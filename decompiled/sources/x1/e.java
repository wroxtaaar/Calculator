package x1;

import java.math.BigInteger;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class e extends a {
    a H;
    a I;

    e(a aVar, a aVar2) {
        this.H = aVar;
        this.I = aVar2;
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        int i4 = i3 - 2;
        return a.x(this.H.o(i4).add(this.I.o(i4)), -2);
    }
}
