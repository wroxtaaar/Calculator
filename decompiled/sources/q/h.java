package q;

/* JADX INFO: compiled from: GuidelineReference.java */
/* JADX INFO: loaded from: classes.dex */
class h extends m {
    public h(p.e eVar) {
        super(eVar);
        eVar.f5535e.f();
        eVar.f5537f.f();
        this.f5843f = ((p.g) eVar).H0();
    }

    private void q(f fVar) {
        this.f5845h.f5813k.add(fVar);
        fVar.f5814l.add(this.f5845h);
    }

    @Override // q.m, q.d
    public void a(d dVar) {
        f fVar = this.f5845h;
        if (fVar.f5805c && !fVar.f5812j) {
            this.f5845h.d((int) ((fVar.f5814l.get(0).f5809g * ((p.g) this.f5839b).K0()) + 0.5f));
        }
    }

    @Override // q.m
    void d() {
        p.g gVar = (p.g) this.f5839b;
        int iI0 = gVar.I0();
        int iJ0 = gVar.J0();
        gVar.K0();
        if (gVar.H0() == 1) {
            if (iI0 != -1) {
                this.f5845h.f5814l.add(this.f5839b.N.f5535e.f5845h);
                this.f5839b.N.f5535e.f5845h.f5813k.add(this.f5845h);
                this.f5845h.f5808f = iI0;
            } else if (iJ0 != -1) {
                this.f5845h.f5814l.add(this.f5839b.N.f5535e.f5846i);
                this.f5839b.N.f5535e.f5846i.f5813k.add(this.f5845h);
                this.f5845h.f5808f = -iJ0;
            } else {
                f fVar = this.f5845h;
                fVar.f5804b = true;
                fVar.f5814l.add(this.f5839b.N.f5535e.f5846i);
                this.f5839b.N.f5535e.f5846i.f5813k.add(this.f5845h);
            }
            q(this.f5839b.f5535e.f5845h);
            q(this.f5839b.f5535e.f5846i);
            return;
        }
        if (iI0 != -1) {
            this.f5845h.f5814l.add(this.f5839b.N.f5537f.f5845h);
            this.f5839b.N.f5537f.f5845h.f5813k.add(this.f5845h);
            this.f5845h.f5808f = iI0;
        } else if (iJ0 != -1) {
            this.f5845h.f5814l.add(this.f5839b.N.f5537f.f5846i);
            this.f5839b.N.f5537f.f5846i.f5813k.add(this.f5845h);
            this.f5845h.f5808f = -iJ0;
        } else {
            f fVar2 = this.f5845h;
            fVar2.f5804b = true;
            fVar2.f5814l.add(this.f5839b.N.f5537f.f5846i);
            this.f5839b.N.f5537f.f5846i.f5813k.add(this.f5845h);
        }
        q(this.f5839b.f5537f.f5845h);
        q(this.f5839b.f5537f.f5846i);
    }

    @Override // q.m
    public void e() {
        if (((p.g) this.f5839b).H0() == 1) {
            this.f5839b.C0(this.f5845h.f5809g);
        } else {
            this.f5839b.D0(this.f5845h.f5809g);
        }
    }

    @Override // q.m
    void f() {
        this.f5845h.c();
    }

    @Override // q.m
    boolean m() {
        return false;
    }
}
