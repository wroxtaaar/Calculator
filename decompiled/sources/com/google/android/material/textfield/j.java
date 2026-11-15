package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.l;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
class j extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f3367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.f f3368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.g f3369g;

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class a extends l {
        a() {
        }

        @Override // com.google.android.material.internal.l, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            j jVar = j.this;
            jVar.f3333c.setChecked(!jVar.g());
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            j jVar = j.this;
            jVar.f3333c.setChecked(!jVar.g());
            editText.removeTextChangedListener(j.this.f3367e);
            editText.addTextChangedListener(j.this.f3367e);
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class c implements TextInputLayout.g {

        /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EditText f3373b;

            a(EditText editText) {
                this.f3373b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3373b.removeTextChangedListener(j.this.f3367e);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i3) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i3 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = j.this.f3331a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (j.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            j.this.f3331a.U();
        }
    }

    j(TextInputLayout textInputLayout, int i3) {
        super(textInputLayout, i3);
        this.f3367e = new a();
        this.f3368f = new b();
        this.f3369g = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.f3331a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        TextInputLayout textInputLayout = this.f3331a;
        int i3 = this.f3334d;
        if (i3 == 0) {
            i3 = t0.e.design_password_eye;
        }
        textInputLayout.setEndIconDrawable(i3);
        TextInputLayout textInputLayout2 = this.f3331a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(t0.i.password_toggle_content_description));
        this.f3331a.setEndIconVisible(true);
        this.f3331a.setEndIconCheckable(true);
        this.f3331a.setEndIconOnClickListener(new d());
        this.f3331a.g(this.f3368f);
        this.f3331a.h(this.f3369g);
        EditText editText = this.f3331a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
