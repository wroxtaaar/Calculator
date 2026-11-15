package u1;

import java.sql.Timestamp;
import java.util.Date;
import o1.w;

/* JADX INFO: compiled from: SqlTypesSupport.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r1.d<? extends Date> f6287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r1.d<? extends Date> f6288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f6289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w f6290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f6291f;

    /* JADX INFO: compiled from: SqlTypesSupport.java */
    class a extends r1.d<java.sql.Date> {
        a(Class cls) {
            super(cls);
        }
    }

    /* JADX INFO: compiled from: SqlTypesSupport.java */
    class b extends r1.d<Timestamp> {
        b(Class cls) {
            super(cls);
        }
    }

    static {
        boolean z2;
        try {
            Class.forName("java.sql.Date");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f6286a = z2;
        if (z2) {
            f6287b = new a(java.sql.Date.class);
            f6288c = new b(Timestamp.class);
            f6289d = u1.a.f6280b;
            f6290e = u1.b.f6282b;
            f6291f = c.f6284b;
            return;
        }
        f6287b = null;
        f6288c = null;
        f6289d = null;
        f6290e = null;
        f6291f = null;
    }
}
