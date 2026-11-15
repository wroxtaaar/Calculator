package q1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, o1.f<?>> f5861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t1.b f5862b = t1.b.a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class a<T> implements q1.i<T> {
        a() {
        }

        @Override // q1.i
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class b<T> implements q1.i<T> {
        b() {
        }

        @Override // q1.i
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: q1.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class C0084c<T> implements q1.i<T> {
        C0084c() {
        }

        @Override // q1.i
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class d<T> implements q1.i<T> {
        d() {
        }

        @Override // q1.i
        public T a() {
            return (T) new q1.h();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class e<T> implements q1.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q1.m f5867a = q1.m.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f5868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Type f5869c;

        e(Class cls, Type type) {
            this.f5868b = cls;
            this.f5869c = type;
        }

        @Override // q1.i
        public T a() {
            try {
                return (T) this.f5867a.c(this.f5868b);
            } catch (Exception e3) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f5869c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e3);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class f<T> implements q1.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o1.f f5871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f5872b;

        f(o1.f fVar, Type type) {
            this.f5871a = fVar;
            this.f5872b = type;
        }

        @Override // q1.i
        public T a() {
            return (T) this.f5871a.a(this.f5872b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class g<T> implements q1.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o1.f f5874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f5875b;

        g(o1.f fVar, Type type) {
            this.f5874a = fVar;
            this.f5875b = type;
        }

        @Override // q1.i
        public T a() {
            return (T) this.f5874a.a(this.f5875b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class h<T> implements q1.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f5877a;

        h(Constructor constructor) {
            this.f5877a = constructor;
        }

        @Override // q1.i
        public T a() {
            try {
                return (T) this.f5877a.newInstance(null);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Failed to invoke " + this.f5877a + " with no args", e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke " + this.f5877a + " with no args", e5.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class i<T> implements q1.i<T> {
        i() {
        }

        @Override // q1.i
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class j<T> implements q1.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f5880a;

        j(Type type) {
            this.f5880a = type;
        }

        @Override // q1.i
        public T a() {
            Type type = this.f5880a;
            if (!(type instanceof ParameterizedType)) {
                throw new o1.k("Invalid EnumSet type: " + this.f5880a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new o1.k("Invalid EnumSet type: " + this.f5880a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class k<T> implements q1.i<T> {
        k() {
        }

        @Override // q1.i
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class l<T> implements q1.i<T> {
        l() {
        }

        @Override // q1.i
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class m<T> implements q1.i<T> {
        m() {
        }

        @Override // q1.i
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ConstructorConstructor.java */
    class n<T> implements q1.i<T> {
        n() {
        }

        @Override // q1.i
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, o1.f<?>> map) {
        this.f5861a = map;
    }

    private <T> q1.i<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f5862b.b(declaredConstructor);
            }
            return new h(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> q1.i<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i();
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k();
            }
            return Queue.class.isAssignableFrom(cls) ? new l() : new m();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new n();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new a();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new b();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(v1.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new d() : new C0084c();
    }

    private <T> q1.i<T> d(Type type, Class<? super T> cls) {
        return new e(cls, type);
    }

    public <T> q1.i<T> a(v1.a<T> aVar) {
        Type typeE = aVar.e();
        Class<? super T> clsC = aVar.c();
        o1.f<?> fVar = this.f5861a.get(typeE);
        if (fVar != null) {
            return new f(fVar, typeE);
        }
        o1.f<?> fVar2 = this.f5861a.get(clsC);
        if (fVar2 != null) {
            return new g(fVar2, typeE);
        }
        q1.i<T> iVarB = b(clsC);
        if (iVarB != null) {
            return iVarB;
        }
        q1.i<T> iVarC = c(typeE, clsC);
        return iVarC != null ? iVarC : d(typeE, clsC);
    }

    public String toString() {
        return this.f5861a.toString();
    }
}
