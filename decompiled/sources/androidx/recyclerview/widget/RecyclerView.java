package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.vivo.seckeysdk.BuildConfig;
import com.vivo.seckeysdk.SecurityKeyCipher;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements e0.j {
    static final boolean A0;
    static final boolean B0;
    static final boolean C0;
    static final boolean D0;
    private static final boolean E0;
    private static final boolean F0;
    private static final Class<?>[] G0;
    static final Interpolator H0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final int[] f1734z0 = {R.attr.nestedScrollingEnabled};
    private int A;
    boolean B;
    private final AccessibilityManager C;
    private List<q> D;
    boolean E;
    boolean F;
    private int G;
    private int H;
    private k I;
    private EdgeEffect J;
    private EdgeEffect K;
    private EdgeEffect L;
    private EdgeEffect M;
    l N;
    private int O;
    private int P;
    private VelocityTracker Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private r W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final int f1735a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f1736b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final int f1737b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final v f1738c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f1739c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private y f1740d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f1741d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    androidx.recyclerview.widget.a f1742e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f1743e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    androidx.recyclerview.widget.b f1744f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    final c0 f1745f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final androidx.recyclerview.widget.p f1746g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    androidx.recyclerview.widget.e f1747g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f1748h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    androidx.recyclerview.widget.e.b f1749h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Runnable f1750i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    final a0 f1751i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Rect f1752j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private t f1753j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Rect f1754k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private List<t> f1755k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final RectF f1756l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    boolean f1757l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    g f1758m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    boolean f1759m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    o f1760n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private l.b f1761n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    w f1762o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    boolean f1763o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final ArrayList<n> f1764p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    androidx.recyclerview.widget.k f1765p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ArrayList<s> f1766q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private j f1767q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private s f1768r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final int[] f1769r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f1770s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private e0.k f1771s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f1772t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final int[] f1773t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f1774u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final int[] f1775u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f1776v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    final int[] f1777v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1778w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    final List<d0> f1779w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f1780x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private Runnable f1781x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f1782y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private final androidx.recyclerview.widget.p.b f1783y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1784z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f1776v || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f1770s) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f1782y) {
                recyclerView2.f1780x = true;
            } else {
                recyclerView2.u();
            }
        }
    }

    public static class a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f1787b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f1798m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f1799n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f1800o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f1801p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f1802q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1786a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1788c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1789d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1790e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1791f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f1792g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f1793h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f1794i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1795j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f1796k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f1797l = false;

        void a(int i3) {
            if ((this.f1790e & i3) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i3) + " but it is " + Integer.toBinaryString(this.f1790e));
        }

        public int b() {
            return this.f1793h ? this.f1788c - this.f1789d : this.f1791f;
        }

        public int c() {
            return this.f1786a;
        }

        public boolean d() {
            return this.f1786a != -1;
        }

        public boolean e() {
            return this.f1793h;
        }

        void f(g gVar) {
            this.f1790e = 1;
            this.f1791f = gVar.e();
            this.f1793h = false;
            this.f1794i = false;
            this.f1795j = false;
        }

        public boolean g() {
            return this.f1797l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1786a + ", mData=" + this.f1787b + ", mItemCount=" + this.f1791f + ", mIsMeasuring=" + this.f1795j + ", mPreviousLayoutItemCount=" + this.f1788c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1789d + ", mStructureChanged=" + this.f1792g + ", mInPreLayout=" + this.f1793h + ", mRunSimpleAnimations=" + this.f1796k + ", mRunPredictiveAnimations=" + this.f1797l + '}';
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.N;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.f1763o0 = false;
        }
    }

    public static abstract class b0 {
    }

    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }

    class c0 implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        OverScroller f1806d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Interpolator f1807e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1808f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1809g;

        c0() {
            Interpolator interpolator = RecyclerView.H0;
            this.f1807e = interpolator;
            this.f1808f = false;
            this.f1809g = false;
            this.f1806d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i3, int i4, int i5, int i6) {
            int iRound;
            int iAbs = Math.abs(i3);
            int iAbs2 = Math.abs(i4);
            boolean z2 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i5 * i5) + (i6 * i6));
            int iSqrt2 = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i7 = width / 2;
            float f3 = width;
            float f4 = i7;
            float fB = f4 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f3)) * f4);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z2) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f3) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        private float b(float f3) {
            return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            e0.t.e0(RecyclerView.this, this);
        }

        public void c(int i3, int i4) {
            RecyclerView.this.setScrollState(2);
            this.f1805c = 0;
            this.f1804b = 0;
            Interpolator interpolator = this.f1807e;
            Interpolator interpolator2 = RecyclerView.H0;
            if (interpolator != interpolator2) {
                this.f1807e = interpolator2;
                this.f1806d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f1806d.fling(0, 0, i3, i4, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.f1808f) {
                this.f1809g = true;
            } else {
                d();
            }
        }

        public void f(int i3, int i4, int i5, Interpolator interpolator) {
            if (i5 == Integer.MIN_VALUE) {
                i5 = a(i3, i4, 0, 0);
            }
            int i6 = i5;
            if (interpolator == null) {
                interpolator = RecyclerView.H0;
            }
            if (this.f1807e != interpolator) {
                this.f1807e = interpolator;
                this.f1806d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1805c = 0;
            this.f1804b = 0;
            RecyclerView.this.setScrollState(2);
            this.f1806d.startScroll(0, 0, i3, i4, i6);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1806d.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f1806d.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i4;
            int i5;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1760n == null) {
                g();
                return;
            }
            this.f1809g = false;
            this.f1808f = true;
            recyclerView.u();
            OverScroller overScroller = this.f1806d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.f1804b;
                int i7 = currY - this.f1805c;
                this.f1804b = currX;
                this.f1805c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f1777v0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.F(i6, i7, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f1777v0;
                    i6 -= iArr2[0];
                    i7 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.t(i6, i7);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f1758m != null) {
                    int[] iArr3 = recyclerView3.f1777v0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.h1(i6, i7, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f1777v0;
                    i4 = iArr4[0];
                    i3 = iArr4[1];
                    i6 -= i4;
                    i7 -= i3;
                    z zVar = recyclerView4.f1760n.f1852g;
                    if (zVar != null && !zVar.g() && zVar.h()) {
                        int iB = RecyclerView.this.f1751i0.b();
                        if (iB == 0) {
                            zVar.r();
                        } else if (zVar.f() >= iB) {
                            zVar.p(iB - 1);
                            zVar.j(i4, i3);
                        } else {
                            zVar.j(i4, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.f1764p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f1777v0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.G(i4, i3, i6, i7, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f1777v0;
                int i8 = i6 - iArr6[0];
                int i9 = i7 - iArr6[1];
                if (i4 != 0 || i3 != 0) {
                    recyclerView6.I(i4, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i8 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i9 != 0));
                z zVar2 = RecyclerView.this.f1760n.f1852g;
                if ((zVar2 != null && zVar2.g()) || !z2) {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView7.f1747g0;
                    if (eVar != null) {
                        eVar.f(recyclerView7, i4, i3);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i8 < 0) {
                            i5 = -currVelocity;
                        } else {
                            i5 = i8 > 0 ? currVelocity : 0;
                        }
                        if (i9 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i9 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i5, currVelocity);
                    }
                    if (RecyclerView.D0) {
                        RecyclerView.this.f1749h0.b();
                    }
                }
            }
            z zVar3 = RecyclerView.this.f1760n.f1852g;
            if (zVar3 != null && zVar3.g()) {
                zVar3.j(0, 0);
            }
            this.f1808f = false;
            if (this.f1809g) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.u1(1);
            }
        }
    }

    class d implements androidx.recyclerview.widget.p.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1760n.m1(d0Var.f1813a, recyclerView.f1738c);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.l(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f1738c.J(d0Var);
            RecyclerView.this.n(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(d0 d0Var, l.c cVar, l.c cVar2) {
            d0Var.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.E) {
                if (recyclerView.N.b(d0Var, d0Var, cVar, cVar2)) {
                    RecyclerView.this.N0();
                }
            } else if (recyclerView.N.d(d0Var, cVar, cVar2)) {
                RecyclerView.this.N0();
            }
        }
    }

    public static abstract class d0 {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final List<Object> f1812s = Collections.emptyList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f1814b;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f1822j;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        RecyclerView f1830r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1815c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1816d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f1817e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1818f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1819g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        d0 f1820h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        d0 f1821i = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        List<Object> f1823k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List<Object> f1824l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f1825m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        v f1826n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f1827o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f1828p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f1829q = -1;

        public d0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1813a = view;
        }

        private void g() {
            if (this.f1823k == null) {
                ArrayList arrayList = new ArrayList();
                this.f1823k = arrayList;
                this.f1824l = Collections.unmodifiableList(arrayList);
            }
        }

        void A(int i3, boolean z2) {
            if (this.f1816d == -1) {
                this.f1816d = this.f1815c;
            }
            if (this.f1819g == -1) {
                this.f1819g = this.f1815c;
            }
            if (z2) {
                this.f1819g += i3;
            }
            this.f1815c += i3;
            if (this.f1813a.getLayoutParams() != null) {
                ((p) this.f1813a.getLayoutParams()).f1872c = true;
            }
        }

        void B(RecyclerView recyclerView) {
            int i3 = this.f1829q;
            if (i3 != -1) {
                this.f1828p = i3;
            } else {
                this.f1828p = e0.t.z(this.f1813a);
            }
            recyclerView.k1(this, 4);
        }

        void C(RecyclerView recyclerView) {
            recyclerView.k1(this, this.f1828p);
            this.f1828p = 0;
        }

        void D() {
            this.f1822j = 0;
            this.f1815c = -1;
            this.f1816d = -1;
            this.f1817e = -1L;
            this.f1819g = -1;
            this.f1825m = 0;
            this.f1820h = null;
            this.f1821i = null;
            d();
            this.f1828p = 0;
            this.f1829q = -1;
            RecyclerView.r(this);
        }

        void E() {
            if (this.f1816d == -1) {
                this.f1816d = this.f1815c;
            }
        }

        void F(int i3, int i4) {
            this.f1822j = (i3 & i4) | (this.f1822j & (~i4));
        }

        public final void G(boolean z2) {
            int i3 = this.f1825m;
            int i4 = z2 ? i3 - 1 : i3 + 1;
            this.f1825m = i4;
            if (i4 < 0) {
                this.f1825m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z2 && i4 == 1) {
                this.f1822j |= 16;
            } else if (z2 && i4 == 0) {
                this.f1822j &= -17;
            }
        }

        void H(v vVar, boolean z2) {
            this.f1826n = vVar;
            this.f1827o = z2;
        }

        boolean I() {
            return (this.f1822j & 16) != 0;
        }

        boolean J() {
            return (this.f1822j & 128) != 0;
        }

        void K() {
            this.f1826n.J(this);
        }

        boolean L() {
            return (this.f1822j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f1822j) == 0) {
                g();
                this.f1823k.add(obj);
            }
        }

        void b(int i3) {
            this.f1822j = i3 | this.f1822j;
        }

        void c() {
            this.f1816d = -1;
            this.f1819g = -1;
        }

        void d() {
            List<Object> list = this.f1823k;
            if (list != null) {
                list.clear();
            }
            this.f1822j &= -1025;
        }

        void e() {
            this.f1822j &= -33;
        }

        void f() {
            this.f1822j &= -257;
        }

        boolean h() {
            return (this.f1822j & 16) == 0 && e0.t.P(this.f1813a);
        }

        void i(int i3, int i4, boolean z2) {
            b(8);
            A(i4, z2);
            this.f1815c = i3;
        }

        public final int j() {
            RecyclerView recyclerView = this.f1830r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b0(this);
        }

        public final long k() {
            return this.f1817e;
        }

        public final int l() {
            return this.f1818f;
        }

        public final int m() {
            int i3 = this.f1819g;
            return i3 == -1 ? this.f1815c : i3;
        }

        public final int n() {
            return this.f1816d;
        }

        List<Object> o() {
            if ((this.f1822j & 1024) != 0) {
                return f1812s;
            }
            List<Object> list = this.f1823k;
            return (list == null || list.size() == 0) ? f1812s : this.f1824l;
        }

        boolean p(int i3) {
            return (this.f1822j & i3) != 0;
        }

        boolean q() {
            return (this.f1822j & 512) != 0 || t();
        }

        boolean r() {
            return (this.f1813a.getParent() == null || this.f1813a.getParent() == this.f1830r) ? false : true;
        }

        boolean s() {
            return (this.f1822j & 1) != 0;
        }

        boolean t() {
            return (this.f1822j & 4) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1815c + " id=" + this.f1817e + ", oldPos=" + this.f1816d + ", pLpos:" + this.f1819g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.f1827o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.f1825m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1813a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.f1822j & 16) == 0 && !e0.t.P(this.f1813a);
        }

        boolean v() {
            return (this.f1822j & 8) != 0;
        }

        boolean w() {
            return this.f1826n != null;
        }

        boolean x() {
            return (this.f1822j & 256) != 0;
        }

        boolean y() {
            return (this.f1822j & 2) != 0;
        }

        boolean z() {
            return (this.f1822j & 2) != 0;
        }
    }

    class e implements androidx.recyclerview.widget.b.InterfaceC0019b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public View a(int i3) {
            return RecyclerView.this.getChildAt(i3);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public void b(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 != null) {
                d0VarG0.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public void c(int i3) {
            View childAt = RecyclerView.this.getChildAt(i3);
            if (childAt != null) {
                RecyclerView.this.z(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i3);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public void d() {
            int iK = k();
            for (int i3 = 0; i3 < iK; i3++) {
                View viewA = a(i3);
                RecyclerView.this.z(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public d0 e(View view) {
            return RecyclerView.g0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public void f(int i3) {
            d0 d0VarG0;
            View viewA = a(i3);
            if (viewA != null && (d0VarG0 = RecyclerView.g0(viewA)) != null) {
                if (d0VarG0.x() && !d0VarG0.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + d0VarG0 + RecyclerView.this.P());
                }
                d0VarG0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i3);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public void g(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 != null) {
                d0VarG0.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public void h(View view, int i3, ViewGroup.LayoutParams layoutParams) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 != null) {
                if (!d0VarG0.x() && !d0VarG0.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + d0VarG0 + RecyclerView.this.P());
                }
                d0VarG0.f();
            }
            RecyclerView.this.attachViewToParent(view, i3, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public void i(View view, int i3) {
            RecyclerView.this.addView(view, i3);
            RecyclerView.this.y(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public int j(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0019b
        public int k() {
            return RecyclerView.this.getChildCount();
        }
    }

    class f implements androidx.recyclerview.widget.a.InterfaceC0018a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public void a(int i3, int i4) {
            RecyclerView.this.D0(i3, i4);
            RecyclerView.this.f1757l0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public void b(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public d0 c(int i3) {
            d0 d0VarZ = RecyclerView.this.Z(i3, true);
            if (d0VarZ == null || RecyclerView.this.f1744f.n(d0VarZ.f1813a)) {
                return null;
            }
            return d0VarZ;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public void d(int i3, int i4) {
            RecyclerView.this.E0(i3, i4, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1757l0 = true;
            recyclerView.f1751i0.f1789d += i4;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public void e(int i3, int i4) {
            RecyclerView.this.E0(i3, i4, false);
            RecyclerView.this.f1757l0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public void f(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public void g(int i3, int i4) {
            RecyclerView.this.C0(i3, i4);
            RecyclerView.this.f1757l0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0018a
        public void h(int i3, int i4, Object obj) {
            RecyclerView.this.x1(i3, i4, obj);
            RecyclerView.this.f1759m0 = true;
        }

        void i(androidx.recyclerview.widget.a.b bVar) {
            int i3 = bVar.f1953a;
            if (i3 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f1760n.R0(recyclerView, bVar.f1954b, bVar.f1956d);
                return;
            }
            if (i3 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f1760n.U0(recyclerView2, bVar.f1954b, bVar.f1956d);
            } else if (i3 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f1760n.W0(recyclerView3, bVar.f1954b, bVar.f1956d, bVar.f1955c);
            } else {
                if (i3 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f1760n.T0(recyclerView4, bVar.f1954b, bVar.f1956d, 1);
            }
        }
    }

    public static abstract class g<VH extends d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f1833a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1834b = false;

        public final void c(VH vh, int i3) {
            vh.f1815c = i3;
            if (i()) {
                vh.f1817e = f(i3);
            }
            vh.F(1, 519);
            a0.c.a("RV OnBindView");
            n(vh, i3, vh.o());
            vh.d();
            ViewGroup.LayoutParams layoutParams = vh.f1813a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f1872c = true;
            }
            a0.c.b();
        }

        public final VH d(ViewGroup viewGroup, int i3) {
            try {
                a0.c.a("RV CreateView");
                VH vh = (VH) o(viewGroup, i3);
                if (vh.f1813a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.f1818f = i3;
                a0.c.b();
                return vh;
            } catch (Throwable th) {
                a0.c.b();
                throw th;
            }
        }

        public abstract int e();

        public long f(int i3) {
            return -1L;
        }

        public int g(int i3) {
            return 0;
        }

        public final boolean h() {
            return this.f1833a.a();
        }

        public final boolean i() {
            return this.f1834b;
        }

        public final void j() {
            this.f1833a.b();
        }

        public final void k(int i3, Object obj) {
            this.f1833a.c(i3, 1, obj);
        }

        public void l(RecyclerView recyclerView) {
        }

        public abstract void m(VH vh, int i3);

        public void n(VH vh, int i3, List<Object> list) {
            m(vh, i3);
        }

        public abstract VH o(ViewGroup viewGroup, int i3);

        public void p(RecyclerView recyclerView) {
        }

        public boolean q(VH vh) {
            return false;
        }

        public void r(VH vh) {
        }

        public void s(VH vh) {
        }

        public void t(VH vh) {
        }

        public void u(i iVar) {
            this.f1833a.registerObserver(iVar);
        }

        public void v(boolean z2) {
            if (h()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f1834b = z2;
        }

        public void w(i iVar) {
            this.f1833a.unregisterObserver(iVar);
        }
    }

    static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i3, int i4, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i3, i4, obj);
            }
        }
    }

    public static abstract class i {
        public void a() {
        }

        public void b(int i3, int i4) {
        }

        public void c(int i3, int i4, Object obj) {
            b(i3, i4);
        }
    }

    public interface j {
        int a(int i3, int i4);
    }

    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i3) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f1835a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<a> f1836b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1837c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f1838d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f1839e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f1840f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(d0 d0Var);
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1841a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1842b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1843c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f1844d;

            public c a(d0 d0Var) {
                return b(d0Var, 0);
            }

            public c b(d0 d0Var, int i3) {
                View view = d0Var.f1813a;
                this.f1841a = view.getLeft();
                this.f1842b = view.getTop();
                this.f1843c = view.getRight();
                this.f1844d = view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i3 = d0Var.f1822j & 14;
            if (d0Var.t()) {
                return 4;
            }
            if ((i3 & 4) != 0) {
                return i3;
            }
            int iN = d0Var.n();
            int iJ = d0Var.j();
            return (iN == -1 || iJ == -1 || iN == iJ) ? i3 : i3 | SecurityKeyCipher.SECURITY_DATA_SIZE_MAX;
        }

        public abstract boolean a(d0 d0Var, c cVar, c cVar2);

        public abstract boolean b(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public abstract boolean c(d0 d0Var, c cVar, c cVar2);

        public abstract boolean d(d0 d0Var, c cVar, c cVar2);

        public abstract boolean f(d0 d0Var);

        public boolean g(d0 d0Var, List<Object> list) {
            return f(d0Var);
        }

        public final void h(d0 d0Var) {
            r(d0Var);
            b bVar = this.f1835a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public final void i() {
            int size = this.f1836b.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f1836b.get(i3).a();
            }
            this.f1836b.clear();
        }

        public abstract void j(d0 d0Var);

        public abstract void k();

        public long l() {
            return this.f1837c;
        }

        public long m() {
            return this.f1840f;
        }

        public long n() {
            return this.f1839e;
        }

        public long o() {
            return this.f1838d;
        }

        public abstract boolean p();

        public c q() {
            return new c();
        }

        public void r(d0 d0Var) {
        }

        public c s(a0 a0Var, d0 d0Var) {
            return q().a(d0Var);
        }

        public c t(a0 a0Var, d0 d0Var, int i3, List<Object> list) {
            return q().a(d0Var);
        }

        public abstract void u();

        void v(b bVar) {
            this.f1835a = bVar;
        }
    }

    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(d0 d0Var) {
            d0Var.G(true);
            if (d0Var.f1820h != null && d0Var.f1821i == null) {
                d0Var.f1820h = null;
            }
            d0Var.f1821i = null;
            if (d0Var.I() || RecyclerView.this.W0(d0Var.f1813a) || !d0Var.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.f1813a, false);
        }
    }

    public static abstract class n {
        @Deprecated
        public void d(Rect rect, int i3, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            d(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            f(canvas, recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            h(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.b f1846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView f1847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.recyclerview.widget.o.b f1848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final androidx.recyclerview.widget.o.b f1849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        androidx.recyclerview.widget.o f1850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        androidx.recyclerview.widget.o f1851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        z f1852g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f1853h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f1854i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1855j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f1856k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f1857l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f1858m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f1859n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f1860o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f1861p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f1862q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f1863r;

        class a implements androidx.recyclerview.widget.o.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i3) {
                return o.this.I(i3);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.o0() - o.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }
        }

        class b implements androidx.recyclerview.widget.o.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i3) {
                return o.this.I(i3);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.W() - o.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.g0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
            void a(int i3, int i4);
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1866a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1867b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f1868c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f1869d;
        }

        public o() {
            a aVar = new a();
            this.f1848c = aVar;
            b bVar = new b();
            this.f1849d = bVar;
            this.f1850e = new androidx.recyclerview.widget.o(aVar);
            this.f1851f = new androidx.recyclerview.widget.o(bVar);
            this.f1853h = false;
            this.f1854i = false;
            this.f1855j = false;
            this.f1856k = true;
            this.f1857l = true;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x001c  */
        /* JADX WARN: Code duplicated, block: B:14:0x0020  */
        /* JADX WARN: Code duplicated, block: B:21:0x002f  */
        public static int K(int i3, int i4, int i5, int i6, boolean z2) {
            int iMax = Math.max(0, i3 - i5);
            if (z2) {
                if (i6 >= 0) {
                    i4 = 1073741824;
                } else if (i6 != -1 || (i4 != Integer.MIN_VALUE && (i4 == 0 || i4 != 1073741824))) {
                    i4 = 0;
                    i6 = 0;
                } else {
                    i6 = iMax;
                }
            } else if (i6 >= 0) {
                i4 = 1073741824;
            } else if (i6 == -1) {
                i6 = iMax;
            } else if (i6 != -2) {
                i4 = 0;
                i6 = 0;
            } else if (i4 == Integer.MIN_VALUE || i4 == 1073741824) {
                i6 = iMax;
                i4 = Integer.MIN_VALUE;
            } else {
                i6 = iMax;
                i4 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i6, i4);
        }

        private int[] L(View view, Rect rect) {
            int[] iArr = new int[2];
            int iE0 = e0();
            int iG0 = g0();
            int iO0 = o0() - f0();
            int iW = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i3 = left - iE0;
            int iMin = Math.min(0, i3);
            int i4 = top - iG0;
            int iMin2 = Math.min(0, i4);
            int i5 = iWidth - iO0;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, iHeight - iW);
            if (Z() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i3, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i5);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i4, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        private void f(View view, int i3, boolean z2) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (z2 || d0VarG0.v()) {
                this.f1847b.f1746g.b(d0VarG0);
            } else {
                this.f1847b.f1746g.p(d0VarG0);
            }
            p pVar = (p) view.getLayoutParams();
            if (d0VarG0.L() || d0VarG0.w()) {
                if (d0VarG0.w()) {
                    d0VarG0.K();
                } else {
                    d0VarG0.e();
                }
                this.f1846a.c(view, i3, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1847b) {
                int iM = this.f1846a.m(view);
                if (i3 == -1) {
                    i3 = this.f1846a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1847b.indexOfChild(view) + this.f1847b.P());
                }
                if (iM != i3) {
                    this.f1847b.f1760n.B0(iM, i3);
                }
            } else {
                this.f1846a.a(view, i3, false);
                pVar.f1872c = true;
                z zVar = this.f1852g;
                if (zVar != null && zVar.h()) {
                    this.f1852g.k(view);
                }
            }
            if (pVar.f1873d) {
                d0VarG0.f1813a.invalidate();
                pVar.f1873d = false;
            }
        }

        public static d i0(Context context, AttributeSet attributeSet, int i3, int i4) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o0.c.RecyclerView, i3, i4);
            dVar.f1866a = typedArrayObtainStyledAttributes.getInt(o0.c.RecyclerView_android_orientation, 1);
            dVar.f1867b = typedArrayObtainStyledAttributes.getInt(o0.c.RecyclerView_spanCount, 1);
            dVar.f1868c = typedArrayObtainStyledAttributes.getBoolean(o0.c.RecyclerView_reverseLayout, false);
            dVar.f1869d = typedArrayObtainStyledAttributes.getBoolean(o0.c.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i4, i5) : size;
            }
            return Math.min(size, Math.max(i4, i5));
        }

        private boolean t0(RecyclerView recyclerView, int i3, int i4) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iE0 = e0();
            int iG0 = g0();
            int iO0 = o0() - f0();
            int iW = W() - d0();
            Rect rect = this.f1847b.f1752j;
            P(focusedChild, rect);
            return rect.left - i3 < iO0 && rect.right - i3 > iE0 && rect.top - i4 < iW && rect.bottom - i4 > iG0;
        }

        private void v1(v vVar, int i3, View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0.J()) {
                return;
            }
            if (d0VarG0.t() && !d0VarG0.v() && !this.f1847b.f1758m.i()) {
                q1(i3);
                vVar.C(d0VarG0);
            } else {
                x(i3);
                vVar.D(view);
                this.f1847b.f1746g.k(d0VarG0);
            }
        }

        private static boolean w0(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (i5 > 0 && i3 != i5) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i3;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i3;
            }
            return true;
        }

        private void y(int i3, View view) {
            this.f1846a.d(i3);
        }

        void A(RecyclerView recyclerView, v vVar) {
            this.f1854i = false;
            I0(recyclerView, vVar);
        }

        public void A0(View view, int i3, int i4) {
            p pVar = (p) view.getLayoutParams();
            Rect rectK0 = this.f1847b.k0(view);
            int i5 = i3 + rectK0.left + rectK0.right;
            int i6 = i4 + rectK0.top + rectK0.bottom;
            int iK = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i5, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int iK2 = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i6, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (F1(view, iK, iK2, pVar)) {
                view.measure(iK, iK2);
            }
        }

        void A1(int i3, int i4) {
            this.f1862q = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            this.f1860o = mode;
            if (mode == 0 && !RecyclerView.B0) {
                this.f1862q = 0;
            }
            this.f1863r = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f1861p = mode2;
            if (mode2 != 0 || RecyclerView.B0) {
                return;
            }
            this.f1863r = 0;
        }

        public View B(View view) {
            View viewR;
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView == null || (viewR = recyclerView.R(view)) == null || this.f1846a.n(viewR)) {
                return null;
            }
            return viewR;
        }

        public void B0(int i3, int i4) {
            View viewI = I(i3);
            if (viewI != null) {
                x(i3);
                h(viewI, i4);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i3 + this.f1847b.toString());
            }
        }

        public void B1(int i3, int i4) {
            this.f1847b.setMeasuredDimension(i3, i4);
        }

        public View C(int i3) {
            int iJ = J();
            for (int i4 = 0; i4 < iJ; i4++) {
                View viewI = I(i4);
                d0 d0VarG0 = RecyclerView.g0(viewI);
                if (d0VarG0 != null && d0VarG0.m() == i3 && !d0VarG0.J() && (this.f1847b.f1751i0.e() || !d0VarG0.v())) {
                    return viewI;
                }
            }
            return null;
        }

        public void C0(int i3) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                recyclerView.A0(i3);
            }
        }

        public void C1(Rect rect, int i3, int i4) {
            B1(n(i3, rect.width() + e0() + f0(), c0()), n(i4, rect.height() + g0() + d0(), b0()));
        }

        public abstract p D();

        public void D0(int i3) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                recyclerView.B0(i3);
            }
        }

        void D1(int i3, int i4) {
            int iJ = J();
            if (iJ == 0) {
                this.f1847b.w(i3, i4);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MIN_VALUE;
            for (int i9 = 0; i9 < iJ; i9++) {
                View viewI = I(i9);
                Rect rect = this.f1847b.f1752j;
                P(viewI, rect);
                int i10 = rect.left;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.right;
                if (i11 > i5) {
                    i5 = i11;
                }
                int i12 = rect.top;
                if (i12 < i7) {
                    i7 = i12;
                }
                int i13 = rect.bottom;
                if (i13 > i8) {
                    i8 = i13;
                }
            }
            this.f1847b.f1752j.set(i6, i7, i5, i8);
            C1(this.f1847b.f1752j, i3, i4);
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void E0(g gVar, g gVar2) {
        }

        void E1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1847b = null;
                this.f1846a = null;
                this.f1862q = 0;
                this.f1863r = 0;
            } else {
                this.f1847b = recyclerView;
                this.f1846a = recyclerView.f1744f;
                this.f1862q = recyclerView.getWidth();
                this.f1863r = recyclerView.getHeight();
            }
            this.f1860o = 1073741824;
            this.f1861p = 1073741824;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean F0(RecyclerView recyclerView, ArrayList<View> arrayList, int i3, int i4) {
            return false;
        }

        boolean F1(View view, int i3, int i4, p pVar) {
            return (!view.isLayoutRequested() && this.f1856k && w0(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getHeight(), i4, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        boolean G1() {
            return false;
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).f1871b.bottom;
        }

        @Deprecated
        public void H0(RecyclerView recyclerView) {
        }

        boolean H1(View view, int i3, int i4, p pVar) {
            return (this.f1856k && w0(view.getMeasuredWidth(), i3, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getMeasuredHeight(), i4, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View I(int i3) {
            androidx.recyclerview.widget.b bVar = this.f1846a;
            if (bVar != null) {
                return bVar.f(i3);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView, v vVar) {
            H0(recyclerView);
        }

        public void I1(RecyclerView recyclerView, a0 a0Var, int i3) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int J() {
            androidx.recyclerview.widget.b bVar = this.f1846a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View J0(View view, int i3, v vVar, a0 a0Var) {
            return null;
        }

        public void J1(z zVar) {
            z zVar2 = this.f1852g;
            if (zVar2 != null && zVar != zVar2 && zVar2.h()) {
                this.f1852g.r();
            }
            this.f1852g = zVar;
            zVar.q(this.f1847b, this);
        }

        public void K0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1847b;
            L0(recyclerView.f1738c, recyclerView.f1751i0, accessibilityEvent);
        }

        void K1() {
            z zVar = this.f1852g;
            if (zVar != null) {
                zVar.r();
            }
        }

        public void L0(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z2 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f1847b.canScrollVertically(-1) && !this.f1847b.canScrollHorizontally(-1) && !this.f1847b.canScrollHorizontally(1)) {
                z2 = false;
            }
            accessibilityEvent.setScrollable(z2);
            g gVar = this.f1847b.f1758m;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.e());
            }
        }

        public boolean L1() {
            return false;
        }

        public boolean M() {
            RecyclerView recyclerView = this.f1847b;
            return recyclerView != null && recyclerView.f1748h;
        }

        public void M0(v vVar, a0 a0Var, f0.d dVar) {
            if (this.f1847b.canScrollVertically(-1) || this.f1847b.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.p0(true);
            }
            if (this.f1847b.canScrollVertically(1) || this.f1847b.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.p0(true);
            }
            dVar.Z(f0.d.b.a(k0(vVar, a0Var), N(vVar, a0Var), v0(vVar, a0Var), l0(vVar, a0Var)));
        }

        public int N(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView == null || recyclerView.f1758m == null || !k()) {
                return 1;
            }
            return this.f1847b.f1758m.e();
        }

        void N0(f0.d dVar) {
            RecyclerView recyclerView = this.f1847b;
            M0(recyclerView.f1738c, recyclerView.f1751i0, dVar);
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        void O0(View view, f0.d dVar) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 == null || d0VarG0.v() || this.f1846a.n(d0VarG0.f1813a)) {
                return;
            }
            RecyclerView recyclerView = this.f1847b;
            P0(recyclerView.f1738c, recyclerView.f1751i0, view, dVar);
        }

        public void P(View view, Rect rect) {
            RecyclerView.h0(view, rect);
        }

        public void P0(v vVar, a0 a0Var, View view, f0.d dVar) {
            dVar.a0(f0.d.c.f(l() ? h0(view) : 0, 1, k() ? h0(view) : 0, 1, false, false));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        public View Q0(View view, int i3) {
            return null;
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1871b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView, int i3, int i4) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1871b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public int T(View view) {
            return view.getRight() + j0(view);
        }

        public void T0(RecyclerView recyclerView, int i3, int i4, int i5) {
        }

        public int U(View view) {
            return view.getTop() - m0(view);
        }

        public void U0(RecyclerView recyclerView, int i3, int i4) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1846a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i3, int i4) {
        }

        public int W() {
            return this.f1863r;
        }

        public void W0(RecyclerView recyclerView, int i3, int i4, Object obj) {
            V0(recyclerView, i3, i4);
        }

        public int X() {
            return this.f1861p;
        }

        public void X0(v vVar, a0 a0Var) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int Y() {
            RecyclerView recyclerView = this.f1847b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.e();
            }
            return 0;
        }

        public void Y0(a0 a0Var) {
        }

        public int Z() {
            return e0.t.B(this.f1847b);
        }

        public void Z0(v vVar, a0 a0Var, int i3, int i4) {
            this.f1847b.w(i3, i4);
        }

        public int a0(View view) {
            return ((p) view.getLayoutParams()).f1871b.left;
        }

        @Deprecated
        public boolean a1(RecyclerView recyclerView, View view, View view2) {
            return x0() || recyclerView.v0();
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return e0.t.C(this.f1847b);
        }

        public boolean b1(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return a1(recyclerView, view, view2);
        }

        public void c(View view, int i3) {
            f(view, i3, true);
        }

        public int c0() {
            return e0.t.D(this.f1847b);
        }

        public void c1(Parcelable parcelable) {
        }

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable d1() {
            return null;
        }

        public void e(View view, int i3) {
            f(view, i3, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void e1(int i3) {
        }

        public int f0() {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void f1(z zVar) {
            if (this.f1852g == zVar) {
                this.f1852g = null;
            }
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                recyclerView.o(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        boolean g1(int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f1847b;
            return h1(recyclerView.f1738c, recyclerView.f1751i0, i3, bundle);
        }

        public void h(View view, int i3) {
            i(view, i3, (p) view.getLayoutParams());
        }

        public int h0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0071 A[PHI: r8
  0x0071: PHI (r8v8 int) = (r8v4 int), (r8v12 int) binds: [B:22:0x005e, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        public boolean h1(v vVar, a0 a0Var, int i3, Bundle bundle) {
            int iW;
            int iO0;
            int i4;
            int i5;
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView == null) {
                return false;
            }
            if (i3 == 4096) {
                iW = recyclerView.canScrollVertically(1) ? (W() - g0()) - d0() : 0;
                if (this.f1847b.canScrollHorizontally(1)) {
                    iO0 = (o0() - e0()) - f0();
                    i4 = iW;
                    i5 = iO0;
                } else {
                    i4 = iW;
                    i5 = 0;
                }
            } else if (i3 != 8192) {
                i5 = 0;
                i4 = 0;
            } else {
                iW = recyclerView.canScrollVertically(-1) ? -((W() - g0()) - d0()) : 0;
                if (this.f1847b.canScrollHorizontally(-1)) {
                    iO0 = -((o0() - e0()) - f0());
                    i4 = iW;
                    i5 = iO0;
                } else {
                    i4 = iW;
                    i5 = 0;
                }
            }
            if (i4 == 0 && i5 == 0) {
                return false;
            }
            this.f1847b.p1(i5, i4, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void i(View view, int i3, p pVar) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0.v()) {
                this.f1847b.f1746g.b(d0VarG0);
            } else {
                this.f1847b.f1746g.p(d0VarG0);
            }
            this.f1846a.c(view, i3, pVar, d0VarG0.v());
        }

        boolean i1(View view, int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f1847b;
            return j1(recyclerView.f1738c, recyclerView.f1751i0, view, i3, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.k0(view));
            }
        }

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f1871b.right;
        }

        public boolean j1(v vVar, a0 a0Var, View view, int i3, Bundle bundle) {
            return false;
        }

        public boolean k() {
            return false;
        }

        public int k0(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView == null || recyclerView.f1758m == null || !l()) {
                return 1;
            }
            return this.f1847b.f1758m.e();
        }

        public void k1(v vVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                if (!RecyclerView.g0(I(iJ)).J()) {
                    n1(iJ, vVar);
                }
            }
        }

        public boolean l() {
            return false;
        }

        public int l0(v vVar, a0 a0Var) {
            return 0;
        }

        void l1(v vVar) {
            int iJ = vVar.j();
            for (int i3 = iJ - 1; i3 >= 0; i3--) {
                View viewN = vVar.n(i3);
                d0 d0VarG0 = RecyclerView.g0(viewN);
                if (!d0VarG0.J()) {
                    d0VarG0.G(false);
                    if (d0VarG0.x()) {
                        this.f1847b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f1847b.N;
                    if (lVar != null) {
                        lVar.j(d0VarG0);
                    }
                    d0VarG0.G(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.f1847b.invalidate();
            }
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).f1871b.top;
        }

        public void m1(View view, v vVar) {
            p1(view);
            vVar.B(view);
        }

        public void n0(View view, boolean z2, Rect rect) {
            Matrix matrix;
            if (z2) {
                Rect rect2 = ((p) view.getLayoutParams()).f1871b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f1847b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f1847b.f1756l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n1(int i3, v vVar) {
            View viewI = I(i3);
            q1(i3);
            vVar.B(viewI);
        }

        public void o(int i3, int i4, a0 a0Var, c cVar) {
        }

        public int o0() {
            return this.f1862q;
        }

        public boolean o1(Runnable runnable) {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void p(int i3, c cVar) {
        }

        public int p0() {
            return this.f1860o;
        }

        public void p1(View view) {
            this.f1846a.p(view);
        }

        public int q(a0 a0Var) {
            return 0;
        }

        boolean q0() {
            int iJ = J();
            for (int i3 = 0; i3 < iJ; i3++) {
                ViewGroup.LayoutParams layoutParams = I(i3).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void q1(int i3) {
            if (I(i3) != null) {
                this.f1846a.q(i3);
            }
        }

        public int r(a0 a0Var) {
            return 0;
        }

        public boolean r0() {
            return this.f1854i;
        }

        public boolean r1(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            return s1(recyclerView, view, rect, z2, false);
        }

        public int s(a0 a0Var) {
            return 0;
        }

        public boolean s0() {
            return this.f1855j;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            int[] iArrL = L(view, rect);
            int i3 = iArrL[0];
            int i4 = iArrL[1];
            if ((z3 && !t0(recyclerView, i3, i4)) || (i3 == 0 && i4 == 0)) {
                return false;
            }
            if (z2) {
                recyclerView.scrollBy(i3, i4);
            } else {
                recyclerView.m1(i3, i4);
            }
            return true;
        }

        public int t(a0 a0Var) {
            return 0;
        }

        public void t1() {
            RecyclerView recyclerView = this.f1847b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int u(a0 a0Var) {
            return 0;
        }

        public final boolean u0() {
            return this.f1857l;
        }

        public void u1() {
            this.f1853h = true;
        }

        public int v(a0 a0Var) {
            return 0;
        }

        public boolean v0(v vVar, a0 a0Var) {
            return false;
        }

        public void w(v vVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                v1(vVar, iJ, I(iJ));
            }
        }

        public int w1(int i3, v vVar, a0 a0Var) {
            return 0;
        }

        public void x(int i3) {
            y(i3, I(i3));
        }

        public boolean x0() {
            z zVar = this.f1852g;
            return zVar != null && zVar.h();
        }

        public void x1(int i3) {
        }

        public boolean y0(View view, boolean z2, boolean z3) {
            boolean z4 = this.f1850e.b(view, 24579) && this.f1851f.b(view, 24579);
            return z2 ? z4 : !z4;
        }

        public int y1(int i3, v vVar, a0 a0Var) {
            return 0;
        }

        void z(RecyclerView recyclerView) {
            this.f1854i = true;
            G0(recyclerView);
        }

        public void z0(View view, int i3, int i4, int i5, int i6) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f1871b;
            view.layout(i3 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i4 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i5 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i6 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
    }

    public interface q {
        void a(View view);

        void b(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i3, int i4);
    }

    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z2);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i3) {
        }

        public void b(RecyclerView recyclerView, int i3, int i4) {
        }
    }

    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<a> f1874a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1875b = 0;

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ArrayList<d0> f1876a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f1877b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f1878c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f1879d = 0;

            a() {
            }
        }

        private a g(int i3) {
            a aVar = this.f1874a.get(i3);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1874a.put(i3, aVar2);
            return aVar2;
        }

        void a() {
            this.f1875b++;
        }

        public void b() {
            for (int i3 = 0; i3 < this.f1874a.size(); i3++) {
                this.f1874a.valueAt(i3).f1876a.clear();
            }
        }

        void c() {
            this.f1875b--;
        }

        void d(int i3, long j3) {
            a aVarG = g(i3);
            aVarG.f1879d = j(aVarG.f1879d, j3);
        }

        void e(int i3, long j3) {
            a aVarG = g(i3);
            aVarG.f1878c = j(aVarG.f1878c, j3);
        }

        public d0 f(int i3) {
            a aVar = this.f1874a.get(i3);
            if (aVar == null || aVar.f1876a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aVar.f1876a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).r()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        void h(g gVar, g gVar2, boolean z2) {
            if (gVar != null) {
                c();
            }
            if (!z2 && this.f1875b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(d0 d0Var) {
            int iL = d0Var.l();
            ArrayList<d0> arrayList = g(iL).f1876a;
            if (this.f1874a.get(iL).f1877b <= arrayList.size()) {
                return;
            }
            d0Var.D();
            arrayList.add(d0Var);
        }

        long j(long j3, long j4) {
            return j3 == 0 ? j4 : ((j3 / 4) * 3) + (j4 / 4);
        }

        boolean k(int i3, long j3, long j4) {
            long j5 = g(i3).f1879d;
            return j5 == 0 || j3 + j5 < j4;
        }

        boolean l(int i3, long j3, long j4) {
            long j5 = g(i3).f1878c;
            return j5 == 0 || j3 + j5 < j4;
        }
    }

    public final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<d0> f1880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<d0> f1881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<d0> f1882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<d0> f1883d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1884e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1885f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        u f1886g;

        public v() {
            ArrayList<d0> arrayList = new ArrayList<>();
            this.f1880a = arrayList;
            this.f1881b = null;
            this.f1882c = new ArrayList<>();
            this.f1883d = Collections.unmodifiableList(arrayList);
            this.f1884e = 2;
            this.f1885f = 2;
        }

        private boolean H(d0 d0Var, int i3, int i4, long j3) {
            d0Var.f1830r = RecyclerView.this;
            int iL = d0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j3 != Long.MAX_VALUE && !this.f1886g.k(iL, nanoTime, j3)) {
                return false;
            }
            RecyclerView.this.f1758m.c(d0Var, i3);
            this.f1886g.d(d0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.f1751i0.e()) {
                return true;
            }
            d0Var.f1819g = i4;
            return true;
        }

        private void b(d0 d0Var) {
            if (RecyclerView.this.u0()) {
                View view = d0Var.f1813a;
                if (e0.t.z(view) == 0) {
                    e0.t.v0(view, 1);
                }
                androidx.recyclerview.widget.k kVar = RecyclerView.this.f1765p0;
                if (kVar == null) {
                    return;
                }
                e0.a aVarN = kVar.n();
                if (aVarN instanceof androidx.recyclerview.widget.k.a) {
                    ((androidx.recyclerview.widget.k.a) aVarN).o(view);
                }
                e0.t.m0(view, aVarN);
            }
        }

        private void q(ViewGroup viewGroup, boolean z2) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z2) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(d0 d0Var) {
            View view = d0Var.f1813a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i3) {
            a(this.f1882c.get(i3), true);
            this.f1882c.remove(i3);
        }

        public void B(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (d0VarG0.w()) {
                d0VarG0.K();
            } else if (d0VarG0.L()) {
                d0VarG0.e();
            }
            C(d0VarG0);
            if (RecyclerView.this.N == null || d0VarG0.u()) {
                return;
            }
            RecyclerView.this.N.j(d0VarG0);
        }

        void C(d0 d0Var) {
            boolean z2;
            boolean z3 = false;
            boolean z4 = true;
            if (d0Var.w() || d0Var.f1813a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.w());
                sb.append(" isAttached:");
                sb.append(d0Var.f1813a.getParent() != null);
                sb.append(RecyclerView.this.P());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d0Var.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.P());
            }
            if (d0Var.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.P());
            }
            boolean zH = d0Var.h();
            g gVar = RecyclerView.this.f1758m;
            if ((gVar != null && zH && gVar.q(d0Var)) || d0Var.u()) {
                if (this.f1885f <= 0 || d0Var.p(526)) {
                    z2 = false;
                } else {
                    int size = this.f1882c.size();
                    if (size >= this.f1885f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.D0 && size > 0 && !RecyclerView.this.f1749h0.d(d0Var.f1815c)) {
                        int i3 = size - 1;
                        while (i3 >= 0) {
                            if (!RecyclerView.this.f1749h0.d(this.f1882c.get(i3).f1815c)) {
                                break;
                            } else {
                                i3--;
                            }
                        }
                        size = i3 + 1;
                    }
                    this.f1882c.add(size, d0Var);
                    z2 = true;
                }
                if (z2) {
                    z4 = false;
                } else {
                    a(d0Var, true);
                }
                z3 = z2;
            } else {
                z4 = false;
            }
            RecyclerView.this.f1746g.q(d0Var);
            if (z3 || z4 || !zH) {
                return;
            }
            d0Var.f1830r = null;
        }

        void D(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (!d0VarG0.p(12) && d0VarG0.y() && !RecyclerView.this.p(d0VarG0)) {
                if (this.f1881b == null) {
                    this.f1881b = new ArrayList<>();
                }
                d0VarG0.H(this, true);
                this.f1881b.add(d0VarG0);
                return;
            }
            if (!d0VarG0.t() || d0VarG0.v() || RecyclerView.this.f1758m.i()) {
                d0VarG0.H(this, false);
                this.f1880a.add(d0VarG0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.P());
            }
        }

        void E(u uVar) {
            u uVar2 = this.f1886g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f1886g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f1886g.a();
        }

        void F(b0 b0Var) {
        }

        public void G(int i3) {
            this.f1884e = i3;
            K();
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:59:0x012c A[PHI: r1 r4
  0x012c: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$d0) = (r1v11 androidx.recyclerview.widget.RecyclerView$d0), (r1v30 androidx.recyclerview.widget.RecyclerView$d0) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]
  0x012c: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:68:0x014d  */
        /* JADX WARN: Code duplicated, block: B:74:0x0179  */
        /* JADX WARN: Code duplicated, block: B:76:0x017f  */
        /* JADX WARN: Code duplicated, block: B:85:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:86:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:88:0x01bf  */
        /* JADX WARN: Code duplicated, block: B:89:0x01cd  */
        /* JADX WARN: Code duplicated, block: B:92:0x01d3 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:94:0x01d6  */
        d0 I(int i3, boolean z2, long j3) {
            d0 d0VarL;
            boolean z3;
            d0 d0Var;
            boolean z4;
            boolean zH;
            ViewGroup.LayoutParams layoutParams;
            p pVar;
            int iM;
            RecyclerView recyclerViewV;
            if (i3 < 0 || i3 >= RecyclerView.this.f1751i0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i3 + "(" + i3 + "). Item count:" + RecyclerView.this.f1751i0.b() + RecyclerView.this.P());
            }
            if (RecyclerView.this.f1751i0.e()) {
                d0VarL = h(i3);
                if (d0VarL != null) {
                    z3 = true;
                }
                if (d0VarL == null && (d0VarL = m(i3, z2)) != null) {
                    if (L(d0VarL)) {
                        z3 = true;
                    } else {
                        if (!z2) {
                            d0VarL.b(4);
                            if (d0VarL.w()) {
                                RecyclerView.this.removeDetachedView(d0VarL.f1813a, false);
                                d0VarL.K();
                            } else if (d0VarL.L()) {
                                d0VarL.e();
                            }
                            C(d0VarL);
                        }
                        d0VarL = null;
                    }
                }
                if (d0VarL == null) {
                    d0Var = d0VarL;
                } else {
                    iM = RecyclerView.this.f1742e.m(i3);
                    if (iM >= 0 || iM >= RecyclerView.this.f1758m.e()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + iM + ").state:" + RecyclerView.this.f1751i0.b() + RecyclerView.this.P());
                    }
                    int iG = RecyclerView.this.f1758m.g(iM);
                    if (RecyclerView.this.f1758m.i() && (d0VarL = l(RecyclerView.this.f1758m.f(iM), iG, z2)) != null) {
                        d0VarL.f1815c = iM;
                        z3 = true;
                    }
                    if (d0VarL == null) {
                        d0 d0VarF = i().f(iG);
                        if (d0VarF != null) {
                            d0VarF.D();
                            if (RecyclerView.A0) {
                                r(d0VarF);
                            }
                        }
                        d0VarL = d0VarF;
                    }
                    if (d0VarL == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j3 != Long.MAX_VALUE && !this.f1886g.l(iG, nanoTime, j3)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        d0 d0VarD = recyclerView.f1758m.d(recyclerView, iG);
                        if (RecyclerView.D0 && (recyclerViewV = RecyclerView.V(d0VarD.f1813a)) != null) {
                            d0VarD.f1814b = new WeakReference<>(recyclerViewV);
                        }
                        this.f1886g.e(iG, RecyclerView.this.getNanoTime() - nanoTime);
                        d0Var = d0VarD;
                    } else {
                        d0Var = d0VarL;
                    }
                }
                z4 = z3;
                if (z4 && !RecyclerView.this.f1751i0.e() && d0Var.p(8192)) {
                    d0Var.F(0, 8192);
                    if (RecyclerView.this.f1751i0.f1796k) {
                        int iE = l.e(d0Var) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.S0(d0Var, recyclerView2.N.t(recyclerView2.f1751i0, d0Var, iE, d0Var.o()));
                    }
                }
                if (RecyclerView.this.f1751i0.e() || !d0Var.s()) {
                    if (d0Var.s() || d0Var.z() || d0Var.t()) {
                        zH = H(d0Var, RecyclerView.this.f1742e.m(i3), i3, j3);
                    }
                    layoutParams = d0Var.f1813a.getLayoutParams();
                    if (layoutParams == null) {
                        pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                        d0Var.f1813a.setLayoutParams(pVar);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        pVar = (p) layoutParams;
                    } else {
                        pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                        d0Var.f1813a.setLayoutParams(pVar);
                    }
                    pVar.f1870a = d0Var;
                    pVar.f1873d = !z4 && zH;
                    return d0Var;
                }
                d0Var.f1819g = i3;
                zH = false;
                layoutParams = d0Var.f1813a.getLayoutParams();
                if (layoutParams == null) {
                    pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                    d0Var.f1813a.setLayoutParams(pVar);
                } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                    pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                    d0Var.f1813a.setLayoutParams(pVar);
                } else {
                    pVar = (p) layoutParams;
                }
                pVar.f1870a = d0Var;
                pVar.f1873d = !z4 && zH;
                return d0Var;
            }
            d0VarL = null;
            z3 = false;
            if (d0VarL == null) {
                if (L(d0VarL)) {
                    if (!z2) {
                        d0VarL.b(4);
                        if (d0VarL.w()) {
                            RecyclerView.this.removeDetachedView(d0VarL.f1813a, false);
                            d0VarL.K();
                        } else if (d0VarL.L()) {
                            d0VarL.e();
                        }
                        C(d0VarL);
                    }
                    d0VarL = null;
                } else {
                    z3 = true;
                }
            }
            if (d0VarL == null) {
                iM = RecyclerView.this.f1742e.m(i3);
                if (iM >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + iM + ").state:" + RecyclerView.this.f1751i0.b() + RecyclerView.this.P());
            }
            d0Var = d0VarL;
            z4 = z3;
            if (z4) {
                d0Var.F(0, 8192);
                if (RecyclerView.this.f1751i0.f1796k) {
                    int iE2 = l.e(d0Var) | 4096;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    RecyclerView.this.S0(d0Var, recyclerView3.N.t(recyclerView3.f1751i0, d0Var, iE2, d0Var.o()));
                }
            }
            if (RecyclerView.this.f1751i0.e()) {
                if (d0Var.s()) {
                }
                zH = H(d0Var, RecyclerView.this.f1742e.m(i3), i3, j3);
            } else {
                if (d0Var.s()) {
                }
                zH = H(d0Var, RecyclerView.this.f1742e.m(i3), i3, j3);
            }
            layoutParams = d0Var.f1813a.getLayoutParams();
            if (layoutParams == null) {
                pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                d0Var.f1813a.setLayoutParams(pVar);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                d0Var.f1813a.setLayoutParams(pVar);
            } else {
                pVar = (p) layoutParams;
            }
            pVar.f1870a = d0Var;
            pVar.f1873d = !z4 && zH;
            return d0Var;
        }

        void J(d0 d0Var) {
            if (d0Var.f1827o) {
                this.f1881b.remove(d0Var);
            } else {
                this.f1880a.remove(d0Var);
            }
            d0Var.f1826n = null;
            d0Var.f1827o = false;
            d0Var.e();
        }

        void K() {
            o oVar = RecyclerView.this.f1760n;
            this.f1885f = this.f1884e + (oVar != null ? oVar.f1858m : 0);
            for (int size = this.f1882c.size() - 1; size >= 0 && this.f1882c.size() > this.f1885f; size--) {
                A(size);
            }
        }

        boolean L(d0 d0Var) {
            if (d0Var.v()) {
                return RecyclerView.this.f1751i0.e();
            }
            int i3 = d0Var.f1815c;
            if (i3 >= 0 && i3 < RecyclerView.this.f1758m.e()) {
                if (RecyclerView.this.f1751i0.e() || RecyclerView.this.f1758m.g(d0Var.f1815c) == d0Var.l()) {
                    return !RecyclerView.this.f1758m.i() || d0Var.k() == RecyclerView.this.f1758m.f(d0Var.f1815c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.P());
        }

        void M(int i3, int i4) {
            int i5;
            int i6 = i4 + i3;
            for (int size = this.f1882c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1882c.get(size);
                if (d0Var != null && (i5 = d0Var.f1815c) >= i3 && i5 < i6) {
                    d0Var.b(2);
                    A(size);
                }
            }
        }

        void a(d0 d0Var, boolean z2) {
            RecyclerView.r(d0Var);
            View view = d0Var.f1813a;
            androidx.recyclerview.widget.k kVar = RecyclerView.this.f1765p0;
            if (kVar != null) {
                e0.a aVarN = kVar.n();
                e0.t.m0(view, aVarN instanceof androidx.recyclerview.widget.k.a ? ((androidx.recyclerview.widget.k.a) aVarN).n(view) : null);
            }
            if (z2) {
                g(d0Var);
            }
            d0Var.f1830r = null;
            i().i(d0Var);
        }

        public void c() {
            this.f1880a.clear();
            z();
        }

        void d() {
            int size = this.f1882c.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f1882c.get(i3).c();
            }
            int size2 = this.f1880a.size();
            for (int i4 = 0; i4 < size2; i4++) {
                this.f1880a.get(i4).c();
            }
            ArrayList<d0> arrayList = this.f1881b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.f1881b.get(i5).c();
                }
            }
        }

        void e() {
            this.f1880a.clear();
            ArrayList<d0> arrayList = this.f1881b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i3) {
            if (i3 >= 0 && i3 < RecyclerView.this.f1751i0.b()) {
                return !RecyclerView.this.f1751i0.e() ? i3 : RecyclerView.this.f1742e.m(i3);
            }
            throw new IndexOutOfBoundsException("invalid position " + i3 + ". State item count is " + RecyclerView.this.f1751i0.b() + RecyclerView.this.P());
        }

        void g(d0 d0Var) {
            w wVar = RecyclerView.this.f1762o;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.f1758m;
            if (gVar != null) {
                gVar.t(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1751i0 != null) {
                recyclerView.f1746g.q(d0Var);
            }
        }

        d0 h(int i3) {
            int size;
            int iM;
            ArrayList<d0> arrayList = this.f1881b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    d0 d0Var = this.f1881b.get(i4);
                    if (!d0Var.L() && d0Var.m() == i3) {
                        d0Var.b(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.f1758m.i() && (iM = RecyclerView.this.f1742e.m(i3)) > 0 && iM < RecyclerView.this.f1758m.e()) {
                    long jF = RecyclerView.this.f1758m.f(iM);
                    for (int i5 = 0; i5 < size; i5++) {
                        d0 d0Var2 = this.f1881b.get(i5);
                        if (!d0Var2.L() && d0Var2.k() == jF) {
                            d0Var2.b(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.f1886g == null) {
                this.f1886g = new u();
            }
            return this.f1886g;
        }

        int j() {
            return this.f1880a.size();
        }

        public List<d0> k() {
            return this.f1883d;
        }

        d0 l(long j3, int i3, boolean z2) {
            for (int size = this.f1880a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1880a.get(size);
                if (d0Var.k() == j3 && !d0Var.L()) {
                    if (i3 == d0Var.l()) {
                        d0Var.b(32);
                        if (d0Var.v() && !RecyclerView.this.f1751i0.e()) {
                            d0Var.F(2, 14);
                        }
                        return d0Var;
                    }
                    if (!z2) {
                        this.f1880a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f1813a, false);
                        y(d0Var.f1813a);
                    }
                }
            }
            int size2 = this.f1882c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f1882c.get(size2);
                if (d0Var2.k() == j3 && !d0Var2.r()) {
                    if (i3 == d0Var2.l()) {
                        if (!z2) {
                            this.f1882c.remove(size2);
                        }
                        return d0Var2;
                    }
                    if (!z2) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        d0 m(int i3, boolean z2) {
            View viewE;
            int size = this.f1880a.size();
            for (int i4 = 0; i4 < size; i4++) {
                d0 d0Var = this.f1880a.get(i4);
                if (!d0Var.L() && d0Var.m() == i3 && !d0Var.t() && (RecyclerView.this.f1751i0.f1793h || !d0Var.v())) {
                    d0Var.b(32);
                    return d0Var;
                }
            }
            if (z2 || (viewE = RecyclerView.this.f1744f.e(i3)) == null) {
                int size2 = this.f1882c.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    d0 d0Var2 = this.f1882c.get(i5);
                    if (!d0Var2.t() && d0Var2.m() == i3 && !d0Var2.r()) {
                        if (!z2) {
                            this.f1882c.remove(i5);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 d0VarG0 = RecyclerView.g0(viewE);
            RecyclerView.this.f1744f.s(viewE);
            int iM = RecyclerView.this.f1744f.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f1744f.d(iM);
                D(viewE);
                d0VarG0.b(8224);
                return d0VarG0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + d0VarG0 + RecyclerView.this.P());
        }

        View n(int i3) {
            return this.f1880a.get(i3).f1813a;
        }

        public View o(int i3) {
            return p(i3, false);
        }

        View p(int i3, boolean z2) {
            return I(i3, z2, Long.MAX_VALUE).f1813a;
        }

        void s() {
            int size = this.f1882c.size();
            for (int i3 = 0; i3 < size; i3++) {
                p pVar = (p) this.f1882c.get(i3).f1813a.getLayoutParams();
                if (pVar != null) {
                    pVar.f1872c = true;
                }
            }
        }

        void t() {
            int size = this.f1882c.size();
            for (int i3 = 0; i3 < size; i3++) {
                d0 d0Var = this.f1882c.get(i3);
                if (d0Var != null) {
                    d0Var.b(6);
                    d0Var.a(null);
                }
            }
            g gVar = RecyclerView.this.f1758m;
            if (gVar == null || !gVar.i()) {
                z();
            }
        }

        void u(int i3, int i4) {
            int size = this.f1882c.size();
            for (int i5 = 0; i5 < size; i5++) {
                d0 d0Var = this.f1882c.get(i5);
                if (d0Var != null && d0Var.f1815c >= i3) {
                    d0Var.A(i4, true);
                }
            }
        }

        void v(int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            if (i3 < i4) {
                i5 = -1;
                i7 = i3;
                i6 = i4;
            } else {
                i5 = 1;
                i6 = i3;
                i7 = i4;
            }
            int size = this.f1882c.size();
            for (int i9 = 0; i9 < size; i9++) {
                d0 d0Var = this.f1882c.get(i9);
                if (d0Var != null && (i8 = d0Var.f1815c) >= i7 && i8 <= i6) {
                    if (i8 == i3) {
                        d0Var.A(i4 - i3, false);
                    } else {
                        d0Var.A(i5, false);
                    }
                }
            }
        }

        void w(int i3, int i4, boolean z2) {
            int i5 = i3 + i4;
            for (int size = this.f1882c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1882c.get(size);
                if (d0Var != null) {
                    int i6 = d0Var.f1815c;
                    if (i6 >= i5) {
                        d0Var.A(-i4, z2);
                    } else if (i6 >= i3) {
                        d0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z2) {
            c();
            i().h(gVar, gVar2, z2);
        }

        void y(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            d0VarG0.f1826n = null;
            d0VarG0.f1827o = false;
            d0VarG0.e();
            C(d0VarG0);
        }

        void z() {
            for (int size = this.f1882c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f1882c.clear();
            if (RecyclerView.D0) {
                RecyclerView.this.f1749h0.b();
            }
        }
    }

    public interface w {
        void a(d0 d0Var);
    }

    private class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.o(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1751i0.f1792g = true;
            recyclerView.Q0(true);
            if (RecyclerView.this.f1742e.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i3, int i4, Object obj) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.f1742e.r(i3, i4, obj)) {
                d();
            }
        }

        void d() {
            if (RecyclerView.C0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f1772t && recyclerView.f1770s) {
                    e0.t.e0(recyclerView, recyclerView.f1750i);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }
    }

    public static abstract class z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView f1891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private o f1892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1893d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1894e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f1895f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f1897h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1890a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f1896g = new a(0, 0);

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f1898a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f1899b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f1900c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f1901d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Interpolator f1902e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f1903f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f1904g;

            public a(int i3, int i4) {
                this(i3, i4, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f1902e != null && this.f1900c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1900c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f1901d >= 0;
            }

            public void b(int i3) {
                this.f1901d = i3;
            }

            void c(RecyclerView recyclerView) {
                int i3 = this.f1901d;
                if (i3 >= 0) {
                    this.f1901d = -1;
                    recyclerView.x0(i3);
                    this.f1903f = false;
                } else {
                    if (!this.f1903f) {
                        this.f1904g = 0;
                        return;
                    }
                    e();
                    recyclerView.f1745f0.f(this.f1898a, this.f1899b, this.f1900c, this.f1902e);
                    int i4 = this.f1904g + 1;
                    this.f1904g = i4;
                    if (i4 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1903f = false;
                }
            }

            public void d(int i3, int i4, int i5, Interpolator interpolator) {
                this.f1898a = i3;
                this.f1899b = i4;
                this.f1900c = i5;
                this.f1902e = interpolator;
                this.f1903f = true;
            }

            public a(int i3, int i4, int i5, Interpolator interpolator) {
                this.f1901d = -1;
                this.f1903f = false;
                this.f1904g = 0;
                this.f1898a = i3;
                this.f1899b = i4;
                this.f1900c = i5;
                this.f1902e = interpolator;
            }
        }

        public interface b {
            PointF a(int i3);
        }

        public PointF a(int i3) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).a(i3);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i3) {
            return this.f1891b.f1760n.C(i3);
        }

        public int c() {
            return this.f1891b.f1760n.J();
        }

        public int d(View view) {
            return this.f1891b.e0(view);
        }

        public o e() {
            return this.f1892c;
        }

        public int f() {
            return this.f1890a;
        }

        public boolean g() {
            return this.f1893d;
        }

        public boolean h() {
            return this.f1894e;
        }

        protected void i(PointF pointF) {
            float f3 = pointF.x;
            float f4 = pointF.y;
            float fSqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        void j(int i3, int i4) {
            PointF pointFA;
            RecyclerView recyclerView = this.f1891b;
            if (this.f1890a == -1 || recyclerView == null) {
                r();
            }
            if (this.f1893d && this.f1895f == null && this.f1892c != null && (pointFA = a(this.f1890a)) != null) {
                float f3 = pointFA.x;
                if (f3 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.h1((int) Math.signum(f3), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f1893d = false;
            View view = this.f1895f;
            if (view != null) {
                if (d(view) == this.f1890a) {
                    o(this.f1895f, recyclerView.f1751i0, this.f1896g);
                    this.f1896g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1895f = null;
                }
            }
            if (this.f1894e) {
                l(i3, i4, recyclerView.f1751i0, this.f1896g);
                boolean zA = this.f1896g.a();
                this.f1896g.c(recyclerView);
                if (zA && this.f1894e) {
                    this.f1893d = true;
                    recyclerView.f1745f0.e();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f1895f = view;
            }
        }

        protected abstract void l(int i3, int i4, a0 a0Var, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, a0 a0Var, a aVar);

        public void p(int i3) {
            this.f1890a = i3;
        }

        void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f1745f0.g();
            if (this.f1897h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f1891b = recyclerView;
            this.f1892c = oVar;
            int i3 = this.f1890a;
            if (i3 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f1751i0.f1786a = i3;
            this.f1894e = true;
            this.f1893d = true;
            this.f1895f = b(f());
            m();
            this.f1891b.f1745f0.e();
            this.f1897h = true;
        }

        protected final void r() {
            if (this.f1894e) {
                this.f1894e = false;
                n();
                this.f1891b.f1751i0.f1786a = -1;
                this.f1895f = null;
                this.f1890a = -1;
                this.f1893d = false;
                this.f1892c.f1(this);
                this.f1892c = null;
                this.f1891b = null;
            }
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        A0 = i3 == 18 || i3 == 19 || i3 == 20;
        B0 = i3 >= 23;
        C0 = i3 >= 16;
        D0 = i3 >= 21;
        E0 = i3 <= 15;
        F0 = i3 <= 15;
        Class<?> cls = Integer.TYPE;
        G0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        H0 = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void A() {
        int i3 = this.A;
        this.A = 0;
        if (i3 == 0 || !u0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(SecurityKeyCipher.SECURITY_DATA_SIZE_MAX);
        f0.b.b(accessibilityEventObtain, i3);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void C() {
        this.f1751i0.a(1);
        Q(this.f1751i0);
        this.f1751i0.f1795j = false;
        r1();
        this.f1746g.f();
        H0();
        P0();
        e1();
        a0 a0Var = this.f1751i0;
        a0Var.f1794i = a0Var.f1796k && this.f1759m0;
        this.f1759m0 = false;
        this.f1757l0 = false;
        a0Var.f1793h = a0Var.f1797l;
        a0Var.f1791f = this.f1758m.e();
        U(this.f1769r0);
        if (this.f1751i0.f1796k) {
            int iG = this.f1744f.g();
            for (int i3 = 0; i3 < iG; i3++) {
                d0 d0VarG0 = g0(this.f1744f.f(i3));
                if (!d0VarG0.J() && (!d0VarG0.t() || this.f1758m.i())) {
                    this.f1746g.e(d0VarG0, this.N.t(this.f1751i0, d0VarG0, l.e(d0VarG0), d0VarG0.o()));
                    if (this.f1751i0.f1794i && d0VarG0.y() && !d0VarG0.v() && !d0VarG0.J() && !d0VarG0.t()) {
                        this.f1746g.c(c0(d0VarG0), d0VarG0);
                    }
                }
            }
        }
        if (this.f1751i0.f1797l) {
            f1();
            a0 a0Var2 = this.f1751i0;
            boolean z2 = a0Var2.f1792g;
            a0Var2.f1792g = false;
            this.f1760n.X0(this.f1738c, a0Var2);
            this.f1751i0.f1792g = z2;
            for (int i4 = 0; i4 < this.f1744f.g(); i4++) {
                d0 d0VarG1 = g0(this.f1744f.f(i4));
                if (!d0VarG1.J() && !this.f1746g.i(d0VarG1)) {
                    int iE = l.e(d0VarG1);
                    boolean zP = d0VarG1.p(8192);
                    if (!zP) {
                        iE |= 4096;
                    }
                    l.c cVarT = this.N.t(this.f1751i0, d0VarG1, iE, d0VarG1.o());
                    if (zP) {
                        S0(d0VarG1, cVarT);
                    } else {
                        this.f1746g.a(d0VarG1, cVarT);
                    }
                }
            }
            s();
        } else {
            s();
        }
        I0();
        t1(false);
        this.f1751i0.f1790e = 2;
    }

    private void D() {
        r1();
        H0();
        this.f1751i0.a(6);
        this.f1742e.j();
        this.f1751i0.f1791f = this.f1758m.e();
        a0 a0Var = this.f1751i0;
        a0Var.f1789d = 0;
        a0Var.f1793h = false;
        this.f1760n.X0(this.f1738c, a0Var);
        a0 a0Var2 = this.f1751i0;
        a0Var2.f1792g = false;
        this.f1740d = null;
        a0Var2.f1796k = a0Var2.f1796k && this.N != null;
        a0Var2.f1790e = 4;
        I0();
        t1(false);
    }

    private void E() {
        this.f1751i0.a(4);
        r1();
        H0();
        a0 a0Var = this.f1751i0;
        a0Var.f1790e = 1;
        if (a0Var.f1796k) {
            for (int iG = this.f1744f.g() - 1; iG >= 0; iG--) {
                d0 d0VarG0 = g0(this.f1744f.f(iG));
                if (!d0VarG0.J()) {
                    long jC0 = c0(d0VarG0);
                    l.c cVarS = this.N.s(this.f1751i0, d0VarG0);
                    d0 d0VarG = this.f1746g.g(jC0);
                    if (d0VarG == null || d0VarG.J()) {
                        this.f1746g.d(d0VarG0, cVarS);
                    } else {
                        boolean zH = this.f1746g.h(d0VarG);
                        boolean zH2 = this.f1746g.h(d0VarG0);
                        if (zH && d0VarG == d0VarG0) {
                            this.f1746g.d(d0VarG0, cVarS);
                        } else {
                            l.c cVarN = this.f1746g.n(d0VarG);
                            this.f1746g.d(d0VarG0, cVarS);
                            l.c cVarM = this.f1746g.m(d0VarG0);
                            if (cVarN == null) {
                                l0(jC0, d0VarG0, d0VarG);
                            } else {
                                m(d0VarG, d0VarG0, cVarN, cVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f1746g.o(this.f1783y0);
        }
        this.f1760n.l1(this.f1738c);
        a0 a0Var2 = this.f1751i0;
        a0Var2.f1788c = a0Var2.f1791f;
        this.E = false;
        this.F = false;
        a0Var2.f1796k = false;
        a0Var2.f1797l = false;
        this.f1760n.f1853h = false;
        ArrayList<d0> arrayList = this.f1738c.f1881b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f1760n;
        if (oVar.f1859n) {
            oVar.f1858m = 0;
            oVar.f1859n = false;
            this.f1738c.K();
        }
        this.f1760n.Y0(this.f1751i0);
        I0();
        t1(false);
        this.f1746g.f();
        int[] iArr = this.f1769r0;
        if (x(iArr[0], iArr[1])) {
            I(0, 0);
        }
        T0();
        c1();
    }

    private boolean K(MotionEvent motionEvent) {
        s sVar = this.f1768r;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return T(motionEvent);
        }
        sVar.b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f1768r = null;
        }
        return true;
    }

    private void K0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i3);
            int x3 = (int) (motionEvent.getX(i3) + 0.5f);
            this.T = x3;
            this.R = x3;
            int y3 = (int) (motionEvent.getY(i3) + 0.5f);
            this.U = y3;
            this.S = y3;
        }
    }

    private boolean O0() {
        return this.N != null && this.f1760n.L1();
    }

    private void P0() {
        boolean z2;
        if (this.E) {
            this.f1742e.v();
            if (this.F) {
                this.f1760n.S0(this);
            }
        }
        if (O0()) {
            this.f1742e.t();
        } else {
            this.f1742e.j();
        }
        boolean z3 = false;
        boolean z4 = this.f1757l0 || this.f1759m0;
        this.f1751i0.f1796k = this.f1776v && this.N != null && ((z2 = this.E) || z4 || this.f1760n.f1853h) && (!z2 || this.f1758m.i());
        a0 a0Var = this.f1751i0;
        if (a0Var.f1796k && z4 && !this.E && O0()) {
            z3 = true;
        }
        a0Var.f1797l = z3;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:13:0x0056  */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    private void R0(float f3, float f4, float f5, float f6) {
        boolean z2;
        boolean z3 = true;
        if (f4 >= 0.0f) {
            if (f4 > 0.0f) {
                N();
                androidx.core.widget.d.a(this.L, f4 / getWidth(), f5 / getHeight());
            } else {
                z2 = false;
            }
            if (f6 < 0.0f) {
                O();
                androidx.core.widget.d.a(this.K, (-f6) / getHeight(), f3 / getWidth());
            } else if (f6 > 0.0f) {
                L();
                androidx.core.widget.d.a(this.M, f6 / getHeight(), 1.0f - (f3 / getWidth()));
            } else {
                z3 = z2;
            }
            if (z3 && f4 == 0.0f && f6 == 0.0f) {
                return;
            }
            e0.t.d0(this);
        }
        M();
        androidx.core.widget.d.a(this.J, (-f4) / getWidth(), 1.0f - (f5 / getHeight()));
        z2 = true;
        if (f6 < 0.0f) {
            O();
            androidx.core.widget.d.a(this.K, (-f6) / getHeight(), f3 / getWidth());
        } else if (f6 > 0.0f) {
            L();
            androidx.core.widget.d.a(this.M, f6 / getHeight(), 1.0f - (f3 / getWidth()));
        } else {
            z3 = z2;
        }
        if (z3) {
        }
        e0.t.d0(this);
    }

    private boolean T(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f1766q.size();
        for (int i3 = 0; i3 < size; i3++) {
            s sVar = this.f1766q.get(i3);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.f1768r = sVar;
                return true;
            }
        }
        return false;
    }

    private void T0() {
        View viewFindViewById;
        if (!this.f1743e0 || this.f1758m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!F0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f1744f.n(focusedChild)) {
                    return;
                }
            } else if (this.f1744f.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewW = null;
        d0 d0VarY = (this.f1751i0.f1799n == -1 || !this.f1758m.i()) ? null : Y(this.f1751i0.f1799n);
        if (d0VarY != null && !this.f1744f.n(d0VarY.f1813a) && d0VarY.f1813a.hasFocusable()) {
            viewW = d0VarY.f1813a;
        } else if (this.f1744f.g() > 0) {
            viewW = W();
        }
        if (viewW != null) {
            int i3 = this.f1751i0.f1800o;
            if (i3 != -1 && (viewFindViewById = viewW.findViewById(i3)) != null && viewFindViewById.isFocusable()) {
                viewW = viewFindViewById;
            }
            viewW.requestFocus();
        }
    }

    private void U(int[] iArr) {
        int iG = this.f1744f.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < iG; i5++) {
            d0 d0VarG0 = g0(this.f1744f.f(i5));
            if (!d0VarG0.J()) {
                int iM = d0VarG0.m();
                if (iM < i3) {
                    i3 = iM;
                }
                if (iM > i4) {
                    i4 = iM;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i4;
    }

    private void U0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.J.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.M.isFinished();
        }
        if (zIsFinished) {
            e0.t.d0(this);
        }
    }

    static RecyclerView V(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView recyclerViewV = V(viewGroup.getChildAt(i3));
            if (recyclerViewV != null) {
                return recyclerViewV;
            }
        }
        return null;
    }

    private View W() {
        d0 d0VarX;
        a0 a0Var = this.f1751i0;
        int i3 = a0Var.f1798m;
        if (i3 == -1) {
            i3 = 0;
        }
        int iB = a0Var.b();
        for (int i4 = i3; i4 < iB; i4++) {
            d0 d0VarX2 = X(i4);
            if (d0VarX2 == null) {
                break;
            }
            if (d0VarX2.f1813a.hasFocusable()) {
                return d0VarX2.f1813a;
            }
        }
        int iMin = Math.min(iB, i3);
        do {
            iMin--;
            if (iMin < 0 || (d0VarX = X(iMin)) == null) {
                return null;
            }
        } while (!d0VarX.f1813a.hasFocusable());
        return d0VarX.f1813a;
    }

    private void b1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f1752j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f1872c) {
                Rect rect = pVar.f1871b;
                Rect rect2 = this.f1752j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f1752j);
            offsetRectIntoDescendantCoords(view, this.f1752j);
        }
        this.f1760n.s1(this, view, this.f1752j, !this.f1776v, view2 == null);
    }

    private void c1() {
        a0 a0Var = this.f1751i0;
        a0Var.f1799n = -1L;
        a0Var.f1798m = -1;
        a0Var.f1800o = -1;
    }

    private void d1() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        u1(0);
        U0();
    }

    private void e1() {
        int iJ;
        View focusedChild = (this.f1743e0 && hasFocus() && this.f1758m != null) ? getFocusedChild() : null;
        d0 d0VarS = focusedChild != null ? S(focusedChild) : null;
        if (d0VarS == null) {
            c1();
            return;
        }
        this.f1751i0.f1799n = this.f1758m.i() ? d0VarS.k() : -1L;
        a0 a0Var = this.f1751i0;
        if (this.E) {
            iJ = -1;
        } else {
            iJ = d0VarS.v() ? d0VarS.f1816d : d0VarS.j();
        }
        a0Var.f1798m = iJ;
        this.f1751i0.f1800o = i0(d0VarS.f1813a);
    }

    private void g(d0 d0Var) {
        View view = d0Var.f1813a;
        boolean z2 = view.getParent() == this;
        this.f1738c.J(f0(view));
        if (d0Var.x()) {
            this.f1744f.c(view, -1, view.getLayoutParams(), true);
        } else if (z2) {
            this.f1744f.k(view);
        } else {
            this.f1744f.b(view, true);
        }
    }

    static d0 g0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f1870a;
    }

    private e0.k getScrollingChildHelper() {
        if (this.f1771s0 == null) {
            this.f1771s0 = new e0.k(this);
        }
        return this.f1771s0;
    }

    static void h0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f1871b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int i0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String j0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void j1(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.f1758m;
        if (gVar2 != null) {
            gVar2.w(this.f1736b);
            this.f1758m.p(this);
        }
        if (!z2 || z3) {
            V0();
        }
        this.f1742e.v();
        g gVar3 = this.f1758m;
        this.f1758m = gVar;
        if (gVar != null) {
            gVar.u(this.f1736b);
            gVar.l(this);
        }
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.E0(gVar3, this.f1758m);
        }
        this.f1738c.x(gVar3, this.f1758m, z2);
        this.f1751i0.f1792g = true;
    }

    private void l0(long j3, d0 d0Var, d0 d0Var2) {
        int iG = this.f1744f.g();
        for (int i3 = 0; i3 < iG; i3++) {
            d0 d0VarG0 = g0(this.f1744f.f(i3));
            if (d0VarG0 != d0Var && c0(d0VarG0) == j3) {
                g gVar = this.f1758m;
                if (gVar == null || !gVar.i()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + d0VarG0 + " \n View Holder 2:" + d0Var + P());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + d0VarG0 + " \n View Holder 2:" + d0Var + P());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + P());
    }

    private void m(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        d0Var.G(false);
        if (z2) {
            g(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                g(d0Var2);
            }
            d0Var.f1820h = d0Var2;
            g(d0Var);
            this.f1738c.J(d0Var);
            d0Var2.G(false);
            d0Var2.f1821i = d0Var;
        }
        if (this.N.b(d0Var, d0Var2, cVar, cVar2)) {
            N0();
        }
    }

    private boolean n0() {
        int iG = this.f1744f.g();
        for (int i3 = 0; i3 < iG; i3++) {
            d0 d0VarG0 = g0(this.f1744f.f(i3));
            if (d0VarG0 != null && !d0VarG0.J() && d0VarG0.y()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void p0() {
        if (e0.t.A(this) == 0) {
            e0.t.w0(this, 8);
        }
    }

    private void q() {
        d1();
        setScrollState(0);
    }

    private void q0() {
        this.f1744f = new androidx.recyclerview.widget.b(new e());
    }

    static void r(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f1814b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == d0Var.f1813a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            d0Var.f1814b = null;
        }
    }

    private void v(Context context, String str, AttributeSet attributeSet, int i3, int i4) {
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strJ0 = j0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strJ0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(G0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i4)};
                } catch (NoSuchMethodException e3) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e4) {
                        e4.initCause(e3);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strJ0, e4);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strJ0, e5);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strJ0, e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strJ0, e7);
            } catch (InstantiationException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strJ0, e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strJ0, e9);
            }
        }
    }

    private boolean w0(View view, View view2, int i3) {
        int i4;
        if (view2 == null || view2 == this || R(view2) == null) {
            return false;
        }
        if (view == null || R(view) == null) {
            return true;
        }
        this.f1752j.set(0, 0, view.getWidth(), view.getHeight());
        this.f1754k.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f1752j);
        offsetDescendantRectToMyCoords(view2, this.f1754k);
        byte b3 = -1;
        int i5 = this.f1760n.Z() == 1 ? -1 : 1;
        Rect rect = this.f1752j;
        int i6 = rect.left;
        Rect rect2 = this.f1754k;
        int i7 = rect2.left;
        if ((i6 < i7 || rect.right <= i7) && rect.right < rect2.right) {
            i4 = 1;
        } else {
            int i8 = rect.right;
            int i9 = rect2.right;
            i4 = ((i8 > i9 || i6 >= i9) && i6 > i7) ? -1 : 0;
        }
        int i10 = rect.top;
        int i11 = rect2.top;
        if ((i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom) {
            b3 = 1;
        } else {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            if ((i12 <= i13 && i10 < i13) || i10 <= i11) {
                b3 = 0;
            }
        }
        if (i3 == 1) {
            return b3 < 0 || (b3 == 0 && i4 * i5 <= 0);
        }
        if (i3 == 2) {
            return b3 > 0 || (b3 == 0 && i4 * i5 >= 0);
        }
        if (i3 == 17) {
            return i4 < 0;
        }
        if (i3 == 33) {
            return b3 < 0;
        }
        if (i3 == 66) {
            return i4 > 0;
        }
        if (i3 == 130) {
            return b3 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i3 + P());
    }

    private void w1() {
        this.f1745f0.g();
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.K1();
        }
    }

    private boolean x(int i3, int i4) {
        U(this.f1769r0);
        int[] iArr = this.f1769r0;
        return (iArr[0] == i3 && iArr[1] == i4) ? false : true;
    }

    public void A0(int i3) {
        int iG = this.f1744f.g();
        for (int i4 = 0; i4 < iG; i4++) {
            this.f1744f.f(i4).offsetLeftAndRight(i3);
        }
    }

    void B() {
        if (this.f1758m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f1760n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        a0 a0Var = this.f1751i0;
        a0Var.f1795j = false;
        if (a0Var.f1790e == 1) {
            C();
            this.f1760n.z1(this);
            D();
        } else if (!this.f1742e.q() && this.f1760n.o0() == getWidth() && this.f1760n.W() == getHeight()) {
            this.f1760n.z1(this);
        } else {
            this.f1760n.z1(this);
            D();
        }
        E();
    }

    public void B0(int i3) {
        int iG = this.f1744f.g();
        for (int i4 = 0; i4 < iG; i4++) {
            this.f1744f.f(i4).offsetTopAndBottom(i3);
        }
    }

    void C0(int i3, int i4) {
        int iJ = this.f1744f.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            d0 d0VarG0 = g0(this.f1744f.i(i5));
            if (d0VarG0 != null && !d0VarG0.J() && d0VarG0.f1815c >= i3) {
                d0VarG0.A(i4, false);
                this.f1751i0.f1792g = true;
            }
        }
        this.f1738c.u(i3, i4);
        requestLayout();
    }

    void D0(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int iJ = this.f1744f.j();
        if (i3 < i4) {
            i7 = -1;
            i6 = i3;
            i5 = i4;
        } else {
            i5 = i3;
            i6 = i4;
            i7 = 1;
        }
        for (int i9 = 0; i9 < iJ; i9++) {
            d0 d0VarG0 = g0(this.f1744f.i(i9));
            if (d0VarG0 != null && (i8 = d0VarG0.f1815c) >= i6 && i8 <= i5) {
                if (i8 == i3) {
                    d0VarG0.A(i4 - i3, false);
                } else {
                    d0VarG0.A(i7, false);
                }
                this.f1751i0.f1792g = true;
            }
        }
        this.f1738c.v(i3, i4);
        requestLayout();
    }

    void E0(int i3, int i4, boolean z2) {
        int i5 = i3 + i4;
        int iJ = this.f1744f.j();
        for (int i6 = 0; i6 < iJ; i6++) {
            d0 d0VarG0 = g0(this.f1744f.i(i6));
            if (d0VarG0 != null && !d0VarG0.J()) {
                int i7 = d0VarG0.f1815c;
                if (i7 >= i5) {
                    d0VarG0.A(-i4, z2);
                    this.f1751i0.f1792g = true;
                } else if (i7 >= i3) {
                    d0VarG0.i(i3 - 1, -i4, z2);
                    this.f1751i0.f1792g = true;
                }
            }
        }
        this.f1738c.w(i3, i4, z2);
        requestLayout();
    }

    public boolean F(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return getScrollingChildHelper().d(i3, i4, iArr, iArr2, i5);
    }

    public void F0(View view) {
    }

    public final void G(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        getScrollingChildHelper().e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    public void G0(View view) {
    }

    void H(int i3) {
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.e1(i3);
        }
        L0(i3);
        t tVar = this.f1753j0;
        if (tVar != null) {
            tVar.a(this, i3);
        }
        List<t> list = this.f1755k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f1755k0.get(size).a(this, i3);
            }
        }
    }

    void H0() {
        this.G++;
    }

    void I(int i3, int i4) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i3, scrollY - i4);
        M0(i3, i4);
        t tVar = this.f1753j0;
        if (tVar != null) {
            tVar.b(this, i3, i4);
        }
        List<t> list = this.f1755k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f1755k0.get(size).b(this, i3, i4);
            }
        }
        this.H--;
    }

    void I0() {
        J0(true);
    }

    void J() {
        int i3;
        for (int size = this.f1779w0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.f1779w0.get(size);
            if (d0Var.f1813a.getParent() == this && !d0Var.J() && (i3 = d0Var.f1829q) != -1) {
                e0.t.v0(d0Var.f1813a, i3);
                d0Var.f1829q = -1;
            }
        }
        this.f1779w0.clear();
    }

    void J0(boolean z2) {
        int i3 = this.G - 1;
        this.G = i3;
        if (i3 < 1) {
            this.G = 0;
            if (z2) {
                A();
                J();
            }
        }
    }

    void L() {
        if (this.M != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this, 3);
        this.M = edgeEffectA;
        if (this.f1748h) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void L0(int i3) {
    }

    void M() {
        if (this.J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this, 0);
        this.J = edgeEffectA;
        if (this.f1748h) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void M0(int i3, int i4) {
    }

    void N() {
        if (this.L != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this, 2);
        this.L = edgeEffectA;
        if (this.f1748h) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void N0() {
        if (this.f1763o0 || !this.f1770s) {
            return;
        }
        e0.t.e0(this, this.f1781x0);
        this.f1763o0 = true;
    }

    void O() {
        if (this.K != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this, 1);
        this.K = edgeEffectA;
        if (this.f1748h) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String P() {
        return " " + super.toString() + ", adapter:" + this.f1758m + ", layout:" + this.f1760n + ", context:" + getContext();
    }

    final void Q(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.f1801p = 0;
            a0Var.f1802q = 0;
        } else {
            OverScroller overScroller = this.f1745f0.f1806d;
            a0Var.f1801p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.f1802q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    void Q0(boolean z2) {
        this.F = z2 | this.F;
        this.E = true;
        z0();
    }

    public View R(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public d0 S(View view) {
        View viewR = R(view);
        if (viewR == null) {
            return null;
        }
        return f0(viewR);
    }

    void S0(d0 d0Var, l.c cVar) {
        d0Var.F(0, 8192);
        if (this.f1751i0.f1794i && d0Var.y() && !d0Var.v() && !d0Var.J()) {
            this.f1746g.c(c0(d0Var), d0Var);
        }
        this.f1746g.e(d0Var, cVar);
    }

    void V0() {
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.k1(this.f1738c);
            this.f1760n.l1(this.f1738c);
        }
        this.f1738c.c();
    }

    boolean W0(View view) {
        r1();
        boolean zR = this.f1744f.r(view);
        if (zR) {
            d0 d0VarG0 = g0(view);
            this.f1738c.J(d0VarG0);
            this.f1738c.C(d0VarG0);
        }
        t1(!zR);
        return zR;
    }

    public d0 X(int i3) {
        d0 d0Var = null;
        if (this.E) {
            return null;
        }
        int iJ = this.f1744f.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            d0 d0VarG0 = g0(this.f1744f.i(i4));
            if (d0VarG0 != null && !d0VarG0.v() && b0(d0VarG0) == i3) {
                if (!this.f1744f.n(d0VarG0.f1813a)) {
                    return d0VarG0;
                }
                d0Var = d0VarG0;
            }
        }
        return d0Var;
    }

    public void X0(n nVar) {
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.f1764p.remove(nVar);
        if (this.f1764p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        y0();
        requestLayout();
    }

    public d0 Y(long j3) {
        g gVar = this.f1758m;
        d0 d0Var = null;
        if (gVar != null && gVar.i()) {
            int iJ = this.f1744f.j();
            for (int i3 = 0; i3 < iJ; i3++) {
                d0 d0VarG0 = g0(this.f1744f.i(i3));
                if (d0VarG0 != null && !d0VarG0.v() && d0VarG0.k() == j3) {
                    if (!this.f1744f.n(d0VarG0.f1813a)) {
                        return d0VarG0;
                    }
                    d0Var = d0VarG0;
                }
            }
        }
        return d0Var;
    }

    public void Y0(s sVar) {
        this.f1766q.remove(sVar);
        if (this.f1768r == sVar) {
            this.f1768r = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036 A[SYNTHETIC] */
    d0 Z(int i3, boolean z2) {
        int iJ = this.f1744f.j();
        d0 d0Var = null;
        for (int i4 = 0; i4 < iJ; i4++) {
            d0 d0VarG0 = g0(this.f1744f.i(i4));
            if (d0VarG0 != null && !d0VarG0.v()) {
                if (z2) {
                    if (d0VarG0.f1815c != i3) {
                        continue;
                    } else {
                        if (this.f1744f.n(d0VarG0.f1813a)) {
                            return d0VarG0;
                        }
                        d0Var = d0VarG0;
                    }
                } else if (d0VarG0.m() != i3) {
                    continue;
                } else {
                    if (this.f1744f.n(d0VarG0.f1813a)) {
                        return d0VarG0;
                    }
                    d0Var = d0VarG0;
                }
            }
        }
        return d0Var;
    }

    public void Z0(t tVar) {
        List<t> list = this.f1755k0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    void a(int i3, int i4) {
        if (i3 < 0) {
            M();
            if (this.J.isFinished()) {
                this.J.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            N();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i3);
            }
        }
        if (i4 < 0) {
            O();
            if (this.K.isFinished()) {
                this.K.onAbsorb(-i4);
            }
        } else if (i4 > 0) {
            L();
            if (this.M.isFinished()) {
                this.M.onAbsorb(i4);
            }
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        e0.t.d0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean a0(int i3, int i4) {
        o oVar = this.f1760n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f1782y) {
            return false;
        }
        int iK = oVar.k();
        boolean zL = this.f1760n.l();
        if (iK == 0 || Math.abs(i3) < this.f1735a0) {
            i3 = 0;
        }
        if (!zL || Math.abs(i4) < this.f1735a0) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return false;
        }
        float f3 = i3;
        float f4 = i4;
        if (!dispatchNestedPreFling(f3, f4)) {
            boolean z2 = iK != 0 || zL;
            dispatchNestedFling(f3, f4, z2);
            r rVar = this.W;
            if (rVar != null && rVar.a(i3, i4)) {
                return true;
            }
            if (z2) {
                if (zL) {
                    iK = (iK == true ? 1 : 0) | 2;
                }
                s1(iK, 1);
                int i5 = this.f1737b0;
                int iMax = Math.max(-i5, Math.min(i3, i5));
                int i6 = this.f1737b0;
                this.f1745f0.c(iMax, Math.max(-i6, Math.min(i4, i6)));
                return true;
            }
        }
        return false;
    }

    void a1() {
        d0 d0Var;
        int iG = this.f1744f.g();
        for (int i3 = 0; i3 < iG; i3++) {
            View viewF = this.f1744f.f(i3);
            d0 d0VarF0 = f0(viewF);
            if (d0VarF0 != null && (d0Var = d0VarF0.f1821i) != null) {
                View view = d0Var.f1813a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i4) {
        o oVar = this.f1760n;
        if (oVar == null || !oVar.F0(this, arrayList, i3, i4)) {
            super.addFocusables(arrayList, i3, i4);
        }
    }

    int b0(d0 d0Var) {
        if (d0Var.p(524) || !d0Var.s()) {
            return -1;
        }
        return this.f1742e.e(d0Var.f1815c);
    }

    long c0(d0 d0Var) {
        return this.f1758m.i() ? d0Var.k() : d0Var.f1815c;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f1760n.m((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f1760n;
        if (oVar != null && oVar.k()) {
            return this.f1760n.q(this.f1751i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f1760n;
        if (oVar != null && oVar.k()) {
            return this.f1760n.r(this.f1751i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f1760n;
        if (oVar != null && oVar.k()) {
            return this.f1760n.s(this.f1751i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f1760n;
        if (oVar != null && oVar.l()) {
            return this.f1760n.t(this.f1751i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f1760n;
        if (oVar != null && oVar.l()) {
            return this.f1760n.u(this.f1751i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f1760n;
        if (oVar != null && oVar.l()) {
            return this.f1760n.v(this.f1751i0);
        }
        return 0;
    }

    public int d0(View view) {
        d0 d0VarG0 = g0(view);
        if (d0VarG0 != null) {
            return d0VarG0.j();
        }
        return -1;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z2) {
        return getScrollingChildHelper().a(f3, f4, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return getScrollingChildHelper().b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i3, i4, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return getScrollingChildHelper().f(i3, i4, i5, i6, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.f1764p.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.f1764p.get(i3).i(canvas, this, this.f1751i0);
        }
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f1748h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f1748h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1748h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.L;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1748h) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.N == null || this.f1764p.size() <= 0 || !this.N.p()) ? z2 : true) {
            e0.t.d0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        return super.drawChild(canvas, view, j3);
    }

    public int e0(View view) {
        d0 d0VarG0 = g0(view);
        if (d0VarG0 != null) {
            return d0VarG0.m();
        }
        return -1;
    }

    public d0 f0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return g0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void f1() {
        int iJ = this.f1744f.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            d0 d0VarG0 = g0(this.f1744f.i(i3));
            if (!d0VarG0.J()) {
                d0VarG0.E();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        View viewJ0;
        boolean z2;
        View viewQ0 = this.f1760n.Q0(view, i3);
        if (viewQ0 != null) {
            return viewQ0;
        }
        boolean z3 = (this.f1758m == null || this.f1760n == null || v0() || this.f1782y) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i3 == 2 || i3 == 1)) {
            if (this.f1760n.l()) {
                int i4 = i3 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i4) == null;
                if (E0) {
                    i3 = i4;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.f1760n.k()) {
                int i5 = (this.f1760n.Z() == 1) ^ (i3 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i5) == null;
                if (E0) {
                    i3 = i5;
                }
                z2 = z4;
            }
            if (z2) {
                u();
                if (R(view) == null) {
                    return null;
                }
                r1();
                this.f1760n.J0(view, i3, this.f1738c, this.f1751i0);
                t1(false);
            }
            viewJ0 = focusFinder.findNextFocus(this, view, i3);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i3);
            if (viewFindNextFocus == null && z3) {
                u();
                if (R(view) == null) {
                    return null;
                }
                r1();
                viewJ0 = this.f1760n.J0(view, i3, this.f1738c, this.f1751i0);
                t1(false);
            } else {
                viewJ0 = viewFindNextFocus;
            }
        }
        if (viewJ0 == null || viewJ0.hasFocusable()) {
            return w0(view, viewJ0, i3) ? viewJ0 : super.focusSearch(view, i3);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i3);
        }
        b1(viewJ0, null);
        return view;
    }

    boolean g1(int i3, int i4, MotionEvent motionEvent) {
        int i5;
        int i6;
        int i7;
        int i8;
        u();
        if (this.f1758m != null) {
            int[] iArr = this.f1777v0;
            iArr[0] = 0;
            iArr[1] = 0;
            h1(i3, i4, iArr);
            int[] iArr2 = this.f1777v0;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i5 = i10;
            i6 = i9;
            i7 = i3 - i9;
            i8 = i4 - i10;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.f1764p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f1777v0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        G(i6, i5, i7, i8, this.f1773t0, 0, iArr3);
        int[] iArr4 = this.f1777v0;
        int i11 = i7 - iArr4[0];
        int i12 = i8 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i13 = this.T;
        int[] iArr5 = this.f1773t0;
        this.T = i13 - iArr5[0];
        this.U -= iArr5[1];
        int[] iArr6 = this.f1775u0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !e0.i.a(motionEvent, 8194)) {
                R0(motionEvent.getX(), i11, motionEvent.getY(), i12);
            }
            t(i3, i4);
        }
        if (i6 != 0 || i5 != 0) {
            I(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i6 == 0 && i5 == 0) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f1760n;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f1760n;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.f1758m;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f1760n;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        j jVar = this.f1767q0;
        return jVar == null ? super.getChildDrawingOrder(i3, i4) : jVar.a(i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1748h;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.f1765p0;
    }

    public k getEdgeEffectFactory() {
        return this.I;
    }

    public l getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.f1764p.size();
    }

    public o getLayoutManager() {
        return this.f1760n;
    }

    public int getMaxFlingVelocity() {
        return this.f1737b0;
    }

    public int getMinFlingVelocity() {
        return this.f1735a0;
    }

    long getNanoTime() {
        if (D0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1743e0;
    }

    public u getRecycledViewPool() {
        return this.f1738c.i();
    }

    public int getScrollState() {
        return this.O;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    void h1(int i3, int i4, int[] iArr) {
        r1();
        H0();
        a0.c.a("RV Scroll");
        Q(this.f1751i0);
        int iW1 = i3 != 0 ? this.f1760n.w1(i3, this.f1738c, this.f1751i0) : 0;
        int iY1 = i4 != 0 ? this.f1760n.y1(i4, this.f1738c, this.f1751i0) : 0;
        a0.c.b();
        a1();
        I0();
        t1(false);
        if (iArr != null) {
            iArr[0] = iW1;
            iArr[1] = iY1;
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i3) {
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f1764p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i3 < 0) {
            this.f1764p.add(nVar);
        } else {
            this.f1764p.add(i3, nVar);
        }
        y0();
        requestLayout();
    }

    public void i1(int i3) {
        if (this.f1782y) {
            return;
        }
        v1();
        o oVar = this.f1760n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.x1(i3);
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f1770s;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f1782y;
    }

    @Override // android.view.View, e0.j
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(s sVar) {
        this.f1766q.add(sVar);
    }

    public void k(t tVar) {
        if (this.f1755k0 == null) {
            this.f1755k0 = new ArrayList();
        }
        this.f1755k0.add(tVar);
    }

    Rect k0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f1872c) {
            return pVar.f1871b;
        }
        if (this.f1751i0.e() && (pVar.b() || pVar.d())) {
            return pVar.f1871b;
        }
        Rect rect = pVar.f1871b;
        rect.set(0, 0, 0, 0);
        int size = this.f1764p.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1752j.set(0, 0, 0, 0);
            this.f1764p.get(i3).e(this.f1752j, view, this, this.f1751i0);
            int i4 = rect.left;
            Rect rect2 = this.f1752j;
            rect.left = i4 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f1872c = false;
        return rect;
    }

    boolean k1(d0 d0Var, int i3) {
        if (!v0()) {
            e0.t.v0(d0Var.f1813a, i3);
            return true;
        }
        d0Var.f1829q = i3;
        this.f1779w0.add(d0Var);
        return false;
    }

    void l(d0 d0Var, l.c cVar, l.c cVar2) {
        d0Var.G(false);
        if (this.N.a(d0Var, cVar, cVar2)) {
            N0();
        }
    }

    boolean l1(AccessibilityEvent accessibilityEvent) {
        if (!v0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? f0.b.a(accessibilityEvent) : 0;
        this.A |= iA != 0 ? iA : 0;
        return true;
    }

    public boolean m0() {
        return !this.f1776v || this.E || this.f1742e.p();
    }

    public void m1(int i3, int i4) {
        n1(i3, i4, null);
    }

    void n(d0 d0Var, l.c cVar, l.c cVar2) {
        g(d0Var);
        d0Var.G(false);
        if (this.N.c(d0Var, cVar, cVar2)) {
            N0();
        }
    }

    public void n1(int i3, int i4, Interpolator interpolator) {
        o1(i3, i4, interpolator, Integer.MIN_VALUE);
    }

    void o(String str) {
        if (v0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + P());
        }
        if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.FLAVOR + P()));
        }
    }

    void o0() {
        this.f1742e = new androidx.recyclerview.widget.a(new f());
    }

    public void o1(int i3, int i4, Interpolator interpolator, int i5) {
        p1(i3, i4, interpolator, i5, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = 0;
        this.f1770s = true;
        this.f1776v = this.f1776v && !isLayoutRequested();
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.z(this);
        }
        this.f1763o0 = false;
        if (D0) {
            ThreadLocal<androidx.recyclerview.widget.e> threadLocal = androidx.recyclerview.widget.e.f2044f;
            androidx.recyclerview.widget.e eVar = threadLocal.get();
            this.f1747g0 = eVar;
            if (eVar == null) {
                this.f1747g0 = new androidx.recyclerview.widget.e();
                Display displayV = e0.t.v(this);
                float f3 = 60.0f;
                if (!isInEditMode() && displayV != null) {
                    float refreshRate = displayV.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f3 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.e eVar2 = this.f1747g0;
                eVar2.f2048d = (long) (1.0E9f / f3);
                threadLocal.set(eVar2);
            }
            this.f1747g0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        v1();
        this.f1770s = false;
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.A(this, this.f1738c);
        }
        this.f1779w0.clear();
        removeCallbacks(this.f1781x0);
        this.f1746g.j();
        if (!D0 || (eVar = this.f1747g0) == null) {
            return;
        }
        eVar.j(this);
        this.f1747g0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f1764p.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1764p.get(i3).g(canvas, this, this.f1751i0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f3;
        float axisValue;
        if (this.f1760n != null && !this.f1782y && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.f1760n.l() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f1760n.k() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f1760n.l()) {
                    f3 = -axisValue2;
                } else if (this.f1760n.k()) {
                    axisValue = axisValue2;
                    f3 = 0.0f;
                } else {
                    f3 = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f3 = 0.0f;
                axisValue = 0.0f;
            }
            if (f3 != 0.0f || axisValue != 0.0f) {
                g1((int) (axisValue * this.f1739c0), (int) (f3 * this.f1741d0), motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.f1782y) {
            return false;
        }
        this.f1768r = null;
        if (T(motionEvent)) {
            q();
            return true;
        }
        o oVar = this.f1760n;
        if (oVar == null) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.f1760n.l();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f1784z) {
                this.f1784z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.T = x3;
            this.R = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.U = y3;
            this.S = y3;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                u1(1);
            }
            int[] iArr = this.f1775u0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i3 = zK;
            if (zL) {
                i3 = (zK ? 1 : 0) | 2;
            }
            s1(i3, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            u1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.P);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x4 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i4 = x4 - this.R;
                int i5 = y4 - this.S;
                if (!zK || Math.abs(i4) <= this.V) {
                    z2 = false;
                } else {
                    this.T = x4;
                    z2 = true;
                }
                if (zL && Math.abs(i5) > this.V) {
                    this.U = y4;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x5;
            this.R = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y5;
            this.S = y5;
        } else if (actionMasked == 6) {
            K0(motionEvent);
        }
        return this.O == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        a0.c.a("RV OnLayout");
        B();
        a0.c.b();
        this.f1776v = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        o oVar = this.f1760n;
        if (oVar == null) {
            w(i3, i4);
            return;
        }
        boolean z2 = false;
        if (oVar.s0()) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f1760n.Z0(this.f1738c, this.f1751i0, i3, i4);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (z2 || this.f1758m == null) {
                return;
            }
            if (this.f1751i0.f1790e == 1) {
                C();
            }
            this.f1760n.A1(i3, i4);
            this.f1751i0.f1795j = true;
            D();
            this.f1760n.D1(i3, i4);
            if (this.f1760n.G1()) {
                this.f1760n.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f1751i0.f1795j = true;
                D();
                this.f1760n.D1(i3, i4);
                return;
            }
            return;
        }
        if (this.f1772t) {
            this.f1760n.Z0(this.f1738c, this.f1751i0, i3, i4);
            return;
        }
        if (this.B) {
            r1();
            H0();
            P0();
            I0();
            a0 a0Var = this.f1751i0;
            if (a0Var.f1797l) {
                a0Var.f1793h = true;
            } else {
                this.f1742e.j();
                this.f1751i0.f1793h = false;
            }
            this.B = false;
            t1(false);
        } else if (this.f1751i0.f1797l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f1758m;
        if (gVar != null) {
            this.f1751i0.f1791f = gVar.e();
        } else {
            this.f1751i0.f1791f = 0;
        }
        r1();
        this.f1760n.Z0(this.f1738c, this.f1751i0, i3, i4);
        t1(false);
        this.f1751i0.f1793h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (v0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.f1740d = yVar;
        super.onRestoreInstanceState(yVar.j());
        o oVar = this.f1760n;
        if (oVar == null || (parcelable2 = this.f1740d.f1889d) == null) {
            return;
        }
        oVar.c1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f1740d;
        if (yVar2 != null) {
            yVar.k(yVar2);
        } else {
            o oVar = this.f1760n;
            if (oVar != null) {
                yVar.f1889d = oVar.d1();
            } else {
                yVar.f1889d = null;
            }
        }
        return yVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 == i5 && i4 == i6) {
            return;
        }
        s0();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00df A[PHI: r0
  0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        boolean z2;
        boolean z3 = false;
        if (this.f1782y || this.f1784z) {
            return false;
        }
        if (K(motionEvent)) {
            q();
            return true;
        }
        o oVar = this.f1760n;
        if (oVar == null) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.f1760n.l();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.f1775u0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.f1775u0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.P = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.T = x3;
            this.R = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.U = y3;
            this.S = y3;
            if (zL) {
                i3 = zK;
                i3 = (zK ? 1 : 0) | 2;
            }
            i3 = zK;
            s1(i3, 0);
        } else if (actionMasked == 1) {
            this.Q.addMovement(motionEventObtain);
            this.Q.computeCurrentVelocity(1000, this.f1737b0);
            float f3 = zK ? -this.Q.getXVelocity(this.P) : 0.0f;
            float f4 = zL ? -this.Q.getYVelocity(this.P) : 0.0f;
            if ((f3 == 0.0f && f4 == 0.0f) || !a0((int) f3, (int) f4)) {
                setScrollState(0);
            }
            d1();
            z3 = true;
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.P);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x4 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int iMax = this.T - x4;
            int iMax2 = this.U - y4;
            if (this.O != 1) {
                if (zK) {
                    iMax = iMax > 0 ? Math.max(0, iMax - this.V) : Math.min(0, iMax + this.V);
                    if (iMax != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (zL) {
                    iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.V) : Math.min(0, iMax2 + this.V);
                    if (iMax2 != 0) {
                        z2 = true;
                    }
                }
                if (z2) {
                    setScrollState(1);
                }
            }
            int i4 = iMax;
            int i5 = iMax2;
            if (this.O == 1) {
                int[] iArr3 = this.f1777v0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (F(zK ? i4 : 0, zL ? i5 : 0, iArr3, this.f1773t0, 0)) {
                    int[] iArr4 = this.f1777v0;
                    i4 -= iArr4[0];
                    i5 -= iArr4[1];
                    int[] iArr5 = this.f1775u0;
                    int i6 = iArr5[0];
                    int[] iArr6 = this.f1773t0;
                    iArr5[0] = i6 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i7 = i5;
                int[] iArr7 = this.f1773t0;
                this.T = x4 - iArr7[0];
                this.U = y4 - iArr7[1];
                if (g1(zK ? i4 : 0, zL ? i7 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                androidx.recyclerview.widget.e eVar = this.f1747g0;
                if (eVar != null && (i4 != 0 || i7 != 0)) {
                    eVar.f(this, i4, i7);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x5;
            this.R = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y5;
            this.S = y5;
        } else if (actionMasked == 6) {
            K0(motionEvent);
        }
        if (!z3) {
            this.Q.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    boolean p(d0 d0Var) {
        l lVar = this.N;
        return lVar == null || lVar.g(d0Var, d0Var.o());
    }

    void p1(int i3, int i4, Interpolator interpolator, int i5, boolean z2) {
        o oVar = this.f1760n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1782y) {
            return;
        }
        if (!oVar.k()) {
            i3 = 0;
        }
        if (!this.f1760n.l()) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        if (!(i5 == Integer.MIN_VALUE || i5 > 0)) {
            scrollBy(i3, i4);
            return;
        }
        if (z2) {
            int i6 = i3 != 0 ? 1 : 0;
            if (i4 != 0) {
                i6 |= 2;
            }
            s1(i6, 1);
        }
        this.f1745f0.f(i3, i4, i5, interpolator);
    }

    public void q1(int i3) {
        if (this.f1782y) {
            return;
        }
        o oVar = this.f1760n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.I1(this, this.f1751i0, i3);
        }
    }

    void r0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(o0.b.fastscroll_default_thickness), resources.getDimensionPixelSize(o0.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(o0.b.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + P());
        }
    }

    void r1() {
        int i3 = this.f1778w + 1;
        this.f1778w = i3;
        if (i3 != 1 || this.f1782y) {
            return;
        }
        this.f1780x = false;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        d0 d0VarG0 = g0(view);
        if (d0VarG0 != null) {
            if (d0VarG0.x()) {
                d0VarG0.f();
            } else if (!d0VarG0.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + d0VarG0 + P());
            }
        }
        view.clearAnimation();
        z(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f1760n.b1(this, this.f1751i0, view, view2) && view2 != null) {
            b1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.f1760n.r1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.f1766q.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1766q.get(i3).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f1778w != 0 || this.f1782y) {
            this.f1780x = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int iJ = this.f1744f.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            d0 d0VarG0 = g0(this.f1744f.i(i3));
            if (!d0VarG0.J()) {
                d0VarG0.c();
            }
        }
        this.f1738c.d();
    }

    void s0() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    public boolean s1(int i3, int i4) {
        return getScrollingChildHelper().p(i3, i4);
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i4) {
        o oVar = this.f1760n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1782y) {
            return;
        }
        boolean zK = oVar.k();
        boolean zL = this.f1760n.l();
        if (zK || zL) {
            if (!zK) {
                i3 = 0;
            }
            if (!zL) {
                i4 = 0;
            }
            g1(i3, i4, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (l1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k kVar) {
        this.f1765p0 = kVar;
        e0.t.m0(this, kVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        j1(gVar, false, true);
        Q0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.f1767q0) {
            return;
        }
        this.f1767q0 = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.f1748h) {
            s0();
        }
        this.f1748h = z2;
        super.setClipToPadding(z2);
        if (this.f1776v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        d0.i.c(kVar);
        this.I = kVar;
        s0();
    }

    public void setHasFixedSize(boolean z2) {
        this.f1772t = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.N;
        if (lVar2 != null) {
            lVar2.k();
            this.N.v(null);
        }
        this.N = lVar;
        if (lVar != null) {
            lVar.v(this.f1761n0);
        }
    }

    public void setItemViewCacheSize(int i3) {
        this.f1738c.G(i3);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f1760n) {
            return;
        }
        v1();
        if (this.f1760n != null) {
            l lVar = this.N;
            if (lVar != null) {
                lVar.k();
            }
            this.f1760n.k1(this.f1738c);
            this.f1760n.l1(this.f1738c);
            this.f1738c.c();
            if (this.f1770s) {
                this.f1760n.A(this, this.f1738c);
            }
            this.f1760n.E1(null);
            this.f1760n = null;
        } else {
            this.f1738c.c();
        }
        this.f1744f.o();
        this.f1760n = oVar;
        if (oVar != null) {
            if (oVar.f1847b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f1847b.P());
            }
            oVar.E1(this);
            if (this.f1770s) {
                this.f1760n.z(this);
            }
        }
        this.f1738c.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    public void setOnFlingListener(r rVar) {
        this.W = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f1753j0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.f1743e0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.f1738c.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.f1762o = wVar;
    }

    void setScrollState(int i3) {
        if (i3 == this.O) {
            return;
        }
        this.O = i3;
        if (i3 != 2) {
            w1();
        }
        H(i3);
    }

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.V = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
        }
        this.V = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f1738c.F(b0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().o(i3);
    }

    @Override // android.view.View, e0.j
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.f1782y) {
            o("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f1782y = true;
                this.f1784z = true;
                v1();
                return;
            }
            this.f1782y = false;
            if (this.f1780x && this.f1760n != null && this.f1758m != null) {
                requestLayout();
            }
            this.f1780x = false;
        }
    }

    void t(int i3, int i4) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i3 <= 0) {
            zIsFinished = false;
        } else {
            this.J.onRelease();
            zIsFinished = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i3 < 0) {
            this.L.onRelease();
            zIsFinished |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i4 > 0) {
            this.K.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i4 < 0) {
            this.M.onRelease();
            zIsFinished |= this.M.isFinished();
        }
        if (zIsFinished) {
            e0.t.d0(this);
        }
    }

    public void t0() {
        if (this.f1764p.size() == 0) {
            return;
        }
        o oVar = this.f1760n;
        if (oVar != null) {
            oVar.g("Cannot invalidate item decorations during a scroll or layout");
        }
        y0();
        requestLayout();
    }

    void t1(boolean z2) {
        if (this.f1778w < 1) {
            this.f1778w = 1;
        }
        if (!z2 && !this.f1782y) {
            this.f1780x = false;
        }
        if (this.f1778w == 1) {
            if (z2 && this.f1780x && !this.f1782y && this.f1760n != null && this.f1758m != null) {
                B();
            }
            if (!this.f1782y) {
                this.f1780x = false;
            }
        }
        this.f1778w--;
    }

    void u() {
        if (!this.f1776v || this.E) {
            a0.c.a("RV FullInvalidate");
            B();
            a0.c.b();
            return;
        }
        if (this.f1742e.p()) {
            if (!this.f1742e.o(4) || this.f1742e.o(11)) {
                if (this.f1742e.p()) {
                    a0.c.a("RV FullInvalidate");
                    B();
                    a0.c.b();
                    return;
                }
                return;
            }
            a0.c.a("RV PartialInvalidate");
            r1();
            H0();
            this.f1742e.t();
            if (!this.f1780x) {
                if (n0()) {
                    B();
                } else {
                    this.f1742e.i();
                }
            }
            t1(true);
            I0();
            a0.c.b();
        }
    }

    boolean u0() {
        AccessibilityManager accessibilityManager = this.C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void u1(int i3) {
        getScrollingChildHelper().r(i3);
    }

    public boolean v0() {
        return this.G > 0;
    }

    public void v1() {
        setScrollState(0);
        w1();
    }

    void w(int i3, int i4) {
        setMeasuredDimension(o.n(i3, getPaddingLeft() + getPaddingRight(), e0.t.D(this)), o.n(i4, getPaddingTop() + getPaddingBottom(), e0.t.C(this)));
    }

    void x0(int i3) {
        if (this.f1760n == null) {
            return;
        }
        setScrollState(2);
        this.f1760n.x1(i3);
        awakenScrollBars();
    }

    void x1(int i3, int i4, Object obj) {
        int i5;
        int iJ = this.f1744f.j();
        int i6 = i3 + i4;
        for (int i7 = 0; i7 < iJ; i7++) {
            View viewI = this.f1744f.i(i7);
            d0 d0VarG0 = g0(viewI);
            if (d0VarG0 != null && !d0VarG0.J() && (i5 = d0VarG0.f1815c) >= i3 && i5 < i6) {
                d0VarG0.b(2);
                d0VarG0.a(obj);
                ((p) viewI.getLayoutParams()).f1872c = true;
            }
        }
        this.f1738c.M(i3, i4);
    }

    void y(View view) {
        d0 d0VarG0 = g0(view);
        F0(view);
        g gVar = this.f1758m;
        if (gVar != null && d0VarG0 != null) {
            gVar.r(d0VarG0);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).a(view);
            }
        }
    }

    void y0() {
        int iJ = this.f1744f.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            ((p) this.f1744f.i(i3).getLayoutParams()).f1872c = true;
        }
        this.f1738c.s();
    }

    void z(View view) {
        d0 d0VarG0 = g0(view);
        G0(view);
        g gVar = this.f1758m;
        if (gVar != null && d0VarG0 != null) {
            gVar.s(d0VarG0);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).b(view);
            }
        }
    }

    void z0() {
        int iJ = this.f1744f.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            d0 d0VarG0 = g0(this.f1744f.i(i3));
            if (d0VarG0 != null && !d0VarG0.J()) {
                d0VarG0.b(6);
            }
        }
        y0();
        this.f1738c.t();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, o0.a.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1736b = new x();
        this.f1738c = new v();
        this.f1746g = new androidx.recyclerview.widget.p();
        this.f1750i = new a();
        this.f1752j = new Rect();
        this.f1754k = new Rect();
        this.f1756l = new RectF();
        this.f1764p = new ArrayList<>();
        this.f1766q = new ArrayList<>();
        this.f1778w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new k();
        this.N = new androidx.recyclerview.widget.c();
        this.O = 0;
        this.P = -1;
        this.f1739c0 = Float.MIN_VALUE;
        this.f1741d0 = Float.MIN_VALUE;
        boolean z2 = true;
        this.f1743e0 = true;
        this.f1745f0 = new c0();
        this.f1749h0 = D0 ? new androidx.recyclerview.widget.e.b() : null;
        this.f1751i0 = new a0();
        this.f1757l0 = false;
        this.f1759m0 = false;
        this.f1761n0 = new m();
        this.f1763o0 = false;
        this.f1769r0 = new int[2];
        this.f1773t0 = new int[2];
        this.f1775u0 = new int[2];
        this.f1777v0 = new int[2];
        this.f1779w0 = new ArrayList();
        this.f1781x0 = new b();
        this.f1783y0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.f1739c0 = e0.u.b(viewConfiguration, context);
        this.f1741d0 = e0.u.d(viewConfiguration, context);
        this.f1735a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1737b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.v(this.f1761n0);
        o0();
        q0();
        p0();
        if (e0.t.z(this) == 0) {
            e0.t.v0(this, 1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        int[] iArr = o0.c.RecyclerView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(o0.c.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(o0.c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1748h = typedArrayObtainStyledAttributes.getBoolean(o0.c.RecyclerView_android_clipToPadding, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(o0.c.RecyclerView_fastScrollEnabled, false);
        this.f1774u = z3;
        if (z3) {
            r0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(o0.c.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(o0.c.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(o0.c.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(o0.c.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        v(context, string, attributeSet, i3, 0);
        if (i4 >= 21) {
            int[] iArr2 = f1734z0;
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i3, 0);
            if (i4 >= 29) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i3, 0);
            }
            z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d0 f1870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Rect f1871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1873d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1871b = new Rect();
            this.f1872c = true;
            this.f1873d = false;
        }

        public int a() {
            return this.f1870a.m();
        }

        public boolean b() {
            return this.f1870a.y();
        }

        public boolean c() {
            return this.f1870a.v();
        }

        public boolean d() {
            return this.f1870a.t();
        }

        public p(int i3, int i4) {
            super(i3, i4);
            this.f1871b = new Rect();
            this.f1872c = true;
            this.f1873d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1871b = new Rect();
            this.f1872c = true;
            this.f1873d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1871b = new Rect();
            this.f1872c = true;
            this.f1873d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f1871b = new Rect();
            this.f1872c = true;
            this.f1873d = false;
        }
    }

    public static class y extends i0.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Parcelable f1889d;

        static class a implements Parcelable.ClassLoaderCreator<y> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public y[] newArray(int i3) {
                return new y[i3];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1889d = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        void k(y yVar) {
            this.f1889d = yVar.f1889d;
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.f1889d, 0);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f1760n;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }
}
