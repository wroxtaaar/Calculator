package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.t;
import f0.g;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    j0.c f2586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c f2587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2588c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2590e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2589d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2591f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f2592g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f2593h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f2594i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final j0.c.AbstractC0071c f2595j = new a();

    class a extends j0.c.AbstractC0071c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2597b = -1;

        a() {
        }

        private boolean n(View view, float f3) {
            if (f3 == 0.0f) {
                return Math.abs(view.getLeft() - this.f2596a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f2592g);
            }
            boolean z2 = t.B(view) == 1;
            int i3 = SwipeDismissBehavior.this.f2591f;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                if (z2) {
                    if (f3 >= 0.0f) {
                        return false;
                    }
                } else if (f3 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i3 != 1) {
                return false;
            }
            if (z2) {
                if (f3 <= 0.0f) {
                    return false;
                }
            } else if (f3 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // j0.c.AbstractC0071c
        public int a(View view, int i3, int i4) {
            int width;
            int width2;
            int width3;
            boolean z2 = t.B(view) == 1;
            int i5 = SwipeDismissBehavior.this.f2591f;
            if (i5 == 0) {
                if (z2) {
                    width = this.f2596a - view.getWidth();
                    width2 = this.f2596a;
                } else {
                    width = this.f2596a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i5 != 1) {
                width = this.f2596a - view.getWidth();
                width2 = this.f2596a + view.getWidth();
            } else if (z2) {
                width = this.f2596a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f2596a - view.getWidth();
                width2 = this.f2596a;
            }
            return SwipeDismissBehavior.G(width, i3, width2);
        }

        @Override // j0.c.AbstractC0071c
        public int b(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // j0.c.AbstractC0071c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // j0.c.AbstractC0071c
        public void i(View view, int i3) {
            this.f2597b = i3;
            this.f2596a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // j0.c.AbstractC0071c
        public void j(int i3) {
            c cVar = SwipeDismissBehavior.this.f2587b;
            if (cVar != null) {
                cVar.b(i3);
            }
        }

        @Override // j0.c.AbstractC0071c
        public void k(View view, int i3, int i4, int i5, int i6) {
            float width = this.f2596a + (view.getWidth() * SwipeDismissBehavior.this.f2593h);
            float width2 = this.f2596a + (view.getWidth() * SwipeDismissBehavior.this.f2594i);
            float f3 = i3;
            if (f3 <= width) {
                view.setAlpha(1.0f);
            } else if (f3 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f3), 1.0f));
            }
        }

        @Override // j0.c.AbstractC0071c
        public void l(View view, float f3, float f4) {
            int i3;
            boolean z2;
            c cVar;
            this.f2597b = -1;
            int width = view.getWidth();
            if (n(view, f3)) {
                int left = view.getLeft();
                int i4 = this.f2596a;
                i3 = left < i4 ? i4 - width : i4 + width;
                z2 = true;
            } else {
                i3 = this.f2596a;
                z2 = false;
            }
            if (SwipeDismissBehavior.this.f2586a.F(i3, view.getTop())) {
                t.e0(view, new d(view, z2));
            } else {
                if (!z2 || (cVar = SwipeDismissBehavior.this.f2587b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // j0.c.AbstractC0071c
        public boolean m(View view, int i3) {
            int i4 = this.f2597b;
            return (i4 == -1 || i4 == i3) && SwipeDismissBehavior.this.E(view);
        }
    }

    class b implements g {
        b() {
        }

        @Override // f0.g
        public boolean a(View view, g.a aVar) {
            boolean z2 = false;
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z3 = t.B(view) == 1;
            int i3 = SwipeDismissBehavior.this.f2591f;
            if ((i3 == 0 && z3) || (i3 == 1 && !z3)) {
                z2 = true;
            }
            int width = view.getWidth();
            if (z2) {
                width = -width;
            }
            t.X(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f2587b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i3);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f2600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2601c;

        d(View view, boolean z2) {
            this.f2600b = view;
            this.f2601c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            j0.c cVar2 = SwipeDismissBehavior.this.f2586a;
            if (cVar2 != null && cVar2.k(true)) {
                t.e0(this.f2600b, this);
            } else {
                if (!this.f2601c || (cVar = SwipeDismissBehavior.this.f2587b) == null) {
                    return;
                }
                cVar.a(this.f2600b);
            }
        }
    }

    static float F(float f3, float f4, float f5) {
        return Math.min(Math.max(f3, f4), f5);
    }

    static int G(int i3, int i4, int i5) {
        return Math.min(Math.max(i3, i4), i5);
    }

    private void H(ViewGroup viewGroup) {
        if (this.f2586a == null) {
            this.f2586a = this.f2590e ? j0.c.l(viewGroup, this.f2589d, this.f2595j) : j0.c.m(viewGroup, this.f2595j);
        }
    }

    static float I(float f3, float f4, float f5) {
        return (f5 - f3) / (f4 - f3);
    }

    private void N(View view) {
        t.g0(view, 1048576);
        if (E(view)) {
            t.i0(view, f0.d.a.f4662y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        j0.c cVar = this.f2586a;
        if (cVar == null) {
            return false;
        }
        cVar.z(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f3) {
        this.f2594i = F(0.0f, f3, 1.0f);
    }

    public void K(c cVar) {
        this.f2587b = cVar;
    }

    public void L(float f3) {
        this.f2593h = F(0.0f, f3, 1.0f);
    }

    public void M(int i3) {
        this.f2591f = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        boolean zB = this.f2588c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zB = coordinatorLayout.B(v3, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2588c = zB;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2588c = false;
        }
        if (!zB) {
            return false;
        }
        H(coordinatorLayout);
        return this.f2586a.G(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v3, int i3) {
        boolean zL = super.l(coordinatorLayout, v3, i3);
        if (t.z(v3) == 0) {
            t.v0(v3, 1);
            N(v3);
        }
        return zL;
    }
}
