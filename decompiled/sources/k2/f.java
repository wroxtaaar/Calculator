package k2;

import com.vivo.seckeysdk.utils.SecurityKeyException;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: CryptoEntryV3.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f5204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f5205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f5206j;

    public f() {
    }

    @Override // k2.a
    public final byte[] k() throws SecurityKeyException {
        if (l() != null) {
            return l();
        }
        if (!i.a(a())) {
            throw new SecurityKeyException("keyToken must have value", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArrC = g.c((short) x());
        byte[] bytes = new byte[0];
        try {
            bytes = a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            l2.i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
        byte[] bArr = {(byte) bytes.length};
        byte[] bArrC2 = g.c((short) b());
        byte[] bArr2 = {(byte) c()};
        if (this.f5204h == null) {
            this.f5204h = new byte[0];
        }
        if (this.f5205i == null) {
            this.f5205i = new byte[0];
        }
        if (this.f5206j == null) {
            this.f5206j = new byte[0];
        }
        byte[] bArr3 = this.f5204h;
        if (bArr3.length >= 256) {
            throw new SecurityKeyException("extend1.length cannot >=256", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArr4 = this.f5205i;
        if (bArr4.length >= 256) {
            throw new SecurityKeyException("extend2.length cannot >=256", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArr5 = this.f5206j;
        if (bArr5.length >= 256) {
            throw new SecurityKeyException("extend3.length cannot >=256", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArr6 = {(byte) bArr3.length};
        byte[] bArr7 = {(byte) bArr4.length};
        byte[] bArr8 = {(byte) bArr5.length};
        int length = bytes.length + 13 + 2 + 1 + 1 + bArr3.length + 1 + bArr4.length + 1 + bArr5.length;
        byte[] bArr9 = new byte[length];
        System.arraycopy(g.c((short) length), 0, bArr9, 0, 2);
        System.arraycopy(bArrC, 0, bArr9, 10, 2);
        System.arraycopy(bArr, 0, bArr9, 12, 1);
        System.arraycopy(bytes, 0, bArr9, 13, bytes.length);
        System.arraycopy(bArrC2, 0, bArr9, bytes.length + 13, 2);
        System.arraycopy(bArr2, 0, bArr9, bytes.length + 15, 1);
        System.arraycopy(bArr6, 0, bArr9, bytes.length + 16, 1);
        byte[] bArr10 = this.f5204h;
        System.arraycopy(bArr10, 0, bArr9, bytes.length + 17, bArr10.length);
        System.arraycopy(bArr7, 0, bArr9, bytes.length + 17 + this.f5204h.length, 1);
        byte[] bArr11 = this.f5205i;
        System.arraycopy(bArr11, 0, bArr9, bytes.length + 18 + this.f5204h.length, bArr11.length);
        System.arraycopy(bArr8, 0, bArr9, bytes.length + 18 + this.f5204h.length + this.f5205i.length, 1);
        byte[] bArr12 = this.f5206j;
        System.arraycopy(bArr12, 0, bArr9, bytes.length + 19 + this.f5204h.length + this.f5205i.length, bArr12.length);
        int i3 = length - 10;
        byte[] bArr13 = new byte[i3];
        System.arraycopy(bArr9, 10, bArr13, 0, i3);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr13);
        System.arraycopy(g.b(crc32.getValue()), 0, bArr9, 2, 8);
        n(bArr9);
        byte[] bArrI = i();
        if (bArrI != null) {
            byte[] bArr14 = new byte[bArrI.length + length];
            System.arraycopy(bArr9, 0, bArr14, 0, length);
            System.arraycopy(bArrI, 0, bArr14, length, bArrI.length);
            bArr9 = bArr14;
        }
        p(bArr9);
        return bArr9;
    }

    @Override // k2.c
    protected final void o() throws SecurityKeyException {
        int iM = m();
        if (iM != x()) {
            throw new SecurityKeyException("Unsupported version of:" + iM + " for this Header + " + f.class, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
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
        Integer numValueOf2 = Integer.valueOf(g.a(new byte[]{bArrD[numValueOf.intValue() + 16]}));
        byte[] bArr4 = new byte[numValueOf2.intValue()];
        if (bArrD.length < numValueOf.intValue() + 17) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        System.arraycopy(bArrD, numValueOf.intValue() + 17, bArr4, 0, numValueOf2.intValue());
        this.f5204h = bArr4;
        Integer numValueOf3 = Integer.valueOf(g.a(new byte[]{bArrD[numValueOf.intValue() + 17 + numValueOf2.intValue()]}));
        byte[] bArr5 = new byte[numValueOf3.intValue()];
        if (bArrD.length < numValueOf.intValue() + 18 + numValueOf2.intValue()) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        System.arraycopy(bArrD, numValueOf.intValue() + 18 + numValueOf2.intValue(), bArr5, 0, numValueOf3.intValue());
        this.f5205i = bArr5;
        Integer numValueOf4 = Integer.valueOf(g.a(new byte[]{bArrD[numValueOf.intValue() + 18 + numValueOf2.intValue() + numValueOf3.intValue()]}));
        byte[] bArr6 = new byte[numValueOf4.intValue()];
        if (bArrD.length < numValueOf.intValue() + 19 + numValueOf2.intValue() + numValueOf3.intValue()) {
            throw new SecurityKeyException("crypto header problem", 150);
        }
        System.arraycopy(bArrD, numValueOf.intValue() + 19 + numValueOf2.intValue() + numValueOf3.intValue(), bArr6, 0, numValueOf4.intValue());
        this.f5206j = bArr6;
    }

    public final void r(byte[] bArr) {
        this.f5204h = bArr;
    }

    public final byte[] s() {
        return this.f5204h;
    }

    public final void t(byte[] bArr) {
        this.f5205i = bArr;
    }

    public final byte[] u() {
        return this.f5205i;
    }

    public final void v(byte[] bArr) {
        this.f5206j = bArr;
    }

    public final byte[] w() {
        return this.f5206j;
    }

    public final int x() {
        return 3;
    }

    public f(byte b3) {
        super((byte) 0);
    }

    public f(byte[] bArr) throws SecurityKeyException {
        super(bArr);
    }
}
