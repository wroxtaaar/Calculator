package y2;

/* JADX INFO: compiled from: OptCodeGen.java */
/* JADX INFO: loaded from: classes.dex */
class s extends u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    l f6555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f6556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    e[] f6557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    double[] f6558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    double[] f6559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    m[] f6560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    byte[] f6561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    c f6562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f6563o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f6564p;

    s(x xVar) {
        super(xVar);
        l lVar = new l();
        this.f6555g = lVar;
        this.f6557i = lVar.f6522b;
        this.f6558j = new double[1];
        this.f6559k = new double[1];
        this.f6560l = new m[1];
        this.f6561m = new byte[1];
        this.f6562n = new c(0, this.f6561m, this.f6558j, this.f6559k, this.f6560l);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0087  */
    /* JADX WARN: Code duplicated, block: B:34:0x008d  */
    /* JADX WARN: Code duplicated, block: B:35:0x008f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0097  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ed  */
    @Override // y2.u, y2.z
    void a(y yVar) throws x {
        byte b3;
        int i3;
        int iA;
        byte b4;
        int iA2;
        int i4;
        boolean z2 = this.f6564p;
        this.f6564p = false;
        byte b5 = 1;
        switch (yVar.f6594c) {
            case 9:
                this.f6558j[0] = yVar.f6596e;
                this.f6559k[0] = 0.0d;
                b3 = 1;
                i3 = this.f6556h;
                this.f6561m[0] = b3;
                if (b3 != 8) {
                    c cVar = this.f6562n;
                    l lVar = this.f6555g;
                    if (z2) {
                        i4 = -1;
                    } else {
                        i4 = -2;
                    }
                    this.f6556h = cVar.x(lVar, i3, i4);
                } else {
                    e[] eVarArr = this.f6557i;
                    int i5 = i3 + 1;
                    this.f6556h = i5;
                    eVarArr[i5].f6500a = Double.NaN;
                    eVarArr[i5].f6501b = 0.0d;
                }
                if (this.f6557i[this.f6556h].v() || b3 == 1) {
                    if (b3 == 2) {
                        iA = this.f6560l[0].a();
                    } else {
                        iA = a0.f6480b[b3];
                    }
                    while (iA > 0) {
                        b4 = this.f6570a.b();
                        if (b4 == 1) {
                            this.f6571b.d();
                        } else {
                            if (b4 == 2) {
                                iA2 = this.f6572c.b().a() - 1;
                            } else {
                                iA2 = a0.f6480b[b4];
                            }
                            iA += iA2;
                        }
                        iA--;
                    }
                    k kVar = this.f6571b;
                    e[] eVarArr2 = this.f6557i;
                    int i6 = this.f6556h;
                    kVar.e(eVarArr2[i6].f6500a, eVarArr2[i6].f6501b);
                } else {
                    if (b3 == 2) {
                        this.f6572c.c(this.f6560l[0]);
                    }
                    b5 = b3;
                }
                this.f6570a.c(b5);
                return;
            case 10:
            case 11:
                v vVarD = d(yVar);
                if (!yVar.a()) {
                    b3 = vVarD.f6577c;
                    if (b3 <= 0) {
                        m mVar = vVarD.f6578d;
                        if (mVar != null) {
                            this.f6560l[0] = mVar;
                        } else {
                            this.f6558j[0] = vVarD.f6579e;
                            this.f6559k[0] = vVarD.f6580f;
                            b3 = 1;
                        }
                    } else if (b3 >= 38 && b3 <= 42) {
                        int i7 = (b3 - 38) + 1;
                        if (i7 > this.f6563o) {
                            this.f6563o = i7;
                        }
                        e[] eVarArr3 = this.f6557i;
                        int i8 = this.f6556h + 1;
                        this.f6556h = i8;
                        eVarArr3[i8].f6500a = Double.NaN;
                        eVarArr3[i8].f6501b = 0.0d;
                        this.f6570a.c(b3);
                        return;
                    }
                    i3 = this.f6556h;
                    this.f6561m[0] = b3;
                    if (b3 != 8) {
                        c cVar2 = this.f6562n;
                        l lVar2 = this.f6555g;
                        if (z2) {
                            i4 = -1;
                        } else {
                            i4 = -2;
                        }
                        this.f6556h = cVar2.x(lVar2, i3, i4);
                    } else {
                        e[] eVarArr4 = this.f6557i;
                        int i9 = i3 + 1;
                        this.f6556h = i9;
                        eVarArr4[i9].f6500a = Double.NaN;
                        eVarArr4[i9].f6501b = 0.0d;
                    }
                    if (this.f6557i[this.f6556h].v()) {
                        if (b3 == 2) {
                            iA = this.f6560l[0].a();
                        } else {
                            iA = a0.f6480b[b3];
                        }
                        while (iA > 0) {
                            b4 = this.f6570a.b();
                            if (b4 == 1) {
                                this.f6571b.d();
                            } else {
                                if (b4 == 2) {
                                    iA2 = this.f6572c.b().a() - 1;
                                } else {
                                    iA2 = a0.f6480b[b4];
                                }
                                iA += iA2;
                            }
                            iA--;
                        }
                        k kVar2 = this.f6571b;
                        e[] eVarArr5 = this.f6557i;
                        int i10 = this.f6556h;
                        kVar2.e(eVarArr5[i10].f6500a, eVarArr5[i10].f6501b);
                    } else {
                        if (b3 == 2) {
                            iA = this.f6560l[0].a();
                        } else {
                            iA = a0.f6480b[b3];
                        }
                        while (iA > 0) {
                            b4 = this.f6570a.b();
                            if (b4 == 1) {
                                this.f6571b.d();
                            } else {
                                if (b4 == 2) {
                                    iA2 = this.f6572c.b().a() - 1;
                                } else {
                                    iA2 = a0.f6480b[b4];
                                }
                                iA += iA2;
                            }
                            iA--;
                        }
                        k kVar3 = this.f6571b;
                        e[] eVarArr6 = this.f6557i;
                        int i11 = this.f6556h;
                        kVar3.e(eVarArr6[i11].f6500a, eVarArr6[i11].f6501b);
                    }
                    this.f6570a.c(b5);
                    return;
                }
                this.f6560l[0] = vVarD.f6578d.k();
                b3 = 2;
                i3 = this.f6556h;
                this.f6561m[0] = b3;
                if (b3 != 8) {
                    c cVar3 = this.f6562n;
                    l lVar3 = this.f6555g;
                    if (z2) {
                        i4 = -1;
                    } else {
                        i4 = -2;
                    }
                    this.f6556h = cVar3.x(lVar3, i3, i4);
                } else {
                    e[] eVarArr7 = this.f6557i;
                    int i12 = i3 + 1;
                    this.f6556h = i12;
                    eVarArr7[i12].f6500a = Double.NaN;
                    eVarArr7[i12].f6501b = 0.0d;
                }
                if (this.f6557i[this.f6556h].v()) {
                    if (b3 == 2) {
                        iA = this.f6560l[0].a();
                    } else {
                        iA = a0.f6480b[b3];
                    }
                    while (iA > 0) {
                        b4 = this.f6570a.b();
                        if (b4 == 1) {
                            this.f6571b.d();
                        } else {
                            if (b4 == 2) {
                                iA2 = this.f6572c.b().a() - 1;
                            } else {
                                iA2 = a0.f6480b[b4];
                            }
                            iA += iA2;
                        }
                        iA--;
                    }
                    k kVar4 = this.f6571b;
                    e[] eVarArr8 = this.f6557i;
                    int i13 = this.f6556h;
                    kVar4.e(eVarArr8[i13].f6500a, eVarArr8[i13].f6501b);
                } else {
                    if (b3 == 2) {
                        iA = this.f6560l[0].a();
                    } else {
                        iA = a0.f6480b[b3];
                    }
                    while (iA > 0) {
                        b4 = this.f6570a.b();
                        if (b4 == 1) {
                            this.f6571b.d();
                        } else {
                            if (b4 == 2) {
                                iA2 = this.f6572c.b().a() - 1;
                            } else {
                                iA2 = a0.f6480b[b4];
                            }
                            iA += iA2;
                        }
                        iA--;
                    }
                    k kVar5 = this.f6571b;
                    e[] eVarArr9 = this.f6557i;
                    int i14 = this.f6556h;
                    kVar5.e(eVarArr9[i14].f6500a, eVarArr9[i14].f6501b);
                }
                this.f6570a.c(b5);
                return;
            default:
                b3 = yVar.f6595d;
                if (b3 <= 0) {
                    throw new Error("wrong vmop: " + ((int) b3));
                }
                if (b3 == 12) {
                    this.f6564p = true;
                }
                i3 = this.f6556h;
                this.f6561m[0] = b3;
                if (b3 != 8) {
                    c cVar4 = this.f6562n;
                    l lVar4 = this.f6555g;
                    if (z2) {
                        i4 = -1;
                    } else {
                        i4 = -2;
                    }
                    this.f6556h = cVar4.x(lVar4, i3, i4);
                } else {
                    e[] eVarArr10 = this.f6557i;
                    int i15 = i3 + 1;
                    this.f6556h = i15;
                    eVarArr10[i15].f6500a = Double.NaN;
                    eVarArr10[i15].f6501b = 0.0d;
                }
                if (this.f6557i[this.f6556h].v()) {
                    if (b3 == 2) {
                        iA = this.f6560l[0].a();
                    } else {
                        iA = a0.f6480b[b3];
                    }
                    while (iA > 0) {
                        b4 = this.f6570a.b();
                        if (b4 == 1) {
                            this.f6571b.d();
                        } else {
                            if (b4 == 2) {
                                iA2 = this.f6572c.b().a() - 1;
                            } else {
                                iA2 = a0.f6480b[b4];
                            }
                            iA += iA2;
                        }
                        iA--;
                    }
                    k kVar6 = this.f6571b;
                    e[] eVarArr11 = this.f6557i;
                    int i16 = this.f6556h;
                    kVar6.e(eVarArr11[i16].f6500a, eVarArr11[i16].f6501b);
                } else {
                    if (b3 == 2) {
                        iA = this.f6560l[0].a();
                    } else {
                        iA = a0.f6480b[b3];
                    }
                    while (iA > 0) {
                        b4 = this.f6570a.b();
                        if (b4 == 1) {
                            this.f6571b.d();
                        } else {
                            if (b4 == 2) {
                                iA2 = this.f6572c.b().a() - 1;
                            } else {
                                iA2 = a0.f6480b[b4];
                            }
                            iA += iA2;
                        }
                        iA--;
                    }
                    k kVar7 = this.f6571b;
                    e[] eVarArr12 = this.f6557i;
                    int i17 = this.f6556h;
                    kVar7.e(eVarArr12[i17].f6500a, eVarArr12[i17].f6501b);
                }
                this.f6570a.c(b5);
                return;
        }
    }

    @Override // y2.u, y2.z
    void b() {
        super.b();
        this.f6556h = -1;
        this.f6563o = 0;
        this.f6564p = false;
    }

    c f(int i3) {
        return new c(i3, this.f6570a.d(), this.f6571b.c(), this.f6571b.b(), this.f6572c.d());
    }
}
