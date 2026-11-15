package com.vos.swipemenu;

import android.view.View;
import android.widget.OverScroller;

/* JADX INFO: compiled from: SwipeHorizontal.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected View f4367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected C0051a f4368c = new C0051a();

    /* JADX INFO: renamed from: com.vos.swipemenu.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SwipeHorizontal.java */
    public static final class C0051a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4371c;
    }

    public a(int i3, View view) {
        this.f4366a = i3;
        this.f4367b = view;
    }

    public abstract void a(OverScroller overScroller, int i3, int i4);

    public abstract void b(OverScroller overScroller, int i3, int i4);

    public abstract C0051a c(int i3, int i4);

    public int d() {
        return this.f4366a;
    }

    public View e() {
        return this.f4367b;
    }

    public int f() {
        return this.f4367b.getWidth();
    }

    public abstract boolean g(int i3, float f3);

    public abstract void h(float f3, float f4, float f5);

    public abstract void i();
}
