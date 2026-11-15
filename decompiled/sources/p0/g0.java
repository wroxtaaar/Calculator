package p0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi23.java */
/* JADX INFO: loaded from: classes.dex */
class g0 extends f0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f5647i = true;

    g0() {
    }

    @Override // p0.i0
    @SuppressLint({"NewApi"})
    public void g(View view, int i3) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i3);
        } else if (f5647i) {
            try {
                view.setTransitionVisibility(i3);
            } catch (NoSuchMethodError unused) {
                f5647i = false;
            }
        }
    }
}
