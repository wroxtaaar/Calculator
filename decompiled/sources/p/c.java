package p;

import java.util.ArrayList;

/* JADX INFO: compiled from: ChainHead.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f5486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e f5487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f5488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f5489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f5490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected e f5491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected e f5492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected ArrayList<e> f5493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f5494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f5495j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f5496k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f5497l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f5498m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f5499n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f5500o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f5501p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f5502q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f5503r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f5504s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f5505t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f5506u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f5507v;

    public c(e eVar, int i3, boolean z2) {
        this.f5502q = false;
        this.f5486a = eVar;
        this.f5501p = i3;
        this.f5502q = z2;
    }

    private void b() {
        int i3 = this.f5501p * 2;
        e eVar = this.f5486a;
        this.f5500o = true;
        e eVar2 = eVar;
        boolean z2 = false;
        while (!z2) {
            this.f5494i++;
            e[] eVarArr = eVar.f5564s0;
            int i4 = this.f5501p;
            e eVar3 = null;
            eVarArr[i4] = null;
            eVar.f5562r0[i4] = null;
            if (eVar.M() != 8) {
                this.f5497l++;
                e.b bVarQ = eVar.q(this.f5501p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarQ != bVar) {
                    this.f5498m += eVar.y(this.f5501p);
                }
                int iB = this.f5498m + eVar.J[i3].b();
                this.f5498m = iB;
                int i5 = i3 + 1;
                this.f5498m = iB + eVar.J[i5].b();
                int iB2 = this.f5499n + eVar.J[i3].b();
                this.f5499n = iB2;
                this.f5499n = iB2 + eVar.J[i5].b();
                if (this.f5487b == null) {
                    this.f5487b = eVar;
                }
                this.f5489d = eVar;
                e.b[] bVarArr = eVar.M;
                int i6 = this.f5501p;
                if (bVarArr[i6] == bVar) {
                    int[] iArr = eVar.f5553n;
                    if (iArr[i6] == 0 || iArr[i6] == 3 || iArr[i6] == 2) {
                        this.f5495j++;
                        float[] fArr = eVar.f5560q0;
                        float f3 = fArr[i6];
                        if (f3 > 0.0f) {
                            this.f5496k += fArr[i6];
                        }
                        if (c(eVar, i6)) {
                            if (f3 < 0.0f) {
                                this.f5503r = true;
                            } else {
                                this.f5504s = true;
                            }
                            if (this.f5493h == null) {
                                this.f5493h = new ArrayList<>();
                            }
                            this.f5493h.add(eVar);
                        }
                        if (this.f5491f == null) {
                            this.f5491f = eVar;
                        }
                        e eVar4 = this.f5492g;
                        if (eVar4 != null) {
                            eVar4.f5562r0[this.f5501p] = eVar;
                        }
                        this.f5492g = eVar;
                    }
                    if (this.f5501p == 0) {
                        if (eVar.f5549l != 0 || eVar.f5555o != 0 || eVar.f5557p != 0) {
                            this.f5500o = false;
                        }
                    } else if (eVar.f5551m != 0 || eVar.f5561r != 0 || eVar.f5563s != 0) {
                        this.f5500o = false;
                    }
                    if (eVar.Q != 0.0f) {
                        this.f5500o = false;
                        this.f5506u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f5564s0[this.f5501p] = eVar;
            }
            d dVar = eVar.J[i3 + 1].f5511d;
            if (dVar != null) {
                e eVar5 = dVar.f5509b;
                d[] dVarArr = eVar5.J;
                if (dVarArr[i3].f5511d != null && dVarArr[i3].f5511d.f5509b == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z2 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f5487b;
        if (eVar6 != null) {
            this.f5498m -= eVar6.J[i3].b();
        }
        e eVar7 = this.f5489d;
        if (eVar7 != null) {
            this.f5498m -= eVar7.J[i3 + 1].b();
        }
        this.f5488c = eVar;
        if (this.f5501p == 0 && this.f5502q) {
            this.f5490e = eVar;
        } else {
            this.f5490e = this.f5486a;
        }
        this.f5505t = this.f5504s && this.f5503r;
    }

    private static boolean c(e eVar, int i3) {
        if (eVar.M() != 8 && eVar.M[i3] == e.b.MATCH_CONSTRAINT) {
            int[] iArr = eVar.f5553n;
            if (iArr[i3] == 0 || iArr[i3] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.f5507v) {
            b();
        }
        this.f5507v = true;
    }
}
