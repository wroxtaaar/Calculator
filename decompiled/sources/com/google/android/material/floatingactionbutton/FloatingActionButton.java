package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.l;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.p;
import d0.i;
import e0.s;
import e0.t;
import java.util.List;
import k1.n;
import t0.j;
import u0.h;
import u0.k;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends p implements s, l, d1.a, n, CoordinatorLayout.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f2961q = j.Widget_Design_FloatingActionButton;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f2962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f2963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f2964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f2965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f2966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f2971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final Rect f2972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f2973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final androidx.appcompat.widget.n f2974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.google.android.material.floatingactionbutton.a f2975p;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: E */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: H */
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: I */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i3) {
            return super.l(coordinatorLayout, floatingActionButton, i3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.f fVar) {
            super.g(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements com.google.android.material.floatingactionbutton.a.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f2979a;

        a(b bVar) {
            this.f2979a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void a() {
            this.f2979a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void b() {
            this.f2979a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class c implements j1.b {
        c() {
        }

        @Override // j1.b
        public void a(int i3, int i4, int i5, int i6) {
            FloatingActionButton.this.f2972m.set(i3, i4, i5, i6);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i3 + floatingActionButton.f2969j, i4 + FloatingActionButton.this.f2969j, i5 + FloatingActionButton.this.f2969j, i6 + FloatingActionButton.this.f2969j);
        }

        @Override // j1.b
        public boolean b() {
            return FloatingActionButton.this.f2971l;
        }

        @Override // j1.b
        public void d(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    class d<T extends FloatingActionButton> implements com.google.android.material.floatingactionbutton.a.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k<T> f2982a;

        d(k<T> kVar) {
            this.f2982a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void a() {
            this.f2982a.a(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void b() {
            this.f2982a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).f2982a.equals(this.f2982a);
        }

        public int hashCode() {
            return this.f2982a.hashCode();
        }
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f2975p == null) {
            this.f2975p = h();
        }
        return this.f2975p;
    }

    private com.google.android.material.floatingactionbutton.a h() {
        return Build.VERSION.SDK_INT >= 21 ? new com.google.android.material.floatingactionbutton.b(this, new c()) : new com.google.android.material.floatingactionbutton.a(this, new c());
    }

    private int k(int i3) {
        int i4 = this.f2968i;
        if (i4 != 0) {
            return i4;
        }
        Resources resources = getResources();
        if (i3 != -1) {
            return i3 != 1 ? resources.getDimensionPixelSize(t0.d.design_fab_size_normal) : resources.getDimensionPixelSize(t0.d.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? k(1) : k(0);
    }

    private void p(Rect rect) {
        int i3 = rect.left;
        Rect rect2 = this.f2972m;
        rect.left = i3 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f2964e;
        if (colorStateList == null) {
            x.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f2965f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.j.e(colorForState, mode));
    }

    private static int r(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i3, size);
        }
        if (mode == 0) {
            return i3;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private com.google.android.material.floatingactionbutton.a.k u(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // d1.a
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().C(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(k<? extends FloatingActionButton> kVar) {
        getImpl().g(new d(kVar));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f2962c;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f2963d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public Drawable getContentBackground() {
        return getImpl().l();
    }

    public int getCustomSize() {
        return this.f2968i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public h getHideMotionSpec() {
        return getImpl().o();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f2966g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f2966g;
    }

    public k1.k getShapeAppearanceModel() {
        return (k1.k) i.c(getImpl().t());
    }

    public h getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f2967h;
    }

    int getSizeDimension() {
        return k(this.f2967h);
    }

    @Override // e0.s
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // e0.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        return this.f2964e;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f2965f;
    }

    public boolean getUseCompatPadding() {
        return this.f2971l;
    }

    @Deprecated
    public boolean i(Rect rect) {
        if (!t.S(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        p(rect);
        return true;
    }

    public void j(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        p(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().y();
    }

    public void l(b bVar) {
        m(bVar, true);
    }

    void m(b bVar, boolean z2) {
        getImpl().v(u(bVar), z2);
    }

    public boolean n() {
        return getImpl().w();
    }

    public boolean o() {
        return getImpl().x();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int sizeDimension = getSizeDimension();
        this.f2969j = (sizeDimension - this.f2970k) / 2;
        getImpl().c0();
        int iMin = Math.min(r(sizeDimension, i3), r(sizeDimension, i4));
        Rect rect = this.f2972m;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof l1.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l1.a aVar = (l1.a) parcelable;
        super.onRestoreInstanceState(aVar.j());
        throw null;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        new l1.a(parcelableOnSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && i(this.f2973n) && !this.f2973n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s(b bVar) {
        t(bVar, true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2962c != colorStateList) {
            this.f2962c = colorStateList;
            getImpl().J(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2963d != mode) {
            this.f2963d = mode;
            getImpl().K(mode);
        }
    }

    public void setCompatElevation(float f3) {
        getImpl().L(f3);
    }

    public void setCompatElevationResource(int i3) {
        setCompatElevation(getResources().getDimension(i3));
    }

    public void setCompatHoveredFocusedTranslationZ(float f3) {
        getImpl().O(f3);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i3) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i3));
    }

    public void setCompatPressedTranslationZ(float f3) {
        getImpl().R(f3);
    }

    public void setCompatPressedTranslationZResource(int i3) {
        setCompatPressedTranslationZ(getResources().getDimension(i3));
    }

    public void setCustomSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i3 != this.f2968i) {
            this.f2968i = i3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        getImpl().d0(f3);
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().n()) {
            getImpl().M(z2);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i3) {
        throw null;
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().N(hVar);
    }

    public void setHideMotionSpecResource(int i3) {
        setHideMotionSpec(h.c(getContext(), i3));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().b0();
            if (this.f2964e != null) {
                q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        this.f2974o.g(i3);
        q();
    }

    public void setMaxImageSize(int i3) {
        this.f2970k = i3;
        getImpl().Q(i3);
    }

    public void setRippleColor(int i3) {
        setRippleColor(ColorStateList.valueOf(i3));
    }

    @Override // android.view.View
    public void setScaleX(float f3) {
        super.setScaleX(f3);
        getImpl().G();
    }

    @Override // android.view.View
    public void setScaleY(float f3) {
        super.setScaleY(f3);
        getImpl().G();
    }

    public void setShadowPaddingEnabled(boolean z2) {
        getImpl().T(z2);
    }

    @Override // k1.n
    public void setShapeAppearanceModel(k1.k kVar) {
        getImpl().U(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().V(hVar);
    }

    public void setShowMotionSpecResource(int i3) {
        setShowMotionSpec(h.c(getContext(), i3));
    }

    public void setSize(int i3) {
        this.f2968i = 0;
        if (i3 != this.f2967h) {
            this.f2967h = i3;
            requestLayout();
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // e0.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f2964e != colorStateList) {
            this.f2964e = colorStateList;
            q();
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f2965f != mode) {
            this.f2965f = mode;
            q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f3) {
        super.setTranslationX(f3);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationY(float f3) {
        super.setTranslationY(f3);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationZ(float f3) {
        super.setTranslationZ(f3);
        getImpl().H();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f2971l != z2) {
            this.f2971l = z2;
            getImpl().A();
        }
    }

    @Override // com.google.android.material.internal.p, android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    void t(b bVar, boolean z2) {
        getImpl().Z(u(bVar), z2);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f2976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f2977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2978c;

        public BaseBehavior() {
            this.f2978c = true;
        }

        private static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i3;
            Rect rect = floatingActionButton.f2972m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i4 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                i3 = rect.right;
            } else {
                i3 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i4 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i4 = -rect.top;
            }
            if (i4 != 0) {
                t.Y(floatingActionButton, i4);
            }
            if (i3 != 0) {
                t.X(floatingActionButton, i3);
            }
        }

        private boolean J(View view, FloatingActionButton floatingActionButton) {
            return this.f2978c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f2976a == null) {
                this.f2976a = new Rect();
            }
            Rect rect = this.f2976a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m(this.f2977b, false);
                return true;
            }
            floatingActionButton.t(this.f2977b, false);
            return true;
        }

        private boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m(this.f2977b, false);
                return true;
            }
            floatingActionButton.t(this.f2977b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f2972m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!F(view)) {
                return false;
            }
            L(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i3) {
            List<View> listR = coordinatorLayout.r(floatingActionButton);
            int size = listR.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = listR.get(i4);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(floatingActionButton, i3);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f1117h == 0) {
                fVar.f1117h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.k.FloatingActionButton_Behavior_Layout);
            this.f2978c = typedArrayObtainStyledAttributes.getBoolean(t0.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f2966g != colorStateList) {
            this.f2966g = colorStateList;
            getImpl().S(this.f2966g);
        }
    }
}
