package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import e0.t;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final boolean f3056t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final Paint f3057u0;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private Typeface D;
    private h1.a E;
    private h1.a F;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean K;
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    private final TextPaint V;
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f3058a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f3059a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3060b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f3061b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3062c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ColorStateList f3063c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3064d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f3065d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3066e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f3067e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3068f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f3069f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3070g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ColorStateList f3071g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f3072h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f3073h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Rect f3074i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private float f3075i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f3076j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private float f3077j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private StaticLayout f3079k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f3081l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private float f3083m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private float f3085n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f3086o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private CharSequence f3087o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f3088p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3090q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f3092r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f3094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f3096t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f3097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f3098v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f3099w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Typeface f3100x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Typeface f3101y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Typeface f3102z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3078k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3080l = 16;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f3082m = 15.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f3084n = 15.0f;
    private boolean J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f3089p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f3091q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private float f3093r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f3095s0 = j.f3123n;

    /* JADX INFO: compiled from: CollapsingTextHelper.java */
    class a implements h1.a.InterfaceC0064a {
        a() {
        }

        @Override // h1.a.InterfaceC0064a
        public void a(Typeface typeface) {
            b.this.T(typeface);
        }
    }

    static {
        f3056t0 = Build.VERSION.SDK_INT < 18;
        f3057u0 = null;
    }

    public b(View view) {
        this.f3058a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f3074i = new Rect();
        this.f3072h = new Rect();
        this.f3076j = new RectF();
        this.f3068f = e();
        H(view.getContext().getResources().getConfiguration());
    }

    private void A(TextPaint textPaint) {
        textPaint.setTextSize(this.f3082m);
        textPaint.setTypeface(this.A);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f3075i0);
        }
    }

    private void B(float f3) {
        if (this.f3064d) {
            this.f3076j.set(f3 < this.f3068f ? this.f3072h : this.f3074i);
            return;
        }
        this.f3076j.left = G(this.f3072h.left, this.f3074i.left, f3, this.X);
        this.f3076j.top = G(this.f3092r, this.f3094s, f3, this.X);
        this.f3076j.right = G(this.f3072h.right, this.f3074i.right, f3, this.X);
        this.f3076j.bottom = G(this.f3072h.bottom, this.f3074i.bottom, f3, this.X);
    }

    private static boolean C(float f3, float f4) {
        return Math.abs(f3 - f4) < 1.0E-5f;
    }

    private boolean D() {
        return t.B(this.f3058a) == 1;
    }

    private boolean F(CharSequence charSequence, boolean z2) {
        return (z2 ? c0.e.f2481d : c0.e.f2480c).a(charSequence, 0, charSequence.length());
    }

    private static float G(float f3, float f4, float f5, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f5 = timeInterpolator.getInterpolation(f5);
        }
        return u0.a.a(f3, f4, f5);
    }

    private float I(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean M(Rect rect, int i3, int i4, int i5, int i6) {
        return rect.left == i3 && rect.top == i4 && rect.right == i5 && rect.bottom == i6;
    }

    private void Q(float f3) {
        this.f3083m0 = f3;
        t.d0(this.f3058a);
    }

    private boolean U(Typeface typeface) {
        h1.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f3102z == typeface) {
            return false;
        }
        this.f3102z = typeface;
        Typeface typefaceB = h1.g.b(this.f3058a.getContext().getResources().getConfiguration(), typeface);
        this.f3101y = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f3102z;
        }
        this.f3100x = typefaceB;
        return true;
    }

    private void Y(float f3) {
        this.f3085n0 = f3;
        t.d0(this.f3058a);
    }

    private static int a(int i3, int i4, float f3) {
        float f4 = 1.0f - f3;
        return Color.argb(Math.round((Color.alpha(i3) * f4) + (Color.alpha(i4) * f3)), Math.round((Color.red(i3) * f4) + (Color.red(i4) * f3)), Math.round((Color.green(i3) * f4) + (Color.green(i4) * f3)), Math.round((Color.blue(i3) * f4) + (Color.blue(i4) * f3)));
    }

    private void b(boolean z2) {
        StaticLayout staticLayout;
        i(1.0f, z2);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f3079k0) != null) {
            this.f3087o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f3087o0;
        float fI = 0.0f;
        if (charSequence2 != null) {
            this.f3081l0 = I(this.V, charSequence2);
        } else {
            this.f3081l0 = 0.0f;
        }
        int iB = e0.d.b(this.f3080l, this.I ? 1 : 0);
        int i3 = iB & 112;
        if (i3 == 48) {
            this.f3094s = this.f3074i.top;
        } else if (i3 != 80) {
            this.f3094s = this.f3074i.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.f3094s = this.f3074i.bottom + this.V.ascent();
        }
        int i4 = iB & 8388615;
        if (i4 == 1) {
            this.f3097u = this.f3074i.centerX() - (this.f3081l0 / 2.0f);
        } else if (i4 != 5) {
            this.f3097u = this.f3074i.left;
        } else {
            this.f3097u = this.f3074i.right - this.f3081l0;
        }
        i(0.0f, z2);
        StaticLayout staticLayout2 = this.f3079k0;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.f3079k0;
        if (staticLayout3 == null || this.f3089p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                fI = I(this.V, charSequence3);
            }
        } else {
            fI = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f3079k0;
        this.f3090q = staticLayout4 != null ? staticLayout4.getLineCount() : 0;
        int iB2 = e0.d.b(this.f3078k, this.I ? 1 : 0);
        int i5 = iB2 & 112;
        if (i5 == 48) {
            this.f3092r = this.f3072h.top;
        } else if (i5 != 80) {
            this.f3092r = this.f3072h.centerY() - (height / 2.0f);
        } else {
            this.f3092r = (this.f3072h.bottom - height) + this.V.descent();
        }
        int i6 = iB2 & 8388615;
        if (i6 == 1) {
            this.f3096t = this.f3072h.centerX() - (fI / 2.0f);
        } else if (i6 != 5) {
            this.f3096t = this.f3072h.left;
        } else {
            this.f3096t = this.f3072h.right - fI;
        }
        j();
        e0(this.f3062c);
    }

    private void c() {
        g(this.f3062c);
    }

    private boolean c0(Typeface typeface) {
        h1.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.C == typeface) {
            return false;
        }
        this.C = typeface;
        Typeface typefaceB = h1.g.b(this.f3058a.getContext().getResources().getConfiguration(), typeface);
        this.B = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.C;
        }
        this.A = typefaceB;
        return true;
    }

    private float d(float f3) {
        float f4 = this.f3068f;
        return f3 <= f4 ? u0.a.b(1.0f, 0.0f, this.f3066e, f4, f3) : u0.a.b(0.0f, 1.0f, f4, 1.0f, f3);
    }

    private float e() {
        float f3 = this.f3066e;
        return f3 + ((1.0f - f3) * 0.5f);
    }

    private void e0(float f3) {
        h(f3);
        boolean z2 = f3056t0 && this.N != 1.0f;
        this.K = z2;
        if (z2) {
            n();
        }
        t.d0(this.f3058a);
    }

    private boolean f(CharSequence charSequence) {
        boolean zD = D();
        return this.J ? F(charSequence, zD) : zD;
    }

    private void g(float f3) {
        float f4;
        B(f3);
        if (!this.f3064d) {
            this.f3098v = G(this.f3096t, this.f3097u, f3, this.X);
            this.f3099w = G(this.f3092r, this.f3094s, f3, this.X);
            e0(f3);
            f4 = f3;
        } else if (f3 < this.f3068f) {
            this.f3098v = this.f3096t;
            this.f3099w = this.f3092r;
            e0(0.0f);
            f4 = 0.0f;
        } else {
            this.f3098v = this.f3097u;
            this.f3099w = this.f3094s - Math.max(0, this.f3070g);
            e0(1.0f);
            f4 = 1.0f;
        }
        TimeInterpolator timeInterpolator = u0.a.f6258b;
        Q(1.0f - G(0.0f, 1.0f, 1.0f - f3, timeInterpolator));
        Y(G(1.0f, 0.0f, f3, timeInterpolator));
        if (this.f3088p != this.f3086o) {
            this.V.setColor(a(v(), t(), f4));
        } else {
            this.V.setColor(t());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f5 = this.f3073h0;
            float f6 = this.f3075i0;
            if (f5 != f6) {
                this.V.setLetterSpacing(G(f6, f5, f3, timeInterpolator));
            } else {
                this.V.setLetterSpacing(f5);
            }
        }
        this.P = G(this.f3065d0, this.Z, f3, null);
        this.Q = G(this.f3067e0, this.f3059a0, f3, null);
        this.R = G(this.f3069f0, this.f3061b0, f3, null);
        int iA = a(u(this.f3071g0), u(this.f3063c0), f3);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.f3064d) {
            this.V.setAlpha((int) (d(f3) * this.V.getAlpha()));
        }
        t.d0(this.f3058a);
    }

    private void h(float f3) {
        i(f3, false);
    }

    private void i(float f3, boolean z2) {
        boolean z3;
        float f4;
        float f5;
        boolean z4;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f3074i.width();
        float fWidth2 = this.f3072h.width();
        if (C(f3, 1.0f)) {
            f4 = this.f3084n;
            f5 = this.f3073h0;
            this.N = 1.0f;
            Typeface typeface = this.D;
            Typeface typeface2 = this.f3100x;
            if (typeface != typeface2) {
                this.D = typeface2;
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            float f6 = this.f3082m;
            float f7 = this.f3075i0;
            Typeface typeface3 = this.D;
            Typeface typeface4 = this.A;
            if (typeface3 != typeface4) {
                this.D = typeface4;
                z3 = true;
            } else {
                z3 = false;
            }
            if (C(f3, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = G(this.f3082m, this.f3084n, f3, this.Y) / this.f3082m;
            }
            float f8 = this.f3084n / this.f3082m;
            fWidth = (!z2 && fWidth2 * f8 > fWidth) ? Math.min(fWidth / f8, fWidth2) : fWidth2;
            f4 = f6;
            f5 = f7;
            z4 = z3;
        }
        if (fWidth > 0.0f) {
            z4 = ((this.O > f4 ? 1 : (this.O == f4 ? 0 : -1)) != 0) || ((this.f3077j0 > f5 ? 1 : (this.f3077j0 == f5 ? 0 : -1)) != 0) || this.U || z4;
            this.O = f4;
            this.f3077j0 = f5;
            this.U = false;
        }
        if (this.H == null || z4) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.D);
            if (Build.VERSION.SDK_INT >= 21) {
                this.V.setLetterSpacing(this.f3077j0);
            }
            this.V.setLinearText(this.N != 1.0f);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(k0() ? this.f3089p0 : 1, fWidth, this.I);
            this.f3079k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i3, float f3, boolean z2) {
        StaticLayout staticLayoutA;
        try {
            staticLayoutA = j.c(this.G, this.V, (int) f3).e(TextUtils.TruncateAt.END).h(z2).d(i3 == 1 ? Layout.Alignment.ALIGN_NORMAL : y()).g(false).j(i3).i(this.f3091q0, this.f3093r0).f(this.f3095s0).a();
        } catch (j.a e3) {
            Log.e("CollapsingTextHelper", e3.getCause().getMessage(), e3);
            staticLayoutA = null;
        }
        return (StaticLayout) d0.i.c(staticLayoutA);
    }

    private boolean k0() {
        return this.f3089p0 > 1 && (!this.I || this.f3064d) && !this.K;
    }

    private void m(Canvas canvas, float f3, float f4) {
        int alpha = this.V.getAlpha();
        canvas.translate(f3, f4);
        float f5 = alpha;
        this.V.setAlpha((int) (this.f3085n0 * f5));
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            TextPaint textPaint = this.V;
            textPaint.setShadowLayer(this.P, this.Q, this.R, z0.c.a(this.S, textPaint.getAlpha()));
        }
        this.f3079k0.draw(canvas);
        this.V.setAlpha((int) (this.f3083m0 * f5));
        if (i3 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, z0.c.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f3079k0.getLineBaseline(0);
        CharSequence charSequence = this.f3087o0;
        float f6 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, this.V);
        if (i3 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.f3064d) {
            return;
        }
        String strTrim = this.f3087o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f3079k0.getLineEnd(0), str.length()), 0.0f, f6, (Paint) this.V);
    }

    private void n() {
        if (this.L != null || this.f3072h.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.f3079k0.getWidth();
        int height = this.f3079k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f3079k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    private float r(int i3, int i4) {
        if (i4 == 17 || (i4 & 7) == 1) {
            return (i3 / 2.0f) - (this.f3081l0 / 2.0f);
        }
        if ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) {
            return this.I ? this.f3074i.left : this.f3074i.right - this.f3081l0;
        }
        return this.I ? this.f3074i.right - this.f3081l0 : this.f3074i.left;
    }

    private float s(RectF rectF, int i3, int i4) {
        if (i4 == 17 || (i4 & 7) == 1) {
            return (i3 / 2.0f) + (this.f3081l0 / 2.0f);
        }
        if ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) {
            return this.I ? rectF.left + this.f3081l0 : this.f3074i.right;
        }
        if (this.I) {
            return this.f3074i.right;
        }
        return this.f3081l0 + rectF.left;
    }

    private int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int v() {
        return u(this.f3086o);
    }

    private Layout.Alignment y() {
        int iB = e0.d.b(this.f3078k, this.I ? 1 : 0) & 7;
        if (iB == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (iB != 5) {
            return this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
    }

    private void z(TextPaint textPaint) {
        textPaint.setTextSize(this.f3084n);
        textPaint.setTypeface(this.f3100x);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f3073h0);
        }
    }

    public final boolean E() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f3088p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f3086o) != null && colorStateList.isStateful());
    }

    public void H(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f3102z;
            if (typeface != null) {
                this.f3101y = h1.g.b(configuration, typeface);
            }
            Typeface typeface2 = this.C;
            if (typeface2 != null) {
                this.B = h1.g.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f3101y;
            if (typeface3 == null) {
                typeface3 = this.f3102z;
            }
            this.f3100x = typeface3;
            Typeface typeface4 = this.B;
            if (typeface4 == null) {
                typeface4 = this.C;
            }
            this.A = typeface4;
            L(true);
        }
    }

    void J() {
        this.f3060b = this.f3074i.width() > 0 && this.f3074i.height() > 0 && this.f3072h.width() > 0 && this.f3072h.height() > 0;
    }

    public void K() {
        L(false);
    }

    public void L(boolean z2) {
        if ((this.f3058a.getHeight() <= 0 || this.f3058a.getWidth() <= 0) && !z2) {
            return;
        }
        b(z2);
        c();
    }

    public void N(int i3, int i4, int i5, int i6) {
        if (M(this.f3074i, i3, i4, i5, i6)) {
            return;
        }
        this.f3074i.set(i3, i4, i5, i6);
        this.U = true;
        J();
    }

    public void O(Rect rect) {
        N(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void P(int i3) {
        h1.d dVar = new h1.d(this.f3058a.getContext(), i3);
        if (dVar.i() != null) {
            this.f3088p = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f3084n = dVar.j();
        }
        ColorStateList colorStateList = dVar.f4849c;
        if (colorStateList != null) {
            this.f3063c0 = colorStateList;
        }
        this.f3059a0 = dVar.f4854h;
        this.f3061b0 = dVar.f4855i;
        this.Z = dVar.f4856j;
        this.f3073h0 = dVar.f4858l;
        h1.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        this.F = new h1.a(new a(), dVar.e());
        dVar.h(this.f3058a.getContext(), this.F);
        K();
    }

    public void R(ColorStateList colorStateList) {
        if (this.f3088p != colorStateList) {
            this.f3088p = colorStateList;
            K();
        }
    }

    public void S(int i3) {
        if (this.f3080l != i3) {
            this.f3080l = i3;
            K();
        }
    }

    public void T(Typeface typeface) {
        if (U(typeface)) {
            K();
        }
    }

    public void V(int i3, int i4, int i5, int i6) {
        if (M(this.f3072h, i3, i4, i5, i6)) {
            return;
        }
        this.f3072h.set(i3, i4, i5, i6);
        this.U = true;
        J();
    }

    public void W(Rect rect) {
        V(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void X(float f3) {
        if (this.f3075i0 != f3) {
            this.f3075i0 = f3;
            K();
        }
    }

    public void Z(ColorStateList colorStateList) {
        if (this.f3086o != colorStateList) {
            this.f3086o = colorStateList;
            K();
        }
    }

    public void a0(int i3) {
        if (this.f3078k != i3) {
            this.f3078k = i3;
            K();
        }
    }

    public void b0(float f3) {
        if (this.f3082m != f3) {
            this.f3082m = f3;
            K();
        }
    }

    public void d0(float f3) {
        float fA = z.a.a(f3, 0.0f, 1.0f);
        if (fA != this.f3062c) {
            this.f3062c = fA;
            c();
        }
    }

    public void f0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        K();
    }

    public final boolean g0(int[] iArr) {
        this.T = iArr;
        if (!E()) {
            return false;
        }
        K();
        return true;
    }

    public void h0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            K();
        }
    }

    public void i0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        K();
    }

    public void j0(Typeface typeface) {
        boolean zU = U(typeface);
        boolean zC0 = c0(typeface);
        if (zU || zC0) {
            K();
        }
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || !this.f3060b) {
            return;
        }
        this.V.setTextSize(this.O);
        float f3 = this.f3098v;
        float f4 = this.f3099w;
        boolean z2 = this.K && this.L != null;
        float f5 = this.N;
        if (f5 != 1.0f && !this.f3064d) {
            canvas.scale(f5, f5, f3, f4);
        }
        if (z2) {
            canvas.drawBitmap(this.L, f3, f4, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!k0() || (this.f3064d && this.f3062c <= this.f3068f)) {
            canvas.translate(f3, f4);
            this.f3079k0.draw(canvas);
        } else {
            m(canvas, this.f3098v - this.f3079k0.getLineStart(0), f4);
        }
        canvas.restoreToCount(iSave);
    }

    public void o(RectF rectF, int i3, int i4) {
        this.I = f(this.G);
        rectF.left = r(i3, i4);
        rectF.top = this.f3074i.top;
        rectF.right = s(rectF, i3, i4);
        rectF.bottom = this.f3074i.top + q();
    }

    public ColorStateList p() {
        return this.f3088p;
    }

    public float q() {
        z(this.W);
        return -this.W.ascent();
    }

    public int t() {
        return u(this.f3088p);
    }

    public float w() {
        A(this.W);
        return -this.W.ascent();
    }

    public float x() {
        return this.f3062c;
    }
}
