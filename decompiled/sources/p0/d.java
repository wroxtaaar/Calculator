package p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: Fade.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends j0 {

    /* JADX INFO: compiled from: Fade.java */
    class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5625b;

        a(View view) {
            this.f5625b = view;
        }

        @Override // p0.m.f
        public void b(m mVar) {
            c0.g(this.f5625b, 1.0f);
            c0.a(this.f5625b);
            mVar.P(this);
        }
    }

    /* JADX INFO: compiled from: Fade.java */
    private static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f5627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5628c = false;

        b(View view) {
            this.f5627b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.g(this.f5627b, 1.0f);
            if (this.f5628c) {
                this.f5627b.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e0.t.O(this.f5627b) && this.f5627b.getLayerType() == 0) {
                this.f5628c = true;
                this.f5627b.setLayerType(2, null);
            }
        }
    }

    public d(int i3) {
        i0(i3);
    }

    private Animator j0(View view, float f3, float f4) {
        if (f3 == f4) {
            return null;
        }
        c0.g(view, f3);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, c0.f5623b, f4);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }

    private static float k0(s sVar, float f3) {
        Float f4;
        return (sVar == null || (f4 = (Float) sVar.f5725a.get("android:fade:transitionAlpha")) == null) ? f3 : f4.floatValue();
    }

    @Override // p0.j0
    public Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fK0 = k0(sVar, 0.0f);
        return j0(view, fK0 != 1.0f ? fK0 : 0.0f, 1.0f);
    }

    @Override // p0.j0
    public Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        c0.e(view);
        return j0(view, k0(sVar, 1.0f), 0.0f);
    }

    @Override // p0.j0, p0.m
    public void j(s sVar) {
        super.j(sVar);
        sVar.f5725a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(sVar.f5726b)));
    }

    public d() {
    }
}
