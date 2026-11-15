package t;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;

/* JADX INFO: compiled from: ActivityCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends u.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f6210c;

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityCompat.java */
    class RunnableC0089a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f6211b;

        RunnableC0089a(Activity activity) {
            this.f6211b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6211b.isFinishing() || t.b.i(this.f6211b)) {
                return;
            }
            this.f6211b.recreate();
        }
    }

    /* JADX INFO: compiled from: ActivityCompat.java */
    public interface b {
        boolean a(Activity activity, int i3, int i4, Intent intent);
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static b g() {
        return f6210c;
    }

    public static void h(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            activity.recreate();
        } else if (i3 <= 23) {
            new Handler(activity.getMainLooper()).post(new RunnableC0089a(activity));
        } else {
            if (t.b.i(activity)) {
                return;
            }
            activity.recreate();
        }
    }
}
