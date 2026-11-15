package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.internal.o;
import e0.c0;
import e0.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k1.k;
import t0.i;
import t0.j;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final int f2644d0 = j.Widget_Design_BottomSheet_Modal;
    private ValueAnimator A;
    int B;
    int C;
    int D;
    float E;
    int F;
    float G;
    boolean H;
    private boolean I;
    private boolean J;
    int K;
    int L;
    j0.c M;
    private boolean N;
    private int O;
    private boolean P;
    private int Q;
    int R;
    int S;
    WeakReference<V> T;
    WeakReference<View> U;
    private final ArrayList<f> V;
    private VelocityTracker W;
    int X;
    private int Y;
    boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2645a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Map<View, Integer> f2646a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2647b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f2648b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2649c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final j0.c.AbstractC0071c f2650c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k1.g f2656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f2657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2661n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2662o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f2663p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f2664q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2665r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2666s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f2667t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2668u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f2669v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f2670w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private k f2671x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f2672y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final BottomSheetBehavior<V>.h f2673z;

    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2675c;

        a(View view, int i3) {
            this.f2674b = view;
            this.f2675c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.J0(this.f2674b, this.f2675c, false);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f2656i != null) {
                BottomSheetBehavior.this.f2656i.Y(fFloatValue);
            }
        }
    }

    class c implements o.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2678a;

        c(boolean z2) {
            this.f2678a = z2;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0080  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
        @Override // com.google.android.material.internal.o.d
        public c0 a(View view, c0 c0Var, o.e eVar) {
            boolean z2;
            w.b bVarF = c0Var.f(c0.m.c());
            w.b bVarF2 = c0Var.f(c0.m.b());
            BottomSheetBehavior.this.f2670w = bVarF.f6322b;
            boolean zE = o.e(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f2662o) {
                BottomSheetBehavior.this.f2669v = c0Var.h();
                paddingBottom = eVar.f3156d + BottomSheetBehavior.this.f2669v;
            }
            if (BottomSheetBehavior.this.f2663p) {
                paddingLeft = (zE ? eVar.f3155c : eVar.f3153a) + bVarF.f6321a;
            }
            if (BottomSheetBehavior.this.f2664q) {
                paddingRight = (zE ? eVar.f3153a : eVar.f3155c) + bVarF.f6323c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z3 = true;
            if (BottomSheetBehavior.this.f2666s) {
                int i3 = marginLayoutParams.leftMargin;
                int i4 = bVarF.f6321a;
                if (i3 != i4) {
                    marginLayoutParams.leftMargin = i4;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (BottomSheetBehavior.this.f2667t) {
                int i5 = marginLayoutParams.rightMargin;
                int i6 = bVarF.f6323c;
                if (i5 != i6) {
                    marginLayoutParams.rightMargin = i6;
                    z2 = true;
                }
            }
            if (BottomSheetBehavior.this.f2668u) {
                int i7 = marginLayoutParams.topMargin;
                int i8 = bVarF.f6322b;
                if (i7 != i8) {
                    marginLayoutParams.topMargin = i8;
                } else {
                    z3 = z2;
                }
            } else {
                z3 = z2;
            }
            if (z3) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f2678a) {
                BottomSheetBehavior.this.f2660m = bVarF2.f6324d;
            }
            if (BottomSheetBehavior.this.f2662o || this.f2678a) {
                BottomSheetBehavior.this.N0(false);
            }
            return c0Var;
        }
    }

    class d extends j0.c.AbstractC0071c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f2680a;

        d() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.S + bottomSheetBehavior.f0()) / 2;
        }

        @Override // j0.c.AbstractC0071c
        public int a(View view, int i3, int i4) {
            return view.getLeft();
        }

        @Override // j0.c.AbstractC0071c
        public int b(View view, int i3, int i4) {
            int iF0 = BottomSheetBehavior.this.f0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return z.a.b(i3, iF0, bottomSheetBehavior.H ? bottomSheetBehavior.S : bottomSheetBehavior.F);
        }

        @Override // j0.c.AbstractC0071c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.H ? bottomSheetBehavior.S : bottomSheetBehavior.F;
        }

        @Override // j0.c.AbstractC0071c
        public void j(int i3) {
            if (i3 == 1 && BottomSheetBehavior.this.J) {
                BottomSheetBehavior.this.C0(1);
            }
        }

        @Override // j0.c.AbstractC0071c
        public void k(View view, int i3, int i4, int i5, int i6) {
            BottomSheetBehavior.this.c0(i4);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:6:0x0010  */
        @Override // j0.c.AbstractC0071c
        public void l(View view, float f3, float f4) {
            int i3 = 6;
            if (f4 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.H && bottomSheetBehavior.G0(view, f4)) {
                    if ((Math.abs(f3) < Math.abs(f4) && f4 > 500.0f) || n(view)) {
                        i3 = 5;
                    } else if (BottomSheetBehavior.this.f2647b || Math.abs(view.getTop() - BottomSheetBehavior.this.f0()) < Math.abs(view.getTop() - BottomSheetBehavior.this.D)) {
                        i3 = 3;
                    }
                } else if (f4 == 0.0f || Math.abs(f3) > Math.abs(f4)) {
                    int top = view.getTop();
                    if (!BottomSheetBehavior.this.f2647b) {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i4 = bottomSheetBehavior2.D;
                        if (top < i4) {
                            if (top < Math.abs(top - bottomSheetBehavior2.F)) {
                                i3 = 3;
                            } else if (BottomSheetBehavior.this.H0()) {
                                i3 = 4;
                            }
                        } else if (Math.abs(top - i4) >= Math.abs(top - BottomSheetBehavior.this.F) || BottomSheetBehavior.this.H0()) {
                            i3 = 4;
                        }
                    } else if (Math.abs(top - BottomSheetBehavior.this.C) < Math.abs(top - BottomSheetBehavior.this.F)) {
                        i3 = 3;
                    } else {
                        i3 = 4;
                    }
                } else if (BottomSheetBehavior.this.f2647b) {
                    i3 = 4;
                } else {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - BottomSheetBehavior.this.D) >= Math.abs(top2 - BottomSheetBehavior.this.F) || BottomSheetBehavior.this.H0()) {
                        i3 = 4;
                    }
                }
            } else if (BottomSheetBehavior.this.f2647b) {
                i3 = 3;
            } else {
                int top3 = view.getTop();
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f2680a;
                if (BottomSheetBehavior.this.H0()) {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior3.E0(jCurrentTimeMillis, (top3 * 100.0f) / bottomSheetBehavior3.S)) {
                        i3 = 4;
                    }
                } else if (top3 <= BottomSheetBehavior.this.D) {
                }
                i3 = 3;
            }
            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
            bottomSheetBehavior4.J0(view, i3, bottomSheetBehavior4.I0());
        }

        @Override // j0.c.AbstractC0071c
        public boolean m(View view, int i3) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i4 = bottomSheetBehavior.K;
            if (i4 == 1 || bottomSheetBehavior.Z) {
                return false;
            }
            if (i4 == 3 && bottomSheetBehavior.X == i3) {
                WeakReference<View> weakReference = bottomSheetBehavior.U;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f2680a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.T;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class e implements f0.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2682a;

        e(int i3) {
            this.f2682a = i3;
        }

        @Override // f0.g
        public boolean a(View view, f0.g.a aVar) {
            BottomSheetBehavior.this.B0(this.f2682a);
            return true;
        }
    }

    public static abstract class f {
        void a(View view) {
        }

        public abstract void b(View view, float f3);

        public abstract void c(View view, int i3);
    }

    public BottomSheetBehavior() {
        this.f2645a = 0;
        this.f2647b = true;
        this.f2649c = false;
        this.f2658k = -1;
        this.f2659l = -1;
        this.f2673z = new h(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.V = new ArrayList<>();
        this.f2648b0 = -1;
        this.f2650c0 = new d();
    }

    private void D0(View view) {
        boolean z2 = (Build.VERSION.SDK_INT < 29 || i0() || this.f2653f) ? false : true;
        if (this.f2662o || this.f2663p || this.f2664q || this.f2666s || this.f2667t || this.f2668u || z2) {
            o.a(view, new c(z2));
        }
    }

    private boolean F0() {
        return this.M != null && (this.J || this.K == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(View view, int i3, boolean z2) {
        int iG0 = g0(i3);
        j0.c cVar = this.M;
        if (!(cVar != null && (!z2 ? !cVar.H(view, view.getLeft(), iG0) : !cVar.F(view.getLeft(), iG0)))) {
            C0(i3);
            return;
        }
        C0(2);
        L0(i3);
        this.f2673z.c(i3);
    }

    private void K0() {
        V v3;
        WeakReference<V> weakReference = this.T;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        t.g0(v3, 524288);
        t.g0(v3, 262144);
        t.g0(v3, 1048576);
        int i3 = this.f2648b0;
        if (i3 != -1) {
            t.g0(v3, i3);
        }
        if (!this.f2647b && this.K != 6) {
            this.f2648b0 = V(v3, i.bottomsheet_action_expand_halfway, 6);
        }
        if (this.H && this.K != 5) {
            l0(v3, f0.d.a.f4662y, 5);
        }
        int i4 = this.K;
        if (i4 == 3) {
            l0(v3, f0.d.a.f4661x, this.f2647b ? 4 : 6);
            return;
        }
        if (i4 == 4) {
            l0(v3, f0.d.a.f4660w, this.f2647b ? 3 : 6);
        } else {
            if (i4 != 6) {
                return;
            }
            l0(v3, f0.d.a.f4661x, 4);
            l0(v3, f0.d.a.f4660w, 3);
        }
    }

    private void L0(int i3) {
        ValueAnimator valueAnimator;
        if (i3 == 2) {
            return;
        }
        boolean z2 = i3 == 3;
        if (this.f2672y != z2) {
            this.f2672y = z2;
            if (this.f2656i == null || (valueAnimator = this.A) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.A.reverse();
                return;
            }
            float f3 = z2 ? 0.0f : 1.0f;
            this.A.setFloatValues(1.0f - f3, f3);
            this.A.start();
        }
    }

    private void M0(boolean z2) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.T;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z2) {
                if (this.f2646a0 != null) {
                    return;
                } else {
                    this.f2646a0 = new HashMap(childCount);
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (childAt != this.T.get()) {
                    if (z2) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f2646a0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f2649c) {
                            t.v0(childAt, 4);
                        }
                    } else if (this.f2649c && (map = this.f2646a0) != null && map.containsKey(childAt)) {
                        t.v0(childAt, this.f2646a0.get(childAt).intValue());
                    }
                }
            }
            if (!z2) {
                this.f2646a0 = null;
            } else if (this.f2649c) {
                this.T.get().sendAccessibilityEvent(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(boolean z2) {
        V v3;
        if (this.T != null) {
            W();
            if (this.K != 4 || (v3 = this.T.get()) == null) {
                return;
            }
            if (z2) {
                B0(4);
            } else {
                v3.requestLayout();
            }
        }
    }

    private int V(V v3, int i3, int i4) {
        return t.b(v3, v3.getResources().getString(i3), Z(i4));
    }

    private void W() {
        int iY = Y();
        if (this.f2647b) {
            this.F = Math.max(this.S - iY, this.C);
        } else {
            this.F = this.S - iY;
        }
    }

    private void X() {
        this.D = (int) (this.S * (1.0f - this.E));
    }

    private int Y() {
        int iMin;
        int i3;
        int i4;
        if (this.f2653f) {
            iMin = Math.min(Math.max(this.f2654g, this.S - ((this.R * 9) / 16)), this.Q);
            i3 = this.f2669v;
        } else {
            if (!this.f2661n && !this.f2662o && (i4 = this.f2660m) > 0) {
                return Math.max(this.f2652e, i4 + this.f2655h);
            }
            iMin = this.f2652e;
            i3 = this.f2669v;
        }
        return iMin + i3;
    }

    private f0.g Z(int i3) {
        return new e(i3);
    }

    private void a0(Context context) {
        if (this.f2671x == null) {
            return;
        }
        k1.g gVar = new k1.g(this.f2671x);
        this.f2656i = gVar;
        gVar.N(context);
        ColorStateList colorStateList = this.f2657j;
        if (colorStateList != null) {
            this.f2656i.X(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f2656i.setTint(typedValue.data);
    }

    private void b0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.A = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.A.addUpdateListener(new b());
    }

    private int e0(int i3, int i4, int i5, int i6) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, i4, i6);
        if (i5 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i5), 1073741824);
        }
        if (size != 0) {
            i5 = Math.min(size, i5);
        }
        return View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
    }

    private int g0(int i3) {
        if (i3 == 3) {
            return f0();
        }
        if (i3 == 4) {
            return this.F;
        }
        if (i3 == 5) {
            return this.S;
        }
        if (i3 == 6) {
            return this.D;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i3);
    }

    private float h0() {
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f2651d);
        return this.W.getYVelocity(this.X);
    }

    private boolean j0(V v3) {
        ViewParent parent = v3.getParent();
        return parent != null && parent.isLayoutRequested() && t.R(v3);
    }

    private void l0(V v3, f0.d.a aVar, int i3) {
        t.i0(v3, aVar, null, Z(i3));
    }

    private void m0() {
        this.X = -1;
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.W = null;
        }
    }

    private void n0(g gVar) {
        int i3 = this.f2645a;
        if (i3 == 0) {
            return;
        }
        if (i3 == -1 || (i3 & 1) == 1) {
            this.f2652e = gVar.f2685e;
        }
        if (i3 == -1 || (i3 & 2) == 2) {
            this.f2647b = gVar.f2686f;
        }
        if (i3 == -1 || (i3 & 4) == 4) {
            this.H = gVar.f2687g;
        }
        if (i3 == -1 || (i3 & 8) == 8) {
            this.I = gVar.f2688h;
        }
    }

    private void o0(V v3, Runnable runnable) {
        if (j0(v3)) {
            v3.post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i3, int i4) {
        this.O = 0;
        this.P = false;
        return (i3 & 2) != 0;
    }

    public void A0(boolean z2) {
        this.I = z2;
    }

    public void B0(int i3) {
        if (i3 == 1 || i3 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i3 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.H && i3 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i3);
            return;
        }
        int i4 = (i3 == 6 && this.f2647b && g0(i3) <= this.C) ? 3 : i3;
        WeakReference<V> weakReference = this.T;
        if (weakReference == null || weakReference.get() == null) {
            C0(i3);
        } else {
            V v3 = this.T.get();
            o0(v3, new a(v3, i4));
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void C(CoordinatorLayout coordinatorLayout, V v3, View view, int i3) {
        WeakReference<View> weakReference;
        int i4 = 3;
        if (v3.getTop() == f0()) {
            C0(3);
            return;
        }
        if (!k0() || ((weakReference = this.U) != null && view == weakReference.get() && this.P)) {
            if (this.O > 0) {
                if (!this.f2647b && v3.getTop() > this.D) {
                    i4 = 6;
                }
            } else if (this.H && G0(v3, h0())) {
                i4 = 5;
            } else if (this.O == 0) {
                int top = v3.getTop();
                if (!this.f2647b) {
                    int i5 = this.D;
                    if (top < i5) {
                        if (top >= Math.abs(top - this.F)) {
                            if (H0()) {
                                i4 = 4;
                            } else {
                                i4 = 6;
                            }
                        }
                    } else if (Math.abs(top - i5) < Math.abs(top - this.F)) {
                        i4 = 6;
                    } else {
                        i4 = 4;
                    }
                } else if (Math.abs(top - this.C) >= Math.abs(top - this.F)) {
                    i4 = 4;
                }
            } else {
                if (!this.f2647b) {
                    int top2 = v3.getTop();
                    if (Math.abs(top2 - this.D) < Math.abs(top2 - this.F)) {
                        i4 = 6;
                    }
                }
                i4 = 4;
            }
            J0(v3, i4, false);
            this.P = false;
        }
    }

    void C0(int i3) {
        V v3;
        if (this.K == i3) {
            return;
        }
        this.K = i3;
        if (i3 == 4 || i3 == 3 || i3 == 6 || (this.H && i3 == 5)) {
            this.L = i3;
        }
        WeakReference<V> weakReference = this.T;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        if (i3 == 3) {
            M0(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            M0(false);
        }
        L0(i3);
        for (int i4 = 0; i4 < this.V.size(); i4++) {
            this.V.get(i4).c(v3, i3);
        }
        K0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        if (!v3.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.K == 1 && actionMasked == 0) {
            return true;
        }
        if (F0()) {
            this.M.z(motionEvent);
        }
        if (actionMasked == 0) {
            m0();
        }
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(motionEvent);
        if (F0() && actionMasked == 2 && !this.N && Math.abs(this.Y - motionEvent.getY()) > this.M.u()) {
            this.M.b(v3, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.N;
    }

    public boolean E0(long j3, float f3) {
        return false;
    }

    boolean G0(View view, float f3) {
        if (this.I) {
            return true;
        }
        if (view.getTop() < this.F) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f3 * 0.1f)) - ((float) this.F)) / ((float) Y()) > 0.5f;
    }

    public boolean H0() {
        return false;
    }

    public boolean I0() {
        return true;
    }

    void c0(int i3) {
        float f3;
        float fF0;
        V v3 = this.T.get();
        if (v3 == null || this.V.isEmpty()) {
            return;
        }
        int i4 = this.F;
        if (i3 > i4 || i4 == f0()) {
            int i5 = this.F;
            f3 = i5 - i3;
            fF0 = this.S - i5;
        } else {
            int i6 = this.F;
            f3 = i6 - i3;
            fF0 = i6 - f0();
        }
        float f4 = f3 / fF0;
        for (int i7 = 0; i7 < this.V.size(); i7++) {
            this.V.get(i7).b(v3, f4);
        }
    }

    View d0(View view) {
        if (t.T(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View viewD0 = d0(viewGroup.getChildAt(i3));
            if (viewD0 != null) {
                return viewD0;
            }
        }
        return null;
    }

    public int f0() {
        if (this.f2647b) {
            return this.C;
        }
        return Math.max(this.B, this.f2665r ? 0 : this.f2670w);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.T = null;
        this.M = null;
    }

    public boolean i0() {
        return this.f2661n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.T = null;
        this.M = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        j0.c cVar;
        if (!v3.isShown() || !this.J) {
            this.N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m0();
        }
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x3 = (int) motionEvent.getX();
            this.Y = (int) motionEvent.getY();
            if (this.K != 2) {
                WeakReference<View> weakReference = this.U;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.B(view, x3, this.Y)) {
                    this.X = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.Z = true;
                }
            }
            this.N = this.X == -1 && !coordinatorLayout.B(v3, x3, this.Y);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.Z = false;
            this.X = -1;
            if (this.N) {
                this.N = false;
                return false;
            }
        }
        if (!this.N && (cVar = this.M) != null && cVar.G(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.U;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.N || this.K == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || Math.abs(((float) this.Y) - motionEvent.getY()) <= ((float) this.M.u())) ? false : true;
    }

    public boolean k0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        if (t.y(coordinatorLayout) && !t.y(v3)) {
            v3.setFitsSystemWindows(true);
        }
        if (this.T == null) {
            this.f2654g = coordinatorLayout.getResources().getDimensionPixelSize(t0.d.design_bottom_sheet_peek_height_min);
            D0(v3);
            this.T = new WeakReference<>(v3);
            k1.g gVar = this.f2656i;
            if (gVar != null) {
                t.p0(v3, gVar);
                k1.g gVar2 = this.f2656i;
                float fW = this.G;
                if (fW == -1.0f) {
                    fW = t.w(v3);
                }
                gVar2.W(fW);
                boolean z2 = this.K == 3;
                this.f2672y = z2;
                this.f2656i.Y(z2 ? 0.0f : 1.0f);
            } else {
                ColorStateList colorStateList = this.f2657j;
                if (colorStateList != null) {
                    t.q0(v3, colorStateList);
                }
            }
            K0();
            if (t.z(v3) == 0) {
                t.v0(v3, 1);
            }
        }
        if (this.M == null) {
            this.M = j0.c.m(coordinatorLayout, this.f2650c0);
        }
        int top = v3.getTop();
        coordinatorLayout.I(v3, i3);
        this.R = coordinatorLayout.getWidth();
        this.S = coordinatorLayout.getHeight();
        int height = v3.getHeight();
        this.Q = height;
        int i4 = this.S;
        int i5 = i4 - height;
        int i6 = this.f2670w;
        if (i5 < i6) {
            if (this.f2665r) {
                this.Q = i4;
            } else {
                this.Q = i4 - i6;
            }
        }
        this.C = Math.max(0, i4 - this.Q);
        X();
        W();
        int i7 = this.K;
        if (i7 == 3) {
            t.Y(v3, f0());
        } else if (i7 == 6) {
            t.Y(v3, this.D);
        } else if (this.H && i7 == 5) {
            t.Y(v3, this.S);
        } else if (i7 == 4) {
            t.Y(v3, this.F);
        } else if (i7 == 1 || i7 == 2) {
            t.Y(v3, top - v3.getTop());
        }
        this.U = new WeakReference<>(d0(v3));
        for (int i8 = 0; i8 < this.V.size(); i8++) {
            this.V.get(i8).a(v3);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, V v3, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        v3.measure(e0(i3, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, this.f2658k, marginLayoutParams.width), e0(i5, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, this.f2659l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v3, View view, float f3, float f4) {
        WeakReference<View> weakReference;
        if (k0() && (weakReference = this.U) != null && view == weakReference.get()) {
            return this.K != 3 || super.o(coordinatorLayout, v3, view, f3, f4);
        }
        return false;
    }

    public void p0(boolean z2) {
        this.J = z2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.U;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (!k0() || view == view2) {
            int top = v3.getTop();
            int i6 = top - i4;
            if (i4 > 0) {
                if (i6 < f0()) {
                    iArr[1] = top - f0();
                    t.Y(v3, -iArr[1]);
                    C0(3);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i4;
                    t.Y(v3, -i4);
                    C0(1);
                }
            } else if (i4 < 0 && !view.canScrollVertically(-1)) {
                int i7 = this.F;
                if (i6 > i7 && !this.H) {
                    iArr[1] = top - i7;
                    t.Y(v3, -iArr[1]);
                    C0(4);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i4;
                    t.Y(v3, -i4);
                    C0(1);
                }
            }
            c0(v3.getTop());
            this.O = i4;
            this.P = true;
        }
    }

    public void q0(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.B = i3;
    }

    public void r0(boolean z2) {
        if (this.f2647b == z2) {
            return;
        }
        this.f2647b = z2;
        if (this.T != null) {
            W();
        }
        C0((this.f2647b && this.K == 6) ? 3 : this.K);
        K0();
    }

    public void s0(boolean z2) {
        this.f2661n = z2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
    }

    public void t0(float f3) {
        if (f3 <= 0.0f || f3 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.E = f3;
        if (this.T != null) {
            X();
        }
    }

    public void u0(boolean z2) {
        if (this.H != z2) {
            this.H = z2;
            if (!z2 && this.K == 5) {
                B0(4);
            }
            K0();
        }
    }

    public void v0(int i3) {
        this.f2659l = i3;
    }

    public void w0(int i3) {
        this.f2658k = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v3, Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.x(coordinatorLayout, v3, gVar.j());
        n0(gVar);
        int i3 = gVar.f2684d;
        if (i3 == 1 || i3 == 2) {
            this.K = 4;
            this.L = 4;
        } else {
            this.K = i3;
            this.L = i3;
        }
    }

    public void x0(int i3) {
        y0(i3, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v3) {
        return new g(super.y(coordinatorLayout, v3), (BottomSheetBehavior<?>) this);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    public final void y0(int i3, boolean z2) {
        boolean z3 = true;
        if (i3 == -1) {
            if (this.f2653f) {
                z3 = false;
            } else {
                this.f2653f = true;
            }
        } else if (this.f2653f || this.f2652e != i3) {
            this.f2653f = false;
            this.f2652e = Math.max(0, i3);
        } else {
            z3 = false;
        }
        if (z3) {
            N0(z2);
        }
    }

    public void z0(int i3) {
        this.f2645a = i3;
    }

    private class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f2691c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f2690b = false;
                j0.c cVar = BottomSheetBehavior.this.M;
                if (cVar != null && cVar.k(true)) {
                    h hVar = h.this;
                    hVar.c(hVar.f2689a);
                    return;
                }
                h hVar2 = h.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.K == 2) {
                    bottomSheetBehavior.C0(hVar2.f2689a);
                }
            }
        }

        private h() {
            this.f2691c = new a();
        }

        void c(int i3) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.T;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f2689a = i3;
            if (this.f2690b) {
                return;
            }
            t.e0(BottomSheetBehavior.this.T.get(), this.f2691c);
            this.f2690b = true;
        }

        /* synthetic */ h(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    protected static class g extends i0.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f2684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2685e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f2686f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f2687g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f2688h;

        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2684d = parcel.readInt();
            this.f2685e = parcel.readInt();
            this.f2686f = parcel.readInt() == 1;
            this.f2687g = parcel.readInt() == 1;
            this.f2688h = parcel.readInt() == 1;
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f2684d);
            parcel.writeInt(this.f2685e);
            parcel.writeInt(this.f2686f ? 1 : 0);
            parcel.writeInt(this.f2687g ? 1 : 0);
            parcel.writeInt(this.f2688h ? 1 : 0);
        }

        public g(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f2684d = bottomSheetBehavior.K;
            this.f2685e = ((BottomSheetBehavior) bottomSheetBehavior).f2652e;
            this.f2686f = ((BottomSheetBehavior) bottomSheetBehavior).f2647b;
            this.f2687g = bottomSheetBehavior.H;
            this.f2688h = ((BottomSheetBehavior) bottomSheetBehavior).I;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i3;
        super(context, attributeSet);
        this.f2645a = 0;
        this.f2647b = true;
        this.f2649c = false;
        this.f2658k = -1;
        this.f2659l = -1;
        this.f2673z = new h(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.V = new ArrayList<>();
        this.f2648b0 = -1;
        this.f2650c0 = new d();
        this.f2655h = context.getResources().getDimensionPixelSize(t0.d.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.k.BottomSheetBehavior_Layout);
        int i4 = t0.k.BottomSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f2657j = h1.c.a(context, typedArrayObtainStyledAttributes, i4);
        }
        if (typedArrayObtainStyledAttributes.hasValue(t0.k.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.f2671x = k.e(context, attributeSet, t0.b.bottomSheetStyle, f2644d0).m();
        }
        a0(context);
        b0();
        if (Build.VERSION.SDK_INT >= 21) {
            this.G = typedArrayObtainStyledAttributes.getDimension(t0.k.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        int i5 = t0.k.BottomSheetBehavior_Layout_android_maxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            w0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i5, -1));
        }
        int i6 = t0.k.BottomSheetBehavior_Layout_android_maxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            v0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = t0.k.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i7);
        if (typedValuePeekValue != null && (i3 = typedValuePeekValue.data) == -1) {
            x0(i3);
        } else {
            x0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        u0(typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_behavior_hideable, false));
        s0(typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        r0(typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        A0(typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        p0(typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_behavior_draggable, true));
        z0(typedArrayObtainStyledAttributes.getInt(t0.k.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        t0(typedArrayObtainStyledAttributes.getFloat(t0.k.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i8 = t0.k.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i8);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            q0(typedValuePeekValue2.data);
        } else {
            q0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i8, 0));
        }
        this.f2662o = typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f2663p = typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f2664q = typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f2665r = typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.f2666s = typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.f2667t = typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.f2668u = typedArrayObtainStyledAttributes.getBoolean(t0.k.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f2651d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
