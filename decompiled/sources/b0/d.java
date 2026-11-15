package b0;

import android.util.Base64;
import d0.i;
import java.util.List;

/* JADX INFO: compiled from: FontRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f2385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2386e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2387f;

    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2382a = (String) i.c(str);
        this.f2383b = (String) i.c(str2);
        this.f2384c = (String) i.c(str3);
        this.f2385d = (List) i.c(list);
        this.f2387f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f2385d;
    }

    public int c() {
        return this.f2386e;
    }

    String d() {
        return this.f2387f;
    }

    public String e() {
        return this.f2382a;
    }

    public String f() {
        return this.f2383b;
    }

    public String g() {
        return this.f2384c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2382a + ", mProviderPackage: " + this.f2383b + ", mQuery: " + this.f2384c + ", mCertificates:");
        for (int i3 = 0; i3 < this.f2385d.size(); i3++) {
            sb.append(" [");
            List<byte[]> list = this.f2385d.get(i3);
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i4), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2386e);
        return sb.toString();
    }
}
