package t;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Class<?> f6212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Field f6213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f6214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f6215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f6216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f6217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Handler f6218g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: ActivityRecreator.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f6219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f6220c;

        a(d dVar, Object obj) {
            this.f6219b = dVar;
            this.f6220c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6219b.f6225a = this.f6220c;
        }
    }

    /* JADX INFO: renamed from: t.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityRecreator.java */
    class RunnableC0090b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Application f6221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f6222c;

        RunnableC0090b(Application application, d dVar) {
            this.f6221b = application;
            this.f6222c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6221b.unregisterActivityLifecycleCallbacks(this.f6222c);
        }
    }

    /* JADX INFO: compiled from: ActivityRecreator.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f6223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f6224c;

        c(Object obj, Object obj2) {
            this.f6223b = obj;
            this.f6224c = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = b.f6215d;
                if (method != null) {
                    method.invoke(this.f6223b, this.f6224c, Boolean.FALSE, "AppCompat recreation");
                } else {
                    b.f6216e.invoke(this.f6223b, this.f6224c, Boolean.FALSE);
                }
            } catch (RuntimeException e3) {
                if (e3.getClass() == RuntimeException.class && e3.getMessage() != null && e3.getMessage().startsWith("Unable to stop")) {
                    throw e3;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* JADX INFO: compiled from: ActivityRecreator.java */
    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f6225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Activity f6226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f6228d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f6229e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f6230f = false;

        d(Activity activity) {
            this.f6226b = activity;
            this.f6227c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f6226b == activity) {
                this.f6226b = null;
                this.f6229e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f6229e || this.f6230f || this.f6228d || !b.h(this.f6225a, this.f6227c, activity)) {
                return;
            }
            this.f6230f = true;
            this.f6225a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f6226b == activity) {
                this.f6228d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        f6212a = clsA;
        f6213b = b();
        f6214c = f();
        f6215d = d(clsA);
        f6216e = c(clsA);
        f6217f = e(clsA);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i3 = Build.VERSION.SDK_INT;
        return i3 == 26 || i3 == 27;
    }

    protected static boolean h(Object obj, int i3, Activity activity) {
        try {
            Object obj2 = f6214c.get(activity);
            if (obj2 == obj && activity.hashCode() == i3) {
                f6218g.postAtFrontOfQueue(new c(f6213b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f6217f == null) {
            return false;
        }
        if (f6216e == null && f6215d == null) {
            return false;
        }
        try {
            Object obj2 = f6214c.get(activity);
            if (obj2 == null || (obj = f6213b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            f6218g.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f6217f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f6218g.post(new RunnableC0090b(application, dVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
