package g1;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.s;
import com.google.android.material.internal.m;
import t0.b;
import t0.j;
import t0.k;
import z0.c;

/* JADX INFO: compiled from: MaterialRadioButton.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f4756g = j.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[][] f4757h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f4758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4759f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4758e == null) {
            int iD = c.d(this, b.colorControlActivated);
            int iD2 = c.d(this, b.colorOnSurface);
            int iD3 = c.d(this, b.colorSurface);
            int[][] iArr = f4757h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = c.h(iD3, iD, 1.0f);
            iArr2[1] = c.h(iD3, iD2, 0.54f);
            iArr2[2] = c.h(iD3, iD2, 0.38f);
            iArr2[3] = c.h(iD3, iD2, 0.38f);
            this.f4758e = new ColorStateList(iArr, iArr2);
        }
        return this.f4758e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4759f && androidx.core.widget.c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f4759f = z2;
        if (z2) {
            androidx.core.widget.c.c(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.c(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f4756g;
        super(m1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        TypedArray typedArrayH = m.h(context2, attributeSet, k.MaterialRadioButton, i3, i4, new int[0]);
        int i5 = k.MaterialRadioButton_buttonTint;
        if (typedArrayH.hasValue(i5)) {
            androidx.core.widget.c.c(this, h1.c.a(context2, typedArrayH, i5));
        }
        this.f4759f = typedArrayH.getBoolean(k.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayH.recycle();
    }
}
