package p;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: ConstraintWidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends l {
    int C0;
    int D0;
    int E0;
    int F0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    q.b f5581x0 = new q.b(this);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public q.e f5582y0 = new q.e(this);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    protected q.b.InterfaceC0082b f5583z0 = null;
    private boolean A0 = false;
    protected o.d B0 = new o.d();
    int G0 = 0;
    int H0 = 0;
    c[] I0 = new c[4];
    c[] J0 = new c[4];
    public boolean K0 = false;
    public boolean L0 = false;
    public boolean M0 = false;
    public int N0 = 0;
    public int O0 = 0;
    private int P0 = 263;
    public boolean Q0 = false;
    private boolean R0 = false;
    private boolean S0 = false;
    int T0 = 0;

    private void M0(e eVar) {
        int i3 = this.G0 + 1;
        c[] cVarArr = this.J0;
        if (i3 >= cVarArr.length) {
            this.J0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.J0[this.G0] = new c(eVar, 0, W0());
        this.G0++;
    }

    private void N0(e eVar) {
        int i3 = this.H0 + 1;
        c[] cVarArr = this.I0;
        if (i3 >= cVarArr.length) {
            this.I0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.I0[this.H0] = new c(eVar, 1, W0());
        this.H0++;
    }

    private void a1() {
        this.G0 = 0;
        this.H0 = 0;
    }

    @Override // p.e
    public void F0(boolean z2, boolean z3) {
        super.F0(z2, z3);
        int size = this.f5594w0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f5594w0.get(i3).F0(z2, z3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0151  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c7 A[PHI: r0 r5
  0x01c7: PHI (r0v26 ??) = (r0v25 ??), (r0v28 ??), (r0v28 ??), (r0v28 ??) binds: [B:69:0x018c, B:77:0x01af, B:78:0x01b1, B:80:0x01b7] A[DONT_GENERATE, DONT_INLINE]
  0x01c7: PHI (r5v11 boolean) = (r5v10 boolean), (r5v13 boolean), (r5v13 boolean), (r5v13 boolean) binds: [B:69:0x018c, B:77:0x01af, B:78:0x01b1, B:80:0x01b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    @Override // p.l
    public void H0() {
        ?? r11;
        boolean z2;
        ?? r12;
        boolean z3;
        ?? r3;
        ?? r13;
        boolean z4;
        boolean zL0;
        this.S = 0;
        this.T = 0;
        int iMax = Math.max(0, N());
        int iMax2 = Math.max(0, t());
        this.R0 = false;
        this.S0 = false;
        boolean z5 = Z0(64) || Z0(128);
        o.d dVar = this.B0;
        dVar.f5352g = false;
        dVar.f5353h = false;
        if (this.P0 != 0 && z5) {
            dVar.f5353h = true;
        }
        e.b[] bVarArr = this.M;
        e.b bVar = bVarArr[1];
        e.b bVar2 = bVarArr[0];
        ArrayList<e> arrayList = this.f5594w0;
        e.b bVarW = w();
        e.b bVar3 = e.b.WRAP_CONTENT;
        boolean z6 = bVarW == bVar3 || K() == bVar3;
        a1();
        int size = this.f5594w0.size();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = this.f5594w0.get(i3);
            if (eVar instanceof l) {
                ((l) eVar).H0();
            }
        }
        int i4 = 0;
        boolean z7 = false;
        ?? r14 = 1;
        while (r14 != 0) {
            int i5 = i4 + 1;
            try {
                this.B0.D();
                a1();
                j(this.B0);
                for (int i6 = 0; i6 < size; i6++) {
                    this.f5594w0.get(i6).j(this.B0);
                }
                zL0 = L0(this.B0);
                r11 = zL0;
                if (zL0) {
                    this.B0.z();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                System.out.println("EXCEPTION : " + e3);
                r11 = r14;
            }
            if (r11 != 0) {
                e1(this.B0, j.f5591a);
            } else {
                G0(this.B0);
                for (int i7 = 0; i7 < size; i7++) {
                    r11 = zL0;
                    this.f5594w0.get(i7).G0(this.B0);
                }
            }
            if (z6) {
                r11 = zL0;
                if (i5 >= 8 || !j.f5591a[2]) {
                    r11 = zL0;
                    r11 = zL0;
                    r11 = zL0;
                    r11 = zL0;
                    z2 = false;
                } else {
                    int iMax3 = 0;
                    int iMax4 = 0;
                    for (int i8 = 0; i8 < size; i8++) {
                        r11 = zL0;
                        e eVar2 = this.f5594w0.get(i8);
                        iMax3 = Math.max(iMax3, eVar2.S + eVar2.N());
                        iMax4 = Math.max(iMax4, eVar2.T + eVar2.t());
                    }
                    r11 = zL0;
                    int iMax5 = Math.max(this.Z, iMax3);
                    int iMax6 = Math.max(this.f5528a0, iMax4);
                    e.b bVar4 = e.b.WRAP_CONTENT;
                    if (bVar2 != bVar4 || N() >= iMax5) {
                        z2 = false;
                        z7 = z7;
                    } else {
                        B0(iMax5);
                        this.M[0] = bVar4;
                        z2 = true;
                        z7 = true;
                    }
                    if (bVar == bVar4 && t() < iMax6) {
                        e0(iMax6);
                        this.M[1] = bVar4;
                        z2 = true;
                        z7 = true;
                    }
                }
            } else {
                r11 = zL0;
                r11 = zL0;
                r11 = zL0;
                r11 = zL0;
                z2 = false;
            }
            int iMax7 = Math.max(this.Z, N());
            boolean z8 = z2;
            boolean z9 = z7;
            if (iMax7 > N()) {
                B0(iMax7);
                this.M[0] = e.b.FIXED;
                z8 = true;
                z9 = true;
            }
            int iMax8 = Math.max(this.f5528a0, t());
            if (iMax8 > t()) {
                e0(iMax8);
                r12 = 1;
                this.M[1] = e.b.FIXED;
                r3 = 1;
                z3 = true;
            } else {
                r12 = 1;
                z3 = z9;
            }
            if (z3) {
                r3 = z8;
                r13 = r3;
                z4 = z3;
            } else {
                r3 = z8;
                e.b bVar5 = this.M[0];
                e.b bVar6 = e.b.WRAP_CONTENT;
                if (bVar5 == bVar6 && iMax > 0) {
                    r3 = r3;
                    z3 = z3;
                    if (N() > iMax) {
                        this.R0 = r12;
                        this.M[0] = e.b.FIXED;
                        B0(iMax);
                        ?? r4 = r12;
                        z3 = r4 == true ? 1 : 0;
                        r3 = r4;
                    }
                }
                r3 = r3;
                r3 = r3;
                z3 = z3;
                z3 = z3;
                if (this.M[r12] != bVar6 || iMax2 <= 0 || t() <= iMax2) {
                    r3 = z8;
                    r13 = r3;
                    z4 = z3;
                } else {
                    this.S0 = r12;
                    this.M[r12] = e.b.FIXED;
                    e0(iMax2);
                    r13 = 1;
                    z4 = true;
                }
            }
            i4 = i5;
            r14 = r13;
            z7 = z4;
        }
        this.f5594w0 = arrayList;
        if (z7) {
            e.b[] bVarArr2 = this.M;
            bVarArr2[0] = bVar2;
            bVarArr2[1] = bVar;
        }
        X(this.B0.v());
    }

    void K0(e eVar, int i3) {
        if (i3 == 0) {
            M0(eVar);
        } else if (i3 == 1) {
            N0(eVar);
        }
    }

    public boolean L0(o.d dVar) {
        f(dVar);
        int size = this.f5594w0.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = this.f5594w0.get(i3);
            eVar.l0(0, false);
            eVar.l0(1, false);
            if (eVar instanceof a) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                e eVar2 = this.f5594w0.get(i4);
                if (eVar2 instanceof a) {
                    ((a) eVar2).K0();
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            e eVar3 = this.f5594w0.get(i5);
            if (eVar3.e()) {
                eVar3.f(dVar);
            }
        }
        for (int i6 = 0; i6 < size; i6++) {
            e eVar4 = this.f5594w0.get(i6);
            if (eVar4 instanceof f) {
                e.b[] bVarArr = eVar4.M;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    eVar4.i0(e.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    eVar4.x0(e.b.FIXED);
                }
                eVar4.f(dVar);
                if (bVar == bVar3) {
                    eVar4.i0(bVar);
                }
                if (bVar2 == bVar3) {
                    eVar4.x0(bVar2);
                }
            } else {
                j.a(this, dVar, eVar4);
                if (!eVar4.e()) {
                    eVar4.f(dVar);
                }
            }
        }
        if (this.G0 > 0) {
            b.a(this, dVar, 0);
        }
        if (this.H0 > 0) {
            b.a(this, dVar, 1);
        }
        return true;
    }

    public boolean O0(boolean z2) {
        return this.f5582y0.f(z2);
    }

    public boolean P0(boolean z2) {
        return this.f5582y0.g(z2);
    }

    public boolean Q0(boolean z2, int i3) {
        return this.f5582y0.h(z2, i3);
    }

    public q.b.InterfaceC0082b R0() {
        return this.f5583z0;
    }

    public int S0() {
        return this.P0;
    }

    public void T0() {
        this.f5582y0.j();
    }

    public void U0() {
        this.f5582y0.k();
    }

    public boolean V0() {
        return this.S0;
    }

    @Override // p.l, p.e
    public void W() {
        this.B0.D();
        this.C0 = 0;
        this.E0 = 0;
        this.D0 = 0;
        this.F0 = 0;
        this.Q0 = false;
        super.W();
    }

    public boolean W0() {
        return this.A0;
    }

    public boolean X0() {
        return this.R0;
    }

    public long Y0(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.C0 = i10;
        this.D0 = i11;
        return this.f5581x0.d(this, i3, i10, i11, i4, i5, i6, i7, i8, i9);
    }

    public boolean Z0(int i3) {
        return (this.P0 & i3) == i3;
    }

    public void b1(q.b.InterfaceC0082b interfaceC0082b) {
        this.f5583z0 = interfaceC0082b;
        this.f5582y0.n(interfaceC0082b);
    }

    public void c1(int i3) {
        this.P0 = i3;
        o.d.f5343s = j.b(i3, 256);
    }

    public void d1(boolean z2) {
        this.A0 = z2;
    }

    public void e1(o.d dVar, boolean[] zArr) {
        zArr[2] = false;
        G0(dVar);
        int size = this.f5594w0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f5594w0.get(i3).G0(dVar);
        }
    }

    public void f1() {
        this.f5581x0.e(this);
    }
}
