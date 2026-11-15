package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import e0.t;

/* JADX INFO: compiled from: FlowLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3109e;

    public e(Context context) {
        this(context, null);
    }

    private static int a(int i3, int i4, int i5) {
        if (i4 != Integer.MIN_VALUE) {
            return i4 != 1073741824 ? i5 : i3;
        }
        return Math.min(i5, i3);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, t0.k.FlowLayout, 0, 0);
        this.f3106b = typedArrayObtainStyledAttributes.getDimensionPixelSize(t0.k.FlowLayout_lineSpacing, 0);
        this.f3107c = typedArrayObtainStyledAttributes.getDimensionPixelSize(t0.k.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int b(View view) {
        Object tag = view.getTag(t0.f.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f3108d;
    }

    protected int getItemSpacing() {
        return this.f3107c;
    }

    protected int getLineSpacing() {
        return this.f3106b;
    }

    protected int getRowCount() {
        return this.f3109e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int iA;
        int iB;
        if (getChildCount() == 0) {
            this.f3109e = 0;
            return;
        }
        this.f3109e = 1;
        boolean z3 = t.B(this) == 1;
        int paddingRight = z3 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z3 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i7 = (i5 - i3) - paddingLeft;
        int measuredWidth = paddingRight;
        int i8 = paddingTop;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(t0.f.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iB = e0.g.b(marginLayoutParams);
                    iA = e0.g.a(marginLayoutParams);
                } else {
                    iA = 0;
                    iB = 0;
                }
                int measuredWidth2 = measuredWidth + iB + childAt.getMeasuredWidth();
                if (!this.f3108d && measuredWidth2 > i7) {
                    i8 = this.f3106b + paddingTop;
                    this.f3109e++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(t0.f.row_index_key, Integer.valueOf(this.f3109e - 1));
                int i10 = measuredWidth + iB;
                int measuredWidth3 = childAt.getMeasuredWidth() + i10;
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (z3) {
                    childAt.layout(i7 - measuredWidth3, i8, (i7 - measuredWidth) - iB, measuredHeight);
                } else {
                    childAt.layout(i10, i8, measuredWidth3, measuredHeight);
                }
                measuredWidth += iB + iA + childAt.getMeasuredWidth() + this.f3107c;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i4);
        int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i7 - getPaddingRight();
        int i8 = paddingTop;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i4);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin + 0;
                    i6 = marginLayoutParams.rightMargin + 0;
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                int i11 = paddingLeft2;
                if (paddingLeft2 + i5 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i11;
                } else {
                    paddingLeft = getPaddingLeft();
                    i8 = this.f3106b + paddingTop;
                }
                int measuredWidth = paddingLeft + i5 + childAt.getMeasuredWidth();
                int measuredHeight = i8 + childAt.getMeasuredHeight();
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i5 + i6 + childAt.getMeasuredWidth() + this.f3107c;
                if (i10 == getChildCount() - 1) {
                    i9 += i6;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i9 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i3) {
        this.f3107c = i3;
    }

    protected void setLineSpacing(int i3) {
        this.f3106b = i3;
    }

    public void setSingleLine(boolean z2) {
        this.f3108d = z2;
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3108d = false;
        d(context, attributeSet);
    }

    @TargetApi(21)
    public e(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f3108d = false;
        d(context, attributeSet);
    }
}
