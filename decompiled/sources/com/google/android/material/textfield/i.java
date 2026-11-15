package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: NoEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
class i extends e {
    i(TextInputLayout textInputLayout) {
        super(textInputLayout, 0);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.f3331a.setEndIconOnClickListener(null);
        this.f3331a.setEndIconDrawable((Drawable) null);
        this.f3331a.setEndIconContentDescription((CharSequence) null);
    }
}
