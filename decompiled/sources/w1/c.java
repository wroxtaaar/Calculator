package w1;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f6382k = new String[128];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f6383l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Writer f6384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f6385c = new int[32];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6386d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6392j;

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f6382k[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f6382k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f6383l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        o(6);
        this.f6388f = ":";
        this.f6392j = true;
        Objects.requireNonNull(writer, "out == null");
        this.f6384b = writer;
    }

    private void a() throws IOException {
        int iN = n();
        if (iN == 5) {
            this.f6384b.write(44);
        } else if (iN != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        p(4);
    }

    private void b() throws IOException {
        int iN = n();
        if (iN == 1) {
            p(2);
            k();
            return;
        }
        if (iN == 2) {
            this.f6384b.append(',');
            k();
        } else {
            if (iN == 4) {
                this.f6384b.append((CharSequence) this.f6388f);
                p(5);
                return;
            }
            if (iN != 6) {
                if (iN != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f6389g) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            p(7);
        }
    }

    private c e(int i3, int i4, char c3) throws IOException {
        int iN = n();
        if (iN != i4 && iN != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f6391i != null) {
            throw new IllegalStateException("Dangling name: " + this.f6391i);
        }
        this.f6386d--;
        if (iN == i4) {
            k();
        }
        this.f6384b.write(c3);
        return this;
    }

    private void k() throws IOException {
        if (this.f6387e == null) {
            return;
        }
        this.f6384b.write(10);
        int i3 = this.f6386d;
        for (int i4 = 1; i4 < i3; i4++) {
            this.f6384b.write(this.f6387e);
        }
    }

    private c m(int i3, char c3) throws IOException {
        b();
        o(i3);
        this.f6384b.write(c3);
        return this;
    }

    private int n() {
        int i3 = this.f6386d;
        if (i3 != 0) {
            return this.f6385c[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void o(int i3) {
        int i4 = this.f6386d;
        int[] iArr = this.f6385c;
        if (i4 == iArr.length) {
            this.f6385c = Arrays.copyOf(iArr, i4 * 2);
        }
        int[] iArr2 = this.f6385c;
        int i5 = this.f6386d;
        this.f6386d = i5 + 1;
        iArr2[i5] = i3;
    }

    private void p(int i3) {
        this.f6385c[this.f6386d - 1] = i3;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void r(String str) throws IOException {
        String str2;
        String[] strArr = this.f6390h ? f6383l : f6382k;
        this.f6384b.write(34);
        int length = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i3 < i4) {
                        this.f6384b.write(str, i3, i4 - i3);
                    }
                    this.f6384b.write(str2);
                    i3 = i4 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i3 < i4) {
                    this.f6384b.write(str, i3, i4 - i3);
                }
                this.f6384b.write(str2);
                i3 = i4 + 1;
            }
        }
        if (i3 < length) {
            this.f6384b.write(str, i3, length - i3);
        }
        this.f6384b.write(34);
    }

    private void x() throws IOException {
        if (this.f6391i != null) {
            a();
            r(this.f6391i);
            this.f6391i = null;
        }
    }

    public c c() throws IOException {
        x();
        return m(1, '[');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6384b.close();
        int i3 = this.f6386d;
        if (i3 > 1 || (i3 == 1 && this.f6385c[i3 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f6386d = 0;
    }

    public c d() throws IOException {
        x();
        return m(3, '{');
    }

    public c f() throws IOException {
        return e(1, 2, ']');
    }

    public void flush() throws IOException {
        if (this.f6386d == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f6384b.flush();
    }

    public c g() throws IOException {
        return e(3, 5, '}');
    }

    public final boolean h() {
        return this.f6392j;
    }

    public boolean i() {
        return this.f6389g;
    }

    public c j(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f6391i != null) {
            throw new IllegalStateException();
        }
        if (this.f6386d == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f6391i = str;
        return this;
    }

    public c l() throws IOException {
        if (this.f6391i != null) {
            if (!this.f6392j) {
                this.f6391i = null;
                return this;
            }
            x();
        }
        b();
        this.f6384b.write("null");
        return this;
    }

    public final void q(boolean z2) {
        this.f6389g = z2;
    }

    public c s(long j3) throws IOException {
        x();
        b();
        this.f6384b.write(Long.toString(j3));
        return this;
    }

    public c t(Boolean bool) throws IOException {
        if (bool == null) {
            return l();
        }
        x();
        b();
        this.f6384b.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c u(Number number) throws IOException {
        if (number == null) {
            return l();
        }
        x();
        String string = number.toString();
        if (this.f6389g || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            b();
            this.f6384b.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c v(String str) throws IOException {
        if (str == null) {
            return l();
        }
        x();
        b();
        r(str);
        return this;
    }

    public c w(boolean z2) throws IOException {
        x();
        b();
        this.f6384b.write(z2 ? "true" : "false");
        return this;
    }
}
