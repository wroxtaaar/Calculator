package com.vivo.seckeysdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.seckeysdk.utils.ProtocolPackage;
import com.vivo.seckeysdk.utils.SDKCipherConfig;
import com.vivo.seckeysdk.utils.SDKCipherNative;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import i2.c;
import i2.d;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l2.a;
import l2.b;
import l2.g;
import l2.h;
import l2.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SecurityKeyCipher {
    public static final int AES_DECRYPT_DATA_SIZE_MAX = 204816;
    public static final int AES_ENCRYPT_DATA_SIZE_MAX = 204800;
    public static final int BASE64_FLAG = 11;
    public static final int HTTP_AES_ENCRYPT = 1;
    public static final int HTTP_FAST_SIGN = 4;
    public static final int HTTP_FAST_SIGN_ENCRYPT = 5;
    public static final int HTTP_RSA_SIGN = 2;
    public static final int HTTP_SIGN_ENCRYPT = 3;
    public static final int KEY_TYPE_EK = 1;
    public static final int KEY_TYPE_SK = 2;
    public static final int KEY_TYPE_VK = 4;
    public static final int KEY_VERSION_1 = 1;
    public static final int KEY_VERSION_2 = 2;
    public static final int KEY_VERSION_MAX = 2;
    public static final int PKGTYPE_AES_ENCRYPT = 5;
    public static final int PKGTYPE_FAST_SIGN_SIGNED = 17;
    public static final int PKGTYPE_FAST_VERIFY = 15;
    public static final int PKGTYPE_FIXED_AES_ENCRYPT = 16;
    public static final int PKGTYPE_RSA_ENCRYPT = 6;
    public static final int PKGTYPE_SIGN_SIGNED = 10;
    public static final int RSA_DECRYPT_DATA_SIZE_MAX = 256;
    public static final int RSA_ENCRYPT_DATA_SIZE_MAX = 245;
    public static final String SDK_VERSION = "seckeysdk-GDPR-V3.1.6-a820cf4";
    public static final int SECURITY_DATA_SIZE_MAX = 2048;
    public static final int SIGN_DATA_SIZE = 256;
    public static final int SIGN_SIGNED_DATA_SIZE_MAX = 204800;
    public static final int SIGN_VERIFY_DATA_SIZE_MAX = 204800;
    public static final int SK_MODE_AUTO = 1;
    public static final int SK_MODE_FIXED = 6;
    public static final int SK_MODE_SDK = 4;
    public static final int SK_MODE_SOFT = 3;
    public static final int SK_MODE_TEE = 2;
    public static final int SK_MODE_UNKOWN = 7;
    protected static volatile Map<String, SecurityKeyCipher> ciphers = new HashMap();
    protected Context mContext;
    protected volatile a mCipher = null;
    protected com.vivo.seckeysdk.utils.a mSdkCipher = null;
    protected i2.a mPlatformCipher = null;
    protected int mCipherMode = 1;

    public static class Builder {
        private static final Boolean AUTO_UPDATE_KEY_DEFAULT = Boolean.TRUE;
        private static final int DEFAULT = -1;
        private Context mContext;
        private String securityLevelProtocol;
        private Boolean mAutoUpdateKey = AUTO_UPDATE_KEY_DEFAULT;
        private int mCipherMode = -1;
        private SecurityKeyCipher instance = null;

        public Builder(Context context, String str) {
            this.mContext = null;
            this.mContext = context;
            this.securityLevelProtocol = str;
        }

        public SecurityKeyCipher build() {
            i.g("SecurityKey", "Builder.build() " + toString());
            SecurityKeyCipher securityKeyCipher = SecurityKeyCipher.getInstance(this.mContext, this.securityLevelProtocol);
            this.instance = securityKeyCipher;
            Boolean bool = this.mAutoUpdateKey;
            if (bool != AUTO_UPDATE_KEY_DEFAULT) {
                securityKeyCipher.setAutoUpdateKey(bool.booleanValue());
            }
            return this.instance;
        }

        public Builder setAutoUpdateKey(boolean z2) {
            this.mAutoUpdateKey = Boolean.valueOf(z2);
            return this;
        }

        public String toString() {
            return "Builder:{mAutoUpdateKey：" + this.mAutoUpdateKey + "}";
        }
    }

    protected SecurityKeyCipher(Context context) {
        this.mContext = null;
        this.mContext = context;
        i.d("SecurityKey", "Create new securityKeyCipher. version: seckeysdk-GDPR-V3.1.6-a820cf4");
    }

    private boolean checkModeValid(int i3) {
        return i3 > 0 && i3 <= 4;
    }

    public static synchronized SecurityKeyCipher getInstance(Context context, String str) {
        int i3;
        int i4;
        if (context == null) {
            i.k("SecurityKey", "getInstance context inputed is null");
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (packageName == null) {
            i.k("SecurityKey", "getPackageName return null");
            return null;
        }
        i.a(packageName);
        if (!TextUtils.isEmpty(str)) {
            packageName = packageName + str;
        }
        if (ciphers.containsKey(packageName)) {
            return ciphers.get(packageName);
        }
        SecurityKeyCipher securityKeyCipher = new SecurityKeyCipher(applicationContext);
        int i5 = 1;
        if (!TextUtils.isEmpty(str)) {
            try {
                b bVarF = b.f(applicationContext, str);
                int iA = bVarF.a();
                String strE = bVarF.e();
                byte[] bArrH = bVarF.h();
                if (bArrH == null || bArrH.length <= 0) {
                    i3 = -1;
                    i4 = -1;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArrH));
                        i4 = jSONObject.has("protectionThreadMode") ? jSONObject.getInt("protectionThreadMode") : -1;
                        try {
                            i3 = jSONObject.has("securityMode") ? jSONObject.getInt("securityMode") : -1;
                        } catch (JSONException e3) {
                            e = e3;
                            i.e("SecurityKey", "Error: " + e.getMessage(), e);
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        i4 = -1;
                    }
                }
                i.g("SecurityKey", "buildProtocolPackageForConstructor cipherMode=" + modeToString(iA) + ",useSecurityMode=" + strE + ",protectionThreadModeFrom=" + i4 + "(" + b.c(i4) + "),securityModeFromJson=" + i3);
                if (i4 != -1 && SDKCipherConfig.userConfigs.get("setCurrentProtectionMode") == null) {
                    SDKCipherConfig.setCurrentProtectionMode(i4);
                }
                SDKCipherConfig.setSecurityMode(strE, i3);
                i5 = iA;
            } catch (SecurityKeyException e5) {
                i.e("SecurityKey", "securityLevelProtocol error! msg=" + e5.getMessage(), e5);
                return null;
            }
        }
        securityKeyCipher.mSdkCipher = com.vivo.seckeysdk.utils.a.A(applicationContext);
        securityKeyCipher.mPlatformCipher = d.a(applicationContext);
        if (c.F()) {
            i.g("SecurityKey", "PlatformCipher supported");
            securityKeyCipher.mCipher = securityKeyCipher.mPlatformCipher;
        } else {
            i.g("SecurityKey", "PlatformCipher not supported");
            securityKeyCipher.mCipher = securityKeyCipher.mSdkCipher;
        }
        if (securityKeyCipher.mCipher != null && securityKeyCipher.mSdkCipher != null) {
            if (!TextUtils.isEmpty(str)) {
                setCipherModeByClientToken(securityKeyCipher, i5);
            }
            ciphers.put(packageName, securityKeyCipher);
            return securityKeyCipher;
        }
        i.k("SecurityKey", "get cipher fail");
        return null;
    }

    private a getProperCipher(ProtocolPackage protocolPackage, int i3, String str) throws SecurityKeyException {
        if (protocolPackage.getCipherMode() != 2) {
            return (this.mCipher == this.mSdkCipher || (this.mPlatformCipher != null && protocolPackage.getKeyVersion() > this.mPlatformCipher.a(i3))) ? this.mSdkCipher : this.mCipher;
        }
        i2.a aVar = this.mPlatformCipher;
        if (aVar != null) {
            return aVar;
        }
        i.k("SecurityKey", "mPlatformCipher == null,not Support tee ".concat(String.valueOf(str)));
        throw new SecurityKeyException("init failed!", 1000);
    }

    private int getTEEKeyVersion(int i3) {
        i2.a aVar = this.mPlatformCipher;
        if (aVar == null) {
            return 0;
        }
        return aVar.y(i3);
    }

    private boolean isPlatformCipher(a aVar) {
        return aVar instanceof i2.a;
    }

    private boolean isSoftMode(byte[] bArr) {
        try {
            int cipherMode = ProtocolPackage.buildProtocolPackage(bArr).getCipherMode();
            return cipherMode == 3 || cipherMode == 4;
        } catch (SecurityKeyException e3) {
            i.e("SecurityKey", "Build Package fail. Error: " + e3.getMessage(), e3);
            return false;
        }
    }

    private Map<String, String> json2Map(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (Exception e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            return new HashMap();
        }
    }

    private String map2Json(Map<String, String> map, boolean z2) {
        try {
            ArrayList arrayList = new ArrayList(map.keySet());
            if (z2) {
                Collections.sort(arrayList);
            }
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = (String) arrayList.get(i3);
                jSONObject.put(str, map.get(str));
            }
            return jSONObject.toString();
        } catch (JSONException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            return BuildConfig.FLAVOR;
        }
    }

    public static String modeToString(int i3) {
        if (i3 == 1) {
            return "AUTO";
        }
        if (i3 == 2) {
            return "TEE";
        }
        if (i3 == 3) {
            return "SOFT";
        }
        if (i3 == 4) {
            return "SDK";
        }
        i.k(BuildConfig.FLAVOR, "unknown mode:".concat(String.valueOf(i3)));
        return "Unkown";
    }

    private void preWork(byte[] bArr) {
        SDKCipherNative.notice();
        if (this.mCipherMode == 1 && isPlatformCipher(this.mCipher) && this.mCipher.w() == 3 && this.mCipher.f(1) == 1) {
            i.i("SecurityKey", "[prework] soft is not secure as sdk. Switch to sdk cipher");
            this.mCipher = this.mSdkCipher;
        }
    }

    private static void setCipherModeByClientToken(SecurityKeyCipher securityKeyCipher, int i3) {
        try {
            securityKeyCipher.setCipherMode(i3);
            i.g("SecurityKey", "switch mode of cipher to " + modeToString(i3));
        } catch (SecurityKeyException e3) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 1) {
                    i.e("SecurityKey", "setCipherModeByC failed to ".concat(String.valueOf(i3)), e3);
                    return;
                }
                i.k("SecurityKey", "setCipherModeByC failed to " + i3 + ", try SDK. msg: " + e3.getMessage());
                try {
                    securityKeyCipher.setCipherMode(4);
                    i.g("SecurityKey", "switch mode of cipher to SDK");
                    return;
                } catch (SecurityKeyException e4) {
                    i.e("SecurityKey", "setCipherModeByC failed to SDK", e4);
                    return;
                }
            }
            i.k("SecurityKey", "setCipherModeByC failed to TEE, try soft. msg: " + e3.getMessage());
            try {
                securityKeyCipher.setCipherMode(3);
                i.g("SecurityKey", "switch mode of cipher to SOFT");
            } catch (SecurityKeyException e5) {
                i.k("SecurityKey", "setCipherModeByC failed to Soft, try sdk. msg: " + e5.getMessage());
                try {
                    securityKeyCipher.setCipherMode(4);
                    i.g("SecurityKey", "switch mode of cipher to SDK");
                } catch (SecurityKeyException e6) {
                    i.e("SecurityKey", "setCipherModeByC failed to SDK", e6);
                }
            }
        }
    }

    public static String sha256(byte[] bArr) {
        return g.d(bArr);
    }

    private byte[] toSecurityBytesCommon(Map<String, String> map, int i3, boolean z2) throws SecurityKeyException {
        if (map == null || map.size() == 0) {
            throw new SecurityKeyException("invalid input params!", 103);
        }
        Map<String, String> securityMapV2 = z2 ? toSecurityMapV2(map, i3) : toSecurityMap(map, i3);
        if (securityMapV2 == null || securityMapV2.isEmpty()) {
            return null;
        }
        try {
            return l2.d.a(securityMapV2, false, false).getBytes();
        } catch (UnsupportedEncodingException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            return null;
        }
    }

    private Map<String, String> toSecurityMapCommon(Map<String, String> map, int i3, boolean z2) throws SecurityKeyException {
        if (map == null || map.size() == 0) {
            throw new SecurityKeyException("invalid input params!", 103);
        }
        HashMap map2 = null;
        try {
            if (i3 == 1) {
                byte[] bArrAesEncrypt = aesEncrypt(l2.d.a(map, false, z2).getBytes("utf-8"));
                if (bArrAesEncrypt != null && bArrAesEncrypt.length != 0) {
                    map2 = new HashMap();
                    map2.put("jvq_param", Base64.encodeToString(bArrAesEncrypt, 11));
                }
            } else if (i3 == 2) {
                String strA = l2.d.a(l2.d.c(map), true, false);
                map2 = new HashMap(map);
                byte[] bArrSign = sign(strA.getBytes("utf-8"));
                if (bArrSign != null && bArrSign.length != 0) {
                    map2.put("jvq_sign", Base64.encodeToString(bArrSign, 11));
                }
            } else if (i3 == 3) {
                Map<String, String> mapC = l2.d.c(map);
                byte[] bArrSign2 = sign(l2.d.a(mapC, true, false).getBytes("utf-8"));
                byte[] bArrAesEncrypt2 = aesEncrypt(l2.d.a(mapC, true, z2).getBytes("utf-8"));
                if (bArrSign2 != null && bArrSign2.length != 0 && bArrAesEncrypt2 != null && bArrAesEncrypt2.length != 0) {
                    map2 = new HashMap();
                    map2.put("jvq_sign", Base64.encodeToString(bArrSign2, 11));
                    map2.put("jvq_param", Base64.encodeToString(bArrAesEncrypt2, 11));
                }
            } else {
                if (i3 != 4) {
                    if (i3 == 5) {
                        Map<String, String> mapC2 = l2.d.c(map);
                        byte[] bArrSignFast = signFast(l2.d.a(mapC2, true, false).getBytes("utf-8"));
                        byte[] bArrAesEncrypt3 = aesEncrypt(l2.d.a(mapC2, true, z2).getBytes("utf-8"));
                        if (bArrSignFast != null && bArrSignFast.length != 0 && bArrAesEncrypt3 != null && bArrAesEncrypt3.length != 0) {
                            map2 = new HashMap();
                            map2.put("jvq_sign", Base64.encodeToString(bArrSignFast, 11));
                            map2.put("jvq_param", Base64.encodeToString(bArrAesEncrypt3, 11));
                        }
                    }
                    return map2;
                }
                String strA2 = l2.d.a(l2.d.c(map), true, false);
                map2 = new HashMap(map);
                byte[] bArrSignFast2 = signFast(strA2.getBytes("utf-8"));
                if (bArrSignFast2 != null && bArrSignFast2.length != 0) {
                    map2.put("jvq_sign", Base64.encodeToString(bArrSignFast2, 11));
                }
            }
            return map2;
        } catch (UnsupportedEncodingException e3) {
            i.k("SecurityKey", "Exception:" + e3.getMessage());
            throw new SecurityKeyException("unknown error!", 1000);
        }
    }

    private String toSecurityUrlCommon(String str, int i3, boolean z2) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new SecurityKeyException("invalid input params!", 102);
        }
        String str2 = null;
        String str3 = (TextUtils.isEmpty(str) || !str.contains("?")) ? null : str.split("[?]")[0];
        if (TextUtils.isEmpty(str3)) {
            throw new SecurityKeyException("input url is invalid! Not include parameters?", 103);
        }
        Map<String, String> mapB = l2.d.b(str);
        if (mapB == null || mapB.size() == 0) {
            throw new SecurityKeyException("invalid request params!", 103);
        }
        try {
            if (i3 == 1) {
                byte[] bArrAesEncrypt = aesEncrypt(l2.d.a(mapB, false, z2).getBytes("utf-8"));
                if (bArrAesEncrypt != null && bArrAesEncrypt.length != 0) {
                    return String.format("%s?jvq_param=%s", str3, Base64.encodeToString(bArrAesEncrypt, 11));
                }
            } else if (i3 == 2) {
                String strA = l2.d.a(l2.d.c(mapB), true, false);
                byte[] bArrSign = sign(strA.getBytes("utf-8"));
                if (bArrSign != null && bArrSign.length != 0) {
                    return String.format("%s?%s&jvq_sign=%s", str3, strA, Base64.encodeToString(bArrSign, 11));
                }
            } else if (i3 == 3) {
                Map<String, String> mapC = l2.d.c(mapB);
                byte[] bArrSign2 = sign(l2.d.a(mapC, true, false).getBytes("utf-8"));
                byte[] bArrAesEncrypt2 = aesEncrypt(l2.d.a(mapC, true, z2).getBytes("utf-8"));
                if (bArrSign2 != null && bArrSign2.length != 0 && bArrAesEncrypt2 != null && bArrAesEncrypt2.length != 0) {
                    return String.format("%s?jvq_sign=%s&jvq_param=%s", str3, Base64.encodeToString(bArrSign2, 11), Base64.encodeToString(bArrAesEncrypt2, 11));
                }
            } else if (i3 == 4) {
                String strA2 = l2.d.a(l2.d.c(mapB), true, false);
                byte[] bArrSignFast = signFast(strA2.getBytes("utf-8"));
                if (bArrSignFast != null && bArrSignFast.length != 0) {
                    return String.format("%s?%s&jvq_sign=%s", str3, strA2, Base64.encodeToString(bArrSignFast, 11));
                }
            } else if (i3 == 5) {
                Map<String, String> mapC2 = l2.d.c(mapB);
                byte[] bArrSignFast2 = signFast(l2.d.a(mapC2, true, false).getBytes("utf-8"));
                byte[] bArrAesEncrypt3 = aesEncrypt(l2.d.a(mapC2, true, z2).getBytes("utf-8"));
                if (bArrSignFast2 != null && bArrSignFast2.length != 0 && bArrAesEncrypt3 != null && bArrAesEncrypt3.length != 0) {
                    str2 = String.format("%s?jvq_sign=%s&jvq_param=%s", str3, Base64.encodeToString(bArrSignFast2, 11), Base64.encodeToString(bArrAesEncrypt3, 11));
                }
            }
            return str2;
        } catch (UnsupportedEncodingException e3) {
            i.k("SecurityKey", "Exception:" + e3.getMessage());
            throw new SecurityKeyException("unknown error!", 1000);
        }
    }

    public byte[] aesDecrypt(byte[] bArr) throws SecurityKeyException {
        try {
            try {
                preWork(bArr);
                return getProperCipher(ProtocolPackage.buildProtocolPackage(bArr), 1, "aesDecrypt").o(bArr);
            } catch (SecurityKeyException e3) {
                if ((e3.getErrorCode() == 152 || !isSoftMode(bArr)) && !needSwitchSdkCipher(bArr)) {
                    e3.getErrorCode();
                    throw e3;
                }
                try {
                    return this.mSdkCipher.o(bArr);
                } catch (SecurityKeyException e4) {
                    e4.getErrorCode();
                    throw e4;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                getCurCipherMode();
                h.c(bArr);
            }
            throw th;
        }
    }

    public byte[] aesDecryptByFixed(byte[] bArr) throws SecurityKeyException {
        int errorCode = 0;
        try {
            try {
                SDKCipherNative.notice();
                return com.vivo.seckeysdk.utils.a.H(bArr);
            } catch (SecurityKeyException e3) {
                errorCode = e3.getErrorCode();
                throw e3;
            }
        } catch (Throwable th) {
            if (errorCode != 0) {
                h.c(bArr);
            }
            throw th;
        }
    }

    public byte[] aesDecryptData(String str) throws SecurityKeyException {
        try {
            return aesDecryptByFixed(Base64.decode(str, 11));
        } catch (IllegalArgumentException e3) {
            new String(g.g(str.getBytes()));
            h.b();
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            throw new SecurityKeyException(e3.getMessage(), -10);
        }
    }

    public byte[] aesDecryptString(String str) throws SecurityKeyException {
        try {
            return aesDecrypt(Base64.decode(str, 11));
        } catch (IllegalArgumentException e3) {
            new String(g.g(str.getBytes()));
            h.b();
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            throw new SecurityKeyException(e3.getMessage(), -10);
        }
    }

    public byte[] aesEncrypt(byte[] bArr) throws SecurityKeyException {
        a aVar;
        try {
            try {
                preWork(null);
                aVar = this.mCipher;
                try {
                    return aVar.v(bArr);
                } catch (SecurityKeyException e3) {
                    e = e3;
                    if (!needSwitchSdkCipher(null) && (aVar == this.mCipher || !(this.mCipher instanceof com.vivo.seckeysdk.utils.a))) {
                        e.getErrorCode();
                        throw e;
                    }
                    return this.mCipher.v(bArr);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    getCurCipherMode();
                    h.d();
                }
                throw th;
            }
        } catch (SecurityKeyException e4) {
            e = e4;
            aVar = null;
        }
    }

    public byte[] aesEncryptByFixed(byte[] bArr) throws SecurityKeyException {
        int errorCode = 0;
        try {
            try {
                SDKCipherNative.notice();
                return this.mSdkCipher.D(bArr);
            } catch (SecurityKeyException e3) {
                errorCode = e3.getErrorCode();
                throw e3;
            }
        } catch (Throwable th) {
            if (errorCode != 0) {
                h.d();
            }
            throw th;
        }
    }

    public String aesEncryptData(byte[] bArr) throws SecurityKeyException {
        return Base64.encodeToString(aesEncryptByFixed(bArr), 11);
    }

    public String aesEncryptToString(byte[] bArr) throws SecurityKeyException {
        return Base64.encodeToString(aesEncrypt(bArr), 11);
    }

    public String decryptResponse(String str) throws SecurityKeyException {
        System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            throw new SecurityKeyException("invalid input params!", 103);
        }
        try {
            byte[] bArrAesDecrypt = aesDecrypt(l2.c.b(str));
            if (bArrAesDecrypt != null) {
                return new String(bArrAesDecrypt, "utf-8");
            }
            return null;
        } catch (SecurityKeyException e3) {
            if (e3.getErrorCode() == 184) {
                new String(g.g(str.getBytes()));
                this.mCipher.w();
                h.b();
            }
            throw e3;
        } catch (UnsupportedEncodingException e4) {
            i.k("SecurityKey", "Exception:" + e4.getMessage());
            throw new SecurityKeyException("unknown error!", 1000);
        }
    }

    public byte[] exportKey(int i3) throws SecurityKeyException {
        if (getCurCipherMode() != 2) {
            throw new SecurityKeyException("operate mode not match", 152);
        }
        SDKCipherNative.notice();
        return this.mCipher.e(i3);
    }

    public int getCurCipherMode() {
        return this.mCipher.w();
    }

    public byte[] getDataOfPackage(byte[] bArr) throws SecurityKeyException {
        if (bArr == null || bArr.length == 0) {
            i.k("SecurityKey", "Input invalid");
            throw new SecurityKeyException("invalid input params!", 103);
        }
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr);
        if (protocolPackageBuildProtocolPackage != null) {
            return protocolPackageBuildProtocolPackage.getCipherData();
        }
        i.k("SecurityKey", "Build package failed");
        return null;
    }

    public int getKeyVersion(int i3) {
        int iF = this.mCipher.f(i3);
        if (iF != 0) {
            return iF;
        }
        if ((getCurCipherMode() != 2 && getCurCipherMode() != 3) || this.mCipherMode != 1) {
            return iF;
        }
        this.mCipher = this.mSdkCipher;
        return this.mCipher.f(i3);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    public byte[] getProtocolHeader(int i3) {
        int i4 = 2;
        if (i3 != 5) {
            if (i3 != 6 && i3 != 10) {
                switch (i3) {
                    case 15:
                    case 16:
                    case 17:
                        i4 = 1;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
            }
        } else {
            i4 = 1;
        }
        if (getKeyVersion(i4) == 0) {
            return null;
        }
        try {
            return this.mCipher.s(i3);
        } catch (SecurityKeyException e3) {
            i.k("SecurityKey", "getProtocolHeader:" + e3.getErrorCode());
            return null;
        }
    }

    public String getSdkVersion() {
        return "seckeysdk-GDPR-V3.1.6-a820cf4";
    }

    public String getToken() {
        return this.mCipher.l();
    }

    public String getUniqueId() {
        return BuildConfig.FLAVOR;
    }

    public String getUpdateKeyParamsString() throws SecurityKeyException {
        if (getCurCipherMode() != 2 && getCurCipherMode() != 1) {
            throw new SecurityKeyException("operate mode not match", 152);
        }
        String strU = this.mCipher.u();
        if (strU == null) {
            return null;
        }
        return "ukparam=" + Base64.encodeToString(aesEncryptByFixed(strU.getBytes(Charset.forName("UTF-8"))), 11);
    }

    public boolean isAutoUpdateKey() {
        return this.mCipher.t();
    }

    public boolean isSupportTEE() {
        i2.a aVar = this.mPlatformCipher;
        return aVar != null && aVar.d();
    }

    protected boolean needSwitchSdkCipher(byte[] bArr) {
        if (this.mCipherMode != 1) {
            return false;
        }
        if (bArr != null) {
            try {
                if (ProtocolPackage.buildProtocolPackage(bArr).getCipherMode() == 2) {
                    return false;
                }
            } catch (SecurityKeyException e3) {
                i.e("SecurityKey", "Build Package Error: " + e3.getMessage(), e3);
                return false;
            }
        }
        if (!isPlatformCipher(this.mCipher)) {
            return false;
        }
        i.i("SecurityKey", "Switch to sdk cipher");
        this.mCipher = this.mSdkCipher;
        return true;
    }

    public boolean needUpdateKey() {
        if (isSupportTEE()) {
            return getTEEKeyVersion(1) == 0 || getTEEKeyVersion(2) == 0 || getTEEKeyVersion(4) == 0;
        }
        return false;
    }

    public byte[] rsaDecrypt(byte[] bArr) throws SecurityKeyException {
        try {
            try {
                preWork(bArr);
                return getProperCipher(ProtocolPackage.buildProtocolPackage(bArr), 2, "rsaDecrypt").n(bArr);
            } catch (SecurityKeyException e3) {
                if ((e3.getErrorCode() == 152 || !isSoftMode(bArr)) && !needSwitchSdkCipher(bArr)) {
                    e3.getErrorCode();
                    throw e3;
                }
                try {
                    return this.mSdkCipher.n(bArr);
                } catch (SecurityKeyException e4) {
                    e4.getErrorCode();
                    throw e4;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                getCurCipherMode();
                h.d();
            }
            throw th;
        }
    }

    public byte[] rsaDecryptString(String str) throws SecurityKeyException {
        try {
            return rsaDecrypt(Base64.decode(str, 11));
        } catch (IllegalArgumentException e3) {
            h.d();
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            throw new SecurityKeyException(e3.getMessage(), -12);
        }
    }

    public byte[] rsaEncrypt(byte[] bArr) throws SecurityKeyException {
        a aVar;
        try {
            try {
                preWork(null);
                aVar = this.mCipher;
                try {
                    return aVar.x(bArr);
                } catch (SecurityKeyException e3) {
                    e = e3;
                    if (!needSwitchSdkCipher(null) && (aVar == this.mCipher || !(this.mCipher instanceof com.vivo.seckeysdk.utils.a))) {
                        e.getErrorCode();
                        throw e;
                    }
                    return this.mCipher.x(bArr);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    getCurCipherMode();
                    h.d();
                }
                throw th;
            }
        } catch (SecurityKeyException e4) {
            e = e4;
            aVar = null;
        }
    }

    public String rsaEncryptToString(byte[] bArr) throws SecurityKeyException {
        return Base64.encodeToString(rsaEncrypt(bArr), 11);
    }

    public boolean setAutoUpdateKey(boolean z2) {
        return this.mCipher.z(z2);
    }

    public boolean setCipherMode(int i3) throws SecurityKeyException {
        if (!checkModeValid(i3)) {
            throw new SecurityKeyException("invalid input mode!", 103);
        }
        if (i3 == 4) {
            this.mCipher = this.mSdkCipher;
        } else if (c.F()) {
            this.mCipher = this.mPlatformCipher;
        }
        this.mCipherMode = i3;
        try {
            return this.mCipher.h(i3);
        } catch (SecurityKeyException e3) {
            if (i3 != 1 || this.mSdkCipher == null) {
                throw e3;
            }
            i.k("SecurityKey", "switch to SDK mode due to platform error: err: " + e3.getErrorCode() + "; msg: " + e3.getMessage());
            this.mCipher = this.mSdkCipher;
            return true;
        }
    }

    public byte[] sign(byte[] bArr) throws SecurityKeyException {
        a aVar;
        try {
            try {
                preWork(null);
                aVar = this.mCipher;
                try {
                    return aVar.q(bArr);
                } catch (SecurityKeyException e3) {
                    e = e3;
                    if (!needSwitchSdkCipher(null) && (aVar == this.mCipher || !(this.mCipher instanceof com.vivo.seckeysdk.utils.a))) {
                        e.getErrorCode();
                        throw e;
                    }
                    return this.mCipher.q(bArr);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    getCurCipherMode();
                    h.d();
                }
                throw th;
            }
        } catch (SecurityKeyException e4) {
            e = e4;
            aVar = null;
        }
    }

    public byte[] signFast(byte[] bArr) throws SecurityKeyException {
        a aVar;
        try {
            try {
                preWork(null);
                aVar = this.mCipher;
                try {
                    return aVar.c(bArr);
                } catch (SecurityKeyException e3) {
                    e = e3;
                    if (!needSwitchSdkCipher(null) && (aVar == this.mCipher || !(this.mCipher instanceof com.vivo.seckeysdk.utils.a))) {
                        e.getErrorCode();
                        throw e;
                    }
                    return this.mCipher.c(bArr);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    getCurCipherMode();
                    h.d();
                }
                throw th;
            }
        } catch (SecurityKeyException e4) {
            e = e4;
            aVar = null;
        }
    }

    public String signToString(byte[] bArr) throws SecurityKeyException {
        return Base64.encodeToString(sign(bArr), 11);
    }

    public boolean signatureVerify(byte[] bArr, byte[] bArr2) throws SecurityKeyException {
        try {
            try {
                preWork(bArr);
                return getProperCipher(ProtocolPackage.buildProtocolPackage(bArr2), 4, "signatureVerify").g(bArr, bArr2);
            } catch (SecurityKeyException e3) {
                if ((e3.getErrorCode() == 152 || !isSoftMode(bArr2)) && !needSwitchSdkCipher(bArr2)) {
                    e3.getErrorCode();
                    throw e3;
                }
                try {
                    return this.mSdkCipher.g(bArr, bArr2);
                } catch (SecurityKeyException e4) {
                    e4.getErrorCode();
                    throw e4;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                getCurCipherMode();
                h.d();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001c A[PHI: r5
  0x001c: PHI (r5v5 boolean) = (r5v3 boolean), (r5v8 boolean) binds: [B:17:0x0040, B:4:0x0013] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean signatureVerifyFast(byte[] bArr, byte[] bArr2) throws SecurityKeyException {
        boolean zP;
        try {
            try {
                preWork(bArr);
                zP = getProperCipher(ProtocolPackage.buildProtocolPackage(bArr2), 1, "signatureVerifyFast").p(bArr, bArr2);
                if (zP) {
                    getCurCipherMode();
                    h.d();
                } else {
                    getCurCipherMode();
                    h.d();
                }
            } catch (SecurityKeyException e3) {
                if ((e3.getErrorCode() == 152 || !isSoftMode(bArr2)) && !needSwitchSdkCipher(bArr2)) {
                    e3.getErrorCode();
                    throw e3;
                }
                try {
                    zP = this.mSdkCipher.p(bArr, bArr2);
                    if (!zP) {
                        getCurCipherMode();
                        h.d();
                    }
                } catch (SecurityKeyException e4) {
                    e4.getErrorCode();
                    throw e4;
                }
            }
            return zP;
        } catch (Throwable th) {
            if (0 == 0) {
                getCurCipherMode();
                h.d();
            } else {
                getCurCipherMode();
                h.d();
            }
            throw th;
        }
    }

    public boolean signatureVerifyString(byte[] bArr, String str) throws SecurityKeyException {
        try {
            return signatureVerify(bArr, Base64.decode(str, 11));
        } catch (IllegalArgumentException e3) {
            h.d();
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            throw new SecurityKeyException(e3.getMessage(), -12);
        }
    }

    public boolean storeKey(String str) throws SecurityKeyException {
        if (str == null || str.length() < 32) {
            i.k("SecurityKey", "storeKey: input keyData error");
            throw new SecurityKeyException("update key fail", 103);
        }
        if (isSupportTEE()) {
            return this.mPlatformCipher.k(str);
        }
        i.k("SecurityKey", "storeKey failed: not support TEE");
        throw new SecurityKeyException("operate mode not match", 152);
    }

    @Deprecated
    public byte[] toSecurityBytes(Map<String, String> map, int i3) throws SecurityKeyException {
        return toSecurityBytesCommon(map, i3, false);
    }

    public byte[] toSecurityBytesV2(Map<String, String> map, int i3) throws SecurityKeyException {
        return toSecurityBytesCommon(map, i3, true);
    }

    public Map<String, String> toSecurityJson(String str, int i3) throws SecurityKeyException {
        if (TextUtils.isEmpty(str)) {
            throw new SecurityKeyException("invalid input params!", 103);
        }
        HashMap map = null;
        try {
            if (i3 == 1) {
                byte[] bArrAesEncrypt = aesEncrypt(str.getBytes("utf-8"));
                if (bArrAesEncrypt != null && bArrAesEncrypt.length != 0) {
                    map = new HashMap();
                    map.put("jvq_param", Base64.encodeToString(bArrAesEncrypt, 11));
                }
            } else if (i3 == 2) {
                String strMap2Json = map2Json(json2Map(str), true);
                map = new HashMap();
                byte[] bArrSign = sign(strMap2Json.getBytes("utf-8"));
                if (bArrSign != null && bArrSign.length != 0) {
                    map.put("jvq_sign", Base64.encodeToString(bArrSign, 11));
                }
            } else if (i3 == 3) {
                byte[] bArrSign2 = sign(str.getBytes("utf-8"));
                byte[] bArrAesEncrypt2 = aesEncrypt(str.getBytes("utf-8"));
                if (bArrSign2 != null && bArrSign2.length != 0 && bArrAesEncrypt2 != null && bArrAesEncrypt2.length != 0) {
                    map = new HashMap();
                    map.put("jvq_sign", Base64.encodeToString(bArrSign2, 11));
                    map.put("jvq_param", Base64.encodeToString(bArrAesEncrypt2, 11));
                }
            } else {
                if (i3 != 4) {
                    if (i3 == 5) {
                        byte[] bArrSignFast = signFast(str.getBytes("utf-8"));
                        byte[] bArrAesEncrypt3 = aesEncrypt(str.getBytes("utf-8"));
                        if (bArrSignFast != null && bArrSignFast.length != 0 && bArrAesEncrypt3 != null && bArrAesEncrypt3.length != 0) {
                            map = new HashMap();
                            map.put("jvq_sign", Base64.encodeToString(bArrSignFast, 11));
                            map.put("jvq_param", Base64.encodeToString(bArrAesEncrypt3, 11));
                        }
                    }
                    return map;
                }
                String strMap2Json2 = map2Json(json2Map(str), true);
                map = new HashMap();
                byte[] bArrSignFast2 = signFast(strMap2Json2.getBytes("utf-8"));
                if (bArrSignFast2 != null && bArrSignFast2.length != 0) {
                    map.put("jvq_sign", Base64.encodeToString(bArrSignFast2, 11));
                }
            }
            return map;
        } catch (UnsupportedEncodingException e3) {
            i.k("SecurityKey", "Exception:" + e3.getMessage());
            throw new SecurityKeyException("unknown error!", 1000);
        }
    }

    @Deprecated
    public Map<String, String> toSecurityMap(Map<String, String> map, int i3) throws SecurityKeyException {
        return toSecurityMapCommon(map, i3, false);
    }

    public Map<String, String> toSecurityMapV2(Map<String, String> map, int i3) throws SecurityKeyException {
        return toSecurityMapCommon(map, i3, true);
    }

    @Deprecated
    public String toSecurityUrl(String str, int i3) throws SecurityKeyException {
        return toSecurityUrlCommon(str, i3, false);
    }

    public String toSecurityUrlV2(String str, int i3) throws SecurityKeyException {
        return toSecurityUrlCommon(str, i3, true);
    }

    public boolean updateKey() throws SecurityKeyException {
        SDKCipherNative.notice();
        return this.mCipher.b();
    }

    public boolean updateKeyFromBusinessServer(String str) throws SecurityKeyException {
        if (TextUtils.isEmpty(str)) {
            i.k("SecurityKey", "updateKeyFromBusinessServer rootUrl is empty");
            throw new SecurityKeyException("Invalied url:".concat(String.valueOf(str)), SecurityKeyException.SK_ERROR_INPUT_URL_INVALIED);
        }
        if (getCurCipherMode() != 2) {
            throw new SecurityKeyException("operate mode not match", 152);
        }
        SDKCipherNative.notice();
        String updateKeyParamsString = getUpdateKeyParamsString();
        StringBuilder sb = new StringBuilder(str);
        if (str.endsWith("?")) {
            sb.append(updateKeyParamsString);
        } else {
            sb.append("?");
            sb.append(updateKeyParamsString);
        }
        return this.mPlatformCipher.i(sb.toString());
    }

    public byte[] vivoBase64Decode(String str) throws SecurityKeyException {
        return l2.c.b(str);
    }

    public String vivoBase64Encode(byte[] bArr) {
        return l2.c.a(bArr);
    }

    public boolean needUpdateKey(SecurityKeyException securityKeyException) {
        return securityKeyException != null && securityKeyException.needUpdateKey();
    }

    public byte[] aesEncrypt(byte[] bArr, int i3) throws SecurityKeyException {
        return this.mSdkCipher.E(bArr, i3);
    }

    public byte[] rsaEncrypt(byte[] bArr, int i3) throws SecurityKeyException {
        return this.mSdkCipher.I(bArr, i3);
    }

    public byte[] sign(byte[] bArr, int i3) throws SecurityKeyException {
        return this.mSdkCipher.L(bArr, i3);
    }

    public byte[] aesEncrypt(byte[] bArr, String str) throws SecurityKeyException {
        try {
            try {
                SDKCipherNative.notice();
                int iB = b.b(this.mContext, str);
                if (iB != 2 && iB != 3 && iB != 1) {
                    return this.mSdkCipher.v(bArr);
                }
                if (c.F()) {
                    return this.mPlatformCipher.j(bArr, g.c("cipherMode", Integer.valueOf(iB)));
                }
                return this.mSdkCipher.v(bArr);
            } catch (SecurityKeyException e3) {
                if (c.F()) {
                    i.i("SecurityKey", "aesEncrypt securityLevelProtocol Switch to sdk cipher");
                    return this.mSdkCipher.v(bArr);
                }
                e3.getErrorCode();
                throw e3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                h.d();
            }
            throw th;
        }
    }

    public byte[] rsaEncrypt(byte[] bArr, String str) throws SecurityKeyException {
        try {
            try {
                SDKCipherNative.notice();
                int iB = b.b(this.mContext, str);
                if (iB != 2 && iB != 3 && iB != 1) {
                    return this.mSdkCipher.x(bArr);
                }
                if (c.F()) {
                    return this.mPlatformCipher.m(bArr, g.c("cipherMode", Integer.valueOf(iB)));
                }
                return this.mSdkCipher.x(bArr);
            } catch (SecurityKeyException e3) {
                if (c.F()) {
                    i.i("SecurityKey", "rsaEncrypt securityLevelProtocol Switch to sdk cipher");
                    return this.mSdkCipher.x(bArr);
                }
                e3.getErrorCode();
                throw e3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                h.d();
            }
            throw th;
        }
    }

    public byte[] sign(byte[] bArr, String str) throws SecurityKeyException {
        try {
            try {
                SDKCipherNative.notice();
                int iB = b.b(this.mContext, str);
                if (iB != 2 && iB != 3 && iB != 1) {
                    return this.mSdkCipher.q(bArr);
                }
                if (c.F()) {
                    return this.mPlatformCipher.r(bArr, g.c("cipherMode", Integer.valueOf(iB)));
                }
                return this.mSdkCipher.q(bArr);
            } catch (SecurityKeyException e3) {
                if (c.F()) {
                    i.i("SecurityKey", "sign securityLevelProtocol Switch to sdk cipher");
                    return this.mSdkCipher.q(bArr);
                }
                e3.getErrorCode();
                throw e3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                h.d();
            }
            throw th;
        }
    }
}
