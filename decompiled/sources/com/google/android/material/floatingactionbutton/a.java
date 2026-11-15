package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import e0.t;
import java.util.ArrayList;
import java.util.Iterator;
import k1.n;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
class a {
    static final TimeInterpolator C = u0.a.f6259c;
    static final int[] D = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] E = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] F = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] G = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] H = {R.attr.state_enabled};
    static final int[] I = new int[0];
    private ViewTreeObserver.OnPreDrawListener B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    k1.k f2984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    k1.g f2985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Drawable f2986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Drawable f2987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2988e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f2990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f2991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f2992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f2993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.google.android.material.internal.i f2994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Animator f2995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private u0.h f2996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private u0.h f2997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f2998o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3000q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f3002s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f3003t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<j> f3004u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final FloatingActionButton f3005v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final j1.b f3006w;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f2989f = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f2999p = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3001r = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Rect f3007x = new Rect();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final RectF f3008y = new RectF();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final RectF f3009z = new RectF();
    private final Matrix A = new Matrix();

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class C0039a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f3012d;

        C0039a(boolean z2, k kVar) {
            this.f3011c = z2;
            this.f3012d = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3010b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f3001r = 0;
            a.this.f2995l = null;
            if (this.f3010b) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.f3005v;
            boolean z2 = this.f3011c;
            floatingActionButton.b(z2 ? 8 : 4, z2);
            k kVar = this.f3012d;
            if (kVar != null) {
                kVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f3005v.b(0, this.f3011c);
            a.this.f3001r = 1;
            a.this.f2995l = animator;
            this.f3010b = false;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f3015c;

        b(boolean z2, k kVar) {
            this.f3014b = z2;
            this.f3015c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f3001r = 0;
            a.this.f2995l = null;
            k kVar = this.f3015c;
            if (kVar != null) {
                kVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f3005v.b(0, this.f3014b);
            a.this.f3001r = 2;
            a.this.f2995l = animator;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class c extends u0.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f3, Matrix matrix, Matrix matrix2) {
            a.this.f2999p = f3;
            return super.evaluate(f3, matrix, matrix2);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f3018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f3019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f3020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f3021e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f3022f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f3023g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f3024h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Matrix f3025i;

        d(float f3, float f4, float f5, float f6, float f7, float f8, float f9, Matrix matrix) {
            this.f3018b = f3;
            this.f3019c = f4;
            this.f3020d = f5;
            this.f3021e = f6;
            this.f3022f = f7;
            this.f3023g = f8;
            this.f3024h = f9;
            this.f3025i = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f3005v.setAlpha(u0.a.b(this.f3018b, this.f3019c, 0.0f, 0.2f, fFloatValue));
            a.this.f3005v.setScaleX(u0.a.a(this.f3020d, this.f3021e, fFloatValue));
            a.this.f3005v.setScaleY(u0.a.a(this.f3022f, this.f3021e, fFloatValue));
            a.this.f2999p = u0.a.a(this.f3023g, this.f3024h, fFloatValue);
            a.this.h(u0.a.a(this.f3023g, this.f3024h, fFloatValue), this.f3025i);
            a.this.f3005v.setImageMatrix(this.f3025i);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class e implements TypeEvaluator<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FloatEvaluator f3027a = new FloatEvaluator();

        e() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f3, Float f4, Float f5) {
            float fFloatValue = this.f3027a.evaluate(f3, (Number) f4, (Number) f5).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.F();
            return true;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class g extends m {
        g() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class h extends m {
        h() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            a aVar = a.this;
            return aVar.f2990g + aVar.f2991h;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class i extends m {
        i() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            a aVar = a.this;
            return aVar.f2990g + aVar.f2992i;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface j {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface k {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class l extends m {
        l() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        protected float a() {
            return a.this.f2990g;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f3035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f3036d;

        private m() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.d0((int) this.f3036d);
            this.f3034b = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f3034b) {
                k1.g gVar = a.this.f2985b;
                this.f3035c = gVar == null ? 0.0f : gVar.w();
                this.f3036d = a();
                this.f3034b = true;
            }
            a aVar = a.this;
            float f3 = this.f3035c;
            aVar.d0((int) (f3 + ((this.f3036d - f3) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ m(a aVar, C0039a c0039a) {
            this();
        }
    }

    a(FloatingActionButton floatingActionButton, j1.b bVar) {
        this.f3005v = floatingActionButton;
        this.f3006w = bVar;
        com.google.android.material.internal.i iVar = new com.google.android.material.internal.i();
        this.f2994k = iVar;
        iVar.a(D, k(new i()));
        iVar.a(E, k(new h()));
        iVar.a(F, k(new h()));
        iVar.a(G, k(new h()));
        iVar.a(H, k(new l()));
        iVar.a(I, k(new g()));
        this.f2998o = floatingActionButton.getRotation();
    }

    private boolean X() {
        return t.S(this.f3005v) && !this.f3005v.isInEditMode();
    }

    private void e0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f3, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f3005v.getDrawable();
        if (drawable == null || this.f3000q == 0) {
            return;
        }
        RectF rectF = this.f3008y;
        RectF rectF2 = this.f3009z;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i3 = this.f3000q;
        rectF2.set(0.0f, 0.0f, i3, i3);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i4 = this.f3000q;
        matrix.postScale(f3, f3, i4 / 2.0f, i4 / 2.0f);
    }

    private AnimatorSet i(u0.h hVar, float f3, float f4, float f5) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f3005v, (Property<FloatingActionButton, Float>) View.ALPHA, f3);
        hVar.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f3005v, (Property<FloatingActionButton, Float>) View.SCALE_X, f4);
        hVar.e("scale").a(objectAnimatorOfFloat2);
        e0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f3005v, (Property<FloatingActionButton, Float>) View.SCALE_Y, f4);
        hVar.e("scale").a(objectAnimatorOfFloat3);
        e0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f5, this.A);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f3005v, new u0.f(), new c(), new Matrix(this.A));
        hVar.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        u0.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f3, float f4, float f5) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new d(this.f3005v.getAlpha(), f3, this.f3005v.getScaleX(), f4, this.f3005v.getScaleY(), this.f2999p, f5, new Matrix(this.A)));
        arrayList.add(valueAnimatorOfFloat);
        u0.b.a(animatorSet, arrayList);
        animatorSet.setDuration(f1.a.d(this.f3005v.getContext(), t0.b.motionDurationLong1, this.f3005v.getContext().getResources().getInteger(t0.g.material_motion_duration_long_1)));
        animatorSet.setInterpolator(f1.a.e(this.f3005v.getContext(), t0.b.motionEasingStandard, u0.a.f6258b));
        return animatorSet;
    }

    private ValueAnimator k(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(C);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.B == null) {
            this.B = new f();
        }
        return this.B;
    }

    void A() {
    }

    void B() {
        ViewTreeObserver viewTreeObserver = this.f3005v.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.B;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.B = null;
        }
    }

    void C(int[] iArr) {
        this.f2994k.d(iArr);
    }

    void D(float f3, float f4, float f5) {
        c0();
        d0(f3);
    }

    void E(Rect rect) {
        d0.i.d(this.f2987d, "Didn't initialize content background");
        if (!W()) {
            this.f3006w.d(this.f2987d);
        } else {
            this.f3006w.d(new InsetDrawable(this.f2987d, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void F() {
        float rotation = this.f3005v.getRotation();
        if (this.f2998o != rotation) {
            this.f2998o = rotation;
            a0();
        }
    }

    void G() {
        ArrayList<j> arrayList = this.f3004u;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    void H() {
        ArrayList<j> arrayList = this.f3004u;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    boolean I() {
        return true;
    }

    void J(ColorStateList colorStateList) {
        k1.g gVar = this.f2985b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
    }

    void K(PorterDuff.Mode mode) {
        k1.g gVar = this.f2985b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    final void L(float f3) {
        if (this.f2990g != f3) {
            this.f2990g = f3;
            D(f3, this.f2991h, this.f2992i);
        }
    }

    void M(boolean z2) {
        this.f2988e = z2;
    }

    final void N(u0.h hVar) {
        this.f2997n = hVar;
    }

    final void O(float f3) {
        if (this.f2991h != f3) {
            this.f2991h = f3;
            D(this.f2990g, f3, this.f2992i);
        }
    }

    final void P(float f3) {
        this.f2999p = f3;
        Matrix matrix = this.A;
        h(f3, matrix);
        this.f3005v.setImageMatrix(matrix);
    }

    final void Q(int i3) {
        if (this.f3000q != i3) {
            this.f3000q = i3;
            b0();
        }
    }

    final void R(float f3) {
        if (this.f2992i != f3) {
            this.f2992i = f3;
            D(this.f2990g, this.f2991h, f3);
        }
    }

    void S(ColorStateList colorStateList) {
        Drawable drawable = this.f2986c;
        if (drawable != null) {
            x.a.o(drawable, i1.b.a(colorStateList));
        }
    }

    void T(boolean z2) {
        this.f2989f = z2;
        c0();
    }

    final void U(k1.k kVar) {
        this.f2984a = kVar;
        k1.g gVar = this.f2985b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Object obj = this.f2986c;
        if (obj instanceof n) {
            ((n) obj).setShapeAppearanceModel(kVar);
        }
    }

    final void V(u0.h hVar) {
        this.f2996m = hVar;
    }

    boolean W() {
        return true;
    }

    final boolean Y() {
        return !this.f2988e || this.f3005v.getSizeDimension() >= this.f2993j;
    }

    void Z(k kVar, boolean z2) {
        if (x()) {
            return;
        }
        Animator animator = this.f2995l;
        if (animator != null) {
            animator.cancel();
        }
        boolean z3 = this.f2996m == null;
        if (!X()) {
            this.f3005v.b(0, z2);
            this.f3005v.setAlpha(1.0f);
            this.f3005v.setScaleY(1.0f);
            this.f3005v.setScaleX(1.0f);
            P(1.0f);
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (this.f3005v.getVisibility() != 0) {
            this.f3005v.setAlpha(0.0f);
            this.f3005v.setScaleY(z3 ? 0.4f : 0.0f);
            this.f3005v.setScaleX(z3 ? 0.4f : 0.0f);
            P(z3 ? 0.4f : 0.0f);
        }
        u0.h hVar = this.f2996m;
        AnimatorSet animatorSetI = hVar != null ? i(hVar, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f);
        animatorSetI.addListener(new b(z2, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f3002s;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener(it.next());
            }
        }
        animatorSetI.start();
    }

    void a0() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f2998o % 90.0f != 0.0f) {
                if (this.f3005v.getLayerType() != 1) {
                    this.f3005v.setLayerType(1, null);
                }
            } else if (this.f3005v.getLayerType() != 0) {
                this.f3005v.setLayerType(0, null);
            }
        }
        k1.g gVar = this.f2985b;
        if (gVar != null) {
            gVar.b0((int) this.f2998o);
        }
    }

    final void b0() {
        P(this.f2999p);
    }

    final void c0() {
        Rect rect = this.f3007x;
        r(rect);
        E(rect);
        this.f3006w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void d0(float f3) {
        k1.g gVar = this.f2985b;
        if (gVar != null) {
            gVar.W(f3);
        }
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f3003t == null) {
            this.f3003t = new ArrayList<>();
        }
        this.f3003t.add(animatorListener);
    }

    void f(Animator.AnimatorListener animatorListener) {
        if (this.f3002s == null) {
            this.f3002s = new ArrayList<>();
        }
        this.f3002s.add(animatorListener);
    }

    void g(j jVar) {
        if (this.f3004u == null) {
            this.f3004u = new ArrayList<>();
        }
        this.f3004u.add(jVar);
    }

    final Drawable l() {
        return this.f2987d;
    }

    float m() {
        return this.f2990g;
    }

    boolean n() {
        return this.f2988e;
    }

    final u0.h o() {
        return this.f2997n;
    }

    float p() {
        return this.f2991h;
    }

    void r(Rect rect) {
        int sizeDimension = this.f2988e ? (this.f2993j - this.f3005v.getSizeDimension()) / 2 : 0;
        float fM = this.f2989f ? m() + this.f2992i : 0.0f;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(fM));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(fM * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float s() {
        return this.f2992i;
    }

    final k1.k t() {
        return this.f2984a;
    }

    final u0.h u() {
        return this.f2996m;
    }

    void v(k kVar, boolean z2) {
        if (w()) {
            return;
        }
        Animator animator = this.f2995l;
        if (animator != null) {
            animator.cancel();
        }
        if (!X()) {
            this.f3005v.b(z2 ? 8 : 4, z2);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        u0.h hVar = this.f2997n;
        AnimatorSet animatorSetI = hVar != null ? i(hVar, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f);
        animatorSetI.addListener(new C0039a(z2, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f3003t;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener(it.next());
            }
        }
        animatorSetI.start();
    }

    boolean w() {
        if (this.f3005v.getVisibility() == 0) {
            return this.f3001r == 1;
        }
        return this.f3001r != 2;
    }

    boolean x() {
        if (this.f3005v.getVisibility() != 0) {
            return this.f3001r == 2;
        }
        return this.f3001r != 1;
    }

    void y() {
        this.f2994k.c();
    }

    void z() {
        k1.g gVar = this.f2985b;
        if (gVar != null) {
            k1.h.f(this.f3005v, gVar);
        }
        if (I()) {
            this.f3005v.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }
}
