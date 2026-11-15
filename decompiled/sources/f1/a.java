package f1;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import h1.b;
import w.c;

/* JADX INFO: compiled from: MotionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static float a(String[] strArr, int i3) {
        float f3 = Float.parseFloat(strArr[i3]);
        if (f3 >= 0.0f && f3 <= 1.0f) {
            return f3;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f3);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static boolean c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        return str.startsWith(sb.toString()) && str.endsWith(")");
    }

    public static int d(Context context, int i3, int i4) {
        return b.c(context, i3, i4);
    }

    public static TimeInterpolator e(Context context, int i3, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i3, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!c(strValueOf, "cubic-bezier")) {
            if (c(strValueOf, "path")) {
                return g0.b.b(c.e(b(strValueOf, "path")));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + strValueOf);
        }
        String[] strArrSplit = b(strValueOf, "cubic-bezier").split(",");
        if (strArrSplit.length == 4) {
            return g0.b.a(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }
}
