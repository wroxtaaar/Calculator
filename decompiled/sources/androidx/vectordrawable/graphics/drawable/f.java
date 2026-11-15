package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: PathInterpolatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f2143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f2144b;

    public f(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(float f3, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f3, f4, f5, f6, 1.0f, 1.0f);
        b(path);
    }

    private void b(Path path) {
        int i3 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f2143a = new float[iMin];
        this.f2144b = new float[iMin];
        float[] fArr = new float[2];
        for (int i4 = 0; i4 < iMin; i4++) {
            pathMeasure.getPosTan((i4 * length) / (iMin - 1), fArr, null);
            this.f2143a[i4] = fArr[0];
            this.f2144b[i4] = fArr[1];
        }
        if (Math.abs(this.f2143a[0]) <= 1.0E-5d && Math.abs(this.f2144b[0]) <= 1.0E-5d) {
            int i5 = iMin - 1;
            if (Math.abs(this.f2143a[i5] - 1.0f) <= 1.0E-5d && Math.abs(this.f2144b[i5] - 1.0f) <= 1.0E-5d) {
                float f3 = 0.0f;
                int i6 = 0;
                while (i3 < iMin) {
                    float[] fArr2 = this.f2143a;
                    int i7 = i6 + 1;
                    float f4 = fArr2[i6];
                    if (f4 < f3) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f4);
                    }
                    fArr2[i3] = f4;
                    i3++;
                    f3 = f4;
                    i6 = i7;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f2143a[0]);
        sb.append(",");
        sb.append(this.f2144b[0]);
        sb.append(" end:");
        int i8 = iMin - 1;
        sb.append(this.f2143a[i8]);
        sb.append(",");
        sb.append(this.f2144b[i8]);
        throw new IllegalArgumentException(sb.toString());
    }

    private void c(float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f3, f4, 1.0f, 1.0f);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (v.g.r(xmlPullParser, "pathData")) {
            String strM = v.g.m(typedArray, xmlPullParser, "pathData", 4);
            Path pathE = w.c.e(strM);
            if (pathE != null) {
                b(pathE);
                return;
            }
            throw new InflateException("The path is null, which is created from " + strM);
        }
        if (!v.g.r(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!v.g.r(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fJ = v.g.j(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float fJ2 = v.g.j(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zR = v.g.r(xmlPullParser, "controlX2");
        if (zR != v.g.r(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zR) {
            a(fJ, fJ2, v.g.j(typedArray, xmlPullParser, "controlX2", 2, 0.0f), v.g.j(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            c(fJ, fJ2);
        }
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
        int length = this.f2143a.length - 1;
        while (length - i3 > 1) {
            int i4 = (i3 + length) / 2;
            if (f3 < this.f2143a[i4]) {
                length = i4;
            } else {
                i3 = i4;
            }
        }
        float[] fArr = this.f2143a;
        float f4 = fArr[length] - fArr[i3];
        if (f4 == 0.0f) {
            return this.f2144b[i3];
        }
        float f5 = (f3 - fArr[i3]) / f4;
        float[] fArr2 = this.f2144b;
        float f6 = fArr2[i3];
        return f6 + (f5 * (fArr2[length] - f6));
    }

    public f(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, a.f2127l);
        d(typedArrayS, xmlPullParser);
        typedArrayS.recycle();
    }
}
