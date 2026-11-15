package q;

import java.util.ArrayList;

/* JADX INFO: compiled from: BasicMeasure.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<p.e> f5779a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f5780b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p.f f5781c;

    /* JADX INFO: compiled from: BasicMeasure.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p.e.b f5782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p.e.b f5783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5786e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5787f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5788g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f5789h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f5790i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f5791j;
    }

    /* JADX INFO: renamed from: q.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicMeasure.java */
    public interface InterfaceC0082b {
        void a();

        void b(p.e eVar, a aVar);
    }

    public b(p.f fVar) {
        this.f5781c = fVar;
    }

    private boolean a(InterfaceC0082b interfaceC0082b, p.e eVar, boolean z2) {
        this.f5780b.f5782a = eVar.w();
        this.f5780b.f5783b = eVar.K();
        this.f5780b.f5784c = eVar.N();
        this.f5780b.f5785d = eVar.t();
        a aVar = this.f5780b;
        aVar.f5790i = false;
        aVar.f5791j = z2;
        p.e.b bVar = aVar.f5782a;
        p.e.b bVar2 = p.e.b.MATCH_CONSTRAINT;
        boolean z3 = bVar == bVar2;
        boolean z4 = aVar.f5783b == bVar2;
        boolean z5 = z3 && eVar.Q > 0.0f;
        boolean z6 = z4 && eVar.Q > 0.0f;
        if (z5 && eVar.f5553n[0] == 4) {
            aVar.f5782a = p.e.b.FIXED;
        }
        if (z6 && eVar.f5553n[1] == 4) {
            aVar.f5783b = p.e.b.FIXED;
        }
        interfaceC0082b.b(eVar, aVar);
        eVar.B0(this.f5780b.f5786e);
        eVar.e0(this.f5780b.f5787f);
        eVar.d0(this.f5780b.f5789h);
        eVar.Y(this.f5780b.f5788g);
        a aVar2 = this.f5780b;
        aVar2.f5791j = false;
        return aVar2.f5790i;
    }

    private void b(p.f fVar) {
        int size = fVar.f5594w0.size();
        InterfaceC0082b interfaceC0082bR0 = fVar.R0();
        for (int i3 = 0; i3 < size; i3++) {
            p.e eVar = fVar.f5594w0.get(i3);
            if (!(eVar instanceof p.g) && (!eVar.f5535e.f5842e.f5812j || !eVar.f5537f.f5842e.f5812j)) {
                p.e.b bVarQ = eVar.q(0);
                p.e.b bVarQ2 = eVar.q(1);
                p.e.b bVar = p.e.b.MATCH_CONSTRAINT;
                if (!(bVarQ == bVar && eVar.f5549l != 1 && bVarQ2 == bVar && eVar.f5551m != 1)) {
                    a(interfaceC0082bR0, eVar, false);
                }
            }
        }
        interfaceC0082bR0.a();
    }

    private void c(p.f fVar, String str, int i3, int i4) {
        int iC = fVar.C();
        int iB = fVar.B();
        fVar.r0(0);
        fVar.q0(0);
        fVar.B0(i3);
        fVar.e0(i4);
        fVar.r0(iC);
        fVar.q0(iB);
        this.f5781c.H0();
    }

    public long d(p.f fVar, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        boolean zO0;
        int i12;
        int i13;
        boolean z2;
        boolean z3;
        int i14;
        int i15;
        InterfaceC0082b interfaceC0082b;
        boolean z4;
        boolean zQ0;
        int i16;
        InterfaceC0082b interfaceC0082bR0 = fVar.R0();
        int size = fVar.f5594w0.size();
        int iN = fVar.N();
        int iT = fVar.t();
        boolean zB = p.j.b(i3, 128);
        boolean z5 = zB || p.j.b(i3, 64);
        if (z5) {
            for (int i17 = 0; i17 < size; i17++) {
                p.e eVar = fVar.f5594w0.get(i17);
                p.e.b bVarW = eVar.w();
                p.e.b bVar = p.e.b.MATCH_CONSTRAINT;
                boolean z6 = (bVarW == bVar) && (eVar.K() == bVar) && eVar.r() > 0.0f;
                if ((eVar.T() && z6) || ((eVar.V() && z6) || (eVar instanceof p.k) || eVar.T() || eVar.V())) {
                    z5 = false;
                    break;
                }
            }
        }
        if (z5) {
            o.e eVar2 = o.d.f5342r;
        }
        int i18 = 2;
        if (z5 && ((i6 == 1073741824 && i8 == 1073741824) || zB)) {
            int iMin = Math.min(fVar.A(), i7);
            int iMin2 = Math.min(fVar.z(), i9);
            if (i6 == 1073741824 && fVar.N() != iMin) {
                fVar.B0(iMin);
                fVar.T0();
            }
            if (i8 == 1073741824 && fVar.t() != iMin2) {
                fVar.e0(iMin2);
                fVar.T0();
            }
            if (i6 == 1073741824 && i8 == 1073741824) {
                zO0 = fVar.O0(zB);
                i12 = 2;
            } else {
                boolean zP0 = fVar.P0(zB);
                if (i6 == 1073741824) {
                    zQ0 = zP0 & fVar.Q0(zB, 0);
                    i16 = 1;
                } else {
                    zQ0 = zP0;
                    i16 = 0;
                }
                if (i8 == 1073741824) {
                    boolean zQ1 = fVar.Q0(zB, 1) & zQ0;
                    i12 = i16 + 1;
                    zO0 = zQ1;
                } else {
                    i12 = i16;
                    zO0 = zQ0;
                }
            }
            if (zO0) {
                fVar.F0(i6 == 1073741824, i8 == 1073741824);
            }
        } else {
            zO0 = false;
            i12 = 0;
        }
        if (zO0 && i12 == 2) {
            return 0L;
        }
        if (size > 0) {
            b(fVar);
        }
        int iS0 = fVar.S0();
        int size2 = this.f5779a.size();
        if (size > 0) {
            c(fVar, "First pass", iN, iT);
        }
        if (size2 > 0) {
            p.e.b bVarW2 = fVar.w();
            p.e.b bVar2 = p.e.b.WRAP_CONTENT;
            boolean z7 = bVarW2 == bVar2;
            boolean z8 = fVar.K() == bVar2;
            int iMax = Math.max(fVar.N(), this.f5781c.C());
            int iMax2 = Math.max(fVar.t(), this.f5781c.B());
            int i19 = 0;
            boolean zA = false;
            while (i19 < size2) {
                p.e eVar3 = this.f5779a.get(i19);
                if (eVar3 instanceof p.k) {
                    int iN2 = eVar3.N();
                    int iT2 = eVar3.t();
                    boolean zA2 = zA | a(interfaceC0082bR0, eVar3, true);
                    int iN3 = eVar3.N();
                    int iT3 = eVar3.t();
                    if (iN3 != iN2) {
                        eVar3.B0(iN3);
                        if (z7 && eVar3.G() > iMax) {
                            iMax = Math.max(iMax, eVar3.G() + eVar3.k(p.d.b.RIGHT).b());
                        }
                        z4 = true;
                    } else {
                        z4 = zA2;
                    }
                    if (iT3 != iT2) {
                        eVar3.e0(iT3);
                        if (z8 && eVar3.n() > iMax2) {
                            iMax2 = Math.max(iMax2, eVar3.n() + eVar3.k(p.d.b.BOTTOM).b());
                        }
                        z4 = true;
                    }
                    zA = z4 | ((p.k) eVar3).I0();
                }
                i19++;
                iS0 = iS0;
                i18 = 2;
            }
            int i20 = iS0;
            int i21 = 0;
            for (int i22 = i18; i21 < i22; i22 = 2) {
                int i23 = 0;
                while (i23 < size2) {
                    p.e eVar4 = this.f5779a.get(i23);
                    if (((eVar4 instanceof p.h) && !(eVar4 instanceof p.k)) || (eVar4 instanceof p.g) || eVar4.M() == 8 || ((eVar4.f5535e.f5842e.f5812j && eVar4.f5537f.f5842e.f5812j) || (eVar4 instanceof p.k))) {
                        i15 = i21;
                        i14 = size2;
                        interfaceC0082b = interfaceC0082bR0;
                    } else {
                        int iN4 = eVar4.N();
                        int iT4 = eVar4.t();
                        i14 = size2;
                        int iL = eVar4.l();
                        i15 = i21;
                        zA |= a(interfaceC0082bR0, eVar4, true);
                        int iN5 = eVar4.N();
                        interfaceC0082b = interfaceC0082bR0;
                        int iT5 = eVar4.t();
                        if (iN5 != iN4) {
                            eVar4.B0(iN5);
                            if (z7 && eVar4.G() > iMax) {
                                iMax = Math.max(iMax, eVar4.G() + eVar4.k(p.d.b.RIGHT).b());
                            }
                            zA = true;
                        }
                        if (iT5 != iT4) {
                            eVar4.e0(iT5);
                            if (z8 && eVar4.n() > iMax2) {
                                iMax2 = Math.max(iMax2, eVar4.n() + eVar4.k(p.d.b.BOTTOM).b());
                            }
                            zA = true;
                        }
                        if (eVar4.Q() && iL != eVar4.l()) {
                            zA = true;
                        }
                    }
                    i23++;
                    size2 = i14;
                    interfaceC0082bR0 = interfaceC0082b;
                    i21 = i15;
                }
                int i24 = i21;
                int i25 = size2;
                InterfaceC0082b interfaceC0082b2 = interfaceC0082bR0;
                if (zA) {
                    c(fVar, "intermediate pass", iN, iT);
                    zA = false;
                }
                i21 = i24 + 1;
                size2 = i25;
                interfaceC0082bR0 = interfaceC0082b2;
            }
            if (zA) {
                c(fVar, "2nd pass", iN, iT);
                if (fVar.N() < iMax) {
                    fVar.B0(iMax);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (fVar.t() < iMax2) {
                    fVar.e0(iMax2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    c(fVar, "3rd pass", iN, iT);
                }
            }
            i13 = i20;
        } else {
            i13 = iS0;
        }
        fVar.c1(i13);
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0032  */
    public void e(p.f fVar) {
        this.f5779a.clear();
        int size = fVar.f5594w0.size();
        for (int i3 = 0; i3 < size; i3++) {
            p.e eVar = fVar.f5594w0.get(i3);
            p.e.b bVarW = eVar.w();
            p.e.b bVar = p.e.b.MATCH_CONSTRAINT;
            if (bVarW != bVar) {
                p.e.b bVarW2 = eVar.w();
                p.e.b bVar2 = p.e.b.MATCH_PARENT;
                if (bVarW2 == bVar2 || eVar.K() == bVar || eVar.K() == bVar2) {
                    this.f5779a.add(eVar);
                }
            } else {
                this.f5779a.add(eVar);
            }
        }
        fVar.T0();
    }
}
