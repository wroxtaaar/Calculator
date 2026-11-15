package p;

import java.util.ArrayList;

/* JADX INFO: compiled from: Chain.java */
/* JADX INFO: loaded from: classes.dex */
class b {
    static void a(f fVar, o.d dVar, int i3) {
        int i4;
        int i5;
        c[] cVarArr;
        if (i3 == 0) {
            int i6 = fVar.G0;
            cVarArr = fVar.J0;
            i5 = i6;
            i4 = 0;
        } else {
            i4 = 2;
            i5 = fVar.H0;
            cVarArr = fVar.I0;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            c cVar = cVarArr[i7];
            cVar.a();
            b(fVar, dVar, i3, i4, cVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0173  */
    /* JADX WARN: Code duplicated, block: B:102:0x0194  */
    /* JADX WARN: Code duplicated, block: B:172:0x02df  */
    /* JADX WARN: Code duplicated, block: B:25:0x003e A[PHI: r14 r15
  0x003e: PHI (r14v3 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x003e: PHI (r15v3 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0040 A[PHI: r14 r15
  0x0040: PHI (r14v28 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x0040: PHI (r15v35 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x016a  */
    /* JADX WARN: Code duplicated, block: B:98:0x016d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [o.d] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [o.i] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [p.e] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    static void b(f fVar, o.d dVar, int i3, int i4, c cVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        Object obj;
        int i5;
        int i6;
        d dVar2;
        o.i iVar;
        o.i iVar2;
        d dVar3;
        o.i iVar3;
        o.i iVar4;
        ?? r5;
        o.i iVar5;
        int size;
        d dVar4;
        int i7;
        e eVar = cVar.f5486a;
        e eVar2 = cVar.f5488c;
        e eVar3 = cVar.f5487b;
        e eVar4 = cVar.f5489d;
        e eVar5 = cVar.f5490e;
        float f3 = cVar.f5496k;
        boolean z5 = fVar.M[i3] == e.b.WRAP_CONTENT;
        if (i3 == 0) {
            int i8 = eVar5.f5552m0;
            z2 = i8 == 0;
            z3 = i8 == 1;
            if (i8 == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            int i9 = eVar5.f5554n0;
            z2 = i9 == 0;
            z3 = i9 == 1;
            if (i9 == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        ?? r7 = eVar;
        boolean z6 = false;
        while (true) {
            obj = null;
            if (z6) {
                break;
            }
            d dVar5 = r7.J[i4];
            int i10 = z4 ? 1 : 4;
            int iB = dVar5.b();
            float f4 = f3;
            e.b bVar = r7.M[i3];
            boolean z7 = z6;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            boolean z8 = bVar == bVar2 && r7.f5553n[i3] == 0;
            d dVar6 = dVar5.f5511d;
            if (dVar6 != null && r7 != eVar) {
                iB += dVar6.b();
            }
            int i11 = iB;
            if (z4 && r7 != eVar && r7 != eVar3) {
                i10 = 5;
            }
            d dVar7 = dVar5.f5511d;
            if (dVar7 != null) {
                if (r7 == eVar3) {
                    dVar.h(dVar5.f5514g, dVar7.f5514g, i11, 6);
                } else {
                    dVar.h(dVar5.f5514g, dVar7.f5514g, i11, 8);
                }
                dVar.e(dVar5.f5514g, dVar5.f5511d.f5514g, i11, (!z8 || z4) ? i10 : 5);
            } else {
                eVar5 = eVar5;
                eVar = eVar;
            }
            if (z5) {
                if (r7.M() == 8 || r7.M[i3] != bVar2) {
                    i7 = 0;
                } else {
                    d[] dVarArr = r7.J;
                    i7 = 0;
                    dVar.h(dVarArr[i4 + 1].f5514g, dVarArr[i4].f5514g, 0, 5);
                }
                dVar.h(r7.J[i4].f5514g, fVar.J[i4].f5514g, i7, 8);
            }
            d dVar8 = r7.J[i4 + 1].f5511d;
            if (dVar8 != null) {
                e eVar6 = dVar8.f5509b;
                d[] dVarArr2 = eVar6.J;
                if (dVarArr2[i4].f5511d != null && dVarArr2[i4].f5511d.f5509b == r7) {
                    obj = eVar6;
                }
            }
            if (obj != null) {
                r7 = obj;
                z6 = z7;
            } else {
                z6 = true;
            }
            z2 = z2;
            f3 = f4;
            z3 = z3;
            eVar5 = eVar5;
            eVar = eVar;
            r7 = r7;
        }
        e eVar7 = eVar5;
        float f5 = f3;
        e eVar8 = eVar;
        boolean z9 = z2;
        boolean z10 = z3;
        if (eVar4 != null) {
            int i12 = i4 + 1;
            if (eVar2.J[i12].f5511d != null) {
                d dVar9 = eVar4.J[i12];
                if ((eVar4.M[i3] == e.b.MATCH_CONSTRAINT && eVar4.f5553n[i3] == 0) && !z4) {
                    d dVar10 = dVar9.f5511d;
                    if (dVar10.f5509b == fVar) {
                        dVar.e(dVar9.f5514g, dVar10.f5514g, -dVar9.b(), 5);
                    } else if (z4) {
                        dVar4 = dVar9.f5511d;
                        if (dVar4.f5509b == fVar) {
                            dVar.e(dVar9.f5514g, dVar4.f5514g, -dVar9.b(), 4);
                        }
                    }
                } else if (z4) {
                    dVar4 = dVar9.f5511d;
                    if (dVar4.f5509b == fVar) {
                        dVar.e(dVar9.f5514g, dVar4.f5514g, -dVar9.b(), 4);
                    }
                }
                dVar.j(dVar9.f5514g, eVar2.J[i12].f5511d.f5514g, -dVar9.b(), 6);
            }
        }
        if (z5) {
            int i13 = i4 + 1;
            o.i iVar6 = fVar.J[i13].f5514g;
            d[] dVarArr3 = eVar2.J;
            dVar.h(iVar6, dVarArr3[i13].f5514g, dVarArr3[i13].b(), 8);
        }
        ArrayList<e> arrayList = cVar.f5493h;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f6 = (!cVar.f5503r || cVar.f5505t) ? f5 : cVar.f5495j;
            float f7 = 0.0f;
            float f8 = 0.0f;
            e eVar9 = null;
            int i14 = 0;
            while (i14 < size) {
                e eVar10 = arrayList.get(i14);
                float f9 = eVar10.f5560q0[i3];
                if (f9 < f7) {
                    if (cVar.f5505t) {
                        d[] dVarArr4 = eVar10.J;
                        dVar.e(dVarArr4[i4 + 1].f5514g, dVarArr4[i4].f5514g, 0, 4);
                    } else {
                        f9 = 1.0f;
                    }
                    arrayList = arrayList;
                    i14++;
                    arrayList = arrayList;
                    f7 = 0.0f;
                }
                if (f9 == f7) {
                    d[] dVarArr5 = eVar10.J;
                    dVar.e(dVarArr5[i4 + 1].f5514g, dVarArr5[i4].f5514g, 0, 8);
                    arrayList = arrayList;
                } else {
                    if (eVar9 != null) {
                        d[] dVarArr6 = eVar9.J;
                        o.i iVar7 = dVarArr6[i4].f5514g;
                        int i15 = i4 + 1;
                        o.i iVar8 = dVarArr6[i15].f5514g;
                        d[] dVarArr7 = eVar10.J;
                        o.i iVar9 = dVarArr7[i4].f5514g;
                        o.i iVar10 = dVarArr7[i15].f5514g;
                        o.b bVarR = dVar.r();
                        bVarR.l(f8, f6, f9, iVar7, iVar8, iVar9, iVar10);
                        dVar.d(bVarR);
                    }
                    eVar9 = eVar10;
                    f8 = f9;
                }
                i14++;
                arrayList = arrayList;
                f7 = 0.0f;
            }
        }
        if (eVar3 != null && (eVar3 == eVar4 || z4)) {
            d dVar11 = eVar8.J[i4];
            int i16 = i4 + 1;
            d dVar12 = eVar2.J[i16];
            d dVar13 = dVar11.f5511d;
            o.i iVar11 = dVar13 != null ? dVar13.f5514g : null;
            d dVar14 = dVar12.f5511d;
            o.i iVar12 = dVar14 != null ? dVar14.f5514g : null;
            d dVar15 = eVar3.J[i4];
            d dVar16 = eVar4.J[i16];
            if (iVar11 != null && iVar12 != null) {
                dVar.c(dVar15.f5514g, iVar11, dVar15.b(), i3 == 0 ? eVar7.f5530b0 : eVar7.f5532c0, iVar12, dVar16.f5514g, dVar16.b(), 7);
            }
        } else if (!z9 || eVar3 == null) {
            int i17 = 8;
            if (z10 && eVar3 != null) {
                int i18 = cVar.f5495j;
                boolean z11 = i18 > 0 && cVar.f5494i == i18;
                e eVar11 = eVar3;
                e eVar12 = eVar11;
                while (eVar11 != null) {
                    e eVar13 = eVar11.f5564s0[i3];
                    while (eVar13 != null && eVar13.M() == i17) {
                        eVar13 = eVar13.f5564s0[i3];
                    }
                    if (eVar11 == eVar3 || eVar11 == eVar4 || eVar13 == null) {
                        eVar12 = eVar12;
                        i6 = i17;
                    } else {
                        e eVar14 = eVar13 == eVar4 ? null : eVar13;
                        d dVar17 = eVar11.J[i4];
                        o.i iVar13 = dVar17.f5514g;
                        d dVar18 = dVar17.f5511d;
                        if (dVar18 != null) {
                            o.i iVar14 = dVar18.f5514g;
                        }
                        int i19 = i4 + 1;
                        o.i iVar15 = eVar12.J[i19].f5514g;
                        int iB2 = dVar17.b();
                        int iB3 = eVar11.J[i19].b();
                        if (eVar14 != null) {
                            dVar2 = eVar14.J[i4];
                            iVar = dVar2.f5514g;
                            d dVar19 = dVar2.f5511d;
                            iVar2 = dVar19 != null ? dVar19.f5514g : null;
                        } else {
                            dVar2 = eVar4.J[i4];
                            iVar = dVar2 != null ? dVar2.f5514g : null;
                            iVar2 = eVar11.J[i19].f5514g;
                        }
                        if (dVar2 != null) {
                            iB3 += dVar2.b();
                        }
                        int i20 = iB3;
                        int iB4 = eVar12.J[i19].b() + iB2;
                        int i21 = z11 ? 8 : 4;
                        if (iVar13 == null || iVar15 == null || iVar == null || iVar2 == null) {
                            i6 = 8;
                        } else {
                            i6 = 8;
                            dVar.c(iVar13, iVar15, iB4, 0.5f, iVar, iVar2, i20, i21);
                        }
                        eVar13 = eVar14;
                    }
                    if (eVar11.M() == i6) {
                        eVar11 = eVar12;
                    }
                    i17 = i6;
                    eVar12 = eVar11;
                    eVar11 = eVar13;
                }
                d dVar20 = eVar3.J[i4];
                d dVar21 = eVar8.J[i4].f5511d;
                int i22 = i4 + 1;
                d dVar22 = eVar4.J[i22];
                d dVar23 = eVar2.J[i22].f5511d;
                if (dVar21 == null) {
                    i5 = 5;
                } else if (eVar3 != eVar4) {
                    i5 = 5;
                    dVar.e(dVar20.f5514g, dVar21.f5514g, dVar20.b(), 5);
                } else {
                    i5 = 5;
                    if (dVar23 != null) {
                        dVar.c(dVar20.f5514g, dVar21.f5514g, dVar20.b(), 0.5f, dVar22.f5514g, dVar23.f5514g, dVar22.b(), 5);
                    }
                }
                if (dVar23 != null && eVar3 != eVar4) {
                    dVar.e(dVar22.f5514g, dVar23.f5514g, -dVar22.b(), i5);
                }
            }
        } else {
            int i23 = cVar.f5495j;
            boolean z12 = i23 > 0 && cVar.f5494i == i23;
            e eVar15 = eVar3;
            e eVar16 = eVar15;
            while (eVar15 != null) {
                e eVar17 = eVar15.f5564s0[i3];
                while (eVar17 != null && eVar17.M() == 8) {
                    eVar17 = eVar17.f5564s0[i3];
                }
                if (eVar17 != null || eVar15 == eVar4) {
                    d dVar24 = eVar15.J[i4];
                    o.i iVar16 = dVar24.f5514g;
                    d dVar25 = dVar24.f5511d;
                    o.i iVar17 = dVar25 != null ? dVar25.f5514g : null;
                    if (eVar16 != eVar15) {
                        iVar17 = eVar16.J[i4 + 1].f5514g;
                    } else if (eVar15 == eVar3 && eVar16 == eVar15) {
                        d[] dVarArr8 = eVar8.J;
                        iVar17 = dVarArr8[i4].f5511d != null ? dVarArr8[i4].f5511d.f5514g : null;
                    }
                    int iB5 = dVar24.b();
                    int i24 = i4 + 1;
                    int iB6 = eVar15.J[i24].b();
                    if (eVar17 != null) {
                        dVar3 = eVar17.J[i4];
                        o.i iVar18 = dVar3.f5514g;
                        iVar4 = eVar15.J[i24].f5514g;
                        iVar3 = iVar18;
                    } else {
                        dVar3 = eVar2.J[i24].f5511d;
                        iVar3 = dVar3 != null ? dVar3.f5514g : null;
                        iVar4 = eVar15.J[i24].f5514g;
                    }
                    if (dVar3 != null) {
                        iB6 += dVar3.b();
                    }
                    if (eVar16 != null) {
                        iB5 += eVar16.J[i24].b();
                    }
                    if (iVar16 != null && iVar17 != null && iVar3 != null && iVar4 != null) {
                        if (eVar15 == eVar3) {
                            iB5 = eVar3.J[i4].b();
                        }
                        dVar.c(iVar16, iVar17, iB5, 0.5f, iVar3, iVar4, eVar15 == eVar4 ? eVar4.J[i24].b() : iB6, z12 ? 8 : 5);
                    }
                }
                if (eVar15.M() != 8) {
                    eVar16 = eVar15;
                }
                eVar15 = eVar17;
            }
        }
        if ((!z9 && !z10) || eVar3 == null || eVar3 == eVar4) {
            return;
        }
        d[] dVarArr9 = eVar3.J;
        d dVar26 = dVarArr9[i4];
        int i25 = i4 + 1;
        d dVar27 = eVar4.J[i25];
        d dVar28 = dVar26.f5511d;
        o.i iVar19 = dVar28 != null ? dVar28.f5514g : null;
        d dVar29 = dVar27.f5511d;
        if (dVar29 != null) {
            iVar5 = dVar29.f5514g;
        } else {
            r5 = 0;
        }
        if (eVar2 != eVar4) {
            d dVar30 = eVar2.J[i25].f5511d;
            if (dVar30 != null) {
                r5 = iVar5;
                obj = dVar30.f5514g;
            }
            r5 = iVar5;
            r5 = obj;
        }
        if (eVar3 == eVar4) {
            dVar26 = dVarArr9[i4];
            dVar27 = dVarArr9[i25];
        }
        if (iVar19 == null || r5 == 0) {
            return;
        }
        dVar.c(dVar26.f5514g, iVar19, dVar26.b(), 0.5f, r5, dVar27.f5514g, eVar4.J[i25].b(), 5);
    }
}
