package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import e0.t;
import k1.g;
import k1.i;
import t0.f;
import t0.h;
import t0.k;

/* JADX INFO: compiled from: RadialViewGroup.java */
/* JADX INFO: loaded from: classes.dex */
class b extends ConstraintLayout {
    private g A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Runnable f3419y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f3420z;

    /* JADX INFO: compiled from: RadialViewGroup.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.x();
        }
    }

    public b(Context context) {
        this(context, null);
    }

    private Drawable t() {
        g gVar = new g();
        this.A = gVar;
        gVar.V(new i(0.5f));
        this.A.X(ColorStateList.valueOf(-1));
        return this.A;
    }

    private static boolean w(View view) {
        return "skip".equals(view.getTag());
    }

    private void y() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f3419y);
            handler.post(this.f3419y);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view.getId() == -1) {
            view.setId(t.k());
        }
        y();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        x();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        y();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.A.X(ColorStateList.valueOf(i3));
    }

    public int u() {
        return this.f3420z;
    }

    public void v(int i3) {
        this.f3420z = i3;
        x();
    }

    protected void x() {
        int childCount = getChildCount();
        int i3 = 1;
        for (int i4 = 0; i4 < childCount; i4++) {
            if (w(getChildAt(i4))) {
                i3++;
            }
        }
        d dVar = new d();
        dVar.g(this);
        float f3 = 0.0f;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            int i6 = f.circle_center;
            if (id != i6 && !w(childAt)) {
                dVar.i(childAt.getId(), i6, this.f3420z, f3);
                f3 += 360.0f / (childCount - i3);
            }
        }
        dVar.c(this);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(h.material_radial_view_group, this);
        t.p0(this, t());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.RadialViewGroup, i3, 0);
        this.f3420z = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.RadialViewGroup_materialCircleRadius, 0);
        this.f3419y = new a();
        typedArrayObtainStyledAttributes.recycle();
    }
}
