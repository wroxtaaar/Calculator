package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackStackRecord.java */
/* JADX INFO: loaded from: classes.dex */
final class a extends s implements l.h {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final l f1273t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f1274u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f1275v;

    /* JADX WARN: Illegal instructions before constructor call */
    a(l lVar) {
        h hVarE0 = lVar.e0();
        i<?> iVar = lVar.f1359o;
        super(hVarE0, iVar != null ? iVar.h().getClassLoader() : null);
        this.f1275v = -1;
        this.f1273t = lVar;
    }

    private static boolean z(s.a aVar) {
        Fragment fragment = aVar.f1437b;
        return (fragment == null || !fragment.f1233l || fragment.H == null || fragment.A || fragment.f1247z || !fragment.W()) ? false : true;
    }

    boolean A() {
        for (int i3 = 0; i3 < this.f1419c.size(); i3++) {
            if (z(this.f1419c.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public void B() {
        if (this.f1435s != null) {
            for (int i3 = 0; i3 < this.f1435s.size(); i3++) {
                this.f1435s.get(i3).run();
            }
            this.f1435s = null;
        }
    }

    void C(Fragment.f fVar) {
        for (int i3 = 0; i3 < this.f1419c.size(); i3++) {
            s.a aVar = this.f1419c.get(i3);
            if (z(aVar)) {
                aVar.f1437b.q1(fVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    Fragment D(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1419c.size() - 1; size >= 0; size--) {
            s.a aVar = this.f1419c.get(size);
            int i3 = aVar.f1436a;
            if (i3 == 1) {
                arrayList.remove(aVar.f1437b);
            } else if (i3 != 3) {
                switch (i3) {
                    case 6:
                        arrayList.add(aVar.f1437b);
                        break;
                    case 7:
                        arrayList.remove(aVar.f1437b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.f1437b;
                        break;
                    case 10:
                        aVar.f1443h = aVar.f1442g;
                        break;
                }
            } else {
                arrayList.add(aVar.f1437b);
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.l.h
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (l.p0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1425i) {
            return true;
        }
        this.f1273t.b(this);
        return true;
    }

    @Override // androidx.fragment.app.s
    public int f() {
        return q(false);
    }

    @Override // androidx.fragment.app.s
    public int g() {
        return q(true);
    }

    @Override // androidx.fragment.app.s
    public void h() {
        j();
        this.f1273t.R(this, false);
    }

    @Override // androidx.fragment.app.s
    public void i() {
        j();
        this.f1273t.R(this, true);
    }

    @Override // androidx.fragment.app.s
    void k(int i3, Fragment fragment, String str, int i4) {
        super.k(i3, fragment, str, i4);
        fragment.f1240s = this.f1273t;
    }

    @Override // androidx.fragment.app.s
    public s l(Fragment fragment) {
        l lVar = fragment.f1240s;
        if (lVar == null || lVar == this.f1273t) {
            return super.l(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void p(int i3) {
        if (this.f1425i) {
            if (l.p0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i3);
            }
            int size = this.f1419c.size();
            for (int i4 = 0; i4 < size; i4++) {
                s.a aVar = this.f1419c.get(i4);
                Fragment fragment = aVar.f1437b;
                if (fragment != null) {
                    fragment.f1239r += i3;
                    if (l.p0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1437b + " to " + aVar.f1437b.f1239r);
                    }
                }
            }
        }
    }

    int q(boolean z2) {
        if (this.f1274u) {
            throw new IllegalStateException("commit already called");
        }
        if (l.p0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new d0.c("FragmentManager"));
            r("  ", printWriter);
            printWriter.close();
        }
        this.f1274u = true;
        if (this.f1425i) {
            this.f1275v = this.f1273t.f();
        } else {
            this.f1275v = -1;
        }
        this.f1273t.O(this, z2);
        return this.f1275v;
    }

    public void r(String str, PrintWriter printWriter) {
        s(str, printWriter, true);
    }

    public void s(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1427k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1275v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1274u);
            if (this.f1424h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1424h));
            }
            if (this.f1420d != 0 || this.f1421e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1420d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1421e));
            }
            if (this.f1422f != 0 || this.f1423g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1422f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1423g));
            }
            if (this.f1428l != 0 || this.f1429m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1428l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1429m);
            }
            if (this.f1430n != 0 || this.f1431o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1430n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1431o);
            }
        }
        if (this.f1419c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1419c.size();
        for (int i3 = 0; i3 < size; i3++) {
            s.a aVar = this.f1419c.get(i3);
            switch (aVar.f1436a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1436a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1437b);
            if (z2) {
                if (aVar.f1438c != 0 || aVar.f1439d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1438c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1439d));
                }
                if (aVar.f1440e != 0 || aVar.f1441f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1440e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1441f));
                }
            }
        }
    }

    void t() {
        int size = this.f1419c.size();
        for (int i3 = 0; i3 < size; i3++) {
            s.a aVar = this.f1419c.get(i3);
            Fragment fragment = aVar.f1437b;
            if (fragment != null) {
                fragment.p1(this.f1424h);
            }
            switch (aVar.f1436a) {
                case 1:
                    fragment.o1(aVar.f1438c);
                    this.f1273t.S0(fragment, false);
                    this.f1273t.d(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1436a);
                case 3:
                    fragment.o1(aVar.f1439d);
                    this.f1273t.K0(fragment);
                    break;
                case 4:
                    fragment.o1(aVar.f1439d);
                    this.f1273t.n0(fragment);
                    break;
                case 5:
                    fragment.o1(aVar.f1438c);
                    this.f1273t.S0(fragment, false);
                    this.f1273t.W0(fragment);
                    break;
                case 6:
                    fragment.o1(aVar.f1439d);
                    this.f1273t.q(fragment);
                    break;
                case 7:
                    fragment.o1(aVar.f1438c);
                    this.f1273t.S0(fragment, false);
                    this.f1273t.h(fragment);
                    break;
                case 8:
                    this.f1273t.U0(fragment);
                    break;
                case 9:
                    this.f1273t.U0(null);
                    break;
                case 10:
                    this.f1273t.T0(fragment, aVar.f1443h);
                    break;
            }
            if (!this.f1434r && aVar.f1436a != 1 && fragment != null) {
                this.f1273t.y0(fragment);
            }
        }
        if (this.f1434r) {
            return;
        }
        l lVar = this.f1273t;
        lVar.z0(lVar.f1358n, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1275v >= 0) {
            sb.append(" #");
            sb.append(this.f1275v);
        }
        if (this.f1427k != null) {
            sb.append(" ");
            sb.append(this.f1427k);
        }
        sb.append("}");
        return sb.toString();
    }

    void u(boolean z2) {
        for (int size = this.f1419c.size() - 1; size >= 0; size--) {
            s.a aVar = this.f1419c.get(size);
            Fragment fragment = aVar.f1437b;
            if (fragment != null) {
                fragment.p1(l.P0(this.f1424h));
            }
            switch (aVar.f1436a) {
                case 1:
                    fragment.o1(aVar.f1441f);
                    this.f1273t.S0(fragment, true);
                    this.f1273t.K0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1436a);
                case 3:
                    fragment.o1(aVar.f1440e);
                    this.f1273t.d(fragment);
                    break;
                case 4:
                    fragment.o1(aVar.f1440e);
                    this.f1273t.W0(fragment);
                    break;
                case 5:
                    fragment.o1(aVar.f1441f);
                    this.f1273t.S0(fragment, true);
                    this.f1273t.n0(fragment);
                    break;
                case 6:
                    fragment.o1(aVar.f1440e);
                    this.f1273t.h(fragment);
                    break;
                case 7:
                    fragment.o1(aVar.f1441f);
                    this.f1273t.S0(fragment, true);
                    this.f1273t.q(fragment);
                    break;
                case 8:
                    this.f1273t.U0(null);
                    break;
                case 9:
                    this.f1273t.U0(fragment);
                    break;
                case 10:
                    this.f1273t.T0(fragment, aVar.f1442g);
                    break;
            }
            if (!this.f1434r && aVar.f1436a != 3 && fragment != null) {
                this.f1273t.y0(fragment);
            }
        }
        if (this.f1434r || !z2) {
            return;
        }
        l lVar = this.f1273t;
        lVar.z0(lVar.f1358n, true);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    Fragment v(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i3 = 0;
        while (i3 < this.f1419c.size()) {
            s.a aVar = this.f1419c.get(i3);
            int i4 = aVar.f1436a;
            if (i4 == 1) {
                arrayList.add(aVar.f1437b);
            } else if (i4 == 2) {
                Fragment fragment3 = aVar.f1437b;
                int i5 = fragment3.f1245x;
                boolean z2 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.f1245x == i5) {
                        if (fragment4 == fragment3) {
                            z2 = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.f1419c.add(i3, new s.a(9, fragment4));
                                i3++;
                                fragment2 = null;
                            }
                            s.a aVar2 = new s.a(3, fragment4);
                            aVar2.f1438c = aVar.f1438c;
                            aVar2.f1440e = aVar.f1440e;
                            aVar2.f1439d = aVar.f1439d;
                            aVar2.f1441f = aVar.f1441f;
                            this.f1419c.add(i3, aVar2);
                            arrayList.remove(fragment4);
                            i3++;
                        }
                    }
                }
                if (z2) {
                    this.f1419c.remove(i3);
                    i3--;
                } else {
                    aVar.f1436a = 1;
                    arrayList.add(fragment3);
                }
            } else if (i4 == 3 || i4 == 6) {
                arrayList.remove(aVar.f1437b);
                Fragment fragment5 = aVar.f1437b;
                if (fragment5 == fragment2) {
                    this.f1419c.add(i3, new s.a(9, fragment5));
                    i3++;
                    fragment2 = null;
                }
            } else if (i4 == 7) {
                arrayList.add(aVar.f1437b);
            } else if (i4 == 8) {
                this.f1419c.add(i3, new s.a(9, fragment2));
                i3++;
                fragment2 = aVar.f1437b;
            }
            i3++;
        }
        return fragment2;
    }

    public String w() {
        return this.f1427k;
    }

    boolean x(int i3) {
        int size = this.f1419c.size();
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f1419c.get(i4).f1437b;
            int i5 = fragment != null ? fragment.f1245x : 0;
            if (i5 != 0 && i5 == i3) {
                return true;
            }
        }
        return false;
    }

    boolean y(ArrayList<a> arrayList, int i3, int i4) {
        if (i4 == i3) {
            return false;
        }
        int size = this.f1419c.size();
        int i5 = -1;
        for (int i6 = 0; i6 < size; i6++) {
            Fragment fragment = this.f1419c.get(i6).f1437b;
            int i7 = fragment != null ? fragment.f1245x : 0;
            if (i7 != 0 && i7 != i5) {
                for (int i8 = i3; i8 < i4; i8++) {
                    a aVar = arrayList.get(i8);
                    int size2 = aVar.f1419c.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        Fragment fragment2 = aVar.f1419c.get(i9).f1437b;
                        if ((fragment2 != null ? fragment2.f1245x : 0) == i7) {
                            return true;
                        }
                    }
                }
                i5 = i7;
            }
        }
        return false;
    }
}
