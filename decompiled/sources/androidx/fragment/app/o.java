package androidx.fragment.app;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: FragmentManagerViewModel.java */
/* JADX INFO: loaded from: classes.dex */
final class o extends androidx.lifecycle.p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final androidx.lifecycle.q.a f1391i = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1395f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, Fragment> f1392c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, o> f1393d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.r> f1394e = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1396g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1397h = false;

    /* JADX INFO: compiled from: FragmentManagerViewModel.java */
    static class a implements androidx.lifecycle.q.a {
        a() {
        }

        @Override // androidx.lifecycle.q.a
        public <T extends androidx.lifecycle.p> T a(Class<T> cls) {
            return new o(true);
        }
    }

    o(boolean z2) {
        this.f1395f = z2;
    }

    static o i(androidx.lifecycle.r rVar) {
        return (o) new androidx.lifecycle.q(rVar, f1391i).a(o.class);
    }

    @Override // androidx.lifecycle.p
    protected void d() {
        if (l.p0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1396g = true;
    }

    boolean e(Fragment fragment) {
        if (this.f1392c.containsKey(fragment.f1227f)) {
            return false;
        }
        this.f1392c.put(fragment.f1227f, fragment);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f1392c.equals(oVar.f1392c) && this.f1393d.equals(oVar.f1393d) && this.f1394e.equals(oVar.f1394e);
    }

    void f(Fragment fragment) {
        if (l.p0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        o oVar = this.f1393d.get(fragment.f1227f);
        if (oVar != null) {
            oVar.d();
            this.f1393d.remove(fragment.f1227f);
        }
        androidx.lifecycle.r rVar = this.f1394e.get(fragment.f1227f);
        if (rVar != null) {
            rVar.a();
            this.f1394e.remove(fragment.f1227f);
        }
    }

    Fragment g(String str) {
        return this.f1392c.get(str);
    }

    o h(Fragment fragment) {
        o oVar = this.f1393d.get(fragment.f1227f);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(this.f1395f);
        this.f1393d.put(fragment.f1227f, oVar2);
        return oVar2;
    }

    public int hashCode() {
        return (((this.f1392c.hashCode() * 31) + this.f1393d.hashCode()) * 31) + this.f1394e.hashCode();
    }

    Collection<Fragment> j() {
        return this.f1392c.values();
    }

    androidx.lifecycle.r k(Fragment fragment) {
        androidx.lifecycle.r rVar = this.f1394e.get(fragment.f1227f);
        if (rVar != null) {
            return rVar;
        }
        androidx.lifecycle.r rVar2 = new androidx.lifecycle.r();
        this.f1394e.put(fragment.f1227f, rVar2);
        return rVar2;
    }

    boolean l() {
        return this.f1396g;
    }

    boolean m(Fragment fragment) {
        return this.f1392c.remove(fragment.f1227f) != null;
    }

    boolean n(Fragment fragment) {
        if (this.f1392c.containsKey(fragment.f1227f)) {
            return this.f1395f ? this.f1396g : !this.f1397h;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1392c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1393d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1394e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
