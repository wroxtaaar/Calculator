package r0;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: VolleyLog.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f6055a = "Volley";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6056b = Log.isLoggable("Volley", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f6057c = v.class.getName();

    /* JADX INFO: compiled from: VolleyLog.java */
    static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final boolean f6058c = v.f6056b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<C0086a> f6059a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6060b = false;

        /* JADX INFO: renamed from: r0.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VolleyLog.java */
        private static class C0086a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f6061a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f6062b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f6063c;

            public C0086a(String str, long j3, long j4) {
                this.f6061a = str;
                this.f6062b = j3;
                this.f6063c = j4;
            }
        }

        a() {
        }

        private long c() {
            if (this.f6059a.size() == 0) {
                return 0L;
            }
            long j3 = this.f6059a.get(0).f6063c;
            List<C0086a> list = this.f6059a;
            return list.get(list.size() - 1).f6063c - j3;
        }

        public synchronized void a(String str, long j3) {
            if (this.f6060b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f6059a.add(new C0086a(str, j3, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.f6060b = true;
            long jC = c();
            if (jC <= 0) {
                return;
            }
            long j3 = this.f6059a.get(0).f6063c;
            v.b("(%-4d ms) %s", Long.valueOf(jC), str);
            for (C0086a c0086a : this.f6059a) {
                long j4 = c0086a.f6063c;
                v.b("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(c0086a.f6062b), c0086a.f6061a);
                j3 = j4;
            }
        }

        protected void finalize() throws Throwable {
            if (this.f6060b) {
                return;
            }
            b("Request on the loose");
            v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i3 = 2; i3 < stackTrace.length; i3++) {
            if (!stackTrace[i3].getClassName().equals(f6057c)) {
                String className = stackTrace[i3].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i3].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f6055a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f6055a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(f6055a, a(str, objArr), th);
    }

    public static void e(String str, Object... objArr) {
        if (f6056b) {
            Log.v(f6055a, a(str, objArr));
        }
    }
}
