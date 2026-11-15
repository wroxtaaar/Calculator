package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.w0;

/* JADX INFO: compiled from: ThemeEnforcement.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f3147a = {t0.b.colorPrimary};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f3148b = {t0.b.colorPrimaryVariant};

    public static void a(Context context) {
        e(context, f3147a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.k.ThemeEnforcement, i3, i4);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(t0.k.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z2) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(t0.b.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f3148b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.k.ThemeEnforcement, i3, i4);
        if (!typedArrayObtainStyledAttributes.getBoolean(t0.k.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(t0.k.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i3, i4, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (g(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
        for (int i5 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i5, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    private static boolean g(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i3)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray h(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        b(context, attributeSet, i3, i4);
        d(context, attributeSet, iArr, i3, i4, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
    }

    public static w0 i(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        b(context, attributeSet, i3, i4);
        d(context, attributeSet, iArr, i3, i4, iArr2);
        return w0.v(context, attributeSet, iArr, i3, i4);
    }
}
