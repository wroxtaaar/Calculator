package p0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ViewGroupUtils.java */
/* JADX INFO: loaded from: classes.dex */
class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5733a = true;

    static w a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new v(viewGroup) : u.g(viewGroup);
    }

    @SuppressLint({"NewApi"})
    private static void b(ViewGroup viewGroup, boolean z2) {
        if (f5733a) {
            try {
                viewGroup.suppressLayout(z2);
            } catch (NoSuchMethodError unused) {
                f5733a = false;
            }
        }
    }

    static void c(ViewGroup viewGroup, boolean z2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            viewGroup.suppressLayout(z2);
        } else if (i3 >= 18) {
            b(viewGroup, z2);
        } else {
            y.b(viewGroup, z2);
        }
    }
}
