package w2;

/* JADX INFO: compiled from: SpringConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f6408c = a(40.0d, 7.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f6409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f6410b;

    public c(double d3, double d4) {
        this.f6410b = d3;
        this.f6409a = d4;
    }

    public static c a(double d3, double d4) {
        return new c(a.b(d3), a.a(d4));
    }
}
