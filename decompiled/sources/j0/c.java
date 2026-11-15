package j0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import e0.t;
import java.util.Arrays;

/* JADX INFO: compiled from: ViewDragHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Interpolator f4943x = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4945b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f4947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f4948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f4949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f4950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f4951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f4952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f4953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f4955l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4956m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4957n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4958o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f4959p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f4960q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private OverScroller f4961r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AbstractC0071c f4962s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f4963t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4964u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ViewGroup f4965v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4946c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f4966w = new b();

    /* JADX INFO: compiled from: ViewDragHelper.java */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: ViewDragHelper.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E(0);
        }
    }

    /* JADX INFO: renamed from: j0.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewDragHelper.java */
    public static abstract class AbstractC0071c {
        public abstract int a(View view, int i3, int i4);

        public abstract int b(View view, int i3, int i4);

        public int c(int i3) {
            return i3;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i3, int i4) {
        }

        public boolean g(int i3) {
            return false;
        }

        public void h(int i3, int i4) {
        }

        public void i(View view, int i3) {
        }

        public abstract void j(int i3);

        public abstract void k(View view, int i3, int i4, int i5, int i6);

        public abstract void l(View view, float f3, float f4);

        public abstract boolean m(View view, int i3);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0071c abstractC0071c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0071c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f4965v = viewGroup;
        this.f4962s = abstractC0071c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f4959p = i3;
        this.f4958o = i3;
        this.f4945b = viewConfiguration.getScaledTouchSlop();
        this.f4956m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4957n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4961r = new OverScroller(context, f4943x);
    }

    private void A() {
        this.f4955l.computeCurrentVelocity(1000, this.f4956m);
        n(e(this.f4955l.getXVelocity(this.f4946c), this.f4957n, this.f4956m), e(this.f4955l.getYVelocity(this.f4946c), this.f4957n, this.f4956m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [j0.c$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void B(float f3, float f4, int i3) {
        int i4;
        boolean zC = c(f3, f4, i3, 1);
        ?? r3 = zC;
        if (c(f4, f3, i3, 4)) {
            r3 = (zC ? 1 : 0) | 4;
        }
        ?? r4 = r3;
        if (c(f3, f4, i3, 2)) {
            r4 = (r3 == true ? 1 : 0) | 2;
        }
        ?? r5 = r4;
        if (c(f4, f3, i3, 8)) {
            i4 = (r4 == true ? 1 : 0) | 8;
        }
        if (r5 == 0) {
            r5 = i4;
            return;
        }
        r5 = i4;
        int[] iArr = this.f4952i;
        iArr[i3] = (iArr[i3] | r5) == true ? 1 : 0;
        this.f4962s.f(r5, i3);
    }

    private void C(float f3, float f4, int i3) {
        q(i3);
        float[] fArr = this.f4947d;
        this.f4949f[i3] = f3;
        fArr[i3] = f3;
        float[] fArr2 = this.f4948e;
        this.f4950g[i3] = f4;
        fArr2[i3] = f4;
        this.f4951h[i3] = t((int) f3, (int) f4);
        this.f4954k |= 1 << i3;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (x(pointerId)) {
                float x3 = motionEvent.getX(i3);
                float y3 = motionEvent.getY(i3);
                this.f4949f[pointerId] = x3;
                this.f4950g[pointerId] = y3;
            }
        }
    }

    private boolean c(float f3, float f4, int i3, int i4) {
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        if ((this.f4951h[i3] & i4) != i4 || (this.f4960q & i4) == 0 || (this.f4953j[i3] & i4) == i4 || (this.f4952i[i3] & i4) == i4) {
            return false;
        }
        int i5 = this.f4945b;
        if (fAbs <= i5 && fAbs2 <= i5) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f4962s.g(i4)) {
            return (this.f4952i[i3] & i4) == 0 && fAbs > ((float) this.f4945b);
        }
        int[] iArr = this.f4953j;
        iArr[i3] = iArr[i3] | i4;
        return false;
    }

    private boolean d(View view, float f3, float f4) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.f4962s.d(view) > 0;
        boolean z3 = this.f4962s.e(view) > 0;
        if (z2 && z3) {
            float f5 = (f3 * f3) + (f4 * f4);
            int i3 = this.f4945b;
            return f5 > ((float) (i3 * i3));
        }
        if (z2) {
            return Math.abs(f3) > ((float) this.f4945b);
        }
        return z3 && Math.abs(f4) > ((float) this.f4945b);
    }

    private float e(float f3, float f4, float f5) {
        float fAbs = Math.abs(f3);
        if (fAbs < f4) {
            return 0.0f;
        }
        if (fAbs > f5) {
            return f3 > 0.0f ? f5 : -f5;
        }
        return f3;
    }

    private int f(int i3, int i4, int i5) {
        int iAbs = Math.abs(i3);
        if (iAbs < i4) {
            return 0;
        }
        if (iAbs > i5) {
            return i3 > 0 ? i5 : -i5;
        }
        return i3;
    }

    private void g() {
        float[] fArr = this.f4947d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f4948e, 0.0f);
        Arrays.fill(this.f4949f, 0.0f);
        Arrays.fill(this.f4950g, 0.0f);
        Arrays.fill(this.f4951h, 0);
        Arrays.fill(this.f4952i, 0);
        Arrays.fill(this.f4953j, 0);
        this.f4954k = 0;
    }

    private void h(int i3) {
        if (this.f4947d == null || !w(i3)) {
            return;
        }
        this.f4947d[i3] = 0.0f;
        this.f4948e[i3] = 0.0f;
        this.f4949f[i3] = 0.0f;
        this.f4950g[i3] = 0.0f;
        this.f4951h[i3] = 0;
        this.f4952i[i3] = 0;
        this.f4953j[i3] = 0;
        this.f4954k = (~(1 << i3)) & this.f4954k;
    }

    private int i(int i3, int i4, int i5) {
        if (i3 == 0) {
            return 0;
        }
        int width = this.f4965v.getWidth();
        float f3 = width / 2;
        float fO = f3 + (o(Math.min(1.0f, Math.abs(i3) / width)) * f3);
        int iAbs = Math.abs(i4);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i3) / i5) + 1.0f) * 256.0f), SecurityKeyException.SK_ERROR_KEY_ENV_ISSUE);
    }

    private int j(View view, int i3, int i4, int i5, int i6) {
        float f3;
        float f4;
        float f5;
        float f6;
        int iF = f(i5, (int) this.f4957n, (int) this.f4956m);
        int iF2 = f(i6, (int) this.f4957n, (int) this.f4956m);
        int iAbs = Math.abs(i3);
        int iAbs2 = Math.abs(i4);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i7 = iAbs3 + iAbs4;
        int i8 = iAbs + iAbs2;
        if (iF != 0) {
            f3 = iAbs3;
            f4 = i7;
        } else {
            f3 = iAbs;
            f4 = i8;
        }
        float f7 = f3 / f4;
        if (iF2 != 0) {
            f5 = iAbs4;
            f6 = i7;
        } else {
            f5 = iAbs2;
            f6 = i8;
        }
        return (int) ((i(i3, iF, this.f4962s.d(view)) * f7) + (i(i4, iF2, this.f4962s.e(view)) * (f5 / f6)));
    }

    public static c l(ViewGroup viewGroup, float f3, AbstractC0071c abstractC0071c) {
        c cVarM = m(viewGroup, abstractC0071c);
        cVarM.f4945b = (int) (cVarM.f4945b * (1.0f / f3));
        return cVarM;
    }

    public static c m(ViewGroup viewGroup, AbstractC0071c abstractC0071c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0071c);
    }

    private void n(float f3, float f4) {
        this.f4964u = true;
        this.f4962s.l(this.f4963t, f3, f4);
        this.f4964u = false;
        if (this.f4944a == 1) {
            E(0);
        }
    }

    private float o(float f3) {
        return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
    }

    private void p(int i3, int i4, int i5, int i6) {
        int left = this.f4963t.getLeft();
        int top = this.f4963t.getTop();
        if (i5 != 0) {
            i3 = this.f4962s.a(this.f4963t, i3, i5);
            t.X(this.f4963t, i3 - left);
        }
        int i7 = i3;
        if (i6 != 0) {
            i4 = this.f4962s.b(this.f4963t, i4, i6);
            t.Y(this.f4963t, i4 - top);
        }
        int i8 = i4;
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.f4962s.k(this.f4963t, i7, i8, i7 - left, i8 - top);
    }

    private void q(int i3) {
        float[] fArr = this.f4947d;
        if (fArr == null || fArr.length <= i3) {
            int i4 = i3 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f4948e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f4949f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f4950g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f4951h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f4952i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f4953j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f4947d = fArr2;
            this.f4948e = fArr3;
            this.f4949f = fArr4;
            this.f4950g = fArr5;
            this.f4951h = iArr;
            this.f4952i = iArr2;
            this.f4953j = iArr3;
        }
    }

    private boolean s(int i3, int i4, int i5, int i6) {
        int left = this.f4963t.getLeft();
        int top = this.f4963t.getTop();
        int i7 = i3 - left;
        int i8 = i4 - top;
        if (i7 == 0 && i8 == 0) {
            this.f4961r.abortAnimation();
            E(0);
            return false;
        }
        this.f4961r.startScroll(left, top, i7, i8, j(this.f4963t, i7, i8, i5, i6));
        E(2);
        return true;
    }

    private int t(int i3, int i4) {
        int i5 = i3 < this.f4965v.getLeft() + this.f4958o ? 1 : 0;
        if (i4 < this.f4965v.getTop() + this.f4958o) {
            i5 |= 4;
        }
        if (i3 > this.f4965v.getRight() - this.f4958o) {
            i5 |= 2;
        }
        return i4 > this.f4965v.getBottom() - this.f4958o ? i5 | 8 : i5;
    }

    private boolean x(int i3) {
        if (w(i3)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void E(int i3) {
        this.f4965v.removeCallbacks(this.f4966w);
        if (this.f4944a != i3) {
            this.f4944a = i3;
            this.f4962s.j(i3);
            if (this.f4944a == 0) {
                this.f4963t = null;
            }
        }
    }

    public boolean F(int i3, int i4) {
        if (this.f4964u) {
            return s(i3, i4, (int) this.f4955l.getXVelocity(this.f4946c), (int) this.f4955l.getYVelocity(this.f4946c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean G(MotionEvent motionEvent) {
        boolean z2;
        View viewR;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f4955l == null) {
            this.f4955l = VelocityTracker.obtain();
        }
        this.f4955l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                a();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    a();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x3 = motionEvent.getX(actionIndex);
                    float y3 = motionEvent.getY(actionIndex);
                    C(x3, y3, pointerId);
                    int i3 = this.f4944a;
                    if (i3 == 0) {
                        int i4 = this.f4951h[pointerId];
                        int i5 = this.f4960q;
                        if ((i4 & i5) != 0) {
                            this.f4962s.h(i4 & i5, pointerId);
                        }
                    } else if (i3 == 2 && (viewR = r((int) x3, (int) y3)) == this.f4963t) {
                        I(viewR, pointerId);
                    }
                } else if (actionMasked == 6) {
                    h(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.f4947d != null && this.f4948e != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i6 = 0; i6 < pointerCount; i6++) {
                    int pointerId2 = motionEvent.getPointerId(i6);
                    if (x(pointerId2)) {
                        float x4 = motionEvent.getX(i6);
                        float y4 = motionEvent.getY(i6);
                        float f3 = x4 - this.f4947d[pointerId2];
                        float f4 = y4 - this.f4948e[pointerId2];
                        View viewR2 = r((int) x4, (int) y4);
                        boolean z3 = viewR2 != null && d(viewR2, f3, f4);
                        if (!z3) {
                            B(f3, f4, pointerId2);
                            if (this.f4944a != 1) {
                                break;
                            }
                        } else {
                            int left = viewR2.getLeft();
                            int i7 = (int) f3;
                            int iA = this.f4962s.a(viewR2, left + i7, i7);
                            int top = viewR2.getTop();
                            int i8 = (int) f4;
                            int iB = this.f4962s.b(viewR2, top + i8, i8);
                            int iD = this.f4962s.d(viewR2);
                            int iE = this.f4962s.e(viewR2);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            B(f3, f4, pointerId2);
                            if (this.f4944a != 1 || (z3 && I(viewR2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                D(motionEvent);
            }
            z2 = false;
        } else {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            z2 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            C(x5, y5, pointerId3);
            View viewR3 = r((int) x5, (int) y5);
            if (viewR3 == this.f4963t && this.f4944a == 2) {
                I(viewR3, pointerId3);
            }
            int i9 = this.f4951h[pointerId3];
            int i10 = this.f4960q;
            if ((i9 & i10) != 0) {
                this.f4962s.h(i9 & i10, pointerId3);
            }
        }
        if (this.f4944a == 1) {
            return true;
        }
        return z2;
    }

    public boolean H(View view, int i3, int i4) {
        this.f4963t = view;
        this.f4946c = -1;
        boolean zS = s(i3, i4, 0, 0);
        if (!zS && this.f4944a == 0 && this.f4963t != null) {
            this.f4963t = null;
        }
        return zS;
    }

    boolean I(View view, int i3) {
        if (view == this.f4963t && this.f4946c == i3) {
            return true;
        }
        if (view == null || !this.f4962s.m(view, i3)) {
            return false;
        }
        this.f4946c = i3;
        b(view, i3);
        return true;
    }

    public void a() {
        this.f4946c = -1;
        g();
        VelocityTracker velocityTracker = this.f4955l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4955l = null;
        }
    }

    public void b(View view, int i3) {
        if (view.getParent() == this.f4965v) {
            this.f4963t = view;
            this.f4946c = i3;
            this.f4962s.i(view, i3);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f4965v + ")");
    }

    public boolean k(boolean z2) {
        if (this.f4944a == 2) {
            boolean zComputeScrollOffset = this.f4961r.computeScrollOffset();
            int currX = this.f4961r.getCurrX();
            int currY = this.f4961r.getCurrY();
            int left = currX - this.f4963t.getLeft();
            int top = currY - this.f4963t.getTop();
            if (left != 0) {
                t.X(this.f4963t, left);
            }
            if (top != 0) {
                t.Y(this.f4963t, top);
            }
            if (left != 0 || top != 0) {
                this.f4962s.k(this.f4963t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f4961r.getFinalX() && currY == this.f4961r.getFinalY()) {
                this.f4961r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z2) {
                    this.f4965v.post(this.f4966w);
                } else {
                    E(0);
                }
            }
        }
        return this.f4944a == 2;
    }

    public View r(int i3, int i4) {
        for (int childCount = this.f4965v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f4965v.getChildAt(this.f4962s.c(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f4945b;
    }

    public boolean v(int i3, int i4) {
        return y(this.f4963t, i3, i4);
    }

    public boolean w(int i3) {
        return (this.f4954k & (1 << i3)) != 0;
    }

    public boolean y(View view, int i3, int i4) {
        return view != null && i3 >= view.getLeft() && i3 < view.getRight() && i4 >= view.getTop() && i4 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f4955l == null) {
            this.f4955l = VelocityTracker.obtain();
        }
        this.f4955l.addMovement(motionEvent);
        int i4 = 0;
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x3, (int) y3);
            C(x3, y3, pointerId);
            I(viewR, pointerId);
            int i5 = this.f4951h[pointerId];
            int i6 = this.f4960q;
            if ((i5 & i6) != 0) {
                this.f4962s.h(i5 & i6, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f4944a == 1) {
                A();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f4944a == 1) {
                if (x(this.f4946c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f4946c);
                    float x4 = motionEvent.getX(iFindPointerIndex);
                    float y4 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f4949f;
                    int i7 = this.f4946c;
                    int i8 = (int) (x4 - fArr[i7]);
                    int i9 = (int) (y4 - this.f4950g[i7]);
                    p(this.f4963t.getLeft() + i8, this.f4963t.getTop() + i9, i8, i9);
                    D(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i4 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i4);
                if (x(pointerId2)) {
                    float x5 = motionEvent.getX(i4);
                    float y5 = motionEvent.getY(i4);
                    float f3 = x5 - this.f4947d[pointerId2];
                    float f4 = y5 - this.f4948e[pointerId2];
                    B(f3, f4, pointerId2);
                    if (this.f4944a != 1) {
                        View viewR2 = r((int) x5, (int) y5);
                        if (d(viewR2, f3, f4) && I(viewR2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i4++;
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f4944a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x6 = motionEvent.getX(actionIndex);
            float y6 = motionEvent.getY(actionIndex);
            C(x6, y6, pointerId3);
            if (this.f4944a != 0) {
                if (v((int) x6, (int) y6)) {
                    I(this.f4963t, pointerId3);
                    return;
                }
                return;
            } else {
                I(r((int) x6, (int) y6), pointerId3);
                int i10 = this.f4951h[pointerId3];
                int i11 = this.f4960q;
                if ((i10 & i11) != 0) {
                    this.f4962s.h(i10 & i11, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f4944a == 1 && pointerId4 == this.f4946c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i4 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i4);
                if (pointerId5 != this.f4946c) {
                    View viewR3 = r((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
                    View view = this.f4963t;
                    if (viewR3 == view && I(view, pointerId5)) {
                        i3 = this.f4946c;
                        break;
                    }
                }
                i4++;
            }
            if (i3 == -1) {
                A();
            }
        }
        h(pointerId4);
    }
}
