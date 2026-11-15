package k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
/* JADX INFO: loaded from: classes.dex */
class h extends Drawable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final double f5053q = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static a f5054r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f5056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f5057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f5058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f5059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f5060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f5061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f5062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f5063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f5064j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f5065k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f5066l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f5067m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f5068n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f5069o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f5070p;

    /* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
    interface a {
        void a(Canvas canvas, RectF rectF, float f3, Paint paint);
    }

    private void a(Rect rect) {
        float f3 = this.f5062h;
        float f4 = 1.5f * f3;
        this.f5059e.set(rect.left + f3, rect.top + f4, rect.right - f3, rect.bottom - f4);
        b();
    }

    private void b() {
        float f3 = this.f5060f;
        RectF rectF = new RectF(-f3, -f3, f3, f3);
        RectF rectF2 = new RectF(rectF);
        float f4 = this.f5063i;
        rectF2.inset(-f4, -f4);
        Path path = this.f5061g;
        if (path == null) {
            this.f5061g = new Path();
        } else {
            path.reset();
        }
        this.f5061g.setFillType(Path.FillType.EVEN_ODD);
        this.f5061g.moveTo(-this.f5060f, 0.0f);
        this.f5061g.rLineTo(-this.f5063i, 0.0f);
        this.f5061g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f5061g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f5061g.close();
        float f5 = this.f5060f;
        float f6 = f5 / (this.f5063i + f5);
        Paint paint = this.f5057c;
        float f7 = this.f5060f + this.f5063i;
        int i3 = this.f5067m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f7, new int[]{i3, i3, this.f5068n}, new float[]{0.0f, f6, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f5058d;
        float f8 = this.f5060f;
        float f9 = this.f5063i;
        int i4 = this.f5067m;
        paint2.setShader(new LinearGradient(0.0f, (-f8) + f9, 0.0f, (-f8) - f9, new int[]{i4, i4, this.f5068n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f5058d.setAntiAlias(false);
    }

    static float c(float f3, float f4, boolean z2) {
        return z2 ? (float) (((double) f3) + ((1.0d - f5053q) * ((double) f4))) : f3;
    }

    static float d(float f3, float f4, boolean z2) {
        return z2 ? (float) (((double) (f3 * 1.5f)) + ((1.0d - f5053q) * ((double) f4))) : f3 * 1.5f;
    }

    private void e(Canvas canvas) {
        float f3 = this.f5060f;
        float f4 = (-f3) - this.f5063i;
        float f5 = f3 + this.f5055a + (this.f5064j / 2.0f);
        float f6 = f5 * 2.0f;
        boolean z2 = this.f5059e.width() - f6 > 0.0f;
        boolean z3 = this.f5059e.height() - f6 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f5059e;
        canvas.translate(rectF.left + f5, rectF.top + f5);
        canvas.drawPath(this.f5061g, this.f5057c);
        if (z2) {
            canvas.drawRect(0.0f, f4, this.f5059e.width() - f6, -this.f5060f, this.f5058d);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f5059e;
        canvas.translate(rectF2.right - f5, rectF2.bottom - f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f5061g, this.f5057c);
        if (z2) {
            canvas.drawRect(0.0f, f4, this.f5059e.width() - f6, (-this.f5060f) + this.f5063i, this.f5058d);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f5059e;
        canvas.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f5061g, this.f5057c);
        if (z3) {
            canvas.drawRect(0.0f, f4, this.f5059e.height() - f6, -this.f5060f, this.f5058d);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f5059e;
        canvas.translate(rectF4.right - f5, rectF4.top + f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f5061g, this.f5057c);
        if (z3) {
            canvas.drawRect(0.0f, f4, this.f5059e.height() - f6, -this.f5060f, this.f5058d);
        }
        canvas.restoreToCount(iSave4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f5065k = colorStateList;
        this.f5056b.setColor(colorStateList.getColorForState(getState(), this.f5065k.getDefaultColor()));
    }

    private void s(float f3, float f4) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f3 + ". Must be >= 0");
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f4 + ". Must be >= 0");
        }
        float fT = t(f3);
        float fT2 = t(f4);
        if (fT > fT2) {
            if (!this.f5070p) {
                this.f5070p = true;
            }
            fT = fT2;
        }
        if (this.f5064j == fT && this.f5062h == fT2) {
            return;
        }
        this.f5064j = fT;
        this.f5062h = fT2;
        this.f5063i = (int) ((fT * 1.5f) + this.f5055a + 0.5f);
        this.f5066l = true;
        invalidateSelf();
    }

    private int t(float f3) {
        int i3 = (int) (f3 + 0.5f);
        return i3 % 2 == 1 ? i3 - 1 : i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5066l) {
            a(getBounds());
            this.f5066l = false;
        }
        canvas.translate(0.0f, this.f5064j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f5064j) / 2.0f);
        f5054r.a(canvas, this.f5059e, this.f5060f, this.f5056b);
    }

    ColorStateList f() {
        return this.f5065k;
    }

    float g() {
        return this.f5060f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f5062h, this.f5060f, this.f5069o));
        int iCeil2 = (int) Math.ceil(c(this.f5062h, this.f5060f, this.f5069o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.f5062h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f5065k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f3 = this.f5062h;
        return (Math.max(f3, this.f5060f + this.f5055a + ((f3 * 1.5f) / 2.0f)) * 2.0f) + (((this.f5062h * 1.5f) + this.f5055a) * 2.0f);
    }

    float k() {
        float f3 = this.f5062h;
        return (Math.max(f3, this.f5060f + this.f5055a + (f3 / 2.0f)) * 2.0f) + ((this.f5062h + this.f5055a) * 2.0f);
    }

    float l() {
        return this.f5064j;
    }

    void m(boolean z2) {
        this.f5069o = z2;
        invalidateSelf();
    }

    void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f5066l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f5065k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f5056b.getColor() == colorForState) {
            return false;
        }
        this.f5056b.setColor(colorForState);
        this.f5066l = true;
        invalidateSelf();
        return true;
    }

    void p(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f3 + ". Must be >= 0");
        }
        float f4 = (int) (f3 + 0.5f);
        if (this.f5060f == f4) {
            return;
        }
        this.f5060f = f4;
        this.f5066l = true;
        invalidateSelf();
    }

    void q(float f3) {
        s(this.f5064j, f3);
    }

    void r(float f3) {
        s(f3, this.f5062h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f5056b.setAlpha(i3);
        this.f5057c.setAlpha(i3);
        this.f5058d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5056b.setColorFilter(colorFilter);
    }
}
