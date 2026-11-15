package r2;

import android.content.Context;
import android.view.WindowManager;

/* JADX INFO: compiled from: VivoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static int b(Context context) {
        float refreshRate = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
        a.a("getRefreshRate", "rate=" + refreshRate);
        if (refreshRate >= 20.0f && refreshRate < 59.0f) {
            return 30;
        }
        if (refreshRate >= 59.0f && refreshRate < 65.0f) {
            return 60;
        }
        if (refreshRate >= 65.0f && refreshRate < 90.0f) {
            return 72;
        }
        if (refreshRate >= 90.0f && refreshRate < 120.0f) {
            return 90;
        }
        if (refreshRate >= 120.0f && refreshRate < 140.0f) {
            return 120;
        }
        if (refreshRate < 140.0f || refreshRate >= 150.0f) {
            return (int) refreshRate;
        }
        return 144;
    }
}
