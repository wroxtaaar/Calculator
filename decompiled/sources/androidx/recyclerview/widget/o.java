package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: ViewBoundsCheck.java */
/* JADX INFO: loaded from: classes.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f2093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f2094b = new a();

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2095a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2098d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2099e;

        a() {
        }

        void a(int i3) {
            this.f2095a = i3 | this.f2095a;
        }

        boolean b() {
            int i3 = this.f2095a;
            if ((i3 & 7) != 0 && (i3 & (c(this.f2098d, this.f2096b) << 0)) == 0) {
                return false;
            }
            int i4 = this.f2095a;
            if ((i4 & 112) != 0 && (i4 & (c(this.f2098d, this.f2097c) << 4)) == 0) {
                return false;
            }
            int i5 = this.f2095a;
            if ((i5 & 1792) != 0 && (i5 & (c(this.f2099e, this.f2096b) << 8)) == 0) {
                return false;
            }
            int i6 = this.f2095a;
            return (i6 & 28672) == 0 || ((c(this.f2099e, this.f2097c) << 12) & i6) != 0;
        }

        int c(int i3, int i4) {
            if (i3 > i4) {
                return 1;
            }
            return i3 == i4 ? 2 : 4;
        }

        void d() {
            this.f2095a = 0;
        }

        void e(int i3, int i4, int i5, int i6) {
            this.f2096b = i3;
            this.f2097c = i4;
            this.f2098d = i5;
            this.f2099e = i6;
        }
    }

    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    interface b {
        View a(int i3);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    o(b bVar) {
        this.f2093a = bVar;
    }

    View a(int i3, int i4, int i5, int i6) {
        int iC = this.f2093a.c();
        int iB = this.f2093a.b();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        while (i3 != i4) {
            View viewA = this.f2093a.a(i3);
            this.f2094b.e(iC, iB, this.f2093a.e(viewA), this.f2093a.d(viewA));
            if (i5 != 0) {
                this.f2094b.d();
                this.f2094b.a(i5);
                if (this.f2094b.b()) {
                    return viewA;
                }
            }
            if (i6 != 0) {
                this.f2094b.d();
                this.f2094b.a(i6);
                if (this.f2094b.b()) {
                    view = viewA;
                }
            }
            i3 += i7;
        }
        return view;
    }

    boolean b(View view, int i3) {
        this.f2094b.e(this.f2093a.c(), this.f2093a.b(), this.f2093a.e(view), this.f2093a.d(view));
        if (i3 == 0) {
            return false;
        }
        this.f2094b.d();
        this.f2094b.a(i3);
        return this.f2094b.b();
    }
}
