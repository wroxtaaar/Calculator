package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import e0.t;
import t0.d;
import t0.f;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f3206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Button f3207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3208d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    private static void c(View view, int i3, int i4) {
        if (t.U(view)) {
            t.y0(view, t.G(view), i3, t.F(view), i4);
        } else {
            view.setPadding(view.getPaddingLeft(), i3, view.getPaddingRight(), i4);
        }
    }

    private boolean d(int i3, int i4, int i5) {
        boolean z2;
        if (i3 != getOrientation()) {
            setOrientation(i3);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f3206b.getPaddingTop() == i4 && this.f3206b.getPaddingBottom() == i5) {
            return z2;
        }
        c(this.f3206b, i4, i5);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i3, int i4) {
        this.f3206b.setAlpha(1.0f);
        long j3 = i4;
        long j4 = i3;
        this.f3206b.animate().alpha(0.0f).setDuration(j3).setStartDelay(j4).start();
        if (this.f3207c.getVisibility() == 0) {
            this.f3207c.setAlpha(1.0f);
            this.f3207c.animate().alpha(0.0f).setDuration(j3).setStartDelay(j4).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i3, int i4) {
        this.f3206b.setAlpha(0.0f);
        long j3 = i4;
        long j4 = i3;
        this.f3206b.animate().alpha(1.0f).setDuration(j3).setStartDelay(j4).start();
        if (this.f3207c.getVisibility() == 0) {
            this.f3207c.setAlpha(0.0f);
            this.f3207c.animate().alpha(1.0f).setDuration(j3).setStartDelay(j4).start();
        }
    }

    public Button getActionView() {
        return this.f3207c;
    }

    public TextView getMessageView() {
        return this.f3206b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f3206b = (TextView) findViewById(f.snackbar_text);
        this.f3207c = (Button) findViewById(f.snackbar_action);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        boolean z2 = true;
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        boolean z3 = this.f3206b.getLayout().getLineCount() > 1;
        if (!z3 || this.f3208d <= 0 || this.f3207c.getMeasuredWidth() <= this.f3208d) {
            if (!z3) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!d(0, dimensionPixelSize, dimensionPixelSize)) {
                z2 = false;
            }
        } else if (!d(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            z2 = false;
        }
        if (z2) {
            super.onMeasure(i3, i4);
        }
    }

    public void setMaxInlineActionWidth(int i3) {
        this.f3208d = i3;
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
