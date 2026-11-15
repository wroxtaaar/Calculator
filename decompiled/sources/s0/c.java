package s0;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import r0.n;
import r0.r;
import r0.s;
import r0.t;
import r0.u;
import r0.v;

/* JADX INFO: compiled from: BasicNetwork.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements r0.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final boolean f6177d = v.f6056b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    protected final i f6178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f6179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final d f6180c;

    @Deprecated
    public c(i iVar) {
        this(iVar, new d(4096));
    }

    private static void b(String str, n<?> nVar, u uVar) throws u {
        r rVarW = nVar.w();
        int iY = nVar.y();
        try {
            rVarW.c(uVar);
            nVar.b(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iY)));
        } catch (u e3) {
            nVar.b(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iY)));
            throw e3;
        }
    }

    private static List<r0.g> c(List<r0.g> list, r0.b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<r0.g> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<r0.g> list2 = aVar.f5978h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (r0.g gVar : aVar.f5978h) {
                    if (!treeSet.contains(gVar.a())) {
                        arrayList.add(gVar);
                    }
                }
            }
        } else if (!aVar.f5977g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.f5977g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new r0.g(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private Map<String, String> d(r0.b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String str = aVar.f5972b;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j3 = aVar.f5974d;
        if (j3 > 0) {
            map.put("If-Modified-Since", g.a(j3));
        }
        return map;
    }

    private byte[] e(InputStream inputStream, int i3) throws s, IOException {
        k kVar = new k(this.f6180c, i3);
        try {
            if (inputStream == null) {
                throw new s();
            }
            byte[] bArrA = this.f6180c.a(1024);
            while (true) {
                int i4 = inputStream.read(bArrA);
                if (i4 == -1) {
                    break;
                }
                kVar.write(bArrA, 0, i4);
            }
            byte[] byteArray = kVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                v.e("Error occurred when closing InputStream", new Object[0]);
            }
            this.f6180c.b(bArrA);
            kVar.close();
            return byteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    v.e("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f6180c.b(null);
            kVar.close();
            throw th;
        }
    }

    private void f(long j3, n<?> nVar, byte[] bArr, int i3) {
        if (f6177d || j3 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = nVar;
            objArr[1] = Long.valueOf(j3);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(nVar.w().b());
            v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [s0.c] */
    @Override // r0.h
    public r0.k a(n<?> nVar) throws u {
        ?? r19;
        byte[] bArr;
        byte[] bArrE;
        ?? r3;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List<r0.g> listEmptyList = Collections.emptyList();
            h hVar = null;
            try {
                try {
                    h hVarB = this.f6179b.b(nVar, d(nVar.l()));
                    try {
                        int iD = hVarB.d();
                        List<r0.g> listC = hVarB.c();
                        if (iD == 304) {
                            r0.b.a aVarL = nVar.l();
                            return aVarL == null ? new r0.k(304, (byte[]) null, true, SystemClock.elapsedRealtime() - jElapsedRealtime, listC) : new r0.k(304, aVarL.f5971a, true, SystemClock.elapsedRealtime() - jElapsedRealtime, c(listC, aVarL));
                        }
                        try {
                            InputStream inputStreamA = hVarB.a();
                            if (inputStreamA != null) {
                                try {
                                    bArrE = e(inputStreamA, hVarB.b());
                                } catch (IOException e3) {
                                    e = e3;
                                    bArr = null;
                                    hVar = hVarB;
                                    r19 = listC;
                                }
                            } else {
                                bArrE = new byte[0];
                            }
                            byte[] bArr2 = bArrE;
                            try {
                                r3 = this;
                                r3.f(SystemClock.elapsedRealtime() - jElapsedRealtime, nVar, bArr2, iD);
                                try {
                                    if (iD < 200 || iD > 299) {
                                        throw new IOException();
                                    }
                                    return new r0.k(iD, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listC);
                                } catch (IOException e4) {
                                    e = e4;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                r3 = listC;
                            }
                            r19 = r3;
                            hVar = hVarB;
                            bArr = bArr2;
                        } catch (IOException e6) {
                            e = e6;
                            listEmptyList = listC;
                            r19 = listEmptyList;
                            bArr = null;
                            hVar = hVarB;
                        }
                        if (hVar == null) {
                            throw new r0.l(e);
                        }
                        int iD2 = hVar.d();
                        v.c("Unexpected response code %d for %s", Integer.valueOf(iD2), nVar.A());
                        if (bArr != null) {
                            r0.k kVar = new r0.k(iD2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, (List<r0.g>) r19);
                            if (iD2 == 401 || iD2 == 403) {
                                b("auth", nVar, new r0.a(kVar));
                            } else {
                                if (iD2 >= 400 && iD2 <= 499) {
                                    throw new r0.d(kVar);
                                }
                                if (iD2 < 500 || iD2 > 599) {
                                    throw new s(kVar);
                                }
                                if (!nVar.Q()) {
                                    throw new s(kVar);
                                }
                                b("server", nVar, new s(kVar));
                            }
                        } else {
                            b("network", nVar, new r0.j());
                        }
                    } catch (IOException e7) {
                        e = e7;
                    }
                } catch (MalformedURLException e8) {
                    throw new RuntimeException("Bad URL " + nVar.A(), e8);
                } catch (SocketTimeoutException unused) {
                    b("socket", nVar, new t());
                }
            } catch (IOException e9) {
                e = e9;
                r19 = listEmptyList;
                bArr = null;
            }
        }
    }

    @Deprecated
    public c(i iVar, d dVar) {
        this.f6178a = iVar;
        this.f6179b = new a(iVar);
        this.f6180c = dVar;
    }

    public c(b bVar) {
        this(bVar, new d(4096));
    }

    public c(b bVar, d dVar) {
        this.f6179b = bVar;
        this.f6178a = bVar;
        this.f6180c = dVar;
    }
}
