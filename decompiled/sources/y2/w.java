package y2;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

/* JADX INFO: compiled from: Symbols.java */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final v[] f6582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static v f6583f = new v(null, 0.0d, false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f6584g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6585a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Hashtable f6586b = new Hashtable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashSet<v> f6587c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Stack<HashSet<v>> f6588d = new Stack<>();

    static {
        Vector vector = new Vector();
        for (byte b3 : a0.f6481c) {
            vector.addElement(v.c(a0.f6479a[b3], b3));
        }
        String[] strArr = {"x", "y", "z"};
        for (byte b4 = 0; b4 < 3; b4 = (byte) (b4 + 1)) {
            vector.addElement(v.b(strArr[b4], b4));
        }
        vector.addElement(new v("pi", 3.141592653589793d, true));
        vector.addElement(new v("π", 3.141592653589793d, true));
        vector.addElement(new v("e", 2.718281828459045d, true));
        vector.addElement(new v("Infinity", Double.POSITIVE_INFINITY, true));
        vector.addElement(new v("infinity", Double.POSITIVE_INFINITY, true));
        vector.addElement(new v("Inf", Double.POSITIVE_INFINITY, true));
        vector.addElement(new v("inf", Double.POSITIVE_INFINITY, true));
        vector.addElement(new v("∞", Double.POSITIVE_INFINITY, true));
        vector.addElement(new v("NaN", Double.NaN, true));
        vector.addElement(new v("nan", Double.NaN, true));
        vector.addElement(new v("i", 0.0d, 1.0d, true));
        vector.addElement(new v("j", 0.0d, 1.0d, false));
        v[] vVarArr = new v[vector.size()];
        f6582e = vVarArr;
        vector.copyInto(vVarArr);
        f6584g = new String[]{"log(x)=ln(x)*0.43429448190325182765", "log10(x)=log(x)", "lg(x)=log(x)", "log2(x)=ln(x)*1.4426950408889634074", "lb(x)=log2(x)", "log(base,x)=ln(x)/ln(base)", "gamma(x)=(x-1)!", "deg=0.017453292519943295", "indeg=57.29577951308232", "sind(x)=sin(x deg)", "cosd(x)=cos(x deg)", "tand(x)=tan(x deg)", "asind(x)=asin(x) indeg", "acosd(x)=acos(x) indeg", "atand(x)=atan(x) indeg", "tg(x)=tan(x)", "tgd(x)=tand(x)"};
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
    
        throw new java.lang.Error(com.vivo.seckeysdk.BuildConfig.FLAVOR + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public w() {
        /*
            r4 = this;
            r4.<init>()
            y2.d r0 = new y2.d
            r0.<init>()
            r4.f6585a = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r4.f6586b = r0
            r0 = 0
            r4.f6587c = r0
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r4.f6588d = r0
            r0 = 0
            r1 = r0
        L1d:
            y2.v[] r2 = y2.w.f6582e
            int r3 = r2.length
            if (r1 >= r3) goto L2a
            r2 = r2[r1]
            r4.a(r2)
            int r1 = r1 + 1
            goto L1d
        L2a:
            java.lang.String[] r1 = y2.w.f6584g     // Catch: y2.x -> L3c
            int r2 = r1.length     // Catch: y2.x -> L3c
            if (r0 >= r2) goto L3b
            r1 = r1[r0]     // Catch: y2.x -> L3c
            y2.n r1 = r4.c(r1)     // Catch: y2.x -> L3c
            r4.f(r1)     // Catch: y2.x -> L3c
            int r0 = r0 + 1
            goto L2a
        L3b:
            return
        L3c:
            r4 = move-exception
            java.lang.Error r0 = new java.lang.Error
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.w.<init>():void");
    }

    void a(v vVar) {
        v vVarD = (v) this.f6586b.put(vVar, vVar);
        if (vVarD != null && vVarD.f6581g) {
            this.f6586b.put(vVarD, vVarD);
            return;
        }
        if (this.f6587c == null) {
            this.f6587c = new HashSet<>();
        }
        if (this.f6587c.contains(vVar)) {
            return;
        }
        HashSet<v> hashSet = this.f6587c;
        if (vVarD == null) {
            vVarD = v.d(vVar);
        }
        hashSet.add(vVarD);
    }

    void b(String[] strArr) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            a(v.b(strArr[i3], i3));
        }
    }

    public synchronized n c(String str) throws x {
        return this.f6585a.c(this, str);
    }

    public synchronized void d(String str, double d3) {
        a(new v(str, d3, 0.0d, false));
    }

    public synchronized void e(String str, m mVar) {
        if (mVar instanceof f) {
            d(str, mVar.c());
        } else {
            a(new v(str, mVar));
        }
    }

    public synchronized void f(n nVar) {
        String str = nVar.f6531b;
        if (str != null) {
            e(str, nVar.f6530a);
        }
    }

    public synchronized double g(String str) throws x {
        return this.f6585a.b(this, str).c();
    }

    synchronized v h(String str, int i3) {
        return (v) this.f6586b.get(f6583f.e(str, i3));
    }

    public synchronized void i() {
        HashSet<v> hashSet = this.f6587c;
        if (hashSet != null) {
            for (v vVar : hashSet) {
                if (vVar.a()) {
                    this.f6586b.remove(vVar);
                } else {
                    this.f6586b.put(vVar, vVar);
                }
            }
        }
        this.f6587c = this.f6588d.pop();
    }

    public synchronized void j() {
        this.f6588d.push(this.f6587c);
        this.f6587c = null;
    }
}
