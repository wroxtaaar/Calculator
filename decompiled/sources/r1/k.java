package r1;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o1.r;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q1.c f6101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o1.d f6102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q1.d f6103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f6104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final t1.b f6105f = t1.b.a();

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Field f6106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f6107e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f6108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ o1.e f6109g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ v1.a f6110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f6111i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z2, boolean z3, Field field, boolean z4, v vVar, o1.e eVar, v1.a aVar, boolean z5) {
            super(str, z2, z3);
            this.f6106d = field;
            this.f6107e = z4;
            this.f6108f = vVar;
            this.f6109g = eVar;
            this.f6110h = aVar;
            this.f6111i = z5;
        }

        @Override // r1.k.c
        void a(w1.a aVar, Object obj) throws IllegalAccessException, IOException {
            Object objB = this.f6108f.b(aVar);
            if (objB == null && this.f6111i) {
                return;
            }
            this.f6106d.set(obj, objB);
        }

        @Override // r1.k.c
        void b(w1.c cVar, Object obj) throws IllegalAccessException, IOException {
            (this.f6107e ? this.f6108f : new m(this.f6109g, this.f6108f, this.f6110h.e())).d(cVar, this.f6106d.get(obj));
        }

        @Override // r1.k.c
        public boolean c(Object obj) throws IllegalAccessException, IOException {
            return this.f6116b && this.f6106d.get(obj) != obj;
        }
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    public static final class b<T> extends v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q1.i<T> f6113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, c> f6114b;

        b(q1.i<T> iVar, Map<String, c> map) {
            this.f6113a = iVar;
            this.f6114b = map;
        }

        @Override // o1.v
        public T b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            T tA = this.f6113a.a();
            try {
                aVar.b();
                while (aVar.j()) {
                    c cVar = this.f6114b.get(aVar.r());
                    if (cVar == null || !cVar.f6117c) {
                        aVar.H();
                    } else {
                        cVar.a(aVar, tA);
                    }
                }
                aVar.g();
                return tA;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            } catch (IllegalStateException e4) {
                throw new r(e4);
            }
        }

        @Override // o1.v
        public void d(w1.c cVar, T t3) throws IOException {
            if (t3 == null) {
                cVar.l();
                return;
            }
            cVar.d();
            try {
                for (c cVar2 : this.f6114b.values()) {
                    if (cVar2.c(t3)) {
                        cVar.j(cVar2.f6115a);
                        cVar2.b(cVar, t3);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f6115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f6116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f6117c;

        protected c(String str, boolean z2, boolean z3) {
            this.f6115a = str;
            this.f6116b = z2;
            this.f6117c = z3;
        }

        abstract void a(w1.a aVar, Object obj) throws IllegalAccessException, IOException;

        abstract void b(w1.c cVar, Object obj) throws IllegalAccessException, IOException;

        abstract boolean c(Object obj) throws IllegalAccessException, IOException;
    }

    public k(q1.c cVar, o1.d dVar, q1.d dVar2, e eVar) {
        this.f6101b = cVar;
        this.f6102c = dVar;
        this.f6103d = dVar2;
        this.f6104e = eVar;
    }

    private c b(o1.e eVar, Field field, String str, v1.a<?> aVar, boolean z2, boolean z3) {
        boolean zA = q1.k.a(aVar.c());
        p1.b bVar = (p1.b) field.getAnnotation(p1.b.class);
        v<?> vVarB = bVar != null ? this.f6104e.b(this.f6101b, eVar, aVar, bVar) : null;
        boolean z4 = vVarB != null;
        if (vVarB == null) {
            vVarB = eVar.l(aVar);
        }
        return new a(str, z2, z3, field, z4, vVarB, eVar, aVar, zA);
    }

    static boolean d(Field field, boolean z2, q1.d dVar) {
        return (dVar.c(field.getType(), z2) || dVar.f(field, z2)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    private Map<String, c> e(o1.e eVar, v1.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type typeE = aVar.e();
        v1.a<?> aVarB = aVar;
        Class<?> clsC = cls;
        while (clsC != Object.class) {
            Field[] declaredFields = clsC.getDeclaredFields();
            int length = declaredFields.length;
            boolean z2 = false;
            int i3 = 0;
            while (i3 < length) {
                Field field = declaredFields[i3];
                boolean zC = c(field, true);
                boolean zC2 = c(field, z2);
                if (zC || zC2) {
                    this.f6105f.b(field);
                    Type typeP = q1.b.p(aVarB.e(), clsC, field.getGenericType());
                    List<String> listF = f(field);
                    int size = listF.size();
                    c cVar = null;
                    ?? r3 = z2;
                    while (r3 < size) {
                        String str = listF.get(r3);
                        boolean z3 = r3 != 0 ? z2 : zC;
                        ?? r20 = r3;
                        c cVar2 = cVar;
                        int i4 = size;
                        List<String> list = listF;
                        Field field2 = field;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, b(eVar, field, str, v1.a.b(typeP), z3, zC2)) : cVar2;
                        zC = z3;
                        listF = list;
                        size = i4;
                        field = field2;
                        z2 = false;
                        r3 = (r20 == true ? 1 : 0) + 1;
                    }
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException(typeE + " declares multiple JSON fields named " + cVar3.f6115a);
                    }
                }
                i3++;
                z2 = false;
            }
            aVarB = v1.a.b(q1.b.p(aVarB.e(), clsC, clsC.getGenericSuperclass()));
            clsC = aVarB.c();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        p1.c cVar = (p1.c) field.getAnnotation(p1.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f6102c.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // o1.w
    public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
        Class<? super T> clsC = aVar.c();
        if (Object.class.isAssignableFrom(clsC)) {
            return new b(this.f6101b.a(aVar), e(eVar, aVar, clsC));
        }
        return null;
    }

    public boolean c(Field field, boolean z2) {
        return d(field, z2, this.f6103d);
    }
}
