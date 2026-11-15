package p0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TransitionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m f5712a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<l.a<ViewGroup, ArrayList<m>>>> f5713b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList<ViewGroup> f5714c = new ArrayList<>();

    /* JADX INFO: compiled from: TransitionManager.java */
    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        m f5715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ViewGroup f5716c;

        /* JADX INFO: renamed from: p0.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TransitionManager.java */
        class C0080a extends n {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l.a f5717b;

            C0080a(l.a aVar) {
                this.f5717b = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p0.m.f
            public void b(m mVar) {
                ((ArrayList) this.f5717b.get(a.this.f5716c)).remove(mVar);
                mVar.P(this);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f5715b = mVar;
            this.f5716c = viewGroup;
        }

        private void a() {
            this.f5716c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f5716c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f5714c.remove(this.f5716c)) {
                return true;
            }
            l.a<ViewGroup, ArrayList<m>> aVarB = o.b();
            ArrayList<m> arrayList = aVarB.get(this.f5716c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarB.put(this.f5716c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f5715b);
            this.f5715b.a(new C0080a(aVarB));
            this.f5715b.k(this.f5716c, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).R(this.f5716c);
                }
            }
            this.f5715b.O(this.f5716c);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f5714c.remove(this.f5716c);
            ArrayList<m> arrayList = o.b().get(this.f5716c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().R(this.f5716c);
                }
            }
            this.f5715b.l(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f5714c.contains(viewGroup) || !e0.t.S(viewGroup)) {
            return;
        }
        f5714c.add(viewGroup);
        if (mVar == null) {
            mVar = f5712a;
        }
        m mVarClone = mVar.clone();
        d(viewGroup, mVarClone);
        l.c(viewGroup, null);
        c(viewGroup, mVarClone);
    }

    static l.a<ViewGroup, ArrayList<m>> b() {
        l.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<l.a<ViewGroup, ArrayList<m>>> weakReference = f5713b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        l.a<ViewGroup, ArrayList<m>> aVar2 = new l.a<>();
        f5713b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().N(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.k(viewGroup, true);
        }
        l lVarB = l.b(viewGroup);
        if (lVarB != null) {
            lVarB.a();
        }
    }
}
