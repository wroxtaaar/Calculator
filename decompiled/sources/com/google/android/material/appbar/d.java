package com.google.android.material.appbar;

import android.view.View;
import e0.t;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f2573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2578f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2579g = true;

    public d(View view) {
        this.f2573a = view;
    }

    void a() {
        View view = this.f2573a;
        t.Y(view, this.f2576d - (view.getTop() - this.f2574b));
        View view2 = this.f2573a;
        t.X(view2, this.f2577e - (view2.getLeft() - this.f2575c));
    }

    public int b() {
        return this.f2576d;
    }

    void c() {
        this.f2574b = this.f2573a.getTop();
        this.f2575c = this.f2573a.getLeft();
    }

    public boolean d(int i3) {
        if (!this.f2579g || this.f2577e == i3) {
            return false;
        }
        this.f2577e = i3;
        a();
        return true;
    }

    public boolean e(int i3) {
        if (!this.f2578f || this.f2576d == i3) {
            return false;
        }
        this.f2576d = i3;
        a();
        return true;
    }
}
