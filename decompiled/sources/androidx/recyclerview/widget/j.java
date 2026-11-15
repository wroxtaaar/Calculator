package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: PagerSnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i f2080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f2081e;

    /* JADX INFO: compiled from: PagerSnapHelper.java */
    class a extends g {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g, androidx.recyclerview.widget.RecyclerView.z
        protected void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            j jVar = j.this;
            int[] iArrC = jVar.c(jVar.f2088a.getLayoutManager(), view);
            int i3 = iArrC[0];
            int i4 = iArrC[1];
            int iW = w(Math.max(Math.abs(i3), Math.abs(i4)));
            if (iW > 0) {
                aVar.d(i3, i4, iW, this.f2069j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.g
        protected int x(int i3) {
            return Math.min(100, super.x(i3));
        }
    }

    private int l(RecyclerView.o oVar, View view, i iVar) {
        return (iVar.g(view) + (iVar.e(view) / 2)) - (iVar.m() + (iVar.n() / 2));
    }

    private View m(RecyclerView.o oVar, i iVar) {
        int iJ = oVar.J();
        View view = null;
        if (iJ == 0) {
            return null;
        }
        int iM = iVar.m() + (iVar.n() / 2);
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < iJ; i4++) {
            View viewI = oVar.I(i4);
            int iAbs = Math.abs((iVar.g(viewI) + (iVar.e(viewI) / 2)) - iM);
            if (iAbs < i3) {
                view = viewI;
                i3 = iAbs;
            }
        }
        return view;
    }

    private i n(RecyclerView.o oVar) {
        i iVar = this.f2081e;
        if (iVar == null || iVar.f2077a != oVar) {
            this.f2081e = i.a(oVar);
        }
        return this.f2081e;
    }

    private i o(RecyclerView.o oVar) {
        if (oVar.l()) {
            return p(oVar);
        }
        if (oVar.k()) {
            return n(oVar);
        }
        return null;
    }

    private i p(RecyclerView.o oVar) {
        i iVar = this.f2080d;
        if (iVar == null || iVar.f2077a != oVar) {
            this.f2080d = i.c(oVar);
        }
        return this.f2080d;
    }

    private boolean q(RecyclerView.o oVar, int i3, int i4) {
        if (oVar.k()) {
            return i3 > 0;
        }
        return i4 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean r(RecyclerView.o oVar) {
        PointF pointFA;
        int iY = oVar.Y();
        if (!(oVar instanceof RecyclerView.z.b) || (pointFA = ((RecyclerView.z.b) oVar).a(iY - 1)) == null) {
            return false;
        }
        return pointFA.x < 0.0f || pointFA.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.k()) {
            iArr[0] = l(oVar, view, n(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.l()) {
            iArr[1] = l(oVar, view, p(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.n
    protected g e(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new a(this.f2088a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.n
    public View g(RecyclerView.o oVar) {
        if (oVar.l()) {
            return m(oVar, p(oVar));
        }
        if (oVar.k()) {
            return m(oVar, n(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.n
    public int h(RecyclerView.o oVar, int i3, int i4) {
        i iVarO;
        int iY = oVar.Y();
        if (iY == 0 || (iVarO = o(oVar)) == null) {
            return -1;
        }
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        int iJ = oVar.J();
        View view = null;
        View view2 = null;
        for (int i7 = 0; i7 < iJ; i7++) {
            View viewI = oVar.I(i7);
            if (viewI != null) {
                int iL = l(oVar, viewI, iVarO);
                if (iL <= 0 && iL > i5) {
                    view2 = viewI;
                    i5 = iL;
                }
                if (iL >= 0 && iL < i6) {
                    view = viewI;
                    i6 = iL;
                }
            }
        }
        boolean zQ = q(oVar, i3, i4);
        if (zQ && view != null) {
            return oVar.h0(view);
        }
        if (!zQ && view2 != null) {
            return oVar.h0(view2);
        }
        if (zQ) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iH0 = oVar.h0(view) + (r(oVar) == zQ ? -1 : 1);
        if (iH0 < 0 || iH0 >= iY) {
            return -1;
        }
        return iH0;
    }
}
