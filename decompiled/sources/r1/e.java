package r1;

import o1.q;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q1.c f6074b;

    public e(q1.c cVar) {
        this.f6074b = cVar;
    }

    @Override // o1.w
    public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
        p1.b bVar = (p1.b) aVar.c().getAnnotation(p1.b.class);
        if (bVar == null) {
            return null;
        }
        return (v<T>) b(this.f6074b, eVar, aVar, bVar);
    }

    v<?> b(q1.c cVar, o1.e eVar, v1.a<?> aVar, p1.b bVar) {
        v<?> lVar;
        Object objA = cVar.a(v1.a.a(bVar.value())).a();
        if (objA instanceof v) {
            lVar = (v) objA;
        } else if (objA instanceof w) {
            lVar = ((w) objA).a(eVar, aVar);
        } else {
            boolean z2 = objA instanceof q;
            if (!z2 && !(objA instanceof o1.i)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z2 ? (q) objA : null, objA instanceof o1.i ? (o1.i) objA : null, eVar, aVar, null);
        }
        return (lVar == null || !bVar.nullSafe()) ? lVar : lVar.a();
    }
}
