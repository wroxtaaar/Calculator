package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewPropertyAnimator f2584d;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2584d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f2581a = 0;
        this.f2582b = 2;
        this.f2583c = 0;
    }

    private void F(V v3, int i3, long j3, TimeInterpolator timeInterpolator) {
        this.f2584d = v3.animate().translationY(i3).setInterpolator(timeInterpolator).setDuration(j3).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i3, int i4) {
        return i3 == 2;
    }

    public boolean G() {
        return this.f2582b == 1;
    }

    public boolean H() {
        return this.f2582b == 2;
    }

    public void I(V v3, int i3) {
        this.f2583c = i3;
        if (this.f2582b == 1) {
            v3.setTranslationY(this.f2581a + i3);
        }
    }

    public void J(V v3) {
        K(v3, true);
    }

    public void K(V v3, boolean z2) {
        if (G()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2584d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f2582b = 1;
        int i3 = this.f2581a + this.f2583c;
        if (z2) {
            F(v3, i3, 175L, u0.a.f6259c);
        } else {
            v3.setTranslationY(i3);
        }
    }

    public void L(V v3) {
        M(v3, true);
    }

    public void M(V v3, boolean z2) {
        if (H()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2584d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f2582b = 2;
        if (z2) {
            F(v3, 0, 225L, u0.a.f6260d);
        } else {
            v3.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        this.f2581a = v3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v3.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, v3, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (i4 > 0) {
            J(v3);
        } else if (i4 < 0) {
            L(v3);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2581a = 0;
        this.f2582b = 2;
        this.f2583c = 0;
    }
}
