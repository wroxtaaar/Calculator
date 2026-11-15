package y2;

/* JADX INFO: compiled from: ByteStack.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f6482a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6483b = 0;

    b() {
    }

    void a() {
        this.f6483b = 0;
    }

    byte b() {
        byte[] bArr = this.f6482a;
        int i3 = this.f6483b - 1;
        this.f6483b = i3;
        return bArr[i3];
    }

    void c(byte b3) {
        int i3 = this.f6483b;
        byte[] bArr = this.f6482a;
        if (i3 >= bArr.length) {
            byte[] bArr2 = new byte[bArr.length << 1];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f6482a = bArr2;
        }
        byte[] bArr3 = this.f6482a;
        int i4 = this.f6483b;
        this.f6483b = i4 + 1;
        bArr3[i4] = b3;
    }

    byte[] d() {
        int i3 = this.f6483b;
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f6482a, 0, bArr, 0, i3);
        return bArr;
    }
}
