package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private int[] O;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    f[] f1906t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    i f1907u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    i f1908v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1909w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f1910x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final androidx.recyclerview.widget.f f1911y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1905s = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f1912z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    d E = new d();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.S1();
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1918e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f1919f;

        b() {
            c();
        }

        void a() {
            this.f1915b = this.f1916c ? StaggeredGridLayoutManager.this.f1907u.i() : StaggeredGridLayoutManager.this.f1907u.m();
        }

        void b(int i3) {
            if (this.f1916c) {
                this.f1915b = StaggeredGridLayoutManager.this.f1907u.i() - i3;
            } else {
                this.f1915b = StaggeredGridLayoutManager.this.f1907u.m() + i3;
            }
        }

        void c() {
            this.f1914a = -1;
            this.f1915b = Integer.MIN_VALUE;
            this.f1916c = false;
            this.f1917d = false;
            this.f1918e = false;
            int[] iArr = this.f1919f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f1919f;
            if (iArr == null || iArr.length < length) {
                this.f1919f = new int[StaggeredGridLayoutManager.this.f1906t.length];
            }
            for (int i3 = 0; i3 < length; i3++) {
                this.f1919f[i3] = fVarArr[i3].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        f f1921e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1922f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.f1921e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f1943e;
        }

        public boolean f() {
            return this.f1922f;
        }

        public c(int i3, int i4) {
            super(i3, i4);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f1932e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1933f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int[] f1934g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        List<d.a> f1935h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f1936i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1937j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f1938k;

        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        public e() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void j() {
            this.f1932e = null;
            this.f1931d = 0;
            this.f1929b = -1;
            this.f1930c = -1;
        }

        void k() {
            this.f1932e = null;
            this.f1931d = 0;
            this.f1933f = 0;
            this.f1934g = null;
            this.f1935h = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f1929b);
            parcel.writeInt(this.f1930c);
            parcel.writeInt(this.f1931d);
            if (this.f1931d > 0) {
                parcel.writeIntArray(this.f1932e);
            }
            parcel.writeInt(this.f1933f);
            if (this.f1933f > 0) {
                parcel.writeIntArray(this.f1934g);
            }
            parcel.writeInt(this.f1936i ? 1 : 0);
            parcel.writeInt(this.f1937j ? 1 : 0);
            parcel.writeInt(this.f1938k ? 1 : 0);
            parcel.writeList(this.f1935h);
        }

        e(Parcel parcel) {
            this.f1929b = parcel.readInt();
            this.f1930c = parcel.readInt();
            int i3 = parcel.readInt();
            this.f1931d = i3;
            if (i3 > 0) {
                int[] iArr = new int[i3];
                this.f1932e = iArr;
                parcel.readIntArray(iArr);
            }
            int i4 = parcel.readInt();
            this.f1933f = i4;
            if (i4 > 0) {
                int[] iArr2 = new int[i4];
                this.f1934g = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f1936i = parcel.readInt() == 1;
            this.f1937j = parcel.readInt() == 1;
            this.f1938k = parcel.readInt() == 1;
            this.f1935h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f1931d = eVar.f1931d;
            this.f1929b = eVar.f1929b;
            this.f1930c = eVar.f1930c;
            this.f1932e = eVar.f1932e;
            this.f1933f = eVar.f1933f;
            this.f1934g = eVar.f1934g;
            this.f1936i = eVar.f1936i;
            this.f1937j = eVar.f1937j;
            this.f1938k = eVar.f1938k;
            this.f1935h = eVar.f1935h;
        }
    }

    class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<View> f1939a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1940b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1941c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1942d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f1943e;

        f(int i3) {
            this.f1943e = i3;
        }

        void a(View view) {
            c cVarN = n(view);
            cVarN.f1921e = this;
            this.f1939a.add(view);
            this.f1941c = Integer.MIN_VALUE;
            if (this.f1939a.size() == 1) {
                this.f1940b = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1942d += StaggeredGridLayoutManager.this.f1907u.e(view);
            }
        }

        void b(boolean z2, int i3) {
            int iL = z2 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z2 || iL >= StaggeredGridLayoutManager.this.f1907u.i()) {
                if (z2 || iL <= StaggeredGridLayoutManager.this.f1907u.m()) {
                    if (i3 != Integer.MIN_VALUE) {
                        iL += i3;
                    }
                    this.f1941c = iL;
                    this.f1940b = iL;
                }
            }
        }

        void c() {
            d.a aVarF;
            ArrayList<View> arrayList = this.f1939a;
            View view = arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.f1941c = StaggeredGridLayoutManager.this.f1907u.d(view);
            if (cVarN.f1922f && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && aVarF.f1926c == 1) {
                this.f1941c += aVarF.j(this.f1943e);
            }
        }

        void d() {
            d.a aVarF;
            View view = this.f1939a.get(0);
            c cVarN = n(view);
            this.f1940b = StaggeredGridLayoutManager.this.f1907u.g(view);
            if (cVarN.f1922f && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && aVarF.f1926c == -1) {
                this.f1940b -= aVarF.j(this.f1943e);
            }
        }

        void e() {
            this.f1939a.clear();
            q();
            this.f1942d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f1912z ? i(this.f1939a.size() - 1, -1, true) : i(0, this.f1939a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f1912z ? i(0, this.f1939a.size(), true) : i(this.f1939a.size() - 1, -1, true);
        }

        int h(int i3, int i4, boolean z2, boolean z3, boolean z4) {
            int iM = StaggeredGridLayoutManager.this.f1907u.m();
            int i5 = StaggeredGridLayoutManager.this.f1907u.i();
            int i6 = i4 > i3 ? 1 : -1;
            while (i3 != i4) {
                View view = this.f1939a.get(i3);
                int iG = StaggeredGridLayoutManager.this.f1907u.g(view);
                int iD = StaggeredGridLayoutManager.this.f1907u.d(view);
                boolean z5 = false;
                boolean z6 = !z4 ? iG >= i5 : iG > i5;
                if (!z4 ? iD > iM : iD >= iM) {
                    z5 = true;
                }
                if (z6 && z5) {
                    if (z2 && z3) {
                        if (iG >= iM && iD <= i5) {
                            return StaggeredGridLayoutManager.this.h0(view);
                        }
                    } else {
                        if (z3) {
                            return StaggeredGridLayoutManager.this.h0(view);
                        }
                        if (iG < iM || iD > i5) {
                            return StaggeredGridLayoutManager.this.h0(view);
                        }
                    }
                }
                i3 += i6;
            }
            return -1;
        }

        int i(int i3, int i4, boolean z2) {
            return h(i3, i4, false, false, z2);
        }

        public int j() {
            return this.f1942d;
        }

        int k() {
            int i3 = this.f1941c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            c();
            return this.f1941c;
        }

        int l(int i3) {
            int i4 = this.f1941c;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f1939a.size() == 0) {
                return i3;
            }
            c();
            return this.f1941c;
        }

        public View m(int i3, int i4) {
            View view = null;
            if (i4 != -1) {
                int size = this.f1939a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1939a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f1912z && staggeredGridLayoutManager.h0(view2) >= i3) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f1912z && staggeredGridLayoutManager2.h0(view2) <= i3) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1939a.size();
                int i5 = 0;
                while (i5 < size2) {
                    View view3 = this.f1939a.get(i5);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f1912z && staggeredGridLayoutManager3.h0(view3) <= i3) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f1912z && staggeredGridLayoutManager4.h0(view3) >= i3) || !view3.hasFocusable()) {
                        break;
                    }
                    i5++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i3 = this.f1940b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            d();
            return this.f1940b;
        }

        int p(int i3) {
            int i4 = this.f1940b;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            if (this.f1939a.size() == 0) {
                return i3;
            }
            d();
            return this.f1940b;
        }

        void q() {
            this.f1940b = Integer.MIN_VALUE;
            this.f1941c = Integer.MIN_VALUE;
        }

        void r(int i3) {
            int i4 = this.f1940b;
            if (i4 != Integer.MIN_VALUE) {
                this.f1940b = i4 + i3;
            }
            int i5 = this.f1941c;
            if (i5 != Integer.MIN_VALUE) {
                this.f1941c = i5 + i3;
            }
        }

        void s() {
            int size = this.f1939a.size();
            View viewRemove = this.f1939a.remove(size - 1);
            c cVarN = n(viewRemove);
            cVarN.f1921e = null;
            if (cVarN.c() || cVarN.b()) {
                this.f1942d -= StaggeredGridLayoutManager.this.f1907u.e(viewRemove);
            }
            if (size == 1) {
                this.f1940b = Integer.MIN_VALUE;
            }
            this.f1941c = Integer.MIN_VALUE;
        }

        void t() {
            View viewRemove = this.f1939a.remove(0);
            c cVarN = n(viewRemove);
            cVarN.f1921e = null;
            if (this.f1939a.size() == 0) {
                this.f1941c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1942d -= StaggeredGridLayoutManager.this.f1907u.e(viewRemove);
            }
            this.f1940b = Integer.MIN_VALUE;
        }

        void u(View view) {
            c cVarN = n(view);
            cVarN.f1921e = this;
            this.f1939a.add(0, view);
            this.f1940b = Integer.MIN_VALUE;
            if (this.f1939a.size() == 1) {
                this.f1941c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1942d += StaggeredGridLayoutManager.this.f1907u.e(view);
            }
        }

        void v(int i3) {
            this.f1940b = i3;
            this.f1941c = i3;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        RecyclerView.o.d dVarI0 = RecyclerView.o.i0(context, attributeSet, i3, i4);
        H2(dVarI0.f1866a);
        J2(dVarI0.f1867b);
        I2(dVarI0.f1868c);
        this.f1911y = new androidx.recyclerview.widget.f();
        a2();
    }

    private void A2(RecyclerView.v vVar, androidx.recyclerview.widget.f fVar) {
        int iMin;
        if (!fVar.f2059a || fVar.f2067i) {
            return;
        }
        if (fVar.f2060b == 0) {
            if (fVar.f2063e == -1) {
                B2(vVar, fVar.f2065g);
                return;
            } else {
                C2(vVar, fVar.f2064f);
                return;
            }
        }
        if (fVar.f2063e == -1) {
            int i3 = fVar.f2064f;
            int iM2 = i3 - m2(i3);
            B2(vVar, iM2 < 0 ? fVar.f2065g : fVar.f2065g - Math.min(iM2, fVar.f2060b));
        } else {
            int iN2 = n2(fVar.f2065g) - fVar.f2065g;
            if (iN2 < 0) {
                iMin = fVar.f2064f;
            } else {
                iMin = Math.min(iN2, fVar.f2060b) + fVar.f2064f;
            }
            C2(vVar, iMin);
        }
    }

    private void B2(RecyclerView.v vVar, int i3) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            if (this.f1907u.g(viewI) < i3 || this.f1907u.q(viewI) < i3) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f1922f) {
                for (int i4 = 0; i4 < this.f1905s; i4++) {
                    if (this.f1906t[i4].f1939a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f1905s; i5++) {
                    this.f1906t[i5].s();
                }
            } else if (cVar.f1921e.f1939a.size() == 1) {
                return;
            } else {
                cVar.f1921e.s();
            }
            m1(viewI, vVar);
        }
    }

    private void C2(RecyclerView.v vVar, int i3) {
        while (J() > 0) {
            View viewI = I(0);
            if (this.f1907u.d(viewI) > i3 || this.f1907u.p(viewI) > i3) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f1922f) {
                for (int i4 = 0; i4 < this.f1905s; i4++) {
                    if (this.f1906t[i4].f1939a.size() == 1) {
                        return;
                    }
                }
                for (int i5 = 0; i5 < this.f1905s; i5++) {
                    this.f1906t[i5].t();
                }
            } else if (cVar.f1921e.f1939a.size() == 1) {
                return;
            } else {
                cVar.f1921e.t();
            }
            m1(viewI, vVar);
        }
    }

    private void D2() {
        if (this.f1908v.k() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int iJ = J();
        for (int i3 = 0; i3 < iJ; i3++) {
            View viewI = I(i3);
            float fE = this.f1908v.e(viewI);
            if (fE >= fMax) {
                if (((c) viewI.getLayoutParams()).f()) {
                    fE = (fE * 1.0f) / this.f1905s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i4 = this.f1910x;
        int iRound = Math.round(fMax * this.f1905s);
        if (this.f1908v.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f1908v.n());
        }
        P2(iRound);
        if (this.f1910x == i4) {
            return;
        }
        for (int i5 = 0; i5 < iJ; i5++) {
            View viewI2 = I(i5);
            c cVar = (c) viewI2.getLayoutParams();
            if (!cVar.f1922f) {
                if (t2() && this.f1909w == 1) {
                    int i6 = this.f1905s;
                    int i7 = cVar.f1921e.f1943e;
                    viewI2.offsetLeftAndRight(((-((i6 - 1) - i7)) * this.f1910x) - ((-((i6 - 1) - i7)) * i4));
                } else {
                    int i8 = cVar.f1921e.f1943e;
                    int i9 = this.f1910x * i8;
                    int i10 = i8 * i4;
                    if (this.f1909w == 1) {
                        viewI2.offsetLeftAndRight(i9 - i10);
                    } else {
                        viewI2.offsetTopAndBottom(i9 - i10);
                    }
                }
            }
        }
    }

    private void E2() {
        if (this.f1909w == 1 || !t2()) {
            this.A = this.f1912z;
        } else {
            this.A = !this.f1912z;
        }
    }

    private void G2(int i3) {
        androidx.recyclerview.widget.f fVar = this.f1911y;
        fVar.f2063e = i3;
        fVar.f2062d = this.A != (i3 == -1) ? -1 : 1;
    }

    private void K2(int i3, int i4) {
        for (int i5 = 0; i5 < this.f1905s; i5++) {
            if (!this.f1906t[i5].f1939a.isEmpty()) {
                Q2(this.f1906t[i5], i3, i4);
            }
        }
    }

    private boolean L2(RecyclerView.a0 a0Var, b bVar) {
        bVar.f1914a = this.G ? g2(a0Var.b()) : c2(a0Var.b());
        bVar.f1915b = Integer.MIN_VALUE;
        return true;
    }

    private void M1(View view) {
        for (int i3 = this.f1905s - 1; i3 >= 0; i3--) {
            this.f1906t[i3].a(view);
        }
    }

    private void N1(b bVar) {
        e eVar = this.I;
        int i3 = eVar.f1931d;
        if (i3 > 0) {
            if (i3 == this.f1905s) {
                for (int i4 = 0; i4 < this.f1905s; i4++) {
                    this.f1906t[i4].e();
                    e eVar2 = this.I;
                    int i5 = eVar2.f1932e[i4];
                    if (i5 != Integer.MIN_VALUE) {
                        i5 += eVar2.f1937j ? this.f1907u.i() : this.f1907u.m();
                    }
                    this.f1906t[i4].v(i5);
                }
            } else {
                eVar.k();
                e eVar3 = this.I;
                eVar3.f1929b = eVar3.f1930c;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.f1938k;
        I2(eVar4.f1936i);
        E2();
        e eVar5 = this.I;
        int i6 = eVar5.f1929b;
        if (i6 != -1) {
            this.C = i6;
            bVar.f1916c = eVar5.f1937j;
        } else {
            bVar.f1916c = this.A;
        }
        if (eVar5.f1933f > 1) {
            d dVar = this.E;
            dVar.f1923a = eVar5.f1934g;
            dVar.f1924b = eVar5.f1935h;
        }
    }

    private void O2(int i3, RecyclerView.a0 a0Var) {
        int iN;
        int iN2;
        int iC;
        androidx.recyclerview.widget.f fVar = this.f1911y;
        boolean z2 = false;
        fVar.f2060b = 0;
        fVar.f2061c = i3;
        if (!x0() || (iC = a0Var.c()) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            if (this.A == (iC < i3)) {
                iN = this.f1907u.n();
                iN2 = 0;
            } else {
                iN2 = this.f1907u.n();
                iN = 0;
            }
        }
        if (M()) {
            this.f1911y.f2064f = this.f1907u.m() - iN2;
            this.f1911y.f2065g = this.f1907u.i() + iN;
        } else {
            this.f1911y.f2065g = this.f1907u.h() + iN;
            this.f1911y.f2064f = -iN2;
        }
        androidx.recyclerview.widget.f fVar2 = this.f1911y;
        fVar2.f2066h = false;
        fVar2.f2059a = true;
        if (this.f1907u.k() == 0 && this.f1907u.h() == 0) {
            z2 = true;
        }
        fVar2.f2067i = z2;
    }

    private void Q1(View view, c cVar, androidx.recyclerview.widget.f fVar) {
        if (fVar.f2063e == 1) {
            if (cVar.f1922f) {
                M1(view);
                return;
            } else {
                cVar.f1921e.a(view);
                return;
            }
        }
        if (cVar.f1922f) {
            z2(view);
        } else {
            cVar.f1921e.u(view);
        }
    }

    private void Q2(f fVar, int i3, int i4) {
        int iJ = fVar.j();
        if (i3 == -1) {
            if (fVar.o() + iJ <= i4) {
                this.B.set(fVar.f1943e, false);
            }
        } else if (fVar.k() - iJ >= i4) {
            this.B.set(fVar.f1943e, false);
        }
    }

    private int R1(int i3) {
        if (J() == 0) {
            return this.A ? 1 : -1;
        }
        return (i3 < j2()) != this.A ? -1 : 1;
    }

    private int R2(int i3, int i4, int i5) {
        if (i4 == 0 && i5 == 0) {
            return i3;
        }
        int mode = View.MeasureSpec.getMode(i3);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - i4) - i5), mode) : i3;
    }

    private boolean T1(f fVar) {
        if (this.A) {
            if (fVar.k() < this.f1907u.i()) {
                ArrayList<View> arrayList = fVar.f1939a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).f1922f;
            }
        } else if (fVar.o() > this.f1907u.m()) {
            return !fVar.n(fVar.f1939a.get(0)).f1922f;
        }
        return false;
    }

    private int U1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.a(a0Var, this.f1907u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int V1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.b(a0Var, this.f1907u, e2(!this.N), d2(!this.N), this, this.N, this.A);
    }

    private int W1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.c(a0Var, this.f1907u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int X1(int i3) {
        if (i3 == 1) {
            return (this.f1909w != 1 && t2()) ? 1 : -1;
        }
        if (i3 == 2) {
            return (this.f1909w != 1 && t2()) ? -1 : 1;
        }
        if (i3 == 17) {
            return this.f1909w == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 == 33) {
            return this.f1909w == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i3 != 66) {
            return (i3 == 130 && this.f1909w == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f1909w == 0 ? 1 : Integer.MIN_VALUE;
    }

    private d.a Y1(int i3) {
        d.a aVar = new d.a();
        aVar.f1927d = new int[this.f1905s];
        for (int i4 = 0; i4 < this.f1905s; i4++) {
            aVar.f1927d[i4] = i3 - this.f1906t[i4].l(i3);
        }
        return aVar;
    }

    private d.a Z1(int i3) {
        d.a aVar = new d.a();
        aVar.f1927d = new int[this.f1905s];
        for (int i4 = 0; i4 < this.f1905s; i4++) {
            aVar.f1927d[i4] = this.f1906t[i4].p(i3) - i3;
        }
        return aVar;
    }

    private void a2() {
        this.f1907u = i.b(this, this.f1909w);
        this.f1908v = i.b(this, 1 - this.f1909w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int b2(RecyclerView.v vVar, androidx.recyclerview.widget.f fVar, RecyclerView.a0 a0Var) {
        int i3;
        int iL2;
        f fVarP2;
        int iE;
        int i4;
        int iE2;
        int iE3;
        boolean z2;
        ?? r9 = 0;
        this.B.set(0, this.f1905s, true);
        if (this.f1911y.f2067i) {
            i3 = fVar.f2063e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i3 = fVar.f2063e == 1 ? fVar.f2065g + fVar.f2060b : fVar.f2064f - fVar.f2060b;
        }
        int i5 = i3;
        K2(fVar.f2063e, i5);
        int i6 = this.A ? this.f1907u.i() : this.f1907u.m();
        ?? r3 = false;
        while (fVar.a(a0Var) && (this.f1911y.f2067i || !this.B.isEmpty())) {
            View viewB = fVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = this.E.g(iA);
            ?? r4 = iG == -1 ? 1 : r9;
            if (r4 != 0) {
                fVarP2 = cVar.f1922f ? this.f1906t[r9] : p2(fVar);
                this.E.n(iA, fVarP2);
            } else {
                fVarP2 = this.f1906t[iG];
            }
            f fVar2 = fVarP2;
            cVar.f1921e = fVar2;
            if (fVar.f2063e == 1) {
                d(viewB);
            } else {
                e(viewB, r9);
            }
            v2(viewB, cVar, r9);
            if (fVar.f2063e == 1) {
                int iL3 = cVar.f1922f ? l2(i6) : fVar2.l(i6);
                int iE4 = this.f1907u.e(viewB) + iL3;
                if (r4 != 0 && cVar.f1922f) {
                    d.a aVarY1 = Y1(iL3);
                    aVarY1.f1926c = -1;
                    aVarY1.f1925b = iA;
                    this.E.a(aVarY1);
                }
                i4 = iE4;
                iE = iL3;
            } else {
                int iO2 = cVar.f1922f ? o2(i6) : fVar2.p(i6);
                iE = iO2 - this.f1907u.e(viewB);
                if (r4 != 0 && cVar.f1922f) {
                    d.a aVarZ1 = Z1(iO2);
                    aVarZ1.f1926c = 1;
                    aVarZ1.f1925b = iA;
                    this.E.a(aVarZ1);
                }
                i4 = iO2;
            }
            if (cVar.f1922f && fVar.f2062d == -1) {
                if (r4 != 0) {
                    this.M = true;
                } else {
                    if (!(fVar.f2063e == 1 ? O1() : P1())) {
                        d.a aVarF = this.E.f(iA);
                        if (aVarF != null) {
                            aVarF.f1928e = true;
                        }
                        this.M = true;
                    }
                }
            }
            Q1(viewB, cVar, fVar);
            if (t2() && this.f1909w == 1) {
                int i7 = cVar.f1922f ? this.f1908v.i() : this.f1908v.i() - (((this.f1905s - 1) - fVar2.f1943e) * this.f1910x);
                iE3 = i7;
                iE2 = i7 - this.f1908v.e(viewB);
            } else {
                int iM = cVar.f1922f ? this.f1908v.m() : (fVar2.f1943e * this.f1910x) + this.f1908v.m();
                iE2 = iM;
                iE3 = this.f1908v.e(viewB) + iM;
            }
            if (this.f1909w == 1) {
                z0(viewB, iE2, iE, iE3, i4);
            } else {
                z0(viewB, iE, iE2, i4, iE3);
            }
            if (cVar.f1922f) {
                K2(this.f1911y.f2063e, i5);
            } else {
                Q2(fVar2, this.f1911y.f2063e, i5);
            }
            A2(vVar, this.f1911y);
            if (!this.f1911y.f2066h || !viewB.hasFocusable()) {
                z2 = false;
            } else if (cVar.f1922f) {
                this.B.clear();
                z2 = false;
            } else {
                z2 = false;
                this.B.set(fVar2.f1943e, false);
            }
            r9 = z2;
            r3 = true;
        }
        ?? r5 = r9;
        if (r3 == false) {
            A2(vVar, this.f1911y);
        }
        if (this.f1911y.f2063e == -1) {
            iL2 = this.f1907u.m() - o2(this.f1907u.m());
        } else {
            iL2 = l2(this.f1907u.i()) - this.f1907u.i();
        }
        return iL2 > 0 ? Math.min(fVar.f2060b, iL2) : r5 == true ? 1 : 0;
    }

    private int c2(int i3) {
        int iJ = J();
        for (int i4 = 0; i4 < iJ; i4++) {
            int iH0 = h0(I(i4));
            if (iH0 >= 0 && iH0 < i3) {
                return iH0;
            }
        }
        return 0;
    }

    private int g2(int i3) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            int iH0 = h0(I(iJ));
            if (iH0 >= 0 && iH0 < i3) {
                return iH0;
            }
        }
        return 0;
    }

    private void h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int i3;
        int iL2 = l2(Integer.MIN_VALUE);
        if (iL2 != Integer.MIN_VALUE && (i3 = this.f1907u.i() - iL2) > 0) {
            int i4 = i3 - (-F2(-i3, vVar, a0Var));
            if (!z2 || i4 <= 0) {
                return;
            }
            this.f1907u.r(i4);
        }
    }

    private void i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int iM;
        int iO2 = o2(Integer.MAX_VALUE);
        if (iO2 != Integer.MAX_VALUE && (iM = iO2 - this.f1907u.m()) > 0) {
            int iF2 = iM - F2(iM, vVar, a0Var);
            if (!z2 || iF2 <= 0) {
                return;
            }
            this.f1907u.r(-iF2);
        }
    }

    private int l2(int i3) {
        int iL = this.f1906t[0].l(i3);
        for (int i4 = 1; i4 < this.f1905s; i4++) {
            int iL2 = this.f1906t[i4].l(i3);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int m2(int i3) {
        int iP = this.f1906t[0].p(i3);
        for (int i4 = 1; i4 < this.f1905s; i4++) {
            int iP2 = this.f1906t[i4].p(i3);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private int n2(int i3) {
        int iL = this.f1906t[0].l(i3);
        for (int i4 = 1; i4 < this.f1905s; i4++) {
            int iL2 = this.f1906t[i4].l(i3);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int o2(int i3) {
        int iP = this.f1906t[0].p(i3);
        for (int i4 = 1; i4 < this.f1905s; i4++) {
            int iP2 = this.f1906t[i4].p(i3);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private f p2(androidx.recyclerview.widget.f fVar) {
        int i3;
        int i4;
        int i5 = -1;
        if (x2(fVar.f2063e)) {
            i3 = this.f1905s - 1;
            i4 = -1;
        } else {
            i3 = 0;
            i5 = this.f1905s;
            i4 = 1;
        }
        f fVar2 = null;
        if (fVar.f2063e == 1) {
            int i6 = Integer.MAX_VALUE;
            int iM = this.f1907u.m();
            while (i3 != i5) {
                f fVar3 = this.f1906t[i3];
                int iL = fVar3.l(iM);
                if (iL < i6) {
                    fVar2 = fVar3;
                    i6 = iL;
                }
                i3 += i4;
            }
            return fVar2;
        }
        int i7 = Integer.MIN_VALUE;
        int i8 = this.f1907u.i();
        while (i3 != i5) {
            f fVar4 = this.f1906t[i3];
            int iP = fVar4.p(i8);
            if (iP > i7) {
                fVar2 = fVar4;
                i7 = iP;
            }
            i3 += i4;
        }
        return fVar2;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void q2(int i3, int i4, int i5) {
        int i6;
        int i7;
        int iK2;
        int iK3 = this.A ? k2() : j2();
        if (i5 == 8) {
            if (i3 < i4) {
                i6 = i4 + 1;
            } else {
                i6 = i3 + 1;
                i7 = i4;
            }
            this.E.h(i7);
            if (i5 != 1) {
                this.E.j(i3, i4);
            } else if (i5 != 2) {
                this.E.k(i3, i4);
            } else if (i5 == 8) {
                this.E.k(i3, 1);
                this.E.j(i4, 1);
            }
            if (i6 <= iK3) {
                return;
            }
            if (this.A) {
                iK2 = j2();
            } else {
                iK2 = k2();
            }
            if (i7 <= iK2) {
                t1();
            }
        }
        i6 = i3 + i4;
        i7 = i3;
        this.E.h(i7);
        if (i5 != 1) {
            this.E.j(i3, i4);
        } else if (i5 != 2) {
            this.E.k(i3, i4);
        } else if (i5 == 8) {
            this.E.k(i3, 1);
            this.E.j(i4, 1);
        }
        if (i6 <= iK3) {
            return;
        }
        if (this.A) {
            iK2 = j2();
        } else {
            iK2 = k2();
        }
        if (i7 <= iK2) {
            t1();
        }
    }

    private void u2(View view, int i3, int i4, boolean z2) {
        j(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int iR2 = R2(i3, i5 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i6 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int iR3 = R2(i4, i6 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z2 ? H1(view, iR2, iR3, cVar) : F1(view, iR2, iR3, cVar)) {
            view.measure(iR2, iR3);
        }
    }

    private void v2(View view, c cVar, boolean z2) {
        if (cVar.f1922f) {
            if (this.f1909w == 1) {
                u2(view, this.J, RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z2);
                return;
            } else {
                u2(view, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z2);
                return;
            }
        }
        if (this.f1909w == 1) {
            u2(view, RecyclerView.o.K(this.f1910x, p0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z2);
        } else {
            u2(view, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.K(this.f1910x, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:89:0x015a  */
    private void w2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        boolean z3;
        e eVar;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && a0Var.b() == 0) {
            k1(vVar);
            bVar.c();
            return;
        }
        boolean z4 = (bVar.f1918e && this.C == -1 && this.I == null) ? false : true;
        if (z4) {
            bVar.c();
            if (this.I != null) {
                N1(bVar);
            } else {
                E2();
                bVar.f1916c = this.A;
            }
            N2(a0Var, bVar);
            bVar.f1918e = true;
        }
        if (this.I == null && this.C == -1 && (bVar.f1916c != this.G || t2() != this.H)) {
            this.E.b();
            bVar.f1917d = true;
        }
        if (J() > 0 && ((eVar = this.I) == null || eVar.f1931d < 1)) {
            if (bVar.f1917d) {
                for (int i3 = 0; i3 < this.f1905s; i3++) {
                    this.f1906t[i3].e();
                    int i4 = bVar.f1915b;
                    if (i4 != Integer.MIN_VALUE) {
                        this.f1906t[i3].v(i4);
                    }
                }
            } else if (z4 || this.L.f1919f == null) {
                for (int i5 = 0; i5 < this.f1905s; i5++) {
                    this.f1906t[i5].b(this.A, bVar.f1915b);
                }
                this.L.d(this.f1906t);
            } else {
                for (int i6 = 0; i6 < this.f1905s; i6++) {
                    f fVar = this.f1906t[i6];
                    fVar.e();
                    fVar.v(this.L.f1919f[i6]);
                }
            }
        }
        w(vVar);
        this.f1911y.f2059a = false;
        this.M = false;
        P2(this.f1908v.n());
        O2(bVar.f1914a, a0Var);
        if (bVar.f1916c) {
            G2(-1);
            b2(vVar, this.f1911y, a0Var);
            G2(1);
            androidx.recyclerview.widget.f fVar2 = this.f1911y;
            fVar2.f2061c = bVar.f1914a + fVar2.f2062d;
            b2(vVar, fVar2, a0Var);
        } else {
            G2(1);
            b2(vVar, this.f1911y, a0Var);
            G2(-1);
            androidx.recyclerview.widget.f fVar3 = this.f1911y;
            fVar3.f2061c = bVar.f1914a + fVar3.f2062d;
            b2(vVar, fVar3, a0Var);
        }
        D2();
        if (J() > 0) {
            if (this.A) {
                h2(vVar, a0Var, true);
                i2(vVar, a0Var, false);
            } else {
                i2(vVar, a0Var, true);
                h2(vVar, a0Var, false);
            }
        }
        if (z2 && !a0Var.e()) {
            if (this.F != 0 && J() > 0 && (this.M || r2() != null)) {
                o1(this.P);
                z3 = S1();
            }
        }
        if (a0Var.e()) {
            this.L.c();
        }
        this.G = bVar.f1916c;
        this.H = t2();
        if (z3) {
            this.L.c();
            w2(vVar, a0Var, false);
        }
    }

    private boolean x2(int i3) {
        if (this.f1909w == 0) {
            return (i3 == -1) != this.A;
        }
        return ((i3 == -1) == this.A) == t2();
    }

    private void z2(View view) {
        for (int i3 = this.f1905s - 1; i3 >= 0; i3--) {
            this.f1906t[i3].u(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i3) {
        super.C0(i3);
        for (int i4 = 0; i4 < this.f1905s; i4++) {
            this.f1906t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i3, int i4) {
        int iN;
        int iN2;
        int iE0 = e0() + f0();
        int iG0 = g0() + d0();
        if (this.f1909w == 1) {
            iN2 = RecyclerView.o.n(i4, rect.height() + iG0, b0());
            iN = RecyclerView.o.n(i3, (this.f1910x * this.f1905s) + iE0, c0());
        } else {
            iN = RecyclerView.o.n(i3, rect.width() + iE0, c0());
            iN2 = RecyclerView.o.n(i4, (this.f1910x * this.f1905s) + iG0, b0());
        }
        B1(iN, iN2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f1909w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i3) {
        super.D0(i3);
        for (int i4 = 0; i4 < this.f1905s; i4++) {
            this.f1906t[i4].r(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    int F2(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i3 == 0) {
            return 0;
        }
        y2(i3, a0Var);
        int iB2 = b2(vVar, this.f1911y, a0Var);
        if (this.f1911y.f2060b >= iB2) {
            i3 = i3 < 0 ? -iB2 : iB2;
        }
        this.f1907u.r(-i3);
        this.G = this.A;
        androidx.recyclerview.widget.f fVar = this.f1911y;
        fVar.f2060b = 0;
        A2(vVar, fVar);
        return i3;
    }

    public void H2(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i3 == this.f1909w) {
            return;
        }
        this.f1909w = i3;
        i iVar = this.f1907u;
        this.f1907u = this.f1908v;
        this.f1908v = iVar;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        o1(this.P);
        for (int i3 = 0; i3 < this.f1905s; i3++) {
            this.f1906t[i3].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i3) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i3);
        J1(gVar);
    }

    public void I2(boolean z2) {
        g(null);
        e eVar = this.I;
        if (eVar != null && eVar.f1936i != z2) {
            eVar.f1936i = z2;
        }
        this.f1912z = z2;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View viewB;
        View viewM;
        if (J() == 0 || (viewB = B(view)) == null) {
            return null;
        }
        E2();
        int iX1 = X1(i3);
        if (iX1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewB.getLayoutParams();
        boolean z2 = cVar.f1922f;
        f fVar = cVar.f1921e;
        int iK2 = iX1 == 1 ? k2() : j2();
        O2(iK2, a0Var);
        G2(iX1);
        androidx.recyclerview.widget.f fVar2 = this.f1911y;
        fVar2.f2061c = fVar2.f2062d + iK2;
        fVar2.f2060b = (int) (this.f1907u.n() * 0.33333334f);
        androidx.recyclerview.widget.f fVar3 = this.f1911y;
        fVar3.f2066h = true;
        fVar3.f2059a = false;
        b2(vVar, fVar3, a0Var);
        this.G = this.A;
        if (!z2 && (viewM = fVar.m(iK2, iX1)) != null && viewM != viewB) {
            return viewM;
        }
        if (x2(iX1)) {
            for (int i4 = this.f1905s - 1; i4 >= 0; i4--) {
                View viewM2 = this.f1906t[i4].m(iK2, iX1);
                if (viewM2 != null && viewM2 != viewB) {
                    return viewM2;
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f1905s; i5++) {
                View viewM3 = this.f1906t[i5].m(iK2, iX1);
                if (viewM3 != null && viewM3 != viewB) {
                    return viewM3;
                }
            }
        }
        boolean z3 = (this.f1912z ^ true) == (iX1 == -1);
        if (!z2) {
            View viewC = C(z3 ? fVar.f() : fVar.g());
            if (viewC != null && viewC != viewB) {
                return viewC;
            }
        }
        if (x2(iX1)) {
            for (int i6 = this.f1905s - 1; i6 >= 0; i6--) {
                if (i6 != fVar.f1943e) {
                    View viewC2 = C(z3 ? this.f1906t[i6].f() : this.f1906t[i6].g());
                    if (viewC2 != null && viewC2 != viewB) {
                        return viewC2;
                    }
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f1905s; i7++) {
                View viewC3 = C(z3 ? this.f1906t[i7].f() : this.f1906t[i7].g());
                if (viewC3 != null && viewC3 != viewB) {
                    return viewC3;
                }
            }
        }
        return null;
    }

    public void J2(int i3) {
        g(null);
        if (i3 != this.f1905s) {
            s2();
            this.f1905s = i3;
            this.B = new BitSet(this.f1905s);
            this.f1906t = new f[this.f1905s];
            for (int i4 = 0; i4 < this.f1905s; i4++) {
                this.f1906t[i4] = new f(i4);
            }
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            View viewE2 = e2(false);
            View viewD2 = d2(false);
            if (viewE2 == null || viewD2 == null) {
                return;
            }
            int iH0 = h0(viewE2);
            int iH1 = h0(viewD2);
            if (iH0 < iH1) {
                accessibilityEvent.setFromIndex(iH0);
                accessibilityEvent.setToIndex(iH1);
            } else {
                accessibilityEvent.setFromIndex(iH1);
                accessibilityEvent.setToIndex(iH0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.I == null;
    }

    boolean M2(RecyclerView.a0 a0Var, b bVar) {
        int i3;
        if (!a0Var.e() && (i3 = this.C) != -1) {
            if (i3 >= 0 && i3 < a0Var.b()) {
                e eVar = this.I;
                if (eVar == null || eVar.f1929b == -1 || eVar.f1931d < 1) {
                    View viewC = C(this.C);
                    if (viewC != null) {
                        bVar.f1914a = this.A ? k2() : j2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f1916c) {
                                bVar.f1915b = (this.f1907u.i() - this.D) - this.f1907u.d(viewC);
                            } else {
                                bVar.f1915b = (this.f1907u.m() + this.D) - this.f1907u.g(viewC);
                            }
                            return true;
                        }
                        if (this.f1907u.e(viewC) > this.f1907u.n()) {
                            bVar.f1915b = bVar.f1916c ? this.f1907u.i() : this.f1907u.m();
                            return true;
                        }
                        int iG = this.f1907u.g(viewC) - this.f1907u.m();
                        if (iG < 0) {
                            bVar.f1915b = -iG;
                            return true;
                        }
                        int i4 = this.f1907u.i() - this.f1907u.d(viewC);
                        if (i4 < 0) {
                            bVar.f1915b = i4;
                            return true;
                        }
                        bVar.f1915b = Integer.MIN_VALUE;
                    } else {
                        int i5 = this.C;
                        bVar.f1914a = i5;
                        int i6 = this.D;
                        if (i6 == Integer.MIN_VALUE) {
                            bVar.f1916c = R1(i5) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i6);
                        }
                        bVar.f1917d = true;
                    }
                } else {
                    bVar.f1915b = Integer.MIN_VALUE;
                    bVar.f1914a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1909w == 1 ? this.f1905s : super.N(vVar, a0Var);
    }

    void N2(RecyclerView.a0 a0Var, b bVar) {
        if (M2(a0Var, bVar) || L2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f1914a = 0;
    }

    boolean O1() {
        int iL = this.f1906t[0].l(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f1905s; i3++) {
            if (this.f1906t[i3].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, f0.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.O0(view, dVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f1909w == 0) {
            dVar.a0(f0.d.c.f(cVar.e(), cVar.f1922f ? this.f1905s : 1, -1, -1, false, false));
        } else {
            dVar.a0(f0.d.c.f(-1, -1, cVar.e(), cVar.f1922f ? this.f1905s : 1, false, false));
        }
    }

    boolean P1() {
        int iP = this.f1906t[0].p(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.f1905s; i3++) {
            if (this.f1906t[i3].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    void P2(int i3) {
        this.f1910x = i3 / this.f1905s;
        this.J = View.MeasureSpec.makeMeasureSpec(i3, this.f1908v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i3, int i4) {
        q2(i3, i4, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.E.b();
        t1();
    }

    boolean S1() {
        int iJ2;
        int iK2;
        if (J() == 0 || this.F == 0 || !r0()) {
            return false;
        }
        if (this.A) {
            iJ2 = k2();
            iK2 = j2();
        } else {
            iJ2 = j2();
            iK2 = k2();
        }
        if (iJ2 == 0 && r2() != null) {
            this.E.b();
            u1();
            t1();
            return true;
        }
        if (!this.M) {
            return false;
        }
        int i3 = this.A ? -1 : 1;
        int i4 = iK2 + 1;
        d.a aVarE = this.E.e(iJ2, i4, i3, true);
        if (aVarE == null) {
            this.M = false;
            this.E.d(i4);
            return false;
        }
        d.a aVarE2 = this.E.e(iJ2, aVarE.f1925b, i3 * (-1), true);
        if (aVarE2 == null) {
            this.E.d(aVarE.f1925b);
        } else {
            this.E.d(aVarE2.f1925b + 1);
        }
        u1();
        t1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i3, int i4, int i5) {
        q2(i3, i4, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i3, int i4) {
        q2(i3, i4, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i3, int i4, Object obj) {
        q2(i3, i4, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        w2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i3) {
        int iR1 = R1(i3);
        PointF pointF = new PointF();
        if (iR1 == 0) {
            return null;
        }
        if (this.f1909w == 0) {
            pointF.x = iR1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iR1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.f1936i = this.f1912z;
        eVar.f1937j = this.G;
        eVar.f1938k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f1923a) == null) {
            eVar.f1933f = 0;
        } else {
            eVar.f1934g = iArr;
            eVar.f1933f = iArr.length;
            eVar.f1935h = dVar.f1924b;
        }
        if (J() > 0) {
            eVar.f1929b = this.G ? k2() : j2();
            eVar.f1930c = f2();
            int i3 = this.f1905s;
            eVar.f1931d = i3;
            eVar.f1932e = new int[i3];
            for (int i4 = 0; i4 < this.f1905s; i4++) {
                if (this.G) {
                    iP = this.f1906t[i4].l(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f1907u.i();
                        iP -= iM;
                    }
                } else {
                    iP = this.f1906t[i4].p(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f1907u.m();
                        iP -= iM;
                    }
                }
                eVar.f1932e[i4] = iP;
            }
        } else {
            eVar.f1929b = -1;
            eVar.f1930c = -1;
            eVar.f1931d = 0;
        }
        return eVar;
    }

    View d2(boolean z2) {
        int iM = this.f1907u.m();
        int i3 = this.f1907u.i();
        View view = null;
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            int iG = this.f1907u.g(viewI);
            int iD = this.f1907u.d(viewI);
            if (iD > iM && iG < i3) {
                if (iD <= i3 || !z2) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(int i3) {
        if (i3 == 0) {
            S1();
        }
    }

    View e2(boolean z2) {
        int iM = this.f1907u.m();
        int i3 = this.f1907u.i();
        int iJ = J();
        View view = null;
        for (int i4 = 0; i4 < iJ; i4++) {
            View viewI = I(i4);
            int iG = this.f1907u.g(viewI);
            if (this.f1907u.d(viewI) > iM && iG < i3) {
                if (iG >= iM || !z2) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    int f2() {
        View viewD2 = this.A ? d2(true) : e2(true);
        if (viewD2 == null) {
            return -1;
        }
        return h0(viewD2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.I == null) {
            super.g(str);
        }
    }

    int j2() {
        if (J() == 0) {
            return 0;
        }
        return h0(I(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f1909w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1909w == 0 ? this.f1905s : super.k0(vVar, a0Var);
    }

    int k2() {
        int iJ = J();
        if (iJ == 0) {
            return 0;
        }
        return h0(I(iJ - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f1909w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i3, int i4, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int iL;
        int iP;
        if (this.f1909w != 0) {
            i3 = i4;
        }
        if (J() == 0 || i3 == 0) {
            return;
        }
        y2(i3, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f1905s) {
            this.O = new int[this.f1905s];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f1905s; i6++) {
            androidx.recyclerview.widget.f fVar = this.f1911y;
            if (fVar.f2062d == -1) {
                iL = fVar.f2064f;
                iP = this.f1906t[i6].p(iL);
            } else {
                iL = this.f1906t[i6].l(fVar.f2065g);
                iP = this.f1911y.f2065g;
            }
            int i7 = iL - iP;
            if (i7 >= 0) {
                this.O[i5] = i7;
                i5++;
            }
        }
        Arrays.sort(this.O, 0, i5);
        for (int i8 = 0; i8 < i5 && this.f1911y.a(a0Var); i8++) {
            cVar.a(this.f1911y.f2061c, this.O[i8]);
            androidx.recyclerview.widget.f fVar2 = this.f1911y;
            fVar2.f2061c += fVar2.f2062d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    View r2() {
        int i3;
        int i4;
        boolean z2;
        int iJ = J() - 1;
        BitSet bitSet = new BitSet(this.f1905s);
        bitSet.set(0, this.f1905s, true);
        byte b3 = (this.f1909w == 1 && t2()) ? (byte) 1 : (byte) -1;
        if (this.A) {
            i3 = -1;
        } else {
            i3 = iJ + 1;
            iJ = 0;
        }
        int i5 = iJ < i3 ? 1 : -1;
        while (iJ != i3) {
            View viewI = I(iJ);
            c cVar = (c) viewI.getLayoutParams();
            if (bitSet.get(cVar.f1921e.f1943e)) {
                if (T1(cVar.f1921e)) {
                    return viewI;
                }
                bitSet.clear(cVar.f1921e.f1943e);
            }
            if (!cVar.f1922f && (i4 = iJ + i5) != i3) {
                View viewI2 = I(i4);
                if (this.A) {
                    int iD = this.f1907u.d(viewI);
                    int iD2 = this.f1907u.d(viewI2);
                    if (iD < iD2) {
                        return viewI;
                    }
                    if (iD == iD2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    int iG = this.f1907u.g(viewI);
                    int iG2 = this.f1907u.g(viewI2);
                    if (iG > iG2) {
                        return viewI;
                    }
                    if (iG == iG2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    if ((cVar.f1921e.f1943e - ((c) viewI2.getLayoutParams()).f1921e.f1943e < 0) != (b3 < 0)) {
                        return viewI;
                    }
                } else {
                    continue;
                }
            }
            iJ += i5;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return this.F != 0;
    }

    public void s2() {
        this.E.b();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    boolean t2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i3, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i3) {
        e eVar = this.I;
        if (eVar != null && eVar.f1929b != i3) {
            eVar.j();
        }
        this.C = i3;
        this.D = Integer.MIN_VALUE;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i3, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i3, vVar, a0Var);
    }

    void y2(int i3, RecyclerView.a0 a0Var) {
        int i4;
        int iJ2;
        if (i3 > 0) {
            iJ2 = k2();
            i4 = 1;
        } else {
            i4 = -1;
            iJ2 = j2();
        }
        this.f1911y.f2059a = true;
        O2(iJ2, a0Var);
        G2(i4);
        androidx.recyclerview.widget.f fVar = this.f1911y;
        fVar.f2061c = iJ2 + fVar.f2062d;
        fVar.f2060b = Math.abs(i3);
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f1923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<a> f1924b;

        d() {
        }

        private int i(int i3) {
            if (this.f1924b == null) {
                return -1;
            }
            a aVarF = f(i3);
            if (aVarF != null) {
                this.f1924b.remove(aVarF);
            }
            int size = this.f1924b.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i4 = -1;
                    break;
                }
                if (this.f1924b.get(i4).f1925b >= i3) {
                    break;
                }
                i4++;
            }
            if (i4 == -1) {
                return -1;
            }
            a aVar = this.f1924b.get(i4);
            this.f1924b.remove(i4);
            return aVar.f1925b;
        }

        private void l(int i3, int i4) {
            List<a> list = this.f1924b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1924b.get(size);
                int i5 = aVar.f1925b;
                if (i5 >= i3) {
                    aVar.f1925b = i5 + i4;
                }
            }
        }

        private void m(int i3, int i4) {
            List<a> list = this.f1924b;
            if (list == null) {
                return;
            }
            int i5 = i3 + i4;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1924b.get(size);
                int i6 = aVar.f1925b;
                if (i6 >= i3) {
                    if (i6 < i5) {
                        this.f1924b.remove(size);
                    } else {
                        aVar.f1925b = i6 - i4;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f1924b == null) {
                this.f1924b = new ArrayList();
            }
            int size = this.f1924b.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar2 = this.f1924b.get(i3);
                if (aVar2.f1925b == aVar.f1925b) {
                    this.f1924b.remove(i3);
                }
                if (aVar2.f1925b >= aVar.f1925b) {
                    this.f1924b.add(i3, aVar);
                    return;
                }
            }
            this.f1924b.add(aVar);
        }

        void b() {
            int[] iArr = this.f1923a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1924b = null;
        }

        void c(int i3) {
            int[] iArr = this.f1923a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i3, 10) + 1];
                this.f1923a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[o(i3)];
                this.f1923a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1923a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i3) {
            List<a> list = this.f1924b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1924b.get(size).f1925b >= i3) {
                        this.f1924b.remove(size);
                    }
                }
            }
            return h(i3);
        }

        public a e(int i3, int i4, int i5, boolean z2) {
            List<a> list = this.f1924b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = this.f1924b.get(i6);
                int i7 = aVar.f1925b;
                if (i7 >= i4) {
                    return null;
                }
                if (i7 >= i3 && (i5 == 0 || aVar.f1926c == i5 || (z2 && aVar.f1928e))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i3) {
            List<a> list = this.f1924b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1924b.get(size);
                if (aVar.f1925b == i3) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i3) {
            int[] iArr = this.f1923a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            return iArr[i3];
        }

        int h(int i3) {
            int[] iArr = this.f1923a;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            int i4 = i(i3);
            if (i4 == -1) {
                int[] iArr2 = this.f1923a;
                Arrays.fill(iArr2, i3, iArr2.length, -1);
                return this.f1923a.length;
            }
            int i5 = i4 + 1;
            Arrays.fill(this.f1923a, i3, i5, -1);
            return i5;
        }

        void j(int i3, int i4) {
            int[] iArr = this.f1923a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f1923a;
            System.arraycopy(iArr2, i3, iArr2, i5, (iArr2.length - i3) - i4);
            Arrays.fill(this.f1923a, i3, i5, -1);
            l(i3, i4);
        }

        void k(int i3, int i4) {
            int[] iArr = this.f1923a;
            if (iArr == null || i3 >= iArr.length) {
                return;
            }
            int i5 = i3 + i4;
            c(i5);
            int[] iArr2 = this.f1923a;
            System.arraycopy(iArr2, i5, iArr2, i3, (iArr2.length - i3) - i4);
            int[] iArr3 = this.f1923a;
            Arrays.fill(iArr3, iArr3.length - i4, iArr3.length, -1);
            m(i3, i4);
        }

        void n(int i3, f fVar) {
            c(i3);
            this.f1923a[i3] = fVar.f1943e;
        }

        int o(int i3) {
            int length = this.f1923a.length;
            while (length <= i3) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0017a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f1925b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f1926c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f1927d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f1928e;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            static class C0017a implements Parcelable.Creator<a> {
                C0017a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i3) {
                    return new a[i3];
                }
            }

            a(Parcel parcel) {
                this.f1925b = parcel.readInt();
                this.f1926c = parcel.readInt();
                this.f1928e = parcel.readInt() == 1;
                int i3 = parcel.readInt();
                if (i3 > 0) {
                    int[] iArr = new int[i3];
                    this.f1927d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            int j(int i3) {
                int[] iArr = this.f1927d;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i3];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1925b + ", mGapDir=" + this.f1926c + ", mHasUnwantedGapAfter=" + this.f1928e + ", mGapPerSpan=" + Arrays.toString(this.f1927d) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeInt(this.f1925b);
                parcel.writeInt(this.f1926c);
                parcel.writeInt(this.f1928e ? 1 : 0);
                int[] iArr = this.f1927d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1927d);
                }
            }

            a() {
            }
        }
    }
}
