package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes.dex */
class b extends a {
    b(FloatingActionButton floatingActionButton, j1.b bVar) {
        super(floatingActionButton, bVar);
    }

    private Animator f0(float f3, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f3005v, "elevation", f3).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f3005v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f4).setDuration(100L));
        animatorSet.setInterpolator(a.C);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void A() {
        c0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void C(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.f3005v.isEnabled()) {
                this.f3005v.setElevation(0.0f);
                this.f3005v.setTranslationZ(0.0f);
                return;
            }
            this.f3005v.setElevation(this.f2990g);
            if (this.f3005v.isPressed()) {
                this.f3005v.setTranslationZ(this.f2992i);
            } else if (this.f3005v.isFocused() || this.f3005v.isHovered()) {
                this.f3005v.setTranslationZ(this.f2991h);
            } else {
                this.f3005v.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void D(float f3, float f4, float f5) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 21) {
            this.f3005v.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(a.D, f0(f3, f5));
            stateListAnimator.addState(a.E, f0(f3, f4));
            stateListAnimator.addState(a.F, f0(f3, f4));
            stateListAnimator.addState(a.G, f0(f3, f4));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f3005v, "elevation", f3).setDuration(0L));
            if (i3 >= 22 && i3 <= 24) {
                FloatingActionButton floatingActionButton = this.f3005v;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f3005v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(a.C);
            stateListAnimator.addState(a.H, animatorSet);
            stateListAnimator.addState(a.I, f0(0.0f, 0.0f));
            this.f3005v.setStateListAnimator(stateListAnimator);
        }
        if (W()) {
            c0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean I() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void S(ColorStateList colorStateList) {
        Drawable drawable = this.f2986c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(i1.b.a(colorStateList));
        } else {
            super.S(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean W() {
        return this.f3006w.b() || !Y();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void a0() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float m() {
        return this.f3005v.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void r(Rect rect) {
        if (this.f3006w.b()) {
            super.r(rect);
        } else if (Y()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f2993j - this.f3005v.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void y() {
    }
}
