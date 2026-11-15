package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.w0;
import androidx.appcompat.widget.z;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.o;
import e0.t;

/* JADX INFO: compiled from: StartCompoundLayout.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class k extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f3376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f3377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f3378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CheckableImageButton f3379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f3380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f3381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View.OnLongClickListener f3382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3383i;

    k(TextInputLayout textInputLayout, w0 w0Var) {
        super(textInputLayout.getContext());
        this.f3376b = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(t0.h.design_text_input_start_icon, (ViewGroup) this, false);
        this.f3379e = checkableImageButton;
        z zVar = new z(getContext());
        this.f3377c = zVar;
        g(w0Var);
        f(w0Var);
        addView(checkableImageButton);
        addView(zVar);
    }

    private void f(w0 w0Var) {
        this.f3377c.setVisibility(8);
        this.f3377c.setId(t0.f.textinput_prefix_text);
        this.f3377c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        t.o0(this.f3377c, 1);
        l(w0Var.n(t0.k.TextInputLayout_prefixTextAppearance, 0));
        int i3 = t0.k.TextInputLayout_prefixTextColor;
        if (w0Var.s(i3)) {
            m(w0Var.c(i3));
        }
        k(w0Var.p(t0.k.TextInputLayout_prefixText));
    }

    private void g(w0 w0Var) {
        if (h1.c.g(getContext())) {
            e0.g.c((ViewGroup.MarginLayoutParams) this.f3379e.getLayoutParams(), 0);
        }
        q(null);
        r(null);
        int i3 = t0.k.TextInputLayout_startIconTint;
        if (w0Var.s(i3)) {
            this.f3380f = h1.c.b(getContext(), w0Var, i3);
        }
        int i4 = t0.k.TextInputLayout_startIconTintMode;
        if (w0Var.s(i4)) {
            this.f3381g = o.f(w0Var.k(i4, -1), null);
        }
        int i5 = t0.k.TextInputLayout_startIconDrawable;
        if (w0Var.s(i5)) {
            p(w0Var.g(i5));
            int i6 = t0.k.TextInputLayout_startIconContentDescription;
            if (w0Var.s(i6)) {
                o(w0Var.p(i6));
            }
            n(w0Var.a(t0.k.TextInputLayout_startIconCheckable, true));
        }
    }

    private void x() {
        int i3 = (this.f3378d == null || this.f3383i) ? 8 : 0;
        setVisibility(this.f3379e.getVisibility() == 0 || i3 == 0 ? 0 : 8);
        this.f3377c.setVisibility(i3);
        this.f3376b.q0();
    }

    CharSequence a() {
        return this.f3378d;
    }

    ColorStateList b() {
        return this.f3377c.getTextColors();
    }

    TextView c() {
        return this.f3377c;
    }

    CharSequence d() {
        return this.f3379e.getContentDescription();
    }

    Drawable e() {
        return this.f3379e.getDrawable();
    }

    boolean h() {
        return this.f3379e.getVisibility() == 0;
    }

    void i(boolean z2) {
        this.f3383i = z2;
        x();
    }

    void j() {
        f.c(this.f3376b, this.f3379e, this.f3380f);
    }

    void k(CharSequence charSequence) {
        this.f3378d = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f3377c.setText(charSequence);
        x();
    }

    void l(int i3) {
        androidx.core.widget.i.n(this.f3377c, i3);
    }

    void m(ColorStateList colorStateList) {
        this.f3377c.setTextColor(colorStateList);
    }

    void n(boolean z2) {
        this.f3379e.setCheckable(z2);
    }

    void o(CharSequence charSequence) {
        if (d() != charSequence) {
            this.f3379e.setContentDescription(charSequence);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        w();
    }

    void p(Drawable drawable) {
        this.f3379e.setImageDrawable(drawable);
        if (drawable != null) {
            f.a(this.f3376b, this.f3379e, this.f3380f, this.f3381g);
            u(true);
            j();
        } else {
            u(false);
            q(null);
            r(null);
            o(null);
        }
    }

    void q(View.OnClickListener onClickListener) {
        f.e(this.f3379e, onClickListener, this.f3382h);
    }

    void r(View.OnLongClickListener onLongClickListener) {
        this.f3382h = onLongClickListener;
        f.f(this.f3379e, onLongClickListener);
    }

    void s(ColorStateList colorStateList) {
        if (this.f3380f != colorStateList) {
            this.f3380f = colorStateList;
            f.a(this.f3376b, this.f3379e, colorStateList, this.f3381g);
        }
    }

    void t(PorterDuff.Mode mode) {
        if (this.f3381g != mode) {
            this.f3381g = mode;
            f.a(this.f3376b, this.f3379e, this.f3380f, mode);
        }
    }

    void u(boolean z2) {
        if (h() != z2) {
            this.f3379e.setVisibility(z2 ? 0 : 8);
            w();
            x();
        }
    }

    void v(f0.d dVar) {
        if (this.f3377c.getVisibility() != 0) {
            dVar.u0(this.f3379e);
        } else {
            dVar.i0(this.f3377c);
            dVar.u0(this.f3377c);
        }
    }

    void w() {
        EditText editText = this.f3376b.f3229f;
        if (editText == null) {
            return;
        }
        t.y0(this.f3377c, h() ? 0 : t.G(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(t0.d.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }
}
