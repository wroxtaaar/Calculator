package e0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: WindowInsetsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f4521b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f4522a;

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f4523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f4524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Field f4525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f4526d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f4523a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f4524b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f4525c = declaredField3;
                declaredField3.setAccessible(true);
                f4526d = true;
            } catch (ReflectiveOperationException e3) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e3.getMessage(), e3);
            }
        }

        public static c0 a(View view) {
            if (f4526d && view.isAttachedToWindow()) {
                try {
                    Object obj = f4523a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f4524b.get(obj);
                        Rect rect2 = (Rect) f4525c.get(obj);
                        if (rect != null && rect2 != null) {
                            c0 c0VarA = new b().b(w.b.c(rect)).c(w.b.c(rect2)).a();
                            c0VarA.r(c0VarA);
                            c0VarA.d(view.getRootView());
                            return c0VarA;
                        }
                    }
                } catch (IllegalAccessException e3) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e3.getMessage(), e3);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class e extends d {
        e() {
        }

        e(c0 c0Var) {
            super(c0Var);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0 f4535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        w.b[] f4536b;

        f() {
            this(new c0((c0) null));
        }

        protected final void a() {
            w.b[] bVarArr = this.f4536b;
            if (bVarArr != null) {
                w.b bVar = bVarArr[m.a(1)];
                w.b bVar2 = this.f4536b[m.a(2)];
                if (bVar != null && bVar2 != null) {
                    f(w.b.a(bVar, bVar2));
                } else if (bVar != null) {
                    f(bVar);
                } else if (bVar2 != null) {
                    f(bVar2);
                }
                w.b bVar3 = this.f4536b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                w.b bVar4 = this.f4536b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                w.b bVar5 = this.f4536b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        c0 b() {
            a();
            return this.f4535a;
        }

        void c(w.b bVar) {
        }

        void d(w.b bVar) {
        }

        void e(w.b bVar) {
        }

        void f(w.b bVar) {
        }

        void g(w.b bVar) {
        }

        f(c0 c0Var) {
            this.f4535a = c0Var;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class i extends h {
        i(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        @Override // e0.c0.l
        c0 a() {
            return c0.u(this.f4543c.consumeDisplayCutout());
        }

        @Override // e0.c0.g, e0.c0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f4543c, iVar.f4543c) && Objects.equals(this.f4547g, iVar.f4547g);
        }

        @Override // e0.c0.l
        e0.c f() {
            return e0.c.e(this.f4543c.getDisplayCutout());
        }

        @Override // e0.c0.l
        public int hashCode() {
            return this.f4543c.hashCode();
        }

        i(c0 c0Var, i iVar) {
            super(c0Var, iVar);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class k extends j {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final c0 f4552r = c0.u(WindowInsets.CONSUMED);

        k(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        @Override // e0.c0.g, e0.c0.l
        final void d(View view) {
        }

        @Override // e0.c0.g, e0.c0.l
        public w.b g(int i3) {
            return w.b.d(this.f4543c.getInsets(n.a(i3)));
        }

        k(c0 c0Var, k kVar) {
            super(c0Var, kVar);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final c0 f4553b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c0 f4554a;

        l(c0 c0Var) {
            this.f4554a = c0Var;
        }

        c0 a() {
            return this.f4554a;
        }

        c0 b() {
            return this.f4554a;
        }

        c0 c() {
            return this.f4554a;
        }

        void d(View view) {
        }

        void e(c0 c0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && d0.d.a(k(), lVar.k()) && d0.d.a(i(), lVar.i()) && d0.d.a(f(), lVar.f());
        }

        e0.c f() {
            return null;
        }

        w.b g(int i3) {
            return w.b.f6320e;
        }

        w.b h() {
            return k();
        }

        public int hashCode() {
            return d0.d.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        w.b i() {
            return w.b.f6320e;
        }

        w.b j() {
            return k();
        }

        w.b k() {
            return w.b.f6320e;
        }

        w.b l() {
            return k();
        }

        c0 m(int i3, int i4, int i5, int i6) {
            return f4553b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(w.b[] bVarArr) {
        }

        void q(w.b bVar) {
        }

        void r(c0 c0Var) {
        }

        public void s(w.b bVar) {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class m {
        static int a(int i3) {
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 4) {
                return 2;
            }
            if (i3 == 8) {
                return 3;
            }
            if (i3 == 16) {
                return 4;
            }
            if (i3 == 32) {
                return 5;
            }
            if (i3 == 64) {
                return 6;
            }
            if (i3 == 128) {
                return 7;
            }
            if (i3 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i3);
        }

        public static int b() {
            return 32;
        }

        public static int c() {
            return 7;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static final class n {
        static int a(int i3) {
            int iStatusBars;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i3 & i5) != 0) {
                    if (i5 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i5 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i5 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i5 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i5 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i5 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i5 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i4 |= iStatusBars;
                }
            }
            return i4;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f4521b = k.f4552r;
        } else {
            f4521b = l.f4553b;
        }
    }

    private c0(WindowInsets windowInsets) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f4522a = new k(this, windowInsets);
            return;
        }
        if (i3 >= 29) {
            this.f4522a = new j(this, windowInsets);
            return;
        }
        if (i3 >= 28) {
            this.f4522a = new i(this, windowInsets);
            return;
        }
        if (i3 >= 21) {
            this.f4522a = new h(this, windowInsets);
        } else if (i3 >= 20) {
            this.f4522a = new g(this, windowInsets);
        } else {
            this.f4522a = new l(this);
        }
    }

    static w.b m(w.b bVar, int i3, int i4, int i5, int i6) {
        int iMax = Math.max(0, bVar.f6321a - i3);
        int iMax2 = Math.max(0, bVar.f6322b - i4);
        int iMax3 = Math.max(0, bVar.f6323c - i5);
        int iMax4 = Math.max(0, bVar.f6324d - i6);
        return (iMax == i3 && iMax2 == i4 && iMax3 == i5 && iMax4 == i6) ? bVar : w.b.b(iMax, iMax2, iMax3, iMax4);
    }

    public static c0 u(WindowInsets windowInsets) {
        return v(windowInsets, null);
    }

    public static c0 v(WindowInsets windowInsets, View view) {
        c0 c0Var = new c0((WindowInsets) d0.i.c(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            c0Var.r(t.H(view));
            c0Var.d(view.getRootView());
        }
        return c0Var;
    }

    @Deprecated
    public c0 a() {
        return this.f4522a.a();
    }

    @Deprecated
    public c0 b() {
        return this.f4522a.b();
    }

    @Deprecated
    public c0 c() {
        return this.f4522a.c();
    }

    void d(View view) {
        this.f4522a.d(view);
    }

    public e0.c e() {
        return this.f4522a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return d0.d.a(this.f4522a, ((c0) obj).f4522a);
        }
        return false;
    }

    public w.b f(int i3) {
        return this.f4522a.g(i3);
    }

    @Deprecated
    public w.b g() {
        return this.f4522a.i();
    }

    @Deprecated
    public int h() {
        return this.f4522a.k().f6324d;
    }

    public int hashCode() {
        l lVar = this.f4522a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f4522a.k().f6321a;
    }

    @Deprecated
    public int j() {
        return this.f4522a.k().f6323c;
    }

    @Deprecated
    public int k() {
        return this.f4522a.k().f6322b;
    }

    public c0 l(int i3, int i4, int i5, int i6) {
        return this.f4522a.m(i3, i4, i5, i6);
    }

    public boolean n() {
        return this.f4522a.n();
    }

    @Deprecated
    public c0 o(int i3, int i4, int i5, int i6) {
        return new b(this).c(w.b.b(i3, i4, i5, i6)).a();
    }

    void p(w.b[] bVarArr) {
        this.f4522a.p(bVarArr);
    }

    void q(w.b bVar) {
        this.f4522a.q(bVar);
    }

    void r(c0 c0Var) {
        this.f4522a.r(c0Var);
    }

    void s(w.b bVar) {
        this.f4522a.s(bVar);
    }

    public WindowInsets t() {
        l lVar = this.f4522a;
        if (lVar instanceof g) {
            return ((g) lVar).f4543c;
        }
        return null;
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Field f4528e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static boolean f4529f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static Constructor<WindowInsets> f4530g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f4531h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WindowInsets f4532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private w.b f4533d;

        c() {
            this.f4532c = h();
        }

        private static WindowInsets h() {
            if (!f4529f) {
                try {
                    f4528e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e3);
                }
                f4529f = true;
            }
            Field field = f4528e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e4);
                }
            }
            if (!f4531h) {
                try {
                    f4530g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e5);
                }
                f4531h = true;
            }
            Constructor<WindowInsets> constructor = f4530g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e6);
                }
            }
            return null;
        }

        @Override // e0.c0.f
        c0 b() {
            a();
            c0 c0VarU = c0.u(this.f4532c);
            c0VarU.p(this.f4536b);
            c0VarU.s(this.f4533d);
            return c0VarU;
        }

        @Override // e0.c0.f
        void d(w.b bVar) {
            this.f4533d = bVar;
        }

        @Override // e0.c0.f
        void f(w.b bVar) {
            WindowInsets windowInsets = this.f4532c;
            if (windowInsets != null) {
                this.f4532c = windowInsets.replaceSystemWindowInsets(bVar.f6321a, bVar.f6322b, bVar.f6323c, bVar.f6324d);
            }
        }

        c(c0 c0Var) {
            this.f4532c = c0Var.t();
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f4534c;

        d() {
            this.f4534c = new WindowInsets.Builder();
        }

        @Override // e0.c0.f
        c0 b() {
            a();
            c0 c0VarU = c0.u(this.f4534c.build());
            c0VarU.p(this.f4536b);
            return c0VarU;
        }

        @Override // e0.c0.f
        void c(w.b bVar) {
            this.f4534c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // e0.c0.f
        void d(w.b bVar) {
            this.f4534c.setStableInsets(bVar.e());
        }

        @Override // e0.c0.f
        void e(w.b bVar) {
            this.f4534c.setSystemGestureInsets(bVar.e());
        }

        @Override // e0.c0.f
        void f(w.b bVar) {
            this.f4534c.setSystemWindowInsets(bVar.e());
        }

        @Override // e0.c0.f
        void g(w.b bVar) {
            this.f4534c.setTappableElementInsets(bVar.e());
        }

        d(c0 c0Var) {
            WindowInsets.Builder builder;
            WindowInsets windowInsetsT = c0Var.t();
            if (windowInsetsT != null) {
                builder = new WindowInsets.Builder(windowInsetsT);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f4534c = builder;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class h extends g {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private w.b f4548n;

        h(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
            this.f4548n = null;
        }

        @Override // e0.c0.l
        c0 b() {
            return c0.u(this.f4543c.consumeStableInsets());
        }

        @Override // e0.c0.l
        c0 c() {
            return c0.u(this.f4543c.consumeSystemWindowInsets());
        }

        @Override // e0.c0.l
        final w.b i() {
            if (this.f4548n == null) {
                this.f4548n = w.b.b(this.f4543c.getStableInsetLeft(), this.f4543c.getStableInsetTop(), this.f4543c.getStableInsetRight(), this.f4543c.getStableInsetBottom());
            }
            return this.f4548n;
        }

        @Override // e0.c0.l
        boolean n() {
            return this.f4543c.isConsumed();
        }

        @Override // e0.c0.l
        public void s(w.b bVar) {
            this.f4548n = bVar;
        }

        h(c0 c0Var, h hVar) {
            super(c0Var, hVar);
            this.f4548n = null;
            this.f4548n = hVar.f4548n;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f4537h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static Method f4538i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static Class<?> f4539j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static Class<?> f4540k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static Field f4541l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static Field f4542m;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets f4543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private w.b[] f4544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private w.b f4545e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c0 f4546f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        w.b f4547g;

        g(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var);
            this.f4545e = null;
            this.f4543c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private w.b t(int i3, boolean z2) {
            w.b bVarA = w.b.f6320e;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    bVarA = w.b.a(bVarA, u(i4, z2));
                }
            }
            return bVarA;
        }

        private w.b v() {
            c0 c0Var = this.f4546f;
            return c0Var != null ? c0Var.g() : w.b.f6320e;
        }

        private w.b w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f4537h) {
                x();
            }
            Method method = f4538i;
            if (method != null && f4540k != null && f4541l != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f4541l.get(f4542m.get(objInvoke));
                    if (rect != null) {
                        return w.b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e3) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f4538i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f4539j = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f4540k = cls;
                f4541l = cls.getDeclaredField("mVisibleInsets");
                f4542m = f4539j.getDeclaredField("mAttachInfo");
                f4541l.setAccessible(true);
                f4542m.setAccessible(true);
            } catch (ReflectiveOperationException e3) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
            }
            f4537h = true;
        }

        @Override // e0.c0.l
        void d(View view) {
            w.b bVarW = w(view);
            if (bVarW == null) {
                bVarW = w.b.f6320e;
            }
            q(bVarW);
        }

        @Override // e0.c0.l
        void e(c0 c0Var) {
            c0Var.r(this.f4546f);
            c0Var.q(this.f4547g);
        }

        @Override // e0.c0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f4547g, ((g) obj).f4547g);
            }
            return false;
        }

        @Override // e0.c0.l
        public w.b g(int i3) {
            return t(i3, false);
        }

        @Override // e0.c0.l
        final w.b k() {
            if (this.f4545e == null) {
                this.f4545e = w.b.b(this.f4543c.getSystemWindowInsetLeft(), this.f4543c.getSystemWindowInsetTop(), this.f4543c.getSystemWindowInsetRight(), this.f4543c.getSystemWindowInsetBottom());
            }
            return this.f4545e;
        }

        @Override // e0.c0.l
        c0 m(int i3, int i4, int i5, int i6) {
            b bVar = new b(c0.u(this.f4543c));
            bVar.c(c0.m(k(), i3, i4, i5, i6));
            bVar.b(c0.m(i(), i3, i4, i5, i6));
            return bVar.a();
        }

        @Override // e0.c0.l
        boolean o() {
            return this.f4543c.isRound();
        }

        @Override // e0.c0.l
        public void p(w.b[] bVarArr) {
            this.f4544d = bVarArr;
        }

        @Override // e0.c0.l
        void q(w.b bVar) {
            this.f4547g = bVar;
        }

        @Override // e0.c0.l
        void r(c0 c0Var) {
            this.f4546f = c0Var;
        }

        protected w.b u(int i3, boolean z2) {
            w.b bVarG;
            int i4;
            if (i3 == 1) {
                return z2 ? w.b.b(0, Math.max(v().f6322b, k().f6322b), 0, 0) : w.b.b(0, k().f6322b, 0, 0);
            }
            if (i3 == 2) {
                if (z2) {
                    w.b bVarV = v();
                    w.b bVarI = i();
                    return w.b.b(Math.max(bVarV.f6321a, bVarI.f6321a), 0, Math.max(bVarV.f6323c, bVarI.f6323c), Math.max(bVarV.f6324d, bVarI.f6324d));
                }
                w.b bVarK = k();
                c0 c0Var = this.f4546f;
                bVarG = c0Var != null ? c0Var.g() : null;
                int iMin = bVarK.f6324d;
                if (bVarG != null) {
                    iMin = Math.min(iMin, bVarG.f6324d);
                }
                return w.b.b(bVarK.f6321a, 0, bVarK.f6323c, iMin);
            }
            if (i3 != 8) {
                if (i3 == 16) {
                    return j();
                }
                if (i3 == 32) {
                    return h();
                }
                if (i3 == 64) {
                    return l();
                }
                if (i3 != 128) {
                    return w.b.f6320e;
                }
                c0 c0Var2 = this.f4546f;
                e0.c cVarE = c0Var2 != null ? c0Var2.e() : f();
                return cVarE != null ? w.b.b(cVarE.b(), cVarE.d(), cVarE.c(), cVarE.a()) : w.b.f6320e;
            }
            w.b[] bVarArr = this.f4544d;
            bVarG = bVarArr != null ? bVarArr[m.a(8)] : null;
            if (bVarG != null) {
                return bVarG;
            }
            w.b bVarK2 = k();
            w.b bVarV2 = v();
            int i5 = bVarK2.f6324d;
            if (i5 > bVarV2.f6324d) {
                return w.b.b(0, 0, 0, i5);
            }
            w.b bVar = this.f4547g;
            return (bVar == null || bVar.equals(w.b.f6320e) || (i4 = this.f4547g.f6324d) <= bVarV2.f6324d) ? w.b.f6320e : w.b.b(0, 0, 0, i4);
        }

        g(c0 c0Var, g gVar) {
            this(c0Var, new WindowInsets(gVar.f4543c));
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class j extends i {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private w.b f4549o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private w.b f4550p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private w.b f4551q;

        j(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
            this.f4549o = null;
            this.f4550p = null;
            this.f4551q = null;
        }

        @Override // e0.c0.l
        w.b h() {
            if (this.f4550p == null) {
                this.f4550p = w.b.d(this.f4543c.getMandatorySystemGestureInsets());
            }
            return this.f4550p;
        }

        @Override // e0.c0.l
        w.b j() {
            if (this.f4549o == null) {
                this.f4549o = w.b.d(this.f4543c.getSystemGestureInsets());
            }
            return this.f4549o;
        }

        @Override // e0.c0.l
        w.b l() {
            if (this.f4551q == null) {
                this.f4551q = w.b.d(this.f4543c.getTappableElementInsets());
            }
            return this.f4551q;
        }

        @Override // e0.c0.g, e0.c0.l
        c0 m(int i3, int i4, int i5, int i6) {
            return c0.u(this.f4543c.inset(i3, i4, i5, i6));
        }

        @Override // e0.c0.h, e0.c0.l
        public void s(w.b bVar) {
        }

        j(c0 c0Var, j jVar) {
            super(c0Var, jVar);
            this.f4549o = null;
            this.f4550p = null;
            this.f4551q = null;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f4527a;

        public b() {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.f4527a = new e();
                return;
            }
            if (i3 >= 29) {
                this.f4527a = new d();
            } else if (i3 >= 20) {
                this.f4527a = new c();
            } else {
                this.f4527a = new f();
            }
        }

        public c0 a() {
            return this.f4527a.b();
        }

        @Deprecated
        public b b(w.b bVar) {
            this.f4527a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(w.b bVar) {
            this.f4527a.f(bVar);
            return this;
        }

        public b(c0 c0Var) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.f4527a = new e(c0Var);
                return;
            }
            if (i3 >= 29) {
                this.f4527a = new d(c0Var);
            } else if (i3 >= 20) {
                this.f4527a = new c(c0Var);
            } else {
                this.f4527a = new f(c0Var);
            }
        }
    }

    public c0(c0 c0Var) {
        if (c0Var != null) {
            l lVar = c0Var.f4522a;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30 && (lVar instanceof k)) {
                this.f4522a = new k(this, (k) lVar);
            } else if (i3 >= 29 && (lVar instanceof j)) {
                this.f4522a = new j(this, (j) lVar);
            } else if (i3 >= 28 && (lVar instanceof i)) {
                this.f4522a = new i(this, (i) lVar);
            } else if (i3 >= 21 && (lVar instanceof h)) {
                this.f4522a = new h(this, (h) lVar);
            } else if (i3 >= 20 && (lVar instanceof g)) {
                this.f4522a = new g(this, (g) lVar);
            } else {
                this.f4522a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f4522a = new l(this);
    }
}
