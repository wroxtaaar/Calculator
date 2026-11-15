package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: compiled from: ForwardingListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final View f607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f612j = new int[2];

    /* JADX INFO: compiled from: ForwardingListener.java */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = h0.this.f607e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: ForwardingListener.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h0.this.e();
        }
    }

    public h0(View view) {
        this.f607e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f604b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f605c = tapTimeout;
        this.f606d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f609g;
        if (runnable != null) {
            this.f607e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f608f;
        if (runnable2 != null) {
            this.f607e.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        f0 f0Var;
        View view = this.f607e;
        h.e eVarB = b();
        if (eVarB == null || !eVarB.c() || (f0Var = (f0) eVarB.l()) == null || !f0Var.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(f0Var, motionEventObtainNoHistory);
        boolean zE = f0Var.e(motionEventObtainNoHistory, this.f611i);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f607e;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f611i = motionEvent.getPointerId(0);
            if (this.f608f == null) {
                this.f608f = new a();
            }
            view.postDelayed(this.f608f, this.f605c);
            if (this.f609g == null) {
                this.f609g = new b();
            }
            view.postDelayed(this.f609g, this.f606d);
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f611i);
            if (iFindPointerIndex >= 0 && !h(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f604b)) {
                a();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
            a();
        }
        return false;
    }

    private static boolean h(View view, float f3, float f4, float f5) {
        float f6 = -f5;
        return f3 >= f6 && f4 >= f6 && f3 < ((float) (view.getRight() - view.getLeft())) + f5 && f4 < ((float) (view.getBottom() - view.getTop())) + f5;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f612j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f612j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract h.e b();

    protected abstract boolean c();

    protected boolean d() {
        h.e eVarB = b();
        if (eVarB == null || !eVarB.c()) {
            return true;
        }
        eVarB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f607e;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f610h = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = this.f610h;
        if (z3) {
            z2 = f(motionEvent) || !d();
        } else {
            z2 = g(motionEvent) && c();
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f607e.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f610h = z2;
        return z2 || z3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f610h = false;
        this.f611i = -1;
        Runnable runnable = this.f608f;
        if (runnable != null) {
            this.f607e.removeCallbacks(runnable);
        }
    }
}
