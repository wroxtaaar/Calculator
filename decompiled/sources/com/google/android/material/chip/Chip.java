package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.g;
import com.google.android.material.internal.h;
import com.google.android.material.internal.m;
import com.google.android.material.internal.o;
import com.vivo.seckeysdk.BuildConfig;
import e0.t;
import h1.f;
import java.util.List;
import k1.n;
import t0.i;
import t0.j;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends g implements com.google.android.material.chip.a.InterfaceC0036a, n, h<Chip> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.chip.a f2763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InsetDrawable f2764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RippleDrawable f2765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View.OnClickListener f2766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f2767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h.a<Chip> f2768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2771m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2772n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2773o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2774p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2775q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f2776r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final d f2777s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f2778t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Rect f2779u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final RectF f2780v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final f f2781w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f2760x = j.Widget_MaterialComponents_Chip_Action;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Rect f2761y = new Rect();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f2762z = {R.attr.state_selected};
    private static final int[] A = {R.attr.state_checkable};

    class a extends f {
        a() {
        }

        @Override // h1.f
        public void a(int i3) {
        }

        @Override // h1.f
        public void b(Typeface typeface, boolean z2) {
            Chip chip = Chip.this;
            chip.setText(chip.f2763e.K2() ? Chip.this.f2763e.g1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (Chip.this.f2768j != null) {
                Chip.this.f2768j.a(Chip.this, z2);
            }
            if (Chip.this.f2767i != null) {
                Chip.this.f2767i.onCheckedChanged(compoundButton, z2);
            }
        }
    }

    class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f2763e != null) {
                Chip.this.f2763e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class d extends j0.a {
        d(Chip chip) {
            super(chip);
        }

        @Override // j0.a
        protected int B(float f3, float f4) {
            return (Chip.this.o() && Chip.this.getCloseIconTouchBounds().contains(f3, f4)) ? 1 : 0;
        }

        @Override // j0.a
        protected void C(List<Integer> list) {
            list.add(0);
            if (Chip.this.o() && Chip.this.t() && Chip.this.f2766h != null) {
                list.add(1);
            }
        }

        @Override // j0.a
        protected boolean J(int i3, int i4, Bundle bundle) {
            if (i4 != 16) {
                return false;
            }
            if (i3 == 0) {
                return Chip.this.performClick();
            }
            if (i3 == 1) {
                return Chip.this.u();
            }
            return false;
        }

        @Override // j0.a
        protected void M(f0.d dVar) {
            dVar.V(Chip.this.s());
            dVar.Y(Chip.this.isClickable());
            dVar.X(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                dVar.t0(text);
            } else {
                dVar.b0(text);
            }
        }

        @Override // j0.a
        protected void N(int i3, f0.d dVar) {
            CharSequence charSequence = BuildConfig.FLAVOR;
            if (i3 != 1) {
                dVar.b0(BuildConfig.FLAVOR);
                dVar.T(Chip.f2761y);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                dVar.b0(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i4 = i.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                if (!TextUtils.isEmpty(text)) {
                    charSequence = text;
                }
                objArr[0] = charSequence;
                dVar.b0(context.getString(i4, objArr).trim());
            }
            dVar.T(Chip.this.getCloseIconTouchBoundsInt());
            dVar.b(f0.d.a.f4646i);
            dVar.c0(Chip.this.isEnabled());
        }

        @Override // j0.a
        protected void O(int i3, boolean z2) {
            if (i3 == 1) {
                Chip.this.f2772n = z2;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void A() {
        this.f2765g = new RippleDrawable(i1.b.a(this.f2763e.e1()), getBackgroundDrawable(), null);
        this.f2763e.J2(false);
        t.p0(this, this.f2765g);
        B();
    }

    private void B() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f2763e) == null) {
            return;
        }
        int iI0 = (int) (aVar.I0() + this.f2763e.i1() + this.f2763e.p0());
        int iN0 = (int) (this.f2763e.N0() + this.f2763e.j1() + this.f2763e.l0());
        if (this.f2764f != null) {
            Rect rect = new Rect();
            this.f2764f.getPadding(rect);
            iN0 += rect.left;
            iI0 += rect.right;
        }
        t.y0(this, iN0, getPaddingTop(), iI0, getPaddingBottom());
    }

    private void C() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        h1.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f2781w);
        }
    }

    private void D(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f2780v.setEmpty();
        if (o() && this.f2766h != null) {
            this.f2763e.X0(this.f2780v);
        }
        return this.f2780v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f2779u.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f2779u;
    }

    private h1.d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.h1();
        }
        return null;
    }

    private void k(com.google.android.material.chip.a aVar) {
        aVar.o2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] l() {
        ?? IsEnabled = isEnabled();
        int i3 = IsEnabled;
        if (this.f2772n) {
            i3 = IsEnabled + 1;
        }
        int i4 = i3;
        if (this.f2771m) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (this.f2770l) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (isChecked()) {
            i6 = i5 + 1;
        }
        int[] iArr = new int[i6];
        int i7 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i7 = 1;
        }
        if (this.f2772n) {
            iArr[i7] = 16842908;
            i7++;
        }
        if (this.f2771m) {
            iArr[i7] = 16843623;
            i7++;
        }
        if (this.f2770l) {
            iArr[i7] = 16842919;
            i7++;
        }
        if (isChecked()) {
            iArr[i7] = 16842913;
        }
        return iArr;
    }

    private void n() {
        if (getBackgroundDrawable() == this.f2764f && this.f2763e.getCallback() == null) {
            this.f2763e.setCallback(this.f2764f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        com.google.android.material.chip.a aVar = this.f2763e;
        return (aVar == null || aVar.Q0() == null) ? false : true;
    }

    private void p(Context context, AttributeSet attributeSet, int i3) {
        TypedArray typedArrayH = m.h(context, attributeSet, k.Chip, i3, f2760x, new int[0]);
        this.f2773o = typedArrayH.getBoolean(k.Chip_ensureMinTouchTargetSize, false);
        this.f2775q = (int) Math.ceil(typedArrayH.getDimension(k.Chip_chipMinTouchTargetSize, (float) Math.ceil(o.b(getContext(), 48))));
        typedArrayH.recycle();
    }

    private void q() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new c());
        }
    }

    private void r(int i3, int i4, int i5, int i6) {
        this.f2764f = new InsetDrawable((Drawable) this.f2763e, i3, i4, i5, i6);
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f2771m != z2) {
            this.f2771m = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f2770l != z2) {
            this.f2770l = z2;
            refreshDrawableState();
        }
    }

    private void v() {
        if (this.f2764f != null) {
            this.f2764f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    private void x(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.o2(null);
        }
    }

    private void y() {
        if (o() && t() && this.f2766h != null) {
            t.m0(this, this.f2777s);
            this.f2778t = true;
        } else {
            t.m0(this, null);
            this.f2778t = false;
        }
    }

    private void z() {
        if (i1.b.f4887a) {
            A();
            return;
        }
        this.f2763e.J2(true);
        t.p0(this, getBackgroundDrawable());
        B();
        n();
    }

    @Override // com.google.android.material.chip.a.InterfaceC0036a
    public void a() {
        m(this.f2775q);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f2778t) {
            return this.f2777s.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f2778t) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f2777s.w(keyEvent) || this.f2777s.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f2763e;
        if ((aVar == null || !aVar.o1()) ? false : this.f2763e.k2(l())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f2776r)) {
            return this.f2776r;
        }
        if (!s()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).h()) ? "android.widget.RadioButton" : "android.widget.CompoundButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f2764f;
        return insetDrawable == null ? this.f2763e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.E0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.F0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.G0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.H0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2763e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.I0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.J0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.K0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.L0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.M0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.N0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.Q0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.R0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.S0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.T0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.U0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.a1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f2778t && (this.f2777s.A() == 1 || this.f2777s.x() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public u0.h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.d1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    public k1.k getShapeAppearanceModel() {
        return this.f2763e.D();
    }

    public u0.h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.i1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            return aVar.j1();
        }
        return 0.0f;
    }

    public boolean m(int i3) {
        this.f2775q = i3;
        if (!w()) {
            if (this.f2764f != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int iMax = Math.max(0, i3 - this.f2763e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i3 - this.f2763e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f2764f != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int i4 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i5 = iMax > 0 ? iMax / 2 : 0;
        if (this.f2764f != null) {
            Rect rect = new Rect();
            this.f2764f.getPadding(rect);
            if (rect.top == i5 && rect.bottom == i5 && rect.left == i4 && rect.right == i4) {
                z();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i3) {
                setMinHeight(i3);
            }
            if (getMinWidth() != i3) {
                setMinWidth(i3);
            }
        } else {
            setMinHeight(i3);
            setMinWidth(i3);
        }
        r(i4, i5, i4, i5);
        z();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k1.h.f(this, this.f2763e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, f2762z);
        }
        if (s()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z2, int i3, Rect rect) {
        super.onFocusChanged(z2, i3, rect);
        if (this.f2778t) {
            this.f2777s.I(z2, i3, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(s());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            f0.d.x0(accessibilityNodeInfo).a0(f0.d.c.f(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.g(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        if (this.f2774p != i3) {
            this.f2774p = i3;
            B();
        }
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    }
                } else if (this.f2770l) {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z2 = true;
                }
                z2 = false;
            } else {
                if (this.f2770l) {
                    u();
                    z2 = true;
                }
                setCloseIconPressed(false);
            }
            z2 = false;
            setCloseIconPressed(false);
        } else if (zContains) {
            setCloseIconPressed(true);
            z2 = true;
        } else {
            z2 = false;
        }
        return z2 || super.onTouchEvent(motionEvent);
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f2763e;
        return aVar != null && aVar.n1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f2776r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2765g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2765g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundResource(int i3) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.w1(z2);
        }
    }

    public void setCheckableResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.x1(i3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar == null) {
            this.f2769k = z2;
        } else if (aVar.n1()) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.y1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i3) {
        setCheckedIconVisible(i3);
    }

    public void setCheckedIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.z1(i3);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.A1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.B1(i3);
        }
    }

    public void setCheckedIconVisible(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.C1(i3);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.E1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.F1(i3);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.G1(f3);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.H1(i3);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f2763e;
        if (aVar2 != aVar) {
            x(aVar2);
            this.f2763e = aVar;
            aVar.z2(false);
            k(this.f2763e);
            m(this.f2775q);
        }
    }

    public void setChipEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.I1(f3);
        }
    }

    public void setChipEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.J1(i3);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.K1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i3) {
        setChipIconVisible(i3);
    }

    public void setChipIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.L1(i3);
        }
    }

    public void setChipIconSize(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.M1(f3);
        }
    }

    public void setChipIconSizeResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.N1(i3);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.O1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.P1(i3);
        }
    }

    public void setChipIconVisible(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.Q1(i3);
        }
    }

    public void setChipMinHeight(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.S1(f3);
        }
    }

    public void setChipMinHeightResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.T1(i3);
        }
    }

    public void setChipStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.U1(f3);
        }
    }

    public void setChipStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.V1(i3);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.W1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.X1(i3);
        }
    }

    public void setChipStrokeWidth(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.Y1(f3);
        }
    }

    public void setChipStrokeWidthResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.Z1(i3);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i3) {
        setText(getResources().getString(i3));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.b2(drawable);
        }
        y();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.c2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i3) {
        setCloseIconVisible(i3);
    }

    public void setCloseIconEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.d2(f3);
        }
    }

    public void setCloseIconEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.e2(i3);
        }
    }

    public void setCloseIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.f2(i3);
        }
        y();
    }

    public void setCloseIconSize(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.g2(f3);
        }
    }

    public void setCloseIconSizeResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.h2(i3);
        }
    }

    public void setCloseIconStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.i2(f3);
        }
    }

    public void setCloseIconStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.j2(i3);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.l2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.m2(i3);
        }
    }

    public void setCloseIconVisible(int i3) {
        setCloseIconVisible(getResources().getBoolean(i3));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.W(f3);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2763e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.p2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.f2773o = z2;
        m(this.f2775q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        if (i3 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i3);
        }
    }

    public void setHideMotionSpec(u0.h hVar) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.q2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.r2(i3);
        }
    }

    public void setIconEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.s2(f3);
        }
    }

    public void setIconEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.t2(i3);
        }
    }

    public void setIconStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.u2(f3);
        }
    }

    public void setIconStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.v2(i3);
        }
    }

    @Override // com.google.android.material.internal.h
    public void setInternalOnCheckedChangeListener(h.a<Chip> aVar) {
        this.f2768j = aVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        if (this.f2763e != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i3);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.w2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i3);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2767i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f2766h = onClickListener;
        y();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.x2(colorStateList);
        }
        if (this.f2763e.l1()) {
            return;
        }
        A();
    }

    public void setRippleColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.y2(i3);
            if (this.f2763e.l1()) {
                return;
            }
            A();
        }
    }

    @Override // k1.n
    public void setShapeAppearanceModel(k1.k kVar) {
        this.f2763e.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(u0.h hVar) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.A2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.B2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        super.setText(aVar.K2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f2763e;
        if (aVar2 != null) {
            aVar2.C2(charSequence);
        }
    }

    public void setTextAppearance(h1.d dVar) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.D2(dVar);
        }
        C();
    }

    public void setTextAppearanceResource(int i3) {
        setTextAppearance(getContext(), i3);
    }

    public void setTextEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.F2(f3);
        }
    }

    public void setTextEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.G2(i3);
        }
    }

    public void setTextStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.H2(f3);
        }
    }

    public void setTextStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.I2(i3);
        }
    }

    public boolean t() {
        com.google.android.material.chip.a aVar = this.f2763e;
        return aVar != null && aVar.p1();
    }

    public boolean u() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f2766h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        if (this.f2778t) {
            this.f2777s.U(1, 1);
        }
        return z2;
    }

    public boolean w() {
        return this.f2773o;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.chipStyle);
    }

    public void setCloseIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.n2(z2);
        }
        y();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f2760x;
        super(m1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f2779u = new Rect();
        this.f2780v = new RectF();
        this.f2781w = new a();
        Context context2 = getContext();
        D(attributeSet);
        com.google.android.material.chip.a aVarU0 = com.google.android.material.chip.a.u0(context2, attributeSet, i3, i4);
        p(context2, attributeSet, i3);
        setChipDrawable(aVarU0);
        aVarU0.W(t.w(this));
        TypedArray typedArrayH = m.h(context2, attributeSet, k.Chip, i3, i4, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(h1.c.a(context2, typedArrayH, k.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayH.hasValue(k.Chip_shapeAppearance);
        typedArrayH.recycle();
        this.f2777s = new d(this);
        y();
        if (!zHasValue) {
            q();
        }
        setChecked(this.f2769k);
        setText(aVarU0.g1());
        setEllipsize(aVarU0.a1());
        C();
        if (!this.f2763e.K2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        B();
        if (w()) {
            setMinHeight(this.f2775q);
        }
        this.f2774p = t.B(this);
        super.setOnCheckedChangeListener(new b());
    }

    public void setCheckedIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.D1(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.R1(z2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.E2(i3);
        }
        C();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        com.google.android.material.chip.a aVar = this.f2763e;
        if (aVar != null) {
            aVar.E2(i3);
        }
        C();
    }
}
