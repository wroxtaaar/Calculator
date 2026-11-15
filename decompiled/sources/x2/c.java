package x2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VReflectionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f6475a;

    public static Object a(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException | NoSuchFieldException e3) {
            a.a("ReflectionUtils", "error", e3);
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            if (f6475a == null) {
                f6475a = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            }
            return (String) f6475a.invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
