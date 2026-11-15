package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: SimpleItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends RecyclerView.l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f2087g = true;

    public final void A(RecyclerView.d0 d0Var) {
        I(d0Var);
        h(d0Var);
    }

    public final void B(RecyclerView.d0 d0Var) {
        J(d0Var);
    }

    public final void C(RecyclerView.d0 d0Var, boolean z2) {
        K(d0Var, z2);
        h(d0Var);
    }

    public final void D(RecyclerView.d0 d0Var, boolean z2) {
        L(d0Var, z2);
    }

    public final void E(RecyclerView.d0 d0Var) {
        M(d0Var);
        h(d0Var);
    }

    public final void F(RecyclerView.d0 d0Var) {
        N(d0Var);
    }

    public final void G(RecyclerView.d0 d0Var) {
        O(d0Var);
        h(d0Var);
    }

    public final void H(RecyclerView.d0 d0Var) {
        P(d0Var);
    }

    public void I(RecyclerView.d0 d0Var) {
    }

    public void J(RecyclerView.d0 d0Var) {
    }

    public void K(RecyclerView.d0 d0Var, boolean z2) {
    }

    public void L(RecyclerView.d0 d0Var, boolean z2) {
    }

    public void M(RecyclerView.d0 d0Var) {
    }

    public void N(RecyclerView.d0 d0Var) {
    }

    public void O(RecyclerView.d0 d0Var) {
    }

    public void P(RecyclerView.d0 d0Var) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i3;
        int i4;
        return (cVar == null || ((i3 = cVar.f1841a) == (i4 = cVar2.f1841a) && cVar.f1842b == cVar2.f1842b)) ? w(d0Var) : y(d0Var, i3, cVar.f1842b, i4, cVar2.f1842b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i3;
        int i4;
        int i5 = cVar.f1841a;
        int i6 = cVar.f1842b;
        if (d0Var2.J()) {
            int i7 = cVar.f1841a;
            i4 = cVar.f1842b;
            i3 = i7;
        } else {
            i3 = cVar2.f1841a;
            i4 = cVar2.f1842b;
        }
        return x(d0Var, d0Var2, i5, i6, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i3 = cVar.f1841a;
        int i4 = cVar.f1842b;
        View view = d0Var.f1813a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1841a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1842b;
        if (d0Var.v() || (i3 == left && i4 == top)) {
            return z(d0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return y(d0Var, i3, i4, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i3 = cVar.f1841a;
        int i4 = cVar2.f1841a;
        if (i3 != i4 || cVar.f1842b != cVar2.f1842b) {
            return y(d0Var, i3, cVar.f1842b, i4, cVar2.f1842b);
        }
        E(d0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.d0 d0Var) {
        return !this.f2087g || d0Var.t();
    }

    public abstract boolean w(RecyclerView.d0 d0Var);

    public abstract boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i3, int i4, int i5, int i6);

    public abstract boolean y(RecyclerView.d0 d0Var, int i3, int i4, int i5, int i6);

    public abstract boolean z(RecyclerView.d0 d0Var);
}
