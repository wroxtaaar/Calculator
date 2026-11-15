package s0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;
import r0.o;

/* JADX INFO: compiled from: Volley.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public static o a(Context context) {
        return c(context, null);
    }

    private static o b(Context context, r0.h hVar) {
        o oVar = new o(new e(new File(context.getCacheDir(), "volley")), hVar);
        oVar.f();
        return oVar;
    }

    public static o c(Context context, b bVar) {
        c cVar;
        c cVar2;
        String str;
        if (bVar == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                cVar2 = new c((b) new j());
            } else {
                try {
                    String packageName = context.getPackageName();
                    str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    str = "volley/0";
                }
                cVar = new c(new f(AndroidHttpClient.newInstance(str)));
            }
            return b(context, cVar2);
        }
        cVar = new c(bVar);
        cVar2 = cVar;
        return b(context, cVar2);
    }
}
