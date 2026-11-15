package q;

import java.util.Iterator;

/* JADX INFO: compiled from: HelperReferences.java */
/* JADX INFO: loaded from: classes.dex */
class i extends m {
    public i(p.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f5845h.f5813k.add(fVar);
        fVar.f5814l.add(this.f5845h);
    }

    @Override // q.m, q.d
    public void a(d dVar) {
        p.a aVar = (p.a) this.f5839b;
        int iI0 = aVar.I0();
        Iterator<f> it = this.f5845h.f5814l.iterator();
        int i3 = 0;
        int i4 = -1;
        while (it.hasNext()) {
            int i5 = it.next().f5809g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (iI0 == 0 || iI0 == 2) {
            this.f5845h.d(i4 + aVar.J0());
        } else {
            this.f5845h.d(i3 + aVar.J0());
        }
    }

    @Override // q.m
    void d() {
        p.e eVar = this.f5839b;
        if (eVar instanceof p.a) {
            this.f5845h.f5804b = true;
            p.a aVar = (p.a) eVar;
            int iI0 = aVar.I0();
            boolean zH0 = aVar.H0();
            int i3 = 0;
            if (iI0 == 0) {
                this.f5845h.f5807e = f.a.LEFT;
                while (i3 < aVar.f5590x0) {
                    p.e eVar2 = aVar.f5589w0[i3];
                    if (zH0 || eVar2.M() != 8) {
                        f fVar = eVar2.f5535e.f5845h;
                        fVar.f5813k.add(this.f5845h);
                        this.f5845h.f5814l.add(fVar);
                    }
                    i3++;
                }
                q(this.f5839b.f5535e.f5845h);
                q(this.f5839b.f5535e.f5846i);
                return;
            }
            if (iI0 == 1) {
                this.f5845h.f5807e = f.a.RIGHT;
                while (i3 < aVar.f5590x0) {
                    p.e eVar3 = aVar.f5589w0[i3];
                    if (zH0 || eVar3.M() != 8) {
                        f fVar2 = eVar3.f5535e.f5846i;
                        fVar2.f5813k.add(this.f5845h);
                        this.f5845h.f5814l.add(fVar2);
                    }
                    i3++;
                }
                q(this.f5839b.f5535e.f5845h);
                q(this.f5839b.f5535e.f5846i);
                return;
            }
            if (iI0 == 2) {
                this.f5845h.f5807e = f.a.TOP;
                while (i3 < aVar.f5590x0) {
                    p.e eVar4 = aVar.f5589w0[i3];
                    if (zH0 || eVar4.M() != 8) {
                        f fVar3 = eVar4.f5537f.f5845h;
                        fVar3.f5813k.add(this.f5845h);
                        this.f5845h.f5814l.add(fVar3);
                    }
                    i3++;
                }
                q(this.f5839b.f5537f.f5845h);
                q(this.f5839b.f5537f.f5846i);
                return;
            }
            if (iI0 != 3) {
                return;
            }
            this.f5845h.f5807e = f.a.BOTTOM;
            while (i3 < aVar.f5590x0) {
                p.e eVar5 = aVar.f5589w0[i3];
                if (zH0 || eVar5.M() != 8) {
                    f fVar4 = eVar5.f5537f.f5846i;
                    fVar4.f5813k.add(this.f5845h);
                    this.f5845h.f5814l.add(fVar4);
                }
                i3++;
            }
            q(this.f5839b.f5537f.f5845h);
            q(this.f5839b.f5537f.f5846i);
        }
    }

    @Override // q.m
    public void e() {
        p.e eVar = this.f5839b;
        if (eVar instanceof p.a) {
            int iI0 = ((p.a) eVar).I0();
            if (iI0 == 0 || iI0 == 1) {
                this.f5839b.C0(this.f5845h.f5809g);
            } else {
                this.f5839b.D0(this.f5845h.f5809g);
            }
        }
    }

    @Override // q.m
    void f() {
        this.f5840c = null;
        this.f5845h.c();
    }

    @Override // q.m
    boolean m() {
        return false;
    }
}
