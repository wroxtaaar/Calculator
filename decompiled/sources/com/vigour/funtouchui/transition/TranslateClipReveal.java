package com.vigour.funtouchui.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class TranslateClipReveal extends Visibility {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static TimeInterpolator f3471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f3472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f3473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static float f3474h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeInterpolator f3475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f3476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f3477d;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f3479c;

        a(View view, Rect rect) {
            this.f3478b = view;
            this.f3479c = rect;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3478b.setClipBounds(this.f3479c);
            if (TranslateClipReveal.f3473g) {
                this.f3478b.setElevation(TranslateClipReveal.f3474h);
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f3482c;

        public b() {
        }

        public b(int i3, int i4, float f3) {
            this.f3480a = i3;
            this.f3481b = i4;
            this.f3482c = f3;
        }
    }

    private static class d extends Property<View, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f3484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f3485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f3486c;

        public d(char c3) {
            super(b.class, "state_" + c3);
            this.f3484a = new Rect();
            this.f3485b = new b();
            this.f3486c = c3;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b get(View view) {
            Rect rect = this.f3484a;
            if (!view.getClipBounds(rect)) {
                rect.setEmpty();
            }
            b bVar = this.f3485b;
            if (this.f3486c == 120) {
                float translationX = view.getTranslationX();
                bVar.f3482c = translationX;
                bVar.f3480a = rect.left + ((int) translationX);
                bVar.f3481b = rect.right + ((int) translationX);
            } else {
                float translationY = view.getTranslationY();
                bVar.f3482c = translationY;
                bVar.f3480a = rect.top + ((int) translationY);
                bVar.f3481b = rect.bottom + ((int) translationY);
            }
            return bVar;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, b bVar) {
            Rect rect = this.f3484a;
            if (view.getClipBounds(rect)) {
                if (this.f3486c == 120) {
                    int i3 = bVar.f3480a;
                    float f3 = bVar.f3482c;
                    rect.left = i3 - ((int) f3);
                    rect.right = bVar.f3481b - ((int) f3);
                } else {
                    int i4 = bVar.f3480a;
                    float f4 = bVar.f3482c;
                    rect.top = i4 - ((int) f4);
                    rect.bottom = bVar.f3481b - ((int) f4);
                }
                view.setClipBounds(rect);
            }
            if (this.f3486c == 120) {
                view.setTranslationX(bVar.f3482c);
            } else {
                view.setTranslationY(bVar.f3482c);
            }
        }
    }

    public TranslateClipReveal() {
        this.f3475b = null;
        this.f3476c = null;
        this.f3477d = null;
        f3471e = null;
    }

    private void c(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put("com.vigour.funtouchui.transition:epicenterReveal:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        transitionValues.values.put("com.vigour.funtouchui.transition:epicenterReveal:translateX", Float.valueOf(view.getTranslationX()));
        transitionValues.values.put("com.vigour.funtouchui.transition:epicenterReveal:translateY", Float.valueOf(view.getTranslationY()));
        transitionValues.values.put("com.vigour.funtouchui.transition:epicenterReveal:translateZ", Float.valueOf(view.getTranslationZ()));
        transitionValues.values.put("com.vigour.funtouchui.transition:epicenterReveal:z", Float.valueOf(view.getZ()));
        transitionValues.values.put("com.vigour.funtouchui.transition:epicenterReveal:clip", view.getClipBounds());
    }

    private static Animator d(View view, b bVar, b bVar2, float f3, b bVar3, b bVar4, float f4, TransitionValues transitionValues, TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2, TimeInterpolator timeInterpolator3) {
        c cVar = new c(null);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Z, f3, f4);
        if (timeInterpolator3 != null) {
            objectAnimatorOfFloat.setInterpolator(timeInterpolator3);
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, new d('x'), cVar, bVar, bVar3);
        if (timeInterpolator != null) {
            objectAnimatorOfObject.setInterpolator(timeInterpolator);
        }
        ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(view, new d('y'), cVar, bVar2, bVar4);
        if (timeInterpolator2 != null) {
            objectAnimatorOfObject2.setInterpolator(timeInterpolator2);
        }
        a aVar = new a(view, (Rect) transitionValues.values.get("com.vigour.funtouchui.transition:epicenterReveal:clip"));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        if (f3472f) {
            animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2, objectAnimatorOfFloat);
        } else {
            animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2, objectAnimatorOfFloat);
        }
        animatorSet.addListener(aVar);
        return animatorSet;
    }

    private Rect e(TransitionValues transitionValues) {
        Rect rect = (Rect) transitionValues.values.get("com.vigour.funtouchui.transition:epicenterReveal:clip");
        return rect == null ? (Rect) transitionValues.values.get("com.vigour.funtouchui.transition:epicenterReveal:bounds") : rect;
    }

    private Rect f(Rect rect) {
        Rect epicenter = getEpicenter();
        if (epicenter != null) {
            return epicenter;
        }
        int iCenterX = rect.centerX();
        int iCenterY = rect.centerY();
        return new Rect(iCenterX, iCenterY, iCenterX, iCenterY);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        c(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        c(transitionValues);
    }

    @Override // android.transition.Transition
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:bounds");
        Rect rectF = f(rect);
        float fCenterX = rectF.centerX() - rect.centerX();
        float fCenterY = rectF.centerY() - rect.centerY();
        float fFloatValue = 0.0f - ((Float) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:z")).floatValue();
        view.setTranslationX(fCenterX);
        view.setTranslationY(fCenterY);
        view.setTranslationZ(fFloatValue);
        float fFloatValue2 = ((Float) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:translateX")).floatValue();
        float fFloatValue3 = ((Float) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:translateY")).floatValue();
        float fFloatValue4 = ((Float) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:translateZ")).floatValue();
        Rect rectE = e(transitionValues2);
        Rect rectF2 = f(rectE);
        view.setClipBounds(rectF2);
        b bVar = new b(rectF2.left, rectF2.right, fCenterX);
        b bVar2 = new b(rectE.left, rectE.right, fFloatValue2);
        b bVar3 = new b(rectF2.top, rectF2.bottom, fCenterY);
        b bVar4 = new b(rectE.top, rectE.bottom, fFloatValue3);
        f3472f = true;
        f3473g = false;
        return d(view, bVar, bVar3, fFloatValue, bVar2, bVar4, fFloatValue4, transitionValues2, this.f3475b, this.f3476c, this.f3477d);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:bounds");
        Rect rectF = f(rect);
        float fCenterX = rectF.centerX() - rect.centerX();
        float fCenterY = rectF.centerY() - rect.centerY();
        float fFloatValue = 0.0f - ((Float) transitionValues.values.get("com.vigour.funtouchui.transition:epicenterReveal:z")).floatValue();
        float fFloatValue2 = ((Float) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:translateX")).floatValue();
        float fFloatValue3 = ((Float) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:translateY")).floatValue();
        float fFloatValue4 = ((Float) transitionValues2.values.get("com.vigour.funtouchui.transition:epicenterReveal:translateZ")).floatValue();
        Rect rectE = e(transitionValues);
        Rect rectF2 = f(rectE);
        view.setClipBounds(rectE);
        b bVar = new b(rectE.left, rectE.right, fFloatValue2);
        b bVar2 = new b(rectF2.left, rectF2.right, fCenterX);
        b bVar3 = new b(rectE.top, rectE.bottom, fFloatValue3);
        b bVar4 = new b(rectF2.top, rectF2.bottom, fCenterY);
        f3472f = false;
        f3473g = true;
        return d(view, bVar, bVar3, fFloatValue4, bVar2, bVar4, fFloatValue, transitionValues2, this.f3475b, this.f3476c, this.f3477d);
    }

    private static class c implements TypeEvaluator<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f3483a;

        private c() {
            this.f3483a = new b();
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b evaluate(float f3, b bVar, b bVar2) {
            b bVar3 = this.f3483a;
            int i3 = bVar.f3481b;
            bVar3.f3481b = i3 + ((int) ((bVar2.f3481b - i3) * f3));
            int i4 = bVar.f3480a;
            bVar3.f3480a = i4 + ((int) ((bVar2.f3480a - i4) * f3));
            float f4 = bVar.f3482c;
            bVar3.f3482c = f4 + ((int) ((bVar2.f3482c - f4) * f3));
            return bVar3;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    public TranslateClipReveal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3475b = com.vigour.funtouchui.transition.a.f3487a;
        TimeInterpolator timeInterpolator = com.vigour.funtouchui.transition.a.f3488b;
        this.f3476c = timeInterpolator;
        this.f3477d = timeInterpolator;
        f3471e = com.vigour.funtouchui.transition.a.f3489c;
        f3474h = context.getResources().getDimension(y1.c.vigour_popup_menu_elevation);
    }
}
