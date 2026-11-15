package l0;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: LookupTableInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f5267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5268b;

    protected d(float[] fArr) {
        this.f5267a = fArr;
        this.f5268b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f5267a;
        int iMin = Math.min((int) ((fArr.length - 1) * f3), fArr.length - 2);
        float f4 = this.f5268b;
        float f5 = (f3 - (iMin * f4)) / f4;
        float[] fArr2 = this.f5267a;
        return fArr2[iMin] + (f5 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
