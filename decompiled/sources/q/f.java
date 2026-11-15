package q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DependencyNode.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    m f5806d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5809g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f5803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5804b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5805c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    a f5807e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f5810h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    g f5811i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5812j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    List<d> f5813k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    List<f> f5814l = new ArrayList();

    /* JADX INFO: compiled from: DependencyNode.java */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(m mVar) {
        this.f5806d = mVar;
    }

    @Override // q.d
    public void a(d dVar) {
        Iterator<f> it = this.f5814l.iterator();
        while (it.hasNext()) {
            if (!it.next().f5812j) {
                return;
            }
        }
        this.f5805c = true;
        d dVar2 = this.f5803a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f5804b) {
            this.f5806d.a(this);
            return;
        }
        f fVar = null;
        int i3 = 0;
        for (f fVar2 : this.f5814l) {
            if (!(fVar2 instanceof g)) {
                i3++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i3 == 1 && fVar.f5812j) {
            g gVar = this.f5811i;
            if (gVar != null) {
                if (!gVar.f5812j) {
                    return;
                } else {
                    this.f5808f = this.f5810h * gVar.f5809g;
                }
            }
            d(fVar.f5809g + this.f5808f);
        }
        d dVar3 = this.f5803a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f5813k.add(dVar);
        if (this.f5812j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f5814l.clear();
        this.f5813k.clear();
        this.f5812j = false;
        this.f5809g = 0;
        this.f5805c = false;
        this.f5804b = false;
    }

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5806d.f5839b.p());
        sb.append(":");
        sb.append(this.f5807e);
        sb.append("(");
        sb.append(this.f5812j ? Integer.valueOf(this.f5809g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f5814l.size());
        sb.append(":d=");
        sb.append(this.f5813k.size());
        sb.append(">");
        return sb.toString();
    }
}
