package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
class a extends com.google.android.material.textfield.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f3281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f3282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.f f3283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextInputLayout.g f3284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AnimatorSet f3285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ValueAnimator f3286j;

    /* JADX INFO: renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class C0042a implements TextWatcher {
        C0042a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f3331a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.m());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            a aVar = a.this;
            aVar.i(aVar.m());
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.this.m());
            editText.setOnFocusChangeListener(a.this.f3282f);
            a aVar = a.this;
            aVar.f3333c.setOnFocusChangeListener(aVar.f3282f);
            editText.removeTextChangedListener(a.this.f3281e);
            editText.addTextChangedListener(a.this.f3281e);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class d implements TextInputLayout.g {

        /* JADX INFO: renamed from: com.google.android.material.textfield.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
        class RunnableC0043a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EditText f3291b;

            RunnableC0043a(EditText editText) {
                this.f3291b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3291b.removeTextChangedListener(a.this.f3281e);
                a.this.i(true);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i3) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i3 != 2) {
                return;
            }
            editText.post(new RunnableC0043a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f3282f) {
                editText.setOnFocusChangeListener(null);
            }
            if (a.this.f3333c.getOnFocusChangeListener() == a.this.f3282f) {
                a.this.f3333c.setOnFocusChangeListener(null);
            }
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.f3331a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f3331a.U();
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f3331a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f3331a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f3333c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f3333c.setScaleX(fFloatValue);
            a.this.f3333c.setScaleY(fFloatValue);
        }
    }

    a(TextInputLayout textInputLayout, int i3) {
        super(textInputLayout, i3);
        this.f3281e = new C0042a();
        this.f3282f = new b();
        this.f3283g = new c();
        this.f3284h = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z2) {
        boolean z3 = this.f3331a.K() == z2;
        if (z2 && !this.f3285i.isRunning()) {
            this.f3286j.cancel();
            this.f3285i.start();
            if (z3) {
                this.f3285i.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.f3285i.cancel();
        this.f3286j.start();
        if (z3) {
            this.f3286j.end();
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(u0.a.f6257a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new h());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator k() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(u0.a.f6260d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new i());
        return valueAnimatorOfFloat;
    }

    private void l() {
        ValueAnimator valueAnimatorK = k();
        ValueAnimator valueAnimatorJ = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f3285i = animatorSet;
        animatorSet.playTogether(valueAnimatorK, valueAnimatorJ);
        this.f3285i.addListener(new f());
        ValueAnimator valueAnimatorJ2 = j(1.0f, 0.0f);
        this.f3286j = valueAnimatorJ2;
        valueAnimatorJ2.addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        EditText editText = this.f3331a.getEditText();
        return editText != null && (editText.hasFocus() || this.f3333c.hasFocus()) && editText.getText().length() > 0;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        TextInputLayout textInputLayout = this.f3331a;
        int i3 = this.f3334d;
        if (i3 == 0) {
            i3 = t0.e.mtrl_ic_cancel;
        }
        textInputLayout.setEndIconDrawable(i3);
        TextInputLayout textInputLayout2 = this.f3331a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(t0.i.clear_text_end_icon_content_description));
        this.f3331a.setEndIconCheckable(false);
        this.f3331a.setEndIconOnClickListener(new e());
        this.f3331a.g(this.f3283g);
        this.f3331a.h(this.f3284h);
        l();
    }

    @Override // com.google.android.material.textfield.e
    void c(boolean z2) {
        if (this.f3331a.getSuffixText() == null) {
            return;
        }
        i(z2);
    }
}
