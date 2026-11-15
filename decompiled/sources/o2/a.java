package o2;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: Spring.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f5460p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static double f5461q = 0.064d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o2.b f5462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5463b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f5466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f5467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f5468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f5469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f5470i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f5476o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f5464c = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5471j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f5472k = 0.005d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private double f5473l = 0.005d;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CopyOnWriteArraySet<c> f5474m = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private double f5475n = 0.0d;

    /* JADX INFO: compiled from: Spring.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f5477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f5478b;

        private b() {
        }
    }

    public a() {
        this.f5466e = new b();
        this.f5467f = new b();
        this.f5468g = new b();
        this.f5476o = true;
        StringBuilder sb = new StringBuilder();
        sb.append("spring:");
        int i3 = f5460p;
        f5460p = i3 + 1;
        sb.append(i3);
        this.f5465d = sb.toString();
        this.f5476o = false;
        q(o2.b.f5479e);
    }

    private double c(b bVar) {
        return Math.abs(this.f5470i - bVar.f5477a);
    }

    private void f(double d3) {
        b bVar = this.f5466e;
        double d4 = bVar.f5477a * d3;
        b bVar2 = this.f5467f;
        double d5 = 1.0d - d3;
        bVar.f5477a = d4 + (bVar2.f5477a * d5);
        bVar.f5478b = (bVar.f5478b * d3) + (bVar2.f5478b * d5);
    }

    private void n() {
        r2.a.a("ReboundSpring", "setMaxDeltaTimeSec");
        WeakReference<Context> weakReference = this.f5464c;
        if (weakReference == null) {
            r2.a.a("ReboundSpring", "null == mContextWeakReference");
            return;
        }
        Context context = weakReference.get();
        if (context == null) {
            r2.a.a("ReboundSpring", "null == context");
            return;
        }
        int iB = r2.b.b(context);
        if (iB == 30) {
            f5461q = 0.125d;
        } else if (iB == 60) {
            f5461q = 0.064d;
        } else if (iB == 72) {
            f5461q = 0.052d;
        } else if (iB == 90) {
            f5461q = 0.041d;
        } else if (iB == 120) {
            f5461q = 0.032d;
        } else if (iB == 144) {
            f5461q = 0.026d;
        }
        r2.a.a("ReboundSpring", "MAX_DELTA_TIME_SEC=" + f5461q);
    }

    public void a(double d3) {
        double d4;
        boolean z2;
        boolean z3;
        boolean zG = g();
        if (zG && this.f5471j) {
            return;
        }
        double d5 = f5461q;
        if (d3 <= d5) {
            d5 = d3;
        }
        this.f5475n += d5;
        o2.b bVar = this.f5462a;
        double d6 = bVar.f5481b;
        double d7 = bVar.f5480a;
        b bVar2 = this.f5466e;
        double d8 = bVar2.f5477a;
        double d9 = bVar2.f5478b;
        b bVar3 = this.f5468g;
        double d10 = bVar3.f5477a;
        double d11 = bVar3.f5478b;
        while (true) {
            d4 = this.f5475n;
            if (d4 < 0.001d) {
                break;
            }
            double d12 = d4 - 0.001d;
            this.f5475n = d12;
            if (d12 < 0.001d) {
                b bVar4 = this.f5467f;
                bVar4.f5477a = d8;
                bVar4.f5478b = d9;
            }
            double d13 = this.f5470i;
            double d14 = ((d13 - d10) * d6) - (d7 * d9);
            double d15 = d9 + (d14 * 0.001d * 0.5d);
            double d16 = ((d13 - (((d9 * 0.001d) * 0.5d) + d8)) * d6) - (d7 * d15);
            double d17 = d9 + (d16 * 0.001d * 0.5d);
            double d18 = ((d13 - (d8 + ((d15 * 0.001d) * 0.5d))) * d6) - (d7 * d17);
            double d19 = d8 + (d17 * 0.001d);
            double d20 = d9 + (d18 * 0.001d);
            d8 += (d9 + ((d15 + d17) * 2.0d) + d20) * 0.16666666666666666d * 0.001d;
            d9 += (d14 + ((d16 + d18) * 2.0d) + (((d13 - d19) * d6) - (d7 * d20))) * 0.16666666666666666d * 0.001d;
            d10 = d19;
            d11 = d20;
        }
        b bVar5 = this.f5468g;
        bVar5.f5477a = d10;
        bVar5.f5478b = d11;
        b bVar6 = this.f5466e;
        bVar6.f5477a = d8;
        bVar6.f5478b = d9;
        if (d4 > 0.0d) {
            f(d4 / 0.001d);
        }
        boolean z4 = true;
        if (g() || (this.f5463b && h())) {
            if (d6 > 0.0d) {
                double d21 = this.f5470i;
                this.f5469h = d21;
                this.f5466e.f5477a = d21;
            } else {
                double d22 = this.f5466e.f5477a;
                this.f5470i = d22;
                this.f5469h = d22;
            }
            r(0.0d);
            z2 = true;
        } else {
            z2 = zG;
        }
        if (this.f5471j) {
            this.f5471j = false;
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2) {
            this.f5471j = true;
        } else {
            z4 = false;
        }
        for (c cVar : this.f5474m) {
            if (z3) {
                cVar.b(this);
            }
            cVar.c(this);
            if (z4) {
                cVar.d(this);
            }
        }
    }

    public double b() {
        return this.f5466e.f5477a;
    }

    public String d() {
        return this.f5465d;
    }

    public double e() {
        return this.f5466e.f5478b;
    }

    public boolean g() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpeedThreshold =");
        sb.append(Math.abs(this.f5466e.f5478b) <= this.f5472k);
        sb.append(" , DistanceThreshold =");
        sb.append(c(this.f5466e) <= this.f5473l);
        r2.a.a("ReboundSpring", sb.toString());
        return Math.abs(this.f5466e.f5478b) <= this.f5472k && (c(this.f5466e) <= this.f5473l || this.f5462a.f5481b == 0.0d);
    }

    public boolean h() {
        return this.f5462a.f5481b > 0.0d && ((this.f5469h < this.f5470i && b() > this.f5470i) || (this.f5469h > this.f5470i && b() < this.f5470i));
    }

    public a i() {
        b bVar = this.f5466e;
        double d3 = bVar.f5477a;
        this.f5470i = d3;
        this.f5468g.f5477a = d3;
        bVar.f5478b = 0.0d;
        return this;
    }

    public void j(Context context) {
        r2.a.a("ReboundSpring", "setContext");
        this.f5464c = new WeakReference<>(context);
    }

    public a k(double d3) {
        return l(d3, true);
    }

    public a l(double d3, boolean z2) {
        this.f5469h = d3;
        this.f5466e.f5477a = d3;
        if (this.f5476o) {
            d();
            throw null;
        }
        if (z2) {
            i();
        }
        n();
        return this;
    }

    public a m(double d3) {
        if (this.f5470i == d3 && g()) {
            return this;
        }
        this.f5469h = b();
        this.f5470i = d3;
        if (this.f5476o) {
            d();
            throw null;
        }
        Iterator<c> it = this.f5474m.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        return this;
    }

    public a o(double d3) {
        this.f5473l = d3;
        return this;
    }

    public a p(double d3) {
        this.f5472k = d3;
        return this;
    }

    public a q(o2.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.f5462a = bVar;
        return this;
    }

    public a r(double d3) {
        b bVar = this.f5466e;
        if (d3 == bVar.f5478b) {
            return this;
        }
        bVar.f5478b = d3;
        if (!this.f5476o) {
            return this;
        }
        d();
        throw null;
    }
}
