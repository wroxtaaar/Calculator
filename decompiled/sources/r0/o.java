package r0;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RequestQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f6037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<n<?>> f6038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<n<?>> f6039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<n<?>> f6040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r0.b f6041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f6042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final q f6043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final i[] f6044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private r0.c f6045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<c> f6046j;

    /* JADX INFO: compiled from: RequestQueue.java */
    class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6047a;

        a(Object obj) {
            this.f6047a = obj;
        }

        @Override // r0.o.b
        public boolean a(n<?> nVar) {
            return nVar.x() == this.f6047a;
        }
    }

    /* JADX INFO: compiled from: RequestQueue.java */
    public interface b {
        boolean a(n<?> nVar);
    }

    /* JADX INFO: compiled from: RequestQueue.java */
    public interface c<T> {
        void a(n<T> nVar);
    }

    public o(r0.b bVar, h hVar, int i3, q qVar) {
        this.f6037a = new AtomicInteger();
        this.f6038b = new HashSet();
        this.f6039c = new PriorityBlockingQueue<>();
        this.f6040d = new PriorityBlockingQueue<>();
        this.f6046j = new ArrayList();
        this.f6041e = bVar;
        this.f6042f = hVar;
        this.f6044h = new i[i3];
        this.f6043g = qVar;
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.K(this);
        synchronized (this.f6038b) {
            this.f6038b.add(nVar);
        }
        nVar.M(e());
        nVar.b("add-to-queue");
        if (nVar.P()) {
            this.f6039c.add(nVar);
            return nVar;
        }
        this.f6040d.add(nVar);
        return nVar;
    }

    public void b(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        c(new a(obj));
    }

    public void c(b bVar) {
        synchronized (this.f6038b) {
            for (n<?> nVar : this.f6038b) {
                if (bVar.a(nVar)) {
                    nVar.c();
                }
            }
        }
    }

    <T> void d(n<T> nVar) {
        synchronized (this.f6038b) {
            this.f6038b.remove(nVar);
        }
        synchronized (this.f6046j) {
            Iterator<c> it = this.f6046j.iterator();
            while (it.hasNext()) {
                it.next().a(nVar);
            }
        }
    }

    public int e() {
        return this.f6037a.incrementAndGet();
    }

    public void f() {
        g();
        r0.c cVar = new r0.c(this.f6039c, this.f6040d, this.f6041e, this.f6043g);
        this.f6045i = cVar;
        cVar.start();
        for (int i3 = 0; i3 < this.f6044h.length; i3++) {
            i iVar = new i(this.f6040d, this.f6042f, this.f6041e, this.f6043g);
            this.f6044h[i3] = iVar;
            iVar.start();
        }
    }

    public void g() {
        r0.c cVar = this.f6045i;
        if (cVar != null) {
            cVar.e();
        }
        for (i iVar : this.f6044h) {
            if (iVar != null) {
                iVar.e();
            }
        }
    }

    public o(r0.b bVar, h hVar, int i3) {
        this(bVar, hVar, i3, new f(new Handler(Looper.getMainLooper())));
    }

    public o(r0.b bVar, h hVar) {
        this(bVar, hVar, 4);
    }
}
