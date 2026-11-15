package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1444a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final v f1445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final v f1446c;

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f1447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a0.b f1449d;

        a(g gVar, Fragment fragment, a0.b bVar) {
            this.f1447b = gVar;
            this.f1448c = fragment;
            this.f1449d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1447b.a(this.f1448c, this.f1449d);
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1450b;

        b(ArrayList arrayList) {
            this.f1450b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.A(this.f1450b, 4);
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f1451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a0.b f1453d;

        c(g gVar, Fragment fragment, a0.b bVar) {
            this.f1451b = gVar;
            this.f1452c = fragment;
            this.f1453d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1451b.a(this.f1452c, this.f1453d);
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class d implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f1454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ v f1455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f1456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f1457e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f1459g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f1460h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Object f1461i;

        d(Object obj, v vVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1454b = obj;
            this.f1455c = vVar;
            this.f1456d = view;
            this.f1457e = fragment;
            this.f1458f = arrayList;
            this.f1459g = arrayList2;
            this.f1460h = arrayList3;
            this.f1461i = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f1454b;
            if (obj != null) {
                this.f1455c.p(obj, this.f1456d);
                this.f1459g.addAll(t.k(this.f1455c, this.f1454b, this.f1457e, this.f1458f, this.f1456d));
            }
            if (this.f1460h != null) {
                if (this.f1461i != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1456d);
                    this.f1455c.q(this.f1461i, this.f1460h, arrayList);
                }
                this.f1460h.clear();
                this.f1460h.add(this.f1456d);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f1462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f1464d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l.a f1465e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f1466f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ v f1467g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Rect f1468h;

        e(Fragment fragment, Fragment fragment2, boolean z2, l.a aVar, View view, v vVar, Rect rect) {
            this.f1462b = fragment;
            this.f1463c = fragment2;
            this.f1464d = z2;
            this.f1465e = aVar;
            this.f1466f = view;
            this.f1467g = vVar;
            this.f1468h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.f(this.f1462b, this.f1463c, this.f1464d, this.f1465e, false);
            View view = this.f1466f;
            if (view != null) {
                this.f1467g.k(view, this.f1468h);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class f implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v f1469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l.a f1470c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f1471d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f1472e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1473f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f1474g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Fragment f1475h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Fragment f1476i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f1477j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f1478k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Object f1479l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ Rect f1480m;

        f(v vVar, l.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z2, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1469b = vVar;
            this.f1470c = aVar;
            this.f1471d = obj;
            this.f1472e = hVar;
            this.f1473f = arrayList;
            this.f1474g = view;
            this.f1475h = fragment;
            this.f1476i = fragment2;
            this.f1477j = z2;
            this.f1478k = arrayList2;
            this.f1479l = obj2;
            this.f1480m = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a<String, View> aVarH = t.h(this.f1469b, this.f1470c, this.f1471d, this.f1472e);
            if (aVarH != null) {
                this.f1473f.addAll(aVarH.values());
                this.f1473f.add(this.f1474g);
            }
            t.f(this.f1475h, this.f1476i, this.f1477j, aVarH, false);
            Object obj = this.f1471d;
            if (obj != null) {
                this.f1469b.A(obj, this.f1478k, this.f1473f);
                View viewS = t.s(aVarH, this.f1472e, this.f1479l, this.f1477j);
                if (viewS != null) {
                    this.f1469b.k(viewS, this.f1480m);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    interface g {
        void a(Fragment fragment, a0.b bVar);

        void b(Fragment fragment, a0.b bVar);
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Fragment f1481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f1483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f1484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1485e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f1486f;

        h() {
        }
    }

    static {
        f1445b = Build.VERSION.SDK_INT >= 21 ? new u() : null;
        f1446c = w();
    }

    static void A(ArrayList<View> arrayList, int i3) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i3);
        }
    }

    static void B(l lVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4, boolean z2, g gVar) {
        if (lVar.f1358n < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i5 = i3; i5 < i4; i5++) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue()) {
                e(aVar, sparseArray, z2);
            } else {
                c(aVar, sparseArray, z2);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(lVar.f1359o.h());
            int size = sparseArray.size();
            for (int i6 = 0; i6 < size; i6++) {
                int iKeyAt = sparseArray.keyAt(i6);
                l.a<String, String> aVarD = d(iKeyAt, arrayList, arrayList2, i3, i4);
                h hVar = (h) sparseArray.valueAt(i6);
                if (z2) {
                    o(lVar, iKeyAt, hVar, view, aVarD, gVar);
                } else {
                    n(lVar, iKeyAt, hVar, view, aVarD, gVar);
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, l.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewM = aVar.m(size);
            if (collection.contains(e0.t.J(viewM))) {
                arrayList.add(viewM);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0058  */
    /* JADX WARN: Code duplicated, block: B:55:0x006f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0071  */
    /* JADX WARN: Code duplicated, block: B:63:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0082  */
    /* JADX WARN: Code duplicated, block: B:65:0x0085  */
    /* JADX WARN: Code duplicated, block: B:69:0x008d  */
    /* JADX WARN: Code duplicated, block: B:70:0x008f  */
    private static void b(androidx.fragment.app.a aVar, s.a aVar2, SparseArray<h> sparseArray, boolean z2, boolean z3) {
        int i3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        View view;
        boolean z8;
        Fragment fragment = aVar2.f1437b;
        if (fragment == null || (i3 = fragment.f1245x) == 0) {
            return;
        }
        int i4 = z2 ? f1444a[aVar2.f1436a] : aVar2.f1436a;
        boolean z9 = false;
        if (i4 == 1) {
            if (z3) {
                z4 = fragment.M;
            } else if (!fragment.f1233l || fragment.f1247z) {
                z4 = false;
            } else {
                z4 = true;
            }
            z5 = false;
            z6 = false;
            z9 = z4;
            z7 = true;
        } else if (i4 == 3) {
            if (z3 ? !fragment.f1233l || fragment.f1247z : fragment.f1233l || (view = fragment.H) == null || view.getVisibility() != 0 || fragment.O < 0.0f) {
                z8 = false;
            } else {
                z8 = true;
            }
            z6 = z8;
            z7 = false;
            z5 = true;
        } else if (i4 == 4) {
            if (!z3 ? !(!fragment.f1233l || fragment.f1247z) : fragment.N && fragment.f1233l && fragment.f1247z) {
                z8 = false;
            } else {
                z8 = true;
            }
            z6 = z8;
            z7 = false;
            z5 = true;
        } else if (i4 == 5) {
            if (!z3) {
                z4 = fragment.f1247z;
            } else if (fragment.N && !fragment.f1247z && fragment.f1233l) {
                z4 = true;
            } else {
                z4 = false;
            }
            z5 = false;
            z6 = false;
            z9 = z4;
            z7 = true;
        } else if (i4 == 6) {
            if (z3) {
                z8 = false;
            } else {
                z8 = false;
            }
            z6 = z8;
            z7 = false;
            z5 = true;
        } else if (i4 != 7) {
            z7 = false;
            z5 = false;
            z6 = false;
        } else {
            if (z3) {
                z4 = fragment.M;
            } else {
                if (fragment.f1233l) {
                }
                z4 = false;
            }
            z5 = false;
            z6 = false;
            z9 = z4;
            z7 = true;
        }
        h hVarP = sparseArray.get(i3);
        if (z9) {
            hVarP = p(hVarP, sparseArray, i3);
            hVarP.f1481a = fragment;
            hVarP.f1482b = z2;
            hVarP.f1483c = aVar;
        }
        if (!z3 && z7) {
            if (hVarP != null && hVarP.f1484d == fragment) {
                hVarP.f1484d = null;
            }
            l lVar = aVar.f1273t;
            if (fragment.f1223b < 1 && lVar.f1358n >= 1 && !aVar.f1434r) {
                lVar.v0(fragment);
                lVar.B0(fragment, 1);
            }
        }
        if (z6 && (hVarP == null || hVarP.f1484d == null)) {
            hVarP = p(hVarP, sparseArray, i3);
            hVarP.f1484d = fragment;
            hVarP.f1485e = z2;
            hVarP.f1486f = aVar;
        }
        if (z3 || !z5 || hVarP == null || hVarP.f1481a != fragment) {
            return;
        }
        hVarP.f1481a = null;
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z2) {
        int size = aVar.f1419c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b(aVar, aVar.f1419c.get(i3), sparseArray, false, z2);
        }
    }

    private static l.a<String, String> d(int i3, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i4, int i5) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        l.a<String, String> aVar = new l.a<>();
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i6);
            if (aVar2.x(i3)) {
                boolean zBooleanValue = arrayList2.get(i6).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f1432p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar2.f1432p;
                        arrayList4 = aVar2.f1433q;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f1432p;
                        arrayList3 = aVar2.f1433q;
                        arrayList4 = arrayList6;
                    }
                    for (int i7 = 0; i7 < size; i7++) {
                        String str = arrayList4.get(i7);
                        String str2 = arrayList3.get(i7);
                        String strRemove = aVar.remove(str2);
                        if (strRemove != null) {
                            aVar.put(str, strRemove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z2) {
        if (aVar.f1273t.f1360p.f()) {
            for (int size = aVar.f1419c.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f1419c.get(size), sparseArray, true, z2);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z2, l.a<String, View> aVar, boolean z3) {
        if (z2) {
            fragment2.w();
        } else {
            fragment.w();
        }
    }

    private static boolean g(v vVar, List<Object> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!vVar.e(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    static l.a<String, View> h(v vVar, l.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        Fragment fragment = hVar.f1481a;
        View viewP = fragment.P();
        if (aVar.isEmpty() || obj == null || viewP == null) {
            aVar.clear();
            return null;
        }
        l.a<String, View> aVar2 = new l.a<>();
        vVar.j(aVar2, viewP);
        androidx.fragment.app.a aVar3 = hVar.f1483c;
        if (hVar.f1482b) {
            fragment.y();
            arrayList = aVar3.f1432p;
        } else {
            fragment.w();
            arrayList = aVar3.f1433q;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static l.a<String, View> i(v vVar, l.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f1484d;
        l.a<String, View> aVar2 = new l.a<>();
        vVar.j(aVar2, fragment.h1());
        androidx.fragment.app.a aVar3 = hVar.f1486f;
        if (hVar.f1485e) {
            fragment.w();
            arrayList = aVar3.f1433q;
        } else {
            fragment.y();
            arrayList = aVar3.f1432p;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
        }
        aVar.o(aVar2.keySet());
        return aVar2;
    }

    private static v j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object objX = fragment.x();
            if (objX != null) {
                arrayList.add(objX);
            }
            Object objJ = fragment.J();
            if (objJ != null) {
                arrayList.add(objJ);
            }
            Object objL = fragment.L();
            if (objL != null) {
                arrayList.add(objL);
            }
        }
        if (fragment2 != null) {
            Object objV = fragment2.v();
            if (objV != null) {
                arrayList.add(objV);
            }
            Object objG = fragment2.G();
            if (objG != null) {
                arrayList.add(objG);
            }
            Object objK = fragment2.K();
            if (objK != null) {
                arrayList.add(objK);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        v vVar = f1445b;
        if (vVar != null && g(vVar, arrayList)) {
            return vVar;
        }
        v vVar2 = f1446c;
        if (vVar2 != null && g(vVar2, arrayList)) {
            return vVar2;
        }
        if (vVar == null && vVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(v vVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View viewP = fragment.P();
        if (viewP != null) {
            vVar.f(arrayList2, viewP);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        vVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(v vVar, ViewGroup viewGroup, View view, l.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.f1481a;
        Fragment fragment2 = hVar.f1484d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = hVar.f1482b;
        Object objT = aVar.isEmpty() ? null : t(vVar, fragment, fragment2, z2);
        l.a<String, View> aVarI = i(vVar, aVar, objT, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarI.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z2, aVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            vVar.z(obj3, view, arrayList);
            z(vVar, obj3, obj2, aVarI, hVar.f1485e, hVar.f1486f);
            if (obj != null) {
                vVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        e0.r.a(viewGroup, new f(vVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z2, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(v vVar, ViewGroup viewGroup, View view, l.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.f1481a;
        Fragment fragment2 = hVar.f1484d;
        if (fragment != null) {
            fragment.h1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = hVar.f1482b;
        Object objT = aVar.isEmpty() ? null : t(vVar, fragment, fragment2, z2);
        l.a<String, View> aVarI = i(vVar, aVar, objT, hVar);
        l.a<String, View> aVarH = h(vVar, aVar, objT, hVar);
        if (aVar.isEmpty()) {
            if (aVarI != null) {
                aVarI.clear();
            }
            if (aVarH != null) {
                aVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarI, aVar.keySet());
            a(arrayList2, aVarH, aVar.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z2, aVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            vVar.z(obj3, view, arrayList);
            z(vVar, obj3, obj2, aVarI, hVar.f1485e, hVar.f1486f);
            Rect rect2 = new Rect();
            View viewS = s(aVarH, hVar, obj, z2);
            if (viewS != null) {
                vVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewS;
        } else {
            view2 = null;
            rect = null;
        }
        e0.r.a(viewGroup, new e(fragment, fragment2, z2, aVarH, view2, vVar, rect));
        return obj3;
    }

    private static void n(l lVar, int i3, h hVar, View view, l.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        v vVarJ;
        Object obj;
        ViewGroup viewGroup = lVar.f1360p.f() ? (ViewGroup) lVar.f1360p.e(i3) : null;
        if (viewGroup == null || (vVarJ = j((fragment2 = hVar.f1484d), (fragment = hVar.f1481a))) == null) {
            return;
        }
        boolean z2 = hVar.f1482b;
        boolean z3 = hVar.f1485e;
        Object objQ = q(vVarJ, fragment, z2);
        Object objR = r(vVarJ, fragment2, z3);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objL = l(vVarJ, viewGroup, view, aVar, hVar, arrayList, arrayList2, objQ, objR);
        if (objQ == null && objL == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList<View> arrayListK = k(vVarJ, obj, fragment2, arrayList, view);
        Object obj2 = (arrayListK == null || arrayListK.isEmpty()) ? null : obj;
        vVarJ.a(objQ, view);
        Object objU = u(vVarJ, objQ, obj2, objL, fragment, hVar.f1482b);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList.size() > 0)) {
            a0.b bVar = new a0.b();
            gVar.b(fragment2, bVar);
            vVarJ.w(fragment2, objU, bVar, new c(gVar, fragment2, bVar));
        }
        if (objU != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            vVarJ.t(objU, objQ, arrayList3, obj2, arrayListK, objL, arrayList2);
            y(vVarJ, viewGroup, fragment, view, arrayList2, objQ, arrayList3, obj2, arrayListK);
            vVarJ.x(viewGroup, arrayList2, aVar);
            vVarJ.c(viewGroup, objU);
            vVarJ.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(l lVar, int i3, h hVar, View view, l.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        v vVarJ;
        Object obj;
        ViewGroup viewGroup = lVar.f1360p.f() ? (ViewGroup) lVar.f1360p.e(i3) : null;
        if (viewGroup == null || (vVarJ = j((fragment2 = hVar.f1484d), (fragment = hVar.f1481a))) == null) {
            return;
        }
        boolean z2 = hVar.f1482b;
        boolean z3 = hVar.f1485e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objQ = q(vVarJ, fragment, z2);
        Object objR = r(vVarJ, fragment2, z3);
        Object objM = m(vVarJ, viewGroup, view, aVar, hVar, arrayList2, arrayList, objQ, objR);
        if (objQ == null && objM == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList<View> arrayListK = k(vVarJ, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListK2 = k(vVarJ, objQ, fragment, arrayList, view);
        A(arrayListK2, 4);
        Object objU = u(vVarJ, objQ, obj, objM, fragment, z2);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList2.size() > 0)) {
            a0.b bVar = new a0.b();
            gVar.b(fragment2, bVar);
            vVarJ.w(fragment2, objU, bVar, new a(gVar, fragment2, bVar));
        }
        if (objU != null) {
            v(vVarJ, obj, fragment2, arrayListK);
            ArrayList<String> arrayListO = vVarJ.o(arrayList);
            vVarJ.t(objU, objQ, arrayListK2, obj, arrayListK, objM, arrayList);
            vVarJ.c(viewGroup, objU);
            vVarJ.y(viewGroup, arrayList2, arrayList, arrayListO, aVar);
            A(arrayListK2, 0);
            vVarJ.A(objM, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i3) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i3, hVar2);
        return hVar2;
    }

    private static Object q(v vVar, Fragment fragment, boolean z2) {
        if (fragment == null) {
            return null;
        }
        return vVar.g(z2 ? fragment.G() : fragment.v());
    }

    private static Object r(v vVar, Fragment fragment, boolean z2) {
        if (fragment == null) {
            return null;
        }
        return vVar.g(z2 ? fragment.J() : fragment.x());
    }

    static View s(l.a<String, View> aVar, h hVar, Object obj, boolean z2) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = hVar.f1483c;
        if (obj == null || aVar == null || (arrayList = aVar2.f1432p) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get(z2 ? aVar2.f1432p.get(0) : aVar2.f1433q.get(0));
    }

    private static Object t(v vVar, Fragment fragment, Fragment fragment2, boolean z2) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return vVar.B(vVar.g(z2 ? fragment2.L() : fragment.K()));
    }

    private static Object u(v vVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z2) {
        boolean zP;
        if (obj == null || obj2 == null || fragment == null) {
            zP = true;
        } else {
            zP = z2 ? fragment.p() : fragment.o();
        }
        return zP ? vVar.n(obj2, obj, obj3) : vVar.m(obj2, obj, obj3);
    }

    private static void v(v vVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.f1233l && fragment.f1247z && fragment.N) {
            fragment.n1(true);
            vVar.r(obj, fragment.P(), arrayList);
            e0.r.a(fragment.G, new b(arrayList));
        }
    }

    private static v w() {
        try {
            return (v) p0.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void x(l.a<String, String> aVar, l.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void y(v vVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        e0.r.a(viewGroup, new d(obj, vVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(v vVar, Object obj, Object obj2, l.a<String, View> aVar, boolean z2, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.f1432p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get(z2 ? aVar2.f1433q.get(0) : aVar2.f1432p.get(0));
        vVar.v(obj, view);
        if (obj2 != null) {
            vVar.v(obj2, view);
        }
    }
}
