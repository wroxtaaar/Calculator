package j2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.seckeysdk.BuildConfig;
import com.vivo.services.cipher.utils.VivoSecurityKeyResult;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import l2.f;
import l2.i;

/* JADX INFO: compiled from: SecurityKeyProxy.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements i2.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f4982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4983d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f4985f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4981b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4984e = BuildConfig.FLAVOR;

    /* JADX INFO: renamed from: j2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SecurityKeyProxy.java */
    public enum EnumC0072a {
        NONE,
        AES,
        RSA,
        END
    }

    /* JADX INFO: compiled from: SecurityKeyProxy.java */
    public enum b {
        NONE(0),
        EK(1),
        SK(2),
        VK(4),
        END(5);


        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4997b;

        b(int i3) {
            this.f4997b = i3;
        }

        final int a() {
            return this.f4997b;
        }
    }

    /* JADX INFO: compiled from: SecurityKeyProxy.java */
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
        EXPORT_KEY,
        END
    }

    public a() {
        this.f4982c = null;
        this.f4983d = BuildConfig.FLAVOR;
        this.f4985f = null;
        if (Build.VERSION.SDK_INT > 27) {
            this.f4983d = "com.vivo.services.cipher.utils.SecurityKeyProxy";
            this.f4982c = f.b("com.vivo.services.cipher.utils.SecurityKeyProxy");
        } else {
            this.f4983d = "android.security.KeyStore";
            Object objE = f.e("android.security.KeyStore", "getInstance", new Class[0], new Object[0]);
            this.f4982c = objE;
            this.f4985f = f.c(this.f4983d, objE, "mBinder");
        }
    }

    private j2.b m(int i3, int i4, int i5, int i6, String str, int i7, String str2, byte[] bArr) {
        Object objD;
        if (Build.VERSION.SDK_INT <= 27) {
            Object obj = this.f4985f;
            Class cls = Integer.TYPE;
            objD = f.d("android.security.IKeystoreService", "vivoSecurityKeyOperate", obj, new Class[]{cls, cls, cls, cls, String.class, cls, String.class, String.class, byte[].class}, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, Integer.valueOf(i7), null, str2, bArr});
        } else {
            String str3 = this.f4983d;
            Object obj2 = this.f4982c;
            Class cls2 = Integer.TYPE;
            objD = f.d(str3, "vivoSecurityKeyOperate", obj2, new Class[]{cls2, cls2, cls2, cls2, String.class, cls2, String.class, String.class, byte[].class}, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, Integer.valueOf(i7), null, str2, bArr});
        }
        return p(objD);
    }

    private j2.b n(int i3, int i4, int i5, int i6, byte[] bArr) {
        String strR = r();
        String strQ = q();
        if (bArr != null && bArr.length != 0 && ((i4 != EnumC0072a.AES.ordinal() || bArr.length <= 204816) && (i4 != EnumC0072a.RSA.ordinal() || bArr.length <= 256))) {
            return m(i3, c.DECRYPT.ordinal(), i4, i5, strQ, i6, strR, bArr);
        }
        i.k("SecurityKeyProxy", "input data error");
        return new j2.b(-201);
    }

    private j2.b o(int i3, int i4, int i5, byte[] bArr) {
        String strR = r();
        String strQ = q();
        if (bArr != null && bArr.length != 0 && ((i4 != EnumC0072a.AES.ordinal() || bArr.length <= 204800) && (i4 != EnumC0072a.RSA.ordinal() || bArr.length <= 245))) {
            return m(i3, c.ENCRYPT.ordinal(), i4, i5, strQ, 0, strR, bArr);
        }
        i.k("SecurityKeyProxy", "input data error");
        return new j2.b(-201);
    }

    private static j2.b p(Object obj) {
        j2.b bVar;
        if (obj instanceof VivoSecurityKeyResult) {
            VivoSecurityKeyResult vivoSecurityKeyResult = (VivoSecurityKeyResult) obj;
            bVar = new j2.b(vivoSecurityKeyResult.resultCode, vivoSecurityKeyResult.operateData, vivoSecurityKeyResult.keyVersion, vivoSecurityKeyResult.uniqueId, vivoSecurityKeyResult.publicKeyHash, vivoSecurityKeyResult.needUpdateKey);
        } else if (obj instanceof android.security.keymaster.VivoSecurityKeyResult) {
            android.security.keymaster.VivoSecurityKeyResult vivoSecurityKeyResult2 = (android.security.keymaster.VivoSecurityKeyResult) obj;
            bVar = new j2.b(vivoSecurityKeyResult2.resultCode, vivoSecurityKeyResult2.operateData, vivoSecurityKeyResult2.keyVersion, vivoSecurityKeyResult2.uniqueId, vivoSecurityKeyResult2.publicKeyHash, vivoSecurityKeyResult2.needUpdateKey);
        } else {
            bVar = null;
        }
        return bVar == null ? new j2.b(-1000) : bVar;
    }

    private String q() {
        String str = this.f4981b;
        if (str != null) {
            return str;
        }
        Context context = this.f4980a;
        if (context != null) {
            return context.getPackageName();
        }
        return null;
    }

    private String r() {
        PublicKey publicKey;
        Context context = this.f4980a;
        if (context == null) {
            i.k("SecurityKeyProxy", "SecurityKeyContext is null");
            return null;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = this.f4980a.getPackageManager();
        if (packageName != null && packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr.length > 0 && (publicKey = (PublicKey) f.a(Signature.class, "getPublicKey", signatureArr[0], new Class[0], new Object[0])) != null) {
                        return new String(Base64.encode(publicKey.getEncoded(), 0));
                    }
                }
            } catch (PackageManager.NameNotFoundException e3) {
                i.e("SecurityKeyProxy", "NameNotFoundException", e3);
            } catch (Exception e4) {
                i.e("SecurityKeyProxy", "Exception", e4);
            }
        }
        return null;
    }

    private String s() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String strR = r();
            if (strR == null) {
                return BuildConfig.FLAVOR;
            }
            messageDigest.update(strR.getBytes());
            return l2.c.a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e3) {
            i.e("SecurityKeyProxy", "Error: " + e3.getMessage(), e3);
            return BuildConfig.FLAVOR;
        } catch (Exception e4) {
            i.e("SecurityKeyProxy", "Error: " + e4.getMessage(), e4);
            return BuildConfig.FLAVOR;
        }
    }

    @Override // i2.b
    public final j2.b a(int i3, byte[] bArr) {
        return o(i3, EnumC0072a.RSA.ordinal(), b.VK.a(), bArr);
    }

    @Override // i2.b
    public final String b() {
        Object objD = f.d(this.f4983d, "vivoKeystoreGetUniqueID", this.f4982c, new Class[0], new Object[0]);
        return objD == null ? BuildConfig.FLAVOR : (String) objD;
    }

    @Override // i2.b
    public final j2.b c(int i3, byte[] bArr) {
        String strR = r();
        String strQ = q();
        if (bArr != null && bArr.length != 0 && bArr.length <= 204800) {
            return m(i3, c.SIGN.ordinal(), 0, b.SK.ordinal(), strQ, 0, strR, bArr);
        }
        i.k("SecurityKeyProxy", "input data error");
        return new j2.b(-201);
    }

    @Override // i2.b
    public final j2.b d(int i3, int i4, byte[] bArr) {
        String strR = r();
        String strQ = q();
        if (bArr != null) {
            return m(i3, c.UPDATE.ordinal(), 0, i4, strQ, 0, strR, bArr);
        }
        i.k("SecurityKeyProxy", "input data error");
        return new j2.b(-201);
    }

    @Override // i2.b
    public final String e() {
        if (TextUtils.isEmpty(this.f4984e)) {
            this.f4984e = s();
        }
        return this.f4984e;
    }

    @Override // i2.b
    public final j2.b f(int i3, int i4, byte[] bArr) {
        return n(i3, EnumC0072a.RSA.ordinal(), b.SK.a(), i4, bArr);
    }

    @Override // i2.b
    public final j2.b g(int i3, byte[] bArr) {
        return o(i3, EnumC0072a.AES.ordinal(), b.EK.a(), bArr);
    }

    @Override // i2.b
    public final j2.b h(int i3, int i4) {
        String strR = r();
        return m(i3, c.EXPORT_KEY.ordinal(), 0, i4, q(), 0, strR, null);
    }

    @Override // i2.b
    public final j2.b i(int i3, int i4, byte[] bArr) {
        String strR = r();
        String strQ = q();
        if (bArr != null && bArr.length != 0 && bArr.length <= 205056) {
            return m(i3, c.VERIFY.ordinal(), 0, b.VK.ordinal(), strQ, i4, strR, bArr);
        }
        i.k("SecurityKeyProxy", "input data error");
        return new j2.b(-201);
    }

    @Override // i2.b
    public final boolean j(Context context, String str) {
        if (context == null) {
            return false;
        }
        this.f4980a = context;
        String packageName = context.getPackageName();
        this.f4981b = packageName;
        if (!packageName.equals("android")) {
            return true;
        }
        if (str == null) {
            return false;
        }
        this.f4981b += "." + str;
        return true;
    }

    @Override // i2.b
    public final j2.b k(int i3, int i4, byte[] bArr) {
        return n(i3, EnumC0072a.AES.ordinal(), b.EK.a(), i4, bArr);
    }

    @Override // i2.b
    public final j2.b l(int i3) {
        String strR = r();
        return m(i3, c.GET_UNIQUE_ID.ordinal(), 0, 0, q(), 0, strR, null);
    }
}
