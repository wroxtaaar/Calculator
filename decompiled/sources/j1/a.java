package j1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f4968i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f4969j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f4970k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f4971l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f4972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f4973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f4974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f4978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f4979h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i3, float f3, float f4) {
        boolean z2 = f4 < 0.0f;
        Path path = this.f4978g;
        if (z2) {
            int[] iArr = f4970k;
            iArr[0] = 0;
            iArr[1] = this.f4977f;
            iArr[2] = this.f4976e;
            iArr[3] = this.f4975d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f3, f4);
            path.close();
            float f5 = -i3;
            rectF.inset(f5, f5);
            int[] iArr2 = f4970k;
            iArr2[0] = 0;
            iArr2[1] = this.f4975d;
            iArr2[2] = this.f4976e;
            iArr2[3] = this.f4977f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f6 = 1.0f - (i3 / fWidth);
        float[] fArr = f4971l;
        fArr[1] = f6;
        fArr[2] = ((1.0f - f6) / 2.0f) + f6;
        this.f4973b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f4970k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f4979h);
        }
        canvas.drawArc(rectF, f3, f4, true, this.f4973b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i3) {
        rectF.bottom += i3;
        rectF.offset(0.0f, -i3);
        int[] iArr = f4968i;
        iArr[0] = this.f4977f;
        iArr[1] = this.f4976e;
        iArr[2] = this.f4975d;
        Paint paint = this.f4974c;
        float f3 = rectF.left;
        paint.setShader(new LinearGradient(f3, rectF.top, f3, rectF.bottom, iArr, f4969j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f4974c);
        canvas.restore();
    }

    public Paint c() {
        return this.f4972a;
    }

    public void d(int i3) {
        this.f4975d = w.a.h(i3, 68);
        this.f4976e = w.a.h(i3, 20);
        this.f4977f = w.a.h(i3, 0);
        this.f4972a.setColor(this.f4975d);
    }

    public a(int i3) {
        this.f4978g = new Path();
        this.f4979h = new Paint();
        this.f4972a = new Paint();
        d(i3);
        this.f4979h.setColor(0);
        Paint paint = new Paint(4);
        this.f4973b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f4974c = new Paint(paint);
    }
}
