package com.mycalc.vivoclone.mods;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Small add-on that is compiled separately and added to the rebuilt APK as classes2.dex.
 *
 * It is started by Android itself (it is declared as a ContentProvider in the manifest, so
 * onCreate() runs when the app process starts) and then watches the calculator screen to:
 *   1. show, under every history entry, how many numbers that calculation used,
 *   2. keep the scientific-mode and exchange-rate buttons hidden,
 *   3. keep the screen in portrait (scientific mode is what landscape switches to).
 *
 * It only touches the original app through view ids, the history database file and
 * framework APIs, so no original code has to be edited.
 */
public class Boot extends ContentProvider {

    static final String CALCULATOR_ACTIVITY = "com.vivo.calculator.Calculator";
    static final String ORIGINAL_PACKAGE = "com.vivo.calculator";

    @Override
    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            Context app = context.getApplicationContext();
            if (app instanceof Application) {
                ((Application) app).registerActivityLifecycleCallbacks(new Watcher());
            }
        }
        return true;
    }

    // A ContentProvider has to implement these, but this one serves no data.
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    /** Starts a Ticker while the calculator screen is in front. */
    static final class Watcher implements Application.ActivityLifecycleCallbacks {
        private final Handler handler = new Handler(Looper.getMainLooper());
        private Ticker ticker;

        @Override
        public void onActivityResumed(Activity activity) {
            if (!CALCULATOR_ACTIVITY.equals(activity.getClass().getName())) {
                return;
            }
            if (ticker != null) {
                ticker.stop();
            }
            ticker = new Ticker(activity, handler);
            ticker.start();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            if (ticker != null && ticker.activity == activity) {
                ticker.stop();
                ticker = null;
            }
        }

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
        }
    }

    /** Runs a few times a second while the calculator is visible. */
    static final class Ticker implements Runnable {
        static final String COUNT_TAG = "mods_number_count";
        // 33+45-78+68 -> 4 numbers; "1,000.5" and "2.5E3" each count as one number
        static final Pattern NUMBER = Pattern.compile("\\p{Nd}+(?:[.,\u066B\u066C]\\p{Nd}+)*(?:E[+-]?\\p{Nd}+)?");

        final Activity activity;
        private final Handler handler;
        private boolean running;

        Ticker(Activity activity, Handler handler) {
            this.activity = activity;
            this.handler = handler;
        }

        void start() {
            running = true;
            handler.post(this);
        }

        void stop() {
            running = false;
            handler.removeCallbacks(this);
        }

        @Override
        public void run() {
            if (!running) {
                return;
            }
            try {
                tick();
            } catch (Throwable ignored) {
                // never let the add-on take the calculator down
            }
            handler.postDelayed(this, 400);
        }

        private void tick() {
            hide("calculator_mode_toge_button");
            hide("exchange_toge_button");

            if (activity.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

            int processId = idOf("calculator_process", "id");
            if (processId != 0) {
                labelRows(activity.getWindow().getDecorView(), processId);
            }
        }

        private int idOf(String name, String type) {
            Resources res = activity.getResources();
            int id = res.getIdentifier(name, type, activity.getPackageName());
            if (id == 0) {
                id = res.getIdentifier(name, type, ORIGINAL_PACKAGE);
            }
            return id;
        }

        private void hide(String idName) {
            int id = idOf(idName, "id");
            if (id == 0) {
                return;
            }
            View view = activity.findViewById(id);
            if (view != null && view.getVisibility() != View.GONE) {
                view.setVisibility(View.GONE);
            }
        }

        private float dp(float value) {
            return TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, value, activity.getResources().getDisplayMetrics());
        }

        /** Finds every history row (a view with the expression id inside a list) and labels it. */
        private void labelRows(View view, int processId) {
            if (view instanceof TextView && view.getId() == processId
                    && view.getParent() instanceof LinearLayout) {
                labelRow((TextView) view, (LinearLayout) view.getParent());
                return;
            }
            if (view instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) view;
                for (int i = 0; i < group.getChildCount(); i++) {
                    labelRows(group.getChildAt(i), processId);
                }
            }
        }

        private void labelRow(TextView expression, LinearLayout row) {
            TextView count = null;
            for (int i = 0; i < row.getChildCount(); i++) {
                View child = row.getChildAt(i);
                if (COUNT_TAG.equals(child.getTag())) {
                    count = (TextView) child;
                    break;
                }
            }
            if (count == null) {
                count = new TextView(activity);
                count.setTag(COUNT_TAG);
                count.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                count.setSingleLine(true);
                count.setTextColor(expression.getCurrentTextColor());
                count.setAlpha(0.65f);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.topMargin = (int) dp(3);
                row.addView(count, row.indexOfChild(expression) + 1, lp);
            }
            // rows are recycled by the list, so always recompute from what the row shows now
            int n = countNumbers(String.valueOf(expression.getText()));
            if (n == 0) {
                count.setVisibility(View.GONE);
                return;
            }
            String text = n + (n == 1 ? " number" : " numbers");
            if (count.getVisibility() != View.VISIBLE) {
                count.setVisibility(View.VISIBLE);
            }
            if (!text.contentEquals(count.getText())) {
                count.setText(text);
            }
            count.setTextColor(expression.getCurrentTextColor());
        }

        static int countNumbers(String expression) {
            int n = 0;
            Matcher m = NUMBER.matcher(expression);
            while (m.find()) {
                n++;
            }
            return n;
        }
    }
}
