package q;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ChainRun.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ArrayList<m> f5792k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f5793l;

    public c(p.e eVar, int i3) {
        super(eVar);
        this.f5792k = new ArrayList<>();
        this.f5843f = i3;
        q();
    }

    private void q() {
        p.e eVar;
        p.e eVar2 = this.f5839b;
        p.e eVarF = eVar2.F(this.f5843f);
        while (true) {
            p.e eVar3 = eVarF;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                eVarF = eVar2.F(this.f5843f);
            }
        }
        this.f5839b = eVar;
        this.f5792k.add(eVar.H(this.f5843f));
        p.e eVarD = eVar.D(this.f5843f);
        while (eVarD != null) {
            this.f5792k.add(eVarD.H(this.f5843f));
            eVarD = eVarD.D(this.f5843f);
        }
        for (m mVar : this.f5792k) {
            int i3 = this.f5843f;
            if (i3 == 0) {
                mVar.f5839b.f5531c = this;
            } else if (i3 == 1) {
                mVar.f5839b.f5533d = this;
            }
        }
        if ((this.f5843f == 0 && ((p.f) this.f5839b.E()).W0()) && this.f5792k.size() > 1) {
            ArrayList<m> arrayList = this.f5792k;
            this.f5839b = arrayList.get(arrayList.size() - 1).f5839b;
        }
        this.f5793l = this.f5843f == 0 ? this.f5839b.v() : this.f5839b.J();
    }

    private p.e r() {
        for (int i3 = 0; i3 < this.f5792k.size(); i3++) {
            m mVar = this.f5792k.get(i3);
            if (mVar.f5839b.M() != 8) {
                return mVar.f5839b;
            }
        }
        return null;
    }

    private p.e s() {
        for (int size = this.f5792k.size() - 1; size >= 0; size--) {
            m mVar = this.f5792k.get(size);
            if (mVar.f5839b.M() != 8) {
                return mVar.f5839b;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:120:0x01cd A[PHI: r1 r22 r23 r24
  0x01cd: PHI (r1v62 int) = (r1v60 int), (r1v68 int) binds: [B:119:0x01cb, B:110:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01cd: PHI (r22v3 float) = (r22v2 float), (r22v5 float) binds: [B:119:0x01cb, B:110:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01cd: PHI (r23v6 boolean) = (r23v5 boolean), (r23v8 boolean) binds: [B:119:0x01cb, B:110:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01cd: PHI (r24v6 int) = (r24v5 int), (r24v8 int) binds: [B:119:0x01cb, B:110:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:303:0x00f6 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ee A[ADDED_TO_REGION] */
    @Override // q.m, q.d
    public void a(d dVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f3;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z3;
        int i12;
        float f4;
        int iMax;
        int i13;
        int i14;
        float f5;
        if (this.f5845h.f5812j && this.f5846i.f5812j) {
            p.e eVarE = this.f5839b.E();
            boolean zW0 = (eVarE == null || !(eVarE instanceof p.f)) ? false : ((p.f) eVarE).W0();
            int i15 = this.f5846i.f5809g - this.f5845h.f5809g;
            int size = this.f5792k.size();
            int i16 = 0;
            while (true) {
                i3 = -1;
                i4 = 8;
                if (i16 >= size) {
                    i16 = -1;
                    break;
                } else if (this.f5792k.get(i16).f5839b.M() != 8) {
                    break;
                } else {
                    i16++;
                }
            }
            int i17 = size - 1;
            for (int i18 = i17; i18 >= 0; i18--) {
                if (this.f5792k.get(i18).f5839b.M() != 8) {
                    i3 = i18;
                    break;
                }
            }
            int i19 = 0;
            while (true) {
                if (i19 >= 2) {
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    f3 = 0.0f;
                    break;
                }
                int i20 = 0;
                i6 = 0;
                i7 = 0;
                int i21 = 0;
                f3 = 0.0f;
                while (i20 < size) {
                    m mVar = this.f5792k.get(i20);
                    if (mVar.f5839b.M() != i4) {
                        i21++;
                        if (i20 > 0 && i20 >= i16) {
                            i6 += mVar.f5845h.f5808f;
                        }
                        g gVar = mVar.f5842e;
                        int i22 = gVar.f5809g;
                        boolean z4 = mVar.f5841d != p.e.b.MATCH_CONSTRAINT;
                        if (z4) {
                            int i23 = this.f5843f;
                            if (i23 == 0 && !mVar.f5839b.f5535e.f5842e.f5812j) {
                                return;
                            }
                            if (i23 == 1 && !mVar.f5839b.f5537f.f5842e.f5812j) {
                                return;
                            } else {
                                i13 = i22;
                            }
                        } else {
                            i13 = i22;
                            if (mVar.f5838a == 1 && i19 == 0) {
                                i14 = gVar.f5824m;
                                i7++;
                            } else {
                                if (gVar.f5812j) {
                                    i14 = i13;
                                }
                                if (z4) {
                                    i6 += i14;
                                } else {
                                    i7++;
                                    f5 = mVar.f5839b.f5560q0[this.f5843f];
                                    if (f5 >= 0.0f) {
                                        f3 += f5;
                                    }
                                }
                                if (i20 >= i17 && i20 < i3) {
                                    i6 += -mVar.f5846i.f5808f;
                                }
                            }
                            z4 = true;
                            if (z4) {
                                i7++;
                                f5 = mVar.f5839b.f5560q0[this.f5843f];
                                if (f5 >= 0.0f) {
                                    f3 += f5;
                                }
                            } else {
                                i6 += i14;
                            }
                            if (i20 >= i17) {
                            }
                        }
                        i14 = i13;
                        if (z4) {
                            i7++;
                            f5 = mVar.f5839b.f5560q0[this.f5843f];
                            if (f5 >= 0.0f) {
                                f3 += f5;
                            }
                        } else {
                            i6 += i14;
                        }
                        if (i20 >= i17) {
                        }
                    }
                    i20++;
                    i4 = 8;
                }
                if (i6 < i15 || i7 == 0) {
                    i5 = i21;
                    break;
                } else {
                    i19++;
                    i4 = 8;
                }
            }
            int i24 = this.f5845h.f5809g;
            if (zW0) {
                i24 = this.f5846i.f5809g;
            }
            if (i6 > i15) {
                i24 = zW0 ? i24 + ((int) (((i6 - i15) / 2.0f) + 0.5f)) : i24 - ((int) (((i6 - i15) / 2.0f) + 0.5f));
            }
            if (i7 > 0) {
                float f6 = i15 - i6;
                int i25 = (int) ((f6 / i7) + 0.5f);
                int i26 = 0;
                int i27 = 0;
                while (i26 < size) {
                    m mVar2 = this.f5792k.get(i26);
                    int i28 = i25;
                    int i29 = i6;
                    if (mVar2.f5839b.M() != 8 && mVar2.f5841d == p.e.b.MATCH_CONSTRAINT) {
                        g gVar2 = mVar2.f5842e;
                        if (gVar2.f5812j) {
                            z3 = zW0;
                            i12 = i5;
                            i24 = i24;
                            f4 = f6;
                        } else {
                            int i30 = f3 > 0.0f ? (int) (((mVar2.f5839b.f5560q0[this.f5843f] * f6) / f3) + 0.5f) : i28;
                            if (this.f5843f == 0) {
                                p.e eVar = mVar2.f5839b;
                                f4 = f6;
                                int i31 = eVar.f5557p;
                                z3 = zW0;
                                i12 = i5;
                                iMax = Math.max(eVar.f5555o, mVar2.f5838a == 1 ? Math.min(i30, gVar2.f5824m) : i30);
                                if (i31 > 0) {
                                    iMax = Math.min(i31, iMax);
                                }
                                if (iMax != i30) {
                                    i27++;
                                    i30 = iMax;
                                }
                            } else {
                                z3 = zW0;
                                i12 = i5;
                                f4 = f6;
                                p.e eVar2 = mVar2.f5839b;
                                int i32 = eVar2.f5563s;
                                iMax = Math.max(eVar2.f5561r, mVar2.f5838a == 1 ? Math.min(i30, gVar2.f5824m) : i30);
                                if (i32 > 0) {
                                    iMax = Math.min(i32, iMax);
                                }
                                if (iMax != i30) {
                                    i27++;
                                    i30 = iMax;
                                }
                            }
                            mVar2.f5842e.d(i30);
                        }
                    } else {
                        z3 = zW0;
                        i12 = i5;
                        i24 = i24;
                        f4 = f6;
                    }
                    i26++;
                    i25 = i28;
                    i6 = i29;
                    i24 = i24;
                    f6 = f4;
                    zW0 = z3;
                    i5 = i12;
                }
                z2 = zW0;
                i8 = i5;
                i9 = i24;
                int i33 = i6;
                if (i27 > 0) {
                    i7 -= i27;
                    int i34 = 0;
                    for (int i35 = 0; i35 < size; i35++) {
                        m mVar3 = this.f5792k.get(i35);
                        if (mVar3.f5839b.M() != 8) {
                            if (i35 > 0 && i35 >= i16) {
                                i34 += mVar3.f5845h.f5808f;
                            }
                            i34 += mVar3.f5842e.f5809g;
                            if (i35 < i17 && i35 < i3) {
                                i34 += -mVar3.f5846i.f5808f;
                            }
                        }
                    }
                    i6 = i34;
                } else {
                    i6 = i33;
                }
                i11 = 2;
                if (this.f5793l == 2 && i27 == 0) {
                    i10 = 0;
                    this.f5793l = 0;
                } else {
                    i10 = 0;
                }
            } else {
                z2 = zW0;
                i8 = i5;
                i9 = i24;
                i10 = 0;
                i11 = 2;
            }
            if (i6 > i15) {
                this.f5793l = i11;
            }
            if (i8 > 0 && i7 == 0 && i16 == i3) {
                this.f5793l = i11;
            }
            int i36 = this.f5793l;
            if (i36 == 1) {
                int i37 = i8;
                int i38 = i37 > 1 ? (i15 - i6) / (i37 - 1) : i37 == 1 ? (i15 - i6) / 2 : i10;
                if (i7 > 0) {
                    i38 = i10;
                }
                int i39 = i9;
                for (int i40 = i10; i40 < size; i40++) {
                    m mVar4 = this.f5792k.get(z2 ? size - (i40 + 1) : i40);
                    if (mVar4.f5839b.M() == 8) {
                        mVar4.f5845h.d(i39);
                        mVar4.f5846i.d(i39);
                    } else {
                        if (i40 > 0) {
                            i39 = z2 ? i39 - i38 : i39 + i38;
                        }
                        if (i40 > 0 && i40 >= i16) {
                            i39 = z2 ? i39 - mVar4.f5845h.f5808f : i39 + mVar4.f5845h.f5808f;
                        }
                        if (z2) {
                            mVar4.f5846i.d(i39);
                        } else {
                            mVar4.f5845h.d(i39);
                        }
                        g gVar3 = mVar4.f5842e;
                        int i41 = gVar3.f5809g;
                        if (mVar4.f5841d == p.e.b.MATCH_CONSTRAINT && mVar4.f5838a == 1) {
                            i41 = gVar3.f5824m;
                        }
                        i39 = z2 ? i39 - i41 : i39 + i41;
                        if (z2) {
                            mVar4.f5845h.d(i39);
                        } else {
                            mVar4.f5846i.d(i39);
                        }
                        mVar4.f5844g = true;
                        if (i40 < i17 && i40 < i3) {
                            i39 = z2 ? i39 - (-mVar4.f5846i.f5808f) : i39 + (-mVar4.f5846i.f5808f);
                        }
                    }
                }
                return;
            }
            int i42 = i8;
            if (i36 == 0) {
                int i43 = (i15 - i6) / (i42 + 1);
                if (i7 > 0) {
                    i43 = i10;
                }
                int i44 = i9;
                for (int i45 = i10; i45 < size; i45++) {
                    m mVar5 = this.f5792k.get(z2 ? size - (i45 + 1) : i45);
                    if (mVar5.f5839b.M() == 8) {
                        mVar5.f5845h.d(i44);
                        mVar5.f5846i.d(i44);
                    } else {
                        int i46 = z2 ? i44 - i43 : i44 + i43;
                        if (i45 > 0 && i45 >= i16) {
                            i46 = z2 ? i46 - mVar5.f5845h.f5808f : i46 + mVar5.f5845h.f5808f;
                        }
                        if (z2) {
                            mVar5.f5846i.d(i46);
                        } else {
                            mVar5.f5845h.d(i46);
                        }
                        g gVar4 = mVar5.f5842e;
                        int iMin = gVar4.f5809g;
                        if (mVar5.f5841d == p.e.b.MATCH_CONSTRAINT && mVar5.f5838a == 1) {
                            iMin = Math.min(iMin, gVar4.f5824m);
                        }
                        i44 = z2 ? i46 - iMin : i46 + iMin;
                        if (z2) {
                            mVar5.f5845h.d(i44);
                        } else {
                            mVar5.f5846i.d(i44);
                        }
                        if (i45 < i17 && i45 < i3) {
                            i44 = z2 ? i44 - (-mVar5.f5846i.f5808f) : i44 + (-mVar5.f5846i.f5808f);
                        }
                    }
                }
                return;
            }
            if (i36 == 2) {
                float fU = this.f5843f == 0 ? this.f5839b.u() : this.f5839b.I();
                if (z2) {
                    fU = 1.0f - fU;
                }
                int i47 = (int) (((i15 - i6) * fU) + 0.5f);
                if (i47 < 0 || i7 > 0) {
                    i47 = i10;
                }
                int i48 = z2 ? i9 - i47 : i9 + i47;
                for (int i49 = i10; i49 < size; i49++) {
                    m mVar6 = this.f5792k.get(z2 ? size - (i49 + 1) : i49);
                    if (mVar6.f5839b.M() == 8) {
                        mVar6.f5845h.d(i48);
                        mVar6.f5846i.d(i48);
                    } else {
                        if (i49 > 0 && i49 >= i16) {
                            i48 = z2 ? i48 - mVar6.f5845h.f5808f : i48 + mVar6.f5845h.f5808f;
                        }
                        if (z2) {
                            mVar6.f5846i.d(i48);
                        } else {
                            mVar6.f5845h.d(i48);
                        }
                        g gVar5 = mVar6.f5842e;
                        int i50 = gVar5.f5809g;
                        if (mVar6.f5841d == p.e.b.MATCH_CONSTRAINT && mVar6.f5838a == 1) {
                            i50 = gVar5.f5824m;
                        }
                        i48 = z2 ? i48 - i50 : i48 + i50;
                        if (z2) {
                            mVar6.f5845h.d(i48);
                        } else {
                            mVar6.f5846i.d(i48);
                        }
                        if (i49 < i17 && i49 < i3) {
                            i48 = z2 ? i48 - (-mVar6.f5846i.f5808f) : i48 + (-mVar6.f5846i.f5808f);
                        }
                    }
                }
            }
        }
    }

    @Override // q.m
    void d() {
        Iterator<m> it = this.f5792k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f5792k.size();
        if (size < 1) {
            return;
        }
        p.e eVar = this.f5792k.get(0).f5839b;
        p.e eVar2 = this.f5792k.get(size - 1).f5839b;
        if (this.f5843f == 0) {
            p.d dVar = eVar.B;
            p.d dVar2 = eVar2.D;
            f fVarI = i(dVar, 0);
            int iB = dVar.b();
            p.e eVarR = r();
            if (eVarR != null) {
                iB = eVarR.B.b();
            }
            if (fVarI != null) {
                b(this.f5845h, fVarI, iB);
            }
            f fVarI2 = i(dVar2, 0);
            int iB2 = dVar2.b();
            p.e eVarS = s();
            if (eVarS != null) {
                iB2 = eVarS.D.b();
            }
            if (fVarI2 != null) {
                b(this.f5846i, fVarI2, -iB2);
            }
        } else {
            p.d dVar3 = eVar.C;
            p.d dVar4 = eVar2.E;
            f fVarI3 = i(dVar3, 1);
            int iB3 = dVar3.b();
            p.e eVarR2 = r();
            if (eVarR2 != null) {
                iB3 = eVarR2.C.b();
            }
            if (fVarI3 != null) {
                b(this.f5845h, fVarI3, iB3);
            }
            f fVarI4 = i(dVar4, 1);
            int iB4 = dVar4.b();
            p.e eVarS2 = s();
            if (eVarS2 != null) {
                iB4 = eVarS2.E.b();
            }
            if (fVarI4 != null) {
                b(this.f5846i, fVarI4, -iB4);
            }
        }
        this.f5845h.f5803a = this;
        this.f5846i.f5803a = this;
    }

    @Override // q.m
    public void e() {
        for (int i3 = 0; i3 < this.f5792k.size(); i3++) {
            this.f5792k.get(i3).e();
        }
    }

    @Override // q.m
    void f() {
        this.f5840c = null;
        Iterator<m> it = this.f5792k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // q.m
    public long j() {
        int size = this.f5792k.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = this.f5792k.get(i3);
            j3 = j3 + ((long) mVar.f5845h.f5808f) + mVar.j() + ((long) mVar.f5846i.f5808f);
        }
        return j3;
    }

    @Override // q.m
    boolean m() {
        int size = this.f5792k.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!this.f5792k.get(i3).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f5843f == 0 ? "horizontal : " : "vertical : ");
        String string = sb.toString();
        Iterator<m> it = this.f5792k.iterator();
        while (it.hasNext()) {
            String str = string + "<";
            string = (str + it.next()) + "> ";
        }
        return string;
    }
}
