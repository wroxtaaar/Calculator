package p0;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi19.java */
/* JADX INFO: loaded from: classes.dex */
class d0 extends i0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f5629e = true;

    d0() {
    }

    @Override // p0.i0
    public void a(View view) {
    }

    @Override // p0.i0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f5629e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f5629e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // p0.i0
    public void d(View view) {
    }

    @Override // p0.i0
    @SuppressLint({"NewApi"})
    public void f(View view, float f3) {
        if (f5629e) {
            try {
                view.setTransitionAlpha(f3);
                return;
            } catch (NoSuchMethodError unused) {
                f5629e = false;
            }
        }
        view.setAlpha(f3);
    }
}
