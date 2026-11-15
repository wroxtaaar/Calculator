package a0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TraceCompat.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f4a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f5b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f6c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f7d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f8e;

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 18 || i3 >= 29) {
            return;
        }
        try {
            f4a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Class cls = Long.TYPE;
            f5b = Trace.class.getMethod("isTagEnabled", cls);
            Class cls2 = Integer.TYPE;
            f6c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
            f7d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
            f8e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
        } catch (Exception e3) {
            Log.i("TraceCompat", "Unable to initialize via reflection.", e3);
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
