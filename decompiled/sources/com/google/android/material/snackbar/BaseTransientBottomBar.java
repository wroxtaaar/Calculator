package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import e0.t;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final Handler f3158p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final boolean f3159q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f3160r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f3161s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f3162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final o f3163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.material.snackbar.a f3164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f3166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<m<B>> f3173l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Behavior f3174m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AccessibilityManager f3175n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    com.google.android.material.snackbar.b.InterfaceC0041b f3176o;

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final n f3177k = new n(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void P(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f3177k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.f3177k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f3177k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3178b;

        a(int i3) {
            this.f3178b = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.u(this.f3178b);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f3163b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f3163b.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f3163b.setScaleY(fFloatValue);
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.v();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f3164c.b(70, SecurityKeyException.SK_ERROR_UNSUPPORTED_PROTOCOL_VERSION);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3184c;

        e(int i3) {
            this.f3184c = i3;
            this.f3183b = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f3159q) {
                t.Y(BaseTransientBottomBar.this.f3163b, iIntValue - this.f3183b);
            } else {
                BaseTransientBottomBar.this.f3163b.setTranslationY(iIntValue);
            }
            this.f3183b = iIntValue;
        }
    }

    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3186b;

        f(int i3) {
            this.f3186b = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.u(this.f3186b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f3164c.a(0, SecurityKeyException.SK_ERROR_UNSUPPORTED_PROTOCOL_VERSION);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3188b = 0;

        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f3159q) {
                t.Y(BaseTransientBottomBar.this.f3163b, iIntValue - this.f3188b);
            } else {
                BaseTransientBottomBar.this.f3163b.setTranslationY(iIntValue);
            }
            this.f3188b = iIntValue;
        }
    }

    class h implements Handler.Callback {
        h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                ((BaseTransientBottomBar) message.obj).A();
                return true;
            }
            if (i3 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).o(message.arg1);
            return true;
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.u(3);
        }
    }

    class j implements SwipeDismissBehavior.c {
        j() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.i(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i3) {
            if (i3 == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.f3176o);
            } else if (i3 == 1 || i3 == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.f3176o);
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = BaseTransientBottomBar.this.f3163b;
            if (oVar == null) {
                return;
            }
            if (oVar.getParent() != null) {
                BaseTransientBottomBar.this.f3163b.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f3163b.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.C();
            } else {
                BaseTransientBottomBar.this.E();
            }
        }
    }

    class l extends AnimatorListenerAdapter {
        l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.v();
        }
    }

    public static abstract class m<B> {
        public void a(B b3, int i3) {
        }

        public void b(B b3) {
        }
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.material.snackbar.b.InterfaceC0041b f3194a;

        public n(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof o;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.f3194a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.f3194a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f3194a = baseTransientBottomBar.f3176o;
        }
    }

    protected static class o extends FrameLayout {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final View.OnTouchListener f3195l = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private BaseTransientBottomBar<?> f3196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f3198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f3199e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f3200f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f3201g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ColorStateList f3202h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private PorterDuff.Mode f3203i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Rect f3204j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f3205k;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected o(Context context) {
            this(context, null);
        }

        private Drawable c() {
            float dimension = getResources().getDimension(t0.d.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(z0.c.i(this, t0.b.colorSurface, t0.b.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f3202h == null) {
                return x.a.r(gradientDrawable);
            }
            Drawable drawableR = x.a.r(gradientDrawable);
            x.a.o(drawableR, this.f3202h);
            return drawableR;
        }

        private void d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f3204j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f3196b = baseTransientBottomBar;
        }

        void b(ViewGroup viewGroup) {
            this.f3205k = true;
            viewGroup.addView(this);
            this.f3205k = false;
        }

        float getActionTextColorAlpha() {
            return this.f3199e;
        }

        int getAnimationMode() {
            return this.f3197c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f3198d;
        }

        int getMaxInlineActionWidth() {
            return this.f3201g;
        }

        int getMaxWidth() {
            return this.f3200f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f3196b;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.r();
            }
            t.j0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f3196b;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.s();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
            super.onLayout(z2, i3, i4, i5, i6);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f3196b;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.t();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (this.f3200f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i5 = this.f3200f;
                if (measuredWidth > i5) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
                }
            }
        }

        void setAnimationMode(int i3) {
            this.f3197c = i3;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f3202h != null) {
                drawable = x.a.r(drawable.mutate());
                x.a.o(drawable, this.f3202h);
                x.a.p(drawable, this.f3203i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f3202h = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = x.a.r(getBackground().mutate());
                x.a.o(drawableR, colorStateList);
                x.a.p(drawableR, this.f3203i);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f3203i = mode;
            if (getBackground() != null) {
                Drawable drawableR = x.a.r(getBackground().mutate());
                x.a.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f3205k || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            d((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f3196b;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.G();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f3195l);
            super.setOnClickListener(onClickListener);
        }

        protected o(Context context, AttributeSet attributeSet) {
            super(m1.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, t0.k.SnackbarLayout);
            int i3 = t0.k.SnackbarLayout_elevation;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                t.t0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, 0));
            }
            this.f3197c = typedArrayObtainStyledAttributes.getInt(t0.k.SnackbarLayout_animationMode, 0);
            this.f3198d = typedArrayObtainStyledAttributes.getFloat(t0.k.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(h1.c.a(context2, typedArrayObtainStyledAttributes, t0.k.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.o.f(typedArrayObtainStyledAttributes.getInt(t0.k.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f3199e = typedArrayObtainStyledAttributes.getFloat(t0.k.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f3200f = typedArrayObtainStyledAttributes.getDimensionPixelSize(t0.k.SnackbarLayout_android_maxWidth, -1);
            this.f3201g = typedArrayObtainStyledAttributes.getDimensionPixelSize(t0.k.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f3195l);
            setFocusable(true);
            if (getBackground() == null) {
                t.p0(this, c());
            }
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f3159q = i3 >= 16 && i3 <= 19;
        f3160r = new int[]{t0.b.snackbarStyle};
        f3161s = BaseTransientBottomBar.class.getSimpleName();
        f3158p = new Handler(Looper.getMainLooper(), new h());
    }

    private void B() {
        if (y()) {
            f();
            return;
        }
        if (this.f3163b.getParent() != null) {
            this.f3163b.setVisibility(0);
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        ValueAnimator valueAnimatorJ = j(0.0f, 1.0f);
        ValueAnimator valueAnimatorM = m(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorJ, valueAnimatorM);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new l());
        animatorSet.start();
    }

    private void D(int i3) {
        ValueAnimator valueAnimatorJ = j(1.0f, 0.0f);
        valueAnimatorJ.setDuration(75L);
        valueAnimatorJ.addListener(new a(i3));
        valueAnimatorJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        int iN = n();
        if (f3159q) {
            t.Y(this.f3163b, iN);
        } else {
            this.f3163b.setTranslationY(iN);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iN, 0);
        valueAnimator.setInterpolator(u0.a.f6258b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(iN));
        valueAnimator.start();
    }

    private void F(int i3) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, n());
        valueAnimator.setInterpolator(u0.a.f6258b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f(i3));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        ViewGroup.LayoutParams layoutParams = this.f3163b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.f3163b.f3204j == null) {
            Log.w(f3161s, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f3163b.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = this.f3163b.f3204j.bottom + (k() != null ? this.f3171j : this.f3167f);
        marginLayoutParams.leftMargin = this.f3163b.f3204j.left + this.f3168g;
        marginLayoutParams.rightMargin = this.f3163b.f3204j.right + this.f3169h;
        marginLayoutParams.topMargin = this.f3163b.f3204j.top;
        this.f3163b.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !z()) {
            return;
        }
        this.f3163b.removeCallbacks(this.f3166e);
        this.f3163b.post(this.f3166e);
    }

    private void g(int i3) {
        if (this.f3163b.getAnimationMode() == 1) {
            D(i3);
        } else {
            F(i3);
        }
    }

    private int h() {
        if (k() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        k().getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        this.f3162a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f3162a.getHeight()) - i3;
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(u0.a.f6257a);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator m(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(u0.a.f6260d);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    private int n() {
        int height = this.f3163b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f3163b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    private boolean q() {
        ViewGroup.LayoutParams layoutParams = this.f3163b.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void w() {
        this.f3171j = h();
        G();
    }

    private void x(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorL = this.f3174m;
        if (swipeDismissBehaviorL == null) {
            swipeDismissBehaviorL = l();
        }
        if (swipeDismissBehaviorL instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorL).P(this);
        }
        swipeDismissBehaviorL.K(new j());
        fVar.o(swipeDismissBehaviorL);
        if (k() == null) {
            fVar.f1116g = 80;
        }
    }

    private boolean z() {
        return this.f3170i > 0 && !this.f3165d && q();
    }

    final void A() {
        if (this.f3163b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f3163b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                x((CoordinatorLayout.f) layoutParams);
            }
            this.f3163b.b(this.f3162a);
            w();
            this.f3163b.setVisibility(4);
        }
        if (t.S(this.f3163b)) {
            B();
        } else {
            this.f3172k = true;
        }
    }

    void f() {
        this.f3163b.post(new k());
    }

    protected void i(int i3) {
        com.google.android.material.snackbar.b.c().b(this.f3176o, i3);
    }

    public View k() {
        return null;
    }

    protected SwipeDismissBehavior<? extends View> l() {
        return new Behavior();
    }

    final void o(int i3) {
        if (y() && this.f3163b.getVisibility() == 0) {
            g(i3);
        } else {
            u(i3);
        }
    }

    public boolean p() {
        return com.google.android.material.snackbar.b.c().e(this.f3176o);
    }

    void r() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f3163b.getRootWindowInsets()) == null) {
            return;
        }
        this.f3170i = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        G();
    }

    void s() {
        if (p()) {
            f3158p.post(new i());
        }
    }

    void t() {
        if (this.f3172k) {
            B();
            this.f3172k = false;
        }
    }

    void u(int i3) {
        com.google.android.material.snackbar.b.c().h(this.f3176o);
        List<m<B>> list = this.f3173l;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3173l.get(size).a(this, i3);
            }
        }
        ViewParent parent = this.f3163b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f3163b);
        }
    }

    void v() {
        com.google.android.material.snackbar.b.c().i(this.f3176o);
        List<m<B>> list = this.f3173l;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3173l.get(size).b(this);
            }
        }
    }

    boolean y() {
        AccessibilityManager accessibilityManager = this.f3175n;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }
}
