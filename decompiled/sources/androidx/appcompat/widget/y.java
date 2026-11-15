package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: AppCompatTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u0 f842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u0 f843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u0 f844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u0 f845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u0 f846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private u0 f847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private u0 f848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a0 f849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f850j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f851k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Typeface f852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f853m;

    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    class a extends v.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f856c;

        a(int i3, int i4, WeakReference weakReference) {
            this.f854a = i3;
            this.f855b = i4;
            this.f856c = weakReference;
        }

        @Override // v.f.a
        public void d(int i3) {
        }

        @Override // v.f.a
        public void e(Typeface typeface) {
            int i3;
            if (Build.VERSION.SDK_INT >= 28 && (i3 = this.f854a) != -1) {
                typeface = Typeface.create(typeface, i3, (this.f855b & 2) != 0);
            }
            y.this.n(this.f856c, typeface);
        }
    }

    y(TextView textView) {
        this.f841a = textView;
        this.f849i = new a0(textView);
    }

    private void A(int i3, float f3) {
        this.f849i.y(i3, f3);
    }

    private void B(Context context, w0 w0Var) {
        String strO;
        this.f850j = w0Var.k(a.j.TextAppearance_android_textStyle, this.f850j);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            int iK = w0Var.k(a.j.TextAppearance_android_textFontWeight, -1);
            this.f851k = iK;
            if (iK != -1) {
                this.f850j = (this.f850j & 2) | 0;
            }
        }
        int i4 = a.j.TextAppearance_android_fontFamily;
        if (!w0Var.s(i4) && !w0Var.s(a.j.TextAppearance_fontFamily)) {
            int i5 = a.j.TextAppearance_android_typeface;
            if (w0Var.s(i5)) {
                this.f853m = false;
                int iK2 = w0Var.k(i5, 1);
                if (iK2 == 1) {
                    this.f852l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f852l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f852l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f852l = null;
        int i6 = a.j.TextAppearance_fontFamily;
        if (w0Var.s(i6)) {
            i4 = i6;
        }
        int i7 = this.f851k;
        int i8 = this.f850j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = w0Var.j(i4, this.f850j, new a(i7, i8, new WeakReference(this.f841a)));
                if (typefaceJ != null) {
                    if (i3 < 28 || this.f851k == -1) {
                        this.f852l = typefaceJ;
                    } else {
                        this.f852l = Typeface.create(Typeface.create(typefaceJ, 0), this.f851k, (this.f850j & 2) != 0);
                    }
                }
                this.f853m = this.f852l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f852l != null || (strO = w0Var.o(i4)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f851k == -1) {
            this.f852l = Typeface.create(strO, this.f850j);
        } else {
            this.f852l = Typeface.create(Typeface.create(strO, 0), this.f851k, (this.f850j & 2) != 0);
        }
    }

    private void a(Drawable drawable, u0 u0Var) {
        if (drawable == null || u0Var == null) {
            return;
        }
        j.i(drawable, u0Var, this.f841a.getDrawableState());
    }

    private static u0 d(Context context, j jVar, int i3) {
        ColorStateList colorStateListF = jVar.f(context, i3);
        if (colorStateListF == null) {
            return null;
        }
        u0 u0Var = new u0();
        u0Var.f782d = true;
        u0Var.f779a = colorStateListF;
        return u0Var;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f841a.getCompoundDrawablesRelative();
            TextView textView = this.f841a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (i3 >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f841a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f841a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f841a.getCompoundDrawables();
        TextView textView3 = this.f841a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void y() {
        u0 u0Var = this.f848h;
        this.f842b = u0Var;
        this.f843c = u0Var;
        this.f844d = u0Var;
        this.f845e = u0Var;
        this.f846f = u0Var;
        this.f847g = u0Var;
    }

    void b() {
        if (this.f842b != null || this.f843c != null || this.f844d != null || this.f845e != null) {
            Drawable[] compoundDrawables = this.f841a.getCompoundDrawables();
            a(compoundDrawables[0], this.f842b);
            a(compoundDrawables[1], this.f843c);
            a(compoundDrawables[2], this.f844d);
            a(compoundDrawables[3], this.f845e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f846f == null && this.f847g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f841a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f846f);
            a(compoundDrawablesRelative[2], this.f847g);
        }
    }

    void c() {
        this.f849i.b();
    }

    int e() {
        return this.f849i.j();
    }

    int f() {
        return this.f849i.k();
    }

    int g() {
        return this.f849i.l();
    }

    int[] h() {
        return this.f849i.m();
    }

    int i() {
        return this.f849i.n();
    }

    ColorStateList j() {
        u0 u0Var = this.f848h;
        if (u0Var != null) {
            return u0Var.f779a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        u0 u0Var = this.f848h;
        if (u0Var != null) {
            return u0Var.f780b;
        }
        return null;
    }

    boolean l() {
        return this.f849i.s();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:47:0x0104  */
    /* JADX WARN: Code duplicated, block: B:48:0x0109  */
    /* JADX WARN: Code duplicated, block: B:50:0x010c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0114  */
    /* JADX WARN: Code duplicated, block: B:53:0x0119  */
    /* JADX WARN: Code duplicated, block: B:61:0x0140  */
    /* JADX WARN: Code duplicated, block: B:80:0x0187  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a6  */
    @SuppressLint({"NewApi"})
    void m(AttributeSet attributeSet, int i3) {
        boolean zA;
        boolean z2;
        String strO;
        ColorStateList colorStateListC;
        String strO2;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        int i4;
        String strO3;
        j jVar;
        int i5;
        int i6;
        int i7;
        Context context = this.f841a.getContext();
        j jVarB = j.b();
        int[] iArr = a.j.AppCompatTextHelper;
        w0 w0VarV = w0.v(context, attributeSet, iArr, i3, 0);
        TextView textView = this.f841a;
        e0.t.k0(textView, textView.getContext(), iArr, attributeSet, w0VarV.r(), i3, 0);
        int iN = w0VarV.n(a.j.AppCompatTextHelper_android_textAppearance, -1);
        int i8 = a.j.AppCompatTextHelper_android_drawableLeft;
        if (w0VarV.s(i8)) {
            this.f842b = d(context, jVarB, w0VarV.n(i8, 0));
        }
        int i9 = a.j.AppCompatTextHelper_android_drawableTop;
        if (w0VarV.s(i9)) {
            this.f843c = d(context, jVarB, w0VarV.n(i9, 0));
        }
        int i10 = a.j.AppCompatTextHelper_android_drawableRight;
        if (w0VarV.s(i10)) {
            this.f844d = d(context, jVarB, w0VarV.n(i10, 0));
        }
        int i11 = a.j.AppCompatTextHelper_android_drawableBottom;
        if (w0VarV.s(i11)) {
            this.f845e = d(context, jVarB, w0VarV.n(i11, 0));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 17) {
            int i13 = a.j.AppCompatTextHelper_android_drawableStart;
            if (w0VarV.s(i13)) {
                this.f846f = d(context, jVarB, w0VarV.n(i13, 0));
            }
            int i14 = a.j.AppCompatTextHelper_android_drawableEnd;
            if (w0VarV.s(i14)) {
                this.f847g = d(context, jVarB, w0VarV.n(i14, 0));
            }
        }
        w0VarV.w();
        boolean z3 = this.f841a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            w0 w0VarT = w0.t(context, iN, a.j.TextAppearance);
            if (z3) {
                zA = false;
                z2 = false;
            } else {
                int i15 = a.j.TextAppearance_textAllCaps;
                if (w0VarT.s(i15)) {
                    zA = w0VarT.a(i15, false);
                    z2 = true;
                } else {
                    zA = false;
                    z2 = false;
                }
            }
            B(context, w0VarT);
            if (i12 < 23) {
                int i16 = a.j.TextAppearance_android_textColor;
                colorStateListC = w0VarT.s(i16) ? w0VarT.c(i16) : null;
                int i17 = a.j.TextAppearance_android_textColorHint;
                colorStateListC2 = w0VarT.s(i17) ? w0VarT.c(i17) : null;
                int i18 = a.j.TextAppearance_android_textColorLink;
                colorStateListC3 = w0VarT.s(i18) ? w0VarT.c(i18) : null;
                i6 = a.j.TextAppearance_textLocale;
                if (w0VarT.s(i6)) {
                    strO2 = w0VarT.o(i6);
                } else {
                    strO2 = null;
                }
                if (i12 >= 26) {
                    i7 = a.j.TextAppearance_fontVariationSettings;
                    if (w0VarT.s(i7)) {
                        strO = w0VarT.o(i7);
                    } else {
                        strO = null;
                    }
                } else {
                    strO = null;
                }
                w0VarT.w();
            } else {
                colorStateListC = null;
                colorStateListC2 = null;
            }
            i6 = a.j.TextAppearance_textLocale;
            if (w0VarT.s(i6)) {
                strO2 = w0VarT.o(i6);
            } else {
                strO2 = null;
            }
            if (i12 >= 26) {
                i7 = a.j.TextAppearance_fontVariationSettings;
                if (w0VarT.s(i7)) {
                    strO = w0VarT.o(i7);
                } else {
                    strO = null;
                }
            } else {
                strO = null;
            }
            w0VarT.w();
        } else {
            zA = false;
            z2 = false;
            strO = null;
            colorStateListC = null;
            strO2 = null;
            colorStateListC2 = null;
            colorStateListC3 = null;
        }
        w0 w0VarV2 = w0.v(context, attributeSet, a.j.TextAppearance, i3, 0);
        if (z3) {
            i4 = 23;
        } else {
            int i19 = a.j.TextAppearance_textAllCaps;
            if (w0VarV2.s(i19)) {
                zA = w0VarV2.a(i19, false);
                i4 = 23;
                z2 = true;
            } else {
                i4 = 23;
            }
        }
        if (i12 < i4) {
            int i20 = a.j.TextAppearance_android_textColor;
            if (w0VarV2.s(i20)) {
                colorStateListC = w0VarV2.c(i20);
            }
            int i21 = a.j.TextAppearance_android_textColorHint;
            if (w0VarV2.s(i21)) {
                colorStateListC2 = w0VarV2.c(i21);
            }
            int i22 = a.j.TextAppearance_android_textColorLink;
            if (w0VarV2.s(i22)) {
                colorStateListC3 = w0VarV2.c(i22);
            }
        }
        int i23 = a.j.TextAppearance_textLocale;
        if (w0VarV2.s(i23)) {
            strO2 = w0VarV2.o(i23);
        }
        if (i12 >= 26) {
            int i24 = a.j.TextAppearance_fontVariationSettings;
            if (w0VarV2.s(i24)) {
                strO3 = w0VarV2.o(i24);
            } else {
                strO3 = strO;
            }
        } else {
            strO3 = strO;
        }
        if (i12 >= 28) {
            int i25 = a.j.TextAppearance_android_textSize;
            if (w0VarV2.s(i25)) {
                jVar = jVarB;
                if (w0VarV2.f(i25, -1) == 0) {
                    this.f841a.setTextSize(0, 0.0f);
                }
            } else {
                jVar = jVarB;
            }
        } else {
            jVar = jVarB;
        }
        B(context, w0VarV2);
        w0VarV2.w();
        if (colorStateListC != null) {
            this.f841a.setTextColor(colorStateListC);
        }
        if (colorStateListC2 != null) {
            this.f841a.setHintTextColor(colorStateListC2);
        }
        if (colorStateListC3 != null) {
            this.f841a.setLinkTextColor(colorStateListC3);
        }
        if (!z3 && z2) {
            r(zA);
        }
        Typeface typeface = this.f852l;
        if (typeface != null) {
            if (this.f851k == -1) {
                this.f841a.setTypeface(typeface, this.f850j);
            } else {
                this.f841a.setTypeface(typeface);
            }
        }
        if (strO3 != null) {
            this.f841a.setFontVariationSettings(strO3);
        }
        if (strO2 != null) {
            if (i12 >= 24) {
                this.f841a.setTextLocales(LocaleList.forLanguageTags(strO2));
            } else if (i12 >= 21) {
                this.f841a.setTextLocale(Locale.forLanguageTag(strO2.substring(0, strO2.indexOf(44))));
            }
        }
        this.f849i.t(attributeSet, i3);
        if (androidx.core.widget.b.f1209a && this.f849i.n() != 0) {
            int[] iArrM = this.f849i.m();
            if (iArrM.length > 0) {
                if (this.f841a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f841a.setAutoSizeTextTypeUniformWithConfiguration(this.f849i.k(), this.f849i.j(), this.f849i.l(), 0);
                } else {
                    this.f841a.setAutoSizeTextTypeUniformWithPresetSizes(iArrM, 0);
                }
            }
        }
        w0 w0VarU = w0.u(context, attributeSet, a.j.AppCompatTextView);
        int iN2 = w0VarU.n(a.j.AppCompatTextView_drawableLeftCompat, -1);
        j jVar2 = jVar;
        Drawable drawableC = iN2 != -1 ? jVar2.c(context, iN2) : null;
        int iN3 = w0VarU.n(a.j.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableC2 = iN3 != -1 ? jVar2.c(context, iN3) : null;
        int iN4 = w0VarU.n(a.j.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableC3 = iN4 != -1 ? jVar2.c(context, iN4) : null;
        int iN5 = w0VarU.n(a.j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableC4 = iN5 != -1 ? jVar2.c(context, iN5) : null;
        int iN6 = w0VarU.n(a.j.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableC5 = iN6 != -1 ? jVar2.c(context, iN6) : null;
        int iN7 = w0VarU.n(a.j.AppCompatTextView_drawableEndCompat, -1);
        x(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? jVar2.c(context, iN7) : null);
        int i26 = a.j.AppCompatTextView_drawableTint;
        if (w0VarU.s(i26)) {
            androidx.core.widget.i.g(this.f841a, w0VarU.c(i26));
        }
        int i27 = a.j.AppCompatTextView_drawableTintMode;
        if (w0VarU.s(i27)) {
            i5 = -1;
            androidx.core.widget.i.h(this.f841a, e0.e(w0VarU.k(i27, -1), null));
        } else {
            i5 = -1;
        }
        int iF = w0VarU.f(a.j.AppCompatTextView_firstBaselineToTopHeight, i5);
        int iF2 = w0VarU.f(a.j.AppCompatTextView_lastBaselineToBottomHeight, i5);
        int iF3 = w0VarU.f(a.j.AppCompatTextView_lineHeight, i5);
        w0VarU.w();
        if (iF != i5) {
            androidx.core.widget.i.j(this.f841a, iF);
        }
        if (iF2 != i5) {
            androidx.core.widget.i.k(this.f841a, iF2);
        }
        if (iF3 != i5) {
            androidx.core.widget.i.l(this.f841a, iF3);
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f853m) {
            this.f852l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f850j);
            }
        }
    }

    void o(boolean z2, int i3, int i4, int i5, int i6) {
        if (androidx.core.widget.b.f1209a) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i3) {
        String strO;
        ColorStateList colorStateListC;
        w0 w0VarT = w0.t(context, i3, a.j.TextAppearance);
        int i4 = a.j.TextAppearance_textAllCaps;
        if (w0VarT.s(i4)) {
            r(w0VarT.a(i4, false));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 23) {
            int i6 = a.j.TextAppearance_android_textColor;
            if (w0VarT.s(i6) && (colorStateListC = w0VarT.c(i6)) != null) {
                this.f841a.setTextColor(colorStateListC);
            }
        }
        int i7 = a.j.TextAppearance_android_textSize;
        if (w0VarT.s(i7) && w0VarT.f(i7, -1) == 0) {
            this.f841a.setTextSize(0, 0.0f);
        }
        B(context, w0VarT);
        if (i5 >= 26) {
            int i8 = a.j.TextAppearance_fontVariationSettings;
            if (w0VarT.s(i8) && (strO = w0VarT.o(i8)) != null) {
                this.f841a.setFontVariationSettings(strO);
            }
        }
        w0VarT.w();
        Typeface typeface = this.f852l;
        if (typeface != null) {
            this.f841a.setTypeface(typeface, this.f850j);
        }
    }

    void r(boolean z2) {
        this.f841a.setAllCaps(z2);
    }

    void s(int i3, int i4, int i5, int i6) throws IllegalArgumentException {
        this.f849i.u(i3, i4, i5, i6);
    }

    void t(int[] iArr, int i3) throws IllegalArgumentException {
        this.f849i.v(iArr, i3);
    }

    void u(int i3) {
        this.f849i.w(i3);
    }

    void v(ColorStateList colorStateList) {
        if (this.f848h == null) {
            this.f848h = new u0();
        }
        u0 u0Var = this.f848h;
        u0Var.f779a = colorStateList;
        u0Var.f782d = colorStateList != null;
        y();
    }

    void w(PorterDuff.Mode mode) {
        if (this.f848h == null) {
            this.f848h = new u0();
        }
        u0 u0Var = this.f848h;
        u0Var.f780b = mode;
        u0Var.f781c = mode != null;
        y();
    }

    void z(int i3, float f3) {
        if (androidx.core.widget.b.f1209a || l()) {
            return;
        }
        A(i3, f3);
    }
}
