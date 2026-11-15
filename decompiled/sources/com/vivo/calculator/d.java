package com.vivo.calculator;

import com.vivo.seckeysdk.BuildConfig;
import java.math.BigInteger;
import vivo.util.VLog;
import z1.g;

/* JADX INFO: compiled from: UnifiedReal.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final d A;
    private static final d B;
    private static final d C;
    private static final d D;
    private static final d E;
    private static final d F;
    private static final d G;
    private static final d H;
    private static final d I;
    private static final d J;
    private static final BigInteger K;
    private static final BigInteger L;
    private static final BigInteger M;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BigInteger f4008c = BigInteger.valueOf(24);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final x1.a f4009d = x1.a.f6449r;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final x1.a f4010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final x1.a f4011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final x1.a f4012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final x1.a f4013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final x1.a f4014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final x1.a f4015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final x1.a f4016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final x1.a f4017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final x1.a f4018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final x1.a f4019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final x1.a[] f4020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final x1.a[] f4021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f4022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f4023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f4024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f4025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f4026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f4027v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f4028w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f4029x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final d f4030y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final d f4031z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z1.a f4032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x1.a f4033b;

    /* JADX INFO: compiled from: UnifiedReal.java */
    public static class a extends ArithmeticException {
        public a() {
            super("Division by zero");
        }
    }

    static {
        x1.a aVar = x1.a.B;
        f4010e = aVar;
        x1.a aVarN = x1.a.f6449r.n();
        f4011f = aVarN;
        x1.a aVarG = x1.a.K(2).G();
        f4012g = aVarG;
        x1.a aVarG2 = x1.a.K(3).G();
        f4013h = aVarG2;
        x1.a aVarS = x1.a.K(2).s();
        f4014i = aVarS;
        x1.a aVarS2 = x1.a.K(3).s();
        f4015j = aVarS2;
        x1.a aVarS3 = x1.a.K(5).s();
        f4016k = aVarS3;
        x1.a aVarS4 = x1.a.K(6).s();
        f4017l = aVarS4;
        x1.a aVarS5 = x1.a.K(7).s();
        f4018m = aVarS5;
        x1.a aVarS6 = x1.a.K(10).s();
        f4019n = aVarS6;
        f4020o = new x1.a[]{null, x1.a.f6449r, aVarG, aVarG2, null, x1.a.K(5).G(), x1.a.K(6).G(), x1.a.K(7).G(), null, null, x1.a.K(10).G()};
        f4021p = new x1.a[]{null, null, aVarS, aVarS2, null, aVarS3, aVarS4, aVarS5, null, null, aVarS6};
        f4022q = new d(aVar);
        f4023r = new d(aVarN);
        f4024s = new d(z1.a.f6616d);
        f4025t = new d(z1.a.f6622j);
        f4026u = new d(z1.a.f6623k);
        f4027v = new d(z1.a.f6624l);
        f4028w = new d(z1.a.f6625m);
        z1.a aVar2 = z1.a.f6617e;
        f4029x = new d(aVar2);
        f4030y = new d(z1.a.f6618f);
        f4031z = new d(z1.a.f6626n);
        A = new d(new z1.a(1L, 180L), aVar);
        B = new d(6L);
        C = new d(aVar2, aVarG);
        D = new d(aVarG2);
        E = new d(aVar2, aVarG2);
        z1.a aVar3 = z1.a.f6619g;
        F = new d(aVar3, aVarG2);
        G = new d(aVar2, aVar);
        H = new d(aVar3, aVar);
        I = new d(z1.a.f6620h, aVar);
        J = new d(z1.a.f6621i, aVar);
        K = BigInteger.valueOf(2L);
        L = BigInteger.valueOf(1000L);
        M = BigInteger.ONE.shiftLeft(1000);
    }

    private d(z1.a aVar, x1.a aVar2) {
        if (aVar == null) {
            throw new ArithmeticException("Building UnifiedReal from null");
        }
        this.f4033b = aVar2;
        this.f4032a = aVar;
    }

    private d B(BigInteger bigInteger) {
        int iU = U(-1000);
        if (iU > 0) {
            return new d(q().s().v(x1.a.L(bigInteger)).n());
        }
        if (iU >= 0) {
            return bigInteger.signum() < 0 ? new d(S(q(), bigInteger.negate()).p()) : new d(S(q(), bigInteger));
        }
        x1.a aVarN = q().w().s().v(x1.a.L(bigInteger)).n();
        if (bigInteger.testBit(0)) {
            aVarN = aVarN.w();
        }
        return new d(aVarN);
    }

    private static BigInteger D(long j3, long j4) {
        if (j3 > 4 * j4) {
            long j5 = 2 * j4;
            BigInteger bigIntegerD = D(j3, j5);
            if (Thread.interrupted()) {
                throw new x1.a.C0099a();
            }
            BigInteger bigIntegerD2 = D(j3 - j4, j5);
            if (Thread.interrupted()) {
                throw new x1.a.C0099a();
            }
            return bigIntegerD.multiply(bigIntegerD2);
        }
        if (j3 == 0) {
            return BigInteger.ONE;
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j3);
        while (true) {
            j3 -= j4;
            if (j3 <= 1) {
                return bigIntegerValueOf;
            }
            bigIntegerValueOf = bigIntegerValueOf.multiply(BigInteger.valueOf(j3));
        }
    }

    private z1.a E(x1.a aVar) {
        int i3 = 0;
        while (true) {
            x1.a[] aVarArr = f4021p;
            if (i3 >= aVarArr.length) {
                return null;
            }
            if (aVarArr[i3] == aVar) {
                return new z1.a(i3);
            }
            i3++;
        }
    }

    private static long F(BigInteger bigInteger, int i3) {
        double dDoubleValue = bigInteger.doubleValue();
        double dLog = Math.log(dDoubleValue) / Math.log(i3);
        if (!Double.isInfinite(dDoubleValue) && Math.abs(dLog - Math.rint(dLog)) > 1.0E-6d) {
            return 0L;
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i3);
        BigInteger bigIntegerValueOf2 = null;
        long j3 = 0;
        while (bigInteger.mod(bigIntegerValueOf).signum() == 0) {
            if (Thread.interrupted()) {
                throw new x1.a.C0099a();
            }
            bigInteger = bigInteger.divide(bigIntegerValueOf);
            j3++;
            if (bigIntegerValueOf2 == null) {
                bigIntegerValueOf2 = BigInteger.valueOf(R(i3));
            }
            while (bigInteger.mod(bigIntegerValueOf2).signum() == 0) {
                bigInteger = bigInteger.divide(bigIntegerValueOf2);
                j3 += 16;
            }
        }
        if (bigInteger.equals(BigInteger.ONE)) {
            return j3;
        }
        return 0L;
    }

    private BigInteger G() {
        BigInteger bigIntegerB;
        if (w()) {
            return BigInteger.ZERO;
        }
        if (this.f4033b != f4010e || (bigIntegerB = z1.a.b(z1.a.j(this.f4032a, z1.a.f6627o))) == null) {
            return null;
        }
        return bigIntegerB.mod(f4008c);
    }

    private static z1.a H(x1.a aVar) {
        int i3 = 0;
        while (true) {
            x1.a[] aVarArr = f4020o;
            if (i3 >= aVarArr.length) {
                return null;
            }
            if (aVarArr[i3] == aVar) {
                return new z1.a(i3);
            }
            i3++;
        }
    }

    private static boolean K(x1.a aVar) {
        if (aVar == f4009d || aVar == f4010e || aVar == f4011f) {
            return true;
        }
        for (x1.a aVar2 : f4020o) {
            if (aVar == aVar2) {
                return true;
            }
        }
        for (x1.a aVar3 : f4021p) {
            if (aVar == aVar3) {
                return true;
            }
        }
        return false;
    }

    private d Q(BigInteger bigInteger) {
        z1.a aVarJ;
        z1.a aVarM;
        BigInteger bigInteger2 = BigInteger.ONE;
        if (bigInteger.equals(bigInteger2)) {
            return this;
        }
        if (bigInteger.signum() == 0) {
            return f4025t;
        }
        BigInteger bigIntegerAbs = bigInteger.abs();
        if (this.f4033b == f4009d && bigIntegerAbs.compareTo(M) <= 0 && (aVarM = this.f4032a.m(bigInteger)) != null) {
            return new d(aVarM);
        }
        if (bigIntegerAbs.compareTo(L) > 0) {
            return B(bigInteger);
        }
        z1.a aVarH = H(this.f4033b);
        if (aVarH == null || (aVarJ = z1.a.j(this.f4032a.m(bigInteger), aVarH.m(bigInteger.shiftRight(1)))) == null) {
            return B(bigInteger);
        }
        return bigInteger.and(bigInteger2).intValue() == 1 ? new d(aVarJ, this.f4033b) : new d(aVarJ);
    }

    private static long R(int i3) {
        if (i3 > 10) {
            throw new AssertionError("Unexpected pow16 argument");
        }
        long j3 = i3 * i3;
        long j4 = j3 * j3;
        long j5 = j4 * j4;
        return j5 * j5;
    }

    private static x1.a S(x1.a aVar, BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ONE;
        if (bigInteger.equals(bigInteger2)) {
            return aVar;
        }
        if (bigInteger.testBit(0)) {
            return aVar.v(S(aVar, bigInteger.subtract(bigInteger2)));
        }
        x1.a aVarS = S(aVar, bigInteger.shiftRight(1));
        if (Thread.interrupted()) {
            throw new x1.a.C0099a();
        }
        return aVarS.v(aVarS);
    }

    private static d W(int i3) {
        if (i3 >= 12) {
            d dVarW = W(i3 - 12);
            if (dVarW == null) {
                return null;
            }
            return dVarW.O();
        }
        if (i3 == 0) {
            return f4024s;
        }
        if (i3 == 6) {
            return f4025t;
        }
        if (i3 == 2) {
            return f4029x;
        }
        if (i3 == 3) {
            return C;
        }
        if (i3 == 4) {
            return E;
        }
        switch (i3) {
            case 8:
                return E;
            case 9:
                return C;
            case 10:
                return f4029x;
            default:
                return null;
        }
    }

    public static d f(int i3) {
        if (i3 < 0) {
            return f(-i3).O();
        }
        if (i3 == 0) {
            return f4024s;
        }
        if (i3 == 1) {
            return new d(z1.a.f6621i, x1.a.B);
        }
        if (i3 == 2) {
            return new d(z1.a.f6617e, x1.a.B);
        }
        throw new AssertionError("asinHalves: Bad argument");
    }

    private static void k(boolean z2) {
        VLog.d("BBKCalculator/UnifiedReal", "check: ");
        if (!z2) {
            throw new AssertionError();
        }
    }

    private void l() {
        d dVar = f4025t;
        if (J(dVar)) {
            if (m(dVar) > 0 || m(f4026u) < 0) {
                throw new ArithmeticException("inverse trig argument out of range");
            }
        }
    }

    private static d p(int i3) {
        int i4 = i3 + 6;
        if (i4 >= 24) {
            i4 -= 24;
        }
        return W(i4);
    }

    private static boolean r(x1.a aVar) {
        return aVar == f4009d || H(aVar) != null;
    }

    private static boolean t(x1.a aVar, x1.a aVar2) {
        x1.a aVar3;
        if (aVar == aVar2) {
            return false;
        }
        x1.a aVar4 = f4011f;
        if (aVar == aVar4 || aVar == (aVar3 = f4010e)) {
            return r(aVar2);
        }
        if (aVar2 == aVar4 || aVar2 == aVar3) {
            return r(aVar);
        }
        return K(aVar) && K(aVar2);
    }

    public d A() {
        if (s(f4024s)) {
            return f4025t;
        }
        if (s(f4025t)) {
            return f4023r;
        }
        z1.a aVarE = E(this.f4033b);
        if (aVarE != null) {
            boolean z2 = false;
            z1.a aVarJ = this.f4032a;
            if (z1.a.b(aVarJ) == null) {
                z2 = true;
                aVarJ = z1.a.j(aVarJ, z1.a.f6624l);
            }
            z1.a aVarN = z1.a.n(aVarE, aVarJ);
            if (aVarN != null) {
                d dVar = new d(aVarN);
                return z2 ? dVar.X() : dVar;
            }
        }
        return new d(q().n());
    }

    public d C() {
        BigInteger bigIntegerI = i();
        VLog.d("BBKCalculator/UnifiedReal", "fact asBI:" + bigIntegerI);
        if (bigIntegerI == null) {
            bigIntegerI = q().o(0);
            if (!c(new d(bigIntegerI), -1000)) {
                throw new ArithmeticException("Non-integral factorial argument");
            }
        }
        if (bigIntegerI.signum() < 0) {
            throw new ArithmeticException("Negative factorial argument");
        }
        if (bigIntegerI.longValue() > 4000 || bigIntegerI.toString().length() > 5) {
            throw new ArithmeticException("Factorial argument too big");
        }
        return new d(new z1.a(D(bigIntegerI.longValue(), 1L)));
    }

    public d I() {
        z1.a aVarH;
        if (w()) {
            throw new a();
        }
        z1.a aVarH2 = H(this.f4033b);
        return (aVarH2 == null || (aVarH = z1.a.h(z1.a.j(this.f4032a, aVarH2))) == null) ? new d(z1.a.h(this.f4032a), this.f4033b.p()) : new d(aVarH, this.f4033b);
    }

    public boolean J(d dVar) {
        x1.a aVar = this.f4033b;
        return (aVar == dVar.f4033b && (K(aVar) || this.f4033b.D(-1000) != 0)) || (this.f4032a.r() == 0 && dVar.f4032a.r() == 0) || t(this.f4033b, dVar.f4033b) || q().k(dVar.q(), -1000) != 0;
    }

    public int L() {
        int iX;
        if (!K(this.f4033b) || (iX = this.f4032a.x()) == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (iX >= 3) {
            return 0;
        }
        return (-iX) + 3;
    }

    public d M() {
        z1.a aVarA;
        if (this.f4033b == f4011f) {
            return new d(this.f4032a, f4009d).M().b(f4025t);
        }
        d dVar = f4024s;
        if (J(dVar)) {
            if (T() <= 0) {
                throw new ArithmeticException("VLog(non-positive)");
            }
            d dVar2 = f4025t;
            int iN = n(dVar2, -1000);
            if (iN == 0) {
                if (s(dVar2)) {
                    return dVar;
                }
            } else if (iN < 0) {
                return I().M().O();
            }
            BigInteger bigIntegerB = z1.a.b(this.f4032a);
            if (bigIntegerB != null) {
                x1.a aVar = this.f4033b;
                if (aVar == f4009d) {
                    int i3 = 0;
                    while (true) {
                        x1.a[] aVarArr = f4021p;
                        if (i3 >= aVarArr.length) {
                            break;
                        }
                        if (aVarArr[i3] != null) {
                            long jF = F(bigIntegerB, i3);
                            if (jF != 0) {
                                return new d(new z1.a(jF), aVarArr[i3]);
                            }
                        }
                        i3++;
                    }
                } else {
                    z1.a aVarH = H(aVar);
                    if (aVarH != null) {
                        int iG = aVarH.g();
                        x1.a[] aVarArr2 = f4021p;
                        if (aVarArr2[iG] != null) {
                            long jF2 = F(bigIntegerB, iG);
                            if (jF2 != 0 && (aVarA = z1.a.a(new z1.a(jF2), z1.a.f6617e)) != null) {
                                return new d(aVarA, aVarArr2[iG]);
                            }
                        }
                    }
                }
            }
        }
        return new d(q().s());
    }

    public d N(d dVar) {
        z1.a aVarH;
        z1.a aVarJ;
        z1.a aVarJ2;
        z1.a aVarJ3;
        x1.a aVar = this.f4033b;
        x1.a aVar2 = f4009d;
        if (aVar == aVar2 && (aVarJ3 = z1.a.j(this.f4032a, dVar.f4032a)) != null) {
            return new d(aVarJ3, dVar.f4033b);
        }
        if (dVar.f4033b == aVar2 && (aVarJ2 = z1.a.j(this.f4032a, dVar.f4032a)) != null) {
            return new d(aVarJ2, this.f4033b);
        }
        if (w() || dVar.w()) {
            return f4024s;
        }
        x1.a aVar3 = this.f4033b;
        if (aVar3 == dVar.f4033b && (aVarH = H(aVar3)) != null && (aVarJ = z1.a.j(z1.a.j(aVarH, this.f4032a), dVar.f4032a)) != null) {
            return new d(aVarJ);
        }
        z1.a aVarJ4 = z1.a.j(this.f4032a, dVar.f4032a);
        return aVarJ4 != null ? new d(aVarJ4, this.f4033b.v(dVar.f4033b)) : new d(q().v(dVar.q()));
    }

    public d O() {
        return new d(z1.a.k(this.f4032a), this.f4033b);
    }

    public d P(d dVar) {
        if (this.f4033b == f4011f) {
            if (this.f4032a.equals(z1.a.f6622j)) {
                return dVar.A();
            }
            return dVar.A().N(new d(this.f4032a).P(dVar));
        }
        z1.a aVarJ = dVar.j();
        if (aVarJ != null) {
            BigInteger bigIntegerB = z1.a.b(aVarJ);
            if (bigIntegerB != null) {
                return Q(bigIntegerB);
            }
            BigInteger bigIntegerB2 = z1.a.b(z1.a.j(z1.a.f6624l, aVarJ));
            if (bigIntegerB2 != null) {
                return Q(bigIntegerB2).X();
            }
        }
        if (w()) {
            return f4024s;
        }
        if (U(-1000) >= 0) {
            return new d(q().s().v(dVar.q()).n());
        }
        throw new ArithmeticException("Negative base for pow() with non-integer exponent");
    }

    public int T() {
        return m(f4024s);
    }

    public int U(int i3) {
        return n(f4024s, i3);
    }

    public d V() {
        d dVarW;
        BigInteger bigIntegerG = G();
        return (bigIntegerG == null || (dVarW = W(bigIntegerG.intValue())) == null) ? new d(q().F()) : dVarW;
    }

    public d X() {
        VLog.d("BBKCalculator/UnifiedReal", "sqrt: definitelyZero = " + w());
        if (w()) {
            return f4024s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sqrt: 2  ");
        x1.a aVar = f4009d;
        sb.append(aVar);
        sb.append(this.f4033b);
        VLog.d("BBKCalculator/UnifiedReal", sb.toString());
        if (this.f4033b == aVar) {
            int i3 = 1;
            while (true) {
                x1.a[] aVarArr = f4020o;
                if (i3 >= aVarArr.length) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sqrt: ");
                sb2.append(aVarArr[i3] != null);
                VLog.d("BBKCalculator/UnifiedReal", sb2.toString());
                if (aVarArr[i3] != null) {
                    z1.a aVarS = z1.a.s(z1.a.f(this.f4032a, new z1.a(i3)));
                    VLog.d("BBKCalculator/UnifiedReal", "sqrt: ratSqrt ==  " + aVarS);
                    if (aVarS != null) {
                        return new d(aVarS, aVarArr[i3]);
                    }
                }
                i3++;
            }
        }
        return new d(q().G());
    }

    public d Y(d dVar) {
        return b(dVar.O());
    }

    public String Z(int i3) {
        BigInteger bigIntegerShiftRight;
        boolean z2;
        VLog.d("BBKCalculator/UnifiedReal", "toStringTruncated: ");
        if (this.f4033b == f4009d || this.f4032a == z1.a.f6616d) {
            return this.f4032a.t(i3);
        }
        x1.a aVarV = x1.a.L(BigInteger.TEN.pow(i3)).v(q());
        boolean z3 = true;
        if (z()) {
            bigIntegerShiftRight = aVarV.o(0);
            if (bigIntegerShiftRight.signum() < 0) {
                bigIntegerShiftRight = bigIntegerShiftRight.negate();
                z2 = true;
            } else {
                z2 = false;
            }
            if (x1.a.L(bigIntegerShiftRight).j(aVarV.b()) > 0) {
                bigIntegerShiftRight = bigIntegerShiftRight.subtract(BigInteger.ONE);
            }
            k(x1.a.L(bigIntegerShiftRight).j(aVarV.b()) < 0);
        } else {
            BigInteger bigIntegerO = aVarV.o(-10);
            if (bigIntegerO.signum() < 0) {
                bigIntegerO = bigIntegerO.negate();
            } else {
                z3 = false;
            }
            bigIntegerShiftRight = bigIntegerO.shiftRight(10);
            z2 = z3;
        }
        String string = bigIntegerShiftRight.toString();
        int length = string.length();
        int i4 = i3 + 1;
        if (length < i4) {
            string = g.e('0', i4 - length) + string;
            length = i4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z2 ? "-" : BuildConfig.FLAVOR);
        int i5 = length - i3;
        sb.append(string.substring(0, i5));
        sb.append(".");
        sb.append(string.substring(i5));
        return sb.toString();
    }

    public d a() {
        return G.Y(e());
    }

    public d b(d dVar) {
        z1.a aVarA;
        if (this.f4033b == dVar.f4033b && (aVarA = z1.a.a(this.f4032a, dVar.f4032a)) != null) {
            return new d(aVarA, this.f4033b);
        }
        if (w()) {
            return dVar;
        }
        return dVar.w() ? this : new d(q().d(dVar.q()));
    }

    public boolean c(d dVar, int i3) {
        if (J(dVar)) {
            return (!t(this.f4033b, dVar.f4033b) || (this.f4032a.r() == 0 && dVar.f4032a.r() == 0)) && m(dVar) == 0;
        }
        return q().k(dVar.q(), i3) == 0;
    }

    public boolean d(int i3) {
        if (K(this.f4033b)) {
            return this.f4032a.x() > i3;
        }
        return q().o(i3 - 2).bitLength() > 2;
    }

    public d e() {
        l();
        BigInteger bigIntegerI = N(f4027v).i();
        if (bigIntegerI != null) {
            return f(bigIntegerI.intValue());
        }
        x1.a aVar = this.f4033b;
        return (aVar != x1.a.f6449r && aVar == f4012g && aVar == f4013h) ? new d(q().f()) : g();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        throw new AssertionError("Can't compare UnifiedReals for exact equality");
    }

    public d g() {
        if (n(f4024s, -10) < 0) {
            return O().g().O();
        }
        if (s(C)) {
            return new d(z1.a.f6620h, f4010e);
        }
        return s(E) ? new d(z1.a.f6619g, f4010e) : new d(q().f());
    }

    public d h() {
        d dVar = f4024s;
        if (n(dVar, -10) < 0) {
            return O().h().O();
        }
        BigInteger bigIntegerI = i();
        if (bigIntegerI == null || bigIntegerI.compareTo(BigInteger.ONE) > 0) {
            if (s(F)) {
                return J;
            }
            return s(D) ? H : new d(x1.b.f6471k.a(q()));
        }
        int iIntValue = bigIntegerI.intValue();
        if (iIntValue == 0) {
            return dVar;
        }
        if (iIntValue == 1) {
            return I;
        }
        throw new AssertionError("Impossible r_int");
    }

    public int hashCode() {
        return 0;
    }

    public BigInteger i() {
        return z1.a.b(j());
    }

    public z1.a j() {
        if (this.f4033b == f4009d || this.f4032a.r() == 0) {
            return this.f4032a;
        }
        return null;
    }

    public int m(d dVar) {
        if (w() && dVar.w()) {
            return 0;
        }
        x1.a aVar = this.f4033b;
        return aVar == dVar.f4033b ? aVar.C() * this.f4032a.c(dVar.f4032a) : q().j(dVar.q());
    }

    public int n(d dVar, int i3) {
        return J(dVar) ? m(dVar) : q().k(dVar.q(), i3);
    }

    public d o() {
        d dVarP;
        BigInteger bigIntegerG = G();
        VLog.d("BBKCalculator/UnifiedReal", "cos: piTwelfths == " + bigIntegerG);
        return (bigIntegerG == null || (dVarP = p(bigIntegerG.intValue())) == null) ? new d(q().l()) : dVarP;
    }

    public x1.a q() {
        return this.f4032a.d().v(this.f4033b);
    }

    public boolean s(d dVar) {
        return J(dVar) && m(dVar) == 0;
    }

    public String toString() {
        return this.f4032a.toString() + "*" + this.f4033b.toString();
    }

    public boolean u() {
        return !v() && K(this.f4033b);
    }

    public boolean v() {
        return this.f4033b == f4009d || this.f4032a.r() == 0;
    }

    public boolean w() {
        return this.f4032a.r() == 0;
    }

    public int x() {
        if (this.f4033b == f4009d || this.f4032a.r() == 0) {
            return z1.a.e(this.f4032a);
        }
        return Integer.MAX_VALUE;
    }

    public d y(d dVar) {
        if (this.f4033b == dVar.f4033b) {
            if (dVar.w()) {
                throw new a();
            }
            z1.a aVarF = z1.a.f(this.f4032a, dVar.f4032a);
            if (aVarF != null) {
                return new d(aVarF, f4009d);
            }
        }
        return N(dVar.I());
    }

    public boolean z() {
        return this.f4033b == f4009d || this.f4032a == z1.a.f6616d || u();
    }

    public d(x1.a aVar) {
        this(z1.a.f6622j, aVar);
    }

    public d(z1.a aVar) {
        this(aVar, f4009d);
    }

    public d(BigInteger bigInteger) {
        this(new z1.a(bigInteger));
    }

    public d(long j3) {
        this(new z1.a(j3));
    }
}
