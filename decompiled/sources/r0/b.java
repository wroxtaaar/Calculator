package r0;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: compiled from: Cache.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f5971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f5973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f5975e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f5976f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f5977g = Collections.emptyMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<g> f5978h;

        public boolean a() {
            return this.f5975e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f5976f < System.currentTimeMillis();
        }
    }

    void a();

    void b(String str, a aVar);

    a c(String str);
}
