package r0;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class n<T> implements Comparable<n<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v.a f6013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f6017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    private p.a f6018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f6019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private o f6020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f6022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f6023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private r f6025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private r0.b.a f6026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Object f6027p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @GuardedBy("mLock")
    private b f6028q;

    /* JADX INFO: compiled from: Request.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f6030c;

        a(String str, long j3) {
            this.f6029b = str;
            this.f6030c = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f6013b.a(this.f6029b, this.f6030c);
            n.this.f6013b.b(n.this.toString());
        }
    }

    /* JADX INFO: compiled from: Request.java */
    interface b {
        void a(n<?> nVar, p<?> pVar);

        void b(n<?> nVar);
    }

    /* JADX INFO: compiled from: Request.java */
    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public n(int i3, String str, @Nullable p.a aVar) {
        this.f6013b = v.a.f6058c ? new v.a() : null;
        this.f6017f = new Object();
        this.f6021j = true;
        this.f6022k = false;
        this.f6023l = false;
        this.f6024m = false;
        this.f6026o = null;
        this.f6014c = i3;
        this.f6015d = str;
        this.f6018g = aVar;
        L(new e());
        this.f6016e = h(str);
    }

    private byte[] g(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("Encoding not supported: " + str, e3);
        }
    }

    private static int h(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public String A() {
        return this.f6015d;
    }

    public boolean B() {
        boolean z2;
        synchronized (this.f6017f) {
            z2 = this.f6023l;
        }
        return z2;
    }

    public boolean C() {
        boolean z2;
        synchronized (this.f6017f) {
            z2 = this.f6022k;
        }
        return z2;
    }

    public void D() {
        synchronized (this.f6017f) {
            this.f6023l = true;
        }
    }

    void E() {
        b bVar;
        synchronized (this.f6017f) {
            bVar = this.f6028q;
        }
        if (bVar != null) {
            bVar.b(this);
        }
    }

    void F(p<?> pVar) {
        b bVar;
        synchronized (this.f6017f) {
            bVar = this.f6028q;
        }
        if (bVar != null) {
            bVar.a(this, pVar);
        }
    }

    protected u G(u uVar) {
        return uVar;
    }

    protected abstract p<T> H(k kVar);

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> I(r0.b.a aVar) {
        this.f6026o = aVar;
        return this;
    }

    void J(b bVar) {
        synchronized (this.f6017f) {
            this.f6028q = bVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> K(o oVar) {
        this.f6020i = oVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> L(r rVar) {
        this.f6025n = rVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> M(int i3) {
        this.f6019h = Integer.valueOf(i3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> N(boolean z2) {
        this.f6021j = z2;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> O(Object obj) {
        this.f6027p = obj;
        return this;
    }

    public final boolean P() {
        return this.f6021j;
    }

    public final boolean Q() {
        return this.f6024m;
    }

    public void b(String str) {
        if (v.a.f6058c) {
            this.f6013b.a(str, Thread.currentThread().getId());
        }
    }

    @CallSuper
    public void c() {
        synchronized (this.f6017f) {
            this.f6022k = true;
            this.f6018g = null;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(n<T> nVar) {
        int iOrdinal;
        int iOrdinal2;
        c cVarV = v();
        c cVarV2 = nVar.v();
        if (cVarV == cVarV2) {
            iOrdinal = this.f6019h.intValue();
            iOrdinal2 = nVar.f6019h.intValue();
        } else {
            iOrdinal = cVarV2.ordinal();
            iOrdinal2 = cVarV.ordinal();
        }
        return iOrdinal - iOrdinal2;
    }

    public void e(u uVar) {
        p.a aVar;
        synchronized (this.f6017f) {
            aVar = this.f6018g;
        }
        if (aVar != null) {
            aVar.b(uVar);
        }
    }

    protected abstract void f(T t3);

    void i(String str) {
        o oVar = this.f6020i;
        if (oVar != null) {
            oVar.d(this);
        }
        if (v.a.f6058c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
            } else {
                this.f6013b.a(str, id);
                this.f6013b.b(toString());
            }
        }
    }

    public byte[] j() throws r0.a {
        Map<String, String> mapP = p();
        if (mapP == null || mapP.size() <= 0) {
            return null;
        }
        return g(mapP, q());
    }

    public String k() {
        return "application/x-www-form-urlencoded; charset=" + q();
    }

    public r0.b.a l() {
        return this.f6026o;
    }

    public String m() {
        String strA = A();
        int iO = o();
        if (iO == 0 || iO == -1) {
            return strA;
        }
        return Integer.toString(iO) + '-' + strA;
    }

    public Map<String, String> n() throws r0.a {
        return Collections.emptyMap();
    }

    public int o() {
        return this.f6014c;
    }

    protected Map<String, String> p() throws r0.a {
        return null;
    }

    protected String q() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] r() throws r0.a {
        Map<String, String> mapT = t();
        if (mapT == null || mapT.size() <= 0) {
            return null;
        }
        return g(mapT, u());
    }

    @Deprecated
    public String s() {
        return k();
    }

    @Deprecated
    protected Map<String, String> t() throws r0.a {
        return p();
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(z());
        StringBuilder sb = new StringBuilder();
        sb.append(C() ? "[X] " : "[ ] ");
        sb.append(A());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(v());
        sb.append(" ");
        sb.append(this.f6019h);
        return sb.toString();
    }

    @Deprecated
    protected String u() {
        return q();
    }

    public c v() {
        return c.NORMAL;
    }

    public r w() {
        return this.f6025n;
    }

    public Object x() {
        return this.f6027p;
    }

    public final int y() {
        return w().a();
    }

    public int z() {
        return this.f6016e;
    }
}
