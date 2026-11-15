package j2;

import android.content.Context;
import java.util.concurrent.Callable;
import l2.i;

/* JADX INFO: compiled from: SecurityServerHandler.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Callable<Object> {
    public static String a(Context context) {
        String strB = b(context, "ro.product.country.region", "unknown");
        return ("unknown".equals(strB) || "N".equals(strB)) ? b(context, "ro.product.customize.bbk", "unknown") : strB;
    }

    private static String b(Context context, String str, String str2) {
        if (context == null) {
            return str2;
        }
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader == null) {
                return str2;
            }
            Class<?> clsLoadClass = classLoader.loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class, String.class).invoke(clsLoadClass, str, str2);
        } catch (Exception e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            return str2;
        }
    }
}
