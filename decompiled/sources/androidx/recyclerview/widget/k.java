package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import e0.t;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends e0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RecyclerView f2083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f2084e;

    /* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class a extends e0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final k f2085d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<View, e0.a> f2086e = new WeakHashMap();

        public a(k kVar) {
            this.f2085d = kVar;
        }

        @Override // e0.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = this.f2086e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // e0.a
        public f0.e b(View view) {
            e0.a aVar = this.f2086e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // e0.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = this.f2086e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            if (this.f2085d.o() || this.f2085d.f2083d.getLayoutManager() == null) {
                super.g(view, dVar);
                return;
            }
            this.f2085d.f2083d.getLayoutManager().O0(view, dVar);
            e0.a aVar = this.f2086e.get(view);
            if (aVar != null) {
                aVar.g(view, dVar);
            } else {
                super.g(view, dVar);
            }
        }

        @Override // e0.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = this.f2086e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // e0.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = this.f2086e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // e0.a
        public boolean j(View view, int i3, Bundle bundle) {
            if (this.f2085d.o() || this.f2085d.f2083d.getLayoutManager() == null) {
                return super.j(view, i3, bundle);
            }
            e0.a aVar = this.f2086e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i3, bundle)) {
                    return true;
                }
            } else if (super.j(view, i3, bundle)) {
                return true;
            }
            return this.f2085d.f2083d.getLayoutManager().i1(view, i3, bundle);
        }

        @Override // e0.a
        public void l(View view, int i3) {
            e0.a aVar = this.f2086e.get(view);
            if (aVar != null) {
                aVar.l(view, i3);
            } else {
                super.l(view, i3);
            }
        }

        @Override // e0.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            e0.a aVar = this.f2086e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        e0.a n(View view) {
            return this.f2086e.remove(view);
        }

        void o(View view) {
            e0.a aVarL = t.l(view);
            if (aVarL == null || aVarL == this) {
                return;
            }
            this.f2086e.put(view, aVarL);
        }
    }

    public k(RecyclerView recyclerView) {
        this.f2083d = recyclerView;
        e0.a aVarN = n();
        if (aVarN == null || !(aVarN instanceof a)) {
            this.f2084e = new a(this);
        } else {
            this.f2084e = (a) aVarN;
        }
    }

    @Override // e0.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().K0(accessibilityEvent);
        }
    }

    @Override // e0.a
    public void g(View view, f0.d dVar) {
        super.g(view, dVar);
        if (o() || this.f2083d.getLayoutManager() == null) {
            return;
        }
        this.f2083d.getLayoutManager().N0(dVar);
    }

    @Override // e0.a
    public boolean j(View view, int i3, Bundle bundle) {
        if (super.j(view, i3, bundle)) {
            return true;
        }
        if (o() || this.f2083d.getLayoutManager() == null) {
            return false;
        }
        return this.f2083d.getLayoutManager().g1(i3, bundle);
    }

    public e0.a n() {
        return this.f2084e;
    }

    boolean o() {
        return this.f2083d.m0();
    }
}
