package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: FragmentAnim.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: compiled from: FragmentAnim.java */
    static class a implements a0.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f1315a;

        a(Fragment fragment) {
            this.f1315a = fragment;
        }

        @Override // a0.b.a
        public void a() {
            if (this.f1315a.q() != null) {
                View viewQ = this.f1315a.q();
                this.f1315a.k1(null);
                viewQ.clearAnimation();
            }
            this.f1315a.l1(null);
        }
    }

    /* JADX INFO: compiled from: FragmentAnim.java */
    static class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f1317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ t.g f1318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a0.b f1319d;

        /* JADX INFO: compiled from: FragmentAnim.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f1317b.q() != null) {
                    b.this.f1317b.k1(null);
                    b bVar = b.this;
                    bVar.f1318c.a(bVar.f1317b, bVar.f1319d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, t.g gVar, a0.b bVar) {
            this.f1316a = viewGroup;
            this.f1317b = fragment;
            this.f1318c = gVar;
            this.f1319d = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1316a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: FragmentAnim.java */
    static class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Fragment f1323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ t.g f1324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0.b f1325f;

        c(ViewGroup viewGroup, View view, Fragment fragment, t.g gVar, a0.b bVar) {
            this.f1321b = viewGroup;
            this.f1322c = view;
            this.f1323d = fragment;
            this.f1324e = gVar;
            this.f1325f = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1321b.endViewTransition(this.f1322c);
            Animator animatorR = this.f1323d.r();
            this.f1323d.l1(null);
            if (animatorR == null || this.f1321b.indexOfChild(this.f1322c) >= 0) {
                return;
            }
            this.f1324e.a(this.f1323d, this.f1325f);
        }
    }

    static void a(Fragment fragment, d dVar, t.g gVar) {
        View view = fragment.H;
        ViewGroup viewGroup = fragment.G;
        viewGroup.startViewTransition(view);
        a0.b bVar = new a0.b();
        bVar.c(new a(fragment));
        gVar.b(fragment, bVar);
        if (dVar.f1326a != null) {
            RunnableC0008e runnableC0008e = new RunnableC0008e(dVar.f1326a, viewGroup, view);
            fragment.k1(fragment.H);
            runnableC0008e.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.H.startAnimation(runnableC0008e);
            return;
        }
        Animator animator = dVar.f1327b;
        fragment.l1(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.H);
        animator.start();
    }

    static d b(Context context, f fVar, Fragment fragment, boolean z2) {
        int iC;
        int iD = fragment.D();
        int iC2 = fragment.C();
        boolean z3 = false;
        fragment.o1(0);
        View viewE = fVar.e(fragment.f1245x);
        if (viewE != null) {
            int i3 = k0.b.visible_removing_fragment_view_tag;
            if (viewE.getTag(i3) != null) {
                viewE.setTag(i3, null);
            }
        }
        ViewGroup viewGroup = fragment.G;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation animationI0 = fragment.i0(iD, z2, iC2);
        if (animationI0 != null) {
            return new d(animationI0);
        }
        Animator animatorJ0 = fragment.j0(iD, z2, iC2);
        if (animatorJ0 != null) {
            return new d(animatorJ0);
        }
        if (iC2 != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iC2));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iC2);
                    if (animationLoadAnimation != null) {
                        return new d(animationLoadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e3) {
                    throw e3;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iC2);
                    if (animatorLoadAnimator != null) {
                        return new d(animatorLoadAnimator);
                    }
                } catch (RuntimeException e4) {
                    if (zEquals) {
                        throw e4;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iC2);
                    if (animationLoadAnimation2 != null) {
                        return new d(animationLoadAnimation2);
                    }
                }
            }
        }
        if (iD != 0 && (iC = c(iD, z2)) >= 0) {
            return new d(AnimationUtils.loadAnimation(context, iC));
        }
        return null;
    }

    private static int c(int i3, boolean z2) {
        if (i3 == 4097) {
            return z2 ? k0.a.fragment_open_enter : k0.a.fragment_open_exit;
        }
        if (i3 == 4099) {
            return z2 ? k0.a.fragment_fade_enter : k0.a.fragment_fade_exit;
        }
        if (i3 != 8194) {
            return -1;
        }
        return z2 ? k0.a.fragment_close_enter : k0.a.fragment_close_exit;
    }

    /* JADX INFO: compiled from: FragmentAnim.java */
    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f1326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f1327b;

        d(Animation animation) {
            this.f1326a = animation;
            this.f1327b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        d(Animator animator) {
            this.f1326a = null;
            this.f1327b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FragmentAnim.java */
    private static class RunnableC0008e extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ViewGroup f1328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f1329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1331e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1332f;

        RunnableC0008e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1332f = true;
            this.f1328b = viewGroup;
            this.f1329c = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation) {
            this.f1332f = true;
            if (this.f1330d) {
                return !this.f1331e;
            }
            if (!super.getTransformation(j3, transformation)) {
                this.f1330d = true;
                e0.r.a(this.f1328b, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1330d || !this.f1332f) {
                this.f1328b.endViewTransition(this.f1329c);
                this.f1331e = true;
            } else {
                this.f1332f = false;
                this.f1328b.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation, float f3) {
            this.f1332f = true;
            if (this.f1330d) {
                return !this.f1331e;
            }
            if (!super.getTransformation(j3, transformation, f3)) {
                this.f1330d = true;
                e0.r.a(this.f1328b, this);
            }
            return true;
        }
    }
}
