package q1;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: Excluder.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements w, Cloneable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f5886h = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5890e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f5887b = -1.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5888c = 136;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5889d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<o1.a> f5891f = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<o1.a> f5892g = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Excluder.java */
    class a<T> extends v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v<T> f5893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f5894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o1.e f5896d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ v1.a f5897e;

        a(boolean z2, boolean z3, o1.e eVar, v1.a aVar) {
            this.f5894b = z2;
            this.f5895c = z3;
            this.f5896d = eVar;
            this.f5897e = aVar;
        }

        private v<T> e() {
            v<T> vVar = this.f5893a;
            if (vVar != null) {
                return vVar;
            }
            v<T> vVarM = this.f5896d.m(d.this, this.f5897e);
            this.f5893a = vVarM;
            return vVarM;
        }

        @Override // o1.v
        public T b(w1.a aVar) throws IOException {
            if (!this.f5894b) {
                return e().b(aVar);
            }
            aVar.H();
            return null;
        }

        @Override // o1.v
        public void d(w1.c cVar, T t3) throws IOException {
            if (this.f5895c) {
                cVar.l();
            } else {
                e().d(cVar, t3);
            }
        }
    }

    private boolean d(Class<?> cls) {
        if (this.f5887b == -1.0d || l((p1.d) cls.getAnnotation(p1.d.class), (p1.e) cls.getAnnotation(p1.e.class))) {
            return (!this.f5889d && h(cls)) || g(cls);
        }
        return true;
    }

    private boolean e(Class<?> cls, boolean z2) {
        Iterator<o1.a> it = (z2 ? this.f5891f : this.f5892g).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean g(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean h(Class<?> cls) {
        return cls.isMemberClass() && !i(cls);
    }

    private boolean i(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean j(p1.d dVar) {
        return dVar == null || dVar.value() <= this.f5887b;
    }

    private boolean k(p1.e eVar) {
        return eVar == null || eVar.value() > this.f5887b;
    }

    private boolean l(p1.d dVar, p1.e eVar) {
        return j(dVar) && k(eVar);
    }

    @Override // o1.w
    public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
        Class<? super T> clsC = aVar.c();
        boolean zD = d(clsC);
        boolean z2 = zD || e(clsC, true);
        boolean z3 = zD || e(clsC, false);
        if (z2 || z3) {
            return new a(z3, z2, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public boolean c(Class<?> cls, boolean z2) {
        return d(cls) || e(cls, z2);
    }

    public boolean f(Field field, boolean z2) {
        p1.a aVar;
        if ((this.f5888c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f5887b != -1.0d && !l((p1.d) field.getAnnotation(p1.d.class), (p1.e) field.getAnnotation(p1.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f5890e && ((aVar = (p1.a) field.getAnnotation(p1.a.class)) == null || (!z2 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f5889d && h(field.getType())) || g(field.getType())) {
            return true;
        }
        List<o1.a> list = z2 ? this.f5891f : this.f5892g;
        if (list.isEmpty()) {
            return false;
        }
        o1.b bVar = new o1.b(field);
        Iterator<o1.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(bVar)) {
                return true;
            }
        }
        return false;
    }
}
