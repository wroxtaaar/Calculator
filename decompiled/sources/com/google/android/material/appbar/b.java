package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.c0;
import e0.t;
import java.util.List;

/* JADX INFO: compiled from: HeaderScrollingViewBehavior.java */
/* JADX INFO: loaded from: classes.dex */
abstract class b extends c<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f2566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f2567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2569g;

    public b() {
        this.f2566d = new Rect();
        this.f2567e = new Rect();
        this.f2568f = 0;
    }

    private static int N(int i3) {
        if (i3 == 0) {
            return 8388659;
        }
        return i3;
    }

    @Override // com.google.android.material.appbar.c
    protected void F(CoordinatorLayout coordinatorLayout, View view, int i3) {
        View viewH = H(coordinatorLayout.r(view));
        if (viewH == null) {
            super.F(coordinatorLayout, view, i3);
            this.f2568f = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.f2566d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, viewH.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + viewH.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        c0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && t.y(coordinatorLayout) && !t.y(view)) {
            rect.left += lastWindowInsets.i();
            rect.right -= lastWindowInsets.j();
        }
        Rect rect2 = this.f2567e;
        e0.d.a(N(fVar.f1112c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i3);
        int I = I(viewH);
        view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
        this.f2568f = rect2.top - viewH.getBottom();
    }

    abstract View H(List<View> list);

    final int I(View view) {
        if (this.f2569g == 0) {
            return 0;
        }
        float fJ = J(view);
        int i3 = this.f2569g;
        return z.a.b((int) (fJ * i3), 0, i3);
    }

    float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.f2569g;
    }

    int L(View view) {
        return view.getMeasuredHeight();
    }

    final int M() {
        return this.f2568f;
    }

    public final void O(int i3) {
        this.f2569g = i3;
    }

    protected boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
        View viewH;
        c0 lastWindowInsets;
        int i7 = view.getLayoutParams().height;
        if ((i7 != -1 && i7 != -2) || (viewH = H(coordinatorLayout.r(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (t.y(viewH) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.k() + lastWindowInsets.h();
        }
        int iL = size + L(viewH);
        int measuredHeight = viewH.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iL -= measuredHeight;
        }
        coordinatorLayout.J(view, i3, i4, View.MeasureSpec.makeMeasureSpec(iL, i7 == -1 ? 1073741824 : Integer.MIN_VALUE), i6);
        return true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2566d = new Rect();
        this.f2567e = new Rect();
        this.f2568f = 0;
    }
}
