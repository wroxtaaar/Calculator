package l2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ReflectUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static Object a(Class cls, String str, Object obj, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            f(th);
            return null;
        }
    }

    public static Object b(String str) {
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Throwable th) {
            f(th);
            return null;
        }
    }

    public static Object c(String str, Object obj, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            f(th);
            return null;
        }
    }

    public static Object d(String str, String str2, Object obj, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            f(th);
            return null;
        }
    }

    public static Object e(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Throwable th) {
            f(th);
            return null;
        }
    }

    private static void f(Throwable th) {
        if ((th instanceof InvocationTargetException) && (th = th.getCause()) == null) {
            return;
        }
        if ((th instanceof NoSuchMethodException) || (th instanceof NoSuchFieldException)) {
            i.k("SecurityKey", th.toString());
            return;
        }
        i.e("SecurityKey", "Error: " + th.getMessage(), th);
    }
}
