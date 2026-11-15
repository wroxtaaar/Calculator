package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ThreadLocal<e> f2044f = new ThreadLocal<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Comparator<c> f2045g = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f2047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f2048d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<RecyclerView> f2046b = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<c> f2049e = new ArrayList<>();

    /* JADX INFO: compiled from: GapWorker.java */
    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f2057d;
            if ((recyclerView == null) != (cVar2.f2057d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z2 = cVar.f2054a;
            if (z2 != cVar2.f2054a) {
                return z2 ? -1 : 1;
            }
            int i3 = cVar2.f2055b - cVar.f2055b;
            if (i3 != 0) {
                return i3;
            }
            int i4 = cVar.f2056c - cVar2.f2056c;
            if (i4 != 0) {
                return i4;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f2052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2053d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i3, int i4) {
            if (i3 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i5 = this.f2053d * 2;
            int[] iArr = this.f2052c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f2052c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i5 >= iArr.length) {
                int[] iArr3 = new int[i5 * 2];
                this.f2052c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f2052c;
            iArr4[i5] = i3;
            iArr4[i5 + 1] = i4;
            this.f2053d++;
        }

        void b() {
            int[] iArr = this.f2052c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2053d = 0;
        }

        void c(RecyclerView recyclerView, boolean z2) {
            this.f2053d = 0;
            int[] iArr = this.f2052c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f1760n;
            if (recyclerView.f1758m == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z2) {
                if (!recyclerView.f1742e.p()) {
                    oVar.p(recyclerView.f1758m.e(), this);
                }
            } else if (!recyclerView.m0()) {
                oVar.o(this.f2050a, this.f2051b, recyclerView.f1751i0, this);
            }
            int i3 = this.f2053d;
            if (i3 > oVar.f1858m) {
                oVar.f1858m = i3;
                oVar.f1859n = z2;
                recyclerView.f1738c.K();
            }
        }

        boolean d(int i3) {
            if (this.f2052c != null) {
                int i4 = this.f2053d * 2;
                for (int i5 = 0; i5 < i4; i5 += 2) {
                    if (this.f2052c[i5] == i3) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i3, int i4) {
            this.f2050a = i3;
            this.f2051b = i4;
        }
    }

    /* JADX INFO: compiled from: GapWorker.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f2057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2058e;

        c() {
        }

        public void a() {
            this.f2054a = false;
            this.f2055b = 0;
            this.f2056c = 0;
            this.f2057d = null;
            this.f2058e = 0;
        }
    }

    e() {
    }

    private void b() {
        c cVar;
        int size = this.f2046b.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView = this.f2046b.get(i4);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f1749h0.c(recyclerView, false);
                i3 += recyclerView.f1749h0.f2053d;
            }
        }
        this.f2049e.ensureCapacity(i3);
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView2 = this.f2046b.get(i6);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f1749h0;
                int iAbs = Math.abs(bVar.f2050a) + Math.abs(bVar.f2051b);
                for (int i7 = 0; i7 < bVar.f2053d * 2; i7 += 2) {
                    if (i5 >= this.f2049e.size()) {
                        cVar = new c();
                        this.f2049e.add(cVar);
                    } else {
                        cVar = this.f2049e.get(i5);
                    }
                    int[] iArr = bVar.f2052c;
                    int i8 = iArr[i7 + 1];
                    cVar.f2054a = i8 <= iAbs;
                    cVar.f2055b = iAbs;
                    cVar.f2056c = i8;
                    cVar.f2057d = recyclerView2;
                    cVar.f2058e = iArr[i7];
                    i5++;
                }
            }
        }
        Collections.sort(this.f2049e, f2045g);
    }

    private void c(c cVar, long j3) {
        RecyclerView.d0 d0VarI = i(cVar.f2057d, cVar.f2058e, cVar.f2054a ? Long.MAX_VALUE : j3);
        if (d0VarI == null || d0VarI.f1814b == null || !d0VarI.s() || d0VarI.t()) {
            return;
        }
        h(d0VarI.f1814b.get(), j3);
    }

    private void d(long j3) {
        for (int i3 = 0; i3 < this.f2049e.size(); i3++) {
            c cVar = this.f2049e.get(i3);
            if (cVar.f2057d == null) {
                return;
            }
            c(cVar, j3);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i3) {
        int iJ = recyclerView.f1744f.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            RecyclerView.d0 d0VarG0 = RecyclerView.g0(recyclerView.f1744f.i(i4));
            if (d0VarG0.f1815c == i3 && !d0VarG0.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j3) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.E && recyclerView.f1744f.j() != 0) {
            recyclerView.V0();
        }
        b bVar = recyclerView.f1749h0;
        bVar.c(recyclerView, true);
        if (bVar.f2053d != 0) {
            try {
                a0.c.a("RV Nested Prefetch");
                recyclerView.f1751i0.f(recyclerView.f1758m);
                for (int i3 = 0; i3 < bVar.f2053d * 2; i3 += 2) {
                    i(recyclerView, bVar.f2052c[i3], j3);
                }
                a0.c.b();
            } catch (Throwable th) {
                a0.c.b();
                throw th;
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i3, long j3) {
        if (e(recyclerView, i3)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f1738c;
        try {
            recyclerView.H0();
            RecyclerView.d0 d0VarI = vVar.I(i3, false, j3);
            if (d0VarI != null) {
                if (!d0VarI.s() || d0VarI.t()) {
                    vVar.a(d0VarI, false);
                } else {
                    vVar.B(d0VarI.f1813a);
                }
            }
            return d0VarI;
        } finally {
            recyclerView.J0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f2046b.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i3, int i4) {
        if (recyclerView.isAttachedToWindow() && this.f2047c == 0) {
            this.f2047c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f1749h0.e(i3, i4);
    }

    void g(long j3) {
        b();
        d(j3);
    }

    public void j(RecyclerView recyclerView) {
        this.f2046b.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a0.c.a("RV Prefetch");
            if (!this.f2046b.isEmpty()) {
                int size = this.f2046b.size();
                long jMax = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = this.f2046b.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f2048d);
                }
            }
        } finally {
            this.f2047c = 0L;
            a0.c.b();
        }
    }
}
