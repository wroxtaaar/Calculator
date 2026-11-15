package b;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.p0;
import e0.a0;
import e0.t;
import e0.x;
import e0.y;
import e0.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends b.a implements ActionBarOverlayLayout.d {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f2339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f2341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f2342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ActionBarContainer f2343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    d0 f2344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ActionBarContextView f2345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    View f2346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    p0 f2347i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    d f2351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    g.b f2352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    g.b.a f2353o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f2354p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2356r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f2359u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f2360v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f2361w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    g.h f2363y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f2364z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<Object> f2348j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2349k = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ArrayList<b.a.b> f2355q = new ArrayList<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f2357s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f2358t = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f2362x = true;
    final y B = new a();
    final y C = new b();
    final a0 D = new c();

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    class a extends z {
        a() {
        }

        @Override // e0.y
        public void a(View view) {
            View view2;
            k kVar = k.this;
            if (kVar.f2358t && (view2 = kVar.f2346h) != null) {
                view2.setTranslationY(0.0f);
                k.this.f2343e.setTranslationY(0.0f);
            }
            k.this.f2343e.setVisibility(8);
            k.this.f2343e.setTransitioning(false);
            k kVar2 = k.this;
            kVar2.f2363y = null;
            kVar2.A();
            ActionBarOverlayLayout actionBarOverlayLayout = k.this.f2342d;
            if (actionBarOverlayLayout != null) {
                t.j0(actionBarOverlayLayout);
            }
        }
    }

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    class b extends z {
        b() {
        }

        @Override // e0.y
        public void a(View view) {
            k kVar = k.this;
            kVar.f2363y = null;
            kVar.f2343e.requestLayout();
        }
    }

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    class c implements a0 {
        c() {
        }

        @Override // e0.a0
        public void a(View view) {
            ((View) k.this.f2343e.getParent()).invalidate();
        }
    }

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class d extends g.b implements androidx.appcompat.view.menu.e.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Context f2368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final androidx.appcompat.view.menu.e f2369e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g.b.a f2370f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private WeakReference<View> f2371g;

        public d(Context context, g.b.a aVar) {
            this.f2368d = context;
            this.f2370f = aVar;
            androidx.appcompat.view.menu.e eVarS = new androidx.appcompat.view.menu.e(context).S(1);
            this.f2369e = eVarS;
            eVarS.R(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            g.b.a aVar = this.f2370f;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.f2370f == null) {
                return;
            }
            k();
            k.this.f2345g.l();
        }

        @Override // g.b
        public void c() {
            k kVar = k.this;
            if (kVar.f2351m != this) {
                return;
            }
            if (k.z(kVar.f2359u, kVar.f2360v, false)) {
                this.f2370f.c(this);
            } else {
                k kVar2 = k.this;
                kVar2.f2352n = this;
                kVar2.f2353o = this.f2370f;
            }
            this.f2370f = null;
            k.this.y(false);
            k.this.f2345g.g();
            k.this.f2344f.m().sendAccessibilityEvent(32);
            k kVar3 = k.this;
            kVar3.f2342d.setHideOnContentScrollEnabled(kVar3.A);
            k.this.f2351m = null;
        }

        @Override // g.b
        public View d() {
            WeakReference<View> weakReference = this.f2371g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // g.b
        public Menu e() {
            return this.f2369e;
        }

        @Override // g.b
        public MenuInflater f() {
            return new g.g(this.f2368d);
        }

        @Override // g.b
        public CharSequence g() {
            return k.this.f2345g.getSubtitle();
        }

        @Override // g.b
        public CharSequence i() {
            return k.this.f2345g.getTitle();
        }

        @Override // g.b
        public void k() {
            if (k.this.f2351m != this) {
                return;
            }
            this.f2369e.d0();
            try {
                this.f2370f.a(this, this.f2369e);
            } finally {
                this.f2369e.c0();
            }
        }

        @Override // g.b
        public boolean l() {
            return k.this.f2345g.j();
        }

        @Override // g.b
        public void m(View view) {
            k.this.f2345g.setCustomView(view);
            this.f2371g = new WeakReference<>(view);
        }

        @Override // g.b
        public void n(int i3) {
            o(k.this.f2339a.getResources().getString(i3));
        }

        @Override // g.b
        public void o(CharSequence charSequence) {
            k.this.f2345g.setSubtitle(charSequence);
        }

        @Override // g.b
        public void q(int i3) {
            r(k.this.f2339a.getResources().getString(i3));
        }

        @Override // g.b
        public void r(CharSequence charSequence) {
            k.this.f2345g.setTitle(charSequence);
        }

        @Override // g.b
        public void s(boolean z2) {
            super.s(z2);
            k.this.f2345g.setTitleOptional(z2);
        }

        public boolean t() {
            this.f2369e.d0();
            try {
                return this.f2370f.b(this, this.f2369e);
            } finally {
                this.f2369e.c0();
            }
        }
    }

    public k(Activity activity, boolean z2) {
        this.f2341c = activity;
        View decorView = activity.getWindow().getDecorView();
        G(decorView);
        if (z2) {
            return;
        }
        this.f2346h = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d0 D(View view) {
        if (view instanceof d0) {
            return (d0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void F() {
        if (this.f2361w) {
            this.f2361w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2342d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            O(false);
        }
    }

    private void G(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(a.f.decor_content_parent);
        this.f2342d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f2344f = D(view.findViewById(a.f.action_bar));
        this.f2345g = (ActionBarContextView) view.findViewById(a.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(a.f.action_bar_container);
        this.f2343e = actionBarContainer;
        d0 d0Var = this.f2344f;
        if (d0Var == null || this.f2345g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f2339a = d0Var.o();
        boolean z2 = (this.f2344f.i() & 4) != 0;
        if (z2) {
            this.f2350l = true;
        }
        g.a aVarB = g.a.b(this.f2339a);
        L(aVarB.a() || z2);
        J(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f2339a.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
            K(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            I(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void J(boolean z2) {
        this.f2356r = z2;
        if (z2) {
            this.f2343e.setTabContainer(null);
            this.f2344f.l(this.f2347i);
        } else {
            this.f2344f.l(null);
            this.f2343e.setTabContainer(this.f2347i);
        }
        boolean z3 = E() == 2;
        p0 p0Var = this.f2347i;
        if (p0Var != null) {
            if (z3) {
                p0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2342d;
                if (actionBarOverlayLayout != null) {
                    t.j0(actionBarOverlayLayout);
                }
            } else {
                p0Var.setVisibility(8);
            }
        }
        this.f2344f.u(!this.f2356r && z3);
        this.f2342d.setHasNonEmbeddedTabs(!this.f2356r && z3);
    }

    private boolean M() {
        return t.S(this.f2343e);
    }

    private void N() {
        if (this.f2361w) {
            return;
        }
        this.f2361w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2342d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        O(false);
    }

    private void O(boolean z2) {
        if (z(this.f2359u, this.f2360v, this.f2361w)) {
            if (this.f2362x) {
                return;
            }
            this.f2362x = true;
            C(z2);
            return;
        }
        if (this.f2362x) {
            this.f2362x = false;
            B(z2);
        }
    }

    static boolean z(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return (z2 || z3) ? false : true;
    }

    void A() {
        g.b.a aVar = this.f2353o;
        if (aVar != null) {
            aVar.c(this.f2352n);
            this.f2352n = null;
            this.f2353o = null;
        }
    }

    public void B(boolean z2) {
        View view;
        g.h hVar = this.f2363y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f2357s != 0 || (!this.f2364z && !z2)) {
            this.B.a(null);
            return;
        }
        this.f2343e.setAlpha(1.0f);
        this.f2343e.setTransitioning(true);
        g.h hVar2 = new g.h();
        float f3 = -this.f2343e.getHeight();
        if (z2) {
            int[] iArr = {0, 0};
            this.f2343e.getLocationInWindow(iArr);
            f3 -= iArr[1];
        }
        x xVarK = t.d(this.f2343e).k(f3);
        xVarK.i(this.D);
        hVar2.c(xVarK);
        if (this.f2358t && (view = this.f2346h) != null) {
            hVar2.c(t.d(view).k(f3));
        }
        hVar2.f(E);
        hVar2.e(250L);
        hVar2.g(this.B);
        this.f2363y = hVar2;
        hVar2.h();
    }

    public void C(boolean z2) {
        View view;
        View view2;
        g.h hVar = this.f2363y;
        if (hVar != null) {
            hVar.a();
        }
        this.f2343e.setVisibility(0);
        if (this.f2357s == 0 && (this.f2364z || z2)) {
            this.f2343e.setTranslationY(0.0f);
            float f3 = -this.f2343e.getHeight();
            if (z2) {
                int[] iArr = {0, 0};
                this.f2343e.getLocationInWindow(iArr);
                f3 -= iArr[1];
            }
            this.f2343e.setTranslationY(f3);
            g.h hVar2 = new g.h();
            x xVarK = t.d(this.f2343e).k(0.0f);
            xVarK.i(this.D);
            hVar2.c(xVarK);
            if (this.f2358t && (view2 = this.f2346h) != null) {
                view2.setTranslationY(f3);
                hVar2.c(t.d(this.f2346h).k(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250L);
            hVar2.g(this.C);
            this.f2363y = hVar2;
            hVar2.h();
        } else {
            this.f2343e.setAlpha(1.0f);
            this.f2343e.setTranslationY(0.0f);
            if (this.f2358t && (view = this.f2346h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2342d;
        if (actionBarOverlayLayout != null) {
            t.j0(actionBarOverlayLayout);
        }
    }

    public int E() {
        return this.f2344f.p();
    }

    public void H(int i3, int i4) {
        int i5 = this.f2344f.i();
        if ((i4 & 4) != 0) {
            this.f2350l = true;
        }
        this.f2344f.v((i3 & i4) | ((~i4) & i5));
    }

    public void I(float f3) {
        t.t0(this.f2343e, f3);
    }

    public void K(boolean z2) {
        if (z2 && !this.f2342d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z2;
        this.f2342d.setHideOnContentScrollEnabled(z2);
    }

    public void L(boolean z2) {
        this.f2344f.n(z2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z2) {
        this.f2358t = z2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.f2360v) {
            this.f2360v = false;
            O(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        g.h hVar = this.f2363y;
        if (hVar != null) {
            hVar.a();
            this.f2363y = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(int i3) {
        this.f2357s = i3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.f2360v) {
            return;
        }
        this.f2360v = true;
        O(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // b.a
    public boolean h() {
        d0 d0Var = this.f2344f;
        if (d0Var == null || !d0Var.s()) {
            return false;
        }
        this.f2344f.collapseActionView();
        return true;
    }

    @Override // b.a
    public void i(boolean z2) {
        if (z2 == this.f2354p) {
            return;
        }
        this.f2354p = z2;
        int size = this.f2355q.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f2355q.get(i3).a(z2);
        }
    }

    @Override // b.a
    public int j() {
        return this.f2344f.i();
    }

    @Override // b.a
    public Context k() {
        if (this.f2340b == null) {
            TypedValue typedValue = new TypedValue();
            this.f2339a.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.f2340b = new ContextThemeWrapper(this.f2339a, i3);
            } else {
                this.f2340b = this.f2339a;
            }
        }
        return this.f2340b;
    }

    @Override // b.a
    public void m(Configuration configuration) {
        J(g.a.b(this.f2339a).g());
    }

    @Override // b.a
    public boolean o(int i3, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f2351m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i3, keyEvent, 0);
    }

    @Override // b.a
    public void r(boolean z2) {
        if (this.f2350l) {
            return;
        }
        s(z2);
    }

    @Override // b.a
    public void s(boolean z2) {
        H(z2 ? 4 : 0, 4);
    }

    @Override // b.a
    public void t(boolean z2) {
        H(z2 ? 8 : 0, 8);
    }

    @Override // b.a
    public void u(boolean z2) {
        g.h hVar;
        this.f2364z = z2;
        if (z2 || (hVar = this.f2363y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // b.a
    public void v(CharSequence charSequence) {
        this.f2344f.setTitle(charSequence);
    }

    @Override // b.a
    public void w(CharSequence charSequence) {
        this.f2344f.setWindowTitle(charSequence);
    }

    @Override // b.a
    public g.b x(g.b.a aVar) {
        d dVar = this.f2351m;
        if (dVar != null) {
            dVar.c();
        }
        this.f2342d.setHideOnContentScrollEnabled(false);
        this.f2345g.k();
        d dVar2 = new d(this.f2345g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f2351m = dVar2;
        dVar2.k();
        this.f2345g.h(dVar2);
        y(true);
        this.f2345g.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void y(boolean z2) {
        x xVarF;
        x xVarF2;
        if (z2) {
            N();
        } else {
            F();
        }
        if (!M()) {
            if (z2) {
                this.f2344f.j(4);
                this.f2345g.setVisibility(0);
                return;
            } else {
                this.f2344f.j(0);
                this.f2345g.setVisibility(8);
                return;
            }
        }
        if (z2) {
            xVarF = this.f2344f.q(4, 100L);
            xVarF2 = this.f2345g.f(0, 200L);
        } else {
            x xVarQ = this.f2344f.q(0, 200L);
            xVarF = this.f2345g.f(8, 100L);
            xVarF2 = xVarQ;
        }
        g.h hVar = new g.h();
        hVar.d(xVarF, xVarF2);
        hVar.h();
    }

    public k(Dialog dialog) {
        G(dialog.getWindow().getDecorView());
    }
}
