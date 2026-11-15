package i;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ArchTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f4872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Executor f4873d = new ExecutorC0065a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f4874e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f4875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f4876b;

    /* JADX INFO: renamed from: i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArchTaskExecutor.java */
    static class ExecutorC0065a implements Executor {
        ExecutorC0065a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().c(runnable);
        }
    }

    /* JADX INFO: compiled from: ArchTaskExecutor.java */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().a(runnable);
        }
    }

    private a() {
        i.b bVar = new i.b();
        this.f4876b = bVar;
        this.f4875a = bVar;
    }

    public static a d() {
        if (f4872c != null) {
            return f4872c;
        }
        synchronized (a.class) {
            if (f4872c == null) {
                f4872c = new a();
            }
        }
        return f4872c;
    }

    @Override // i.c
    public void a(Runnable runnable) {
        this.f4875a.a(runnable);
    }

    @Override // i.c
    public boolean b() {
        return this.f4875a.b();
    }

    @Override // i.c
    public void c(Runnable runnable) {
        this.f4875a.c(runnable);
    }
}
