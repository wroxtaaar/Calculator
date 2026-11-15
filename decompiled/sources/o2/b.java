package o2;

/* JADX INFO: compiled from: SpringConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f5479e = a(40.0d, 7.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f5480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f5481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f5482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f5483d;

    public b(double d3, double d4) {
        this.f5481b = d3;
        this.f5480a = d4;
    }

    public static b a(double d3, double d4) {
        return new b(s2.a.b(d3), s2.a.a(d4));
    }

    public String toString() {
        return "tension,friction=[" + this.f5481b + "," + this.f5480a + "]stiffness,damping=[" + this.f5482c + "," + this.f5483d + "]";
    }
}
