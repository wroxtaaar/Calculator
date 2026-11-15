package c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.m0;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AppCompatResources.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2441a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0030a>> f2442b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f2443c = new Object();

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppCompatResources.java */
    private static class C0030a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ColorStateList f2444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f2445b;

        C0030a(ColorStateList colorStateList, Configuration configuration) {
            this.f2444a = colorStateList;
            this.f2445b = configuration;
        }
    }

    private static void a(Context context, int i3, ColorStateList colorStateList) {
        synchronized (f2443c) {
            WeakHashMap<Context, SparseArray<C0030a>> weakHashMap = f2442b;
            SparseArray<C0030a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i3, new C0030a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i3) {
        C0030a c0030a;
        synchronized (f2443c) {
            SparseArray<C0030a> sparseArray = f2442b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0030a = sparseArray.get(i3)) != null) {
                if (c0030a.f2445b.equals(context.getResources().getConfiguration())) {
                    return c0030a.f2444a;
                }
                sparseArray.remove(i3);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i3);
        }
        ColorStateList colorStateListB = b(context, i3);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListF = f(context, i3);
        if (colorStateListF == null) {
            return u.a.c(context, i3);
        }
        a(context, i3, colorStateListF);
        return colorStateListF;
    }

    public static Drawable d(Context context, int i3) {
        return m0.h().j(context, i3);
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = f2441a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList f(Context context, int i3) {
        if (g(context, i3)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return v.a.a(resources, resources.getXml(i3), context.getTheme());
        } catch (Exception e3) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e3);
            return null;
        }
    }

    private static boolean g(Context context, int i3) {
        Resources resources = context.getResources();
        TypedValue typedValueE = e();
        resources.getValue(i3, typedValueE, true);
        int i4 = typedValueE.type;
        return i4 >= 28 && i4 <= 31;
    }
}
