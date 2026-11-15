package w2;

/* JADX INFO: compiled from: Spring.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f6393m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f6394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0096b f6397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0096b f6398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C0096b f6399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f6400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f6401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6402i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f6403j = 0.005d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f6404k = 0.005d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private double f6405l = 0.0d;

    /* JADX INFO: renamed from: w2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Spring.java */
    private static class C0096b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f6406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f6407b;

        private C0096b() {
        }
    }

    public b() {
        this.f6397d = new C0096b();
        this.f6398e = new C0096b();
        this.f6399f = new C0096b();
        StringBuilder sb = new StringBuilder();
        sb.append("spring:");
        int i3 = f6393m;
        f6393m = i3 + 1;
        sb.append(i3);
        this.f6396c = sb.toString();
        l(c.f6408c);
    }

    private double c(C0096b c0096b) {
        return Math.abs(this.f6401h - c0096b.f6406a);
    }

    private void e(double d3) {
        C0096b c0096b = this.f6397d;
        double d4 = c0096b.f6406a * d3;
        C0096b c0096b2 = this.f6398e;
        double d5 = 1.0d - d3;
        c0096b.f6406a = d4 + (c0096b2.f6406a * d5);
        c0096b.f6407b = (c0096b.f6407b * d3) + (c0096b2.f6407b * d5);
    }

    public void a(double d3) {
        double d4;
        boolean z2;
        boolean zF = f();
        if (zF && this.f6402i) {
            return;
        }
        this.f6405l += d3 <= 0.064d ? d3 : 0.064d;
        c cVar = this.f6394a;
        double d5 = cVar.f6410b;
        double d6 = cVar.f6409a;
        C0096b c0096b = this.f6397d;
        double d7 = c0096b.f6406a;
        double d8 = c0096b.f6407b;
        C0096b c0096b2 = this.f6399f;
        double d9 = c0096b2.f6406a;
        double d10 = c0096b2.f6407b;
        while (true) {
            d4 = this.f6405l;
            if (d4 < 0.001d) {
                break;
            }
            double d11 = d4 - 0.001d;
            this.f6405l = d11;
            if (d11 < 0.001d) {
                C0096b c0096b3 = this.f6398e;
                c0096b3.f6406a = d7;
                c0096b3.f6407b = d8;
            }
            double d12 = this.f6401h;
            double d13 = ((d12 - d9) * d5) - (d6 * d8);
            double d14 = d8 + (d13 * 0.001d * 0.5d);
            double d15 = ((d12 - (((d8 * 0.001d) * 0.5d) + d7)) * d5) - (d6 * d14);
            double d16 = d8 + (d15 * 0.001d * 0.5d);
            double d17 = ((d12 - (d7 + ((d14 * 0.001d) * 0.5d))) * d5) - (d6 * d16);
            double d18 = d7 + (d16 * 0.001d);
            double d19 = d8 + (d17 * 0.001d);
            d7 += (d8 + ((d14 + d16) * 2.0d) + d19) * 0.16666666666666666d * 0.001d;
            d8 += (d13 + ((d15 + d17) * 2.0d) + (((d12 - d18) * d5) - (d6 * d19))) * 0.16666666666666666d * 0.001d;
            d9 = d18;
            d10 = d19;
        }
        C0096b c0096b4 = this.f6399f;
        c0096b4.f6406a = d9;
        c0096b4.f6407b = d10;
        C0096b c0096b5 = this.f6397d;
        c0096b5.f6406a = d7;
        c0096b5.f6407b = d8;
        if (d4 > 0.0d) {
            e(d4 / 0.001d);
        }
        if (f() || (this.f6395b && g())) {
            if (d5 > 0.0d) {
                double d20 = this.f6401h;
                this.f6400g = d20;
                this.f6397d.f6406a = d20;
            } else {
                double d21 = this.f6397d.f6406a;
                this.f6401h = d21;
                this.f6400g = d21;
            }
            m(0.0d);
            z2 = true;
        } else {
            z2 = zF;
        }
        if (this.f6402i) {
            this.f6402i = false;
        }
        if (z2) {
            this.f6402i = true;
        }
    }

    public double b() {
        return this.f6397d.f6406a;
    }

    public double d() {
        return this.f6401h;
    }

    public boolean f() {
        return Math.abs(this.f6397d.f6407b) <= this.f6403j && (c(this.f6397d) <= this.f6404k || this.f6394a.f6410b == 0.0d);
    }

    public boolean g() {
        return this.f6394a.f6410b > 0.0d && ((this.f6400g < this.f6401h && b() > this.f6401h) || (this.f6400g > this.f6401h && b() < this.f6401h));
    }

    public b h() {
        C0096b c0096b = this.f6397d;
        double d3 = c0096b.f6406a;
        this.f6401h = d3;
        this.f6399f.f6406a = d3;
        c0096b.f6407b = 0.0d;
        return this;
    }

    public b i(double d3) {
        return j(d3, true);
    }

    public b j(double d3, boolean z2) {
        this.f6400g = d3;
        this.f6397d.f6406a = d3;
        if (z2) {
            h();
        }
        return this;
    }

    public b k(double d3) {
        if (this.f6401h == d3 && f()) {
            return this;
        }
        this.f6400g = b();
        this.f6401h = d3;
        return this;
    }

    public b l(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.f6394a = cVar;
        return this;
    }

    public b m(double d3) {
        C0096b c0096b = this.f6397d;
        if (d3 == c0096b.f6407b) {
            return this;
        }
        c0096b.f6407b = d3;
        return this;
    }
}
