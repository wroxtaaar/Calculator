package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Object f1521j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f1522a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j.b<m<? super T>, LiveData<T>.b> f1523b = new j.b<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1524c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Object f1525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile Object f1526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f1530i;

    class LifecycleBoundObserver extends LiveData<T>.b implements e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final g f1531e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f1532f;

        @Override // androidx.lifecycle.e
        public void d(g gVar, d.a aVar) {
            if (this.f1531e.b().b() == d.b.DESTROYED) {
                this.f1532f.f(this.f1534a);
            } else {
                h(j());
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        void i() {
            this.f1531e.b().c(this);
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean j() {
            return this.f1531e.b().b().a(d.b.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1522a) {
                obj = LiveData.this.f1526e;
                LiveData.this.f1526e = LiveData.f1521j;
            }
            LiveData.this.g(obj);
        }
    }

    private abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final m<? super T> f1534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveData f1537d;

        void h(boolean z2) {
            if (z2 == this.f1535b) {
                return;
            }
            this.f1535b = z2;
            LiveData liveData = this.f1537d;
            int i3 = liveData.f1524c;
            boolean z3 = i3 == 0;
            liveData.f1524c = i3 + (z2 ? 1 : -1);
            if (z3 && z2) {
                liveData.d();
            }
            LiveData liveData2 = this.f1537d;
            if (liveData2.f1524c == 0 && !this.f1535b) {
                liveData2.e();
            }
            if (this.f1535b) {
                this.f1537d.c(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public LiveData() {
        Object obj = f1521j;
        this.f1526e = obj;
        this.f1530i = new a();
        this.f1525d = obj;
        this.f1527f = -1;
    }

    static void a(String str) {
        if (i.a.d().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.b bVar) {
        if (bVar.f1535b) {
            if (!bVar.j()) {
                bVar.h(false);
                return;
            }
            int i3 = bVar.f1536c;
            int i4 = this.f1527f;
            if (i3 >= i4) {
                return;
            }
            bVar.f1536c = i4;
            bVar.f1534a.a((Object) this.f1525d);
        }
    }

    void c(LiveData<T>.b bVar) {
        if (this.f1528g) {
            this.f1529h = true;
            return;
        }
        this.f1528g = true;
        do {
            this.f1529h = false;
            if (bVar != null) {
                b(bVar);
                bVar = null;
            } else {
                j.b<m<? super T>, LiveData<T>.b>.d dVarD = this.f1523b.d();
                while (dVarD.hasNext()) {
                    b((b) dVarD.next().getValue());
                    if (this.f1529h) {
                        break;
                    }
                }
            }
        } while (this.f1529h);
        this.f1528g = false;
    }

    protected void d() {
    }

    protected void e() {
    }

    public void f(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.b bVarH = this.f1523b.h(mVar);
        if (bVarH == null) {
            return;
        }
        bVarH.i();
        bVarH.h(false);
    }

    protected void g(T t3) {
        a("setValue");
        this.f1527f++;
        this.f1525d = t3;
        c(null);
    }
}
