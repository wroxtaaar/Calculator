package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: OnBackPressedCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f36a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f37b = new CopyOnWriteArrayList<>();

    public b(boolean z2) {
        this.f36a = z2;
    }

    void a(a aVar) {
        this.f37b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f36a;
    }

    public final void d() {
        Iterator<a> it = this.f37b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    void e(a aVar) {
        this.f37b.remove(aVar);
    }

    public final void f(boolean z2) {
        this.f36a = z2;
    }
}
