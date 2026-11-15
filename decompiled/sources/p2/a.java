package p2;

import android.content.Context;
import android.os.SystemClock;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SpringEstimateUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f5746m = "p2.a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f5747a = Float.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f5748b = Float.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f5749c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f5750d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f5751e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float f5752f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f5753g = 15.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5754h = 800.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f5755i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f5756j = 16.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private WeakReference<Context> f5757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f5758l;

    /* JADX INFO: renamed from: p2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SpringEstimateUtils.java */
    private class C0081a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f5759g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f5760h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f5761i;

        public C0081a(float f3, float f4, float f5) {
            super();
            r2.a.a(a.f5746m, "Solution3 c1=" + f3 + " , c2=" + f4 + " , r=" + f5);
            this.f5759g = f3;
            this.f5760h = f4;
            this.f5761i = f5;
            g();
        }

        @Override // p2.a.d
        public float b() {
            return this.f5775c;
        }

        @Override // p2.a.d
        public float c(float f3) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f5761i * f3);
            float f4 = this.f5761i;
            float f5 = this.f5759g;
            float f6 = this.f5760h;
            float f7 = (f4 * (f5 + (f3 * f6)) * fPow) + (f6 * fPow);
            this.f5774b = f7;
            return f7;
        }

        @Override // p2.a.d
        public float f(float f3) {
            float fPow = (float) (((double) (this.f5759g + (this.f5760h * f3))) * Math.pow(2.718281828459045d, this.f5761i * f3));
            this.f5776d = fPow;
            return fPow;
        }

        public final void g() {
            float f3 = this.f5760h;
            float f4 = (-(((f3 * 2.0f) / this.f5761i) + this.f5759g)) / f3;
            int i3 = 0;
            if (f4 < 0.0f || Float.isInfinite(f4) || Float.isNaN(f4)) {
                f4 = 0.0f;
            } else {
                float f5 = f(f4);
                int i4 = 0;
                while (a.this.d(Math.abs(f5), a.this.f5747a, 0.0f)) {
                    i4++;
                    if (i4 > 999.0f) {
                        break;
                    }
                    f4 = (f4 + 0.0f) / 2.0f;
                    f5 = f(f4);
                }
                if (i4 > 999.0f) {
                    this.f5775c = f4;
                    return;
                }
            }
            float f6 = f(f4);
            float fC = c(f4);
            while (a.this.c(Math.abs(f6), a.this.f5747a, 0.0f)) {
                i3++;
                if (i3 > 999.0f) {
                    break;
                }
                f4 -= f6 / fC;
                if (f4 < 0.0f || Float.isNaN(f4) || Float.isInfinite(f4)) {
                    this.f5775c = 0.0f;
                    return;
                } else {
                    f6 = f(f4);
                    fC = c(f4);
                }
            }
            if (i3 > 999.0f) {
                this.f5775c = -1.0f;
            } else {
                this.f5775c = f4;
            }
        }
    }

    /* JADX INFO: compiled from: SpringEstimateUtils.java */
    private class b extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f5763g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f5764h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f5765i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f5766j;

        public b(float f3, float f4, float f5, float f6) {
            super();
            r2.a.a(a.f5746m, "Solution2 c1=" + f3 + " , c2=" + f4 + " , r1=" + f5 + " , r2=" + f6);
            this.f5763g = f3;
            this.f5764h = f4;
            this.f5765i = f5;
            this.f5766j = f6;
            g();
        }

        @Override // p2.a.d
        public float b() {
            return this.f5775c;
        }

        @Override // p2.a.d
        public float c(float f3) {
            float f4 = this.f5763g;
            float f5 = this.f5765i;
            float fPow = f4 * f5 * ((float) Math.pow(2.718281828459045d, f5 * f3));
            float f6 = this.f5764h;
            float f7 = this.f5766j;
            float fPow2 = fPow + (f6 * f7 * ((float) Math.pow(2.718281828459045d, f7 * f3)));
            this.f5774b = fPow2;
            return fPow2;
        }

        @Override // p2.a.d
        public float f(float f3) {
            float fPow = (this.f5763g * ((float) Math.pow(2.718281828459045d, this.f5765i * f3))) + (this.f5764h * ((float) Math.pow(2.718281828459045d, this.f5766j * f3)));
            this.f5776d = fPow;
            return fPow;
        }

        public final void g() {
            r2.a.a(a.f5746m, "Solution2 doEstimateDuration");
            float f3 = this.f5763g;
            float f4 = this.f5765i;
            float fLog = (float) Math.log(Math.abs(f3 * f4 * f4));
            float f5 = -this.f5764h;
            float f6 = this.f5766j;
            float fLog2 = (fLog - ((float) Math.log(Math.abs((f5 * f6) * f6)))) / (this.f5766j - this.f5765i);
            int i3 = 0;
            if (fLog2 < 0.0f || Float.isInfinite(fLog2) || Float.isNaN(fLog2)) {
                fLog2 = 0.0f;
            } else {
                float f7 = f(fLog2);
                int i4 = 0;
                while (a.this.d(Math.abs(f7), a.this.f5747a, 0.0f)) {
                    i4++;
                    if (i4 > 999.0f) {
                        break;
                    }
                    fLog2 = (fLog2 + 0.0f) / 2.0f;
                    f7 = f(fLog2);
                }
                if (i4 > 999.0f) {
                    this.f5775c = fLog2;
                    return;
                }
            }
            float f8 = f(fLog2);
            float fC = c(fLog2);
            while (a.this.c(Math.abs(f8), a.this.f5747a, 0.0f)) {
                i3++;
                if (i3 > 999.0f) {
                    break;
                }
                fLog2 -= f8 / fC;
                if (fLog2 < 0.0f || Float.isNaN(fLog2) || Float.isInfinite(fLog2)) {
                    this.f5775c = 0.0f;
                    return;
                } else {
                    f8 = f(fLog2);
                    fC = c(fLog2);
                }
            }
            if (i3 > 999.0f) {
                this.f5775c = -1.0f;
            } else {
                this.f5775c = fLog2;
            }
        }
    }

    /* JADX INFO: compiled from: SpringEstimateUtils.java */
    private class c extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f5768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f5769h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f5770i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f5771j;

        public c(float f3, float f4, float f5, float f6) {
            super();
            this.f5768g = f3;
            this.f5769h = f4;
            this.f5771j = f5;
            this.f5770i = f6;
            g();
        }

        @Override // p2.a.d
        public float b() {
            return this.f5775c;
        }

        @Override // p2.a.d
        public float c(float f3) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f5770i * f3);
            float fCos = (float) Math.cos(this.f5771j * f3);
            float fSin = (float) Math.sin(this.f5771j * f3);
            float f4 = this.f5769h;
            float f5 = this.f5771j;
            float f6 = this.f5768g;
            float f7 = ((((f4 * f5) * fCos) - ((f5 * f6) * fSin)) * fPow) + (this.f5770i * fPow * ((f4 * fSin) + (f6 * fCos)));
            this.f5774b = f7;
            return f7;
        }

        @Override // p2.a.d
        public float f(float f3) {
            float fPow = ((float) Math.pow(2.718281828459045d, this.f5770i * f3)) * ((this.f5768g * ((float) Math.cos(this.f5771j * f3))) + (this.f5769h * ((float) Math.sin(this.f5771j * f3))));
            this.f5776d = fPow;
            return fPow;
        }

        public final void g() {
            r2.a.a(a.f5746m, "Solution3 doEstimateDuration");
            a aVar = a.this;
            float f3 = aVar.f5753g;
            float fSqrt = (float) Math.sqrt((f3 * f3) / ((aVar.f5755i * 4.0f) * aVar.f5754h));
            a aVar2 = a.this;
            float fSqrt2 = (float) Math.sqrt(aVar2.f5754h / aVar2.f5755i);
            float fSqrt3 = ((float) Math.sqrt(1.0f - (fSqrt * fSqrt))) * fSqrt2;
            float f4 = 3.1415927f / fSqrt3;
            float fAtan = (float) Math.atan(this.f5769h / this.f5768g);
            if (Float.isNaN(fAtan)) {
                this.f5775c = 0.0f;
                return;
            }
            float fAcos = ((((float) Math.acos(0.0d)) + fAtan) % 3.1415927f) / this.f5771j;
            float fC = c(fAcos);
            float fAcos2 = (((((float) Math.acos(0.0d)) + ((float) Math.atan(fSqrt3 / (fSqrt * fSqrt2)))) + fAtan) % 3.1415927f) / fSqrt3;
            r2.a.a(a.f5746m, "tx0=" + fAcos + " , ti=" + fAcos2);
            int i3 = 0;
            float f5 = 0.0f;
            while (Math.abs(fC) > a.this.f5748b) {
                int i4 = i3 + 1;
                if (i3 >= 999.0f) {
                    i3 = i4;
                    break;
                }
                fAcos += f4;
                fC = c(fAcos);
                f5 += f4;
                fAcos2 += f4;
                i3 = i4;
            }
            float fA = -1.0f;
            if (i3 >= 999.0f) {
                this.f5775c = -1.0f;
                return;
            }
            if ((f5 <= fAcos2 && fAcos2 < fAcos) || f5 == fAcos) {
                fA = a(fAcos2, f4 + fAcos2);
                r2.a.a(a.f5746m, "res=" + fA);
            } else if (f5 < fAcos && fAcos < fAcos2) {
                fA = a(Math.max(0.0f, fAcos2 - f4), fAcos2);
            }
            this.f5775c = fA;
        }
    }

    /* JADX INFO: compiled from: SpringEstimateUtils.java */
    private abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected float f5773a = 0.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected float f5774b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected float f5775c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected float f5776d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float[] f5777e = new float[17];

        protected d() {
        }

        private float d(float f3, float f4) {
            if (f3 <= 999.0f) {
                return f4;
            }
            return -1.0f;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004d  */
        private float e(float f3, float f4, float f5) {
            float f6;
            float f7 = (f5 - f4) / a.this.f5756j;
            r2.a.a(a.f5746m, "delta=" + f7);
            boolean z2 = c((f5 + f4) / 2.0f) > 0.0f;
            for (int i3 = 1; i3 < 17; i3++) {
                float[] fArr = this.f5777e;
                int i4 = i3 - 1;
                float f8 = fArr[i3] - fArr[i4];
                if (!z2 || fArr[i3] < f3) {
                    if (!z2 && fArr[i3] <= f3) {
                        if (f8 == 0.0f) {
                            f6 = i4;
                        } else {
                            f6 = i3 - ((fArr[i3] - f3) / f8);
                        }
                    }
                } else if (f8 == 0.0f) {
                    f6 = i4;
                } else {
                    f6 = i4 + ((f3 - fArr[i4]) / f8);
                }
                return f4 + (f6 * f7);
            }
            return f5;
        }

        public float a(float f3, float f4) {
            float f5;
            float f6 = (f4 - f3) / a.this.f5756j;
            float f7 = a.this.f5747a;
            for (int i3 = 0; i3 < 17; i3++) {
                this.f5777e[i3] = f((i3 * f6) + f3);
            }
            boolean z2 = true;
            int i4 = 1;
            while (true) {
                f5 = 0.0f;
                if (i4 >= 17) {
                    z2 = false;
                    break;
                }
                float[] fArr = this.f5777e;
                int i5 = i4 - 1;
                float f8 = fArr[i5];
                float f9 = a.this.f5747a;
                if ((f8 - f9) * (fArr[i4] - f9) < 0.0f) {
                    f7 = f9;
                    break;
                }
                if ((fArr[i5] + f9) * (fArr[i4] + f9) < 0.0f) {
                    f7 = -f9;
                    break;
                }
                i4++;
            }
            if (!z2) {
                return f3;
            }
            float fE = e(f7, f3, f4);
            while (true) {
                float f10 = fE;
                float f11 = f4;
                f4 = f10;
                float fAbs = Math.abs(f(f4));
                a aVar = a.this;
                if (fAbs >= aVar.f5747a || f11 - f4 < 0.0625f) {
                    break;
                }
                float f12 = (f4 - f3) / aVar.f5756j;
                for (int i6 = 0; i6 < 17; i6++) {
                    this.f5777e[i6] = f((i6 * f12) + f3);
                }
                fE = e(f7, f3, f4);
            }
            float f13 = f(f4);
            float fC = c(f4);
            while (Math.abs(f13) > a.this.f5747a) {
                float f14 = 1.0f + f5;
                if (f5 >= 999.0f) {
                    f5 = f14;
                    break;
                }
                f4 -= f13 / fC;
                f13 = f(f4);
                fC = c(f4);
                f5 = f14;
            }
            return d(f5, f4);
        }

        public abstract float b();

        public abstract float c(float f3);

        public abstract float f(float f3);
    }

    public a(Context context) {
        this.f5757k = null;
        this.f5757k = new WeakReference<>(context);
    }

    private void f() {
        String str = f5746m;
        r2.a.a(str, "setMaxDeltaTimeSec");
        WeakReference<Context> weakReference = this.f5757k;
        if (weakReference == null) {
            r2.a.a(str, "null == mContextWeakReference");
            return;
        }
        Context context = weakReference.get();
        if (context == null) {
            r2.a.a(str, "null == context");
            return;
        }
        int iB = r2.b.b(context);
        if (iB == 30) {
            this.f5756j = 33.0f;
        } else if (iB == 60) {
            this.f5756j = 16.0f;
        } else if (iB == 72) {
            this.f5756j = 14.0f;
        } else if (iB == 90) {
            this.f5756j = 11.0f;
        } else if (iB == 120) {
            this.f5756j = 8.0f;
        } else if (iB == 144) {
            this.f5756j = 7.0f;
        }
        r2.a.a(str, "DELTA_TIME_SEC=" + this.f5756j);
    }

    public boolean c(float f3, float f4, float f5) {
        return f3 > f4 - f5;
    }

    public boolean d(float f3, float f4, float f5) {
        return f3 < f4 - f5;
    }

    public float e() {
        float fB = this.f5758l.b();
        if (Float.compare(fB, -1.0f) == 0) {
            return 500.0f;
        }
        return fB * 1000.0f;
    }

    public void g(int i3, int i4, int i5, o2.b bVar, float f3, float f4) {
        f();
        this.f5755i = 1.0f;
        this.f5754h = Math.min(Math.max(1.0f, (float) bVar.f5481b), 999.0f);
        this.f5753g = Math.min(Math.max(1.0f, (float) bVar.f5480a), 99.0f);
        this.f5758l = null;
        this.f5750d = i3;
        this.f5749c = i4;
        this.f5752f = i5;
        this.f5751e = 0L;
        h(f3, f4);
        this.f5758l = i(this.f5750d - this.f5749c, this.f5752f);
        this.f5751e = SystemClock.elapsedRealtime();
    }

    public a h(float f3, float f4) {
        this.f5747a = Math.abs(f3);
        this.f5748b = f4;
        return this;
    }

    public d i(float f3, float f4) {
        float f5 = this.f5753g;
        float f6 = this.f5755i;
        float f7 = f5 * f5;
        float f8 = 4.0f * f6 * this.f5754h;
        float f9 = f7 - f8;
        int iCompare = Float.compare(f7, f8);
        r2.a.a(f5746m, "compare=" + iCompare);
        if (iCompare == 0) {
            float f10 = (-f5) / (f6 * 2.0f);
            return new C0081a(f3, f4 - (f10 * f3), f10);
        }
        if (iCompare <= 0) {
            float f11 = f6 * 2.0f;
            float fSqrt = (float) (Math.sqrt(((double) f8) - ((double) f7)) / ((double) f11));
            float f12 = (-f5) / f11;
            return new c(f3, (f4 - (f12 * f3)) / fSqrt, fSqrt, f12);
        }
        double d3 = -f5;
        double d4 = f9;
        double d5 = f6 * 2.0f;
        float fSqrt2 = (float) ((d3 - Math.sqrt(d4)) / d5);
        float fSqrt3 = (float) ((d3 + Math.sqrt(d4)) / d5);
        float f13 = (f4 - (fSqrt2 * f3)) / (fSqrt3 - fSqrt2);
        return new b(f3 - f13, f13, fSqrt2, fSqrt3);
    }
}
