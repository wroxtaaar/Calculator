package j0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import e0.t;
import f0.d;
import f0.e;
import f0.f;
import java.util.ArrayList;
import java.util.List;
import l.h;

/* JADX INFO: compiled from: ExploreByTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends e0.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Rect f4925n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final j0.b.a<d> f4926o = new C0069a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final j0.b.InterfaceC0070b<h<d>, d> f4927p = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AccessibilityManager f4932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f4933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f4934j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f4928d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f4929e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f4930f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f4931g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f4935k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f4936l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4937m = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: j0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    class C0069a implements j0.b.a<d> {
        C0069a() {
        }

        @Override // j0.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d dVar, Rect rect) {
            dVar.l(rect);
        }
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    class b implements j0.b.InterfaceC0070b<h<d>, d> {
        b() {
        }

        @Override // j0.b.InterfaceC0070b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public d b(h<d> hVar, int i3) {
            return hVar.l(i3);
        }

        @Override // j0.b.InterfaceC0070b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int a(h<d> hVar) {
            return hVar.k();
        }
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    private class c extends e {
        c() {
        }

        @Override // f0.e
        public d b(int i3) {
            return d.N(a.this.H(i3));
        }

        @Override // f0.e
        public d d(int i3) {
            int i4 = i3 == 2 ? a.this.f4935k : a.this.f4936l;
            if (i4 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i4);
        }

        @Override // f0.e
        public boolean f(int i3, int i4, Bundle bundle) {
            return a.this.P(i3, i4, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f4933i = view;
        this.f4932h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (t.z(view) == 0) {
            t.v0(view, 1);
        }
    }

    private static Rect D(View view, int i3, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i3 == 17) {
            rect.set(width, 0, width, height);
        } else if (i3 == 33) {
            rect.set(0, height, width, height);
        } else if (i3 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f4933i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f4933i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int F(int i3) {
        if (i3 == 19) {
            return 33;
        }
        if (i3 != 21) {
            return i3 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i3, Rect rect) {
        d dVar;
        h<d> hVarY = y();
        int i4 = this.f4936l;
        d dVarE = i4 == Integer.MIN_VALUE ? null : hVarY.e(i4);
        if (i3 == 1 || i3 == 2) {
            dVar = (d) j0.b.d(hVarY, f4927p, f4926o, dVarE, i3, t.B(this.f4933i) == 1, false);
        } else {
            if (i3 != 17 && i3 != 33 && i3 != 66 && i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i5 = this.f4936l;
            if (i5 != Integer.MIN_VALUE) {
                z(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f4933i, i3, rect2);
            }
            dVar = (d) j0.b.c(hVarY, f4927p, f4926o, dVarE, rect2, i3);
        }
        return T(dVar != null ? hVarY.h(hVarY.g(dVar)) : Integer.MIN_VALUE);
    }

    private boolean Q(int i3, int i4, Bundle bundle) {
        if (i4 == 1) {
            return T(i3);
        }
        if (i4 == 2) {
            return o(i3);
        }
        if (i4 != 64) {
            return i4 != 128 ? J(i3, i4, bundle) : n(i3);
        }
        return S(i3);
    }

    private boolean R(int i3, Bundle bundle) {
        return t.c0(this.f4933i, i3, bundle);
    }

    private boolean S(int i3) {
        int i4;
        if (!this.f4932h.isEnabled() || !this.f4932h.isTouchExplorationEnabled() || (i4 = this.f4935k) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            n(i4);
        }
        this.f4935k = i3;
        this.f4933i.invalidate();
        U(i3, 32768);
        return true;
    }

    private void V(int i3) {
        int i4 = this.f4937m;
        if (i4 == i3) {
            return;
        }
        this.f4937m = i3;
        U(i3, 128);
        U(i4, 256);
    }

    private boolean n(int i3) {
        if (this.f4935k != i3) {
            return false;
        }
        this.f4935k = Integer.MIN_VALUE;
        this.f4933i.invalidate();
        U(i3, 65536);
        return true;
    }

    private boolean p() {
        int i3 = this.f4936l;
        return i3 != Integer.MIN_VALUE && J(i3, 16, null);
    }

    private AccessibilityEvent q(int i3, int i4) {
        return i3 != -1 ? r(i3, i4) : s(i4);
    }

    private AccessibilityEvent r(int i3, int i4) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i4);
        d dVarH = H(i3);
        accessibilityEventObtain.getText().add(dVarH.w());
        accessibilityEventObtain.setContentDescription(dVarH.r());
        accessibilityEventObtain.setScrollable(dVarH.I());
        accessibilityEventObtain.setPassword(dVarH.H());
        accessibilityEventObtain.setEnabled(dVarH.D());
        accessibilityEventObtain.setChecked(dVarH.B());
        L(i3, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(dVarH.o());
        f.c(accessibilityEventObtain, this.f4933i, i3);
        accessibilityEventObtain.setPackageName(this.f4933i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent s(int i3) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
        this.f4933i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private d t(int i3) {
        d dVarL = d.L();
        dVarL.c0(true);
        dVarL.e0(true);
        dVarL.X("android.view.View");
        Rect rect = f4925n;
        dVarL.T(rect);
        dVarL.U(rect);
        dVarL.m0(this.f4933i);
        N(i3, dVarL);
        if (dVarL.w() == null && dVarL.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        dVarL.l(this.f4929e);
        if (this.f4929e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iJ = dVarL.j();
        if ((iJ & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iJ & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        dVarL.k0(this.f4933i.getContext().getPackageName());
        dVarL.r0(this.f4933i, i3);
        if (this.f4935k == i3) {
            dVarL.R(true);
            dVarL.a(128);
        } else {
            dVarL.R(false);
            dVarL.a(64);
        }
        boolean z2 = this.f4936l == i3;
        if (z2) {
            dVarL.a(2);
        } else if (dVarL.E()) {
            dVarL.a(1);
        }
        dVarL.f0(z2);
        this.f4933i.getLocationOnScreen(this.f4931g);
        dVarL.m(this.f4928d);
        if (this.f4928d.equals(rect)) {
            dVarL.l(this.f4928d);
            if (dVarL.f4640b != -1) {
                d dVarL2 = d.L();
                for (int i4 = dVarL.f4640b; i4 != -1; i4 = dVarL2.f4640b) {
                    dVarL2.n0(this.f4933i, -1);
                    dVarL2.T(f4925n);
                    N(i4, dVarL2);
                    dVarL2.l(this.f4929e);
                    Rect rect2 = this.f4928d;
                    Rect rect3 = this.f4929e;
                    rect2.offset(rect3.left, rect3.top);
                }
                dVarL2.P();
            }
            this.f4928d.offset(this.f4931g[0] - this.f4933i.getScrollX(), this.f4931g[1] - this.f4933i.getScrollY());
        }
        if (this.f4933i.getLocalVisibleRect(this.f4930f)) {
            this.f4930f.offset(this.f4931g[0] - this.f4933i.getScrollX(), this.f4931g[1] - this.f4933i.getScrollY());
            if (this.f4928d.intersect(this.f4930f)) {
                dVarL.U(this.f4928d);
                if (E(this.f4928d)) {
                    dVarL.v0(true);
                }
            }
        }
        return dVarL;
    }

    private d u() {
        d dVarM = d.M(this.f4933i);
        t.a0(this.f4933i, dVarM);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (dVarM.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            dVarM.c(this.f4933i, ((Integer) arrayList.get(i3)).intValue());
        }
        return dVarM;
    }

    private h<d> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<d> hVar = new h<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            hVar.i(arrayList.get(i3).intValue(), t(arrayList.get(i3).intValue()));
        }
        return hVar;
    }

    private void z(int i3, Rect rect) {
        H(i3).l(rect);
    }

    public final int A() {
        return this.f4936l;
    }

    protected abstract int B(float f3, float f4);

    protected abstract void C(List<Integer> list);

    d H(int i3) {
        return i3 == -1 ? u() : t(i3);
    }

    public final void I(boolean z2, int i3, Rect rect) {
        int i4 = this.f4936l;
        if (i4 != Integer.MIN_VALUE) {
            o(i4);
        }
        if (z2) {
            G(i3, rect);
        }
    }

    protected abstract boolean J(int i3, int i4, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i3, AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void M(d dVar);

    protected abstract void N(int i3, d dVar);

    protected abstract void O(int i3, boolean z2);

    boolean P(int i3, int i4, Bundle bundle) {
        return i3 != -1 ? Q(i3, i4, bundle) : R(i4, bundle);
    }

    public final boolean T(int i3) {
        int i4;
        if ((!this.f4933i.isFocused() && !this.f4933i.requestFocus()) || (i4 = this.f4936l) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            o(i4);
        }
        if (i3 == Integer.MIN_VALUE) {
            return false;
        }
        this.f4936l = i3;
        O(i3, true);
        U(i3, 8);
        return true;
    }

    public final boolean U(int i3, int i4) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f4932h.isEnabled() || (parent = this.f4933i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f4933i, q(i3, i4));
    }

    @Override // e0.a
    public e b(View view) {
        if (this.f4934j == null) {
            this.f4934j = new c();
        }
        return this.f4934j;
    }

    @Override // e0.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // e0.a
    public void g(View view, d dVar) {
        super.g(view, dVar);
        M(dVar);
    }

    public final boolean o(int i3) {
        if (this.f4936l != i3) {
            return false;
        }
        this.f4936l = Integer.MIN_VALUE;
        O(i3, false);
        U(i3, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f4932h.isEnabled() || !this.f4932h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iB = B(motionEvent.getX(), motionEvent.getY());
            V(iB);
            return iB != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f4937m == Integer.MIN_VALUE) {
            return false;
        }
        V(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i3 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iF = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z2 = false;
                    while (i3 < repeatCount && G(iF, null)) {
                        i3++;
                        z2 = true;
                    }
                    return z2;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.f4935k;
    }
}
