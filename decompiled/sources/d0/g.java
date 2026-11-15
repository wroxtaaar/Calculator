package d0;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f4504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4505b;

    public g(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f4504a = new Object[i3];
    }

    private boolean c(T t3) {
        for (int i3 = 0; i3 < this.f4505b; i3++) {
            if (this.f4504a[i3] == t3) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.f
    public boolean a(T t3) {
        if (c(t3)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.f4505b;
        Object[] objArr = this.f4504a;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = t3;
        this.f4505b = i3 + 1;
        return true;
    }

    @Override // d0.f
    public T b() {
        int i3 = this.f4505b;
        if (i3 <= 0) {
            return null;
        }
        int i4 = i3 - 1;
        Object[] objArr = this.f4504a;
        T t3 = (T) objArr[i4];
        objArr[i4] = null;
        this.f4505b = i3 - 1;
        return t3;
    }
}
