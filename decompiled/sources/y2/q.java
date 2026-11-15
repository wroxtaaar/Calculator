package y2;

import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: compiled from: Lexer.java */
/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final y f6534d = new y(1, 4, 2, 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final y f6535e = new y(2, 4, 2, 4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final y f6536f = new y(3, 5, 2, 5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final y f6537g = new y(4, 5, 2, 6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final y f6538h = new y(5, 5, 2, 7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final y f6539i = new y(6, 6, 1, 9);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final y f6540j = new y(7, 7, 3, 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final y f6541k = new y(8, 8, 4, 11);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final y f6542l = new y(17, 9, 4, 12);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final y f6543m = new y(16, 10, 1, 13);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final y f6544n = new y(13, 1, 1, 0);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final y f6545o = new y(14, 3, 0, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final y f6546p = new y(12, 2, 0, 0);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final y f6547q = new y(15, 0, 0, 0);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final y f6548r = new y(9, 20, 0, 0);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final y f6549s = new y(10, 20, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private char[] f6550a = new char[32];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private x f6552c;

    q(x xVar) {
        this.f6552c = xVar;
    }

    private void a(String str) {
        int length = str.length();
        int i3 = length + 1;
        if (this.f6550a.length < i3) {
            this.f6550a = new char[i3];
        }
        str.getChars(0, length, this.f6550a, 0);
        this.f6550a[length] = '$';
        this.f6551b = 0;
    }

    y b() throws x {
        char[] cArr;
        int i3;
        char c3;
        int i4;
        char[] cArr2;
        int i5;
        while (" \n\r\t".indexOf(this.f6550a[this.f6551b]) != -1) {
            this.f6551b++;
        }
        char[] cArr3 = this.f6550a;
        int i6 = this.f6551b;
        char c4 = cArr3[i6];
        int i7 = i6 + 1;
        this.f6551b = i7;
        switch (c4) {
            case '!':
                return f6541k;
            case '\"':
            case '&':
            case '\'':
            case '.':
            default:
                if (('0' > c4 || c4 > '9') && c4 != '.') {
                    if (('a' <= c4 && c4 <= 'z') || ('A' <= c4 && c4 <= 'Z')) {
                        while (true) {
                            cArr = this.f6550a;
                            i3 = i7 + 1;
                            c3 = cArr[i7];
                            if (('a' <= c3 && c3 <= 'z') || (('A' <= c3 && c3 <= 'Z') || ('0' <= c3 && c3 <= '9'))) {
                                i7 = i3;
                            }
                        }
                        if (c3 == '\'') {
                            c3 = cArr[i3];
                            i3++;
                        }
                        String strValueOf = String.valueOf(cArr, i6, (i3 - 1) - i6);
                        while (" \n\r\t".indexOf(c3) != -1) {
                            char c5 = this.f6550a[i3];
                            i3++;
                            c3 = c5;
                        }
                        if (c3 == '(') {
                            this.f6551b = i3;
                            return new y(11, 0, 1, 0).b(strValueOf);
                        }
                        this.f6551b = i3 - 1;
                        return f6549s.b(strValueOf);
                    }
                    if ((c4 >= 913 && c4 <= 937) || ((c4 >= 945 && c4 <= 969) || c4 == 8734)) {
                        return f6549s.b(BuildConfig.FLAVOR + c4);
                    }
                    if (c4 == '^') {
                        return f6540j;
                    }
                    if (c4 == 215) {
                        return f6536f;
                    }
                    if (c4 == 247) {
                        return f6537g;
                    }
                    if (c4 == 8722) {
                        return f6535e;
                    }
                    if (c4 == 8730) {
                        return f6543m;
                    }
                    throw this.f6552c.a("invalid character '" + c4 + "'", i6);
                }
                if (c4 == '0') {
                    char lowerCase = Character.toLowerCase(cArr3[i7]);
                    if (lowerCase == 'x') {
                        i4 = 16;
                    } else if (lowerCase == 'b') {
                        i4 = 2;
                    } else {
                        i4 = lowerCase == 'o' ? 8 : 0;
                    }
                    if (i4 > 0) {
                        int i8 = i7 + 1;
                        while (true) {
                            cArr2 = this.f6550a;
                            i5 = i8 + 1;
                            char c6 = cArr2[i8];
                            if (('a' <= c6 && c6 <= 'z') || (('A' <= c6 && c6 <= 'Z') || ('0' <= c6 && c6 <= '9'))) {
                                i8 = i5;
                            }
                        }
                        String strValueOf2 = String.valueOf(cArr2, i6 + 2, (i5 - 3) - i6);
                        int i9 = i5 - 1;
                        this.f6551b = i9;
                        try {
                            return f6548r.c(Integer.parseInt(strValueOf2, i4));
                        } catch (NumberFormatException unused) {
                            throw this.f6552c.a("invalid number '" + String.valueOf(this.f6550a, i6, i9 - i6) + "'", i6);
                        }
                    }
                }
                while (true) {
                    if (('0' > c4 || c4 > '9') && c4 != '.' && c4 != 'E' && c4 != 'e') {
                        int i10 = i7 - 1;
                        this.f6551b = i10;
                        String strValueOf3 = String.valueOf(this.f6550a, i6, i10 - i6);
                        try {
                            if (strValueOf3.equals(".")) {
                                return f6548r.c(0.0d);
                            }
                            return f6548r.c(Double.parseDouble(strValueOf3));
                        } catch (NumberFormatException unused2) {
                            throw this.f6552c.a("invalid number '" + strValueOf3 + "'", i6);
                        }
                    }
                    if (c4 == 'E' || c4 == 'e') {
                        char[] cArr4 = this.f6550a;
                        if (cArr4[i7] == '-' || cArr4[i7] == 8722) {
                            cArr4[i7] = '-';
                            i7++;
                        }
                    }
                    char c7 = this.f6550a[i7];
                    i7++;
                    c4 = c7;
                }
                break;
            case '#':
                return f6538h;
            case '$':
                return f6547q;
            case '%':
                return f6542l;
            case '(':
                return f6544n;
            case ')':
                return f6545o;
            case '*':
                return f6536f;
            case '+':
                return f6534d;
            case ',':
                return f6546p;
            case '-':
                return f6535e;
            case '/':
                return f6537g;
        }
    }

    void c(String str, z zVar) throws x {
        y yVarB;
        this.f6552c.f6589b = str;
        if (str.indexOf(36) != -1) {
            throw this.f6552c.a("Invalid character '$'", str.indexOf(36));
        }
        a(str);
        zVar.b();
        do {
            int i3 = this.f6551b;
            yVarB = b();
            yVarB.f6599h = i3;
            zVar.a(yVarB);
        } while (yVarB != f6547q);
    }
}
