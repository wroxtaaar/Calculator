package d2;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import o1.e;
import o1.r;
import r0.k;
import r0.m;
import r0.n;
import r0.p;
import s0.g;
import vivo.util.VLog;

/* JADX INFO: compiled from: GsonRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> extends n<T> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f4507r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private c<T> f4508s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private e f4509t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Class<T> f4510u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f4511v;

    public a(int i3, String str, String str2, Class<T> cls, c<T> cVar) {
        super(i3, str, cVar);
        this.f4507r = new Object();
        this.f4511v = str2;
        this.f4509t = new e();
        this.f4510u = cls;
        this.f4508s = cVar;
    }

    @Override // r0.n
    protected p<T> H(k kVar) {
        try {
            String str = new String(kVar.f6008b, g.d(kVar.f6009c, "utf-8"));
            VLog.d("BBKCalculator/GsonRequest", "parseNetworkResponse,jsonString:" + str);
            String strA = b.g().a(str);
            VLog.d("BBKCalculator/GsonRequest", "parseNetworkResponse,decodeString:" + strA);
            return p.c(this.f4509t.h(strA, this.f4510u), g.c(kVar));
        } catch (UnsupportedEncodingException e3) {
            return p.a(new m(e3));
        } catch (r e4) {
            return p.a(new m(e4));
        }
    }

    @Override // r0.n
    public void c() {
        super.c();
        synchronized (this.f4507r) {
            this.f4508s = null;
        }
    }

    @Override // r0.n
    protected void f(T t3) {
        c<T> cVar;
        synchronized (this.f4507r) {
            cVar = this.f4508s;
        }
        if (cVar != null) {
            cVar.a(t3);
        }
    }

    @Override // r0.n
    public byte[] j() throws r0.a {
        VLog.d("BBKCalculator/GsonRequest", "getBody:" + this.f4511v);
        return this.f4511v.getBytes();
    }

    @Override // r0.n
    public String k() {
        return "text/plain;charset=UTF-8";
    }

    @Override // r0.n
    public Map<String, String> n() throws r0.a {
        HashMap map = new HashMap(1);
        map.put("Connection", "close");
        return map;
    }

    @Override // r0.n
    public r0.r w() {
        return new r0.e(7500, 1, 1.0f);
    }
}
