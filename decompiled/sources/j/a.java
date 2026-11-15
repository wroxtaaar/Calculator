package j;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FastSafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f4911f = new HashMap<>();

    @Override // j.b
    protected b.c<K, V> c(K k3) {
        return this.f4911f.get(k3);
    }

    public boolean contains(K k3) {
        return this.f4911f.containsKey(k3);
    }

    @Override // j.b
    public V g(K k3, V v3) {
        b.c<K, V> cVarC = c(k3);
        if (cVarC != null) {
            return cVarC.f4917c;
        }
        this.f4911f.put(k3, f(k3, v3));
        return null;
    }

    @Override // j.b
    public V h(K k3) {
        V v3 = (V) super.h(k3);
        this.f4911f.remove(k3);
        return v3;
    }

    public Map.Entry<K, V> i(K k3) {
        if (contains(k3)) {
            return this.f4911f.get(k3).f4919e;
        }
        return null;
    }
}
