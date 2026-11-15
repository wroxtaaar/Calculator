package y2;

/* JADX INFO: compiled from: ContextFunction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static l f6503c = new l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final double[] f6504d = new double[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final e[] f6505e = new e[0];

    @Override // y2.m
    public double c() {
        return f(f6504d);
    }

    @Override // y2.m
    public double d(double d3) {
        double dN;
        synchronized (f6503c) {
            dN = n(d3, f6503c);
        }
        return dN;
    }

    @Override // y2.m
    public double e(double d3, double d4) {
        double dM;
        synchronized (f6503c) {
            dM = m(d3, d4, f6503c);
        }
        return dM;
    }

    @Override // y2.m
    public double f(double[] dArr) {
        double dO;
        synchronized (f6503c) {
            dO = o(dArr, f6503c);
        }
        return dO;
    }

    @Override // y2.m
    public e g(e eVar) {
        e eVarQ;
        synchronized (f6503c) {
            eVarQ = q(eVar, f6503c);
        }
        return eVarQ;
    }

    @Override // y2.m
    public e h(e eVar, e eVar2) {
        e eVarP;
        synchronized (f6503c) {
            eVarP = p(eVar, eVar2, f6503c);
        }
        return eVarP;
    }

    @Override // y2.m
    public e i(e[] eVarArr) {
        e eVarR;
        synchronized (f6503c) {
            eVarR = r(eVarArr, f6503c);
        }
        return eVarR;
    }

    @Override // y2.m
    public e j() {
        return i(f6505e);
    }

    public double m(double d3, double d4, l lVar) {
        double[] dArr = lVar.f6525e;
        dArr[0] = d3;
        dArr[1] = d4;
        return o(dArr, lVar);
    }

    public double n(double d3, l lVar) {
        double[] dArr = lVar.f6524d;
        dArr[0] = d3;
        return o(dArr, lVar);
    }

    public abstract double o(double[] dArr, l lVar);

    public e p(e eVar, e eVar2, l lVar) {
        e[] eVarArr = lVar.f6527g;
        eVarArr[0] = eVar;
        eVarArr[1] = eVar2;
        return r(eVarArr, lVar);
    }

    public e q(e eVar, l lVar) {
        e[] eVarArr = lVar.f6526f;
        eVarArr[0] = eVar;
        return r(eVarArr, lVar);
    }

    public abstract e r(e[] eVarArr, l lVar);

    e[] s(double[] dArr, l lVar) {
        int length = dArr.length;
        if (length == 0) {
            return f6505e;
        }
        if (length == 1) {
            e[] eVarArr = lVar.f6526f;
            eVarArr[0].F(dArr[0], 0.0d);
            return eVarArr;
        }
        if (length == 2) {
            e[] eVarArr2 = lVar.f6527g;
            eVarArr2[0].F(dArr[0], 0.0d);
            eVarArr2[1].F(dArr[1], 0.0d);
            return eVarArr2;
        }
        e[] eVarArr3 = new e[dArr.length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            eVarArr3[i3] = new e(dArr[i3], 0.0d);
        }
        return eVarArr3;
    }
}
