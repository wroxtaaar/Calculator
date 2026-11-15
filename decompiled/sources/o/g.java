package o;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
class g<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f5363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5364b;

    g(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f5363a = new Object[i3];
    }

    @Override // o.f
    public boolean a(T t3) {
        int i3 = this.f5364b;
        Object[] objArr = this.f5363a;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = t3;
        this.f5364b = i3 + 1;
        return true;
    }

    @Override // o.f
    public T b() {
        int i3 = this.f5364b;
        if (i3 <= 0) {
            return null;
        }
        int i4 = i3 - 1;
        Object[] objArr = this.f5363a;
        T t3 = (T) objArr[i4];
        objArr[i4] = null;
        this.f5364b = i3 - 1;
        return t3;
    }

    @Override // o.f
    public void c(T[] tArr, int i3) {
        if (i3 > tArr.length) {
            i3 = tArr.length;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            T t3 = tArr[i4];
            int i5 = this.f5364b;
            Object[] objArr = this.f5363a;
            if (i5 < objArr.length) {
                objArr[i5] = t3;
                this.f5364b = i5 + 1;
            }
        }
    }
}
