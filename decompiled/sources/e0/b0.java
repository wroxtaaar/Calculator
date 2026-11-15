package e0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: WindowCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: compiled from: WindowCompat.java */
    private static class a {
        static void a(Window window, boolean z2) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z2 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* JADX INFO: compiled from: WindowCompat.java */
    private static class b {
        static d0 a(Window window) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                return d0.c(insetsController);
            }
            return null;
        }

        static void b(Window window, boolean z2) {
            window.setDecorFitsSystemWindows(z2);
        }
    }

    public static d0 a(Window window, View view) {
        return Build.VERSION.SDK_INT >= 30 ? b.a(window) : new d0(window, view);
    }

    public static void b(Window window, boolean z2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            b.b(window, z2);
        } else if (i3 >= 16) {
            a.a(window, z2);
        }
    }
}
