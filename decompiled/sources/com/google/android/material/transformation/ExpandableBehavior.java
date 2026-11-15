package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.t;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3429a;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d1.a f3432d;

        a(View view, int i3, d1.a aVar) {
            this.f3430b = view;
            this.f3431c = i3;
            this.f3432d = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f3430b.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f3429a == this.f3431c) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                d1.a aVar = this.f3432d;
                expandableBehavior.H((View) aVar, this.f3430b, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f3429a = 0;
    }

    private boolean F(boolean z2) {
        if (!z2) {
            return this.f3429a == 1;
        }
        int i3 = this.f3429a;
        return i3 == 0 || i3 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected d1.a G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> listR = coordinatorLayout.r(view);
        int size = listR.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = listR.get(i3);
            if (e(coordinatorLayout, view, view2)) {
                return (d1.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean H(View view, View view2, boolean z2, boolean z3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        d1.a aVar = (d1.a) view2;
        if (!F(aVar.a())) {
            return false;
        }
        this.f3429a = aVar.a() ? 1 : 2;
        return H((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i3) {
        d1.a aVarG;
        if (t.S(view) || (aVarG = G(coordinatorLayout, view)) == null || !F(aVarG.a())) {
            return false;
        }
        int i4 = aVarG.a() ? 1 : 2;
        this.f3429a = i4;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i4, aVarG));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3429a = 0;
    }
}
