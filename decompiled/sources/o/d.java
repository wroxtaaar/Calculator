package o;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: LinearSystem.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f5341q = 1000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static e f5342r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f5343s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f5344t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static long f5345u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5348c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    o.b[] f5351f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final c f5358m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private a f5361p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5346a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, i> f5347b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5349d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5350e = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5352g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5353h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean[] f5354i = new boolean[32];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f5355j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f5356k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f5357l = 32;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private i[] f5359n = new i[f5341q];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f5360o = 0;

    /* JADX INFO: compiled from: LinearSystem.java */
    interface a {
        void a(i iVar);

        i b(d dVar, boolean[] zArr);

        void c(a aVar);

        void clear();

        i getKey();
    }

    /* JADX INFO: compiled from: LinearSystem.java */
    class b extends o.b {
        public b(c cVar) {
            this.f5335e = new j(this, cVar);
        }
    }

    public d() {
        this.f5351f = null;
        this.f5351f = new o.b[32];
        C();
        c cVar = new c();
        this.f5358m = cVar;
        this.f5348c = new h(cVar);
        if (f5343s) {
            this.f5361p = new b(cVar);
        } else {
            this.f5361p = new o.b(cVar);
        }
    }

    private final int B(a aVar, boolean z2) {
        for (int i3 = 0; i3 < this.f5355j; i3++) {
            this.f5354i[i3] = false;
        }
        boolean z3 = false;
        int i4 = 0;
        while (!z3) {
            i4++;
            if (i4 >= this.f5355j * 2) {
                return i4;
            }
            if (aVar.getKey() != null) {
                this.f5354i[aVar.getKey().f5378c] = true;
            }
            i iVarB = aVar.b(this, this.f5354i);
            if (iVarB != null) {
                boolean[] zArr = this.f5354i;
                int i5 = iVarB.f5378c;
                if (zArr[i5]) {
                    return i4;
                }
                zArr[i5] = true;
            }
            if (iVarB != null) {
                float f3 = Float.MAX_VALUE;
                int i6 = -1;
                for (int i7 = 0; i7 < this.f5356k; i7++) {
                    o.b bVar = this.f5351f[i7];
                    if (bVar.f5331a.f5385j != i.a.UNRESTRICTED && !bVar.f5336f && bVar.t(iVarB)) {
                        float f4 = bVar.f5335e.f(iVarB);
                        if (f4 < 0.0f) {
                            float f5 = (-bVar.f5332b) / f4;
                            if (f5 < f3) {
                                i6 = i7;
                                f3 = f5;
                            }
                        }
                    }
                }
                if (i6 > -1) {
                    o.b bVar2 = this.f5351f[i6];
                    bVar2.f5331a.f5379d = -1;
                    bVar2.y(iVarB);
                    i iVar = bVar2.f5331a;
                    iVar.f5379d = i6;
                    iVar.g(bVar2);
                }
            } else {
                z3 = true;
            }
        }
        return i4;
    }

    private void C() {
        int i3 = 0;
        if (f5343s) {
            while (true) {
                o.b[] bVarArr = this.f5351f;
                if (i3 >= bVarArr.length) {
                    return;
                }
                o.b bVar = bVarArr[i3];
                if (bVar != null) {
                    this.f5358m.f5337a.a(bVar);
                }
                this.f5351f[i3] = null;
                i3++;
            }
        } else {
            while (true) {
                o.b[] bVarArr2 = this.f5351f;
                if (i3 >= bVarArr2.length) {
                    return;
                }
                o.b bVar2 = bVarArr2[i3];
                if (bVar2 != null) {
                    this.f5358m.f5338b.a(bVar2);
                }
                this.f5351f[i3] = null;
                i3++;
            }
        }
    }

    private i a(i.a aVar, String str) {
        i iVarB = this.f5358m.f5339c.b();
        if (iVarB == null) {
            iVarB = new i(aVar, str);
            iVarB.f(aVar, str);
        } else {
            iVarB.d();
            iVarB.f(aVar, str);
        }
        int i3 = this.f5360o;
        int i4 = f5341q;
        if (i3 >= i4) {
            int i5 = i4 * 2;
            f5341q = i5;
            this.f5359n = (i[]) Arrays.copyOf(this.f5359n, i5);
        }
        i[] iVarArr = this.f5359n;
        int i6 = this.f5360o;
        this.f5360o = i6 + 1;
        iVarArr[i6] = iVarB;
        return iVarB;
    }

    private final void l(o.b bVar) {
        if (f5343s) {
            o.b[] bVarArr = this.f5351f;
            int i3 = this.f5356k;
            if (bVarArr[i3] != null) {
                this.f5358m.f5337a.a(bVarArr[i3]);
            }
        } else {
            o.b[] bVarArr2 = this.f5351f;
            int i4 = this.f5356k;
            if (bVarArr2[i4] != null) {
                this.f5358m.f5338b.a(bVarArr2[i4]);
            }
        }
        o.b[] bVarArr3 = this.f5351f;
        int i5 = this.f5356k;
        bVarArr3[i5] = bVar;
        i iVar = bVar.f5331a;
        iVar.f5379d = i5;
        this.f5356k = i5 + 1;
        iVar.g(bVar);
    }

    private void n() {
        for (int i3 = 0; i3 < this.f5356k; i3++) {
            o.b bVar = this.f5351f[i3];
            bVar.f5331a.f5381f = bVar.f5332b;
        }
    }

    public static o.b s(d dVar, i iVar, i iVar2, float f3) {
        return dVar.r().j(iVar, iVar2, f3);
    }

    private int u(a aVar) throws Exception {
        float f3;
        boolean z2;
        int i3 = 0;
        while (true) {
            f3 = 0.0f;
            if (i3 >= this.f5356k) {
                z2 = false;
                break;
            }
            o.b[] bVarArr = this.f5351f;
            if (bVarArr[i3].f5331a.f5385j != i.a.UNRESTRICTED && bVarArr[i3].f5332b < 0.0f) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (!z2) {
            return 0;
        }
        boolean z3 = false;
        int i4 = 0;
        while (!z3) {
            i4++;
            float f4 = Float.MAX_VALUE;
            int i5 = -1;
            int i6 = -1;
            int i7 = 0;
            int i8 = 0;
            while (i7 < this.f5356k) {
                o.b bVar = this.f5351f[i7];
                if (bVar.f5331a.f5385j != i.a.UNRESTRICTED && !bVar.f5336f && bVar.f5332b < f3) {
                    int i9 = 1;
                    while (i9 < this.f5355j) {
                        i iVar = this.f5358m.f5340d[i9];
                        float f5 = bVar.f5335e.f(iVar);
                        if (f5 > f3) {
                            for (int i10 = 0; i10 < 9; i10++) {
                                float f6 = iVar.f5383h[i10] / f5;
                                if ((f6 < f4 && i10 == i8) || i10 > i8) {
                                    i8 = i10;
                                    f4 = f6;
                                    i5 = i7;
                                    i6 = i9;
                                }
                            }
                        }
                        i9++;
                        f3 = 0.0f;
                    }
                }
                i7++;
                f3 = 0.0f;
            }
            if (i5 != -1) {
                o.b bVar2 = this.f5351f[i5];
                bVar2.f5331a.f5379d = -1;
                bVar2.y(this.f5358m.f5340d[i6]);
                i iVar2 = bVar2.f5331a;
                iVar2.f5379d = i5;
                iVar2.g(bVar2);
            } else {
                z3 = true;
            }
            if (i4 > this.f5355j / 2) {
                z3 = true;
            }
            f3 = 0.0f;
        }
        return i4;
    }

    public static e w() {
        return f5342r;
    }

    private void y() {
        int i3 = this.f5349d * 2;
        this.f5349d = i3;
        this.f5351f = (o.b[]) Arrays.copyOf(this.f5351f, i3);
        c cVar = this.f5358m;
        cVar.f5340d = (i[]) Arrays.copyOf(cVar.f5340d, this.f5349d);
        int i4 = this.f5349d;
        this.f5354i = new boolean[i4];
        this.f5350e = i4;
        this.f5357l = i4;
    }

    void A(a aVar) throws Exception {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i3 = 0;
        while (true) {
            cVar = this.f5358m;
            i[] iVarArr = cVar.f5340d;
            if (i3 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i3];
            if (iVar != null) {
                iVar.d();
            }
            i3++;
        }
        cVar.f5339c.c(this.f5359n, this.f5360o);
        this.f5360o = 0;
        Arrays.fill(this.f5358m.f5340d, (Object) null);
        HashMap<String, i> map = this.f5347b;
        if (map != null) {
            map.clear();
        }
        this.f5346a = 0;
        this.f5348c.clear();
        this.f5355j = 1;
        for (int i4 = 0; i4 < this.f5356k; i4++) {
            this.f5351f[i4].f5333c = false;
        }
        C();
        this.f5356k = 0;
        if (f5343s) {
            this.f5361p = new b(this.f5358m);
        } else {
            this.f5361p = new o.b(this.f5358m);
        }
    }

    public void b(p.e eVar, p.e eVar2, float f3, int i3) {
        p.d.b bVar = p.d.b.LEFT;
        i iVarQ = q(eVar.k(bVar));
        p.d.b bVar2 = p.d.b.TOP;
        i iVarQ2 = q(eVar.k(bVar2));
        p.d.b bVar3 = p.d.b.RIGHT;
        i iVarQ3 = q(eVar.k(bVar3));
        p.d.b bVar4 = p.d.b.BOTTOM;
        i iVarQ4 = q(eVar.k(bVar4));
        i iVarQ5 = q(eVar2.k(bVar));
        i iVarQ6 = q(eVar2.k(bVar2));
        i iVarQ7 = q(eVar2.k(bVar3));
        i iVarQ8 = q(eVar2.k(bVar4));
        o.b bVarR = r();
        double d3 = f3;
        double d4 = i3;
        bVarR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (Math.sin(d3) * d4));
        d(bVarR);
        o.b bVarR2 = r();
        bVarR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (Math.cos(d3) * d4));
        d(bVarR2);
    }

    public void c(i iVar, i iVar2, int i3, float f3, i iVar3, i iVar4, int i4, int i5) {
        o.b bVarR = r();
        bVarR.h(iVar, iVar2, i3, f3, iVar3, iVar4, i4);
        if (i5 != 8) {
            bVarR.d(this, i5);
        }
        d(bVarR);
    }

    public void d(o.b bVar) {
        i iVarW;
        if (bVar == null) {
            return;
        }
        boolean z2 = true;
        if (this.f5356k + 1 >= this.f5357l || this.f5355j + 1 >= this.f5350e) {
            y();
        }
        boolean z3 = false;
        if (!bVar.f5336f) {
            bVar.D(this);
            if (bVar.u()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                i iVarP = p();
                bVar.f5331a = iVarP;
                l(bVar);
                this.f5361p.c(bVar);
                B(this.f5361p, true);
                if (iVarP.f5379d == -1) {
                    if (bVar.f5331a == iVarP && (iVarW = bVar.w(iVarP)) != null) {
                        bVar.y(iVarW);
                    }
                    if (!bVar.f5336f) {
                        bVar.f5331a.g(bVar);
                    }
                    this.f5356k--;
                }
            } else {
                z2 = false;
            }
            if (!bVar.s()) {
                return;
            } else {
                z3 = z2;
            }
        }
        if (z3) {
            return;
        }
        l(bVar);
    }

    public o.b e(i iVar, i iVar2, int i3, int i4) {
        if (i4 == 8 && iVar2.f5382g && iVar.f5379d == -1) {
            iVar.e(this, iVar2.f5381f + i3);
            return null;
        }
        o.b bVarR = r();
        bVarR.n(iVar, iVar2, i3);
        if (i4 != 8) {
            bVarR.d(this, i4);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(i iVar, int i3) {
        int i4 = iVar.f5379d;
        if (i4 == -1) {
            iVar.e(this, i3);
            return;
        }
        if (i4 == -1) {
            o.b bVarR = r();
            bVarR.i(iVar, i3);
            d(bVarR);
            return;
        }
        o.b bVar = this.f5351f[i4];
        if (bVar.f5336f) {
            bVar.f5332b = i3;
            return;
        }
        if (bVar.f5335e.k() == 0) {
            bVar.f5336f = true;
            bVar.f5332b = i3;
        } else {
            o.b bVarR2 = r();
            bVarR2.m(iVar, i3);
            d(bVarR2);
        }
    }

    public void g(i iVar, i iVar2, int i3, boolean z2) {
        o.b bVarR = r();
        i iVarT = t();
        iVarT.f5380e = 0;
        bVarR.o(iVar, iVar2, iVarT, i3);
        d(bVarR);
    }

    public void h(i iVar, i iVar2, int i3, int i4) {
        o.b bVarR = r();
        i iVarT = t();
        iVarT.f5380e = 0;
        bVarR.o(iVar, iVar2, iVarT, i3);
        if (i4 != 8) {
            m(bVarR, (int) (bVarR.f5335e.f(iVarT) * (-1.0f)), i4);
        }
        d(bVarR);
    }

    public void i(i iVar, i iVar2, int i3, boolean z2) {
        o.b bVarR = r();
        i iVarT = t();
        iVarT.f5380e = 0;
        bVarR.p(iVar, iVar2, iVarT, i3);
        d(bVarR);
    }

    public void j(i iVar, i iVar2, int i3, int i4) {
        o.b bVarR = r();
        i iVarT = t();
        iVarT.f5380e = 0;
        bVarR.p(iVar, iVar2, iVarT, i3);
        if (i4 != 8) {
            m(bVarR, (int) (bVarR.f5335e.f(iVarT) * (-1.0f)), i4);
        }
        d(bVarR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f3, int i3) {
        o.b bVarR = r();
        bVarR.k(iVar, iVar2, iVar3, iVar4, f3);
        if (i3 != 8) {
            bVarR.d(this, i3);
        }
        d(bVarR);
    }

    void m(o.b bVar, int i3, int i4) {
        bVar.e(o(i4, null), i3);
    }

    public i o(int i3, String str) {
        if (this.f5355j + 1 >= this.f5350e) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i4 = this.f5346a + 1;
        this.f5346a = i4;
        this.f5355j++;
        iVarA.f5378c = i4;
        iVarA.f5380e = i3;
        this.f5358m.f5340d[i4] = iVarA;
        this.f5348c.a(iVarA);
        return iVarA;
    }

    public i p() {
        if (this.f5355j + 1 >= this.f5350e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i3 = this.f5346a + 1;
        this.f5346a = i3;
        this.f5355j++;
        iVarA.f5378c = i3;
        this.f5358m.f5340d[i3] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarE = null;
        if (obj == null) {
            return null;
        }
        if (this.f5355j + 1 >= this.f5350e) {
            y();
        }
        if (obj instanceof p.d) {
            p.d dVar = (p.d) obj;
            iVarE = dVar.e();
            if (iVarE == null) {
                dVar.l(this.f5358m);
                iVarE = dVar.e();
            }
            int i3 = iVarE.f5378c;
            if (i3 == -1 || i3 > this.f5346a || this.f5358m.f5340d[i3] == null) {
                if (i3 != -1) {
                    iVarE.d();
                }
                int i4 = this.f5346a + 1;
                this.f5346a = i4;
                this.f5355j++;
                iVarE.f5378c = i4;
                iVarE.f5385j = i.a.UNRESTRICTED;
                this.f5358m.f5340d[i4] = iVarE;
            }
        }
        return iVarE;
    }

    public o.b r() {
        o.b bVarB;
        if (f5343s) {
            bVarB = this.f5358m.f5337a.b();
            if (bVarB == null) {
                bVarB = new b(this.f5358m);
                f5345u++;
            } else {
                bVarB.z();
            }
        } else {
            bVarB = this.f5358m.f5338b.b();
            if (bVarB == null) {
                bVarB = new o.b(this.f5358m);
                f5344t++;
            } else {
                bVarB.z();
            }
        }
        i.b();
        return bVarB;
    }

    public i t() {
        if (this.f5355j + 1 >= this.f5350e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i3 = this.f5346a + 1;
        this.f5346a = i3;
        this.f5355j++;
        iVarA.f5378c = i3;
        this.f5358m.f5340d[i3] = iVarA;
        return iVarA;
    }

    public c v() {
        return this.f5358m;
    }

    public int x(Object obj) {
        i iVarE = ((p.d) obj).e();
        if (iVarE != null) {
            return (int) (iVarE.f5381f + 0.5f);
        }
        return 0;
    }

    public void z() throws Exception {
        if (!this.f5352g && !this.f5353h) {
            A(this.f5348c);
            return;
        }
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f5356k) {
                z2 = true;
                break;
            } else if (!this.f5351f[i3].f5336f) {
                break;
            } else {
                i3++;
            }
        }
        if (z2) {
            n();
        } else {
            A(this.f5348c);
        }
    }
}
