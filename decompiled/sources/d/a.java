package d;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.m0;
import java.io.IOException;
import l.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class a extends d.d implements x.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f4444u = a.class.getSimpleName();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private c f4445p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private g f4446q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f4447r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4448s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4449t;

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f4450a;

        b(Animatable animatable) {
            super();
            this.f4450a = animatable;
        }

        @Override // d.a.g
        public void c() {
            this.f4450a.start();
        }

        @Override // d.a.g
        public void d() {
            this.f4450a.stop();
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static class c extends d.d.a {
        l.d<Long> K;
        h<Integer> L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                this.K = new l.d<>();
                this.L = new h<>();
            }
        }

        private static long D(int i3, int i4) {
            return ((long) i4) | (((long) i3) << 32);
        }

        int B(int[] iArr, Drawable drawable, int i3) {
            int iZ = super.z(iArr, drawable);
            this.L.i(iZ, Integer.valueOf(i3));
            return iZ;
        }

        int C(int i3, int i4, Drawable drawable, boolean z2) {
            int iA = super.a(drawable);
            long jD = D(i3, i4);
            long j3 = z2 ? 8589934592L : 0L;
            long j4 = iA;
            this.K.a(jD, Long.valueOf(j4 | j3));
            if (z2) {
                this.K.a(D(i4, i3), Long.valueOf(4294967296L | j4 | j3));
            }
            return iA;
        }

        int E(int i3) {
            if (i3 < 0) {
                return 0;
            }
            return this.L.f(i3, 0).intValue();
        }

        int F(int[] iArr) {
            int iA = super.A(iArr);
            return iA >= 0 ? iA : super.A(StateSet.WILD_CARD);
        }

        int G(int i3, int i4) {
            return (int) this.K.f(D(i3, i4), -1L).longValue();
        }

        boolean H(int i3, int i4) {
            return (this.K.f(D(i3, i4), -1L).longValue() & 4294967296L) != 0;
        }

        boolean I(int i3, int i4) {
            return (this.K.f(D(i3, i4), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // d.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // d.d.a, d.b.c
        void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // d.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.b f4451a;

        d(androidx.vectordrawable.graphics.drawable.b bVar) {
            super();
            this.f4451a = bVar;
        }

        @Override // d.a.g
        public void c() {
            this.f4451a.start();
        }

        @Override // d.a.g
        public void d() {
            this.f4451a.stop();
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f4452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4453b;

        e(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i3 = z2 ? numberOfFrames - 1 : 0;
            int i4 = z2 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z2);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i3, i4);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(fVar.a());
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f4453b = z3;
            this.f4452a = objectAnimatorOfInt;
        }

        @Override // d.a.g
        public boolean a() {
            return this.f4453b;
        }

        @Override // d.a.g
        public void b() {
            this.f4452a.reverse();
        }

        @Override // d.a.g
        public void c() {
            this.f4452a.start();
        }

        @Override // d.a.g
        public void d() {
            this.f4452a.cancel();
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class f implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f4454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4456c;

        f(AnimationDrawable animationDrawable, boolean z2) {
            b(animationDrawable, z2);
        }

        int a() {
            return this.f4456c;
        }

        int b(AnimationDrawable animationDrawable, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f4455b = numberOfFrames;
            int[] iArr = this.f4454a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f4454a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f4454a;
            int i3 = 0;
            for (int i4 = 0; i4 < numberOfFrames; i4++) {
                int duration = animationDrawable.getDuration(z2 ? (numberOfFrames - i4) - 1 : i4);
                iArr2[i4] = duration;
                i3 += duration;
            }
            this.f4456c = i3;
            return i3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            int i3 = (int) ((f3 * this.f4456c) + 0.5f);
            int i4 = this.f4455b;
            int[] iArr = this.f4454a;
            int i5 = 0;
            while (i5 < i4 && i3 >= iArr[i5]) {
                i3 -= iArr[i5];
                i5++;
            }
            return (i5 / i4) + (i5 < i4 ? i3 / this.f4456c : 0.0f);
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    r(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, e.b.AnimatedStateListDrawableItem);
        int resourceId = typedArrayS.getResourceId(e.b.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayS.getResourceId(e.b.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableJ = resourceId2 > 0 ? m0.h().j(context, resourceId2) : null;
        typedArrayS.recycle();
        int[] iArrK = k(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableJ = androidx.vectordrawable.graphics.drawable.h.c(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableJ = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableJ != null) {
            return this.f4445p.B(iArrK, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, e.b.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayS.getResourceId(e.b.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayS.getResourceId(e.b.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayS.getResourceId(e.b.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableJ = resourceId3 > 0 ? m0.h().j(context, resourceId3) : null;
        boolean z2 = typedArrayS.getBoolean(e.b.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayS.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableJ = androidx.vectordrawable.graphics.drawable.b.a(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableJ = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f4445p.C(resourceId, resourceId2, drawableJ, z2);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    private boolean s(int i3) {
        int iC;
        int iG;
        g bVar;
        g gVar = this.f4446q;
        if (gVar == null) {
            iC = c();
        } else {
            if (i3 == this.f4447r) {
                return true;
            }
            if (i3 == this.f4448s && gVar.a()) {
                gVar.b();
                this.f4447r = this.f4448s;
                this.f4448s = i3;
                return true;
            }
            iC = this.f4447r;
            gVar.d();
        }
        this.f4446q = null;
        this.f4448s = -1;
        this.f4447r = -1;
        c cVar = this.f4445p;
        int iE = cVar.E(iC);
        int iE2 = cVar.E(i3);
        if (iE2 == 0 || iE == 0 || (iG = cVar.G(iE, iE2)) < 0) {
            return false;
        }
        boolean zI = cVar.I(iE, iE2);
        g(iG);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(iE, iE2), zI);
        } else {
            if (!(current instanceof androidx.vectordrawable.graphics.drawable.b)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((androidx.vectordrawable.graphics.drawable.b) current);
        }
        bVar.c();
        this.f4446q = bVar;
        this.f4448s = iC;
        this.f4447r = i3;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.f4445p;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f4474d |= typedArray.getChangingConfigurations();
        }
        cVar.x(typedArray.getBoolean(e.b.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f4479i));
        cVar.t(typedArray.getBoolean(e.b.AnimatedStateListDrawableCompat_android_constantSize, cVar.f4482l));
        cVar.u(typedArray.getInt(e.b.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.v(typedArray.getInt(e.b.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(e.b.AnimatedStateListDrawableCompat_android_dither, cVar.f4494x));
    }

    @Override // d.d, d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // d.d, d.b
    void h(d.b.c cVar) {
        super.h(cVar);
        if (cVar instanceof c) {
            this.f4445p = (c) cVar;
        }
    }

    @Override // d.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // d.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f4446q;
        if (gVar != null) {
            gVar.d();
            this.f4446q = null;
            g(this.f4447r);
            this.f4447r = -1;
            this.f4448s = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.f4445p, this, null);
    }

    @Override // d.d, d.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f4449t && super.mutate() == this) {
            this.f4445p.r();
            this.f4449t = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, e.b.AnimatedStateListDrawableCompat);
        setVisible(typedArrayS.getBoolean(e.b.AnimatedStateListDrawableCompat_android_visible, true), true);
        t(typedArrayS);
        i(resources);
        typedArrayS.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i3) {
        return super.onLayoutDirectionChanged(i3);
    }

    @Override // d.d, d.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iF = this.f4445p.F(iArr);
        boolean z2 = iF != c() && (s(iF) || g(iF));
        Drawable current = getCurrent();
        return current != null ? z2 | current.setState(iArr) : z2;
    }

    @Override // d.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        super.scheduleDrawable(drawable, runnable, j3);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i3) {
        super.setAlpha(i3);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z2) {
        super.setAutoMirrored(z2);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z2) {
        super.setDither(z2);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f3, float f4) {
        super.setHotspot(f3, f4);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i3, int i4, int i5, int i6) {
        super.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // d.b, android.graphics.drawable.Drawable, x.b
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // d.b, android.graphics.drawable.Drawable, x.b
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        g gVar = this.f4446q;
        if (gVar != null && (visible || z3)) {
            if (z2) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // d.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    a(c cVar, Resources resources) {
        super(null);
        this.f4447r = -1;
        this.f4448s = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
