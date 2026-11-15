package q;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: DependencyGraph.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p.f f5794a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p.f f5797d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5795b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5796c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<m> f5798e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<k> f5799f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b.InterfaceC0082b f5800g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b.a f5801h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList<k> f5802i = new ArrayList<>();

    public e(p.f fVar) {
        this.f5794a = fVar;
        this.f5797d = fVar;
    }

    private void a(f fVar, int i3, int i4, f fVar2, ArrayList<k> arrayList, k kVar) {
        m mVar = fVar.f5806d;
        if (mVar.f5840c == null) {
            p.f fVar3 = this.f5794a;
            if (mVar == fVar3.f5535e || mVar == fVar3.f5537f) {
                return;
            }
            if (kVar == null) {
                kVar = new k(mVar, i4);
                arrayList.add(kVar);
            }
            mVar.f5840c = kVar;
            kVar.a(mVar);
            for (d dVar : mVar.f5845h.f5813k) {
                if (dVar instanceof f) {
                    a((f) dVar, i3, 0, fVar2, arrayList, kVar);
                }
            }
            for (d dVar2 : mVar.f5846i.f5813k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i3, 1, fVar2, arrayList, kVar);
                }
            }
            if (i3 == 1 && (mVar instanceof l)) {
                for (d dVar3 : ((l) mVar).f5835k.f5813k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i3, 2, fVar2, arrayList, kVar);
                    }
                }
            }
            for (f fVar4 : mVar.f5845h.f5814l) {
                if (fVar4 == fVar2) {
                    kVar.f5829b = true;
                }
                a(fVar4, i3, 0, fVar2, arrayList, kVar);
            }
            for (f fVar5 : mVar.f5846i.f5814l) {
                if (fVar5 == fVar2) {
                    kVar.f5829b = true;
                }
                a(fVar5, i3, 1, fVar2, arrayList, kVar);
            }
            if (i3 == 1 && (mVar instanceof l)) {
                Iterator<f> it = ((l) mVar).f5835k.f5814l.iterator();
                while (it.hasNext()) {
                    a(it.next(), i3, 2, fVar2, arrayList, kVar);
                }
            }
        }
    }

    private boolean b(p.f fVar) {
        int iN;
        p.e.b bVar;
        int iT;
        p.e.b bVar2;
        p.e.b bVar3;
        p.e.b bVar4;
        for (p.e eVar : fVar.f5594w0) {
            p.e.b[] bVarArr = eVar.M;
            p.e.b bVar5 = bVarArr[0];
            p.e.b bVar6 = bVarArr[1];
            if (eVar.M() == 8) {
                eVar.f5527a = true;
            } else {
                if (eVar.f5559q < 1.0f && bVar5 == p.e.b.MATCH_CONSTRAINT) {
                    eVar.f5549l = 2;
                }
                if (eVar.f5565t < 1.0f && bVar6 == p.e.b.MATCH_CONSTRAINT) {
                    eVar.f5551m = 2;
                }
                if (eVar.r() > 0.0f) {
                    p.e.b bVar7 = p.e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == p.e.b.WRAP_CONTENT || bVar6 == p.e.b.FIXED)) {
                        eVar.f5549l = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == p.e.b.WRAP_CONTENT || bVar5 == p.e.b.FIXED)) {
                        eVar.f5551m = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (eVar.f5549l == 0) {
                            eVar.f5549l = 3;
                        }
                        if (eVar.f5551m == 0) {
                            eVar.f5551m = 3;
                        }
                    }
                }
                p.e.b bVar8 = p.e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && eVar.f5549l == 1 && (eVar.B.f5511d == null || eVar.D.f5511d == null)) {
                    bVar5 = p.e.b.WRAP_CONTENT;
                }
                p.e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && eVar.f5551m == 1 && (eVar.C.f5511d == null || eVar.E.f5511d == null)) {
                    bVar6 = p.e.b.WRAP_CONTENT;
                }
                p.e.b bVar10 = bVar6;
                j jVar = eVar.f5535e;
                jVar.f5841d = bVar9;
                int i3 = eVar.f5549l;
                jVar.f5838a = i3;
                l lVar = eVar.f5537f;
                lVar.f5841d = bVar10;
                int i4 = eVar.f5551m;
                lVar.f5838a = i4;
                p.e.b bVar11 = p.e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == p.e.b.FIXED || bVar9 == p.e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == p.e.b.FIXED || bVar10 == p.e.b.WRAP_CONTENT)) {
                    int iN2 = eVar.N();
                    if (bVar9 == bVar11) {
                        iN = (fVar.N() - eVar.B.f5512e) - eVar.D.f5512e;
                        bVar = p.e.b.FIXED;
                    } else {
                        iN = iN2;
                        bVar = bVar9;
                    }
                    int iT2 = eVar.t();
                    if (bVar10 == bVar11) {
                        iT = (fVar.t() - eVar.C.f5512e) - eVar.E.f5512e;
                        bVar2 = p.e.b.FIXED;
                    } else {
                        iT = iT2;
                        bVar2 = bVar10;
                    }
                    l(eVar, bVar, iN, bVar2, iT);
                    eVar.f5535e.f5842e.d(eVar.N());
                    eVar.f5537f.f5842e.d(eVar.t());
                    eVar.f5527a = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = p.e.b.WRAP_CONTENT) || bVar10 == p.e.b.FIXED)) {
                        if (i3 == 3) {
                            if (bVar10 == bVar4) {
                                l(eVar, bVar4, 0, bVar4, 0);
                            }
                            int iT3 = eVar.t();
                            int i5 = (int) ((iT3 * eVar.Q) + 0.5f);
                            p.e.b bVar12 = p.e.b.FIXED;
                            l(eVar, bVar12, i5, bVar12, iT3);
                            eVar.f5535e.f5842e.d(eVar.N());
                            eVar.f5537f.f5842e.d(eVar.t());
                            eVar.f5527a = true;
                        } else if (i3 == 1) {
                            l(eVar, bVar4, 0, bVar10, 0);
                            eVar.f5535e.f5842e.f5824m = eVar.N();
                        } else if (i3 == 2) {
                            p.e.b[] bVarArr2 = fVar.M;
                            p.e.b bVar13 = bVarArr2[0];
                            p.e.b bVar14 = p.e.b.FIXED;
                            if (bVar13 == bVar14 || bVarArr2[0] == bVar11) {
                                l(eVar, bVar14, (int) ((eVar.f5559q * fVar.N()) + 0.5f), bVar10, eVar.t());
                                eVar.f5535e.f5842e.d(eVar.N());
                                eVar.f5537f.f5842e.d(eVar.t());
                                eVar.f5527a = true;
                            }
                        } else {
                            p.d[] dVarArr = eVar.J;
                            if (dVarArr[0].f5511d == null || dVarArr[1].f5511d == null) {
                                l(eVar, bVar4, 0, bVar10, 0);
                                eVar.f5535e.f5842e.d(eVar.N());
                                eVar.f5537f.f5842e.d(eVar.t());
                                eVar.f5527a = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = p.e.b.WRAP_CONTENT) || bVar9 == p.e.b.FIXED)) {
                        if (i4 == 3) {
                            if (bVar9 == bVar3) {
                                l(eVar, bVar3, 0, bVar3, 0);
                            }
                            int iN3 = eVar.N();
                            float f3 = eVar.Q;
                            if (eVar.s() == -1) {
                                f3 = 1.0f / f3;
                            }
                            p.e.b bVar15 = p.e.b.FIXED;
                            l(eVar, bVar15, iN3, bVar15, (int) ((iN3 * f3) + 0.5f));
                            eVar.f5535e.f5842e.d(eVar.N());
                            eVar.f5537f.f5842e.d(eVar.t());
                            eVar.f5527a = true;
                        } else if (i4 == 1) {
                            l(eVar, bVar9, 0, bVar3, 0);
                            eVar.f5537f.f5842e.f5824m = eVar.t();
                        } else if (i4 == 2) {
                            p.e.b[] bVarArr3 = fVar.M;
                            p.e.b bVar16 = bVarArr3[1];
                            p.e.b bVar17 = p.e.b.FIXED;
                            if (bVar16 == bVar17 || bVarArr3[1] == bVar11) {
                                l(eVar, bVar9, eVar.N(), bVar17, (int) ((eVar.f5565t * fVar.t()) + 0.5f));
                                eVar.f5535e.f5842e.d(eVar.N());
                                eVar.f5537f.f5842e.d(eVar.t());
                                eVar.f5527a = true;
                            }
                        } else {
                            p.d[] dVarArr2 = eVar.J;
                            if (dVarArr2[2].f5511d == null || dVarArr2[3].f5511d == null) {
                                l(eVar, bVar3, 0, bVar10, 0);
                                eVar.f5535e.f5842e.d(eVar.N());
                                eVar.f5537f.f5842e.d(eVar.t());
                                eVar.f5527a = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i3 == 1 || i4 == 1) {
                            p.e.b bVar18 = p.e.b.WRAP_CONTENT;
                            l(eVar, bVar18, 0, bVar18, 0);
                            eVar.f5535e.f5842e.f5824m = eVar.N();
                            eVar.f5537f.f5842e.f5824m = eVar.t();
                        } else if (i4 == 2 && i3 == 2) {
                            p.e.b[] bVarArr4 = fVar.M;
                            p.e.b bVar19 = bVarArr4[0];
                            p.e.b bVar20 = p.e.b.FIXED;
                            if (bVar19 == bVar20 || bVarArr4[0] == bVar20) {
                                if (bVarArr4[1] == bVar20 || bVarArr4[1] == bVar20) {
                                    l(eVar, bVar20, (int) ((eVar.f5559q * fVar.N()) + 0.5f), bVar20, (int) ((eVar.f5565t * fVar.t()) + 0.5f));
                                    eVar.f5535e.f5842e.d(eVar.N());
                                    eVar.f5537f.f5842e.d(eVar.t());
                                    eVar.f5527a = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(p.f fVar, int i3) {
        int size = this.f5802i.size();
        long jMax = 0;
        for (int i4 = 0; i4 < size; i4++) {
            jMax = Math.max(jMax, this.f5802i.get(i4).b(fVar, i3));
        }
        return (int) jMax;
    }

    private void i(m mVar, int i3, ArrayList<k> arrayList) {
        for (d dVar : mVar.f5845h.f5813k) {
            if (dVar instanceof f) {
                a((f) dVar, i3, 0, mVar.f5846i, arrayList, null);
            } else if (dVar instanceof m) {
                a(((m) dVar).f5845h, i3, 0, mVar.f5846i, arrayList, null);
            }
        }
        for (d dVar2 : mVar.f5846i.f5813k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i3, 1, mVar.f5845h, arrayList, null);
            } else if (dVar2 instanceof m) {
                a(((m) dVar2).f5846i, i3, 1, mVar.f5845h, arrayList, null);
            }
        }
        if (i3 == 1) {
            for (d dVar3 : ((l) mVar).f5835k.f5813k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i3, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(p.e eVar, p.e.b bVar, int i3, p.e.b bVar2, int i4) {
        b.a aVar = this.f5801h;
        aVar.f5782a = bVar;
        aVar.f5783b = bVar2;
        aVar.f5784c = i3;
        aVar.f5785d = i4;
        this.f5800g.b(eVar, aVar);
        eVar.B0(this.f5801h.f5786e);
        eVar.e0(this.f5801h.f5787f);
        eVar.d0(this.f5801h.f5789h);
        eVar.Y(this.f5801h.f5788g);
    }

    public void c() {
        d(this.f5798e);
        this.f5802i.clear();
        k.f5827h = 0;
        i(this.f5794a.f5535e, 0, this.f5802i);
        i(this.f5794a.f5537f, 1, this.f5802i);
        this.f5795b = false;
    }

    public void d(ArrayList<m> arrayList) {
        arrayList.clear();
        this.f5797d.f5535e.f();
        this.f5797d.f5537f.f();
        arrayList.add(this.f5797d.f5535e);
        arrayList.add(this.f5797d.f5537f);
        HashSet hashSet = null;
        for (p.e eVar : this.f5797d.f5594w0) {
            if (eVar instanceof p.g) {
                arrayList.add(new h(eVar));
            } else {
                if (eVar.T()) {
                    if (eVar.f5531c == null) {
                        eVar.f5531c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f5531c);
                } else {
                    arrayList.add(eVar.f5535e);
                }
                if (eVar.V()) {
                    if (eVar.f5533d == null) {
                        eVar.f5533d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f5533d);
                } else {
                    arrayList.add(eVar.f5537f);
                }
                if (eVar instanceof p.i) {
                    arrayList.add(new i(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        for (m mVar : arrayList) {
            if (mVar.f5839b != this.f5797d) {
                mVar.d();
            }
        }
    }

    public boolean f(boolean z2) {
        boolean z3;
        boolean z4 = true;
        boolean z5 = z2 & true;
        if (this.f5795b || this.f5796c) {
            for (p.e eVar : this.f5794a.f5594w0) {
                eVar.f5527a = false;
                eVar.f5535e.r();
                eVar.f5537f.q();
            }
            p.f fVar = this.f5794a;
            fVar.f5527a = false;
            fVar.f5535e.r();
            this.f5794a.f5537f.q();
            this.f5796c = false;
        }
        if (b(this.f5797d)) {
            return false;
        }
        this.f5794a.C0(0);
        this.f5794a.D0(0);
        p.e.b bVarQ = this.f5794a.q(0);
        p.e.b bVarQ2 = this.f5794a.q(1);
        if (this.f5795b) {
            c();
        }
        int iO = this.f5794a.O();
        int iP = this.f5794a.P();
        this.f5794a.f5535e.f5845h.d(iO);
        this.f5794a.f5537f.f5845h.d(iP);
        m();
        p.e.b bVar = p.e.b.WRAP_CONTENT;
        if (bVarQ == bVar || bVarQ2 == bVar) {
            if (z5) {
                Iterator<m> it = this.f5798e.iterator();
                while (it.hasNext()) {
                    if (!it.next().m()) {
                        z5 = false;
                        break;
                    }
                }
            }
            if (z5 && bVarQ == p.e.b.WRAP_CONTENT) {
                this.f5794a.i0(p.e.b.FIXED);
                p.f fVar2 = this.f5794a;
                fVar2.B0(e(fVar2, 0));
                p.f fVar3 = this.f5794a;
                fVar3.f5535e.f5842e.d(fVar3.N());
            }
            if (z5 && bVarQ2 == p.e.b.WRAP_CONTENT) {
                this.f5794a.x0(p.e.b.FIXED);
                p.f fVar4 = this.f5794a;
                fVar4.e0(e(fVar4, 1));
                p.f fVar5 = this.f5794a;
                fVar5.f5537f.f5842e.d(fVar5.t());
            }
        }
        p.f fVar6 = this.f5794a;
        p.e.b[] bVarArr = fVar6.M;
        p.e.b bVar2 = bVarArr[0];
        p.e.b bVar3 = p.e.b.FIXED;
        if (bVar2 == bVar3 || bVarArr[0] == p.e.b.MATCH_PARENT) {
            int iN = fVar6.N() + iO;
            this.f5794a.f5535e.f5846i.d(iN);
            this.f5794a.f5535e.f5842e.d(iN - iO);
            m();
            p.f fVar7 = this.f5794a;
            p.e.b[] bVarArr2 = fVar7.M;
            if (bVarArr2[1] == bVar3 || bVarArr2[1] == p.e.b.MATCH_PARENT) {
                int iT = fVar7.t() + iP;
                this.f5794a.f5537f.f5846i.d(iT);
                this.f5794a.f5537f.f5842e.d(iT - iP);
            }
            m();
            z3 = true;
        } else {
            z3 = false;
        }
        for (m mVar : this.f5798e) {
            if (mVar.f5839b != this.f5794a || mVar.f5844g) {
                mVar.e();
            }
        }
        for (m mVar2 : this.f5798e) {
            if (z3 || mVar2.f5839b != this.f5794a) {
                if (!mVar2.f5845h.f5812j || ((!mVar2.f5846i.f5812j && !(mVar2 instanceof h)) || (!mVar2.f5842e.f5812j && !(mVar2 instanceof c) && !(mVar2 instanceof h)))) {
                    z4 = false;
                    break;
                }
            }
        }
        this.f5794a.i0(bVarQ);
        this.f5794a.x0(bVarQ2);
        return z4;
    }

    public boolean g(boolean z2) {
        if (this.f5795b) {
            for (p.e eVar : this.f5794a.f5594w0) {
                eVar.f5527a = false;
                j jVar = eVar.f5535e;
                jVar.f5842e.f5812j = false;
                jVar.f5844g = false;
                jVar.r();
                l lVar = eVar.f5537f;
                lVar.f5842e.f5812j = false;
                lVar.f5844g = false;
                lVar.q();
            }
            p.f fVar = this.f5794a;
            fVar.f5527a = false;
            j jVar2 = fVar.f5535e;
            jVar2.f5842e.f5812j = false;
            jVar2.f5844g = false;
            jVar2.r();
            l lVar2 = this.f5794a.f5537f;
            lVar2.f5842e.f5812j = false;
            lVar2.f5844g = false;
            lVar2.q();
            c();
        }
        if (b(this.f5797d)) {
            return false;
        }
        this.f5794a.C0(0);
        this.f5794a.D0(0);
        this.f5794a.f5535e.f5845h.d(0);
        this.f5794a.f5537f.f5845h.d(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c5  */
    public boolean h(boolean z2, int i3) {
        boolean z3;
        p.e.b bVar;
        boolean z4 = true;
        boolean z5 = z2 & true;
        p.e.b bVarQ = this.f5794a.q(0);
        p.e.b bVarQ2 = this.f5794a.q(1);
        int iO = this.f5794a.O();
        int iP = this.f5794a.P();
        if (z5 && (bVarQ == (bVar = p.e.b.WRAP_CONTENT) || bVarQ2 == bVar)) {
            for (m mVar : this.f5798e) {
                if (mVar.f5843f == i3 && !mVar.m()) {
                    z5 = false;
                    break;
                }
            }
            if (i3 == 0) {
                if (z5 && bVarQ == p.e.b.WRAP_CONTENT) {
                    this.f5794a.i0(p.e.b.FIXED);
                    p.f fVar = this.f5794a;
                    fVar.B0(e(fVar, 0));
                    p.f fVar2 = this.f5794a;
                    fVar2.f5535e.f5842e.d(fVar2.N());
                }
            } else if (z5 && bVarQ2 == p.e.b.WRAP_CONTENT) {
                this.f5794a.x0(p.e.b.FIXED);
                p.f fVar3 = this.f5794a;
                fVar3.e0(e(fVar3, 1));
                p.f fVar4 = this.f5794a;
                fVar4.f5537f.f5842e.d(fVar4.t());
            }
        }
        if (i3 == 0) {
            p.f fVar5 = this.f5794a;
            p.e.b[] bVarArr = fVar5.M;
            if (bVarArr[0] == p.e.b.FIXED || bVarArr[0] == p.e.b.MATCH_PARENT) {
                int iN = fVar5.N() + iO;
                this.f5794a.f5535e.f5846i.d(iN);
                this.f5794a.f5535e.f5842e.d(iN - iO);
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            p.f fVar6 = this.f5794a;
            p.e.b[] bVarArr2 = fVar6.M;
            if (bVarArr2[1] == p.e.b.FIXED || bVarArr2[1] == p.e.b.MATCH_PARENT) {
                int iT = fVar6.t() + iP;
                this.f5794a.f5537f.f5846i.d(iT);
                this.f5794a.f5537f.f5842e.d(iT - iP);
                z3 = true;
            } else {
                z3 = false;
            }
        }
        m();
        for (m mVar2 : this.f5798e) {
            if (mVar2.f5843f == i3 && (mVar2.f5839b != this.f5794a || mVar2.f5844g)) {
                mVar2.e();
            }
        }
        for (m mVar3 : this.f5798e) {
            if (mVar3.f5843f == i3 && (z3 || mVar3.f5839b != this.f5794a)) {
                if (!mVar3.f5845h.f5812j || !mVar3.f5846i.f5812j || (!(mVar3 instanceof c) && !mVar3.f5842e.f5812j)) {
                    z4 = false;
                    break;
                }
            }
        }
        this.f5794a.i0(bVarQ);
        this.f5794a.x0(bVarQ2);
        return z4;
    }

    public void j() {
        this.f5795b = true;
    }

    public void k() {
        this.f5796c = true;
    }

    public void m() {
        g gVar;
        for (p.e eVar : this.f5794a.f5594w0) {
            if (!eVar.f5527a) {
                p.e.b[] bVarArr = eVar.M;
                boolean z2 = false;
                p.e.b bVar = bVarArr[0];
                p.e.b bVar2 = bVarArr[1];
                int i3 = eVar.f5549l;
                int i4 = eVar.f5551m;
                p.e.b bVar3 = p.e.b.WRAP_CONTENT;
                boolean z3 = bVar == bVar3 || (bVar == p.e.b.MATCH_CONSTRAINT && i3 == 1);
                if (bVar2 == bVar3 || (bVar2 == p.e.b.MATCH_CONSTRAINT && i4 == 1)) {
                    z2 = true;
                }
                g gVar2 = eVar.f5535e.f5842e;
                boolean z4 = gVar2.f5812j;
                g gVar3 = eVar.f5537f.f5842e;
                boolean z5 = gVar3.f5812j;
                if (z4 && z5) {
                    p.e.b bVar4 = p.e.b.FIXED;
                    l(eVar, bVar4, gVar2.f5809g, bVar4, gVar3.f5809g);
                    eVar.f5527a = true;
                } else if (z4 && z2) {
                    l(eVar, p.e.b.FIXED, gVar2.f5809g, bVar3, gVar3.f5809g);
                    if (bVar2 == p.e.b.MATCH_CONSTRAINT) {
                        eVar.f5537f.f5842e.f5824m = eVar.t();
                    } else {
                        eVar.f5537f.f5842e.d(eVar.t());
                        eVar.f5527a = true;
                    }
                } else if (z5 && z3) {
                    l(eVar, bVar3, gVar2.f5809g, p.e.b.FIXED, gVar3.f5809g);
                    if (bVar == p.e.b.MATCH_CONSTRAINT) {
                        eVar.f5535e.f5842e.f5824m = eVar.N();
                    } else {
                        eVar.f5535e.f5842e.d(eVar.N());
                        eVar.f5527a = true;
                    }
                }
                if (eVar.f5527a && (gVar = eVar.f5537f.f5836l) != null) {
                    gVar.d(eVar.l());
                }
            }
        }
    }

    public void n(b.InterfaceC0082b interfaceC0082b) {
        this.f5800g = interfaceC0082b;
    }
}
