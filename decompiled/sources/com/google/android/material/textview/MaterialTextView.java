package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.z;
import h1.b;
import h1.c;
import m1.a;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends z {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    private void f(Resources.Theme theme, int i3) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i3, k.MaterialTextAppearance);
        int i4 = i(getContext(), typedArrayObtainStyledAttributes, k.MaterialTextAppearance_android_lineHeight, k.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (i4 >= 0) {
            setLineHeight(i4);
        }
    }

    private static boolean g(Context context) {
        return b.b(context, t0.b.textAppearanceLineHeightEnabled, true);
    }

    private static int h(Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.MaterialTextView, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int i(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i3 = 0; i3 < iArr.length && iC < 0; i3++) {
            iC = c.c(context, typedArray, iArr[i3], -1);
        }
        return iC;
    }

    private static boolean j(Context context, Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.MaterialTextView, i3, i4);
        int i5 = i(context, typedArrayObtainStyledAttributes, k.MaterialTextView_android_lineHeight, k.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return i5 != -1;
    }

    @Override // androidx.appcompat.widget.z, android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        if (g(context)) {
            f(context.getTheme(), i3);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i3, int i4) {
        int iH;
        super(a.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        if (g(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (j(context2, theme, attributeSet, i3, i4) || (iH = h(theme, attributeSet, i3, i4)) == -1) {
                return;
            }
            f(theme, iH);
        }
    }
}
