package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: ScrollbarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class l {
    static int a(RecyclerView.a0 a0Var, i iVar, View view, View view2, RecyclerView.o oVar, boolean z2) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1;
        }
        return Math.min(iVar.n(), iVar.d(view2) - iVar.g(view));
    }

    static int b(RecyclerView.a0 a0Var, i iVar, View view, View view2, RecyclerView.o oVar, boolean z2, boolean z3) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z3 ? Math.max(0, (a0Var.b() - Math.max(oVar.h0(view), oVar.h0(view2))) - 1) : Math.max(0, Math.min(oVar.h0(view), oVar.h0(view2)));
        if (z2) {
            return Math.round((iMax * (Math.abs(iVar.d(view2) - iVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1))) + (iVar.m() - iVar.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.a0 a0Var, i iVar, View view, View view2, RecyclerView.o oVar, boolean z2) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return a0Var.b();
        }
        return (int) (((iVar.d(view2) - iVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1)) * a0Var.b());
    }
}
