package com.vivo.calculator;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class RefreshLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f3839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinearLayout f3842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ProgressBar f3843f;

    public RefreshLinearLayout(Context context) {
        this(context, null);
    }

    public void a() {
        this.f3840c = LayoutInflater.from(this.f3839b).inflate(R.layout.refresh_header, (ViewGroup) null);
        this.f3841d = (int) TypedValue.applyDimension(1, this.f3841d, this.f3839b.getResources().getDisplayMetrics());
        this.f3840c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f3841d));
        addView(this.f3840c);
        this.f3842e = (LinearLayout) findViewById(R.id.update);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.refresh_view_new);
        this.f3843f = progressBar;
        progressBar.setVisibility(0);
    }

    public void b() {
        if (getOrientation() == 0) {
            setOrientation(1);
        }
    }

    public void c() {
        setHeadViewPaddingTop(-1);
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

    public void setHeadViewPaddingTop(int i3) {
        if (i3 != 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.f3842e.getVisibility() == 0) {
            return;
        }
        this.f3842e.setVisibility(0);
    }

    public RefreshLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public RefreshLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3841d = 24;
        this.f3839b = context;
        b();
        a();
        c();
    }
}
