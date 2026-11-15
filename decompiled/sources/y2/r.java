package y2;

/* JADX INFO: compiled from: MoreMath.java */
/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final double[] f6553a = {57.15623566586292d, -59.59796035547549d, 14.136097974741746d, -0.4919138160976202d, 3.399464998481189E-5d, 4.652362892704858E-5d, -9.837447530487956E-5d, 1.580887032249125E-4d, -2.1026444172410488E-4d, 2.1743961811521265E-4d, -1.643181065367639E-4d, 8.441822398385275E-5d, -2.6190838401581408E-5d, 3.6899182659531625E-6d};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final double[] f6554b = {1.0d, 40320.0d, 2.0922789888E13d, 6.204484017332394E23d, 2.631308369336935E35d, 8.159152832478977E47d, 1.2413915592536073E61d, 7.109985878048635E74d, 1.2688693218588417E89d, 6.1234458376886085E103d, 7.156945704626381E118d, 1.8548264225739844E134d, 9.916779348709496E149d, 1.0299016745145628E166d, 1.974506857221074E182d, 6.689502913449127E198d, 3.856204823625804E215d, 3.659042881952549E232d, 5.5502938327393044E249d, 1.3113358856834524E267d, 4.7147236359920616E284d, 2.5260757449731984E302d};

    public static final double a(double d3) {
        return Math.log((d3 + d3) - (1.0d / (Math.sqrt((d3 * d3) - 1.0d) + d3)));
    }

    public static final double b(double d3) {
        return d3 < 0.0d ? -b(-d3) : Math.log(d3 + d3 + (1.0d / (Math.sqrt((d3 * d3) + 1.0d) + d3)));
    }

    public static final double c(double d3) {
        return d3 < 0.0d ? -c(-d3) : Math.log(((d3 + d3) / (1.0d - d3)) + 1.0d) * 0.5d;
    }

    public static final double d(double d3, double d4) {
        if (d3 < 0.0d || d4 < 0.0d) {
            return Double.NaN;
        }
        if (d3 < d4) {
            return 0.0d;
        }
        if (Math.floor(d3) != d3 || Math.floor(d4) != d4) {
            return Math.exp((i(d3) - i(d4)) - i(d3 - d4));
        }
        double dMin = Math.min(d4, d3 - d4);
        if (d3 <= 170.0d && 12.0d < dMin && dMin <= 170.0d) {
            return (f(d3) / f(dMin)) / f(d3 - dMin);
        }
        double d5 = d3 - dMin;
        double d6 = 1.0d;
        while (dMin > 0.5d && d6 < Double.POSITIVE_INFINITY) {
            d6 *= (d5 + dMin) / dMin;
            dMin -= 1.0d;
        }
        return d6;
    }

    public static final double e(double d3) {
        if (h(d3 - 1.5707963267948966d)) {
            return 0.0d;
        }
        return Math.cos(d3);
    }

    public static final double f(double d3) {
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        if (d3 < 0.0d) {
            return Double.NaN;
        }
        if (d3 <= 170.0d && Math.floor(d3) == d3) {
            int i3 = (int) d3;
            switch (i3 & 7) {
                case 0:
                    return f6554b[i3 >> 3];
                case 1:
                    return f6554b[i3 >> 3] * d3;
                case 2:
                    d4 = d3;
                    d3 *= d4 - 1.0d;
                    return f6554b[i3 >> 3] * d3;
                case 3:
                    d5 = d3;
                    d4 = d5 - 1.0d;
                    d3 *= d4;
                    d3 *= d4 - 1.0d;
                    return f6554b[i3 >> 3] * d3;
                case 4:
                    d6 = d3;
                    d5 = d6 - 1.0d;
                    d3 *= d5;
                    d4 = d5 - 1.0d;
                    d3 *= d4;
                    d3 *= d4 - 1.0d;
                    return f6554b[i3 >> 3] * d3;
                case 5:
                    d7 = d3;
                    d6 = d7 - 1.0d;
                    d3 *= d6;
                    d5 = d6 - 1.0d;
                    d3 *= d5;
                    d4 = d5 - 1.0d;
                    d3 *= d4;
                    d3 *= d4 - 1.0d;
                    return f6554b[i3 >> 3] * d3;
                case 6:
                    d8 = d3;
                    d7 = d8 - 1.0d;
                    d3 *= d7;
                    d6 = d7 - 1.0d;
                    d3 *= d6;
                    d5 = d6 - 1.0d;
                    d3 *= d5;
                    d4 = d5 - 1.0d;
                    d3 *= d4;
                    d3 *= d4 - 1.0d;
                    return f6554b[i3 >> 3] * d3;
                case 7:
                    d8 = d3 - 1.0d;
                    d3 *= d8;
                    d7 = d8 - 1.0d;
                    d3 *= d7;
                    d6 = d7 - 1.0d;
                    d3 *= d6;
                    d5 = d6 - 1.0d;
                    d3 *= d5;
                    d4 = d5 - 1.0d;
                    d3 *= d4;
                    d3 *= d4 - 1.0d;
                    return f6554b[i3 >> 3] * d3;
            }
        }
        return Math.exp(i(d3));
    }

    public static final double g(double d3, double d4) {
        if (Double.isNaN(d3) || Double.isNaN(d4) || Double.isInfinite(d3) || Double.isInfinite(d4)) {
            return Double.NaN;
        }
        double dAbs = Math.abs(d3);
        double dAbs2 = Math.abs(d4);
        while (dAbs < 1.0E15d * dAbs2) {
            double d5 = dAbs % dAbs2;
            dAbs = dAbs2;
            dAbs2 = d5;
        }
        return dAbs;
    }

    private static final boolean h(double d3) {
        double d4 = d3 / 3.141592653589793d;
        return d4 == Math.floor(d4);
    }

    public static final double i(double d3) {
        double d4 = 5.2421875d + d3;
        double d5 = 0.9999999999999971d;
        int i3 = 0;
        while (true) {
            double[] dArr = f6553a;
            if (i3 >= dArr.length) {
                return ((Math.log(d5) + 0.9189385332046728d) + ((d4 - 4.7421875d) * Math.log(d4))) - d4;
            }
            d3 += 1.0d;
            d5 += dArr[i3] / d3;
            i3++;
        }
    }

    public static final double j(double d3, double d4) {
        if (d3 < 0.0d || d4 < 0.0d) {
            return Double.NaN;
        }
        if (d3 < d4) {
            return 0.0d;
        }
        if (Math.floor(d3) != d3 || Math.floor(d4) != d4) {
            return Math.exp(i(d3) - i(d3 - d4));
        }
        if (d3 <= 170.0d && 10.0d < d4 && d4 <= 170.0d) {
            return f(d3) / f(d3 - d4);
        }
        double d5 = (d3 - d4) + 0.5d;
        double d6 = 1.0d;
        while (d3 > d5 && d6 < Double.POSITIVE_INFINITY) {
            d6 *= d3;
            d3 -= 1.0d;
        }
        return d6;
    }

    public static final double k(double d3) {
        if (h(d3)) {
            return 0.0d;
        }
        return Math.sin(d3);
    }

    public static final double l(double d3) {
        if (h(d3)) {
            return 0.0d;
        }
        return Math.tan(d3);
    }
}
