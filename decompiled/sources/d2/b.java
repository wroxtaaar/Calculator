package d2;

import android.util.Base64;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.seckeysdk.BuildConfig;
import java.net.URLDecoder;
import vivo.util.VLog;

/* JADX INFO: compiled from: NetUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f4512a;

    private b() {
    }

    private String e() {
        return e2.a.i().g("calculator_key", BuildConfig.FLAVOR);
    }

    public static b g() {
        b bVar = f4512a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f4512a;
                if (bVar == null) {
                    bVar = new b();
                    f4512a = bVar;
                }
            }
        }
        return bVar;
    }

    public String a(String str) {
        try {
            return BBKCalculatorApplication.a().b().decryptResponse(URLDecoder.decode(str, "UTF-8"));
        } catch (Exception e3) {
            VLog.e("BBKCalculator/NetUtils", "decode, exception:" + e3.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public String b(String str, String str2) {
        try {
            return "jvq_param=" + Base64.encodeToString(BBKCalculatorApplication.a().b().aesEncrypt(("lang=" + str + "&ver=" + str2).getBytes("UTF-8")), 10);
        } catch (Exception e3) {
            VLog.e("BBKCalculator/NetUtils", "getCurrencyPostBody e" + e3);
            return BuildConfig.FLAVOR;
        }
    }

    public String c() {
        return e() + "/cacl/exchange/getName.do?";
    }

    public String d() {
        return e() + "/cacl/exchange/getRates.do?";
    }

    public String f(String str, String str2) {
        byte[] bArrAesEncrypt;
        try {
            bArrAesEncrypt = BBKCalculatorApplication.a().b().aesEncrypt(("curr1=" + str + "&curr2=" + str2).getBytes("UTF-8"));
        } catch (Exception e3) {
            VLog.e("BBKCalculator/NetUtils", "getExchangePostBody e" + e3);
            bArrAesEncrypt = null;
        }
        if (bArrAesEncrypt == null) {
            return BuildConfig.FLAVOR;
        }
        return "jvq_param=" + Base64.encodeToString(bArrAesEncrypt, 10);
    }
}
