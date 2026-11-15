package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AdapterHelper.java */
/* JADX INFO: loaded from: classes.dex */
class a implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d0.f<b> f1945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<b> f1947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final InterfaceC0018a f1948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Runnable f1949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f1950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h f1951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1952h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdapterHelper.java */
    interface InterfaceC0018a {
        void a(int i3, int i4);

        void b(b bVar);

        RecyclerView.d0 c(int i3);

        void d(int i3, int i4);

        void e(int i3, int i4);

        void f(b bVar);

        void g(int i3, int i4);

        void h(int i3, int i4, Object obj);
    }

    /* JADX INFO: compiled from: AdapterHelper.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f1955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1956d;

        b(int i3, int i4, int i5, Object obj) {
            this.f1953a = i3;
            this.f1954b = i4;
            this.f1956d = i5;
            this.f1955c = obj;
        }

        String a() {
            int i3 = this.f1953a;
            if (i3 == 1) {
                return "add";
            }
            if (i3 == 2) {
                return "rm";
            }
            if (i3 != 4) {
                return i3 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i3 = this.f1953a;
            if (i3 != bVar.f1953a) {
                return false;
            }
            if (i3 == 8 && Math.abs(this.f1956d - this.f1954b) == 1 && this.f1956d == bVar.f1954b && this.f1954b == bVar.f1956d) {
                return true;
            }
            if (this.f1956d != bVar.f1956d || this.f1954b != bVar.f1954b) {
                return false;
            }
            Object obj2 = this.f1955c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1955c)) {
                    return false;
                }
            } else if (bVar.f1955c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1953a * 31) + this.f1954b) * 31) + this.f1956d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1954b + "c:" + this.f1956d + ",p:" + this.f1955c + "]";
        }
    }

    a(InterfaceC0018a interfaceC0018a) {
        this(interfaceC0018a, false);
    }

    private void c(b bVar) {
        s(bVar);
    }

    private void d(b bVar) {
        s(bVar);
    }

    private void f(b bVar) {
        boolean z2;
        byte b3;
        int i3 = bVar.f1954b;
        int i4 = bVar.f1956d + i3;
        byte b4 = -1;
        int i5 = i3;
        int i6 = 0;
        while (i5 < i4) {
            if (this.f1948d.c(i5) != null || h(i5)) {
                if (b4 == 0) {
                    k(b(2, i3, i6, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b3 = 1;
            } else {
                if (b4 == 1) {
                    s(b(2, i3, i6, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b3 = 0;
            }
            if (z2) {
                i5 -= i6;
                i4 -= i6;
                i6 = 1;
            } else {
                i6++;
            }
            i5++;
            b4 = b3;
        }
        if (i6 != bVar.f1956d) {
            a(bVar);
            bVar = b(2, i3, i6, null);
        }
        if (b4 == 0) {
            k(bVar);
        } else {
            s(bVar);
        }
    }

    private void g(b bVar) {
        int i3 = bVar.f1954b;
        int i4 = bVar.f1956d + i3;
        int i5 = 0;
        byte b3 = -1;
        int i6 = i3;
        while (i3 < i4) {
            if (this.f1948d.c(i3) != null || h(i3)) {
                if (b3 == 0) {
                    k(b(4, i6, i5, bVar.f1955c));
                    i6 = i3;
                    i5 = 0;
                }
                b3 = 1;
            } else {
                if (b3 == 1) {
                    s(b(4, i6, i5, bVar.f1955c));
                    i6 = i3;
                    i5 = 0;
                }
                b3 = 0;
            }
            i5++;
            i3++;
        }
        if (i5 != bVar.f1956d) {
            Object obj = bVar.f1955c;
            a(bVar);
            bVar = b(4, i6, i5, obj);
        }
        if (b3 == 0) {
            k(bVar);
        } else {
            s(bVar);
        }
    }

    private boolean h(int i3) {
        int size = this.f1947c.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.f1947c.get(i4);
            int i5 = bVar.f1953a;
            if (i5 == 8) {
                if (n(bVar.f1956d, i4 + 1) == i3) {
                    return true;
                }
            } else if (i5 == 1) {
                int i6 = bVar.f1954b;
                int i7 = bVar.f1956d + i6;
                while (i6 < i7) {
                    if (n(i6, i4 + 1) == i3) {
                        return true;
                    }
                    i6++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i3;
        int i4 = bVar.f1953a;
        if (i4 == 1 || i4 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iW = w(bVar.f1954b, i4);
        int i5 = bVar.f1954b;
        int i6 = bVar.f1953a;
        if (i6 == 2) {
            i3 = 0;
        } else {
            if (i6 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i3 = 1;
        }
        int i7 = 1;
        for (int i8 = 1; i8 < bVar.f1956d; i8++) {
            int iW2 = w(bVar.f1954b + (i3 * i8), bVar.f1953a);
            int i9 = bVar.f1953a;
            if (i9 == 2 ? iW2 == iW : i9 == 4 && iW2 == iW + 1) {
                i7++;
            } else {
                b bVarB = b(i9, iW, i7, bVar.f1955c);
                l(bVarB, i5);
                a(bVarB);
                if (bVar.f1953a == 4) {
                    i5 += i7;
                }
                i7 = 1;
                iW = iW2;
            }
        }
        Object obj = bVar.f1955c;
        a(bVar);
        if (i7 > 0) {
            b bVarB2 = b(bVar.f1953a, iW, i7, obj);
            l(bVarB2, i5);
            a(bVarB2);
        }
    }

    private void s(b bVar) {
        this.f1947c.add(bVar);
        int i3 = bVar.f1953a;
        if (i3 == 1) {
            this.f1948d.g(bVar.f1954b, bVar.f1956d);
            return;
        }
        if (i3 == 2) {
            this.f1948d.e(bVar.f1954b, bVar.f1956d);
            return;
        }
        if (i3 == 4) {
            this.f1948d.h(bVar.f1954b, bVar.f1956d, bVar.f1955c);
        } else {
            if (i3 == 8) {
                this.f1948d.a(bVar.f1954b, bVar.f1956d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int w(int i3, int i4) {
        int i5;
        int i6;
        for (int size = this.f1947c.size() - 1; size >= 0; size--) {
            b bVar = this.f1947c.get(size);
            int i7 = bVar.f1953a;
            if (i7 == 8) {
                int i8 = bVar.f1954b;
                int i9 = bVar.f1956d;
                if (i8 < i9) {
                    i6 = i8;
                    i5 = i9;
                } else {
                    i5 = i8;
                    i6 = i9;
                }
                if (i3 < i6 || i3 > i5) {
                    if (i3 < i8) {
                        if (i4 == 1) {
                            bVar.f1954b = i8 + 1;
                            bVar.f1956d = i9 + 1;
                        } else if (i4 == 2) {
                            bVar.f1954b = i8 - 1;
                            bVar.f1956d = i9 - 1;
                        }
                    }
                } else if (i6 == i8) {
                    if (i4 == 1) {
                        bVar.f1956d = i9 + 1;
                    } else if (i4 == 2) {
                        bVar.f1956d = i9 - 1;
                    }
                    i3++;
                } else {
                    if (i4 == 1) {
                        bVar.f1954b = i8 + 1;
                    } else if (i4 == 2) {
                        bVar.f1954b = i8 - 1;
                    }
                    i3--;
                }
            } else {
                int i10 = bVar.f1954b;
                if (i10 <= i3) {
                    if (i7 == 1) {
                        i3 -= bVar.f1956d;
                    } else if (i7 == 2) {
                        i3 += bVar.f1956d;
                    }
                } else if (i4 == 1) {
                    bVar.f1954b = i10 + 1;
                } else if (i4 == 2) {
                    bVar.f1954b = i10 - 1;
                }
            }
        }
        for (int size2 = this.f1947c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1947c.get(size2);
            if (bVar2.f1953a == 8) {
                int i11 = bVar2.f1956d;
                if (i11 == bVar2.f1954b || i11 < 0) {
                    this.f1947c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1956d <= 0) {
                this.f1947c.remove(size2);
                a(bVar2);
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.h.a
    public void a(b bVar) {
        if (this.f1950f) {
            return;
        }
        bVar.f1955c = null;
        this.f1945a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.h.a
    public b b(int i3, int i4, int i5, Object obj) {
        b bVarB = this.f1945a.b();
        if (bVarB == null) {
            return new b(i3, i4, i5, obj);
        }
        bVarB.f1953a = i3;
        bVarB.f1954b = i4;
        bVarB.f1956d = i5;
        bVarB.f1955c = obj;
        return bVarB;
    }

    public int e(int i3) {
        int size = this.f1946b.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.f1946b.get(i4);
            int i5 = bVar.f1953a;
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = bVar.f1954b;
                    if (i6 <= i3) {
                        int i7 = bVar.f1956d;
                        if (i6 + i7 > i3) {
                            return -1;
                        }
                        i3 -= i7;
                    } else {
                        continue;
                    }
                } else if (i5 == 8) {
                    int i8 = bVar.f1954b;
                    if (i8 == i3) {
                        i3 = bVar.f1956d;
                    } else {
                        if (i8 < i3) {
                            i3--;
                        }
                        if (bVar.f1956d <= i3) {
                            i3++;
                        }
                    }
                }
            } else if (bVar.f1954b <= i3) {
                i3 += bVar.f1956d;
            }
        }
        return i3;
    }

    void i() {
        int size = this.f1947c.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1948d.b(this.f1947c.get(i3));
        }
        u(this.f1947c);
        this.f1952h = 0;
    }

    void j() {
        i();
        int size = this.f1946b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1946b.get(i3);
            int i4 = bVar.f1953a;
            if (i4 == 1) {
                this.f1948d.b(bVar);
                this.f1948d.g(bVar.f1954b, bVar.f1956d);
            } else if (i4 == 2) {
                this.f1948d.b(bVar);
                this.f1948d.d(bVar.f1954b, bVar.f1956d);
            } else if (i4 == 4) {
                this.f1948d.b(bVar);
                this.f1948d.h(bVar.f1954b, bVar.f1956d, bVar.f1955c);
            } else if (i4 == 8) {
                this.f1948d.b(bVar);
                this.f1948d.a(bVar.f1954b, bVar.f1956d);
            }
            Runnable runnable = this.f1949e;
            if (runnable != null) {
                runnable.run();
            }
        }
        u(this.f1946b);
        this.f1952h = 0;
    }

    void l(b bVar, int i3) {
        this.f1948d.f(bVar);
        int i4 = bVar.f1953a;
        if (i4 == 2) {
            this.f1948d.d(i3, bVar.f1956d);
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1948d.h(i3, bVar.f1956d, bVar.f1955c);
        }
    }

    int m(int i3) {
        return n(i3, 0);
    }

    int n(int i3, int i4) {
        int size = this.f1947c.size();
        while (i4 < size) {
            b bVar = this.f1947c.get(i4);
            int i5 = bVar.f1953a;
            if (i5 == 8) {
                int i6 = bVar.f1954b;
                if (i6 == i3) {
                    i3 = bVar.f1956d;
                } else {
                    if (i6 < i3) {
                        i3--;
                    }
                    if (bVar.f1956d <= i3) {
                        i3++;
                    }
                }
            } else {
                int i7 = bVar.f1954b;
                if (i7 > i3) {
                    continue;
                } else if (i5 == 2) {
                    int i8 = bVar.f1956d;
                    if (i3 < i7 + i8) {
                        return -1;
                    }
                    i3 -= i8;
                } else if (i5 == 1) {
                    i3 += bVar.f1956d;
                }
            }
            i4++;
        }
        return i3;
    }

    boolean o(int i3) {
        return (this.f1952h & i3) != 0;
    }

    boolean p() {
        return this.f1946b.size() > 0;
    }

    boolean q() {
        return (this.f1947c.isEmpty() || this.f1946b.isEmpty()) ? false : true;
    }

    boolean r(int i3, int i4, Object obj) {
        if (i4 < 1) {
            return false;
        }
        this.f1946b.add(b(4, i3, i4, obj));
        this.f1952h |= 4;
        return this.f1946b.size() == 1;
    }

    void t() {
        this.f1951g.b(this.f1946b);
        int size = this.f1946b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1946b.get(i3);
            int i4 = bVar.f1953a;
            if (i4 == 1) {
                c(bVar);
            } else if (i4 == 2) {
                f(bVar);
            } else if (i4 == 4) {
                g(bVar);
            } else if (i4 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f1949e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1946b.clear();
    }

    void u(List<b> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(list.get(i3));
        }
        list.clear();
    }

    void v() {
        u(this.f1946b);
        u(this.f1947c);
        this.f1952h = 0;
    }

    a(InterfaceC0018a interfaceC0018a, boolean z2) {
        this.f1945a = new d0.g(30);
        this.f1946b = new ArrayList<>();
        this.f1947c = new ArrayList<>();
        this.f1952h = 0;
        this.f1948d = interfaceC0018a;
        this.f1950f = z2;
        this.f1951g = new h(this);
    }
}
