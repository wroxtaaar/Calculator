package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    private int[] H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f1701s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f1702t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    i f1703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f1706x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1707y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1708z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        i f1709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1713e;

        a() {
            e();
        }

        void a() {
            this.f1711c = this.f1712d ? this.f1709a.i() : this.f1709a.m();
        }

        public void b(View view, int i3) {
            if (this.f1712d) {
                this.f1711c = this.f1709a.d(view) + this.f1709a.o();
            } else {
                this.f1711c = this.f1709a.g(view);
            }
            this.f1710b = i3;
        }

        public void c(View view, int i3) {
            int iO = this.f1709a.o();
            if (iO >= 0) {
                b(view, i3);
                return;
            }
            this.f1710b = i3;
            if (this.f1712d) {
                int i4 = (this.f1709a.i() - iO) - this.f1709a.d(view);
                this.f1711c = this.f1709a.i() - i4;
                if (i4 > 0) {
                    int iE = this.f1711c - this.f1709a.e(view);
                    int iM = this.f1709a.m();
                    int iMin = iE - (iM + Math.min(this.f1709a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f1711c += Math.min(i4, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f1709a.g(view);
            int iM2 = iG - this.f1709a.m();
            this.f1711c = iG;
            if (iM2 > 0) {
                int i5 = (this.f1709a.i() - Math.min(0, (this.f1709a.i() - iO) - this.f1709a.d(view))) - (iG + this.f1709a.e(view));
                if (i5 < 0) {
                    this.f1711c -= Math.min(iM2, -i5);
                }
            }
        }

        boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        void e() {
            this.f1710b = -1;
            this.f1711c = Integer.MIN_VALUE;
            this.f1712d = false;
            this.f1713e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1710b + ", mCoordinate=" + this.f1711c + ", mLayoutFromEnd=" + this.f1712d + ", mValid=" + this.f1713e + '}';
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1717d;

        protected b() {
        }

        void a() {
            this.f1714a = 0;
            this.f1715b = false;
            this.f1716c = false;
            this.f1717d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1721d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1722e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1723f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1724g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f1728k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f1730m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1718a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1725h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f1726i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1727j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List<RecyclerView.d0> f1729l = null;

        c() {
        }

        private View e() {
            int size = this.f1729l.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.f1729l.get(i3).f1813a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1721d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f1721d = -1;
            } else {
                this.f1721d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.a0 a0Var) {
            int i3 = this.f1721d;
            return i3 >= 0 && i3 < a0Var.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.f1729l != null) {
                return e();
            }
            View viewO = vVar.o(this.f1721d);
            this.f1721d += this.f1722e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.f1729l.size();
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = this.f1729l.get(i4).f1813a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f1721d) * this.f1722e) >= 0 && iA < i3) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i3 = iA;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1733d;

        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        public d() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean j() {
            return this.f1731b >= 0;
        }

        void k() {
            this.f1731b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f1731b);
            parcel.writeInt(this.f1732c);
            parcel.writeInt(this.f1733d ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f1731b = parcel.readInt();
            this.f1732c = parcel.readInt();
            this.f1733d = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f1731b = dVar.f1731b;
            this.f1732c = dVar.f1732c;
            this.f1733d = dVar.f1733d;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void A2() {
        if (this.f1701s == 1 || !q2()) {
            this.f1706x = this.f1705w;
        } else {
            this.f1706x = !this.f1705w;
        }
    }

    private boolean F2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (J() == 0) {
            return false;
        }
        View viewV = V();
        if (viewV != null && aVar.d(viewV, a0Var)) {
            aVar.c(viewV, h0(viewV));
            return true;
        }
        if (this.f1704v != this.f1707y) {
            return false;
        }
        View viewI2 = aVar.f1712d ? i2(vVar, a0Var) : j2(vVar, a0Var);
        if (viewI2 == null) {
            return false;
        }
        aVar.b(viewI2, h0(viewI2));
        if (!a0Var.e() && L1()) {
            if (this.f1703u.g(viewI2) >= this.f1703u.i() || this.f1703u.d(viewI2) < this.f1703u.m()) {
                aVar.f1711c = aVar.f1712d ? this.f1703u.i() : this.f1703u.m();
            }
        }
        return true;
    }

    private boolean G2(RecyclerView.a0 a0Var, a aVar) {
        int i3;
        if (!a0Var.e() && (i3 = this.A) != -1) {
            if (i3 >= 0 && i3 < a0Var.b()) {
                aVar.f1710b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.j()) {
                    boolean z2 = this.D.f1733d;
                    aVar.f1712d = z2;
                    if (z2) {
                        aVar.f1711c = this.f1703u.i() - this.D.f1732c;
                    } else {
                        aVar.f1711c = this.f1703u.m() + this.D.f1732c;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z3 = this.f1706x;
                    aVar.f1712d = z3;
                    if (z3) {
                        aVar.f1711c = this.f1703u.i() - this.B;
                    } else {
                        aVar.f1711c = this.f1703u.m() + this.B;
                    }
                    return true;
                }
                View viewC = C(this.A);
                if (viewC == null) {
                    if (J() > 0) {
                        aVar.f1712d = (this.A < h0(I(0))) == this.f1706x;
                    }
                    aVar.a();
                } else {
                    if (this.f1703u.e(viewC) > this.f1703u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f1703u.g(viewC) - this.f1703u.m() < 0) {
                        aVar.f1711c = this.f1703u.m();
                        aVar.f1712d = false;
                        return true;
                    }
                    if (this.f1703u.i() - this.f1703u.d(viewC) < 0) {
                        aVar.f1711c = this.f1703u.i();
                        aVar.f1712d = true;
                        return true;
                    }
                    aVar.f1711c = aVar.f1712d ? this.f1703u.d(viewC) + this.f1703u.o() : this.f1703u.g(viewC);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void H2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (G2(a0Var, aVar) || F2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1710b = this.f1707y ? a0Var.b() - 1 : 0;
    }

    private void I2(int i3, int i4, boolean z2, RecyclerView.a0 a0Var) {
        int iM;
        this.f1702t.f1730m = z2();
        this.f1702t.f1723f = i3;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z3 = i3 == 1;
        c cVar = this.f1702t;
        int i5 = z3 ? iMax2 : iMax;
        cVar.f1725h = i5;
        if (!z3) {
            iMax = iMax2;
        }
        cVar.f1726i = iMax;
        if (z3) {
            cVar.f1725h = i5 + this.f1703u.j();
            View viewM2 = m2();
            c cVar2 = this.f1702t;
            cVar2.f1722e = this.f1706x ? -1 : 1;
            int iH0 = h0(viewM2);
            c cVar3 = this.f1702t;
            cVar2.f1721d = iH0 + cVar3.f1722e;
            cVar3.f1719b = this.f1703u.d(viewM2);
            iM = this.f1703u.d(viewM2) - this.f1703u.i();
        } else {
            View viewN2 = n2();
            this.f1702t.f1725h += this.f1703u.m();
            c cVar4 = this.f1702t;
            cVar4.f1722e = this.f1706x ? 1 : -1;
            int iH1 = h0(viewN2);
            c cVar5 = this.f1702t;
            cVar4.f1721d = iH1 + cVar5.f1722e;
            cVar5.f1719b = this.f1703u.g(viewN2);
            iM = (-this.f1703u.g(viewN2)) + this.f1703u.m();
        }
        c cVar6 = this.f1702t;
        cVar6.f1720c = i4;
        if (z2) {
            cVar6.f1720c = i4 - iM;
        }
        cVar6.f1724g = iM;
    }

    private void J2(int i3, int i4) {
        this.f1702t.f1720c = this.f1703u.i() - i4;
        c cVar = this.f1702t;
        cVar.f1722e = this.f1706x ? -1 : 1;
        cVar.f1721d = i3;
        cVar.f1723f = 1;
        cVar.f1719b = i4;
        cVar.f1724g = Integer.MIN_VALUE;
    }

    private void K2(a aVar) {
        J2(aVar.f1710b, aVar.f1711c);
    }

    private void L2(int i3, int i4) {
        this.f1702t.f1720c = i4 - this.f1703u.m();
        c cVar = this.f1702t;
        cVar.f1721d = i3;
        cVar.f1722e = this.f1706x ? 1 : -1;
        cVar.f1723f = -1;
        cVar.f1719b = i4;
        cVar.f1724g = Integer.MIN_VALUE;
    }

    private void M2(a aVar) {
        L2(aVar.f1710b, aVar.f1711c);
    }

    private int O1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(a0Var, this.f1703u, Y1(!this.f1708z, true), X1(!this.f1708z, true), this, this.f1708z);
    }

    private int P1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(a0Var, this.f1703u, Y1(!this.f1708z, true), X1(!this.f1708z, true), this, this.f1708z, this.f1706x);
    }

    private int Q1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(a0Var, this.f1703u, Y1(!this.f1708z, true), X1(!this.f1708z, true), this, this.f1708z);
    }

    private View V1() {
        return d2(0, J());
    }

    private View W1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, 0, J(), a0Var.b());
    }

    private View a2() {
        return d2(J() - 1, -1);
    }

    private View b2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, J() - 1, -1, a0Var.b());
    }

    private View f2() {
        return this.f1706x ? V1() : a2();
    }

    private View g2() {
        return this.f1706x ? a2() : V1();
    }

    private View i2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1706x ? W1(vVar, a0Var) : b2(vVar, a0Var);
    }

    private View j2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1706x ? b2(vVar, a0Var) : W1(vVar, a0Var);
    }

    private int k2(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int i4;
        int i5 = this.f1703u.i() - i3;
        if (i5 <= 0) {
            return 0;
        }
        int i6 = -B2(-i5, vVar, a0Var);
        int i7 = i3 + i6;
        if (!z2 || (i4 = this.f1703u.i() - i7) <= 0) {
            return i6;
        }
        this.f1703u.r(i4);
        return i4 + i6;
    }

    private int l2(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int iM;
        int iM2 = i3 - this.f1703u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i4 = -B2(iM2, vVar, a0Var);
        int i5 = i3 + i4;
        if (!z2 || (iM = i5 - this.f1703u.m()) <= 0) {
            return i4;
        }
        this.f1703u.r(-iM);
        return i4 - iM;
    }

    private View m2() {
        return I(this.f1706x ? 0 : J() - 1);
    }

    private View n2() {
        return I(this.f1706x ? J() - 1 : 0);
    }

    private void t2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i3, int i4) {
        if (!a0Var.g() || J() == 0 || a0Var.e() || !L1()) {
            return;
        }
        List<RecyclerView.d0> listK = vVar.k();
        int size = listK.size();
        int iH0 = h0(I(0));
        int iE = 0;
        int iE2 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.d0 d0Var = listK.get(i5);
            if (!d0Var.v()) {
                if (((d0Var.m() < iH0) != this.f1706x ? (byte) -1 : (byte) 1) == -1) {
                    iE += this.f1703u.e(d0Var.f1813a);
                } else {
                    iE2 += this.f1703u.e(d0Var.f1813a);
                }
            }
        }
        this.f1702t.f1729l = listK;
        if (iE > 0) {
            L2(h0(n2()), i3);
            c cVar = this.f1702t;
            cVar.f1725h = iE;
            cVar.f1720c = 0;
            cVar.a();
            U1(vVar, this.f1702t, a0Var, false);
        }
        if (iE2 > 0) {
            J2(h0(m2()), i4);
            c cVar2 = this.f1702t;
            cVar2.f1725h = iE2;
            cVar2.f1720c = 0;
            cVar2.a();
            U1(vVar, this.f1702t, a0Var, false);
        }
        this.f1702t.f1729l = null;
    }

    private void v2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f1718a || cVar.f1730m) {
            return;
        }
        int i3 = cVar.f1724g;
        int i4 = cVar.f1726i;
        if (cVar.f1723f == -1) {
            x2(vVar, i3, i4);
        } else {
            y2(vVar, i3, i4);
        }
    }

    private void w2(RecyclerView.v vVar, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        if (i4 <= i3) {
            while (i3 > i4) {
                n1(i3, vVar);
                i3--;
            }
        } else {
            for (int i5 = i4 - 1; i5 >= i3; i5--) {
                n1(i5, vVar);
            }
        }
    }

    private void x2(RecyclerView.v vVar, int i3, int i4) {
        int iJ = J();
        if (i3 < 0) {
            return;
        }
        int iH = (this.f1703u.h() - i3) + i4;
        if (this.f1706x) {
            for (int i5 = 0; i5 < iJ; i5++) {
                View viewI = I(i5);
                if (this.f1703u.g(viewI) < iH || this.f1703u.q(viewI) < iH) {
                    w2(vVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = iJ - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View viewI2 = I(i7);
            if (this.f1703u.g(viewI2) < iH || this.f1703u.q(viewI2) < iH) {
                w2(vVar, i6, i7);
                return;
            }
        }
    }

    private void y2(RecyclerView.v vVar, int i3, int i4) {
        if (i3 < 0) {
            return;
        }
        int i5 = i3 - i4;
        int iJ = J();
        if (!this.f1706x) {
            for (int i6 = 0; i6 < iJ; i6++) {
                View viewI = I(i6);
                if (this.f1703u.d(viewI) > i5 || this.f1703u.p(viewI) > i5) {
                    w2(vVar, 0, i6);
                    return;
                }
            }
            return;
        }
        int i7 = iJ - 1;
        for (int i8 = i7; i8 >= 0; i8--) {
            View viewI2 = I(i8);
            if (this.f1703u.d(viewI2) > i5 || this.f1703u.p(viewI2) > i5) {
                w2(vVar, i7, i8);
                return;
            }
        }
    }

    int B2(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i3 == 0) {
            return 0;
        }
        T1();
        this.f1702t.f1718a = true;
        int i4 = i3 > 0 ? 1 : -1;
        int iAbs = Math.abs(i3);
        I2(i4, iAbs, true, a0Var);
        c cVar = this.f1702t;
        int iU1 = cVar.f1724g + U1(vVar, cVar, a0Var, false);
        if (iU1 < 0) {
            return 0;
        }
        if (iAbs > iU1) {
            i3 = i4 * iU1;
        }
        this.f1703u.r(-i3);
        this.f1702t.f1728k = i3;
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i3) {
        int iJ = J();
        if (iJ == 0) {
            return null;
        }
        int iH0 = i3 - h0(I(0));
        if (iH0 >= 0 && iH0 < iJ) {
            View viewI = I(iH0);
            if (h0(viewI) == i3) {
                return viewI;
            }
        }
        return super.C(i3);
    }

    public void C2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        g(null);
        if (i3 != this.f1701s || this.f1703u == null) {
            i iVarB = i.b(this, i3);
            this.f1703u = iVarB;
            this.E.f1709a = iVarB;
            this.f1701s = i3;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z2) {
        g(null);
        if (z2 == this.f1705w) {
            return;
        }
        this.f1705w = z2;
        t1();
    }

    public void E2(boolean z2) {
        g(null);
        if (this.f1707y == z2) {
            return;
        }
        this.f1707y = z2;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        if (this.C) {
            k1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i3) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i3);
        J1(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iR1;
        A2();
        if (J() == 0 || (iR1 = R1(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(iR1, (int) (this.f1703u.n() * 0.33333334f), false, a0Var);
        c cVar = this.f1702t;
        cVar.f1724g = Integer.MIN_VALUE;
        cVar.f1718a = false;
        U1(vVar, cVar, a0Var, true);
        View viewG2 = iR1 == -1 ? g2() : f2();
        View viewN2 = iR1 == -1 ? n2() : m2();
        if (!viewN2.hasFocusable()) {
            return viewG2;
        }
        if (viewG2 == null) {
            return null;
        }
        return viewN2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && this.f1704v == this.f1707y;
    }

    protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
        int i3;
        int iO2 = o2(a0Var);
        if (this.f1702t.f1723f == -1) {
            i3 = 0;
        } else {
            i3 = iO2;
            iO2 = 0;
        }
        iArr[0] = iO2;
        iArr[1] = i3;
    }

    void N1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i3 = cVar.f1721d;
        if (i3 < 0 || i3 >= a0Var.b()) {
            return;
        }
        cVar2.a(i3, Math.max(0, cVar.f1724g));
    }

    int R1(int i3) {
        if (i3 == 1) {
            return (this.f1701s != 1 && q2()) ? 1 : -1;
        }
        if (i3 == 2) {
            return (this.f1701s != 1 && q2()) ? -1 : 1;
        }
        if (i3 == 17) {
            return this.f1701s == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 == 33) {
            return this.f1701s == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 != 66) {
            return (i3 == 130 && this.f1701s == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f1701s == 0 ? 1 : Integer.MIN_VALUE;
    }

    c S1() {
        return new c();
    }

    void T1() {
        if (this.f1702t == null) {
            this.f1702t = S1();
        }
    }

    int U1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z2) {
        int i3 = cVar.f1720c;
        int i4 = cVar.f1724g;
        if (i4 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                cVar.f1724g = i4 + i3;
            }
            v2(vVar, cVar);
        }
        int i5 = cVar.f1720c + cVar.f1725h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f1730m && i5 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            s2(vVar, a0Var, cVar, bVar);
            if (!bVar.f1715b) {
                cVar.f1719b += bVar.f1714a * cVar.f1723f;
                if (!bVar.f1716c || cVar.f1729l != null || !a0Var.e()) {
                    int i6 = cVar.f1720c;
                    int i7 = bVar.f1714a;
                    cVar.f1720c = i6 - i7;
                    i5 -= i7;
                }
                int i8 = cVar.f1724g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + bVar.f1714a;
                    cVar.f1724g = i9;
                    int i10 = cVar.f1720c;
                    if (i10 < 0) {
                        cVar.f1724g = i9 + i10;
                    }
                    v2(vVar, cVar);
                }
                if (z2 && bVar.f1717d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - cVar.f1720c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iK2;
        int i7;
        View viewC;
        int iG;
        int i8;
        int i9 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.b() == 0) {
            k1(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.j()) {
            this.A = this.D.f1731b;
        }
        T1();
        this.f1702t.f1718a = false;
        A2();
        View viewV = V();
        a aVar = this.E;
        if (!aVar.f1713e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f1712d = this.f1706x ^ this.f1707y;
            H2(vVar, a0Var, aVar2);
            this.E.f1713e = true;
        } else if (viewV != null && (this.f1703u.g(viewV) >= this.f1703u.i() || this.f1703u.d(viewV) <= this.f1703u.m())) {
            this.E.c(viewV, h0(viewV));
        }
        c cVar = this.f1702t;
        cVar.f1723f = cVar.f1728k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]) + this.f1703u.m();
        int iMax2 = Math.max(0, this.H[1]) + this.f1703u.j();
        if (a0Var.e() && (i7 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewC = C(i7)) != null) {
            if (this.f1706x) {
                i8 = this.f1703u.i() - this.f1703u.d(viewC);
                iG = this.B;
            } else {
                iG = this.f1703u.g(viewC) - this.f1703u.m();
                i8 = this.B;
            }
            int i10 = i8 - iG;
            if (i10 > 0) {
                iMax += i10;
            } else {
                iMax2 -= i10;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f1712d ? !this.f1706x : this.f1706x) {
            i9 = 1;
        }
        u2(vVar, a0Var, aVar3, i9);
        w(vVar);
        this.f1702t.f1730m = z2();
        this.f1702t.f1727j = a0Var.e();
        this.f1702t.f1726i = 0;
        a aVar4 = this.E;
        if (aVar4.f1712d) {
            M2(aVar4);
            c cVar2 = this.f1702t;
            cVar2.f1725h = iMax;
            U1(vVar, cVar2, a0Var, false);
            c cVar3 = this.f1702t;
            i4 = cVar3.f1719b;
            int i11 = cVar3.f1721d;
            int i12 = cVar3.f1720c;
            if (i12 > 0) {
                iMax2 += i12;
            }
            K2(this.E);
            c cVar4 = this.f1702t;
            cVar4.f1725h = iMax2;
            cVar4.f1721d += cVar4.f1722e;
            U1(vVar, cVar4, a0Var, false);
            c cVar5 = this.f1702t;
            i3 = cVar5.f1719b;
            int i13 = cVar5.f1720c;
            if (i13 > 0) {
                L2(i11, i4);
                c cVar6 = this.f1702t;
                cVar6.f1725h = i13;
                U1(vVar, cVar6, a0Var, false);
                i4 = this.f1702t.f1719b;
            }
        } else {
            K2(aVar4);
            c cVar7 = this.f1702t;
            cVar7.f1725h = iMax2;
            U1(vVar, cVar7, a0Var, false);
            c cVar8 = this.f1702t;
            i3 = cVar8.f1719b;
            int i14 = cVar8.f1721d;
            int i15 = cVar8.f1720c;
            if (i15 > 0) {
                iMax += i15;
            }
            M2(this.E);
            c cVar9 = this.f1702t;
            cVar9.f1725h = iMax;
            cVar9.f1721d += cVar9.f1722e;
            U1(vVar, cVar9, a0Var, false);
            c cVar10 = this.f1702t;
            i4 = cVar10.f1719b;
            int i16 = cVar10.f1720c;
            if (i16 > 0) {
                J2(i14, i3);
                c cVar11 = this.f1702t;
                cVar11.f1725h = i16;
                U1(vVar, cVar11, a0Var, false);
                i3 = this.f1702t.f1719b;
            }
        }
        if (J() > 0) {
            if (this.f1706x ^ this.f1707y) {
                int iK3 = k2(i3, vVar, a0Var, true);
                i5 = i4 + iK3;
                i6 = i3 + iK3;
                iK2 = l2(i5, vVar, a0Var, false);
            } else {
                int iL2 = l2(i4, vVar, a0Var, true);
                i5 = i4 + iL2;
                i6 = i3 + iL2;
                iK2 = k2(i6, vVar, a0Var, false);
            }
            i4 = i5 + iK2;
            i3 = i6 + iK2;
        }
        t2(vVar, a0Var, i4, i3);
        if (a0Var.e()) {
            this.E.e();
        } else {
            this.f1703u.s();
        }
        this.f1704v = this.f1707y;
    }

    View X1(boolean z2, boolean z3) {
        return this.f1706x ? e2(0, J(), z2, z3) : e2(J() - 1, -1, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    View Y1(boolean z2, boolean z3) {
        return this.f1706x ? e2(J() - 1, -1, z2, z3) : e2(0, J(), z2, z3);
    }

    public int Z1() {
        View viewE2 = e2(0, J(), false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i3) {
        if (J() == 0) {
            return null;
        }
        int i4 = (i3 < h0(I(0))) != this.f1706x ? -1 : 1;
        return this.f1701s == 0 ? new PointF(i4, 0.0f) : new PointF(0.0f, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View viewE2 = e2(J() - 1, -1, false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (J() > 0) {
            T1();
            boolean z2 = this.f1704v ^ this.f1706x;
            dVar.f1733d = z2;
            if (z2) {
                View viewM2 = m2();
                dVar.f1732c = this.f1703u.i() - this.f1703u.d(viewM2);
                dVar.f1731b = h0(viewM2);
            } else {
                View viewN2 = n2();
                dVar.f1731b = h0(viewN2);
                dVar.f1732c = this.f1703u.g(viewN2) - this.f1703u.m();
            }
        } else {
            dVar.k();
        }
        return dVar;
    }

    View d2(int i3, int i4) {
        byte b3;
        int i5;
        int i6;
        T1();
        if (i4 > i3) {
            b3 = 1;
        } else {
            b3 = i4 < i3 ? (byte) -1 : (byte) 0;
        }
        if (b3 == 0) {
            return I(i3);
        }
        if (this.f1703u.g(I(i3)) < this.f1703u.m()) {
            i5 = 16644;
            i6 = 16388;
        } else {
            i5 = 4161;
            i6 = 4097;
        }
        return this.f1701s == 0 ? this.f1850e.a(i3, i4, i5, i6) : this.f1851f.a(i3, i4, i5, i6);
    }

    View e2(int i3, int i4, boolean z2, boolean z3) {
        T1();
        int i5 = z2 ? 24579 : 320;
        int i6 = z3 ? 320 : 0;
        return this.f1701s == 0 ? this.f1850e.a(i3, i4, i5, i6) : this.f1851f.a(i3, i4, i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.D == null) {
            super.g(str);
        }
    }

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
            if (iH0 >= 0 && iH0 < i5) {
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
    public boolean k() {
        return this.f1701s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f1701s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i3, int i4, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.f1701s != 0) {
            i3 = i4;
        }
        if (J() == 0 || i3 == 0) {
            return;
        }
        T1();
        I2(i3 > 0 ? 1 : -1, Math.abs(i3), true, a0Var);
        N1(a0Var, this.f1702t, cVar);
    }

    @Deprecated
    protected int o2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.f1703u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i3, RecyclerView.o.c cVar) {
        boolean z2;
        int i4;
        d dVar = this.D;
        if (dVar == null || !dVar.j()) {
            A2();
            z2 = this.f1706x;
            i4 = this.A;
            if (i4 == -1) {
                i4 = z2 ? i3 - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z2 = dVar2.f1733d;
            i4 = dVar2.f1731b;
        }
        int i5 = z2 ? -1 : 1;
        for (int i6 = 0; i6 < this.G && i4 >= 0 && i4 < i3; i6++) {
            cVar.a(i4, 0);
            i4 += i5;
        }
    }

    public int p2() {
        return this.f1701s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    protected boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    public boolean r2() {
        return this.f1708z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i3;
        int i4;
        int i5;
        int iE0;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.f1715b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f1729l == null) {
            if (this.f1706x == (cVar.f1723f == -1)) {
                d(viewD);
            } else {
                e(viewD, 0);
            }
        } else {
            if (this.f1706x == (cVar.f1723f == -1)) {
                b(viewD);
            } else {
                c(viewD, 0);
            }
        }
        A0(viewD, 0, 0);
        bVar.f1714a = this.f1703u.e(viewD);
        if (this.f1701s == 1) {
            if (q2()) {
                iF = o0() - f0();
                iE0 = iF - this.f1703u.f(viewD);
            } else {
                iE0 = e0();
                iF = this.f1703u.f(viewD) + iE0;
            }
            if (cVar.f1723f == -1) {
                int i6 = cVar.f1719b;
                i5 = i6;
                i4 = iF;
                i3 = i6 - bVar.f1714a;
            } else {
                int i7 = cVar.f1719b;
                i3 = i7;
                i4 = iF;
                i5 = bVar.f1714a + i7;
            }
        } else {
            int iG0 = g0();
            int iF2 = this.f1703u.f(viewD) + iG0;
            if (cVar.f1723f == -1) {
                int i8 = cVar.f1719b;
                i4 = i8;
                i3 = iG0;
                i5 = iF2;
                iE0 = i8 - bVar.f1714a;
            } else {
                int i9 = cVar.f1719b;
                i3 = iG0;
                i4 = bVar.f1714a + i9;
                i5 = iF2;
                iE0 = i9;
            }
        }
        z0(viewD, iE0, i3, i4, i5);
        if (pVar.c() || pVar.b()) {
            bVar.f1716c = true;
        }
        bVar.f1717d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    void u2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1701s == 1) {
            return 0;
        }
        return B2(i3, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i3) {
        this.A = i3;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.k();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f1701s == 0) {
            return 0;
        }
        return B2(i3, vVar, a0Var);
    }

    boolean z2() {
        return this.f1703u.k() == 0 && this.f1703u.h() == 0;
    }

    public LinearLayoutManager(Context context, int i3, boolean z2) {
        this.f1701s = 1;
        this.f1705w = false;
        this.f1706x = false;
        this.f1707y = false;
        this.f1708z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        C2(i3);
        D2(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f1701s = 1;
        this.f1705w = false;
        this.f1706x = false;
        this.f1707y = false;
        this.f1708z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d dVarI0 = RecyclerView.o.i0(context, attributeSet, i3, i4);
        C2(dVarI0.f1866a);
        D2(dVarI0.f1868c);
        E2(dVarI0.f1869d);
    }
}
