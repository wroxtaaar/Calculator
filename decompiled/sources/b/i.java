package b;

/* JADX INFO: compiled from: TwilightCalculator.java */
/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i f2325d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2328c;

    i() {
    }

    static i b() {
        if (f2325d == null) {
            f2325d = new i();
        }
        return f2325d;
    }

    public void a(long j3, double d3, double d4) {
        float f3 = (j3 - 946728000000L) / 8.64E7f;
        float f4 = (0.01720197f * f3) + 6.24006f;
        double d5 = f4;
        double dSin = (Math.sin(d5) * 0.03341960161924362d) + d5 + (Math.sin(2.0f * f4) * 3.4906598739326E-4d) + (Math.sin(f4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d6 = (-d4) / 360.0d;
        double dRound = ((double) (Math.round(((double) (f3 - 9.0E-4f)) - d6) + 9.0E-4f)) + d6 + (Math.sin(d5) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d7 = 0.01745329238474369d * d3;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d7) * Math.sin(dAsin))) / (Math.cos(d7) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f2328c = 1;
            this.f2326a = -1L;
            this.f2327b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f2328c = 0;
                this.f2326a = -1L;
                this.f2327b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f2326a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.f2327b = jRound;
            if (jRound >= j3 || this.f2326a <= j3) {
                this.f2328c = 1;
            } else {
                this.f2328c = 0;
            }
        }
    }
}
