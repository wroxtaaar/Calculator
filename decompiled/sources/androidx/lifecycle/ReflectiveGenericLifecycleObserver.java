package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a.C0009a f1539b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1538a = obj;
        this.f1539b = a.f1544c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        this.f1539b.a(gVar, aVar, this.f1538a);
    }
}
