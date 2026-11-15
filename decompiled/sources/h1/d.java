package h1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import t0.k;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f4847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f4848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f4849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f4855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f4856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f4858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorStateList f4859m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4860n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f4861o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4862p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Typeface f4863q;

    /* JADX INFO: compiled from: TextAppearance.java */
    class a extends v.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f4864a;

        a(f fVar) {
            this.f4864a = fVar;
        }

        @Override // v.f.a
        public void d(int i3) {
            d.this.f4862p = true;
            this.f4864a.a(i3);
        }

        @Override // v.f.a
        public void e(Typeface typeface) {
            d dVar = d.this;
            dVar.f4863q = Typeface.create(typeface, dVar.f4851e);
            d.this.f4862p = true;
            this.f4864a.b(d.this.f4863q, false);
        }
    }

    /* JADX INFO: compiled from: TextAppearance.java */
    class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f4867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f4868c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f4866a = context;
            this.f4867b = textPaint;
            this.f4868c = fVar;
        }

        @Override // h1.f
        public void a(int i3) {
            this.f4868c.a(i3);
        }

        @Override // h1.f
        public void b(Typeface typeface, boolean z2) {
            d.this.p(this.f4866a, this.f4867b, typeface);
            this.f4868c.b(typeface, z2);
        }
    }

    public d(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, k.TextAppearance);
        l(typedArrayObtainStyledAttributes.getDimension(k.TextAppearance_android_textSize, 0.0f));
        k(c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColor));
        this.f4847a = c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColorHint);
        this.f4848b = c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColorLink);
        this.f4851e = typedArrayObtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, 0);
        this.f4852f = typedArrayObtainStyledAttributes.getInt(k.TextAppearance_android_typeface, 1);
        int iE = c.e(typedArrayObtainStyledAttributes, k.TextAppearance_fontFamily, k.TextAppearance_android_fontFamily);
        this.f4861o = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f4850d = typedArrayObtainStyledAttributes.getString(iE);
        this.f4853g = typedArrayObtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false);
        this.f4849c = c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_shadowColor);
        this.f4854h = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDx, 0.0f);
        this.f4855i = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDy, 0.0f);
        this.f4856j = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT < 21) {
            this.f4857k = false;
            this.f4858l = 0.0f;
            return;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i3, k.MaterialTextAppearance);
        int i4 = k.MaterialTextAppearance_android_letterSpacing;
        this.f4857k = typedArrayObtainStyledAttributes2.hasValue(i4);
        this.f4858l = typedArrayObtainStyledAttributes2.getFloat(i4, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f4863q == null && (str = this.f4850d) != null) {
            this.f4863q = Typeface.create(str, this.f4851e);
        }
        if (this.f4863q == null) {
            int i3 = this.f4852f;
            if (i3 == 1) {
                this.f4863q = Typeface.SANS_SERIF;
            } else if (i3 == 2) {
                this.f4863q = Typeface.SERIF;
            } else if (i3 != 3) {
                this.f4863q = Typeface.DEFAULT;
            } else {
                this.f4863q = Typeface.MONOSPACE;
            }
            this.f4863q = Typeface.create(this.f4863q, this.f4851e);
        }
    }

    private boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i3 = this.f4861o;
        return (i3 != 0 ? v.f.a(context, i3) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f4863q;
    }

    public Typeface f(Context context) {
        if (this.f4862p) {
            return this.f4863q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceC = v.f.c(context, this.f4861o);
                this.f4863q = typefaceC;
                if (typefaceC != null) {
                    this.f4863q = Typeface.create(typefaceC, this.f4851e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e3) {
                Log.d("TextAppearance", "Error loading font " + this.f4850d, e3);
            }
        }
        d();
        this.f4862p = true;
        return this.f4863q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i3 = this.f4861o;
        if (i3 == 0) {
            this.f4862p = true;
        }
        if (this.f4862p) {
            fVar.b(this.f4863q, true);
            return;
        }
        try {
            v.f.e(context, i3, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f4862p = true;
            fVar.a(1);
        } catch (Exception e3) {
            Log.d("TextAppearance", "Error loading font " + this.f4850d, e3);
            this.f4862p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f4859m;
    }

    public float j() {
        return this.f4860n;
    }

    public void k(ColorStateList colorStateList) {
        this.f4859m = colorStateList;
    }

    public void l(float f3) {
        this.f4860n = f3;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f4859m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f3 = this.f4856j;
        float f4 = this.f4854h;
        float f5 = this.f4855i;
        ColorStateList colorStateList2 = this.f4849c;
        textPaint.setShadowLayer(f3, f4, f5, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = g.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i3 = this.f4851e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i3 & 1) != 0);
        textPaint.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f4860n);
        if (Build.VERSION.SDK_INT < 21 || !this.f4857k) {
            return;
        }
        textPaint.setLetterSpacing(this.f4858l);
    }
}
