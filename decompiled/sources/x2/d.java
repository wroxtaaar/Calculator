package x2;

import android.content.Context;
import android.os.Vibrator;
import android.provider.Settings;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VibratorHelp.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f6476c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Vibrator f6478b;

    public d(Context context) {
        this.f6477a = context;
        this.f6478b = (Vibrator) context.getSystemService("vibrator");
        f6476c = "1".equals(c.b("persist.vivo.support.lra", "0"));
    }

    public void a() {
        if (!f6476c || this.f6478b == null || Settings.System.getInt(this.f6477a.getContentResolver(), "haptic_feedback_enabled", -1) == 0) {
            return;
        }
        Class<?> cls = this.f6478b.getClass();
        try {
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("vibratorPro", cls2, Long.TYPE, cls2);
            if (declaredMethod != null) {
                ((Long) declaredMethod.invoke(this.f6478b, 112, -1, -1)).longValue();
            }
        } catch (Exception unused) {
        }
    }
}
