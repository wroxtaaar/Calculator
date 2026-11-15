package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.o;
import e0.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t0.j;
import u0.k;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final int f2603m0 = j.Widget_MaterialComponents_BottomAppBar;
    private Integer Q;
    private final int R;
    private final k1.g S;
    private Animator T;
    private Animator U;
    private int V;
    private int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f2604a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f2605b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ArrayList<g> f2606c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f2607d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f2608e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f2609f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private Behavior f2610g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f2611h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f2612i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private int f2613j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    AnimatorListenerAdapter f2614k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    k<FloatingActionButton> f2615l0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.k0();
            BottomAppBar.this.T = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.l0();
        }
    }

    class b extends FloatingActionButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2622a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.k0();
            }
        }

        b(int i3) {
            this.f2622a = i3;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.p0(this.f2622a));
            floatingActionButton.s(new a());
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.k0();
            BottomAppBar.this.f2608e0 = false;
            BottomAppBar.this.U = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.l0();
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f2627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f2628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f2629e;

        d(ActionMenuView actionMenuView, int i3, boolean z2) {
            this.f2627c = actionMenuView;
            this.f2628d = i3;
            this.f2629e = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2626b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2626b) {
                return;
            }
            boolean z2 = BottomAppBar.this.f2607d0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.u0(bottomAppBar.f2607d0);
            BottomAppBar.this.A0(this.f2627c, this.f2628d, this.f2629e, z2);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f2631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f2633d;

        e(ActionMenuView actionMenuView, int i3, boolean z2) {
            this.f2631b = actionMenuView;
            this.f2632c = i3;
            this.f2633d = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.f2631b;
            actionMenuView.setTranslationX(BottomAppBar.this.o0(actionMenuView, this.f2632c, this.f2633d));
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f2614k0.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonM0 = BottomAppBar.this.m0();
            if (floatingActionButtonM0 != null) {
                floatingActionButtonM0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    interface g {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    static class h extends i0.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2636d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f2637e;

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f2636d);
            parcel.writeInt(this.f2637e ? 1 : 0);
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2636d = parcel.readInt();
            this.f2637e = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(ActionMenuView actionMenuView, int i3, boolean z2, boolean z3) {
        e eVar = new e(actionMenuView, i3, z2);
        if (z3) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f2614k0);
        floatingActionButton.f(new f());
        floatingActionButton.g(this.f2615l0);
    }

    private void g0() {
        Animator animator = this.U;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.T;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f2611h0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return p0(this.V);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f2613j0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f2612i0;
    }

    private com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.S.D().p();
    }

    private void i0(int i3, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(m0(), "translationX", p0(i3));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    private void j0(int i3, boolean z2, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - o0(actionMenuView, i3, z2)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.addListener(new d(actionMenuView, i3, z2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        ArrayList<g> arrayList;
        int i3 = this.f2605b0 - 1;
        this.f2605b0 = i3;
        if (i3 != 0 || (arrayList = this.f2606c0) == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        ArrayList<g> arrayList;
        int i3 = this.f2605b0;
        this.f2605b0 = i3 + 1;
        if (i3 != 0 || (arrayList = this.f2606c0) == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton m0() {
        View viewN0 = n0();
        if (viewN0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewN0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View n0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).s(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p0(int i3) {
        boolean zE = o.e(this);
        if (i3 == 1) {
            return ((getMeasuredWidth() / 2) - (this.R + (zE ? this.f2613j0 : this.f2612i0))) * (zE ? -1 : 1);
        }
        return 0.0f;
    }

    private boolean q0() {
        FloatingActionButton floatingActionButtonM0 = m0();
        return floatingActionButtonM0 != null && floatingActionButtonM0.o();
    }

    private void r0(int i3, boolean z2) {
        if (!t.S(this)) {
            this.f2608e0 = false;
            u0(this.f2607d0);
            return;
        }
        Animator animator = this.U;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!q0()) {
            i3 = 0;
            z2 = false;
        }
        j0(i3, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.U = animatorSet;
        animatorSet.addListener(new c());
        this.U.start();
    }

    private void s0(int i3) {
        if (this.V == i3 || !t.S(this)) {
            return;
        }
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.W == 1) {
            i0(i3, arrayList);
        } else {
            h0(i3, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.T = animatorSet;
        animatorSet.addListener(new a());
        this.T.start();
    }

    private Drawable t0(Drawable drawable) {
        if (drawable == null || this.Q == null) {
            return drawable;
        }
        Drawable drawableR = x.a.r(drawable.mutate());
        x.a.n(drawableR, this.Q.intValue());
        return drawableR;
    }

    private void v0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.U != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (q0()) {
            z0(actionMenuView, this.V, this.f2609f0);
        } else {
            z0(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        getTopEdgeTreatment().m(getFabTranslationX());
        View viewN0 = n0();
        this.S.Y((this.f2609f0 && q0()) ? 1.0f : 0.0f);
        if (viewN0 != null) {
            viewN0.setTranslationY(getFabTranslationY());
            viewN0.setTranslationX(getFabTranslationX());
        }
    }

    private void z0(ActionMenuView actionMenuView, int i3, boolean z2) {
        A0(actionMenuView, i3, z2, false);
    }

    public ColorStateList getBackgroundTint() {
        return this.S.F();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.V;
    }

    public int getFabAnimationMode() {
        return this.W;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public boolean getHideOnScroll() {
        return this.f2604a0;
    }

    protected void h0(int i3, List<Animator> list) {
        FloatingActionButton floatingActionButtonM0 = m0();
        if (floatingActionButtonM0 == null || floatingActionButtonM0.n()) {
            return;
        }
        l0();
        floatingActionButtonM0.l(new b(i3));
    }

    protected int o0(ActionMenuView actionMenuView, int i3, boolean z2) {
        if (i3 != 1 || !z2) {
            return 0;
        }
        boolean zE = o.e(this);
        int measuredWidth = zE ? getMeasuredWidth() : 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f2229a & 8388615) == 8388611) {
                measuredWidth = zE ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zE ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zE ? this.f2612i0 : -this.f2613j0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k1.h.f(this, this.S);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        if (z2) {
            g0();
            w0();
        }
        v0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.j());
        this.V = hVar.f2636d;
        this.f2609f0 = hVar.f2637e;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.f2636d = this.V;
        hVar.f2637e = this.f2609f0;
        return hVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        x.a.o(this.S, colorStateList);
    }

    public void setCradleVerticalOffset(float f3) {
        if (f3 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().h(f3);
            this.S.invalidateSelf();
            w0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        this.S.W(f3);
        getBehavior().I(this, this.S.C() - this.S.B());
    }

    public void setFabAlignmentMode(int i3) {
        x0(i3, 0);
    }

    public void setFabAnimationMode(int i3) {
        this.W = i3;
    }

    void setFabCornerSize(float f3) {
        if (f3 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().i(f3);
            this.S.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f3) {
        if (f3 != getFabCradleMargin()) {
            getTopEdgeTreatment().j(f3);
            this.S.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f3) {
        if (f3 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().k(f3);
            this.S.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z2) {
        this.f2604a0 = z2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(t0(drawable));
    }

    public void setNavigationIconTint(int i3) {
        this.Q = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void u0(int i3) {
        if (i3 != 0) {
            this.f2607d0 = 0;
            getMenu().clear();
            x(i3);
        }
    }

    public void x0(int i3, int i4) {
        this.f2607d0 = i4;
        this.f2608e0 = true;
        r0(i3, this.f2609f0);
        s0(i3);
        this.V = i3;
    }

    boolean y0(int i3) {
        float f3 = i3;
        if (f3 == getTopEdgeTreatment().g()) {
            return false;
        }
        getTopEdgeTreatment().l(f3);
        this.S.invalidateSelf();
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f2610g0 == null) {
            this.f2610g0 = new Behavior();
        }
        return this.f2610g0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Rect f2616e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference<BottomAppBar> f2617f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2618g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final View.OnLayoutChangeListener f2619h;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f2617f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.j(Behavior.this.f2616e);
                int iHeight = Behavior.this.f2616e.height();
                bottomAppBar.y0(iHeight);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f2616e)));
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f2618g == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(t0.d.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (o.e(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.R;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.R;
                    }
                }
            }
        }

        public Behavior() {
            this.f2619h = new a();
            this.f2616e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i3) {
            this.f2617f = new WeakReference<>(bottomAppBar);
            View viewN0 = bottomAppBar.n0();
            if (viewN0 != null && !t.S(viewN0)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewN0.getLayoutParams();
                fVar.f1113d = 49;
                this.f2618g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (viewN0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewN0;
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(t0.a.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(t0.a.mtrl_fab_hide_motion_spec);
                    }
                    floatingActionButton.addOnLayoutChangeListener(this.f2619h);
                    bottomAppBar.f0(floatingActionButton);
                }
                bottomAppBar.w0();
            }
            coordinatorLayout.I(bottomAppBar, i3);
            return super.l(coordinatorLayout, bottomAppBar, i3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i3, int i4) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i3, i4);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2619h = new a();
            this.f2616e = new Rect();
        }
    }
}
