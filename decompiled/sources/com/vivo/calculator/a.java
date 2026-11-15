package com.vivo.calculator;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TtsSpan;
import com.vivo.seckeysdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import vivo.util.VLog;

/* JADX INFO: compiled from: CalculatorExpr.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static l[] f3844d = l.values();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BigInteger f3845e = BigInteger.valueOf(1000000);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final BigInteger f3846f = BigInteger.valueOf(1000000000);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final com.vivo.calculator.d f3847g = new com.vivo.calculator.d(100).I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<k> f3848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<k> f3849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<k> f3850c;

    /* JADX INFO: renamed from: com.vivo.calculator.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CalculatorExpr.java */
    static /* synthetic */ class C0046a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3851a;

        static {
            int[] iArr = new int[l.values().length];
            f3851a = iArr;
            try {
                iArr[l.CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3851a[l.PRE_EVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g f3861c;

        c(boolean z2, int i3, g gVar) {
            this.f3860b = z2;
            this.f3859a = i3;
            this.f3861c = gVar;
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.vivo.calculator.d f3863b;

        d(int i3, com.vivo.calculator.d dVar) {
            this.f3862a = i3;
            this.f3863b = dVar;
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.vivo.calculator.d f3865b;

        e(int i3, com.vivo.calculator.d dVar) {
            this.f3864a = i3;
            this.f3865b = dVar;
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.vivo.calculator.d f3867b;

        f(int i3, com.vivo.calculator.d dVar) {
            this.f3866a = i3;
            this.f3867b = dVar;
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    public interface g {
        boolean a(long j3);

        boolean b(long j3);

        com.vivo.calculator.d c(long j3, com.vivo.calculator.d dVar);

        com.vivo.calculator.d d(long j3);

        a e(long j3);

        com.vivo.calculator.d f(long j3);

        com.vivo.calculator.d g(long j3);

        boolean h(long j3);

        a i(long j3);

        com.vivo.calculator.d j(long j3, com.vivo.calculator.d dVar);

        a k(long j3);

        com.vivo.calculator.d l(long j3, com.vivo.calculator.d dVar);
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    public static class j extends Exception {
        public j() {
        }

        public j(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static abstract class k {
        private k() {
        }

        abstract CharSequence a(Context context);

        abstract void b(DataOutput dataOutput) throws IOException;

        /* synthetic */ k(C0046a c0046a) {
            this();
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private enum l {
        CONSTANT,
        OPERATOR,
        PRE_EVAL;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }
    }

    public a() {
        this.f3848a = new ArrayList<>();
    }

    private void A(e eVar) throws j {
        String strZ = eVar.f3865b.Z(0);
        if (strZ.indexOf(45) < 0 && strZ.length() > 4) {
            throw new j();
        }
    }

    private void B(f fVar) throws j {
        String strZ = fVar.f3867b.Z(0);
        if (strZ.indexOf(45) < 0 && strZ.length() > 4) {
            throw new j();
        }
    }

    private boolean G0(int i3) {
        if (i3 < 0 || i3 >= this.f3848a.size()) {
            return false;
        }
        k kVar = this.f3848a.get(i3);
        if (kVar instanceof h) {
            return z1.e.l(((h) kVar).f3868a);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if ((r1 instanceof com.vivo.calculator.a.h) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean H0(int r2, boolean r3) {
        /*
            r1 = this;
            r0 = 0
            if (r3 == 0) goto L1b
            if (r2 < 0) goto L1a
            java.util.ArrayList<com.vivo.calculator.a$k> r3 = r1.f3849b
            int r3 = r3.size()
            if (r2 < r3) goto Le
            goto L1a
        Le:
            java.util.ArrayList<com.vivo.calculator.a$k> r1 = r1.f3849b
            java.lang.Object r1 = r1.get(r2)
            com.vivo.calculator.a$k r1 = (com.vivo.calculator.a.k) r1
            boolean r2 = r1 instanceof com.vivo.calculator.a.h
            if (r2 != 0) goto L33
        L1a:
            return r0
        L1b:
            if (r2 < 0) goto L3c
            java.util.ArrayList<com.vivo.calculator.a$k> r3 = r1.f3850c
            int r3 = r3.size()
            if (r2 < r3) goto L26
            goto L3c
        L26:
            java.util.ArrayList<com.vivo.calculator.a$k> r1 = r1.f3850c
            java.lang.Object r1 = r1.get(r2)
            com.vivo.calculator.a$k r1 = (com.vivo.calculator.a.k) r1
            boolean r2 = r1 instanceof com.vivo.calculator.a.h
            if (r2 != 0) goto L33
            return r0
        L33:
            com.vivo.calculator.a$h r1 = (com.vivo.calculator.a.h) r1
            int r1 = r1.f3868a
            boolean r1 = z1.e.l(r1)
            return r1
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.calculator.a.H0(int, boolean):boolean");
    }

    private d S(int i3, c cVar) throws j {
        d dVarE0;
        VLog.d("BBKCalculator/CalculatorExpr", "evalExpr: i == " + i3);
        d dVarE1 = e0(i3, cVar);
        int i4 = dVarE1.f3862a;
        com.vivo.calculator.d dVarB = dVarE1.f3863b;
        VLog.d("BBKCalculator/CalculatorExpr", "evalExpr: start val == " + dVarB);
        while (true) {
            boolean zS0 = S0(i4, R.id.op_add, cVar);
            if (!zS0 && !S0(i4, R.id.op_sub, cVar)) {
                VLog.d("BBKCalculator/CalculatorExpr", "evalExpr: val == " + dVarB);
                return new d(i4, dVarB);
            }
            int i5 = i4 + 1;
            if (Z0(i5)) {
                dVarE0 = s0(i5, !zS0, cVar);
                dVarB = dVarB.N(dVarE0.f3863b);
            } else {
                dVarE0 = e0(i5, cVar);
                dVarB = zS0 ? dVarB.b(dVarE0.f3863b) : dVarB.Y(dVarE0.f3863b);
            }
            i4 = dVarE0.f3862a;
        }
    }

    private boolean S0(int i3, int i4, c cVar) {
        if (i3 >= cVar.f3859a) {
            return false;
        }
        return V0(i3, i4);
    }

    private e T(int i3, c cVar) throws j {
        e eVarF0;
        VLog.d("BBKCalculator/CalculatorExpr", "evalExprEx: i == " + i3);
        e eVarF1 = f0(i3, cVar);
        int i4 = eVarF1.f3864a;
        com.vivo.calculator.d dVarB = eVarF1.f3865b;
        VLog.d("BBKCalculator/CalculatorExpr", "evalExprEx: val start  == " + dVarB);
        while (true) {
            boolean zT0 = T0(i4, R.id.e_op_add, cVar);
            if (!zT0 && !T0(i4, R.id.e_op_sub, cVar)) {
                VLog.d("BBKCalculator/CalculatorExpr", "evalExprEx: val == " + dVarB);
                return new e(i4, dVarB);
            }
            int i5 = i4 + 1;
            if (a1(i5)) {
                eVarF0 = t0(i5, !zT0, cVar);
                dVarB = dVarB.N(eVarF0.f3865b);
            } else {
                eVarF0 = f0(i5, cVar);
                dVarB = zT0 ? dVarB.b(eVarF0.f3865b) : dVarB.Y(eVarF0.f3865b);
            }
            i4 = eVarF0.f3864a;
        }
    }

    private boolean T0(int i3, int i4, c cVar) {
        if (i3 >= cVar.f3859a) {
            return false;
        }
        return W0(i3, i4);
    }

    private f U(int i3, c cVar) throws j {
        f fVarG0;
        VLog.d("BBKCalculator/CalculatorExpr", "evalExprExchange: i == " + i3);
        f fVarG1 = g0(i3, cVar);
        int i4 = fVarG1.f3866a;
        VLog.d("BBKCalculator/CalculatorExpr", "evalExprExchange: cpos == " + i4);
        com.vivo.calculator.d dVarB = fVarG1.f3867b;
        while (true) {
            boolean zU0 = U0(i4, R.id.e_op_add, cVar);
            if (!zU0 && !U0(i4, R.id.e_op_sub, cVar)) {
                VLog.d("BBKCalculator/CalculatorExpr", "evalExprExchange: val == " + dVarB);
                return new f(i4, dVarB);
            }
            int i5 = i4 + 1;
            if (b1(i5)) {
                fVarG0 = u0(i5, !zU0, cVar);
                dVarB = dVarB.N(fVarG0.f3867b);
            } else {
                fVarG0 = g0(i5, cVar);
                dVarB = zU0 ? dVarB.b(fVarG0.f3867b) : dVarB.Y(fVarG0.f3867b);
            }
            i4 = fVarG0.f3866a;
        }
    }

    private boolean U0(int i3, int i4, c cVar) {
        if (i3 >= cVar.f3859a) {
            return false;
        }
        return X0(i3, i4);
    }

    private d V(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalFactor: ");
        d dVarB0 = b0(i3, cVar);
        int i4 = dVarB0.f3862a;
        com.vivo.calculator.d dVarP = dVarB0.f3863b;
        dVarP.toString().indexOf(46);
        if (S0(i4, R.id.op_pow, cVar)) {
            VLog.d("BBKCalculator/CalculatorExpr", "evalFactor: op_pow ---");
            d dVarY = Y(i4 + 1, cVar);
            i4 = dVarY.f3862a;
            VLog.d("BBKCalculator/CalculatorExpr", "evalFactor: val == " + dVarY.f3863b);
            z(dVarY);
            if (dVarP.toString().startsWith("0/1") && dVarY.f3863b.toString().startsWith("-")) {
                VLog.d("BBKCalculator/CalculatorExpr", "Cannot be divided by 0");
                throw new j();
            }
            dVarP = dVarP.P(dVarY.f3863b);
        }
        VLog.d("BBKCalculator/CalculatorExpr", "evalFactor: val === " + dVarP);
        return new d(i4, dVarP);
    }

    private boolean V0(int i3, int i4) {
        ArrayList<k> arrayList = this.f3848a;
        if (arrayList == null || i3 >= arrayList.size()) {
            return false;
        }
        k kVar = this.f3848a.get(i3);
        return (kVar instanceof h) && ((h) kVar).f3868a == i4;
    }

    private e W(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalFactorEx: start ");
        e eVarC0 = c0(i3, cVar);
        int i4 = eVarC0.f3864a;
        com.vivo.calculator.d dVar = eVarC0.f3865b;
        dVar.toString().indexOf(46);
        VLog.d("BBKCalculator/CalculatorExpr", "evalFactorEx: val 222 cpos=== " + i4 + "val == " + dVar);
        return new e(i4, dVar);
    }

    private boolean W0(int i3, int i4) {
        ArrayList<k> arrayList = this.f3849b;
        if (arrayList == null || i3 >= arrayList.size()) {
            return false;
        }
        k kVar = this.f3849b.get(i3);
        return (kVar instanceof h) && ((h) kVar).f3868a == i4;
    }

    private f X(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalFactorExchange: start");
        f fVarD0 = d0(i3, cVar);
        int i4 = fVarD0.f3866a;
        com.vivo.calculator.d dVar = fVarD0.f3867b;
        dVar.toString().indexOf(46);
        VLog.d("BBKCalculator/CalculatorExpr", "evalFactorExchange: val 222 cpos=== " + i4 + "val == " + dVar);
        return new f(i4, dVar);
    }

    private boolean X0(int i3, int i4) {
        ArrayList<k> arrayList = this.f3850c;
        if (arrayList == null || i3 >= arrayList.size()) {
            return false;
        }
        k kVar = this.f3850c.get(i3);
        return (kVar instanceof h) && ((h) kVar).f3868a == i4;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    private d Y(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalSignedFactor: ");
        boolean zS0 = S0(i3, R.id.op_sub, cVar);
        if (i3 == 0) {
            boolean zS1 = S0(i3, R.id.op_add, cVar);
            if (zS0 || zS1) {
                i3++;
            }
        } else if (zS0) {
            i3++;
        }
        d dVarV = V(i3, cVar);
        int i4 = dVarV.f3862a;
        com.vivo.calculator.d dVarO = dVarV.f3863b;
        if (zS0) {
            dVarO = dVarO.O();
        }
        VLog.d("BBKCalculator/CalculatorExpr", "evalSignedFactor: i end cpos == " + i4 + "  result" + dVarO);
        return new d(i4, dVarO);
    }

    private e Z(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalSignedFactorEx: i == " + i3);
        boolean zT0 = T0(i3, R.id.e_op_sub, cVar);
        if (zT0) {
            i3++;
        }
        e eVarW = W(i3, cVar);
        int i4 = eVarW.f3864a;
        com.vivo.calculator.d dVarO = eVarW.f3865b;
        if (zT0) {
            dVarO = dVarO.O();
        }
        VLog.d("BBKCalculator/CalculatorExpr", "evalSignedFactorEx: i end cpos == " + i4 + "  result" + dVarO);
        return new e(i4, dVarO);
    }

    private boolean Z0(int i3) {
        int i4 = i3 + 2;
        if (this.f3848a.size() < i4 || !V0(i3 + 1, R.id.op_pct) || (this.f3848a.get(i3) instanceof h)) {
            return false;
        }
        if (this.f3848a.size() == i4) {
            return true;
        }
        if (!(this.f3848a.get(i4) instanceof h)) {
            return false;
        }
        int i5 = ((h) this.f3848a.get(i4)).f3868a;
        return i5 == R.id.op_add || i5 == R.id.op_sub || i5 == R.id.rparen;
    }

    private f a0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalSignedFactorExchange: i == " + i3);
        boolean zU0 = U0(i3, R.id.e_op_sub, cVar);
        if (zU0) {
            i3++;
        }
        f fVarX = X(i3, cVar);
        int i4 = fVarX.f3866a;
        com.vivo.calculator.d dVarO = fVarX.f3867b;
        if (zU0) {
            dVarO = dVarO.O();
        }
        VLog.d("BBKCalculator/CalculatorExpr", "evalSignedFactorExchange: i end cpos == " + i4 + "  result" + dVarO);
        return new f(i4, dVarO);
    }

    private boolean a1(int i3) {
        int i4 = i3 + 2;
        if (this.f3849b.size() < i4 || !W0(i3 + 1, R.id.op_pct) || (this.f3849b.get(i3) instanceof h)) {
            return false;
        }
        if (this.f3849b.size() == i4) {
            return true;
        }
        if (!(this.f3849b.get(i4) instanceof h)) {
            return false;
        }
        int i5 = ((h) this.f3849b.get(i4)).f3868a;
        return i5 == R.id.e_op_add || i5 == R.id.e_op_sub;
    }

    private d b0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalSuffix: ");
        d dVarH0 = h0(i3, cVar);
        int i4 = dVarH0.f3862a;
        com.vivo.calculator.d dVarN = dVarH0.f3863b;
        boolean zS0 = false;
        while (true) {
            boolean zS1 = S0(i4, R.id.op_fact, cVar);
            if (!zS1 && !(zS0 = S0(i4, R.id.op_sqr, cVar)) && !S0(i4, R.id.op_pct, cVar)) {
                VLog.d("BBKCalculator/CalculatorExpr", "evalSuffix:cpos  " + i4 + "    val" + dVarN);
                return new d(i4, dVarN);
            }
            if (zS1) {
                dVarN = dVarN.C();
            } else {
                dVarN = zS0 ? dVarN.N(dVarN) : dVarN.N(f3847g);
            }
            i4++;
        }
    }

    private boolean b1(int i3) {
        int i4 = i3 + 2;
        if (this.f3850c.size() < i4 || !X0(i3 + 1, R.id.op_pct) || (this.f3850c.get(i3) instanceof h)) {
            return false;
        }
        if (this.f3850c.size() == i4) {
            return true;
        }
        if (!(this.f3850c.get(i4) instanceof h)) {
            return false;
        }
        int i5 = ((h) this.f3850c.get(i4)).f3868a;
        return i5 == R.id.e_op_add || i5 == R.id.e_op_sub;
    }

    private e c0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalSuffixEx: i == " + i3);
        e eVarI0 = i0(i3, cVar);
        int i4 = eVarI0.f3864a;
        com.vivo.calculator.d dVar = eVarI0.f3865b;
        VLog.d("BBKCalculator/CalculatorExpr", "evalSuffixEx :cpos  " + i4 + "    val" + dVar);
        return new e(i4, dVar);
    }

    private f d0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalSuffixExchange:  i == " + i3);
        f fVarJ0 = j0(i3, cVar);
        int i4 = fVarJ0.f3866a;
        com.vivo.calculator.d dVar = fVarJ0.f3867b;
        VLog.d("BBKCalculator/CalculatorExpr", "evalSuffixExchange :cpos  " + i4 + "    val" + dVar);
        return new f(i4, dVar);
    }

    private d e0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalTerm: ");
        d dVarY = Y(i3, cVar);
        int i4 = dVarY.f3862a;
        com.vivo.calculator.d dVarN = dVarY.f3863b;
        while (true) {
            boolean zS0 = false;
            boolean zS1 = S0(i4, R.id.op_mul, cVar);
            if (!zS1 && !(zS0 = S0(i4, R.id.op_div, cVar)) && !w(i4)) {
                VLog.d("BBKCalculator/CalculatorExpr", "evalTerm: val == " + dVarN);
                return new d(i4, dVarN);
            }
            if (zS1 || zS0) {
                i4++;
            }
            d dVarY2 = Y(i4, cVar);
            if (zS0) {
                dVarN = dVarN.y(dVarY2.f3863b);
            } else {
                if (dVarN.toString().indexOf(46) > 11000) {
                    throw new j();
                }
                dVarN = dVarN.N(dVarY2.f3863b);
                if (dVarN.toString().indexOf(46) > 10004) {
                    throw new j();
                }
            }
            i4 = dVarY2.f3862a;
        }
    }

    private e f0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalTermEx: i == " + i3);
        e eVarZ = Z(i3, cVar);
        int i4 = eVarZ.f3864a;
        com.vivo.calculator.d dVarN = eVarZ.f3865b;
        while (true) {
            boolean zT0 = false;
            boolean zT1 = T0(i4, R.id.e_op_mul, cVar);
            if (!zT1 && !(zT0 = T0(i4, R.id.e_op_div, cVar)) && !x(i4)) {
                VLog.d("BBKCalculator/CalculatorExpr", "evalTermEx: val == " + dVarN);
                VLog.d("BBKCalculator/CalculatorExpr", "evalTermEx: cpos == " + i4);
                return new e(i4, dVarN);
            }
            VLog.d("BBKCalculator/CalculatorExpr", "evalTermEx,is_mul:" + zT1 + ",is_div:" + zT0);
            if (zT1 || zT0) {
                i4++;
            }
            e eVarZ2 = Z(i4, cVar);
            if (zT0) {
                dVarN = dVarN.y(eVarZ2.f3865b);
            } else {
                if (dVarN.toString().indexOf(46) > 11000) {
                    throw new j();
                }
                dVarN = dVarN.N(eVarZ2.f3865b);
                if (dVarN.toString().indexOf(46) > 10004) {
                    throw new j();
                }
            }
            i4 = eVarZ2.f3864a;
        }
    }

    public static k f1(DataInput dataInput) {
        try {
            byte b3 = dataInput.readByte();
            if (b3 >= 32) {
                return new h(b3);
            }
            int i3 = C0046a.f3851a[f3844d[b3].ordinal()];
            if (i3 == 1) {
                return new b(dataInput);
            }
            if (i3 != 2) {
                throw new IOException("Bad save file format");
            }
            i iVar = new i(dataInput);
            if (iVar.f3869a != -1) {
                return iVar;
            }
            b bVar = new b();
            bVar.c(R.id.dec_point);
            return bVar;
        } catch (Exception e3) {
            VLog.e("BBKCalculator/CalculatorExpr", "Exception e = " + e3);
            return null;
        }
    }

    private f g0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalTermExchange: i == " + i3);
        f fVarA0 = a0(i3, cVar);
        int i4 = fVarA0.f3866a;
        com.vivo.calculator.d dVarN = fVarA0.f3867b;
        while (true) {
            boolean zU0 = false;
            boolean zU1 = U0(i4, R.id.e_op_mul, cVar);
            if (!zU1 && !(zU0 = U0(i4, R.id.e_op_div, cVar)) && !y(i4)) {
                VLog.d("BBKCalculator/CalculatorExpr", "evalTermExchange: val == " + dVarN);
                VLog.d("BBKCalculator/CalculatorExpr", "evalTermExchange: cpos == " + i4);
                return new f(i4, dVarN);
            }
            VLog.d("BBKCalculator/CalculatorExpr", "evalTermExchange,is_mul:" + zU1 + ",is_div:" + zU0);
            if (zU1 || zU0) {
                i4++;
            }
            f fVarA1 = a0(i4, cVar);
            if (zU0) {
                dVarN = dVarN.y(fVarA1.f3867b);
            } else {
                if (dVarN.toString().indexOf(46) > 11000) {
                    throw new j();
                }
                dVarN = dVarN.N(fVarA1.f3867b);
                if (dVarN.toString().indexOf(46) > 10004) {
                    throw new j();
                }
            }
            i4 = fVarA1.f3866a;
        }
    }

    public static k g1(DataInput dataInput) {
        try {
            byte b3 = dataInput.readByte();
            if (b3 >= 32) {
                return new h(b3);
            }
            int i3 = C0046a.f3851a[f3844d[b3].ordinal()];
            if (i3 == 1) {
                return new b(dataInput);
            }
            if (i3 != 2) {
                throw new IOException("Bad save file format");
            }
            i iVar = new i(dataInput);
            if (iVar.f3869a != -1) {
                return iVar;
            }
            b bVar = new b();
            bVar.c(R.id.e_dec_point);
            return bVar;
        } catch (Exception e3) {
            VLog.e("BBKCalculator/CalculatorExpr", "Exception e" + e3);
            return null;
        }
    }

    private d h0(int i3, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "evalUnary: ");
        k kVar = this.f3848a.get(i3);
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            StringBuilder sb = new StringBuilder();
            sb.append("evalUnary: 555 ");
            int i4 = i3 + 1;
            sb.append(new d(i4, new com.vivo.calculator.d(bVar.n())).f3863b);
            VLog.d("BBKCalculator/CalculatorExpr", sb.toString());
            return new d(i4, new com.vivo.calculator.d(bVar.n()));
        }
        if (kVar instanceof i) {
            long j3 = ((i) kVar).f3869a;
            com.vivo.calculator.d dVarG = cVar.f3861c.g(j3);
            VLog.d("BBKCalculator/CalculatorExpr", "evalUnary: res === " + dVarG);
            if (dVarG == null) {
                dVarG = c1(j3, cVar.f3861c);
            }
            return new d(i3 + 1, dVarG);
        }
        int i5 = ((h) kVar).f3868a;
        switch (i5) {
            case R.id.EE /* 2131230724 */:
                d dVarY = Y(i3 + 1, cVar);
                VLog.d("BBKCalculator/CalculatorExpr", "evalUnary EE argVal:" + dVarY.f3863b);
                z(dVarY);
                return new d(dVarY.f3862a, com.vivo.calculator.d.f4031z.P(dVarY.f3863b));
            case R.id.lparen /* 2131231069 */:
                d dVarS = S(i3 + 1, cVar);
                if (S0(dVarS.f3862a, R.id.rparen, cVar)) {
                    dVarS.f3862a++;
                }
                return new d(dVarS.f3862a, dVarS.f3863b);
            case R.id.op_sqrt /* 2131231178 */:
                int i6 = i3 + 1;
                if (S0(i6, R.id.op_sub, cVar)) {
                    d dVarH0 = h0(i3 + 2, cVar);
                    return new d(dVarH0.f3862a, dVarH0.f3863b.O().X());
                }
                d dVarH1 = h0(i6, cVar);
                return new d(dVarH1.f3862a, dVarH1.f3863b.X());
            case R.id.rand /* 2131231219 */:
                return new d(i3 + 1, new com.vivo.calculator.d(z1.a.v(Math.random())));
            default:
                switch (i5) {
                    case R.id.const_e /* 2131230855 */:
                        return new d(i3 + 1, com.vivo.calculator.d.f4023r);
                    case R.id.const_pi /* 2131230856 */:
                        return new d(i3 + 1, com.vivo.calculator.d.f4022q);
                    default:
                        switch (i5) {
                            case R.id.fun_arccos /* 2131230978 */:
                                d dVarS2 = S(i3 + 1, cVar);
                                if (S0(dVarS2.f3862a, R.id.rparen, cVar)) {
                                    dVarS2.f3862a++;
                                }
                                return new d(dVarS2.f3862a, p0(dVarS2.f3863b.a(), cVar));
                            case R.id.fun_arccosh /* 2131230979 */:
                                d dVarS3 = S(i3 + 1, cVar);
                                if (S0(dVarS3.f3862a, R.id.rparen, cVar)) {
                                    dVarS3.f3862a++;
                                }
                                int i7 = dVarS3.f3862a;
                                com.vivo.calculator.d dVar = dVarS3.f3863b;
                                com.vivo.calculator.d dVar2 = com.vivo.calculator.d.f4025t;
                                return new d(i7, dVar.b(dVar.Y(dVar2).X().N(dVarS3.f3863b.b(dVar2).X())).M());
                            case R.id.fun_arcsin /* 2131230980 */:
                                d dVarS4 = S(i3 + 1, cVar);
                                if (S0(dVarS4.f3862a, R.id.rparen, cVar)) {
                                    dVarS4.f3862a++;
                                }
                                return new d(dVarS4.f3862a, p0(dVarS4.f3863b.e(), cVar));
                            case R.id.fun_arcsinh /* 2131230981 */:
                                d dVarS5 = S(i3 + 1, cVar);
                                if (S0(dVarS5.f3862a, R.id.rparen, cVar)) {
                                    dVarS5.f3862a++;
                                }
                                int i8 = dVarS5.f3862a;
                                com.vivo.calculator.d dVar3 = dVarS5.f3863b;
                                return new d(i8, dVar3.b(dVar3.P(com.vivo.calculator.d.f4027v).b(com.vivo.calculator.d.f4025t).X()).M());
                            case R.id.fun_arctan /* 2131230982 */:
                                d dVarS6 = S(i3 + 1, cVar);
                                if (S0(dVarS6.f3862a, R.id.rparen, cVar)) {
                                    dVarS6.f3862a++;
                                }
                                return new d(dVarS6.f3862a, p0(dVarS6.f3863b.h(), cVar));
                            case R.id.fun_arctanh /* 2131230983 */:
                                d dVarS7 = S(i3 + 1, cVar);
                                if (S0(dVarS7.f3862a, R.id.rparen, cVar)) {
                                    dVarS7.f3862a++;
                                }
                                int i9 = dVarS7.f3862a;
                                com.vivo.calculator.d dVar4 = com.vivo.calculator.d.f4025t;
                                return new d(i9, dVar4.b(dVarS7.f3863b).M().Y(dVar4.Y(dVarS7.f3863b).M()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_cos /* 2131230984 */:
                                d dVarS8 = S(i3 + 1, cVar);
                                if (S0(dVarS8.f3862a, R.id.rparen, cVar)) {
                                    dVarS8.f3862a++;
                                }
                                return new d(dVarS8.f3862a, l1(dVarS8.f3863b, cVar).o());
                            case R.id.fun_cosh /* 2131230985 */:
                                d dVarS9 = S(i3 + 1, cVar);
                                z(dVarS9);
                                if (S0(dVarS9.f3862a, R.id.rparen, cVar)) {
                                    dVarS9.f3862a++;
                                }
                                return new d(dVarS9.f3862a, dVarS9.f3863b.A().b(dVarS9.f3863b.O().A()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_exp /* 2131230986 */:
                                d dVarY2 = Y(i3 + 1, cVar);
                                VLog.d("BBKCalculator/CalculatorExpr", "evalUnary fun_exp argVal:" + dVarY2.f3863b);
                                z(dVarY2);
                                return new d(dVarY2.f3862a, dVarY2.f3863b.A());
                            case R.id.fun_lg /* 2131230987 */:
                                d dVarS10 = S(i3 + 1, cVar);
                                if (S0(dVarS10.f3862a, R.id.rparen, cVar)) {
                                    dVarS10.f3862a++;
                                }
                                return new d(dVarS10.f3862a, dVarS10.f3863b.M().y(com.vivo.calculator.d.f4031z.M()));
                            case R.id.fun_ln /* 2131230988 */:
                                d dVarS11 = S(i3 + 1, cVar);
                                if (S0(dVarS11.f3862a, R.id.rparen, cVar)) {
                                    dVarS11.f3862a++;
                                }
                                return new d(dVarS11.f3862a, dVarS11.f3863b.M());
                            case R.id.fun_log /* 2131230989 */:
                                d dVarS12 = S(i3 + 1, cVar);
                                if (S0(dVarS12.f3862a, R.id.rparen, cVar)) {
                                    dVarS12.f3862a++;
                                }
                                return new d(dVarS12.f3862a, dVarS12.f3863b.M().y(com.vivo.calculator.d.f4027v.M()));
                            case R.id.fun_sin /* 2131230990 */:
                                d dVarS13 = S(i3 + 1, cVar);
                                if (S0(dVarS13.f3862a, R.id.rparen, cVar)) {
                                    dVarS13.f3862a++;
                                }
                                return new d(dVarS13.f3862a, l1(dVarS13.f3863b, cVar).V());
                            case R.id.fun_sinh /* 2131230991 */:
                                d dVarS14 = S(i3 + 1, cVar);
                                z(dVarS14);
                                if (S0(dVarS14.f3862a, R.id.rparen, cVar)) {
                                    dVarS14.f3862a++;
                                }
                                return new d(dVarS14.f3862a, dVarS14.f3863b.A().Y(dVarS14.f3863b.O().A()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_tan /* 2131230992 */:
                                d dVarS15 = S(i3 + 1, cVar);
                                if (S0(dVarS15.f3862a, R.id.rparen, cVar)) {
                                    dVarS15.f3862a++;
                                }
                                com.vivo.calculator.d dVarL1 = l1(dVarS15.f3863b, cVar);
                                return new d(dVarS15.f3862a, dVarL1.V().y(dVarL1.o()));
                            case R.id.fun_tanh /* 2131230993 */:
                                d dVarS16 = S(i3 + 1, cVar);
                                z(dVarS16);
                                if (S0(dVarS16.f3862a, R.id.rparen, cVar)) {
                                    dVarS16.f3862a++;
                                }
                                return new d(dVarS16.f3862a, dVarS16.f3863b.A().Y(dVarS16.f3863b.O().A()).y(dVarS16.f3863b.A().b(dVarS16.f3863b.O().A())));
                            default:
                                throw new j("Unrecognized token in expression");
                        }
                }
        }
    }

    private e i0(int i3, c cVar) throws j {
        k kVar = this.f3849b.get(i3);
        if (kVar instanceof b) {
            e eVar = new e(i3 + 1, new com.vivo.calculator.d(((b) kVar).n()));
            VLog.d("BBKCalculator/CalculatorExpr", "evalUnaryEx:  ==  Constant " + eVar.f3865b);
            return eVar;
        }
        if (kVar instanceof i) {
            long j3 = ((i) kVar).f3869a;
            VLog.d("BBKCalculator/CalculatorExpr", "evalUnary: PreEval res start=== ");
            com.vivo.calculator.d dVarF = cVar.f3861c.f(j3);
            VLog.d("BBKCalculator/CalculatorExpr", "evalUnary: PreEval res === " + dVarF);
            if (dVarF == null) {
                dVarF = d1(j3, cVar.f3861c);
            }
            return new e(i3 + 1, dVarF);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("evalUnaryEx：");
        h hVar = (h) kVar;
        sb.append(hVar.f3868a);
        VLog.i("BBKCalculator/CalculatorExpr", sb.toString());
        int i4 = hVar.f3868a;
        switch (i4) {
            case R.id.EE /* 2131230724 */:
                e eVarZ = Z(i3 + 1, cVar);
                A(eVarZ);
                if (T0(eVarZ.f3864a, R.id.rparen, cVar)) {
                    eVarZ.f3864a++;
                }
                VLog.d("BBKCalculator/CalculatorExpr", "evalUnaryEx EE argVal:" + eVarZ.f3865b);
                return new e(eVarZ.f3864a, com.vivo.calculator.d.f4031z.P(eVarZ.f3865b));
            case R.id.lparen /* 2131231069 */:
                e eVarT = T(i3 + 1, cVar);
                if (T0(eVarT.f3864a, R.id.rparen, cVar)) {
                    eVarT.f3864a++;
                }
                return new e(eVarT.f3864a, eVarT.f3865b);
            case R.id.op_sqrt /* 2131231178 */:
                int i5 = i3 + 1;
                if (T0(i5, R.id.op_sub, cVar)) {
                    e eVarI0 = i0(i3 + 2, cVar);
                    return new e(eVarI0.f3864a, eVarI0.f3865b.O().X());
                }
                e eVarI1 = i0(i5, cVar);
                return new e(eVarI1.f3864a, eVarI1.f3865b.X());
            case R.id.rand /* 2131231219 */:
                return new e(i3 + 1, new com.vivo.calculator.d(z1.a.v(Math.random())));
            default:
                switch (i4) {
                    case R.id.const_e /* 2131230855 */:
                        return new e(i3 + 1, com.vivo.calculator.d.f4023r);
                    case R.id.const_pi /* 2131230856 */:
                        return new e(i3 + 1, com.vivo.calculator.d.f4022q);
                    default:
                        switch (i4) {
                            case R.id.fun_arccos /* 2131230978 */:
                                e eVarT2 = T(i3 + 1, cVar);
                                if (T0(eVarT2.f3864a, R.id.rparen, cVar)) {
                                    eVarT2.f3864a++;
                                }
                                return new e(eVarT2.f3864a, p0(eVarT2.f3865b.a(), cVar));
                            case R.id.fun_arccosh /* 2131230979 */:
                                e eVarT3 = T(i3 + 1, cVar);
                                if (T0(eVarT3.f3864a, R.id.rparen, cVar)) {
                                    eVarT3.f3864a++;
                                }
                                int i6 = eVarT3.f3864a;
                                com.vivo.calculator.d dVar = eVarT3.f3865b;
                                com.vivo.calculator.d dVar2 = com.vivo.calculator.d.f4025t;
                                return new e(i6, dVar.b(dVar.Y(dVar2).X().N(eVarT3.f3865b.b(dVar2).X())).M());
                            case R.id.fun_arcsin /* 2131230980 */:
                                e eVarT4 = T(i3 + 1, cVar);
                                if (T0(eVarT4.f3864a, R.id.rparen, cVar)) {
                                    eVarT4.f3864a++;
                                }
                                return new e(eVarT4.f3864a, p0(eVarT4.f3865b.e(), cVar));
                            case R.id.fun_arcsinh /* 2131230981 */:
                                e eVarT5 = T(i3 + 1, cVar);
                                if (T0(eVarT5.f3864a, R.id.rparen, cVar)) {
                                    eVarT5.f3864a++;
                                }
                                int i7 = eVarT5.f3864a;
                                com.vivo.calculator.d dVar3 = eVarT5.f3865b;
                                return new e(i7, dVar3.b(dVar3.P(com.vivo.calculator.d.f4027v).b(com.vivo.calculator.d.f4025t).X()).M());
                            case R.id.fun_arctan /* 2131230982 */:
                                e eVarT6 = T(i3 + 1, cVar);
                                if (T0(eVarT6.f3864a, R.id.rparen, cVar)) {
                                    eVarT6.f3864a++;
                                }
                                return new e(eVarT6.f3864a, p0(eVarT6.f3865b.h(), cVar));
                            case R.id.fun_arctanh /* 2131230983 */:
                                e eVarT7 = T(i3 + 1, cVar);
                                if (T0(eVarT7.f3864a, R.id.rparen, cVar)) {
                                    eVarT7.f3864a++;
                                }
                                int i8 = eVarT7.f3864a;
                                com.vivo.calculator.d dVar4 = com.vivo.calculator.d.f4025t;
                                return new e(i8, dVar4.b(eVarT7.f3865b).M().Y(dVar4.Y(eVarT7.f3865b).M()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_cos /* 2131230984 */:
                                e eVarT8 = T(i3 + 1, cVar);
                                if (T0(eVarT8.f3864a, R.id.rparen, cVar)) {
                                    eVarT8.f3864a++;
                                }
                                return new e(eVarT8.f3864a, l1(eVarT8.f3865b, cVar).o());
                            case R.id.fun_cosh /* 2131230985 */:
                                e eVarT9 = T(i3 + 1, cVar);
                                A(eVarT9);
                                if (T0(eVarT9.f3864a, R.id.rparen, cVar)) {
                                    eVarT9.f3864a++;
                                }
                                return new e(eVarT9.f3864a, eVarT9.f3865b.A().b(eVarT9.f3865b.O().A()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_exp /* 2131230986 */:
                                e eVarZ2 = Z(i3 + 1, cVar);
                                A(eVarZ2);
                                if (T0(eVarZ2.f3864a, R.id.rparen, cVar)) {
                                    eVarZ2.f3864a++;
                                }
                                return new e(eVarZ2.f3864a, eVarZ2.f3865b.A());
                            case R.id.fun_lg /* 2131230987 */:
                                e eVarT10 = T(i3 + 1, cVar);
                                if (T0(eVarT10.f3864a, R.id.rparen, cVar)) {
                                    eVarT10.f3864a++;
                                }
                                return new e(eVarT10.f3864a, eVarT10.f3865b.M().y(com.vivo.calculator.d.f4031z.M()));
                            case R.id.fun_ln /* 2131230988 */:
                                e eVarT11 = T(i3 + 1, cVar);
                                if (T0(eVarT11.f3864a, R.id.rparen, cVar)) {
                                    eVarT11.f3864a++;
                                }
                                return new e(eVarT11.f3864a, eVarT11.f3865b.M());
                            case R.id.fun_log /* 2131230989 */:
                                e eVarT12 = T(i3 + 1, cVar);
                                if (T0(eVarT12.f3864a, R.id.rparen, cVar)) {
                                    eVarT12.f3864a++;
                                }
                                return new e(eVarT12.f3864a, eVarT12.f3865b.M().y(com.vivo.calculator.d.f4027v.M()));
                            case R.id.fun_sin /* 2131230990 */:
                                e eVarT13 = T(i3 + 1, cVar);
                                if (T0(eVarT13.f3864a, R.id.rparen, cVar)) {
                                    eVarT13.f3864a++;
                                }
                                return new e(eVarT13.f3864a, l1(eVarT13.f3865b, cVar).V());
                            case R.id.fun_sinh /* 2131230991 */:
                                e eVarT14 = T(i3 + 1, cVar);
                                A(eVarT14);
                                if (T0(eVarT14.f3864a, R.id.rparen, cVar)) {
                                    eVarT14.f3864a++;
                                }
                                return new e(eVarT14.f3864a, eVarT14.f3865b.A().Y(eVarT14.f3865b.O().A()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_tan /* 2131230992 */:
                                e eVarT15 = T(i3 + 1, cVar);
                                if (T0(eVarT15.f3864a, R.id.rparen, cVar)) {
                                    eVarT15.f3864a++;
                                }
                                com.vivo.calculator.d dVarL1 = l1(eVarT15.f3865b, cVar);
                                return new e(eVarT15.f3864a, dVarL1.V().y(dVarL1.o()));
                            case R.id.fun_tanh /* 2131230993 */:
                                e eVarT16 = T(i3 + 1, cVar);
                                A(eVarT16);
                                if (T0(eVarT16.f3864a, R.id.rparen, cVar)) {
                                    eVarT16.f3864a++;
                                }
                                return new e(eVarT16.f3864a, eVarT16.f3865b.A().Y(eVarT16.f3865b.O().A()).y(eVarT16.f3865b.A().b(eVarT16.f3865b.O().A())));
                            default:
                                VLog.e("BBKCalculator/CalculatorExpr", "evalUnaryEx: Unable to calculate:" + hVar.f3868a);
                                throw new j("Unrecognized token in expression");
                        }
                }
        }
    }

    private f j0(int i3, c cVar) throws j {
        k kVar = this.f3850c.get(i3);
        if (kVar instanceof b) {
            f fVar = new f(i3 + 1, new com.vivo.calculator.d(((b) kVar).n()));
            VLog.d("BBKCalculator/CalculatorExpr", "evalUnaryExchange:  Constant ==  " + fVar.f3867b);
            return fVar;
        }
        if (kVar instanceof i) {
            long j3 = ((i) kVar).f3869a;
            com.vivo.calculator.d dVarD = cVar.f3861c.d(j3);
            VLog.d("BBKCalculator/CalculatorExpr", "evalUnaryExchange: PreEval res === " + dVarD);
            if (dVarD == null) {
                dVarD = e1(j3, cVar.f3861c);
            }
            return new f(i3 + 1, dVarD);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("evalUnaryExchange：");
        h hVar = (h) kVar;
        sb.append(hVar.f3868a);
        VLog.i("BBKCalculator/CalculatorExpr", sb.toString());
        int i4 = hVar.f3868a;
        switch (i4) {
            case R.id.EE /* 2131230724 */:
                f fVarA0 = a0(i3 + 1, cVar);
                if (U0(fVarA0.f3866a, R.id.rparen, cVar)) {
                    fVarA0.f3866a++;
                }
                VLog.d("BBKCalculator/CalculatorExpr", "evalUnaryExchange EE argVal:" + fVarA0.f3867b);
                B(fVarA0);
                return new f(fVarA0.f3866a, com.vivo.calculator.d.f4031z.P(fVarA0.f3867b));
            case R.id.lparen /* 2131231069 */:
                f fVarU = U(i3 + 1, cVar);
                if (U0(fVarU.f3866a, R.id.rparen, cVar)) {
                    fVarU.f3866a++;
                }
                return new f(fVarU.f3866a, fVarU.f3867b);
            case R.id.op_sqrt /* 2131231178 */:
                int i5 = i3 + 1;
                if (U0(i5, R.id.op_sub, cVar)) {
                    f fVarJ0 = j0(i3 + 2, cVar);
                    return new f(fVarJ0.f3866a, fVarJ0.f3867b.O().X());
                }
                f fVarJ1 = j0(i5, cVar);
                return new f(fVarJ1.f3866a, fVarJ1.f3867b.X());
            case R.id.rand /* 2131231219 */:
                return new f(i3 + 1, new com.vivo.calculator.d(z1.a.v(Math.random())));
            default:
                switch (i4) {
                    case R.id.const_e /* 2131230855 */:
                        return new f(i3 + 1, com.vivo.calculator.d.f4023r);
                    case R.id.const_pi /* 2131230856 */:
                        return new f(i3 + 1, com.vivo.calculator.d.f4022q);
                    default:
                        switch (i4) {
                            case R.id.fun_arccos /* 2131230978 */:
                                f fVarU2 = U(i3 + 1, cVar);
                                if (U0(fVarU2.f3866a, R.id.rparen, cVar)) {
                                    fVarU2.f3866a++;
                                }
                                return new f(fVarU2.f3866a, p0(fVarU2.f3867b.a(), cVar));
                            case R.id.fun_arccosh /* 2131230979 */:
                                f fVarU3 = U(i3 + 1, cVar);
                                if (U0(fVarU3.f3866a, R.id.rparen, cVar)) {
                                    fVarU3.f3866a++;
                                }
                                int i6 = fVarU3.f3866a;
                                com.vivo.calculator.d dVar = fVarU3.f3867b;
                                com.vivo.calculator.d dVar2 = com.vivo.calculator.d.f4025t;
                                return new f(i6, dVar.b(dVar.Y(dVar2).X().N(fVarU3.f3867b.b(dVar2).X())).M());
                            case R.id.fun_arcsin /* 2131230980 */:
                                f fVarU4 = U(i3 + 1, cVar);
                                if (U0(fVarU4.f3866a, R.id.rparen, cVar)) {
                                    fVarU4.f3866a++;
                                }
                                return new f(fVarU4.f3866a, p0(fVarU4.f3867b.e(), cVar));
                            case R.id.fun_arcsinh /* 2131230981 */:
                                f fVarU5 = U(i3 + 1, cVar);
                                if (U0(fVarU5.f3866a, R.id.rparen, cVar)) {
                                    fVarU5.f3866a++;
                                }
                                int i7 = fVarU5.f3866a;
                                com.vivo.calculator.d dVar3 = fVarU5.f3867b;
                                return new f(i7, dVar3.b(dVar3.P(com.vivo.calculator.d.f4027v).b(com.vivo.calculator.d.f4025t).X()).M());
                            case R.id.fun_arctan /* 2131230982 */:
                                f fVarU6 = U(i3 + 1, cVar);
                                if (U0(fVarU6.f3866a, R.id.rparen, cVar)) {
                                    fVarU6.f3866a++;
                                }
                                return new f(fVarU6.f3866a, p0(fVarU6.f3867b.h(), cVar));
                            case R.id.fun_arctanh /* 2131230983 */:
                                f fVarU7 = U(i3 + 1, cVar);
                                if (U0(fVarU7.f3866a, R.id.rparen, cVar)) {
                                    fVarU7.f3866a++;
                                }
                                int i8 = fVarU7.f3866a;
                                com.vivo.calculator.d dVar4 = com.vivo.calculator.d.f4025t;
                                return new f(i8, dVar4.b(fVarU7.f3867b).M().Y(dVar4.Y(fVarU7.f3867b).M()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_cos /* 2131230984 */:
                                f fVarU8 = U(i3 + 1, cVar);
                                if (U0(fVarU8.f3866a, R.id.rparen, cVar)) {
                                    fVarU8.f3866a++;
                                }
                                return new f(fVarU8.f3866a, l1(fVarU8.f3867b, cVar).o());
                            case R.id.fun_cosh /* 2131230985 */:
                                f fVarU9 = U(i3 + 1, cVar);
                                fVarU9.f3867b.toString().split("/");
                                B(fVarU9);
                                if (U0(fVarU9.f3866a, R.id.rparen, cVar)) {
                                    fVarU9.f3866a++;
                                }
                                return new f(fVarU9.f3866a, fVarU9.f3867b.A().b(fVarU9.f3867b.O().A()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_exp /* 2131230986 */:
                                f fVarA1 = a0(i3 + 1, cVar);
                                B(fVarA1);
                                if (U0(fVarA1.f3866a, R.id.rparen, cVar)) {
                                    fVarA1.f3866a++;
                                }
                                return new f(fVarA1.f3866a, fVarA1.f3867b.A());
                            case R.id.fun_lg /* 2131230987 */:
                                f fVarU10 = U(i3 + 1, cVar);
                                if (U0(fVarU10.f3866a, R.id.rparen, cVar)) {
                                    fVarU10.f3866a++;
                                }
                                return new f(fVarU10.f3866a, fVarU10.f3867b.M().y(com.vivo.calculator.d.f4031z.M()));
                            case R.id.fun_ln /* 2131230988 */:
                                f fVarU11 = U(i3 + 1, cVar);
                                if (U0(fVarU11.f3866a, R.id.rparen, cVar)) {
                                    fVarU11.f3866a++;
                                }
                                return new f(fVarU11.f3866a, fVarU11.f3867b.M());
                            case R.id.fun_log /* 2131230989 */:
                                f fVarU12 = U(i3 + 1, cVar);
                                if (U0(fVarU12.f3866a, R.id.rparen, cVar)) {
                                    fVarU12.f3866a++;
                                }
                                return new f(fVarU12.f3866a, fVarU12.f3867b.M().y(com.vivo.calculator.d.f4027v.M()));
                            case R.id.fun_sin /* 2131230990 */:
                                f fVarU13 = U(i3 + 1, cVar);
                                if (U0(fVarU13.f3866a, R.id.rparen, cVar)) {
                                    fVarU13.f3866a++;
                                }
                                return new f(fVarU13.f3866a, l1(fVarU13.f3867b, cVar).V());
                            case R.id.fun_sinh /* 2131230991 */:
                                f fVarU14 = U(i3 + 1, cVar);
                                B(fVarU14);
                                if (U0(fVarU14.f3866a, R.id.rparen, cVar)) {
                                    fVarU14.f3866a++;
                                }
                                return new f(fVarU14.f3866a, fVarU14.f3867b.A().Y(fVarU14.f3867b.O().A()).y(com.vivo.calculator.d.f4027v));
                            case R.id.fun_tan /* 2131230992 */:
                                f fVarU15 = U(i3 + 1, cVar);
                                if (U0(fVarU15.f3866a, R.id.rparen, cVar)) {
                                    fVarU15.f3866a++;
                                }
                                com.vivo.calculator.d dVarL1 = l1(fVarU15.f3867b, cVar);
                                return new f(fVarU15.f3866a, dVarL1.V().y(dVarL1.o()));
                            case R.id.fun_tanh /* 2131230993 */:
                                f fVarU16 = U(i3 + 1, cVar);
                                B(fVarU16);
                                if (U0(fVarU16.f3866a, R.id.rparen, cVar)) {
                                    fVarU16.f3866a++;
                                }
                                return new f(fVarU16.f3866a, fVarU16.f3867b.A().Y(fVarU16.f3867b.O().A()).y(fVarU16.f3867b.A().b(fVarU16.f3867b.O().A())));
                            default:
                                VLog.e("BBKCalculator/CalculatorExpr", "evalUnaryExchange: Unable to calculate");
                                throw new j("Unrecognized token in expression");
                        }
                }
        }
    }

    private void k(k kVar, boolean z2) {
        if (z2) {
            this.f3848a.add(kVar);
        } else {
            ArrayList<k> arrayList = this.f3848a;
            arrayList.add(arrayList.size() - 1, kVar);
        }
    }

    private void l(ArrayList<Long> arrayList, g gVar) {
        if (this.f3848a == null) {
            return;
        }
        VLog.d("BBKCalculator/CalculatorExpr", "  addReferencedExprs: ");
        ArrayList<k> arrayList2 = new ArrayList();
        arrayList2.addAll(this.f3848a);
        for (k kVar : arrayList2) {
            if (kVar instanceof i) {
                Long lValueOf = Long.valueOf(((i) kVar).f3869a);
                VLog.d("BBKCalculator/CalculatorExpr", "  addReferencedExprs: index " + lValueOf);
                if (gVar.g(lValueOf.longValue()) == null && !arrayList.contains(lValueOf)) {
                    arrayList.add(lValueOf);
                }
            }
        }
    }

    private com.vivo.calculator.d l1(com.vivo.calculator.d dVar, c cVar) {
        return cVar.f3860b ? dVar.N(com.vivo.calculator.d.A) : dVar;
    }

    private void m(ArrayList<Long> arrayList, g gVar) {
        if (this.f3849b == null) {
            return;
        }
        VLog.d("BBKCalculator/CalculatorExpr", "  addReferencedExprsEx: size == " + this.f3849b.size());
        for (k kVar : this.f3849b) {
            if (kVar instanceof i) {
                Long lValueOf = Long.valueOf(((i) kVar).f3869a);
                VLog.d("BBKCalculator/CalculatorExpr", "  addReferencedExprsEx: index " + lValueOf);
                if (gVar.f(lValueOf.longValue()) == null && !arrayList.contains(lValueOf)) {
                    arrayList.add(lValueOf);
                }
            }
        }
    }

    private void n(ArrayList<Long> arrayList, g gVar) {
        VLog.d("BBKCalculator/CalculatorExpr", "  addReferencedExprs: ");
        ArrayList<k> arrayList2 = this.f3850c;
        if (arrayList2 == null) {
            return;
        }
        for (k kVar : arrayList2) {
            if (kVar instanceof i) {
                Long lValueOf = Long.valueOf(((i) kVar).f3869a);
                VLog.d("BBKCalculator/CalculatorExpr", "  addReferencedExprs: index " + lValueOf);
                if (gVar.d(lValueOf.longValue()) == null && !arrayList.contains(lValueOf)) {
                    arrayList.add(lValueOf);
                }
            }
        }
    }

    private void o(int i3, int i4, b bVar, b bVar2) {
        if (TextUtils.isEmpty(bVar.toString())) {
            this.f3848a.add(i4, new h(i3));
            this.f3848a.add(i4 + 1, bVar2);
        } else {
            this.f3848a.add(i4, bVar);
            this.f3848a.add(i4 + 1, new h(i3));
            this.f3848a.add(i4 + 2, bVar2);
        }
    }

    private void p(int i3, int i4, b bVar, b bVar2, boolean z2) {
        if (z2) {
            if (TextUtils.isEmpty(bVar.toString())) {
                this.f3849b.add(i4, new h(i3));
                this.f3849b.add(i4 + 1, bVar2);
                return;
            } else {
                this.f3849b.add(i4, bVar);
                this.f3849b.add(i4 + 1, new h(i3));
                this.f3849b.add(i4 + 2, bVar2);
                return;
            }
        }
        if (TextUtils.isEmpty(bVar.toString())) {
            this.f3850c.add(i4, new h(i3));
            this.f3850c.add(i4 + 1, bVar2);
        } else {
            this.f3850c.add(i4, bVar);
            this.f3850c.add(i4 + 1, new h(i3));
            this.f3850c.add(i4 + 2, bVar2);
        }
    }

    private com.vivo.calculator.d p0(com.vivo.calculator.d dVar, c cVar) {
        return cVar.f3860b ? dVar.y(com.vivo.calculator.d.A) : dVar;
    }

    private int p1() {
        int size = this.f3848a.size();
        while (size > 0) {
            k kVar = this.f3848a.get(size - 1);
            if (!(kVar instanceof h) || !z1.e.l(((h) kVar).f3868a)) {
                break;
            }
            size--;
        }
        VLog.d("BBKCalculator/CalculatorExpr", "trailingBinaryOpsStart:result ==  " + size);
        return size;
    }

    private int q1() {
        int size = this.f3849b.size();
        while (size > 0) {
            k kVar = this.f3849b.get(size - 1);
            if (!(kVar instanceof h) || !z1.e.l(((h) kVar).f3868a)) {
                break;
            }
            size--;
        }
        VLog.d("BBKCalculator/CalculatorExpr", "trailingBinaryOpsStartEx:result ==  " + size);
        return size;
    }

    private int r1() {
        int size = this.f3850c.size();
        while (size > 0) {
            k kVar = this.f3850c.get(size - 1);
            if (!(kVar instanceof h) || !z1.e.l(((h) kVar).f3868a)) {
                break;
            }
            size--;
        }
        VLog.d("BBKCalculator/CalculatorExpr", "trailingBinaryOpsStartExchange:result ==  " + size);
        return size;
    }

    private d s0(int i3, boolean z2, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "getPercentFactor: ");
        com.vivo.calculator.d dVarO = h0(i3, cVar).f3863b;
        if (z2) {
            dVarO = dVarO.O();
        }
        return new d(i3 + 2, com.vivo.calculator.d.f4025t.b(dVarO.N(f3847g)));
    }

    private e t0(int i3, boolean z2, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "getPercentFactorEx: ");
        com.vivo.calculator.d dVarO = i0(i3, cVar).f3865b;
        if (z2) {
            dVarO = dVarO.O();
        }
        return new e(i3 + 2, com.vivo.calculator.d.f4025t.b(dVarO.N(f3847g)));
    }

    private f u0(int i3, boolean z2, c cVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "getPercentFactorExchange: ");
        com.vivo.calculator.d dVarO = j0(i3, cVar).f3867b;
        if (z2) {
            dVarO = dVarO.O();
        }
        return new f(i3 + 2, com.vivo.calculator.d.f4025t.b(dVarO.N(f3847g)));
    }

    private int v0(Context context, int i3) {
        if (this.f3848a.size() == 0) {
            return 0;
        }
        k kVar = this.f3848a.get(i3);
        return kVar instanceof b ? kVar.toString().length() : kVar.a(context).length();
    }

    private boolean w(int i3) {
        if (i3 >= this.f3848a.size()) {
            return false;
        }
        k kVar = this.f3848a.get(i3);
        if (!(kVar instanceof h)) {
            return true;
        }
        int i4 = ((h) kVar).f3868a;
        return (z1.e.l(i4) || i4 == R.id.op_fact || i4 == R.id.rparen) ? false : true;
    }

    private int w0(Context context, int i3, boolean z2) {
        k kVar;
        if (z2) {
            if (this.f3849b.size() == 0) {
                return 0;
            }
            kVar = this.f3849b.get(i3);
        } else {
            if (this.f3850c.size() == 0) {
                return 0;
            }
            kVar = this.f3850c.get(i3);
        }
        return kVar instanceof b ? kVar.toString().length() : kVar.a(context).length();
    }

    private boolean x(int i3) {
        if (i3 >= this.f3849b.size()) {
            return false;
        }
        k kVar = this.f3849b.get(i3);
        if (!(kVar instanceof h)) {
            return true;
        }
        int i4 = ((h) kVar).f3868a;
        return (z1.e.l(i4) || i4 == R.id.op_fact || i4 == R.id.rparen) ? false : true;
    }

    private boolean y(int i3) {
        if (i3 >= this.f3850c.size()) {
            return false;
        }
        k kVar = this.f3850c.get(i3);
        if (!(kVar instanceof h)) {
            return true;
        }
        int i4 = ((h) kVar).f3868a;
        return (z1.e.l(i4) || i4 == R.id.op_fact || i4 == R.id.rparen) ? false : true;
    }

    private void z(d dVar) throws j {
        String strZ = dVar.f3863b.Z(0);
        if (strZ.indexOf(45) < 0 && strZ.length() > 4) {
            throw new j();
        }
    }

    public boolean A0() {
        p1();
        int size = this.f3848a.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!(this.f3848a.get(i3) instanceof b)) {
                return true;
            }
        }
        return false;
    }

    public boolean B0() {
        VLog.d("BBKCalculator/CalculatorExpr", "hasInterestingOpsEx: mExprEx ==  " + this.f3849b);
        int size = this.f3849b.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!(this.f3849b.get(i3) instanceof b)) {
                return true;
            }
        }
        return false;
    }

    public void C() {
        ArrayList<k> arrayList = this.f3848a;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public boolean C0() {
        VLog.d("BBKCalculator/CalculatorExpr", "hasInterestingOpsExchange: mExprExchange ==  " + this.f3850c);
        int size = this.f3850c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!(this.f3850c.get(i3) instanceof b)) {
                return true;
            }
        }
        return false;
    }

    public void D() {
        ArrayList<k> arrayList = this.f3849b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void D0() {
        if (this.f3848a.size() < 4) {
            return;
        }
        ArrayList<k> arrayList = this.f3848a;
        k kVar = arrayList.get(arrayList.size() - 1);
        if ((kVar instanceof h ? ((h) kVar).f3868a : 0) == R.id.rparen) {
            ArrayList<k> arrayList2 = this.f3848a;
            if (arrayList2.get(arrayList2.size() - 2) instanceof b) {
                ArrayList<k> arrayList3 = this.f3848a;
                k kVar2 = arrayList3.get(arrayList3.size() - 3);
                ArrayList<k> arrayList4 = this.f3848a;
                k kVar3 = arrayList4.get(arrayList4.size() - 4);
                int i3 = kVar2 instanceof h ? ((h) kVar2).f3868a : 0;
                int i4 = kVar3 instanceof h ? ((h) kVar3).f3868a : 0;
                if (i3 == R.id.op_sub && i4 == R.id.lparen) {
                    ArrayList<k> arrayList5 = this.f3848a;
                    arrayList5.remove(arrayList5.size() - 1);
                    ArrayList<k> arrayList6 = this.f3848a;
                    arrayList6.remove(arrayList6.size() - 2);
                    ArrayList<k> arrayList7 = this.f3848a;
                    arrayList7.remove(arrayList7.size() - 2);
                }
            }
        }
    }

    public void E() {
        VLog.d("BBKCalculator/CalculatorExpr", "clearExchange: clear");
        ArrayList<k> arrayList = this.f3850c;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public boolean E0(Context context, int i3) {
        if (!N0(context, R.id.op_mul, i3)) {
            return false;
        }
        int size = this.f3848a.size();
        int iK0 = k0(context, i3);
        k kVar = size == 0 ? null : this.f3848a.get(iK0);
        if (kVar instanceof b) {
            String strSubstring = kVar.toString().substring(0, i3 - q0(context, iK0));
            if (!strSubstring.contains(BuildConfig.FLAVOR + z1.e.h()) && strSubstring.length() <= 4) {
                if (strSubstring.contains(BuildConfig.FLAVOR + z1.e.i())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object F() {
        a aVar = new a(true);
        for (k kVar : this.f3849b) {
            if (kVar instanceof b) {
                aVar.f3849b.add((k) ((b) kVar).clone());
            } else {
                aVar.f3849b.add(kVar);
            }
        }
        return aVar;
    }

    boolean F0() {
        int size = this.f3848a.size();
        if (size == 0) {
            return false;
        }
        k kVar = this.f3848a.get(size - 1);
        if (kVar instanceof h) {
            return z1.e.l(((h) kVar).f3868a);
        }
        return false;
    }

    public Object G() {
        a aVar = new a(false, false);
        for (k kVar : this.f3850c) {
            if (kVar instanceof b) {
                aVar.f3850c.add((k) ((b) kVar).clone());
            } else {
                aVar.f3850c.add(kVar);
            }
        }
        return aVar;
    }

    public void H() {
        int size = this.f3848a.size();
        if (size == 0) {
            return;
        }
        int i3 = size - 1;
        k kVar = this.f3848a.get(i3);
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            bVar.g();
            if (!bVar.k()) {
                return;
            }
        }
        this.f3848a.remove(i3);
    }

    public void I(Context context, int i3) {
        if (this.f3848a.size() != 0) {
            int iK0 = k0(context, i3);
            k kVar = this.f3848a.get(iK0);
            if (kVar instanceof b) {
                b bVar = (b) kVar;
                bVar.h(i3 - q0(context, iK0));
                if (!bVar.k()) {
                    return;
                }
            }
            this.f3848a.remove(iK0);
        }
    }

    boolean I0() {
        int size = this.f3849b.size();
        if (size == 0) {
            return false;
        }
        k kVar = this.f3849b.get(size - 1);
        if (kVar instanceof h) {
            return z1.e.l(((h) kVar).f3868a);
        }
        return false;
    }

    public void J(Context context, int i3, boolean z2) {
        if (z2) {
            if (this.f3849b.size() != 0) {
                int iL0 = l0(context, i3, z2);
                k kVar = this.f3849b.get(iL0);
                if (kVar instanceof b) {
                    b bVar = (b) kVar;
                    bVar.h(i3 - r0(context, iL0, z2));
                    if (!bVar.k()) {
                        return;
                    }
                }
                this.f3849b.remove(iL0);
                return;
            }
            return;
        }
        if (this.f3850c.size() != 0) {
            int iL1 = l0(context, i3, z2);
            k kVar2 = this.f3850c.get(iL1);
            if (kVar2 instanceof b) {
                b bVar2 = (b) kVar2;
                bVar2.h(i3 - r0(context, iL1, z2));
                if (!bVar2.k()) {
                    return;
                }
            }
            this.f3850c.remove(iL1);
        }
    }

    boolean J0() {
        int size = this.f3850c.size();
        if (size == 0) {
            return false;
        }
        k kVar = this.f3850c.get(size - 1);
        if (kVar instanceof h) {
            return z1.e.l(((h) kVar).f3868a);
        }
        return false;
    }

    public String K(Context context, int i3) {
        int size = this.f3848a.size();
        if (size == 0) {
            return null;
        }
        int iK0 = k0(context, i3);
        VLog.d("BBKCalculator/CalculatorExpr", "deleteAndCombineNumber,pos:" + iK0);
        k kVar = this.f3848a.get(iK0);
        if (iK0 > 0 && iK0 < size - 1) {
            int i4 = iK0 + 1;
            k kVar2 = this.f3848a.get(i4);
            if ((this.f3848a.get(iK0 - 1) instanceof b) && (kVar2 instanceof b)) {
                String string = ((b) kVar2).toString();
                this.f3848a.remove(i4);
                this.f3848a.remove(iK0);
                return string;
            }
        }
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            bVar.h(i3 - q0(context, iK0));
            if (!bVar.k()) {
                return null;
            }
        }
        this.f3848a.remove(iK0);
        return null;
    }

    boolean K0() {
        int size = this.f3848a.size();
        if (size == 0) {
            return false;
        }
        return this.f3848a.get(size - 1) instanceof b;
    }

    public String L(Context context, int i3) {
        int size = this.f3849b.size();
        if (size == 0) {
            return null;
        }
        int iL0 = l0(context, i3, true);
        k kVar = this.f3849b.get(iL0);
        if (iL0 > 0 && iL0 < size - 1) {
            int i4 = iL0 + 1;
            k kVar2 = this.f3849b.get(i4);
            if ((this.f3849b.get(iL0 - 1) instanceof b) && (kVar2 instanceof b)) {
                String string = ((b) kVar2).toString();
                this.f3849b.remove(i4);
                this.f3849b.remove(iL0);
                return string;
            }
        }
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            bVar.h(i3 - r0(context, iL0, true));
            if (!bVar.k()) {
                return null;
            }
        }
        this.f3849b.remove(iL0);
        return null;
    }

    public boolean L0() {
        ArrayList<k> arrayList = this.f3848a;
        if (arrayList == null) {
            return false;
        }
        for (k kVar : arrayList) {
            if ((kVar instanceof h) && z1.e.q(((h) kVar).f3868a)) {
                return true;
            }
        }
        return false;
    }

    public String M(Context context, int i3) {
        int size = this.f3850c.size();
        if (size == 0) {
            return null;
        }
        int iL0 = l0(context, i3, false);
        k kVar = this.f3850c.get(iL0);
        if (iL0 > 0 && iL0 < size - 1) {
            int i4 = iL0 + 1;
            k kVar2 = this.f3850c.get(i4);
            if ((this.f3850c.get(iL0 - 1) instanceof b) && (kVar2 instanceof b)) {
                String string = ((b) kVar2).toString();
                this.f3850c.remove(i4);
                this.f3850c.remove(iL0);
                return string;
            }
        }
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            bVar.h(i3 - r0(context, iL0, false));
            if (!bVar.k()) {
                return null;
            }
        }
        this.f3850c.remove(iL0);
        return null;
    }

    public int M0() {
        ArrayList<k> arrayList = this.f3848a;
        k kVar = arrayList.get(arrayList.size() - 1);
        VLog.d("BBKCalculator/CalculatorExpr", "indexOfPND tk:" + kVar.toString());
        if (kVar instanceof b) {
            return kVar.toString().length();
        }
        return 0;
    }

    public void N() {
        int size = this.f3849b.size();
        if (size == 0) {
            return;
        }
        int i3 = size - 1;
        k kVar = this.f3849b.get(i3);
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            bVar.g();
            if (!bVar.k()) {
                return;
            }
        }
        this.f3849b.remove(i3);
    }

    public boolean N0(Context context, int i3, int i4) {
        if (!z1.e.l(i3)) {
            return false;
        }
        int iK0 = k0(context, i4);
        return i4 - q0(context, iK0) <= v0(context, iK0);
    }

    public void O() {
        int size = this.f3850c.size();
        if (size == 0) {
            return;
        }
        int i3 = size - 1;
        k kVar = this.f3850c.get(i3);
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            bVar.g();
            if (!bVar.k()) {
                return;
            }
        }
        this.f3850c.remove(i3);
    }

    public boolean O0(Context context, int i3, int i4, boolean z2) {
        if (!z1.e.l(i3)) {
            return false;
        }
        int iL0 = l0(context, i4, z2);
        return i4 - r0(context, iL0, z2) <= w0(context, iL0, z2);
    }

    com.vivo.calculator.d P(boolean z2, g gVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "  eval: degreeMode " + z2);
        Iterator<Long> it = x0(gVar).iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            VLog.d("BBKCalculator/CalculatorExpr", "  eval: ");
            c1(jLongValue, gVar);
        }
        try {
            int iP1 = p1();
            d dVarS = S(0, new c(z2, iP1, gVar));
            VLog.d("BBKCalculator/CalculatorExpr", "  eval: res " + dVarS);
            if (dVarS.f3862a == iP1) {
                return dVarS.f3863b;
            }
            throw new j("Failed to parse full expression");
        } catch (IndexOutOfBoundsException unused) {
            throw new j("Unexpected expression end");
        }
    }

    public boolean P0() {
        return this.f3848a.isEmpty();
    }

    com.vivo.calculator.d Q(boolean z2, g gVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "  evalEx: degreeMode " + z2);
        Iterator<Long> it = y0(gVar).iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            VLog.d("BBKCalculator/CalculatorExpr", " evalEx:  nestedEvalEx ");
            d1(jLongValue, gVar);
        }
        try {
            int iQ1 = q1();
            e eVarT = T(0, new c(z2, iQ1, gVar));
            VLog.d("BBKCalculator/CalculatorExpr", "  evalEx: res == " + eVarT + ",res.pos : " + eVarT.f3864a + ",prefixLen:" + iQ1);
            if (eVarT.f3864a == iQ1) {
                return eVarT.f3865b;
            }
            throw new j("Failed to parse full expression");
        } catch (IndexOutOfBoundsException unused) {
            throw new j("Unexpected expression end");
        }
    }

    public boolean Q0() {
        return this.f3849b.isEmpty();
    }

    com.vivo.calculator.d R(boolean z2, g gVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "  evalExchange: degreeMode " + z2);
        Iterator<Long> it = z0(gVar).iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            VLog.d("BBKCalculator/CalculatorExpr", "  evalExchange ==== : ");
            e1(jLongValue, gVar);
        }
        try {
            int iR1 = r1();
            f fVarU = U(0, new c(z2, iR1, gVar));
            VLog.d("BBKCalculator/CalculatorExpr", "  evalExchange: res " + fVarU);
            if (fVarU.f3866a == iR1) {
                return fVarU.f3867b;
            }
            throw new j("Failed to parse full expression");
        } catch (IndexOutOfBoundsException unused) {
            throw new j("Unexpected expression end");
        }
    }

    public boolean R0() {
        return this.f3850c.isEmpty();
    }

    boolean Y0() {
        int size = this.f3848a.size();
        return (size == 0 ? null : this.f3848a.get(size - 1)) instanceof b;
    }

    public a a(long j3, String str, String str2) {
        if (g2.b.f4760a) {
            g2.b.f4760a = false;
            str = str.replace(",", BuildConfig.FLAVOR);
            str2 = str2.replace(",", BuildConfig.FLAVOR);
        }
        a aVar = new a();
        aVar.f3848a.add(new i(j3, str, str2));
        return aVar;
    }

    public a b(long j3, String str, String str2) {
        if (g2.b.f4760a) {
            g2.b.f4760a = false;
            str = str.replace(",", BuildConfig.FLAVOR);
            str2 = str2.replace(",", BuildConfig.FLAVOR);
        }
        a aVar = new a(true);
        aVar.f3849b.add(new i(j3, str, str2));
        return aVar;
    }

    public a c(long j3, String str, String str2) {
        if (g2.b.f4760a) {
            g2.b.f4760a = false;
            str = str.replace(",", BuildConfig.FLAVOR);
            str2 = str2.replace(",", BuildConfig.FLAVOR);
        }
        a aVar = new a(false, false);
        aVar.f3850c.add(new i(j3, str, str2));
        return aVar;
    }

    com.vivo.calculator.d c1(long j3, g gVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "nestedEval: ");
        a aVarE = gVar.e(j3);
        return gVar.c(j3, aVarE.S(0, new c(gVar.b(j3), aVarE.p1(), gVar)).f3863b);
    }

    public Object clone() {
        a aVar = new a();
        ArrayList<k> arrayList = this.f3848a;
        if (arrayList == null || arrayList.size() <= 0) {
            VLog.d("BBKCalculator/CalculatorExpr", "clone null , mExpr : " + this.f3848a);
        } else {
            for (k kVar : this.f3848a) {
                if (kVar instanceof b) {
                    aVar.f3848a.add((k) ((b) kVar).clone());
                } else {
                    aVar.f3848a.add(kVar);
                }
            }
        }
        return aVar;
    }

    public a d(long j3, String str, String str2) {
        if (g2.b.f4760a) {
            g2.b.f4760a = false;
            str = str.replace(",", BuildConfig.FLAVOR);
            str2 = str2.replace(",", BuildConfig.FLAVOR);
        }
        a aVar = new a();
        i iVar = new i(j3, str, str2);
        if (str.contains("-")) {
            aVar.f3848a.add(new h(R.id.lparen));
            aVar.f3848a.add(iVar);
            aVar.f3848a.add(new h(R.id.rparen));
        } else {
            aVar.f3848a.add(iVar);
        }
        return aVar;
    }

    com.vivo.calculator.d d1(long j3, g gVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "nestedEvalEx: ");
        a aVarI = gVar.i(j3);
        return gVar.l(j3, aVarI.T(0, new c(gVar.a(j3), aVarI.q1(), gVar)).f3865b);
    }

    public boolean e(int i3) {
        int size = this.f3848a.size();
        int iD = z1.e.d(i3);
        boolean zL = z1.e.l(i3);
        k kVar = size == 0 ? null : this.f3848a.get(size - 1);
        if (kVar instanceof h) {
            int i4 = ((h) kVar).f3868a;
        }
        if (zL && !z1.e.o(i3)) {
            while (F0()) {
                H();
            }
        }
        if (!(iD != 10 || i3 == R.id.dec_point)) {
            this.f3848a.add(new h(i3));
            return true;
        }
        if (size == 0) {
            this.f3848a.add(new b());
            size++;
        } else {
            k kVar2 = this.f3848a.get(size - 1);
            if (!(kVar2 instanceof b)) {
                if (kVar2 instanceof i) {
                    this.f3848a.add(new h(R.id.op_mul));
                    size++;
                }
                this.f3848a.add(new b());
                size++;
            }
        }
        return ((b) this.f3848a.get(size - 1)).c(i3);
    }

    com.vivo.calculator.d e1(long j3, g gVar) throws j {
        VLog.d("BBKCalculator/CalculatorExpr", "nestedEvalExchange: ");
        a aVarK = gVar.k(j3);
        return gVar.j(j3, aVarK.U(0, new c(gVar.h(j3), aVarK.r1(), gVar)).f3867b);
    }

    public boolean f(Context context, int i3, int i4) {
        int size = this.f3848a.size();
        int iD = z1.e.d(i3);
        boolean zL = z1.e.l(i3);
        int iK0 = k0(context, i4);
        VLog.d("BBKCalculator/CalculatorExpr", "add: pos ==  " + iK0);
        k kVar = size == 0 ? null : this.f3848a.get(iK0);
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            String strD = iVar.d();
            String strC = iVar.c();
            if (iK0 >= 0 && iK0 < this.f3848a.size()) {
                this.f3848a.remove(iK0);
            }
            if (strD != null && strD.startsWith("-")) {
                strD = strD.substring(1, strD.length());
                q(iK0, new h(R.id.op_sub));
                iK0++;
            }
            int iIndexOf = strD != null ? strD.indexOf("E") : 0;
            q(iK0, new b(strD, iIndexOf > 0 ? strC.substring(iIndexOf - 1, strC.length()) : BuildConfig.FLAVOR));
            kVar = this.f3848a.get(iK0);
        }
        k kVar2 = iK0 > 1 ? this.f3848a.get(iK0 - 1) : null;
        boolean z2 = kVar instanceof h;
        int i5 = z2 ? ((h) kVar).f3868a : 0;
        if (zL && !z1.e.o(i3)) {
            int i6 = i4;
            int i7 = iK0;
            while (G0(i7)) {
                I(context, i6);
                i7--;
                i6--;
            }
        }
        if (iD != 10 || i3 == R.id.dec_point) {
            if (size == 0) {
                this.f3848a.add(new b());
            } else {
                k kVar3 = this.f3848a.get(iK0);
                if (!(kVar3 instanceof b)) {
                    if (iK0 == size - 1) {
                        if (iK0 == 0 && i4 == 0) {
                            this.f3848a.add(iK0, new b());
                            return ((b) this.f3848a.get(iK0)).d(i3, i4 - q0(context, iK0));
                        }
                        this.f3848a.add(new b());
                    } else if ((kVar3 instanceof h) && i4 != 0) {
                    }
                    iK0++;
                }
            }
            if (!(this.f3848a.get(iK0) instanceof b)) {
                this.f3848a.add(iK0, new b());
            }
            return ((b) this.f3848a.get(iK0)).d(i3, i4 - q0(context, iK0));
        }
        if (size == 0) {
            this.f3848a.add(new h(i3));
            return true;
        }
        if (z2) {
            if (!z1.e.l(i5) || !zL) {
                iK0 = o0(i4, zL, iK0, i5);
            }
            if (z1.e.l(i5) && kVar2 != null && (kVar2 instanceof h) && z1.e.l(((h) kVar2).f3868a)) {
                iK0--;
            }
            q(iK0, new h(i3));
            return true;
        }
        int iQ0 = i4 - q0(context, iK0);
        if (iQ0 >= v0(context, iK0)) {
            q(iK0 + 1, new h(i3));
            return true;
        }
        if (!(kVar instanceof b)) {
            return true;
        }
        int i8 = iQ0 < 0 ? 0 : iQ0;
        b bVar = (b) kVar;
        b bVar2 = (b) bVar.clone();
        b bVar3 = (b) bVar.clone();
        bVar2.l(i8);
        bVar3.m(i8);
        VLog.i("BBKCalculator/CalculatorExpr", " add  preTk = " + bVar2.toString() + " sufTk=" + bVar3.toString() + "  pos=" + iK0);
        if (iK0 >= 0 && iK0 < this.f3848a.size()) {
            this.f3848a.remove(iK0);
        }
        o(i3, iK0, bVar2, bVar3);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:97:0x021e  */
    public boolean g(Context context, int i3, int i4, boolean z2) {
        boolean z3;
        VLog.d("BBKCalculator/CalculatorExpr", "add: ---  mExprEx ");
        int size = this.f3849b.size();
        int iD = z1.e.d(i3);
        boolean zL = z1.e.l(i3);
        int iL0 = l0(context, i4, true);
        k kVar = size == 0 ? null : this.f3849b.get(iL0);
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            String strD = iVar.d();
            String strC = iVar.c();
            this.f3849b.remove(iL0);
            if (strD != null && strD.startsWith("-")) {
                strD = strD.substring(1, strD.length());
                r(iL0, new h(R.id.e_op_sub), true);
                iL0++;
            }
            int iIndexOf = strD != null ? strD.indexOf("E") : 0;
            r(iL0, new b(strD, iIndexOf > 0 ? strC.substring(iIndexOf - 1, strC.length()) : BuildConfig.FLAVOR), true);
            kVar = this.f3849b.get(iL0);
        }
        k kVar2 = iL0 > 1 ? this.f3849b.get(iL0 - 1) : null;
        boolean z4 = kVar instanceof h;
        int i5 = z4 ? ((h) kVar).f3868a : 0;
        if (zL && !z1.e.o(i3)) {
            if (z1.e.n(i5)) {
                return false;
            }
            if (z1.e.o(i5) && i5 != R.id.e_op_sub) {
                return false;
            }
            int i6 = i4;
            int i7 = iL0;
            while (H0(i7, true)) {
                J(context, i6, true);
                i7--;
                i6--;
            }
        }
        if (iD != 10 || i3 == R.id.e_dec_point) {
            if (size != 0) {
                k kVar3 = this.f3849b.get(iL0);
                if (!(kVar3 instanceof b)) {
                    if (iL0 != size - 1) {
                        z3 = z2;
                        if ((kVar3 instanceof h) && i4 != 0) {
                        }
                    } else {
                        if (iL0 == 0 && i4 == 0) {
                            this.f3849b.add(iL0, new b());
                            return ((b) this.f3849b.get(iL0)).e(i3, i4 - r0(context, iL0, z2));
                        }
                        z3 = z2;
                        this.f3849b.add(new b());
                    }
                    iL0++;
                }
                if (!(this.f3849b.get(iL0) instanceof b)) {
                    this.f3849b.add(iL0, new b());
                }
                return ((b) this.f3849b.get(iL0)).e(i3, i4 - r0(context, iL0, z3));
            }
            this.f3849b.add(new b());
            z3 = z2;
            if (!(this.f3849b.get(iL0) instanceof b)) {
                this.f3849b.add(iL0, new b());
            }
            return ((b) this.f3849b.get(iL0)).e(i3, i4 - r0(context, iL0, z3));
        }
        if (size == 0) {
            this.f3849b.add(new h(i3));
            return true;
        }
        VLog.i("BBKCalculator/CalculatorExpr", " add index = " + i4 + "  pos=" + iL0);
        if (z4) {
            if (!z1.e.l(i5) || !zL) {
                iL0 = o0(i4, zL, iL0, i5);
            }
            if (z1.e.l(i5) && kVar2 != null && (kVar2 instanceof h) && z1.e.l(((h) kVar2).f3868a)) {
                iL0--;
            }
            r(iL0, new h(i3), true);
            return true;
        }
        int iR0 = i4 - r0(context, iL0, true);
        int iW0 = w0(context, iL0, true);
        VLog.i("BBKCalculator/CalculatorExpr", " exprPos= " + iR0 + "   postkSize=" + iW0);
        if (iR0 >= iW0) {
            r(iL0 + 1, new h(i3), true);
            return true;
        }
        if (!(kVar instanceof b)) {
            return true;
        }
        int i8 = iR0 < 0 ? 0 : iR0;
        b bVar = (b) kVar;
        b bVar2 = (b) bVar.clone();
        b bVar3 = (b) bVar.clone();
        bVar2.l(i8);
        bVar3.m(i8);
        VLog.i("BBKCalculator/CalculatorExpr", "add  preTk = " + bVar2.toString() + " sufTk=" + bVar3.toString() + "  pos=" + iL0);
        this.f3849b.remove(iL0);
        p(i3, iL0, bVar2, bVar3, true);
        return true;
    }

    public boolean h(Context context, int i3, int i4, boolean z2) {
        VLog.d("BBKCalculator/CalculatorExpr", "addEx: ---   mExprExchange ");
        int size = this.f3850c.size();
        int iD = z1.e.d(i3);
        boolean zL = z1.e.l(i3);
        int iL0 = l0(context, i4, false);
        k kVar = size == 0 ? null : this.f3850c.get(iL0);
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            String strD = iVar.d();
            String strC = iVar.c();
            this.f3850c.remove(iL0);
            if (strD != null && strD.startsWith("-")) {
                strD = strD.substring(1, strD.length());
                r(iL0, new h(R.id.e_op_sub), false);
                iL0++;
            }
            int iIndexOf = strD != null ? strD.indexOf("E") : 0;
            r(iL0, new b(strD, iIndexOf > 0 ? strC.substring(iIndexOf - 1, strC.length()) : BuildConfig.FLAVOR), false);
            kVar = this.f3850c.get(iL0);
        }
        k kVar2 = iL0 > 1 ? this.f3850c.get(iL0 - 1) : null;
        boolean z3 = kVar instanceof h;
        int i5 = z3 ? ((h) kVar).f3868a : 0;
        if (zL && !z1.e.o(i3)) {
            if (z1.e.n(i5) || (z1.e.o(i5) && i5 != R.id.e_op_sub)) {
                return false;
            }
            int i6 = i4;
            int i7 = iL0;
            while (H0(i7, false)) {
                J(context, i6, false);
                i7--;
                i6--;
            }
        }
        if (iD != 10 || i3 == R.id.e_dec_point) {
            if (size == 0) {
                this.f3850c.add(new b());
            } else {
                k kVar3 = this.f3850c.get(iL0);
                if (!(kVar3 instanceof b)) {
                    if (iL0 == size - 1) {
                        if (iL0 == 0 && i4 == 0) {
                            this.f3850c.add(iL0, new b());
                            return ((b) this.f3850c.get(iL0)).e(i3, i4 - r0(context, iL0, false));
                        }
                        this.f3850c.add(new b());
                    } else if ((kVar3 instanceof h) && i4 != 0) {
                    }
                    iL0++;
                }
            }
            if (!(this.f3850c.get(iL0) instanceof b)) {
                this.f3850c.add(iL0, new b());
            }
            return ((b) this.f3850c.get(iL0)).e(i3, i4 - r0(context, iL0, false));
        }
        if (size == 0) {
            this.f3850c.add(new h(i3));
            return true;
        }
        VLog.i("BBKCalculator/CalculatorExpr", " add index = " + i4 + "  pos=" + iL0);
        if (z3) {
            if (!z1.e.l(i5) || !zL) {
                iL0 = o0(i4, zL, iL0, i5);
            }
            if (z1.e.l(i5) && kVar2 != null && (kVar2 instanceof h) && z1.e.l(((h) kVar2).f3868a)) {
                iL0--;
            }
            r(iL0, new h(i3), false);
            return true;
        }
        int iR0 = i4 - r0(context, iL0, false);
        int iW0 = w0(context, iL0, false);
        VLog.i("BBKCalculator/CalculatorExpr", " exprPos= " + iR0 + "   posTkSize=" + iW0);
        if (iR0 >= iW0) {
            r(iL0 + 1, new h(i3), false);
            return true;
        }
        if (!(kVar instanceof b)) {
            return true;
        }
        int i8 = iR0 >= 0 ? iR0 : 0;
        b bVar = (b) kVar;
        b bVar2 = (b) bVar.clone();
        b bVar3 = (b) bVar.clone();
        bVar2.l(i8);
        bVar3.m(i8);
        VLog.i("BBKCalculator/CalculatorExpr", " preTk = " + bVar2.toString() + " sufTk=" + bVar3.toString() + "  pos=" + iL0);
        this.f3850c.remove(iL0);
        p(i3, iL0, bVar2, bVar3, false);
        return true;
    }

    public void h1() {
        while (true) {
            int size = this.f3849b.size();
            if (size == 0) {
                return;
            }
            k kVar = this.f3849b.get(size - 1);
            if (!(kVar instanceof h)) {
                return;
            }
            int i3 = ((h) kVar).f3868a;
            if (i3 != R.id.e_op_add && i3 != R.id.e_op_sub) {
                return;
            } else {
                N();
            }
        }
    }

    void i(int i3) {
        ArrayList<k> arrayList = this.f3848a;
        ((b) arrayList.get(arrayList.size() - 1)).f(i3);
    }

    public byte[] i1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                s1(dataOutputStream);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new AssertionError("Impossible IO exception", e3);
        }
    }

    public void j(int i3, boolean z2) {
        k(new h(i3), z2);
    }

    public byte[] j1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                t1(dataOutputStream);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new AssertionError("Impossible IO exception", e3);
        }
    }

    public int k0(Context context, int i3) {
        int size = this.f3848a.size();
        int iV0 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iV0 += v0(context, i4);
            if (i3 <= iV0) {
                return i4;
            }
        }
        if (size > 0) {
            return size - 1;
        }
        return 0;
    }

    public byte[] k1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                u1(dataOutputStream);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new AssertionError("Impossible IO exception", e3);
        }
    }

    public int l0(Context context, int i3, boolean z2) {
        int size = z2 ? this.f3849b.size() : this.f3850c.size();
        int iW0 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iW0 += w0(context, i4, z2);
            if (i3 <= iW0) {
                return i4;
            }
        }
        if (size > 0) {
            return size - 1;
        }
        return 0;
    }

    public int m0(Context context, int i3) {
        return q0(context, k0(context, i3));
    }

    SpannableStringBuilder m1(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        VLog.d("BBKCalculator/CalculatorExpr", "toSpannableStringBuilder: mExpr == " + this.f3848a);
        for (k kVar : this.f3848a) {
            if (kVar != null) {
                spannableStringBuilder.append(kVar.a(context));
            }
        }
        return spannableStringBuilder;
    }

    public int n0(Context context, int i3, boolean z2) {
        return r0(context, l0(context, i3, z2), z2);
    }

    public SpannableStringBuilder n1(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (k kVar : this.f3849b) {
            if (kVar != null) {
                spannableStringBuilder.append(kVar.a(context));
            }
        }
        return spannableStringBuilder;
    }

    public int o0(int i3, boolean z2, int i4, int i5) {
        if (i4 == 0 && i3 == 0) {
            return i4;
        }
        if (i4 != 0) {
            i4++;
        }
        if (!z1.e.l(i5) && i4 == 0) {
            i4++;
        }
        return (z1.e.l(i5) && !z2 && i4 == 0 && i3 == 1) ? i4 + 1 : i4;
    }

    public SpannableStringBuilder o1(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (k kVar : this.f3850c) {
            if (kVar != null) {
                spannableStringBuilder.append(kVar.a(context));
            }
        }
        return spannableStringBuilder;
    }

    public void q(int i3, k kVar) {
        if (i3 >= this.f3848a.size()) {
            this.f3848a.add(kVar);
        } else {
            this.f3848a.add(i3, kVar);
        }
    }

    public int q0(Context context, int i3) {
        int iV0 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iV0 += v0(context, i4);
        }
        return iV0;
    }

    public void r(int i3, k kVar, boolean z2) {
        if (z2) {
            if (i3 >= this.f3849b.size()) {
                this.f3849b.add(kVar);
                return;
            } else {
                this.f3849b.add(i3, kVar);
                return;
            }
        }
        if (i3 >= this.f3850c.size()) {
            this.f3850c.add(kVar);
        } else {
            this.f3850c.add(i3, kVar);
        }
    }

    public int r0(Context context, int i3, boolean z2) {
        int iW0 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iW0 += w0(context, i4, z2);
        }
        return iW0;
    }

    public void s(Context context, a aVar, int i3, boolean z2) {
        int size = this.f3848a.size();
        int size2 = aVar.f3848a.size();
        int iK0 = k0(context, i3);
        int i4 = 0;
        if (size == 0 || size2 == 0) {
            while (i4 < size2) {
                this.f3848a.add(iK0 + i4, aVar.f3848a.get(i4));
                i4++;
            }
            return;
        }
        int iQ0 = i3 - q0(context, iK0);
        int iV0 = v0(context, iK0);
        k kVar = this.f3848a.get(iK0);
        aVar.f3848a.get(0);
        if (iQ0 >= iV0) {
            if (!(kVar instanceof h) || z2) {
                return;
            }
            while (i4 < size2) {
                this.f3848a.add(iK0 + 1 + i4, aVar.f3848a.get(i4));
                i4++;
            }
            return;
        }
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            b bVar2 = (b) bVar.clone();
            b bVar3 = (b) bVar.clone();
            bVar2.l(iQ0);
            bVar3.m(iQ0);
            if (iK0 >= 0 && iK0 < this.f3848a.size()) {
                this.f3848a.remove(iK0);
            }
            this.f3848a.add(iK0, bVar2);
            while (i4 < size2) {
                this.f3848a.add(iK0 + i4 + 1, aVar.f3848a.get(i4));
                i4++;
            }
            this.f3848a.add(iK0 + size2 + 1, bVar3);
        }
    }

    public void s1(DataOutput dataOutput) throws IOException {
        int size = this.f3848a.size();
        dataOutput.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f3848a.get(i3).b(dataOutput);
        }
    }

    public void t(a aVar) {
        ArrayList<k> arrayList = this.f3848a;
        if (arrayList == null || aVar == null || aVar.f3848a == null) {
            VLog.d("BBKCalculator/CalculatorExpr", "append , mExpr == null || expr2 == null || expr2.mExpr == null , return.");
            return;
        }
        int size = arrayList.size();
        int size2 = aVar.f3848a.size();
        if (size != 0 && size2 != 0) {
            k kVar = this.f3848a.get(size - 1);
            if (!(aVar.f3848a.get(0) instanceof h) && !(kVar instanceof h)) {
                this.f3848a.add(new h(R.id.op_mul));
            }
        }
        for (int i3 = 0; i3 < size2; i3++) {
            this.f3848a.add(aVar.f3848a.get(i3));
        }
    }

    public void t1(DataOutput dataOutput) throws IOException {
        int size = this.f3849b.size();
        VLog.d("BBKCalculator/CalculatorExpr", "writeEx,size: " + size);
        dataOutput.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<k> arrayList = this.f3849b;
            if (arrayList != null && arrayList.get(i3) != null) {
                this.f3849b.get(i3).b(dataOutput);
            }
        }
    }

    public void u(a aVar) {
        int size = this.f3849b.size();
        int size2 = aVar.f3849b.size();
        if (size != 0 && size2 != 0) {
            k kVar = this.f3849b.get(size - 1);
            if (!(aVar.f3849b.get(0) instanceof h) && !(kVar instanceof h)) {
                this.f3849b.add(new h(R.id.e_op_mul));
            }
        }
        for (int i3 = 0; i3 < size2; i3++) {
            this.f3849b.add(aVar.f3849b.get(i3));
        }
    }

    public void u1(DataOutput dataOutput) throws IOException {
        int size = this.f3850c.size();
        VLog.d("BBKCalculator/CalculatorExpr", "writeExchange,size: " + size);
        dataOutput.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f3850c.get(i3).b(dataOutput);
        }
    }

    public void v(a aVar) {
        int size = this.f3850c.size();
        int size2 = aVar.f3850c.size();
        if (size != 0 && size2 != 0) {
            k kVar = this.f3850c.get(size - 1);
            if (!(aVar.f3850c.get(0) instanceof h) && !(kVar instanceof h)) {
                this.f3850c.add(new h(R.id.e_op_mul));
            }
        }
        for (int i3 = 0; i3 < size2; i3++) {
            this.f3850c.add(aVar.f3850c.get(i3));
        }
    }

    public ArrayList<Long> x0(g gVar) {
        ArrayList<Long> arrayList = new ArrayList<>();
        VLog.d("BBKCalculator/CalculatorExpr", "  getTransitivelyReferencedExprs: " + arrayList.size());
        l(arrayList, gVar);
        for (int i3 = 0; i3 != arrayList.size(); i3++) {
            gVar.e(arrayList.get(i3).longValue()).l(arrayList, gVar);
        }
        Collections.reverse(arrayList);
        VLog.d("BBKCalculator/CalculatorExpr", "  getTransitivelyReferencedExprs: " + arrayList);
        return arrayList;
    }

    public ArrayList<Long> y0(g gVar) {
        ArrayList<Long> arrayList = new ArrayList<>();
        VLog.d("BBKCalculator/CalculatorExpr", "  getTransitivelyReferencedExprsEx: " + arrayList.size());
        m(arrayList, gVar);
        for (int i3 = 0; i3 != arrayList.size(); i3++) {
            gVar.i(arrayList.get(i3).longValue()).m(arrayList, gVar);
        }
        Collections.reverse(arrayList);
        VLog.d("BBKCalculator/CalculatorExpr", "  getTransitivelyReferencedExprsEx: " + arrayList);
        return arrayList;
    }

    public ArrayList<Long> z0(g gVar) {
        ArrayList<Long> arrayList = new ArrayList<>();
        VLog.d("BBKCalculator/CalculatorExpr", "  getTransitivelyReferencedExprsExchange: " + arrayList.size());
        n(arrayList, gVar);
        for (int i3 = 0; i3 != arrayList.size(); i3++) {
            gVar.k(arrayList.get(i3).longValue()).n(arrayList, gVar);
        }
        Collections.reverse(arrayList);
        VLog.d("BBKCalculator/CalculatorExpr", "  getTransitivelyReferencedExprsExchange: " + arrayList);
        return arrayList;
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static class h extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3868a;

        h(int i3) {
            super(null);
            VLog.d("BBKCalculator/CalculatorExpr/Operator", "Operator: resId" + i3);
            this.f3868a = i3;
        }

        @Override // com.vivo.calculator.a.k
        public CharSequence a(Context context) {
            String strZ = z1.e.z(context, this.f3868a);
            VLog.d("BBKCalculator/CalculatorExpr/Operator", "toCharSequence: desc " + strZ);
            if (strZ == null) {
                return z1.e.C(context, this.f3868a);
            }
            SpannableString spannableString = new SpannableString(z1.e.C(context, this.f3868a));
            spannableString.setSpan(new TtsSpan.TextBuilder(strZ).build(), 0, spannableString.length(), 33);
            return spannableString;
        }

        @Override // com.vivo.calculator.a.k
        void b(DataOutput dataOutput) throws IOException {
            VLog.d("BBKCalculator/CalculatorExpr/Operator", "write: ");
            int i3 = this.f3868a;
            if (i3 != -1) {
                dataOutput.writeByte(z1.e.y(i3));
            }
        }

        h(byte b3) throws IOException {
            super(null);
            VLog.d("BBKCalculator/CalculatorExpr/Operator", "Operator:" + ((char) b3));
            this.f3868a = z1.e.f(b3);
        }
    }

    public a(boolean z2) {
        this.f3849b = new ArrayList<>();
        this.f3850c = new ArrayList<>();
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static class i extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f3869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f3870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f3871c;

        i(long j3, String str, String str2) {
            super(null);
            this.f3869a = j3;
            this.f3871c = str;
            this.f3870b = str2;
        }

        @Override // com.vivo.calculator.a.k
        public CharSequence a(Context context) {
            VLog.d("BBKCalculator/CalculatorExpr/PreEval", "toCharSequence: ");
            return z1.e.D(this.f3871c);
        }

        @Override // com.vivo.calculator.a.k
        public void b(DataOutput dataOutput) throws IOException {
            VLog.d("BBKCalculator/CalculatorExpr/PreEval", "write: ");
            dataOutput.writeByte(l.PRE_EVAL.ordinal());
            long j3 = this.f3869a;
            if (j3 > 2147483647L || j3 < -2147483648L) {
                throw new AssertionError("Expression index too big");
            }
            dataOutput.writeInt((int) j3);
            dataOutput.writeUTF(this.f3871c);
        }

        public String c() {
            return this.f3870b;
        }

        public String d() {
            return this.f3871c;
        }

        i(DataInput dataInput) throws IOException {
            super(null);
            this.f3869a = dataInput.readInt();
            String utf = dataInput.readUTF();
            this.f3871c = utf;
            this.f3870b = utf;
        }
    }

    /* JADX INFO: compiled from: CalculatorExpr.java */
    private static class b extends k implements Cloneable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static int f3852g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static int f3853h = 2;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f3855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f3856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f3857e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3858f;

        b() {
            super(null);
            this.f3855c = BuildConfig.FLAVOR;
            this.f3856d = BuildConfig.FLAVOR;
            this.f3854b = false;
            this.f3858f = 0;
            this.f3857e = BuildConfig.FLAVOR;
        }

        private String i() {
            return String.valueOf(z1.e.h());
        }

        private String j() {
            return String.valueOf(z1.e.i());
        }

        @Override // com.vivo.calculator.a.k
        public CharSequence a(Context context) {
            return toString();
        }

        @Override // com.vivo.calculator.a.k
        void b(DataOutput dataOutput) throws IOException {
            VLog.d("BBKCalculator/CalculatorExpr/Constant", "write: ");
            byte b3 = (byte) ((this.f3854b ? f3852g : 0) | (this.f3858f != 0 ? f3853h : 0));
            dataOutput.writeByte(l.CONSTANT.ordinal());
            dataOutput.writeUTF(this.f3855c);
            dataOutput.writeByte(b3);
            if (this.f3854b) {
                dataOutput.writeUTF(this.f3856d);
            }
            int i3 = this.f3858f;
            if (i3 != 0) {
                dataOutput.writeInt(i3);
            }
        }

        public boolean c(int i3) {
            if (i3 == R.id.dec_point) {
                if (this.f3854b || this.f3858f != 0) {
                    return false;
                }
                this.f3854b = true;
                return true;
            }
            int iD = z1.e.d(i3);
            int i4 = this.f3858f;
            if (i4 != 0) {
                if (Math.abs(i4) > 10000) {
                    return false;
                }
                int i5 = this.f3858f;
                if (i5 > 0) {
                    this.f3858f = (i5 * 10) + iD;
                } else {
                    this.f3858f = (i5 * 10) - iD;
                }
                return true;
            }
            if (this.f3854b) {
                this.f3856d += iD;
            } else {
                this.f3855c += iD;
            }
            return true;
        }

        public Object clone() {
            b bVar = new b();
            bVar.f3855c = this.f3855c;
            bVar.f3856d = this.f3856d;
            bVar.f3854b = this.f3854b;
            bVar.f3858f = this.f3858f;
            return bVar;
        }

        public boolean d(int i3, int i4) {
            String str;
            if (i4 < 0) {
                i4 = 0;
            }
            String strJ = z1.e.j(this.f3855c);
            int length = strJ.length();
            if (i3 == R.id.dec_point) {
                if (this.f3854b || this.f3858f != 0) {
                    return false;
                }
                this.f3854b = true;
                if (i4 < length) {
                    this.f3855c = strJ.substring(0, i4);
                    this.f3856d = strJ.substring(i4, length);
                    this.f3855c = this.f3855c.replaceAll(",", BuildConfig.FLAVOR);
                    this.f3856d = this.f3856d.replaceAll(",", BuildConfig.FLAVOR);
                }
                return true;
            }
            int iD = z1.e.d(i3);
            int iIndexOf = toString().indexOf("E");
            int i5 = this.f3858f;
            if (i5 != 0 && i4 > iIndexOf) {
                if (Math.abs(i5) > 10000) {
                    return false;
                }
                int i6 = (i4 - iIndexOf) - 1;
                String str2 = this.f3858f + BuildConfig.FLAVOR;
                int length2 = str2.length();
                if (i6 < length2) {
                    str = str2.substring(0, i6) + iD + str2.substring(i6, length2);
                } else {
                    str = str2 + iD;
                }
                try {
                    this.f3858f = Integer.parseInt(str);
                    return true;
                } catch (NumberFormatException e3) {
                    VLog.e("BBKCalculator/CalculatorExpr/Constant", "NumberFormatException" + e3);
                }
            }
            if (!this.f3854b || i4 <= length) {
                if (i4 < length) {
                    this.f3855c = strJ.substring(0, i4) + iD + strJ.substring(i4, length);
                } else {
                    this.f3855c += iD;
                }
                this.f3855c = this.f3855c.replaceAll(",", BuildConfig.FLAVOR);
            } else {
                int i7 = (i4 - length) - 1;
                String str3 = this.f3856d;
                int length3 = str3.length();
                if (i7 < length3) {
                    this.f3856d = str3.substring(0, i7) + iD + str3.substring(i7, length3);
                } else {
                    this.f3856d += iD;
                }
            }
            return true;
        }

        public boolean e(int i3, int i4) {
            String str;
            if (i4 < 0) {
                i4 = 0;
            }
            String strJ = z1.e.j(this.f3855c);
            int length = strJ.length();
            if (i3 == R.id.e_dec_point) {
                if (this.f3854b || this.f3858f != 0) {
                    return false;
                }
                this.f3854b = true;
                if (i4 < length) {
                    this.f3855c = strJ.substring(0, i4);
                    this.f3856d = strJ.substring(i4, length);
                    this.f3855c = this.f3855c.replaceAll(",", BuildConfig.FLAVOR);
                    this.f3856d = this.f3856d.replaceAll(",", BuildConfig.FLAVOR);
                }
                return true;
            }
            int iD = z1.e.d(i3);
            int iIndexOf = toString().indexOf("E");
            int i5 = this.f3858f;
            if (i5 != 0 && i4 > iIndexOf) {
                if (Math.abs(i5) > 10000) {
                    return false;
                }
                int i6 = (i4 - iIndexOf) - 1;
                String str2 = this.f3858f + BuildConfig.FLAVOR;
                int length2 = str2.length();
                if (i6 < length2) {
                    str = str2.substring(0, i6) + iD + str2.substring(i6, length2);
                } else {
                    str = str2 + iD;
                }
                try {
                    this.f3858f = Integer.parseInt(str);
                    return true;
                } catch (NumberFormatException e3) {
                    VLog.e("BBKCalculator/CalculatorExpr/Constant", "NumberFormatException" + e3);
                }
            }
            if (!this.f3854b || i4 <= length) {
                if (i4 < length) {
                    this.f3855c = strJ.substring(0, i4) + iD + strJ.substring(i4, length);
                } else {
                    this.f3855c += iD;
                }
                this.f3855c = this.f3855c.replaceAll(",", BuildConfig.FLAVOR);
            } else {
                int i7 = (i4 - length) - 1;
                String str3 = this.f3856d;
                int length3 = str3.length();
                if (i7 < length3) {
                    this.f3856d = str3.substring(0, i7) + iD + str3.substring(i7, length3);
                } else {
                    this.f3856d += iD;
                }
            }
            return true;
        }

        public void f(int i3) {
            this.f3858f = i3;
        }

        public void g() {
            VLog.d("BBKCalculator/CalculatorExpr/Constant", "delete: ");
            int i3 = this.f3858f;
            if (i3 != 0) {
                this.f3858f = i3 / 10;
                return;
            }
            if (!this.f3856d.isEmpty()) {
                String str = this.f3856d;
                this.f3856d = str.substring(0, str.length() - 1);
            } else if (this.f3854b) {
                this.f3854b = false;
            } else {
                String str2 = this.f3855c;
                this.f3855c = str2.substring(0, str2.length() - 1);
            }
        }

        public void h(int i3) {
            String strSubstring;
            String strJ = z1.e.j(this.f3855c);
            int length = strJ.length();
            VLog.i("BBKCalculator/CalculatorExpr/Constant", " length=" + length + " index=" + i3);
            int iIndexOf = toString().indexOf("E");
            if (this.f3858f != 0 && i3 > iIndexOf) {
                if (i3 != iIndexOf + 1) {
                    int i4 = (i3 - iIndexOf) - 1;
                    String str = this.f3858f + BuildConfig.FLAVOR;
                    int length2 = str.length();
                    if (i4 <= 0 || i4 >= length2) {
                        strSubstring = str.substring(0, length2 - 1);
                    } else {
                        strSubstring = str.substring(0, i4 - 1) + str.substring(i4, length2);
                    }
                    try {
                        this.f3858f = Integer.parseInt(strSubstring);
                        return;
                    } catch (NumberFormatException unused) {
                        this.f3858f = 0;
                        return;
                    }
                }
                return;
            }
            if (!this.f3856d.isEmpty() && i3 > length + 1) {
                int i5 = (i3 - length) - 1;
                String str2 = this.f3856d;
                int length3 = str2.length();
                if (i5 <= 0 || i5 >= length3) {
                    this.f3856d = str2.substring(0, length3 - 1);
                    return;
                }
                this.f3856d = str2.substring(0, i5 - 1) + str2.substring(i5, length3);
                return;
            }
            if (this.f3854b && i3 == length + 1) {
                this.f3854b = false;
                this.f3855c += this.f3856d;
                this.f3856d = BuildConfig.FLAVOR;
                return;
            }
            if (i3 > length) {
                if (this.f3855c.length() > 0) {
                    String str3 = this.f3855c;
                    this.f3855c = str3.substring(0, str3.length() - 1);
                    return;
                }
                return;
            }
            if (i3 != 0) {
                int i6 = i3 - 1;
                if (strJ.charAt(i6) == ',') {
                    this.f3855c = strJ.substring(0, i3 - 2) + strJ.substring(i6, length);
                } else if (i3 < length) {
                    this.f3855c = strJ.substring(0, i6) + strJ.substring(i3, length);
                } else {
                    this.f3855c = strJ.substring(0, i6);
                }
                this.f3855c = this.f3855c.replaceAll(",", BuildConfig.FLAVOR);
            }
        }

        public boolean k() {
            return !this.f3854b && this.f3855c.isEmpty();
        }

        public void l(int i3) {
            String strReplaceAll = toString().substring(0, i3).replaceAll("\\" + j(), BuildConfig.FLAVOR);
            this.f3855c = BuildConfig.FLAVOR;
            this.f3856d = BuildConfig.FLAVOR;
            this.f3854b = false;
            this.f3858f = 0;
            if (!strReplaceAll.contains("E")) {
                if (!strReplaceAll.contains(i())) {
                    this.f3855c = strReplaceAll;
                    return;
                }
                this.f3854b = true;
                int iIndexOf = strReplaceAll.indexOf(i());
                if (iIndexOf > 0) {
                    this.f3855c = strReplaceAll.substring(0, iIndexOf);
                }
                this.f3856d = strReplaceAll.substring(iIndexOf + 1);
                return;
            }
            this.f3854b = true;
            int iIndexOf2 = strReplaceAll.indexOf(i());
            if (iIndexOf2 > 0) {
                this.f3855c = strReplaceAll.substring(0, iIndexOf2);
                this.f3856d = strReplaceAll.substring(iIndexOf2 + 1, strReplaceAll.indexOf("E"));
            } else if (iIndexOf2 == 0) {
                this.f3856d = strReplaceAll.substring(iIndexOf2 + 1, strReplaceAll.indexOf("E"));
            } else {
                this.f3855c = strReplaceAll.substring(0, strReplaceAll.indexOf("E"));
            }
            try {
                this.f3858f = Integer.parseInt(strReplaceAll.substring(strReplaceAll.indexOf("E") + 1, strReplaceAll.length()));
            } catch (NumberFormatException e3) {
                VLog.e("BBKCalculator/CalculatorExpr/Constant", "NumberFormatException in prefixTk" + e3);
            }
        }

        public void m(int i3) {
            String strReplaceAll = toString().substring(i3).replaceAll("\\" + j(), BuildConfig.FLAVOR);
            this.f3855c = BuildConfig.FLAVOR;
            this.f3856d = BuildConfig.FLAVOR;
            this.f3854b = false;
            this.f3858f = 0;
            if (!strReplaceAll.contains("E")) {
                if (!strReplaceAll.contains(i())) {
                    this.f3855c = strReplaceAll;
                    return;
                }
                this.f3854b = true;
                int iIndexOf = strReplaceAll.indexOf(i());
                if (iIndexOf > 0) {
                    this.f3855c = strReplaceAll.substring(0, iIndexOf);
                }
                this.f3856d = strReplaceAll.substring(iIndexOf + 1);
                return;
            }
            this.f3854b = true;
            int iIndexOf2 = strReplaceAll.indexOf(i());
            if (iIndexOf2 > 0) {
                this.f3855c = strReplaceAll.substring(0, iIndexOf2);
                this.f3856d = strReplaceAll.substring(iIndexOf2 + 1, strReplaceAll.indexOf("E"));
            } else if (iIndexOf2 == 0) {
                this.f3856d = strReplaceAll.substring(iIndexOf2 + 1, strReplaceAll.indexOf("E"));
            } else {
                this.f3855c = strReplaceAll.substring(0, strReplaceAll.indexOf("E"));
            }
            try {
                this.f3858f = Integer.parseInt(strReplaceAll.substring(strReplaceAll.indexOf("E") + 1, strReplaceAll.length()));
            } catch (NumberFormatException unused) {
                VLog.e("BBKCalculator/CalculatorExpr/Constant", "NumberFormatException in sufixTk");
            }
        }

        public z1.a n() throws j {
            BigInteger bigInteger;
            String str = this.f3855c;
            if (str.isEmpty()) {
                if (this.f3856d.isEmpty()) {
                    throw new j();
                }
                str = "0";
            }
            VLog.d("BBKCalculator/CalculatorExpr/Constant", "toRational,whole:" + str + ",mFraction:" + this.f3856d);
            String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
            String strReplaceAll2 = this.f3856d.replaceAll(",", BuildConfig.FLAVOR);
            this.f3856d = strReplaceAll2;
            if (strReplaceAll2 != null) {
                bigInteger = new BigInteger(strReplaceAll + this.f3856d);
            } else {
                bigInteger = new BigInteger(strReplaceAll);
            }
            int i3 = this.f3858f;
            if (i3 > 0) {
                bigInteger = bigInteger.multiply(BigInteger.TEN.pow(i3));
            }
            BigInteger bigIntegerPow = BigInteger.TEN.pow(this.f3856d.length());
            int i4 = this.f3858f;
            if (i4 < 0) {
                bigIntegerPow = bigIntegerPow.multiply(BigInteger.TEN.pow(-i4));
            }
            return new z1.a(bigInteger, bigIntegerPow);
        }

        public String toString() {
            String strA;
            if (this.f3858f != 0) {
                strA = this.f3855c;
            } else {
                String str = this.f3855c;
                strA = z1.g.a(str, 0, str.length());
            }
            if (this.f3854b) {
                strA = (strA + '.') + this.f3856d;
            }
            if (this.f3858f != 0) {
                strA = strA + "E" + this.f3858f;
            }
            return z1.e.D(strA);
        }

        b(String str, String str2) {
            super(null);
            this.f3855c = BuildConfig.FLAVOR;
            this.f3856d = BuildConfig.FLAVOR;
            this.f3854b = false;
            this.f3858f = 0;
            this.f3857e = str2;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("E")) {
                this.f3854b = true;
                int iIndexOf = str.indexOf(".");
                if (iIndexOf > 0) {
                    this.f3855c = str.substring(0, iIndexOf);
                    this.f3856d = str.substring(iIndexOf + 1, str.indexOf("E"));
                } else if (iIndexOf == 0) {
                    this.f3856d = str.substring(0, str.indexOf("E"));
                } else {
                    this.f3855c = str.substring(0, str.indexOf("E"));
                }
                this.f3858f = Integer.parseInt(str.substring(str.indexOf("E") + 1, str.length()));
                if (this.f3857e.contains(".")) {
                    String str3 = this.f3857e;
                    this.f3857e = str3.substring(0, str3.indexOf("."));
                }
                if (this.f3858f < 0) {
                    this.f3857e = BuildConfig.FLAVOR;
                }
            } else if (str.contains(".")) {
                this.f3854b = true;
                int iIndexOf2 = str.indexOf(".");
                if (iIndexOf2 > 0) {
                    this.f3855c = str.substring(0, iIndexOf2);
                    this.f3856d = str.substring(iIndexOf2 + 1);
                } else {
                    this.f3856d = str;
                }
            } else {
                this.f3855c = str;
            }
            this.f3855c = this.f3855c.replaceAll(",", BuildConfig.FLAVOR);
            this.f3856d = this.f3856d.replaceAll(",", BuildConfig.FLAVOR);
        }

        b(DataInput dataInput) throws IOException {
            super(null);
            this.f3855c = dataInput.readUTF();
            byte b3 = dataInput.readByte();
            if ((f3852g & b3) != 0) {
                this.f3854b = true;
                this.f3856d = dataInput.readUTF();
            } else {
                this.f3856d = BuildConfig.FLAVOR;
            }
            if ((b3 & f3853h) != 0) {
                this.f3858f = dataInput.readInt();
            }
        }
    }

    public a(boolean z2, boolean z3) {
        this.f3849b = new ArrayList<>();
        this.f3850c = new ArrayList<>();
    }

    a(DataInput dataInput) throws IOException {
        this.f3848a = new ArrayList<>();
        int i3 = dataInput.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f3848a.add(f1(dataInput));
        }
    }

    a(DataInput dataInput, boolean z2) throws IOException {
        VLog.d("BBKCalculator/CalculatorExpr", "CalculatorExpr: ");
        int i3 = dataInput.readInt();
        int i4 = 0;
        if (z2) {
            this.f3849b = new ArrayList<>();
            while (i4 < i3) {
                this.f3849b.add(g1(dataInput));
                i4++;
            }
            return;
        }
        this.f3850c = new ArrayList<>();
        while (i4 < i3) {
            this.f3850c.add(g1(dataInput));
            i4++;
        }
    }
}
