package com.vigour.funtouchui.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import y1.h;

/* JADX INFO: loaded from: classes.dex */
public class VigourProgressDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RectF f3465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f3467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f3468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f3469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Rect f3470j;

    public VigourProgressDrawable() {
        this(null, null);
    }

    private void a(Canvas canvas, int i3) {
        this.f3469i.setColor(this.f3461a);
        this.f3469i.setAlpha((int) (this.f3468h * 255.0f));
        canvas.drawArc(this.f3465e, this.f3464d, (i3 * 360.0f) / 10000.0f, false, this.f3469i);
    }

    protected static TypedArray b(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private void c(TypedArray typedArray) {
        this.f3463c = typedArray.getInteger(h.VigourProgressDrawable_statelevel, this.f3463c);
        this.f3461a = typedArray.getColor(h.VigourProgressDrawable_linecolor, -3355444);
        this.f3466f = typedArray.getDimension(h.VigourProgressDrawable_arcwidth, this.f3466f);
        this.f3464d = typedArray.getInteger(h.VigourProgressDrawable_startangle, this.f3464d);
        this.f3467g = typedArray.getDimension(h.VigourProgressDrawable_padding, this.f3467g);
        this.f3468h = typedArray.getFloat(h.VigourProgressDrawable_linealpha, 1.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.f3470j = bounds;
        float fWidth = ((bounds.width() / 2.0f) - (this.f3466f / 2.0f)) - this.f3467g;
        this.f3465e.set(this.f3470j.centerX() - fWidth, this.f3470j.centerY() - fWidth, this.f3470j.centerX() + fWidth, this.f3470j.centerY() + fWidth);
        this.f3469i.setStrokeWidth(this.f3466f);
        this.f3469i.setColor(this.f3461a);
        this.f3469i.setStrokeCap(Paint.Cap.ROUND);
        int level = getLevel();
        this.f3462b = level;
        if (level > 0) {
            a(canvas, level);
            return;
        }
        int i3 = this.f3463c;
        if (i3 > 0) {
            a(canvas, i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayB = b(resources, theme, attributeSet, h.VigourProgressDrawable);
        c(typedArrayB);
        typedArrayB.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        invalidateSelf();
        return super.onLevelChange(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public VigourProgressDrawable(Drawable.ConstantState constantState, Resources resources) {
        this.f3461a = 0;
        this.f3462b = 0;
        this.f3463c = 10000;
        this.f3464d = -90;
        this.f3465e = null;
        this.f3466f = 0.0f;
        this.f3467g = 0.0f;
        this.f3468h = 1.0f;
        this.f3469i = null;
        Paint paint = new Paint(1);
        this.f3469i = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f3465e = new RectF();
        this.f3461a = -3355444;
    }
}
