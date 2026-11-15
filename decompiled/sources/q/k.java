package q;

import java.util.ArrayList;

/* JADX INFO: compiled from: RunGroup.java */
/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f5827h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    m f5830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    m f5831d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f5834g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5828a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5829b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<m> f5832e = new ArrayList<>();

    public k(m mVar, int i3) {
        this.f5830c = null;
        this.f5831d = null;
        this.f5833f = 0;
        int i4 = f5827h;
        this.f5833f = i4;
        f5827h = i4 + 1;
        this.f5830c = mVar;
        this.f5831d = mVar;
        this.f5834g = i3;
    }

    private long c(f fVar, long j3) {
        m mVar = fVar.f5806d;
        if (mVar instanceof i) {
            return j3;
        }
        int size = fVar.f5813k.size();
        long jMin = j3;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = fVar.f5813k.get(i3);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f5806d != mVar) {
                    jMin = Math.min(jMin, c(fVar2, ((long) fVar2.f5808f) + j3));
                }
            }
        }
        if (fVar != mVar.f5846i) {
            return jMin;
        }
        long j4 = j3 - mVar.j();
        return Math.min(Math.min(jMin, c(mVar.f5845h, j4)), j4 - ((long) mVar.f5845h.f5808f));
    }

    private long d(f fVar, long j3) {
        m mVar = fVar.f5806d;
        if (mVar instanceof i) {
            return j3;
        }
        int size = fVar.f5813k.size();
        long jMax = j3;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = fVar.f5813k.get(i3);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f5806d != mVar) {
                    jMax = Math.max(jMax, d(fVar2, ((long) fVar2.f5808f) + j3));
                }
            }
        }
        if (fVar != mVar.f5845h) {
            return jMax;
        }
        long j4 = j3 + mVar.j();
        return Math.max(Math.max(jMax, d(mVar.f5846i, j4)), j4 - ((long) mVar.f5846i.f5808f));
    }

    public void a(m mVar) {
        this.f5832e.add(mVar);
        this.f5831d = mVar;
    }

    public long b(p.f fVar, int i3) {
        m mVar = this.f5830c;
        if (mVar instanceof c) {
            if (((c) mVar).f5843f != i3) {
                return 0L;
            }
        } else if (i3 == 0) {
            if (!(mVar instanceof j)) {
                return 0L;
            }
        } else if (!(mVar instanceof l)) {
            return 0L;
        }
        f fVar2 = (i3 == 0 ? fVar.f5535e : fVar.f5537f).f5845h;
        f fVar3 = (i3 == 0 ? fVar.f5535e : fVar.f5537f).f5846i;
        boolean zContains = mVar.f5845h.f5814l.contains(fVar2);
        boolean zContains2 = this.f5830c.f5846i.f5814l.contains(fVar3);
        long j3 = this.f5830c.j();
        if (!zContains || !zContains2) {
            if (zContains) {
                f fVar4 = this.f5830c.f5845h;
                return Math.max(d(fVar4, fVar4.f5808f), ((long) this.f5830c.f5845h.f5808f) + j3);
            }
            if (!zContains2) {
                m mVar2 = this.f5830c;
                return (((long) mVar2.f5845h.f5808f) + mVar2.j()) - ((long) this.f5830c.f5846i.f5808f);
            }
            f fVar5 = this.f5830c.f5846i;
            return Math.max(-c(fVar5, fVar5.f5808f), ((long) (-this.f5830c.f5846i.f5808f)) + j3);
        }
        long jD = d(this.f5830c.f5845h, 0L);
        long jC = c(this.f5830c.f5846i, 0L);
        long j4 = jD - j3;
        m mVar3 = this.f5830c;
        int i4 = mVar3.f5846i.f5808f;
        if (j4 >= (-i4)) {
            j4 += (long) i4;
        }
        int i5 = mVar3.f5845h.f5808f;
        long j5 = ((-jC) - j3) - ((long) i5);
        if (j5 >= i5) {
            j5 -= (long) i5;
        }
        float fM = mVar3.f5839b.m(i3);
        float f3 = fM > 0.0f ? (long) ((j5 / fM) + (j4 / (1.0f - fM))) : 0L;
        long j6 = ((long) ((f3 * fM) + 0.5f)) + j3 + ((long) ((f3 * (1.0f - fM)) + 0.5f));
        m mVar4 = this.f5830c;
        return (((long) mVar4.f5845h.f5808f) + j6) - ((long) mVar4.f5846i.f5808f);
    }
}
