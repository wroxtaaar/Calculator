package y2;

import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: compiled from: Complex.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f6500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f6501b;

    public e() {
    }

    private final e C() {
        if (!Double.isInfinite(this.f6501b)) {
            this.f6501b = 0.0d;
        } else if (!Double.isInfinite(this.f6500a)) {
            this.f6500a = 0.0d;
        }
        return this;
    }

    private final e K() {
        double d3 = this.f6500a;
        double d4 = 1.0d - (d3 * d3);
        double d5 = this.f6501b;
        return F(d4 + (d5 * d5), d3 * (-2.0d) * d5).J();
    }

    private final e N() {
        return F(this.f6501b, this.f6500a);
    }

    public final e A(e eVar) {
        double d3 = this.f6500a;
        double d4 = this.f6501b;
        double d5 = eVar.f6500a;
        double d6 = eVar.f6501b;
        if (d4 == 0.0d && d6 == 0.0d) {
            return F(d3 * d5, 0.0d);
        }
        double d7 = (d3 * d5) - (d4 * d6);
        double d8 = (d3 * d6) + (d4 * d5);
        if (!F(d7, d8).v()) {
            return this;
        }
        if (F(d3, d4).u()) {
            C();
            d3 = this.f6500a;
            d4 = this.f6501b;
        }
        if (eVar.u()) {
            F(d5, d6).C();
            d5 = this.f6500a;
            d6 = this.f6501b;
        }
        if (d4 == 0.0d) {
            if (d6 == 0.0d) {
                return F(d3 * d5, 0.0d);
            }
            return d5 == 0.0d ? F(0.0d, d3 * d6) : F(d5 * d3, d3 * d6);
        }
        if (d3 == 0.0d) {
            if (d5 == 0.0d) {
                return F((-d4) * d6, 0.0d);
            }
            return d6 == 0.0d ? F(0.0d, d4 * d5) : F((-d4) * d6, d4 * d5);
        }
        if (d6 == 0.0d) {
            return F(d3 * d5, d4 * d5);
        }
        return d5 == 0.0d ? F((-d4) * d6, d3 * d6) : F(d7, d8);
    }

    public final e B() {
        return F(-this.f6500a, -this.f6501b);
    }

    public final e D(e eVar) {
        double d3 = this.f6501b;
        if (d3 == 0.0d && eVar.f6501b == 0.0d) {
            return F(r.j(this.f6500a, eVar.f6500a), 0.0d);
        }
        double d4 = this.f6500a;
        w();
        double d5 = this.f6500a;
        double d6 = this.f6501b;
        F(d4 - eVar.f6500a, d3 - eVar.f6501b).w();
        return F(d5 - this.f6500a, d6 - this.f6501b).q();
    }

    public final e E(e eVar) {
        if (eVar.f6501b != 0.0d) {
            if (this.f6501b == 0.0d) {
                double d3 = this.f6500a;
                if (d3 > 0.0d) {
                    double dPow = Math.pow(d3, eVar.f6500a);
                    return F(0.0d, eVar.f6501b * Math.log(this.f6500a)).q().F(this.f6500a * dPow, dPow * this.f6501b);
                }
            }
            e eVarX = x();
            double d4 = eVar.f6500a;
            double d5 = this.f6500a;
            double d6 = eVar.f6501b;
            double d7 = this.f6501b;
            return eVarX.F((d4 * d5) - (d6 * d7), (d4 * d7) + (d6 * d5)).q();
        }
        double d8 = eVar.f6500a;
        if (d8 == 0.0d) {
            return F(1.0d, 0.0d);
        }
        if (this.f6501b == 0.0d) {
            double dPow2 = Math.pow(this.f6500a, d8);
            if (dPow2 == dPow2) {
                return F(dPow2, 0.0d);
            }
        }
        double d9 = eVar.f6500a;
        if (d9 == 2.0d) {
            return L();
        }
        if (d9 == 0.5d) {
            return J();
        }
        double dPow3 = Math.pow(b(), eVar.f6500a / 2.0d);
        double dF = f() * eVar.f6500a;
        return F(r.e(dF) * dPow3, dPow3 * r.k(dF));
    }

    public e F(double d3, double d4) {
        this.f6500a = d3;
        this.f6501b = d4;
        return this;
    }

    public e G(e eVar) {
        this.f6500a = eVar.f6500a;
        this.f6501b = eVar.f6501b;
        return this;
    }

    public final e H() {
        double dK;
        double dE = 0.0d;
        if (this.f6501b == 0.0d) {
            dK = r.k(this.f6500a);
        } else {
            dK = r.k(this.f6500a) * Math.cosh(this.f6501b);
            dE = r.e(this.f6500a) * Math.sinh(this.f6501b);
        }
        return F(dK, dE);
    }

    public final e I() {
        return this.f6501b == 0.0d ? F(Math.sinh(this.f6500a), 0.0d) : N().H().N();
    }

    public final e J() {
        if (this.f6501b == 0.0d) {
            double d3 = this.f6500a;
            if (d3 >= 0.0d) {
                F(Math.sqrt(d3), 0.0d);
            } else {
                F(0.0d, Math.sqrt(-d3));
            }
        } else {
            double dSqrt = Math.sqrt((Math.abs(this.f6500a) + a()) / 2.0d);
            if (this.f6500a >= 0.0d) {
                F(dSqrt, this.f6501b / (dSqrt + dSqrt));
            } else {
                double dAbs = Math.abs(this.f6501b) / (dSqrt + dSqrt);
                if (this.f6501b < 0.0d) {
                    dSqrt = -dSqrt;
                }
                F(dAbs, dSqrt);
            }
        }
        return this;
    }

    public final e L() {
        double d3 = this.f6500a;
        double d4 = this.f6501b;
        return F((d3 * d3) - (d4 * d4), d3 * 2.0d * d4);
    }

    public final e M(e eVar) {
        double dUlp = Math.ulp(this.f6500a);
        double d3 = this.f6500a - eVar.f6500a;
        this.f6500a = d3;
        this.f6501b -= eVar.f6501b;
        if (Math.abs(d3) < dUlp * 1024.0d) {
            this.f6500a = 0.0d;
        }
        return this;
    }

    public final e O() {
        double d3 = this.f6501b;
        if (d3 == 0.0d) {
            return F(r.l(this.f6500a), 0.0d);
        }
        double d4 = this.f6500a;
        double d5 = d4 + d4;
        double d6 = d3 + d3;
        double dE = r.e(d5) + Math.cosh(d6);
        return F(r.k(d5) / dE, Math.sinh(d6) / dE);
    }

    public final e P() {
        return this.f6501b == 0.0d ? F(Math.tanh(this.f6500a), 0.0d) : N().O().N();
    }

    public final double a() {
        double dAbs = Math.abs(this.f6500a);
        double dAbs2 = Math.abs(this.f6501b);
        if (dAbs == 0.0d || dAbs2 == 0.0d) {
            return dAbs + dAbs2;
        }
        boolean z2 = dAbs > dAbs2;
        double d3 = z2 ? dAbs2 / dAbs : dAbs / dAbs2;
        if (!z2) {
            dAbs = dAbs2;
        }
        return dAbs * Math.sqrt((d3 * d3) + 1.0d);
    }

    public final double b() {
        double d3 = this.f6500a;
        double d4 = this.f6501b;
        return (d3 * d3) + (d4 * d4);
    }

    public final e c() {
        if (this.f6501b == 0.0d && Math.abs(this.f6500a) <= 1.0d) {
            return F(Math.acos(this.f6500a), 0.0d);
        }
        return K().F(this.f6500a - this.f6501b, this.f6501b + this.f6500a).x().F(this.f6501b, -this.f6500a);
    }

    public final e d() {
        double d3 = this.f6501b;
        if (d3 == 0.0d) {
            double d4 = this.f6500a;
            if (d4 >= 1.0d) {
                return F(r.a(d4), 0.0d);
            }
        }
        double d5 = this.f6500a;
        return F(((d5 * d5) - (d3 * d3)) - 1.0d, 2.0d * d5 * d3).J().F(this.f6500a + d5, this.f6501b + d3).x();
    }

    public final e e(e eVar) {
        double dUlp = Math.ulp(this.f6500a);
        double d3 = this.f6500a + eVar.f6500a;
        this.f6500a = d3;
        this.f6501b += eVar.f6501b;
        if (Math.abs(d3) < dUlp * 1024.0d) {
            this.f6500a = 0.0d;
        }
        return this;
    }

    public final double f() {
        return Math.atan2(this.f6501b, this.f6500a);
    }

    public double g() {
        if (this.f6501b == 0.0d) {
            return this.f6500a;
        }
        return Double.NaN;
    }

    public final e h() {
        if (this.f6501b == 0.0d && Math.abs(this.f6500a) <= 1.0d) {
            return F(Math.asin(this.f6500a), 0.0d);
        }
        double d3 = this.f6500a;
        return K().F(this.f6500a - this.f6501b, this.f6501b + d3).x().F(this.f6501b, -this.f6500a);
    }

    public final e i() {
        double d3 = this.f6501b;
        if (d3 == 0.0d) {
            return F(r.b(this.f6500a), 0.0d);
        }
        double d4 = this.f6500a;
        return F(((d4 * d4) - (d3 * d3)) + 1.0d, 2.0d * d4 * d3).J().F(this.f6500a + d4, this.f6501b + d3).x();
    }

    public final e j() {
        double d3 = this.f6501b;
        if (d3 == 0.0d) {
            return F(Math.atan(this.f6500a), 0.0d);
        }
        double d4 = this.f6500a;
        double d5 = (d4 * d4) + (d3 * d3);
        double d6 = ((d5 - d3) - d3) + 1.0d;
        return F((-(d5 - 1.0d)) / d6, (-(d4 + d4)) / d6).x().F((-this.f6501b) / 2.0d, this.f6500a / 2.0d);
    }

    public final e k() {
        double d3 = this.f6501b;
        if (d3 == 0.0d) {
            return F(r.c(this.f6500a), 0.0d);
        }
        double d4 = this.f6500a;
        double d5 = d4 * d4;
        double d6 = ((d5 + 1.0d) - d4) - d4;
        return F(((1.0d - d5) - (d3 * d3)) / d6, (d3 + d3) / d6).x().F(this.f6500a / 2.0d, this.f6501b / 2.0d);
    }

    public final e l(e eVar) {
        double d3 = this.f6501b;
        if (d3 == 0.0d && eVar.f6501b == 0.0d) {
            return F(r.d(this.f6500a, eVar.f6500a), 0.0d);
        }
        double d4 = this.f6500a;
        w();
        double d5 = this.f6500a;
        double d6 = this.f6501b;
        G(eVar).w();
        double d7 = this.f6500a;
        double d8 = this.f6501b;
        F(d4 - eVar.f6500a, d3 - eVar.f6501b).w();
        return F((d5 - d7) - this.f6500a, (d6 - d8) - this.f6501b).q();
    }

    public final e m() {
        return F(this.f6500a, -this.f6501b);
    }

    public final e n() {
        double dE;
        double dSinh = 0.0d;
        if (this.f6501b == 0.0d) {
            dE = r.e(this.f6500a);
        } else {
            dE = r.e(this.f6500a) * Math.cosh(this.f6501b);
            dSinh = (-r.k(this.f6500a)) * Math.sinh(this.f6501b);
        }
        return F(dE, dSinh);
    }

    public final e o() {
        return this.f6501b == 0.0d ? F(Math.cosh(this.f6500a), 0.0d) : N().n().m();
    }

    public final e p(e eVar) {
        double d3 = eVar.f6500a;
        double d4 = eVar.f6501b;
        if (this.f6501b == 0.0d && d4 == 0.0d) {
            return F(this.f6500a / d3, 0.0d);
        }
        if (eVar.u() && t()) {
            return F(0.0d, 0.0d);
        }
        if (d4 == 0.0d) {
            double d5 = this.f6500a;
            return d5 == 0.0d ? F(0.0d, this.f6501b / d3) : F(d5 / d3, this.f6501b / d3);
        }
        if (d3 == 0.0d) {
            return F(this.f6501b / d4, (-this.f6500a) / d4);
        }
        if (Math.abs(d3) > Math.abs(d4)) {
            double d6 = d4 / d3;
            double d7 = d3 + (d4 * d6);
            double d8 = this.f6500a;
            double d9 = this.f6501b;
            return F(((d9 * d6) + d8) / d7, (d9 - (d8 * d6)) / d7);
        }
        double d10 = d3 / d4;
        double d11 = (d3 * d10) + d4;
        double d12 = this.f6500a;
        double d13 = this.f6501b;
        return F(((d12 * d10) + d13) / d11, ((d13 * d10) - d12) / d11);
    }

    public final e q() {
        double dExp = Math.exp(this.f6500a);
        double d3 = this.f6501b;
        return d3 == 0.0d ? F(dExp, 0.0d) : F(r.e(d3) * dExp, dExp * r.k(this.f6501b));
    }

    public final e r() {
        return this.f6501b == 0.0d ? F(r.f(this.f6500a), 0.0d) : w().q();
    }

    public final e s(e eVar) {
        if (this.f6501b == 0.0d && eVar.f6501b == 0.0d) {
            return F(r.g(this.f6500a, eVar.f6500a), 0.0d);
        }
        e eVar2 = new e(eVar);
        double dB = b();
        for (double dB2 = eVar2.b(); dB < 1.0E30d * dB2; dB2 = eVar2.b()) {
            double d3 = eVar2.f6500a;
            double d4 = eVar2.f6501b;
            eVar2.G(y(eVar2));
            F(d3, d4);
            dB = dB2;
        }
        if (Math.abs(this.f6500a) < Math.abs(this.f6501b)) {
            F(-this.f6501b, this.f6500a);
        }
        if (this.f6500a < 0.0d) {
            B();
        }
        return this;
    }

    public final boolean t() {
        return (u() || v()) ? false : true;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f6501b == 0.0d) {
            sb = new StringBuilder();
            sb.append(BuildConfig.FLAVOR);
            sb.append(this.f6500a);
        } else {
            sb = new StringBuilder();
            sb.append("(");
            sb.append(this.f6500a);
            sb.append(", ");
            sb.append(this.f6501b);
            sb.append(')');
        }
        return sb.toString();
    }

    public final boolean u() {
        return Double.isInfinite(this.f6500a) || (Double.isInfinite(this.f6501b) && !v());
    }

    public final boolean v() {
        return Double.isNaN(this.f6500a) || Double.isNaN(this.f6501b);
    }

    public final e w() {
        double d3 = this.f6500a;
        double d4 = this.f6501b;
        double d5 = (d3 * d3) + (d4 * d4);
        double d6 = 0.9999999999999971d;
        double d7 = 0.0d;
        for (double d8 : r.f6553a) {
            d3 += 1.0d;
            d5 += (d3 + d3) - 1.0d;
            d6 += (d8 * d3) / d5;
            d7 -= (d8 * this.f6501b) / d5;
        }
        double d9 = this.f6500a;
        double d10 = 0.5d + d9;
        double d11 = d9 + 5.2421875d;
        double d12 = this.f6501b;
        this.f6500a = d11;
        x();
        double d13 = this.f6500a;
        double d14 = this.f6501b;
        F(d6, d7).x();
        this.f6500a += (((d10 * d13) - (d12 * d14)) + 0.9189385332046728d) - d11;
        this.f6501b += ((d10 * d14) + (d13 * d12)) - d12;
        return this;
    }

    public final e x() {
        double d3 = this.f6501b;
        if (d3 == 0.0d) {
            double d4 = this.f6500a;
            if (d4 >= 0.0d) {
                return F(Math.log(d4), 0.0d);
            }
        }
        return F(Math.log(a()), Math.atan2(d3, this.f6500a));
    }

    public final e y(e eVar) {
        double d3 = this.f6500a;
        double d4 = this.f6501b;
        return (d4 == 0.0d && eVar.f6501b == 0.0d) ? F(d3 % eVar.f6500a, 0.0d) : p(eVar).F(Math.rint(this.f6500a), Math.rint(this.f6501b)).A(eVar).F(d3 - this.f6500a, d4 - this.f6501b);
    }

    e z(double d3) {
        this.f6500a *= d3;
        this.f6501b *= d3;
        return this;
    }

    public e(double d3, double d4) {
        F(d3, d4);
    }

    public e(e eVar) {
        G(eVar);
    }
}
