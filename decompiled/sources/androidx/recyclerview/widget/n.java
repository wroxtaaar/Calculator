package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: compiled from: SnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f2088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f2089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView.t f2090c = new a();

    /* JADX INFO: compiled from: SnapHelper.java */
    class a extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2091a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i3) {
            super.a(recyclerView, i3);
            if (i3 == 0 && this.f2091a) {
                this.f2091a = false;
                n.this.k();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i3, int i4) {
            if (i3 == 0 && i4 == 0) {
                return;
            }
            this.f2091a = true;
        }
    }

    private void f() {
        this.f2088a.Z0(this.f2090c);
        this.f2088a.setOnFlingListener(null);
    }

    private void i() throws IllegalStateException {
        if (this.f2088a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f2088a.k(this.f2090c);
        this.f2088a.setOnFlingListener(this);
    }

    private boolean j(RecyclerView.o oVar, int i3, int i4) {
        RecyclerView.z zVarD;
        int iH;
        if (!(oVar instanceof RecyclerView.z.b) || (zVarD = d(oVar)) == null || (iH = h(oVar, i3, i4)) == -1) {
            return false;
        }
        zVarD.p(iH);
        oVar.J1(zVarD);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i3, int i4) {
        RecyclerView.o layoutManager = this.f2088a.getLayoutManager();
        if (layoutManager == null || this.f2088a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f2088a.getMinFlingVelocity();
        return (Math.abs(i4) > minFlingVelocity || Math.abs(i3) > minFlingVelocity) && j(layoutManager, i3, i4);
    }

    public void b(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f2088a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f2088a = recyclerView;
        if (recyclerView != null) {
            i();
            this.f2089b = new Scroller(this.f2088a.getContext(), new DecelerateInterpolator());
            k();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    protected RecyclerView.z d(RecyclerView.o oVar) {
        return e(oVar);
    }

    @Deprecated
    protected abstract g e(RecyclerView.o oVar);

    public abstract View g(RecyclerView.o oVar);

    public abstract int h(RecyclerView.o oVar, int i3, int i4);

    void k() {
        RecyclerView.o layoutManager;
        View viewG;
        RecyclerView recyclerView = this.f2088a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewG = g(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewG);
        if (iArrC[0] == 0 && iArrC[1] == 0) {
            return;
        }
        this.f2088a.m1(iArrC[0], iArrC[1]);
    }
}
