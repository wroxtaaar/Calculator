package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class t extends a0 {
    a J;

    t(a aVar) {
        this.J = aVar;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        if (i3 >= 2) {
            return a.f6436e;
        }
        int iH = (i3 - a.h((((i3 * (-3)) / 2) + 4) * 2)) - 4;
        int i4 = i3 - 3;
        BigInteger bigIntegerO = this.J.o(i4);
        BigInteger bigIntegerShiftLeft = a.f6437f.shiftLeft((i3 - 4) - iH);
        BigInteger bigIntegerShiftLeft2 = bigIntegerO.shiftLeft(i4 - iH);
        BigInteger bigIntegerX = bigIntegerShiftLeft2;
        int i5 = 1;
        BigInteger bigIntegerAdd = bigIntegerX;
        while (bigIntegerShiftLeft2.abs().compareTo(bigIntegerShiftLeft) >= 0) {
            if (Thread.interrupted() || a.f6447p) {
                throw new a.C0099a();
            }
            i5 += 2;
            bigIntegerX = a.x(a.x(bigIntegerX.multiply(BigInteger.valueOf(i5 - 2)).multiply(bigIntegerO), i4 + 2).multiply(bigIntegerO).divide(BigInteger.valueOf(i5 - 1)), i4 - 2);
            bigIntegerShiftLeft2 = bigIntegerX.divide(BigInteger.valueOf(i5));
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerShiftLeft2);
        }
        return a.x(bigIntegerAdd, iH - i3);
    }
}
