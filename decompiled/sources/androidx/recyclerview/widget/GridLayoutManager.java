package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean I;
    int J;
    int[] K;
    View[] L;
    final SparseIntArray M;
    final SparseIntArray N;
    c O;
    final Rect P;
    private boolean Q;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i3, int i4) {
            return i3 % i4;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i3) {
            return 1;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f1697a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseIntArray f1698b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1699c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1700d = false;

        static int a(SparseIntArray sparseIntArray, int i3) {
            int size = sparseIntArray.size() - 1;
            int i4 = 0;
            while (i4 <= size) {
                int i5 = (i4 + size) >>> 1;
                if (sparseIntArray.keyAt(i5) < i3) {
                    i4 = i5 + 1;
                } else {
                    size = i5 - 1;
                }
            }
            int i6 = i4 - 1;
            if (i6 < 0 || i6 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i6);
        }

        int b(int i3, int i4) {
            if (!this.f1700d) {
                return d(i3, i4);
            }
            int i5 = this.f1698b.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int iD = d(i3, i4);
            this.f1698b.put(i3, iD);
            return iD;
        }

        int c(int i3, int i4) {
            if (!this.f1699c) {
                return e(i3, i4);
            }
            int i5 = this.f1697a.get(i3, -1);
            if (i5 != -1) {
                return i5;
            }
            int iE = e(i3, i4);
            this.f1697a.put(i3, iE);
            return iE;
        }

        public int d(int i3, int i4) {
            int i5;
            int i6;
            int iC;
            int iA;
            if (!this.f1700d || (iA = a(this.f1698b, i3)) == -1) {
                i5 = 0;
                i6 = 0;
                iC = 0;
            } else {
                i5 = this.f1698b.get(iA);
                i6 = iA + 1;
                iC = c(iA, i4) + f(iA);
                if (iC == i4) {
                    i5++;
                    iC = 0;
                }
            }
            int iF = f(i3);
            while (i6 < i3) {
                int iF2 = f(i6);
                iC += iF2;
                if (iC == i4) {
                    i5++;
                    iC = 0;
                } else if (iC > i4) {
                    i5++;
                    iC = iF2;
                }
                i6++;
            }
            return iC + iF > i4 ? i5 + 1 : i5;
        }

        public abstract int e(int i3, int i4);

        public abstract int f(int i3);

        public void g() {
            this.f1698b.clear();
        }

        public void h() {
            this.f1697a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        e3(RecyclerView.o.i0(context, attributeSet, i3, i4).f1867b);
    }

    private void N2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i3, boolean z2) {
        int i4;
        int i5;
        int i6 = 0;
        int i7 = -1;
        if (z2) {
            i5 = 1;
            i7 = i3;
            i4 = 0;
        } else {
            i4 = i3 - 1;
            i5 = -1;
        }
        while (i4 != i7) {
            View view = this.L[i4];
            b bVar = (b) view.getLayoutParams();
            int iA3 = a3(vVar, a0Var, h0(view));
            bVar.f1696f = iA3;
            bVar.f1695e = i6;
            i6 += iA3;
            i4 += i5;
        }
    }

    private void O2() {
        int iJ = J();
        for (int i3 = 0; i3 < iJ; i3++) {
            b bVar = (b) I(i3).getLayoutParams();
            int iA = bVar.a();
            this.M.put(iA, bVar.f());
            this.N.put(iA, bVar.e());
        }
    }

    private void P2(int i3) {
        this.K = Q2(this.K, this.J, i3);
    }

    static int[] Q2(int[] iArr, int i3, int i4) {
        int i5;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i4) {
            iArr = new int[i3 + 1];
        }
        int i6 = 0;
        iArr[0] = 0;
        int i7 = i4 / i3;
        int i8 = i4 % i3;
        int i9 = 0;
        for (int i10 = 1; i10 <= i3; i10++) {
            i6 += i8;
            if (i6 <= 0 || i3 - i6 >= i8) {
                i5 = i7;
            } else {
                i5 = i7 + 1;
                i6 -= i3;
            }
            i9 += i5;
            iArr[i10] = i9;
        }
        return iArr;
    }

    private void R2() {
        this.M.clear();
        this.N.clear();
    }

    private int S2(RecyclerView.a0 a0Var) {
        if (J() != 0 && a0Var.b() != 0) {
            T1();
            boolean zR2 = r2();
            View viewY1 = Y1(!zR2, true);
            View viewX1 = X1(!zR2, true);
            if (viewY1 != null && viewX1 != null) {
                int iB = this.O.b(h0(viewY1), this.J);
                int iB2 = this.O.b(h0(viewX1), this.J);
                int iMax = this.f1706x ? Math.max(0, ((this.O.b(a0Var.b() - 1, this.J) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zR2) {
                    return Math.round((iMax * (Math.abs(this.f1703u.d(viewX1) - this.f1703u.g(viewY1)) / ((this.O.b(h0(viewX1), this.J) - this.O.b(h0(viewY1), this.J)) + 1))) + (this.f1703u.m() - this.f1703u.g(viewY1)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int T2(RecyclerView.a0 a0Var) {
        if (J() != 0 && a0Var.b() != 0) {
            T1();
            View viewY1 = Y1(!r2(), true);
            View viewX1 = X1(!r2(), true);
            if (viewY1 != null && viewX1 != null) {
                if (!r2()) {
                    return this.O.b(a0Var.b() - 1, this.J) + 1;
                }
                return (int) (((this.f1703u.d(viewX1) - this.f1703u.g(viewY1)) / ((this.O.b(h0(viewX1), this.J) - this.O.b(h0(viewY1), this.J)) + 1)) * (this.O.b(a0Var.b() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    private void U2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i3) {
        boolean z2 = i3 == 1;
        int iZ2 = Z2(vVar, a0Var, aVar.f1710b);
        if (z2) {
            while (iZ2 > 0) {
                int i4 = aVar.f1710b;
                if (i4 <= 0) {
                    return;
                }
                int i5 = i4 - 1;
                aVar.f1710b = i5;
                iZ2 = Z2(vVar, a0Var, i5);
            }
            return;
        }
        int iB = a0Var.b() - 1;
        int i6 = aVar.f1710b;
        while (i6 < iB) {
            int i7 = i6 + 1;
            int iZ3 = Z2(vVar, a0Var, i7);
            if (iZ3 <= iZ2) {
                break;
            }
            i6 = i7;
            iZ2 = iZ3;
        }
        aVar.f1710b = i6;
    }

    private void V2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int Y2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i3) {
        if (!a0Var.e()) {
            return this.O.b(i3, this.J);
        }
        int iF = vVar.f(i3);
        if (iF != -1) {
            return this.O.b(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i3);
        return 0;
    }

    private int Z2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i3) {
        if (!a0Var.e()) {
            return this.O.c(i3, this.J);
        }
        int i4 = this.N.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int iF = vVar.f(i3);
        if (iF != -1) {
            return this.O.c(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 0;
    }

    private int a3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i3) {
        if (!a0Var.e()) {
            return this.O.f(i3);
        }
        int i4 = this.M.get(i3, -1);
        if (i4 != -1) {
            return i4;
        }
        int iF = vVar.f(i3);
        if (iF != -1) {
            return this.O.f(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
        return 1;
    }

    private void b3(float f3, int i3) {
        P2(Math.max(Math.round(f3 * this.J), i3));
    }

    private void c3(View view, int i3, boolean z2) {
        int iK;
        int iK2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1871b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iW2 = W2(bVar.f1695e, bVar.f1696f);
        if (this.f1701s == 1) {
            iK2 = RecyclerView.o.K(iW2, i3, i5, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iK = RecyclerView.o.K(this.f1703u.n(), X(), i4, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iK3 = RecyclerView.o.K(iW2, i3, i4, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iK4 = RecyclerView.o.K(this.f1703u.n(), p0(), i5, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iK = iK3;
            iK2 = iK4;
        }
        d3(view, iK2, iK, z2);
    }

    private void d3(View view, int i3, int i4, boolean z2) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z2 ? H1(view, i3, i4, pVar) : F1(view, i3, i4, pVar)) {
            view.measure(i3, i4);
        }
    }

    private void f3() {
        int iW;
        int iG0;
        if (p2() == 1) {
            iW = o0() - f0();
            iG0 = e0();
        } else {
            iW = W() - d0();
            iG0 = g0();
        }
        P2(iW - iG0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i3, int i4) {
        int iN;
        int iN2;
        if (this.K == null) {
            super.C1(rect, i3, i4);
        }
        int iE0 = e0() + f0();
        int iG0 = g0() + d0();
        if (this.f1701s == 1) {
            iN2 = RecyclerView.o.n(i4, rect.height() + iG0, b0());
            int[] iArr = this.K;
            iN = RecyclerView.o.n(i3, iArr[iArr.length - 1] + iE0, c0());
        } else {
            iN = RecyclerView.o.n(i3, rect.width() + iE0, c0());
            int[] iArr2 = this.K;
            iN2 = RecyclerView.o.n(i4, iArr2[iArr2.length - 1] + iG0, b0());
        }
        B1(iN, iN2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f1701s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void E2(boolean z2) {
        if (z2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.E2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View J0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.J0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1701s == 1) {
            return this.J;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return Y2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void N1(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int iF = this.J;
        for (int i3 = 0; i3 < this.J && cVar.c(a0Var) && iF > 0; i3++) {
            int i4 = cVar.f1721d;
            cVar2.a(i4, Math.max(0, cVar.f1724g));
            iF -= this.O.f(i4);
            cVar.f1721d += cVar.f1722e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, f0.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.O0(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iY2 = Y2(vVar, a0Var, bVar.a());
        if (this.f1701s == 0) {
            dVar.a0(f0.d.c.f(bVar.e(), bVar.f(), iY2, 1, false, false));
        } else {
            dVar.a0(f0.d.c.f(iY2, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i3, int i4) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i3, int i4, int i5) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i3, int i4) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i3, int i4, Object obj) {
        this.O.h();
        this.O.g();
    }

    int W2(int i3, int i4) {
        if (this.f1701s != 1 || !q2()) {
            int[] iArr = this.K;
            return iArr[i4 + i3] - iArr[i3];
        }
        int[] iArr2 = this.K;
        int i5 = this.J;
        return iArr2[i5 - i3] - iArr2[(i5 - i3) - i4];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            O2();
        }
        super.X0(vVar, a0Var);
        R2();
    }

    public int X2() {
        return this.J;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.I = false;
    }

    public void e3(int i3) {
        if (i3 == this.J) {
            return;
        }
        this.I = true;
        if (i3 >= 1) {
            this.J = i3;
            this.O.h();
            t1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i3);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i3, int i4, int i5) {
        T1();
        int iM = this.f1703u.m();
        int i6 = this.f1703u.i();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i3 != i4) {
            View viewI = I(i3);
            int iH0 = h0(viewI);
            if (iH0 >= 0 && iH0 < i5 && Z2(vVar, a0Var, iH0) == 0) {
                if (((RecyclerView.p) viewI.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.f1703u.g(viewI) < i6 && this.f1703u.d(viewI) >= iM) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i3 += i7;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1701s == 0) {
            return this.J;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return Y2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return this.Q ? S2(a0Var) : super.r(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return this.Q ? T2(a0Var) : super.s(a0Var);
    }

    /* JADX WARN: Code duplicated, block: B:98:0x0218  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i3;
        int iF;
        int i4;
        int i5;
        int i6;
        int iF2;
        int iF3;
        int i7;
        int iK;
        int iK2;
        View viewD;
        int iL = this.f1703u.l();
        ?? r5 = 0;
        boolean z2 = iL != 1073741824;
        int i8 = J() > 0 ? this.K[this.J] : 0;
        if (z2) {
            f3();
        }
        boolean z3 = cVar.f1722e == 1;
        int iZ2 = this.J;
        if (!z3) {
            iZ2 = Z2(vVar, a0Var, cVar.f1721d) + a3(vVar, a0Var, cVar.f1721d);
        }
        int i9 = 0;
        while (i9 < this.J && cVar.c(a0Var) && iZ2 > 0) {
            int i10 = cVar.f1721d;
            int iA3 = a3(vVar, a0Var, i10);
            if (iA3 > this.J) {
                throw new IllegalArgumentException("Item at position " + i10 + " requires " + iA3 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
            iZ2 -= iA3;
            if (iZ2 < 0 || (viewD = cVar.d(vVar)) == null) {
                break;
            }
            this.L[i9] = viewD;
            i9++;
        }
        if (i9 == 0) {
            bVar.f1715b = true;
            return;
        }
        float f3 = 0.0f;
        N2(vVar, a0Var, i9, z3);
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            View view = this.L[i11];
            if (cVar.f1729l == null) {
                if (z3) {
                    d(view);
                } else {
                    e(view, r5);
                }
            } else if (z3) {
                b(view);
            } else {
                c(view, r5);
            }
            j(view, this.P);
            c3(view, iL, r5);
            int iE = this.f1703u.e(view);
            if (iE > i12) {
                i12 = iE;
            }
            float f4 = (this.f1703u.f(view) * 1.0f) / ((b) view.getLayoutParams()).f1696f;
            if (f4 > f3) {
                f3 = f4;
            }
            i11++;
            r5 = 0;
        }
        if (z2) {
            b3(f3, i8);
            i12 = 0;
            for (int i13 = 0; i13 < i9; i13++) {
                View view2 = this.L[i13];
                c3(view2, 1073741824, true);
                int iE2 = this.f1703u.e(view2);
                if (iE2 > i12) {
                    i12 = iE2;
                }
            }
        }
        for (int i14 = 0; i14 < i9; i14++) {
            View view3 = this.L[i14];
            if (this.f1703u.e(view3) != i12) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f1871b;
                int i15 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i16 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int iW2 = W2(bVar2.f1695e, bVar2.f1696f);
                if (this.f1701s == 1) {
                    iK2 = RecyclerView.o.K(iW2, 1073741824, i16, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    iK = View.MeasureSpec.makeMeasureSpec(i12 - i15, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - i16, 1073741824);
                    iK = RecyclerView.o.K(iW2, 1073741824, i15, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    iK2 = iMakeMeasureSpec;
                }
                d3(view3, iK2, iK, true);
            }
        }
        int i17 = 0;
        bVar.f1714a = i12;
        if (this.f1701s == 1) {
            if (cVar.f1723f == -1) {
                i4 = cVar.f1719b;
                i5 = i4 - i12;
            } else {
                int i18 = cVar.f1719b;
                i5 = i18;
                i4 = i12 + i18;
            }
            i3 = 0;
            iF = 0;
        } else if (cVar.f1723f == -1) {
            int i19 = cVar.f1719b;
            iF = i19 - i12;
            i5 = 0;
            i3 = i19;
            i4 = 0;
        } else {
            int i20 = cVar.f1719b;
            i3 = i12 + i20;
            iF = i20;
            i4 = 0;
            i5 = 0;
        }
        while (i17 < i9) {
            View view4 = this.L[i17];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.f1701s == 1) {
                if (q2()) {
                    int iE0 = e0() + this.K[this.J - bVar3.f1695e];
                    iF = iE0 - this.f1703u.f(view4);
                    iF3 = i4;
                    iF2 = iE0;
                    i6 = i5;
                } else {
                    int iE1 = e0() + this.K[bVar3.f1695e];
                    iF3 = i4;
                    i7 = iE1;
                    i6 = i5;
                    iF2 = this.f1703u.f(view4) + iE1;
                }
                z0(view4, i7, i6, iF2, iF3);
                if (bVar3.c() || bVar3.b()) {
                    bVar.f1716c = true;
                }
                bVar.f1717d |= view4.hasFocusable();
                i17++;
                i4 = iF3;
                i3 = iF2;
                i5 = i6;
                iF = i7;
            } else {
                int iG0 = g0() + this.K[bVar3.f1695e];
                i6 = iG0;
                iF2 = i3;
                iF3 = this.f1703u.f(view4) + iG0;
            }
            i7 = iF;
            z0(view4, i7, i6, iF2, iF3);
            if (bVar3.c()) {
                bVar.f1716c = true;
            } else {
                bVar.f1716c = true;
            }
            bVar.f1717d |= view4.hasFocusable();
            i17++;
            i4 = iF3;
            i3 = iF2;
            i5 = i6;
            iF = i7;
        }
        Arrays.fill(this.L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return this.Q ? S2(a0Var) : super.u(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void u2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i3) {
        super.u2(vVar, a0Var, aVar, i3);
        f3();
        if (a0Var.b() > 0 && !a0Var.e()) {
            U2(vVar, a0Var, aVar, i3);
        }
        V2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return this.Q ? T2(a0Var) : super.v(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        f3();
        V2();
        return super.w1(i3, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        f3();
        V2();
        return super.y1(i3, vVar, a0Var);
    }

    public static class b extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1695e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1696f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1695e = -1;
            this.f1696f = 0;
        }

        public int e() {
            return this.f1695e;
        }

        public int f() {
            return this.f1696f;
        }

        public b(int i3, int i4) {
            super(i3, i4);
            this.f1695e = -1;
            this.f1696f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1695e = -1;
            this.f1696f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1695e = -1;
            this.f1696f = 0;
        }
    }

    public GridLayoutManager(Context context, int i3, int i4, boolean z2) {
        super(context, i4, z2);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        e3(i3);
    }
}
