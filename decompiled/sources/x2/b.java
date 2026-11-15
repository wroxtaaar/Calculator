package x2;

/* JADX INFO: compiled from: VMathUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static int a(int i3, int i4, int i5) {
        if (i3 < i4) {
            return i4;
        }
        return i3 > i5 ? i5 : i3;
    }

    public static float b(float f3, float f4, float f5) {
        return f3 + ((f4 - f3) * f5);
    }

    public static float c(float f3, float f4, float f5) {
        return (((((f4 - f3) + 180.0f) % 360.0f) - 180.0f) * f5) + f3;
    }
}
