package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.t;

/* JADX INFO: compiled from: HeaderBehavior.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a<V extends View> extends c<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f2556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f2557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VelocityTracker f2562j;

    /* JADX INFO: renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderBehavior.java */
    private class RunnableC0034a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CoordinatorLayout f2563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final V f2564c;

        RunnableC0034a(CoordinatorLayout coordinatorLayout, V v3) {
            this.f2563b = coordinatorLayout;
            this.f2564c = v3;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f2564c == null || (overScroller = a.this.f2557e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.N(this.f2563b, this.f2564c);
                return;
            }
            a aVar = a.this;
            aVar.P(this.f2563b, this.f2564c, aVar.f2557e.getCurrY());
            t.e0(this.f2564c, this);
        }
    }

    public a() {
        this.f2559g = -1;
        this.f2561i = -1;
    }

    private void I() {
        if (this.f2562j == null) {
            this.f2562j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        boolean z2;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f2562j;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f2562j.computeCurrentVelocity(1000);
                J(coordinatorLayout, v3, -L(v3), 0, this.f2562j.getYVelocity(this.f2559g));
                z2 = true;
            }
            this.f2558f = false;
            this.f2559g = -1;
            velocityTracker = this.f2562j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2562j = null;
            }
            velocityTracker2 = this.f2562j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (this.f2558f) {
                return true;
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f2559g);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y3 = (int) motionEvent.getY(iFindPointerIndex);
            int i3 = this.f2560h - y3;
            this.f2560h = y3;
            O(coordinatorLayout, v3, i3, K(v3), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i4 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.f2559g = motionEvent.getPointerId(i4);
                this.f2560h = (int) (motionEvent.getY(i4) + 0.5f);
            }
        }
        z2 = false;
        velocityTracker2 = this.f2562j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.f2558f || z2;
        z2 = false;
        this.f2558f = false;
        this.f2559g = -1;
        velocityTracker = this.f2562j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2562j = null;
        }
        velocityTracker2 = this.f2562j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f2558f) {
            return true;
        }
    }

    boolean H(V v3) {
        return false;
    }

    final boolean J(CoordinatorLayout coordinatorLayout, V v3, int i3, int i4, float f3) {
        Runnable runnable = this.f2556d;
        if (runnable != null) {
            v3.removeCallbacks(runnable);
            this.f2556d = null;
        }
        if (this.f2557e == null) {
            this.f2557e = new OverScroller(v3.getContext());
        }
        this.f2557e.fling(0, E(), 0, Math.round(f3), 0, 0, i3, i4);
        if (!this.f2557e.computeScrollOffset()) {
            N(coordinatorLayout, v3);
            return false;
        }
        RunnableC0034a runnableC0034a = new RunnableC0034a(coordinatorLayout, v3);
        this.f2556d = runnableC0034a;
        t.e0(v3, runnableC0034a);
        return true;
    }

    int K(V v3) {
        return -v3.getHeight();
    }

    int L(V v3) {
        return v3.getHeight();
    }

    int M() {
        return E();
    }

    void N(CoordinatorLayout coordinatorLayout, V v3) {
    }

    final int O(CoordinatorLayout coordinatorLayout, V v3, int i3, int i4, int i5) {
        return Q(coordinatorLayout, v3, M() - i3, i4, i5);
    }

    int P(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        return Q(coordinatorLayout, v3, i3, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int Q(CoordinatorLayout coordinatorLayout, V v3, int i3, int i4, int i5) {
        int iB;
        int iE = E();
        if (i4 == 0 || iE < i4 || iE > i5 || iE == (iB = z.a.b(i3, i4, i5))) {
            return 0;
        }
        G(iB);
        return iE - iB;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f2561i < 0) {
            this.f2561i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2558f) {
            int i3 = this.f2559g;
            if (i3 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y3 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y3 - this.f2560h) > this.f2561i) {
                this.f2560h = y3;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2559g = -1;
            int x3 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            boolean z2 = H(v3) && coordinatorLayout.B(v3, x3, y4);
            this.f2558f = z2;
            if (z2) {
                this.f2560h = y4;
                this.f2559g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f2557e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2557e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2562j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2559g = -1;
        this.f2561i = -1;
    }
}
