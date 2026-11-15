package r1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: ArrayTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<E> extends v<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f6064c = new C0087a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<E> f6065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v<E> f6066b;

    /* JADX INFO: renamed from: r1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayTypeAdapter.java */
    class C0087a implements w {
        C0087a() {
        }

        @Override // o1.w
        public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
            Type typeE = aVar.e();
            if (!(typeE instanceof GenericArrayType) && (!(typeE instanceof Class) || !((Class) typeE).isArray())) {
                return null;
            }
            Type typeG = q1.b.g(typeE);
            return new a(eVar, eVar.l(v1.a.b(typeG)), q1.b.k(typeG));
        }
    }

    public a(o1.e eVar, v<E> vVar, Class<E> cls) {
        this.f6066b = new m(eVar, vVar, cls);
        this.f6065a = cls;
    }

    @Override // o1.v
    public Object b(w1.a aVar) throws IOException {
        if (aVar.x() == w1.b.NULL) {
            aVar.t();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.j()) {
            arrayList.add(this.f6066b.b(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f6065a, size);
        for (int i3 = 0; i3 < size; i3++) {
            Array.set(objNewInstance, i3, arrayList.get(i3));
        }
        return objNewInstance;
    }

    @Override // o1.v
    public void d(w1.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.l();
            return;
        }
        cVar.c();
        int length = Array.getLength(obj);
        for (int i3 = 0; i3 < length; i3++) {
            this.f6066b.d(cVar, (E) Array.get(obj, i3));
        }
        cVar.f();
    }
}
