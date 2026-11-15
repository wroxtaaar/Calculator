package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.m;
import com.google.android.material.internal.n;
import e0.t;
import k1.g;
import k1.h;
import t0.j;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int V = j.Widget_MaterialComponents_Toolbar;
    private static final ImageView.ScaleType[] W = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Integer Q;
    private boolean R;
    private boolean S;
    private ImageView.ScaleType T;
    private Boolean U;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    private Pair<Integer, Integer> O(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i3 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i3 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i3 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void P(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.X(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.N(context);
            gVar.W(t.w(this));
            t.p0(this, gVar);
        }
    }

    private void Q(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i3 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i4 = measuredWidth2 + i3;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i3, 0), Math.max(i4 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i3 += iMax;
            i4 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i4 - i3, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i3, view.getTop(), i4, view.getBottom());
    }

    private void R() {
        if (this.R || this.S) {
            TextView textViewE = n.e(this);
            TextView textViewC = n.c(this);
            if (textViewE == null && textViewC == null) {
                return;
            }
            Pair<Integer, Integer> pairO = O(textViewE, textViewC);
            if (this.R && textViewE != null) {
                Q(textViewE, pairO);
            }
            if (!this.S || textViewC == null) {
                return;
            }
            Q(textViewC, pairO);
        }
    }

    private Drawable S(Drawable drawable) {
        if (drawable == null || this.Q == null) {
            return drawable;
        }
        Drawable drawableR = x.a.r(drawable.mutate());
        x.a.n(drawableR, this.Q.intValue());
        return drawableR;
    }

    private void T() {
        ImageView imageViewB = n.b(this);
        if (imageViewB != null) {
            Boolean bool = this.U;
            if (bool != null) {
                imageViewB.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.T;
            if (scaleType != null) {
                imageViewB.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.T;
    }

    public Integer getNavigationIconTint() {
        return this.Q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        R();
        T();
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        h.d(this, f3);
    }

    public void setLogoAdjustViewBounds(boolean z2) {
        Boolean bool = this.U;
        if (bool == null || bool.booleanValue() != z2) {
            this.U = Boolean.valueOf(z2);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.T != scaleType) {
            this.T = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(S(drawable));
    }

    public void setNavigationIconTint(int i3) {
        this.Q = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z2) {
        if (this.S != z2) {
            this.S = z2;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z2) {
        if (this.R != z2) {
            this.R = z2;
            requestLayout();
        }
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i3) {
        int i4 = V;
        super(m1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        Context context2 = getContext();
        TypedArray typedArrayH = m.h(context2, attributeSet, k.MaterialToolbar, i3, i4, new int[0]);
        int i5 = k.MaterialToolbar_navigationIconTint;
        if (typedArrayH.hasValue(i5)) {
            setNavigationIconTint(typedArrayH.getColor(i5, -1));
        }
        this.R = typedArrayH.getBoolean(k.MaterialToolbar_titleCentered, false);
        this.S = typedArrayH.getBoolean(k.MaterialToolbar_subtitleCentered, false);
        int i6 = typedArrayH.getInt(k.MaterialToolbar_logoScaleType, -1);
        if (i6 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = W;
            if (i6 < scaleTypeArr.length) {
                this.T = scaleTypeArr[i6];
            }
        }
        int i7 = k.MaterialToolbar_logoAdjustViewBounds;
        if (typedArrayH.hasValue(i7)) {
            this.U = Boolean.valueOf(typedArrayH.getBoolean(i7, false));
        }
        typedArrayH.recycle();
        P(context2);
    }
}
