package r1;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import o1.o;

/* JADX INFO: compiled from: JsonTreeWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends w1.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Writer f6081p = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final o f6082q = new o("closed");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List<o1.j> f6083m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f6084n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private o1.j f6085o;

    /* JADX INFO: compiled from: JsonTreeWriter.java */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f6081p);
        this.f6083m = new ArrayList();
        this.f6085o = o1.l.f5448a;
    }

    private void A(o1.j jVar) {
        if (this.f6084n != null) {
            if (!jVar.e() || h()) {
                ((o1.m) z()).h(this.f6084n, jVar);
            }
            this.f6084n = null;
            return;
        }
        if (this.f6083m.isEmpty()) {
            this.f6085o = jVar;
            return;
        }
        o1.j jVarZ = z();
        if (!(jVarZ instanceof o1.g)) {
            throw new IllegalStateException();
        }
        ((o1.g) jVarZ).h(jVar);
    }

    private o1.j z() {
        List<o1.j> list = this.f6083m;
        return list.get(list.size() - 1);
    }

    @Override // w1.c
    public w1.c c() throws IOException {
        o1.g gVar = new o1.g();
        A(gVar);
        this.f6083m.add(gVar);
        return this;
    }

    @Override // w1.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f6083m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f6083m.add(f6082q);
    }

    @Override // w1.c
    public w1.c d() throws IOException {
        o1.m mVar = new o1.m();
        A(mVar);
        this.f6083m.add(mVar);
        return this;
    }

    @Override // w1.c
    public w1.c f() throws IOException {
        if (this.f6083m.isEmpty() || this.f6084n != null) {
            throw new IllegalStateException();
        }
        if (!(z() instanceof o1.g)) {
            throw new IllegalStateException();
        }
        List<o1.j> list = this.f6083m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // w1.c, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // w1.c
    public w1.c g() throws IOException {
        if (this.f6083m.isEmpty() || this.f6084n != null) {
            throw new IllegalStateException();
        }
        if (!(z() instanceof o1.m)) {
            throw new IllegalStateException();
        }
        List<o1.j> list = this.f6083m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // w1.c
    public w1.c j(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f6083m.isEmpty() || this.f6084n != null) {
            throw new IllegalStateException();
        }
        if (!(z() instanceof o1.m)) {
            throw new IllegalStateException();
        }
        this.f6084n = str;
        return this;
    }

    @Override // w1.c
    public w1.c l() throws IOException {
        A(o1.l.f5448a);
        return this;
    }

    @Override // w1.c
    public w1.c s(long j3) throws IOException {
        A(new o(Long.valueOf(j3)));
        return this;
    }

    @Override // w1.c
    public w1.c t(Boolean bool) throws IOException {
        if (bool == null) {
            return l();
        }
        A(new o(bool));
        return this;
    }

    @Override // w1.c
    public w1.c u(Number number) throws IOException {
        if (number == null) {
            return l();
        }
        if (!i()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        A(new o(number));
        return this;
    }

    @Override // w1.c
    public w1.c v(String str) throws IOException {
        if (str == null) {
            return l();
        }
        A(new o(str));
        return this;
    }

    @Override // w1.c
    public w1.c w(boolean z2) throws IOException {
        A(new o(Boolean.valueOf(z2)));
        return this;
    }

    public o1.j y() {
        if (this.f6083m.isEmpty()) {
            return this.f6085o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f6083m);
    }
}
