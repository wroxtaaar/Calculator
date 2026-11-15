package u1;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import o1.e;
import o1.r;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: SqlDateTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
final class a extends v<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final w f6280b = new C0091a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f6281a;

    /* JADX INFO: renamed from: u1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SqlDateTypeAdapter.java */
    class C0091a implements w {
        C0091a() {
        }

        @Override // o1.w
        public <T> v<T> a(e eVar, v1.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            C0091a c0091a = null;
            if (clsC == Date.class) {
                return new a(c0091a);
            }
            return null;
        }
    }

    /* synthetic */ a(C0091a c0091a) {
        this();
    }

    @Override // o1.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Date b(w1.a aVar) throws IOException {
        if (aVar.x() == w1.b.NULL) {
            aVar.t();
            return null;
        }
        try {
            return new Date(this.f6281a.parse(aVar.v()).getTime());
        } catch (ParseException e3) {
            throw new r(e3);
        }
    }

    @Override // o1.v
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(w1.c cVar, Date date) throws IOException {
        cVar.v(date == null ? null : this.f6281a.format((java.util.Date) date));
    }

    private a() {
        this.f6281a = new SimpleDateFormat("MMM d, yyyy");
    }
}
