package q;

/* JADX INFO: compiled from: DimensionDependency.java */
/* JADX INFO: loaded from: classes.dex */
class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5824m;

    public g(m mVar) {
        super(mVar);
        if (mVar instanceof j) {
            this.f5807e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f5807e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // q.f
    public void d(int i3) {
        if (this.f5812j) {
            return;
        }
        this.f5812j = true;
        this.f5809g = i3;
        for (d dVar : this.f5813k) {
            dVar.a(dVar);
        }
    }
}
