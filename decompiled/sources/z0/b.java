package z0;

import android.app.Activity;

/* JADX INFO: compiled from: DynamicColorsOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final z0.a.f f6607d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final z0.a.e f6608e = new C0101b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z0.a.f f6610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z0.a.e f6611c;

    /* JADX INFO: compiled from: DynamicColorsOptions.java */
    class a implements z0.a.f {
        a() {
        }

        @Override // z0.a.f
        public boolean a(Activity activity, int i3) {
            return true;
        }
    }

    /* JADX INFO: renamed from: z0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DynamicColorsOptions.java */
    class C0101b implements z0.a.e {
        C0101b() {
        }

        @Override // z0.a.e
        public void a(Activity activity) {
        }
    }

    /* JADX INFO: compiled from: DynamicColorsOptions.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private z0.a.f f6613b = b.f6607d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private z0.a.e f6614c = b.f6608e;

        public b d() {
            return new b(this, null);
        }
    }

    /* synthetic */ b(c cVar, a aVar) {
        this(cVar);
    }

    public z0.a.e c() {
        return this.f6611c;
    }

    public z0.a.f d() {
        return this.f6610b;
    }

    public int e() {
        return this.f6609a;
    }

    private b(c cVar) {
        this.f6609a = cVar.f6612a;
        this.f6610b = cVar.f6613b;
        this.f6611c = cVar.f6614c;
    }
}
