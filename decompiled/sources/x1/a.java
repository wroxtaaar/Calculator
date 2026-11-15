package x1;

import java.math.BigInteger;
import vivo.util.VLog;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Number {
    static double A;
    public static a B;
    public static a C;
    static a D;
    static final BigInteger E;
    static final BigInteger F;
    static final BigInteger G;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final BigInteger f6436e = BigInteger.ZERO;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final BigInteger f6437f = BigInteger.ONE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final BigInteger f6438g = BigInteger.valueOf(-1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final BigInteger f6439h = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final BigInteger f6440i = BigInteger.valueOf(-2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final BigInteger f6441j = BigInteger.valueOf(3);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final BigInteger f6442k = BigInteger.valueOf(6);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final BigInteger f6443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final BigInteger f6444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final BigInteger f6445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final BigInteger f6446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f6447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static a f6448q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static a f6449r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static a f6450s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static a f6451t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static a f6452u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static a f6453v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static a f6454w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static a f6455x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static a f6456y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static a f6457z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient int f6458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient BigInteger f6459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient boolean f6460d = false;

    /* JADX INFO: renamed from: x1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CR.java */
    public static class C0099a extends RuntimeException {
    }

    /* JADX INFO: compiled from: CR.java */
    public static class b extends RuntimeException {
    }

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(8L);
        f6443l = bigIntegerValueOf;
        f6444m = BigInteger.TEN;
        f6445n = BigInteger.valueOf(750L);
        f6446o = BigInteger.valueOf(-750L);
        f6447p = false;
        f6448q = K(0);
        f6449r = K(1);
        f6450s = K(10).m(K(9));
        f6451t = K(25).m(K(24));
        f6452u = K(81).m(K(80));
        f6453v = K(7).v(f6450s.E());
        f6454w = K(2).v(f6451t.E());
        f6455x = K(3).v(f6452u.E());
        f6456y = f6453v.H(f6454w).d(f6455x);
        f6457z = K(4);
        A = Math.log(2.0d);
        B = new j();
        a aVar = f6457z;
        C = aVar.v(aVar.v(g(5)).H(g(239)));
        D = B.B(1);
        E = bigIntegerValueOf;
        F = BigInteger.valueOf(24L);
        G = BigInteger.valueOf(64L);
    }

    public static a K(int i3) {
        return L(BigInteger.valueOf(i3));
    }

    public static a L(BigInteger bigInteger) {
        return new l(bigInteger);
    }

    private static String M(int i3) {
        char[] cArr = new char[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            cArr[i4] = '0';
        }
        return new String(cArr);
    }

    static a g(int i3) {
        return new m(i3);
    }

    static int h(int i3) {
        return (int) Math.ceil(Math.log(Math.abs(i3) + 1) / Math.log(2.0d));
    }

    static void i(int i3) {
        if (((i3 >> 29) ^ (i3 >> 28)) != 0) {
            throw new b();
        }
    }

    static BigInteger x(BigInteger bigInteger, int i3) {
        return i3 >= 0 ? bigInteger.shiftLeft(i3) : z(bigInteger, i3 + 1).add(f6437f).shiftRight(1);
    }

    static BigInteger z(BigInteger bigInteger, int i3) {
        if (i3 == 0) {
            return bigInteger;
        }
        return i3 < 0 ? bigInteger.shiftRight(-i3) : bigInteger.shiftLeft(i3);
    }

    public a A(int i3) {
        i(i3);
        return new y(this, i3);
    }

    public a B(int i3) {
        i(i3);
        return new y(this, -i3);
    }

    public int C() {
        int i3 = -20;
        while (true) {
            i(i3);
            int iD = D(i3);
            if (iD != 0) {
                return iD;
            }
            if (Thread.interrupted() || f6447p) {
                throw new C0099a();
            }
            i3 *= 2;
        }
    }

    public int D(int i3) {
        int iSignum;
        return (!this.f6460d || (iSignum = this.f6459c.signum()) == 0) ? o(i3 - 1).signum() : iSignum;
    }

    a E() {
        return new w(H(f6449r));
    }

    public a F() {
        return D.H(this).l();
    }

    public a G() {
        return new b0(this);
    }

    public a H(a aVar) {
        return new e(this, aVar.w());
    }

    public String I(int i3) {
        return J(i3, 10);
    }

    public String J(int i3, int i4) {
        BigInteger bigIntegerO = (16 == i4 ? A(i3 * 4) : v(new l(BigInteger.valueOf(i4).pow(i3)))).o(0);
        String string = bigIntegerO.abs().toString(i4);
        if (i3 != 0) {
            int length = string.length();
            if (length <= i3) {
                int i5 = i3 + 1;
                string = M(i5 - length) + string;
                length = i5;
            }
            int i6 = length - i3;
            string = string.substring(0, i6) + "." + string.substring(i6);
        }
        if (bigIntegerO.signum() >= 0) {
            return string;
        }
        return "-" + string;
    }

    public BigInteger a() {
        return o(0);
    }

    public a b() {
        return y(w(), this);
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return a().byteValue();
    }

    public a c() {
        return D.H(f());
    }

    public a d(a aVar) {
        return new e(this, aVar);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        int iQ = q(-1080);
        if (Integer.MIN_VALUE == iQ) {
            return 0.0d;
        }
        int i3 = iQ - 60;
        double dDoubleValue = o(i3).doubleValue();
        boolean z2 = i3 < -1000;
        long jDoubleToLongBits = Double.doubleToLongBits(dDoubleValue);
        if (z2) {
            i3 += 96;
        }
        long j3 = i3;
        if (((((jDoubleToLongBits >> 52) & 2047) + j3) & (-2048)) != 0) {
            return dDoubleValue < 0.0d ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        double dLongBitsToDouble = Double.longBitsToDouble(jDoubleToLongBits + (j3 << 52));
        return z2 ? (dLongBitsToDouble / 2.81474976710656E14d) / 2.81474976710656E14d : dLongBitsToDouble;
    }

    protected abstract BigInteger e(int i3);

    public a f() {
        BigInteger bigIntegerO = o(-10);
        if (bigIntegerO.compareTo(f6445n) > 0) {
            return f6449r.H(v(this)).G().c();
        }
        return bigIntegerO.compareTo(f6446o) < 0 ? w().f().w() : new t(this);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // java.lang.Number
    public int intValue() {
        return a().intValue();
    }

    public int j(a aVar) {
        int i3 = -20;
        while (true) {
            i(i3);
            int iK = k(aVar, i3);
            if (iK != 0) {
                return iK;
            }
            if (Thread.interrupted() || f6447p) {
                throw new C0099a();
            }
            i3 *= 2;
        }
    }

    public int k(a aVar, int i3) {
        int i4 = i3 - 1;
        BigInteger bigIntegerO = o(i4);
        BigInteger bigIntegerO2 = aVar.o(i4);
        BigInteger bigInteger = f6437f;
        if (bigIntegerO.compareTo(bigIntegerO2.add(bigInteger)) > 0) {
            return 1;
        }
        return bigIntegerO.compareTo(bigIntegerO2.subtract(bigInteger)) < 0 ? -1 : 0;
    }

    public a l() {
        VLog.d("BBKCalculator/CR", "cos: ");
        BigInteger bigIntegerO = m(B).o(-1);
        BigInteger bigIntegerAbs = bigIntegerO.abs();
        VLog.d("BBKCalculator/CR", "cos: halfpi_multiples == " + bigIntegerO);
        VLog.d("BBKCalculator/CR", "cos: abs_halfpi_multiples == " + bigIntegerAbs);
        BigInteger bigInteger = f6439h;
        if (bigIntegerAbs.compareTo(bigInteger) >= 0) {
            BigInteger bigIntegerX = x(bigIntegerO, -1);
            a aVarV = B.v(L(bigIntegerX));
            return bigIntegerX.and(f6437f).signum() != 0 ? H(aVarV).l().w() : H(aVarV).l();
        }
        if (o(-1).abs().compareTo(bigInteger) < 0) {
            return new u(this);
        }
        a aVarL = B(1).l();
        return aVarL.v(aVarL).A(1).H(f6449r);
    }

    @Override // java.lang.Number
    public long longValue() {
        return a().longValue();
    }

    public a m(a aVar) {
        return new q(this, aVar.p());
    }

    public a n() {
        BigInteger bigIntegerO = o(-10);
        if (bigIntegerO.compareTo(f6439h) <= 0 && bigIntegerO.compareTo(f6440i) >= 0) {
            return new v(this);
        }
        a aVarN = B(1).n();
        return aVarN.v(aVarN);
    }

    public synchronized BigInteger o(int i3) {
        i(i3);
        if (this.f6460d && i3 >= this.f6458b) {
            VLog.d("BigInteger", "get_appr: " + x(this.f6459c, this.f6458b - i3));
            return x(this.f6459c, this.f6458b - i3);
        }
        BigInteger bigIntegerE = e(i3);
        this.f6458b = i3;
        this.f6459c = bigIntegerE;
        this.f6460d = true;
        VLog.d("BigInteger", "get_appr: " + bigIntegerE);
        return bigIntegerE;
    }

    public a p() {
        return new n(this);
    }

    int q(int i3) {
        for (int i4 = 0; i4 > i3 + 30; i4 = ((i4 * 3) / 2) - 16) {
            int iU = u(i4);
            if (iU != Integer.MIN_VALUE) {
                return iU;
            }
            i(i4);
            if (Thread.interrupted() || f6447p) {
                throw new C0099a();
            }
        }
        return u(i3);
    }

    int r() {
        return (this.f6458b + (this.f6459c.signum() >= 0 ? this.f6459c.bitLength() : this.f6459c.negate().bitLength())) - 1;
    }

    public a s() {
        BigInteger bigIntegerO = o(-4);
        if (bigIntegerO.compareTo(f6436e) < 0) {
            throw new ArithmeticException("ln(negative)");
        }
        if (bigIntegerO.compareTo(E) <= 0) {
            return p().s().w();
        }
        if (bigIntegerO.compareTo(F) < 0) {
            return E();
        }
        if (bigIntegerO.compareTo(G) <= 0) {
            return G().G().s().A(2);
        }
        int iBitLength = bigIntegerO.bitLength() - 3;
        return B(iBitLength).s().d(K(iBitLength).v(f6456y));
    }

    int t() {
        return q(Integer.MIN_VALUE);
    }

    public String toString() {
        return I(10);
    }

    int u(int i3) {
        if (!this.f6460d || (this.f6459c.compareTo(f6437f) <= 0 && this.f6459c.compareTo(f6438g) >= 0)) {
            o(i3 - 1);
            if (this.f6459c.abs().compareTo(f6437f) <= 0) {
                return Integer.MIN_VALUE;
            }
        }
        return r();
    }

    public a v(a aVar) {
        return new q(this, aVar);
    }

    public a w() {
        return new r(this);
    }

    public a y(a aVar, a aVar2) {
        return new x(this, aVar, aVar2);
    }
}
