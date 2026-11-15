package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import e0.t;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: PopupWindowCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f1215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1216d;

    public static void a(PopupWindow popupWindow, boolean z2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            popupWindow.setOverlapAnchor(z2);
            return;
        }
        if (i3 >= 21) {
            if (!f1216d) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1215c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e3);
                }
                f1216d = true;
            }
            Field field = f1215c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z2));
                } catch (IllegalAccessException e4) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e4);
                }
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i3);
            return;
        }
        if (!f1214b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f1213a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f1214b = true;
        }
        Method method = f1213a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i3));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i3, i4, i5);
            return;
        }
        if ((e0.d.b(i5, t.B(view)) & 7) == 5) {
            i3 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i3, i4);
    }
}
