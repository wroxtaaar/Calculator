package n2;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: FlingEffectHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f5315a;

    private static boolean a(Context context, OverScroller overScroller, boolean z2) {
        Method method;
        if (overScroller == null || (method = f5315a) == null) {
            return false;
        }
        try {
            method.invoke(overScroller, context, Boolean.valueOf(z2));
            return true;
        } catch (Exception e3) {
            Log.e("FlingEffectHelper", "setSpringEffect e: " + e3);
            return false;
        }
    }

    private static boolean b(Context context, RecyclerView recyclerView, boolean z2) {
        Field declaredField;
        boolean zA = false;
        if (recyclerView == null) {
            return false;
        }
        boolean zC = c();
        Log.d("FlingEffectHelper", "initOverScrollerMethod: success=" + zC);
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
            zA = obj2 instanceof OverScroller ? a(context, (OverScroller) obj2, z2) : zC;
        } catch (Exception e3) {
            Log.e("FlingEffectHelper", "flinger exception : " + e3);
        }
        Log.d("FlingEffectHelper", "hookOverScroller: success=" + zA);
        return zA;
    }

    private static boolean c() {
        try {
            f5315a = Class.forName("android.widget.OverScroller").getMethod("setFlingEffect", Context.class, Boolean.TYPE);
            return true;
        } catch (Exception e3) {
            Log.e("FlingEffectHelper", "initMethod fail e: " + e3);
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean d(Context context, View view, boolean z2) {
        if (view instanceof RecyclerView) {
            return b(context, (RecyclerView) view, z2);
        }
        return true;
    }
}
