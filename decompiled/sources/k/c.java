package k;

import android.content.res.ColorStateList;

/* JADX INFO: compiled from: CardViewApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class c implements f {
    c() {
    }

    private g n(e eVar) {
        return (g) eVar.d();
    }

    @Override // k.f
    public void a(e eVar) {
        f(eVar, e(eVar));
    }

    @Override // k.f
    public void b(e eVar) {
        f(eVar, e(eVar));
    }

    @Override // k.f
    public float c(e eVar) {
        return d(eVar) * 2.0f;
    }

    @Override // k.f
    public float d(e eVar) {
        return n(eVar).d();
    }

    @Override // k.f
    public float e(e eVar) {
        return n(eVar).c();
    }

    @Override // k.f
    public void f(e eVar, float f3) {
        n(eVar).g(f3, eVar.c(), eVar.f());
        o(eVar);
    }

    @Override // k.f
    public void g(e eVar, ColorStateList colorStateList) {
        n(eVar).f(colorStateList);
    }

    @Override // k.f
    public void h(e eVar, float f3) {
        n(eVar).h(f3);
    }

    @Override // k.f
    public float i(e eVar) {
        return d(eVar) * 2.0f;
    }

    @Override // k.f
    public ColorStateList j(e eVar) {
        return n(eVar).b();
    }

    @Override // k.f
    public void k() {
    }

    @Override // k.f
    public void l(e eVar, float f3) {
        eVar.b().setElevation(f3);
    }

    @Override // k.f
    public float m(e eVar) {
        return eVar.b().getElevation();
    }

    public void o(e eVar) {
        if (!eVar.c()) {
            eVar.a(0, 0, 0, 0);
            return;
        }
        float fE = e(eVar);
        float fD = d(eVar);
        int iCeil = (int) Math.ceil(h.c(fE, fD, eVar.f()));
        int iCeil2 = (int) Math.ceil(h.d(fE, fD, eVar.f()));
        eVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }
}
