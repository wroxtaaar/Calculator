package com.vivo.springkit.nestedScroll;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import androidx.core.widget.g;

/* JADX INFO: compiled from: ScrollUtils.java */
/* JADX INFO: loaded from: classes.dex */
class a {
    public static boolean a(View view) {
        return view instanceof ListView ? g.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public static boolean b(View view) {
        return view instanceof ListView ? g.a((ListView) view, 1) : view.canScrollHorizontally(1);
    }

    public static boolean c(View view) {
        return view instanceof ListView ? g.a((ListView) view, -1) : view.canScrollHorizontally(-1);
    }

    public static boolean d(View view) {
        return view instanceof ListView ? g.a((ListView) view, 1) : view.canScrollVertically(1);
    }

    public static int e(Context context, int i3) {
        return (int) ((i3 * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        if (displayMetrics.heightPixels == 0) {
            displayMetrics.heightPixels = e(context, 2400);
        }
        return displayMetrics.heightPixels;
    }

    public static int g(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        if (displayMetrics.widthPixels == 0) {
            displayMetrics.widthPixels = e(context, 1080);
        }
        return displayMetrics.widthPixels;
    }
}
