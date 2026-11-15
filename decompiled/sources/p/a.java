package p;

/* JADX INFO: compiled from: Barrier.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends i {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private int f5484y0 = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f5485z0 = true;
    private int A0 = 0;

    public boolean H0() {
        return this.f5485z0;
    }

    public int I0() {
        return this.f5484y0;
    }

    public int J0() {
        return this.A0;
    }

    protected void K0() {
        for (int i3 = 0; i3 < this.f5590x0; i3++) {
            e eVar = this.f5589w0[i3];
            int i4 = this.f5484y0;
            if (i4 == 0 || i4 == 1) {
                eVar.l0(0, true);
            } else if (i4 == 2 || i4 == 3) {
                eVar.l0(1, true);
            }
        }
    }

    public void L0(boolean z2) {
        this.f5485z0 = z2;
    }

    public void M0(int i3) {
        this.f5484y0 = i3;
    }

    public void N0(int i3) {
        this.A0 = i3;
    }

    @Override // p.e
    public void f(o.d dVar) {
        d[] dVarArr;
        boolean z2;
        int i3;
        int i4;
        int i5;
        d[] dVarArr2 = this.J;
        dVarArr2[0] = this.B;
        dVarArr2[2] = this.C;
        dVarArr2[1] = this.D;
        dVarArr2[3] = this.E;
        int i6 = 0;
        while (true) {
            dVarArr = this.J;
            if (i6 >= dVarArr.length) {
                break;
            }
            dVarArr[i6].f5514g = dVar.q(dVarArr[i6]);
            i6++;
        }
        int i7 = this.f5484y0;
        if (i7 < 0 || i7 >= 4) {
            return;
        }
        d dVar2 = dVarArr[i7];
        int i8 = 0;
        while (true) {
            if (i8 >= this.f5590x0) {
                z2 = false;
                break;
            }
            e eVar = this.f5589w0[i8];
            if ((this.f5485z0 || eVar.g()) && ((((i4 = this.f5484y0) == 0 || i4 == 1) && eVar.w() == e.b.MATCH_CONSTRAINT && eVar.B.f5511d != null && eVar.D.f5511d != null) || (((i5 = this.f5484y0) == 2 || i5 == 3) && eVar.K() == e.b.MATCH_CONSTRAINT && eVar.C.f5511d != null && eVar.E.f5511d != null))) {
                z2 = true;
                break;
            }
            i8++;
        }
        boolean z3 = this.B.h() || this.D.h();
        boolean z4 = this.C.h() || this.E.h();
        int i9 = !z2 && (((i3 = this.f5484y0) == 0 && z3) || ((i3 == 2 && z4) || ((i3 == 1 && z3) || (i3 == 3 && z4)))) ? 5 : 4;
        for (int i10 = 0; i10 < this.f5590x0; i10++) {
            e eVar2 = this.f5589w0[i10];
            if (this.f5485z0 || eVar2.g()) {
                o.i iVarQ = dVar.q(eVar2.J[this.f5484y0]);
                d[] dVarArr3 = eVar2.J;
                int i11 = this.f5484y0;
                dVarArr3[i11].f5514g = iVarQ;
                int i12 = (dVarArr3[i11].f5511d == null || dVarArr3[i11].f5511d.f5509b != this) ? 0 : dVarArr3[i11].f5512e + 0;
                if (i11 == 0 || i11 == 2) {
                    dVar.i(dVar2.f5514g, iVarQ, this.A0 - i12, z2);
                } else {
                    dVar.g(dVar2.f5514g, iVarQ, this.A0 + i12, z2);
                }
                dVar.e(dVar2.f5514g, iVarQ, this.A0 + i12, i9);
            }
        }
        int i13 = this.f5484y0;
        if (i13 == 0) {
            dVar.e(this.D.f5514g, this.B.f5514g, 0, 8);
            dVar.e(this.B.f5514g, this.N.D.f5514g, 0, 4);
            dVar.e(this.B.f5514g, this.N.B.f5514g, 0, 0);
            return;
        }
        if (i13 == 1) {
            dVar.e(this.B.f5514g, this.D.f5514g, 0, 8);
            dVar.e(this.B.f5514g, this.N.B.f5514g, 0, 4);
            dVar.e(this.B.f5514g, this.N.D.f5514g, 0, 0);
        } else if (i13 == 2) {
            dVar.e(this.E.f5514g, this.C.f5514g, 0, 8);
            dVar.e(this.C.f5514g, this.N.E.f5514g, 0, 4);
            dVar.e(this.C.f5514g, this.N.C.f5514g, 0, 0);
        } else if (i13 == 3) {
            dVar.e(this.C.f5514g, this.E.f5514g, 0, 8);
            dVar.e(this.C.f5514g, this.N.C.f5514g, 0, 4);
            dVar.e(this.C.f5514g, this.N.E.f5514g, 0, 0);
        }
    }

    @Override // p.e
    public boolean g() {
        return true;
    }

    @Override // p.e
    public String toString() {
        String str = "[Barrier] " + p() + " {";
        for (int i3 = 0; i3 < this.f5590x0; i3++) {
            e eVar = this.f5589w0[i3];
            if (i3 > 0) {
                str = str + ", ";
            }
            str = str + eVar.p();
        }
        return str + "}";
    }
}
