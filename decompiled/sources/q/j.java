package q;

/* JADX INFO: compiled from: HorizontalWidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int[] f5825k = new int[2];

    /* JADX INFO: compiled from: HorizontalWidgetRun.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5826a;

        static {
            int[] iArr = new int[m.b.values().length];
            f5826a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5826a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5826a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(p.e eVar) {
        super(eVar);
        this.f5845h.f5807e = f.a.LEFT;
        this.f5846i.f5807e = f.a.RIGHT;
        this.f5843f = 0;
    }

    private void q(int[] iArr, int i3, int i4, int i5, int i6, float f3, int i7) {
        int i8 = i4 - i3;
        int i9 = i6 - i5;
        if (i7 != -1) {
            if (i7 == 0) {
                iArr[0] = (int) ((i9 * f3) + 0.5f);
                iArr[1] = i9;
                return;
            } else {
                if (i7 != 1) {
                    return;
                }
                iArr[0] = i8;
                iArr[1] = (int) ((i8 * f3) + 0.5f);
                return;
            }
        }
        int i10 = (int) ((i9 * f3) + 0.5f);
        int i11 = (int) ((i8 / f3) + 0.5f);
        if (i10 <= i8) {
            iArr[0] = i10;
            iArr[1] = i9;
        } else if (i11 <= i9) {
            iArr[0] = i8;
            iArr[1] = i11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02de  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ed  */
    @Override // q.m, q.d
    public void a(d dVar) {
        int iG;
        int i3;
        int iG2;
        float f3;
        float fR;
        float fR2;
        int i4;
        int i5 = a.f5826a[this.f5847j.ordinal()];
        if (i5 == 1) {
            p(dVar);
        } else if (i5 == 2) {
            o(dVar);
        } else if (i5 == 3) {
            p.e eVar = this.f5839b;
            n(dVar, eVar.B, eVar.D, 0);
            return;
        }
        if (!this.f5842e.f5812j && this.f5841d == p.e.b.MATCH_CONSTRAINT) {
            p.e eVar2 = this.f5839b;
            int i6 = eVar2.f5549l;
            if (i6 == 2) {
                p.e eVarE = eVar2.E();
                if (eVarE != null) {
                    g gVar = eVarE.f5535e.f5842e;
                    if (gVar.f5812j) {
                        this.f5842e.d((int) ((gVar.f5809g * this.f5839b.f5559q) + 0.5f));
                    }
                }
            } else if (i6 == 3) {
                int i7 = eVar2.f5551m;
                if (i7 == 0 || i7 == 3) {
                    l lVar = eVar2.f5537f;
                    f fVar = lVar.f5845h;
                    f fVar2 = lVar.f5846i;
                    boolean z2 = eVar2.B.f5511d != null;
                    boolean z3 = eVar2.C.f5511d != null;
                    boolean z4 = eVar2.D.f5511d != null;
                    boolean z5 = eVar2.E.f5511d != null;
                    int iS = eVar2.s();
                    if (z2 && z3 && z4 && z5) {
                        float fR3 = this.f5839b.r();
                        if (fVar.f5812j && fVar2.f5812j) {
                            f fVar3 = this.f5845h;
                            if (fVar3.f5805c && this.f5846i.f5805c) {
                                q(f5825k, fVar3.f5814l.get(0).f5809g + this.f5845h.f5808f, this.f5846i.f5814l.get(0).f5809g - this.f5846i.f5808f, fVar.f5809g + fVar.f5808f, fVar2.f5809g - fVar2.f5808f, fR3, iS);
                                this.f5842e.d(f5825k[0]);
                                this.f5839b.f5537f.f5842e.d(f5825k[1]);
                                return;
                            }
                            return;
                        }
                        f fVar4 = this.f5845h;
                        if (fVar4.f5812j) {
                            f fVar5 = this.f5846i;
                            if (fVar5.f5812j) {
                                if (!fVar.f5805c || !fVar2.f5805c) {
                                    return;
                                }
                                q(f5825k, fVar4.f5809g + fVar4.f5808f, fVar5.f5809g - fVar5.f5808f, fVar.f5814l.get(0).f5809g + fVar.f5808f, fVar2.f5814l.get(0).f5809g - fVar2.f5808f, fR3, iS);
                                this.f5842e.d(f5825k[0]);
                                this.f5839b.f5537f.f5842e.d(f5825k[1]);
                            }
                        }
                        f fVar6 = this.f5845h;
                        if (!fVar6.f5805c || !this.f5846i.f5805c || !fVar.f5805c || !fVar2.f5805c) {
                            return;
                        }
                        q(f5825k, fVar6.f5814l.get(0).f5809g + this.f5845h.f5808f, this.f5846i.f5814l.get(0).f5809g - this.f5846i.f5808f, fVar.f5814l.get(0).f5809g + fVar.f5808f, fVar2.f5814l.get(0).f5809g - fVar2.f5808f, fR3, iS);
                        this.f5842e.d(f5825k[0]);
                        this.f5839b.f5537f.f5842e.d(f5825k[1]);
                    } else if (z2 && z4) {
                        if (!this.f5845h.f5805c || !this.f5846i.f5805c) {
                            return;
                        }
                        float fR4 = this.f5839b.r();
                        int i8 = this.f5845h.f5814l.get(0).f5809g + this.f5845h.f5808f;
                        int i9 = this.f5846i.f5814l.get(0).f5809g - this.f5846i.f5808f;
                        if (iS == -1 || iS == 0) {
                            int iG3 = g(i9 - i8, 0);
                            int i10 = (int) ((iG3 * fR4) + 0.5f);
                            int iG4 = g(i10, 1);
                            if (i10 != iG4) {
                                iG3 = (int) ((iG4 / fR4) + 0.5f);
                            }
                            this.f5842e.d(iG3);
                            this.f5839b.f5537f.f5842e.d(iG4);
                        } else if (iS == 1) {
                            int iG5 = g(i9 - i8, 0);
                            int i11 = (int) ((iG5 / fR4) + 0.5f);
                            int iG6 = g(i11, 1);
                            if (i11 != iG6) {
                                iG5 = (int) ((iG6 * fR4) + 0.5f);
                            }
                            this.f5842e.d(iG5);
                            this.f5839b.f5537f.f5842e.d(iG6);
                        }
                    } else if (z3 && z5) {
                        if (!fVar.f5805c || !fVar2.f5805c) {
                            return;
                        }
                        float fR5 = this.f5839b.r();
                        int i12 = fVar.f5814l.get(0).f5809g + fVar.f5808f;
                        int i13 = fVar2.f5814l.get(0).f5809g - fVar2.f5808f;
                        if (iS == -1) {
                            iG = g(i13 - i12, 1);
                            i3 = (int) ((iG / fR5) + 0.5f);
                            iG2 = g(i3, 0);
                            if (i3 != iG2) {
                                iG = (int) ((iG2 * fR5) + 0.5f);
                            }
                            this.f5842e.d(iG2);
                            this.f5839b.f5537f.f5842e.d(iG);
                        } else if (iS == 0) {
                            int iG7 = g(i13 - i12, 1);
                            int i14 = (int) ((iG7 * fR5) + 0.5f);
                            int iG8 = g(i14, 0);
                            if (i14 != iG8) {
                                iG7 = (int) ((iG8 / fR5) + 0.5f);
                            }
                            this.f5842e.d(iG8);
                            this.f5839b.f5537f.f5842e.d(iG7);
                        } else if (iS == 1) {
                            iG = g(i13 - i12, 1);
                            i3 = (int) ((iG / fR5) + 0.5f);
                            iG2 = g(i3, 0);
                            if (i3 != iG2) {
                                iG = (int) ((iG2 * fR5) + 0.5f);
                            }
                            this.f5842e.d(iG2);
                            this.f5839b.f5537f.f5842e.d(iG);
                        }
                    }
                } else {
                    int iS2 = eVar2.s();
                    if (iS2 != -1) {
                        if (iS2 == 0) {
                            p.e eVar3 = this.f5839b;
                            fR2 = eVar3.f5537f.f5842e.f5809g / eVar3.r();
                            i4 = (int) (fR2 + 0.5f);
                        } else if (iS2 != 1) {
                            i4 = 0;
                        } else {
                            p.e eVar4 = this.f5839b;
                            f3 = eVar4.f5537f.f5842e.f5809g;
                            fR = eVar4.r();
                        }
                        this.f5842e.d(i4);
                    } else {
                        p.e eVar5 = this.f5839b;
                        f3 = eVar5.f5537f.f5842e.f5809g;
                        fR = eVar5.r();
                    }
                    fR2 = f3 * fR;
                    i4 = (int) (fR2 + 0.5f);
                    this.f5842e.d(i4);
                }
            }
        }
        f fVar7 = this.f5845h;
        if (fVar7.f5805c) {
            f fVar8 = this.f5846i;
            if (fVar8.f5805c) {
                if (fVar7.f5812j && fVar8.f5812j && this.f5842e.f5812j) {
                    return;
                }
                if (!this.f5842e.f5812j && this.f5841d == p.e.b.MATCH_CONSTRAINT) {
                    p.e eVar6 = this.f5839b;
                    if (eVar6.f5549l == 0 && !eVar6.T()) {
                        f fVar9 = this.f5845h.f5814l.get(0);
                        f fVar10 = this.f5846i.f5814l.get(0);
                        int i15 = fVar9.f5809g;
                        f fVar11 = this.f5845h;
                        int i16 = i15 + fVar11.f5808f;
                        int i17 = fVar10.f5809g + this.f5846i.f5808f;
                        fVar11.d(i16);
                        this.f5846i.d(i17);
                        this.f5842e.d(i17 - i16);
                        return;
                    }
                }
                if (!this.f5842e.f5812j && this.f5841d == p.e.b.MATCH_CONSTRAINT && this.f5838a == 1 && this.f5845h.f5814l.size() > 0 && this.f5846i.f5814l.size() > 0) {
                    int iMin = Math.min((this.f5846i.f5814l.get(0).f5809g + this.f5846i.f5808f) - (this.f5845h.f5814l.get(0).f5809g + this.f5845h.f5808f), this.f5842e.f5824m);
                    p.e eVar7 = this.f5839b;
                    int i18 = eVar7.f5557p;
                    int iMax = Math.max(eVar7.f5555o, iMin);
                    if (i18 > 0) {
                        iMax = Math.min(i18, iMax);
                    }
                    this.f5842e.d(iMax);
                }
                if (this.f5842e.f5812j) {
                    f fVar12 = this.f5845h.f5814l.get(0);
                    f fVar13 = this.f5846i.f5814l.get(0);
                    int i19 = fVar12.f5809g + this.f5845h.f5808f;
                    int i20 = fVar13.f5809g + this.f5846i.f5808f;
                    float fU = this.f5839b.u();
                    if (fVar12 == fVar13) {
                        i19 = fVar12.f5809g;
                        i20 = fVar13.f5809g;
                        fU = 0.5f;
                    }
                    this.f5845h.d((int) (i19 + 0.5f + (((i20 - i19) - this.f5842e.f5809g) * fU)));
                    this.f5846i.d(this.f5845h.f5809g + this.f5842e.f5809g);
                }
            }
        }
    }

    @Override // q.m
    void d() {
        p.e eVarE;
        p.e eVarE2;
        p.e eVar = this.f5839b;
        if (eVar.f5527a) {
            this.f5842e.d(eVar.N());
        }
        if (this.f5842e.f5812j) {
            p.e.b bVar = this.f5841d;
            p.e.b bVar2 = p.e.b.MATCH_PARENT;
            if (bVar == bVar2 && (((eVarE = this.f5839b.E()) != null && eVarE.w() == p.e.b.FIXED) || eVarE.w() == bVar2)) {
                b(this.f5845h, eVarE.f5535e.f5845h, this.f5839b.B.b());
                b(this.f5846i, eVarE.f5535e.f5846i, -this.f5839b.D.b());
                return;
            }
        } else {
            p.e.b bVarW = this.f5839b.w();
            this.f5841d = bVarW;
            if (bVarW != p.e.b.MATCH_CONSTRAINT) {
                p.e.b bVar3 = p.e.b.MATCH_PARENT;
                if (bVarW == bVar3 && (((eVarE2 = this.f5839b.E()) != null && eVarE2.w() == p.e.b.FIXED) || eVarE2.w() == bVar3)) {
                    int iN = (eVarE2.N() - this.f5839b.B.b()) - this.f5839b.D.b();
                    b(this.f5845h, eVarE2.f5535e.f5845h, this.f5839b.B.b());
                    b(this.f5846i, eVarE2.f5535e.f5846i, -this.f5839b.D.b());
                    this.f5842e.d(iN);
                    return;
                }
                if (this.f5841d == p.e.b.FIXED) {
                    this.f5842e.d(this.f5839b.N());
                }
            }
        }
        g gVar = this.f5842e;
        if (gVar.f5812j) {
            p.e eVar2 = this.f5839b;
            if (eVar2.f5527a) {
                p.d[] dVarArr = eVar2.J;
                if (dVarArr[0].f5511d != null && dVarArr[1].f5511d != null) {
                    if (eVar2.T()) {
                        this.f5845h.f5808f = this.f5839b.J[0].b();
                        this.f5846i.f5808f = -this.f5839b.J[1].b();
                        return;
                    }
                    f fVarH = h(this.f5839b.J[0]);
                    if (fVarH != null) {
                        b(this.f5845h, fVarH, this.f5839b.J[0].b());
                    }
                    f fVarH2 = h(this.f5839b.J[1]);
                    if (fVarH2 != null) {
                        b(this.f5846i, fVarH2, -this.f5839b.J[1].b());
                    }
                    this.f5845h.f5804b = true;
                    this.f5846i.f5804b = true;
                    return;
                }
                if (dVarArr[0].f5511d != null) {
                    f fVarH3 = h(dVarArr[0]);
                    if (fVarH3 != null) {
                        b(this.f5845h, fVarH3, this.f5839b.J[0].b());
                        b(this.f5846i, this.f5845h, this.f5842e.f5809g);
                        return;
                    }
                    return;
                }
                if (dVarArr[1].f5511d != null) {
                    f fVarH4 = h(dVarArr[1]);
                    if (fVarH4 != null) {
                        b(this.f5846i, fVarH4, -this.f5839b.J[1].b());
                        b(this.f5845h, this.f5846i, -this.f5842e.f5809g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof p.h) || eVar2.E() == null || this.f5839b.k(p.d.b.CENTER).f5511d != null) {
                    return;
                }
                b(this.f5845h, this.f5839b.E().f5535e.f5845h, this.f5839b.O());
                b(this.f5846i, this.f5845h, this.f5842e.f5809g);
                return;
            }
        }
        if (this.f5841d == p.e.b.MATCH_CONSTRAINT) {
            p.e eVar3 = this.f5839b;
            int i3 = eVar3.f5549l;
            if (i3 == 2) {
                p.e eVarE3 = eVar3.E();
                if (eVarE3 != null) {
                    g gVar2 = eVarE3.f5537f.f5842e;
                    this.f5842e.f5814l.add(gVar2);
                    gVar2.f5813k.add(this.f5842e);
                    g gVar3 = this.f5842e;
                    gVar3.f5804b = true;
                    gVar3.f5813k.add(this.f5845h);
                    this.f5842e.f5813k.add(this.f5846i);
                }
            } else if (i3 == 3) {
                if (eVar3.f5551m == 3) {
                    this.f5845h.f5803a = this;
                    this.f5846i.f5803a = this;
                    l lVar = eVar3.f5537f;
                    lVar.f5845h.f5803a = this;
                    lVar.f5846i.f5803a = this;
                    gVar.f5803a = this;
                    if (eVar3.V()) {
                        this.f5842e.f5814l.add(this.f5839b.f5537f.f5842e);
                        this.f5839b.f5537f.f5842e.f5813k.add(this.f5842e);
                        l lVar2 = this.f5839b.f5537f;
                        lVar2.f5842e.f5803a = this;
                        this.f5842e.f5814l.add(lVar2.f5845h);
                        this.f5842e.f5814l.add(this.f5839b.f5537f.f5846i);
                        this.f5839b.f5537f.f5845h.f5813k.add(this.f5842e);
                        this.f5839b.f5537f.f5846i.f5813k.add(this.f5842e);
                    } else if (this.f5839b.T()) {
                        this.f5839b.f5537f.f5842e.f5814l.add(this.f5842e);
                        this.f5842e.f5813k.add(this.f5839b.f5537f.f5842e);
                    } else {
                        this.f5839b.f5537f.f5842e.f5814l.add(this.f5842e);
                    }
                } else {
                    g gVar4 = eVar3.f5537f.f5842e;
                    gVar.f5814l.add(gVar4);
                    gVar4.f5813k.add(this.f5842e);
                    this.f5839b.f5537f.f5845h.f5813k.add(this.f5842e);
                    this.f5839b.f5537f.f5846i.f5813k.add(this.f5842e);
                    g gVar5 = this.f5842e;
                    gVar5.f5804b = true;
                    gVar5.f5813k.add(this.f5845h);
                    this.f5842e.f5813k.add(this.f5846i);
                    this.f5845h.f5814l.add(this.f5842e);
                    this.f5846i.f5814l.add(this.f5842e);
                }
            }
        }
        p.e eVar4 = this.f5839b;
        p.d[] dVarArr2 = eVar4.J;
        if (dVarArr2[0].f5511d != null && dVarArr2[1].f5511d != null) {
            if (eVar4.T()) {
                this.f5845h.f5808f = this.f5839b.J[0].b();
                this.f5846i.f5808f = -this.f5839b.J[1].b();
                return;
            }
            f fVarH5 = h(this.f5839b.J[0]);
            f fVarH6 = h(this.f5839b.J[1]);
            fVarH5.b(this);
            fVarH6.b(this);
            this.f5847j = m.b.CENTER;
            return;
        }
        if (dVarArr2[0].f5511d != null) {
            f fVarH7 = h(dVarArr2[0]);
            if (fVarH7 != null) {
                b(this.f5845h, fVarH7, this.f5839b.J[0].b());
                c(this.f5846i, this.f5845h, 1, this.f5842e);
                return;
            }
            return;
        }
        if (dVarArr2[1].f5511d != null) {
            f fVarH8 = h(dVarArr2[1]);
            if (fVarH8 != null) {
                b(this.f5846i, fVarH8, -this.f5839b.J[1].b());
                c(this.f5845h, this.f5846i, -1, this.f5842e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof p.h) || eVar4.E() == null) {
            return;
        }
        b(this.f5845h, this.f5839b.E().f5535e.f5845h, this.f5839b.O());
        c(this.f5846i, this.f5845h, 1, this.f5842e);
    }

    @Override // q.m
    public void e() {
        f fVar = this.f5845h;
        if (fVar.f5812j) {
            this.f5839b.C0(fVar.f5809g);
        }
    }

    @Override // q.m
    void f() {
        this.f5840c = null;
        this.f5845h.c();
        this.f5846i.c();
        this.f5842e.c();
        this.f5844g = false;
    }

    @Override // q.m
    boolean m() {
        return this.f5841d != p.e.b.MATCH_CONSTRAINT || this.f5839b.f5549l == 0;
    }

    void r() {
        this.f5844g = false;
        this.f5845h.c();
        this.f5845h.f5812j = false;
        this.f5846i.c();
        this.f5846i.f5812j = false;
        this.f5842e.f5812j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f5839b.p();
    }
}
