package s0;

import android.os.SystemClock;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r0.v;

/* JADX INFO: compiled from: DiskBasedCache.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f6186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f6188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6189d;

    public e(File file, int i3) {
        this.f6186a = new LinkedHashMap(16, 0.75f, true);
        this.f6187b = 0L;
        this.f6188c = file;
        this.f6189d = i3;
    }

    private String g(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void h(int i3) {
        long j3 = i3;
        if (this.f6187b + j3 < this.f6189d) {
            return;
        }
        if (v.f6056b) {
            v.e("Pruning old cache entries.", new Object[0]);
        }
        long j4 = this.f6187b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f6186a.entrySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (f(value.f6191b).delete()) {
                this.f6187b -= value.f6190a;
            } else {
                String str = value.f6191b;
                v.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
            }
            it.remove();
            i4++;
            if (this.f6187b + j3 < this.f6189d * 0.9f) {
                break;
            } else {
                j3 = j3;
            }
        }
        if (v.f6056b) {
            v.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i4), Long.valueOf(this.f6187b - j4), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    private void i(String str, a aVar) {
        if (this.f6186a.containsKey(str)) {
            this.f6187b += aVar.f6190a - this.f6186a.get(str).f6190a;
        } else {
            this.f6187b += aVar.f6190a;
        }
        this.f6186a.put(str, aVar);
    }

    private static int j(InputStream inputStream) throws IOException {
        int i3 = inputStream.read();
        if (i3 != -1) {
            return i3;
        }
        throw new EOFException();
    }

    static List<r0.g> k(b bVar) throws IOException {
        int iL = l(bVar);
        if (iL < 0) {
            throw new IOException("readHeaderList size=" + iL);
        }
        List<r0.g> listEmptyList = iL == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i3 = 0; i3 < iL; i3++) {
            listEmptyList.add(new r0.g(n(bVar).intern(), n(bVar).intern()));
        }
        return listEmptyList;
    }

    static int l(InputStream inputStream) throws IOException {
        return (j(inputStream) << 24) | (j(inputStream) << 0) | 0 | (j(inputStream) << 8) | (j(inputStream) << 16);
    }

    static long m(InputStream inputStream) throws IOException {
        return ((((long) j(inputStream)) & 255) << 0) | 0 | ((((long) j(inputStream)) & 255) << 8) | ((((long) j(inputStream)) & 255) << 16) | ((((long) j(inputStream)) & 255) << 24) | ((((long) j(inputStream)) & 255) << 32) | ((((long) j(inputStream)) & 255) << 40) | ((((long) j(inputStream)) & 255) << 48) | ((255 & ((long) j(inputStream))) << 56);
    }

    static String n(b bVar) throws IOException {
        return new String(q(bVar, m(bVar)), "UTF-8");
    }

    private void p(String str) {
        a aVarRemove = this.f6186a.remove(str);
        if (aVarRemove != null) {
            this.f6187b -= aVarRemove.f6190a;
        }
    }

    static byte[] q(b bVar, long j3) throws IOException {
        long jA = bVar.a();
        if (j3 >= 0 && j3 <= jA) {
            int i3 = (int) j3;
            if (i3 == j3) {
                byte[] bArr = new byte[i3];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j3 + ", maxLength=" + jA);
    }

    static void r(List<r0.g> list, OutputStream outputStream) throws IOException {
        if (list == null) {
            s(outputStream, 0);
            return;
        }
        s(outputStream, list.size());
        for (r0.g gVar : list) {
            u(outputStream, gVar.a());
            u(outputStream, gVar.b());
        }
    }

    static void s(OutputStream outputStream, int i3) throws IOException {
        outputStream.write((i3 >> 0) & 255);
        outputStream.write((i3 >> 8) & 255);
        outputStream.write((i3 >> 16) & 255);
        outputStream.write((i3 >> 24) & 255);
    }

    static void t(OutputStream outputStream, long j3) throws IOException {
        outputStream.write((byte) (j3 >>> 0));
        outputStream.write((byte) (j3 >>> 8));
        outputStream.write((byte) (j3 >>> 16));
        outputStream.write((byte) (j3 >>> 24));
        outputStream.write((byte) (j3 >>> 32));
        outputStream.write((byte) (j3 >>> 40));
        outputStream.write((byte) (j3 >>> 48));
        outputStream.write((byte) (j3 >>> 56));
    }

    static void u(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        t(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // r0.b
    public synchronized void a() {
        if (!this.f6188c.exists()) {
            if (!this.f6188c.mkdirs()) {
                v.c("Unable to create cache dir %s", this.f6188c.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.f6188c.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                long length = file.length();
                b bVar = new b(new BufferedInputStream(d(file)), length);
                try {
                    a aVarB = a.b(bVar);
                    aVarB.f6190a = length;
                    i(aVarB.f6191b, aVarB);
                    bVar.close();
                } catch (Throwable th) {
                    bVar.close();
                    throw th;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    @Override // r0.b
    public synchronized void b(String str, r0.b.a aVar) {
        h(aVar.f5971a.length);
        File fileF = f(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(e(fileF));
            a aVar2 = new a(str, aVar);
            if (!aVar2.d(bufferedOutputStream)) {
                bufferedOutputStream.close();
                v.b("Failed to write header for %s", fileF.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(aVar.f5971a);
            bufferedOutputStream.close();
            i(str, aVar2);
        } catch (IOException unused) {
            if (fileF.delete()) {
                return;
            }
            v.b("Could not clean up file %s", fileF.getAbsolutePath());
        }
    }

    @Override // r0.b
    public synchronized r0.b.a c(String str) {
        a aVar = this.f6186a.get(str);
        if (aVar == null) {
            return null;
        }
        File fileF = f(str);
        try {
            b bVar = new b(new BufferedInputStream(d(fileF)), fileF.length());
            try {
                a aVarB = a.b(bVar);
                if (TextUtils.equals(str, aVarB.f6191b)) {
                    r0.b.a aVarC = aVar.c(q(bVar, bVar.a()));
                    bVar.close();
                    return aVarC;
                }
                v.b("%s: key=%s, found=%s", fileF.getAbsolutePath(), str, aVarB.f6191b);
                p(str);
                bVar.close();
                return null;
            } catch (Throwable th) {
                bVar.close();
                throw th;
            }
        } catch (IOException e3) {
            v.b("%s: %s", fileF.getAbsolutePath(), e3.toString());
            o(str);
            return null;
        }
    }

    InputStream d(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    OutputStream e(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    public File f(String str) {
        return new File(this.f6188c, g(str));
    }

    public synchronized void o(String str) {
        boolean zDelete = f(str).delete();
        p(str);
        if (!zDelete) {
            v.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
        }
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    @VisibleForTesting
    static class b extends FilterInputStream {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f6199c;

        b(InputStream inputStream, long j3) {
            super(inputStream);
            this.f6198b = j3;
        }

        long a() {
            return this.f6198b - this.f6199c;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i3 = super.read();
            if (i3 != -1) {
                this.f6199c++;
            }
            return i3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = super.read(bArr, i3, i4);
            if (i5 != -1) {
                this.f6199c += (long) i5;
            }
            return i5;
        }
    }

    public e(File file) {
        this(file, 5242880);
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f6190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f6191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f6192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f6193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f6194e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f6195f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f6196g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final List<r0.g> f6197h;

        private a(String str, String str2, long j3, long j4, long j5, long j6, List<r0.g> list) {
            this.f6191b = str;
            this.f6192c = BuildConfig.FLAVOR.equals(str2) ? null : str2;
            this.f6193d = j3;
            this.f6194e = j4;
            this.f6195f = j5;
            this.f6196g = j6;
            this.f6197h = list;
        }

        private static List<r0.g> a(r0.b.a aVar) {
            List<r0.g> list = aVar.f5978h;
            return list != null ? list : g.f(aVar.f5977g);
        }

        static a b(b bVar) throws IOException {
            if (e.l(bVar) == 538247942) {
                return new a(e.n(bVar), e.n(bVar), e.m(bVar), e.m(bVar), e.m(bVar), e.m(bVar), e.k(bVar));
            }
            throw new IOException();
        }

        r0.b.a c(byte[] bArr) {
            r0.b.a aVar = new r0.b.a();
            aVar.f5971a = bArr;
            aVar.f5972b = this.f6192c;
            aVar.f5973c = this.f6193d;
            aVar.f5974d = this.f6194e;
            aVar.f5975e = this.f6195f;
            aVar.f5976f = this.f6196g;
            aVar.f5977g = g.g(this.f6197h);
            aVar.f5978h = Collections.unmodifiableList(this.f6197h);
            return aVar;
        }

        boolean d(OutputStream outputStream) {
            try {
                e.s(outputStream, 538247942);
                e.u(outputStream, this.f6191b);
                String str = this.f6192c;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                e.u(outputStream, str);
                e.t(outputStream, this.f6193d);
                e.t(outputStream, this.f6194e);
                e.t(outputStream, this.f6195f);
                e.t(outputStream, this.f6196g);
                e.r(this.f6197h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e3) {
                v.b("%s", e3.toString());
                return false;
            }
        }

        a(String str, r0.b.a aVar) {
            this(str, aVar.f5972b, aVar.f5973c, aVar.f5974d, aVar.f5975e, aVar.f5976f, a(aVar));
            this.f6190a = aVar.f5971a.length;
        }
    }
}
