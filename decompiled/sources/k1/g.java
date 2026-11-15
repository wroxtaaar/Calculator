package k1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements x.b, n {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f5075y = g.class.getSimpleName();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Paint f5076z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f5077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m.g[] f5078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m.g[] f5079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BitSet f5080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Matrix f5082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Path f5083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Path f5084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f5085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RectF f5086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Region f5087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Region f5088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private k f5089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint f5090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Paint f5091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final j1.a f5092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l.b f5093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final l f5094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private PorterDuffColorFilter f5095t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PorterDuffColorFilter f5096u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5097v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final RectF f5098w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f5099x;

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    class a implements l.b {
        a() {
        }

        @Override // k1.l.b
        public void a(m mVar, Matrix matrix, int i3) {
            g.this.f5080e.set(i3, mVar.e());
            g.this.f5078c[i3] = mVar.f(matrix);
        }

        @Override // k1.l.b
        public void b(m mVar, Matrix matrix, int i3) {
            g.this.f5080e.set(i3 + 4, mVar.e());
            g.this.f5079d[i3] = mVar.f(matrix);
        }
    }

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    class b implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f5101a;

        b(float f3) {
            this.f5101a = f3;
        }

        @Override // k1.k.c
        public k1.c a(k1.c cVar) {
            return cVar instanceof i ? cVar : new k1.b(this.f5101a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        f5076z = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    private float E() {
        if (M()) {
            return this.f5091p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean K() {
        c cVar = this.f5077b;
        int i3 = cVar.f5119q;
        return i3 != 1 && cVar.f5120r > 0 && (i3 == 2 || U());
    }

    private boolean L() {
        Paint.Style style = this.f5077b.f5124v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean M() {
        Paint.Style style = this.f5077b.f5124v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f5091p.getStrokeWidth() > 0.0f;
    }

    private void O() {
        super.invalidateSelf();
    }

    private void R(Canvas canvas) {
        if (K()) {
            canvas.save();
            T(canvas);
            if (!this.f5099x) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f5098w.width() - getBounds().width());
            int iHeight = (int) (this.f5098w.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f5098w.width()) + (this.f5077b.f5120r * 2) + iWidth, ((int) this.f5098w.height()) + (this.f5077b.f5120r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f3 = (getBounds().left - this.f5077b.f5120r) - iWidth;
            float f4 = (getBounds().top - this.f5077b.f5120r) - iHeight;
            canvas2.translate(-f3, -f4);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int S(int i3, int i4) {
        return (i3 * (i4 + (i4 >>> 7))) >>> 8;
    }

    private void T(Canvas canvas) {
        int iA = A();
        int iB = B();
        if (Build.VERSION.SDK_INT < 21 && this.f5099x) {
            Rect clipBounds = canvas.getClipBounds();
            int i3 = this.f5077b.f5120r;
            clipBounds.inset(-i3, -i3);
            clipBounds.offset(iA, iB);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(iA, iB);
    }

    private PorterDuffColorFilter f(Paint paint, boolean z2) {
        if (!z2) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f5097v = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f5077b.f5112j != 1.0f) {
            this.f5082g.reset();
            Matrix matrix = this.f5082g;
            float f3 = this.f5077b.f5112j;
            matrix.setScale(f3, f3, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f5082g);
        }
        path.computeBounds(this.f5098w, true);
    }

    private boolean g0(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f5077b.f5106d == null || color2 == (colorForState2 = this.f5077b.f5106d.getColorForState(iArr, (color2 = this.f5090o.getColor())))) {
            z2 = false;
        } else {
            this.f5090o.setColor(colorForState2);
            z2 = true;
        }
        if (this.f5077b.f5107e == null || color == (colorForState = this.f5077b.f5107e.getColorForState(iArr, (color = this.f5091p.getColor())))) {
            return z2;
        }
        this.f5091p.setColor(colorForState);
        return true;
    }

    private boolean h0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f5095t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f5096u;
        c cVar = this.f5077b;
        this.f5095t = k(cVar.f5109g, cVar.f5110h, this.f5090o, true);
        c cVar2 = this.f5077b;
        this.f5096u = k(cVar2.f5108f, cVar2.f5110h, this.f5091p, false);
        c cVar3 = this.f5077b;
        if (cVar3.f5123u) {
            this.f5092q.d(cVar3.f5109g.getColorForState(getState(), 0));
        }
        return (d0.d.a(porterDuffColorFilter, this.f5095t) && d0.d.a(porterDuffColorFilter2, this.f5096u)) ? false : true;
    }

    private void i() {
        k kVarY = D().y(new b(-E()));
        this.f5089n = kVarY;
        this.f5094s.d(kVarY, this.f5077b.f5113k, v(), this.f5084i);
    }

    private void i0() {
        float fJ = J();
        this.f5077b.f5120r = (int) Math.ceil(0.75f * fJ);
        this.f5077b.f5121s = (int) Math.ceil(fJ * 0.25f);
        h0();
        O();
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = l(colorForState);
        }
        this.f5097v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z2) {
        return (colorStateList == null || mode == null) ? f(paint, z2) : j(colorStateList, mode, z2);
    }

    public static g m(Context context, float f3) {
        int iC = z0.c.c(context, t0.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.N(context);
        gVar.X(ColorStateList.valueOf(iC));
        gVar.W(f3);
        return gVar;
    }

    private void n(Canvas canvas) {
        if (this.f5080e.cardinality() > 0) {
            Log.w(f5075y, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f5077b.f5121s != 0) {
            canvas.drawPath(this.f5083h, this.f5092q.c());
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.f5078c[i3].b(this.f5092q, this.f5077b.f5120r, canvas);
            this.f5079d[i3].b(this.f5092q, this.f5077b.f5120r, canvas);
        }
        if (this.f5099x) {
            int iA = A();
            int iB = B();
            canvas.translate(-iA, -iB);
            canvas.drawPath(this.f5083h, f5076z);
            canvas.translate(iA, iB);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.f5090o, this.f5083h, this.f5077b.f5103a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF) * this.f5077b.f5113k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    private RectF v() {
        this.f5086k.set(u());
        float fE = E();
        this.f5086k.inset(fE, fE);
        return this.f5086k;
    }

    public int A() {
        c cVar = this.f5077b;
        return (int) (((double) cVar.f5121s) * Math.sin(Math.toRadians(cVar.f5122t)));
    }

    public int B() {
        c cVar = this.f5077b;
        return (int) (((double) cVar.f5121s) * Math.cos(Math.toRadians(cVar.f5122t)));
    }

    public int C() {
        return this.f5077b.f5120r;
    }

    public k D() {
        return this.f5077b.f5103a;
    }

    public ColorStateList F() {
        return this.f5077b.f5109g;
    }

    public float G() {
        return this.f5077b.f5103a.r().a(u());
    }

    public float H() {
        return this.f5077b.f5103a.t().a(u());
    }

    public float I() {
        return this.f5077b.f5118p;
    }

    public float J() {
        return w() + I();
    }

    public void N(Context context) {
        this.f5077b.f5104b = new c1.a(context);
        i0();
    }

    public boolean P() {
        c1.a aVar = this.f5077b.f5104b;
        return aVar != null && aVar.d();
    }

    public boolean Q() {
        return this.f5077b.f5103a.u(u());
    }

    public boolean U() {
        int i3 = Build.VERSION.SDK_INT;
        return i3 < 21 || !(Q() || this.f5083h.isConvex() || i3 >= 29);
    }

    public void V(k1.c cVar) {
        setShapeAppearanceModel(this.f5077b.f5103a.x(cVar));
    }

    public void W(float f3) {
        c cVar = this.f5077b;
        if (cVar.f5117o != f3) {
            cVar.f5117o = f3;
            i0();
        }
    }

    public void X(ColorStateList colorStateList) {
        c cVar = this.f5077b;
        if (cVar.f5106d != colorStateList) {
            cVar.f5106d = colorStateList;
            onStateChange(getState());
        }
    }

    public void Y(float f3) {
        c cVar = this.f5077b;
        if (cVar.f5113k != f3) {
            cVar.f5113k = f3;
            this.f5081f = true;
            invalidateSelf();
        }
    }

    public void Z(int i3, int i4, int i5, int i6) {
        c cVar = this.f5077b;
        if (cVar.f5111i == null) {
            cVar.f5111i = new Rect();
        }
        this.f5077b.f5111i.set(i3, i4, i5, i6);
        invalidateSelf();
    }

    public void a0(float f3) {
        c cVar = this.f5077b;
        if (cVar.f5116n != f3) {
            cVar.f5116n = f3;
            i0();
        }
    }

    public void b0(int i3) {
        c cVar = this.f5077b;
        if (cVar.f5122t != i3) {
            cVar.f5122t = i3;
            O();
        }
    }

    public void c0(float f3, int i3) {
        f0(f3);
        e0(ColorStateList.valueOf(i3));
    }

    public void d0(float f3, ColorStateList colorStateList) {
        f0(f3);
        e0(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f5090o.setColorFilter(this.f5095t);
        int alpha = this.f5090o.getAlpha();
        this.f5090o.setAlpha(S(alpha, this.f5077b.f5115m));
        this.f5091p.setColorFilter(this.f5096u);
        this.f5091p.setStrokeWidth(this.f5077b.f5114l);
        int alpha2 = this.f5091p.getAlpha();
        this.f5091p.setAlpha(S(alpha2, this.f5077b.f5115m));
        if (this.f5081f) {
            i();
            g(u(), this.f5083h);
            this.f5081f = false;
        }
        R(canvas);
        if (L()) {
            o(canvas);
        }
        if (M()) {
            r(canvas);
        }
        this.f5090o.setAlpha(alpha);
        this.f5091p.setAlpha(alpha2);
    }

    public void e0(ColorStateList colorStateList) {
        c cVar = this.f5077b;
        if (cVar.f5107e != colorStateList) {
            cVar.f5107e = colorStateList;
            onStateChange(getState());
        }
    }

    public void f0(float f3) {
        this.f5077b.f5114l = f3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5077b.f5115m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5077b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f5077b.f5119q == 2) {
            return;
        }
        if (Q()) {
            outline.setRoundRect(getBounds(), G() * this.f5077b.f5113k);
            return;
        }
        g(u(), this.f5083h);
        if (this.f5083h.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f5083h);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f5077b.f5111i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f5087l.set(getBounds());
        g(u(), this.f5083h);
        this.f5088m.setPath(this.f5083h, this.f5087l);
        this.f5087l.op(this.f5088m, Region.Op.DIFFERENCE);
        return this.f5087l;
    }

    protected final void h(RectF rectF, Path path) {
        l lVar = this.f5094s;
        c cVar = this.f5077b;
        lVar.e(cVar.f5103a, cVar.f5113k, rectF, this.f5093r, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f5081f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f5077b.f5109g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f5077b.f5108f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f5077b.f5107e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f5077b.f5106d) != null && colorStateList4.isStateful())));
    }

    protected int l(int i3) {
        float fJ = J() + y();
        c1.a aVar = this.f5077b.f5104b;
        return aVar != null ? aVar.c(i3, fJ) : i3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f5077b = new c(this.f5077b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f5081f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.k.b
    protected boolean onStateChange(int[] iArr) {
        boolean z2 = g0(iArr) || h0();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    protected void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f5077b.f5103a, rectF);
    }

    protected void r(Canvas canvas) {
        q(canvas, this.f5091p, this.f5084i, this.f5089n, v());
    }

    public float s() {
        return this.f5077b.f5103a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        c cVar = this.f5077b;
        if (cVar.f5115m != i3) {
            cVar.f5115m = i3;
            O();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5077b.f5105c = colorFilter;
        O();
    }

    @Override // k1.n
    public void setShapeAppearanceModel(k kVar) {
        this.f5077b.f5103a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        this.f5077b.f5109g = colorStateList;
        h0();
        O();
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f5077b;
        if (cVar.f5110h != mode) {
            cVar.f5110h = mode;
            h0();
            O();
        }
    }

    public float t() {
        return this.f5077b.f5103a.l().a(u());
    }

    protected RectF u() {
        this.f5085j.set(getBounds());
        return this.f5085j;
    }

    public float w() {
        return this.f5077b.f5117o;
    }

    public ColorStateList x() {
        return this.f5077b.f5106d;
    }

    public float y() {
        return this.f5077b.f5116n;
    }

    public int z() {
        return this.f5097v;
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(k.e(context, attributeSet, i3, i4).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private g(c cVar) {
        l lVar;
        this.f5078c = new m.g[4];
        this.f5079d = new m.g[4];
        this.f5080e = new BitSet(8);
        this.f5082g = new Matrix();
        this.f5083h = new Path();
        this.f5084i = new Path();
        this.f5085j = new RectF();
        this.f5086k = new RectF();
        this.f5087l = new Region();
        this.f5088m = new Region();
        Paint paint = new Paint(1);
        this.f5090o = paint;
        Paint paint2 = new Paint(1);
        this.f5091p = paint2;
        this.f5092q = new j1.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.f5094s = lVar;
        this.f5098w = new RectF();
        this.f5099x = true;
        this.f5077b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        h0();
        g0(getState());
        this.f5093r = new a();
    }

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    static final class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k f5103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c1.a f5104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorFilter f5105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f5106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ColorStateList f5107e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ColorStateList f5108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f5109g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f5110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Rect f5111i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f5112j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f5113k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f5114l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f5115m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f5116n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f5117o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f5118p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f5119q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f5120r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f5121s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f5122t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f5123u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f5124v;

        public c(k kVar, c1.a aVar) {
            this.f5106d = null;
            this.f5107e = null;
            this.f5108f = null;
            this.f5109g = null;
            this.f5110h = PorterDuff.Mode.SRC_IN;
            this.f5111i = null;
            this.f5112j = 1.0f;
            this.f5113k = 1.0f;
            this.f5115m = 255;
            this.f5116n = 0.0f;
            this.f5117o = 0.0f;
            this.f5118p = 0.0f;
            this.f5119q = 0;
            this.f5120r = 0;
            this.f5121s = 0;
            this.f5122t = 0;
            this.f5123u = false;
            this.f5124v = Paint.Style.FILL_AND_STROKE;
            this.f5103a = kVar;
            this.f5104b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f5081f = true;
            return gVar;
        }

        public c(c cVar) {
            this.f5106d = null;
            this.f5107e = null;
            this.f5108f = null;
            this.f5109g = null;
            this.f5110h = PorterDuff.Mode.SRC_IN;
            this.f5111i = null;
            this.f5112j = 1.0f;
            this.f5113k = 1.0f;
            this.f5115m = 255;
            this.f5116n = 0.0f;
            this.f5117o = 0.0f;
            this.f5118p = 0.0f;
            this.f5119q = 0;
            this.f5120r = 0;
            this.f5121s = 0;
            this.f5122t = 0;
            this.f5123u = false;
            this.f5124v = Paint.Style.FILL_AND_STROKE;
            this.f5103a = cVar.f5103a;
            this.f5104b = cVar.f5104b;
            this.f5114l = cVar.f5114l;
            this.f5105c = cVar.f5105c;
            this.f5106d = cVar.f5106d;
            this.f5107e = cVar.f5107e;
            this.f5110h = cVar.f5110h;
            this.f5109g = cVar.f5109g;
            this.f5115m = cVar.f5115m;
            this.f5112j = cVar.f5112j;
            this.f5121s = cVar.f5121s;
            this.f5119q = cVar.f5119q;
            this.f5123u = cVar.f5123u;
            this.f5113k = cVar.f5113k;
            this.f5116n = cVar.f5116n;
            this.f5117o = cVar.f5117o;
            this.f5118p = cVar.f5118p;
            this.f5120r = cVar.f5120r;
            this.f5122t = cVar.f5122t;
            this.f5108f = cVar.f5108f;
            this.f5124v = cVar.f5124v;
            if (cVar.f5111i != null) {
                this.f5111i = new Rect(cVar.f5111i);
            }
        }
    }
}
