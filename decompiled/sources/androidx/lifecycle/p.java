package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f1573a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1574b = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    final void a() {
        this.f1574b = true;
        Map<String, Object> map = this.f1573a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f1573a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        d();
    }

    <T> T c(String str) {
        T t3;
        Map<String, Object> map = this.f1573a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t3 = (T) this.f1573a.get(str);
        }
        return t3;
    }

    protected void d() {
    }
}
