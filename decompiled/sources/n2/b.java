package n2;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SpringEffectHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f5316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f5317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f5318c;

    public static boolean a(Context context, OverScroller overScroller, boolean z2) {
        boolean z3;
        if (overScroller == null) {
            return false;
        }
        Method method = f5316a;
        if (method != null) {
            try {
                method.invoke(overScroller, context, Boolean.valueOf(z2));
            } catch (Exception e3) {
                r2.a.b("SpringEffectHelper", "setSpringEffect e: " + e3);
                z3 = false;
            }
        }
        z3 = true;
        Method method2 = f5318c;
        if (method2 != null && z2) {
            try {
                method2.invoke(overScroller, context, Double.valueOf(2.5d), Double.valueOf(0.8d), Double.valueOf(17.0d), Double.valueOf(100.0d), Double.valueOf(22.0d), Double.valueOf(100.0d));
            } catch (Exception e4) {
                r2.a.b("SpringEffectHelper", "setSpringEffect e: " + e4.getMessage());
                return false;
            }
        }
        return z3;
    }

    private static boolean b(Context context, RecyclerView recyclerView, boolean z2) {
        Field declaredField;
        if (recyclerView == null) {
            return false;
        }
        boolean zD = d();
        try {
            Field declaredField2 = recyclerView.getClass().getDeclaredField("mViewFlinger");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(recyclerView);
            Class<?> cls = obj.getClass();
            try {
                declaredField = cls.getDeclaredField("mScroller");
            } catch (NoSuchFieldException unused) {
                declaredField = cls.getDeclaredField("mOverScroller");
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return obj2 instanceof OverScroller ? a(context, (OverScroller) obj2, z2) : zD;
        } catch (Exception e3) {
            r2.a.b("SpringEffectHelper", "flinger exception : " + e3);
            return false;
        }
    }

    private static boolean c(View view) {
        try {
            if (view instanceof AbsListView) {
                Class<?> cls = Class.forName("android.widget.AbsListView");
                Class<?> cls2 = Boolean.TYPE;
                f5316a = cls.getMethod("setSpringEffect", cls2);
                f5317b = cls.getMethod("setEdgeEffect", cls2);
            } else if (view instanceof ScrollView) {
                Class<?> cls3 = Class.forName("android.widget.ScrollView");
                Class<?> cls4 = Boolean.TYPE;
                f5316a = cls3.getMethod("setSpringEffect", cls4);
                f5317b = cls3.getMethod("setEdgeEffect", cls4);
            } else if (view instanceof HorizontalScrollView) {
                Class<?> cls5 = Class.forName("android.widget.HorizontalScrollView");
                Class<?> cls6 = Boolean.TYPE;
                f5316a = cls5.getMethod("setMaterialSpringEffect", cls6);
                f5317b = cls5.getMethod("setEdgeEffect", cls6);
            }
            return true;
        } catch (Exception e3) {
            r2.a.b("SpringEffectHelper", "initMethod fail e: " + e3.getMessage());
            e3.printStackTrace();
            return false;
        }
    }

    private static boolean d() {
        try {
            Class<?> cls = Class.forName("android.widget.OverScroller");
            f5316a = cls.getMethod("setSpringEffect", Context.class, Boolean.TYPE);
            Class<?> cls2 = Double.TYPE;
            f5318c = cls.getMethod("setSpringEffectParam", Context.class, cls2, cls2, cls2, cls2, cls2, cls2);
            return true;
        } catch (Exception e3) {
            r2.a.b("SpringEffectHelper", "initMethod fail e: " + e3);
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean e(Context context, View view, boolean z2) {
        boolean z3 = true;
        if (!(view instanceof AbsListView) && !(view instanceof ScrollView) && !(view instanceof HorizontalScrollView)) {
            if (view instanceof RecyclerView) {
                return b(context, (RecyclerView) view, z2);
            }
            return true;
        }
        boolean zC = c(view);
        Method method = f5316a;
        if (method != null) {
            try {
                method.invoke(view, Boolean.valueOf(z2));
            } catch (Exception e3) {
                r2.a.b("SpringEffectHelper", "setSpringEffect e: " + e3.getMessage());
                zC = false;
            }
        }
        Method method2 = f5317b;
        if (method2 != null) {
            try {
                Object[] objArr = new Object[1];
                if (z2) {
                    z3 = false;
                }
                objArr[0] = Boolean.valueOf(z3);
                method2.invoke(view, objArr);
            } catch (Exception e4) {
                r2.a.b("SpringEffectHelper", "setSpringEffect e: " + e4.getMessage());
                return false;
            }
        }
        return zC;
    }
}
