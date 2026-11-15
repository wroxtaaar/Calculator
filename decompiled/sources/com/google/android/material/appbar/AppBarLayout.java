package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import e0.c0;
import e0.t;
import f0.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import k1.h;
import t0.j;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f2506u = j.Widget_Design_AppBarLayout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c0 f2513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<b> f2514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2517l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2518m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f2519n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WeakReference<View> f2520o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator f2521p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List<f> f2522q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int[] f2523r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Drawable f2524s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Behavior f2525t;

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f2526k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f2527l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private ValueAnimator f2528m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private e f2529n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private WeakReference<View> f2530o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f2531p;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f2532b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f2533c;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f2532b = coordinatorLayout;
                this.f2533c = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f2532b, this.f2533c, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b extends e0.a {
            b() {
            }

            @Override // e0.a
            public void g(View view, f0.d dVar) {
                super.g(view, dVar);
                dVar.p0(BaseBehavior.this.f2531p);
                dVar.X(ScrollView.class.getName());
            }
        }

        class c implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f2536a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f2537b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f2538c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f2539d;

            c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
                this.f2536a = coordinatorLayout;
                this.f2537b = appBarLayout;
                this.f2538c = view;
                this.f2539d = i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // f0.g
            public boolean a(View view, g.a aVar) {
                BaseBehavior.this.q(this.f2536a, this.f2537b, this.f2538c, 0, this.f2539d, new int[]{0, 0}, 1);
                return true;
            }
        }

        class d implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f2541a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f2542b;

            d(AppBarLayout appBarLayout, boolean z2) {
                this.f2541a = appBarLayout;
                this.f2542b = z2;
            }

            @Override // f0.g
            public boolean a(View view, g.a aVar) {
                this.f2541a.setExpanded(this.f2542b);
                return true;
            }
        }

        public BaseBehavior() {
        }

        private boolean T(CoordinatorLayout coordinatorLayout, T t3, View view) {
            boolean z2 = false;
            if (M() != (-t3.getTotalScrollRange())) {
                U(coordinatorLayout, t3, f0.d.a.f4654q, false);
                z2 = true;
            }
            if (M() != 0) {
                if (!view.canScrollVertically(-1)) {
                    U(coordinatorLayout, t3, f0.d.a.f4655r, true);
                    return true;
                }
                int i3 = -t3.getDownNestedPreScrollRange();
                if (i3 != 0) {
                    t.i0(coordinatorLayout, f0.d.a.f4655r, null, new c(coordinatorLayout, t3, view, i3));
                    return true;
                }
            }
            return z2;
        }

        private void U(CoordinatorLayout coordinatorLayout, T t3, f0.d.a aVar, boolean z2) {
            t.i0(coordinatorLayout, aVar, null, new d(t3, z2));
        }

        private void V(CoordinatorLayout coordinatorLayout, T t3, int i3, float f3) {
            int iAbs = Math.abs(M() - i3);
            float fAbs = Math.abs(f3);
            W(coordinatorLayout, t3, i3, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t3.getHeight()) + 1.0f) * 150.0f));
        }

        private void W(CoordinatorLayout coordinatorLayout, T t3, int i3, int i4) {
            int iM = M();
            if (iM == i3) {
                ValueAnimator valueAnimator = this.f2528m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f2528m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f2528m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f2528m = valueAnimator3;
                valueAnimator3.setInterpolator(u0.a.f6261e);
                this.f2528m.addUpdateListener(new a(coordinatorLayout, t3));
            } else {
                valueAnimator2.cancel();
            }
            this.f2528m.setDuration(Math.min(i4, SecurityKeyException.SK_ERROR_KEY_ENV_ISSUE));
            this.f2528m.setIntValues(iM, i3);
            this.f2528m.start();
        }

        private int X(int i3, int i4, int i5) {
            return i3 < (i4 + i5) / 2 ? i4 : i5;
        }

        private boolean Z(CoordinatorLayout coordinatorLayout, T t3, View view) {
            return t3.j() && coordinatorLayout.getHeight() - view.getHeight() <= t3.getHeight();
        }

        private static boolean a0(int i3, int i4) {
            return (i3 & i4) == i4;
        }

        private boolean b0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (((e) appBarLayout.getChildAt(i3).getLayoutParams()).f2553a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View c0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof e0.j) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View d0(AppBarLayout appBarLayout, int i3) {
            int iAbs = Math.abs(i3);
            int childCount = appBarLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int e0(T t3, int i3) {
            int childCount = t3.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = t3.getChildAt(i4);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (a0(eVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i5 = -i3;
                if (top <= i5 && bottom >= i5) {
                    return i4;
                }
            }
            return -1;
        }

        private View f0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int i0(T t3, int i3) {
            int iAbs = Math.abs(i3);
            int childCount = t3.getChildCount();
            int topInset = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = t3.getChildAt(i4);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator interpolatorD = eVar.d();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorD == null) {
                        break;
                    }
                    int iC = eVar.c();
                    if ((iC & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= t.C(childAt);
                        }
                    }
                    if (t.y(childAt)) {
                        topInset -= t3.getTopInset();
                    }
                    if (topInset <= 0) {
                        break;
                    }
                    float f3 = topInset;
                    return Integer.signum(i3) * (childAt.getTop() + Math.round(f3 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f3)));
                }
            }
            return i3;
        }

        private boolean v0(CoordinatorLayout coordinatorLayout, T t3) {
            List<View> listS = coordinatorLayout.s(t3);
            int size = listS.size();
            for (int i3 = 0; i3 < size; i3++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) listS.get(i3).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).K() != 0;
                }
            }
            return false;
        }

        private void w0(CoordinatorLayout coordinatorLayout, T t3) {
            int topInset = t3.getTopInset() + t3.getPaddingTop();
            int iM = M() - topInset;
            int iE0 = e0(t3, iM);
            if (iE0 >= 0) {
                View childAt = t3.getChildAt(iE0);
                e eVar = (e) childAt.getLayoutParams();
                int iC = eVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int iC2 = -childAt.getBottom();
                    if (iE0 == 0 && t.y(t3) && t.y(childAt)) {
                        topInset2 -= t3.getTopInset();
                    }
                    if (a0(iC, 2)) {
                        iC2 += t.C(childAt);
                    } else if (a0(iC, 5)) {
                        int iC3 = t.C(childAt) + iC2;
                        if (iM < iC3) {
                            topInset2 = iC3;
                        } else {
                            iC2 = iC3;
                        }
                    }
                    if (a0(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) eVar).topMargin;
                        iC2 -= ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    }
                    V(coordinatorLayout, t3, z.a.b(X(iM, iC2, topInset2) + topInset, -t3.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void x0(CoordinatorLayout coordinatorLayout, T t3) {
            View viewF0;
            t.g0(coordinatorLayout, f0.d.a.f4654q.b());
            t.g0(coordinatorLayout, f0.d.a.f4655r.b());
            if (t3.getTotalScrollRange() == 0 || (viewF0 = f0(coordinatorLayout)) == null || !b0(t3)) {
                return;
            }
            if (!t.M(coordinatorLayout)) {
                t.m0(coordinatorLayout, new b());
            }
            this.f2531p = T(coordinatorLayout, t3, viewF0);
        }

        private void y0(CoordinatorLayout coordinatorLayout, T t3, int i3, int i4, boolean z2) {
            View viewD0 = d0(t3, i3);
            boolean zU = false;
            if (viewD0 != null) {
                int iC = ((e) viewD0.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int iC2 = t.C(viewD0);
                    if (i4 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i3) < (viewD0.getBottom() - iC2) - t3.getTopInset()) : (-i3) >= (viewD0.getBottom() - iC2) - t3.getTopInset()) {
                        zU = true;
                    }
                }
            }
            if (t3.l()) {
                zU = t3.u(c0(coordinatorLayout));
            }
            boolean zR = t3.r(zU);
            if (z2 || (zR && v0(coordinatorLayout, t3))) {
                t3.jumpDrawablesToCurrentState();
            }
        }

        @Override // com.google.android.material.appbar.a
        int M() {
            return E() + this.f2526k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
        public boolean H(T t3) {
            WeakReference<View> weakReference = this.f2530o;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
        public int K(T t3) {
            return -t3.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
        public int L(T t3) {
            return t3.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout coordinatorLayout, T t3) {
            w0(coordinatorLayout, t3);
            if (t3.l()) {
                t3.r(t3.u(c0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, T t3, int i3) {
            boolean zL = super.l(coordinatorLayout, t3, i3);
            int pendingAction = t3.getPendingAction();
            e eVar = this.f2529n;
            if (eVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z2 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i4 = -t3.getUpNestedPreScrollRange();
                        if (z2) {
                            V(coordinatorLayout, t3, i4, 0.0f);
                        } else {
                            P(coordinatorLayout, t3, i4);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z2) {
                            V(coordinatorLayout, t3, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, t3, 0);
                        }
                    }
                }
            } else if (eVar.f2544d) {
                P(coordinatorLayout, t3, -t3.getTotalScrollRange());
            } else if (eVar.f2545e) {
                P(coordinatorLayout, t3, 0);
            } else {
                View childAt = t3.getChildAt(eVar.f2546f);
                P(coordinatorLayout, t3, (-childAt.getBottom()) + (this.f2529n.f2548h ? t.C(childAt) + t3.getTopInset() : Math.round(childAt.getHeight() * this.f2529n.f2547g)));
            }
            t3.n();
            this.f2529n = null;
            G(z.a.b(E(), -t3.getTotalScrollRange(), 0));
            y0(coordinatorLayout, t3, E(), 0, true);
            t3.m(E());
            x0(coordinatorLayout, t3);
            return zL;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, T t3, int i3, int i4, int i5, int i6) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t3.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t3, i3, i4, i5, i6);
            }
            coordinatorLayout.J(t3, i3, i4, View.MeasureSpec.makeMeasureSpec(0, 0), i6);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, T t3, View view, int i3, int i4, int[] iArr, int i5) {
            int i6;
            int downNestedPreScrollRange;
            if (i4 != 0) {
                if (i4 < 0) {
                    i6 = -t3.getTotalScrollRange();
                    downNestedPreScrollRange = t3.getDownNestedPreScrollRange() + i6;
                } else {
                    i6 = -t3.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i7 = i6;
                int i8 = downNestedPreScrollRange;
                if (i7 != i8) {
                    iArr[1] = O(coordinatorLayout, t3, i4, i7, i8);
                }
            }
            if (t3.l()) {
                t3.r(t3.u(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, T t3, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            if (i6 < 0) {
                iArr[1] = O(coordinatorLayout, t3, i6, -t3.getDownNestedScrollRange(), 0);
            }
            if (i6 == 0) {
                x0(coordinatorLayout, t3);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, T t3, Parcelable parcelable) {
            if (parcelable instanceof e) {
                s0((e) parcelable, true);
                super.x(coordinatorLayout, t3, this.f2529n.j());
            } else {
                super.x(coordinatorLayout, t3, parcelable);
                this.f2529n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t3) {
            Parcelable parcelableY = super.y(coordinatorLayout, t3);
            e eVarT0 = t0(parcelableY, t3);
            return eVarT0 == null ? parcelableY : eVarT0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, T t3, View view, View view2, int i3, int i4) {
            ValueAnimator valueAnimator;
            boolean z2 = (i3 & 2) != 0 && (t3.l() || Z(coordinatorLayout, t3, view));
            if (z2 && (valueAnimator = this.f2528m) != null) {
                valueAnimator.cancel();
            }
            this.f2530o = null;
            this.f2527l = i4;
            return z2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, T t3, View view, int i3) {
            if (this.f2527l == 0 || i3 == 1) {
                w0(coordinatorLayout, t3);
                if (t3.l()) {
                    t3.r(t3.u(view));
                }
            }
            this.f2530o = new WeakReference<>(view);
        }

        void s0(e eVar, boolean z2) {
            if (this.f2529n == null || z2) {
                this.f2529n = eVar;
            }
        }

        e t0(Parcelable parcelable, T t3) {
            int iE = E();
            int childCount = t3.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t3.getChildAt(i3);
                int bottom = childAt.getBottom() + iE;
                if (childAt.getTop() + iE <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = i0.a.f4882c;
                    }
                    e eVar = new e(parcelable);
                    boolean z2 = iE == 0;
                    eVar.f2545e = z2;
                    eVar.f2544d = !z2 && (-iE) >= t3.getTotalScrollRange();
                    eVar.f2546f = i3;
                    eVar.f2548h = bottom == t.C(childAt) + t3.getTopInset();
                    eVar.f2547g = bottom / childAt.getHeight();
                    return eVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, T t3, int i3, int i4, int i5) {
            int iM = M();
            int i6 = 0;
            if (i4 == 0 || iM < i4 || iM > i5) {
                this.f2526k = 0;
            } else {
                int iB = z.a.b(i3, i4, i5);
                if (iM != iB) {
                    int iI0 = t3.h() ? i0(t3, iB) : iB;
                    boolean zG = G(iI0);
                    int i7 = iM - iB;
                    this.f2526k = iB - iI0;
                    if (zG) {
                        while (i6 < t3.getChildCount()) {
                            e eVar = (e) t3.getChildAt(i6).getLayoutParams();
                            c cVarB = eVar.b();
                            if (cVarB != null && (eVar.c() & 1) != 0) {
                                cVarB.a(t3, t3.getChildAt(i6), E());
                            }
                            i6++;
                        }
                    }
                    if (!zG && t3.h()) {
                        coordinatorLayout.f(t3);
                    }
                    t3.m(E());
                    y0(coordinatorLayout, t3, iB, iB < iM ? -1 : 1, false);
                    i6 = i7;
                }
            }
            x0(coordinatorLayout, t3);
            return i6;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class e extends i0.a {
            public static final Parcelable.Creator<e> CREATOR = new a();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f2544d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f2545e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f2546f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            float f2547g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            boolean f2548h;

            class a implements Parcelable.ClassLoaderCreator<e> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public e createFromParcel(Parcel parcel) {
                    return new e(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new e(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public e[] newArray(int i3) {
                    return new e[i3];
                }
            }

            public e(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2544d = parcel.readByte() != 0;
                this.f2545e = parcel.readByte() != 0;
                this.f2546f = parcel.readInt();
                this.f2547g = parcel.readFloat();
                this.f2548h = parcel.readByte() != 0;
            }

            @Override // i0.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                super.writeToParcel(parcel, i3);
                parcel.writeByte(this.f2544d ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f2545e ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f2546f);
                parcel.writeFloat(this.f2547g);
                parcel.writeByte(this.f2548h ? (byte) 1 : (byte) 0);
            }

            public e(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.a, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.D(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean G(int i3) {
            return super.G(i3);
        }

        @Override // com.google.android.material.appbar.a, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.k(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: k0 */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            return super.l(coordinatorLayout, appBarLayout, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: l0 */
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5, int i6) {
            return super.m(coordinatorLayout, appBarLayout, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: m0 */
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int[] iArr, int i5) {
            super.q(coordinatorLayout, appBarLayout, view, i3, i4, iArr, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: n0 */
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i3, i4, i5, i6, i7, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: o0 */
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: p0 */
        public /* bridge */ /* synthetic */ Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: r0 */
        public /* bridge */ /* synthetic */ void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            super.C(coordinatorLayout, appBarLayout, view, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        private static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                return ((BaseBehavior) cVarF).M();
            }
            return 0;
        }

        private void S(View view, View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                t.Y(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).f2526k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.l()) {
                    appBarLayout.r(appBarLayout.u(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        float J(View view) {
            int i3;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iR = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iR > downNestedPreScrollRange) && (i3 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iR / i3) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.b
        int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List<View> list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = list.get(i3);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                t.g0(coordinatorLayout, f0.d.a.f4654q.b());
                t.g0(coordinatorLayout, f0.d.a.f4655r.b());
                t.m0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.l(coordinatorLayout, view, i3);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
            return super.m(coordinatorLayout, view, i3, i4, i5, i6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            AppBarLayout appBarLayoutH = H(coordinatorLayout.r(view));
            if (appBarLayoutH != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f2566d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutH.o(false, !z2);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ScrollingViewBehavior_Layout);
            O(typedArrayObtainStyledAttributes.getDimensionPixelSize(k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.g f2549b;

        a(k1.g gVar) {
            this.f2549b = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f2549b.W(fFloatValue);
            if (AppBarLayout.this.f2524s instanceof k1.g) {
                ((k1.g) AppBarLayout.this.f2524s).W(fFloatValue);
            }
            Iterator it = AppBarLayout.this.f2522q.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(fFloatValue, this.f2549b.z());
            }
        }
    }

    public interface b<T extends AppBarLayout> {
        void a(T t3, int i3);
    }

    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f3);
    }

    public static class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f2551a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f2552b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, View view, float f3) {
            b(this.f2551a, appBarLayout, view);
            float fAbs = this.f2551a.top - Math.abs(f3);
            if (fAbs > 0.0f) {
                t.s0(view, null);
                view.setTranslationY(0.0f);
                return;
            }
            float fA = 1.0f - z.a.a(Math.abs(fAbs / this.f2551a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f2551a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f2552b);
            this.f2552b.offset(0, (int) (-fHeight));
            t.s0(view, this.f2552b);
        }
    }

    public interface f {
        void a(float f3, int i3);
    }

    private void c() {
        WeakReference<View> weakReference = this.f2520o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2520o = null;
    }

    private View d(View view) {
        int i3;
        if (this.f2520o == null && (i3 = this.f2519n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i3) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f2519n);
            }
            if (viewFindViewById != null) {
                this.f2520o = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f2520o;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean i() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((e) getChildAt(i3).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        Behavior behavior = this.f2525t;
        BaseBehavior.e eVarT0 = (behavior == null || this.f2508c == -1 || this.f2512g != 0) ? null : behavior.t0(i0.a.f4882c, this);
        this.f2508c = -1;
        this.f2509d = -1;
        this.f2510e = -1;
        if (eVarT0 != null) {
            this.f2525t.s0(eVarT0, false);
        }
    }

    private void p(boolean z2, boolean z3, boolean z4) {
        this.f2512g = (z2 ? 1 : 2) | (z3 ? 4 : 0) | (z4 ? 8 : 0);
        requestLayout();
    }

    private boolean q(boolean z2) {
        if (this.f2516k == z2) {
            return false;
        }
        this.f2516k = z2;
        refreshDrawableState();
        return true;
    }

    private boolean t() {
        return this.f2524s != null && getTopInset() > 0;
    }

    private boolean v() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || t.y(childAt)) ? false : true;
    }

    private void w(k1.g gVar, boolean z2) {
        float dimension = getResources().getDimension(t0.d.design_appbar_elevation);
        float f3 = z2 ? 0.0f : dimension;
        if (!z2) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f2521p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f3, dimension);
        this.f2521p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(t0.g.app_bar_elevation_anim_duration));
        this.f2521p.setInterpolator(u0.a.f6257a);
        this.f2521p.addUpdateListener(new a(gVar));
        this.f2521p.start();
    }

    private void x() {
        setWillNotDraw(!t());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (t()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f2507b);
            this.f2524s.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2524s;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) {
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
        }
        return new e((LinearLayout.LayoutParams) layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f2525t = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iC;
        int i3 = this.f2509d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            e eVar = (e) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = eVar.f2553a;
            if ((i5 & 5) != 5) {
                if (i4 > 0) {
                    break;
                }
            } else {
                int i6 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                if ((i5 & 8) != 0) {
                    iC = t.C(childAt);
                } else {
                    if ((i5 & 2) != 0) {
                        iC = measuredHeight - t.C(childAt);
                    } else {
                        iMin = i6 + measuredHeight;
                    }
                    if (childCount == 0 && t.y(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i4 += iMin;
                }
                iMin = i6 + iC;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i4 += iMin;
            }
        }
        int iMax = Math.max(0, i4);
        this.f2509d = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i3 = this.f2510e;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int iC = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            e eVar = (e) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
            int i5 = eVar.f2553a;
            if ((i5 & 1) == 0) {
                break;
            }
            iC += measuredHeight;
            if ((i5 & 2) != 0) {
                iC -= t.C(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iC);
        this.f2510e = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f2519n;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iC = t.C(this);
        if (iC == 0) {
            int childCount = getChildCount();
            iC = childCount >= 1 ? t.C(getChildAt(childCount - 1)) : 0;
            if (iC == 0) {
                return getHeight() / 3;
            }
        }
        return (iC * 2) + topInset;
    }

    int getPendingAction() {
        return this.f2512g;
    }

    public Drawable getStatusBarForeground() {
        return this.f2524s;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        c0 c0Var = this.f2513h;
        if (c0Var != null) {
            return c0Var.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i3 = this.f2508c;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int iC = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            e eVar = (e) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = eVar.f2553a;
            if ((i5 & 1) == 0) {
                break;
            }
            iC += measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
            if (i4 == 0 && t.y(childAt)) {
                iC -= getTopInset();
            }
            if ((i5 & 2) != 0) {
                iC -= t.C(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iC);
        this.f2508c = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean h() {
        return this.f2511f;
    }

    boolean j() {
        return getTotalScrollRange() != 0;
    }

    public boolean l() {
        return this.f2518m;
    }

    void m(int i3) {
        this.f2507b = i3;
        if (!willNotDraw()) {
            t.d0(this);
        }
        List<b> list = this.f2514i;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                b bVar = this.f2514i.get(i4);
                if (bVar != null) {
                    bVar.a(this, i3);
                }
            }
        }
    }

    void n() {
        this.f2512g = 0;
    }

    public void o(boolean z2, boolean z3) {
        p(z2, z3, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        if (this.f2523r == null) {
            this.f2523r = new int[4];
        }
        int[] iArr = this.f2523r;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + iArr.length);
        boolean z2 = this.f2516k;
        int i4 = t0.b.state_liftable;
        if (!z2) {
            i4 = -i4;
        }
        iArr[0] = i4;
        iArr[1] = (z2 && this.f2517l) ? t0.b.state_lifted : -t0.b.state_lifted;
        int i5 = t0.b.state_collapsible;
        if (!z2) {
            i5 = -i5;
        }
        iArr[2] = i5;
        iArr[3] = (z2 && this.f2517l) ? t0.b.state_collapsed : -t0.b.state_collapsed;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        boolean z3 = true;
        if (t.y(this) && v()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                t.Y(getChildAt(childCount), topInset);
            }
        }
        k();
        this.f2511f = false;
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            if (((e) getChildAt(i7).getLayoutParams()).d() != null) {
                this.f2511f = true;
                break;
            }
        }
        Drawable drawable = this.f2524s;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f2515j) {
            return;
        }
        if (!this.f2518m && !i()) {
            z3 = false;
        }
        q(z3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != 1073741824 && t.y(this) && v()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = z.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i4));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        k();
    }

    boolean r(boolean z2) {
        return s(z2, !this.f2515j);
    }

    boolean s(boolean z2, boolean z3) {
        if (!z3 || this.f2517l == z2) {
            return false;
        }
        this.f2517l = z2;
        refreshDrawableState();
        if (!this.f2518m || !(getBackground() instanceof k1.g)) {
            return true;
        }
        w((k1.g) getBackground(), z2);
        return true;
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        h.d(this, f3);
    }

    public void setExpanded(boolean z2) {
        o(z2, t.S(this));
    }

    public void setLiftOnScroll(boolean z2) {
        this.f2518m = z2;
    }

    public void setLiftOnScrollTargetViewId(int i3) {
        this.f2519n = i3;
        c();
    }

    public void setLiftableOverrideEnabled(boolean z2) {
        this.f2515j = z2;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i3);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f2524s;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f2524s = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f2524s.setState(getDrawableState());
                }
                x.a.m(this.f2524s, t.B(this));
                this.f2524s.setVisible(getVisibility() == 0, false);
                this.f2524s.setCallback(this);
            }
            x();
            t.d0(this);
        }
    }

    public void setStatusBarForegroundColor(int i3) {
        setStatusBarForeground(new ColorDrawable(i3));
    }

    public void setStatusBarForegroundResource(int i3) {
        setStatusBarForeground(c.a.d(getContext(), i3));
    }

    @Deprecated
    public void setTargetElevation(float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.e.a(this, f3);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z2 = i3 == 0;
        Drawable drawable = this.f2524s;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    boolean u(View view) {
        View viewD = d(view);
        if (viewD != null) {
            view = viewD;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2524s;
    }

    public static class e extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f2554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Interpolator f2555c;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2553a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.AppBarLayout_Layout);
            this.f2553a = typedArrayObtainStyledAttributes.getInt(k.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(a(typedArrayObtainStyledAttributes.getInt(k.AppBarLayout_Layout_layout_scrollEffect, 0)));
            int i3 = k.AppBarLayout_Layout_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.f2555c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i3, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        private c a(int i3) {
            if (i3 != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.f2554b;
        }

        public int c() {
            return this.f2553a;
        }

        public Interpolator d() {
            return this.f2555c;
        }

        boolean e() {
            int i3 = this.f2553a;
            return (i3 & 1) == 1 && (i3 & 10) != 0;
        }

        public void f(c cVar) {
            this.f2554b = cVar;
        }

        public e(int i3, int i4) {
            super(i3, i4);
            this.f2553a = 1;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2553a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2553a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2553a = 1;
        }
    }
}
