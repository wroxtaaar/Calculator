package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e0.t;
import java.util.ArrayList;
import java.util.List;
import t0.f;
import u0.h;
import u0.i;
import u0.j;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f3436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f3437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f3438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f3439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f3440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f3441h;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f3444d;

        a(boolean z2, View view, View view2) {
            this.f3442b = z2;
            this.f3443c = view;
            this.f3444d = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3442b) {
                return;
            }
            this.f3443c.setVisibility(4);
            this.f3444d.setAlpha(1.0f);
            this.f3444d.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f3442b) {
                this.f3443c.setVisibility(0);
                this.f3444d.setAlpha(0.0f);
                this.f3444d.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3446b;

        b(View view) {
            this.f3446b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3446b.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x0.d f3448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Drawable f3449c;

        c(x0.d dVar, Drawable drawable) {
            this.f3448b = dVar;
            this.f3449c = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3448b.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f3448b.setCircularRevealOverlayDrawable(this.f3449c);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x0.d f3451b;

        d(x0.d dVar) {
            this.f3451b = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            x0.d.e revealInfo = this.f3451b.getRevealInfo();
            revealInfo.f6435c = Float.MAX_VALUE;
            this.f3451b.setRevealInfo(revealInfo);
        }
    }

    protected static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f3453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f3454b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.f3436c = new Rect();
        this.f3437d = new RectF();
        this.f3438e = new RectF();
        this.f3439f = new int[2];
    }

    private ViewGroup K(View view) {
        View viewFindViewById = view.findViewById(f.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return f0(viewFindViewById);
        }
        return ((view instanceof n1.b) || (view instanceof n1.a)) ? f0(((ViewGroup) view).getChildAt(0)) : f0(view);
    }

    private void L(View view, e eVar, i iVar, i iVar2, float f3, float f4, float f5, float f6, RectF rectF) {
        float fS = S(eVar, iVar, f3, f5);
        float fS2 = S(eVar, iVar2, f4, f6);
        Rect rect = this.f3436c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f3437d;
        rectF2.set(rect);
        RectF rectF3 = this.f3438e;
        T(view, rectF3);
        rectF3.offset(fS, fS2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f3440g, this.f3441h);
    }

    private Pair<i, i> N(float f3, float f4, boolean z2, e eVar) {
        i iVarE;
        i iVarE2;
        if (f3 == 0.0f || f4 == 0.0f) {
            iVarE = eVar.f3453a.e("translationXLinear");
            iVarE2 = eVar.f3453a.e("translationYLinear");
        } else if ((!z2 || f4 >= 0.0f) && (z2 || f4 <= 0.0f)) {
            iVarE = eVar.f3453a.e("translationXCurveDownwards");
            iVarE2 = eVar.f3453a.e("translationYCurveDownwards");
        } else {
            iVarE = eVar.f3453a.e("translationXCurveUpwards");
            iVarE2 = eVar.f3453a.e("translationYCurveUpwards");
        }
        return new Pair<>(iVarE, iVarE2);
    }

    private float O(View view, View view2, j jVar) {
        RectF rectF = this.f3437d;
        RectF rectF2 = this.f3438e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, j jVar) {
        RectF rectF = this.f3437d;
        RectF rectF2 = this.f3438e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, j jVar) {
        float fCenterX;
        float fCenterX2;
        float f3;
        RectF rectF = this.f3437d;
        RectF rectF2 = this.f3438e;
        M(view, rectF);
        T(view2, rectF2);
        int i3 = jVar.f6277a & 7;
        if (i3 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else {
            if (i3 != 3) {
                if (i3 != 5) {
                    f3 = 0.0f;
                } else {
                    fCenterX = rectF2.right;
                    fCenterX2 = rectF.right;
                }
                return f3 + jVar.f6278b;
            }
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        }
        f3 = fCenterX - fCenterX2;
        return f3 + jVar.f6278b;
    }

    private float R(View view, View view2, j jVar) {
        float fCenterY;
        float fCenterY2;
        float f3;
        RectF rectF = this.f3437d;
        RectF rectF2 = this.f3438e;
        M(view, rectF);
        T(view2, rectF2);
        int i3 = jVar.f6277a & 112;
        if (i3 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else {
            if (i3 != 48) {
                if (i3 != 80) {
                    f3 = 0.0f;
                } else {
                    fCenterY = rectF2.bottom;
                    fCenterY2 = rectF.bottom;
                }
                return f3 + jVar.f6279c;
            }
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        }
        f3 = fCenterY - fCenterY2;
        return f3 + jVar.f6279c;
    }

    private float S(e eVar, i iVar, float f3, float f4) {
        long jC = iVar.c();
        long jD = iVar.d();
        i iVarE = eVar.f3453a.e("expansion");
        return u0.a.a(f3, f4, iVar.e().getInterpolation((((iVarE.c() + iVarE.d()) + 17) - jC) / jD));
    }

    private void T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f3439f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z2, boolean z3, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupK;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof x0.d) && x0.c.f6428a == 0) || (viewGroupK = K(view2)) == null) {
                return;
            }
            if (z2) {
                if (!z3) {
                    u0.d.f6263a.set(viewGroupK, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, u0.d.f6263a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, u0.d.f6263a, 0.0f);
            }
            eVar.f3453a.e("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V(View view, View view2, boolean z2, boolean z3, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof x0.d) {
            x0.d dVar = (x0.d) view2;
            int iD0 = d0(view);
            int i3 = 16777215 & iD0;
            if (z2) {
                if (!z3) {
                    dVar.setCircularRevealScrimColor(iD0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(dVar, x0.d.C0098d.f6432a, i3);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(dVar, x0.d.C0098d.f6432a, iD0);
            }
            objectAnimatorOfInt.setEvaluator(u0.c.b());
            eVar.f3453a.e("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void W(View view, View view2, boolean z2, e eVar, List<Animator> list) {
        float fQ = Q(view, view2, eVar.f3454b);
        float fR = R(view, view2, eVar.f3454b);
        Pair<i, i> pairN = N(fQ, fR, z2, eVar);
        i iVar = (i) pairN.first;
        i iVar2 = (i) pairN.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z2) {
            fQ = this.f3440g;
        }
        fArr[0] = fQ;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z2) {
            fR = this.f3441h;
        }
        fArr2[0] = fR;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    private void X(View view, View view2, boolean z2, boolean z3, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fW = t.w(view2) - t.w(view);
        if (z2) {
            if (!z3) {
                view2.setTranslationZ(-fW);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fW);
        }
        eVar.f3453a.e("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(View view, View view2, boolean z2, boolean z3, e eVar, float f3, float f4, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof x0.d) {
            x0.d dVar = (x0.d) view2;
            float fO = O(view, view2, eVar.f3454b);
            float fP = P(view, view2, eVar.f3454b);
            ((FloatingActionButton) view).i(this.f3436c);
            float fWidth = this.f3436c.width() / 2.0f;
            i iVarE = eVar.f3453a.e("expansion");
            if (z2) {
                if (!z3) {
                    dVar.setRevealInfo(new x0.d.e(fO, fP, fWidth));
                }
                if (z3) {
                    fWidth = dVar.getRevealInfo().f6435c;
                }
                animatorA = x0.a.a(dVar, fO, fP, e1.a.b(fO, fP, 0.0f, 0.0f, f3, f4));
                animatorA.addListener(new d(dVar));
                b0(view2, iVarE.c(), (int) fO, (int) fP, fWidth, list);
            } else {
                float f5 = dVar.getRevealInfo().f6435c;
                Animator animatorA2 = x0.a.a(dVar, fO, fP, fWidth);
                int i3 = (int) fO;
                int i4 = (int) fP;
                b0(view2, iVarE.c(), i3, i4, f5, list);
                a0(view2, iVarE.c(), iVarE.d(), eVar.f3453a.f(), i3, i4, fWidth, list);
                animatorA = animatorA2;
            }
            iVarE.a(animatorA);
            list.add(animatorA);
            list2.add(x0.a.b(dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z(View view, View view2, boolean z2, boolean z3, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof x0.d) && (view instanceof ImageView)) {
            x0.d dVar = (x0.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z2) {
                if (!z3) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, u0.e.f6264b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, u0.e.f6264b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.f3453a.e("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(dVar, drawable));
        }
    }

    private void a0(View view, long j3, long j4, long j5, int i3, int i4, float f3, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j6 = j3 + j4;
            if (j6 < j5) {
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i3, i4, f3, f3);
                animatorCreateCircularReveal.setStartDelay(j6);
                animatorCreateCircularReveal.setDuration(j5 - j6);
                list.add(animatorCreateCircularReveal);
            }
        }
    }

    private void b0(View view, long j3, int i3, int i4, float f3, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j3 <= 0) {
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i3, i4, f3, f3);
        animatorCreateCircularReveal.setStartDelay(0L);
        animatorCreateCircularReveal.setDuration(j3);
        list.add(animatorCreateCircularReveal);
    }

    private void c0(View view, View view2, boolean z2, boolean z3, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fQ = Q(view, view2, eVar.f3454b);
        float fR = R(view, view2, eVar.f3454b);
        Pair<i, i> pairN = N(fQ, fR, z2, eVar);
        i iVar = (i) pairN.first;
        i iVar2 = (i) pairN.second;
        if (z2) {
            if (!z3) {
                view2.setTranslationX(-fQ);
                view2.setTranslationY(-fR);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, iVar, iVar2, -fQ, -fR, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fQ);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fR);
        }
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private int d0(View view) {
        ColorStateList colorStateListS = t.s(view);
        if (colorStateListS != null) {
            return colorStateListS.getColorForState(view.getDrawableState(), colorStateListS.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z2, boolean z3) {
        e eVarE0 = e0(view2.getContext(), z2);
        if (z2) {
            this.f3440g = view.getTranslationX();
            this.f3441h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            X(view, view2, z2, z3, eVarE0, arrayList, arrayList2);
        }
        RectF rectF = this.f3437d;
        c0(view, view2, z2, z3, eVarE0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        W(view, view2, z2, eVarE0, arrayList);
        Z(view, view2, z2, z3, eVarE0, arrayList, arrayList2);
        Y(view, view2, z2, z3, eVarE0, fWidth, fHeight, arrayList, arrayList2);
        V(view, view2, z2, z3, eVarE0, arrayList, arrayList2);
        U(view, view2, z2, z3, eVarE0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        u0.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z2, view2, view));
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            animatorSet.addListener(arrayList2.get(i3));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    protected abstract e e0(Context context, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f1117h == 0) {
            fVar.f1117h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3436c = new Rect();
        this.f3437d = new RectF();
        this.f3438e = new RectF();
        this.f3439f = new int[2];
    }
}
