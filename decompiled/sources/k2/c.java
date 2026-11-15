package k2;

import com.vivo.seckeysdk.utils.SecurityKeyException;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: AbstractCryptoEntry.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f5198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f5199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f5203g;

    public c() {
        this.f5197a = true;
    }

    @Override // k2.a
    public String a() {
        return this.f5202f;
    }

    @Override // k2.a
    public int b() {
        return this.f5201e;
    }

    @Override // k2.a
    public int c() {
        return this.f5200d;
    }

    @Override // k2.a
    public byte[] d() {
        return this.f5199c;
    }

    @Override // k2.a
    public void e(byte[] bArr) {
        this.f5203g = bArr;
    }

    @Override // k2.a
    public void f(int i3) {
        this.f5200d = i3;
    }

    @Override // k2.a
    public void g(String str) {
        this.f5202f = str;
    }

    @Override // k2.a
    public b h() {
        return new h(this);
    }

    @Override // k2.a
    public byte[] i() {
        return this.f5203g;
    }

    @Override // k2.a
    public void j(int i3) {
        this.f5201e = i3;
    }

    @Override // k2.a
    public byte[] l() {
        return this.f5198b;
    }

    protected final int m() throws SecurityKeyException {
        byte[] bArr = new byte[2];
        System.arraycopy(this.f5198b, 10, bArr, 0, 2);
        return g.a(bArr);
    }

    protected final void n(byte[] bArr) {
        this.f5199c = bArr;
    }

    protected abstract void o() throws SecurityKeyException;

    protected final void p(byte[] bArr) {
        this.f5198b = bArr;
    }

    public boolean q() throws SecurityKeyException {
        if (!this.f5197a) {
            return true;
        }
        byte[] bArr = this.f5199c;
        if (bArr == null) {
            throw new SecurityKeyException("The haeder bytes must not be empty", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        byte[] bArr2 = new byte[8];
        byte[] bArr3 = new byte[bArr.length - 10];
        System.arraycopy(bArr, 2, bArr2, 0, 8);
        byte[] bArr4 = this.f5199c;
        System.arraycopy(bArr4, 10, bArr3, 0, bArr4.length - 10);
        long jD = g.d(bArr2);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr3);
        long value = crc32.getValue();
        if (jD == value) {
            return true;
        }
        throw new SecurityKeyException("头数据校验不成功，头部校验和为：" + jD + ",计算校验和为：" + value, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
    }

    public c(byte b3) {
        this.f5197a = true;
        this.f5197a = false;
    }

    public c(byte[] bArr) throws SecurityKeyException {
        this.f5197a = true;
        if (bArr != null && bArr.length != 0) {
            this.f5198b = bArr;
            this.f5197a = true;
            byte[] bArr2 = new byte[2];
            System.arraycopy(bArr, 0, bArr2, 0, 2);
            int iA = g.a(bArr2);
            if (iA > 0) {
                byte[] bArr3 = this.f5198b;
                if (bArr3.length >= iA) {
                    if (bArr3.length > iA) {
                        byte[] bArr4 = new byte[iA];
                        this.f5199c = bArr4;
                        System.arraycopy(bArr3, 0, bArr4, 0, iA);
                        byte[] bArr5 = this.f5198b;
                        byte[] bArr6 = new byte[bArr5.length - iA];
                        this.f5203g = bArr6;
                        System.arraycopy(bArr5, iA, bArr6, 0, bArr5.length - iA);
                    } else {
                        this.f5199c = bArr3;
                    }
                    q();
                    o();
                    return;
                }
                throw new SecurityKeyException("Header length great than entry length,entry length:" + this.f5198b.length + ",header length:" + iA, SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
            }
            throw new SecurityKeyException("Illegal header length:".concat(String.valueOf(iA)), SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
        }
        throw new SecurityKeyException("Entry body must not be empty", SecurityKeyException.SK_ERROR_CRYPTO_ENTRY_PARSE_FAILED);
    }
}
