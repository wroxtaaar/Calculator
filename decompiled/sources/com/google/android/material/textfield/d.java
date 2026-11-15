package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import e0.t;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
class d extends com.google.android.material.textfield.e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final boolean f3298t;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f3299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f3300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.e f3301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextInputLayout.f f3302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.g f3303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f3304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f0.c.a f3305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f3308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private StateListDrawable f3309o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k1.g f3310p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AccessibilityManager f3311q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueAnimator f3312r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ValueAnimator f3313s;

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class a extends com.google.android.material.internal.l {

        /* JADX INFO: renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        class RunnableC0044a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f3315b;

            RunnableC0044a(AutoCompleteTextView autoCompleteTextView) {
                this.f3315b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.f3315b.isPopupShowing();
                d.this.J(zIsPopupShowing);
                d.this.f3306l = zIsPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.l, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewC = d.C(d.this.f3331a.getEditText());
            if (d.this.f3311q.isTouchExplorationEnabled() && d.H(autoCompleteTextViewC) && !d.this.f3333c.hasFocus()) {
                autoCompleteTextViewC.dismissDropDown();
            }
            autoCompleteTextViewC.post(new RunnableC0044a(autoCompleteTextViewC));
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class b implements AutoCompleteTextView.OnDismissListener {
        b() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.N();
            d.this.J(false);
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f3333c.setChecked(dVar.f3307m);
            d.this.f3313s.start();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class C0045d implements ValueAnimator.AnimatorUpdateListener {
        C0045d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f3333c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            d.this.f3331a.setEndIconActivated(z2);
            if (z2) {
                return;
            }
            d.this.J(false);
            d.this.f3306l = false;
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class f extends TextInputLayout.e {
        f(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, e0.a
        public void g(View view, f0.d dVar) {
            super.g(view, dVar);
            if (!d.H(d.this.f3331a.getEditText())) {
                dVar.X(Spinner.class.getName());
            }
            if (dVar.K()) {
                dVar.h0(null);
            }
        }

        @Override // e0.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewC = d.C(d.this.f3331a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f3311q.isEnabled() && !d.H(d.this.f3331a.getEditText())) {
                d.this.M(autoCompleteTextViewC);
                d.this.N();
            }
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class g implements TextInputLayout.f {
        g() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewC = d.C(textInputLayout.getEditText());
            d.this.K(autoCompleteTextViewC);
            d.this.y(autoCompleteTextViewC);
            d.this.L(autoCompleteTextViewC);
            autoCompleteTextViewC.setThreshold(0);
            autoCompleteTextViewC.removeTextChangedListener(d.this.f3299e);
            autoCompleteTextViewC.addTextChangedListener(d.this.f3299e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.H(autoCompleteTextViewC) && d.this.f3311q.isTouchExplorationEnabled()) {
                t.v0(d.this.f3333c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f3301g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class h implements TextInputLayout.g {

        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f3324b;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.f3324b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3324b.removeTextChangedListener(d.this.f3299e);
            }
        }

        h() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i3) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i3 == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f3300f) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (d.f3298t) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
            if (i3 == 3) {
                textInputLayout.removeOnAttachStateChangeListener(d.this.f3304j);
                d.this.I();
            }
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class i implements View.OnAttachStateChangeListener {
        i() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            d.this.B();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            d.this.I();
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class j implements f0.c.a {
        j() {
        }

        @Override // f0.c.a
        public void onTouchExplorationStateChanged(boolean z2) {
            AutoCompleteTextView autoCompleteTextView;
            TextInputLayout textInputLayout = d.this.f3331a;
            if (textInputLayout == null || (autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText()) == null || d.H(autoCompleteTextView)) {
                return;
            }
            t.v0(d.this.f3333c, z2 ? 2 : 1);
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.M((AutoCompleteTextView) d.this.f3331a.getEditText());
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class l implements View.OnTouchListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f3329b;

        l(AutoCompleteTextView autoCompleteTextView) {
            this.f3329b = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.G()) {
                    d.this.f3306l = false;
                }
                d.this.M(this.f3329b);
                d.this.N();
            }
            return false;
        }
    }

    static {
        f3298t = Build.VERSION.SDK_INT >= 21;
    }

    d(TextInputLayout textInputLayout, int i3) {
        super(textInputLayout, i3);
        this.f3299e = new a();
        this.f3300f = new e();
        this.f3301g = new f(this.f3331a);
        this.f3302h = new g();
        this.f3303i = new h();
        this.f3304j = new i();
        this.f3305k = new j();
        this.f3306l = false;
        this.f3307m = false;
        this.f3308n = Long.MAX_VALUE;
    }

    private void A(AutoCompleteTextView autoCompleteTextView, int i3, int[][] iArr, k1.g gVar) {
        LayerDrawable layerDrawable;
        int iD = z0.c.d(autoCompleteTextView, t0.b.colorSurface);
        k1.g gVar2 = new k1.g(gVar.D());
        int iH = z0.c.h(i3, iD, 0.1f);
        gVar2.X(new ColorStateList(iArr, new int[]{iH, 0}));
        if (f3298t) {
            gVar2.setTint(iD);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iH, iD});
            k1.g gVar3 = new k1.g(gVar.D());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        t.p0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        TextInputLayout textInputLayout;
        if (this.f3311q == null || (textInputLayout = this.f3331a) == null || !t.R(textInputLayout)) {
            return;
        }
        f0.c.a(this.f3311q, this.f3305k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AutoCompleteTextView C(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator D(int i3, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(u0.a.f6257a);
        valueAnimatorOfFloat.setDuration(i3);
        valueAnimatorOfFloat.addUpdateListener(new C0045d());
        return valueAnimatorOfFloat;
    }

    private k1.g E(float f3, float f4, float f5, int i3) {
        k1.k kVarM = k1.k.a().A(f3).E(f3).s(f4).w(f4).m();
        k1.g gVarM = k1.g.m(this.f3332b, f5);
        gVarM.setShapeAppearanceModel(kVarM);
        gVarM.Z(0, i3, 0, i3);
        return gVarM;
    }

    private void F() {
        this.f3313s = D(67, 0.0f, 1.0f);
        ValueAnimator valueAnimatorD = D(50, 1.0f, 0.0f);
        this.f3312r = valueAnimatorD;
        valueAnimatorD.addListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f3308n;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean H(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        AccessibilityManager accessibilityManager = this.f3311q;
        if (accessibilityManager != null) {
            f0.c.b(accessibilityManager, this.f3305k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z2) {
        if (this.f3307m != z2) {
            this.f3307m = z2;
            this.f3313s.cancel();
            this.f3312r.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(AutoCompleteTextView autoCompleteTextView) {
        if (f3298t) {
            int boxBackgroundMode = this.f3331a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f3310p);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f3309o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void L(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new l(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f3300f);
        if (f3298t) {
            autoCompleteTextView.setOnDismissListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (G()) {
            this.f3306l = false;
        }
        if (this.f3306l) {
            this.f3306l = false;
            return;
        }
        if (f3298t) {
            J(!this.f3307m);
        } else {
            this.f3307m = !this.f3307m;
            this.f3333c.toggle();
        }
        if (!this.f3307m) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.f3306l = true;
        this.f3308n = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(AutoCompleteTextView autoCompleteTextView) {
        if (H(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.f3331a.getBoxBackgroundMode();
        k1.g boxBackground = this.f3331a.getBoxBackground();
        int iD = z0.c.d(autoCompleteTextView, t0.b.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            A(autoCompleteTextView, iD, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            z(autoCompleteTextView, iD, iArr, boxBackground);
        }
    }

    private void z(AutoCompleteTextView autoCompleteTextView, int i3, int[][] iArr, k1.g gVar) {
        int boxBackgroundColor = this.f3331a.getBoxBackgroundColor();
        int[] iArr2 = {z0.c.h(i3, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f3298t) {
            t.p0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        k1.g gVar2 = new k1.g(gVar.D());
        gVar2.X(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int iG = t.G(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int iF = t.F(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        t.p0(autoCompleteTextView, layerDrawable);
        t.y0(autoCompleteTextView, iG, paddingTop, iF, paddingBottom);
    }

    void O(AutoCompleteTextView autoCompleteTextView) {
        if (!H(autoCompleteTextView) && this.f3331a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
            y(autoCompleteTextView);
        }
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        float dimensionPixelOffset = this.f3332b.getResources().getDimensionPixelOffset(t0.d.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f3332b.getResources().getDimensionPixelOffset(t0.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f3332b.getResources().getDimensionPixelOffset(t0.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        k1.g gVarE = E(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        k1.g gVarE2 = E(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f3310p = gVarE;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f3309o = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, gVarE);
        this.f3309o.addState(new int[0], gVarE2);
        int i3 = this.f3334d;
        if (i3 == 0) {
            i3 = f3298t ? t0.e.mtrl_dropdown_arrow : t0.e.mtrl_ic_arrow_drop_down;
        }
        this.f3331a.setEndIconDrawable(i3);
        TextInputLayout textInputLayout = this.f3331a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(t0.i.exposed_dropdown_menu_content_description));
        this.f3331a.setEndIconOnClickListener(new k());
        this.f3331a.g(this.f3302h);
        this.f3331a.h(this.f3303i);
        F();
        this.f3311q = (AccessibilityManager) this.f3332b.getSystemService("accessibility");
        this.f3331a.addOnAttachStateChangeListener(this.f3304j);
        B();
    }

    @Override // com.google.android.material.textfield.e
    boolean b(int i3) {
        return i3 != 0;
    }

    @Override // com.google.android.material.textfield.e
    boolean d() {
        return true;
    }
}
