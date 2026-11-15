package p0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i0 f5622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Property<View, Float> f5623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Property<View, Rect> f5624c;

    /* JADX INFO: compiled from: ViewUtils.java */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(c0.c(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            c0.g(view, f3.floatValue());
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return e0.t.u(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            e0.t.s0(view, rect);
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            f5622a = new h0();
        } else if (i3 >= 23) {
            f5622a = new g0();
        } else if (i3 >= 22) {
            f5622a = new f0();
        } else if (i3 >= 21) {
            f5622a = new e0();
        } else if (i3 >= 19) {
            f5622a = new d0();
        } else {
            f5622a = new i0();
        }
        f5623b = new a(Float.class, "translationAlpha");
        f5624c = new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        f5622a.a(view);
    }

    static b0 b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new a0(view) : z.e(view);
    }

    static float c(View view) {
        return f5622a.c(view);
    }

    static m0 d(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new l0(view) : new k0(view.getWindowToken());
    }

    static void e(View view) {
        f5622a.d(view);
    }

    static void f(View view, int i3, int i4, int i5, int i6) {
        f5622a.e(view, i3, i4, i5, i6);
    }

    static void g(View view, float f3) {
        f5622a.f(view, f3);
    }

    static void h(View view, int i3) {
        f5622a.g(view, i3);
    }

    static void i(View view, Matrix matrix) {
        f5622a.h(view, matrix);
    }

    static void j(View view, Matrix matrix) {
        f5622a.i(view, matrix);
    }
}
