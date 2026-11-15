package l2;

import vivo.util.VLog;

/* JADX INFO: compiled from: VLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5294a = "Unknown";

    public static void a(String str) {
        f5294a = str;
    }

    public static void b(String str, j2.c cVar, String str2) {
        VLog.d(str, cVar.s() + ": " + str2);
    }

    public static void c(String str, j2.c cVar, String str2, Throwable th) {
        VLog.e(str, cVar.s() + ": " + str2, th);
    }

    public static void d(String str, String str2) {
        VLog.d(str, f5294a + ": " + str2);
    }

    public static void e(String str, String str2, Throwable th) {
        VLog.e(str, str2, th);
    }

    public static void f(String str, j2.c cVar, String str2) {
        VLog.i(str, cVar.s() + ": " + str2);
    }

    public static void g(String str, String str2) {
        VLog.i(str, f5294a + ": " + str2);
    }

    public static void h(String str, j2.c cVar, String str2) {
        VLog.w(str, cVar.s() + ": " + str2);
    }

    public static void i(String str, String str2) {
        VLog.w(str, f5294a + ": " + str2);
    }

    public static void j(String str, j2.c cVar, String str2) {
        VLog.e(str, cVar.s() + ": " + str2);
    }

    public static void k(String str, String str2) {
        VLog.e(str, f5294a + ": " + str2);
    }
}
