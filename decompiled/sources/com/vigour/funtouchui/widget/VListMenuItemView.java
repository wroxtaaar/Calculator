package com.vigour.funtouchui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class VListMenuItemView extends ListMenuItemView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3493s;

    public VListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3493s = 280;
        this.f3493s = i(280);
    }

    private int i(int i3) {
        return (int) ((i3 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // androidx.appcompat.view.menu.ListMenuItemView, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int measuredWidth = getMeasuredWidth();
        int i5 = this.f3493s;
        if (measuredWidth > i5) {
            measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public VListMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3493s = 280;
        this.f3493s = i(280);
    }
}
