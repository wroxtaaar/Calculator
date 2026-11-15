package com.vos.swipemenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import e0.t;
import java.util.Locale;
import u2.d;
import y1.h;

/* JADX INFO: loaded from: classes.dex */
public class SwipeMenuLayout extends FrameLayout implements d {
    private static final String A = SwipeMenuLayout.class.getSimpleName();
    private static w2.c B = new w2.c(20.0d, 8.0d);
    public static boolean C = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w2.b f4332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f4333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f4339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f4340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f4344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f4346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f4347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.vos.swipemenu.b f4348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private c f4349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.vos.swipemenu.a f4350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4351u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f4352v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private OverScroller f4353w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private VelocityTracker f4354x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4355y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f4356z;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f4357b;

        a(long j3) {
            this.f4357b = j3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwipeMenuLayout.this.f4334d = true;
            SwipeMenuLayout.this.f4332b.a(SystemClock.uptimeMillis() - this.f4357b);
            SwipeMenuLayout.this.scrollTo((int) SwipeMenuLayout.this.f4332b.b(), 0);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeMenuLayout.this.f4334d = false;
            SwipeMenuLayout swipeMenuLayout = SwipeMenuLayout.this;
            swipeMenuLayout.scrollTo((int) swipeMenuLayout.f4332b.d(), 0);
        }
    }

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    private int e(MotionEvent motionEvent, int i3) {
        int x3 = (int) (motionEvent.getX() - getScrollX());
        int iF = this.f4350t.f();
        int i4 = iF / 2;
        float f3 = iF;
        float f4 = i4;
        return Math.min(i3 > 0 ? Math.round(Math.abs((f4 + (d(Math.min(1.0f, (Math.abs(x3) * 1.0f) / f3)) * f4)) / i3) * 1000.0f) * 4 : (int) (((Math.abs(x3) / f3) + 1.0f) * 100.0f), this.f4341k);
    }

    public static boolean h() {
        byte directionality = Character.getDirectionality(Locale.getDefault().getDisplayName().charAt(0));
        return directionality == 1 || directionality == 2;
    }

    public static boolean j() {
        return C;
    }

    private void k(int i3, int i4) {
        if (this.f4350t != null) {
            if (Math.abs(getScrollX()) >= this.f4350t.e().getWidth() * this.f4340j) {
                n();
            } else {
                l();
            }
        }
    }

    private void o(int i3) {
        com.vos.swipemenu.a aVar = this.f4350t;
        if (aVar != null) {
            aVar.b(this.f4353w, getScrollX(), i3);
            invalidate();
        }
    }

    @Override // u2.c
    public boolean a() {
        return g() || i();
    }

    @Override // android.view.View
    public void computeScroll() {
        com.vos.swipemenu.a aVar;
        if (this.f4353w.computeScrollOffset() && (aVar = this.f4350t) != null) {
            if (aVar instanceof c) {
                scrollTo(Math.abs(this.f4353w.getCurrX()), 0);
                invalidate();
            } else {
                scrollTo(-Math.abs(this.f4353w.getCurrX()), 0);
                invalidate();
            }
        }
        if (h()) {
            if (this.f4339i == null || getScrollX() >= 0) {
                return;
            }
            this.f4339i.setTranslationX(getScrollX());
            return;
        }
        if (this.f4339i == null || getScrollX() <= 0) {
            return;
        }
        this.f4339i.setTranslationX(getScrollX());
    }

    float d(float f3) {
        return (float) Math.sin((float) (((double) (f3 - 0.5f)) * 0.4712389167638204d));
    }

    public float f(int i3, int i4) {
        float f3;
        float f4;
        if (i3 == 0) {
            f3 = i4;
            f4 = 0.19999999f;
        } else if (i3 == 1) {
            f3 = i4;
            f4 = 0.5375f;
        } else {
            if (i3 != 2) {
                return 0.0f;
            }
            f3 = i4;
            f4 = 0.875f;
        }
        return f3 * f4;
    }

    public boolean g() {
        com.vos.swipemenu.b bVar = this.f4348r;
        return bVar != null && bVar.j(getScrollX());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public float getOpenPercent() {
        return this.f4340j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public boolean i() {
        c cVar = this.f4349s;
        return cVar != null && cVar.j(getScrollX());
    }

    public void l() {
        m(this.f4341k);
    }

    public void m(int i3) {
        com.vos.swipemenu.a aVar = this.f4350t;
        if (aVar != null) {
            aVar.a(this.f4353w, getScrollX(), i3);
            invalidate();
        }
    }

    public void n() {
        o(this.f4341k);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f4336f;
        if (i3 != 0 && this.f4348r == null) {
            this.f4348r = new com.vos.swipemenu.b(findViewById(i3));
        }
        int i4 = this.f4338h;
        if (i4 != 0 && this.f4349s == null) {
            this.f4349s = new c(findViewById(i4));
        }
        int i5 = this.f4337g;
        if (i5 != 0 && this.f4347q == null) {
            this.f4347q = findViewById(i5);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setClickable(true);
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setText("You may not have set the ContentView.");
        this.f4347q = textView;
        addView(textView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            int x3 = (int) motionEvent.getX();
            this.f4343m = x3;
            this.f4345o = x3;
            this.f4346p = (int) motionEvent.getY();
            return false;
        }
        if (action != 1) {
            if (action == 2) {
                int x4 = (int) (motionEvent.getX() - this.f4345o);
                return Math.abs(x4) > this.f4342l && Math.abs(x4) > Math.abs((int) (motionEvent.getY() - ((float) this.f4346p)));
            }
            if (action != 3) {
                return zOnInterceptTouchEvent;
            }
        }
        com.vos.swipemenu.a aVar = this.f4350t;
        boolean z2 = aVar != null && aVar.g(getWidth(), motionEvent.getX());
        if (!a() || !z2) {
            return false;
        }
        l();
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        View view = this.f4347q;
        if (view != null) {
            int measuredWidthAndState = view.getMeasuredWidthAndState();
            int measuredHeightAndState = this.f4347q.getMeasuredHeightAndState();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4347q.getLayoutParams();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + layoutParams.topMargin;
            this.f4347q.layout(paddingLeft, paddingTop, measuredWidthAndState + paddingLeft, measuredHeightAndState + paddingTop);
        }
        com.vos.swipemenu.b bVar = this.f4348r;
        if (bVar != null) {
            View viewE = bVar.e();
            int measuredWidthAndState2 = viewE.getMeasuredWidthAndState();
            int measuredHeightAndState2 = viewE.getMeasuredHeightAndState();
            int paddingTop2 = getPaddingTop() + ((FrameLayout.LayoutParams) viewE.getLayoutParams()).topMargin;
            viewE.layout(-measuredWidthAndState2, paddingTop2, 0, measuredHeightAndState2 + paddingTop2);
        }
        c cVar = this.f4349s;
        if (cVar != null) {
            View viewE2 = cVar.e();
            int measuredWidthAndState3 = viewE2.getMeasuredWidthAndState();
            int measuredHeightAndState3 = viewE2.getMeasuredHeightAndState();
            int paddingTop3 = getPaddingTop() + ((FrameLayout.LayoutParams) viewE2.getLayoutParams()).topMargin;
            int measuredWidthAndState4 = getMeasuredWidthAndState();
            viewE2.layout(measuredWidthAndState4, paddingTop3, measuredWidthAndState3 + measuredWidthAndState4, measuredHeightAndState3 + paddingTop3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4354x == null) {
            this.f4354x = VelocityTracker.obtain();
        }
        this.f4354x.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (!j()) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.f4334d) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4335e = getLayoutDirection() == 1 ? -1 : 1;
        if (action == 0) {
            this.f4343m = (int) motionEvent.getX();
            this.f4344n = (int) motionEvent.getY();
        } else if (action == 1) {
            int x3 = (int) (this.f4345o - motionEvent.getX());
            int y3 = (int) (this.f4346p - motionEvent.getY());
            this.f4352v = false;
            this.f4354x.computeCurrentVelocity(1000);
            int xVelocity = (int) this.f4354x.getXVelocity();
            int iAbs = Math.abs(xVelocity);
            if (iAbs <= this.f4355y) {
                k(x3, y3);
            } else if (this.f4350t != null) {
                int iE = e(motionEvent, iAbs);
                if (this.f4350t instanceof c) {
                    if (xVelocity < 0) {
                        p(xVelocity);
                    } else {
                        m(iE);
                    }
                } else if (xVelocity > 0) {
                    p(xVelocity);
                } else {
                    m(iE);
                }
                t.d0(this);
            }
            this.f4354x.clear();
            this.f4354x.recycle();
            this.f4354x = null;
            if (Math.abs(this.f4345o - motionEvent.getX()) > this.f4342l || Math.abs(this.f4346p - motionEvent.getY()) > this.f4342l || g() || i()) {
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
        } else if (action != 2) {
            if (action == 3) {
                this.f4352v = false;
                k((int) (this.f4345o - motionEvent.getX()), (int) (this.f4346p - motionEvent.getY()));
            }
        } else if (j()) {
            int x4 = (int) (this.f4343m - motionEvent.getX());
            int y4 = (int) (this.f4344n - motionEvent.getY());
            if (!this.f4352v && Math.abs(x4) > this.f4342l && Math.abs(x4) > Math.abs(y4)) {
                this.f4352v = true;
            }
            if (this.f4352v) {
                if (this.f4350t == null || this.f4351u) {
                    if (this.f4335e == 1) {
                        this.f4350t = this.f4349s;
                    } else {
                        this.f4350t = this.f4348r;
                    }
                }
                if (a()) {
                    scrollBy(((int) Math.pow(Math.abs((int) (x4 / 1.5f)), 0.5d)) * (x4 > 0 ? 1 : -1), 0);
                } else {
                    if (this.f4345o - motionEvent.getX() > this.f4350t.f()) {
                        x4 = (int) (((this.f4345o - motionEvent.getX()) - this.f4350t.f()) / 2.0f);
                    }
                    scrollBy(x4, 0);
                    this.f4350t.i();
                }
                this.f4343m = (int) motionEvent.getX();
                this.f4344n = (int) motionEvent.getY();
                this.f4351u = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(float f3) {
        float scrollX = getScrollX();
        float f4 = this.f4350t.f() * this.f4335e;
        Log.d(A, "pos:" + scrollX + "   iconsWidth:" + f4);
        this.f4332b.i((double) scrollX);
        this.f4332b.k((double) f4);
        this.f4332b.l(B);
        this.f4332b.m(((double) (-Math.max(f3, -this.f4333c))) * 0.4d);
        long jUptimeMillis = SystemClock.uptimeMillis();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(scrollX, f4);
        valueAnimatorOfFloat.addUpdateListener(new a(jUptimeMillis));
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.start();
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        com.vos.swipemenu.a aVar = this.f4350t;
        if (aVar == null) {
            super.scrollTo(i3, i4);
            return;
        }
        com.vos.swipemenu.a.C0051a c0051aC = aVar.c(i3, i4);
        this.f4351u = c0051aC.f4371c;
        if (c0051aC.f4369a != getScrollX()) {
            super.scrollTo(c0051aC.f4369a, c0051aC.f4370b);
        }
        int iF = this.f4350t.f();
        if (a()) {
            int iAbs = iF - Math.abs(getScrollX());
            this.f4350t.h((-this.f4335e) * f(0, iAbs), (-this.f4335e) * f(1, iAbs), (-this.f4335e) * f(2, iAbs));
        }
        invalidate();
    }

    public void setDivider(int i3) {
        this.f4339i = findViewById(i3);
    }

    public void setOpenPercent(float f3) {
        this.f4340j = f3;
    }

    public void setScrollerDuration(int i3) {
        this.f4341k = i3;
    }

    public void setSwipeEnable(boolean z2) {
        C = z2;
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4334d = false;
        this.f4335e = 1;
        this.f4336f = 0;
        this.f4337g = 0;
        this.f4338h = 0;
        this.f4340j = 0.5f;
        this.f4341k = 300;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.SwipeMenuLayout);
        this.f4336f = typedArrayObtainStyledAttributes.getResourceId(h.SwipeMenuLayout_leftViewId, this.f4336f);
        this.f4337g = typedArrayObtainStyledAttributes.getResourceId(h.SwipeMenuLayout_contentViewId, this.f4337g);
        this.f4338h = typedArrayObtainStyledAttributes.getResourceId(h.SwipeMenuLayout_rightViewId, this.f4338h);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f4342l = viewConfiguration.getScaledTouchSlop();
        this.f4355y = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4356z = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4353w = new OverScroller(getContext(), new v2.b());
        this.f4332b = new w2.b();
        this.f4333c = getResources().getDisplayMetrics().density * 1000.0f;
    }
}
