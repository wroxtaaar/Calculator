package c0;

import java.util.Locale;

/* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0.d f2478a = new C0033e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0.d f2479b = new C0033e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0.d f2480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0.d f2481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0.d f2482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0.d f2483f;

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final a f2484b = new a(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f2485a;

        private a(boolean z2) {
            this.f2485a = z2;
        }

        @Override // c0.e.c
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            boolean z2 = false;
            while (i3 < i5) {
                int iA = e.a(Character.getDirectionality(charSequence.charAt(i3)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                    } else if (!this.f2485a) {
                        return 1;
                    }
                    i3++;
                    z2 = z2;
                } else if (this.f2485a) {
                    return 0;
                }
                z2 = true;
                i3++;
                z2 = z2;
            }
            if (z2) {
                return this.f2485a ? 1 : 0;
            }
            return 2;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f2486a = new b();

        private b() {
        }

        @Override // c0.e.c
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            int iB = 2;
            while (i3 < i5 && iB == 2) {
                iB = e.b(Character.getDirectionality(charSequence.charAt(i3)));
                i3++;
            }
            return iB;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private interface c {
        int a(CharSequence charSequence, int i3, int i4);
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static abstract class d implements c0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f2487a;

        d(c cVar) {
            this.f2487a = cVar;
        }

        private boolean c(CharSequence charSequence, int i3, int i4) {
            int iA = this.f2487a.a(charSequence, i3, i4);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return b();
            }
            return false;
        }

        @Override // c0.d
        public boolean a(CharSequence charSequence, int i3, int i4) {
            if (charSequence == null || i3 < 0 || i4 < 0 || charSequence.length() - i4 < i3) {
                throw new IllegalArgumentException();
            }
            return this.f2487a == null ? b() : c(charSequence, i3, i4);
        }

        protected abstract boolean b();
    }

    /* JADX INFO: renamed from: c0.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class C0033e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f2488b;

        C0033e(c cVar, boolean z2) {
            super(cVar);
            this.f2488b = z2;
        }

        @Override // c0.e.d
        protected boolean b() {
            return this.f2488b;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final f f2489b = new f();

        f() {
            super(null);
        }

        @Override // c0.e.d
        protected boolean b() {
            return c0.f.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f2486a;
        f2480c = new C0033e(bVar, false);
        f2481d = new C0033e(bVar, true);
        f2482e = new C0033e(a.f2484b, false);
        f2483f = f.f2489b;
    }

    static int a(int i3) {
        if (i3 != 0) {
            return (i3 == 1 || i3 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i3) {
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                return 0;
            }
            switch (i3) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
