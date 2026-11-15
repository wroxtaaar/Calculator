package b;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: compiled from: ResourcesFlusher.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f2317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f2319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f2321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f2322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Field f2323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f2324h;

    static void a(Resources resources) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            return;
        }
        if (i3 >= 24) {
            d(resources);
        } else if (i3 >= 23) {
            c(resources);
        } else if (i3 >= 21) {
            b(resources);
        }
    }

    private static void b(Resources resources) {
        if (!f2318b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f2317a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e3);
            }
            f2318b = true;
        }
        Field field = f2317a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e4);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f2318b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f2317a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e3);
            }
            f2318b = true;
        }
        Object obj = null;
        Field field = f2317a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e4);
            }
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f2324h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f2323g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e3);
            }
            f2324h = true;
        }
        Field field = f2323g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e4);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f2318b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f2317a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e5);
            }
            f2318b = true;
        }
        Field field2 = f2317a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e6);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) {
        if (!f2320d) {
            try {
                f2319c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e3) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e3);
            }
            f2320d = true;
        }
        Class<?> cls = f2319c;
        if (cls == null) {
            return;
        }
        if (!f2322f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f2321e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e4);
            }
            f2322f = true;
        }
        Field field = f2321e;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e5) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e5);
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
