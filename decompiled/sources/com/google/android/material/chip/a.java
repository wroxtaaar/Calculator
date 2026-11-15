package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.internal.k;
import com.google.android.material.internal.m;
import com.google.android.material.internal.o;
import com.vivo.seckeysdk.BuildConfig;
import h1.c;
import h1.d;
import i1.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import k1.g;
import u0.h;

/* JADX INFO: compiled from: ChipDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends g implements Drawable.Callback, k.b {
    private static final int[] K0 = {R.attr.state_enabled};
    private static final ShapeDrawable L0 = new ShapeDrawable(new OvalShape());
    private ColorStateList A;
    private ColorStateList A0;
    private ColorStateList B;
    private PorterDuff.Mode B0;
    private float C;
    private int[] C0;
    private float D;
    private boolean D0;
    private ColorStateList E;
    private ColorStateList E0;
    private float F;
    private WeakReference<InterfaceC0036a> F0;
    private ColorStateList G;
    private TextUtils.TruncateAt G0;
    private CharSequence H;
    private boolean H0;
    private boolean I;
    private int I0;
    private Drawable J;
    private boolean J0;
    private ColorStateList K;
    private float L;
    private boolean M;
    private boolean N;
    private Drawable O;
    private Drawable P;
    private ColorStateList Q;
    private float R;
    private CharSequence S;
    private boolean T;
    private boolean U;
    private Drawable V;
    private ColorStateList W;
    private h X;
    private h Y;
    private float Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f2798a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f2799b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f2800c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f2801d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f2802e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f2803f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private float f2804g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Context f2805h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Paint f2806i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final Paint f2807j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final Paint.FontMetrics f2808k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final RectF f2809l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final PointF f2810m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Path f2811n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final k f2812o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f2813p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f2814q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f2815r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f2816s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f2817t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f2818u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f2819v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private int f2820w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f2821x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private ColorFilter f2822y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private PorterDuffColorFilter f2823z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChipDrawable.java */
    public interface InterfaceC0036a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.D = -1.0f;
        this.f2806i0 = new Paint(1);
        this.f2808k0 = new Paint.FontMetrics();
        this.f2809l0 = new RectF();
        this.f2810m0 = new PointF();
        this.f2811n0 = new Path();
        this.f2821x0 = 255;
        this.B0 = PorterDuff.Mode.SRC_IN;
        this.F0 = new WeakReference<>(null);
        N(context);
        this.f2805h0 = context;
        k kVar = new k(this);
        this.f2812o0 = kVar;
        this.H = BuildConfig.FLAVOR;
        kVar.e().density = context.getResources().getDisplayMetrics().density;
        this.f2807j0 = null;
        int[] iArr = K0;
        setState(iArr);
        k2(iArr);
        this.H0 = true;
        if (b.f4887a) {
            L0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (N2()) {
            n0(rect, this.f2809l0);
            RectF rectF = this.f2809l0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.O.setBounds(0, 0, (int) this.f2809l0.width(), (int) this.f2809l0.height());
            if (b.f4887a) {
                this.P.setBounds(this.O.getBounds());
                this.P.jumpToCurrentState();
                this.P.draw(canvas);
            } else {
                this.O.draw(canvas);
            }
            canvas.translate(-f3, -f4);
        }
    }

    private void B0(Canvas canvas, Rect rect) {
        this.f2806i0.setColor(this.f2817t0);
        this.f2806i0.setStyle(Paint.Style.FILL);
        this.f2809l0.set(rect);
        if (!this.J0) {
            canvas.drawRoundRect(this.f2809l0, H0(), H0(), this.f2806i0);
        } else {
            h(new RectF(rect), this.f2811n0);
            super.p(canvas, this.f2806i0, this.f2811n0, u());
        }
    }

    private void C0(Canvas canvas, Rect rect) {
        Paint paint = this.f2807j0;
        if (paint != null) {
            paint.setColor(w.a.h(-16777216, 127));
            canvas.drawRect(rect, this.f2807j0);
            if (M2() || L2()) {
                k0(rect, this.f2809l0);
                canvas.drawRect(this.f2809l0, this.f2807j0);
            }
            if (this.H != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f2807j0);
            }
            if (N2()) {
                n0(rect, this.f2809l0);
                canvas.drawRect(this.f2809l0, this.f2807j0);
            }
            this.f2807j0.setColor(w.a.h(-65536, 127));
            m0(rect, this.f2809l0);
            canvas.drawRect(this.f2809l0, this.f2807j0);
            this.f2807j0.setColor(w.a.h(-16711936, 127));
            o0(rect, this.f2809l0);
            canvas.drawRect(this.f2809l0, this.f2807j0);
        }
    }

    private void D0(Canvas canvas, Rect rect) {
        if (this.H != null) {
            Paint.Align alignS0 = s0(rect, this.f2810m0);
            q0(rect, this.f2809l0);
            if (this.f2812o0.d() != null) {
                this.f2812o0.e().drawableState = getState();
                this.f2812o0.j(this.f2805h0);
            }
            this.f2812o0.e().setTextAlign(alignS0);
            int iSave = 0;
            boolean z2 = Math.round(this.f2812o0.f(g1().toString())) > Math.round(this.f2809l0.width());
            if (z2) {
                iSave = canvas.save();
                canvas.clipRect(this.f2809l0);
            }
            CharSequence charSequenceEllipsize = this.H;
            if (z2 && this.G0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f2812o0.e(), this.f2809l0.width(), this.G0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f2810m0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f2812o0.e());
            if (z2) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean L2() {
        return this.U && this.V != null && this.f2819v0;
    }

    private boolean M2() {
        return this.I && this.J != null;
    }

    private boolean N2() {
        return this.N && this.O != null;
    }

    private void O2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void P2() {
        this.E0 = this.D0 ? b.a(this.G) : null;
    }

    @TargetApi(21)
    private void Q2() {
        this.P = new RippleDrawable(b.a(e1()), this.O, L0);
    }

    private float Y0() {
        Drawable drawable = this.f2819v0 ? this.V : this.J;
        float f3 = this.L;
        if (f3 > 0.0f || drawable == null) {
            return f3;
        }
        float fCeil = (float) Math.ceil(o.b(this.f2805h0, 24));
        return ((float) drawable.getIntrinsicHeight()) <= fCeil ? drawable.getIntrinsicHeight() : fCeil;
    }

    private float Z0() {
        Drawable drawable = this.f2819v0 ? this.V : this.J;
        float f3 = this.L;
        return (f3 > 0.0f || drawable == null) ? f3 : drawable.getIntrinsicWidth();
    }

    private void a2(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    private void j0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        x.a.m(drawable, x.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.O) {
            if (drawable.isStateful()) {
                drawable.setState(V0());
            }
            x.a.o(drawable, this.Q);
            return;
        }
        Drawable drawable2 = this.J;
        if (drawable == drawable2 && this.M) {
            x.a.o(drawable2, this.K);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void k0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (M2() || L2()) {
            float f3 = this.Z + this.f2798a0;
            float fZ0 = Z0();
            if (x.a.f(this) == 0) {
                float f4 = rect.left + f3;
                rectF.left = f4;
                rectF.right = f4 + fZ0;
            } else {
                float f5 = rect.right - f3;
                rectF.right = f5;
                rectF.left = f5 - fZ0;
            }
            float fY0 = Y0();
            float fExactCenterY = rect.exactCenterY() - (fY0 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fY0;
        }
    }

    private ColorFilter k1() {
        ColorFilter colorFilter = this.f2822y0;
        return colorFilter != null ? colorFilter : this.f2823z0;
    }

    private void m0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (N2()) {
            float f3 = this.f2804g0 + this.f2803f0 + this.R + this.f2802e0 + this.f2801d0;
            if (x.a.f(this) == 0) {
                rectF.right = rect.right - f3;
            } else {
                rectF.left = rect.left + f3;
            }
        }
    }

    private static boolean m1(int[] iArr, int i3) {
        if (iArr == null) {
            return false;
        }
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    private void n0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (N2()) {
            float f3 = this.f2804g0 + this.f2803f0;
            if (x.a.f(this) == 0) {
                float f4 = rect.right - f3;
                rectF.right = f4;
                rectF.left = f4 - this.R;
            } else {
                float f5 = rect.left + f3;
                rectF.left = f5;
                rectF.right = f5 + this.R;
            }
            float fExactCenterY = rect.exactCenterY();
            float f6 = this.R;
            float f7 = fExactCenterY - (f6 / 2.0f);
            rectF.top = f7;
            rectF.bottom = f7 + f6;
        }
    }

    private void o0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (N2()) {
            float f3 = this.f2804g0 + this.f2803f0 + this.R + this.f2802e0 + this.f2801d0;
            if (x.a.f(this) == 0) {
                float f4 = rect.right;
                rectF.right = f4;
                rectF.left = f4 - f3;
            } else {
                int i3 = rect.left;
                rectF.left = i3;
                rectF.right = i3 + f3;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void q0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.H != null) {
            float fL0 = this.Z + l0() + this.f2800c0;
            float fP0 = this.f2804g0 + p0() + this.f2801d0;
            if (x.a.f(this) == 0) {
                rectF.left = rect.left + fL0;
                rectF.right = rect.right - fP0;
            } else {
                rectF.left = rect.left + fP0;
                rectF.right = rect.right - fL0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean q1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float r0() {
        this.f2812o0.e().getFontMetrics(this.f2808k0);
        Paint.FontMetrics fontMetrics = this.f2808k0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean r1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean s1(d dVar) {
        return (dVar == null || dVar.i() == null || !dVar.i().isStateful()) ? false : true;
    }

    private boolean t0() {
        return this.U && this.V != null && this.T;
    }

    private void t1(AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayH = m.h(this.f2805h0, attributeSet, t0.k.Chip, i3, i4, new int[0]);
        this.J0 = typedArrayH.hasValue(t0.k.Chip_shapeAppearance);
        a2(c.a(this.f2805h0, typedArrayH, t0.k.Chip_chipSurfaceColor));
        E1(c.a(this.f2805h0, typedArrayH, t0.k.Chip_chipBackgroundColor));
        S1(typedArrayH.getDimension(t0.k.Chip_chipMinHeight, 0.0f));
        int i5 = t0.k.Chip_chipCornerRadius;
        if (typedArrayH.hasValue(i5)) {
            G1(typedArrayH.getDimension(i5, 0.0f));
        }
        W1(c.a(this.f2805h0, typedArrayH, t0.k.Chip_chipStrokeColor));
        Y1(typedArrayH.getDimension(t0.k.Chip_chipStrokeWidth, 0.0f));
        x2(c.a(this.f2805h0, typedArrayH, t0.k.Chip_rippleColor));
        C2(typedArrayH.getText(t0.k.Chip_android_text));
        d dVarF = c.f(this.f2805h0, typedArrayH, t0.k.Chip_android_textAppearance);
        dVarF.l(typedArrayH.getDimension(t0.k.Chip_android_textSize, dVarF.j()));
        if (Build.VERSION.SDK_INT < 23) {
            dVarF.k(c.a(this.f2805h0, typedArrayH, t0.k.Chip_android_textColor));
        }
        D2(dVarF);
        int i6 = typedArrayH.getInt(t0.k.Chip_android_ellipsize, 0);
        if (i6 == 1) {
            p2(TextUtils.TruncateAt.START);
        } else if (i6 == 2) {
            p2(TextUtils.TruncateAt.MIDDLE);
        } else if (i6 == 3) {
            p2(TextUtils.TruncateAt.END);
        }
        R1(typedArrayH.getBoolean(t0.k.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            R1(typedArrayH.getBoolean(t0.k.Chip_chipIconEnabled, false));
        }
        K1(c.d(this.f2805h0, typedArrayH, t0.k.Chip_chipIcon));
        int i7 = t0.k.Chip_chipIconTint;
        if (typedArrayH.hasValue(i7)) {
            O1(c.a(this.f2805h0, typedArrayH, i7));
        }
        M1(typedArrayH.getDimension(t0.k.Chip_chipIconSize, -1.0f));
        n2(typedArrayH.getBoolean(t0.k.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            n2(typedArrayH.getBoolean(t0.k.Chip_closeIconEnabled, false));
        }
        b2(c.d(this.f2805h0, typedArrayH, t0.k.Chip_closeIcon));
        l2(c.a(this.f2805h0, typedArrayH, t0.k.Chip_closeIconTint));
        g2(typedArrayH.getDimension(t0.k.Chip_closeIconSize, 0.0f));
        w1(typedArrayH.getBoolean(t0.k.Chip_android_checkable, false));
        D1(typedArrayH.getBoolean(t0.k.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            D1(typedArrayH.getBoolean(t0.k.Chip_checkedIconEnabled, false));
        }
        y1(c.d(this.f2805h0, typedArrayH, t0.k.Chip_checkedIcon));
        int i8 = t0.k.Chip_checkedIconTint;
        if (typedArrayH.hasValue(i8)) {
            A1(c.a(this.f2805h0, typedArrayH, i8));
        }
        A2(h.b(this.f2805h0, typedArrayH, t0.k.Chip_showMotionSpec));
        q2(h.b(this.f2805h0, typedArrayH, t0.k.Chip_hideMotionSpec));
        U1(typedArrayH.getDimension(t0.k.Chip_chipStartPadding, 0.0f));
        u2(typedArrayH.getDimension(t0.k.Chip_iconStartPadding, 0.0f));
        s2(typedArrayH.getDimension(t0.k.Chip_iconEndPadding, 0.0f));
        H2(typedArrayH.getDimension(t0.k.Chip_textStartPadding, 0.0f));
        F2(typedArrayH.getDimension(t0.k.Chip_textEndPadding, 0.0f));
        i2(typedArrayH.getDimension(t0.k.Chip_closeIconStartPadding, 0.0f));
        d2(typedArrayH.getDimension(t0.k.Chip_closeIconEndPadding, 0.0f));
        I1(typedArrayH.getDimension(t0.k.Chip_chipEndPadding, 0.0f));
        w2(typedArrayH.getDimensionPixelSize(t0.k.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayH.recycle();
    }

    public static a u0(Context context, AttributeSet attributeSet, int i3, int i4) {
        a aVar = new a(context, attributeSet, i3, i4);
        aVar.t1(attributeSet, i3, i4);
        return aVar;
    }

    private void v0(Canvas canvas, Rect rect) {
        if (L2()) {
            k0(rect, this.f2809l0);
            RectF rectF = this.f2809l0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.V.setBounds(0, 0, (int) this.f2809l0.width(), (int) this.f2809l0.height());
            this.V.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private boolean v1(int[] iArr, int[] iArr2) {
        boolean z2;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.A;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f2813p0) : 0);
        boolean state = true;
        if (this.f2813p0 != iL) {
            this.f2813p0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.B;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f2814q0) : 0);
        if (this.f2814q0 != iL2) {
            this.f2814q0 = iL2;
            zOnStateChange = true;
        }
        int iG = z0.c.g(iL, iL2);
        if ((this.f2815r0 != iG) | (x() == null)) {
            this.f2815r0 = iG;
            X(ColorStateList.valueOf(iG));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.E;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f2816s0) : 0;
        if (this.f2816s0 != colorForState) {
            this.f2816s0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.E0 == null || !b.b(iArr)) ? 0 : this.E0.getColorForState(iArr, this.f2817t0);
        if (this.f2817t0 != colorForState2) {
            this.f2817t0 = colorForState2;
            if (this.D0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f2812o0.d() == null || this.f2812o0.d().i() == null) ? 0 : this.f2812o0.d().i().getColorForState(iArr, this.f2818u0);
        if (this.f2818u0 != colorForState3) {
            this.f2818u0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z3 = m1(getState(), R.attr.state_checked) && this.T;
        if (this.f2819v0 == z3 || this.V == null) {
            z2 = false;
        } else {
            float fL0 = l0();
            this.f2819v0 = z3;
            if (fL0 != l0()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.A0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f2820w0) : 0;
        if (this.f2820w0 != colorForState4) {
            this.f2820w0 = colorForState4;
            this.f2823z0 = b1.a.a(this, this.A0, this.B0);
        } else {
            state = zOnStateChange;
        }
        if (r1(this.J)) {
            state |= this.J.setState(iArr);
        }
        if (r1(this.V)) {
            state |= this.V.setState(iArr);
        }
        if (r1(this.O)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.O.setState(iArr3);
        }
        if (b.f4887a && r1(this.P)) {
            state |= this.P.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            u1();
        }
        return state;
    }

    private void w0(Canvas canvas, Rect rect) {
        if (this.J0) {
            return;
        }
        this.f2806i0.setColor(this.f2814q0);
        this.f2806i0.setStyle(Paint.Style.FILL);
        this.f2806i0.setColorFilter(k1());
        this.f2809l0.set(rect);
        canvas.drawRoundRect(this.f2809l0, H0(), H0(), this.f2806i0);
    }

    private void x0(Canvas canvas, Rect rect) {
        if (M2()) {
            k0(rect, this.f2809l0);
            RectF rectF = this.f2809l0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.J.setBounds(0, 0, (int) this.f2809l0.width(), (int) this.f2809l0.height());
            this.J.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private void y0(Canvas canvas, Rect rect) {
        if (this.F <= 0.0f || this.J0) {
            return;
        }
        this.f2806i0.setColor(this.f2816s0);
        this.f2806i0.setStyle(Paint.Style.STROKE);
        if (!this.J0) {
            this.f2806i0.setColorFilter(k1());
        }
        RectF rectF = this.f2809l0;
        float f3 = rect.left;
        float f4 = this.F;
        rectF.set(f3 + (f4 / 2.0f), rect.top + (f4 / 2.0f), rect.right - (f4 / 2.0f), rect.bottom - (f4 / 2.0f));
        float f5 = this.D - (this.F / 2.0f);
        canvas.drawRoundRect(this.f2809l0, f5, f5, this.f2806i0);
    }

    private void z0(Canvas canvas, Rect rect) {
        if (this.J0) {
            return;
        }
        this.f2806i0.setColor(this.f2813p0);
        this.f2806i0.setStyle(Paint.Style.FILL);
        this.f2809l0.set(rect);
        canvas.drawRoundRect(this.f2809l0, H0(), H0(), this.f2806i0);
    }

    public void A1(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            if (t0()) {
                x.a.o(this.V, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void A2(h hVar) {
        this.X = hVar;
    }

    public void B1(int i3) {
        A1(c.a.c(this.f2805h0, i3));
    }

    public void B2(int i3) {
        A2(h.c(this.f2805h0, i3));
    }

    public void C1(int i3) {
        D1(this.f2805h0.getResources().getBoolean(i3));
    }

    public void C2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        if (TextUtils.equals(this.H, charSequence)) {
            return;
        }
        this.H = charSequence;
        this.f2812o0.i(true);
        invalidateSelf();
        u1();
    }

    public void D1(boolean z2) {
        if (this.U != z2) {
            boolean zL2 = L2();
            this.U = z2;
            boolean zL3 = L2();
            if (zL2 != zL3) {
                if (zL3) {
                    j0(this.V);
                } else {
                    O2(this.V);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public void D2(d dVar) {
        this.f2812o0.h(dVar, this.f2805h0);
    }

    public Drawable E0() {
        return this.V;
    }

    public void E1(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            onStateChange(getState());
        }
    }

    public void E2(int i3) {
        D2(new d(this.f2805h0, i3));
    }

    public ColorStateList F0() {
        return this.W;
    }

    public void F1(int i3) {
        E1(c.a.c(this.f2805h0, i3));
    }

    public void F2(float f3) {
        if (this.f2801d0 != f3) {
            this.f2801d0 = f3;
            invalidateSelf();
            u1();
        }
    }

    public ColorStateList G0() {
        return this.B;
    }

    @Deprecated
    public void G1(float f3) {
        if (this.D != f3) {
            this.D = f3;
            setShapeAppearanceModel(D().w(f3));
        }
    }

    public void G2(int i3) {
        F2(this.f2805h0.getResources().getDimension(i3));
    }

    public float H0() {
        return this.J0 ? G() : this.D;
    }

    @Deprecated
    public void H1(int i3) {
        G1(this.f2805h0.getResources().getDimension(i3));
    }

    public void H2(float f3) {
        if (this.f2800c0 != f3) {
            this.f2800c0 = f3;
            invalidateSelf();
            u1();
        }
    }

    public float I0() {
        return this.f2804g0;
    }

    public void I1(float f3) {
        if (this.f2804g0 != f3) {
            this.f2804g0 = f3;
            invalidateSelf();
            u1();
        }
    }

    public void I2(int i3) {
        H2(this.f2805h0.getResources().getDimension(i3));
    }

    public Drawable J0() {
        Drawable drawable = this.J;
        if (drawable != null) {
            return x.a.q(drawable);
        }
        return null;
    }

    public void J1(int i3) {
        I1(this.f2805h0.getResources().getDimension(i3));
    }

    public void J2(boolean z2) {
        if (this.D0 != z2) {
            this.D0 = z2;
            P2();
            onStateChange(getState());
        }
    }

    public float K0() {
        return this.L;
    }

    public void K1(Drawable drawable) {
        Drawable drawableJ0 = J0();
        if (drawableJ0 != drawable) {
            float fL0 = l0();
            this.J = drawable != null ? x.a.r(drawable).mutate() : null;
            float fL1 = l0();
            O2(drawableJ0);
            if (M2()) {
                j0(this.J);
            }
            invalidateSelf();
            if (fL0 != fL1) {
                u1();
            }
        }
    }

    boolean K2() {
        return this.H0;
    }

    public ColorStateList L0() {
        return this.K;
    }

    public void L1(int i3) {
        K1(c.a.d(this.f2805h0, i3));
    }

    public float M0() {
        return this.C;
    }

    public void M1(float f3) {
        if (this.L != f3) {
            float fL0 = l0();
            this.L = f3;
            float fL1 = l0();
            invalidateSelf();
            if (fL0 != fL1) {
                u1();
            }
        }
    }

    public float N0() {
        return this.Z;
    }

    public void N1(int i3) {
        M1(this.f2805h0.getResources().getDimension(i3));
    }

    public ColorStateList O0() {
        return this.E;
    }

    public void O1(ColorStateList colorStateList) {
        this.M = true;
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (M2()) {
                x.a.o(this.J, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float P0() {
        return this.F;
    }

    public void P1(int i3) {
        O1(c.a.c(this.f2805h0, i3));
    }

    public Drawable Q0() {
        Drawable drawable = this.O;
        if (drawable != null) {
            return x.a.q(drawable);
        }
        return null;
    }

    public void Q1(int i3) {
        R1(this.f2805h0.getResources().getBoolean(i3));
    }

    public CharSequence R0() {
        return this.S;
    }

    public void R1(boolean z2) {
        if (this.I != z2) {
            boolean zM2 = M2();
            this.I = z2;
            boolean zM3 = M2();
            if (zM2 != zM3) {
                if (zM3) {
                    j0(this.J);
                } else {
                    O2(this.J);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public float S0() {
        return this.f2803f0;
    }

    public void S1(float f3) {
        if (this.C != f3) {
            this.C = f3;
            invalidateSelf();
            u1();
        }
    }

    public float T0() {
        return this.R;
    }

    public void T1(int i3) {
        S1(this.f2805h0.getResources().getDimension(i3));
    }

    public float U0() {
        return this.f2802e0;
    }

    public void U1(float f3) {
        if (this.Z != f3) {
            this.Z = f3;
            invalidateSelf();
            u1();
        }
    }

    public int[] V0() {
        return this.C0;
    }

    public void V1(int i3) {
        U1(this.f2805h0.getResources().getDimension(i3));
    }

    public ColorStateList W0() {
        return this.Q;
    }

    public void W1(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            if (this.J0) {
                e0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void X0(RectF rectF) {
        o0(getBounds(), rectF);
    }

    public void X1(int i3) {
        W1(c.a.c(this.f2805h0, i3));
    }

    public void Y1(float f3) {
        if (this.F != f3) {
            this.F = f3;
            this.f2806i0.setStrokeWidth(f3);
            if (this.J0) {
                super.f0(f3);
            }
            invalidateSelf();
        }
    }

    public void Z1(int i3) {
        Y1(this.f2805h0.getResources().getDimension(i3));
    }

    @Override // com.google.android.material.internal.k.b
    public void a() {
        u1();
        invalidateSelf();
    }

    public TextUtils.TruncateAt a1() {
        return this.G0;
    }

    public h b1() {
        return this.Y;
    }

    public void b2(Drawable drawable) {
        Drawable drawableQ0 = Q0();
        if (drawableQ0 != drawable) {
            float fP0 = p0();
            this.O = drawable != null ? x.a.r(drawable).mutate() : null;
            if (b.f4887a) {
                Q2();
            }
            float fP1 = p0();
            O2(drawableQ0);
            if (N2()) {
                j0(this.O);
            }
            invalidateSelf();
            if (fP0 != fP1) {
                u1();
            }
        }
    }

    public float c1() {
        return this.f2799b0;
    }

    public void c2(CharSequence charSequence) {
        if (this.S != charSequence) {
            this.S = c0.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float d1() {
        return this.f2798a0;
    }

    public void d2(float f3) {
        if (this.f2803f0 != f3) {
            this.f2803f0 = f3;
            invalidateSelf();
            if (N2()) {
                u1();
            }
        }
    }

    @Override // k1.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i3 = this.f2821x0;
        int iA = i3 < 255 ? v0.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i3) : 0;
        z0(canvas, bounds);
        w0(canvas, bounds);
        if (this.J0) {
            super.draw(canvas);
        }
        y0(canvas, bounds);
        B0(canvas, bounds);
        x0(canvas, bounds);
        v0(canvas, bounds);
        if (this.H0) {
            D0(canvas, bounds);
        }
        A0(canvas, bounds);
        C0(canvas, bounds);
        if (this.f2821x0 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public ColorStateList e1() {
        return this.G;
    }

    public void e2(int i3) {
        d2(this.f2805h0.getResources().getDimension(i3));
    }

    public h f1() {
        return this.X;
    }

    public void f2(int i3) {
        b2(c.a.d(this.f2805h0, i3));
    }

    public CharSequence g1() {
        return this.H;
    }

    public void g2(float f3) {
        if (this.R != f3) {
            this.R = f3;
            invalidateSelf();
            if (N2()) {
                u1();
            }
        }
    }

    @Override // k1.g, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2821x0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f2822y0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Z + l0() + this.f2800c0 + this.f2812o0.f(g1().toString()) + this.f2801d0 + p0() + this.f2804g0), this.I0);
    }

    @Override // k1.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // k1.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.J0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.D);
        } else {
            outline.setRoundRect(bounds, this.D);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public d h1() {
        return this.f2812o0.d();
    }

    public void h2(int i3) {
        g2(this.f2805h0.getResources().getDimension(i3));
    }

    public float i1() {
        return this.f2801d0;
    }

    public void i2(float f3) {
        if (this.f2802e0 != f3) {
            this.f2802e0 = f3;
            invalidateSelf();
            if (N2()) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // k1.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return q1(this.A) || q1(this.B) || q1(this.E) || (this.D0 && q1(this.E0)) || s1(this.f2812o0.d()) || t0() || r1(this.J) || r1(this.V) || q1(this.A0);
    }

    public float j1() {
        return this.f2800c0;
    }

    public void j2(int i3) {
        i2(this.f2805h0.getResources().getDimension(i3));
    }

    public boolean k2(int[] iArr) {
        if (Arrays.equals(this.C0, iArr)) {
            return false;
        }
        this.C0 = iArr;
        if (N2()) {
            return v1(getState(), iArr);
        }
        return false;
    }

    float l0() {
        if (M2() || L2()) {
            return this.f2798a0 + Z0() + this.f2799b0;
        }
        return 0.0f;
    }

    public boolean l1() {
        return this.D0;
    }

    public void l2(ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            if (N2()) {
                x.a.o(this.O, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void m2(int i3) {
        l2(c.a.c(this.f2805h0, i3));
    }

    public boolean n1() {
        return this.T;
    }

    public void n2(boolean z2) {
        if (this.N != z2) {
            boolean zN2 = N2();
            this.N = z2;
            boolean zN3 = N2();
            if (zN2 != zN3) {
                if (zN3) {
                    j0(this.O);
                } else {
                    O2(this.O);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public boolean o1() {
        return r1(this.O);
    }

    public void o2(InterfaceC0036a interfaceC0036a) {
        this.F0 = new WeakReference<>(interfaceC0036a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i3);
        if (M2()) {
            zOnLayoutDirectionChanged |= x.a.m(this.J, i3);
        }
        if (L2()) {
            zOnLayoutDirectionChanged |= x.a.m(this.V, i3);
        }
        if (N2()) {
            zOnLayoutDirectionChanged |= x.a.m(this.O, i3);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        boolean zOnLevelChange = super.onLevelChange(i3);
        if (M2()) {
            zOnLevelChange |= this.J.setLevel(i3);
        }
        if (L2()) {
            zOnLevelChange |= this.V.setLevel(i3);
        }
        if (N2()) {
            zOnLevelChange |= this.O.setLevel(i3);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // k1.g, android.graphics.drawable.Drawable, com.google.android.material.internal.k.b
    public boolean onStateChange(int[] iArr) {
        if (this.J0) {
            super.onStateChange(iArr);
        }
        return v1(iArr, V0());
    }

    float p0() {
        if (N2()) {
            return this.f2802e0 + this.R + this.f2803f0;
        }
        return 0.0f;
    }

    public boolean p1() {
        return this.N;
    }

    public void p2(TextUtils.TruncateAt truncateAt) {
        this.G0 = truncateAt;
    }

    public void q2(h hVar) {
        this.Y = hVar;
    }

    public void r2(int i3) {
        q2(h.c(this.f2805h0, i3));
    }

    Paint.Align s0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.H != null) {
            float fL0 = this.Z + l0() + this.f2800c0;
            if (x.a.f(this) == 0) {
                pointF.x = rect.left + fL0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fL0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - r0();
        }
        return align;
    }

    public void s2(float f3) {
        if (this.f2799b0 != f3) {
            float fL0 = l0();
            this.f2799b0 = f3;
            float fL1 = l0();
            invalidateSelf();
            if (fL0 != fL1) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j3);
        }
    }

    @Override // k1.g, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f2821x0 != i3) {
            this.f2821x0 = i3;
            invalidateSelf();
        }
    }

    @Override // k1.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2822y0 != colorFilter) {
            this.f2822y0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // k1.g, android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // k1.g, android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.B0 != mode) {
            this.B0 = mode;
            this.f2823z0 = b1.a.a(this, this.A0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (M2()) {
            visible |= this.J.setVisible(z2, z3);
        }
        if (L2()) {
            visible |= this.V.setVisible(z2, z3);
        }
        if (N2()) {
            visible |= this.O.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t2(int i3) {
        s2(this.f2805h0.getResources().getDimension(i3));
    }

    protected void u1() {
        InterfaceC0036a interfaceC0036a = this.F0.get();
        if (interfaceC0036a != null) {
            interfaceC0036a.a();
        }
    }

    public void u2(float f3) {
        if (this.f2798a0 != f3) {
            float fL0 = l0();
            this.f2798a0 = f3;
            float fL1 = l0();
            invalidateSelf();
            if (fL0 != fL1) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v2(int i3) {
        u2(this.f2805h0.getResources().getDimension(i3));
    }

    public void w1(boolean z2) {
        if (this.T != z2) {
            this.T = z2;
            float fL0 = l0();
            if (!z2 && this.f2819v0) {
                this.f2819v0 = false;
            }
            float fL1 = l0();
            invalidateSelf();
            if (fL0 != fL1) {
                u1();
            }
        }
    }

    public void w2(int i3) {
        this.I0 = i3;
    }

    public void x1(int i3) {
        w1(this.f2805h0.getResources().getBoolean(i3));
    }

    public void x2(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            P2();
            onStateChange(getState());
        }
    }

    public void y1(Drawable drawable) {
        if (this.V != drawable) {
            float fL0 = l0();
            this.V = drawable;
            float fL1 = l0();
            O2(this.V);
            j0(this.V);
            invalidateSelf();
            if (fL0 != fL1) {
                u1();
            }
        }
    }

    public void y2(int i3) {
        x2(c.a.c(this.f2805h0, i3));
    }

    public void z1(int i3) {
        y1(c.a.d(this.f2805h0, i3));
    }

    void z2(boolean z2) {
        this.H0 = z2;
    }
}
