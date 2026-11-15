package l2;

import android.util.Base64;

/* JADX INFO: compiled from: SKDC.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static String a(int i3) {
        switch (i3) {
            case 21310:
                return "init_d";
            case 21311:
                return "key_u";
            case 21312:
                return "aes_e";
            case 21313:
                return "aes_d";
            case 21314:
                return "rsa_e";
            case 21315:
                return "rsa_d";
            case 21316:
                return "sign_s";
            case 21317:
                return "sign_v";
            case 21318:
                return "data_s";
            case 21319:
                return "data_r";
            case 21320:
                return "risk_exit";
            case 21321:
                return "fast_sign";
            case 21322:
                return "fast_verify";
            default:
                i.i("SecurityKey", "unknown actiontype: ".concat(String.valueOf(i3)));
                return "unknown";
        }
    }

    public static void b() {
    }

    public static void c(byte[] bArr) {
        Base64.encodeToString(g.g(bArr), 11);
    }

    public static void d() {
    }

    public static void e() {
    }
}
