package l;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    f<K, V> f5208i;

    /* JADX INFO: renamed from: l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayMap.java */
    class C0073a extends f<K, V> {
        C0073a() {
        }

        @Override // l.f
        protected void a() {
            a.this.clear();
        }

        @Override // l.f
        protected Object b(int i3, int i4) {
            return a.this.f5257c[(i3 << 1) + i4];
        }

        @Override // l.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // l.f
        protected int d() {
            return a.this.f5258d;
        }

        @Override // l.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // l.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // l.f
        protected void g(K k3, V v3) {
            a.this.put(k3, v3);
        }

        @Override // l.f
        protected void h(int i3) {
            a.this.k(i3);
        }

        @Override // l.f
        protected V i(int i3, V v3) {
            return a.this.l(i3, v3);
        }
    }

    public a() {
    }

    private f<K, V> n() {
        if (this.f5208i == null) {
            this.f5208i = new C0073a();
        }
        return this.f5208i;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f5258d + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }

    public a(int i3) {
        super(i3);
    }

    public a(g gVar) {
        super(gVar);
    }
}
