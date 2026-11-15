package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: AppCompatImageHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u0 f699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u0 f700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u0 f701d;

    public n(ImageView imageView) {
        this.f698a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f701d == null) {
            this.f701d = new u0();
        }
        u0 u0Var = this.f701d;
        u0Var.a();
        ColorStateList colorStateListA = androidx.core.widget.e.a(this.f698a);
        if (colorStateListA != null) {
            u0Var.f782d = true;
            u0Var.f779a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.e.b(this.f698a);
        if (modeB != null) {
            u0Var.f781c = true;
            u0Var.f780b = modeB;
        }
        if (!u0Var.f782d && !u0Var.f781c) {
            return false;
        }
        j.i(drawable, u0Var, this.f698a.getDrawableState());
        return true;
    }

    private boolean j() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 21) {
            return this.f699b != null;
        }
        return i3 == 21;
    }

    void b() {
        Drawable drawable = this.f698a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            u0 u0Var = this.f700c;
            if (u0Var != null) {
                j.i(drawable, u0Var, this.f698a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f699b;
            if (u0Var2 != null) {
                j.i(drawable, u0Var2, this.f698a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        u0 u0Var = this.f700c;
        if (u0Var != null) {
            return u0Var.f779a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        u0 u0Var = this.f700c;
        if (u0Var != null) {
            return u0Var.f780b;
        }
        return null;
    }

    boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f698a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i3) {
        int iN;
        Context context = this.f698a.getContext();
        int[] iArr = a.j.AppCompatImageView;
        w0 w0VarV = w0.v(context, attributeSet, iArr, i3, 0);
        ImageView imageView = this.f698a;
        e0.t.k0(imageView, imageView.getContext(), iArr, attributeSet, w0VarV.r(), i3, 0);
        try {
            Drawable drawable = this.f698a.getDrawable();
            if (drawable == null && (iN = w0VarV.n(a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = c.a.d(this.f698a.getContext(), iN)) != null) {
                this.f698a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                e0.b(drawable);
            }
            int i4 = a.j.AppCompatImageView_tint;
            if (w0VarV.s(i4)) {
                androidx.core.widget.e.c(this.f698a, w0VarV.c(i4));
            }
            int i5 = a.j.AppCompatImageView_tintMode;
            if (w0VarV.s(i5)) {
                androidx.core.widget.e.d(this.f698a, e0.e(w0VarV.k(i5, -1), null));
            }
        } finally {
            w0VarV.w();
        }
    }

    public void g(int i3) {
        if (i3 != 0) {
            Drawable drawableD = c.a.d(this.f698a.getContext(), i3);
            if (drawableD != null) {
                e0.b(drawableD);
            }
            this.f698a.setImageDrawable(drawableD);
        } else {
            this.f698a.setImageDrawable(null);
        }
        b();
    }

    void h(ColorStateList colorStateList) {
        if (this.f700c == null) {
            this.f700c = new u0();
        }
        u0 u0Var = this.f700c;
        u0Var.f779a = colorStateList;
        u0Var.f782d = true;
        b();
    }

    void i(PorterDuff.Mode mode) {
        if (this.f700c == null) {
            this.f700c = new u0();
        }
        u0 u0Var = this.f700c;
        u0Var.f780b = mode;
        u0Var.f781c = true;
        b();
    }
}
