package d0;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class h<T> extends g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4506c;

    public h(int i3) {
        super(i3);
        this.f4506c = new Object();
    }

    @Override // d0.g, d0.f
    public boolean a(T t3) {
        boolean zA;
        synchronized (this.f4506c) {
            zA = super.a(t3);
        }
        return zA;
    }

    @Override // d0.g, d0.f
    public T b() {
        T t3;
        synchronized (this.f4506c) {
            t3 = (T) super.b();
        }
        return t3;
    }
}
