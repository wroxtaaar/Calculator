package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InterfaceC0019b f1957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f1958b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<View> f1959c = new ArrayList();

    /* JADX INFO: compiled from: ChildHelper.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f1960a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f1961b;

        a() {
        }

        private void c() {
            if (this.f1961b == null) {
                this.f1961b = new a();
            }
        }

        void a(int i3) {
            if (i3 < 64) {
                this.f1960a &= ~(1 << i3);
                return;
            }
            a aVar = this.f1961b;
            if (aVar != null) {
                aVar.a(i3 - 64);
            }
        }

        int b(int i3) {
            a aVar = this.f1961b;
            if (aVar == null) {
                if (i3 >= 64) {
                    return Long.bitCount(this.f1960a);
                }
                return Long.bitCount(((1 << i3) - 1) & this.f1960a);
            }
            if (i3 >= 64) {
                return aVar.b(i3 - 64) + Long.bitCount(this.f1960a);
            }
            return Long.bitCount(((1 << i3) - 1) & this.f1960a);
        }

        boolean d(int i3) {
            if (i3 < 64) {
                return ((1 << i3) & this.f1960a) != 0;
            }
            c();
            return this.f1961b.d(i3 - 64);
        }

        void e(int i3, boolean z2) {
            if (i3 >= 64) {
                c();
                this.f1961b.e(i3 - 64, z2);
                return;
            }
            long j3 = this.f1960a;
            boolean z3 = (Long.MIN_VALUE & j3) != 0;
            long j4 = (1 << i3) - 1;
            this.f1960a = ((j3 & (~j4)) << 1) | (j3 & j4);
            if (z2) {
                h(i3);
            } else {
                a(i3);
            }
            if (z3 || this.f1961b != null) {
                c();
                this.f1961b.e(0, z3);
            }
        }

        boolean f(int i3) {
            if (i3 >= 64) {
                c();
                return this.f1961b.f(i3 - 64);
            }
            long j3 = 1 << i3;
            long j4 = this.f1960a;
            boolean z2 = (j4 & j3) != 0;
            long j5 = j4 & (~j3);
            this.f1960a = j5;
            long j6 = j3 - 1;
            this.f1960a = (j5 & j6) | Long.rotateRight((~j6) & j5, 1);
            a aVar = this.f1961b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1961b.f(0);
            }
            return z2;
        }

        void g() {
            this.f1960a = 0L;
            a aVar = this.f1961b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i3) {
            if (i3 < 64) {
                this.f1960a |= 1 << i3;
            } else {
                c();
                this.f1961b.h(i3 - 64);
            }
        }

        public String toString() {
            if (this.f1961b == null) {
                return Long.toBinaryString(this.f1960a);
            }
            return this.f1961b.toString() + "xx" + Long.toBinaryString(this.f1960a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChildHelper.java */
    interface InterfaceC0019b {
        View a(int i3);

        void b(View view);

        void c(int i3);

        void d();

        RecyclerView.d0 e(View view);

        void f(int i3);

        void g(View view);

        void h(View view, int i3, ViewGroup.LayoutParams layoutParams);

        void i(View view, int i3);

        int j(View view);

        int k();
    }

    b(InterfaceC0019b interfaceC0019b) {
        this.f1957a = interfaceC0019b;
    }

    private int h(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int iK = this.f1957a.k();
        int i4 = i3;
        while (i4 < iK) {
            int iB = i3 - (i4 - this.f1958b.b(i4));
            if (iB == 0) {
                while (this.f1958b.d(i4)) {
                    i4++;
                }
                return i4;
            }
            i4 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.f1959c.add(view);
        this.f1957a.b(view);
    }

    private boolean t(View view) {
        if (!this.f1959c.remove(view)) {
            return false;
        }
        this.f1957a.g(view);
        return true;
    }

    void a(View view, int i3, boolean z2) {
        int iK = i3 < 0 ? this.f1957a.k() : h(i3);
        this.f1958b.e(iK, z2);
        if (z2) {
            l(view);
        }
        this.f1957a.i(view, iK);
    }

    void b(View view, boolean z2) {
        a(view, -1, z2);
    }

    void c(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int iK = i3 < 0 ? this.f1957a.k() : h(i3);
        this.f1958b.e(iK, z2);
        if (z2) {
            l(view);
        }
        this.f1957a.h(view, iK, layoutParams);
    }

    void d(int i3) {
        int iH = h(i3);
        this.f1958b.f(iH);
        this.f1957a.f(iH);
    }

    View e(int i3) {
        int size = this.f1959c.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = this.f1959c.get(i4);
            RecyclerView.d0 d0VarE = this.f1957a.e(view);
            if (d0VarE.m() == i3 && !d0VarE.t() && !d0VarE.v()) {
                return view;
            }
        }
        return null;
    }

    View f(int i3) {
        return this.f1957a.a(h(i3));
    }

    int g() {
        return this.f1957a.k() - this.f1959c.size();
    }

    View i(int i3) {
        return this.f1957a.a(i3);
    }

    int j() {
        return this.f1957a.k();
    }

    void k(View view) {
        int iJ = this.f1957a.j(view);
        if (iJ >= 0) {
            this.f1958b.h(iJ);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int iJ = this.f1957a.j(view);
        if (iJ == -1 || this.f1958b.d(iJ)) {
            return -1;
        }
        return iJ - this.f1958b.b(iJ);
    }

    boolean n(View view) {
        return this.f1959c.contains(view);
    }

    void o() {
        this.f1958b.g();
        for (int size = this.f1959c.size() - 1; size >= 0; size--) {
            this.f1957a.g(this.f1959c.get(size));
            this.f1959c.remove(size);
        }
        this.f1957a.d();
    }

    void p(View view) {
        int iJ = this.f1957a.j(view);
        if (iJ < 0) {
            return;
        }
        if (this.f1958b.f(iJ)) {
            t(view);
        }
        this.f1957a.c(iJ);
    }

    void q(int i3) {
        int iH = h(i3);
        View viewA = this.f1957a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f1958b.f(iH)) {
            t(viewA);
        }
        this.f1957a.c(iH);
    }

    boolean r(View view) {
        int iJ = this.f1957a.j(view);
        if (iJ == -1) {
            t(view);
            return true;
        }
        if (!this.f1958b.d(iJ)) {
            return false;
        }
        this.f1958b.f(iJ);
        t(view);
        this.f1957a.c(iJ);
        return true;
    }

    void s(View view) {
        int iJ = this.f1957a.j(view);
        if (iJ < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f1958b.d(iJ)) {
            this.f1958b.a(iJ);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f1958b.toString() + ", hidden list:" + this.f1959c.size();
    }
}
