package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f2845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f2846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final b f2847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final b f2848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final b f2849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final b f2850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final b f2851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Paint f2852h;

    c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(h1.b.d(context, t0.b.materialCalendarStyle, h.class.getCanonicalName()), t0.k.MaterialCalendar);
        this.f2845a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendar_dayStyle, 0));
        this.f2851g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendar_dayInvalidStyle, 0));
        this.f2846b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendar_daySelectedStyle, 0));
        this.f2847c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = h1.c.a(context, typedArrayObtainStyledAttributes, t0.k.MaterialCalendar_rangeFillColor);
        this.f2848d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendar_yearStyle, 0));
        this.f2849e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendar_yearSelectedStyle, 0));
        this.f2850f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f2852h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
