package s0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: ByteArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Comparator<byte[]> f6181e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<byte[]> f6182a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<byte[]> f6183b = new ArrayList(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6184c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6185d;

    /* JADX INFO: compiled from: ByteArrayPool.java */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public d(int i3) {
        this.f6185d = i3;
    }

    private synchronized void c() {
        while (this.f6184c > this.f6185d) {
            byte[] bArrRemove = this.f6182a.remove(0);
            this.f6183b.remove(bArrRemove);
            this.f6184c -= bArrRemove.length;
        }
    }

    public synchronized byte[] a(int i3) {
        for (int i4 = 0; i4 < this.f6183b.size(); i4++) {
            byte[] bArr = this.f6183b.get(i4);
            if (bArr.length >= i3) {
                this.f6184c -= bArr.length;
                this.f6183b.remove(i4);
                this.f6182a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f6185d) {
                this.f6182a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f6183b, bArr, f6181e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f6183b.add(iBinarySearch, bArr);
                this.f6184c += bArr.length;
                c();
            }
        }
    }
}
