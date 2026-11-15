package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes.dex */
class c<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f2570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2572c;

    public c() {
        this.f2571b = 0;
        this.f2572c = 0;
    }

    public int E() {
        d dVar = this.f2570a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    protected void F(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        coordinatorLayout.I(v3, i3);
    }

    public boolean G(int i3) {
        d dVar = this.f2570a;
        if (dVar != null) {
            return dVar.e(i3);
        }
        this.f2571b = i3;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        F(coordinatorLayout, v3, i3);
        if (this.f2570a == null) {
            this.f2570a = new d(v3);
        }
        this.f2570a.c();
        this.f2570a.a();
        int i4 = this.f2571b;
        if (i4 != 0) {
            this.f2570a.e(i4);
            this.f2571b = 0;
        }
        int i5 = this.f2572c;
        if (i5 == 0) {
            return true;
        }
        this.f2570a.d(i5);
        this.f2572c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2571b = 0;
        this.f2572c = 0;
    }
}
