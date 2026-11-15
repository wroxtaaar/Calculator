package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: compiled from: AppCompatCompoundButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompoundButton f615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f616b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f617c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f618d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f619e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f620f;

    i(CompoundButton compoundButton) {
        this.f615a = compoundButton;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f615a);
        if (drawableA != null) {
            if (this.f618d || this.f619e) {
                Drawable drawableMutate = x.a.r(drawableA).mutate();
                if (this.f618d) {
                    x.a.o(drawableMutate, this.f616b);
                }
                if (this.f619e) {
                    x.a.p(drawableMutate, this.f617c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f615a.getDrawableState());
                }
                this.f615a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i3) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = androidx.core.widget.c.a(this.f615a)) == null) ? i3 : i3 + drawableA.getIntrinsicWidth();
    }

    ColorStateList c() {
        return this.f616b;
    }

    PorterDuff.Mode d() {
        return this.f617c;
    }

    void e(AttributeSet attributeSet, int i3) {
        boolean z2;
        int iN;
        int iN2;
        Context context = this.f615a.getContext();
        int[] iArr = a.j.CompoundButton;
        w0 w0VarV = w0.v(context, attributeSet, iArr, i3, 0);
        CompoundButton compoundButton = this.f615a;
        e0.t.k0(compoundButton, compoundButton.getContext(), iArr, attributeSet, w0VarV.r(), i3, 0);
        try {
            int i4 = a.j.CompoundButton_buttonCompat;
            if (!w0VarV.s(i4) || (iN2 = w0VarV.n(i4, 0)) == 0) {
                z2 = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.f615a;
                    compoundButton2.setButtonDrawable(c.a.d(compoundButton2.getContext(), iN2));
                    z2 = true;
                } catch (Resources.NotFoundException unused) {
                    z2 = false;
                }
            }
            if (!z2) {
                int i5 = a.j.CompoundButton_android_button;
                if (w0VarV.s(i5) && (iN = w0VarV.n(i5, 0)) != 0) {
                    CompoundButton compoundButton3 = this.f615a;
                    compoundButton3.setButtonDrawable(c.a.d(compoundButton3.getContext(), iN));
                }
            }
            int i6 = a.j.CompoundButton_buttonTint;
            if (w0VarV.s(i6)) {
                androidx.core.widget.c.c(this.f615a, w0VarV.c(i6));
            }
            int i7 = a.j.CompoundButton_buttonTintMode;
            if (w0VarV.s(i7)) {
                androidx.core.widget.c.d(this.f615a, e0.e(w0VarV.k(i7, -1), null));
            }
        } finally {
            w0VarV.w();
        }
    }

    void f() {
        if (this.f620f) {
            this.f620f = false;
        } else {
            this.f620f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.f616b = colorStateList;
        this.f618d = true;
        a();
    }

    void h(PorterDuff.Mode mode) {
        this.f617c = mode;
        this.f619e = true;
        a();
    }
}
