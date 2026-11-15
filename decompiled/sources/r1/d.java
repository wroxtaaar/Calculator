package r1;

import java.util.Date;

/* JADX INFO: compiled from: DefaultDateTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<T extends Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d<Date> f6072b = new a(Date.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f6073a;

    /* JADX INFO: compiled from: DefaultDateTypeAdapter.java */
    class a extends d<Date> {
        a(Class cls) {
            super(cls);
        }
    }

    protected d(Class<T> cls) {
        this.f6073a = cls;
    }
}
