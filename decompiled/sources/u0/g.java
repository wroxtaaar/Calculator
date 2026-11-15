package u0;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: compiled from: MatrixEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f6267a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f6268b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f6269c = new Matrix();

    public Matrix a(float f3, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f6267a);
        matrix2.getValues(this.f6268b);
        for (int i3 = 0; i3 < 9; i3++) {
            float[] fArr = this.f6268b;
            float f4 = fArr[i3];
            float[] fArr2 = this.f6267a;
            fArr[i3] = fArr2[i3] + ((f4 - fArr2[i3]) * f3);
        }
        this.f6269c.setValues(this.f6268b);
        return this.f6269c;
    }
}
