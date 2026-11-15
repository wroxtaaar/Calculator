package vivo.util;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class VLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG_PREFIX = "_V_";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    private VLog() {
    }

    public static int d(String str, String str2) {
        return Log.d(vTag(str), str2);
    }

    public static int e(String str, String str2) {
        return Log.e(vTag(str), str2);
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static int i(String str, String str2) {
        return Log.i(vTag(str), str2);
    }

    public static boolean isLoggable(String str, int i3) {
        return Log.isLoggable(str, i3);
    }

    public static int println(int i3, String str, String str2) {
        return Log.println(i3, vTag(str), str2);
    }

    public static int v(String str, String str2) {
        return Log.v(vTag(str), str2);
    }

    private static String vTag(String str) {
        return TAG_PREFIX + str;
    }

    public static int w(String str, String str2) {
        return Log.w(vTag(str), str2);
    }

    public static int wtf(String str, String str2) {
        return Log.wtf(vTag(str), str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return Log.d(vTag(str), str2, th);
    }

    public static int e(String str, String str2, Throwable th) {
        return Log.e(vTag(str), str2, th);
    }

    public static int i(String str, String str2, Throwable th) {
        return Log.i(vTag(str), str2, th);
    }

    public static int v(String str, String str2, Throwable th) {
        return Log.v(vTag(str), str2, th);
    }

    public static int w(String str, String str2, Throwable th) {
        return Log.w(vTag(str), str2, th);
    }

    public static int wtf(String str, String str2, Throwable th) {
        return Log.wtf(vTag(str), str2, th);
    }

    public static int w(String str, Throwable th) {
        return Log.w(vTag(str), th);
    }

    public static int wtf(String str, Throwable th) {
        return Log.wtf(vTag(str), th);
    }
}
