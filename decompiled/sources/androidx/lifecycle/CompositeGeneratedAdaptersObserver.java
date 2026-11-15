package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c[] f1516a;

    CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f1516a = cVarArr;
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        k kVar = new k();
        for (c cVar : this.f1516a) {
            cVar.a(gVar, aVar, false, kVar);
        }
        for (c cVar2 : this.f1516a) {
            cVar2.a(gVar, aVar, true, kVar);
        }
    }
}
