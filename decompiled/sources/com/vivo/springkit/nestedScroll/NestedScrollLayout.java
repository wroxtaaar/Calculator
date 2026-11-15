package com.vivo.springkit.nestedScroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import e0.n;
import e0.o;
import q2.b;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollLayout extends LinearLayout implements n {
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f4292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f4293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f4294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f4295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final o f4296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f4297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4298m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f4299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f4301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private b f4302q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f4303r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4304s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4305t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4306u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f4307v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f4308w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f4309x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f4310y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f4311z;

    public NestedScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        b bVar = this.f4302q;
        if (bVar == null || bVar.q()) {
            return;
        }
        this.f4302q.a();
    }

    private void b(int i3, float f3) {
        r2.a.a("NestedScrollLayout", "doSpringBack orientation=" + i3 + " , offset = " + f3);
        if (getOrientation() == 1) {
            int iM = (int) this.f4302q.m();
            r2.a.a("NestedScrollLayout", "doSpringBack velocity=" + iM);
            if (i3 == 1 || i3 == 0) {
                this.f4302q.s(0, 0, -iM);
            }
        } else if (getOrientation() == 0) {
            int iL = (int) this.f4302q.l();
            r2.a.a("NestedScrollLayout", "doSpringBack velocity=" + iL);
            if (i3 == 3 || i3 == 2) {
                this.f4302q.r(0, 0, -iL);
            }
        }
        postInvalidateOnAnimation();
        this.f4302q.i();
    }

    private void c() {
        View childAt = getChildAt(0);
        this.f4295j = childAt;
        if (childAt == null) {
            throw new RuntimeException("NestedScrollLayout must have at least one child!");
        }
        if (!(childAt instanceof RecyclerView) || n2.a.d(getContext(), this.f4295j, true)) {
            return;
        }
        n2.b.e(getContext(), this.f4295j, true);
    }

    private void d() {
        if (this.f4302q != null) {
            return;
        }
        if (this.f4295j instanceof RecyclerView) {
            this.f4302q = new b(getContext());
        } else {
            this.f4302q = new b(getContext());
        }
    }

    private void e(float f3, float f4) {
        if (getOrientation() == 1) {
            this.f4304s = 0;
            this.f4302q.j(0, 0, 0, (int) f4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            this.f4303r = 0;
            this.f4302q.j(0, 0, (int) f3, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        }
        invalidate();
    }

    private void f(int i3, int i4, int[] iArr) {
        if (getOrientation() == 1) {
            if (i4 > 0) {
                float f3 = this.f4297l;
                if (f3 > 0.0f) {
                    if (i4 > f3) {
                        iArr[1] = (int) (iArr[1] + f3);
                        q(0.0f);
                        return;
                    } else {
                        iArr[1] = iArr[1] + i4;
                        q((-i4) + f3);
                        return;
                    }
                }
            }
            if (i4 < 0) {
                float f4 = this.f4297l;
                if (f4 < 0.0f) {
                    if (i4 < f4) {
                        iArr[1] = (int) (iArr[1] + f4);
                        q(0.0f);
                        return;
                    } else {
                        iArr[1] = iArr[1] + i4;
                        q((-i4) + f4);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i3 > 0) {
            float f5 = this.f4297l;
            if (f5 > 0.0f) {
                if (i3 > f5) {
                    iArr[0] = (int) (iArr[0] + f5);
                    q(0.0f);
                    return;
                } else {
                    iArr[0] = iArr[0] + i3;
                    q((-i3) + f5);
                    return;
                }
            }
        }
        if (i3 < 0) {
            float f6 = this.f4297l;
            if (f6 < 0.0f) {
                if (i3 < f6) {
                    iArr[0] = (int) (iArr[0] + f6);
                    q(0.0f);
                } else {
                    iArr[0] = iArr[0] + i3;
                    q((-i3) + f6);
                }
            }
        }
    }

    private void g(float f3) {
        int i3;
        if (f3 == 0.0f) {
            return;
        }
        if (getOrientation() == 1) {
            i3 = f3 > 0.0f ? this.f4299n : this.f4298m;
        } else {
            i3 = f3 > 0.0f ? this.f4300o : this.f4301p;
        }
        float f4 = i3;
        if (f4 == 0.0f) {
            return;
        }
        float fPow = (((float) Math.pow(this.f4297l / f4, 2.0d)) * 4.0f) + 2.0f;
        float f5 = (int) (f3 / fPow);
        r2.a.a("NestedScrollLayout", "distance = " + f5 + ", mMoveDistance = " + this.f4297l + " , damping = " + fPow);
        q(this.f4297l + (f5 * (-1.0f)));
    }

    private void k(float f3) {
        if (f3 == 0.0f) {
            return;
        }
        q(f3);
    }

    private void l() {
        a();
        this.E = false;
    }

    private void p(int i3, int i4) {
        r2.a.a("NestedScrollLayout", "overScroll, orientation = " + i3 + ", offset = " + i4);
        this.f4305t = true;
        b(i3, (float) i4);
    }

    private void q(float f3) {
        r2.a.a("NestedScrollLayout", "transContent : distance = " + f3);
        if (!(this.f4308w && this.f4306u) && f3 > 0.0f) {
            return;
        }
        if (!(this.f4309x && this.f4307v) && f3 < 0.0f) {
            return;
        }
        if (getOrientation() == 1) {
            if (Math.abs(f3) > Math.max(this.f4298m, this.f4299n)) {
                return;
            }
        } else if (Math.abs(f3) > Math.max(this.f4300o, this.f4301p)) {
            return;
        }
        this.f4297l = f3;
        if (this.f4295j != null) {
            if (getOrientation() == 1) {
                this.f4295j.setTranslationY(this.f4297l);
            } else {
                this.f4295j.setTranslationX(this.f4297l);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar = this.f4302q;
        if (bVar == null || bVar.q() || !this.f4302q.i()) {
            this.f4305t = false;
            return;
        }
        if (getOrientation() == 1) {
            int iO = this.f4302q.o();
            int i3 = iO - this.f4304s;
            this.f4304s = iO;
            if (!this.f4305t && i3 < 0 && this.f4297l >= 0.0f && !a.a(this.f4295j)) {
                r2.a.a("NestedScrollLayout", "ORIENTATION_DOWN overScroll");
                p(1, i3);
            } else if (!this.f4305t && i3 > 0 && this.f4297l <= 0.0f && !a.d(this.f4295j)) {
                r2.a.a("NestedScrollLayout", "ORIENTATION_UP overScroll");
                p(0, i3);
            } else if (this.f4305t) {
                r2.a.a("NestedScrollLayout", "currY=" + iO);
                k((float) iO);
            }
        } else {
            int iN = this.f4302q.n();
            int i4 = iN - this.f4303r;
            this.f4303r = iN;
            if (!this.f4305t && i4 < 0 && this.f4297l >= 0.0f && !a.c(this.f4295j)) {
                r2.a.a("NestedScrollLayout", "ORIENTATION_RIGHT overScroll");
                p(3, i4);
            } else if (!this.f4305t && i4 > 0 && this.f4297l <= 0.0f && !a.b(this.f4295j)) {
                r2.a.a("NestedScrollLayout", "ORIENTATION_LEFT overScroll");
                p(2, i4);
            } else if (this.f4305t) {
                r2.a.a("NestedScrollLayout", "currX=" + iN);
                k((float) iN);
            }
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.C) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.E = true;
            this.B = 0;
            this.A = false;
            this.f4310y = motionEvent.getRawX();
            this.f4311z = motionEvent.getRawY();
        } else if (actionMasked == 1) {
            if (this.D) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (actionMasked == 2) {
            if (this.E) {
                l();
            }
            float rawX = motionEvent.getRawX() - this.f4310y;
            float rawY = motionEvent.getRawY() - this.f4311z;
            if (!this.A && this.D) {
                ViewParent parent = getParent();
                if (getOrientation() == 0) {
                    if (Math.abs(rawX) >= Math.abs(rawY)) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                } else if (Math.abs(rawX) < Math.abs(rawY)) {
                    parent.requestDisallowInterceptTouchEvent(true);
                } else {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
            int i3 = this.B + 1;
            this.B = i3;
            if (i3 > 2) {
                this.A = true;
            }
        } else if (actionMasked == 3) {
            if (this.D) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        c();
        d();
        int iF = a.f(getContext());
        int iG = a.g(getContext());
        this.f4298m = this.f4306u ? iF : 0;
        if (!this.f4307v) {
            iF = 0;
        }
        this.f4299n = iF;
        this.f4300o = this.f4309x ? iG : 0;
        if (!this.f4308w) {
            iG = 0;
        }
        this.f4301p = iG;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4295j.getLayoutParams();
        this.f4295j.layout(getPaddingLeft() + marginLayoutParams.leftMargin, getPaddingTop() + marginLayoutParams.topMargin, getPaddingLeft() + marginLayoutParams.leftMargin + this.f4295j.getMeasuredWidth(), getPaddingTop() + marginLayoutParams.topMargin + this.f4295j.getMeasuredHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            measureChildWithMargins(getChildAt(i5), i3, 0, i4, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.onNestedFling(view, f3, f4, z2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedPreFling(View view, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            r2.a.a("NestedScrollLayout", "onNestedPreFling, velocityX = " + f3 + ", velocityY = " + f4 + ", moveDistance = " + this.f4297l);
            if (this.f4297l == 0.0f) {
                if (getOrientation() == 1) {
                    if (!this.f4306u && f4 < 0.0f) {
                        return false;
                    }
                    if (!this.f4307v && f4 > 0.0f) {
                        return false;
                    }
                } else {
                    if (!this.f4309x && f3 < 0.0f) {
                        return false;
                    }
                    if (!this.f4308w && f3 > 0.0f) {
                        return false;
                    }
                }
            }
            e(f3, f4);
            if (getOrientation() == 1) {
                if ((f4 > 0.0f && this.f4297l > 0.0f) || (f4 < 0.0f && this.f4297l < 0.0f)) {
                    return true;
                }
            } else if ((f3 > 0.0f && this.f4297l > 0.0f) || (f3 < 0.0f && this.f4297l < 0.0f)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            f(i3, i4, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 21) {
            r2.a.a("NestedScrollLayout", "onNestedScroll, dyConsumed = " + i4 + ", dyUnconsumed = " + i6);
            if (getOrientation() == 1) {
                g(i6);
            } else {
                g(i5);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4296k.b(view, view2, i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (getOrientation() == 1) {
            return (i3 & 2) != 0;
        }
        return (i3 & 1) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onStopNestedScroll(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            r2.a.a("NestedScrollLayout", "onStopNestedScroll, mMoveDistance = " + this.f4297l);
            if (this.f4297l != 0.0f) {
                this.f4305t = true;
                if (getOrientation() == 1) {
                    this.f4302q.s((int) this.f4297l, 0, 0);
                } else {
                    this.f4302q.r((int) this.f4297l, 0, 0);
                }
                postInvalidateOnAnimation();
            }
        }
    }

    public void setBottomOverScrollEnable(boolean z2) {
        this.f4299n = z2 ? a.f(getContext()) : 0;
        this.f4307v = z2;
    }

    public void setDisallowInterceptEnable(boolean z2) {
        r2.a.a("NestedScrollLayout", "setDisalowInterceptEnable, enable = " + z2);
        this.D = z2;
    }

    public void setLeftOverScrollEnable(boolean z2) {
        this.f4301p = z2 ? a.g(getContext()) : 0;
        this.f4308w = z2;
    }

    public void setRightOverScrollEnable(boolean z2) {
        this.f4300o = z2 ? a.g(getContext()) : 0;
        this.f4309x = z2;
    }

    public void setTopOverScrollEnable(boolean z2) {
        this.f4298m = z2 ? a.f(getContext()) : 0;
        this.f4306u = z2;
    }

    public void setTouchEnable(boolean z2) {
        this.C = z2;
    }

    public NestedScrollLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4287b = "NestedScrollLayout";
        this.f4288c = 0;
        this.f4289d = 1;
        this.f4290e = 2;
        this.f4291f = 3;
        this.f4292g = 700;
        this.f4293h = 500;
        this.f4294i = -1.0f;
        this.f4305t = false;
        this.f4306u = true;
        this.f4307v = true;
        this.f4308w = true;
        this.f4309x = true;
        this.f4310y = 0.0f;
        this.f4311z = 0.0f;
        this.A = false;
        this.B = 0;
        this.C = true;
        this.D = false;
        this.E = false;
        this.f4296k = new o(this);
        if (Build.VERSION.SDK_INT >= 21) {
            setNestedScrollingEnabled(true);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m2.a.NestedScrollLayout, i3, 0);
        try {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                if (index == m2.a.NestedScrollLayout_disallowintercept_enable) {
                    setDisallowInterceptEnable(typedArrayObtainStyledAttributes.getBoolean(index, false));
                } else if (index == m2.a.NestedScrollLayout_touch_enable) {
                    setTouchEnable(typedArrayObtainStyledAttributes.getBoolean(index, true));
                }
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
