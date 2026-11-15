package s0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PoolingByteArrayOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f6208b;

    public k(d dVar, int i3) {
        this.f6208b = dVar;
        ((ByteArrayOutputStream) this).buf = dVar.a(Math.max(i3, 256));
    }

    private void a(int i3) {
        int i4 = ((ByteArrayOutputStream) this).count;
        if (i4 + i3 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] bArrA = this.f6208b.a((i4 + i3) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrA, 0, ((ByteArrayOutputStream) this).count);
        this.f6208b.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6208b.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f6208b.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i4) {
        a(i4);
        super.write(bArr, i3, i4);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i3) {
        a(1);
        super.write(i3);
    }
}
