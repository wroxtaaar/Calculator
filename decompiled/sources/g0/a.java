package g0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: PathInterpolatorApi14.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f4754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f4755b;

    a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i3 = ((int) (length / 0.002f)) + 1;
        this.f4754a = new float[i3];
        this.f4755b = new float[i3];
        float[] fArr = new float[2];
        for (int i4 = 0; i4 < i3; i4++) {
            pathMeasure.getPosTan((i4 * length) / (i3 - 1), fArr, null);
            this.f4754a[i4] = fArr[0];
            this.f4755b[i4] = fArr[1];
        }
    }

    private static Path a(float f3, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f3, f4, f5, f6, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        int i3 = 0;
        int length = this.f4754a.length - 1;
        while (length - i3 > 1) {
            int i4 = (i3 + length) / 2;
            if (f3 < this.f4754a[i4]) {
                length = i4;
            } else {
                i3 = i4;
            }
        }
        float[] fArr = this.f4754a;
        float f4 = fArr[length] - fArr[i3];
        if (f4 == 0.0f) {
            return this.f4755b[i3];
        }
        float f5 = (f3 - fArr[i3]) / f4;
        float[] fArr2 = this.f4755b;
        float f6 = fArr2[i3];
        return f6 + (f5 * (fArr2[length] - f6));
    }

    a(float f3, float f4, float f5, float f6) {
        this(a(f3, f4, f5, f6));
    }
}
