package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: FragmentStateManager.java */
/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f1411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Fragment f1412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1413c = -1;

    /* JADX INFO: compiled from: FragmentStateManager.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1414a;

        static {
            int[] iArr = new int[androidx.lifecycle.d.b.values().length];
            f1414a = iArr;
            try {
                iArr[androidx.lifecycle.d.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1414a[androidx.lifecycle.d.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1414a[androidx.lifecycle.d.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    q(k kVar, Fragment fragment) {
        this.f1411a = kVar;
        this.f1412b = fragment;
    }

    private Bundle n() {
        Bundle bundle = new Bundle();
        this.f1412b.c1(bundle);
        this.f1411a.j(this.f1412b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1412b.H != null) {
            p();
        }
        if (this.f1412b.f1225d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1412b.f1225d);
        }
        if (!this.f1412b.J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1412b.J);
        }
        return bundle;
    }

    void a() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1412b);
        }
        Fragment fragment = this.f1412b;
        fragment.I0(fragment.f1224c);
        k kVar = this.f1411a;
        Fragment fragment2 = this.f1412b;
        kVar.a(fragment2, fragment2.f1224c, false);
    }

    void b(i<?> iVar, l lVar, Fragment fragment) {
        Fragment fragment2 = this.f1412b;
        fragment2.f1241t = iVar;
        fragment2.f1243v = fragment;
        fragment2.f1240s = lVar;
        this.f1411a.g(fragment2, iVar.h(), false);
        this.f1412b.J0();
        Fragment fragment3 = this.f1412b;
        Fragment fragment4 = fragment3.f1243v;
        if (fragment4 == null) {
            iVar.k(fragment3);
        } else {
            fragment4.f0(fragment3);
        }
        this.f1411a.b(this.f1412b, iVar.h(), false);
    }

    int c() {
        int iMin = this.f1413c;
        Fragment fragment = this.f1412b;
        if (fragment.f1235n) {
            if (fragment.f1236o) {
                iMin = Math.max(iMin, 1);
            } else {
                iMin = iMin < 2 ? Math.min(iMin, fragment.f1223b) : Math.min(iMin, 1);
            }
        }
        if (!this.f1412b.f1233l) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment2 = this.f1412b;
        if (fragment2.f1234m) {
            iMin = fragment2.U() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        Fragment fragment3 = this.f1412b;
        if (fragment3.I && fragment3.f1223b < 3) {
            iMin = Math.min(iMin, 2);
        }
        int i3 = a.f1414a[this.f1412b.R.ordinal()];
        if (i3 == 1) {
            return iMin;
        }
        if (i3 != 2) {
            return i3 != 3 ? Math.min(iMin, -1) : Math.min(iMin, 1);
        }
        return Math.min(iMin, 3);
    }

    void d() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1412b);
        }
        Fragment fragment = this.f1412b;
        if (fragment.Q) {
            fragment.i1(fragment.f1224c);
            this.f1412b.f1223b = 1;
            return;
        }
        this.f1411a.h(fragment, fragment.f1224c, false);
        Fragment fragment2 = this.f1412b;
        fragment2.M0(fragment2.f1224c);
        k kVar = this.f1411a;
        Fragment fragment3 = this.f1412b;
        kVar.c(fragment3, fragment3.f1224c, false);
    }

    void e(f fVar) {
        String resourceName;
        if (this.f1412b.f1235n) {
            return;
        }
        if (l.p0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1412b);
        }
        ViewGroup viewGroup = null;
        Fragment fragment = this.f1412b;
        ViewGroup viewGroup2 = fragment.G;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i3 = fragment.f1245x;
            if (i3 != 0) {
                if (i3 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f1412b + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fVar.e(i3);
                if (viewGroup == null) {
                    Fragment fragment2 = this.f1412b;
                    if (!fragment2.f1237p) {
                        try {
                            resourceName = fragment2.H().getResourceName(this.f1412b.f1245x);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1412b.f1245x) + " (" + resourceName + ") for fragment " + this.f1412b);
                    }
                }
            }
        }
        Fragment fragment3 = this.f1412b;
        fragment3.G = viewGroup;
        fragment3.O0(fragment3.S0(fragment3.f1224c), viewGroup, this.f1412b.f1224c);
        View view = this.f1412b.H;
        if (view != null) {
            boolean z2 = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.f1412b;
            fragment4.H.setTag(k0.b.fragment_container_view_tag, fragment4);
            if (viewGroup != null) {
                viewGroup.addView(this.f1412b.H);
            }
            Fragment fragment5 = this.f1412b;
            if (fragment5.f1247z) {
                fragment5.H.setVisibility(8);
            }
            e0.t.j0(this.f1412b.H);
            Fragment fragment6 = this.f1412b;
            fragment6.G0(fragment6.H, fragment6.f1224c);
            k kVar = this.f1411a;
            Fragment fragment7 = this.f1412b;
            kVar.m(fragment7, fragment7.H, fragment7.f1224c, false);
            Fragment fragment8 = this.f1412b;
            if (fragment8.H.getVisibility() == 0 && this.f1412b.G != null) {
                z2 = true;
            }
            fragment8.M = z2;
        }
    }

    void f(i<?> iVar, o oVar) {
        if (l.p0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1412b);
        }
        Fragment fragment = this.f1412b;
        boolean zIsChangingConfigurations = true;
        boolean z2 = fragment.f1234m && !fragment.U();
        if (!(z2 || oVar.n(this.f1412b))) {
            this.f1412b.f1223b = 0;
            return;
        }
        if (iVar instanceof androidx.lifecycle.s) {
            zIsChangingConfigurations = oVar.l();
        } else if (iVar.h() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) iVar.h()).isChangingConfigurations();
        }
        if (z2 || zIsChangingConfigurations) {
            oVar.f(this.f1412b);
        }
        this.f1412b.P0();
        this.f1411a.d(this.f1412b, false);
    }

    void g(o oVar) {
        if (l.p0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1412b);
        }
        this.f1412b.R0();
        boolean z2 = false;
        this.f1411a.e(this.f1412b, false);
        Fragment fragment = this.f1412b;
        fragment.f1223b = -1;
        fragment.f1241t = null;
        fragment.f1243v = null;
        fragment.f1240s = null;
        if (fragment.f1234m && !fragment.U()) {
            z2 = true;
        }
        if (z2 || oVar.n(this.f1412b)) {
            if (l.p0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f1412b);
            }
            this.f1412b.R();
        }
    }

    void h() {
        Fragment fragment = this.f1412b;
        if (fragment.f1235n && fragment.f1236o && !fragment.f1238q) {
            if (l.p0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1412b);
            }
            Fragment fragment2 = this.f1412b;
            fragment2.O0(fragment2.S0(fragment2.f1224c), null, this.f1412b.f1224c);
            View view = this.f1412b.H;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1412b;
                fragment3.H.setTag(k0.b.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f1412b;
                if (fragment4.f1247z) {
                    fragment4.H.setVisibility(8);
                }
                Fragment fragment5 = this.f1412b;
                fragment5.G0(fragment5.H, fragment5.f1224c);
                k kVar = this.f1411a;
                Fragment fragment6 = this.f1412b;
                kVar.m(fragment6, fragment6.H, fragment6.f1224c, false);
            }
        }
    }

    Fragment i() {
        return this.f1412b;
    }

    void j() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1412b);
        }
        this.f1412b.X0();
        this.f1411a.f(this.f1412b, false);
    }

    void k(ClassLoader classLoader) {
        Bundle bundle = this.f1412b.f1224c;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f1412b;
        fragment.f1225d = fragment.f1224c.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f1412b;
        fragment2.f1230i = fragment2.f1224c.getString("android:target_state");
        Fragment fragment3 = this.f1412b;
        if (fragment3.f1230i != null) {
            fragment3.f1231j = fragment3.f1224c.getInt("android:target_req_state", 0);
        }
        Fragment fragment4 = this.f1412b;
        Boolean bool = fragment4.f1226e;
        if (bool != null) {
            fragment4.J = bool.booleanValue();
            this.f1412b.f1226e = null;
        } else {
            fragment4.J = fragment4.f1224c.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment5 = this.f1412b;
        if (fragment5.J) {
            return;
        }
        fragment5.I = true;
    }

    void l() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.f1412b);
        }
        Fragment fragment = this.f1412b;
        if (fragment.H != null) {
            fragment.j1(fragment.f1224c);
        }
        this.f1412b.f1224c = null;
    }

    void m() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1412b);
        }
        this.f1412b.b1();
        this.f1411a.i(this.f1412b, false);
        Fragment fragment = this.f1412b;
        fragment.f1224c = null;
        fragment.f1225d = null;
    }

    p o() {
        p pVar = new p(this.f1412b);
        Fragment fragment = this.f1412b;
        if (fragment.f1223b <= -1 || pVar.f1410n != null) {
            pVar.f1410n = fragment.f1224c;
        } else {
            Bundle bundleN = n();
            pVar.f1410n = bundleN;
            if (this.f1412b.f1230i != null) {
                if (bundleN == null) {
                    pVar.f1410n = new Bundle();
                }
                pVar.f1410n.putString("android:target_state", this.f1412b.f1230i);
                int i3 = this.f1412b.f1231j;
                if (i3 != 0) {
                    pVar.f1410n.putInt("android:target_req_state", i3);
                }
            }
        }
        return pVar;
    }

    void p() {
        if (this.f1412b.H == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f1412b.H.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f1412b.f1225d = sparseArray;
        }
    }

    void q(int i3) {
        this.f1413c = i3;
    }

    void r() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1412b);
        }
        this.f1412b.d1();
        this.f1411a.k(this.f1412b, false);
    }

    void s() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1412b);
        }
        this.f1412b.e1();
        this.f1411a.l(this.f1412b, false);
    }

    q(k kVar, ClassLoader classLoader, h hVar, p pVar) {
        this.f1411a = kVar;
        Fragment fragmentA = hVar.a(classLoader, pVar.f1398b);
        this.f1412b = fragmentA;
        Bundle bundle = pVar.f1407k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.m1(pVar.f1407k);
        fragmentA.f1227f = pVar.f1399c;
        fragmentA.f1235n = pVar.f1400d;
        fragmentA.f1237p = true;
        fragmentA.f1244w = pVar.f1401e;
        fragmentA.f1245x = pVar.f1402f;
        fragmentA.f1246y = pVar.f1403g;
        fragmentA.B = pVar.f1404h;
        fragmentA.f1234m = pVar.f1405i;
        fragmentA.A = pVar.f1406j;
        fragmentA.f1247z = pVar.f1408l;
        fragmentA.R = androidx.lifecycle.d.b.values()[pVar.f1409m];
        Bundle bundle2 = pVar.f1410n;
        if (bundle2 != null) {
            fragmentA.f1224c = bundle2;
        } else {
            fragmentA.f1224c = new Bundle();
        }
        if (l.p0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    q(k kVar, Fragment fragment, p pVar) {
        this.f1411a = kVar;
        this.f1412b = fragment;
        fragment.f1225d = null;
        fragment.f1239r = 0;
        fragment.f1236o = false;
        fragment.f1233l = false;
        Fragment fragment2 = fragment.f1229h;
        fragment.f1230i = fragment2 != null ? fragment2.f1227f : null;
        fragment.f1229h = null;
        Bundle bundle = pVar.f1410n;
        if (bundle != null) {
            fragment.f1224c = bundle;
        } else {
            fragment.f1224c = new Bundle();
        }
    }
}
