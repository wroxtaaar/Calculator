package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class m extends a0 {
    int J;

    m(int i3) {
        this.J = i3;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        int i4 = 1;
        if (i3 >= 1) {
            return a.f6436e;
        }
        int iH = (i3 - a.h((((-i3) / 2) + 2) * 2)) - 2;
        BigInteger bigInteger = a.f6437f;
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(-iH);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.J);
        int i5 = this.J;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(i5 * i5);
        BigInteger bigIntegerDivide = bigIntegerShiftLeft.divide(bigIntegerValueOf);
        BigInteger bigIntegerShiftLeft2 = bigInteger.shiftLeft((i3 - 2) - iH);
        BigInteger bigIntegerDivide2 = bigIntegerDivide;
        BigInteger bigIntegerAdd = bigIntegerDivide2;
        BigInteger bigIntegerDivide3 = bigIntegerAdd;
        int i6 = 1;
        while (bigIntegerDivide2.abs().compareTo(bigIntegerShiftLeft2) >= 0) {
            if (Thread.interrupted() || a.f6447p) {
                throw new a.C0099a();
            }
            i4 += 2;
            bigIntegerDivide3 = bigIntegerDivide3.divide(bigIntegerValueOf2);
            i6 = -i6;
            bigIntegerDivide2 = bigIntegerDivide3.divide(BigInteger.valueOf(i6 * i4));
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerDivide2);
        }
        return a.x(bigIntegerAdd, iH - i3);
    }
}
