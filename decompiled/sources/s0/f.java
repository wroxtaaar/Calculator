package s0;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import r0.n;

/* JADX INFO: compiled from: HttpClientStack.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HttpClient f6200a;

    /* JADX INFO: compiled from: HttpClientStack.java */
    public static final class a extends HttpEntityEnclosingRequestBase {
        public a(String str) {
            setURI(URI.create(str));
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return "PATCH";
        }
    }

    public f(HttpClient httpClient) {
        this.f6200a = httpClient;
    }

    static HttpUriRequest b(n<?> nVar, Map<String, String> map) throws r0.a {
        switch (nVar.o()) {
            case -1:
                byte[] bArrR = nVar.r();
                if (bArrR == null) {
                    return new HttpGet(nVar.A());
                }
                HttpPost httpPost = new HttpPost(nVar.A());
                httpPost.addHeader("Content-Type", nVar.s());
                httpPost.setEntity(new ByteArrayEntity(bArrR));
                return httpPost;
            case 0:
                return new HttpGet(nVar.A());
            case 1:
                HttpPost httpPost2 = new HttpPost(nVar.A());
                httpPost2.addHeader("Content-Type", nVar.k());
                d(httpPost2, nVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(nVar.A());
                httpPut.addHeader("Content-Type", nVar.k());
                d(httpPut, nVar);
                return httpPut;
            case 3:
                return new HttpDelete(nVar.A());
            case 4:
                return new HttpHead(nVar.A());
            case 5:
                return new HttpOptions(nVar.A());
            case 6:
                return new HttpTrace(nVar.A());
            case 7:
                a aVar = new a(nVar.A());
                aVar.addHeader("Content-Type", nVar.k());
                d(aVar, nVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void d(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, n<?> nVar) throws r0.a {
        byte[] bArrJ = nVar.j();
        if (bArrJ != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(bArrJ));
        }
    }

    private static void e(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    @Override // s0.i
    public HttpResponse a(n<?> nVar, Map<String, String> map) throws r0.a, IOException {
        HttpUriRequest httpUriRequestB = b(nVar, map);
        e(httpUriRequestB, map);
        e(httpUriRequestB, nVar.n());
        c(httpUriRequestB);
        HttpParams params = httpUriRequestB.getParams();
        int iY = nVar.y();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, iY);
        return this.f6200a.execute(httpUriRequestB);
    }

    protected void c(HttpUriRequest httpUriRequest) throws IOException {
    }
}
