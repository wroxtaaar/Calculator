package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.i0;

/* JADX INFO: compiled from: ForegroundLinearLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends i0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f3110q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f3111r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f3112s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f3114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f3115v;

    public f(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3110q;
        if (drawable != null) {
            if (this.f3115v) {
                this.f3115v = false;
                Rect rect = this.f3111r;
                Rect rect2 = this.f3112s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f3114u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f3113t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f3, float f4) {
        super.drawableHotspotChanged(f3, f4);
        Drawable drawable = this.f3110q;
        if (drawable != null) {
            drawable.setHotspot(f3, f4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3110q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f3110q.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f3110q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f3113t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3110q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        this.f3115v = z2 | this.f3115v;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f3115v = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f3110q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f3110q);
            }
            this.f3110q = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f3113t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i3) {
        if (this.f3113t != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f3113t = i3;
            if (i3 == 119 && this.f3110q != null) {
                this.f3110q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3110q;
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3111r = new Rect();
        this.f3112s = new Rect();
        this.f3113t = 119;
        this.f3114u = true;
        this.f3115v = false;
        TypedArray typedArrayH = m.h(context, attributeSet, t0.k.ForegroundLinearLayout, i3, 0, new int[0]);
        this.f3113t = typedArrayH.getInt(t0.k.ForegroundLinearLayout_android_foregroundGravity, this.f3113t);
        Drawable drawable = typedArrayH.getDrawable(t0.k.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f3114u = typedArrayH.getBoolean(t0.k.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayH.recycle();
    }
}
