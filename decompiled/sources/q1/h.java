package q1;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: LinkedTreeMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator<Comparable> f5902i = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Comparator<? super K> f5903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e<K, V> f5904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f5906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final e<K, V> f5907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h<K, V>.b f5908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h<K, V>.c f5909h;

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: compiled from: LinkedTreeMap.java */
        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f5905d;
        }
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    final class c extends AbstractSet<K> {

        /* JADX INFO: compiled from: LinkedTreeMap.java */
        class a extends h<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f5923g;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f5905d;
        }
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    private abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f5914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<K, V> f5915c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5916d;

        d() {
            this.f5914b = h.this.f5907f.f5921e;
            this.f5916d = h.this.f5906e;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f5914b;
            h hVar = h.this;
            if (eVar == hVar.f5907f) {
                throw new NoSuchElementException();
            }
            if (hVar.f5906e != this.f5916d) {
                throw new ConcurrentModificationException();
            }
            this.f5914b = eVar.f5921e;
            this.f5915c = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5914b != h.this.f5907f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f5915c;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f5915c = null;
            this.f5916d = h.this.f5906e;
        }
    }

    public h() {
        this(f5902i);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void e(e<K, V> eVar, boolean z2) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f5919c;
            e<K, V> eVar3 = eVar.f5920d;
            int i3 = eVar2 != null ? eVar2.f5925i : 0;
            int i4 = eVar3 != null ? eVar3.f5925i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                e<K, V> eVar4 = eVar3.f5919c;
                e<K, V> eVar5 = eVar3.f5920d;
                int i6 = (eVar4 != null ? eVar4.f5925i : 0) - (eVar5 != null ? eVar5.f5925i : 0);
                if (i6 == -1 || (i6 == 0 && !z2)) {
                    i(eVar);
                } else {
                    j(eVar3);
                    i(eVar);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 2) {
                e<K, V> eVar6 = eVar2.f5919c;
                e<K, V> eVar7 = eVar2.f5920d;
                int i7 = (eVar6 != null ? eVar6.f5925i : 0) - (eVar7 != null ? eVar7.f5925i : 0);
                if (i7 == 1 || (i7 == 0 && !z2)) {
                    j(eVar);
                } else {
                    i(eVar2);
                    j(eVar);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 0) {
                eVar.f5925i = i3 + 1;
                if (z2) {
                    return;
                }
            } else {
                eVar.f5925i = Math.max(i3, i4) + 1;
                if (!z2) {
                    return;
                }
            }
            eVar = eVar.f5918b;
        }
    }

    private void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f5918b;
        eVar.f5918b = null;
        if (eVar2 != null) {
            eVar2.f5918b = eVar3;
        }
        if (eVar3 == null) {
            this.f5904c = eVar2;
        } else if (eVar3.f5919c == eVar) {
            eVar3.f5919c = eVar2;
        } else {
            eVar3.f5920d = eVar2;
        }
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5919c;
        e<K, V> eVar3 = eVar.f5920d;
        e<K, V> eVar4 = eVar3.f5919c;
        e<K, V> eVar5 = eVar3.f5920d;
        eVar.f5920d = eVar4;
        if (eVar4 != null) {
            eVar4.f5918b = eVar;
        }
        h(eVar, eVar3);
        eVar3.f5919c = eVar;
        eVar.f5918b = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f5925i : 0, eVar4 != null ? eVar4.f5925i : 0) + 1;
        eVar.f5925i = iMax;
        eVar3.f5925i = Math.max(iMax, eVar5 != null ? eVar5.f5925i : 0) + 1;
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5919c;
        e<K, V> eVar3 = eVar.f5920d;
        e<K, V> eVar4 = eVar2.f5919c;
        e<K, V> eVar5 = eVar2.f5920d;
        eVar.f5919c = eVar5;
        if (eVar5 != null) {
            eVar5.f5918b = eVar;
        }
        h(eVar, eVar2);
        eVar2.f5920d = eVar;
        eVar.f5918b = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f5925i : 0, eVar5 != null ? eVar5.f5925i : 0) + 1;
        eVar.f5925i = iMax;
        eVar2.f5925i = Math.max(iMax, eVar4 != null ? eVar4.f5925i : 0) + 1;
    }

    e<K, V> b(K k3, boolean z2) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f5903b;
        e<K, V> eVar2 = this.f5904c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f5902i ? (Comparable) k3 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f5923g) : comparator.compare(k3, eVar2.f5923g);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f5919c : eVar2.f5920d;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z2) {
            return null;
        }
        e<K, V> eVar4 = this.f5907f;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k3, eVar4, eVar4.f5922f);
            if (iCompareTo < 0) {
                eVar2.f5919c = eVar;
            } else {
                eVar2.f5920d = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f5902i && !(k3 instanceof Comparable)) {
                throw new ClassCastException(k3.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k3, eVar4, eVar4.f5922f);
            this.f5904c = eVar;
        }
        this.f5905d++;
        this.f5906e++;
        return eVar;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> eVarD = d(entry.getKey());
        if (eVarD != null && a(eVarD.f5924h, entry.getValue())) {
            return eVarD;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f5904c = null;
        this.f5905d = 0;
        this.f5906e++;
        e<K, V> eVar = this.f5907f;
        eVar.f5922f = eVar;
        eVar.f5921e = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.f5908g;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f5908g = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z2) {
        int i3;
        if (z2) {
            e<K, V> eVar2 = eVar.f5922f;
            eVar2.f5921e = eVar.f5921e;
            eVar.f5921e.f5922f = eVar2;
        }
        e<K, V> eVar3 = eVar.f5919c;
        e<K, V> eVar4 = eVar.f5920d;
        e<K, V> eVar5 = eVar.f5918b;
        int i4 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f5919c = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f5920d = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f5905d--;
            this.f5906e++;
            return;
        }
        e<K, V> eVarB = eVar3.f5925i > eVar4.f5925i ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e<K, V> eVar6 = eVar.f5919c;
        if (eVar6 != null) {
            i3 = eVar6.f5925i;
            eVarB.f5919c = eVar6;
            eVar6.f5918b = eVarB;
            eVar.f5919c = null;
        } else {
            i3 = 0;
        }
        e<K, V> eVar7 = eVar.f5920d;
        if (eVar7 != null) {
            i4 = eVar7.f5925i;
            eVarB.f5920d = eVar7;
            eVar7.f5918b = eVarB;
            eVar.f5920d = null;
        }
        eVarB.f5925i = Math.max(i3, i4) + 1;
        h(eVar, eVarB);
    }

    e<K, V> g(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f5924h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.f5909h;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.f5909h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k3, V v3) {
        Objects.requireNonNull(k3, "key == null");
        e<K, V> eVarB = b(k3, true);
        V v4 = eVarB.f5924h;
        eVarB.f5924h = v3;
        return v4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f5924h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f5905d;
    }

    public h(Comparator<? super K> comparator) {
        this.f5905d = 0;
        this.f5906e = 0;
        this.f5907f = new e<>();
        this.f5903b = comparator == null ? f5902i : comparator;
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f5918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<K, V> f5919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e<K, V> f5920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e<K, V> f5921e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        e<K, V> f5922f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final K f5923g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        V f5924h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f5925i;

        e() {
            this.f5923g = null;
            this.f5922f = this;
            this.f5921e = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this.f5919c;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f5919c;
            }
        }

        public e<K, V> b() {
            e<K, V> eVar = this.f5920d;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f5920d;
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k3 = this.f5923g;
            if (k3 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k3.equals(entry.getKey())) {
                return false;
            }
            V v3 = this.f5924h;
            if (v3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5923g;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5924h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k3 = this.f5923g;
            int iHashCode = k3 == null ? 0 : k3.hashCode();
            V v3 = this.f5924h;
            return iHashCode ^ (v3 != null ? v3.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            V v4 = this.f5924h;
            this.f5924h = v3;
            return v4;
        }

        public String toString() {
            return this.f5923g + "=" + this.f5924h;
        }

        e(e<K, V> eVar, K k3, e<K, V> eVar2, e<K, V> eVar3) {
            this.f5918b = eVar;
            this.f5923g = k3;
            this.f5925i = 1;
            this.f5921e = eVar2;
            this.f5922f = eVar3;
            eVar3.f5921e = this;
            eVar2.f5922f = this;
        }
    }
}
