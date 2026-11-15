package com.vivo.seckeysdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import java.io.File;
import l2.g;
import l2.h;
import l2.i;

/* JADX INFO: loaded from: classes.dex */
public class SDKCipherNative {
    public static boolean initClass = false;
    public static boolean isLoadSoOK = true;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                String[] strArrH = g.h();
                if (strArrH != null) {
                    for (String str : strArrH) {
                        File file = new File(str.trim(), "libvivoseckey.so");
                        if (file.exists()) {
                            i.g("SecurityKey", "so_sha256=" + g.b(file) + ",len=" + file.length() + ",soFile=" + file.getAbsolutePath());
                            return;
                        }
                        i.g("SecurityKey", "soFile=" + file.getAbsolutePath() + " not exist");
                    }
                }
            } catch (Throwable th) {
                i.e("SecurityKey", "Error: " + th.getMessage(), th);
            }
        }
    }

    public enum b {
        NONE,
        AES,
        RSA,
        AES_FIXED,
        END
    }

    public enum c {
        NONE,
        ENCRYPT,
        DECRYPT,
        SIGN,
        VERIFY,
        UPDATE,
        UPDATE_WITH_NAME,
        GET_UNIQUE_ID,
        WRITE_SFS,
        READ_SFS,
        END
    }

    static {
        try {
            startGetSoLoadInfoThread();
            System.loadLibrary("vivoseckey");
            isLoadSoOK = true;
        } catch (Throwable th) {
            isLoadSoOK = false;
            i.e("SecurityKey", "Error: " + th.getMessage(), th);
            th.getMessage();
            g.e();
            if (th instanceof UnsatisfiedLinkError) {
                throw th;
            }
            String[] strArrH = g.h();
            if (strArrH != null) {
                for (String str : strArrH) {
                    File file = new File(str, "libvivoseckey.so");
                    if (file.exists()) {
                        if (file.length() >= 102400) {
                            return;
                        }
                        i.k("SecurityKey", "found libvivoseckey.so < 100KB, please check! so_sha256=" + g.b(file) + ",fileLen=" + file.length() + ",soFile=" + file.getAbsolutePath());
                        throw th;
                    }
                }
            }
        }
    }

    public static void cData(Context context, int i3) {
        try {
            h.d();
            i.g("SecurityKey", "java cData end");
        } catch (Throwable th) {
            i.e("SecurityKey", "Error: " + th.getMessage(), th);
        }
    }

    public static Signature[] collectCert(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.endsWith(".apk") && new File(str).exists()) {
                return g.f(str);
            }
            return null;
        } catch (Throwable th) {
            i.e("SecurityKey", "Error: " + th.getMessage(), th);
            return null;
        }
    }

    public static native NativeResponse execute(NativeRequest nativeRequest);

    public static String getSubstrateEntry(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null && new File(str).exists()) {
                return g.a(context, str);
            }
            return BuildConfig.FLAVOR;
        } catch (Throwable th) {
            i.e("SecurityKey", "Error: " + th.getMessage(), th);
            return BuildConfig.FLAVOR;
        }
    }

    public static native boolean init(Context context);

    public static native boolean notice();

    private static void startGetSoLoadInfoThread() {
        new Thread(new a()).start();
    }
}
