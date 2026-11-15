package q;

/* JADX INFO: compiled from: VerticalWidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f5835k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f5836l;

    /* JADX INFO: compiled from: VerticalWidgetRun.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5837a;

        static {
            int[] iArr = new int[m.b.values().length];
            f5837a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5837a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5837a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(p.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f5835k = fVar;
        this.f5836l = null;
        this.f5845h.f5807e = f.a.TOP;
        this.f5846i.f5807e = f.a.BOTTOM;
        fVar.f5807e = f.a.BASELINE;
        this.f5843f = 1;
    }

    @Override // q.m, q.d
    public void a(d dVar) {
        float f3;
        float fR;
        float fR2;
        int i3;
        int i4 = a.f5837a[this.f5847j.ordinal()];
        if (i4 == 1) {
            p(dVar);
        } else if (i4 == 2) {
            o(dVar);
        } else if (i4 == 3) {
            p.e eVar = this.f5839b;
            n(dVar, eVar.C, eVar.E, 1);
            return;
        }
        g gVar = this.f5842e;
        if (gVar.f5805c && !gVar.f5812j && this.f5841d == p.e.b.MATCH_CONSTRAINT) {
            p.e eVar2 = this.f5839b;
            int i5 = eVar2.f5551m;
            if (i5 == 2) {
                p.e eVarE = eVar2.E();
                if (eVarE != null) {
                    g gVar2 = eVarE.f5537f.f5842e;
                    if (gVar2.f5812j) {
                        this.f5842e.d((int) ((gVar2.f5809g * this.f5839b.f5565t) + 0.5f));
                    }
                }
            } else if (i5 == 3 && eVar2.f5535e.f5842e.f5812j) {
                int iS = eVar2.s();
                if (iS != -1) {
                    if (iS == 0) {
                        p.e eVar3 = this.f5839b;
                        fR2 = eVar3.f5535e.f5842e.f5809g * eVar3.r();
                        i3 = (int) (fR2 + 0.5f);
                    } else if (iS != 1) {
                        i3 = 0;
                    } else {
                        p.e eVar4 = this.f5839b;
                        f3 = eVar4.f5535e.f5842e.f5809g;
                        fR = eVar4.r();
                    }
                    this.f5842e.d(i3);
                } else {
                    p.e eVar5 = this.f5839b;
                    f3 = eVar5.f5535e.f5842e.f5809g;
                    fR = eVar5.r();
                }
                fR2 = f3 / fR;
                i3 = (int) (fR2 + 0.5f);
                this.f5842e.d(i3);
            }
        }
        f fVar = this.f5845h;
        if (fVar.f5805c) {
            f fVar2 = this.f5846i;
            if (fVar2.f5805c) {
                if (fVar.f5812j && fVar2.f5812j && this.f5842e.f5812j) {
                    return;
                }
                if (!this.f5842e.f5812j && this.f5841d == p.e.b.MATCH_CONSTRAINT) {
                    p.e eVar6 = this.f5839b;
                    if (eVar6.f5549l == 0 && !eVar6.V()) {
                        f fVar3 = this.f5845h.f5814l.get(0);
                        f fVar4 = this.f5846i.f5814l.get(0);
                        int i6 = fVar3.f5809g;
                        f fVar5 = this.f5845h;
                        int i7 = i6 + fVar5.f5808f;
                        int i8 = fVar4.f5809g + this.f5846i.f5808f;
                        fVar5.d(i7);
                        this.f5846i.d(i8);
                        this.f5842e.d(i8 - i7);
                        return;
                    }
                }
                if (!this.f5842e.f5812j && this.f5841d == p.e.b.MATCH_CONSTRAINT && this.f5838a == 1 && this.f5845h.f5814l.size() > 0 && this.f5846i.f5814l.size() > 0) {
                    f fVar6 = this.f5845h.f5814l.get(0);
                    int i9 = (this.f5846i.f5814l.get(0).f5809g + this.f5846i.f5808f) - (fVar6.f5809g + this.f5845h.f5808f);
                    g gVar3 = this.f5842e;
                    int i10 = gVar3.f5824m;
                    if (i9 < i10) {
                        gVar3.d(i9);
                    } else {
                        gVar3.d(i10);
                    }
                }
                if (this.f5842e.f5812j && this.f5845h.f5814l.size() > 0 && this.f5846i.f5814l.size() > 0) {
                    f fVar7 = this.f5845h.f5814l.get(0);
                    f fVar8 = this.f5846i.f5814l.get(0);
                    int i11 = fVar7.f5809g + this.f5845h.f5808f;
                    int i12 = fVar8.f5809g + this.f5846i.f5808f;
                    float fI = this.f5839b.I();
                    if (fVar7 == fVar8) {
                        i11 = fVar7.f5809g;
                        i12 = fVar8.f5809g;
                        fI = 0.5f;
                    }
                    this.f5845h.d((int) (i11 + 0.5f + (((i12 - i11) - this.f5842e.f5809g) * fI)));
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
            this.f5842e.d(eVar.t());
        }
        if (!this.f5842e.f5812j) {
            this.f5841d = this.f5839b.K();
            if (this.f5839b.Q()) {
                this.f5836l = new q.a(this);
            }
            p.e.b bVar = this.f5841d;
            if (bVar != p.e.b.MATCH_CONSTRAINT) {
                if (bVar == p.e.b.MATCH_PARENT && (eVarE2 = this.f5839b.E()) != null && eVarE2.K() == p.e.b.FIXED) {
                    int iT = (eVarE2.t() - this.f5839b.C.b()) - this.f5839b.E.b();
                    b(this.f5845h, eVarE2.f5537f.f5845h, this.f5839b.C.b());
                    b(this.f5846i, eVarE2.f5537f.f5846i, -this.f5839b.E.b());
                    this.f5842e.d(iT);
                    return;
                }
                if (this.f5841d == p.e.b.FIXED) {
                    this.f5842e.d(this.f5839b.t());
                }
            }
        } else if (this.f5841d == p.e.b.MATCH_PARENT && (eVarE = this.f5839b.E()) != null && eVarE.K() == p.e.b.FIXED) {
            b(this.f5845h, eVarE.f5537f.f5845h, this.f5839b.C.b());
            b(this.f5846i, eVarE.f5537f.f5846i, -this.f5839b.E.b());
            return;
        }
        g gVar = this.f5842e;
        boolean z2 = gVar.f5812j;
        if (z2) {
            p.e eVar2 = this.f5839b;
            if (eVar2.f5527a) {
                p.d[] dVarArr = eVar2.J;
                if (dVarArr[2].f5511d != null && dVarArr[3].f5511d != null) {
                    if (eVar2.V()) {
                        this.f5845h.f5808f = this.f5839b.J[2].b();
                        this.f5846i.f5808f = -this.f5839b.J[3].b();
                    } else {
                        f fVarH = h(this.f5839b.J[2]);
                        if (fVarH != null) {
                            b(this.f5845h, fVarH, this.f5839b.J[2].b());
                        }
                        f fVarH2 = h(this.f5839b.J[3]);
                        if (fVarH2 != null) {
                            b(this.f5846i, fVarH2, -this.f5839b.J[3].b());
                        }
                        this.f5845h.f5804b = true;
                        this.f5846i.f5804b = true;
                    }
                    if (this.f5839b.Q()) {
                        b(this.f5835k, this.f5845h, this.f5839b.l());
                        return;
                    }
                    return;
                }
                if (dVarArr[2].f5511d != null) {
                    f fVarH3 = h(dVarArr[2]);
                    if (fVarH3 != null) {
                        b(this.f5845h, fVarH3, this.f5839b.J[2].b());
                        b(this.f5846i, this.f5845h, this.f5842e.f5809g);
                        if (this.f5839b.Q()) {
                            b(this.f5835k, this.f5845h, this.f5839b.l());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (dVarArr[3].f5511d != null) {
                    f fVarH4 = h(dVarArr[3]);
                    if (fVarH4 != null) {
                        b(this.f5846i, fVarH4, -this.f5839b.J[3].b());
                        b(this.f5845h, this.f5846i, -this.f5842e.f5809g);
                    }
                    if (this.f5839b.Q()) {
                        b(this.f5835k, this.f5845h, this.f5839b.l());
                        return;
                    }
                    return;
                }
                if (dVarArr[4].f5511d != null) {
                    f fVarH5 = h(dVarArr[4]);
                    if (fVarH5 != null) {
                        b(this.f5835k, fVarH5, 0);
                        b(this.f5845h, this.f5835k, -this.f5839b.l());
                        b(this.f5846i, this.f5845h, this.f5842e.f5809g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof p.h) || eVar2.E() == null || this.f5839b.k(p.d.b.CENTER).f5511d != null) {
                    return;
                }
                b(this.f5845h, this.f5839b.E().f5537f.f5845h, this.f5839b.P());
                b(this.f5846i, this.f5845h, this.f5842e.f5809g);
                if (this.f5839b.Q()) {
                    b(this.f5835k, this.f5845h, this.f5839b.l());
                    return;
                }
                return;
            }
        }
        if (z2 || this.f5841d != p.e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            p.e eVar3 = this.f5839b;
            int i3 = eVar3.f5551m;
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
            } else if (i3 == 3 && !eVar3.V()) {
                p.e eVar4 = this.f5839b;
                if (eVar4.f5549l != 3) {
                    g gVar4 = eVar4.f5535e.f5842e;
                    this.f5842e.f5814l.add(gVar4);
                    gVar4.f5813k.add(this.f5842e);
                    g gVar5 = this.f5842e;
                    gVar5.f5804b = true;
                    gVar5.f5813k.add(this.f5845h);
                    this.f5842e.f5813k.add(this.f5846i);
                }
            }
        }
        p.e eVar5 = this.f5839b;
        p.d[] dVarArr2 = eVar5.J;
        if (dVarArr2[2].f5511d != null && dVarArr2[3].f5511d != null) {
            if (eVar5.V()) {
                this.f5845h.f5808f = this.f5839b.J[2].b();
                this.f5846i.f5808f = -this.f5839b.J[3].b();
            } else {
                f fVarH6 = h(this.f5839b.J[2]);
                f fVarH7 = h(this.f5839b.J[3]);
                fVarH6.b(this);
                fVarH7.b(this);
                this.f5847j = m.b.CENTER;
            }
            if (this.f5839b.Q()) {
                c(this.f5835k, this.f5845h, 1, this.f5836l);
            }
        } else if (dVarArr2[2].f5511d != null) {
            f fVarH8 = h(dVarArr2[2]);
            if (fVarH8 != null) {
                b(this.f5845h, fVarH8, this.f5839b.J[2].b());
                c(this.f5846i, this.f5845h, 1, this.f5842e);
                if (this.f5839b.Q()) {
                    c(this.f5835k, this.f5845h, 1, this.f5836l);
                }
                p.e.b bVar2 = this.f5841d;
                p.e.b bVar3 = p.e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f5839b.r() > 0.0f) {
                    j jVar = this.f5839b.f5535e;
                    if (jVar.f5841d == bVar3) {
                        jVar.f5842e.f5813k.add(this.f5842e);
                        this.f5842e.f5814l.add(this.f5839b.f5535e.f5842e);
                        this.f5842e.f5803a = this;
                    }
                }
            }
        } else if (dVarArr2[3].f5511d != null) {
            f fVarH9 = h(dVarArr2[3]);
            if (fVarH9 != null) {
                b(this.f5846i, fVarH9, -this.f5839b.J[3].b());
                c(this.f5845h, this.f5846i, -1, this.f5842e);
                if (this.f5839b.Q()) {
                    c(this.f5835k, this.f5845h, 1, this.f5836l);
                }
            }
        } else if (dVarArr2[4].f5511d != null) {
            f fVarH10 = h(dVarArr2[4]);
            if (fVarH10 != null) {
                b(this.f5835k, fVarH10, 0);
                c(this.f5845h, this.f5835k, -1, this.f5836l);
                c(this.f5846i, this.f5845h, 1, this.f5842e);
            }
        } else if (!(eVar5 instanceof p.h) && eVar5.E() != null) {
            b(this.f5845h, this.f5839b.E().f5537f.f5845h, this.f5839b.P());
            c(this.f5846i, this.f5845h, 1, this.f5842e);
            if (this.f5839b.Q()) {
                c(this.f5835k, this.f5845h, 1, this.f5836l);
            }
            p.e.b bVar4 = this.f5841d;
            p.e.b bVar5 = p.e.b.MATCH_CONSTRAINT;
            if (bVar4 == bVar5 && this.f5839b.r() > 0.0f) {
                j jVar2 = this.f5839b.f5535e;
                if (jVar2.f5841d == bVar5) {
                    jVar2.f5842e.f5813k.add(this.f5842e);
                    this.f5842e.f5814l.add(this.f5839b.f5535e.f5842e);
                    this.f5842e.f5803a = this;
                }
            }
        }
        if (this.f5842e.f5814l.size() == 0) {
            this.f5842e.f5805c = true;
        }
    }

    @Override // q.m
    public void e() {
        f fVar = this.f5845h;
        if (fVar.f5812j) {
            this.f5839b.D0(fVar.f5809g);
        }
    }

    @Override // q.m
    void f() {
        this.f5840c = null;
        this.f5845h.c();
        this.f5846i.c();
        this.f5835k.c();
        this.f5842e.c();
        this.f5844g = false;
    }

    @Override // q.m
    boolean m() {
        return this.f5841d != p.e.b.MATCH_CONSTRAINT || this.f5839b.f5551m == 0;
    }

    void q() {
        this.f5844g = false;
        this.f5845h.c();
        this.f5845h.f5812j = false;
        this.f5846i.c();
        this.f5846i.f5812j = false;
        this.f5835k.c();
        this.f5835k.f5812j = false;
        this.f5842e.f5812j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f5839b.p();
    }
}
