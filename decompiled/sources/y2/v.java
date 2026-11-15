package y2;

/* JADX INFO: compiled from: Symbol.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    byte f6577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    m f6578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f6579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    double f6580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f6581g;

    private v(String str, int i3, byte b3, boolean z2, int i4) {
        this.f6581g = false;
        e(str, i3);
        this.f6577c = b3;
        this.f6581g = z2;
    }

    static v b(String str, int i3) {
        return new v(str, -3, (byte) (i3 + 38), false, 0);
    }

    static v c(String str, int i3) {
        return new v(str, a0.f6480b[i3], (byte) i3, true, 0);
    }

    static v d(v vVar) {
        return new v(vVar.f6575a, vVar.f6576b, (byte) 0, false, 0);
    }

    boolean a() {
        return this.f6577c == 0 && this.f6578d == null && this.f6579e == 0.0d && this.f6580f == 0.0d;
    }

    v e(String str, int i3) {
        this.f6575a = str;
        this.f6576b = i3;
        return this;
    }

    public boolean equals(Object obj) {
        v vVar = (v) obj;
        return this.f6575a.equals(vVar.f6575a) && this.f6576b == vVar.f6576b;
    }

    public int hashCode() {
        return this.f6575a.hashCode() + this.f6576b;
    }

    public String toString() {
        return "Symbol '" + this.f6575a + "' arity " + this.f6576b + " val " + this.f6579e + " op " + ((int) this.f6577c);
    }

    v(String str, m mVar) {
        this.f6581g = false;
        e(str, mVar.a());
        this.f6578d = mVar;
    }

    v(String str, double d3, boolean z2) {
        this(str, d3, 0.0d, z2);
    }

    v(String str, double d3, double d4, boolean z2) {
        this.f6581g = false;
        e(str, -3);
        this.f6579e = d3;
        this.f6580f = d4;
        this.f6581g = z2;
    }
}
