package com.google.android.material.timepicker;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.vivo.seckeysdk.BuildConfig;
import e0.t;
import f0.d;
import java.util.Arrays;
import t0.f;
import t0.h;
import t0.j;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends com.google.android.material.timepicker.b implements ClockHandView.d {
    private final ClockHandView B;
    private final Rect C;
    private final RectF D;
    private final SparseArray<TextView> E;
    private final e0.a F;
    private final int[] G;
    private final float[] H;
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private String[] M;
    private float N;
    private final ColorStateList O;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.v(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.B.g()) - ClockFaceView.this.I);
            return true;
        }
    }

    class b extends e0.a {
        b() {
        }

        @Override // e0.a
        public void g(View view, d dVar) {
            super.g(view, dVar);
            int iIntValue = ((Integer) view.getTag(f.material_value_index)).intValue();
            if (iIntValue > 0) {
                dVar.u0((View) ClockFaceView.this.E.get(iIntValue - 1));
            }
            dVar.a0(d.c.f(0, 1, iIntValue, 1, false, view.isSelected()));
            dVar.Y(true);
            dVar.b(d.a.f4646i);
        }

        @Override // e0.a
        public boolean j(View view, int i3, Bundle bundle) {
            if (i3 != 16) {
                return super.j(view, i3, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            float x3 = view.getX() + (view.getWidth() / 2.0f);
            float height = (view.getHeight() / 2.0f) + view.getY();
            ClockFaceView.this.B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, x3, height, 0));
            ClockFaceView.this.B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, x3, height, 0));
            return true;
        }
    }

    public ClockFaceView(Context context) {
        this(context, null);
    }

    private void C() {
        RectF rectFD = this.B.d();
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            TextView textView = this.E.get(i3);
            if (textView != null) {
                textView.getDrawingRect(this.C);
                offsetDescendantRectToMyCoords(textView, this.C);
                textView.setSelected(rectFD.contains(this.C.centerX(), this.C.centerY()));
                textView.getPaint().setShader(D(rectFD, this.C, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient D(RectF rectF, Rect rect, TextView textView) {
        this.D.set(rect);
        this.D.offset(textView.getPaddingLeft(), textView.getPaddingTop());
        if (RectF.intersects(rectF, this.D)) {
            return new RadialGradient(rectF.centerX() - this.D.left, rectF.centerY() - this.D.top, rectF.width() * 0.5f, this.G, this.H, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static float E(float f3, float f4, float f5) {
        return Math.max(Math.max(f3, f4), f5);
    }

    private void G(int i3) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.E.size();
        for (int i4 = 0; i4 < Math.max(this.M.length, size); i4++) {
            TextView textView = this.E.get(i4);
            if (i4 >= this.M.length) {
                removeView(textView);
                this.E.remove(i4);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(h.material_clockface_textview, (ViewGroup) this, false);
                    this.E.put(i4, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.M[i4]);
                textView.setTag(f.material_value_index, Integer.valueOf(i4));
                t.m0(textView, this.F);
                textView.setTextColor(this.O);
                if (i3 != 0) {
                    textView.setContentDescription(getResources().getString(i3, this.M[i4]));
                }
            }
        }
    }

    public void F(String[] strArr, int i3) {
        this.M = strArr;
        G(i3);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void a(float f3, boolean z2) {
        if (Math.abs(this.N - f3) > 0.001f) {
            this.N = f3;
            C();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        d.x0(accessibilityNodeInfo).Z(d.b.a(1, this.M.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        C();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iE = (int) (this.L / E(this.J / displayMetrics.heightPixels, this.K / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iE, 1073741824);
        setMeasuredDimension(iE, iE);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.b
    public void v(int i3) {
        if (i3 != u()) {
            super.v(i3);
            this.B.j(u());
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new Rect();
        this.D = new RectF();
        this.E = new SparseArray<>();
        this.H = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ClockFaceView, i3, j.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = h1.c.a(context, typedArrayObtainStyledAttributes, k.ClockFaceView_clockNumberTextColor);
        this.O = colorStateListA;
        LayoutInflater.from(context).inflate(h.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(f.material_clock_hand);
        this.B = clockHandView;
        this.I = resources.getDimensionPixelSize(t0.d.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.G = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = c.a.c(context, t0.c.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = h1.c.a(context, typedArrayObtainStyledAttributes, k.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.F = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, BuildConfig.FLAVOR);
        F(strArr, 0);
        this.J = resources.getDimensionPixelSize(t0.d.material_time_picker_minimum_screen_height);
        this.K = resources.getDimensionPixelSize(t0.d.material_time_picker_minimum_screen_width);
        this.L = resources.getDimensionPixelSize(t0.d.material_clock_size);
    }
}
