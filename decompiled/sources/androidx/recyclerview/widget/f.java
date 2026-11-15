package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: LayoutState.java */
/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2063e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f2066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f2067i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f2059a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2064f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f2065g = 0;

    f() {
    }

    boolean a(RecyclerView.a0 a0Var) {
        int i3 = this.f2061c;
        return i3 >= 0 && i3 < a0Var.b();
    }

    View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.f2061c);
        this.f2061c += this.f2062d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2060b + ", mCurrentPosition=" + this.f2061c + ", mItemDirection=" + this.f2062d + ", mLayoutDirection=" + this.f2063e + ", mStartLine=" + this.f2064f + ", mEndLine=" + this.f2065g + '}';
    }
}
