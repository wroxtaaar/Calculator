package a0;

import android.os.Build;
import android.os.CancellationSignal;

/* JADX INFO: compiled from: CancellationSignal.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f0a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f1b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f2c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3d;

    /* JADX INFO: compiled from: CancellationSignal.java */
    public interface a {
        void a();
    }

    private void d() {
        while (this.f3d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f0a) {
                return;
            }
            this.f0a = true;
            this.f3d = true;
            a aVar = this.f1b;
            Object obj = this.f2c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f3d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f3d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z2;
        synchronized (this) {
            z2 = this.f0a;
        }
        return z2;
    }

    public void c(a aVar) {
        synchronized (this) {
            d();
            if (this.f1b == aVar) {
                return;
            }
            this.f1b = aVar;
            if (this.f0a && aVar != null) {
                aVar.a();
            }
        }
    }
}
