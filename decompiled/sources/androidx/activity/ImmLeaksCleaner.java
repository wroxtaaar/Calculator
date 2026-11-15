package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f23b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f24c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f25d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f26e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f27a;

    ImmLeaksCleaner(Activity activity) {
        this.f27a = activity;
    }

    private static void h() {
        try {
            f23b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f25d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f26e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f24c = declaredField3;
            declaredField3.setAccessible(true);
            f23b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        if (aVar != d.a.ON_DESTROY) {
            return;
        }
        if (f23b == 0) {
            h();
        }
        if (f23b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f27a.getSystemService("input_method");
            try {
                Object obj = f24c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f25d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f26e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
