package l;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class e<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f5229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5236h;

    public e(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f5231c = i3;
        this.f5229a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int e(K k3, V v3) {
        int iF = f(k3, v3);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException("Negative size: " + k3 + "=" + v3);
    }

    protected V a(K k3) {
        return null;
    }

    protected void b(boolean z2, K k3, V v3, V v4) {
    }

    public final V c(K k3) {
        V vPut;
        Objects.requireNonNull(k3, "key == null");
        synchronized (this) {
            V v3 = this.f5229a.get(k3);
            if (v3 != null) {
                this.f5235g++;
                return v3;
            }
            this.f5236h++;
            V vA = a(k3);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                this.f5233e++;
                vPut = this.f5229a.put(k3, vA);
                if (vPut != null) {
                    this.f5229a.put(k3, vPut);
                } else {
                    this.f5230b += e(k3, vA);
                }
            }
            if (vPut != null) {
                b(false, k3, vA, vPut);
                return vPut;
            }
            g(this.f5231c);
            return vA;
        }
    }

    public final V d(K k3, V v3) {
        V vPut;
        if (k3 == null || v3 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f5232d++;
            this.f5230b += e(k3, v3);
            vPut = this.f5229a.put(k3, v3);
            if (vPut != null) {
                this.f5230b -= e(k3, vPut);
            }
        }
        if (vPut != null) {
            b(false, k3, vPut, v3);
        }
        g(this.f5231c);
        return vPut;
    }

    protected int f(K k3, V v3) {
        return 1;
    }

    public void g(int i3) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f5230b < 0 || (this.f5229a.isEmpty() && this.f5230b != 0)) {
                    break;
                }
                if (this.f5230b > i3 && !this.f5229a.isEmpty()) {
                    Map.Entry<K, V> next = this.f5229a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f5229a.remove(key);
                    this.f5230b -= e(key, value);
                    this.f5234f++;
                }
                return;
            }
            b(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized String toString() {
        int i3;
        int i4;
        i3 = this.f5235g;
        i4 = this.f5236h + i3;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f5231c), Integer.valueOf(this.f5235g), Integer.valueOf(this.f5236h), Integer.valueOf(i4 != 0 ? (i3 * 100) / i4 : 0));
    }
}
