package t1;

import java.lang.reflect.AccessibleObject;
import q1.e;

/* JADX INFO: compiled from: ReflectionAccessor.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f6235a;

    static {
        f6235a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f6235a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
