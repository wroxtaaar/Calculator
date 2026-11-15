package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.o f2077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Rect f2079c;

    /* JADX INFO: compiled from: OrientationHelper.java */
    static class a extends i {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.i
        public int d(View view) {
            return this.f2077a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2077a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2077a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int g(View view) {
            return this.f2077a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int h() {
            return this.f2077a.o0();
        }

        @Override // androidx.recyclerview.widget.i
        public int i() {
            return this.f2077a.o0() - this.f2077a.f0();
        }

        @Override // androidx.recyclerview.widget.i
        public int j() {
            return this.f2077a.f0();
        }

        @Override // androidx.recyclerview.widget.i
        public int k() {
            return this.f2077a.p0();
        }

        @Override // androidx.recyclerview.widget.i
        public int l() {
            return this.f2077a.X();
        }

        @Override // androidx.recyclerview.widget.i
        public int m() {
            return this.f2077a.e0();
        }

        @Override // androidx.recyclerview.widget.i
        public int n() {
            return (this.f2077a.o0() - this.f2077a.e0()) - this.f2077a.f0();
        }

        @Override // androidx.recyclerview.widget.i
        public int p(View view) {
            this.f2077a.n0(view, true, this.f2079c);
            return this.f2079c.right;
        }

        @Override // androidx.recyclerview.widget.i
        public int q(View view) {
            this.f2077a.n0(view, true, this.f2079c);
            return this.f2079c.left;
        }

        @Override // androidx.recyclerview.widget.i
        public void r(int i3) {
            this.f2077a.C0(i3);
        }
    }

    /* JADX INFO: compiled from: OrientationHelper.java */
    static class b extends i {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.i
        public int d(View view) {
            return this.f2077a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2077a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2077a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int g(View view) {
            return this.f2077a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int h() {
            return this.f2077a.W();
        }

        @Override // androidx.recyclerview.widget.i
        public int i() {
            return this.f2077a.W() - this.f2077a.d0();
        }

        @Override // androidx.recyclerview.widget.i
        public int j() {
            return this.f2077a.d0();
        }

        @Override // androidx.recyclerview.widget.i
        public int k() {
            return this.f2077a.X();
        }

        @Override // androidx.recyclerview.widget.i
        public int l() {
            return this.f2077a.p0();
        }

        @Override // androidx.recyclerview.widget.i
        public int m() {
            return this.f2077a.g0();
        }

        @Override // androidx.recyclerview.widget.i
        public int n() {
            return (this.f2077a.W() - this.f2077a.g0()) - this.f2077a.d0();
        }

        @Override // androidx.recyclerview.widget.i
        public int p(View view) {
            this.f2077a.n0(view, true, this.f2079c);
            return this.f2079c.bottom;
        }

        @Override // androidx.recyclerview.widget.i
        public int q(View view) {
            this.f2077a.n0(view, true, this.f2079c);
            return this.f2079c.top;
        }

        @Override // androidx.recyclerview.widget.i
        public void r(int i3) {
            this.f2077a.D0(i3);
        }
    }

    /* synthetic */ i(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static i a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static i b(RecyclerView.o oVar, int i3) {
        if (i3 == 0) {
            return a(oVar);
        }
        if (i3 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static i c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f2078b) {
            return 0;
        }
        return n() - this.f2078b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i3);

    public void s() {
        this.f2078b = n();
    }

    private i(RecyclerView.o oVar) {
        this.f2078b = Integer.MIN_VALUE;
        this.f2079c = new Rect();
        this.f2077a = oVar;
    }
}
