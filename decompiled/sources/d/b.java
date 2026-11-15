package d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* JADX INFO: compiled from: DrawableContainer.java */
/* JADX INFO: loaded from: classes.dex */
class b extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f4457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f4458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f4459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f4460e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4462g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f4465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f4466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f4467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private C0054b f4468m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4461f = 255;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4463h = -1;

    /* JADX INFO: compiled from: DrawableContainer.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawableContainer.java */
    static class C0054b implements Drawable.Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Drawable.Callback f4470b;

        C0054b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f4470b;
            this.f4470b = null;
            return callback;
        }

        public C0054b b(Drawable.Callback callback) {
            this.f4470b = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            Drawable.Callback callback = this.f4470b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j3);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f4470b;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: compiled from: DrawableContainer.java */
    static abstract class c extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f4471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Resources f4472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f4476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Drawable[] f4477g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f4478h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f4479i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f4480j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Rect f4481k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f4482l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f4483m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f4484n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f4485o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f4486p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f4487q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f4488r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f4489s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f4490t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f4491u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f4492v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f4493w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f4494x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        boolean f4495y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f4496z;

        c(c cVar, b bVar, Resources resources) {
            this.f4473c = 160;
            this.f4479i = false;
            this.f4482l = false;
            this.f4494x = true;
            this.A = 0;
            this.B = 0;
            this.f4471a = bVar;
            this.f4472b = resources != null ? resources : cVar != null ? cVar.f4472b : null;
            int iF = b.f(resources, cVar != null ? cVar.f4473c : 0);
            this.f4473c = iF;
            if (cVar == null) {
                this.f4477g = new Drawable[10];
                this.f4478h = 0;
                return;
            }
            this.f4474d = cVar.f4474d;
            this.f4475e = cVar.f4475e;
            this.f4492v = true;
            this.f4493w = true;
            this.f4479i = cVar.f4479i;
            this.f4482l = cVar.f4482l;
            this.f4494x = cVar.f4494x;
            this.f4495y = cVar.f4495y;
            this.f4496z = cVar.f4496z;
            this.A = cVar.A;
            this.B = cVar.B;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.I = cVar.I;
            if (cVar.f4473c == iF) {
                if (cVar.f4480j) {
                    this.f4481k = new Rect(cVar.f4481k);
                    this.f4480j = true;
                }
                if (cVar.f4483m) {
                    this.f4484n = cVar.f4484n;
                    this.f4485o = cVar.f4485o;
                    this.f4486p = cVar.f4486p;
                    this.f4487q = cVar.f4487q;
                    this.f4483m = true;
                }
            }
            if (cVar.f4488r) {
                this.f4489s = cVar.f4489s;
                this.f4488r = true;
            }
            if (cVar.f4490t) {
                this.f4491u = cVar.f4491u;
                this.f4490t = true;
            }
            Drawable[] drawableArr = cVar.f4477g;
            this.f4477g = new Drawable[drawableArr.length];
            this.f4478h = cVar.f4478h;
            SparseArray<Drawable.ConstantState> sparseArray = cVar.f4476f;
            if (sparseArray != null) {
                this.f4476f = sparseArray.clone();
            } else {
                this.f4476f = new SparseArray<>(this.f4478h);
            }
            int i3 = this.f4478h;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    Drawable.ConstantState constantState = drawableArr[i4].getConstantState();
                    if (constantState != null) {
                        this.f4476f.put(i4, constantState);
                    } else {
                        this.f4477g[i4] = drawableArr[i4];
                    }
                }
            }
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f4476f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f4477g[this.f4476f.keyAt(i3)] = s(this.f4476f.valueAt(i3).newDrawable(this.f4472b));
                }
                this.f4476f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f4496z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f4471a);
            return drawableMutate;
        }

        public final int a(Drawable drawable) {
            int i3 = this.f4478h;
            if (i3 >= this.f4477g.length) {
                o(i3, i3 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f4471a);
            this.f4477g[i3] = drawable;
            this.f4478h++;
            this.f4475e = drawable.getChangingConfigurations() | this.f4475e;
            p();
            this.f4481k = null;
            this.f4480j = false;
            this.f4483m = false;
            this.f4492v = false;
            return i3;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i3 = this.f4478h;
                Drawable[] drawableArr = this.f4477g;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (drawableArr[i4] != null && drawableArr[i4].canApplyTheme()) {
                        drawableArr[i4].applyTheme(theme);
                        this.f4475e |= drawableArr[i4].getChangingConfigurations();
                    }
                }
                y(theme.getResources());
            }
        }

        public synchronized boolean c() {
            if (this.f4492v) {
                return this.f4493w;
            }
            e();
            this.f4492v = true;
            int i3 = this.f4478h;
            Drawable[] drawableArr = this.f4477g;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4].getConstantState() == null) {
                    this.f4493w = false;
                    return false;
                }
            }
            this.f4493w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i3 = this.f4478h;
            Drawable[] drawableArr = this.f4477g;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f4476f.get(i4);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f4483m = true;
            e();
            int i3 = this.f4478h;
            Drawable[] drawableArr = this.f4477g;
            this.f4485o = -1;
            this.f4484n = -1;
            this.f4487q = 0;
            this.f4486p = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f4484n) {
                    this.f4484n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f4485o) {
                    this.f4485o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f4486p) {
                    this.f4486p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f4487q) {
                    this.f4487q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f4477g.length;
        }

        public final Drawable g(int i3) {
            int iIndexOfKey;
            Drawable drawable = this.f4477g[i3];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f4476f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i3)) < 0) {
                return null;
            }
            Drawable drawableS = s(this.f4476f.valueAt(iIndexOfKey).newDrawable(this.f4472b));
            this.f4477g[i3] = drawableS;
            this.f4476f.removeAt(iIndexOfKey);
            if (this.f4476f.size() == 0) {
                this.f4476f = null;
            }
            return drawableS;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4475e | this.f4474d;
        }

        public final int h() {
            return this.f4478h;
        }

        public final int i() {
            if (!this.f4483m) {
                d();
            }
            return this.f4485o;
        }

        public final int j() {
            if (!this.f4483m) {
                d();
            }
            return this.f4487q;
        }

        public final int k() {
            if (!this.f4483m) {
                d();
            }
            return this.f4486p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f4479i) {
                return null;
            }
            Rect rect2 = this.f4481k;
            if (rect2 != null || this.f4480j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i3 = this.f4478h;
            Drawable[] drawableArr = this.f4477g;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i5 = rect3.left;
                    if (i5 > rect.left) {
                        rect.left = i5;
                    }
                    int i6 = rect3.top;
                    if (i6 > rect.top) {
                        rect.top = i6;
                    }
                    int i7 = rect3.right;
                    if (i7 > rect.right) {
                        rect.right = i7;
                    }
                    int i8 = rect3.bottom;
                    if (i8 > rect.bottom) {
                        rect.bottom = i8;
                    }
                }
            }
            this.f4480j = true;
            this.f4481k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f4483m) {
                d();
            }
            return this.f4484n;
        }

        public final int n() {
            if (this.f4488r) {
                return this.f4489s;
            }
            e();
            int i3 = this.f4478h;
            Drawable[] drawableArr = this.f4477g;
            int opacity = i3 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i4 = 1; i4 < i3; i4++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i4].getOpacity());
            }
            this.f4489s = opacity;
            this.f4488r = true;
            return opacity;
        }

        public void o(int i3, int i4) {
            Drawable[] drawableArr = new Drawable[i4];
            System.arraycopy(this.f4477g, 0, drawableArr, 0, i3);
            this.f4477g = drawableArr;
        }

        void p() {
            this.f4488r = false;
            this.f4490t = false;
        }

        public final boolean q() {
            return this.f4482l;
        }

        abstract void r();

        public final void t(boolean z2) {
            this.f4482l = z2;
        }

        public final void u(int i3) {
            this.A = i3;
        }

        public final void v(int i3) {
            this.B = i3;
        }

        final boolean w(int i3, int i4) {
            int i5 = this.f4478h;
            Drawable[] drawableArr = this.f4477g;
            boolean z2 = false;
            for (int i6 = 0; i6 < i5; i6++) {
                if (drawableArr[i6] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i6].setLayoutDirection(i3) : false;
                    if (i6 == i4) {
                        z2 = layoutDirection;
                    }
                }
            }
            this.f4496z = i3;
            return z2;
        }

        public final void x(boolean z2) {
            this.f4479i = z2;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f4472b = resources;
                int iF = b.f(resources, this.f4473c);
                int i3 = this.f4473c;
                this.f4473c = iF;
                if (i3 != iF) {
                    this.f4483m = false;
                    this.f4480j = false;
                }
            }
        }
    }

    b() {
    }

    private void d(Drawable drawable) {
        if (this.f4468m == null) {
            this.f4468m = new C0054b();
        }
        drawable.setCallback(this.f4468m.b(drawable.getCallback()));
        try {
            if (this.f4457b.A <= 0 && this.f4462g) {
                drawable.setAlpha(this.f4461f);
            }
            c cVar = this.f4457b;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    x.a.o(drawable, cVar.F);
                }
                c cVar2 = this.f4457b;
                if (cVar2.I) {
                    x.a.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f4457b.f4494x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (i3 >= 19) {
                drawable.setAutoMirrored(this.f4457b.C);
            }
            Rect rect = this.f4458c;
            if (i3 >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f4468m.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && x.a.f(this) == 1;
    }

    static int f(Resources resources, int i3) {
        if (resources != null) {
            i3 = resources.getDisplayMetrics().densityDpi;
        }
        if (i3 == 0) {
            return 160;
        }
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    void a(boolean z2) {
        boolean z3;
        Drawable drawable;
        long j3;
        boolean z4 = true;
        this.f4462g = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f4459d;
        if (drawable2 != null) {
            long j4 = this.f4466k;
            if (j4 != 0) {
                if (j4 <= jUptimeMillis) {
                    drawable2.setAlpha(this.f4461f);
                    this.f4466k = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j4 - jUptimeMillis) * 255)) / this.f4457b.A)) * this.f4461f) / 255);
                    z3 = true;
                }
            }
            drawable = this.f4460e;
            if (drawable != null) {
                j3 = this.f4467l;
                if (j3 == 0) {
                    if (j3 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f4460e = null;
                        this.f4467l = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j3 - jUptimeMillis) * 255)) / this.f4457b.B) * this.f4461f) / 255);
                    }
                }
                if (z2 || !z4) {
                }
                scheduleSelf(this.f4465j, jUptimeMillis + 16);
                return;
            }
            this.f4467l = 0L;
            z4 = z3;
            if (z2) {
            }
        }
        this.f4466k = 0L;
        z3 = false;
        drawable = this.f4460e;
        if (drawable != null) {
            j3 = this.f4467l;
            if (j3 == 0) {
                if (j3 <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.f4460e = null;
                    this.f4467l = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j3 - jUptimeMillis) * 255)) / this.f4457b.B) * this.f4461f) / 255);
                }
            }
            if (z2) {
            }
        }
        this.f4467l = 0L;
        z4 = z3;
        if (z2) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f4457b.b(theme);
    }

    c b() {
        throw null;
    }

    int c() {
        return this.f4463h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f4457b.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f4460e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    boolean g(int i3) {
        if (i3 == this.f4463h) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f4457b.B > 0) {
            Drawable drawable = this.f4460e;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f4459d;
            if (drawable2 != null) {
                this.f4460e = drawable2;
                this.f4467l = ((long) this.f4457b.B) + jUptimeMillis;
            } else {
                this.f4460e = null;
                this.f4467l = 0L;
            }
        } else {
            Drawable drawable3 = this.f4459d;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i3 >= 0) {
            c cVar = this.f4457b;
            if (i3 < cVar.f4478h) {
                Drawable drawableG = cVar.g(i3);
                this.f4459d = drawableG;
                this.f4463h = i3;
                if (drawableG != null) {
                    int i4 = this.f4457b.A;
                    if (i4 > 0) {
                        this.f4466k = jUptimeMillis + ((long) i4);
                    }
                    d(drawableG);
                }
            } else {
                this.f4459d = null;
                this.f4463h = -1;
            }
        } else {
            this.f4459d = null;
            this.f4463h = -1;
        }
        if (this.f4466k != 0 || this.f4467l != 0) {
            Runnable runnable = this.f4465j;
            if (runnable == null) {
                this.f4465j = new a();
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4461f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f4457b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f4457b.c()) {
            return null;
        }
        this.f4457b.f4474d = getChangingConfigurations();
        return this.f4457b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f4459d;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f4458c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f4457b.q()) {
            return this.f4457b.i();
        }
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f4457b.q()) {
            return this.f4457b.m();
        }
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f4457b.q()) {
            return this.f4457b.j();
        }
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f4457b.q()) {
            return this.f4457b.k();
        }
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f4459d;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f4457b.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.f4457b.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f4459d;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i3 = rect.left;
            rect.left = rect.right;
            rect.right = i3;
        }
        return padding;
    }

    void h(c cVar) {
        this.f4457b = cVar;
        int i3 = this.f4463h;
        if (i3 >= 0) {
            Drawable drawableG = cVar.g(i3);
            this.f4459d = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f4460e = null;
    }

    final void i(Resources resources) {
        this.f4457b.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f4457b;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable != this.f4459d || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f4457b.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f4460e;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f4460e = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f4459d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f4462g) {
                this.f4459d.setAlpha(this.f4461f);
            }
        }
        if (this.f4467l != 0) {
            this.f4467l = 0L;
            z2 = true;
        }
        if (this.f4466k != 0) {
            this.f4466k = 0L;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f4464i && super.mutate() == this) {
            c cVarB = b();
            cVarB.r();
            h(cVarB);
            this.f4464i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4460e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f4459d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return this.f4457b.w(i3, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f4460e;
        if (drawable != null) {
            return drawable.setLevel(i3);
        }
        Drawable drawable2 = this.f4459d;
        if (drawable2 != null) {
            return drawable2.setLevel(i3);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4460e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f4459d;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        if (drawable != this.f4459d || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f4462g && this.f4461f == i3) {
            return;
        }
        this.f4462g = true;
        this.f4461f = i3;
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            if (this.f4466k == 0) {
                drawable.setAlpha(i3);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        c cVar = this.f4457b;
        if (cVar.C != z2) {
            cVar.C = z2;
            Drawable drawable = this.f4459d;
            if (drawable != null) {
                x.a.j(drawable, z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f4457b;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f4459d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        c cVar = this.f4457b;
        if (cVar.f4494x != z2) {
            cVar.f4494x = z2;
            Drawable drawable = this.f4459d;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            x.a.k(drawable, f3, f4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        Rect rect = this.f4458c;
        if (rect == null) {
            this.f4458c = new Rect(i3, i4, i5, i6);
        } else {
            rect.set(i3, i4, i5, i6);
        }
        Drawable drawable = this.f4459d;
        if (drawable != null) {
            x.a.l(drawable, i3, i4, i5, i6);
        }
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f4457b;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            x.a.o(this.f4459d, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f4457b;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            x.a.p(this.f4459d, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f4460e;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f4459d;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f4459d || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
