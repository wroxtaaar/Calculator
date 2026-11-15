package y2;

/* JADX INFO: compiled from: Derivative.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m f6516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f6517d = new e();

    public j(m mVar) throws a {
        this.f6516c = mVar;
        mVar.b(1);
    }

    @Override // y2.m
    public int a() {
        return 1;
    }

    @Override // y2.m
    public double d(double d3) {
        return this.f6516c.g(this.f6517d.F(d3, 1.0E-12d)).f6501b * 1.0E12d;
    }
}
