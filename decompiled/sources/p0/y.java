package p0;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
/* JADX INFO: loaded from: classes.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LayoutTransition f5734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f5735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f5736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f5737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f5738e;

    /* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
    static class a extends LayoutTransition {
        a() {
        }

        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f5738e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f5737d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f5738e = true;
        }
        Method method = f5737d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    static void b(ViewGroup viewGroup, boolean z2) {
        boolean z3 = false;
        if (f5734a == null) {
            a aVar = new a();
            f5734a = aVar;
            aVar.setAnimator(2, null);
            f5734a.setAnimator(0, null);
            f5734a.setAnimator(1, null);
            f5734a.setAnimator(3, null);
            f5734a.setAnimator(4, null);
        }
        if (z2) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != f5734a) {
                    viewGroup.setTag(j.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f5734a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f5736c) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f5735b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f5736c = true;
        }
        Field field = f5735b;
        if (field != null) {
            try {
                boolean z4 = field.getBoolean(viewGroup);
                if (z4) {
                    try {
                        f5735b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z3 = z4;
                        Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                    }
                }
                z3 = z4;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z3) {
            viewGroup.requestLayout();
        }
        int i3 = j.transition_layout_save;
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(i3);
        if (layoutTransition2 != null) {
            viewGroup.setTag(i3, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
