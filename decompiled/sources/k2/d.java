package k2;

import com.vivo.seckeysdk.utils.SecurityKeyException;

/* JADX INFO: compiled from: CryptoEntryFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static a a(int i3) throws SecurityKeyException {
        if (i3 == 1) {
            return new e((byte) 0);
        }
        if (i3 == 3) {
            return new f((byte) 0);
        }
        throw new SecurityKeyException("Unsupported protocol version for CryptoEntry:" + i3 + ": (This data is illegal ciphertext, please check!)", SecurityKeyException.SK_ERROR_UNSUPPORTED_PROTOCOL_VERSION);
    }

    public static a b(byte[] bArr) throws SecurityKeyException {
        byte[] bArr2 = new byte[2];
        if (bArr.length < 12) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        System.arraycopy(bArr, 10, bArr2, 0, 2);
        int iA = g.a(bArr2);
        if (iA == 1) {
            return new e(bArr);
        }
        if (iA == 3) {
            return new f(bArr);
        }
        throw new SecurityKeyException("Unsupported protocol version for CryptoEntry:" + iA + ": (This data is illegal ciphertext, please check!)", SecurityKeyException.SK_ERROR_UNSUPPORTED_PROTOCOL_VERSION);
    }
}
