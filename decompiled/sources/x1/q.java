package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class q extends a {
    a H;
    a I;

    q(a aVar, a aVar2) {
        this.H = aVar;
        this.I = aVar2;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        int i4 = (i3 >> 1) - 1;
        int iU = this.H.u(i4);
        if (iU == Integer.MIN_VALUE) {
            iU = this.I.u(i4);
            if (iU == Integer.MIN_VALUE) {
                return a.f6436e;
            }
            a aVar = this.H;
            this.H = this.I;
            this.I = aVar;
        }
        int i5 = (i3 - iU) - 3;
        BigInteger bigIntegerO = this.I.o(i5);
        if (bigIntegerO.signum() == 0) {
            return a.f6436e;
        }
        int iR = (i3 - this.I.r()) - 3;
        return a.x(this.H.o(iR).multiply(bigIntegerO), (iR + i5) - i3);
    }
}
