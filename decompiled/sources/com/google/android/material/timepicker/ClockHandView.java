package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import e0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t0.j;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ValueAnimator f3392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<d> f3398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f3399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f3400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Paint f3401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final RectF f3402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f3403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f3404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f3405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private c f3406p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private double f3407q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3408r;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f3, boolean z2);
    }

    public interface d {
        void a(float f3, boolean z2);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f3 = width;
        float fCos = (this.f3408r * ((float) Math.cos(this.f3407q))) + f3;
        float f4 = height;
        float fSin = (this.f3408r * ((float) Math.sin(this.f3407q))) + f4;
        this.f3401k.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f3399i, this.f3401k);
        double dSin = Math.sin(this.f3407q);
        double dCos = Math.cos(this.f3407q);
        double d3 = this.f3408r - this.f3399i;
        this.f3401k.setStrokeWidth(this.f3403m);
        canvas.drawLine(f3, f4, width + ((int) (dCos * d3)), height + ((int) (d3 * dSin)), this.f3401k);
        canvas.drawCircle(f3, f4, this.f3400j, this.f3401k);
    }

    private int e(float f3, float f4) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f4 - (getHeight() / 2), f3 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    private Pair<Float, Float> h(float f3) {
        float f4 = f();
        if (Math.abs(f4 - f3) > 180.0f) {
            if (f4 > 180.0f && f3 < 180.0f) {
                f3 += 360.0f;
            }
            if (f4 < 180.0f && f3 > 180.0f) {
                f4 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f4), Float.valueOf(f3));
    }

    private boolean i(float f3, float f4, boolean z2, boolean z3, boolean z4) {
        float fE = e(f3, f4);
        boolean z5 = false;
        boolean z6 = f() != fE;
        if (z3 && z6) {
            return true;
        }
        if (!z6 && !z2) {
            return false;
        }
        if (z4 && this.f3393c) {
            z5 = true;
        }
        l(fE, z5);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(float f3, boolean z2) {
        float f4 = f3 % 360.0f;
        this.f3404n = f4;
        this.f3407q = Math.toRadians(f4 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.f3408r * ((float) Math.cos(this.f3407q)));
        float fSin = height + (this.f3408r * ((float) Math.sin(this.f3407q)));
        RectF rectF = this.f3402l;
        int i3 = this.f3399i;
        rectF.set(width - i3, fSin - i3, width + i3, fSin + i3);
        Iterator<d> it = this.f3398h.iterator();
        while (it.hasNext()) {
            it.next().a(f4, z2);
        }
        invalidate();
    }

    public void b(d dVar) {
        this.f3398h.add(dVar);
    }

    public RectF d() {
        return this.f3402l;
    }

    public float f() {
        return this.f3404n;
    }

    public int g() {
        return this.f3399i;
    }

    public void j(int i3) {
        this.f3408r = i3;
        invalidate();
    }

    public void k(float f3) {
        l(f3, false);
    }

    public void l(float f3, boolean z2) {
        ValueAnimator valueAnimator = this.f3392b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            m(f3, false);
            return;
        }
        Pair<Float, Float> pairH = h(f3);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pairH.first).floatValue(), ((Float) pairH.second).floatValue());
        this.f3392b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f3392b.addUpdateListener(new a());
        this.f3392b.addListener(new b());
        this.f3392b.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        k(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f3394d = x3;
            this.f3395e = y3;
            this.f3396f = true;
            this.f3405o = false;
            z2 = false;
            z3 = false;
            z4 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i3 = (int) (x3 - this.f3394d);
            int i4 = (int) (y3 - this.f3395e);
            this.f3396f = (i3 * i3) + (i4 * i4) > this.f3397g;
            boolean z5 = this.f3405o;
            z2 = actionMasked == 1;
            z4 = false;
            z3 = z5;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
        }
        boolean zI = i(x3, y3, z3, z4, z2) | this.f3405o;
        this.f3405o = zI;
        if (zI && z2 && (cVar = this.f3406p) != null) {
            cVar.a(e(x3, y3), this.f3396f);
        }
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.materialClockStyle);
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3398h = new ArrayList();
        Paint paint = new Paint();
        this.f3401k = paint;
        this.f3402l = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ClockHandView, i3, j.Widget_MaterialComponents_TimePicker_Clock);
        this.f3408r = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.ClockHandView_materialCircleRadius, 0);
        this.f3399i = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f3403m = resources.getDimensionPixelSize(t0.d.material_clock_hand_stroke_width);
        this.f3400j = resources.getDimensionPixelSize(t0.d.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(k.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        k(0.0f);
        this.f3397g = ViewConfiguration.get(context).getScaledTouchSlop();
        t.v0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
