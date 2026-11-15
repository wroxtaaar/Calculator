package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import e0.t;

/* JADX INFO: compiled from: AutoScrollHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f1179s = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f1182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f1183e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1187i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1191m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f1192n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f1193o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f1194p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1195q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1196r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C0006a f1180b = new C0006a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Interpolator f1181c = new AccelerateInterpolator();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f1184f = {0.0f, 0.0f};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f1185g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f1188j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f1189k = {0.0f, 0.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float[] f1190l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoScrollHelper.java */
    private static class C0006a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f1199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f1200d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f1206j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f1207k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f1201e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f1205i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f1202f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1203g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1204h = 0;

        C0006a() {
        }

        private float e(long j3) {
            long j4 = this.f1201e;
            if (j3 < j4) {
                return 0.0f;
            }
            long j5 = this.f1205i;
            if (j5 < 0 || j3 < j5) {
                return a.e((j3 - j4) / this.f1197a, 0.0f, 1.0f) * 0.5f;
            }
            float f3 = this.f1206j;
            return (1.0f - f3) + (f3 * a.e((j3 - j5) / this.f1207k, 0.0f, 1.0f));
        }

        private float g(float f3) {
            return ((-4.0f) * f3 * f3) + (f3 * 4.0f);
        }

        public void a() {
            if (this.f1202f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j3 = jCurrentAnimationTimeMillis - this.f1202f;
            this.f1202f = jCurrentAnimationTimeMillis;
            float f3 = j3 * fG;
            this.f1203g = (int) (this.f1199c * f3);
            this.f1204h = (int) (f3 * this.f1200d);
        }

        public int b() {
            return this.f1203g;
        }

        public int c() {
            return this.f1204h;
        }

        public int d() {
            float f3 = this.f1199c;
            return (int) (f3 / Math.abs(f3));
        }

        public int f() {
            float f3 = this.f1200d;
            return (int) (f3 / Math.abs(f3));
        }

        public boolean h() {
            return this.f1205i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1205i + ((long) this.f1207k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1207k = a.f((int) (jCurrentAnimationTimeMillis - this.f1201e), 0, this.f1198b);
            this.f1206j = e(jCurrentAnimationTimeMillis);
            this.f1205i = jCurrentAnimationTimeMillis;
        }

        public void j(int i3) {
            this.f1198b = i3;
        }

        public void k(int i3) {
            this.f1197a = i3;
        }

        public void l(float f3, float f4) {
            this.f1199c = f3;
            this.f1200d = f4;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1201e = jCurrentAnimationTimeMillis;
            this.f1205i = -1L;
            this.f1202f = jCurrentAnimationTimeMillis;
            this.f1206j = 0.5f;
            this.f1203g = 0;
            this.f1204h = 0;
        }
    }

    /* JADX INFO: compiled from: AutoScrollHelper.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f1194p) {
                if (aVar.f1192n) {
                    aVar.f1192n = false;
                    aVar.f1180b.m();
                }
                C0006a c0006a = a.this.f1180b;
                if (c0006a.h() || !a.this.u()) {
                    a.this.f1194p = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f1193o) {
                    aVar2.f1193o = false;
                    aVar2.c();
                }
                c0006a.a();
                a.this.j(c0006a.b(), c0006a.c());
                t.e0(a.this.f1182d, this);
            }
        }
    }

    public a(View view) {
        this.f1182d = view;
        float f3 = Resources.getSystem().getDisplayMetrics().density;
        float f4 = (int) ((1575.0f * f3) + 0.5f);
        o(f4, f4);
        float f5 = (int) ((f3 * 315.0f) + 0.5f);
        p(f5, f5);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f1179s);
        r(500);
        q(500);
    }

    private float d(int i3, float f3, float f4, float f5) {
        float fH = h(this.f1184f[i3], f4, this.f1185g[i3], f3);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f6 = this.f1188j[i3];
        float f7 = this.f1189k[i3];
        float f8 = this.f1190l[i3];
        float f9 = f6 * f5;
        return fH > 0.0f ? e(fH * f9, f7, f8) : -e((-fH) * f9, f7, f8);
    }

    static float e(float f3, float f4, float f5) {
        if (f3 > f5) {
            return f5;
        }
        return f3 < f4 ? f4 : f3;
    }

    static int f(int i3, int i4, int i5) {
        if (i3 > i5) {
            return i5;
        }
        return i3 < i4 ? i4 : i3;
    }

    private float g(float f3, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        int i3 = this.f1186h;
        if (i3 == 0 || i3 == 1) {
            if (f3 < f4) {
                if (f3 >= 0.0f) {
                    return 1.0f - (f3 / f4);
                }
                if (this.f1194p && i3 == 1) {
                    return 1.0f;
                }
            }
        } else if (i3 == 2 && f3 < 0.0f) {
            return f3 / (-f4);
        }
        return 0.0f;
    }

    private float h(float f3, float f4, float f5, float f6) {
        float interpolation;
        float fE = e(f3 * f4, 0.0f, f5);
        float fG = g(f4 - f6, fE) - g(f6, fE);
        if (fG < 0.0f) {
            interpolation = -this.f1181c.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f1181c.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f1192n) {
            this.f1194p = false;
        } else {
            this.f1180b.i();
        }
    }

    private void v() {
        int i3;
        if (this.f1183e == null) {
            this.f1183e = new b();
        }
        this.f1194p = true;
        this.f1192n = true;
        if (this.f1191m || (i3 = this.f1187i) <= 0) {
            this.f1183e.run();
        } else {
            t.f0(this.f1182d, this.f1183e, i3);
        }
        this.f1191m = true;
    }

    public abstract boolean a(int i3);

    public abstract boolean b(int i3);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1182d.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i3, int i4);

    public a k(int i3) {
        this.f1187i = i3;
        return this;
    }

    public a l(int i3) {
        this.f1186h = i3;
        return this;
    }

    public a m(boolean z2) {
        if (this.f1195q && !z2) {
            i();
        }
        this.f1195q = z2;
        return this;
    }

    public a n(float f3, float f4) {
        float[] fArr = this.f1185g;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public a o(float f3, float f4) {
        float[] fArr = this.f1190l;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f1195q) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    i();
                }
            }
            return this.f1196r && this.f1194p;
        }
        this.f1193o = true;
        this.f1191m = false;
        this.f1180b.l(d(0, motionEvent.getX(), view.getWidth(), this.f1182d.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f1182d.getHeight()));
        if (!this.f1194p && u()) {
            v();
        }
        if (this.f1196r) {
            return false;
        }
    }

    public a p(float f3, float f4) {
        float[] fArr = this.f1189k;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    public a q(int i3) {
        this.f1180b.j(i3);
        return this;
    }

    public a r(int i3) {
        this.f1180b.k(i3);
        return this;
    }

    public a s(float f3, float f4) {
        float[] fArr = this.f1184f;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public a t(float f3, float f4) {
        float[] fArr = this.f1188j;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    boolean u() {
        C0006a c0006a = this.f1180b;
        int iF = c0006a.f();
        int iD = c0006a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
