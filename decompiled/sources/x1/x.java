package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class x extends a {
    a H;
    int I;
    a J;
    a K;

    x(a aVar, a aVar2, a aVar3) {
        this.H = aVar;
        aVar.o(-20).signum();
        this.J = aVar2;
        this.K = aVar3;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        int i4 = this.I;
        if (i4 < 0) {
            return this.J.o(i3);
        }
        if (i4 > 0) {
            return this.K.o(i3);
        }
        int i5 = i3 - 1;
        BigInteger bigIntegerO = this.J.o(i5);
        BigInteger bigIntegerO2 = this.K.o(i5);
        if (bigIntegerO.subtract(bigIntegerO2).abs().compareTo(a.f6437f) <= 0) {
            return a.x(bigIntegerO, -1);
        }
        if (this.H.C() < 0) {
            this.I = -1;
            return a.x(bigIntegerO, -1);
        }
        this.I = 1;
        return a.x(bigIntegerO2, -1);
    }
}
