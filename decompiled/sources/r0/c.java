package r0;

import android.os.Process;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: CacheDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Thread {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f5979h = v.f6056b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<n<?>> f5980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BlockingQueue<n<?>> f5981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r0.b f5982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f5983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f5984f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f5985g = new b(this);

    /* JADX INFO: compiled from: CacheDispatcher.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f5986b;

        a(n nVar) {
            this.f5986b = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f5981c.put(this.f5986b);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: compiled from: CacheDispatcher.java */
    private static class b implements n.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, List<n<?>>> f5988a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f5989b;

        b(c cVar) {
            this.f5989b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean d(n<?> nVar) {
            String strM = nVar.m();
            if (!this.f5988a.containsKey(strM)) {
                this.f5988a.put(strM, null);
                nVar.J(this);
                if (v.f6056b) {
                    v.b("new request, sending to network %s", strM);
                }
                return false;
            }
            List<n<?>> arrayList = this.f5988a.get(strM);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            nVar.b("waiting-for-response");
            arrayList.add(nVar);
            this.f5988a.put(strM, arrayList);
            if (v.f6056b) {
                v.b("Request for cacheKey=%s is in flight, putting on hold.", strM);
            }
            return true;
        }

        @Override // r0.n.b
        public void a(n<?> nVar, p<?> pVar) {
            List<n<?>> listRemove;
            r0.b.a aVar = pVar.f6050b;
            if (aVar == null || aVar.a()) {
                b(nVar);
                return;
            }
            String strM = nVar.m();
            synchronized (this) {
                listRemove = this.f5988a.remove(strM);
            }
            if (listRemove != null) {
                if (v.f6056b) {
                    v.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), strM);
                }
                Iterator<n<?>> it = listRemove.iterator();
                while (it.hasNext()) {
                    this.f5989b.f5983e.c(it.next(), pVar);
                }
            }
        }

        @Override // r0.n.b
        public synchronized void b(n<?> nVar) {
            try {
                String strM = nVar.m();
                List<n<?>> listRemove = this.f5988a.remove(strM);
                if (listRemove != null && !listRemove.isEmpty()) {
                    if (v.f6056b) {
                        v.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), strM);
                    }
                    n<?> nVarRemove = listRemove.remove(0);
                    this.f5988a.put(strM, listRemove);
                    nVarRemove.J(this);
                    try {
                        this.f5989b.f5981c.put(nVarRemove);
                    } catch (InterruptedException e3) {
                        v.c("Couldn't add request to queue. %s", e3.toString());
                        Thread.currentThread().interrupt();
                        this.f5989b.e();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, r0.b bVar, q qVar) {
        this.f5980b = blockingQueue;
        this.f5981c = blockingQueue2;
        this.f5982d = bVar;
        this.f5983e = qVar;
    }

    private void c() throws InterruptedException {
        d(this.f5980b.take());
    }

    @VisibleForTesting
    void d(n<?> nVar) throws InterruptedException {
        nVar.b("cache-queue-take");
        if (nVar.C()) {
            nVar.i("cache-discard-canceled");
            return;
        }
        r0.b.a aVarC = this.f5982d.c(nVar.m());
        if (aVarC == null) {
            nVar.b("cache-miss");
            if (this.f5985g.d(nVar)) {
                return;
            }
            this.f5981c.put(nVar);
            return;
        }
        if (aVarC.a()) {
            nVar.b("cache-hit-expired");
            nVar.I(aVarC);
            if (this.f5985g.d(nVar)) {
                return;
            }
            this.f5981c.put(nVar);
            return;
        }
        nVar.b("cache-hit");
        p<?> pVarH = nVar.H(new k(aVarC.f5971a, aVarC.f5977g));
        nVar.b("cache-hit-parsed");
        if (!aVarC.b()) {
            this.f5983e.c(nVar, pVarH);
            return;
        }
        nVar.b("cache-hit-refresh-needed");
        nVar.I(aVarC);
        pVarH.f6052d = true;
        if (this.f5985g.d(nVar)) {
            this.f5983e.c(nVar, pVarH);
        } else {
            this.f5983e.b(nVar, pVarH, new a(nVar));
        }
    }

    public void e() {
        this.f5984f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f5979h) {
            v.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f5982d.a();
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f5984f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
