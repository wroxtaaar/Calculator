package q;

/* JADX INFO: compiled from: WidgetRun.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    p.e f5839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    k f5840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected p.e.b f5841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    g f5842e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5843f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f5844g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f5845h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f5846i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected b f5847j = b.NONE;

    /* JADX INFO: compiled from: WidgetRun.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5848a;

        static {
            int[] iArr = new int[p.d.b.values().length];
            f5848a = iArr;
            try {
                iArr[p.d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5848a[p.d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5848a[p.d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5848a[p.d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5848a[p.d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: WidgetRun.java */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public m(p.e eVar) {
        this.f5839b = eVar;
    }

    private void l(int i3, int i4) {
        int i5 = this.f5838a;
        if (i5 == 0) {
            this.f5842e.d(g(i4, i3));
            return;
        }
        if (i5 == 1) {
            this.f5842e.d(Math.min(g(this.f5842e.f5824m, i3), i4));
            return;
        }
        if (i5 == 2) {
            p.e eVarE = this.f5839b.E();
            if (eVarE != null) {
                g gVar = (i3 == 0 ? eVarE.f5535e : eVarE.f5537f).f5842e;
                if (gVar.f5812j) {
                    p.e eVar = this.f5839b;
                    this.f5842e.d(g((int) ((gVar.f5809g * (i3 == 0 ? eVar.f5559q : eVar.f5565t)) + 0.5f), i3));
                    return;
                }
                return;
            }
            return;
        }
        if (i5 != 3) {
            return;
        }
        p.e eVar2 = this.f5839b;
        m mVar = eVar2.f5535e;
        p.e.b bVar = mVar.f5841d;
        p.e.b bVar2 = p.e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && mVar.f5838a == 3) {
            l lVar = eVar2.f5537f;
            if (lVar.f5841d == bVar2 && lVar.f5838a == 3) {
                return;
            }
        }
        if (i3 == 0) {
            mVar = eVar2.f5537f;
        }
        if (mVar.f5842e.f5812j) {
            float fR = eVar2.r();
            this.f5842e.d(i3 == 1 ? (int) ((mVar.f5842e.f5809g / fR) + 0.5f) : (int) ((fR * mVar.f5842e.f5809g) + 0.5f));
        }
    }

    @Override // q.d
    public void a(d dVar) {
    }

    protected final void b(f fVar, f fVar2, int i3) {
        fVar.f5814l.add(fVar2);
        fVar.f5808f = i3;
        fVar2.f5813k.add(fVar);
    }

    protected final void c(f fVar, f fVar2, int i3, g gVar) {
        fVar.f5814l.add(fVar2);
        fVar.f5814l.add(this.f5842e);
        fVar.f5810h = i3;
        fVar.f5811i = gVar;
        fVar2.f5813k.add(fVar);
        gVar.f5813k.add(fVar);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i3, int i4) {
        int iMax;
        if (i4 == 0) {
            p.e eVar = this.f5839b;
            int i5 = eVar.f5557p;
            iMax = Math.max(eVar.f5555o, i3);
            if (i5 > 0) {
                iMax = Math.min(i5, i3);
            }
            if (iMax == i3) {
                return i3;
            }
        } else {
            p.e eVar2 = this.f5839b;
            int i6 = eVar2.f5563s;
            iMax = Math.max(eVar2.f5561r, i3);
            if (i6 > 0) {
                iMax = Math.min(i6, i3);
            }
            if (iMax == i3) {
                return i3;
            }
        }
        return iMax;
    }

    protected final f h(p.d dVar) {
        p.d dVar2 = dVar.f5511d;
        if (dVar2 == null) {
            return null;
        }
        p.e eVar = dVar2.f5509b;
        int i3 = a.f5848a[dVar2.f5510c.ordinal()];
        if (i3 == 1) {
            return eVar.f5535e.f5845h;
        }
        if (i3 == 2) {
            return eVar.f5535e.f5846i;
        }
        if (i3 == 3) {
            return eVar.f5537f.f5845h;
        }
        if (i3 == 4) {
            return eVar.f5537f.f5835k;
        }
        if (i3 != 5) {
            return null;
        }
        return eVar.f5537f.f5846i;
    }

    protected final f i(p.d dVar, int i3) {
        p.d dVar2 = dVar.f5511d;
        if (dVar2 == null) {
            return null;
        }
        p.e eVar = dVar2.f5509b;
        m mVar = i3 == 0 ? eVar.f5535e : eVar.f5537f;
        int i4 = a.f5848a[dVar2.f5510c.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 5) {
                        return null;
                    }
                }
            }
            return mVar.f5846i;
        }
        return mVar.f5845h;
    }

    public long j() {
        g gVar = this.f5842e;
        if (gVar.f5812j) {
            return gVar.f5809g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f5844g;
    }

    abstract boolean m();

    protected void n(d dVar, p.d dVar2, p.d dVar3, int i3) {
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f5812j && fVarH2.f5812j) {
            int iB = fVarH.f5809g + dVar2.b();
            int iB2 = fVarH2.f5809g - dVar3.b();
            int i4 = iB2 - iB;
            if (!this.f5842e.f5812j && this.f5841d == p.e.b.MATCH_CONSTRAINT) {
                l(i3, i4);
            }
            g gVar = this.f5842e;
            if (gVar.f5812j) {
                if (gVar.f5809g == i4) {
                    this.f5845h.d(iB);
                    this.f5846i.d(iB2);
                    return;
                }
                p.e eVar = this.f5839b;
                float fU = i3 == 0 ? eVar.u() : eVar.I();
                if (fVarH == fVarH2) {
                    iB = fVarH.f5809g;
                    iB2 = fVarH2.f5809g;
                    fU = 0.5f;
                }
                this.f5845h.d((int) (iB + 0.5f + (((iB2 - iB) - this.f5842e.f5809g) * fU)));
                this.f5846i.d(this.f5845h.f5809g + this.f5842e.f5809g);
            }
        }
    }

    protected void o(d dVar) {
    }

    protected void p(d dVar) {
    }
}
