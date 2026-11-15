package z1;

import com.vivo.seckeysdk.BuildConfig;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: compiled from: BoundedRational.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static Random f6615c = new Random();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f6616d = new a(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6617e = new a(1, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f6618f = new a(-1, 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f6619g = new a(1, 3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f6620h = new a(1, 4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f6621i = new a(1, 6);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f6622j = new a(1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f6623k = new a(-1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f6624l = new a(2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f6625m = new a(-2);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f6626n = new a(10);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f6627o = new a(12);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f6628p = new a(30);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f6629q = new a(-30);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f6630r = new a(45);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f6631s = new a(-45);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f6632t = new a(90);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f6633u = new a(-90);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final BigInteger f6634v = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final BigInteger f6635w = BigInteger.valueOf(-1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final BigInteger f6636x = BigInteger.valueOf(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BigInteger f6637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BigInteger f6638b;

    /* JADX INFO: renamed from: z1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BoundedRational.java */
    public static class C0102a extends ArithmeticException {
        public C0102a() {
            super("Division by zero");
        }
    }

    public a(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f6637a = bigInteger;
        this.f6638b = bigInteger2;
    }

    public static a a(a aVar, a aVar2) {
        if (aVar == null || aVar2 == null) {
            return null;
        }
        return i(new a(aVar.f6637a.multiply(aVar2.f6638b).add(aVar2.f6637a.multiply(aVar.f6638b)), aVar.f6638b.multiply(aVar2.f6638b)));
    }

    public static BigInteger b(a aVar) {
        if (aVar == null) {
            return null;
        }
        BigInteger[] bigIntegerArrDivideAndRemainder = aVar.f6637a.divideAndRemainder(aVar.f6638b);
        if (bigIntegerArrDivideAndRemainder[1].signum() == 0) {
            return bigIntegerArrDivideAndRemainder[0];
        }
        return null;
    }

    public static int e(a aVar) {
        if (aVar == null) {
            return Integer.MAX_VALUE;
        }
        int i3 = 0;
        if (aVar.f6638b.equals(BigInteger.ONE)) {
            return 0;
        }
        BigInteger bigIntegerDivide = aVar.q().f6638b;
        if (bigIntegerDivide.bitLength() > 10000) {
            return Integer.MAX_VALUE;
        }
        int i4 = 0;
        while (!bigIntegerDivide.testBit(0)) {
            i4++;
            bigIntegerDivide = bigIntegerDivide.shiftRight(1);
        }
        while (true) {
            BigInteger bigInteger = f6636x;
            if (bigIntegerDivide.mod(bigInteger).signum() != 0) {
                break;
            }
            i3++;
            bigIntegerDivide = bigIntegerDivide.divide(bigInteger);
        }
        if (bigIntegerDivide.equals(BigInteger.ONE) || bigIntegerDivide.equals(f6635w)) {
            return Math.max(i4, i3);
        }
        return Integer.MAX_VALUE;
    }

    public static a f(a aVar, a aVar2) {
        return j(aVar, h(aVar2));
    }

    public static a h(a aVar) {
        if (aVar == null) {
            return null;
        }
        if (aVar.f6637a.signum() != 0) {
            return new a(aVar.f6638b, aVar.f6637a);
        }
        throw new C0102a();
    }

    private static a i(a aVar) {
        if (aVar == null) {
            return null;
        }
        if (!aVar.u() && (f6615c.nextInt() & 15) != 0) {
            return aVar;
        }
        a aVarQ = aVar.l().q();
        if (aVarQ.u()) {
            return null;
        }
        return aVarQ;
    }

    public static a j(a aVar, a aVar2) {
        return i(o(aVar, aVar2));
    }

    public static a k(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(aVar.f6637a.negate(), aVar.f6638b);
    }

    private a l() {
        return this.f6638b.signum() > 0 ? this : new a(this.f6637a.negate(), this.f6638b.negate());
    }

    public static a n(a aVar, a aVar2) {
        if (aVar2 == null || aVar == null) {
            return null;
        }
        a aVarL = aVar2.q().l();
        if (aVarL.f6638b.equals(BigInteger.ONE)) {
            return aVar.m(aVarL.f6637a);
        }
        return null;
    }

    private static a o(a aVar, a aVar2) {
        if (aVar == null || aVar2 == null) {
            return null;
        }
        a aVar3 = f6622j;
        if (aVar == aVar3) {
            return aVar2;
        }
        return aVar2 == aVar3 ? aVar : new a(aVar.f6637a.multiply(aVar2.f6637a), aVar.f6638b.multiply(aVar2.f6638b));
    }

    private a p(BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ONE;
        if (bigInteger.equals(bigInteger2)) {
            return this;
        }
        if (bigInteger.and(bigInteger2).intValue() == 1) {
            return o(p(bigInteger.subtract(bigInteger2)), this);
        }
        if (bigInteger.signum() == 0) {
            return f6622j;
        }
        a aVarP = p(bigInteger.shiftRight(1));
        if (Thread.interrupted()) {
            throw new x1.a.C0099a();
        }
        a aVarO = o(aVarP, aVarP);
        if (aVarO == null || aVarO.u()) {
            return null;
        }
        return aVarO;
    }

    private a q() {
        if (this.f6638b.equals(BigInteger.ONE)) {
            return this;
        }
        BigInteger bigIntegerGcd = this.f6637a.gcd(this.f6638b);
        return new a(this.f6637a.divide(bigIntegerGcd), this.f6638b.divide(bigIntegerGcd));
    }

    public static a s(a aVar) {
        if (aVar == null) {
            return null;
        }
        a aVarQ = aVar.l().q();
        if (aVarQ.f6637a.signum() < 0) {
            throw new ArithmeticException("sqrt(negative)");
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(Math.round(Math.sqrt(aVarQ.f6637a.doubleValue())));
        if (!bigIntegerValueOf.multiply(bigIntegerValueOf).equals(aVarQ.f6637a)) {
            return null;
        }
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(Math.round(Math.sqrt(aVarQ.f6638b.doubleValue())));
        if (bigIntegerValueOf2.multiply(bigIntegerValueOf2).equals(aVarQ.f6638b)) {
            return new a(bigIntegerValueOf, bigIntegerValueOf2);
        }
        return null;
    }

    private boolean u() {
        return !this.f6638b.equals(BigInteger.ONE) && this.f6637a.bitLength() + this.f6638b.bitLength() > 10000;
    }

    public static a v(double d3) {
        long jRound = Math.round(d3);
        if (jRound == d3 && Math.abs(jRound) <= 1000) {
            return w(jRound);
        }
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(Math.abs(d3));
        long j3 = 4503599627370495L & jDoubleToRawLongBits;
        int i3 = (int) (jDoubleToRawLongBits >>> 52);
        if ((i3 & 2047) == 2047) {
            throw new ArithmeticException("Infinity or NaN not convertible to BoundedRational");
        }
        long j4 = d3 < 0.0d ? -1L : 1L;
        int i4 = i3 - 1075;
        if (i3 == 0) {
            i4++;
        } else {
            j3 += 4503599627370496L;
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j4 * j3);
        BigInteger bigIntegerShiftLeft = BigInteger.ONE;
        if (i4 >= 0) {
            bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i4);
        } else {
            bigIntegerShiftLeft = bigIntegerShiftLeft.shiftLeft(-i4);
        }
        return new a(bigIntegerValueOf, bigIntegerShiftLeft);
    }

    public static a w(long j3) {
        if (j3 >= -2 && j3 <= 10) {
            int i3 = (int) j3;
            if (i3 == -2) {
                return f6625m;
            }
            if (i3 == -1) {
                return f6623k;
            }
            if (i3 == 0) {
                return f6616d;
            }
            if (i3 == 1) {
                return f6622j;
            }
            if (i3 == 2) {
                return f6624l;
            }
            if (i3 == 10) {
                return f6626n;
            }
        }
        return new a(j3);
    }

    public int c(a aVar) {
        return this.f6637a.multiply(aVar.f6638b).compareTo(aVar.f6637a.multiply(this.f6638b)) * this.f6638b.signum() * aVar.f6638b.signum();
    }

    public x1.a d() {
        return x1.a.L(this.f6637a).m(x1.a.L(this.f6638b));
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof a) && c((a) obj) == 0;
    }

    public int g() {
        a aVarQ = q();
        if (aVarQ.f6638b.equals(BigInteger.ONE)) {
            return aVarQ.f6637a.intValue();
        }
        throw new ArithmeticException("intValue of non-int");
    }

    public int hashCode() {
        a aVarL = q().l();
        return Objects.hash(aVarL.f6637a, aVarL.f6638b);
    }

    public a m(BigInteger bigInteger) {
        int iSignum = bigInteger.signum();
        if (iSignum == 0) {
            return f6622j;
        }
        BigInteger bigInteger2 = BigInteger.ONE;
        if (bigInteger.equals(bigInteger2)) {
            return this;
        }
        a aVarL = q().l();
        if (aVarL.f6638b.equals(bigInteger2)) {
            if (aVarL.f6637a.equals(BigInteger.ZERO)) {
                return f6616d;
            }
            if (aVarL.f6637a.equals(bigInteger2)) {
                return f6622j;
            }
            if (aVarL.f6637a.equals(f6635w)) {
                return bigInteger.testBit(0) ? f6623k : f6622j;
            }
        }
        if (bigInteger.bitLength() > 1000) {
            return null;
        }
        return iSignum < 0 ? h(aVarL).p(bigInteger.negate()) : aVarL.p(bigInteger);
    }

    public int r() {
        return this.f6637a.signum() * this.f6638b.signum();
    }

    public String t(int i3) {
        String string = this.f6637a.abs().multiply(BigInteger.TEN.pow(i3)).divide(this.f6638b.abs()).toString();
        int length = string.length();
        int i4 = i3 + 1;
        if (length < i4) {
            string = g.e('0', i4 - length) + string;
            length = i4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(r() < 0 ? "-" : BuildConfig.FLAVOR);
        int i5 = length - i3;
        sb.append(string.substring(0, i5));
        sb.append(".");
        sb.append(string.substring(i5));
        return sb.toString();
    }

    public String toString() {
        return this.f6637a.toString() + "/" + this.f6638b.toString();
    }

    public int x() {
        if (this.f6637a.signum() == 0) {
            return Integer.MIN_VALUE;
        }
        return this.f6637a.bitLength() - this.f6638b.bitLength();
    }

    public a(BigInteger bigInteger) {
        this.f6637a = bigInteger;
        this.f6638b = BigInteger.ONE;
    }

    public a(long j3, long j4) {
        this.f6637a = BigInteger.valueOf(j3);
        this.f6638b = BigInteger.valueOf(j4);
    }

    public a(long j3) {
        this.f6637a = BigInteger.valueOf(j3);
        this.f6638b = BigInteger.valueOf(1L);
    }
}
