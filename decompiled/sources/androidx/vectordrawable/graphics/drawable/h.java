package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.vivo.seckeysdk.SecurityKeyCipher;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: VectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.vectordrawable.graphics.drawable.g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final PorterDuff.Mode f2146l = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0023h f2147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuffColorFilter f2148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorFilter f2149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable.ConstantState f2152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f2153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Matrix f2154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Rect f2155k;

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2182b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2181a = w.c.d(string2);
            }
            this.f2183c = v.g.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (v.g.r(xmlPullParser, "pathData")) {
                TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2119d);
                f(typedArrayS, xmlPullParser);
                typedArrayS.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class C0023h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f2203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f2204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f2205d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f2206e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Bitmap f2207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ColorStateList f2208g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f2209h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f2210i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f2211j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f2212k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Paint f2213l;

        public C0023h(C0023h c0023h) {
            this.f2204c = null;
            this.f2205d = h.f2146l;
            if (c0023h != null) {
                this.f2202a = c0023h.f2202a;
                g gVar = new g(c0023h.f2203b);
                this.f2203b = gVar;
                if (c0023h.f2203b.f2190e != null) {
                    gVar.f2190e = new Paint(c0023h.f2203b.f2190e);
                }
                if (c0023h.f2203b.f2189d != null) {
                    this.f2203b.f2189d = new Paint(c0023h.f2203b.f2189d);
                }
                this.f2204c = c0023h.f2204c;
                this.f2205d = c0023h.f2205d;
                this.f2206e = c0023h.f2206e;
            }
        }

        public boolean a(int i3, int i4) {
            return i3 == this.f2207f.getWidth() && i4 == this.f2207f.getHeight();
        }

        public boolean b() {
            return !this.f2212k && this.f2208g == this.f2204c && this.f2209h == this.f2205d && this.f2211j == this.f2206e && this.f2210i == this.f2203b.getRootAlpha();
        }

        public void c(int i3, int i4) {
            if (this.f2207f == null || !a(i3, i4)) {
                this.f2207f = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                this.f2212k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f2207f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f2213l == null) {
                Paint paint = new Paint();
                this.f2213l = paint;
                paint.setFilterBitmap(true);
            }
            this.f2213l.setAlpha(this.f2203b.getRootAlpha());
            this.f2213l.setColorFilter(colorFilter);
            return this.f2213l;
        }

        public boolean f() {
            return this.f2203b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f2203b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2202a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f2203b.g(iArr);
            this.f2212k |= zG;
            return zG;
        }

        public void i() {
            this.f2208g = this.f2204c;
            this.f2209h = this.f2205d;
            this.f2210i = this.f2203b.getRootAlpha();
            this.f2211j = this.f2206e;
            this.f2212k = false;
        }

        public void j(int i3, int i4) {
            this.f2207f.eraseColor(0);
            this.f2203b.b(new Canvas(this.f2207f), i3, i4, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this);
        }

        public C0023h() {
            this.f2204c = null;
            this.f2205d = h.f2146l;
            this.f2203b = new g();
        }
    }

    h() {
        this.f2151g = true;
        this.f2153i = new float[9];
        this.f2154j = new Matrix();
        this.f2155k = new Rect();
        this.f2147c = new C0023h();
    }

    static int a(int i3, float f3) {
        return (i3 & 16777215) | (((int) (Color.alpha(i3) * f3)) << 24);
    }

    public static h b(Resources resources, int i3, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            h hVar = new h();
            hVar.f2145b = v.f.b(resources, i3, theme);
            hVar.f2152h = new i(hVar.f2145b.getConstantState());
            return hVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i3);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        } catch (XmlPullParserException e4) {
            Log.e("VectorDrawableCompat", "parser error", e4);
            return null;
        }
    }

    public static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = new h();
        hVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return hVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0023h c0023h = this.f2147c;
        g gVar = c0023h.f2203b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f2193h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f2169b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f2201p.put(cVar.getPathName(), cVar);
                    }
                    z2 = false;
                    c0023h.f2202a = cVar.f2184d | c0023h.f2202a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f2169b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f2201p.put(bVar.getPathName(), bVar);
                    }
                    c0023h.f2202a = bVar.f2184d | c0023h.f2202a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f2169b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f2201p.put(dVar2.getGroupName(), dVar2);
                    }
                    c0023h.f2202a = dVar2.f2178k | c0023h.f2202a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && x.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        C0023h c0023h = this.f2147c;
        g gVar = c0023h.f2203b;
        c0023h.f2205d = g(v.g.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = v.g.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            c0023h.f2204c = colorStateListG;
        }
        c0023h.f2206e = v.g.e(typedArray, xmlPullParser, "autoMirrored", 5, c0023h.f2206e);
        gVar.f2196k = v.g.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f2196k);
        float fJ = v.g.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f2197l);
        gVar.f2197l = fJ;
        if (gVar.f2196k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f2194i = typedArray.getDimension(3, gVar.f2194i);
        float dimension = typedArray.getDimension(2, gVar.f2195j);
        gVar.f2195j = dimension;
        if (gVar.f2194i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(v.g.j(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f2199n = string;
            gVar.f2201p.put(string, gVar);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f2145b;
        if (drawable == null) {
            return false;
        }
        x.a.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    Object d(String str) {
        return this.f2147c.f2203b.f2201p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f2155k);
        if (this.f2155k.width() <= 0 || this.f2155k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f2149e;
        if (colorFilter == null) {
            colorFilter = this.f2148d;
        }
        canvas.getMatrix(this.f2154j);
        this.f2154j.getValues(this.f2153i);
        float fAbs = Math.abs(this.f2153i[0]);
        float fAbs2 = Math.abs(this.f2153i[4]);
        float fAbs3 = Math.abs(this.f2153i[1]);
        float fAbs4 = Math.abs(this.f2153i[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (this.f2155k.width() * fAbs);
        int iHeight = (int) (this.f2155k.height() * fAbs2);
        int iMin = Math.min(SecurityKeyCipher.SECURITY_DATA_SIZE_MAX, iWidth);
        int iMin2 = Math.min(SecurityKeyCipher.SECURITY_DATA_SIZE_MAX, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f2155k;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f2155k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f2155k.offsetTo(0, 0);
        this.f2147c.c(iMin, iMin2);
        if (!this.f2151g) {
            this.f2147c.j(iMin, iMin2);
        } else if (!this.f2147c.b()) {
            this.f2147c.j(iMin, iMin2);
            this.f2147c.i();
        }
        this.f2147c.d(canvas, colorFilter, this.f2155k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f2145b;
        return drawable != null ? x.a.d(drawable) : this.f2147c.f2203b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f2147c.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2145b;
        return drawable != null ? x.a.e(drawable) : this.f2149e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2145b != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f2145b.getConstantState());
        }
        this.f2147c.f2202a = getChangingConfigurations();
        return this.f2147c;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2147c.f2203b.f2195j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2147c.f2203b.f2194i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    void h(boolean z2) {
        this.f2151g = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f2145b;
        return drawable != null ? x.a.h(drawable) : this.f2147c.f2206e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0023h c0023h;
        ColorStateList colorStateList;
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((c0023h = this.f2147c) != null && (c0023h.g() || ((colorStateList = this.f2147c.f2204c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2150f && super.mutate() == this) {
            this.f2147c = new C0023h(this.f2147c);
            this.f2150f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z2 = false;
        C0023h c0023h = this.f2147c;
        ColorStateList colorStateList = c0023h.f2204c;
        if (colorStateList != null && (mode = c0023h.f2205d) != null) {
            this.f2148d = j(this.f2148d, colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        if (!c0023h.g() || !c0023h.h(iArr)) {
            return z2;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j3) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j3);
        } else {
            super.scheduleSelf(runnable, j3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else if (this.f2147c.f2203b.getRootAlpha() != i3) {
            this.f2147c.f2203b.setRootAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.j(drawable, z2);
        } else {
            this.f2147c.f2206e = z2;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i3) {
        super.setChangingConfigurations(i3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i3, PorterDuff.Mode mode) {
        super.setColorFilter(i3, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f3, float f4) {
        super.setHotspot(f3, f4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i3, int i4, int i5, int i6) {
        super.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTint(int i3) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.n(drawable, i3);
        } else {
            setTintList(ColorStateList.valueOf(i3));
        }
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.o(drawable, colorStateList);
            return;
        }
        C0023h c0023h = this.f2147c;
        if (c0023h.f2204c != colorStateList) {
            c0023h.f2204c = colorStateList;
            this.f2148d = j(this.f2148d, colorStateList, c0023h.f2205d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.p(drawable, mode);
            return;
        }
        C0023h c0023h = this.f2147c;
        if (c0023h.f2205d != mode) {
            c0023h.f2205d = mode;
            this.f2148d = j(this.f2148d, c0023h.f2204c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.setVisible(z2, z3) : super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f2214a;

        public i(Drawable.ConstantState constantState) {
            this.f2214a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2214a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2214a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h();
            hVar.f2145b = (VectorDrawable) this.f2214a.newDrawable();
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            h hVar = new h();
            hVar.f2145b = (VectorDrawable) this.f2214a.newDrawable(resources);
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            h hVar = new h();
            hVar.f2145b = (VectorDrawable) this.f2214a.newDrawable(resources, theme);
            return hVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2149e = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static abstract class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected w.c.b[] f2181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2184d;

        public f() {
            super();
            this.f2181a = null;
            this.f2183c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            w.c.b[] bVarArr = this.f2181a;
            if (bVarArr != null) {
                w.c.b.e(bVarArr, path);
            }
        }

        public w.c.b[] getPathData() {
            return this.f2181a;
        }

        public String getPathName() {
            return this.f2182b;
        }

        public void setPathData(w.c.b[] bVarArr) {
            if (w.c.b(this.f2181a, bVarArr)) {
                w.c.j(this.f2181a, bVarArr);
            } else {
                this.f2181a = w.c.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f2181a = null;
            this.f2183c = 0;
            this.f2182b = fVar.f2182b;
            this.f2184d = fVar.f2184d;
            this.f2181a = w.c.f(fVar.f2181a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0023h c0023h = this.f2147c;
        c0023h.f2203b = new g();
        TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2116a);
        i(typedArrayS, xmlPullParser, theme);
        typedArrayS.recycle();
        c0023h.f2202a = getChangingConfigurations();
        c0023h.f2212k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f2148d = j(this.f2148d, c0023h.f2204c, c0023h.f2205d);
    }

    h(C0023h c0023h) {
        this.f2151g = true;
        this.f2153i = new float[9];
        this.f2154j = new Matrix();
        this.f2155k = new Rect();
        this.f2147c = c0023h;
        this.f2148d = j(this.f2148d, c0023h.f2204c, c0023h.f2205d);
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f2156e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        v.b f2157f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f2158g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        v.b f2159h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f2160i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f2161j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f2162k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f2163l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float f2164m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Paint.Cap f2165n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Paint.Join f2166o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f2167p;

        c() {
            this.f2158g = 0.0f;
            this.f2160i = 1.0f;
            this.f2161j = 1.0f;
            this.f2162k = 0.0f;
            this.f2163l = 1.0f;
            this.f2164m = 0.0f;
            this.f2165n = Paint.Cap.BUTT;
            this.f2166o = Paint.Join.MITER;
            this.f2167p = 4.0f;
        }

        private Paint.Cap e(int i3, Paint.Cap cap) {
            if (i3 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i3 != 1) {
                return i3 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join f(int i3, Paint.Join join) {
            if (i3 == 0) {
                return Paint.Join.MITER;
            }
            if (i3 != 1) {
                return i3 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2156e = null;
            if (v.g.r(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2182b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2181a = w.c.d(string2);
                }
                this.f2159h = v.g.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f2161j = v.g.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f2161j);
                this.f2165n = e(v.g.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f2165n);
                this.f2166o = f(v.g.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f2166o);
                this.f2167p = v.g.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f2167p);
                this.f2157f = v.g.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f2160i = v.g.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2160i);
                this.f2158g = v.g.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f2158g);
                this.f2163l = v.g.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2163l);
                this.f2164m = v.g.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f2164m);
                this.f2162k = v.g.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f2162k);
                this.f2183c = v.g.k(typedArray, xmlPullParser, "fillType", 13, this.f2183c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean a() {
            return this.f2159h.i() || this.f2157f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean b(int[] iArr) {
            return this.f2157f.j(iArr) | this.f2159h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2118c);
            h(typedArrayS, xmlPullParser, theme);
            typedArrayS.recycle();
        }

        float getFillAlpha() {
            return this.f2161j;
        }

        int getFillColor() {
            return this.f2159h.e();
        }

        float getStrokeAlpha() {
            return this.f2160i;
        }

        int getStrokeColor() {
            return this.f2157f.e();
        }

        float getStrokeWidth() {
            return this.f2158g;
        }

        float getTrimPathEnd() {
            return this.f2163l;
        }

        float getTrimPathOffset() {
            return this.f2164m;
        }

        float getTrimPathStart() {
            return this.f2162k;
        }

        void setFillAlpha(float f3) {
            this.f2161j = f3;
        }

        void setFillColor(int i3) {
            this.f2159h.k(i3);
        }

        void setStrokeAlpha(float f3) {
            this.f2160i = f3;
        }

        void setStrokeColor(int i3) {
            this.f2157f.k(i3);
        }

        void setStrokeWidth(float f3) {
            this.f2158g = f3;
        }

        void setTrimPathEnd(float f3) {
            this.f2163l = f3;
        }

        void setTrimPathOffset(float f3) {
            this.f2164m = f3;
        }

        void setTrimPathStart(float f3) {
            this.f2162k = f3;
        }

        c(c cVar) {
            super(cVar);
            this.f2158g = 0.0f;
            this.f2160i = 1.0f;
            this.f2161j = 1.0f;
            this.f2162k = 0.0f;
            this.f2163l = 1.0f;
            this.f2164m = 0.0f;
            this.f2165n = Paint.Cap.BUTT;
            this.f2166o = Paint.Join.MITER;
            this.f2167p = 4.0f;
            this.f2156e = cVar.f2156e;
            this.f2157f = cVar.f2157f;
            this.f2158g = cVar.f2158g;
            this.f2160i = cVar.f2160i;
            this.f2159h = cVar.f2159h;
            this.f2183c = cVar.f2183c;
            this.f2161j = cVar.f2161j;
            this.f2162k = cVar.f2162k;
            this.f2163l = cVar.f2163l;
            this.f2164m = cVar.f2164m;
            this.f2165n = cVar.f2165n;
            this.f2166o = cVar.f2166o;
            this.f2167p = cVar.f2167p;
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class g {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final Matrix f2185q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f2186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f2187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Matrix f2188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f2189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f2190e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PathMeasure f2191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2192g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final d f2193h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f2194i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f2195j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f2196k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f2197l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f2198m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f2199n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Boolean f2200o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final l.a<String, Object> f2201p;

        public g() {
            this.f2188c = new Matrix();
            this.f2194i = 0.0f;
            this.f2195j = 0.0f;
            this.f2196k = 0.0f;
            this.f2197l = 0.0f;
            this.f2198m = 255;
            this.f2199n = null;
            this.f2200o = null;
            this.f2201p = new l.a<>();
            this.f2193h = new d();
            this.f2186a = new Path();
            this.f2187b = new Path();
        }

        private static float a(float f3, float f4, float f5, float f6) {
            return (f3 * f6) - (f4 * f5);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            dVar.f2168a.set(matrix);
            dVar.f2168a.preConcat(dVar.f2177j);
            canvas.save();
            for (int i5 = 0; i5 < dVar.f2169b.size(); i5++) {
                e eVar = dVar.f2169b.get(i5);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f2168a, canvas, i3, i4, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i3, i4, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            float f3 = i3 / this.f2196k;
            float f4 = i4 / this.f2197l;
            float fMin = Math.min(f3, f4);
            Matrix matrix = dVar.f2168a;
            this.f2188c.set(matrix);
            this.f2188c.postScale(f3, f4);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.d(this.f2186a);
            Path path = this.f2186a;
            this.f2187b.reset();
            if (fVar.c()) {
                this.f2187b.setFillType(fVar.f2183c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f2187b.addPath(path, this.f2188c);
                canvas.clipPath(this.f2187b);
                return;
            }
            c cVar = (c) fVar;
            float f5 = cVar.f2162k;
            if (f5 != 0.0f || cVar.f2163l != 1.0f) {
                float f6 = cVar.f2164m;
                float f7 = (f5 + f6) % 1.0f;
                float f8 = (cVar.f2163l + f6) % 1.0f;
                if (this.f2191f == null) {
                    this.f2191f = new PathMeasure();
                }
                this.f2191f.setPath(this.f2186a, false);
                float length = this.f2191f.getLength();
                float f9 = f7 * length;
                float f10 = f8 * length;
                path.reset();
                if (f9 > f10) {
                    this.f2191f.getSegment(f9, length, path, true);
                    this.f2191f.getSegment(0.0f, f10, path, true);
                } else {
                    this.f2191f.getSegment(f9, f10, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f2187b.addPath(path, this.f2188c);
            if (cVar.f2159h.l()) {
                v.b bVar = cVar.f2159h;
                if (this.f2190e == null) {
                    Paint paint = new Paint(1);
                    this.f2190e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f2190e;
                if (bVar.h()) {
                    Shader shaderF = bVar.f();
                    shaderF.setLocalMatrix(this.f2188c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f2161j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(h.a(bVar.e(), cVar.f2161j));
                }
                paint2.setColorFilter(colorFilter);
                this.f2187b.setFillType(cVar.f2183c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f2187b, paint2);
            }
            if (cVar.f2157f.l()) {
                v.b bVar2 = cVar.f2157f;
                if (this.f2189d == null) {
                    Paint paint3 = new Paint(1);
                    this.f2189d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f2189d;
                Paint.Join join = cVar.f2166o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f2165n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f2167p);
                if (bVar2.h()) {
                    Shader shaderF2 = bVar2.f();
                    shaderF2.setLocalMatrix(this.f2188c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f2160i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(h.a(bVar2.e(), cVar.f2160i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f2158g * fMin * fE);
                canvas.drawPath(this.f2187b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            c(this.f2193h, f2185q, canvas, i3, i4, colorFilter);
        }

        public boolean f() {
            if (this.f2200o == null) {
                this.f2200o = Boolean.valueOf(this.f2193h.a());
            }
            return this.f2200o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f2193h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f2198m;
        }

        public void setAlpha(float f3) {
            setRootAlpha((int) (f3 * 255.0f));
        }

        public void setRootAlpha(int i3) {
            this.f2198m = i3;
        }

        public g(g gVar) {
            this.f2188c = new Matrix();
            this.f2194i = 0.0f;
            this.f2195j = 0.0f;
            this.f2196k = 0.0f;
            this.f2197l = 0.0f;
            this.f2198m = 255;
            this.f2199n = null;
            this.f2200o = null;
            l.a<String, Object> aVar = new l.a<>();
            this.f2201p = aVar;
            this.f2193h = new d(gVar.f2193h, aVar);
            this.f2186a = new Path(gVar.f2186a);
            this.f2187b = new Path(gVar.f2187b);
            this.f2194i = gVar.f2194i;
            this.f2195j = gVar.f2195j;
            this.f2196k = gVar.f2196k;
            this.f2197l = gVar.f2197l;
            this.f2192g = gVar.f2192g;
            this.f2198m = gVar.f2198m;
            this.f2199n = gVar.f2199n;
            String str = gVar.f2199n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f2200o = gVar.f2200o;
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f2168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<e> f2169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f2170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f2171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f2172e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f2173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f2174g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f2175h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f2176i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Matrix f2177j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f2178k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int[] f2179l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f2180m;

        public d(d dVar, l.a<String, Object> aVar) {
            f bVar;
            super();
            this.f2168a = new Matrix();
            this.f2169b = new ArrayList<>();
            this.f2170c = 0.0f;
            this.f2171d = 0.0f;
            this.f2172e = 0.0f;
            this.f2173f = 1.0f;
            this.f2174g = 1.0f;
            this.f2175h = 0.0f;
            this.f2176i = 0.0f;
            Matrix matrix = new Matrix();
            this.f2177j = matrix;
            this.f2180m = null;
            this.f2170c = dVar.f2170c;
            this.f2171d = dVar.f2171d;
            this.f2172e = dVar.f2172e;
            this.f2173f = dVar.f2173f;
            this.f2174g = dVar.f2174g;
            this.f2175h = dVar.f2175h;
            this.f2176i = dVar.f2176i;
            this.f2179l = dVar.f2179l;
            String str = dVar.f2180m;
            this.f2180m = str;
            this.f2178k = dVar.f2178k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f2177j);
            ArrayList<e> arrayList = dVar.f2169b;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                e eVar = arrayList.get(i3);
                if (eVar instanceof d) {
                    this.f2169b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f2169b.add(bVar);
                    String str2 = bVar.f2182b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f2177j.reset();
            this.f2177j.postTranslate(-this.f2171d, -this.f2172e);
            this.f2177j.postScale(this.f2173f, this.f2174g);
            this.f2177j.postRotate(this.f2170c, 0.0f, 0.0f);
            this.f2177j.postTranslate(this.f2175h + this.f2171d, this.f2176i + this.f2172e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f2179l = null;
            this.f2170c = v.g.j(typedArray, xmlPullParser, "rotation", 5, this.f2170c);
            this.f2171d = typedArray.getFloat(1, this.f2171d);
            this.f2172e = typedArray.getFloat(2, this.f2172e);
            this.f2173f = v.g.j(typedArray, xmlPullParser, "scaleX", 3, this.f2173f);
            this.f2174g = v.g.j(typedArray, xmlPullParser, "scaleY", 4, this.f2174g);
            this.f2175h = v.g.j(typedArray, xmlPullParser, "translateX", 6, this.f2175h);
            this.f2176i = v.g.j(typedArray, xmlPullParser, "translateY", 7, this.f2176i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2180m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean a() {
            for (int i3 = 0; i3 < this.f2169b.size(); i3++) {
                if (this.f2169b.get(i3).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i3 = 0; i3 < this.f2169b.size(); i3++) {
                zB |= this.f2169b.get(i3).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2117b);
            e(typedArrayS, xmlPullParser);
            typedArrayS.recycle();
        }

        public String getGroupName() {
            return this.f2180m;
        }

        public Matrix getLocalMatrix() {
            return this.f2177j;
        }

        public float getPivotX() {
            return this.f2171d;
        }

        public float getPivotY() {
            return this.f2172e;
        }

        public float getRotation() {
            return this.f2170c;
        }

        public float getScaleX() {
            return this.f2173f;
        }

        public float getScaleY() {
            return this.f2174g;
        }

        public float getTranslateX() {
            return this.f2175h;
        }

        public float getTranslateY() {
            return this.f2176i;
        }

        public void setPivotX(float f3) {
            if (f3 != this.f2171d) {
                this.f2171d = f3;
                d();
            }
        }

        public void setPivotY(float f3) {
            if (f3 != this.f2172e) {
                this.f2172e = f3;
                d();
            }
        }

        public void setRotation(float f3) {
            if (f3 != this.f2170c) {
                this.f2170c = f3;
                d();
            }
        }

        public void setScaleX(float f3) {
            if (f3 != this.f2173f) {
                this.f2173f = f3;
                d();
            }
        }

        public void setScaleY(float f3) {
            if (f3 != this.f2174g) {
                this.f2174g = f3;
                d();
            }
        }

        public void setTranslateX(float f3) {
            if (f3 != this.f2175h) {
                this.f2175h = f3;
                d();
            }
        }

        public void setTranslateY(float f3) {
            if (f3 != this.f2176i) {
                this.f2176i = f3;
                d();
            }
        }

        public d() {
            super();
            this.f2168a = new Matrix();
            this.f2169b = new ArrayList<>();
            this.f2170c = 0.0f;
            this.f2171d = 0.0f;
            this.f2172e = 0.0f;
            this.f2173f = 1.0f;
            this.f2174g = 1.0f;
            this.f2175h = 0.0f;
            this.f2176i = 0.0f;
            this.f2177j = new Matrix();
            this.f2180m = null;
        }
    }
}
