package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import e0.t;

/* JADX INFO: compiled from: FastScroller.java */
/* JADX INFO: loaded from: classes.dex */
class d extends RecyclerView.n implements RecyclerView.s {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final StateListDrawable f2015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Drawable f2016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StateListDrawable f2019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Drawable f2020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f2021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f2022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f2023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f2025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f2026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f2027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f2028p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RecyclerView f2031s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final ValueAnimator f2038z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2029q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2030r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f2032t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2033u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f2034v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f2035w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int[] f2036x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int[] f2037y = new int[2];

    /* JADX INFO: compiled from: FastScroller.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(500);
        }
    }

    /* JADX INFO: compiled from: FastScroller.java */
    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i3, int i4) {
            d.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* JADX INFO: compiled from: FastScroller.java */
    private class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2041b = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2041b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2041b) {
                this.f2041b = false;
                return;
            }
            if (((Float) d.this.f2038z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.y(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.v();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FastScroller.java */
    private class C0021d implements ValueAnimator.AnimatorUpdateListener {
        C0021d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f2015c.setAlpha(iFloatValue);
            d.this.f2016d.setAlpha(iFloatValue);
            d.this.v();
        }
    }

    d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i3, int i4, int i5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2038z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f2015c = stateListDrawable;
        this.f2016d = drawable;
        this.f2019g = stateListDrawable2;
        this.f2020h = drawable2;
        this.f2017e = Math.max(i3, stateListDrawable.getIntrinsicWidth());
        this.f2018f = Math.max(i3, drawable.getIntrinsicWidth());
        this.f2021i = Math.max(i3, stateListDrawable2.getIntrinsicWidth());
        this.f2022j = Math.max(i3, drawable2.getIntrinsicWidth());
        this.f2013a = i4;
        this.f2014b = i5;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new C0021d());
        j(recyclerView);
    }

    private void C(float f3) {
        int[] iArrP = p();
        float fMax = Math.max(iArrP[0], Math.min(iArrP[1], f3));
        if (Math.abs(this.f2024l - fMax) < 2.0f) {
            return;
        }
        int iX = x(this.f2025m, fMax, iArrP, this.f2031s.computeVerticalScrollRange(), this.f2031s.computeVerticalScrollOffset(), this.f2030r);
        if (iX != 0) {
            this.f2031s.scrollBy(0, iX);
        }
        this.f2025m = fMax;
    }

    private void k() {
        this.f2031s.removeCallbacks(this.B);
    }

    private void l() {
        this.f2031s.X0(this);
        this.f2031s.Y0(this);
        this.f2031s.Z0(this.C);
        k();
    }

    private void m(Canvas canvas) {
        int i3 = this.f2030r;
        int i4 = this.f2021i;
        int i5 = i3 - i4;
        int i6 = this.f2027o;
        int i7 = this.f2026n;
        int i8 = i6 - (i7 / 2);
        this.f2019g.setBounds(0, 0, i7, i4);
        this.f2020h.setBounds(0, 0, this.f2029q, this.f2022j);
        canvas.translate(0.0f, i5);
        this.f2020h.draw(canvas);
        canvas.translate(i8, 0.0f);
        this.f2019g.draw(canvas);
        canvas.translate(-i8, -i5);
    }

    private void n(Canvas canvas) {
        int i3 = this.f2029q;
        int i4 = this.f2017e;
        int i5 = i3 - i4;
        int i6 = this.f2024l;
        int i7 = this.f2023k;
        int i8 = i6 - (i7 / 2);
        this.f2015c.setBounds(0, 0, i4, i7);
        this.f2016d.setBounds(0, 0, this.f2018f, this.f2030r);
        if (!s()) {
            canvas.translate(i5, 0.0f);
            this.f2016d.draw(canvas);
            canvas.translate(0.0f, i8);
            this.f2015c.draw(canvas);
            canvas.translate(-i5, -i8);
            return;
        }
        this.f2016d.draw(canvas);
        canvas.translate(this.f2017e, i8);
        canvas.scale(-1.0f, 1.0f);
        this.f2015c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f2017e, -i8);
    }

    private int[] o() {
        int[] iArr = this.f2037y;
        int i3 = this.f2014b;
        iArr[0] = i3;
        iArr[1] = this.f2029q - i3;
        return iArr;
    }

    private int[] p() {
        int[] iArr = this.f2036x;
        int i3 = this.f2014b;
        iArr[0] = i3;
        iArr[1] = this.f2030r - i3;
        return iArr;
    }

    private void r(float f3) {
        int[] iArrO = o();
        float fMax = Math.max(iArrO[0], Math.min(iArrO[1], f3));
        if (Math.abs(this.f2027o - fMax) < 2.0f) {
            return;
        }
        int iX = x(this.f2028p, fMax, iArrO, this.f2031s.computeHorizontalScrollRange(), this.f2031s.computeHorizontalScrollOffset(), this.f2029q);
        if (iX != 0) {
            this.f2031s.scrollBy(iX, 0);
        }
        this.f2028p = fMax;
    }

    private boolean s() {
        return t.B(this.f2031s) == 1;
    }

    private void w(int i3) {
        k();
        this.f2031s.postDelayed(this.B, i3);
    }

    private int x(float f3, float f4, int[] iArr, int i3, int i4, int i5) {
        int i6 = iArr[1] - iArr[0];
        if (i6 == 0) {
            return 0;
        }
        int i7 = i3 - i5;
        int i8 = (int) (((f4 - f3) / i6) * i7);
        int i9 = i4 + i8;
        if (i9 >= i7 || i9 < 0) {
            return 0;
        }
        return i8;
    }

    private void z() {
        this.f2031s.h(this);
        this.f2031s.j(this);
        this.f2031s.k(this.C);
    }

    public void A() {
        int i3 = this.A;
        if (i3 != 0) {
            if (i3 != 3) {
                return;
            } else {
                this.f2038z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f2038z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f2038z.setDuration(500L);
        this.f2038z.setStartDelay(0L);
        this.f2038z.start();
    }

    void B(int i3, int i4) {
        int iComputeVerticalScrollRange = this.f2031s.computeVerticalScrollRange();
        int i5 = this.f2030r;
        this.f2032t = iComputeVerticalScrollRange - i5 > 0 && i5 >= this.f2013a;
        int iComputeHorizontalScrollRange = this.f2031s.computeHorizontalScrollRange();
        int i6 = this.f2029q;
        boolean z2 = iComputeHorizontalScrollRange - i6 > 0 && i6 >= this.f2013a;
        this.f2033u = z2;
        boolean z3 = this.f2032t;
        if (!z3 && !z2) {
            if (this.f2034v != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z3) {
            float f3 = i5;
            this.f2024l = (int) ((f3 * (i4 + (f3 / 2.0f))) / iComputeVerticalScrollRange);
            this.f2023k = Math.min(i5, (i5 * i5) / iComputeVerticalScrollRange);
        }
        if (this.f2033u) {
            float f4 = i6;
            this.f2027o = (int) ((f4 * (i3 + (f4 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f2026n = Math.min(i6, (i6 * i6) / iComputeHorizontalScrollRange);
        }
        int i7 = this.f2034v;
        if (i7 == 0 || i7 == 1) {
            y(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i3 = this.f2034v;
        if (i3 == 1) {
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zU && !zT) {
                return false;
            }
            if (zT) {
                this.f2035w = 1;
                this.f2028p = (int) motionEvent.getX();
            } else if (zU) {
                this.f2035w = 2;
                this.f2025m = (int) motionEvent.getY();
            }
            y(2);
        } else if (i3 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f2034v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            if (zU || zT) {
                if (zT) {
                    this.f2035w = 1;
                    this.f2028p = (int) motionEvent.getX();
                } else if (zU) {
                    this.f2035w = 2;
                    this.f2025m = (int) motionEvent.getY();
                }
                y(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f2034v == 2) {
            this.f2025m = 0.0f;
            this.f2028p = 0.0f;
            y(1);
            this.f2035w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f2034v == 2) {
            A();
            if (this.f2035w == 1) {
                r(motionEvent.getX());
            }
            if (this.f2035w == 2) {
                C(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.f2029q != this.f2031s.getWidth() || this.f2030r != this.f2031s.getHeight()) {
            this.f2029q = this.f2031s.getWidth();
            this.f2030r = this.f2031s.getHeight();
            y(0);
        } else if (this.A != 0) {
            if (this.f2032t) {
                n(canvas);
            }
            if (this.f2033u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2031s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.f2031s = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    void q(int i3) {
        int i4 = this.A;
        if (i4 == 1) {
            this.f2038z.cancel();
        } else if (i4 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f2038z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f2038z.setDuration(i3);
        this.f2038z.start();
    }

    boolean t(float f3, float f4) {
        if (f4 >= this.f2030r - this.f2021i) {
            int i3 = this.f2027o;
            int i4 = this.f2026n;
            if (f3 >= i3 - (i4 / 2) && f3 <= i3 + (i4 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean u(float f3, float f4) {
        if (!s() ? f3 >= this.f2029q - this.f2017e : f3 <= this.f2017e / 2) {
            int i3 = this.f2024l;
            int i4 = this.f2023k;
            if (f4 >= i3 - (i4 / 2) && f4 <= i3 + (i4 / 2)) {
                return true;
            }
        }
        return false;
    }

    void v() {
        this.f2031s.invalidate();
    }

    void y(int i3) {
        if (i3 == 2 && this.f2034v != 2) {
            this.f2015c.setState(D);
            k();
        }
        if (i3 == 0) {
            v();
        } else {
            A();
        }
        if (this.f2034v == 2 && i3 != 2) {
            this.f2015c.setState(E);
            w(1200);
        } else if (i3 == 1) {
            w(1500);
        }
        this.f2034v = i3;
    }
}
