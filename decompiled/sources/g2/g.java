package g2;

import android.os.Build;
import android.os.FtBuild;
import android.text.TextUtils;
import android.view.View;
import java.lang.reflect.Method;
import vivo.util.VLog;

/* JADX INFO: compiled from: ReflectUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static Class<?> a() {
        try {
            return Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e3) {
            VLog.e("BBKCalculator/ReflectUtils", "getSystemPropertiesClass() exception:" + e3.getMessage());
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            return (String) a().getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e3) {
            VLog.e("BBKCalculator/ReflectUtils", "get() exception:" + e3.getMessage());
            return str2;
        }
    }

    public static Object c(Object obj, String str, String str2) {
        try {
            Method method = Class.forName(str).getMethod(str2, new Class[0]);
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return method.invoke(obj, new Object[0]);
        } catch (Exception e3) {
            VLog.e("BBKCalculator/ReflectUtils", "invokeMethodCustom methodName : " + str2, e3);
            return null;
        }
    }

    public static boolean d() {
        String osVersion = FtBuild.getOsVersion();
        if (TextUtils.isEmpty(osVersion)) {
            return false;
        }
        try {
            return FtBuild.getOsName().equals("vos") && Float.parseFloat(osVersion.trim()) >= 5.0f;
        } catch (Exception e3) {
            VLog.e("BBKCalculator/ReflectUtils", "isOsMaxFour,Exception : " + e3);
            return false;
        }
    }

    public static boolean e() {
        String osVersion = FtBuild.getOsVersion();
        if (TextUtils.isEmpty(osVersion)) {
            return false;
        }
        try {
            return FtBuild.getOsName().equals("vos") && Float.parseFloat(osVersion.trim()) >= 4.0f;
        } catch (Exception e3) {
            VLog.e("BBKCalculator/ReflectUtils", "isOsMaxFour,Exception : " + e3);
            return false;
        }
    }

    public static void f(View view, int i3) {
        if (view == null) {
            return;
        }
        Method method = null;
        try {
            method = Class.forName(Build.VERSION.SDK_INT >= 29 ? "android.view.View" : "android.view.VivoBaseView").getMethod("setNightMode", Integer.TYPE);
        } catch (Exception e3) {
            VLog.e("BBKCalculator/ReflectUtils", "setNightMode , getMethod fail e: " + e3.getMessage());
        }
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i3));
            } catch (Exception e4) {
                VLog.e("BBKCalculator/ReflectUtils", "setNightMode,invoke e: " + e4.getMessage());
            }
        }
    }
}
