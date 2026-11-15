package p0;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi22.java */
/* JADX INFO: loaded from: classes.dex */
class f0 extends e0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f5646h = true;

    f0() {
    }

    @Override // p0.i0
    @SuppressLint({"NewApi"})
    public void e(View view, int i3, int i4, int i5, int i6) {
        if (f5646h) {
            try {
                view.setLeftTopRightBottom(i3, i4, i5, i6);
            } catch (NoSuchMethodError unused) {
                f5646h = false;
            }
        }
    }
}
