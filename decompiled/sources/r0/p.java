package r0;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public class p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f6049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.a f6050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f6051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6052d;

    /* JADX INFO: compiled from: Response.java */
    public interface a {
        void b(u uVar);
    }

    private p(T t3, b.a aVar) {
        this.f6052d = false;
        this.f6049a = t3;
        this.f6050b = aVar;
        this.f6051c = null;
    }

    public static <T> p<T> a(u uVar) {
        return new p<>(uVar);
    }

    public static <T> p<T> c(T t3, b.a aVar) {
        return new p<>(t3, aVar);
    }

    public boolean b() {
        return this.f6051c == null;
    }

    private p(u uVar) {
        this.f6052d = false;
        this.f6049a = null;
        this.f6050b = null;
        this.f6051c = uVar;
    }
}
