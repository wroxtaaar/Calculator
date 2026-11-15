package x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: WrappedDrawableApi21.java */
/* JADX INFO: loaded from: classes.dex */
class e extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Method f6422i;

    e(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (f6422i == null) {
            try {
                f6422i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e3) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e3);
            }
        }
    }

    @Override // x.d
    protected boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f6421g;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f6421g.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f6421g.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f6421g;
        if (drawable != null && (method = f6422i) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e3) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e3);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        this.f6421g.setHotspot(f3, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        this.f6421g.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // x.d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // x.d, android.graphics.drawable.Drawable, x.b
    public void setTint(int i3) {
        if (c()) {
            super.setTint(i3);
        } else {
            this.f6421g.setTint(i3);
        }
    }

    @Override // x.d, android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f6421g.setTintList(colorStateList);
        }
    }

    @Override // x.d, android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f6421g.setTintMode(mode);
        }
    }

    e(f fVar, Resources resources) {
        super(fVar, resources);
        g();
    }
}
