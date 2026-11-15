package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: LinearSmoothScroller.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends RecyclerView.z {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected PointF f2070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DisplayMetrics f2071l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f2073n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f2068i = new LinearInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f2069j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2072m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f2074o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f2075p = 0;

    public g(Context context) {
        this.f2071l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f2072m) {
            this.f2073n = v(this.f2071l);
            this.f2072m = true;
        }
        return this.f2073n;
    }

    private int y(int i3, int i4) {
        int i5 = i3 - i4;
        if (i3 * i5 <= 0) {
            return 0;
        }
        return i5;
    }

    protected int B() {
        PointF pointF = this.f2070k;
        if (pointF != null) {
            float f3 = pointF.y;
            if (f3 != 0.0f) {
                return f3 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.z.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.f2070k = pointFA;
        this.f2074o = (int) (pointFA.x * 10000.0f);
        this.f2075p = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.f2074o * 1.2f), (int) (this.f2075p * 1.2f), (int) (x(10000) * 1.2f), this.f2068i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void l(int i3, int i4, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f2074o = y(this.f2074o, i3);
        int iY = y(this.f2075p, i4);
        this.f2075p = iY;
        if (this.f2074o == 0 && iY == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void n() {
        this.f2075p = 0;
        this.f2074o = 0;
        this.f2070k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        int iT = t(view, z());
        int iU = u(view, B());
        int iW = w((int) Math.sqrt((iT * iT) + (iU * iU)));
        if (iW > 0) {
            aVar.d(-iT, -iU, iW, this.f2069j);
        }
    }

    public int s(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == -1) {
            return i5 - i3;
        }
        if (i7 != 0) {
            if (i7 == 1) {
                return i6 - i4;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i8 = i5 - i3;
        if (i8 > 0) {
            return i8;
        }
        int i9 = i6 - i4;
        if (i9 < 0) {
            return i9;
        }
        return 0;
    }

    public int t(View view, int i3) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.k()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.Q(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, oVarE.T(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, oVarE.e0(), oVarE.o0() - oVarE.f0(), i3);
    }

    public int u(View view, int i3) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.l()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.U(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, oVarE.O(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, oVarE.g0(), oVarE.W() - oVarE.d0(), i3);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int w(int i3) {
        return (int) Math.ceil(((double) x(i3)) / 0.3356d);
    }

    protected int x(int i3) {
        return (int) Math.ceil(Math.abs(i3) * A());
    }

    protected int z() {
        PointF pointF = this.f2070k;
        if (pointF != null) {
            float f3 = pointF.x;
            if (f3 != 0.0f) {
                return f3 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
