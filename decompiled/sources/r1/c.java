package r1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o1.r;
import o1.v;
import o1.w;

/* JADX INFO: compiled from: DateTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends v<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f6070b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f6071a;

    /* JADX INFO: compiled from: DateTypeAdapter.java */
    class a implements w {
        a() {
        }

        @Override // o1.w
        public <T> v<T> a(o1.e eVar, v1.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f6071a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (q1.e.e()) {
            arrayList.add(q1.j.c(2, 2));
        }
    }

    private synchronized Date e(String str) {
        Iterator<DateFormat> it = this.f6071a.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return s1.a.c(str, new ParsePosition(0));
        } catch (ParseException e3) {
            throw new r(str, e3);
        }
    }

    @Override // o1.v
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(w1.a aVar) throws IOException {
        if (aVar.x() != w1.b.NULL) {
            return e(aVar.v());
        }
        aVar.t();
        return null;
    }

    @Override // o1.v
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized void d(w1.c cVar, Date date) throws IOException {
        try {
            if (date == null) {
                cVar.l();
            } else {
                cVar.v(this.f6071a.get(0).format(date));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
