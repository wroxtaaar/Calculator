package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class y extends a {
    a H;
    int I;

    y(a aVar, int i3) {
        this.H = aVar;
        this.I = i3;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        return this.H.o(i3 - this.I);
    }
}
