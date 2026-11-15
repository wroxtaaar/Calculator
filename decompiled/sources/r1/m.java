package r1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import o1.v;

/* JADX INFO: compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
final class m<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o1.e f6126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v<T> f6127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f6128c;

    m(o1.e eVar, v<T> vVar, Type type) {
        this.f6126a = eVar;
        this.f6127b = vVar;
        this.f6128c = type;
    }

    private Type e(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }

    @Override // o1.v
    public T b(w1.a aVar) throws IOException {
        return this.f6127b.b(aVar);
    }

    @Override // o1.v
    public void d(w1.c cVar, T t3) throws IOException {
        v<T> vVarL = this.f6127b;
        Type typeE = e(this.f6128c, t3);
        if (typeE != this.f6128c) {
            vVarL = this.f6126a.l(v1.a.b(typeE));
            if (vVarL instanceof k.b) {
                v<T> vVar = this.f6127b;
                if (!(vVar instanceof k.b)) {
                    vVarL = vVar;
                }
            }
        }
        vVarL.d(cVar, t3);
    }
}
