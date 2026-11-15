package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.internal.o;
import e0.t;
import k1.g;
import k1.k;
import k1.n;
import t0.b;
import z0.c;

/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final boolean f2731t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final boolean f2732u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialButton f2733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f2734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f2741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f2742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f2743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f2744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f2745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2746n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2747o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f2748p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f2749q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LayerDrawable f2750r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f2751s;

    static {
        int i3 = Build.VERSION.SDK_INT;
        f2731t = i3 >= 21;
        f2732u = i3 >= 21 && i3 <= 22;
    }

    a(MaterialButton materialButton, k kVar) {
        this.f2733a = materialButton;
        this.f2734b = kVar;
    }

    private void E(int i3, int i4) {
        int iG = t.G(this.f2733a);
        int paddingTop = this.f2733a.getPaddingTop();
        int iF = t.F(this.f2733a);
        int paddingBottom = this.f2733a.getPaddingBottom();
        int i5 = this.f2737e;
        int i6 = this.f2738f;
        this.f2738f = i4;
        this.f2737e = i3;
        if (!this.f2747o) {
            F();
        }
        t.y0(this.f2733a, iG, (paddingTop + i3) - i5, iF, (paddingBottom + i4) - i6);
    }

    private void F() {
        this.f2733a.setInternalBackground(a());
        g gVarF = f();
        if (gVarF != null) {
            gVarF.W(this.f2751s);
        }
    }

    private void G(k kVar) {
        if (f2732u && !this.f2747o) {
            int iG = t.G(this.f2733a);
            int paddingTop = this.f2733a.getPaddingTop();
            int iF = t.F(this.f2733a);
            int paddingBottom = this.f2733a.getPaddingBottom();
            F();
            t.y0(this.f2733a, iG, paddingTop, iF, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(kVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(kVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(kVar);
        }
    }

    private void I() {
        g gVarF = f();
        g gVarN = n();
        if (gVarF != null) {
            gVarF.d0(this.f2740h, this.f2743k);
            if (gVarN != null) {
                gVarN.c0(this.f2740h, this.f2746n ? c.d(this.f2733a, b.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.f2735c, this.f2737e, this.f2736d, this.f2738f);
    }

    private Drawable a() {
        g gVar = new g(this.f2734b);
        gVar.N(this.f2733a.getContext());
        x.a.o(gVar, this.f2742j);
        PorterDuff.Mode mode = this.f2741i;
        if (mode != null) {
            x.a.p(gVar, mode);
        }
        gVar.d0(this.f2740h, this.f2743k);
        g gVar2 = new g(this.f2734b);
        gVar2.setTint(0);
        gVar2.c0(this.f2740h, this.f2746n ? c.d(this.f2733a, b.colorSurface) : 0);
        if (f2731t) {
            g gVar3 = new g(this.f2734b);
            this.f2745m = gVar3;
            x.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(i1.b.a(this.f2744l), J(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.f2745m);
            this.f2750r = rippleDrawable;
            return rippleDrawable;
        }
        i1.a aVar = new i1.a(this.f2734b);
        this.f2745m = aVar;
        x.a.o(aVar, i1.b.a(this.f2744l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f2745m});
        this.f2750r = layerDrawable;
        return J(layerDrawable);
    }

    private g g(boolean z2) {
        LayerDrawable layerDrawable = this.f2750r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f2731t ? (g) ((LayerDrawable) ((InsetDrawable) this.f2750r.getDrawable(0)).getDrawable()).getDrawable(!z2 ? 1 : 0) : (g) this.f2750r.getDrawable(!z2 ? 1 : 0);
    }

    private g n() {
        return g(true);
    }

    void A(ColorStateList colorStateList) {
        if (this.f2743k != colorStateList) {
            this.f2743k = colorStateList;
            I();
        }
    }

    void B(int i3) {
        if (this.f2740h != i3) {
            this.f2740h = i3;
            I();
        }
    }

    void C(ColorStateList colorStateList) {
        if (this.f2742j != colorStateList) {
            this.f2742j = colorStateList;
            if (f() != null) {
                x.a.o(f(), this.f2742j);
            }
        }
    }

    void D(PorterDuff.Mode mode) {
        if (this.f2741i != mode) {
            this.f2741i = mode;
            if (f() == null || this.f2741i == null) {
                return;
            }
            x.a.p(f(), this.f2741i);
        }
    }

    void H(int i3, int i4) {
        Drawable drawable = this.f2745m;
        if (drawable != null) {
            drawable.setBounds(this.f2735c, this.f2737e, i4 - this.f2736d, i3 - this.f2738f);
        }
    }

    int b() {
        return this.f2739g;
    }

    public int c() {
        return this.f2738f;
    }

    public int d() {
        return this.f2737e;
    }

    public n e() {
        LayerDrawable layerDrawable = this.f2750r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f2750r.getNumberOfLayers() > 2 ? (n) this.f2750r.getDrawable(2) : (n) this.f2750r.getDrawable(1);
    }

    g f() {
        return g(false);
    }

    ColorStateList h() {
        return this.f2744l;
    }

    k i() {
        return this.f2734b;
    }

    ColorStateList j() {
        return this.f2743k;
    }

    int k() {
        return this.f2740h;
    }

    ColorStateList l() {
        return this.f2742j;
    }

    PorterDuff.Mode m() {
        return this.f2741i;
    }

    boolean o() {
        return this.f2747o;
    }

    boolean p() {
        return this.f2749q;
    }

    void q(TypedArray typedArray) {
        this.f2735c = typedArray.getDimensionPixelOffset(t0.k.MaterialButton_android_insetLeft, 0);
        this.f2736d = typedArray.getDimensionPixelOffset(t0.k.MaterialButton_android_insetRight, 0);
        this.f2737e = typedArray.getDimensionPixelOffset(t0.k.MaterialButton_android_insetTop, 0);
        this.f2738f = typedArray.getDimensionPixelOffset(t0.k.MaterialButton_android_insetBottom, 0);
        int i3 = t0.k.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i3)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i3, -1);
            this.f2739g = dimensionPixelSize;
            y(this.f2734b.w(dimensionPixelSize));
            this.f2748p = true;
        }
        this.f2740h = typedArray.getDimensionPixelSize(t0.k.MaterialButton_strokeWidth, 0);
        this.f2741i = o.f(typedArray.getInt(t0.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f2742j = h1.c.a(this.f2733a.getContext(), typedArray, t0.k.MaterialButton_backgroundTint);
        this.f2743k = h1.c.a(this.f2733a.getContext(), typedArray, t0.k.MaterialButton_strokeColor);
        this.f2744l = h1.c.a(this.f2733a.getContext(), typedArray, t0.k.MaterialButton_rippleColor);
        this.f2749q = typedArray.getBoolean(t0.k.MaterialButton_android_checkable, false);
        this.f2751s = typedArray.getDimensionPixelSize(t0.k.MaterialButton_elevation, 0);
        int iG = t.G(this.f2733a);
        int paddingTop = this.f2733a.getPaddingTop();
        int iF = t.F(this.f2733a);
        int paddingBottom = this.f2733a.getPaddingBottom();
        if (typedArray.hasValue(t0.k.MaterialButton_android_background)) {
            s();
        } else {
            F();
        }
        t.y0(this.f2733a, iG + this.f2735c, paddingTop + this.f2737e, iF + this.f2736d, paddingBottom + this.f2738f);
    }

    void r(int i3) {
        if (f() != null) {
            f().setTint(i3);
        }
    }

    void s() {
        this.f2747o = true;
        this.f2733a.setSupportBackgroundTintList(this.f2742j);
        this.f2733a.setSupportBackgroundTintMode(this.f2741i);
    }

    void t(boolean z2) {
        this.f2749q = z2;
    }

    void u(int i3) {
        if (this.f2748p && this.f2739g == i3) {
            return;
        }
        this.f2739g = i3;
        this.f2748p = true;
        y(this.f2734b.w(i3));
    }

    public void v(int i3) {
        E(this.f2737e, i3);
    }

    public void w(int i3) {
        E(i3, this.f2738f);
    }

    void x(ColorStateList colorStateList) {
        if (this.f2744l != colorStateList) {
            this.f2744l = colorStateList;
            boolean z2 = f2731t;
            if (z2 && (this.f2733a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f2733a.getBackground()).setColor(i1.b.a(colorStateList));
            } else {
                if (z2 || !(this.f2733a.getBackground() instanceof i1.a)) {
                    return;
                }
                ((i1.a) this.f2733a.getBackground()).setTintList(i1.b.a(colorStateList));
            }
        }
    }

    void y(k kVar) {
        this.f2734b = kVar;
        G(kVar);
    }

    void z(boolean z2) {
        this.f2746n = z2;
        I();
    }
}
