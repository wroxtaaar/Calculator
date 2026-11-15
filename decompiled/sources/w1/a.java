package w1;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import q1.f;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reader f6356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6357c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char[] f6358d = new char[1024];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6359e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6360f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6361g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6362h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f6363i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f6364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f6366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f6367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6368n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String[] f6369o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f6370p;

    /* JADX INFO: renamed from: w1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JsonReader.java */
    class C0095a extends f {
        C0095a() {
        }

        @Override // q1.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof r1.f) {
                ((r1.f) aVar).N();
                return;
            }
            int iE = aVar.f6363i;
            if (iE == 0) {
                iE = aVar.e();
            }
            if (iE == 13) {
                aVar.f6363i = 9;
                return;
            }
            if (iE == 12) {
                aVar.f6363i = 8;
                return;
            }
            if (iE == 14) {
                aVar.f6363i = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.x() + aVar.m());
        }
    }

    static {
        f.f5900a = new C0095a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f6367m = iArr;
        this.f6368n = 0;
        this.f6368n = 0 + 1;
        iArr[0] = 6;
        this.f6369o = new String[32];
        this.f6370p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f6356b = reader;
    }

    private void A(int i3) {
        int i4 = this.f6368n;
        int[] iArr = this.f6367m;
        if (i4 == iArr.length) {
            int i5 = i4 * 2;
            this.f6367m = Arrays.copyOf(iArr, i5);
            this.f6370p = Arrays.copyOf(this.f6370p, i5);
            this.f6369o = (String[]) Arrays.copyOf(this.f6369o, i5);
        }
        int[] iArr2 = this.f6367m;
        int i6 = this.f6368n;
        this.f6368n = i6 + 1;
        iArr2[i6] = i3;
    }

    private char B() throws IOException {
        int i3;
        int i4;
        if (this.f6359e == this.f6360f && !h(1)) {
            throw I("Unterminated escape sequence");
        }
        char[] cArr = this.f6358d;
        int i5 = this.f6359e;
        int i6 = i5 + 1;
        this.f6359e = i6;
        char c3 = cArr[i5];
        if (c3 == '\n') {
            this.f6361g++;
            this.f6362h = i6;
        } else if (c3 != '\"' && c3 != '\'' && c3 != '/' && c3 != '\\') {
            if (c3 == 'b') {
                return '\b';
            }
            if (c3 == 'f') {
                return '\f';
            }
            if (c3 == 'n') {
                return '\n';
            }
            if (c3 == 'r') {
                return '\r';
            }
            if (c3 == 't') {
                return '\t';
            }
            if (c3 != 'u') {
                throw I("Invalid escape sequence");
            }
            if (i6 + 4 > this.f6360f && !h(4)) {
                throw I("Unterminated escape sequence");
            }
            char c4 = 0;
            int i7 = this.f6359e;
            int i8 = i7 + 4;
            while (i7 < i8) {
                char c5 = this.f6358d[i7];
                char c6 = (char) (c4 << 4);
                if (c5 < '0' || c5 > '9') {
                    if (c5 >= 'a' && c5 <= 'f') {
                        i3 = c5 - 'a';
                    } else {
                        if (c5 < 'A' || c5 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f6358d, this.f6359e, 4));
                        }
                        i3 = c5 - 'A';
                    }
                    i4 = i3 + 10;
                } else {
                    i4 = c5 - '0';
                }
                c4 = (char) (c6 + i4);
                i7++;
            }
            this.f6359e += 4;
            return c4;
        }
        return c3;
    }

    private void D(char c3) throws IOException {
        char[] cArr = this.f6358d;
        do {
            int i3 = this.f6359e;
            int i4 = this.f6360f;
            while (i3 < i4) {
                int i5 = i3 + 1;
                char c4 = cArr[i3];
                if (c4 == c3) {
                    this.f6359e = i5;
                    return;
                }
                if (c4 == '\\') {
                    this.f6359e = i5;
                    B();
                    i3 = this.f6359e;
                    i4 = this.f6360f;
                } else {
                    if (c4 == '\n') {
                        this.f6361g++;
                        this.f6362h = i5;
                    }
                    i3 = i5;
                }
            }
            this.f6359e = i3;
        } while (h(1));
        throw I("Unterminated string");
    }

    private boolean E(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f6359e + length > this.f6360f && !h(length)) {
                return false;
            }
            char[] cArr = this.f6358d;
            int i3 = this.f6359e;
            if (cArr[i3] != '\n') {
                for (int i4 = 0; i4 < length; i4++) {
                    if (this.f6358d[this.f6359e + i4] == str.charAt(i4)) {
                    }
                }
                return true;
            }
            this.f6361g++;
            this.f6362h = i3 + 1;
            this.f6359e++;
        }
    }

    private void F() throws IOException {
        char c3;
        do {
            if (this.f6359e >= this.f6360f && !h(1)) {
                return;
            }
            char[] cArr = this.f6358d;
            int i3 = this.f6359e;
            int i4 = i3 + 1;
            this.f6359e = i4;
            c3 = cArr[i3];
            if (c3 == '\n') {
                this.f6361g++;
                this.f6362h = i4;
                return;
            }
        } while (c3 != '\r');
    }

    private void G() throws IOException {
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f6359e;
                if (i4 + i3 < this.f6360f) {
                    char c3 = this.f6358d[i4 + i3];
                    if (c3 != '\t' && c3 != '\n' && c3 != '\f' && c3 != '\r' && c3 != ' ') {
                        if (c3 != '#') {
                            if (c3 != ',') {
                                if (c3 != '/' && c3 != '=') {
                                    if (c3 != '{' && c3 != '}' && c3 != ':') {
                                        if (c3 != ';') {
                                            switch (c3) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    this.f6359e += i3;
                    return;
                }
                this.f6359e = i4 + i3;
            }
        } while (h(1));
    }

    private IOException I(String str) throws IOException {
        throw new d(str + m());
    }

    private void c() throws IOException {
        if (!this.f6357c) {
            throw I("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void d() throws IOException {
        s(true);
        int i3 = this.f6359e - 1;
        this.f6359e = i3;
        if (i3 + 5 <= this.f6360f || h(5)) {
            char[] cArr = this.f6358d;
            if (cArr[i3] == ')' && cArr[i3 + 1] == ']' && cArr[i3 + 2] == '}' && cArr[i3 + 3] == '\'' && cArr[i3 + 4] == '\n') {
                this.f6359e += 5;
            }
        }
    }

    private boolean h(int i3) throws IOException {
        int i4;
        int i5;
        char[] cArr = this.f6358d;
        int i6 = this.f6362h;
        int i7 = this.f6359e;
        this.f6362h = i6 - i7;
        int i8 = this.f6360f;
        if (i8 != i7) {
            int i9 = i8 - i7;
            this.f6360f = i9;
            System.arraycopy(cArr, i7, cArr, 0, i9);
        } else {
            this.f6360f = 0;
        }
        this.f6359e = 0;
        do {
            Reader reader = this.f6356b;
            int i10 = this.f6360f;
            int i11 = reader.read(cArr, i10, cArr.length - i10);
            if (i11 == -1) {
                return false;
            }
            i4 = this.f6360f + i11;
            this.f6360f = i4;
            if (this.f6361g == 0 && (i5 = this.f6362h) == 0 && i4 > 0 && cArr[0] == 65279) {
                this.f6359e++;
                this.f6362h = i5 + 1;
                i3++;
            }
        } while (i4 < i3);
        return true;
    }

    private boolean l(char c3) throws IOException {
        if (c3 == '\t' || c3 == '\n' || c3 == '\f' || c3 == '\r' || c3 == ' ') {
            return false;
        }
        if (c3 != '#') {
            if (c3 == ',') {
                return false;
            }
            if (c3 != '/' && c3 != '=') {
                if (c3 == '{' || c3 == '}' || c3 == ':') {
                    return false;
                }
                if (c3 != ';') {
                    switch (c3) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private int s(boolean z2) throws IOException {
        char[] cArr = this.f6358d;
        int i3 = this.f6359e;
        int i4 = this.f6360f;
        while (true) {
            if (i3 == i4) {
                this.f6359e = i3;
                if (!h(1)) {
                    if (!z2) {
                        return -1;
                    }
                    throw new EOFException("End of input" + m());
                }
                i3 = this.f6359e;
                i4 = this.f6360f;
            }
            int i5 = i3 + 1;
            char c3 = cArr[i3];
            if (c3 == '\n') {
                this.f6361g++;
                this.f6362h = i5;
            } else if (c3 != ' ' && c3 != '\r' && c3 != '\t') {
                if (c3 == '/') {
                    this.f6359e = i5;
                    if (i5 == i4) {
                        this.f6359e = i5 - 1;
                        boolean zH = h(2);
                        this.f6359e++;
                        if (!zH) {
                            return c3;
                        }
                    }
                    c();
                    int i6 = this.f6359e;
                    char c4 = cArr[i6];
                    if (c4 == '*') {
                        this.f6359e = i6 + 1;
                        if (!E("*/")) {
                            throw I("Unterminated comment");
                        }
                        i3 = this.f6359e + 2;
                        i4 = this.f6360f;
                    } else {
                        if (c4 != '/') {
                            return c3;
                        }
                        this.f6359e = i6 + 1;
                        F();
                        i3 = this.f6359e;
                        i4 = this.f6360f;
                    }
                } else {
                    if (c3 != '#') {
                        this.f6359e = i5;
                        return c3;
                    }
                    this.f6359e = i5;
                    c();
                    F();
                    i3 = this.f6359e;
                    i4 = this.f6360f;
                }
            }
            i3 = i5;
        }
    }

    private String u(char c3) throws IOException {
        int i3;
        char[] cArr = this.f6358d;
        StringBuilder sb = null;
        do {
            int i4 = this.f6359e;
            int i5 = this.f6360f;
            while (true) {
                int i6 = i5;
                i3 = i4;
                while (true) {
                    if (i4 < i6) {
                        int i7 = i4 + 1;
                        char c4 = cArr[i4];
                        if (c4 == c3) {
                            this.f6359e = i7;
                            int i8 = (i7 - i3) - 1;
                            if (sb == null) {
                                return new String(cArr, i3, i8);
                            }
                            sb.append(cArr, i3, i8);
                            return sb.toString();
                        }
                        if (c4 == '\\') {
                            this.f6359e = i7;
                            int i9 = (i7 - i3) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i9 + 1) * 2, 16));
                            }
                            sb.append(cArr, i3, i9);
                            sb.append(B());
                            i4 = this.f6359e;
                            i5 = this.f6360f;
                        } else {
                            if (c4 == '\n') {
                                this.f6361g++;
                                this.f6362h = i7;
                            }
                            i4 = i7;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i4 - i3) * 2, 16));
            }
            sb.append(cArr, i3, i4 - i3);
            this.f6359e = i4;
        } while (h(1));
        throw I("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String w() throws IOException {
        String string;
        int i3 = 0;
        StringBuilder sb = null;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = this.f6359e;
                if (i5 + i4 < this.f6360f) {
                    char c3 = this.f6358d[i5 + i4];
                    if (c3 != '\t' && c3 != '\n' && c3 != '\f' && c3 != '\r' && c3 != ' ') {
                        if (c3 != '#') {
                            if (c3 != ',') {
                                if (c3 != '/' && c3 != '=') {
                                    if (c3 != '{' && c3 != '}' && c3 != ':') {
                                        if (c3 != ';') {
                                            switch (c3) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i4++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    i3 = i4;
                } else if (i4 >= this.f6358d.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i4, 16));
                    }
                    sb.append(this.f6358d, this.f6359e, i4);
                    this.f6359e += i4;
                    if (!h(1)) {
                    }
                } else if (!h(i4 + 1)) {
                    i3 = i4;
                }
                if (sb == null) {
                    string = new String(this.f6358d, this.f6359e, i3);
                } else {
                    sb.append(this.f6358d, this.f6359e, i3);
                    string = sb.toString();
                }
                this.f6359e += i3;
                return string;
            }
        }
    }

    private int y() throws IOException {
        int i3;
        String str;
        String str2;
        char c3 = this.f6358d[this.f6359e];
        if (c3 == 't' || c3 == 'T') {
            i3 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c3 == 'f' || c3 == 'F') {
            i3 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (c3 != 'n' && c3 != 'N') {
                return 0;
            }
            i3 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i4 = 1; i4 < length; i4++) {
            if (this.f6359e + i4 >= this.f6360f && !h(i4 + 1)) {
                return 0;
            }
            char c4 = this.f6358d[this.f6359e + i4];
            if (c4 != str.charAt(i4) && c4 != str2.charAt(i4)) {
                return 0;
            }
        }
        if ((this.f6359e + length < this.f6360f || h(length + 1)) && l(this.f6358d[this.f6359e + length])) {
            return 0;
        }
        this.f6359e += length;
        this.f6363i = i3;
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:90:0x00df  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:97:0x00eb  */
    private int z() throws IOException {
        char c3;
        char c4;
        char[] cArr = this.f6358d;
        int i3 = this.f6359e;
        int i4 = this.f6360f;
        int i5 = 0;
        boolean z2 = true;
        int i6 = 0;
        char c5 = 0;
        boolean z3 = false;
        long j3 = 0;
        while (true) {
            if (i3 + i6 != i4) {
                c3 = cArr[i3 + i6];
                c4 = 3;
                if (c3 != '+') {
                    if (c3 != 'E' || c3 == 'e') {
                        i5 = 0;
                        if (c5 == 2 && c5 != 4) {
                            return 0;
                        }
                        c5 = 5;
                    } else if (c3 == '-') {
                        c4 = 6;
                        i5 = 0;
                        if (c5 == 0) {
                            c5 = 1;
                            z3 = true;
                        } else if (c5 != 5) {
                            return 0;
                        }
                    } else if (c3 == '.') {
                        i5 = 0;
                        if (c5 != 2) {
                            return 0;
                        }
                    } else {
                        if (c3 < '0' || c3 > '9') {
                            if (!l(c3)) {
                                break;
                            }
                            return 0;
                        }
                        if (c5 == 1 || c5 == 0) {
                            j3 = -(c3 - '0');
                            c5 = 2;
                        } else if (c5 == 2) {
                            if (j3 == 0) {
                                return 0;
                            }
                            long j4 = (10 * j3) - ((long) (c3 - '0'));
                            z2 &= j3 > -922337203685477580L || (j3 == -922337203685477580L && j4 < j3);
                            j3 = j4;
                        } else if (c5 == 3) {
                            i5 = 0;
                            c5 = 4;
                        } else if (c5 == 5 || c5 == 6) {
                            i5 = 0;
                            c5 = 7;
                        }
                        i5 = 0;
                    }
                    i6++;
                } else {
                    c4 = 6;
                    i5 = 0;
                    if (c5 != 5) {
                        return 0;
                    }
                }
                c5 = c4;
                i6++;
            } else {
                if (i6 == cArr.length) {
                    return i5;
                }
                if (!h(i6 + 1)) {
                    break;
                }
                i3 = this.f6359e;
                i4 = this.f6360f;
                c3 = cArr[i3 + i6];
                c4 = 3;
                if (c3 != '+') {
                    if (c3 != 'E') {
                        i5 = 0;
                        if (c5 == 2) {
                        }
                        c5 = 5;
                    } else {
                        i5 = 0;
                        if (c5 == 2) {
                        }
                        c5 = 5;
                    }
                    i6++;
                } else {
                    c4 = 6;
                    i5 = 0;
                    if (c5 != 5) {
                        return 0;
                    }
                }
                c5 = c4;
                i6++;
            }
        }
        if (c5 == 2 && z2 && ((j3 != Long.MIN_VALUE || z3) && (j3 != 0 || !z3))) {
            if (!z3) {
                j3 = -j3;
            }
            this.f6364j = j3;
            this.f6359e += i6;
            this.f6363i = 15;
            return 15;
        }
        if (c5 != 2 && c5 != 4 && c5 != 7) {
            return 0;
        }
        this.f6365k = i6;
        this.f6363i = 16;
        return 16;
    }

    public final void C(boolean z2) {
        this.f6357c = z2;
    }

    public void H() throws IOException {
        int i3 = 0;
        do {
            int iE = this.f6363i;
            if (iE == 0) {
                iE = e();
            }
            if (iE == 3) {
                A(1);
            } else {
                if (iE == 1) {
                    A(3);
                } else if (iE == 4 || iE == 2) {
                    this.f6368n--;
                    i3--;
                } else if (iE == 14 || iE == 10) {
                    G();
                } else if (iE == 8 || iE == 12) {
                    D('\'');
                } else if (iE == 9 || iE == 13) {
                    D('\"');
                } else if (iE == 16) {
                    this.f6359e += this.f6365k;
                }
                this.f6363i = 0;
            }
            i3++;
            this.f6363i = 0;
        } while (i3 != 0);
        int[] iArr = this.f6370p;
        int i4 = this.f6368n;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.f6369o[i4 - 1] = "null";
    }

    public void a() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 3) {
            A(1);
            this.f6370p[this.f6368n - 1] = 0;
            this.f6363i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + x() + m());
        }
    }

    public void b() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 1) {
            A(3);
            this.f6363i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + x() + m());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6363i = 0;
        this.f6367m[0] = 8;
        this.f6368n = 1;
        this.f6356b.close();
    }

    int e() throws IOException {
        int iS;
        int[] iArr = this.f6367m;
        int i3 = this.f6368n;
        int i4 = iArr[i3 - 1];
        if (i4 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i4 == 2) {
            int iS2 = s(true);
            if (iS2 != 44) {
                if (iS2 != 59) {
                    if (iS2 != 93) {
                        throw I("Unterminated array");
                    }
                    this.f6363i = 4;
                    return 4;
                }
                c();
            }
        } else {
            if (i4 == 3 || i4 == 5) {
                iArr[i3 - 1] = 4;
                if (i4 == 5 && (iS = s(true)) != 44) {
                    if (iS != 59) {
                        if (iS != 125) {
                            throw I("Unterminated object");
                        }
                        this.f6363i = 2;
                        return 2;
                    }
                    c();
                }
                int iS3 = s(true);
                if (iS3 == 34) {
                    this.f6363i = 13;
                    return 13;
                }
                if (iS3 == 39) {
                    c();
                    this.f6363i = 12;
                    return 12;
                }
                if (iS3 == 125) {
                    if (i4 == 5) {
                        throw I("Expected name");
                    }
                    this.f6363i = 2;
                    return 2;
                }
                c();
                this.f6359e--;
                if (!l((char) iS3)) {
                    throw I("Expected name");
                }
                this.f6363i = 14;
                return 14;
            }
            if (i4 == 4) {
                iArr[i3 - 1] = 5;
                int iS4 = s(true);
                if (iS4 != 58) {
                    if (iS4 != 61) {
                        throw I("Expected ':'");
                    }
                    c();
                    if (this.f6359e < this.f6360f || h(1)) {
                        char[] cArr = this.f6358d;
                        int i5 = this.f6359e;
                        if (cArr[i5] == '>') {
                            this.f6359e = i5 + 1;
                        }
                    }
                }
            } else if (i4 == 6) {
                if (this.f6357c) {
                    d();
                }
                this.f6367m[this.f6368n - 1] = 7;
            } else if (i4 == 7) {
                if (s(false) == -1) {
                    this.f6363i = 17;
                    return 17;
                }
                c();
                this.f6359e--;
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iS5 = s(true);
        if (iS5 == 34) {
            this.f6363i = 9;
            return 9;
        }
        if (iS5 == 39) {
            c();
            this.f6363i = 8;
            return 8;
        }
        if (iS5 != 44 && iS5 != 59) {
            if (iS5 == 91) {
                this.f6363i = 3;
                return 3;
            }
            if (iS5 != 93) {
                if (iS5 == 123) {
                    this.f6363i = 1;
                    return 1;
                }
                this.f6359e--;
                int iY = y();
                if (iY != 0) {
                    return iY;
                }
                int iZ = z();
                if (iZ != 0) {
                    return iZ;
                }
                if (!l(this.f6358d[this.f6359e])) {
                    throw I("Expected value");
                }
                c();
                this.f6363i = 10;
                return 10;
            }
            if (i4 == 1) {
                this.f6363i = 4;
                return 4;
            }
        }
        if (i4 != 1 && i4 != 2) {
            throw I("Unexpected value");
        }
        c();
        this.f6359e--;
        this.f6363i = 7;
        return 7;
    }

    public void f() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + x() + m());
        }
        int i3 = this.f6368n - 1;
        this.f6368n = i3;
        int[] iArr = this.f6370p;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f6363i = 0;
    }

    public void g() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + x() + m());
        }
        int i3 = this.f6368n - 1;
        this.f6368n = i3;
        this.f6369o[i3] = null;
        int[] iArr = this.f6370p;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f6363i = 0;
    }

    public String i() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = this.f6368n;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.f6367m[i4];
            if (i5 == 1 || i5 == 2) {
                sb.append('[');
                sb.append(this.f6370p[i4]);
                sb.append(']');
            } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                sb.append('.');
                String[] strArr = this.f6369o;
                if (strArr[i4] != null) {
                    sb.append(strArr[i4]);
                }
            }
        }
        return sb.toString();
    }

    public boolean j() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        return (iE == 2 || iE == 4) ? false : true;
    }

    public final boolean k() {
        return this.f6357c;
    }

    String m() {
        return " at line " + (this.f6361g + 1) + " column " + ((this.f6359e - this.f6362h) + 1) + " path " + i();
    }

    public boolean n() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 5) {
            this.f6363i = 0;
            int[] iArr = this.f6370p;
            int i3 = this.f6368n - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (iE == 6) {
            this.f6363i = 0;
            int[] iArr2 = this.f6370p;
            int i4 = this.f6368n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + x() + m());
    }

    public double o() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.f6363i = 0;
            int[] iArr = this.f6370p;
            int i3 = this.f6368n - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f6364j;
        }
        if (iE == 16) {
            this.f6366l = new String(this.f6358d, this.f6359e, this.f6365k);
            this.f6359e += this.f6365k;
        } else if (iE == 8 || iE == 9) {
            this.f6366l = u(iE == 8 ? '\'' : '\"');
        } else if (iE == 10) {
            this.f6366l = w();
        } else if (iE != 11) {
            throw new IllegalStateException("Expected a double but was " + x() + m());
        }
        this.f6363i = 11;
        double d3 = Double.parseDouble(this.f6366l);
        if (!this.f6357c && (Double.isNaN(d3) || Double.isInfinite(d3))) {
            throw new d("JSON forbids NaN and infinities: " + d3 + m());
        }
        this.f6366l = null;
        this.f6363i = 0;
        int[] iArr2 = this.f6370p;
        int i4 = this.f6368n - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return d3;
    }

    public int p() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            long j3 = this.f6364j;
            int i3 = (int) j3;
            if (j3 == i3) {
                this.f6363i = 0;
                int[] iArr = this.f6370p;
                int i4 = this.f6368n - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f6364j + m());
        }
        if (iE == 16) {
            this.f6366l = new String(this.f6358d, this.f6359e, this.f6365k);
            this.f6359e += this.f6365k;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected an int but was " + x() + m());
            }
            if (iE == 10) {
                this.f6366l = w();
            } else {
                this.f6366l = u(iE == 8 ? '\'' : '\"');
            }
            try {
                int i5 = Integer.parseInt(this.f6366l);
                this.f6363i = 0;
                int[] iArr2 = this.f6370p;
                int i6 = this.f6368n - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return i5;
            } catch (NumberFormatException unused) {
            }
        }
        this.f6363i = 11;
        double d3 = Double.parseDouble(this.f6366l);
        int i7 = (int) d3;
        if (i7 != d3) {
            throw new NumberFormatException("Expected an int but was " + this.f6366l + m());
        }
        this.f6366l = null;
        this.f6363i = 0;
        int[] iArr3 = this.f6370p;
        int i8 = this.f6368n - 1;
        iArr3[i8] = iArr3[i8] + 1;
        return i7;
    }

    public long q() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.f6363i = 0;
            int[] iArr = this.f6370p;
            int i3 = this.f6368n - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f6364j;
        }
        if (iE == 16) {
            this.f6366l = new String(this.f6358d, this.f6359e, this.f6365k);
            this.f6359e += this.f6365k;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected a long but was " + x() + m());
            }
            if (iE == 10) {
                this.f6366l = w();
            } else {
                this.f6366l = u(iE == 8 ? '\'' : '\"');
            }
            try {
                long j3 = Long.parseLong(this.f6366l);
                this.f6363i = 0;
                int[] iArr2 = this.f6370p;
                int i4 = this.f6368n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return j3;
            } catch (NumberFormatException unused) {
            }
        }
        this.f6363i = 11;
        double d3 = Double.parseDouble(this.f6366l);
        long j4 = (long) d3;
        if (j4 != d3) {
            throw new NumberFormatException("Expected a long but was " + this.f6366l + m());
        }
        this.f6366l = null;
        this.f6363i = 0;
        int[] iArr3 = this.f6370p;
        int i5 = this.f6368n - 1;
        iArr3[i5] = iArr3[i5] + 1;
        return j4;
    }

    public String r() throws IOException {
        String strU;
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 14) {
            strU = w();
        } else if (iE == 12) {
            strU = u('\'');
        } else {
            if (iE != 13) {
                throw new IllegalStateException("Expected a name but was " + x() + m());
            }
            strU = u('\"');
        }
        this.f6363i = 0;
        this.f6369o[this.f6368n - 1] = strU;
        return strU;
    }

    public void t() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 7) {
            this.f6363i = 0;
            int[] iArr = this.f6370p;
            int i3 = this.f6368n - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + x() + m());
    }

    public String toString() {
        return getClass().getSimpleName() + m();
    }

    public String v() throws IOException {
        String str;
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 10) {
            str = w();
        } else if (iE == 8) {
            str = u('\'');
        } else if (iE == 9) {
            str = u('\"');
        } else if (iE == 11) {
            str = this.f6366l;
            this.f6366l = null;
        } else if (iE == 15) {
            str = Long.toString(this.f6364j);
        } else {
            if (iE != 16) {
                throw new IllegalStateException("Expected a string but was " + x() + m());
            }
            str = new String(this.f6358d, this.f6359e, this.f6365k);
            this.f6359e += this.f6365k;
        }
        this.f6363i = 0;
        int[] iArr = this.f6370p;
        int i3 = this.f6368n - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public b x() throws IOException {
        int iE = this.f6363i;
        if (iE == 0) {
            iE = e();
        }
        switch (iE) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }
}
