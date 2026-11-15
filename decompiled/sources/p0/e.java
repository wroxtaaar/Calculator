package p0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class e extends androidx.fragment.app.v {

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class a extends m.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f5630a;

        a(Rect rect) {
            this.f5630a = rect;
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class b implements m.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f5632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f5633c;

        b(View view, ArrayList arrayList) {
            this.f5632b = view;
            this.f5633c = arrayList;
        }

        @Override // p0.m.f
        public void a(m mVar) {
        }

        @Override // p0.m.f
        public void b(m mVar) {
            mVar.P(this);
            this.f5632b.setVisibility(8);
            int size = this.f5633c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((View) this.f5633c.get(i3)).setVisibility(0);
            }
        }

        @Override // p0.m.f
        public void c(m mVar) {
        }

        @Override // p0.m.f
        public void d(m mVar) {
        }

        @Override // p0.m.f
        public void e(m mVar) {
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class c extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f5635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f5636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f5637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f5638e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f5639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f5640g;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f5635b = obj;
            this.f5636c = arrayList;
            this.f5637d = obj2;
            this.f5638e = arrayList2;
            this.f5639f = obj3;
            this.f5640g = arrayList3;
        }

        @Override // p0.m.f
        public void b(m mVar) {
            mVar.P(this);
        }

        @Override // p0.n, p0.m.f
        public void d(m mVar) {
            Object obj = this.f5635b;
            if (obj != null) {
                e.this.q(obj, this.f5636c, null);
            }
            Object obj2 = this.f5637d;
            if (obj2 != null) {
                e.this.q(obj2, this.f5638e, null);
            }
            Object obj3 = this.f5639f;
            if (obj3 != null) {
                e.this.q(obj3, this.f5640g, null);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class d extends m.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f5642a;

        d(Rect rect) {
            this.f5642a = rect;
        }
    }

    private static boolean C(m mVar) {
        return (androidx.fragment.app.v.l(mVar.z()) && androidx.fragment.app.v.l(mVar.A()) && androidx.fragment.app.v.l(mVar.B())) ? false : true;
    }

    @Override // androidx.fragment.app.v
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.C().clear();
            qVar.C().addAll(arrayList2);
            q(qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.v
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.e0((m) obj);
        return qVar;
    }

    @Override // androidx.fragment.app.v
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.v
    public void b(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar == null) {
            return;
        }
        int i3 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int iH0 = qVar.h0();
            while (i3 < iH0) {
                b(qVar.g0(i3), arrayList);
                i3++;
            }
            return;
        }
        if (C(mVar) || !androidx.fragment.app.v.l(mVar.C())) {
            return;
        }
        int size = arrayList.size();
        while (i3 < size) {
            mVar.b(arrayList.get(i3));
            i3++;
        }
    }

    @Override // androidx.fragment.app.v
    public void c(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.v
    public boolean e(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.v
    public Object g(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.v
    public Object m(Object obj, Object obj2, Object obj3) {
        m mVarM0 = (m) obj;
        m mVar = (m) obj2;
        m mVar2 = (m) obj3;
        if (mVarM0 != null && mVar != null) {
            mVarM0 = new q().e0(mVarM0).e0(mVar).m0(1);
        } else if (mVarM0 == null) {
            mVarM0 = mVar != null ? mVar : null;
        }
        if (mVar2 == null) {
            return mVarM0;
        }
        q qVar = new q();
        if (mVarM0 != null) {
            qVar.e0(mVarM0);
        }
        qVar.e0(mVar2);
        return qVar;
    }

    @Override // androidx.fragment.app.v
    public Object n(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.e0((m) obj);
        }
        if (obj2 != null) {
            qVar.e0((m) obj2);
        }
        if (obj3 != null) {
            qVar.e0((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.v
    public void p(Object obj, View view) {
        if (obj != null) {
            ((m) obj).Q(view);
        }
    }

    @Override // androidx.fragment.app.v
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i3 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int iH0 = qVar.h0();
            while (i3 < iH0) {
                q(qVar.g0(i3), arrayList, arrayList2);
                i3++;
            }
            return;
        }
        if (C(mVar)) {
            return;
        }
        List<View> listC = mVar.C();
        if (listC.size() == arrayList.size() && listC.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i3 < size) {
                mVar.b(arrayList2.get(i3));
                i3++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                mVar.Q(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.v
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.v
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.v
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).V(new d(rect));
        }
    }

    @Override // androidx.fragment.app.v
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((m) obj).V(new a(rect));
        }
    }

    @Override // androidx.fragment.app.v
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> listC = qVar.C();
        listC.clear();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            androidx.fragment.app.v.d(listC, arrayList.get(i3));
        }
        listC.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }
}
