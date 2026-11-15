package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f760a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f761b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f762c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f763d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f764e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f765f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f766g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f767h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[] f768i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f769j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(a.j.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i3) {
        ColorStateList colorStateListE = e(context, i3);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f761b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i3, typedValueF.getFloat());
    }

    public static int c(Context context, int i3) {
        int[] iArr = f769j;
        iArr[0] = i3;
        w0 w0VarU = w0.u(context, null, iArr);
        try {
            return w0VarU.b(0, 0);
        } finally {
            w0VarU.w();
        }
    }

    static int d(Context context, int i3, float f3) {
        int iC = c(context, i3);
        return w.a.h(iC, Math.round(Color.alpha(iC) * f3));
    }

    public static ColorStateList e(Context context, int i3) {
        int[] iArr = f769j;
        iArr[0] = i3;
        w0 w0VarU = w0.u(context, null, iArr);
        try {
            return w0VarU.c(0);
        } finally {
            w0VarU.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f760a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
