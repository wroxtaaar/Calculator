package r2;

import android.os.Build;
import android.util.Log;

/* JADX INFO: compiled from: LogKit.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f6173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f6174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f6175d;

    static {
        boolean zEquals = b.a("persist.debug.springkit", "false").equals("true");
        f6172a = zEquals;
        String str = Build.TYPE;
        boolean z2 = true;
        boolean z3 = str.equals("eng") || str.equals("branddebug");
        f6173b = z3;
        f6174c = false;
        f6175d = false;
        try {
            boolean zEquals2 = b.a("persist.sys.log.ctrl", "no").equals("yes");
            f6174c = zEquals2;
            if (!z3 && (!zEquals2 || !zEquals)) {
                z2 = false;
            }
            f6175d = z2;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        if (f6175d) {
            Log.v("SpringKit-" + str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f6175d) {
            Log.e("SpringKit-" + str, str2);
        }
    }
}
