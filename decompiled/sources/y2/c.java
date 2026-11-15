package y2;

import java.util.Random;

/* JADX INFO: compiled from: CompiledFunction.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final p f6484k = new p();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Random f6485l = new Random();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final double[] f6486m = new double[0];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final m[] f6487n = new m[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double[] f6488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final double[] f6489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m[] f6490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f6491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f6492j;

    /* JADX INFO: compiled from: CompiledFunction.java */
    static class a extends m {
        a() {
        }

        @Override // y2.m
        public int a() {
            return 1;
        }

        @Override // y2.m
        public double d(double d3) {
            if (d3 > 0.0d) {
                return 1.0d;
            }
            return d3 < 0.0d ? -1.0d : 0.0d;
        }
    }

    c(int i3, byte[] bArr, double[] dArr, double[] dArr2, m[] mVarArr) {
        this.f6492j = i3;
        this.f6491i = bArr;
        this.f6488f = dArr;
        this.f6489g = dArr2;
        this.f6490h = mVarArr;
    }

    private double t(double[] dArr, l lVar) {
        return r(s(dArr, lVar), lVar).g();
    }

    private int u(l lVar, int i3) {
        int i4 = i3 + 1;
        int iX = x(lVar, i3, -2);
        if (iX == i4) {
            e[] eVarArr = lVar.f6522b;
            eVarArr[iX - this.f6492j].G(eVarArr[iX]);
            return iX - this.f6492j;
        }
        throw new Error("Stack pointer after exec: expected " + i4 + ", got " + iX);
    }

    private int v(l lVar, int i3) throws p {
        int i4 = i3 + 1;
        int iW = w(lVar, i3);
        if (iW == i4) {
            double[] dArr = lVar.f6521a;
            int i5 = this.f6492j;
            dArr[iW - i5] = dArr[iW];
            return iW - i5;
        }
        throw new Error("Stack pointer after exec: expected " + i4 + ", got " + iW);
    }

    static m y(int i3) {
        byte[] bArr = a0.f6480b;
        if (bArr[i3] != 1) {
            throw new Error("makeOpFunction expects arity 1, found " + ((int) bArr[i3]));
        }
        double[] dArr = f6486m;
        c cVar = new c(bArr[i3], new byte[]{38, (byte) i3}, dArr, dArr, f6487n);
        if (i3 == 29) {
            cVar.l(new a());
        }
        return cVar;
    }

    @Override // y2.m
    public int a() {
        return this.f6492j;
    }

    @Override // y2.g
    public double o(double[] dArr, l lVar) {
        if (this.f6489g != null) {
            return t(dArr, lVar);
        }
        b(dArr.length);
        System.arraycopy(dArr, 0, lVar.f6521a, lVar.f6523c, dArr.length);
        try {
            v(lVar, (lVar.f6523c + dArr.length) - 1);
            return lVar.f6521a[lVar.f6523c];
        } catch (p unused) {
            return t(dArr, lVar);
        }
    }

    @Override // y2.g
    public e r(e[] eVarArr, l lVar) {
        b(eVarArr.length);
        e[] eVarArr2 = lVar.f6522b;
        int i3 = lVar.f6523c;
        for (int i4 = 0; i4 < eVarArr.length; i4++) {
            eVarArr2[i4 + i3].G(eVarArr[i4]);
        }
        u(lVar, (eVarArr.length + i3) - 1);
        return eVarArr2[i3];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f6492j != 0) {
            stringBuffer.append("arity ");
            stringBuffer.append(this.f6492j);
            stringBuffer.append("; ");
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f6491i;
            if (i3 >= bArr.length) {
                break;
            }
            byte b3 = bArr[i3];
            stringBuffer.append(a0.f6479a[b3]);
            if (b3 == 1) {
                stringBuffer.append(' ');
                if (this.f6489g == null) {
                    stringBuffer.append(this.f6488f[i4]);
                } else {
                    stringBuffer.append('(');
                    stringBuffer.append(this.f6488f[i4]);
                    stringBuffer.append(", ");
                    stringBuffer.append(this.f6489g[i4]);
                    stringBuffer.append(')');
                }
                i4++;
            } else if (b3 == 2) {
                i5++;
            }
            stringBuffer.append("; ");
            i3++;
        }
        if (i4 != this.f6488f.length) {
            stringBuffer.append("\nuses only ");
            stringBuffer.append(i4);
            stringBuffer.append(" consts out of ");
            stringBuffer.append(this.f6488f.length);
        }
        if (i5 != this.f6490h.length) {
            stringBuffer.append("\nuses only ");
            stringBuffer.append(i5);
            stringBuffer.append(" funcs out of ");
            stringBuffer.append(this.f6490h.length);
        }
        return stringBuffer.toString();
    }

    int w(l lVar, int i3) throws p {
        double dC;
        if (this.f6489g != null) {
            throw f6484k;
        }
        double[] dArr = lVar.f6521a;
        int i4 = i3 - this.f6492j;
        int length = this.f6491i.length;
        int i5 = 0;
        int i6 = -2;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int iV = i3;
        while (i7 < length) {
            int i10 = this.f6491i[i7];
            switch (i10) {
                case 1:
                    i4 = i4;
                    length = length;
                    i6 = i6;
                    iV++;
                    dArr[iV] = this.f6488f[i8];
                    i8++;
                    i6 = i6;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 2:
                    int i11 = i9 + 1;
                    m mVar = this.f6490h[i9];
                    if (mVar instanceof c) {
                        iV = ((c) mVar).v(lVar, iV);
                        i4 = i4;
                        length = length;
                        i9 = i11;
                    } else {
                        int iA = mVar.a();
                        int i12 = iV - iA;
                        int i13 = lVar.f6523c;
                        int i14 = i12 + 1;
                        try {
                            lVar.f6523c = i14;
                            if (iA == 0) {
                                dC = mVar.c();
                            } else if (iA == 1) {
                                dC = mVar.d(dArr[i14]);
                            } else if (iA != 2) {
                                double[] dArr2 = new double[iA];
                                System.arraycopy(dArr, i14, dArr2, i5, iA);
                                dC = mVar.f(dArr2);
                            } else {
                                dC = mVar.e(dArr[i14], dArr[i12 + 2]);
                            }
                            lVar.f6523c = i13;
                            dArr[i14] = dC;
                            i9 = i11;
                            iV = i14;
                            i6 = i6;
                        } catch (Throwable th) {
                            lVar.f6523c = i13;
                            throw th;
                        }
                    }
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 3:
                    iV--;
                    double d3 = dArr[iV];
                    double d4 = d3 + (i6 == i7 + (-1) ? dArr[iV] * dArr[iV + 1] : dArr[iV + 1]);
                    dArr[iV] = Math.abs(d4) >= Math.ulp(d3) * 1024.0d ? d4 : 0.0d;
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 4:
                    iV--;
                    double d5 = dArr[iV];
                    double d6 = d5 - (i6 == i7 + (-1) ? dArr[iV] * dArr[iV + 1] : dArr[iV + 1]);
                    dArr[iV] = Math.abs(d6) >= Math.ulp(d5) * 1024.0d ? d6 : 0.0d;
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 5:
                    iV--;
                    dArr[iV] = dArr[iV] * dArr[iV + 1];
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 6:
                    iV--;
                    dArr[iV] = dArr[iV] / dArr[iV + 1];
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 7:
                    iV--;
                    dArr[iV] = dArr[iV] % dArr[iV + 1];
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 8:
                    iV++;
                    dArr[iV] = f6485l.nextDouble();
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 9:
                    dArr[iV] = -dArr[iV];
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 10:
                    iV--;
                    dArr[iV] = Math.pow(dArr[iV], dArr[iV + 1]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 11:
                    dArr[iV] = r.f(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 12:
                    dArr[iV] = dArr[iV] * 0.01d;
                    i4 = i4;
                    length = length;
                    i6 = i7;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 13:
                    double d7 = dArr[iV];
                    if (d7 < 0.0d) {
                        throw f6484k;
                    }
                    dArr[iV] = Math.sqrt(d7);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                    break;
                case 14:
                    dArr[iV] = Math.cbrt(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 15:
                    dArr[iV] = Math.exp(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 16:
                    dArr[iV] = Math.log(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 17:
                    dArr[iV] = r.k(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 18:
                    dArr[iV] = r.e(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 19:
                    dArr[iV] = r.l(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 20:
                    double d8 = dArr[iV];
                    if (d8 < -1.0d || d8 > 1.0d) {
                        throw f6484k;
                    }
                    dArr[iV] = Math.asin(d8);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 21:
                    double d9 = dArr[iV];
                    if (d9 < -1.0d || d9 > 1.0d) {
                        throw f6484k;
                    }
                    dArr[iV] = Math.acos(d9);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 22:
                    dArr[iV] = Math.atan(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 23:
                    dArr[iV] = Math.sinh(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 24:
                    dArr[iV] = Math.cosh(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 25:
                    dArr[iV] = Math.tanh(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 26:
                    dArr[iV] = r.b(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 27:
                    dArr[iV] = r.a(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 28:
                    dArr[iV] = r.c(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 29:
                    dArr[iV] = Math.abs(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 30:
                    dArr[iV] = Math.floor(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 31:
                    dArr[iV] = Math.ceil(dArr[iV]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 32:
                    dArr[iV] = dArr[iV] <= 0.0d ? dArr[iV] < 0.0d ? -1.0d : 0.0d : 1.0d;
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 33:
                    iV--;
                    dArr[iV] = Math.min(dArr[iV], dArr[iV + 1]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 34:
                    iV--;
                    dArr[iV] = Math.min(dArr[iV], dArr[iV + 1]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 35:
                    iV--;
                    dArr[iV] = r.g(dArr[iV], dArr[iV + 1]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 36:
                    iV--;
                    dArr[iV] = r.d(dArr[iV], dArr[iV + 1]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 37:
                    iV--;
                    dArr[iV] = r.j(dArr[iV], dArr[iV + 1]);
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                    iV++;
                    dArr[iV] = dArr[(i10 + i4) - 37];
                    i4 = i4;
                    length = length;
                    i7++;
                    i4 = i4;
                    length = length;
                    i5 = 0;
                    break;
                default:
                    throw new Error("Unknown opcode " + i10);
            }
        }
        return iV;
    }

    int x(l lVar, int i3, int i4) {
        int i5;
        int i6;
        e eVar;
        int i7;
        e[] eVarArr = lVar.f6522b;
        int i8 = i3 - this.f6492j;
        int iU = i3;
        int i9 = i4;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int length = this.f6491i.length; i10 < length; length = i6) {
            int i13 = this.f6491i[i10];
            switch (i13) {
                case 1:
                    i5 = i8;
                    i6 = length;
                    iU++;
                    e eVar2 = eVarArr[iU];
                    double d3 = this.f6488f[i11];
                    double[] dArr = this.f6489g;
                    eVar2.F(d3, dArr != null ? dArr[i11] : 0.0d);
                    i11++;
                    i10++;
                    i8 = i5;
                    break;
                case 2:
                    i5 = i8;
                    i6 = length;
                    int i14 = iU;
                    int i15 = i12 + 1;
                    m mVar = this.f6490h[i12];
                    if (mVar instanceof c) {
                        iU = ((c) mVar).u(lVar, i14);
                        i12 = i15;
                    } else {
                        int iA = mVar.a();
                        int i16 = i14 - iA;
                        int i17 = lVar.f6523c;
                        int i18 = i16 + 1;
                        try {
                            lVar.f6523c = i18;
                            if (iA == 0) {
                                eVar = new e(mVar.c(), 0.0d);
                            } else if (iA == 1) {
                                eVar = mVar.g(eVarArr[i18]);
                            } else if (iA != 2) {
                                e[] eVarArr2 = new e[iA];
                                System.arraycopy(eVarArr, i18, eVarArr2, 0, iA);
                                eVar = mVar.i(eVarArr2);
                            } else {
                                eVar = mVar.h(eVarArr[i18], eVarArr[i16 + 2]);
                            }
                            lVar.f6523c = i17;
                            eVarArr[i18].G(eVar);
                            i12 = i15;
                            iU = i18;
                        } catch (Throwable th) {
                            lVar.f6523c = i17;
                            throw th;
                        }
                    }
                    i10++;
                    i8 = i5;
                    break;
                case 3:
                    i5 = i8;
                    i6 = length;
                    iU--;
                    eVarArr[iU].e(i9 == i10 + (-1) ? eVarArr[iU + 1].A(eVarArr[iU]) : eVarArr[iU + 1]);
                    i10++;
                    i8 = i5;
                    break;
                case 4:
                    i5 = i8;
                    i6 = length;
                    iU--;
                    eVarArr[iU].M(i9 == i10 + (-1) ? eVarArr[iU + 1].A(eVarArr[iU]) : eVarArr[iU + 1]);
                    i10++;
                    i8 = i5;
                    break;
                case 5:
                    i5 = i8;
                    i6 = length;
                    iU--;
                    eVarArr[iU].A(eVarArr[iU + 1]);
                    i10++;
                    i8 = i5;
                    break;
                case 6:
                    i5 = i8;
                    i6 = length;
                    iU--;
                    eVarArr[iU].p(eVarArr[iU + 1]);
                    i10++;
                    i8 = i5;
                    break;
                case 7:
                    i5 = i8;
                    i6 = length;
                    iU--;
                    eVarArr[iU].y(eVarArr[iU + 1]);
                    i10++;
                    i8 = i5;
                    break;
                case 8:
                    iU++;
                    i5 = i8;
                    i6 = length;
                    eVarArr[iU].F(f6485l.nextDouble(), 0.0d);
                    i10++;
                    i8 = i5;
                    break;
                case 9:
                    i7 = iU;
                    eVarArr[i7].B();
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 10:
                    iU--;
                    eVarArr[iU].E(eVarArr[iU + 1]);
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 11:
                    i7 = iU;
                    eVarArr[i7].r();
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 12:
                    int i19 = iU;
                    eVarArr[i19].z(0.01d);
                    iU = i19;
                    i5 = i8;
                    i6 = length;
                    i9 = i10;
                    i10++;
                    i8 = i5;
                    break;
                case 13:
                    i7 = iU;
                    eVarArr[i7].J();
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 14:
                    i7 = iU;
                    eVarArr[iU].E(new e(3.3333333333333335d, 0.0d));
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 15:
                    eVarArr[iU].q();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 16:
                    eVarArr[iU].x();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 17:
                    eVarArr[iU].H();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 18:
                    eVarArr[iU].n();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 19:
                    eVarArr[iU].O();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 20:
                    eVarArr[iU].h();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 21:
                    eVarArr[iU].c();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 22:
                    eVarArr[iU].j();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 23:
                    eVarArr[iU].I();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 24:
                    eVarArr[iU].o();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 25:
                    eVarArr[iU].P();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 26:
                    eVarArr[iU].i();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 27:
                    eVarArr[iU].d();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 28:
                    eVarArr[iU].k();
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 29:
                    eVarArr[iU].F(eVarArr[iU].a(), 0.0d);
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 30:
                    eVarArr[iU].F(Math.floor(eVarArr[iU].f6500a), 0.0d);
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 31:
                    eVarArr[iU].F(Math.ceil(eVarArr[iU].f6500a), 0.0d);
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 32:
                    double d4 = eVarArr[iU].f6500a;
                    eVarArr[iU].F(d4 > 0.0d ? 1.0d : d4 < 0.0d ? -1.0d : 0.0d, 0.0d);
                    i7 = iU;
                    iU = i7;
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 33:
                    iU--;
                    int i20 = iU + 1;
                    if (eVarArr[i20].f6500a < eVarArr[iU].f6500a) {
                        eVarArr[iU].G(eVarArr[i20]);
                    }
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 34:
                    iU--;
                    int i21 = iU + 1;
                    if (eVarArr[iU].f6500a < eVarArr[i21].f6500a) {
                        eVarArr[iU].G(eVarArr[i21]);
                    }
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 35:
                    iU--;
                    eVarArr[iU].s(eVarArr[iU + 1]);
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 36:
                    iU--;
                    eVarArr[iU].l(eVarArr[iU + 1]);
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 37:
                    iU--;
                    eVarArr[iU].D(eVarArr[iU + 1]);
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                    iU++;
                    eVarArr[iU].G(eVarArr[(i13 + i8) - 37]);
                    i5 = i8;
                    i6 = length;
                    i10++;
                    i8 = i5;
                    break;
                default:
                    throw new Error("Unknown opcode " + i13);
            }
        }
        return iU;
    }
}
