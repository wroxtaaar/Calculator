package u1;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import o1.e;
import o1.r;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: SqlTimeTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends v<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final w f6282b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f6283a;

    /* JADX INFO: compiled from: SqlTimeTypeAdapter.java */
    class a implements w {
        a() {
        }

        @Override // o1.w
        public <T> v<T> a(e eVar, v1.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            a aVar2 = null;
            if (clsC == Time.class) {
                return new b(aVar2);
            }
            return null;
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    @Override // o1.v
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Time b(w1.a aVar) throws IOException {
        if (aVar.x() == w1.b.NULL) {
            aVar.t();
            return null;
        }
        try {
            return new Time(this.f6283a.parse(aVar.v()).getTime());
        } catch (ParseException e3) {
            throw new r(e3);
        }
    }

    @Override // o1.v
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(w1.c cVar, Time time) throws IOException {
        cVar.v(time == null ? null : this.f6283a.format((Date) time));
    }

    private b() {
        this.f6283a = new SimpleDateFormat("hh:mm:ss a");
    }
}
