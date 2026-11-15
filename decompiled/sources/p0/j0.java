package p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: Visibility.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends m {
    private static final String[] M = {"android:visibility:visibility", "android:visibility:parent"};
    private int L = 3;

    /* JADX INFO: compiled from: Visibility.java */
    class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f5659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f5660d;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f5658b = viewGroup;
            this.f5659c = view;
            this.f5660d = view2;
        }

        @Override // p0.n, p0.m.f
        public void a(m mVar) {
            if (this.f5659c.getParent() == null) {
                x.a(this.f5658b).a(this.f5659c);
            } else {
                j0.this.f();
            }
        }

        @Override // p0.m.f
        public void b(m mVar) {
            this.f5660d.setTag(j.save_overlay_view, null);
            x.a(this.f5658b).c(this.f5659c);
            mVar.P(this);
        }

        @Override // p0.n, p0.m.f
        public void c(m mVar) {
            x.a(this.f5658b).c(this.f5659c);
        }
    }

    /* JADX INFO: compiled from: Visibility.java */
    private static class b extends AnimatorListenerAdapter implements m.f, p0.a.InterfaceC0078a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f5662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f5663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ViewGroup f5664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f5665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f5667g = false;

        b(View view, int i3, boolean z2) {
            this.f5662b = view;
            this.f5663c = i3;
            this.f5664d = (ViewGroup) view.getParent();
            this.f5665e = z2;
            g(true);
        }

        private void f() {
            if (!this.f5667g) {
                c0.h(this.f5662b, this.f5663c);
                ViewGroup viewGroup = this.f5664d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z2) {
            ViewGroup viewGroup;
            if (!this.f5665e || this.f5666f == z2 || (viewGroup = this.f5664d) == null) {
                return;
            }
            this.f5666f = z2;
            x.c(viewGroup, z2);
        }

        @Override // p0.m.f
        public void a(m mVar) {
            g(true);
        }

        @Override // p0.m.f
        public void b(m mVar) {
            f();
            mVar.P(this);
        }

        @Override // p0.m.f
        public void c(m mVar) {
            g(false);
        }

        @Override // p0.m.f
        public void d(m mVar) {
        }

        @Override // p0.m.f
        public void e(m mVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5667g = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, p0.a.InterfaceC0078a
        public void onAnimationPause(Animator animator) {
            if (this.f5667g) {
                return;
            }
            c0.h(this.f5662b, this.f5663c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, p0.a.InterfaceC0078a
        public void onAnimationResume(Animator animator) {
            if (this.f5667g) {
                return;
            }
            c0.h(this.f5662b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: Visibility.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f5672e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewGroup f5673f;

        c() {
        }
    }

    private void c0(s sVar) {
        sVar.f5725a.put("android:visibility:visibility", Integer.valueOf(sVar.f5726b.getVisibility()));
        sVar.f5725a.put("android:visibility:parent", sVar.f5726b.getParent());
        int[] iArr = new int[2];
        sVar.f5726b.getLocationOnScreen(iArr);
        sVar.f5725a.put("android:visibility:screenLocation", iArr);
    }

    private c d0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f5668a = false;
        cVar.f5669b = false;
        if (sVar == null || !sVar.f5725a.containsKey("android:visibility:visibility")) {
            cVar.f5670c = -1;
            cVar.f5672e = null;
        } else {
            cVar.f5670c = ((Integer) sVar.f5725a.get("android:visibility:visibility")).intValue();
            cVar.f5672e = (ViewGroup) sVar.f5725a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f5725a.containsKey("android:visibility:visibility")) {
            cVar.f5671d = -1;
            cVar.f5673f = null;
        } else {
            cVar.f5671d = ((Integer) sVar2.f5725a.get("android:visibility:visibility")).intValue();
            cVar.f5673f = (ViewGroup) sVar2.f5725a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i3 = cVar.f5670c;
            int i4 = cVar.f5671d;
            if (i3 == i4 && cVar.f5672e == cVar.f5673f) {
                return cVar;
            }
            if (i3 != i4) {
                if (i3 == 0) {
                    cVar.f5669b = false;
                    cVar.f5668a = true;
                } else if (i4 == 0) {
                    cVar.f5669b = true;
                    cVar.f5668a = true;
                }
            } else if (cVar.f5673f == null) {
                cVar.f5669b = false;
                cVar.f5668a = true;
            } else if (cVar.f5672e == null) {
                cVar.f5669b = true;
                cVar.f5668a = true;
            }
        } else if (sVar == null && cVar.f5671d == 0) {
            cVar.f5669b = true;
            cVar.f5668a = true;
        } else if (sVar2 == null && cVar.f5670c == 0) {
            cVar.f5669b = false;
            cVar.f5668a = true;
        }
        return cVar;
    }

    @Override // p0.m
    public String[] D() {
        return M;
    }

    @Override // p0.m
    public boolean F(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f5725a.containsKey("android:visibility:visibility") != sVar.f5725a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarD0 = d0(sVar, sVar2);
        if (cVarD0.f5668a) {
            return cVarD0.f5670c == 0 || cVarD0.f5671d == 0;
        }
        return false;
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator f0(ViewGroup viewGroup, s sVar, int i3, s sVar2, int i4) {
        if ((this.L & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f5726b.getParent();
            if (d0(t(view, false), E(view, false)).f5668a) {
                return null;
            }
        }
        return e0(viewGroup, sVar2.f5726b, sVar, sVar2);
    }

    @Override // p0.m
    public void g(s sVar) {
        c0(sVar);
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    public Animator h0(ViewGroup viewGroup, s sVar, int i3, s sVar2, int i4) {
        View view;
        boolean z2;
        boolean z3;
        View view2;
        if ((this.L & 2) != 2 || sVar == null) {
            return null;
        }
        View view3 = sVar.f5726b;
        View viewA = sVar2 != null ? sVar2.f5726b : null;
        int i5 = j.save_overlay_view;
        View view4 = (View) view3.getTag(i5);
        if (view4 != null) {
            view2 = null;
            z3 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z2 = false;
                } else {
                    viewA = null;
                    view = null;
                    z2 = true;
                }
            } else if (i4 == 4 || view3 == viewA) {
                view = viewA;
                z2 = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z2 = true;
            }
            if (z2) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (d0(E(view5, true), t(view5, true)).f5668a) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.f5701x) {
                            }
                        } else {
                            viewA = r.a(viewGroup, view3, view5);
                        }
                    }
                    z3 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z3 = false;
                view4 = view3;
            } else {
                z3 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            c0.h(view2, 0);
            Animator animatorG0 = g0(viewGroup, view2, sVar, sVar2);
            if (animatorG0 != null) {
                b bVar = new b(view2, i4, true);
                animatorG0.addListener(bVar);
                p0.a.a(animatorG0, bVar);
                a(bVar);
            } else {
                c0.h(view2, visibility);
            }
            return animatorG0;
        }
        if (!z3) {
            int[] iArr = (int[]) sVar.f5725a.get("android:visibility:screenLocation");
            int i6 = iArr[0];
            int i7 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i6 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i7 - iArr2[1]) - view4.getTop());
            x.a(viewGroup).a(view4);
        }
        Animator animatorG1 = g0(viewGroup, view4, sVar, sVar2);
        if (!z3) {
            if (animatorG1 == null) {
                x.a(viewGroup).c(view4);
            } else {
                view3.setTag(i5, view4);
                a(new a(viewGroup, view4, view3));
            }
        }
        return animatorG1;
    }

    public void i0(int i3) {
        if ((i3 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.L = i3;
    }

    @Override // p0.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // p0.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        c cVarD0 = d0(sVar, sVar2);
        if (!cVarD0.f5668a) {
            return null;
        }
        if (cVarD0.f5672e == null && cVarD0.f5673f == null) {
            return null;
        }
        return cVarD0.f5669b ? f0(viewGroup, sVar, cVarD0.f5670c, sVar2, cVarD0.f5671d) : h0(viewGroup, sVar, cVarD0.f5670c, sVar2, cVarD0.f5671d);
    }
}
