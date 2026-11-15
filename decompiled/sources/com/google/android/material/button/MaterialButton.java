package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import androidx.core.widget.i;
import com.google.android.material.internal.m;
import com.google.android.material.internal.o;
import e0.t;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k1.h;
import k1.k;
import k1.n;
import t0.j;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f2694q = {R.attr.state_checkable};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f2695r = {R.attr.state_checked};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f2696s = j.Widget_MaterialComponents_Button;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.button.a f2697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<a> f2698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f2699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f2700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f2701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f2702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2708o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2709p;

    public interface a {
        void a(MaterialButton materialButton, boolean z2);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z2);
    }

    static class c extends i0.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2710d;

        class a implements Parcelable.ClassLoaderCreator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private void k(Parcel parcel) {
            this.f2710d = parcel.readInt() == 1;
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f2710d ? 1 : 0);
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            k(parcel);
        }
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    private boolean b() {
        int i3 = this.f2709p;
        return i3 == 3 || i3 == 4;
    }

    private boolean c() {
        int i3 = this.f2709p;
        return i3 == 1 || i3 == 2;
    }

    private boolean d() {
        int i3 = this.f2709p;
        return i3 == 16 || i3 == 32;
    }

    private boolean e() {
        return t.B(this) == 1;
    }

    private boolean f() {
        com.google.android.material.button.a aVar = this.f2697d;
        return (aVar == null || aVar.o()) ? false : true;
    }

    private void g() {
        if (c()) {
            i.i(this, this.f2702i, null, null, null);
        } else if (b()) {
            i.i(this, null, null, this.f2702i, null);
        } else if (d()) {
            i.i(this, null, this.f2702i, null, null);
        }
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        if (Build.VERSION.SDK_INT < 17) {
            return getGravityTextAlignment();
        }
        int textAlignment = getTextAlignment();
        if (textAlignment == 1) {
            return getGravityTextAlignment();
        }
        if (textAlignment == 6 || textAlignment == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            return (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    private void h(boolean z2) {
        Drawable drawable = this.f2702i;
        boolean z3 = true;
        if (drawable != null) {
            Drawable drawableMutate = x.a.r(drawable).mutate();
            this.f2702i = drawableMutate;
            x.a.o(drawableMutate, this.f2701h);
            PorterDuff.Mode mode = this.f2700g;
            if (mode != null) {
                x.a.p(this.f2702i, mode);
            }
            int intrinsicWidth = this.f2703j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f2702i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f2703j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f2702i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f2702i;
            int i3 = this.f2704k;
            int i4 = this.f2705l;
            drawable2.setBounds(i3, i4, intrinsicWidth + i3, intrinsicHeight + i4);
            this.f2702i.setVisible(true, z2);
        }
        if (z2) {
            g();
            return;
        }
        Drawable[] drawableArrA = i.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[1];
        Drawable drawable5 = drawableArrA[2];
        if ((!c() || drawable3 == this.f2702i) && ((!b() || drawable5 == this.f2702i) && (!d() || drawable4 == this.f2702i))) {
            z3 = false;
        }
        if (z3) {
            g();
        }
    }

    private void i(int i3, int i4) {
        if (this.f2702i == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.f2704k = 0;
                if (this.f2709p == 16) {
                    this.f2705l = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.f2703j;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f2702i.getIntrinsicHeight();
                }
                int textHeight = (((((i4 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f2706m) - getPaddingBottom()) / 2;
                if (this.f2705l != textHeight) {
                    this.f2705l = textHeight;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f2705l = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i5 = this.f2709p;
        if (i5 == 1 || i5 == 3 || ((i5 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i5 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f2704k = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.f2703j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f2702i.getIntrinsicWidth();
        }
        int textWidth = ((((i3 - getTextWidth()) - t.F(this)) - intrinsicWidth) - this.f2706m) - t.G(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textWidth /= 2;
        }
        if (e() != (this.f2709p == 4)) {
            textWidth = -textWidth;
        }
        if (this.f2704k != textWidth) {
            this.f2704k = textWidth;
            h(false);
        }
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f2697d;
        return aVar != null && aVar.p();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.f2697d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f2702i;
    }

    public int getIconGravity() {
        return this.f2709p;
    }

    public int getIconPadding() {
        return this.f2706m;
    }

    public int getIconSize() {
        return this.f2703j;
    }

    public ColorStateList getIconTint() {
        return this.f2701h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2700g;
    }

    public int getInsetBottom() {
        return this.f2697d.c();
    }

    public int getInsetTop() {
        return this.f2697d.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f2697d.h();
        }
        return null;
    }

    public k getShapeAppearanceModel() {
        if (f()) {
            return this.f2697d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f2697d.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.f2697d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f, e0.s
    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.f2697d.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f, e0.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.f2697d.m() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2707n;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            h.f(this, this.f2697d.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (a()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f2694q);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f2695r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        com.google.android.material.button.a aVar;
        super.onLayout(z2, i3, i4, i5, i6);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f2697d) != null) {
            aVar.H(i6 - i4, i5 - i3);
        }
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.j());
        setChecked(cVar.f2710d);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f2710d = this.f2707n;
        return cVar;
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f2702i != null) {
            if (this.f2702i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (f()) {
            this.f2697d.r(i3);
        } else {
            super.setBackgroundColor(i3);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f2697d.s();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i3) {
        setBackgroundDrawable(i3 != 0 ? c.a.d(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (f()) {
            this.f2697d.t(z2);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (a() && isEnabled() && this.f2707n != z2) {
            this.f2707n = z2;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f2707n);
            }
            if (this.f2708o) {
                return;
            }
            this.f2708o = true;
            Iterator<a> it = this.f2698e.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f2707n);
            }
            this.f2708o = false;
        }
    }

    public void setCornerRadius(int i3) {
        if (f()) {
            this.f2697d.u(i3);
        }
    }

    public void setCornerRadiusResource(int i3) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        if (f()) {
            this.f2697d.f().W(f3);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f2702i != drawable) {
            this.f2702i = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i3) {
        if (this.f2709p != i3) {
            this.f2709p = i3;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i3) {
        if (this.f2706m != i3) {
            this.f2706m = i3;
            setCompoundDrawablePadding(i3);
        }
    }

    public void setIconResource(int i3) {
        setIcon(i3 != 0 ? c.a.d(getContext(), i3) : null);
    }

    public void setIconSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f2703j != i3) {
            this.f2703j = i3;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f2701h != colorStateList) {
            this.f2701h = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2700g != mode) {
            this.f2700g = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i3) {
        setIconTint(c.a.c(getContext(), i3));
    }

    public void setInsetBottom(int i3) {
        this.f2697d.v(i3);
    }

    public void setInsetTop(int i3) {
        this.f2697d.w(i3);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(b bVar) {
        this.f2699f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        b bVar = this.f2699f;
        if (bVar != null) {
            bVar.a(this, z2);
        }
        super.setPressed(z2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.f2697d.x(colorStateList);
        }
    }

    public void setRippleColorResource(int i3) {
        if (f()) {
            setRippleColor(c.a.c(getContext(), i3));
        }
    }

    @Override // k1.n
    public void setShapeAppearanceModel(k kVar) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f2697d.y(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (f()) {
            this.f2697d.z(z2);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.f2697d.A(colorStateList);
        }
    }

    public void setStrokeColorResource(int i3) {
        if (f()) {
            setStrokeColor(c.a.c(getContext(), i3));
        }
    }

    public void setStrokeWidth(int i3) {
        if (f()) {
            this.f2697d.B(i3);
        }
    }

    public void setStrokeWidthResource(int i3) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // androidx.appcompat.widget.f, e0.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.f2697d.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f, e0.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.f2697d.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i3) {
        super.setTextAlignment(i3);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f2707n);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f2696s;
        super(m1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f2698e = new LinkedHashSet<>();
        this.f2707n = false;
        this.f2708o = false;
        Context context2 = getContext();
        TypedArray typedArrayH = m.h(context2, attributeSet, t0.k.MaterialButton, i3, i4, new int[0]);
        this.f2706m = typedArrayH.getDimensionPixelSize(t0.k.MaterialButton_iconPadding, 0);
        this.f2700g = o.f(typedArrayH.getInt(t0.k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f2701h = h1.c.a(getContext(), typedArrayH, t0.k.MaterialButton_iconTint);
        this.f2702i = h1.c.d(getContext(), typedArrayH, t0.k.MaterialButton_icon);
        this.f2709p = typedArrayH.getInteger(t0.k.MaterialButton_iconGravity, 1);
        this.f2703j = typedArrayH.getDimensionPixelSize(t0.k.MaterialButton_iconSize, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, k.e(context2, attributeSet, i3, i4).m());
        this.f2697d = aVar;
        aVar.q(typedArrayH);
        typedArrayH.recycle();
        setCompoundDrawablePadding(this.f2706m);
        h(this.f2702i != null);
    }
}
