package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: compiled from: TooltipCompatHandler.java */
/* JADX INFO: loaded from: classes.dex */
class z0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static z0 f862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static z0 f863l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f867e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f868f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a1 f871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f872j;

    /* JADX INFO: compiled from: TooltipCompatHandler.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.g(false);
        }
    }

    /* JADX INFO: compiled from: TooltipCompatHandler.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.c();
        }
    }

    private z0(View view, CharSequence charSequence) {
        this.f864b = view;
        this.f865c = charSequence;
        this.f866d = e0.u.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f864b.removeCallbacks(this.f867e);
    }

    private void b() {
        this.f869g = Integer.MAX_VALUE;
        this.f870h = Integer.MAX_VALUE;
    }

    private void d() {
        this.f864b.postDelayed(this.f867e, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(z0 z0Var) {
        z0 z0Var2 = f862k;
        if (z0Var2 != null) {
            z0Var2.a();
        }
        f862k = z0Var;
        if (z0Var != null) {
            z0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        z0 z0Var = f862k;
        if (z0Var != null && z0Var.f864b == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new z0(view, charSequence);
            return;
        }
        z0 z0Var2 = f863l;
        if (z0Var2 != null && z0Var2.f864b == view) {
            z0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x3 = (int) motionEvent.getX();
        int y3 = (int) motionEvent.getY();
        if (Math.abs(x3 - this.f869g) <= this.f866d && Math.abs(y3 - this.f870h) <= this.f866d) {
            return false;
        }
        this.f869g = x3;
        this.f870h = y3;
        return true;
    }

    void c() {
        if (f863l == this) {
            f863l = null;
            a1 a1Var = this.f871i;
            if (a1Var != null) {
                a1Var.c();
                this.f871i = null;
                b();
                this.f864b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f862k == this) {
            e(null);
        }
        this.f864b.removeCallbacks(this.f868f);
    }

    void g(boolean z2) {
        long j3;
        int longPressTimeout;
        long j4;
        if (e0.t.R(this.f864b)) {
            e(null);
            z0 z0Var = f863l;
            if (z0Var != null) {
                z0Var.c();
            }
            f863l = this;
            this.f872j = z2;
            a1 a1Var = new a1(this.f864b.getContext());
            this.f871i = a1Var;
            a1Var.e(this.f864b, this.f869g, this.f870h, this.f872j, this.f865c);
            this.f864b.addOnAttachStateChangeListener(this);
            if (this.f872j) {
                j4 = 2500;
            } else {
                if ((e0.t.K(this.f864b) & 1) == 1) {
                    j3 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j4 = j3 - ((long) longPressTimeout);
            }
            this.f864b.removeCallbacks(this.f868f);
            this.f864b.postDelayed(this.f868f, j4);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f871i != null && this.f872j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f864b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f864b.isEnabled() && this.f871i == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f869g = view.getWidth() / 2;
        this.f870h = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
