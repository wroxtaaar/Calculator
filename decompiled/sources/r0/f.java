package r0;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutorDelivery.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f5994a;

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f5995a;

        a(Handler handler) {
            this.f5995a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f5995a.post(runnable);
        }
    }

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    private static class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n f5997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final p f5998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Runnable f5999d;

        public b(n nVar, p pVar, Runnable runnable) {
            this.f5997b = nVar;
            this.f5998c = pVar;
            this.f5999d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5997b.C()) {
                this.f5997b.i("canceled-at-delivery");
                return;
            }
            if (this.f5998c.b()) {
                this.f5997b.f(this.f5998c.f6049a);
            } else {
                this.f5997b.e(this.f5998c.f6051c);
            }
            if (this.f5998c.f6052d) {
                this.f5997b.b("intermediate-response");
            } else {
                this.f5997b.i("done");
            }
            Runnable runnable = this.f5999d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f5994a = new a(handler);
    }

    @Override // r0.q
    public void a(n<?> nVar, u uVar) {
        nVar.b("post-error");
        this.f5994a.execute(new b(nVar, p.a(uVar), null));
    }

    @Override // r0.q
    public void b(n<?> nVar, p<?> pVar, Runnable runnable) {
        nVar.D();
        nVar.b("post-response");
        this.f5994a.execute(new b(nVar, pVar, runnable));
    }

    @Override // r0.q
    public void c(n<?> nVar, p<?> pVar) {
        b(nVar, pVar, null);
    }
}
