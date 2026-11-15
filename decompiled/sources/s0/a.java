package s0;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;
import r0.n;

/* JADX INFO: compiled from: AdaptedHttpStack.java */
/* JADX INFO: loaded from: classes.dex */
class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f6176a;

    a(i iVar) {
        this.f6176a = iVar;
    }

    @Override // s0.b
    public h b(n<?> nVar, Map<String, String> map) throws r0.a, IOException {
        try {
            HttpResponse httpResponseA = this.f6176a.a(nVar, map);
            int statusCode = httpResponseA.getStatusLine().getStatusCode();
            Header[] allHeaders = httpResponseA.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new r0.g(header.getName(), header.getValue()));
            }
            if (httpResponseA.getEntity() == null) {
                return new h(statusCode, arrayList);
            }
            long contentLength = httpResponseA.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new h(statusCode, arrayList, (int) httpResponseA.getEntity().getContentLength(), httpResponseA.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e3) {
            throw new SocketTimeoutException(e3.getMessage());
        }
    }
}
