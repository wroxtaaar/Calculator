package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FragmentManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    private static boolean F = false;
    private ArrayList<Boolean> A;
    private ArrayList<Fragment> B;
    private ArrayList<j> C;
    private o D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1346b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f1348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f1349e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f1351g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<g> f1354j;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    androidx.fragment.app.i<?> f1359o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    androidx.fragment.app.f f1360p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Fragment f1361q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    Fragment f1362r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1365u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1366v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1367w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1368x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1369y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ArrayList<androidx.fragment.app.a> f1370z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<h> f1345a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r f1347c = new r();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.fragment.app.j f1350f = new androidx.fragment.app.j(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.activity.b f1352h = new a(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f1353i = new AtomicInteger();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ConcurrentHashMap<Fragment, HashSet<a0.b>> f1355k = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final t.g f1356l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final k f1357m = new k(this);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f1358n = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private androidx.fragment.app.h f1363s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private androidx.fragment.app.h f1364t = new c();
    private Runnable E = new d();

    /* JADX INFO: compiled from: FragmentManager.java */
    class a extends androidx.activity.b {
        a(boolean z2) {
            super(z2);
        }

        @Override // androidx.activity.b
        public void b() {
            l.this.m0();
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    class b implements t.g {
        b() {
        }

        @Override // androidx.fragment.app.t.g
        public void a(Fragment fragment, a0.b bVar) {
            if (bVar.b()) {
                return;
            }
            l.this.J0(fragment, bVar);
        }

        @Override // androidx.fragment.app.t.g
        public void b(Fragment fragment, a0.b bVar) {
            l.this.c(fragment, bVar);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    class c extends androidx.fragment.app.h {
        c() {
        }

        @Override // androidx.fragment.app.h
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.i<?> iVar = l.this.f1359o;
            return iVar.a(iVar.h(), str, null);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.Q(true);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Fragment f1377d;

        e(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1375b = viewGroup;
            this.f1376c = view;
            this.f1377d = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1375b.endViewTransition(this.f1376c);
            animator.removeListener(this);
            Fragment fragment = this.f1377d;
            View view = fragment.H;
            if (view == null || !fragment.f1247z) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    public static abstract class f {
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    public interface g {
        void a();
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    interface h {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private class i implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f1381c;

        i(String str, int i3, int i4) {
            this.f1379a = str;
            this.f1380b = i3;
            this.f1381c = i4;
        }

        @Override // androidx.fragment.app.l.h
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = l.this.f1362r;
            if (fragment == null || this.f1380b >= 0 || this.f1379a != null || !fragment.t().F0()) {
                return l.this.H0(arrayList, arrayList2, this.f1379a, this.f1380b, this.f1381c);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    static class j implements Fragment.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f1383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f1384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1385c;

        j(androidx.fragment.app.a aVar, boolean z2) {
            this.f1383a = z2;
            this.f1384b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.f
        public void a() {
            int i3 = this.f1385c - 1;
            this.f1385c = i3;
            if (i3 != 0) {
                return;
            }
            this.f1384b.f1273t.R0();
        }

        @Override // androidx.fragment.app.Fragment.f
        public void b() {
            this.f1385c++;
        }

        void c() {
            androidx.fragment.app.a aVar = this.f1384b;
            aVar.f1273t.n(aVar, this.f1383a, false, false);
        }

        void d() {
            boolean z2 = this.f1385c > 0;
            for (Fragment fragment : this.f1384b.f1273t.f0()) {
                fragment.q1(null);
                if (z2 && fragment.W()) {
                    fragment.t1();
                }
            }
            androidx.fragment.app.a aVar = this.f1384b;
            aVar.f1273t.n(aVar, this.f1383a, !z2, true);
        }

        public boolean e() {
            return this.f1385c == 0;
        }
    }

    private void C(Fragment fragment) {
        if (fragment == null || !fragment.equals(V(fragment.f1227f))) {
            return;
        }
        fragment.a1();
    }

    private boolean G0(String str, int i3, int i4) {
        Q(false);
        P(true);
        Fragment fragment = this.f1362r;
        if (fragment != null && i3 < 0 && str == null && fragment.t().F0()) {
            return true;
        }
        boolean zH0 = H0(this.f1370z, this.A, str, i3, i4);
        if (zH0) {
            this.f1346b = true;
            try {
                L0(this.f1370z, this.A);
                m();
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        Y0();
        L();
        this.f1347c.b();
        return zH0;
    }

    private int I0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4, l.b<Fragment> bVar) {
        int i5 = i4;
        for (int i6 = i4 - 1; i6 >= i3; i6--) {
            androidx.fragment.app.a aVar = arrayList.get(i6);
            boolean zBooleanValue = arrayList2.get(i6).booleanValue();
            if (aVar.A() && !aVar.y(arrayList, i6 + 1, i4)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                j jVar = new j(aVar, zBooleanValue);
                this.C.add(jVar);
                aVar.C(jVar);
                if (zBooleanValue) {
                    aVar.t();
                } else {
                    aVar.u(false);
                }
                i5--;
                if (i6 != i5) {
                    arrayList.remove(i6);
                    arrayList.add(i5, aVar);
                }
                a(bVar);
            }
        }
        return i5;
    }

    private void J(int i3) {
        try {
            this.f1346b = true;
            this.f1347c.d(i3);
            z0(i3, false);
            this.f1346b = false;
            Q(true);
        } catch (Throwable th) {
            this.f1346b = false;
            throw th;
        }
    }

    private void L() {
        if (this.f1369y) {
            this.f1369y = false;
            X0();
        }
    }

    private void L0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        U(arrayList, arrayList2);
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (!arrayList.get(i3).f1434r) {
                if (i4 != i3) {
                    T(arrayList, arrayList2, i4, i3);
                }
                i4 = i3 + 1;
                if (arrayList2.get(i3).booleanValue()) {
                    while (i4 < size && arrayList2.get(i4).booleanValue() && !arrayList.get(i4).f1434r) {
                        i4++;
                    }
                }
                T(arrayList, arrayList2, i3, i4);
                i3 = i4 - 1;
            }
            i3++;
        }
        if (i4 != size) {
            T(arrayList, arrayList2, i4, size);
        }
    }

    private void N() {
        if (this.f1355k.isEmpty()) {
            return;
        }
        for (Fragment fragment : this.f1355k.keySet()) {
            j(fragment);
            B0(fragment, fragment.M());
        }
    }

    private void N0() {
        if (this.f1354j != null) {
            for (int i3 = 0; i3 < this.f1354j.size(); i3++) {
                this.f1354j.get(i3).a();
            }
        }
    }

    private void P(boolean z2) {
        if (this.f1346b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1359o == null) {
            if (!this.f1368x) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f1359o.j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2) {
            l();
        }
        if (this.f1370z == null) {
            this.f1370z = new ArrayList<>();
            this.A = new ArrayList<>();
        }
        this.f1346b = true;
        try {
            U(null, null);
        } finally {
            this.f1346b = false;
        }
    }

    static int P0(int i3) {
        if (i3 == 4097) {
            return 8194;
        }
        if (i3 != 4099) {
            return i3 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private static void S(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        while (i3 < i4) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                aVar.p(-1);
                aVar.u(i3 == i4 + (-1));
            } else {
                aVar.p(1);
                aVar.t();
            }
            i3++;
        }
    }

    private void T(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        int i5;
        int i6 = i3;
        boolean z2 = arrayList.get(i6).f1434r;
        ArrayList<Fragment> arrayList3 = this.B;
        if (arrayList3 == null) {
            this.B = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.B.addAll(this.f1347c.m());
        Fragment fragmentJ0 = j0();
        boolean z3 = false;
        for (int i7 = i6; i7 < i4; i7++) {
            androidx.fragment.app.a aVar = arrayList.get(i7);
            fragmentJ0 = !arrayList2.get(i7).booleanValue() ? aVar.v(this.B, fragmentJ0) : aVar.D(this.B, fragmentJ0);
            z3 = z3 || aVar.f1425i;
        }
        this.B.clear();
        if (!z2) {
            t.B(this, arrayList, arrayList2, i3, i4, false, this.f1356l);
        }
        S(arrayList, arrayList2, i3, i4);
        if (z2) {
            l.b<Fragment> bVar = new l.b<>();
            a(bVar);
            int iI0 = I0(arrayList, arrayList2, i3, i4, bVar);
            x0(bVar);
            i5 = iI0;
        } else {
            i5 = i4;
        }
        if (i5 != i6 && z2) {
            t.B(this, arrayList, arrayList2, i3, i5, true, this.f1356l);
            z0(this.f1358n, true);
        }
        while (i6 < i4) {
            androidx.fragment.app.a aVar2 = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue() && aVar2.f1275v >= 0) {
                aVar2.f1275v = -1;
            }
            aVar2.B();
            i6++;
        }
        if (z3) {
            N0();
        }
    }

    private void U(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<j> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i3 = 0;
        while (i3 < size) {
            j jVar = this.C.get(i3);
            if (arrayList != null && !jVar.f1383a && (iIndexOf2 = arrayList.indexOf(jVar.f1384b)) != -1 && arrayList2 != null && arrayList2.get(iIndexOf2).booleanValue()) {
                this.C.remove(i3);
                i3--;
                size--;
                jVar.c();
            } else if (jVar.e() || (arrayList != null && jVar.f1384b.y(arrayList, 0, arrayList.size()))) {
                this.C.remove(i3);
                i3--;
                size--;
                if (arrayList == null || jVar.f1383a || (iIndexOf = arrayList.indexOf(jVar.f1384b)) == -1 || arrayList2 == null || !arrayList2.get(iIndexOf).booleanValue()) {
                    jVar.d();
                } else {
                    jVar.c();
                }
            }
            i3++;
        }
    }

    private void V0(Fragment fragment) {
        ViewGroup viewGroupD0 = d0(fragment);
        if (viewGroupD0 != null) {
            int i3 = k0.b.visible_removing_fragment_view_tag;
            if (viewGroupD0.getTag(i3) == null) {
                viewGroupD0.setTag(i3, fragment);
            }
            ((Fragment) viewGroupD0.getTag(i3)).o1(fragment.C());
        }
    }

    private void X0() {
        for (Fragment fragment : this.f1347c.k()) {
            if (fragment != null) {
                D0(fragment);
            }
        }
    }

    private void Y0() {
        synchronized (this.f1345a) {
            if (this.f1345a.isEmpty()) {
                this.f1352h.f(b0() > 0 && s0(this.f1361q));
            } else {
                this.f1352h.f(true);
            }
        }
    }

    private void Z() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void a(l.b<Fragment> bVar) {
        int i3 = this.f1358n;
        if (i3 < 1) {
            return;
        }
        int iMin = Math.min(i3, 3);
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment.f1223b < iMin) {
                B0(fragment, iMin);
                if (fragment.H != null && !fragment.f1247z && fragment.M) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private boolean a0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f1345a) {
            if (this.f1345a.isEmpty()) {
                return false;
            }
            int size = this.f1345a.size();
            boolean zA = false;
            for (int i3 = 0; i3 < size; i3++) {
                zA |= this.f1345a.get(i3).a(arrayList, arrayList2);
            }
            this.f1345a.clear();
            this.f1359o.j().removeCallbacks(this.E);
            return zA;
        }
    }

    private o c0(Fragment fragment) {
        return this.D.h(fragment);
    }

    private ViewGroup d0(Fragment fragment) {
        if (fragment.f1245x > 0 && this.f1360p.f()) {
            View viewE = this.f1360p.e(fragment.f1245x);
            if (viewE instanceof ViewGroup) {
                return (ViewGroup) viewE;
            }
        }
        return null;
    }

    private void j(Fragment fragment) {
        HashSet<a0.b> hashSet = this.f1355k.get(fragment);
        if (hashSet != null) {
            Iterator<a0.b> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            p(fragment);
            this.f1355k.remove(fragment);
        }
    }

    static Fragment k0(View view) {
        Object tag = view.getTag(k0.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void l() {
        if (u0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void m() {
        this.f1346b = false;
        this.A.clear();
        this.f1370z.clear();
    }

    private void o(Fragment fragment) {
        Animator animator;
        if (fragment.H != null) {
            androidx.fragment.app.e.d dVarB = androidx.fragment.app.e.b(this.f1359o.h(), this.f1360p, fragment, !fragment.f1247z);
            if (dVarB == null || (animator = dVarB.f1327b) == null) {
                if (dVarB != null) {
                    fragment.H.startAnimation(dVarB.f1326a);
                    dVarB.f1326a.start();
                }
                fragment.H.setVisibility((!fragment.f1247z || fragment.T()) ? 0 : 8);
                if (fragment.T()) {
                    fragment.n1(false);
                }
            } else {
                animator.setTarget(fragment.H);
                if (!fragment.f1247z) {
                    fragment.H.setVisibility(0);
                } else if (fragment.T()) {
                    fragment.n1(false);
                } else {
                    ViewGroup viewGroup = fragment.G;
                    View view = fragment.H;
                    viewGroup.startViewTransition(view);
                    dVarB.f1327b.addListener(new e(viewGroup, view, fragment));
                }
                dVarB.f1327b.start();
            }
        }
        if (fragment.f1233l && q0(fragment)) {
            this.f1365u = true;
        }
        fragment.N = false;
        fragment.r0(fragment.f1247z);
    }

    private void p(Fragment fragment) {
        fragment.Q0();
        this.f1357m.n(fragment, false);
        fragment.G = null;
        fragment.H = null;
        fragment.T = null;
        fragment.U.g(null);
        fragment.f1236o = false;
    }

    static boolean p0(int i3) {
        return F || Log.isLoggable("FragmentManager", i3);
    }

    private boolean q0(Fragment fragment) {
        return (fragment.D && fragment.E) || fragment.f1242u.k();
    }

    private void w0(q qVar) {
        Fragment fragmentI = qVar.i();
        if (this.f1347c.c(fragmentI.f1227f)) {
            if (p0(2)) {
                Log.v("FragmentManager", "Removed fragment from active set " + fragmentI);
            }
            this.f1347c.o(qVar);
            M0(fragmentI);
        }
    }

    private void x0(l.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragmentI = bVar.i(i3);
            if (!fragmentI.f1233l) {
                View viewH1 = fragmentI.h1();
                fragmentI.O = viewH1.getAlpha();
                viewH1.setAlpha(0.0f);
            }
        }
    }

    boolean A(MenuItem menuItem) {
        if (this.f1358n < 1) {
            return false;
        }
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null && fragment.V0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void A0(Fragment fragment) {
        B0(fragment, this.f1358n);
    }

    void B(Menu menu) {
        if (this.f1358n < 1) {
            return;
        }
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null) {
                fragment.W0(menu);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:123:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fd  */
    void B0(Fragment fragment, int i3) {
        Fragment fragmentV;
        ViewGroup viewGroup;
        q qVarL = this.f1347c.l(fragment.f1227f);
        int i4 = 1;
        if (qVarL == null) {
            qVarL = new q(this.f1357m, fragment);
            qVarL.q(1);
        }
        int iMin = Math.min(i3, qVarL.c());
        int i5 = fragment.f1223b;
        androidx.fragment.app.e.d dVarB = null;
        if (i5 <= iMin) {
            if (i5 < iMin && !this.f1355k.isEmpty()) {
                j(fragment);
            }
            int i6 = fragment.f1223b;
            if (i6 != -1) {
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 == 3) {
                            }
                        }
                        if (iMin > 3) {
                            qVarL.m();
                        }
                    }
                    if (iMin > 2) {
                        qVarL.r();
                    }
                    if (iMin > 3) {
                        qVarL.m();
                    }
                }
                if (iMin > -1) {
                    qVarL.h();
                }
                if (iMin > 1) {
                    qVarL.e(this.f1360p);
                    qVarL.a();
                    qVarL.l();
                }
                if (iMin > 2) {
                    qVarL.r();
                }
                if (iMin > 3) {
                    qVarL.m();
                }
            } else if (iMin > -1) {
                if (p0(3)) {
                    Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
                }
                Fragment fragment2 = fragment.f1229h;
                if (fragment2 != null) {
                    if (!fragment2.equals(V(fragment2.f1227f))) {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.f1229h + " that does not belong to this FragmentManager!");
                    }
                    Fragment fragment3 = fragment.f1229h;
                    if (fragment3.f1223b < 1) {
                        B0(fragment3, 1);
                    }
                    fragment.f1230i = fragment.f1229h.f1227f;
                    fragment.f1229h = null;
                }
                String str = fragment.f1230i;
                if (str != null) {
                    Fragment fragmentV2 = V(str);
                    if (fragmentV2 == null) {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.f1230i + " that does not belong to this FragmentManager!");
                    }
                    if (fragmentV2.f1223b < 1) {
                        B0(fragmentV2, 1);
                    }
                }
                qVarL.b(this.f1359o, this, this.f1361q);
            }
            if (iMin > 0) {
                qVarL.d();
            }
            if (iMin > -1) {
                qVarL.h();
            }
            if (iMin > 1) {
                qVarL.e(this.f1360p);
                qVarL.a();
                qVarL.l();
            }
            if (iMin > 2) {
                qVarL.r();
            }
            if (iMin > 3) {
                qVarL.m();
            }
        } else if (i5 > iMin) {
            if (i5 != 0) {
                boolean z2 = false;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                if (iMin < 4) {
                                    qVarL.j();
                                }
                            }
                        }
                        if (iMin < 3) {
                            qVarL.s();
                        }
                    }
                    if (iMin < 2) {
                        if (p0(3)) {
                            Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.H != null && this.f1359o.n(fragment) && fragment.f1225d == null) {
                            qVarL.p();
                        }
                        View view = fragment.H;
                        if (view != null && (viewGroup = fragment.G) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.H.clearAnimation();
                            if (!fragment.Y()) {
                                if (this.f1358n > -1 && !this.f1368x && fragment.H.getVisibility() == 0 && fragment.O >= 0.0f) {
                                    dVarB = androidx.fragment.app.e.b(this.f1359o.h(), this.f1360p, fragment, false);
                                }
                                fragment.O = 0.0f;
                                ViewGroup viewGroup2 = fragment.G;
                                View view2 = fragment.H;
                                if (dVarB != null) {
                                    fragment.r1(iMin);
                                    androidx.fragment.app.e.a(fragment, dVarB, this.f1356l);
                                }
                                viewGroup2.removeView(view2);
                                if (viewGroup2 != fragment.G) {
                                    return;
                                }
                            }
                        }
                        if (this.f1355k.get(fragment) == null) {
                            p(fragment);
                        } else {
                            fragment.r1(iMin);
                        }
                    }
                }
                if (iMin >= 1) {
                    i4 = iMin;
                } else {
                    if (fragment.f1234m && !fragment.U()) {
                        z2 = true;
                    }
                    if (z2 || this.D.n(fragment)) {
                        w0(qVarL);
                    } else {
                        String str2 = fragment.f1230i;
                        if (str2 != null && (fragmentV = V(str2)) != null && fragmentV.I()) {
                            fragment.f1229h = fragmentV;
                        }
                    }
                    if (this.f1355k.get(fragment) != null) {
                        fragment.r1(iMin);
                    } else {
                        qVarL.f(this.f1359o, this.D);
                        i4 = iMin;
                    }
                }
                if (i4 < 0) {
                    qVarL.g(this.D);
                }
                iMin = i4;
            } else {
                i4 = iMin;
                if (i4 < 0) {
                    qVarL.g(this.D);
                }
                iMin = i4;
            }
        }
        if (fragment.f1223b != iMin) {
            if (p0(3)) {
                Log.d("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + iMin + " found " + fragment.f1223b);
            }
            fragment.f1223b = iMin;
        }
    }

    void C0() {
        if (this.f1359o == null) {
            return;
        }
        this.f1366v = false;
        this.f1367w = false;
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null) {
                fragment.a0();
            }
        }
    }

    void D() {
        J(3);
    }

    void D0(Fragment fragment) {
        if (fragment.I) {
            if (this.f1346b) {
                this.f1369y = true;
            } else {
                fragment.I = false;
                B0(fragment, this.f1358n);
            }
        }
    }

    void E(boolean z2) {
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null) {
                fragment.Y0(z2);
            }
        }
    }

    public void E0(int i3, int i4) {
        if (i3 >= 0) {
            O(new i(null, i3, i4), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i3);
    }

    boolean F(Menu menu) {
        boolean z2 = false;
        if (this.f1358n < 1) {
            return false;
        }
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null && fragment.Z0(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean F0() {
        return G0(null, -1, 0);
    }

    void G() {
        Y0();
        C(this.f1362r);
    }

    void H() {
        this.f1366v = false;
        this.f1367w = false;
        J(4);
    }

    boolean H0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i3, int i4) {
        int i5;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f1348d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i3 < 0 && (i4 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1348d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i3 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f1348d.get(size2);
                    if ((str != null && str.equals(aVar.w())) || (i3 >= 0 && i3 == aVar.f1275v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i4 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f1348d.get(size2);
                        if (str == null || !str.equals(aVar2.w())) {
                            if (i3 < 0 || i3 != aVar2.f1275v) {
                                break;
                            }
                        }
                    }
                }
                i5 = size2;
            } else {
                i5 = -1;
            }
            if (i5 == this.f1348d.size() - 1) {
                return false;
            }
            for (int size3 = this.f1348d.size() - 1; size3 > i5; size3--) {
                arrayList.add(this.f1348d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    void I() {
        this.f1366v = false;
        this.f1367w = false;
        J(3);
    }

    void J0(Fragment fragment, a0.b bVar) {
        HashSet<a0.b> hashSet = this.f1355k.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.f1355k.remove(fragment);
            if (fragment.f1223b < 3) {
                p(fragment);
                B0(fragment, fragment.M());
            }
        }
    }

    void K() {
        this.f1367w = true;
        J(2);
    }

    void K0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f1239r);
        }
        boolean z2 = !fragment.U();
        if (!fragment.A || z2) {
            this.f1347c.p(fragment);
            if (q0(fragment)) {
                this.f1365u = true;
            }
            fragment.f1234m = true;
            V0(fragment);
        }
    }

    public void M(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f1347c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f1349e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                Fragment fragment = this.f1349e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f1348d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                androidx.fragment.app.a aVar = this.f1348d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.r(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1353i.get());
        synchronized (this.f1345a) {
            int size3 = this.f1345a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size3; i5++) {
                    h hVar = this.f1345a.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(hVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1359o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1360p);
        if (this.f1361q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1361q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1358n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1366v);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1367w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1368x);
        if (this.f1365u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1365u);
        }
    }

    void M0(Fragment fragment) {
        if (u0()) {
            if (p0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.D.m(fragment) && p0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void O(h hVar, boolean z2) {
        if (!z2) {
            if (this.f1359o == null) {
                if (!this.f1368x) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            l();
        }
        synchronized (this.f1345a) {
            if (this.f1359o == null) {
                if (!z2) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f1345a.add(hVar);
                R0();
            }
        }
    }

    void O0(Parcelable parcelable) {
        q qVar;
        if (parcelable == null) {
            return;
        }
        n nVar = (n) parcelable;
        if (nVar.f1386b == null) {
            return;
        }
        this.f1347c.q();
        for (p pVar : nVar.f1386b) {
            if (pVar != null) {
                Fragment fragmentG = this.D.g(pVar.f1399c);
                if (fragmentG != null) {
                    if (p0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentG);
                    }
                    qVar = new q(this.f1357m, fragmentG, pVar);
                } else {
                    qVar = new q(this.f1357m, this.f1359o.h().getClassLoader(), e0(), pVar);
                }
                Fragment fragmentI = qVar.i();
                fragmentI.f1240s = this;
                if (p0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentI.f1227f + "): " + fragmentI);
                }
                qVar.k(this.f1359o.h().getClassLoader());
                this.f1347c.n(qVar);
                qVar.q(this.f1358n);
            }
        }
        for (Fragment fragment : this.D.j()) {
            if (!this.f1347c.c(fragment.f1227f)) {
                if (p0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + nVar.f1386b);
                }
                B0(fragment, 1);
                fragment.f1234m = true;
                B0(fragment, -1);
            }
        }
        this.f1347c.r(nVar.f1387c);
        if (nVar.f1388d != null) {
            this.f1348d = new ArrayList<>(nVar.f1388d.length);
            int i3 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = nVar.f1388d;
                if (i3 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarJ = bVarArr[i3].j(this);
                if (p0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + aVarJ.f1275v + "): " + aVarJ);
                    PrintWriter printWriter = new PrintWriter(new d0.c("FragmentManager"));
                    aVarJ.s("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1348d.add(aVarJ);
                i3++;
            }
        } else {
            this.f1348d = null;
        }
        this.f1353i.set(nVar.f1389e);
        String str = nVar.f1390f;
        if (str != null) {
            Fragment fragmentV = V(str);
            this.f1362r = fragmentV;
            C(fragmentV);
        }
    }

    boolean Q(boolean z2) {
        P(z2);
        boolean z3 = false;
        while (a0(this.f1370z, this.A)) {
            this.f1346b = true;
            try {
                L0(this.f1370z, this.A);
                m();
                z3 = true;
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        Y0();
        L();
        this.f1347c.b();
        return z3;
    }

    Parcelable Q0() {
        int size;
        Z();
        N();
        Q(true);
        this.f1366v = true;
        ArrayList<p> arrayListS = this.f1347c.s();
        androidx.fragment.app.b[] bVarArr = null;
        if (arrayListS.isEmpty()) {
            if (p0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> arrayListT = this.f1347c.t();
        ArrayList<androidx.fragment.app.a> arrayList = this.f1348d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i3 = 0; i3 < size; i3++) {
                bVarArr[i3] = new androidx.fragment.app.b(this.f1348d.get(i3));
                if (p0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f1348d.get(i3));
                }
            }
        }
        n nVar = new n();
        nVar.f1386b = arrayListS;
        nVar.f1387c = arrayListT;
        nVar.f1388d = bVarArr;
        nVar.f1389e = this.f1353i.get();
        Fragment fragment = this.f1362r;
        if (fragment != null) {
            nVar.f1390f = fragment.f1227f;
        }
        return nVar;
    }

    void R(h hVar, boolean z2) {
        if (z2 && (this.f1359o == null || this.f1368x)) {
            return;
        }
        P(z2);
        if (hVar.a(this.f1370z, this.A)) {
            this.f1346b = true;
            try {
                L0(this.f1370z, this.A);
                m();
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        Y0();
        L();
        this.f1347c.b();
    }

    void R0() {
        synchronized (this.f1345a) {
            ArrayList<j> arrayList = this.C;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z3 = this.f1345a.size() == 1;
            if (z2 || z3) {
                this.f1359o.j().removeCallbacks(this.E);
                this.f1359o.j().post(this.E);
                Y0();
            }
        }
    }

    void S0(Fragment fragment, boolean z2) {
        ViewGroup viewGroupD0 = d0(fragment);
        if (viewGroupD0 == null || !(viewGroupD0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupD0).setDrawDisappearingViewsLast(!z2);
    }

    void T0(Fragment fragment, androidx.lifecycle.d.b bVar) {
        if (fragment.equals(V(fragment.f1227f)) && (fragment.f1241t == null || fragment.f1240s == this)) {
            fragment.R = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void U0(Fragment fragment) {
        if (fragment == null || (fragment.equals(V(fragment.f1227f)) && (fragment.f1241t == null || fragment.f1240s == this))) {
            Fragment fragment2 = this.f1362r;
            this.f1362r = fragment;
            C(fragment2);
            C(this.f1362r);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    Fragment V(String str) {
        return this.f1347c.f(str);
    }

    public Fragment W(int i3) {
        return this.f1347c.g(i3);
    }

    void W0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f1247z) {
            fragment.f1247z = false;
            fragment.N = !fragment.N;
        }
    }

    public Fragment X(String str) {
        return this.f1347c.h(str);
    }

    Fragment Y(String str) {
        return this.f1347c.i(str);
    }

    void b(androidx.fragment.app.a aVar) {
        if (this.f1348d == null) {
            this.f1348d = new ArrayList<>();
        }
        this.f1348d.add(aVar);
    }

    public int b0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f1348d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void c(Fragment fragment, a0.b bVar) {
        if (this.f1355k.get(fragment) == null) {
            this.f1355k.put(fragment, new HashSet<>());
        }
        this.f1355k.get(fragment).add(bVar);
    }

    void d(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        v0(fragment);
        if (fragment.A) {
            return;
        }
        this.f1347c.a(fragment);
        fragment.f1234m = false;
        if (fragment.H == null) {
            fragment.N = false;
        }
        if (q0(fragment)) {
            this.f1365u = true;
        }
    }

    void e(Fragment fragment) {
        if (u0()) {
            if (p0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.D.e(fragment) && p0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public androidx.fragment.app.h e0() {
        androidx.fragment.app.h hVar = this.f1363s;
        if (hVar != null) {
            return hVar;
        }
        Fragment fragment = this.f1361q;
        return fragment != null ? fragment.f1240s.e0() : this.f1364t;
    }

    int f() {
        return this.f1353i.getAndIncrement();
    }

    public List<Fragment> f0() {
        return this.f1347c.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void g(androidx.fragment.app.i<?> iVar, androidx.fragment.app.f fVar, Fragment fragment) {
        androidx.lifecycle.g gVar;
        if (this.f1359o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1359o = iVar;
        this.f1360p = fVar;
        this.f1361q = fragment;
        if (fragment != null) {
            Y0();
        }
        if (iVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) iVar;
            OnBackPressedDispatcher onBackPressedDispatcherC = cVar.c();
            this.f1351g = onBackPressedDispatcherC;
            if (fragment != null) {
                gVar = cVar;
                gVar = fragment;
            }
            gVar = cVar;
            onBackPressedDispatcherC.a(gVar, this.f1352h);
        }
        if (fragment != null) {
            this.D = fragment.f1240s.c0(fragment);
        } else if (iVar instanceof androidx.lifecycle.s) {
            this.D = o.i(((androidx.lifecycle.s) iVar).i());
        } else {
            this.D = new o(false);
        }
    }

    LayoutInflater.Factory2 g0() {
        return this.f1350f;
    }

    void h(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.A) {
            fragment.A = false;
            if (fragment.f1233l) {
                return;
            }
            this.f1347c.a(fragment);
            if (p0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (q0(fragment)) {
                this.f1365u = true;
            }
        }
    }

    k h0() {
        return this.f1357m;
    }

    public s i() {
        return new androidx.fragment.app.a(this);
    }

    Fragment i0() {
        return this.f1361q;
    }

    public Fragment j0() {
        return this.f1362r;
    }

    boolean k() {
        boolean zQ0 = false;
        for (Fragment fragment : this.f1347c.k()) {
            if (fragment != null) {
                zQ0 = q0(fragment);
            }
            if (zQ0) {
                return true;
            }
        }
        return false;
    }

    androidx.lifecycle.r l0(Fragment fragment) {
        return this.D.k(fragment);
    }

    void m0() {
        Q(true);
        if (this.f1352h.c()) {
            F0();
        } else {
            this.f1351g.c();
        }
    }

    void n(androidx.fragment.app.a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.u(z4);
        } else {
            aVar.t();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            t.B(this, arrayList, arrayList2, 0, 1, true, this.f1356l);
        }
        if (z4) {
            z0(this.f1358n, true);
        }
        for (Fragment fragment : this.f1347c.k()) {
            if (fragment != null && fragment.H != null && fragment.M && aVar.x(fragment.f1245x)) {
                float f3 = fragment.O;
                if (f3 > 0.0f) {
                    fragment.H.setAlpha(f3);
                }
                if (z4) {
                    fragment.O = 0.0f;
                } else {
                    fragment.O = -1.0f;
                    fragment.M = false;
                }
            }
        }
    }

    void n0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f1247z) {
            return;
        }
        fragment.f1247z = true;
        fragment.N = true ^ fragment.N;
        V0(fragment);
    }

    public boolean o0() {
        return this.f1368x;
    }

    void q(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.A) {
            return;
        }
        fragment.A = true;
        if (fragment.f1233l) {
            if (p0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f1347c.p(fragment);
            if (q0(fragment)) {
                this.f1365u = true;
            }
            V0(fragment);
        }
    }

    void r() {
        this.f1366v = false;
        this.f1367w = false;
        J(2);
    }

    boolean r0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.V();
    }

    void s(Configuration configuration) {
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null) {
                fragment.K0(configuration);
            }
        }
    }

    boolean s0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        l lVar = fragment.f1240s;
        return fragment.equals(lVar.j0()) && s0(lVar.f1361q);
    }

    boolean t(MenuItem menuItem) {
        if (this.f1358n < 1) {
            return false;
        }
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null && fragment.L0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean t0(int i3) {
        return this.f1358n >= i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f1361q;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f1361q)));
            sb.append("}");
        } else {
            androidx.fragment.app.i<?> iVar = this.f1359o;
            if (iVar != null) {
                sb.append(iVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f1359o)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    void u() {
        this.f1366v = false;
        this.f1367w = false;
        J(1);
    }

    public boolean u0() {
        return this.f1366v || this.f1367w;
    }

    boolean v(Menu menu, MenuInflater menuInflater) {
        if (this.f1358n < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null && r0(fragment) && fragment.N0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f1349e != null) {
            for (int i3 = 0; i3 < this.f1349e.size(); i3++) {
                Fragment fragment2 = this.f1349e.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.n0();
                }
            }
        }
        this.f1349e = arrayList;
        return z2;
    }

    void v0(Fragment fragment) {
        if (this.f1347c.c(fragment.f1227f)) {
            return;
        }
        q qVar = new q(this.f1357m, fragment);
        qVar.k(this.f1359o.h().getClassLoader());
        this.f1347c.n(qVar);
        if (fragment.C) {
            if (fragment.B) {
                e(fragment);
            } else {
                M0(fragment);
            }
            fragment.C = false;
        }
        qVar.q(this.f1358n);
        if (p0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void w() {
        this.f1368x = true;
        Q(true);
        N();
        J(-1);
        this.f1359o = null;
        this.f1360p = null;
        this.f1361q = null;
        if (this.f1351g != null) {
            this.f1352h.d();
            this.f1351g = null;
        }
    }

    void x() {
        J(1);
    }

    void y() {
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null) {
                fragment.T0();
            }
        }
    }

    void y0(Fragment fragment) {
        if (!this.f1347c.c(fragment.f1227f)) {
            if (p0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f1358n + "since it is not added to " + this);
                return;
            }
            return;
        }
        A0(fragment);
        if (fragment.H != null) {
            Fragment fragmentJ = this.f1347c.j(fragment);
            if (fragmentJ != null) {
                View view = fragmentJ.H;
                ViewGroup viewGroup = fragment.G;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.H);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.H, iIndexOfChild);
                }
            }
            if (fragment.M && fragment.G != null) {
                float f3 = fragment.O;
                if (f3 > 0.0f) {
                    fragment.H.setAlpha(f3);
                }
                fragment.O = 0.0f;
                fragment.M = false;
                androidx.fragment.app.e.d dVarB = androidx.fragment.app.e.b(this.f1359o.h(), this.f1360p, fragment, true);
                if (dVarB != null) {
                    Animation animation = dVarB.f1326a;
                    if (animation != null) {
                        fragment.H.startAnimation(animation);
                    } else {
                        dVarB.f1327b.setTarget(fragment.H);
                        dVarB.f1327b.start();
                    }
                }
            }
        }
        if (fragment.N) {
            o(fragment);
        }
    }

    void z(boolean z2) {
        for (Fragment fragment : this.f1347c.m()) {
            if (fragment != null) {
                fragment.U0(z2);
            }
        }
    }

    void z0(int i3, boolean z2) {
        androidx.fragment.app.i<?> iVar;
        if (this.f1359o == null && i3 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i3 != this.f1358n) {
            this.f1358n = i3;
            Iterator<Fragment> it = this.f1347c.m().iterator();
            while (it.hasNext()) {
                y0(it.next());
            }
            for (Fragment fragment : this.f1347c.k()) {
                if (fragment != null && !fragment.M) {
                    y0(fragment);
                }
            }
            X0();
            if (this.f1365u && (iVar = this.f1359o) != null && this.f1358n == 4) {
                iVar.o();
                this.f1365u = false;
            }
        }
    }
}
