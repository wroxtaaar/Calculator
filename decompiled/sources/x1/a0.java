package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a0 extends a {
    static int H = -64;
    static int I = 32;

    a0() {
    }

    @Override // x1.a
    public synchronized BigInteger o(int i3) {
        int i4;
        a.i(i3);
        if (this.f6460d && i3 >= (i4 = this.f6458b)) {
            return a.x(this.f6459c, i4 - i3);
        }
        int i5 = H;
        if (i3 < i5) {
            int i6 = I;
            i5 = (~(i6 - 1)) & ((i3 - i6) + 1);
        }
        BigInteger bigIntegerE = e(i5);
        this.f6458b = i5;
        this.f6459c = bigIntegerE;
        this.f6460d = true;
        return a.x(bigIntegerE, i5 - i3);
    }
}
