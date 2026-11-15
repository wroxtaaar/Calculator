package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FragmentTransitionImpl.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public abstract class v {

    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f1504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f1505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f1506e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1507f;

        a(int i3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f1503b = i3;
            this.f1504c = arrayList;
            this.f1505d = arrayList2;
            this.f1506e = arrayList3;
            this.f1507f = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i3 = 0; i3 < this.f1503b; i3++) {
                e0.t.A0((View) this.f1504c.get(i3), (String) this.f1505d.get(i3));
                e0.t.A0((View) this.f1506e.get(i3), (String) this.f1507f.get(i3));
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f1510c;

        b(ArrayList arrayList, Map map) {
            this.f1509b = arrayList;
            this.f1510c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1509b.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) this.f1509b.get(i3);
                String strJ = e0.t.J(view);
                if (strJ != null) {
                    e0.t.A0(view, v.i(this.f1510c, strJ));
                }
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f1513c;

        c(ArrayList arrayList, Map map) {
            this.f1512b = arrayList;
            this.f1513c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1512b.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) this.f1512b.get(i3);
                e0.t.A0(view, (String) this.f1513c.get(e0.t.J(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i3 = size; i3 < list.size(); i3++) {
            View view2 = list.get(i3);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    if (!h(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (list.get(i4) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (e0.v.a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                f(arrayList, viewGroup.getChildAt(i3));
            }
        }
    }

    public abstract Object g(Object obj);

    void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String strJ = e0.t.J(view);
            if (strJ != null) {
                map.put(strJ, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    j(map, viewGroup.getChildAt(i3));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = arrayList.get(i3);
            arrayList2.add(e0.t.J(view));
            e0.t.A0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        e0.r.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, a0.b bVar, Runnable runnable) {
        runnable.run();
    }

    void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        e0.r.a(view, new b(arrayList, map));
    }

    void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = arrayList.get(i3);
            String strJ = e0.t.J(view2);
            arrayList4.add(strJ);
            if (strJ != null) {
                e0.t.A0(view2, null);
                String str = map.get(strJ);
                for (int i4 = 0; i4 < size; i4++) {
                    if (str.equals(arrayList3.get(i4))) {
                        e0.t.A0(arrayList2.get(i4), strJ);
                        break;
                    }
                }
            }
        }
        e0.r.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
