package z0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DynamicColors.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f6600a = {t0.b.dynamicColorThemeOverlay};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f6601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"PrivateApi"})
    private static final c f6602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, c> f6603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, c> f6604e;

    /* JADX INFO: renamed from: z0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DynamicColors.java */
    class C0100a implements c {
        C0100a() {
        }

        @Override // z0.a.c
        public boolean a() {
            return true;
        }
    }

    /* JADX INFO: compiled from: DynamicColors.java */
    class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f6605a;

        b() {
        }

        @Override // z0.a.c
        public boolean a() {
            if (this.f6605a == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                    declaredMethod.setAccessible(true);
                    this.f6605a = Long.valueOf(((Long) declaredMethod.invoke(null, "ro.build.version.oneui")).longValue());
                } catch (Exception unused) {
                    this.f6605a = -1L;
                }
            }
            return this.f6605a.longValue() >= 40100;
        }
    }

    /* JADX INFO: compiled from: DynamicColors.java */
    private interface c {
        boolean a();
    }

    /* JADX INFO: compiled from: DynamicColors.java */
    private static class d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final z0.b f6606a;

        d(z0.b bVar) {
            this.f6606a = bVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            a.f(activity, this.f6606a.e(), this.f6606a.d(), this.f6606a.c());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: compiled from: DynamicColors.java */
    public interface e {
        void a(Activity activity);
    }

    /* JADX INFO: compiled from: DynamicColors.java */
    public interface f {
        boolean a(Activity activity, int i3);
    }

    static {
        C0100a c0100a = new C0100a();
        f6601b = c0100a;
        b bVar = new b();
        f6602c = bVar;
        HashMap map = new HashMap();
        map.put("google", c0100a);
        map.put("hmd global", c0100a);
        map.put("infinix", c0100a);
        map.put("infinix mobility limited", c0100a);
        map.put("itel", c0100a);
        map.put("kyocera", c0100a);
        map.put("lenovo", c0100a);
        map.put("lge", c0100a);
        map.put("motorola", c0100a);
        map.put("nothing", c0100a);
        map.put("oneplus", c0100a);
        map.put("oppo", c0100a);
        map.put("realme", c0100a);
        map.put("robolectric", c0100a);
        map.put("samsung", bVar);
        map.put("sharp", c0100a);
        map.put("sony", c0100a);
        map.put("tcl", c0100a);
        map.put("tecno", c0100a);
        map.put("tecno mobile limited", c0100a);
        map.put("vivo", c0100a);
        map.put("xiaomi", c0100a);
        f6603d = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", c0100a);
        map2.put("jio", c0100a);
        f6604e = Collections.unmodifiableMap(map2);
    }

    @Deprecated
    public static void b(Activity activity) {
        e(activity);
    }

    public static void c(Application application) {
        d(application, new z0.b.c().d());
    }

    public static void d(Application application, z0.b bVar) {
        application.registerActivityLifecycleCallbacks(new d(bVar));
    }

    public static void e(Activity activity) {
        g(activity, new z0.b.c().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Activity activity, int i3, f fVar, e eVar) {
        if (i()) {
            if (i3 == 0) {
                i3 = h(activity);
            }
            if (i3 == 0 || !fVar.a(activity, i3)) {
                return;
            }
            z0.d.a(activity, i3);
            eVar.a(activity);
        }
    }

    public static void g(Activity activity, z0.b bVar) {
        f(activity, bVar.e(), bVar.d(), bVar.c());
    }

    private static int h(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f6600a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean i() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        c cVar = f6603d.get(Build.MANUFACTURER.toLowerCase());
        if (cVar == null) {
            cVar = f6604e.get(Build.BRAND.toLowerCase());
        }
        return cVar != null && cVar.a();
    }
}
