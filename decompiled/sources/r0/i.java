package r0;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: NetworkDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends Thread {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<n<?>> f6002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f6003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f6004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f6005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f6006f = false;

    public i(BlockingQueue<n<?>> blockingQueue, h hVar, b bVar, q qVar) {
        this.f6002b = blockingQueue;
        this.f6003c = hVar;
        this.f6004d = bVar;
        this.f6005e = qVar;
    }

    @TargetApi(14)
    private void a(n<?> nVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(nVar.z());
        }
    }

    private void b(n<?> nVar, u uVar) {
        this.f6005e.a(nVar, nVar.G(uVar));
    }

    private void c() throws InterruptedException {
        d(this.f6002b.take());
    }

    @VisibleForTesting
    void d(n<?> nVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            nVar.b("network-queue-take");
            if (nVar.C()) {
                nVar.i("network-discard-cancelled");
                nVar.E();
                return;
            }
            a(nVar);
            k kVarA = this.f6003c.a(nVar);
            nVar.b("network-http-complete");
            if (kVarA.f6011e && nVar.B()) {
                nVar.i("not-modified");
                nVar.E();
                return;
            }
            p<?> pVarH = nVar.H(kVarA);
            nVar.b("network-parse-complete");
            if (nVar.P() && pVarH.f6050b != null) {
                this.f6004d.b(nVar.m(), pVarH.f6050b);
                nVar.b("network-cache-written");
            }
            nVar.D();
            this.f6005e.c(nVar, pVarH);
            nVar.F(pVarH);
        } catch (u e3) {
            e3.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            b(nVar, e3);
            nVar.E();
        } catch (Exception e4) {
            v.d(e4, "Unhandled exception %s", e4.toString());
            u uVar = new u(e4);
            uVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.f6005e.a(nVar, uVar);
            nVar.E();
        }
    }

    public void e() {
        this.f6006f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f6006f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                v.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
