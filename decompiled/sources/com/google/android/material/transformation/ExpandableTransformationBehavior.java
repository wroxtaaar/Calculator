package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimatorSet f3434b;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f3434b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected boolean H(View view, View view2, boolean z2, boolean z3) {
        AnimatorSet animatorSet = this.f3434b;
        boolean z4 = animatorSet != null;
        if (z4) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetJ = J(view, view2, z2, z4);
        this.f3434b = animatorSetJ;
        animatorSetJ.addListener(new a());
        this.f3434b.start();
        if (!z3) {
            this.f3434b.end();
        }
        return true;
    }

    protected abstract AnimatorSet J(View view, View view2, boolean z2, boolean z3);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
