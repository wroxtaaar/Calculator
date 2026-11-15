package r1;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import o1.o;

/* JADX INFO: compiled from: JsonTreeReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends w1.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Reader f6075u = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Object f6076v = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Object[] f6077q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f6078r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String[] f6079s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f6080t;

    /* JADX INFO: compiled from: JsonTreeReader.java */
    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i3, int i4) throws IOException {
            throw new AssertionError();
        }
    }

    private void J(w1.b bVar) throws IOException {
        if (x() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + x() + m());
    }

    private Object L() {
        return this.f6077q[this.f6078r - 1];
    }

    private Object M() {
        Object[] objArr = this.f6077q;
        int i3 = this.f6078r - 1;
        this.f6078r = i3;
        Object obj = objArr[i3];
        objArr[i3] = null;
        return obj;
    }

    private void O(Object obj) {
        int i3 = this.f6078r;
        Object[] objArr = this.f6077q;
        if (i3 == objArr.length) {
            int i4 = i3 * 2;
            this.f6077q = Arrays.copyOf(objArr, i4);
            this.f6080t = Arrays.copyOf(this.f6080t, i4);
            this.f6079s = (String[]) Arrays.copyOf(this.f6079s, i4);
        }
        Object[] objArr2 = this.f6077q;
        int i5 = this.f6078r;
        this.f6078r = i5 + 1;
        objArr2[i5] = obj;
    }

    private String m() {
        return " at path " + i();
    }

    @Override // w1.a
    public void H() throws IOException {
        if (x() == w1.b.NAME) {
            r();
            this.f6079s[this.f6078r - 2] = "null";
        } else {
            M();
            int i3 = this.f6078r;
            if (i3 > 0) {
                this.f6079s[i3 - 1] = "null";
            }
        }
        int i4 = this.f6078r;
        if (i4 > 0) {
            int[] iArr = this.f6080t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    o1.j K() throws IOException {
        w1.b bVarX = x();
        if (bVarX != w1.b.NAME && bVarX != w1.b.END_ARRAY && bVarX != w1.b.END_OBJECT && bVarX != w1.b.END_DOCUMENT) {
            o1.j jVar = (o1.j) L();
            H();
            return jVar;
        }
        throw new IllegalStateException("Unexpected " + bVarX + " when reading a JsonElement.");
    }

    public void N() throws IOException {
        J(w1.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) L()).next();
        O(entry.getValue());
        O(new o((String) entry.getKey()));
    }

    @Override // w1.a
    public void a() throws IOException {
        J(w1.b.BEGIN_ARRAY);
        O(((o1.g) L()).iterator());
        this.f6080t[this.f6078r - 1] = 0;
    }

    @Override // w1.a
    public void b() throws IOException {
        J(w1.b.BEGIN_OBJECT);
        O(((o1.m) L()).i().iterator());
    }

    @Override // w1.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6077q = new Object[]{f6076v};
        this.f6078r = 1;
    }

    @Override // w1.a
    public void f() throws IOException {
        J(w1.b.END_ARRAY);
        M();
        M();
        int i3 = this.f6078r;
        if (i3 > 0) {
            int[] iArr = this.f6080t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // w1.a
    public void g() throws IOException {
        J(w1.b.END_OBJECT);
        M();
        M();
        int i3 = this.f6078r;
        if (i3 > 0) {
            int[] iArr = this.f6080t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // w1.a
    public String i() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = 0;
        while (true) {
            int i4 = this.f6078r;
            if (i3 >= i4) {
                return sb.toString();
            }
            Object[] objArr = this.f6077q;
            if (objArr[i3] instanceof o1.g) {
                i3++;
                if (i3 < i4 && (objArr[i3] instanceof Iterator)) {
                    sb.append('[');
                    sb.append(this.f6080t[i3]);
                    sb.append(']');
                }
            } else if ((objArr[i3] instanceof o1.m) && (i3 = i3 + 1) < i4 && (objArr[i3] instanceof Iterator)) {
                sb.append('.');
                String[] strArr = this.f6079s;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
            i3++;
        }
    }

    @Override // w1.a
    public boolean j() throws IOException {
        w1.b bVarX = x();
        return (bVarX == w1.b.END_OBJECT || bVarX == w1.b.END_ARRAY) ? false : true;
    }

    @Override // w1.a
    public boolean n() throws IOException {
        J(w1.b.BOOLEAN);
        boolean zH = ((o) M()).h();
        int i3 = this.f6078r;
        if (i3 > 0) {
            int[] iArr = this.f6080t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return zH;
    }

    @Override // w1.a
    public double o() throws IOException {
        w1.b bVarX = x();
        w1.b bVar = w1.b.NUMBER;
        if (bVarX != bVar && bVarX != w1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarX + m());
        }
        double dI = ((o) L()).i();
        if (!k() && (Double.isNaN(dI) || Double.isInfinite(dI))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dI);
        }
        M();
        int i3 = this.f6078r;
        if (i3 > 0) {
            int[] iArr = this.f6080t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return dI;
    }

    @Override // w1.a
    public int p() throws IOException {
        w1.b bVarX = x();
        w1.b bVar = w1.b.NUMBER;
        if (bVarX != bVar && bVarX != w1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarX + m());
        }
        int iJ = ((o) L()).j();
        M();
        int i3 = this.f6078r;
        if (i3 > 0) {
            int[] iArr = this.f6080t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return iJ;
    }

    @Override // w1.a
    public long q() throws IOException {
        w1.b bVarX = x();
        w1.b bVar = w1.b.NUMBER;
        if (bVarX != bVar && bVarX != w1.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarX + m());
        }
        long jK = ((o) L()).k();
        M();
        int i3 = this.f6078r;
        if (i3 > 0) {
            int[] iArr = this.f6080t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return jK;
    }

    @Override // w1.a
    public String r() throws IOException {
        J(w1.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) L()).next();
        String str = (String) entry.getKey();
        this.f6079s[this.f6078r - 1] = str;
        O(entry.getValue());
        return str;
    }

    @Override // w1.a
    public void t() throws IOException {
        J(w1.b.NULL);
        M();
        int i3 = this.f6078r;
        if (i3 > 0) {
            int[] iArr = this.f6080t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // w1.a
    public String toString() {
        return f.class.getSimpleName() + m();
    }

    @Override // w1.a
    public String v() throws IOException {
        w1.b bVarX = x();
        w1.b bVar = w1.b.STRING;
        if (bVarX == bVar || bVarX == w1.b.NUMBER) {
            String strM = ((o) M()).m();
            int i3 = this.f6078r;
            if (i3 > 0) {
                int[] iArr = this.f6080t;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
            return strM;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarX + m());
    }

    @Override // w1.a
    public w1.b x() throws IOException {
        if (this.f6078r == 0) {
            return w1.b.END_DOCUMENT;
        }
        Object objL = L();
        if (objL instanceof Iterator) {
            boolean z2 = this.f6077q[this.f6078r - 2] instanceof o1.m;
            Iterator it = (Iterator) objL;
            if (!it.hasNext()) {
                return z2 ? w1.b.END_OBJECT : w1.b.END_ARRAY;
            }
            if (z2) {
                return w1.b.NAME;
            }
            O(it.next());
            return x();
        }
        if (objL instanceof o1.m) {
            return w1.b.BEGIN_OBJECT;
        }
        if (objL instanceof o1.g) {
            return w1.b.BEGIN_ARRAY;
        }
        if (!(objL instanceof o)) {
            if (objL instanceof o1.l) {
                return w1.b.NULL;
            }
            if (objL == f6076v) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        o oVar = (o) objL;
        if (oVar.q()) {
            return w1.b.STRING;
        }
        if (oVar.n()) {
            return w1.b.BOOLEAN;
        }
        if (oVar.p()) {
            return w1.b.NUMBER;
        }
        throw new AssertionError();
    }
}
