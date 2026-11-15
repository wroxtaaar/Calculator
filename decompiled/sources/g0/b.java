package g0;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: PathInterpolatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static Interpolator a(float f3, float f4, float f5, float f6) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(f3, f4, f5, f6) : new a(f3, f4, f5, f6);
    }

    public static Interpolator b(Path path) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(path) : new a(path);
    }
}
