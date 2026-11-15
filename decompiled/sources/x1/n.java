package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class n extends a {
    a H;

    n(a aVar) {
        this.H = aVar;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        int iT = this.H.t();
        int i4 = iT - (((1 - iT) - i3) + 3);
        int i5 = (-i3) - i4;
        if (i5 < 0) {
            return a.f6436e;
        }
        BigInteger bigIntegerShiftLeft = a.f6437f.shiftLeft(i5);
        BigInteger bigIntegerO = this.H.o(i4);
        BigInteger bigIntegerAbs = bigIntegerO.abs();
        BigInteger bigIntegerDivide = bigIntegerShiftLeft.add(bigIntegerAbs.shiftRight(1)).divide(bigIntegerAbs);
        return bigIntegerO.signum() < 0 ? bigIntegerDivide.negate() : bigIntegerDivide;
    }
}
