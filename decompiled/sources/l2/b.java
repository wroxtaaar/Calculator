package l2;

import android.content.Context;
import android.util.Base64;
import com.vivo.seckeysdk.BuildConfig;
import com.vivo.seckeysdk.SecurityKeyCipher;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: SecurityLevelProtocolPackage.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f5270m = "forConstructor";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f5271n = "forMethod";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static HashMap<String, b> f5272o = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5273a = "UTF-8";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f5275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f5276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f5280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f5282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f5283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f5284l;

    private b(Context context, byte[] bArr, String str) throws SecurityKeyException {
        this.f5274b = true;
        this.f5275c = null;
        this.f5279g = BuildConfig.FLAVOR;
        this.f5280h = BuildConfig.FLAVOR;
        this.f5281i = BuildConfig.FLAVOR;
        this.f5282j = BuildConfig.FLAVOR;
        this.f5283k = new byte[0];
        this.f5284l = new byte[0];
        if (bArr == null || bArr.length == 0) {
            throw new SecurityKeyException("Entry body must not be empty", 1000);
        }
        this.f5276d = context;
        this.f5275c = bArr;
        this.f5274b = true;
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int iA = k2.g.a(bArr2);
        if (iA <= 0) {
            throw new SecurityKeyException("Illegal header length:".concat(String.valueOf(iA)), SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArr3 = this.f5275c;
        if (bArr3.length < iA) {
            throw new SecurityKeyException("Header length great than entry length,entry length:" + this.f5275c.length + ",header length:" + iA, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        if (this.f5274b) {
            if (bArr3 == null) {
                throw new SecurityKeyException("The haeder bytes must not be empty", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
            }
            byte[] bArr4 = new byte[8];
            byte[] bArr5 = new byte[bArr3.length - 12];
            System.arraycopy(bArr3, 4, bArr4, 0, 8);
            byte[] bArr6 = this.f5275c;
            System.arraycopy(bArr6, 12, bArr5, 0, bArr6.length - 12);
            long jD = k2.g.d(bArr4);
            CRC32 crc32 = new CRC32();
            crc32.update(bArr5);
            long value = crc32.getValue();
            if (jD != value) {
                throw new SecurityKeyException("头数据校验不成功，头部校验和为：" + jD + ",计算校验和为：" + value, 1000);
            }
        }
        try {
            byte[] bArr7 = new byte[2];
            System.arraycopy(this.f5275c, 12, bArr7, 0, 2);
            int iA2 = k2.g.a(bArr7);
            if (iA2 != 1) {
                throw new SecurityKeyException("Unsupported version of:" + iA2 + " for this Header + " + b.class, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
            }
            this.f5277e = iA2;
            byte[] bArr8 = this.f5275c;
            if (bArr8.length < 17) {
                throw new SecurityKeyException("crypto header problem", 150);
            }
            byte[] bArr9 = new byte[4];
            System.arraycopy(bArr8, 14, bArr9, 0, 4);
            this.f5278f = Integer.valueOf(k2.g.a(bArr9)).intValue();
            Integer numValueOf = Integer.valueOf(k2.g.a(new byte[]{bArr8[18]}));
            byte[] bArr10 = new byte[numValueOf.intValue()];
            if (bArr8.length < numValueOf.intValue() + 18) {
                throw new SecurityKeyException("crypto header problem", 150);
            }
            System.arraycopy(bArr8, 19, bArr10, 0, numValueOf.intValue());
            String str2 = new String(bArr10, this.f5273a);
            if (!str.equals(str2)) {
                throw new SecurityKeyException("Unsupported tag=" + str2 + " for this Header + " + b.class, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
            }
            this.f5279g = str2;
            Integer numValueOf2 = Integer.valueOf(k2.g.a(new byte[]{bArr8[numValueOf.intValue() + 19]}));
            byte[] bArr11 = new byte[numValueOf2.intValue()];
            if (bArr8.length < numValueOf2.intValue() + 19) {
                throw new SecurityKeyException("crypto header problem", 150);
            }
            System.arraycopy(bArr8, numValueOf.intValue() + 20, bArr11, 0, numValueOf2.intValue());
            String str3 = new String(bArr11, this.f5273a);
            String packageName = this.f5276d.getPackageName();
            if (!packageName.equals(str3)) {
                throw new SecurityKeyException("Unsupported protocol_packageName of:" + str3 + " for this Header + " + b.class + ",expected to be app_packageName=" + packageName + ", but " + str3, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
            }
            this.f5280h = str3;
            Integer numValueOf3 = Integer.valueOf(k2.g.a(new byte[]{bArr8[numValueOf.intValue() + 20 + numValueOf2.intValue()]}));
            byte[] bArr12 = new byte[numValueOf3.intValue()];
            if (bArr8.length < numValueOf.intValue() + 21 + numValueOf2.intValue() + numValueOf3.intValue()) {
                throw new SecurityKeyException("crypto header problem", 150);
            }
            System.arraycopy(bArr8, numValueOf.intValue() + 21 + numValueOf2.intValue(), bArr12, 0, numValueOf3.intValue());
            this.f5281i = new String(bArr12, this.f5273a);
            int iIntValue = numValueOf.intValue() + 21 + numValueOf2.intValue() + numValueOf3.intValue();
            if (iIntValue < bArr8.length) {
                Integer numValueOf4 = Integer.valueOf(k2.g.a(new byte[]{bArr8[iIntValue]}));
                byte[] bArr13 = new byte[numValueOf4.intValue()];
                if (bArr8.length < numValueOf.intValue() + 21 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue()) {
                    throw new SecurityKeyException("crypto header problem", 150);
                }
                System.arraycopy(bArr8, numValueOf.intValue() + 22 + numValueOf2.intValue() + numValueOf3.intValue(), bArr13, 0, numValueOf4.intValue());
                this.f5282j = new String(bArr13, this.f5273a);
                int iIntValue2 = numValueOf.intValue() + 22 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue();
                if (iIntValue2 < bArr8.length) {
                    Integer numValueOf5 = Integer.valueOf(k2.g.a(new byte[]{bArr8[iIntValue2]}));
                    byte[] bArr14 = new byte[numValueOf5.intValue()];
                    if (bArr8.length < numValueOf.intValue() + 22 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue() + numValueOf5.intValue()) {
                        throw new SecurityKeyException("crypto header problem", 150);
                    }
                    System.arraycopy(bArr8, numValueOf.intValue() + 23 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue(), bArr14, 0, numValueOf5.intValue());
                    this.f5283k = bArr14;
                    if (numValueOf.intValue() + 23 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue() + numValueOf5.intValue() < bArr8.length) {
                        Integer numValueOf6 = Integer.valueOf(k2.g.a(new byte[]{bArr8[numValueOf.intValue() + 23 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue() + numValueOf5.intValue()]}));
                        byte[] bArr15 = new byte[numValueOf6.intValue()];
                        if (bArr8.length < numValueOf.intValue() + 23 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue() + numValueOf5.intValue() + numValueOf6.intValue()) {
                            throw new SecurityKeyException("crypto header problem", 150);
                        }
                        System.arraycopy(bArr8, numValueOf.intValue() + 24 + numValueOf2.intValue() + numValueOf3.intValue() + numValueOf4.intValue() + numValueOf5.intValue(), bArr15, 0, numValueOf6.intValue());
                        this.f5284l = bArr15;
                    }
                }
            }
        } catch (UnsupportedEncodingException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
    }

    public static int b(Context context, String str) {
        try {
            b bVarG = f5272o.get(str);
            if (bVarG == null) {
                bVarG = g(context, str);
                f5272o.put(str, bVarG);
            }
            int i3 = bVarG.f5278f;
            i.g("SecurityKey", "resetVivoCipher buildProtocolPackageForMethod cipherMode=" + i3 + ",mode=" + SecurityKeyCipher.modeToString(i3));
            return i3;
        } catch (SecurityKeyException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            return 4;
        }
    }

    public static String c(int i3) {
        if (i3 == 0) {
            return "NONE";
        }
        if (i3 != 1) {
            return i3 != 2 ? "UNKNOWN" : "APP_PROTECTION";
        }
        return "SDK_PROTECTION";
    }

    private static b d(Context context, byte[] bArr, String str) throws SecurityKeyException {
        return new b(context, bArr, str);
    }

    public static b f(Context context, String str) throws SecurityKeyException {
        try {
            return d(context, Base64.decode(str, 3), f5270m);
        } catch (IllegalArgumentException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            throw new SecurityKeyException(e3.getMessage(), -1000);
        }
    }

    private static b g(Context context, String str) throws SecurityKeyException {
        try {
            return d(context, Base64.decode(str, 3), f5271n);
        } catch (IllegalArgumentException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            throw new SecurityKeyException(e3.getMessage(), -1000);
        }
    }

    public final int a() {
        return this.f5278f;
    }

    public final String e() {
        return this.f5282j;
    }

    public final byte[] h() {
        return this.f5283k;
    }
}
