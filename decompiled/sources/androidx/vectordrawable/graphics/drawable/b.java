package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends g implements Animatable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0022b f2128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f2129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArgbEvaluator f2130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animator.AnimatorListener f2131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<Object> f2132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Drawable.Callback f2133h;

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            b.this.scheduleSelf(runnable, j3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    private static class C0022b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h f2136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnimatorSet f2137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<Animator> f2138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        l.a<Animator, String> f2139e;

        public C0022b(Context context, C0022b c0022b, Drawable.Callback callback, Resources resources) {
            if (c0022b != null) {
                this.f2135a = c0022b.f2135a;
                h hVar = c0022b.f2136b;
                if (hVar != null) {
                    Drawable.ConstantState constantState = hVar.getConstantState();
                    if (resources != null) {
                        this.f2136b = (h) constantState.newDrawable(resources);
                    } else {
                        this.f2136b = (h) constantState.newDrawable();
                    }
                    h hVar2 = (h) this.f2136b.mutate();
                    this.f2136b = hVar2;
                    hVar2.setCallback(callback);
                    this.f2136b.setBounds(c0022b.f2136b.getBounds());
                    this.f2136b.h(false);
                }
                ArrayList<Animator> arrayList = c0022b.f2138d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2138d = new ArrayList<>(size);
                    this.f2139e = new l.a<>(size);
                    for (int i3 = 0; i3 < size; i3++) {
                        Animator animator = c0022b.f2138d.get(i3);
                        Animator animatorClone = animator.clone();
                        String str = c0022b.f2139e.get(animator);
                        animatorClone.setTarget(this.f2136b.d(str));
                        this.f2138d.add(animatorClone);
                        this.f2139e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f2137c == null) {
                this.f2137c = new AnimatorSet();
            }
            this.f2137c.playTogether(this.f2138d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2135a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    b() {
        this(null, null, null);
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f2128c.f2136b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        C0022b c0022b = this.f2128c;
        if (c0022b.f2138d == null) {
            c0022b.f2138d = new ArrayList<>();
            this.f2128c.f2139e = new l.a<>();
        }
        this.f2128c.f2138d.add(animator);
        this.f2128c.f2139e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i3 = 0; i3 < childAnimations.size(); i3++) {
                c(childAnimations.get(i3));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2130e == null) {
                    this.f2130e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2130e);
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            return x.a.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f2128c.f2136b.draw(canvas);
        if (this.f2128c.f2137c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f2145b;
        return drawable != null ? x.a.d(drawable) : this.f2128c.f2136b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f2128c.f2135a | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2145b;
        return drawable != null ? x.a.e(drawable) : this.f2128c.f2136b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2145b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f2145b.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f2128c.f2136b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f2128c.f2136b.getIntrinsicWidth();
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
        return drawable != null ? drawable.getOpacity() : this.f2128c.f2136b.getOpacity();
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

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayS = v.g.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2120e);
                    int resourceId = typedArrayS.getResourceId(0, 0);
                    if (resourceId != 0) {
                        h hVarB = h.b(resources, resourceId, theme);
                        hVarB.h(false);
                        hVarB.setCallback(this.f2133h);
                        h hVar = this.f2128c.f2136b;
                        if (hVar != null) {
                            hVar.setCallback(null);
                        }
                        this.f2128c.f2136b = hVarB;
                    }
                    typedArrayS.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f2121f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2129d;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, d.i(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2128c.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f2145b;
        return drawable != null ? x.a.h(drawable) : this.f2128c.f2136b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f2145b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f2128c.f2137c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.isStateful() : this.f2128c.f2136b.isStateful();
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
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2128c.f2136b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.setLevel(i3) : this.f2128c.f2136b.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2145b;
        return drawable != null ? drawable.setState(iArr) : this.f2128c.f2136b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else {
            this.f2128c.f2136b.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.j(drawable, z2);
        } else {
            this.f2128c.f2136b.setAutoMirrored(z2);
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
            this.f2128c.f2136b.setTint(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.o(drawable, colorStateList);
        } else {
            this.f2128c.f2136b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            x.a.p(drawable, mode);
        } else {
            this.f2128c.f2136b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.f2128c.f2136b.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f2128c.f2137c.isStarted()) {
                return;
            }
            this.f2128c.f2137c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2128c.f2137c.end();
        }
    }

    private b(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2145b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2128c.f2136b.setColorFilter(colorFilter);
        }
    }

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    private static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f2140a;

        public c(Drawable.ConstantState constantState) {
            this.f2140a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2140a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2140a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f2140a.newDrawable();
            bVar.f2145b = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f2133h);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f2140a.newDrawable(resources);
            bVar.f2145b = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f2133h);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable drawableNewDrawable = this.f2140a.newDrawable(resources, theme);
            bVar.f2145b = drawableNewDrawable;
            drawableNewDrawable.setCallback(bVar.f2133h);
            return bVar;
        }
    }

    private b(Context context, C0022b c0022b, Resources resources) {
        this.f2130e = null;
        this.f2131f = null;
        this.f2132g = null;
        a aVar = new a();
        this.f2133h = aVar;
        this.f2129d = context;
        if (c0022b != null) {
            this.f2128c = c0022b;
        } else {
            this.f2128c = new C0022b(context, c0022b, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
