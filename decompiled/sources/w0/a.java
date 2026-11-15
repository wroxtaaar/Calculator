package w0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.g;
import com.google.android.material.internal.m;
import com.google.android.material.internal.o;
import t0.b;
import t0.j;
import t0.k;
import z0.c;

/* JADX INFO: compiled from: MaterialCheckBox.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f6351h = j.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[][] f6352i = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f6353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6355g;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.checkboxStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f6353e == null) {
            int[][] iArr = f6352i;
            int[] iArr2 = new int[iArr.length];
            int iD = c.d(this, b.colorControlActivated);
            int iD2 = c.d(this, b.colorSurface);
            int iD3 = c.d(this, b.colorOnSurface);
            iArr2[0] = c.h(iD2, iD, 1.0f);
            iArr2[1] = c.h(iD2, iD3, 0.54f);
            iArr2[2] = c.h(iD2, iD3, 0.38f);
            iArr2[3] = c.h(iD2, iD3, 0.38f);
            this.f6353e = new ColorStateList(iArr, iArr2);
        }
        return this.f6353e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6354f && androidx.core.widget.c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f6355g || !TextUtils.isEmpty(getText()) || (drawableA = androidx.core.widget.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (o.e(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            x.a.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void setCenterIfNoTextEnabled(boolean z2) {
        this.f6355g = z2;
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f6354f = z2;
        if (z2) {
            androidx.core.widget.c.c(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.c(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f6351h;
        super(m1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        TypedArray typedArrayH = m.h(context2, attributeSet, k.MaterialCheckBox, i3, i4, new int[0]);
        int i5 = k.MaterialCheckBox_buttonTint;
        if (typedArrayH.hasValue(i5)) {
            androidx.core.widget.c.c(this, h1.c.a(context2, typedArrayH, i5));
        }
        this.f6354f = typedArrayH.getBoolean(k.MaterialCheckBox_useMaterialThemeColors, false);
        this.f6355g = typedArrayH.getBoolean(k.MaterialCheckBox_centerIfNoTextEnabled, true);
        typedArrayH.recycle();
    }
}
