package y2;

import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: compiled from: Token.java */
/* JADX INFO: loaded from: classes.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f6592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f6593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f6594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final byte f6595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f6596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f6597f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f6598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f6599h;

    y(int i3, int i4, int i5, int i6) {
        this.f6594c = i3;
        this.f6592a = i4;
        this.f6593b = i5;
        this.f6595d = (byte) i6;
        this.f6598g = i3 == 11 ? 1 : -3;
    }

    public boolean a() {
        int length;
        String str = this.f6597f;
        return str != null && (length = str.length()) > 0 && this.f6597f.charAt(length - 1) == '\'';
    }

    y b(String str) {
        this.f6597f = str;
        return this;
    }

    y c(double d3) {
        this.f6596e = d3;
        return this;
    }

    public String toString() {
        switch (this.f6594c) {
            case 9:
                return BuildConfig.FLAVOR + this.f6596e;
            case 10:
                return this.f6597f;
            case 11:
                return this.f6597f + '(' + this.f6598g + ')';
            default:
                return BuildConfig.FLAVOR + this.f6594c;
        }
    }
}
