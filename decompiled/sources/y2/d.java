package y2;

/* JADX INFO: compiled from: Compiler.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f6493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f6494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t f6495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f6496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f6497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u f6498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h f6499g;

    d() {
        x xVar = new x();
        this.f6493a = xVar;
        this.f6494b = new q(xVar);
        this.f6495c = new t(xVar);
        this.f6496d = new i(xVar);
        this.f6497e = new s(xVar);
        this.f6498f = new u(xVar);
        this.f6499g = new h();
    }

    m a(w wVar, String str) throws x {
        m fVar;
        this.f6499g.a(str, this.f6494b, this.f6496d);
        h hVar = this.f6499g;
        if (hVar.f6509c == -2) {
            try {
                fVar = new f(b(wVar, hVar.f6510d).j());
            } catch (x e3) {
                if (e3 != u.f6569f) {
                    throw e3;
                }
                fVar = null;
            }
        } else {
            fVar = null;
        }
        if (fVar == null) {
            wVar.j();
            wVar.b(this.f6499g.f6508b);
            try {
                this.f6495c.e(this.f6497e.e(wVar));
                this.f6494b.c(this.f6499g.f6510d, this.f6495c);
                wVar.i();
                int i3 = this.f6499g.f6509c;
                if (i3 == -2) {
                    i3 = this.f6497e.f6563o;
                }
                fVar = this.f6497e.f(i3);
            } catch (Throwable th) {
                wVar.i();
                throw th;
            }
        }
        fVar.f6529b = str;
        return fVar;
    }

    m b(w wVar, String str) throws x {
        this.f6495c.e(this.f6498f.e(wVar));
        this.f6494b.c(str, this.f6495c);
        return this.f6498f.c();
    }

    n c(w wVar, String str) throws x {
        return new n(a(wVar, str), this.f6499g.f6507a);
    }
}
