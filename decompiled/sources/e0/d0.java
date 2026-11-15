package e0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f4555a;

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Window f4556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f4557b;

        a(Window window, View view) {
            this.f4556a = window;
            this.f4557b = view;
        }

        protected void c(int i3) {
            View decorView = this.f4556a.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void d(int i3) {
            this.f4556a.addFlags(i3);
        }

        protected void e(int i3) {
            View decorView = this.f4556a.getDecorView();
            decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
        }

        protected void f(int i3) {
            this.f4556a.clearFlags(i3);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class b extends a {
        b(Window window, View view) {
            super(window, view);
        }

        @Override // e0.d0.e
        public void b(boolean z2) {
            if (!z2) {
                e(8192);
                return;
            }
            f(67108864);
            d(Integer.MIN_VALUE);
            c(8192);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class c extends b {
        c(Window window, View view) {
            super(window, view);
        }

        @Override // e0.d0.e
        public void a(boolean z2) {
            if (!z2) {
                e(16);
                return;
            }
            f(134217728);
            d(Integer.MIN_VALUE);
            c(16);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d0 f4558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowInsetsController f4559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final l.g<Object, WindowInsetsController.OnControllableInsetsChangedListener> f4560c;

        d(Window window, d0 d0Var) {
            this(window.getInsetsController(), d0Var);
        }

        @Override // e0.d0.e
        public void a(boolean z2) {
            if (z2) {
                this.f4559b.setSystemBarsAppearance(16, 16);
            } else {
                this.f4559b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // e0.d0.e
        public void b(boolean z2) {
            if (z2) {
                this.f4559b.setSystemBarsAppearance(8, 8);
            } else {
                this.f4559b.setSystemBarsAppearance(0, 8);
            }
        }

        d(WindowInsetsController windowInsetsController, d0 d0Var) {
            this.f4560c = new l.g<>();
            this.f4559b = windowInsetsController;
            this.f4558a = d0Var;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsControllerCompat.java */
    private static class e {
        e() {
        }

        public void a(boolean z2) {
        }

        public void b(boolean z2) {
        }
    }

    private d0(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f4555a = new d(windowInsetsController, this);
        } else {
            this.f4555a = new e();
        }
    }

    public static d0 c(WindowInsetsController windowInsetsController) {
        return new d0(windowInsetsController);
    }

    public void a(boolean z2) {
        this.f4555a.a(z2);
    }

    public void b(boolean z2) {
        this.f4555a.b(z2);
    }

    public d0(Window window, View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f4555a = new d(window, this);
            return;
        }
        if (i3 >= 26) {
            this.f4555a = new c(window, view);
            return;
        }
        if (i3 >= 23) {
            this.f4555a = new b(window, view);
        } else if (i3 >= 20) {
            this.f4555a = new a(window, view);
        } else {
            this.f4555a = new e();
        }
    }
}
