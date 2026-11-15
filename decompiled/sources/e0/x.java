package e0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<View> f4603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f4604b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Runnable f4605c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f4606d = -1;

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f4607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4608c;

        a(y yVar, View view) {
            this.f4607b = yVar;
            this.f4608c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4607b.c(this.f4608c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4607b.a(this.f4608c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f4607b.b(this.f4608c);
        }
    }

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a0 f4610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4611c;

        b(a0 a0Var, View view) {
            this.f4610b = a0Var;
            this.f4611c = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4610b.a(this.f4611c);
        }
    }

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    static class c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        x f4613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4614b;

        c(x xVar) {
            this.f4613a = xVar;
        }

        @Override // e0.y
        @SuppressLint({"WrongConstant"})
        public void a(View view) {
            int i3 = this.f4613a.f4606d;
            if (i3 > -1) {
                view.setLayerType(i3, null);
                this.f4613a.f4606d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f4614b) {
                x xVar = this.f4613a;
                Runnable runnable = xVar.f4605c;
                if (runnable != null) {
                    xVar.f4605c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                y yVar = tag instanceof y ? (y) tag : null;
                if (yVar != null) {
                    yVar.a(view);
                }
                this.f4614b = true;
            }
        }

        @Override // e0.y
        public void b(View view) {
            this.f4614b = false;
            if (this.f4613a.f4606d > -1) {
                view.setLayerType(2, null);
            }
            x xVar = this.f4613a;
            Runnable runnable = xVar.f4604b;
            if (runnable != null) {
                xVar.f4604b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            y yVar = tag instanceof y ? (y) tag : null;
            if (yVar != null) {
                yVar.b(view);
            }
        }

        @Override // e0.y
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            y yVar = tag instanceof y ? (y) tag : null;
            if (yVar != null) {
                yVar.c(view);
            }
        }
    }

    x(View view) {
        this.f4603a = new WeakReference<>(view);
    }

    private void g(View view, y yVar) {
        if (yVar != null) {
            view.animate().setListener(new a(yVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public x a(float f3) {
        View view = this.f4603a.get();
        if (view != null) {
            view.animate().alpha(f3);
        }
        return this;
    }

    public void b() {
        View view = this.f4603a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.f4603a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public x d(long j3) {
        View view = this.f4603a.get();
        if (view != null) {
            view.animate().setDuration(j3);
        }
        return this;
    }

    public x e(Interpolator interpolator) {
        View view = this.f4603a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public x f(y yVar) {
        View view = this.f4603a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                g(view, yVar);
            } else {
                view.setTag(2113929216, yVar);
                g(view, new c(this));
            }
        }
        return this;
    }

    public x h(long j3) {
        View view = this.f4603a.get();
        if (view != null) {
            view.animate().setStartDelay(j3);
        }
        return this;
    }

    public x i(a0 a0Var) {
        View view = this.f4603a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(a0Var != null ? new b(a0Var, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.f4603a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public x k(float f3) {
        View view = this.f4603a.get();
        if (view != null) {
            view.animate().translationY(f3);
        }
        return this;
    }
}
