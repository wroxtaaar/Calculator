package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import e0.b0;
import e0.d0;

/* JADX INFO: compiled from: EdgeToEdgeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Window window, boolean z2, Integer num, Integer num2) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        boolean z3 = num == null || num.intValue() == 0;
        boolean z4 = num2 == null || num2.intValue() == 0;
        if (z3 || z4) {
            int iB = z0.c.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z3) {
                num = Integer.valueOf(iB);
            }
            if (z4) {
                num2 = Integer.valueOf(iB);
            }
        }
        b0.b(window, !z2);
        int iC = c(window.getContext(), z2);
        int iB2 = b(window.getContext(), z2);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        boolean zD = d(iC, z0.c.f(num.intValue()));
        boolean zD2 = d(iB2, z0.c.f(num2.intValue()));
        d0 d0VarA = b0.a(window, window.getDecorView());
        if (d0VarA != null) {
            d0VarA.b(zD);
            d0VarA.a(zD2);
        }
    }

    @TargetApi(21)
    private static int b(Context context, boolean z2) {
        if (z2 && Build.VERSION.SDK_INT < 27) {
            return w.a.h(z0.c.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z2) {
            return 0;
        }
        return z0.c.b(context, R.attr.navigationBarColor, -16777216);
    }

    @TargetApi(21)
    private static int c(Context context, boolean z2) {
        if (z2 && Build.VERSION.SDK_INT < 23) {
            return w.a.h(z0.c.b(context, R.attr.statusBarColor, -16777216), 128);
        }
        if (z2) {
            return 0;
        }
        return z0.c.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i3, boolean z2) {
        return z0.c.f(i3) || (i3 == 0 && z2);
    }
}
