package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.g, androidx.lifecycle.s, androidx.savedstate.b {
    static final Object X = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    private boolean F;
    ViewGroup G;
    View H;
    boolean I;
    d K;
    boolean M;
    boolean N;
    float O;
    LayoutInflater P;
    boolean Q;
    androidx.lifecycle.h S;
    w T;
    androidx.savedstate.a V;
    private int W;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Bundle f1224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    SparseArray<Parcelable> f1225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Boolean f1226e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Bundle f1228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Fragment f1229h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f1231j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f1233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f1234m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f1235n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f1236o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f1237p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f1238q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f1239r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    l f1240s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    i<?> f1241t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Fragment f1243v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f1244w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f1245x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    String f1246y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f1247z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1223b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f1227f = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f1230i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f1232k = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    l f1242u = new m();
    boolean E = true;
    boolean J = true;
    Runnable L = new a();
    androidx.lifecycle.d.b R = androidx.lifecycle.d.b.RESUMED;
    androidx.lifecycle.l<androidx.lifecycle.g> U = new androidx.lifecycle.l<>();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.t1();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.j();
        }
    }

    class c extends androidx.fragment.app.f {
        c() {
        }

        @Override // androidx.fragment.app.f
        public View e(int i3) {
            View view = Fragment.this.H;
            if (view != null) {
                return view.findViewById(i3);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.f
        public boolean f() {
            return Fragment.this.H != null;
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f1252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Animator f1253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1255d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1256e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1257f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1258g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f1259h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f1260i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f1261j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f1262k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Boolean f1263l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Boolean f1264m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        t.f f1265n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        t.f f1266o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f1267p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        f f1268q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f1269r;

        d() {
            Object obj = Fragment.X;
            this.f1258g = obj;
            this.f1259h = null;
            this.f1260i = obj;
            this.f1261j = null;
            this.f1262k = obj;
        }
    }

    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    interface f {
        void a();

        void b();
    }

    public Fragment() {
        Q();
    }

    private void Q() {
        this.S = new androidx.lifecycle.h(this);
        this.V = androidx.savedstate.a.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.S.a(new androidx.lifecycle.e() { // from class: androidx.fragment.app.Fragment.2
                @Override // androidx.lifecycle.e
                public void d(androidx.lifecycle.g gVar, androidx.lifecycle.d.a aVar) {
                    View view;
                    if (aVar != androidx.lifecycle.d.a.ON_STOP || (view = Fragment.this.H) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
    }

    @Deprecated
    public static Fragment S(Context context, String str, Bundle bundle) {
        try {
            Fragment fragmentNewInstance = h.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.m1(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e3) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (InstantiationException e4) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new e("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new e("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    private d l() {
        if (this.K == null) {
            this.K = new d();
        }
        return this.K;
    }

    public final Object A() {
        i<?> iVar = this.f1241t;
        if (iVar == null) {
            return null;
        }
        return iVar.l();
    }

    public void A0(boolean z2) {
    }

    @Deprecated
    public LayoutInflater B(Bundle bundle) {
        i<?> iVar = this.f1241t;
        if (iVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterM = iVar.m();
        e0.f.b(layoutInflaterM, this.f1242u.g0());
        return layoutInflaterM;
    }

    public void B0(int i3, String[] strArr, int[] iArr) {
    }

    int C() {
        d dVar = this.K;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1255d;
    }

    public void C0() {
        this.F = true;
    }

    int D() {
        d dVar = this.K;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1256e;
    }

    public void D0(Bundle bundle) {
    }

    public final Fragment E() {
        return this.f1243v;
    }

    public void E0() {
        this.F = true;
    }

    public final l F() {
        l lVar = this.f1240s;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void F0() {
        this.F = true;
    }

    public Object G() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1260i;
        return obj == X ? x() : obj;
    }

    public void G0(View view, Bundle bundle) {
    }

    public final Resources H() {
        return g1().getResources();
    }

    public void H0(Bundle bundle) {
        this.F = true;
    }

    public final boolean I() {
        return this.B;
    }

    void I0(Bundle bundle) {
        this.f1242u.C0();
        this.f1223b = 2;
        this.F = false;
        b0(bundle);
        if (this.F) {
            this.f1242u.r();
            return;
        }
        throw new x("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public Object J() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1258g;
        return obj == X ? v() : obj;
    }

    void J0() {
        this.f1242u.g(this.f1241t, new c(), this);
        this.f1223b = 0;
        this.F = false;
        e0(this.f1241t.h());
        if (this.F) {
            return;
        }
        throw new x("Fragment " + this + " did not call through to super.onAttach()");
    }

    public Object K() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f1261j;
    }

    void K0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f1242u.s(configuration);
    }

    public Object L() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1262k;
        return obj == X ? K() : obj;
    }

    boolean L0(MenuItem menuItem) {
        if (this.f1247z) {
            return false;
        }
        return g0(menuItem) || this.f1242u.t(menuItem);
    }

    int M() {
        d dVar = this.K;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1254c;
    }

    void M0(Bundle bundle) {
        this.f1242u.C0();
        this.f1223b = 1;
        this.F = false;
        this.V.c(bundle);
        h0(bundle);
        this.Q = true;
        if (this.F) {
            this.S.i(androidx.lifecycle.d.a.ON_CREATE);
            return;
        }
        throw new x("Fragment " + this + " did not call through to super.onCreate()");
    }

    public final String N(int i3) {
        return H().getString(i3);
    }

    boolean N0(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.f1247z) {
            return false;
        }
        if (this.D && this.E) {
            z2 = true;
            k0(menu, menuInflater);
        }
        return z2 | this.f1242u.v(menu, menuInflater);
    }

    public final Fragment O() {
        String str;
        Fragment fragment = this.f1229h;
        if (fragment != null) {
            return fragment;
        }
        l lVar = this.f1240s;
        if (lVar == null || (str = this.f1230i) == null) {
            return null;
        }
        return lVar.V(str);
    }

    void O0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1242u.C0();
        this.f1238q = true;
        this.T = new w();
        View viewL0 = l0(layoutInflater, viewGroup, bundle);
        this.H = viewL0;
        if (viewL0 != null) {
            this.T.e();
            this.U.g(this.T);
        } else {
            if (this.T.f()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.T = null;
        }
    }

    public View P() {
        return this.H;
    }

    void P0() {
        this.f1242u.w();
        this.S.i(androidx.lifecycle.d.a.ON_DESTROY);
        this.f1223b = 0;
        this.F = false;
        this.Q = false;
        m0();
        if (this.F) {
            return;
        }
        throw new x("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void Q0() {
        this.f1242u.x();
        if (this.H != null) {
            this.T.a(androidx.lifecycle.d.a.ON_DESTROY);
        }
        this.f1223b = 1;
        this.F = false;
        o0();
        if (this.F) {
            androidx.loader.app.a.b(this).c();
            this.f1238q = false;
        } else {
            throw new x("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void R() {
        Q();
        this.f1227f = UUID.randomUUID().toString();
        this.f1233l = false;
        this.f1234m = false;
        this.f1235n = false;
        this.f1236o = false;
        this.f1237p = false;
        this.f1239r = 0;
        this.f1240s = null;
        this.f1242u = new m();
        this.f1241t = null;
        this.f1244w = 0;
        this.f1245x = 0;
        this.f1246y = null;
        this.f1247z = false;
        this.A = false;
    }

    void R0() {
        this.f1223b = -1;
        this.F = false;
        p0();
        this.P = null;
        if (this.F) {
            if (this.f1242u.o0()) {
                return;
            }
            this.f1242u.w();
            this.f1242u = new m();
            return;
        }
        throw new x("Fragment " + this + " did not call through to super.onDetach()");
    }

    LayoutInflater S0(Bundle bundle) {
        LayoutInflater layoutInflaterQ0 = q0(bundle);
        this.P = layoutInflaterQ0;
        return layoutInflaterQ0;
    }

    boolean T() {
        d dVar = this.K;
        if (dVar == null) {
            return false;
        }
        return dVar.f1269r;
    }

    void T0() {
        onLowMemory();
        this.f1242u.y();
    }

    final boolean U() {
        return this.f1239r > 0;
    }

    void U0(boolean z2) {
        u0(z2);
        this.f1242u.z(z2);
    }

    public final boolean V() {
        l lVar;
        return this.E && ((lVar = this.f1240s) == null || lVar.r0(this.f1243v));
    }

    boolean V0(MenuItem menuItem) {
        if (this.f1247z) {
            return false;
        }
        return (this.D && this.E && v0(menuItem)) || this.f1242u.A(menuItem);
    }

    boolean W() {
        d dVar = this.K;
        if (dVar == null) {
            return false;
        }
        return dVar.f1267p;
    }

    void W0(Menu menu) {
        if (this.f1247z) {
            return;
        }
        if (this.D && this.E) {
            w0(menu);
        }
        this.f1242u.B(menu);
    }

    public final boolean X() {
        return this.f1234m;
    }

    void X0() {
        this.f1242u.D();
        if (this.H != null) {
            this.T.a(androidx.lifecycle.d.a.ON_PAUSE);
        }
        this.S.i(androidx.lifecycle.d.a.ON_PAUSE);
        this.f1223b = 3;
        this.F = false;
        x0();
        if (this.F) {
            return;
        }
        throw new x("Fragment " + this + " did not call through to super.onPause()");
    }

    final boolean Y() {
        Fragment fragmentE = E();
        return fragmentE != null && (fragmentE.X() || fragmentE.Y());
    }

    void Y0(boolean z2) {
        y0(z2);
        this.f1242u.E(z2);
    }

    public final boolean Z() {
        l lVar = this.f1240s;
        if (lVar == null) {
            return false;
        }
        return lVar.u0();
    }

    boolean Z0(Menu menu) {
        boolean z2 = false;
        if (this.f1247z) {
            return false;
        }
        if (this.D && this.E) {
            z2 = true;
            z0(menu);
        }
        return z2 | this.f1242u.F(menu);
    }

    void a0() {
        this.f1242u.C0();
    }

    void a1() {
        boolean zS0 = this.f1240s.s0(this);
        Boolean bool = this.f1232k;
        if (bool == null || bool.booleanValue() != zS0) {
            this.f1232k = Boolean.valueOf(zS0);
            A0(zS0);
            this.f1242u.G();
        }
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d b() {
        return this.S;
    }

    public void b0(Bundle bundle) {
        this.F = true;
    }

    void b1() {
        this.f1242u.C0();
        this.f1242u.Q(true);
        this.f1223b = 4;
        this.F = false;
        C0();
        if (!this.F) {
            throw new x("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.h hVar = this.S;
        androidx.lifecycle.d.a aVar = androidx.lifecycle.d.a.ON_RESUME;
        hVar.i(aVar);
        if (this.H != null) {
            this.T.a(aVar);
        }
        this.f1242u.H();
    }

    public void c0(int i3, int i4, Intent intent) {
    }

    void c1(Bundle bundle) {
        D0(bundle);
        this.V.d(bundle);
        Parcelable parcelableQ0 = this.f1242u.Q0();
        if (parcelableQ0 != null) {
            bundle.putParcelable("android:support:fragments", parcelableQ0);
        }
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry d() {
        return this.V.b();
    }

    @Deprecated
    public void d0(Activity activity) {
        this.F = true;
    }

    void d1() {
        this.f1242u.C0();
        this.f1242u.Q(true);
        this.f1223b = 3;
        this.F = false;
        E0();
        if (!this.F) {
            throw new x("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.h hVar = this.S;
        androidx.lifecycle.d.a aVar = androidx.lifecycle.d.a.ON_START;
        hVar.i(aVar);
        if (this.H != null) {
            this.T.a(aVar);
        }
        this.f1242u.I();
    }

    public void e0(Context context) {
        this.F = true;
        i<?> iVar = this.f1241t;
        Activity activityG = iVar == null ? null : iVar.g();
        if (activityG != null) {
            this.F = false;
            d0(activityG);
        }
    }

    void e1() {
        this.f1242u.K();
        if (this.H != null) {
            this.T.a(androidx.lifecycle.d.a.ON_STOP);
        }
        this.S.i(androidx.lifecycle.d.a.ON_STOP);
        this.f1223b = 2;
        this.F = false;
        F0();
        if (this.F) {
            return;
        }
        throw new x("Fragment " + this + " did not call through to super.onStop()");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f0(Fragment fragment) {
    }

    public final androidx.fragment.app.d f1() {
        androidx.fragment.app.d dVarN = n();
        if (dVarN != null) {
            return dVarN;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public boolean g0(MenuItem menuItem) {
        return false;
    }

    public final Context g1() {
        Context contextU = u();
        if (contextU != null) {
            return contextU;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void h0(Bundle bundle) {
        this.F = true;
        i1(bundle);
        if (this.f1242u.t0(1)) {
            return;
        }
        this.f1242u.u();
    }

    public final View h1() {
        View viewP = P();
        if (viewP != null) {
            return viewP;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.lifecycle.s
    public androidx.lifecycle.r i() {
        l lVar = this.f1240s;
        if (lVar != null) {
            return lVar.l0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public Animation i0(int i3, boolean z2, int i4) {
        return null;
    }

    void i1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f1242u.O0(parcelable);
        this.f1242u.u();
    }

    void j() {
        d dVar = this.K;
        f fVar = null;
        if (dVar != null) {
            dVar.f1267p = false;
            f fVar2 = dVar.f1268q;
            dVar.f1268q = null;
            fVar = fVar2;
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    public Animator j0(int i3, boolean z2, int i4) {
        return null;
    }

    final void j1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f1225d;
        if (sparseArray != null) {
            this.H.restoreHierarchyState(sparseArray);
            this.f1225d = null;
        }
        this.F = false;
        H0(bundle);
        if (this.F) {
            if (this.H != null) {
                this.T.a(androidx.lifecycle.d.a.ON_CREATE);
            }
        } else {
            throw new x("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f1244w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f1245x));
        printWriter.print(" mTag=");
        printWriter.println(this.f1246y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1223b);
        printWriter.print(" mWho=");
        printWriter.print(this.f1227f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f1239r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f1233l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f1234m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f1235n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f1236o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f1247z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.J);
        if (this.f1240s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f1240s);
        }
        if (this.f1241t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f1241t);
        }
        if (this.f1243v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f1243v);
        }
        if (this.f1228g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1228g);
        }
        if (this.f1224c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1224c);
        }
        if (this.f1225d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1225d);
        }
        Fragment fragmentO = O();
        if (fragmentO != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentO);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1231j);
        }
        if (C() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(C());
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.H);
        }
        if (q() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(q());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(M());
        }
        if (u() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f1242u + ":");
        this.f1242u.M(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void k0(Menu menu, MenuInflater menuInflater) {
    }

    void k1(View view) {
        l().f1252a = view;
    }

    public View l0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3 = this.W;
        if (i3 != 0) {
            return layoutInflater.inflate(i3, viewGroup, false);
        }
        return null;
    }

    void l1(Animator animator) {
        l().f1253b = animator;
    }

    Fragment m(String str) {
        return str.equals(this.f1227f) ? this : this.f1242u.Y(str);
    }

    public void m0() {
        this.F = true;
    }

    public void m1(Bundle bundle) {
        if (this.f1240s != null && Z()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f1228g = bundle;
    }

    public final androidx.fragment.app.d n() {
        i<?> iVar = this.f1241t;
        if (iVar == null) {
            return null;
        }
        return (androidx.fragment.app.d) iVar.g();
    }

    public void n0() {
    }

    void n1(boolean z2) {
        l().f1269r = z2;
    }

    public boolean o() {
        Boolean bool;
        d dVar = this.K;
        if (dVar == null || (bool = dVar.f1264m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void o0() {
        this.F = true;
    }

    void o1(int i3) {
        if (this.K == null && i3 == 0) {
            return;
        }
        l().f1255d = i3;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        f1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.F = true;
    }

    public boolean p() {
        Boolean bool;
        d dVar = this.K;
        if (dVar == null || (bool = dVar.f1263l) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void p0() {
        this.F = true;
    }

    void p1(int i3) {
        if (this.K == null && i3 == 0) {
            return;
        }
        l();
        this.K.f1256e = i3;
    }

    View q() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f1252a;
    }

    public LayoutInflater q0(Bundle bundle) {
        return B(bundle);
    }

    void q1(f fVar) {
        l();
        d dVar = this.K;
        f fVar2 = dVar.f1268q;
        if (fVar == fVar2) {
            return;
        }
        if (fVar != null && fVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (dVar.f1267p) {
            dVar.f1268q = fVar;
        }
        if (fVar != null) {
            fVar.b();
        }
    }

    Animator r() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f1253b;
    }

    public void r0(boolean z2) {
    }

    void r1(int i3) {
        l().f1254c = i3;
    }

    public final Bundle s() {
        return this.f1228g;
    }

    @Deprecated
    public void s0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    public void s1(Fragment fragment, int i3) {
        l lVar = this.f1240s;
        l lVar2 = fragment != null ? fragment.f1240s : null;
        if (lVar != null && lVar2 != null && lVar != lVar2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragmentO = fragment; fragmentO != null; fragmentO = fragmentO.O()) {
            if (fragmentO == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.f1230i = null;
            this.f1229h = null;
        } else if (this.f1240s == null || fragment.f1240s == null) {
            this.f1230i = null;
            this.f1229h = fragment;
        } else {
            this.f1230i = fragment.f1227f;
            this.f1229h = null;
        }
        this.f1231j = i3;
    }

    public final l t() {
        if (this.f1241t != null) {
            return this.f1242u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void t0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
        i<?> iVar = this.f1241t;
        Activity activityG = iVar == null ? null : iVar.g();
        if (activityG != null) {
            this.F = false;
            s0(activityG, attributeSet, bundle);
        }
    }

    public void t1() {
        l lVar = this.f1240s;
        if (lVar == null || lVar.f1359o == null) {
            l().f1267p = false;
        } else if (Looper.myLooper() != this.f1240s.f1359o.j().getLooper()) {
            this.f1240s.f1359o.j().postAtFrontOfQueue(new b());
        } else {
            j();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1227f);
        sb.append(")");
        if (this.f1244w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1244w));
        }
        if (this.f1246y != null) {
            sb.append(" ");
            sb.append(this.f1246y);
        }
        sb.append('}');
        return sb.toString();
    }

    public Context u() {
        i<?> iVar = this.f1241t;
        if (iVar == null) {
            return null;
        }
        return iVar.h();
    }

    public void u0(boolean z2) {
    }

    public Object v() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f1257f;
    }

    public boolean v0(MenuItem menuItem) {
        return false;
    }

    t.f w() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f1265n;
    }

    public void w0(Menu menu) {
    }

    public Object x() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f1259h;
    }

    public void x0() {
        this.F = true;
    }

    t.f y() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f1266o;
    }

    public void y0(boolean z2) {
    }

    @Deprecated
    public final l z() {
        return this.f1240s;
    }

    public void z0(Menu menu) {
    }
}
