package com.vivo.calculator.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.Locale;
import vivo.util.VLog;

/* JADX INFO: compiled from: PullToRefreshBase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f<T extends View> extends LinearLayout implements com.vivo.calculator.pulltorefresh.b.a {
    private int A;
    private float B;
    private i C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f4197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private m f4199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e f4200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e f4201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private T f4202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private FrameLayout f4203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f4204n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4205o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4206p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f4207q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f4208r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Interpolator f4209s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private d f4210t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.vivo.calculator.pulltorefresh.c f4211u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.vivo.calculator.pulltorefresh.c f4212v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private h<T> f4213w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private g<T> f4214x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private InterfaceC0050f<T> f4215y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private f<T>.l f4216z;

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    class a implements j {
        a() {
        }

        @Override // com.vivo.calculator.pulltorefresh.f.j
        public void a() {
            f.this.g();
        }
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.requestLayout();
        }
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f4221c;

        static {
            int[] iArr = new int[k.values().length];
            f4221c = iArr;
            try {
                iArr[k.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4221c[k.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[e.values().length];
            f4220b = iArr2;
            try {
                iArr2[e.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4220b[e.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4220b[e.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4220b[e.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[m.values().length];
            f4219a = iArr3;
            try {
                iArr3[m.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4219a[m.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4219a[m.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4219a[m.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4219a[m.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4219a[m.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public enum d {
        ROTATE,
        FLIP;

        static d b() {
            return FLIP;
        }

        static d c(int i3) {
            return i3 != 1 ? ROTATE : FLIP;
        }

        com.vivo.calculator.pulltorefresh.c a(Context context, e eVar, k kVar, TypedArray typedArray) {
            return new com.vivo.calculator.pulltorefresh.a(context, eVar, kVar, typedArray);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public enum e {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static e f4230h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static e f4231i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4233b;

        static {
            e eVar = PULL_FROM_START;
            e eVar2 = PULL_FROM_END;
            f4230h = eVar;
            f4231i = eVar2;
        }

        e(int i3) {
            this.f4233b = i3;
        }

        static e a() {
            return PULL_FROM_START;
        }

        static e c(int i3) {
            for (e eVar : values()) {
                if (i3 == eVar.b()) {
                    return eVar;
                }
            }
            return a();
        }

        int b() {
            return this.f4233b;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }

        boolean d() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean e() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean f() {
            return this == PULL_FROM_START || this == BOTH;
        }
    }

    /* JADX INFO: renamed from: com.vivo.calculator.pulltorefresh.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public interface InterfaceC0050f<V extends View> {
        void a(f<V> fVar, m mVar, e eVar);
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public interface g<V extends View> {
        void a(f<V> fVar);

        void b(f<V> fVar);
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public interface h<V extends View> {
        void a(f<V> fVar);
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public interface i {
        void a();

        void b();

        void c(float f3);

        void d();

        void e();

        void f(int i3);

        void g(int i3, int i4);

        void h(int i3, int i4);

        void i();

        void j();
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    interface j {
        void a();
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public enum k {
        VERTICAL,
        HORIZONTAL;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    final class l implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Interpolator f4237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4239d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f4240e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private j f4241f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f4242g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f4243h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f4244i = -1;

        l(int i3, int i4, long j3, j jVar) {
            this.f4239d = i3;
            this.f4238c = i4;
            this.f4237b = f.this.f4209s;
            this.f4240e = j3;
            this.f4241f = jVar;
        }

        public void a() {
            this.f4242g = false;
            f.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4243h == -1) {
                this.f4243h = System.currentTimeMillis();
            } else {
                int iRound = this.f4239d - Math.round((this.f4239d - this.f4238c) * this.f4237b.getInterpolation(Math.max(Math.min(((System.currentTimeMillis() - this.f4243h) * 1000) / this.f4240e, 1000L), 0L) / 1000.0f));
                this.f4244i = iRound;
                f.this.setHeaderScroll(iRound);
            }
            if (this.f4242g && this.f4238c != this.f4244i) {
                com.vivo.calculator.pulltorefresh.h.a(f.this, this);
                return;
            }
            j jVar = this.f4241f;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: PullToRefreshBase.java */
    public enum m {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);


        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4253b;

        m(int i3) {
            this.f4253b = i3;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }
    }

    public f(Context context) {
        super(context);
        this.f4192b = 0.0f;
        this.f4198h = false;
        this.f4199i = m.RESET;
        this.f4200j = e.a();
        this.f4204n = true;
        this.f4205o = false;
        this.f4206p = true;
        this.f4207q = true;
        this.f4208r = true;
        this.f4210t = d.b();
        this.A = -1;
        this.B = -1.0f;
        this.C = null;
        k(context, null);
    }

    private void B(int i3, long j3, long j4, j jVar) {
        f<T>.l lVar = this.f4216z;
        if (lVar != null) {
            lVar.a();
        }
        int scrollY = c.f4221c[getPullToRefreshScrollDirection().ordinal()] != 1 ? getScrollY() : getScrollX();
        VLog.v("BBKCalculator/PullToRefreshBase", "smoothScrollTo oldScrollValue " + scrollY + ", newScrollValue " + i3);
        if (scrollY == i3) {
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        if (this.f4209s == null) {
            this.f4209s = new DecelerateInterpolator(2.0f);
        }
        f<T>.l lVar2 = new l(scrollY, i3, j3, jVar);
        this.f4216z = lVar2;
        if (j4 > 0) {
            postDelayed(lVar2, j4);
        } else {
            post(lVar2);
        }
    }

    private void d(Context context, T t3) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.f4203m = frameLayout;
        frameLayout.addView(t3, -1, -1);
        f(this.f4203m, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        VLog.v("BBKCalculator/PullToRefreshBase", "callRefreshListener mCurrentMode " + this.f4201k);
        h<T> hVar = this.f4213w;
        if (hVar != null) {
            hVar.a(this);
            return;
        }
        g<T> gVar = this.f4214x;
        if (gVar != null) {
            e eVar = this.f4201k;
            if (eVar == e.PULL_FROM_START) {
                gVar.b(this);
            } else if (eVar == e.PULL_FROM_END) {
                gVar.a(this);
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        return c.f4221c[getPullToRefreshScrollDirection().ordinal()] != 1 ? new LinearLayout.LayoutParams(-1, -2) : new LinearLayout.LayoutParams(-2, -1);
    }

    private int getMaximumPullScroll() {
        return c.f4221c[getPullToRefreshScrollDirection().ordinal()] != 1 ? Math.round(getHeight() / 2.0f) : Math.round(getWidth() / 2.0f);
    }

    private void k(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        if (c.f4221c[getPullToRefreshScrollDirection().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.f4193c = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z1.f.PullToRefresh);
        if (typedArrayObtainStyledAttributes.hasValue(12)) {
            this.f4200j = e.c(typedArrayObtainStyledAttributes.getInteger(12, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f4210t = d.c(typedArrayObtainStyledAttributes.getInteger(1, 0));
        }
        com.vivo.calculator.pulltorefresh.b bVar = (T) i(context, attributeSet);
        this.f4202l = bVar;
        if (bVar instanceof com.vivo.calculator.pulltorefresh.b) {
            bVar.setScrollOverDYListener(this);
        }
        d(context, this.f4202l);
        this.f4211u = h(context, e.PULL_FROM_START, typedArrayObtainStyledAttributes);
        this.f4212v = h(context, e.PULL_FROM_END, typedArrayObtainStyledAttributes);
        if (typedArrayObtainStyledAttributes.hasValue(14)) {
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(14);
            if (drawable2 != null) {
                this.f4202l.setBackgroundDrawable(drawable2);
            }
        } else if (typedArrayObtainStyledAttributes.hasValue(0) && (drawable = typedArrayObtainStyledAttributes.getDrawable(0)) != null) {
            this.f4202l.setBackgroundDrawable(drawable);
        }
        if (typedArrayObtainStyledAttributes.hasValue(13)) {
            this.f4207q = typedArrayObtainStyledAttributes.getBoolean(13, true);
        }
        if (typedArrayObtainStyledAttributes.hasValue(16)) {
            this.f4205o = typedArrayObtainStyledAttributes.getBoolean(16, false);
        }
        j(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        D();
    }

    private boolean m() {
        int i3 = c.f4220b[this.f4200j.ordinal()];
        if (i3 == 1) {
            return n();
        }
        if (i3 == 2) {
            return o();
        }
        if (i3 != 4) {
            return false;
        }
        return n() || o();
    }

    private void setCurHeaderSize(int i3) {
        this.A = i3;
    }

    private void v() {
        float f3;
        float f4;
        int iRound;
        int footerSize;
        if (c.f4221c[getPullToRefreshScrollDirection().ordinal()] != 1) {
            f3 = this.f4197g;
            f4 = this.f4195e;
        } else {
            f3 = this.f4196f;
            f4 = this.f4194d;
        }
        int[] iArr = c.f4220b;
        if (iArr[this.f4201k.ordinal()] != 1) {
            if (f3 > f4) {
                iRound = 0;
            } else {
                float f5 = f4 - f3;
                iRound = (int) (-(Math.pow(f5, 0.85d) / 1.2d));
                if (PullToRefreshScrollView.getmFlag() == 2) {
                    iRound = (int) (-f5);
                }
            }
            footerSize = getHeaderSize();
        } else {
            iRound = Math.round(Math.max(f3 - f4, 0.0f) / 2.0f);
            footerSize = getFooterSize();
        }
        setHeaderScroll(iRound);
        if (iRound == 0 || p()) {
            return;
        }
        float fAbs = Math.abs(iRound) / footerSize;
        if (iArr[this.f4201k.ordinal()] != 1) {
            this.f4211u.a(fAbs);
            i iVar = this.C;
            if (iVar != null) {
                iVar.c(fAbs);
            }
        } else {
            this.f4212v.a(fAbs);
        }
        m mVar = this.f4199i;
        m mVar2 = m.PULL_TO_REFRESH;
        if (mVar != mVar2 && footerSize > Math.abs(iRound)) {
            y(mVar2, new boolean[0]);
        } else {
            if (this.f4199i != mVar2 || footerSize > Math.abs(iRound)) {
                return;
            }
            y(m.RELEASE_TO_REFRESH, new boolean[0]);
        }
    }

    public final void A(int i3, long j3) {
        B(i3, j3, 0L, null);
    }

    protected final void C(int i3, j jVar) {
        B(i3, getPullToRefreshScrollDuration(), 0L, jVar);
    }

    protected void D() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.f4211u.getParent()) {
            removeView(this.f4211u);
        }
        if (this.f4200j.f()) {
            e(this.f4211u, 0, loadingLayoutLayoutParams);
        }
        if (this == this.f4212v.getParent()) {
            removeView(this.f4212v);
        }
        if (this.f4200j.e()) {
            f(this.f4212v, loadingLayoutLayoutParams);
        }
        w();
        e eVar = this.f4200j;
        if (eVar == e.BOTH) {
            eVar = e.PULL_FROM_START;
        }
        this.f4201k = eVar;
    }

    @Override // com.vivo.calculator.pulltorefresh.b.a
    public void a(int i3, int i4) {
        i iVar = this.C;
        if (iVar != null) {
            iVar.g(i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        VLog.v("BBKCalculator/PullToRefreshBase", "addView: " + view.getClass().getSimpleName());
        View refreshableView = getRefreshableView();
        if (!(refreshableView instanceof ViewGroup)) {
            throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
        }
        ((ViewGroup) refreshableView).addView(view, i3, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        i iVar;
        i iVar2;
        if (motionEvent.getAction() == 0) {
            this.f4192b = motionEvent.getRawY();
        }
        if (motionEvent.getAction() == 2 && (iVar2 = this.C) != null) {
            iVar2.b();
        }
        if (motionEvent.getAction() == 1) {
            float rawY = motionEvent.getRawY();
            float f3 = this.f4192b;
            if (f3 != 0.0f && Math.abs(rawY - f3) >= 5.0f && (iVar = this.C) != null) {
                iVar.d();
            }
            i iVar3 = this.C;
            if (iVar3 != null) {
                iVar3.e();
            }
        }
        try {
            if (isAttachedToWindow()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return false;
        } catch (Exception e3) {
            VLog.e("BBKCalculator/PullToRefreshBase", "dispatchTouchEvent:" + e3.getMessage());
            return false;
        }
    }

    protected final void e(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
    }

    protected final void f(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public final e getCurrentMode() {
        return this.f4201k;
    }

    public final boolean getFilterTouchEvents() {
        return this.f4206p;
    }

    public final int getFooterSize() {
        return this.f4212v.getContentSize();
    }

    protected final com.vivo.calculator.pulltorefresh.c getHeaderLayout() {
        return this.f4211u;
    }

    protected final int getHeaderSize() {
        int i3 = this.A;
        return i3 != -1 ? i3 : this.f4211u.getContentSize();
    }

    public final e getMode() {
        return this.f4200j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public abstract k getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration() {
        return 500;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    public final T getRefreshableView() {
        return this.f4202l;
    }

    public i getScrollViewListener() {
        return this.C;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.f4204n;
    }

    public final m getState() {
        return this.f4199i;
    }

    public FrameLayout getmRefreshableViewWrapper() {
        return this.f4203m;
    }

    protected com.vivo.calculator.pulltorefresh.c h(Context context, e eVar, TypedArray typedArray) {
        com.vivo.calculator.pulltorefresh.c cVarA = this.f4210t.a(context, eVar, getPullToRefreshScrollDirection(), typedArray);
        cVarA.setVisibility(4);
        return cVarA;
    }

    protected abstract T i(Context context, AttributeSet attributeSet);

    protected void j(TypedArray typedArray) {
    }

    public final boolean l() {
        return this.f4200j.d();
    }

    protected abstract boolean n();

    protected abstract boolean o();

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (p() || !l()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f4198h = false;
            return false;
        }
        if (action != 0 && this.f4198h) {
            return true;
        }
        if (action != 0) {
            if (action == 2 && m()) {
                float rawY = motionEvent.getRawY();
                float x3 = motionEvent.getX();
                float f3 = rawY - this.f4195e;
                float f4 = x3 - this.f4194d;
                float fAbs = Math.abs(f3);
                if (this.B == 0.0f && fAbs > this.f4193c && (!this.f4206p || fAbs > Math.abs(f4))) {
                    if (this.f4200j.f() && f3 >= 1.0f && o()) {
                        this.f4195e = rawY;
                        this.f4194d = x3;
                        this.f4198h = true;
                        if (this.f4200j == e.BOTH) {
                            this.f4201k = e.PULL_FROM_START;
                        }
                    } else if (this.f4200j.e() && f3 <= -1.0f && n()) {
                        this.f4195e = rawY;
                        this.f4194d = x3;
                        this.f4198h = true;
                        if (this.f4200j == e.BOTH) {
                            this.f4201k = e.PULL_FROM_END;
                        }
                    }
                }
            }
        } else if (m()) {
            float rawY2 = motionEvent.getRawY();
            this.f4197g = rawY2;
            this.f4195e = rawY2;
            float x4 = motionEvent.getX();
            this.f4196f = x4;
            this.f4194d = x4;
            this.f4198h = false;
        }
        return this.f4198h;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        try {
            super.onRestoreInstanceState(parcelable);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i3, int i4, int i5, int i6) {
        VLog.v("BBKCalculator/PullToRefreshBase", String.format(Locale.getDefault(), "onSizeChanged. W: %d, H: %d", Integer.valueOf(i3), Integer.valueOf(i4)));
        super.onSizeChanged(i3, i4, i5, i6);
        w();
        x(i3, i4);
        post(new b());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0044  */
    /* JADX WARN: Code duplicated, block: B:29:0x0048  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!l()) {
            return false;
        }
        if (!this.f4205o && p()) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.f4198h) {
                    this.f4198h = false;
                    if (this.f4199i != m.RELEASE_TO_REFRESH && (this.f4213w != null || this.f4214x != null)) {
                        y(m.REFRESHING, true);
                        return true;
                    }
                    if (p()) {
                        z(0);
                        return true;
                    }
                    y(m.RESET, new boolean[0]);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.f4198h) {
                        this.f4198h = false;
                        if (this.f4199i != m.RELEASE_TO_REFRESH) {
                        }
                        if (p()) {
                            z(0);
                            return true;
                        }
                        y(m.RESET, new boolean[0]);
                        return true;
                    }
                }
            } else if (this.f4198h) {
                this.f4195e = motionEvent.getRawY();
                this.f4194d = motionEvent.getX();
                v();
                return true;
            }
        } else if (m()) {
            float rawY = motionEvent.getRawY();
            this.f4197g = rawY;
            this.f4195e = rawY;
            float x3 = motionEvent.getX();
            this.f4196f = x3;
            this.f4194d = x3;
            return true;
        }
        return false;
    }

    public final boolean p() {
        m mVar = this.f4199i;
        return mVar == m.REFRESHING || mVar == m.MANUAL_REFRESHING;
    }

    protected void q() {
        int i3 = c.f4220b[this.f4201k.ordinal()];
        if (i3 == 1) {
            this.f4212v.c();
            return;
        }
        if (i3 != 2) {
            return;
        }
        this.f4211u.c();
        i iVar = this.C;
        if (iVar != null) {
            iVar.j();
        }
    }

    public final void r() {
        if (p()) {
            y(m.RESET, new boolean[0]);
        }
    }

    protected void s(boolean z2) {
        VLog.v("BBKCalculator/PullToRefreshBase", "onRefreshing doScroll " + z2 + ", mShowViewWhileRefreshing " + this.f4204n + ", mCurrentMode " + this.f4201k);
        if (this.f4200j.f()) {
            this.f4211u.e();
            i iVar = this.C;
            if (iVar != null) {
                iVar.a();
            }
        }
        if (this.f4200j.e()) {
            this.f4212v.e();
        }
        if (!z2) {
            g();
            return;
        }
        if (!this.f4204n) {
            z(0);
            return;
        }
        a aVar = new a();
        int i3 = c.f4220b[this.f4201k.ordinal()];
        if (i3 != 1 && i3 != 3) {
            C(-getHeaderSize(), aVar);
        } else {
            C(getFooterSize(), aVar);
            r();
        }
    }

    public void setCurScrollY(int i3) {
        this.B = i3;
    }

    public void setDisableScrollingWhileRefreshing(boolean z2) {
        setScrollingWhileRefreshingEnabled(!z2);
    }

    public final void setFilterTouchEvents(boolean z2) {
        this.f4206p = z2;
    }

    @TargetApi(11)
    public final void setHeaderScroll(int i3) {
        i iVar;
        VLog.v("BBKCalculator/PullToRefreshBase", "setHeaderScroll: " + i3 + ", mCurrentMode:" + this.f4201k);
        int maximumPullScroll = getMaximumPullScroll();
        if (PullToRefreshScrollView.getmFlag() != 2) {
            i3 = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i3));
        }
        VLog.v("BBKCalculator/PullToRefreshBase", "Clamp value to with pull maximumPullScroll = " + maximumPullScroll + ",value = " + i3);
        if (this.f4208r) {
            if (i3 < 0) {
                this.f4211u.setVisibility(0);
            } else if (i3 <= 0) {
                this.f4211u.setVisibility(4);
                this.f4212v.setVisibility(4);
            }
            if (this.f4201k == e.PULL_FROM_START && (iVar = this.C) != null) {
                iVar.f(i3);
                VLog.v("BBKCalculator/PullToRefreshBase", "mScrollViewListener.onHeaderScrolled(value) " + i3);
            }
        }
        int i4 = c.f4221c[getPullToRefreshScrollDirection().ordinal()];
        if (i4 == 1) {
            scrollTo(i3, 0);
        } else if (i4 == 2 && PullToRefreshScrollView.getmFlag() != 2) {
            scrollTo(0, i3);
        }
    }

    @Override // android.view.View
    public void setLongClickable(boolean z2) {
        getRefreshableView().setLongClickable(z2);
    }

    public final void setMode(e eVar) {
        if (eVar != this.f4200j) {
            VLog.v("BBKCalculator/PullToRefreshBase", "Setting mode to: " + eVar);
            this.f4200j = eVar;
            D();
        }
    }

    public void setOnPullEventListener(InterfaceC0050f<T> interfaceC0050f) {
        this.f4215y = interfaceC0050f;
    }

    public final void setOnRefreshListener(h<T> hVar) {
        this.f4213w = hVar;
        this.f4214x = null;
    }

    public void setOnScrollViewListener(i iVar) {
        this.C = iVar;
    }

    public final void setPullToRefreshEnabled(boolean z2) {
        setMode(z2 ? e.a() : e.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z2) {
        this.f4207q = z2;
    }

    public final void setRefreshing(boolean z2) {
        if (p()) {
            return;
        }
        y(m.MANUAL_REFRESHING, z2);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.f4209s = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z2) {
        this.f4205o = z2;
    }

    public final void setShowViewWhileRefreshing(boolean z2) {
        this.f4204n = z2;
    }

    protected void t() {
        int i3 = c.f4220b[this.f4201k.ordinal()];
        if (i3 == 1) {
            this.f4212v.g();
            return;
        }
        if (i3 != 2) {
            return;
        }
        this.f4211u.g();
        i iVar = this.C;
        if (iVar != null) {
            iVar.i();
        }
    }

    protected void u() {
        this.f4198h = false;
        this.f4208r = true;
        this.f4211u.i();
        this.f4212v.i();
        z(0);
    }

    protected final void w() {
        int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i3 = c.f4221c[getPullToRefreshScrollDirection().ordinal()];
        if (i3 == 1) {
            if (this.f4200j.f()) {
                this.f4211u.setWidth(maximumPullScroll);
                paddingLeft = -maximumPullScroll;
            } else {
                paddingLeft = 0;
            }
            if (this.f4200j.e()) {
                this.f4212v.setWidth(maximumPullScroll);
                paddingRight = -maximumPullScroll;
            } else {
                paddingRight = 0;
            }
        } else if (i3 == 2) {
            if (this.f4200j.f()) {
                this.f4211u.setHeight(maximumPullScroll);
                paddingTop = -maximumPullScroll;
            } else {
                paddingTop = 0;
            }
            if (this.f4200j.e()) {
                this.f4212v.setHeight(maximumPullScroll);
                paddingBottom = -maximumPullScroll;
            } else {
                paddingBottom = 0;
            }
        }
        VLog.v("BBKCalculator/PullToRefreshBase", String.format(Locale.getDefault(), "Setting Padding. L: %d, T: %d, R: %d, B: %d", Integer.valueOf(paddingLeft), Integer.valueOf(paddingTop), Integer.valueOf(paddingRight), Integer.valueOf(paddingBottom)));
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    protected final void x(int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4203m.getLayoutParams();
        int i5 = c.f4221c[getPullToRefreshScrollDirection().ordinal()];
        if (i5 == 1) {
            if (layoutParams.width != i3) {
                layoutParams.width = i3;
                this.f4203m.requestLayout();
                return;
            }
            return;
        }
        if (i5 == 2 && layoutParams.height != i4) {
            layoutParams.height = i4;
            this.f4203m.requestLayout();
        }
    }

    final void y(m mVar, boolean... zArr) {
        this.f4199i = mVar;
        VLog.v("BBKCalculator/PullToRefreshBase", "State: " + this.f4199i.name());
        int i3 = c.f4219a[this.f4199i.ordinal()];
        if (i3 == 1) {
            u();
        } else if (i3 == 2) {
            q();
        } else if (i3 == 3) {
            t();
        } else if (i3 == 4 || i3 == 5) {
            s(zArr[0]);
        }
        InterfaceC0050f<T> interfaceC0050f = this.f4215y;
        if (interfaceC0050f != null) {
            interfaceC0050f.a(this, this.f4199i, this.f4201k);
        }
    }

    protected final void z(int i3) {
        A(i3, getPullToRefreshScrollDuration());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public final void setOnRefreshListener(g<T> gVar) {
        this.f4214x = gVar;
        this.f4213w = null;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4192b = 0.0f;
        this.f4198h = false;
        this.f4199i = m.RESET;
        this.f4200j = e.a();
        this.f4204n = true;
        this.f4205o = false;
        this.f4206p = true;
        this.f4207q = true;
        this.f4208r = true;
        this.f4210t = d.b();
        this.A = -1;
        this.B = -1.0f;
        this.C = null;
        k(context, attributeSet);
    }

    public f(Context context, e eVar) {
        super(context);
        this.f4192b = 0.0f;
        this.f4198h = false;
        this.f4199i = m.RESET;
        this.f4200j = e.a();
        this.f4204n = true;
        this.f4205o = false;
        this.f4206p = true;
        this.f4207q = true;
        this.f4208r = true;
        this.f4210t = d.b();
        this.A = -1;
        this.B = -1.0f;
        this.C = null;
        this.f4200j = eVar;
        k(context, null);
    }

    public f(Context context, e eVar, d dVar) {
        super(context);
        this.f4192b = 0.0f;
        this.f4198h = false;
        this.f4199i = m.RESET;
        this.f4200j = e.a();
        this.f4204n = true;
        this.f4205o = false;
        this.f4206p = true;
        this.f4207q = true;
        this.f4208r = true;
        this.f4210t = d.b();
        this.A = -1;
        this.B = -1.0f;
        this.C = null;
        this.f4200j = eVar;
        this.f4210t = dVar;
        k(context, null);
    }
}
