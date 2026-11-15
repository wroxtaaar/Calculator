package r1;

import java.io.IOException;
import o1.r;
import o1.t;
import o1.u;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: NumberTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends v<Number> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final w f6092b = f(t.f5455c);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f6093a;

    /* JADX INFO: compiled from: NumberTypeAdapter.java */
    class a implements w {
        a() {
        }

        @Override // o1.w
        public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
            if (aVar.c() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: NumberTypeAdapter.java */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6095a;

        static {
            int[] iArr = new int[w1.b.values().length];
            f6095a = iArr;
            try {
                iArr[w1.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6095a[w1.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6095a[w1.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(u uVar) {
        this.f6093a = uVar;
    }

    public static w e(u uVar) {
        return uVar == t.f5455c ? f6092b : f(uVar);
    }

    private static w f(u uVar) {
        return new i(uVar).new a();
    }

    @Override // o1.v
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(w1.a aVar) throws IOException {
        w1.b bVarX = aVar.x();
        int i3 = b.f6095a[bVarX.ordinal()];
        if (i3 == 1) {
            aVar.t();
            return null;
        }
        if (i3 == 2 || i3 == 3) {
            return this.f6093a.a(aVar);
        }
        throw new r("Expecting number, got: " + bVarX);
    }

    @Override // o1.v
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(w1.c cVar, Number number) throws IOException {
        cVar.u(number);
    }
}
