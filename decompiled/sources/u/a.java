package u;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;

/* JADX INFO: compiled from: ContextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f6255a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static TypedValue f6256b;

    public static Context a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    public static int b(Context context, int i3) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i3) : context.getResources().getColor(i3);
    }

    public static ColorStateList c(Context context, int i3) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i3) : context.getResources().getColorStateList(i3);
    }

    public static Drawable d(Context context, int i3) {
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            return context.getDrawable(i3);
        }
        if (i5 >= 16) {
            return context.getResources().getDrawable(i3);
        }
        synchronized (f6255a) {
            if (f6256b == null) {
                f6256b = new TypedValue();
            }
            context.getResources().getValue(i3, f6256b, true);
            i4 = f6256b.resourceId;
        }
        return context.getResources().getDrawable(i4);
    }

    public static boolean e(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }
}
