package p0;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi21.java */
/* JADX INFO: loaded from: classes.dex */
class e0 extends d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f5644f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f5645g = true;

    e0() {
    }

    @Override // p0.i0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f5644f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f5644f = false;
            }
        }
    }

    @Override // p0.i0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f5645g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f5645g = false;
            }
        }
    }
}
