package w;

import android.graphics.Color;

/* JADX INFO: compiled from: ColorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<double[]> f6319a = new ThreadLocal<>();

    public static void a(int i3, int i4, int i5, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d3 = ((double) i3) / 255.0d;
        double dPow = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double d4 = ((double) i4) / 255.0d;
        double dPow2 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        double d5 = ((double) i5) / 255.0d;
        double dPow3 = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * 100.0d;
    }

    public static double b(int i3) {
        double[] dArrG = g();
        c(i3, dArrG);
        return dArrG[1] / 100.0d;
    }

    public static void c(int i3, double[] dArr) {
        a(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    private static int d(int i3, int i4) {
        return 255 - (((255 - i4) * (255 - i3)) / 255);
    }

    public static int e(int i3, int i4) {
        int iAlpha = Color.alpha(i4);
        int iAlpha2 = Color.alpha(i3);
        int iD = d(iAlpha2, iAlpha);
        return Color.argb(iD, f(Color.red(i3), iAlpha2, Color.red(i4), iAlpha, iD), f(Color.green(i3), iAlpha2, Color.green(i4), iAlpha, iD), f(Color.blue(i3), iAlpha2, Color.blue(i4), iAlpha, iD));
    }

    private static int f(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        return (((i3 * 255) * i4) + ((i5 * i6) * (255 - i4))) / (i7 * 255);
    }

    private static double[] g() {
        ThreadLocal<double[]> threadLocal = f6319a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int h(int i3, int i4) {
        if (i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i3 & 16777215) | (i4 << 24);
    }
}
