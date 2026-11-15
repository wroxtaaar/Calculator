package com.mycalc.vivoclone.mods;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Small add-on that is compiled separately and added to the rebuilt APK as classes2.dex.
 *
 * It is started by Android itself (it is declared as a ContentProvider in the manifest, so
 * onCreate() runs when the app process starts) and then watches the calculator screen to:
 *   1. show "History . N items" next to the history icon,
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
        final Activity activity;
        private final Handler handler;
        private boolean running;
        private TextView label;
        private int shownCount = -1;

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

            ensureLabel();
            if (label != null) {
                int count = countHistoryRows();
                if (count >= 0 && count != shownCount) {
                    shownCount = count;
                    label.setText("History · " + count + (count == 1 ? " item" : " items"));
                }
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

        private void ensureLabel() {
            if (label != null && label.getParent() != null) {
                return;
            }
            int historyId = idOf("history_toge_button", "id");
            if (historyId == 0) {
                return;
            }
            final View historyButton = activity.findViewById(historyId);
            if (historyButton == null || !(historyButton.getParent() instanceof RelativeLayout)) {
                return;
            }
            RelativeLayout parent = (RelativeLayout) historyButton.getParent();

            TextView text = new TextView(activity);
            text.setId(View.generateViewId());
            text.setGravity(Gravity.CENTER_VERTICAL);
            text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
            text.setSingleLine(true);
            text.setTextColor(greyText());
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    historyButton.performClick();
                }
            });

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.addRule(RelativeLayout.RIGHT_OF, historyId);
            lp.addRule(RelativeLayout.ALIGN_TOP, historyId);
            lp.addRule(RelativeLayout.ALIGN_BOTTOM, historyId);
            // the history icon carries a 30dp end margin that RIGHT_OF respects, so pull back to ~8dp
            lp.leftMargin = (int) -dp(22);
            parent.addView(text, lp);

            label = text;
            shownCount = -1;
        }

        private int greyText() {
            int id = idOf("history_input_edit_color", "color");
            if (id != 0) {
                return activity.getResources().getColor(id, activity.getTheme());
            }
            return 0xFF888888;
        }

        /** Number of saved calculations; -1 when it could not be read right now. */
        private int countHistoryRows() {
            File file = activity.getDatabasePath("history.db3");
            if (!file.exists()) {
                return 0;
            }
            SQLiteDatabase db = null;
            Cursor cursor = null;
            try {
                db = SQLiteDatabase.openDatabase(file.getPath(), null, SQLiteDatabase.OPEN_READONLY);
                cursor = db.rawQuery("select count(*) from history_table", null);
                return cursor.moveToFirst() ? cursor.getInt(0) : 0;
            } catch (Throwable t) {
                String message = String.valueOf(t.getMessage());
                if (message.contains("no such table")) {
                    return 0;
                }
                // busy because the calculator is writing right now: keep what is shown
                return shownCount >= 0 ? -1 : 0;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                if (db != null) {
                    db.close();
                }
            }
        }
    }
}
