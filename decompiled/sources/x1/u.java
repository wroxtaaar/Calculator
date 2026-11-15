package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class u extends a0 {
    a J;

    u(a aVar) {
        this.J = aVar;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        if (i3 >= 1) {
            return a.f6436e;
        }
        int iH = (i3 - a.h((((-i3) / 2) + 4) * 2)) - 4;
        int i4 = i3 - 2;
        BigInteger bigIntegerO = this.J.o(i4);
        BigInteger bigInteger = a.f6437f;
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft((i3 - 4) - iH);
        BigInteger bigIntegerShiftLeft2 = bigInteger.shiftLeft(-iH);
        int i5 = 0;
        BigInteger bigIntegerAdd = bigIntegerShiftLeft2;
        while (bigIntegerShiftLeft2.abs().compareTo(bigIntegerShiftLeft) >= 0) {
            if (Thread.interrupted() || a.f6447p) {
                throw new a.C0099a();
            }
            i5 += 2;
            bigIntegerShiftLeft2 = a.x(a.x(bigIntegerShiftLeft2.multiply(bigIntegerO), i4).multiply(bigIntegerO), i4).divide(BigInteger.valueOf(-i5).multiply(BigInteger.valueOf(i5 - 1)));
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerShiftLeft2);
        }
        return a.x(bigIntegerAdd, iH - i3);
    }
}
