package b0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: RequestExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: compiled from: RequestExecutor.java */
    private static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2412b;

        /* JADX INFO: renamed from: b0.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RequestExecutor.java */
        private static class C0028a extends Thread {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f2413b;

            C0028a(Runnable runnable, String str, int i3) {
                super(runnable, str);
                this.f2413b = i3;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f2413b);
                super.run();
            }
        }

        a(String str, int i3) {
            this.f2411a = str;
            this.f2412b = i3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0028a(runnable, this.f2411a, this.f2412b);
        }
    }

    /* JADX INFO: compiled from: RequestExecutor.java */
    private static class b<T> implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Callable<T> f2414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d0.a<T> f2415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Handler f2416d;

        /* JADX INFO: compiled from: RequestExecutor.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d0.a f2417b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f2418c;

            a(d0.a aVar, Object obj) {
                this.f2417b = aVar;
                this.f2418c = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f2417b.a(this.f2418c);
            }
        }

        b(Handler handler, Callable<T> callable, d0.a<T> aVar) {
            this.f2414b = callable;
            this.f2415c = aVar;
            this.f2416d = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T tCall;
            try {
                tCall = this.f2414b.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f2416d.post(new a(this.f2415c, tCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i3, int i4) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i4, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i3));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(Executor executor, Callable<T> callable, d0.a<T> aVar) {
        executor.execute(new b(b0.b.a(), callable, aVar));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int i3) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            throw e3;
        } catch (ExecutionException e4) {
            throw new RuntimeException(e4);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
