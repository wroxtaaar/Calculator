package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

/* JADX INFO: compiled from: VisibilityAwareImageButton.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class p extends ImageButton {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3157b;

    public final void b(int i3, boolean z2) {
        super.setVisibility(i3);
        if (z2) {
            this.f3157b = i3;
        }
    }

    public final int getUserSetVisibility() {
        return this.f3157b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        b(i3, true);
    }
}
