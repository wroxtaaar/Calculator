package androidx.fragment.app;

/* JADX INFO: compiled from: FragmentViewLifecycleOwner.java */
/* JADX INFO: loaded from: classes.dex */
class w implements androidx.lifecycle.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.lifecycle.h f1515b = null;

    w() {
    }

    void a(androidx.lifecycle.d.a aVar) {
        this.f1515b.i(aVar);
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d b() {
        e();
        return this.f1515b;
    }

    void e() {
        if (this.f1515b == null) {
            this.f1515b = new androidx.lifecycle.h(this);
        }
    }

    boolean f() {
        return this.f1515b != null;
    }

    void g(androidx.lifecycle.d.b bVar) {
        this.f1515b.p(bVar);
    }
}
