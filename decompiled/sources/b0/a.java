package b0;

import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: compiled from: CallbackWithHandler.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f.c f2373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f2374b;

    /* JADX INFO: renamed from: b0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CallbackWithHandler.java */
    class RunnableC0026a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.c f2375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Typeface f2376c;

        RunnableC0026a(f.c cVar, Typeface typeface) {
            this.f2375b = cVar;
            this.f2376c = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2375b.b(this.f2376c);
        }
    }

    /* JADX INFO: compiled from: CallbackWithHandler.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.c f2378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2379c;

        b(f.c cVar, int i3) {
            this.f2378b = cVar;
            this.f2379c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2378b.a(this.f2379c);
        }
    }

    a(f.c cVar, Handler handler) {
        this.f2373a = cVar;
        this.f2374b = handler;
    }

    private void a(int i3) {
        this.f2374b.post(new b(this.f2373a, i3));
    }

    private void c(Typeface typeface) {
        this.f2374b.post(new RunnableC0026a(this.f2373a, typeface));
    }

    void b(e.C0027e c0027e) {
        if (c0027e.a()) {
            c(c0027e.f2402a);
        } else {
            a(c0027e.f2403b);
        }
    }
}
