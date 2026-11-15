package j2;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SecurityKeyConfigure.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5018b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f5024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f5027k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f5029m;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f5028l = Long.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5019c = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private i2.b f5030n = new a();

    public final i2.b a() {
        return this.f5030n;
    }

    public final void b(int i3) {
        this.f5019c = i3;
    }

    public final void c(long j3) {
        this.f5028l = j3;
    }

    public final void d(Context context) {
        this.f5018b = context;
    }

    public final void e(String str) {
        this.f5017a = str;
    }

    public final int f(int i3) {
        int i4;
        if (i3 == 1) {
            i4 = this.f5023g;
        } else if (i3 == 2) {
            i4 = this.f5023g >> 8;
        } else {
            if (i3 != 4) {
                return 0;
            }
            i4 = this.f5023g >> 16;
        }
        return i4 & 255;
    }

    public final String g() {
        return this.f5017a;
    }

    public final void h(long j3) {
        this.f5029m = j3;
    }

    public final void i(String str) {
        this.f5020d = str;
    }

    public final Context j() {
        return this.f5018b;
    }

    public final void k(int i3) {
        this.f5023g = i3;
    }

    public final void l(String str) {
        this.f5021e = str;
        this.f5022f = str;
        if (str == null || TextUtils.isEmpty(str)) {
            this.f5022f = "unknown";
        } else {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                this.f5022f = str.substring(iLastIndexOf + 1);
            }
        }
        if (this.f5022f.length() > 16) {
            this.f5022f = this.f5022f.substring(0, 15);
        }
    }

    public final int m() {
        return this.f5019c;
    }

    public final void n(int i3) {
        this.f5026j = i3;
    }

    public final void o(String str) {
        this.f5024h = str;
    }

    public final String p() {
        return this.f5020d;
    }

    public final void q(String str) {
        this.f5025i = str;
    }

    public final String r() {
        return this.f5021e;
    }

    public final String s() {
        return this.f5022f;
    }

    public final String t() {
        return this.f5024h;
    }

    public final int u() {
        return this.f5026j;
    }

    public final void v() {
        this.f5027k = 2;
    }

    public final int w() {
        return this.f5027k;
    }

    public final long x() {
        return this.f5028l;
    }

    public final long y() {
        return this.f5029m;
    }

    public final String z() {
        return this.f5025i;
    }
}
