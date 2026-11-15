package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClassesInfoCache.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static a f1544c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, C0009a> f1545a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f1546b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    static class C0009a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<d.a, List<b>> f1547a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<b, d.a> f1548b;

        C0009a(Map<b, d.a> map) {
            this.f1548b = map;
            for (Map.Entry<b, d.a> entry : map.entrySet()) {
                d.a value = entry.getValue();
                List<b> arrayList = this.f1547a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f1547a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void b(List<b> list, g gVar, d.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(gVar, aVar, obj);
                }
            }
        }

        void a(g gVar, d.a aVar, Object obj) {
            b(this.f1547a.get(aVar), gVar, aVar, obj);
            b(this.f1547a.get(d.a.ON_ANY), gVar, aVar, obj);
        }
    }

    /* JADX INFO: compiled from: ClassesInfoCache.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f1550b;

        b(int i3, Method method) {
            this.f1549a = i3;
            this.f1550b = method;
            method.setAccessible(true);
        }

        void a(g gVar, d.a aVar, Object obj) {
            try {
                int i3 = this.f1549a;
                if (i3 == 0) {
                    this.f1550b.invoke(obj, new Object[0]);
                } else if (i3 == 1) {
                    this.f1550b.invoke(obj, gVar);
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    this.f1550b.invoke(obj, gVar, aVar);
                }
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to call observer method", e4.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1549a == bVar.f1549a && this.f1550b.getName().equals(bVar.f1550b.getName());
        }

        public int hashCode() {
            return (this.f1549a * 31) + this.f1550b.getName().hashCode();
        }
    }

    a() {
    }

    private C0009a a(Class<?> cls, Method[] methodArr) {
        int i3;
        C0009a c0009aC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (c0009aC = c(superclass)) != null) {
            map.putAll(c0009aC.f1548b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, d.a> entry : c(cls2).f1548b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i3 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(g.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i3 = 1;
                }
                d.a aVarValue = nVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != d.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i3 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new b(i3, method), aVarValue, cls);
                z2 = true;
            }
        }
        C0009a c0009a = new C0009a(map);
        this.f1545a.put(cls, c0009a);
        this.f1546b.put(cls, Boolean.valueOf(z2));
        return c0009a;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e3) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
        }
    }

    private void e(Map<b, d.a> map, b bVar, d.a aVar, Class<?> cls) {
        d.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f1550b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    C0009a c(Class<?> cls) {
        C0009a c0009a = this.f1545a.get(cls);
        return c0009a != null ? c0009a : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f1546b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((n) method.getAnnotation(n.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f1546b.put(cls, Boolean.FALSE);
        return false;
    }
}
