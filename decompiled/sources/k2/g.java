package k2;

import com.vivo.seckeysdk.utils.SecurityKeyException;

/* JADX INFO: compiled from: NumericUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static int a(byte[] bArr) throws SecurityKeyException {
        if (bArr.length == 0) {
            throw new SecurityKeyException("Data received  must have value", 1000);
        }
        if (bArr.length > 4) {
            throw new SecurityKeyException("Size of data received  must less than 4", 1000);
        }
        int i3 = 0;
        for (byte b3 : bArr) {
            i3 = (i3 << 8) | (b3 & 255);
        }
        return i3;
    }

    public static byte[] b(long j3) {
        return new byte[]{(byte) (j3 >>> 56), (byte) (j3 >>> 48), (byte) (j3 >>> 40), (byte) (j3 >>> 32), (byte) (j3 >>> 24), (byte) (j3 >>> 16), (byte) (j3 >>> 8), (byte) j3};
    }

    public static byte[] c(short s3) {
        return new byte[]{(byte) (s3 >>> 8), (byte) s3};
    }

    public static long d(byte[] bArr) throws SecurityKeyException {
        long j3 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j3 = (j3 << 8) | ((long) (bArr[i3] & 255));
        }
        return j3;
    }
}
