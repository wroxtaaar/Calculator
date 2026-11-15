package v2;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: VivoSlipBackInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PathInterpolator f6318a;

    public b() {
        a();
    }

    private void a() {
        if (f6318a == null) {
            f6318a = new PathInterpolator(a.b(new PointF(0.28f, 0.85f), new PointF(0.36f, 1.0f)));
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        return f6318a.getInterpolation(f3);
    }
}
