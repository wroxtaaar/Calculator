package r0;

/* JADX INFO: compiled from: VolleyError.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f6053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6054c;

    public u() {
        this.f6053b = null;
    }

    void a(long j3) {
        this.f6054c = j3;
    }

    public u(k kVar) {
        this.f6053b = kVar;
    }

    public u(Throwable th) {
        super(th);
        this.f6053b = null;
    }
}
