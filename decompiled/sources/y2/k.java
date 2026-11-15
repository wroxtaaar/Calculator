package y2;

/* JADX INFO: compiled from: DoubleStack.java */
/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double[] f6518a = new double[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[] f6519b = new double[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6520c = 0;

    k() {
    }

    void a() {
        this.f6520c = 0;
    }

    double[] b() {
        int i3;
        boolean z2;
        int i4 = 0;
        while (true) {
            i3 = this.f6520c;
            if (i4 >= i3) {
                z2 = true;
                break;
            }
            if (this.f6519b[i4] != 0.0d) {
                z2 = false;
                break;
            }
            i4++;
        }
        if (z2) {
            return null;
        }
        double[] dArr = new double[i3];
        System.arraycopy(this.f6519b, 0, dArr, 0, i3);
        return dArr;
    }

    double[] c() {
        int i3 = this.f6520c;
        double[] dArr = new double[i3];
        System.arraycopy(this.f6518a, 0, dArr, 0, i3);
        return dArr;
    }

    void d() {
        this.f6520c--;
    }

    void e(double d3, double d4) {
        int i3 = this.f6520c;
        double[] dArr = this.f6518a;
        if (i3 >= dArr.length) {
            int length = dArr.length << 1;
            double[] dArr2 = new double[length];
            double[] dArr3 = new double[length];
            System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
            System.arraycopy(this.f6519b, 0, dArr3, 0, this.f6518a.length);
            this.f6518a = dArr2;
            this.f6519b = dArr3;
        }
        double[] dArr4 = this.f6518a;
        int i4 = this.f6520c;
        dArr4[i4] = d3;
        this.f6519b[i4] = d4;
        this.f6520c = i4 + 1;
    }
}
