package androidx.fragment.app;

import android.view.ViewGroup;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransaction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f1417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f1418b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f1424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1425i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f1427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f1428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    CharSequence f1429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f1430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    CharSequence f1431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList<String> f1432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList<String> f1433q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ArrayList<Runnable> f1435s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<a> f1419c = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f1426j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f1434r = false;

    /* JADX INFO: compiled from: FragmentTransaction.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Fragment f1437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1439d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1440e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1441f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.lifecycle.d.b f1442g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        androidx.lifecycle.d.b f1443h;

        a() {
        }

        a(int i3, Fragment fragment) {
            this.f1436a = i3;
            this.f1437b = fragment;
            androidx.lifecycle.d.b bVar = androidx.lifecycle.d.b.RESUMED;
            this.f1442g = bVar;
            this.f1443h = bVar;
        }
    }

    s(h hVar, ClassLoader classLoader) {
        this.f1417a = hVar;
        this.f1418b = classLoader;
    }

    public s b(int i3, Fragment fragment, String str) {
        k(i3, fragment, str, 1);
        return this;
    }

    s c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.G = viewGroup;
        return b(viewGroup.getId(), fragment, str);
    }

    public s d(Fragment fragment, String str) {
        k(0, fragment, str, 1);
        return this;
    }

    void e(a aVar) {
        this.f1419c.add(aVar);
        aVar.f1438c = this.f1420d;
        aVar.f1439d = this.f1421e;
        aVar.f1440e = this.f1422f;
        aVar.f1441f = this.f1423g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public s j() {
        if (this.f1425i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1426j = false;
        return this;
    }

    void k(int i3, Fragment fragment, String str, int i4) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.f1246y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f1246y + " now " + str);
            }
            fragment.f1246y = str;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i5 = fragment.f1244w;
            if (i5 != 0 && i5 != i3) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f1244w + " now " + i3);
            }
            fragment.f1244w = i3;
            fragment.f1245x = i3;
        }
        e(new a(i4, fragment));
    }

    public s l(Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    public s m(int i3, Fragment fragment) {
        return n(i3, fragment, null);
    }

    public s n(int i3, Fragment fragment, String str) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        k(i3, fragment, str, 2);
        return this;
    }

    public s o(boolean z2) {
        this.f1434r = z2;
        return this;
    }
}
