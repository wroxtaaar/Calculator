package o1;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final v1.a<?> f5418x = v1.a.a(Object.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<v1.a<?>, f<?>>> f5419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<v1.a<?>, v<?>> f5420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q1.c f5421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r1.e f5422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<w> f5423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final q1.d f5424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final o1.d f5425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map<Type, o1.f<?>> f5426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f5427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f5428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f5429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f5430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final boolean f5431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f5432n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f5433o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final String f5434p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final int f5435q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final int f5436r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final s f5437s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final List<w> f5438t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final List<w> f5439u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final u f5440v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final u f5441w;

    /* JADX INFO: compiled from: Gson.java */
    class a extends v<Number> {
        a() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return Double.valueOf(aVar.o());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.l();
            } else {
                e.d(number.doubleValue());
                cVar.u(number);
            }
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    class b extends v<Number> {
        b() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return Float.valueOf((float) aVar.o());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.l();
            } else {
                e.d(number.floatValue());
                cVar.u(number);
            }
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    class c extends v<Number> {
        c() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return Long.valueOf(aVar.q());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.l();
            } else {
                cVar.v(number.toString());
            }
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    class d extends v<AtomicLong> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f5444a;

        d(v vVar) {
            this.f5444a = vVar;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(w1.a aVar) throws IOException {
            return new AtomicLong(((Number) this.f5444a.b(aVar)).longValue());
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, AtomicLong atomicLong) throws IOException {
            this.f5444a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: renamed from: o1.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Gson.java */
    class C0076e extends v<AtomicLongArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f5445a;

        C0076e(v vVar) {
            this.f5445a = vVar;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(w1.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.j()) {
                arrayList.add(Long.valueOf(((Number) this.f5445a.b(aVar)).longValue()));
            }
            aVar.f();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i3 = 0; i3 < size; i3++) {
                atomicLongArray.set(i3, ((Long) arrayList.get(i3)).longValue());
            }
            return atomicLongArray;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.c();
            int length = atomicLongArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                this.f5445a.d(cVar, Long.valueOf(atomicLongArray.get(i3)));
            }
            cVar.f();
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    static class f<T> extends v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v<T> f5446a;

        f() {
        }

        @Override // o1.v
        public T b(w1.a aVar) throws IOException {
            v<T> vVar = this.f5446a;
            if (vVar != null) {
                return vVar.b(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // o1.v
        public void d(w1.c cVar, T t3) throws IOException {
            v<T> vVar = this.f5446a;
            if (vVar == null) {
                throw new IllegalStateException();
            }
            vVar.d(cVar, t3);
        }

        public void e(v<T> vVar) {
            if (this.f5446a != null) {
                throw new AssertionError();
            }
            this.f5446a = vVar;
        }
    }

    public e() {
        this(q1.d.f5886h, o1.c.f5411b, Collections.emptyMap(), false, false, false, true, false, false, false, s.f5451b, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), t.f5454b, t.f5455c);
    }

    private static void a(Object obj, w1.a aVar) {
        if (obj != null) {
            try {
                if (aVar.x() == w1.b.END_DOCUMENT) {
                } else {
                    throw new k("JSON document was not fully consumed.");
                }
            } catch (w1.d e3) {
                throw new r(e3);
            } catch (IOException e4) {
                throw new k(e4);
            }
        }
    }

    private static v<AtomicLong> b(v<Number> vVar) {
        return new d(vVar).a();
    }

    private static v<AtomicLongArray> c(v<Number> vVar) {
        return new C0076e(vVar).a();
    }

    static void d(double d3) {
        if (Double.isNaN(d3) || Double.isInfinite(d3)) {
            throw new IllegalArgumentException(d3 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private v<Number> e(boolean z2) {
        return z2 ? r1.n.f6150v : new a();
    }

    private v<Number> f(boolean z2) {
        return z2 ? r1.n.f6149u : new b();
    }

    private static v<Number> n(s sVar) {
        return sVar == s.f5451b ? r1.n.f6148t : new c();
    }

    public <T> T g(Reader reader, Type type) throws r, k {
        w1.a aVarO = o(reader);
        T t3 = (T) j(aVarO, type);
        a(t3, aVarO);
        return t3;
    }

    public <T> T h(String str, Class<T> cls) throws r {
        return (T) q1.k.b(cls).cast(i(str, cls));
    }

    public <T> T i(String str, Type type) throws r {
        if (str == null) {
            return null;
        }
        return (T) g(new StringReader(str), type);
    }

    public <T> T j(w1.a aVar, Type type) throws r, k {
        boolean zK = aVar.k();
        boolean z2 = true;
        aVar.C(true);
        try {
            try {
                try {
                    aVar.x();
                    z2 = false;
                    T tB = l(v1.a.b(type)).b(aVar);
                    aVar.C(zK);
                    return tB;
                } catch (EOFException e3) {
                    if (!z2) {
                        throw new r(e3);
                    }
                    aVar.C(zK);
                    return null;
                } catch (IOException e4) {
                    throw new r(e4);
                }
            } catch (AssertionError e5) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e5.getMessage());
                assertionError.initCause(e5);
                throw assertionError;
            } catch (IllegalStateException e6) {
                throw new r(e6);
            }
        } catch (Throwable th) {
            aVar.C(zK);
            throw th;
        }
    }

    public <T> v<T> k(Class<T> cls) {
        return l(v1.a.a(cls));
    }

    public <T> v<T> l(v1.a<T> aVar) {
        v<T> vVar = (v) this.f5420b.get(aVar == null ? f5418x : aVar);
        if (vVar != null) {
            return vVar;
        }
        Map<v1.a<?>, f<?>> map = this.f5419a.get();
        boolean z2 = false;
        if (map == null) {
            map = new HashMap<>();
            this.f5419a.set(map);
            z2 = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            Iterator<w> it = this.f5423e.iterator();
            while (it.hasNext()) {
                v<T> vVarA = it.next().a(this, aVar);
                if (vVarA != null) {
                    fVar2.e(vVarA);
                    this.f5420b.put(aVar, vVarA);
                    map.remove(aVar);
                    if (z2) {
                        this.f5419a.remove();
                    }
                    return vVarA;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.9) cannot handle " + aVar);
        } catch (Throwable th) {
            map.remove(aVar);
            if (z2) {
                this.f5419a.remove();
            }
            throw th;
        }
    }

    public <T> v<T> m(w wVar, v1.a<T> aVar) {
        if (!this.f5423e.contains(wVar)) {
            wVar = this.f5422d;
        }
        boolean z2 = false;
        for (w wVar2 : this.f5423e) {
            if (z2) {
                v<T> vVarA = wVar2.a(this, aVar);
                if (vVarA != null) {
                    return vVarA;
                }
            } else if (wVar2 == wVar) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public w1.a o(Reader reader) {
        w1.a aVar = new w1.a(reader);
        aVar.C(this.f5432n);
        return aVar;
    }

    public String toString() {
        return "{serializeNulls:" + this.f5427i + ",factories:" + this.f5423e + ",instanceCreators:" + this.f5421c + "}";
    }

    e(q1.d dVar, o1.d dVar2, Map<Type, o1.f<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, s sVar, String str, int i3, int i4, List<w> list, List<w> list2, List<w> list3, u uVar, u uVar2) {
        this.f5419a = new ThreadLocal<>();
        this.f5420b = new ConcurrentHashMap();
        this.f5424f = dVar;
        this.f5425g = dVar2;
        this.f5426h = map;
        q1.c cVar = new q1.c(map);
        this.f5421c = cVar;
        this.f5427i = z2;
        this.f5428j = z3;
        this.f5429k = z4;
        this.f5430l = z5;
        this.f5431m = z6;
        this.f5432n = z7;
        this.f5433o = z8;
        this.f5437s = sVar;
        this.f5434p = str;
        this.f5435q = i3;
        this.f5436r = i4;
        this.f5438t = list;
        this.f5439u = list2;
        this.f5440v = uVar;
        this.f5441w = uVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(r1.n.V);
        arrayList.add(r1.j.e(uVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(r1.n.B);
        arrayList.add(r1.n.f6141m);
        arrayList.add(r1.n.f6135g);
        arrayList.add(r1.n.f6137i);
        arrayList.add(r1.n.f6139k);
        v<Number> vVarN = n(sVar);
        arrayList.add(r1.n.a(Long.TYPE, Long.class, vVarN));
        arrayList.add(r1.n.a(Double.TYPE, Double.class, e(z8)));
        arrayList.add(r1.n.a(Float.TYPE, Float.class, f(z8)));
        arrayList.add(r1.i.e(uVar2));
        arrayList.add(r1.n.f6143o);
        arrayList.add(r1.n.f6145q);
        arrayList.add(r1.n.b(AtomicLong.class, b(vVarN)));
        arrayList.add(r1.n.b(AtomicLongArray.class, c(vVarN)));
        arrayList.add(r1.n.f6147s);
        arrayList.add(r1.n.f6152x);
        arrayList.add(r1.n.D);
        arrayList.add(r1.n.F);
        arrayList.add(r1.n.b(BigDecimal.class, r1.n.f6154z));
        arrayList.add(r1.n.b(BigInteger.class, r1.n.A));
        arrayList.add(r1.n.H);
        arrayList.add(r1.n.J);
        arrayList.add(r1.n.N);
        arrayList.add(r1.n.P);
        arrayList.add(r1.n.T);
        arrayList.add(r1.n.L);
        arrayList.add(r1.n.f6132d);
        arrayList.add(r1.c.f6070b);
        arrayList.add(r1.n.R);
        if (u1.d.f6286a) {
            arrayList.add(u1.d.f6290e);
            arrayList.add(u1.d.f6289d);
            arrayList.add(u1.d.f6291f);
        }
        arrayList.add(r1.a.f6064c);
        arrayList.add(r1.n.f6130b);
        arrayList.add(new r1.b(cVar));
        arrayList.add(new r1.h(cVar, z3));
        r1.e eVar = new r1.e(cVar);
        this.f5422d = eVar;
        arrayList.add(eVar);
        arrayList.add(r1.n.W);
        arrayList.add(new r1.k(cVar, dVar2, dVar, eVar));
        this.f5423e = Collections.unmodifiableList(arrayList);
    }
}
