package r0;

/* JADX INFO: compiled from: DefaultRetryPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f5993d;

    public e() {
        this(2500, 1, 1.0f);
    }

    @Override // r0.r
    public int a() {
        return this.f5990a;
    }

    @Override // r0.r
    public int b() {
        return this.f5991b;
    }

    @Override // r0.r
    public void c(u uVar) throws u {
        this.f5991b++;
        int i3 = this.f5990a;
        this.f5990a = i3 + ((int) (i3 * this.f5993d));
        if (!d()) {
            throw uVar;
        }
    }

    protected boolean d() {
        return this.f5991b <= this.f5992c;
    }

    public e(int i3, int i4, float f3) {
        this.f5990a = i3;
        this.f5992c = i4;
        this.f5993d = f3;
    }
}
