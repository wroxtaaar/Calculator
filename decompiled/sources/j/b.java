package j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c<K, V> f4912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c<K, V> f4913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f4914d = new WeakHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4915e = 0;

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f4919e;
        }

        @Override // j.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f4918d;
        }
    }

    /* JADX INFO: renamed from: j.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static class C0068b<K, V> extends e<K, V> {
        C0068b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // j.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f4918d;
        }

        @Override // j.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f4919e;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final K f4916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final V f4917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c<K, V> f4918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c<K, V> f4919e;

        c(K k3, V v3) {
            this.f4916b = k3;
            this.f4917c = v3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f4916b.equals(cVar.f4916b) && this.f4917c.equals(cVar.f4917c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4916b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4917c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f4917c.hashCode() ^ this.f4916b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f4916b + "=" + this.f4917c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c<K, V> f4920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4921c = true;

        d() {
        }

        @Override // j.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f4920b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f4919e;
                this.f4920b = cVar3;
                this.f4921c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f4921c) {
                this.f4921c = false;
                this.f4920b = b.this.f4912b;
            } else {
                c<K, V> cVar = this.f4920b;
                this.f4920b = cVar != null ? cVar.f4918d : null;
            }
            return this.f4920b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4921c) {
                return b.this.f4912b != null;
            }
            c<K, V> cVar = this.f4920b;
            return (cVar == null || cVar.f4918d == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c<K, V> f4923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c<K, V> f4924c;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f4923b = cVar2;
            this.f4924c = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f4924c;
            c<K, V> cVar2 = this.f4923b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // j.b.f
        public void a(c<K, V> cVar) {
            if (this.f4923b == cVar && cVar == this.f4924c) {
                this.f4924c = null;
                this.f4923b = null;
            }
            c<K, V> cVar2 = this.f4923b;
            if (cVar2 == cVar) {
                this.f4923b = b(cVar2);
            }
            if (this.f4924c == cVar) {
                this.f4924c = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f4924c;
            this.f4924c = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4924c != null;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0068b c0068b = new C0068b(this.f4913c, this.f4912b);
        this.f4914d.put(c0068b, Boolean.FALSE);
        return c0068b;
    }

    public Map.Entry<K, V> b() {
        return this.f4912b;
    }

    protected c<K, V> c(K k3) {
        c<K, V> cVar = this.f4912b;
        while (cVar != null && !cVar.f4916b.equals(k3)) {
            cVar = cVar.f4918d;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f4914d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.f4913c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    protected c<K, V> f(K k3, V v3) {
        c<K, V> cVar = new c<>(k3, v3);
        this.f4915e++;
        c<K, V> cVar2 = this.f4913c;
        if (cVar2 == null) {
            this.f4912b = cVar;
            this.f4913c = cVar;
            return cVar;
        }
        cVar2.f4918d = cVar;
        cVar.f4919e = cVar2;
        this.f4913c = cVar;
        return cVar;
    }

    public V g(K k3, V v3) {
        c<K, V> cVarC = c(k3);
        if (cVarC != null) {
            return cVarC.f4917c;
        }
        f(k3, v3);
        return null;
    }

    public V h(K k3) {
        c<K, V> cVarC = c(k3);
        if (cVarC == null) {
            return null;
        }
        this.f4915e--;
        if (!this.f4914d.isEmpty()) {
            Iterator<f<K, V>> it = this.f4914d.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarC);
            }
        }
        c<K, V> cVar = cVarC.f4919e;
        if (cVar != null) {
            cVar.f4918d = cVarC.f4918d;
        } else {
            this.f4912b = cVarC.f4918d;
        }
        c<K, V> cVar2 = cVarC.f4918d;
        if (cVar2 != null) {
            cVar2.f4919e = cVar;
        } else {
            this.f4913c = cVar;
        }
        cVarC.f4918d = null;
        cVarC.f4919e = null;
        return cVarC.f4917c;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f4912b, this.f4913c);
        this.f4914d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f4915e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
