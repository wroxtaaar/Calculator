package s0;

import com.vivo.seckeysdk.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import r0.n;

/* JADX INFO: compiled from: BaseHttpStack.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements i {
    @Override // s0.i
    @Deprecated
    public final HttpResponse a(n<?> nVar, Map<String, String> map) throws r0.a, IOException {
        h hVarB = b(nVar, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), hVarB.d(), BuildConfig.FLAVOR));
        ArrayList arrayList = new ArrayList();
        for (r0.g gVar : hVarB.c()) {
            arrayList.add(new BasicHeader(gVar.a(), gVar.b()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream inputStreamA = hVarB.a();
        if (inputStreamA != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStreamA);
            basicHttpEntity.setContentLength(hVarB.b());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }

    public abstract h b(n<?> nVar, Map<String, String> map) throws r0.a, IOException;
}
