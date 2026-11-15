package r1;

import java.io.IOException;
import o1.p;
import o1.q;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: TreeTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class l<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q<T> f6118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o1.i<T> f6119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final o1.e f6120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v1.a<T> f6121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w f6122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l<T>.b f6123f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private v<T> f6124g;

    /* JADX INFO: compiled from: TreeTypeAdapter.java */
    private final class b implements p, o1.h {
        private b() {
        }
    }

    public l(q<T> qVar, o1.i<T> iVar, o1.e eVar, v1.a<T> aVar, w wVar) {
        this.f6118a = qVar;
        this.f6119b = iVar;
        this.f6120c = eVar;
        this.f6121d = aVar;
        this.f6122e = wVar;
    }

    private v<T> e() {
        v<T> vVar = this.f6124g;
        if (vVar != null) {
            return vVar;
        }
        v<T> vVarM = this.f6120c.m(this.f6122e, this.f6121d);
        this.f6124g = vVarM;
        return vVarM;
    }

    @Override // o1.v
    public T b(w1.a aVar) throws IOException {
        if (this.f6119b == null) {
            return e().b(aVar);
        }
        o1.j jVarA = q1.l.a(aVar);
        if (jVarA.e()) {
            return null;
        }
        return this.f6119b.a(jVarA, this.f6121d.e(), this.f6123f);
    }

    @Override // o1.v
    public void d(w1.c cVar, T t3) throws IOException {
        q<T> qVar = this.f6118a;
        if (qVar == null) {
            e().d(cVar, t3);
        } else if (t3 == null) {
            cVar.l();
        } else {
            q1.l.b(qVar.a(t3, this.f6121d.e(), this.f6123f), cVar);
        }
    }
}
