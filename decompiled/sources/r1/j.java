package r1;

import java.io.IOException;
import java.util.ArrayList;
import o1.t;
import o1.u;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: ObjectTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends v<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final w f6096c = f(t.f5454b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o1.e f6097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f6098b;

    /* JADX INFO: compiled from: ObjectTypeAdapter.java */
    class a implements w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f6099b;

        a(u uVar) {
            this.f6099b = uVar;
        }

        @Override // o1.w
        public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Object.class) {
                return new j(eVar, this.f6099b, aVar2);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ObjectTypeAdapter.java */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6100a;

        static {
            int[] iArr = new int[w1.b.values().length];
            f6100a = iArr;
            try {
                iArr[w1.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6100a[w1.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6100a[w1.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6100a[w1.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6100a[w1.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6100a[w1.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ j(o1.e eVar, u uVar, a aVar) {
        this(eVar, uVar);
    }

    public static w e(u uVar) {
        return uVar == t.f5454b ? f6096c : f(uVar);
    }

    private static w f(u uVar) {
        return new a(uVar);
    }

    @Override // o1.v
    public Object b(w1.a aVar) throws IOException {
        switch (b.f6100a[aVar.x().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.j()) {
                    arrayList.add(b(aVar));
                }
                aVar.f();
                return arrayList;
            case 2:
                q1.h hVar = new q1.h();
                aVar.b();
                while (aVar.j()) {
                    hVar.put(aVar.r(), b(aVar));
                }
                aVar.g();
                return hVar;
            case 3:
                return aVar.v();
            case 4:
                return this.f6098b.a(aVar);
            case 5:
                return Boolean.valueOf(aVar.n());
            case 6:
                aVar.t();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // o1.v
    public void d(w1.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.l();
            return;
        }
        v vVarK = this.f6097a.k(obj.getClass());
        if (!(vVarK instanceof j)) {
            vVarK.d(cVar, obj);
        } else {
            cVar.d();
            cVar.g();
        }
    }

    private j(o1.e eVar, u uVar) {
        this.f6097a = eVar;
        this.f6098b = uVar;
    }
}
