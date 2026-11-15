package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class v extends a {
    a H;

    v(a aVar) {
        this.H = aVar;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        if (i3 >= 1) {
            return a.f6436e;
        }
        int iH = (i3 - a.h((((-i3) / 2) + 2) * 2)) - 4;
        int i4 = i3 - 3;
        BigInteger bigIntegerO = this.H.o(i4);
        BigInteger bigInteger = a.f6437f;
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(-iH);
        BigInteger bigIntegerShiftLeft2 = bigInteger.shiftLeft((i3 - 4) - iH);
        int i5 = 0;
        BigInteger bigIntegerAdd = bigIntegerShiftLeft;
        while (bigIntegerShiftLeft.abs().compareTo(bigIntegerShiftLeft2) >= 0) {
            if (Thread.interrupted() || a.f6447p) {
                throw new a.C0099a();
            }
            i5++;
            bigIntegerShiftLeft = a.x(bigIntegerShiftLeft.multiply(bigIntegerO), i4).divide(BigInteger.valueOf(i5));
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerShiftLeft);
        }
        return a.x(bigIntegerAdd, iH - i3);
    }
}
