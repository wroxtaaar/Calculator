package k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: RoundRectDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class g extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f5043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f5044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f5045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f5046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f5049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f5050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f5051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f5052k;

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f5049h = colorStateList;
        this.f5043b.setColor(colorStateList.getColorForState(getState(), this.f5049h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f5044c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f5045d.set(rect);
        if (this.f5047f) {
            this.f5045d.inset((int) Math.ceil(h.c(this.f5046e, this.f5042a, this.f5048g)), (int) Math.ceil(h.d(this.f5046e, this.f5042a, this.f5048g)));
            this.f5044c.set(this.f5045d);
        }
    }

    public ColorStateList b() {
        return this.f5049h;
    }

    float c() {
        return this.f5046e;
    }

    public float d() {
        return this.f5042a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.f5043b;
        if (this.f5050i == null || paint.getColorFilter() != null) {
            z2 = false;
        } else {
            paint.setColorFilter(this.f5050i);
            z2 = true;
        }
        RectF rectF = this.f5044c;
        float f3 = this.f5042a;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        if (z2) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f3, boolean z2, boolean z3) {
        if (f3 == this.f5046e && this.f5047f == z2 && this.f5048g == z3) {
            return;
        }
        this.f5046e = f3;
        this.f5047f = z2;
        this.f5048g = z3;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f5045d, this.f5042a);
    }

    void h(float f3) {
        if (f3 == this.f5042a) {
            return;
        }
        this.f5042a = f3;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f5051j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f5049h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f5049h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z2 = colorForState != this.f5043b.getColor();
        if (z2) {
            this.f5043b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f5051j;
        if (colorStateList2 == null || (mode = this.f5052k) == null) {
            return z2;
        }
        this.f5050i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f5043b.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5043b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f5051j = colorStateList;
        this.f5050i = a(colorStateList, this.f5052k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f5052k = mode;
        this.f5050i = a(this.f5051j, mode);
        invalidateSelf();
    }
}
