package r1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import o1.o;
import o1.r;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: MapTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q1.c f6086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f6087c;

    /* JADX INFO: compiled from: MapTypeAdapterFactory.java */
    private final class a<K, V> extends v<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v<K> f6088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final v<V> f6089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final q1.i<? extends Map<K, V>> f6090c;

        public a(o1.e eVar, Type type, v<K> vVar, Type type2, v<V> vVar2, q1.i<? extends Map<K, V>> iVar) {
            this.f6088a = new m(eVar, vVar, type);
            this.f6089b = new m(eVar, vVar2, type2);
            this.f6090c = iVar;
        }

        private String e(o1.j jVar) {
            if (!jVar.g()) {
                if (jVar.e()) {
                    return "null";
                }
                throw new AssertionError();
            }
            o oVarC = jVar.c();
            if (oVarC.p()) {
                return String.valueOf(oVarC.l());
            }
            if (oVarC.n()) {
                return Boolean.toString(oVarC.h());
            }
            if (oVarC.q()) {
                return oVarC.m();
            }
            throw new AssertionError();
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(w1.a aVar) throws IOException {
            w1.b bVarX = aVar.x();
            if (bVarX == w1.b.NULL) {
                aVar.t();
                return null;
            }
            Map<K, V> mapA = this.f6090c.a();
            if (bVarX == w1.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.j()) {
                    aVar.a();
                    K kB = this.f6088a.b(aVar);
                    if (mapA.put(kB, this.f6089b.b(aVar)) != null) {
                        throw new r("duplicate key: " + kB);
                    }
                    aVar.f();
                }
                aVar.f();
            } else {
                aVar.b();
                while (aVar.j()) {
                    q1.f.f5900a.a(aVar);
                    K kB2 = this.f6088a.b(aVar);
                    if (mapA.put(kB2, this.f6089b.b(aVar)) != null) {
                        throw new r("duplicate key: " + kB2);
                    }
                }
                aVar.g();
            }
            return mapA;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.l();
                return;
            }
            if (!h.this.f6087c) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.j(String.valueOf(entry.getKey()));
                    this.f6089b.d(cVar, entry.getValue());
                }
                cVar.g();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i3 = 0;
            boolean z2 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                o1.j jVarC = this.f6088a.c(entry2.getKey());
                arrayList.add(jVarC);
                arrayList2.add(entry2.getValue());
                z2 |= jVarC.d() || jVarC.f();
            }
            if (!z2) {
                cVar.d();
                int size = arrayList.size();
                while (i3 < size) {
                    cVar.j(e((o1.j) arrayList.get(i3)));
                    this.f6089b.d(cVar, (V) arrayList2.get(i3));
                    i3++;
                }
                cVar.g();
                return;
            }
            cVar.c();
            int size2 = arrayList.size();
            while (i3 < size2) {
                cVar.c();
                q1.l.b((o1.j) arrayList.get(i3), cVar);
                this.f6089b.d(cVar, (V) arrayList2.get(i3));
                cVar.f();
                i3++;
            }
            cVar.f();
        }
    }

    public h(q1.c cVar, boolean z2) {
        this.f6086b = cVar;
        this.f6087c = z2;
    }

    private v<?> b(o1.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.f6134f : eVar.l(v1.a.b(type));
    }

    @Override // o1.w
    public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
        Type typeE = aVar.e();
        if (!Map.class.isAssignableFrom(aVar.c())) {
            return null;
        }
        Type[] typeArrJ = q1.b.j(typeE, q1.b.k(typeE));
        return new a(eVar, typeArrJ[0], b(eVar, typeArrJ[0]), typeArrJ[1], eVar.l(v1.a.b(typeArrJ[1])), this.f6086b.a(aVar));
    }
}
