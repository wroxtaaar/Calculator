package s0;

import android.support.annotation.VisibleForTesting;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import r0.n;

/* JADX INFO: compiled from: HurlStack.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends s0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f6205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f6206b;

    /* JADX INFO: compiled from: HurlStack.java */
    static class a extends FilterInputStream {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HttpURLConnection f6207b;

        a(HttpURLConnection httpURLConnection) {
            super(j.i(httpURLConnection));
            this.f6207b = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f6207b.disconnect();
        }
    }

    /* JADX INFO: compiled from: HurlStack.java */
    public interface b {
        String a(String str);
    }

    public j() {
        this(null);
    }

    private static void d(HttpURLConnection httpURLConnection, n<?> nVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", nVar.k());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private static void e(HttpURLConnection httpURLConnection, n<?> nVar) throws r0.a, IOException {
        byte[] bArrJ = nVar.j();
        if (bArrJ != null) {
            d(httpURLConnection, nVar, bArrJ);
        }
    }

    @VisibleForTesting
    static List<r0.g> f(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new r0.g(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private static boolean h(int i3, int i4) {
        return (i3 == 4 || (100 <= i4 && i4 < 200) || i4 == 204 || i4 == 304) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream i(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection j(URL url, n<?> nVar) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionG = g(url);
        int iY = nVar.y();
        httpURLConnectionG.setConnectTimeout(iY);
        httpURLConnectionG.setReadTimeout(iY);
        httpURLConnectionG.setUseCaches(false);
        httpURLConnectionG.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f6206b) != null) {
            ((HttpsURLConnection) httpURLConnectionG).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionG;
    }

    static void k(HttpURLConnection httpURLConnection, n<?> nVar) throws r0.a, IOException {
        switch (nVar.o()) {
            case -1:
                byte[] bArrR = nVar.r();
                if (bArrR != null) {
                    httpURLConnection.setRequestMethod("POST");
                    d(httpURLConnection, nVar, bArrR);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                e(httpURLConnection, nVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                e(httpURLConnection, nVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                e(httpURLConnection, nVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // s0.b
    public h b(n<?> nVar, Map<String, String> map) throws r0.a, IOException {
        String strA = nVar.A();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(nVar.n());
        b bVar = this.f6205a;
        if (bVar != null) {
            String strA2 = bVar.a(strA);
            if (strA2 == null) {
                throw new IOException("URL blocked by rewriter: " + strA);
            }
            strA = strA2;
        }
        HttpURLConnection httpURLConnectionJ = j(new URL(strA), nVar);
        try {
            for (String str : map2.keySet()) {
                httpURLConnectionJ.setRequestProperty(str, (String) map2.get(str));
            }
            k(httpURLConnectionJ, nVar);
            int responseCode = httpURLConnectionJ.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (h(nVar.o(), responseCode)) {
                return new h(responseCode, f(httpURLConnectionJ.getHeaderFields()), httpURLConnectionJ.getContentLength(), new a(httpURLConnectionJ));
            }
            h hVar = new h(responseCode, f(httpURLConnectionJ.getHeaderFields()));
            httpURLConnectionJ.disconnect();
            return hVar;
        } catch (Throwable th) {
            if (0 == 0) {
                httpURLConnectionJ.disconnect();
            }
            throw th;
        }
    }

    protected HttpURLConnection g(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public j(b bVar) {
        this(bVar, null);
    }

    public j(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f6205a = bVar;
        this.f6206b = sSLSocketFactory;
    }
}
