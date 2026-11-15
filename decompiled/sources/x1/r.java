package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class r extends a {
    a H;

    r(a aVar) {
        this.H = aVar;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        return this.H.o(i3).negate();
    }
}
