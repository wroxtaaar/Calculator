package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FragmentStore.java */
/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f1415a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, q> f1416b = new HashMap<>();

    r() {
    }

    void a(Fragment fragment) {
        if (this.f1415a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f1415a) {
            this.f1415a.add(fragment);
        }
        fragment.f1233l = true;
    }

    void b() {
        this.f1416b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f1416b.containsKey(str);
    }

    void d(int i3) {
        Iterator<Fragment> it = this.f1415a.iterator();
        while (it.hasNext()) {
            q qVar = this.f1416b.get(it.next().f1227f);
            if (qVar != null) {
                qVar.q(i3);
            }
        }
        for (q qVar2 : this.f1416b.values()) {
            if (qVar2 != null) {
                qVar2.q(i3);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f1416b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (q qVar : this.f1416b.values()) {
                printWriter.print(str);
                if (qVar != null) {
                    Fragment fragmentI = qVar.i();
                    printWriter.println(fragmentI);
                    fragmentI.k(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f1415a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.f1415a.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        q qVar = this.f1416b.get(str);
        if (qVar != null) {
            return qVar.i();
        }
        return null;
    }

    Fragment g(int i3) {
        for (int size = this.f1415a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1415a.get(size);
            if (fragment != null && fragment.f1244w == i3) {
                return fragment;
            }
        }
        for (q qVar : this.f1416b.values()) {
            if (qVar != null) {
                Fragment fragmentI = qVar.i();
                if (fragmentI.f1244w == i3) {
                    return fragmentI;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.f1415a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1415a.get(size);
                if (fragment != null && str.equals(fragment.f1246y)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (q qVar : this.f1416b.values()) {
            if (qVar != null) {
                Fragment fragmentI = qVar.i();
                if (str.equals(fragmentI.f1246y)) {
                    return fragmentI;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentM;
        for (q qVar : this.f1416b.values()) {
            if (qVar != null && (fragmentM = qVar.i().m(str)) != null) {
                return fragmentM;
            }
        }
        return null;
    }

    Fragment j(Fragment fragment) {
        ViewGroup viewGroup = fragment.G;
        View view = fragment.H;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.f1415a.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
                Fragment fragment2 = this.f1415a.get(iIndexOf);
                if (fragment2.G == viewGroup && fragment2.H != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    List<Fragment> k() {
        ArrayList arrayList = new ArrayList();
        for (q qVar : this.f1416b.values()) {
            if (qVar != null) {
                arrayList.add(qVar.i());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    q l(String str) {
        return this.f1416b.get(str);
    }

    List<Fragment> m() {
        ArrayList arrayList;
        if (this.f1415a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1415a) {
            arrayList = new ArrayList(this.f1415a);
        }
        return arrayList;
    }

    void n(q qVar) {
        this.f1416b.put(qVar.i().f1227f, qVar);
    }

    void o(q qVar) {
        Fragment fragmentI = qVar.i();
        for (q qVar2 : this.f1416b.values()) {
            if (qVar2 != null) {
                Fragment fragmentI2 = qVar2.i();
                if (fragmentI.f1227f.equals(fragmentI2.f1230i)) {
                    fragmentI2.f1229h = fragmentI;
                    fragmentI2.f1230i = null;
                }
            }
        }
        this.f1416b.put(fragmentI.f1227f, null);
        String str = fragmentI.f1230i;
        if (str != null) {
            fragmentI.f1229h = f(str);
        }
    }

    void p(Fragment fragment) {
        synchronized (this.f1415a) {
            this.f1415a.remove(fragment);
        }
        fragment.f1233l = false;
    }

    void q() {
        this.f1416b.clear();
    }

    void r(List<String> list) {
        this.f1415a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (l.p0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    ArrayList<p> s() {
        ArrayList<p> arrayList = new ArrayList<>(this.f1416b.size());
        for (q qVar : this.f1416b.values()) {
            if (qVar != null) {
                Fragment fragmentI = qVar.i();
                p pVarO = qVar.o();
                arrayList.add(pVarO);
                if (l.p0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentI + ": " + pVarO.f1410n);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> t() {
        synchronized (this.f1415a) {
            if (this.f1415a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f1415a.size());
            for (Fragment fragment : this.f1415a) {
                arrayList.add(fragment.f1227f);
                if (l.p0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.f1227f + "): " + fragment);
                }
            }
            return arrayList;
        }
    }
}
