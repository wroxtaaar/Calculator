package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class w extends a0 {
    a J;

    w(a aVar) {
        this.J = aVar;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        if (i3 >= 0) {
            return a.f6436e;
        }
        int iH = (i3 - a.h((-i3) * 2)) - 4;
        int i4 = i3 - 3;
        BigInteger bigIntegerO = this.J.o(i4);
        BigInteger bigInteger = a.f6437f;
        bigInteger.shiftLeft(-iH);
        BigInteger bigIntegerX = a.x(bigIntegerO, i4 - iH);
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft((i3 - 4) - iH);
        BigInteger bigIntegerAdd = bigIntegerX;
        BigInteger bigIntegerX2 = bigIntegerAdd;
        int i5 = 1;
        int i6 = 1;
        while (bigIntegerX.abs().compareTo(bigIntegerShiftLeft) >= 0) {
            if (Thread.interrupted() || a.f6447p) {
                throw new a.C0099a();
            }
            i5++;
            i6 = -i6;
            bigIntegerX2 = a.x(bigIntegerX2.multiply(bigIntegerO), i4);
            bigIntegerX = bigIntegerX2.divide(BigInteger.valueOf(i5 * i6));
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerX);
        }
        return a.x(bigIntegerAdd, iH - i3);
    }
}
