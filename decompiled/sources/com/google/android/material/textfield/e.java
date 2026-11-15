package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextInputLayout f3331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f3332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CheckableImageButton f3333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f3334d;

    e(TextInputLayout textInputLayout, int i3) {
        this.f3331a = textInputLayout;
        this.f3332b = textInputLayout.getContext();
        this.f3333c = textInputLayout.getEndIconView();
        this.f3334d = i3;
    }

    abstract void a();

    boolean b(int i3) {
        return true;
    }

    void c(boolean z2) {
    }

    boolean d() {
        return false;
    }
}
