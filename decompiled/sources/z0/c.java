package z0;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: MaterialColors.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a(int i3, int i4) {
        return w.a.h(i3, (Color.alpha(i3) * i4) / 255);
    }

    public static int b(Context context, int i3, int i4) {
        TypedValue typedValueA = h1.b.a(context, i3);
        return typedValueA != null ? typedValueA.data : i4;
    }

    public static int c(Context context, int i3, String str) {
        return h1.b.d(context, i3, str);
    }

    public static int d(View view, int i3) {
        return h1.b.e(view, i3);
    }

    public static int e(View view, int i3, int i4) {
        return b(view.getContext(), i3, i4);
    }

    public static boolean f(int i3) {
        return i3 != 0 && w.a.b(i3) > 0.5d;
    }

    public static int g(int i3, int i4) {
        return w.a.e(i4, i3);
    }

    public static int h(int i3, int i4, float f3) {
        return g(i3, w.a.h(i4, Math.round(Color.alpha(i4) * f3)));
    }

    public static int i(View view, int i3, int i4, float f3) {
        return h(d(view, i3), d(view, i4), f3);
    }
}
