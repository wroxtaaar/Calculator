package x1;

import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: compiled from: CR.java */
/* JADX INFO: loaded from: classes.dex */
class j extends a0 {
    private static BigInteger L = BigInteger.valueOf(4);
    private static a M = new b0(a.f6449r.B(1));
    ArrayList<Integer> J = new ArrayList<>();
    ArrayList<BigInteger> K = new ArrayList<>();

    j() {
        this.J.add(null);
        this.K.add(null);
    }

    @Override // x1.a
    protected BigInteger e(int i3) {
        a b0Var;
        if (i3 >= 0) {
            return a.x(BigInteger.valueOf(3L), -i3);
        }
        int iCeil = ((int) Math.ceil(Math.log(-i3) / Math.log(2.0d))) + 10;
        int i4 = i3 - iCeil;
        BigInteger bigInteger = BigInteger.ONE;
        int i5 = -i4;
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(i5);
        BigInteger bigIntegerO = M.o(i4);
        BigInteger bigIntegerShiftLeft2 = bigInteger.shiftLeft(i5 - 2);
        int i6 = 0;
        while (bigIntegerShiftLeft.subtract(bigIntegerO).subtract(L).signum() > 0) {
            BigInteger bigIntegerShiftRight = bigIntegerShiftLeft.add(bigIntegerO).shiftRight(1);
            BigInteger bigIntegerSubtract = bigIntegerShiftLeft.subtract(bigIntegerShiftRight);
            a aVarB = a.L(bigIntegerShiftLeft.multiply(bigIntegerO).shiftRight(i5)).B(i5);
            int i7 = i6 + 1;
            if (this.J.size() == i7) {
                this.J.add(null);
                this.K.add(null);
                b0Var = aVarB.G();
            } else {
                b0Var = new b0(aVarB, this.J.get(i7).intValue(), this.K.get(i7));
            }
            bigIntegerO = b0Var.o(i4);
            this.J.set(i7, Integer.valueOf(i3));
            this.K.set(i7, a.x(bigIntegerO, -iCeil));
            bigIntegerShiftLeft2 = bigIntegerShiftLeft2.subtract(bigIntegerSubtract.multiply(bigIntegerSubtract).shiftLeft(i6 + i4));
            bigIntegerShiftLeft = bigIntegerShiftRight;
            i6 = i7;
        }
        BigInteger bigIntegerAdd = bigIntegerShiftLeft.add(bigIntegerO);
        return a.x(bigIntegerAdd.multiply(bigIntegerAdd).divide(bigIntegerShiftLeft2).shiftRight(2), -iCeil);
    }
}
