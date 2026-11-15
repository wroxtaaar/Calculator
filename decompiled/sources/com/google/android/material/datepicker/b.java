package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;

/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f2839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f2840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f2841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f2842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k1.k f2844f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i3, k1.k kVar, Rect rect) {
        d0.i.b(rect.left);
        d0.i.b(rect.top);
        d0.i.b(rect.right);
        d0.i.b(rect.bottom);
        this.f2839a = rect;
        this.f2840b = colorStateList2;
        this.f2841c = colorStateList;
        this.f2842d = colorStateList3;
        this.f2843e = i3;
        this.f2844f = kVar;
    }

    static b a(Context context, int i3) {
        d0.i.a(i3 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, t0.k.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(t0.k.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(t0.k.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(t0.k.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(t0.k.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = h1.c.a(context, typedArrayObtainStyledAttributes, t0.k.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = h1.c.a(context, typedArrayObtainStyledAttributes, t0.k.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = h1.c.a(context, typedArrayObtainStyledAttributes, t0.k.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(t0.k.MaterialCalendarItem_itemStrokeWidth, 0);
        k1.k kVarM = k1.k.b(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, kVarM, rect);
    }

    int b() {
        return this.f2839a.bottom;
    }

    int c() {
        return this.f2839a.top;
    }

    void d(TextView textView) {
        k1.g gVar = new k1.g();
        k1.g gVar2 = new k1.g();
        gVar.setShapeAppearanceModel(this.f2844f);
        gVar2.setShapeAppearanceModel(this.f2844f);
        gVar.X(this.f2841c);
        gVar.d0(this.f2843e, this.f2842d);
        textView.setTextColor(this.f2840b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f2840b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.f2839a;
        e0.t.p0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
