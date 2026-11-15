package com.vivo.calculator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class RefreshHeaderLayout extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ProgressBar f3838b;

    public RefreshHeaderLayout(Context context) {
        this(context, null);
    }

    public void a(float f3) {
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
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

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.refresh_pb_new);
        this.f3838b = progressBar;
        progressBar.setVisibility(0);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }
}
