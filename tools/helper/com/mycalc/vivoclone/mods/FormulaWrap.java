package com.mycalc.vivoclone.mods;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.WeakHashMap;

/**
 * Keeps a long calculation on screen: it shrinks and then wraps onto up to six lines.
 *
 * The original input box is a single line that scrolls sideways. While the text fits on one line
 * this class does nothing. When it does not, a second TextView (same text, colours and spans) is
 * drawn over the input box and the original is made invisible, so the calculator's own logic and
 * animations are not touched.
 */
final class FormulaWrap {

    private static final int MAX_LINES = 6;
    private static final WeakHashMap<View, Boolean> WATCHED = new WeakHashMap<View, Boolean>();

    private final Activity activity;
    private TextView formula;
    private TextView overlay;
    private boolean hidingFormula;

    FormulaWrap(Activity activity) {
        this.activity = activity;
    }

    private float dp(float value) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, value, activity.getResources().getDisplayMetrics());
    }

    private TextView findFormula() {
        Resources res = activity.getResources();
        int id = res.getIdentifier("formula", "id", activity.getPackageName());
        if (id == 0) {
            id = res.getIdentifier("formula", "id", Boot.ORIGINAL_PACKAGE);
        }
        if (id == 0) {
            return null;
        }
        View v = activity.findViewById(id);
        return v instanceof TextView ? (TextView) v : null;
    }

    void update() {
        TextView found = findFormula();
        if (found == null) {
            return;
        }
        if (found != formula) {
            release();
            formula = found;
        }
        if (!WATCHED.containsKey(formula)) {
            WATCHED.put(formula, Boolean.TRUE);
            formula.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    formula.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                update();
                            } catch (Throwable ignored) {
                            }
                        }
                    });
                }
            });
        }

        int avail = formula.getWidth() - formula.getTotalPaddingLeft() - formula.getTotalPaddingRight();
        if (avail <= 0) {
            return;
        }
        CharSequence text = formula.getText();
        float max = formula.getTextSize();
        TextPaint paint = new TextPaint(formula.getPaint());
        paint.setTextSize(max);
        if (text == null || text.length() == 0 || Layout.getDesiredWidth(text, paint) <= avail) {
            release();
            return;
        }

        CharSequence broken = withBreaks(text);
        float floor = Math.min(max, Math.max(dp(17), max * 0.38f));
        float size = floor;
        // one line at full size, one more line allowed for every step it shrinks, six at the smallest
        for (float s = max; s >= floor; s -= 1f) {
            paint.setTextSize(s);
            int allowed = max > floor ? 1 + (int) ((max - s) / (max - floor) * (MAX_LINES - 1) + 0.0001f) : MAX_LINES;
            if (lineCount(broken, paint, avail) <= allowed) {
                size = s;
                break;
            }
        }

        ensureOverlay();
        overlay.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        overlay.setTextColor(formula.getCurrentTextColor());
        Typeface face = formula.getTypeface();
        if (face != null) {
            overlay.setTypeface(face);
        }
        overlay.setPadding(formula.getTotalPaddingLeft(), 0, formula.getTotalPaddingRight(), 0);
        overlay.setText(broken);
        place();
        if (!hidingFormula || formula.getAlpha() != 0f) {
            formula.setAlpha(0f);
            hidingFormula = true;
        }
    }

    void release() {
        if (overlay != null && overlay.getParent() instanceof ViewGroup) {
            ((ViewGroup) overlay.getParent()).removeView(overlay);
        }
        if (hidingFormula && formula != null) {
            formula.setAlpha(1f);
        }
        hidingFormula = false;
    }

    private void ensureOverlay() {
        if (overlay == null) {
            overlay = new TextView(activity);
            overlay.setGravity(Gravity.END);
            overlay.setBreakStrategy(Layout.BREAK_STRATEGY_SIMPLE);
            overlay.setHyphenationFrequency(Layout.HYPHENATION_FREQUENCY_NONE);
            overlay.setClickable(false);
            overlay.setFocusable(false);
            overlay.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        }
        if (overlay.getParent() == null) {
            ViewGroup content = (ViewGroup) activity.findViewById(android.R.id.content);
            content.addView(overlay, new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.TOP | Gravity.START));
        }
    }

    /** Puts the overlay's last line where the single line used to be, growing upwards. */
    private void place() {
        ViewGroup content = (ViewGroup) activity.findViewById(android.R.id.content);
        int[] f = new int[2];
        int[] c = new int[2];
        formula.getLocationInWindow(f);
        content.getLocationInWindow(c);
        int width = formula.getWidth();
        overlay.measure(
                View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int height = overlay.getMeasuredHeight();
        int bottom = f[1] - c[1] + formula.getHeight() - (int) dp(6);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) overlay.getLayoutParams();
        int left = f[0] - c[0];
        int top = bottom - height;
        if (lp.width != width || lp.leftMargin != left || lp.topMargin != top) {
            lp.width = width;
            lp.leftMargin = left;
            lp.topMargin = top;
            overlay.setLayoutParams(lp);
        }
    }

    private static int lineCount(CharSequence text, TextPaint paint, int width) {
        return StaticLayout.Builder.obtain(text, 0, text.length(), paint, width)
                .setBreakStrategy(Layout.BREAK_STRATEGY_SIMPLE)
                .setHyphenationFrequency(Layout.HYPHENATION_FREQUENCY_NONE)
                .setIncludePad(true)
                .build()
                .getLineCount();
    }

    /** Lets the line break after an operator (the platform will not break inside "5+5"). */
    private static CharSequence withBreaks(CharSequence text) {
        SpannableStringBuilder sb = new SpannableStringBuilder(text);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch == '+' || ch == '-' || ch == '−' || ch == '×' || ch == '÷'
                    || ch == '*' || ch == '/' || ch == 'x') {
                sb.insert(i + 1, "​");
            }
        }
        return sb;
    }
}
