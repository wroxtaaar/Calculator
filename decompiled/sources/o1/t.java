package o1;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ToNumberPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class t implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f5454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f5455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f5456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t f5457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ t[] f5458f;

    /* JADX INFO: compiled from: ToNumberPolicy.java */
    final enum a extends t {
        a(String str, int i3) {
            super(str, i3, null);
        }

        @Override // o1.u
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(w1.a aVar) throws IOException {
            return Double.valueOf(aVar.o());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f5454b = aVar;
        t tVar = new t("LAZILY_PARSED_NUMBER", 1) { // from class: o1.t.b
            {
                a aVar2 = null;
            }

            @Override // o1.u
            public Number a(w1.a aVar2) throws IOException {
                return new q1.g(aVar2.v());
            }
        };
        f5455c = tVar;
        t tVar2 = new t("LONG_OR_DOUBLE", 2) { // from class: o1.t.c
            {
                a aVar2 = null;
            }

            @Override // o1.u
            public Number a(w1.a aVar2) throws n, IOException {
                String strV = aVar2.v();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strV));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strV);
                        if ((!dValueOf.isInfinite() && !dValueOf.isNaN()) || aVar2.k()) {
                            return dValueOf;
                        }
                        throw new w1.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar2.i());
                    }
                } catch (NumberFormatException e3) {
                    throw new n("Cannot parse " + strV + "; at path " + aVar2.i(), e3);
                }
            }
        };
        f5456d = tVar2;
        t tVar3 = new t("BIG_DECIMAL", 3) { // from class: o1.t.d
            {
                a aVar2 = null;
            }

            @Override // o1.u
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(w1.a aVar2) throws IOException {
                String strV = aVar2.v();
                try {
                    return new BigDecimal(strV);
                } catch (NumberFormatException e3) {
                    throw new n("Cannot parse " + strV + "; at path " + aVar2.i(), e3);
                }
            }
        };
        f5457e = tVar3;
        f5458f = new t[]{aVar, tVar, tVar2, tVar3};
    }

    private t(String str, int i3) {
        super(str, i3);
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f5458f.clone();
    }

    /* synthetic */ t(String str, int i3, a aVar) {
        this(str, i3);
    }
}
