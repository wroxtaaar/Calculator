package u1;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import o1.e;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: SqlTimestampTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class c extends v<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final w f6284b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v<Date> f6285a;

    /* JADX INFO: compiled from: SqlTimestampTypeAdapter.java */
    class a implements w {
        a() {
        }

        @Override // o1.w
        public <T> v<T> a(e eVar, v1.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Timestamp.class) {
                return new c(eVar.k(Date.class), aVar2);
            }
            return null;
        }
    }

    /* synthetic */ c(v vVar, a aVar) {
        this(vVar);
    }

    @Override // o1.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(w1.a aVar) throws IOException {
        Date dateB = this.f6285a.b(aVar);
        if (dateB != null) {
            return new Timestamp(dateB.getTime());
        }
        return null;
    }

    @Override // o1.v
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(w1.c cVar, Timestamp timestamp) throws IOException {
        this.f6285a.d(cVar, timestamp);
    }

    private c(v<Date> vVar) {
        this.f6285a = vVar;
    }
}
