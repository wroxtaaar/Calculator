package p;

/* JADX INFO: compiled from: Guideline.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected float f5584w0 = -1.0f;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    protected int f5585x0 = -1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    protected int f5586y0 = -1;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private d f5587z0 = this.C;
    private int A0 = 0;
    private int B0 = 0;

    /* JADX INFO: compiled from: Guideline.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5588a;

        static {
            int[] iArr = new int[d.b.values().length];
            f5588a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5588a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5588a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5588a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5588a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5588a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5588a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5588a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5588a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.K.clear();
        this.K.add(this.f5587z0);
        int length = this.J.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.J[i3] = this.f5587z0;
        }
    }

    @Override // p.e
    public void G0(o.d dVar) {
        if (E() == null) {
            return;
        }
        int iX = dVar.x(this.f5587z0);
        if (this.A0 == 1) {
            C0(iX);
            D0(0);
            e0(E().t());
            B0(0);
            return;
        }
        C0(0);
        D0(iX);
        B0(E().N());
        e0(0);
    }

    public int H0() {
        return this.A0;
    }

    public int I0() {
        return this.f5585x0;
    }

    public int J0() {
        return this.f5586y0;
    }

    public float K0() {
        return this.f5584w0;
    }

    public void L0(int i3) {
        if (i3 > -1) {
            this.f5584w0 = -1.0f;
            this.f5585x0 = i3;
            this.f5586y0 = -1;
        }
    }

    public void M0(int i3) {
        if (i3 > -1) {
            this.f5584w0 = -1.0f;
            this.f5585x0 = -1;
            this.f5586y0 = i3;
        }
    }

    public void N0(float f3) {
        if (f3 > -1.0f) {
            this.f5584w0 = f3;
            this.f5585x0 = -1;
            this.f5586y0 = -1;
        }
    }

    public void O0(int i3) {
        if (this.A0 == i3) {
            return;
        }
        this.A0 = i3;
        this.K.clear();
        if (this.A0 == 1) {
            this.f5587z0 = this.B;
        } else {
            this.f5587z0 = this.C;
        }
        this.K.add(this.f5587z0);
        int length = this.J.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.J[i4] = this.f5587z0;
        }
    }

    @Override // p.e
    public void f(o.d dVar) {
        f fVar = (f) E();
        if (fVar == null) {
            return;
        }
        d dVarK = fVar.k(d.b.LEFT);
        d dVarK2 = fVar.k(d.b.RIGHT);
        e eVar = this.N;
        boolean z2 = eVar != null && eVar.M[0] == e.b.WRAP_CONTENT;
        if (this.A0 == 0) {
            dVarK = fVar.k(d.b.TOP);
            dVarK2 = fVar.k(d.b.BOTTOM);
            e eVar2 = this.N;
            z2 = eVar2 != null && eVar2.M[1] == e.b.WRAP_CONTENT;
        }
        if (this.f5585x0 != -1) {
            o.i iVarQ = dVar.q(this.f5587z0);
            dVar.e(iVarQ, dVar.q(dVarK), this.f5585x0, 8);
            if (z2) {
                dVar.h(dVar.q(dVarK2), iVarQ, 0, 5);
                return;
            }
            return;
        }
        if (this.f5586y0 == -1) {
            if (this.f5584w0 != -1.0f) {
                dVar.d(o.d.s(dVar, dVar.q(this.f5587z0), dVar.q(dVarK2), this.f5584w0));
                return;
            }
            return;
        }
        o.i iVarQ2 = dVar.q(this.f5587z0);
        o.i iVarQ3 = dVar.q(dVarK2);
        dVar.e(iVarQ2, iVarQ3, -this.f5586y0, 8);
        if (z2) {
            dVar.h(iVarQ2, dVar.q(dVarK), 0, 5);
            dVar.h(iVarQ3, iVarQ2, 0, 5);
        }
    }

    @Override // p.e
    public boolean g() {
        return true;
    }

    @Override // p.e
    public d k(d.b bVar) {
        switch (a.f5588a[bVar.ordinal()]) {
            case 1:
            case 2:
                if (this.A0 == 1) {
                    return this.f5587z0;
                }
                break;
            case 3:
            case 4:
                if (this.A0 == 0) {
                    return this.f5587z0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(bVar.name());
    }
}
