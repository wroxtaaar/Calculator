package v1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import q1.b;

/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Class<? super T> f6315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Type f6316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f6317c;

    protected a() {
        Type typeD = d(getClass());
        this.f6316b = typeD;
        this.f6315a = (Class<? super T>) b.k(typeD);
        this.f6317c = typeD.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    static Type d(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> c() {
        return this.f6315a;
    }

    public final Type e() {
        return this.f6316b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f6316b, ((a) obj).f6316b);
    }

    public final int hashCode() {
        return this.f6317c;
    }

    public final String toString() {
        return b.u(this.f6316b);
    }

    a(Type type) {
        Type typeB = b.b((Type) q1.a.b(type));
        this.f6316b = typeB;
        this.f6315a = (Class<? super T>) b.k(typeB);
        this.f6317c = typeB.hashCode();
    }
}
