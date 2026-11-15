package androidx.appcompat.widget;

/* JADX INFO: compiled from: RtlSpacingHelper.java */
/* JADX INFO: loaded from: classes.dex */
class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f705a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f706b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f707c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f708d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f709e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f710f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f711g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f712h = false;

    o0() {
    }

    public int a() {
        return this.f711g ? this.f705a : this.f706b;
    }

    public int b() {
        return this.f705a;
    }

    public int c() {
        return this.f706b;
    }

    public int d() {
        return this.f711g ? this.f706b : this.f705a;
    }

    public void e(int i3, int i4) {
        this.f712h = false;
        if (i3 != Integer.MIN_VALUE) {
            this.f709e = i3;
            this.f705a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f710f = i4;
            this.f706b = i4;
        }
    }

    public void f(boolean z2) {
        if (z2 == this.f711g) {
            return;
        }
        this.f711g = z2;
        if (!this.f712h) {
            this.f705a = this.f709e;
            this.f706b = this.f710f;
            return;
        }
        if (z2) {
            int i3 = this.f708d;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f709e;
            }
            this.f705a = i3;
            int i4 = this.f707c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f710f;
            }
            this.f706b = i4;
            return;
        }
        int i5 = this.f707c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f709e;
        }
        this.f705a = i5;
        int i6 = this.f708d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.f710f;
        }
        this.f706b = i6;
    }

    public void g(int i3, int i4) {
        this.f707c = i3;
        this.f708d = i4;
        this.f712h = true;
        if (this.f711g) {
            if (i4 != Integer.MIN_VALUE) {
                this.f705a = i4;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.f706b = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f705a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f706b = i4;
        }
    }
}
