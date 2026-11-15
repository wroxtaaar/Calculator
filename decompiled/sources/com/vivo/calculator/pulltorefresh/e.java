package com.vivo.calculator.pulltorefresh;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.AnimationUtils;

/* JADX INFO: compiled from: PathScroller.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f4189f;

    /* JADX INFO: compiled from: PathScroller.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float[] f4190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float[] f4191b;

        public a(Path path) {
            AnimationUtils.currentAnimationTimeMillis();
            PathMeasure pathMeasure = new PathMeasure(path, false);
            float length = pathMeasure.getLength();
            int i3 = ((int) (length / 0.002f)) + 1;
            this.f4190a = new float[i3];
            this.f4191b = new float[i3];
            float[] fArr = new float[2];
            for (int i4 = 0; i4 < i3; i4++) {
                pathMeasure.getPosTan((i4 * length) / (i3 - 1), fArr, null);
                this.f4190a[i4] = fArr[0];
                this.f4191b[i4] = fArr[1];
            }
            AnimationUtils.currentAnimationTimeMillis();
        }

        float a(float f3) {
            int i3 = 0;
            if (f3 <= 0.0f) {
                return this.f4191b[0];
            }
            if (f3 >= 1.0f) {
                float[] fArr = this.f4191b;
                return fArr[fArr.length - 1];
            }
            int length = this.f4190a.length - 1;
            while (length - i3 > 1) {
                int i4 = (i3 + length) / 2;
                if (f3 < this.f4190a[i4]) {
                    length = i4;
                } else {
                    i3 = i4;
                }
            }
            float[] fArr2 = this.f4190a;
            float f4 = fArr2[length] - fArr2[i3];
            if (f4 == 0.0f) {
                return this.f4191b[i3];
            }
            float f5 = (f3 - fArr2[i3]) / f4;
            float[] fArr3 = this.f4191b;
            float f6 = fArr3[i3];
            return f6 + (f5 * (fArr3[length] - f6));
        }
    }

    public boolean a() {
        if (this.f4186c) {
            return false;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f4184a;
        float f3 = 1.0f;
        int i3 = this.f4185b;
        float f4 = (jCurrentAnimationTimeMillis * 1.0f) / i3;
        if (jCurrentAnimationTimeMillis >= i3) {
            this.f4186c = true;
        } else {
            f3 = f4;
        }
        this.f4187d = Math.round(this.f4188e * this.f4189f.a(f3));
        return true;
    }

    public int b() {
        return this.f4187d;
    }

    public void c(float f3, int i3, a aVar) {
        this.f4188e = f3;
        this.f4185b = i3;
        this.f4186c = false;
        this.f4189f = aVar;
        this.f4184a = AnimationUtils.currentAnimationTimeMillis();
    }
}
