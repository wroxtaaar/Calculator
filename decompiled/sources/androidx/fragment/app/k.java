package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f1341a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f1342b;

    /* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final l.f f1343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f1344b;
    }

    k(l lVar) {
        this.f1342b = lVar;
    }

    void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().a(fragment, bundle, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void b(Fragment fragment, Context context, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().b(fragment, context, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().c(fragment, bundle, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void d(Fragment fragment, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().d(fragment, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void e(Fragment fragment, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().e(fragment, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void f(Fragment fragment, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().f(fragment, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void g(Fragment fragment, Context context, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().g(fragment, context, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void h(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().h(fragment, bundle, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void i(Fragment fragment, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().i(fragment, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void j(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().j(fragment, bundle, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void k(Fragment fragment, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().k(fragment, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void l(Fragment fragment, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().l(fragment, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void m(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().m(fragment, view, bundle, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }

    void n(Fragment fragment, boolean z2) {
        Fragment fragmentI0 = this.f1342b.i0();
        if (fragmentI0 != null) {
            fragmentI0.F().h0().n(fragment, true);
        }
        for (a aVar : this.f1341a) {
            if (!z2 || aVar.f1344b) {
                l.f fVar = aVar.f1343a;
                throw null;
            }
        }
    }
}
