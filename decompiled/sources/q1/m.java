package q1;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f5926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f5927b;

        a(Method method, Object obj) {
            this.f5926a = method;
            this.f5927b = obj;
        }

        @Override // q1.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.f5926a.invoke(this.f5927b, cls);
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f5928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5929b;

        b(Method method, int i3) {
            this.f5928a = method;
            this.f5929b = i3;
        }

        @Override // q1.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.f5928a.invoke(null, cls, Integer.valueOf(this.f5929b));
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class c extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f5930a;

        c(Method method) {
            this.f5930a = method;
        }

        @Override // q1.m
        public <T> T c(Class<T> cls) throws Exception {
            m.a(cls);
            return (T) this.f5930a.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class d extends m {
        d() {
        }

        @Override // q1.m
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static m b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
