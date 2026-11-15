package c0;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: ICUCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f2464b;

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            if (i3 < 24) {
                try {
                    f2464b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e3) {
                    throw new IllegalStateException(e3);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            f2463a = cls.getMethod("getScript", String.class);
            f2464b = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e4) {
            f2463a = null;
            f2464b = null;
            Log.w("ICUCompat", e4);
        }
    }

    private static String a(Locale locale) {
        String string = locale.toString();
        try {
            Method method = f2464b;
            if (method != null) {
                return (String) method.invoke(null, string);
            }
        } catch (IllegalAccessException e3) {
            Log.w("ICUCompat", e3);
        } catch (InvocationTargetException e4) {
            Log.w("ICUCompat", e4);
        }
        return string;
    }

    private static String b(String str) {
        try {
            Method method = f2463a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e3) {
            Log.w("ICUCompat", e3);
        } catch (InvocationTargetException e4) {
            Log.w("ICUCompat", e4);
        }
        return null;
    }

    public static String c(Locale locale) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i3 < 21) {
            String strA = a(locale);
            if (strA != null) {
                return b(strA);
            }
            return null;
        }
        try {
            return ((Locale) f2464b.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e3) {
            Log.w("ICUCompat", e3);
            return locale.getScript();
        } catch (InvocationTargetException e4) {
            Log.w("ICUCompat", e4);
            return locale.getScript();
        }
    }
}
