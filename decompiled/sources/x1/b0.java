package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class b0 extends a {
    a H;
    final int I = 50;
    final int J = 60;

    b0(a aVar) {
        this.H = aVar;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        int i4 = (i3 * 2) - 1;
        int iQ = this.H.q(i4);
        if (iQ <= i4) {
            return a.f6436e;
        }
        int i5 = iQ / 2;
        int i6 = i5 - i3;
        if (i6 > 50) {
            int i7 = i5 - ((i6 / 2) + 6);
            BigInteger bigIntegerO = this.H.o(i7 * 2);
            BigInteger bigIntegerO2 = o(i7);
            return a.x(bigIntegerO2.multiply(bigIntegerO2).add(bigIntegerO), i7 - i3).divide(bigIntegerO2).add(a.f6437f).shiftRight(1);
        }
        int i8 = (iQ - 60) & (-2);
        int i9 = i8 - 60;
        double dDoubleValue = this.H.o(i8).shiftLeft(60).doubleValue();
        if (dDoubleValue >= 0.0d) {
            return a.z(BigInteger.valueOf((long) Math.sqrt(dDoubleValue)), (i9 / 2) - i3);
        }
        throw new ArithmeticException("sqrt(negative)");
    }

    b0(a aVar, int i3, BigInteger bigInteger) {
        this.H = aVar;
        this.f6458b = i3;
        this.f6459c = bigInteger;
        this.f6460d = true;
    }
}
