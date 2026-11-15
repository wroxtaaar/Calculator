package x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: WrappedDrawableApi14.java */
/* JADX INFO: loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, c, b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final PorterDuff.Mode f6415h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f6417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    f f6419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f6421g;

    d(f fVar, Resources resources) {
        this.f6419e = fVar;
        e(resources);
    }

    private f d() {
        return new f(this.f6419e);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f6419e;
        if (fVar == null || (constantState = fVar.f6424b) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.f6419e;
        ColorStateList colorStateList = fVar.f6425c;
        PorterDuff.Mode mode = fVar.f6426d;
        if (colorStateList == null || mode == null) {
            this.f6418d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f6418d || colorForState != this.f6416b || mode != this.f6417c) {
                setColorFilter(colorForState, mode);
                this.f6416b = colorForState;
                this.f6417c = mode;
                this.f6418d = true;
                return true;
            }
        }
        return false;
    }

    @Override // x.c
    public final Drawable a() {
        return this.f6421g;
    }

    @Override // x.c
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f6421g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f6421g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f6419e;
            if (fVar != null) {
                fVar.f6424b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f6421g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f6419e;
        return this.f6421g.getChangingConfigurations() | changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f6419e;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f6419e.f6423a = getChangingConfigurations();
        return this.f6419e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f6421g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f6421g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f6421g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.f(this.f6421g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f6421g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f6421g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f6421g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f6421g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f6421g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f6421g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.h(this.f6421g);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.f6419e) == null) ? null : fVar.f6425c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f6421g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f6421g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f6420f && super.mutate() == this) {
            this.f6419e = d();
            Drawable drawable = this.f6421g;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f6419e;
            if (fVar != null) {
                Drawable drawable2 = this.f6421g;
                fVar.f6424b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f6420f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6421g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return a.m(this.f6421g, i3);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        return this.f6421g.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f6421g.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        a.j(this.f6421g, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i3) {
        this.f6421g.setChangingConfigurations(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6421g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f6421g.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f6421g.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f6421g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        this.f6419e.f6425c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f6419e.f6426d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f6421g.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    d(Drawable drawable) {
        this.f6419e = d();
        b(drawable);
    }
}
