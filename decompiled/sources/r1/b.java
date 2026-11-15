package r1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: CollectionTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q1.c f6067b;

    /* JADX INFO: compiled from: CollectionTypeAdapterFactory.java */
    private static final class a<E> extends v<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v<E> f6068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q1.i<? extends Collection<E>> f6069b;

        public a(o1.e eVar, Type type, v<E> vVar, q1.i<? extends Collection<E>> iVar) {
            this.f6068a = new m(eVar, vVar, type);
            this.f6069b = iVar;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            Collection<E> collectionA = this.f6069b.a();
            aVar.a();
            while (aVar.j()) {
                collectionA.add(this.f6068a.b(aVar));
            }
            aVar.f();
            return collectionA;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.l();
                return;
            }
            cVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f6068a.d(cVar, it.next());
            }
            cVar.f();
        }
    }

    public b(q1.c cVar) {
        this.f6067b = cVar;
    }

    @Override // o1.w
    public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
        Type typeE = aVar.e();
        Class<? super T> clsC = aVar.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = q1.b.h(typeE, clsC);
        return new a(eVar, typeH, eVar.l(v1.a.b(typeH)), this.f6067b.a(aVar));
    }
}
