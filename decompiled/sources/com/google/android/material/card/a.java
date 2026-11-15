package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import k1.k;
import k1.n;
import t0.b;
import t0.j;

/* JADX INFO: compiled from: MaterialCardView.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends k.a implements Checkable, n {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f2752n = {R.attr.state_checkable};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f2753o = {R.attr.state_checked};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f2754p = {b.state_dragged};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f2755q = j.Widget_MaterialComponents_CardView;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private InterfaceC0035a f2759m;

    /* JADX INFO: renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialCardView.java */
    public interface InterfaceC0035a {
    }

    private void d() {
        if (Build.VERSION.SDK_INT > 26) {
            throw null;
        }
    }

    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.f2758l;
    }

    @Override // k.a
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconGravity() {
        throw null;
    }

    public int getCheckedIconMargin() {
        throw null;
    }

    public int getCheckedIconSize() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // k.a
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // k.a
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // k.a
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // k.a
    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    @Override // k.a
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public k getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2757k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f2752n);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f2753o);
        }
        if (f()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f2754p);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // k.a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f2756j) {
            throw null;
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // k.a
    public void setCardBackgroundColor(int i3) {
        ColorStateList.valueOf(i3);
        throw null;
    }

    @Override // k.a
    public void setCardElevation(float f3) {
        super.setCardElevation(f3);
        throw null;
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z2) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f2757k != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        throw null;
    }

    public void setCheckedIconGravity(int i3) {
        throw null;
    }

    public void setCheckedIconMargin(int i3) {
        throw null;
    }

    public void setCheckedIconMarginResource(int i3) {
        if (i3 == -1) {
            return;
        }
        getResources().getDimensionPixelSize(i3);
        throw null;
    }

    public void setCheckedIconResource(int i3) {
        c.a.d(getContext(), i3);
        throw null;
    }

    public void setCheckedIconSize(int i3) {
        throw null;
    }

    public void setCheckedIconSizeResource(int i3) {
        if (i3 == 0) {
            return;
        }
        getResources().getDimensionPixelSize(i3);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
    }

    public void setDragged(boolean z2) {
        if (this.f2758l != z2) {
            this.f2758l = z2;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // k.a
    public void setMaxCardElevation(float f3) {
        super.setMaxCardElevation(f3);
        throw null;
    }

    public void setOnCheckedChangeListener(InterfaceC0035a interfaceC0035a) {
        this.f2759m = interfaceC0035a;
    }

    @Override // k.a
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        throw null;
    }

    public void setProgress(float f3) {
        throw null;
    }

    @Override // k.a
    public void setRadius(float f3) {
        super.setRadius(f3);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int i3) {
        c.a.c(getContext(), i3);
        throw null;
    }

    @Override // k1.n
    public void setShapeAppearanceModel(k kVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(kVar.u(getBoundsAsRectF()));
        }
        throw null;
    }

    public void setStrokeColor(int i3) {
        setStrokeColor(ColorStateList.valueOf(i3));
    }

    public void setStrokeWidth(int i3) {
        throw null;
    }

    @Override // k.a
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.f2757k = !this.f2757k;
            refreshDrawableState();
            d();
            throw null;
        }
    }

    @Override // k.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }
}
