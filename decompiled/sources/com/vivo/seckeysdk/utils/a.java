package com.vivo.seckeysdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import java.security.SecureRandom;
import java.util.Arrays;
import l2.c;
import l2.e;
import l2.g;
import l2.h;
import l2.i;

/* JADX INFO: compiled from: SDKCipher.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements l2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f4277b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f4278a = null;

    private a() {
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00dc A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000b, B:11:0x0028, B:14:0x0030, B:16:0x0036, B:33:0x00dc, B:17:0x003f, B:19:0x004f, B:20:0x0058, B:22:0x0073, B:23:0x008b, B:26:0x0095, B:28:0x00bc, B:29:0x00c4, B:30:0x00d2), top: B:42:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00e0  */
    public static synchronized a A(Context context) {
        if (f4277b != null) {
            return f4277b;
        }
        a aVar = new a();
        f4277b = aVar;
        aVar.f4278a = new b();
        f4277b.f4278a.b(context);
        a aVar2 = f4277b;
        b bVar = aVar2.f4278a;
        boolean z2 = true;
        if (bVar != null && bVar.d() != null) {
            SDKCipherNative.initClass = true;
            if (!SDKCipherNative.isLoadSoOK) {
                i.k("SecurityKey", "SDKCipherNative libvivoseckey.so is load failed, please check!");
            } else if (SDKCipherNative.init(aVar2.f4278a.d().getApplicationContext())) {
                NativeRequest nativeRequest = new NativeRequest();
                nativeRequest.setOperateType(SDKCipherNative.c.GET_UNIQUE_ID.ordinal());
                nativeRequest.setEncryptType(0);
                NativeResponse nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
                if (nativeResponseExecute.getErr() != 0) {
                    i.k("SecurityKey", "SDKCipherNative get fail:" + nativeResponseExecute.getErr());
                } else {
                    String str = BuildConfig.FLAVOR;
                    if (TextUtils.isEmpty(BuildConfig.FLAVOR)) {
                        str = "Unknown";
                    }
                    aVar2.f4278a.c(str);
                    aVar2.f4278a.e(nativeResponseExecute.getKeyVersion());
                    aVar2.f4278a.f(c.a(nativeResponseExecute.getPubicKeyHash()));
                    String packageName = aVar2.f4278a.d().getPackageName();
                    if (packageName == null) {
                        i.k("SecurityKey", "sdk cipher packageName fail");
                    } else {
                        aVar2.f4278a.j();
                        aVar2.f4278a.i(packageName);
                        aVar2.B();
                    }
                }
            } else {
                i.k("SecurityKey", "SDKCipherNative init fail!");
            }
            if (z2) {
                return null;
            }
            return f4277b;
        }
        i.k("SecurityKey", "Configure or context is null!");
        z2 = false;
        if (z2) {
            return null;
        }
        return f4277b;
    }

    private void B() {
        if (this.f4278a.g() != 4 && this.f4278a.g() != 1 && this.f4278a.g() != 3) {
            b bVar = this.f4278a;
            bVar.k(bVar.l());
        } else {
            if (f(1) == 1) {
                this.f4278a.k("jnisgmain@" + this.f4278a.l());
                return;
            }
            this.f4278a.k("jnisgmain_v2@" + this.f4278a.l());
        }
    }

    private static boolean C(int i3, int i4, NativeResponse nativeResponse) {
        if (nativeResponse == null) {
            if (i3 != 21322) {
                h.d();
            }
            i.k("SecurityKey", "Actiontype " + h.a(i3) + "return null");
            return i4 < 2;
        }
        if (i3 != 21322) {
            nativeResponse.getErr();
            h.d();
        }
        if (nativeResponse.getErr() == 0) {
            return false;
        }
        i.k("SecurityKey", "Actiontype " + h.a(i3) + "error: " + nativeResponse.getErr());
        return i4 < 2;
    }

    private byte[] F(byte[] bArr, int i3, int i4) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.ENCRYPT.ordinal());
        nativeRequest.setEncryptType(SDKCipherNative.b.AES.ordinal());
        nativeRequest.setData(bArr);
        nativeRequest.setKeyVersion(i4);
        int i5 = 0;
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i5++;
        } while (C(21312, i5, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            if (nativeResponseExecute.getOutput() != null) {
                return new ProtocolPackage(this.f4278a.h(nativeResponseExecute.getKeyVersion()), nativeResponseExecute.getKeyVersion(), i3, nativeResponseExecute.getOutput()).getbytes();
            }
            i.k("SecurityKey", "aesEncrypt output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        i.k("SecurityKey", "aesEncrypt fail:" + nativeResponseExecute.getErr());
        throw new SecurityKeyException(nativeResponseExecute.getErr());
    }

    private static void G() throws SecurityKeyException {
        if (SDKCipherNative.isLoadSoOK) {
            return;
        }
        i.k("SecurityKey", "SDKCipherNative libvivoseckey.so is load failed, please check!");
        throw new SecurityKeyException("libvivoseckey.so is load failed,please check!", SecurityKeyException.SK_ERROR_LOAD_SO_FAILED);
    }

    public static byte[] H(byte[] bArr) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        e eVarD = e.d(bArr);
        byte[] bArrB = eVarD.b();
        new String(bArrB);
        if (bArrB.length <= 15) {
            throw new SecurityKeyException("aes decrypt error", -10);
        }
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.DECRYPT.ordinal());
        nativeRequest.setEncryptType(SDKCipherNative.b.AES_FIXED.ordinal());
        nativeRequest.setKeyVersion(eVarD.c());
        byte[] bArrE = eVarD.e();
        byte[] bArr2 = new byte[bArrB.length + bArrE.length];
        int i3 = 0;
        System.arraycopy(bArrB, 0, bArr2, 0, bArrB.length);
        System.arraycopy(bArrE, 0, bArr2, bArrB.length, bArrE.length);
        nativeRequest.setData(bArr2);
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i3++;
        } while (C(21313, i3, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            if (nativeResponseExecute.getOutput() != null) {
                return nativeResponseExecute.getOutput();
            }
            i.k("SecurityKey", "aesDecrypt output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        i.k("SecurityKey", "aesDecrypt fail:" + nativeResponseExecute.getErr());
        throw new SecurityKeyException(nativeResponseExecute.getErr());
    }

    private byte[] J(byte[] bArr, int i3, int i4) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.ENCRYPT.ordinal());
        nativeRequest.setEncryptType(SDKCipherNative.b.AES.ordinal());
        nativeRequest.setData(bArr);
        nativeRequest.setKeyVersion(i3);
        int i5 = 0;
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i5++;
        } while (C(i4, i5, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            if (nativeResponseExecute.getOutput() != null) {
                return new ProtocolPackage(this.f4278a.h(nativeResponseExecute.getKeyVersion()), nativeResponseExecute.getKeyVersion(), 17, nativeResponseExecute.getOutput()).getbytes();
            }
            i.k("SecurityKey", "aesEncrypt output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        i.k("SecurityKey", "aesEncrypt fail:" + nativeResponseExecute.getErr());
        throw new SecurityKeyException(nativeResponseExecute.getErr());
    }

    private static byte[] K() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public final byte[] D(byte[] bArr) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.ENCRYPT.ordinal());
        nativeRequest.setEncryptType(SDKCipherNative.b.AES_FIXED.ordinal());
        byte[] bArrK = K();
        byte[] bArr2 = new byte[bArr.length + 16];
        int i3 = 0;
        System.arraycopy(bArrK, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        nativeRequest.setData(bArr2);
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i3++;
        } while (C(21312, i3, nativeResponseExecute));
        if (nativeResponseExecute.getErr() != 0) {
            i.k("SecurityKey", "aesEncryptByFixed fail:" + nativeResponseExecute.getErr());
            throw new SecurityKeyException(nativeResponseExecute.getErr());
        }
        if (nativeResponseExecute.getOutput() == null) {
            i.k("SecurityKey", "aesEncryptByFixed output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        e eVar = new e("fixedKey@" + this.f4278a.l(), 1, 16, nativeResponseExecute.getOutput());
        eVar.a(bArrK);
        return eVar.f();
    }

    public final byte[] E(byte[] bArr, int i3) throws SecurityKeyException {
        return F(bArr, 5, i3);
    }

    public final byte[] I(byte[] bArr, int i3) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.ENCRYPT.ordinal());
        nativeRequest.setEncryptType(SDKCipherNative.b.RSA.ordinal());
        nativeRequest.setData(bArr);
        nativeRequest.setKeyVersion(i3);
        int i4 = 0;
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i4++;
        } while (C(21314, i4, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            if (nativeResponseExecute.getOutput() != null) {
                return new ProtocolPackage(this.f4278a.h(nativeResponseExecute.getKeyVersion()), nativeResponseExecute.getKeyVersion(), 7, nativeResponseExecute.getOutput()).getbytes();
            }
            i.k("SecurityKey", "rsaEncrypt output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        i.k("SecurityKey", "rsaEncrypt fail:" + nativeResponseExecute.getErr());
        throw new SecurityKeyException(nativeResponseExecute.getErr());
    }

    public final byte[] L(byte[] bArr, int i3) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.SIGN.ordinal());
        int i4 = 0;
        nativeRequest.setEncryptType(0);
        nativeRequest.setData(bArr);
        nativeRequest.setKeyVersion(i3);
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i4++;
        } while (C(21316, i4, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            if (nativeResponseExecute.getOutput() != null) {
                return new ProtocolPackage(this.f4278a.h(nativeResponseExecute.getKeyVersion()), nativeResponseExecute.getKeyVersion(), 9, nativeResponseExecute.getOutput()).getbytes();
            }
            i.k("SecurityKey", "sign output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        i.k("SecurityKey", "sign fail:" + nativeResponseExecute.getErr());
        throw new SecurityKeyException(nativeResponseExecute.getErr());
    }

    @Override // l2.a
    public final boolean b() throws SecurityKeyException {
        return false;
    }

    @Override // l2.a
    public final byte[] c(byte[] bArr) throws SecurityKeyException {
        return J(g.d(bArr).getBytes(), this.f4278a.a(1), 21321);
    }

    @Override // l2.a
    public final byte[] e(int i3) throws SecurityKeyException {
        i.k("SecurityKey", "exportKey not supported");
        throw new SecurityKeyException("operate mode not match", 152);
    }

    @Override // l2.a
    public final int f(int i3) {
        return this.f4278a.a(i3);
    }

    @Override // l2.a
    public final boolean g(byte[] bArr, byte[] bArr2) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr2);
        int iA = this.f4278a.a(4);
        if (protocolPackageBuildProtocolPackage.getKeyVersion() > iA) {
            i.k("SecurityKey", "signatureVerify  not supported for pkg.KeyVersion(" + protocolPackageBuildProtocolPackage.getKeyVersion() + ") > sdk_currentKeyVersion(" + iA + ")");
            throw new SecurityKeyException("decrypt  keyversion  of the data is greater than the currently supported version", SecurityKeyException.SK_ERROR_UNSUPPORTED_DECRYPT_KEYVERION_VERSION);
        }
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.VERIFY.ordinal());
        nativeRequest.setEncryptType(0);
        nativeRequest.setKeyVersion(protocolPackageBuildProtocolPackage.getKeyVersion());
        byte[] bArr3 = new byte[bArr.length + protocolPackageBuildProtocolPackage.getData().length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(protocolPackageBuildProtocolPackage.getData(), 0, bArr3, bArr.length, protocolPackageBuildProtocolPackage.getData().length);
        nativeRequest.setData(bArr3);
        int i3 = 0;
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i3++;
        } while (C(21317, i3, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            return true;
        }
        i.k("SecurityKey", "sign fail:" + nativeResponseExecute.getErr());
        return false;
    }

    @Override // l2.a
    public final boolean h(int i3) {
        if (i3 == 3 || i3 == 4) {
            B();
            return true;
        }
        i.k("SecurityKey", "setCipherMode not supported:".concat(String.valueOf(i3)));
        return false;
    }

    @Override // l2.a
    public final String l() {
        return this.f4278a.m();
    }

    @Override // l2.a
    public final byte[] n(byte[] bArr) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr);
        int iA = this.f4278a.a(2);
        if (protocolPackageBuildProtocolPackage.getKeyVersion() > iA) {
            i.k("SecurityKey", "rsaDecrypt  not supported for pkg.KeyVersion(" + protocolPackageBuildProtocolPackage.getKeyVersion() + ") > sdk_currentKeyVersion(" + iA + ")");
            throw new SecurityKeyException("decrypt  keyversion  of the data is greater than the currently supported version", SecurityKeyException.SK_ERROR_UNSUPPORTED_DECRYPT_KEYVERION_VERSION);
        }
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.DECRYPT.ordinal());
        nativeRequest.setEncryptType(SDKCipherNative.b.RSA.ordinal());
        nativeRequest.setKeyVersion(protocolPackageBuildProtocolPackage.getKeyVersion());
        nativeRequest.setData(protocolPackageBuildProtocolPackage.getData());
        int i3 = 0;
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i3++;
        } while (C(21315, i3, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            if (nativeResponseExecute.getOutput() != null) {
                return nativeResponseExecute.getOutput();
            }
            i.k("SecurityKey", "rsaDecrypt output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        i.k("SecurityKey", "rsaDecrypt fail:" + nativeResponseExecute.getErr());
        throw new SecurityKeyException(nativeResponseExecute.getErr());
    }

    @Override // l2.a
    public final byte[] o(byte[] bArr) throws SecurityKeyException {
        NativeResponse nativeResponseExecute;
        G();
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr);
        int type = protocolPackageBuildProtocolPackage.getType();
        if (type != 5 && type != 3 && type != 4 && type != 17 && type != 15) {
            i.k("SecurityKey", "aesDecrypt decrypt type " + type + " is not supported");
            throw new SecurityKeyException("encrypt type of data is not supported", 154);
        }
        int iA = this.f4278a.a(1);
        if (protocolPackageBuildProtocolPackage.getKeyVersion() > iA) {
            i.k("SecurityKey", "aesDecrypt  not supported for pkg.KeyVersion(" + protocolPackageBuildProtocolPackage.getKeyVersion() + ") > sdk_currentKeyVersion(" + iA + ")");
            throw new SecurityKeyException("decrypt  keyversion  of the data is greater than the currently supported version", SecurityKeyException.SK_ERROR_UNSUPPORTED_DECRYPT_KEYVERION_VERSION);
        }
        NativeRequest nativeRequest = new NativeRequest();
        nativeRequest.setOperateType(SDKCipherNative.c.DECRYPT.ordinal());
        nativeRequest.setEncryptType(SDKCipherNative.b.AES.ordinal());
        nativeRequest.setKeyVersion(protocolPackageBuildProtocolPackage.getKeyVersion());
        nativeRequest.setData(protocolPackageBuildProtocolPackage.getData());
        int i3 = 0;
        do {
            nativeResponseExecute = SDKCipherNative.execute(nativeRequest);
            i3++;
        } while (C(21313, i3, nativeResponseExecute));
        if (nativeResponseExecute.getErr() == 0) {
            if (nativeResponseExecute.getOutput() != null) {
                return nativeResponseExecute.getOutput();
            }
            i.k("SecurityKey", "aesDecrypt output is null");
            throw new SecurityKeyException("unknown error!", -1000);
        }
        i.k("SecurityKey", "aesDecrypt fail:" + nativeResponseExecute.getErr());
        throw new SecurityKeyException(nativeResponseExecute.getErr());
    }

    @Override // l2.a
    public final boolean p(byte[] bArr, byte[] bArr2) throws SecurityKeyException {
        String strD = g.d(bArr);
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr2);
        int keyVersion = protocolPackageBuildProtocolPackage.getKeyVersion();
        return Arrays.equals(ProtocolPackage.buildProtocolPackage(J(strD.getBytes(), keyVersion, 21322)).getCipherData(), protocolPackageBuildProtocolPackage.getCipherData());
    }

    @Override // l2.a
    public final byte[] q(byte[] bArr) throws SecurityKeyException {
        return L(bArr, this.f4278a.a(2));
    }

    @Override // l2.a
    public final byte[] s(int i3) throws SecurityKeyException {
        int iA;
        G();
        if (i3 == 5) {
            iA = this.f4278a.a(1);
        } else if (i3 != 6 && i3 != 10) {
            switch (i3) {
                case 15:
                    iA = this.f4278a.a(1);
                    break;
                case 16:
                    iA = 1;
                    break;
                case 17:
                    iA = this.f4278a.a(1);
                    break;
                default:
                    iA = 0;
                    break;
            }
        } else {
            iA = this.f4278a.a(2);
        }
        if (i3 != 16) {
            return new ProtocolPackage(this.f4278a.m(), iA, i3, null).getHeaderbytes();
        }
        e eVar = new e("fixedKey@" + this.f4278a.l(), 1, i3, null);
        eVar.a(K());
        return eVar.g();
    }

    @Override // l2.a
    public final boolean t() {
        return false;
    }

    @Override // l2.a
    public final String u() throws SecurityKeyException {
        throw new SecurityKeyException("Not Supported.", SecurityKeyException.SK_ERROR_KEY_METHOD_NOT_SUPPORTED);
    }

    @Override // l2.a
    public final byte[] v(byte[] bArr) throws SecurityKeyException {
        return F(bArr, 5, this.f4278a.a(1));
    }

    @Override // l2.a
    public final int w() {
        return this.f4278a.g();
    }

    @Override // l2.a
    public final byte[] x(byte[] bArr) throws SecurityKeyException {
        return I(bArr, this.f4278a.a(2));
    }

    @Override // l2.a
    public final boolean z(boolean z2) {
        return false;
    }
}
