package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: AppCompatBackgroundHelper.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f571a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u0 f574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u0 f575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u0 f576f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f573c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f572b = j.b();

    e(View view) {
        this.f571a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f576f == null) {
            this.f576f = new u0();
        }
        u0 u0Var = this.f576f;
        u0Var.a();
        ColorStateList colorStateListS = e0.t.s(this.f571a);
        if (colorStateListS != null) {
            u0Var.f782d = true;
            u0Var.f779a = colorStateListS;
        }
        PorterDuff.Mode modeT = e0.t.t(this.f571a);
        if (modeT != null) {
            u0Var.f781c = true;
            u0Var.f780b = modeT;
        }
        if (!u0Var.f782d && !u0Var.f781c) {
            return false;
        }
        j.i(drawable, u0Var, this.f571a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 21) {
            return this.f574d != null;
        }
        return i3 == 21;
    }

    void b() {
        Drawable background = this.f571a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            u0 u0Var = this.f575e;
            if (u0Var != null) {
                j.i(background, u0Var, this.f571a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f574d;
            if (u0Var2 != null) {
                j.i(background, u0Var2, this.f571a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        u0 u0Var = this.f575e;
        if (u0Var != null) {
            return u0Var.f779a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        u0 u0Var = this.f575e;
        if (u0Var != null) {
            return u0Var.f780b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i3) {
        Context context = this.f571a.getContext();
        int[] iArr = a.j.ViewBackgroundHelper;
        w0 w0VarV = w0.v(context, attributeSet, iArr, i3, 0);
        View view = this.f571a;
        e0.t.k0(view, view.getContext(), iArr, attributeSet, w0VarV.r(), i3, 0);
        try {
            int i4 = a.j.ViewBackgroundHelper_android_background;
            if (w0VarV.s(i4)) {
                this.f573c = w0VarV.n(i4, -1);
                ColorStateList colorStateListF = this.f572b.f(this.f571a.getContext(), this.f573c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i5 = a.j.ViewBackgroundHelper_backgroundTint;
            if (w0VarV.s(i5)) {
                e0.t.q0(this.f571a, w0VarV.c(i5));
            }
            int i6 = a.j.ViewBackgroundHelper_backgroundTintMode;
            if (w0VarV.s(i6)) {
                e0.t.r0(this.f571a, e0.e(w0VarV.k(i6, -1), null));
            }
        } finally {
            w0VarV.w();
        }
    }

    void f(Drawable drawable) {
        this.f573c = -1;
        h(null);
        b();
    }

    void g(int i3) {
        this.f573c = i3;
        j jVar = this.f572b;
        h(jVar != null ? jVar.f(this.f571a.getContext(), i3) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f574d == null) {
                this.f574d = new u0();
            }
            u0 u0Var = this.f574d;
            u0Var.f779a = colorStateList;
            u0Var.f782d = true;
        } else {
            this.f574d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f575e == null) {
            this.f575e = new u0();
        }
        u0 u0Var = this.f575e;
        u0Var.f779a = colorStateList;
        u0Var.f782d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f575e == null) {
            this.f575e = new u0();
        }
        u0 u0Var = this.f575e;
        u0Var.f780b = mode;
        u0Var.f781c = true;
        b();
    }
}
