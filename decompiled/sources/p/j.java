package p;

/* JADX INFO: compiled from: Optimizer.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean[] f5591a = new boolean[3];

    static void a(f fVar, o.d dVar, e eVar) {
        eVar.f5545j = -1;
        eVar.f5547k = -1;
        e.b bVar = fVar.M[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.M[0] == e.b.MATCH_PARENT) {
            int i3 = eVar.B.f5512e;
            int iN = fVar.N() - eVar.D.f5512e;
            d dVar2 = eVar.B;
            dVar2.f5514g = dVar.q(dVar2);
            d dVar3 = eVar.D;
            dVar3.f5514g = dVar.q(dVar3);
            dVar.f(eVar.B.f5514g, i3);
            dVar.f(eVar.D.f5514g, iN);
            eVar.f5545j = 2;
            eVar.h0(i3, iN);
        }
        if (fVar.M[1] == bVar2 || eVar.M[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i4 = eVar.C.f5512e;
        int iT = fVar.t() - eVar.E.f5512e;
        d dVar4 = eVar.C;
        dVar4.f5514g = dVar.q(dVar4);
        d dVar5 = eVar.E;
        dVar5.f5514g = dVar.q(dVar5);
        dVar.f(eVar.C.f5514g, i4);
        dVar.f(eVar.E.f5514g, iT);
        if (eVar.Y > 0 || eVar.M() == 8) {
            d dVar6 = eVar.F;
            dVar6.f5514g = dVar.q(dVar6);
            dVar.f(eVar.F.f5514g, eVar.Y + i4);
        }
        eVar.f5547k = 2;
        eVar.w0(i4, iT);
    }

    public static final boolean b(int i3, int i4) {
        return (i3 & i4) == i4;
    }
}
