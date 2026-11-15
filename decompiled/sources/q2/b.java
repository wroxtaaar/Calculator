package q2;

import android.content.Context;
import android.os.SystemClock;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: ReboundOverScroller.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f5931g = 10000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f5932h = 30000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f5933i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f5934j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f5935k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f5936l = 25;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f5937m = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f5939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Interpolator f5942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SoftReference<Object> f5943f;

    /* JADX INFO: compiled from: ReboundOverScroller.java */
    static class a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static o2.b f5944s = new o2.b(140.0d, 21.5d);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static o2.b f5945t = new o2.b(250.0d, 28.0d);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static o2.b f5946u = new o2.b(0.0d, 2.2d);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static o2.b f5947v = new o2.b(90.0d, 38.0d);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private static double f5948w = 1.0d;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static float f5949x = (float) (Math.log(0.78d) / Math.log(0.9d));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f5953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f5954e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f5955f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5956g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f5957h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f5958i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private o2.a f5961l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private p2.a f5962m;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private SoftReference<q2.a> f5965p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f5966q;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f5959j = ViewConfiguration.getScrollFriction();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f5960k = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f5963n = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f5964o = 0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Interpolator f5967r = new DecelerateInterpolator();

        a(Context context) {
            o2.a aVar = new o2.a();
            this.f5961l = aVar;
            aVar.o(1.0d);
            this.f5961l.j(context);
            this.f5962m = new p2.a(context);
            this.f5957h = true;
            this.f5966q = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private void n(int i3, int i4, int i5) {
            r2.a.a("ReboundOverScroller", "start spring back");
            int iO = o(i5);
            this.f5957h = false;
            float f3 = iO;
            this.f5953d = f3;
            this.f5954e = f3;
            this.f5960k = 1;
            this.f5950a = i3;
            this.f5951b = i3;
            this.f5952c = i4;
            this.f5958i = 100;
            this.f5955f = SystemClock.uptimeMillis();
            this.f5961l.q(f5945t);
            this.f5961l.k(i3);
            int i6 = (int) (((double) iO) * f5948w);
            this.f5961l.r(i6);
            this.f5961l.p(b.f5936l);
            this.f5961l.o(b.f5937m);
            this.f5961l.m(i4);
            this.f5962m.g(i3, i4, i6, f5945t, b.f5937m, b.f5936l);
            this.f5956g = (int) this.f5962m.e();
        }

        private int o(int i3) {
            r2.a.a("ReboundOverScroller", "sIsFlywheel=" + b.f5935k);
            if (b.f5935k) {
                if (b.f5933i && Math.abs(i3) > b.f5932h) {
                    i3 = b.f5932h * ((int) Math.signum(i3));
                    r2.a.a("ReboundOverScroller", "thresholdVelocity >" + b.f5932h);
                }
            } else if (b.f5933i && Math.abs(i3) > b.f5931g) {
                i3 = b.f5931g * ((int) Math.signum(i3));
                r2.a.a("ReboundOverScroller", "thresholdVelocity >" + b.f5931g);
            }
            r2.a.a("ReboundOverScroller", "thresholdVelocity velocity=" + i3);
            return i3;
        }

        boolean g() {
            if (this.f5960k != 0) {
                return false;
            }
            int i3 = this.f5951b;
            if (i3 >= this.f5964o && (i3 <= this.f5963n || this.f5953d == 0.0f)) {
                return false;
            }
            r2.a.a("ReboundOverScroller", "over fling need to spring back");
            SoftReference<q2.a> softReference = this.f5965p;
            if (softReference != null && softReference.get() != null) {
                this.f5965p.get().a();
            }
            r2.a.a("ReboundOverScroller", "mOverflingMinRange=" + this.f5964o + " , mOverflingMaxRange=" + this.f5963n + " , mCurrentPosition=" + this.f5951b + " , mOver=" + this.f5958i);
            int i4 = this.f5963n;
            int i5 = this.f5958i;
            int i6 = i4 + i5;
            int i7 = this.f5951b;
            int i8 = this.f5964o;
            if (i7 < i8) {
                if (i7 > i6) {
                    j(i6, i8, i5);
                } else {
                    j(i7, i8, i5);
                }
            }
            int i9 = this.f5951b;
            int i10 = this.f5963n;
            if (i9 <= i10) {
                return true;
            }
            if (i9 > i6) {
                j(i6, i10, this.f5958i);
                return true;
            }
            j(i9, i10, this.f5958i);
            return true;
        }

        void h() {
            this.f5951b = this.f5952c;
            this.f5957h = true;
            this.f5961l.i();
        }

        void i(int i3, int i4, int i5, int i6, int i7) {
            r2.a.a("ReboundOverScroller", "start fling");
            int iO = (int) (((double) o(i4)) * f5948w);
            this.f5958i = i7;
            this.f5957h = false;
            float f3 = iO;
            this.f5953d = f3;
            this.f5954e = f3;
            this.f5956g = 0;
            this.f5950a = i3;
            this.f5951b = i3;
            if (i3 > i6 || i3 < i5) {
                if (i3 > i6) {
                    i5 = i6;
                }
                n(i3, i5, iO);
                return;
            }
            this.f5963n = i6;
            this.f5964o = i5;
            this.f5960k = 0;
            this.f5952c = i3 >= i6 ? i5 : i6;
            this.f5955f = SystemClock.uptimeMillis();
            this.f5961l.k(i3);
            this.f5961l.r(iO);
            this.f5961l.q(f5946u);
            this.f5961l.p(b.f5936l);
            this.f5961l.o(b.f5937m);
            this.f5961l.m(i3 >= i6 ? i5 : i6);
        }

        void j(int i3, int i4, int i5) {
            r2.a.a("ReboundOverScroller", "start notify edge reached");
            int i6 = this.f5960k;
            if (i6 != 0) {
                if (i6 == 4) {
                    this.f5951b = 0;
                    this.f5952c = 0;
                    this.f5957h = true;
                    return;
                }
                return;
            }
            this.f5958i = i5;
            float fE = (float) this.f5961l.e();
            this.f5961l.q(f5944s);
            this.f5960k = 3;
            this.f5950a = i3;
            this.f5955f = SystemClock.uptimeMillis();
            this.f5961l.k(i3);
            this.f5961l.r(fE);
            this.f5961l.p(b.f5936l);
            this.f5961l.o(b.f5937m);
            this.f5961l.m(i4);
            this.f5952c = i4;
        }

        protected boolean k() {
            int i3 = this.f5951b;
            int i4 = this.f5958i;
            return i3 > this.f5963n + i4 || i3 < this.f5964o - i4;
        }

        boolean l(int i3, int i4, int i5) {
            this.f5957h = true;
            this.f5952c = i3;
            this.f5950a = i3;
            this.f5953d = 0.0f;
            this.f5956g = 0;
            if (i3 < i4) {
                n(i3, i4, 0);
            } else if (i3 > i5) {
                n(i3, i5, 0);
            }
            return !this.f5957h;
        }

        boolean m(int i3, int i4, int i5) {
            this.f5952c = i3;
            this.f5950a = i3;
            this.f5953d = i5;
            this.f5956g = 0;
            n(i3, i4, i5);
            return !this.f5957h;
        }

        boolean p() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (this.f5960k == 4) {
                long j3 = jUptimeMillis - this.f5955f;
                int i3 = this.f5956g;
                if (j3 >= i3) {
                    h();
                    return false;
                }
                float interpolation = this.f5967r.getInterpolation(j3 / i3);
                if (!this.f5957h) {
                    q(interpolation);
                }
                return true;
            }
            this.f5961l.a((jUptimeMillis - this.f5955f) / 1000.0d);
            float fE = (float) this.f5961l.e();
            this.f5954e = fE;
            this.f5953d = fE;
            r2.a.a("test_log >>", "UPDATE : mVelocity=" + this.f5953d);
            this.f5955f = jUptimeMillis;
            int i4 = this.f5960k;
            if (i4 == 0) {
                this.f5951b = (int) Math.round(this.f5961l.b());
                r2.a.a("test_log >>", "SPLINE : mCurrentPosition=" + this.f5951b);
                if (g()) {
                    this.f5951b = this.f5952c;
                } else if (this.f5961l.g()) {
                    this.f5952c = this.f5951b;
                }
                return !this.f5961l.g();
            }
            if (i4 == 1) {
                this.f5951b = (int) Math.round(this.f5961l.b());
                r2.a.a("test_log >>", "CUBIC : mCurrentPosition=" + this.f5951b);
                if (!this.f5961l.g()) {
                    return true;
                }
                r2.a.a("ReboundOverScroller", "case CUBIC : spring is reset");
                this.f5951b = 0;
                if (!this.f5961l.g()) {
                    this.f5961l.i();
                }
                return false;
            }
            if (i4 != 3) {
                return true;
            }
            this.f5951b = (int) Math.round(this.f5961l.b());
            r2.a.a("test_log >>", "BOUNCE : mCurrentPosition=" + this.f5951b);
            if (k()) {
                r2.a.a("ReboundOverScroller", "case BOUNCE : current position is too over");
                if (!this.f5961l.g()) {
                    this.f5961l.i();
                }
                int i5 = this.f5951b;
                int i6 = this.f5964o;
                if (i5 < i6) {
                    int i7 = i6 - this.f5958i;
                    this.f5951b = i7;
                    l(i7, i6, this.f5963n);
                } else {
                    int i8 = this.f5963n;
                    if (i5 > i8) {
                        int i9 = this.f5958i + i8;
                        this.f5951b = i9;
                        l(i9, i6, i8);
                    }
                }
            }
            if (!this.f5961l.g()) {
                return true;
            }
            r2.a.a("ReboundOverScroller", "case BOUNCE : spring is reset");
            this.f5951b = 0;
            if (!this.f5961l.g()) {
                this.f5961l.i();
            }
            return false;
        }

        void q(float f3) {
            int i3 = this.f5950a;
            this.f5951b = i3 + Math.round(f3 * (this.f5952c - i3));
        }
    }

    /* JADX INFO: renamed from: q2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReboundOverScroller.java */
    static class InterpolatorC0085b implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final float f5968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final float f5969b;

        static {
            float fA = 1.0f / a(1.0f);
            f5968a = fA;
            f5969b = 1.0f - (fA * a(1.0f));
        }

        InterpolatorC0085b() {
        }

        private static float a(float f3) {
            float f4 = f3 * 8.0f;
            return f4 < 1.0f ? f4 - (1.0f - ((float) Math.exp(-f4))) : ((1.0f - ((float) Math.exp(1.0f - f4))) * 0.63212055f) + 0.36787945f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float fA = f5968a * a(f3);
            return fA > 0.0f ? fA + f5969b : fA;
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public void a() {
        this.f5938a.h();
        this.f5939b.h();
        h();
    }

    public void h() {
        SoftReference<Object> softReference = this.f5943f;
        if (softReference != null) {
            softReference.clear();
            this.f5943f = null;
        }
    }

    public boolean i() {
        r2.a.a("test_log >>", "computeScrollOffset");
        if (q()) {
            return false;
        }
        int i3 = this.f5941d;
        if (i3 == 0) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f5938a.f5955f;
            int i4 = this.f5938a.f5956g;
            if (jCurrentAnimationTimeMillis < i4) {
                float interpolation = this.f5942e.getInterpolation(jCurrentAnimationTimeMillis / i4);
                if (!this.f5938a.f5957h) {
                    this.f5938a.q(interpolation);
                }
                if (!this.f5939b.f5957h) {
                    this.f5939b.q(interpolation);
                }
            } else {
                a();
            }
        } else if (i3 == 1) {
            if (!this.f5938a.f5957h && !this.f5938a.p()) {
                this.f5938a.h();
            }
            if (!this.f5939b.f5957h && !this.f5939b.p()) {
                this.f5939b.h();
            }
        }
        return true;
    }

    public void j(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        k(i3, i4, i5, i6, i7, i8, i9, i10, 0, 0);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0094  */
    public void k(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13;
        int i14 = i6;
        r2.a.a("ReboundOverScroller", "mFlywheel=" + this.f5940c + " , isFinished()=" + q());
        if (!this.f5940c || q()) {
            i13 = i5;
            f5935k = false;
        } else {
            float f3 = this.f5938a.f5954e;
            float f4 = this.f5939b.f5954e;
            StringBuilder sb = new StringBuilder();
            sb.append("if=");
            i13 = i5;
            float f5 = i13;
            sb.append(Math.signum(f5) == Math.signum(f3) && Math.signum((float) i14) == Math.signum(f4));
            r2.a.a("ReboundOverScroller", sb.toString());
            if (Math.signum(f5) == Math.signum(f3)) {
                float f6 = i14;
                if (Math.signum(f6) == Math.signum(f4)) {
                    f5935k = true;
                    i13 = (int) (f5 + f3);
                    i14 = (int) (f6 + f4);
                } else {
                    f5935k = false;
                }
            } else {
                f5935k = false;
            }
        }
        r2.a.a("ReboundOverScroller", "sIsFlywheel=" + f5935k);
        this.f5941d = 1;
        this.f5938a.i(i3, i13, i7, i8, i11);
        this.f5939b.i(i4, i14, i9, i10, i12);
    }

    public float l() {
        return this.f5938a.f5953d;
    }

    public float m() {
        return this.f5939b.f5953d;
    }

    public final int n() {
        return this.f5938a.f5951b;
    }

    public final int o() {
        return this.f5939b.f5951b;
    }

    void p() {
        f5931g = Integer.valueOf(!f5934j ? r2.b.a("persist.debug.threshold_fling_velocity", String.valueOf(30000)) : r2.b.a("persist.debug.threshold_fling_velocity", String.valueOf(10000))).intValue();
        r2.a.a("ReboundOverScroller", "THRESHOLD_FLING_VELOCITY=" + f5931g);
        f5932h = Integer.valueOf(r2.b.a("persist.debug.threshold_fling_velocity_flywheel", String.valueOf(30000))).intValue();
        r2.a.a("ReboundOverScroller", "THRESHOLD_FLING_VELOCITY_FLYWHEEL=" + f5932h);
        f5933i = true;
    }

    public final boolean q() {
        return this.f5938a.f5957h && this.f5939b.f5957h;
    }

    public boolean r(int i3, int i4, int i5) {
        this.f5941d = 1;
        return this.f5938a.m(i3, i4, i5);
    }

    public boolean s(int i3, int i4, int i5) {
        this.f5941d = 1;
        return this.f5939b.m(i3, i4, i5);
    }

    public b(Context context, Interpolator interpolator) {
        this(context, interpolator, f5934j);
    }

    public b(Context context, Interpolator interpolator, boolean z2) {
        r2.a.a("ReboundOverScroller", "flywheel=" + z2);
        if (interpolator == null) {
            this.f5942e = new InterpolatorC0085b();
        } else {
            this.f5942e = interpolator;
        }
        this.f5940c = z2;
        this.f5938a = new a(context);
        this.f5939b = new a(context);
        p();
    }
}
