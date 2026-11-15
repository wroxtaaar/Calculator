package k2;

import com.vivo.seckeysdk.utils.SecurityKeyException;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: CryptoEntryV1.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends c {
    public e(byte b3) {
        super((byte) 0);
    }

    @Override // k2.a
    public final byte[] k() throws SecurityKeyException {
        if (l() != null) {
            return l();
        }
        if (!i.a(a())) {
            throw new SecurityKeyException("keyToken must have value", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArrC = g.c((short) r());
        byte[] bytes = new byte[0];
        try {
            bytes = a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            l2.i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
        byte[] bArr = {(byte) bytes.length};
        byte[] bArrC2 = g.c((short) b());
        byte[] bArr2 = {(byte) c()};
        int length = bytes.length + 13 + 2 + 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(g.c((short) length), 0, bArr3, 0, 2);
        System.arraycopy(bArrC, 0, bArr3, 10, 2);
        System.arraycopy(bArr, 0, bArr3, 12, 1);
        System.arraycopy(bytes, 0, bArr3, 13, bytes.length);
        System.arraycopy(bArrC2, 0, bArr3, bytes.length + 13, 2);
        System.arraycopy(bArr2, 0, bArr3, bytes.length + 15, 1);
        int i3 = length - 10;
        byte[] bArr4 = new byte[i3];
        System.arraycopy(bArr3, 10, bArr4, 0, i3);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr4);
        System.arraycopy(g.b(crc32.getValue()), 0, bArr3, 2, 8);
        n(bArr3);
        byte[] bArrI = i();
        if (bArrI != null) {
            byte[] bArr5 = new byte[bArrI.length + length];
            System.arraycopy(bArr3, 0, bArr5, 0, length);
            System.arraycopy(bArrI, 0, bArr5, length, bArrI.length);
            bArr3 = bArr5;
        }
        p(bArr3);
        return bArr3;
    }

    @Override // k2.c
    protected final void o() throws SecurityKeyException {
        int iM = m();
        if (iM != r()) {
            throw new SecurityKeyException("Unsupported version of:" + iM + " for this Header + " + e.class, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArrD = d();
        if (bArrD.length < 13) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        Integer numValueOf = Integer.valueOf(g.a(new byte[]{bArrD[12]}));
        byte[] bArr = new byte[numValueOf.intValue()];
        if (bArrD.length < numValueOf.intValue() + 13) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        System.arraycopy(bArrD, 13, bArr, 0, numValueOf.intValue());
        try {
            g(new String(bArr, "UTF-8"));
        } catch (UnsupportedEncodingException e3) {
            l2.i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
        byte[] bArr2 = new byte[2];
        if (bArrD.length < numValueOf.intValue() + 13 + 2) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        System.arraycopy(bArrD, numValueOf.intValue() + 13, bArr2, 0, 2);
        j(g.a(bArr2));
        byte[] bArr3 = new byte[1];
        if (bArrD.length < numValueOf.intValue() + 15 + 1) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        System.arraycopy(bArrD, numValueOf.intValue() + 15, bArr3, 0, 1);
        f(g.a(bArr3));
    }

    public final int r() {
        return 1;
    }

    public e(byte[] bArr) throws SecurityKeyException {
        super(bArr);
    }
}
