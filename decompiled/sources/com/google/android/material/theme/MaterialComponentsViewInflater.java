package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.z;
import b.g;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.h;
import com.google.android.material.textview.MaterialTextView;
import w0.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends g {
    @Override // b.g
    protected d b(Context context, AttributeSet attributeSet) {
        return new h(context, attributeSet);
    }

    @Override // b.g
    protected f c(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // b.g
    protected androidx.appcompat.widget.g d(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // b.g
    protected s j(Context context, AttributeSet attributeSet) {
        return new g1.a(context, attributeSet);
    }

    @Override // b.g
    protected z n(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
