package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class l extends a {
    BigInteger H;

    l(BigInteger bigInteger) {
        this.H = bigInteger;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        return a.x(this.H, -i3);
    }
}
