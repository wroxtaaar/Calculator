package y2;

/* JADX INFO: compiled from: Function.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f6528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f6529b;

    public abstract int a();

    public void b(int i3) throws a {
        if (a() == i3) {
            return;
        }
        throw new a("Expected " + a() + " arguments, got " + i3);
    }

    public double c() {
        throw new a(0);
    }

    public double d(double d3) {
        throw new a(1);
    }

    public double e(double d3, double d4) {
        throw new a(2);
    }

    public double f(double[] dArr) {
        int length = dArr.length;
        if (length == 0) {
            return c();
        }
        if (length == 1) {
            return d(dArr[0]);
        }
        if (length == 2) {
            return e(dArr[0], dArr[1]);
        }
        throw new a(dArr.length);
    }

    public e g(e eVar) {
        b(1);
        return new e(eVar.f6501b == 0.0d ? d(eVar.f6500a) : Double.NaN, 0.0d);
    }

    public e h(e eVar, e eVar2) {
        b(2);
        return new e((eVar.f6501b == 0.0d && eVar2.f6501b == 0.0d) ? e(eVar.f6500a, eVar2.f6500a) : Double.NaN, 0.0d);
    }

    public e i(e[] eVarArr) {
        int length = eVarArr.length;
        if (length == 0) {
            return j();
        }
        if (length == 1) {
            return g(eVarArr[0]);
        }
        if (length == 2) {
            return h(eVarArr[0], eVarArr[1]);
        }
        int length2 = eVarArr.length;
        b(length2);
        double[] dArr = new double[length2];
        for (int length3 = eVarArr.length - 1; length3 >= 0; length3--) {
            if (eVarArr[length3].f6501b != 0.0d) {
                return new e(Double.NaN, 0.0d);
            }
            dArr[length3] = eVarArr[length3].f6500a;
        }
        return new e(f(dArr), 0.0d);
    }

    public e j() {
        b(0);
        return new e(c(), 0.0d);
    }

    public m k() {
        if (this.f6528a == null) {
            this.f6528a = new j(this);
        }
        return this.f6528a;
    }

    void l(m mVar) {
        this.f6528a = mVar;
    }
}
