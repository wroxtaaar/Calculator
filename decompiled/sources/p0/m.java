package p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.vivo.seckeysdk.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m implements Cloneable {
    private static final int[] I = {2, 1, 3, 4};
    private static final g J = new a();
    private static ThreadLocal<l.a<Animator, d>> K = new ThreadLocal<>();
    p E;
    private e F;
    private l.a<String, String> G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<s> f5698u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList<s> f5699v;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5679b = getClass().getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5680c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f5681d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TimeInterpolator f5682e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<Integer> f5683f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<View> f5684g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<String> f5685h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<Class<?>> f5686i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<Integer> f5687j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<View> f5688k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList<Class<?>> f5689l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList<String> f5690m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<Integer> f5691n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList<View> f5692o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ArrayList<Class<?>> f5693p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private t f5694q = new t();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private t f5695r = new t();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    q f5696s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f5697t = I;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ViewGroup f5700w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f5701x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ArrayList<Animator> f5702y = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f5703z = 0;
    private boolean A = false;
    private boolean B = false;
    private ArrayList<f> C = null;
    private ArrayList<Animator> D = new ArrayList<>();
    private g H = J;

    /* JADX INFO: compiled from: Transition.java */
    static class a extends g {
        a() {
        }

        @Override // p0.g
        public Path a(float f3, float f4, float f5, float f6) {
            Path path = new Path();
            path.moveTo(f3, f4);
            path.lineTo(f5, f6);
            return path;
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l.a f5704b;

        b(l.a aVar) {
            this.f5704b = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5704b.remove(animator);
            m.this.f5702y.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.f5702y.add(animator);
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.p();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f5707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        s f5709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        m0 f5710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        m f5711e;

        d(View view, String str, m mVar, m0 m0Var, s sVar) {
            this.f5707a = view;
            this.f5708b = str;
            this.f5709c = sVar;
            this.f5710d = m0Var;
            this.f5711e = mVar;
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    public static abstract class e {
    }

    /* JADX INFO: compiled from: Transition.java */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static boolean H(s sVar, s sVar2, String str) {
        Object obj = sVar.f5725a.get(str);
        Object obj2 = sVar2.f5725a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void I(l.a<View, s> aVar, l.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View viewValueAt = sparseArray.valueAt(i3);
            if (viewValueAt != null && G(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i3))) != null && G(view)) {
                s sVar = aVar.get(viewValueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f5698u.add(sVar);
                    this.f5699v.add(sVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void J(l.a<View, s> aVar, l.a<View, s> aVar2) {
        s sVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewI = aVar.i(size);
            if (viewI != null && G(viewI) && (sVarRemove = aVar2.remove(viewI)) != null && G(sVarRemove.f5726b)) {
                this.f5698u.add(aVar.k(size));
                this.f5699v.add(sVarRemove);
            }
        }
    }

    private void K(l.a<View, s> aVar, l.a<View, s> aVar2, l.d<View> dVar, l.d<View> dVar2) {
        View viewE;
        int iL = dVar.l();
        for (int i3 = 0; i3 < iL; i3++) {
            View viewM = dVar.m(i3);
            if (viewM != null && G(viewM) && (viewE = dVar2.e(dVar.h(i3))) != null && G(viewE)) {
                s sVar = aVar.get(viewM);
                s sVar2 = aVar2.get(viewE);
                if (sVar != null && sVar2 != null) {
                    this.f5698u.add(sVar);
                    this.f5699v.add(sVar2);
                    aVar.remove(viewM);
                    aVar2.remove(viewE);
                }
            }
        }
    }

    private void L(l.a<View, s> aVar, l.a<View, s> aVar2, l.a<String, View> aVar3, l.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i3 = 0; i3 < size; i3++) {
            View viewM = aVar3.m(i3);
            if (viewM != null && G(viewM) && (view = aVar4.get(aVar3.i(i3))) != null && G(view)) {
                s sVar = aVar.get(viewM);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f5698u.add(sVar);
                    this.f5699v.add(sVar2);
                    aVar.remove(viewM);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void M(t tVar, t tVar2) {
        l.a<View, s> aVar = new l.a<>(tVar.f5728a);
        l.a<View, s> aVar2 = new l.a<>(tVar2.f5728a);
        int i3 = 0;
        while (true) {
            int[] iArr = this.f5697t;
            if (i3 >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i4 = iArr[i3];
            if (i4 == 1) {
                J(aVar, aVar2);
            } else if (i4 == 2) {
                L(aVar, aVar2, tVar.f5731d, tVar2.f5731d);
            } else if (i4 == 3) {
                I(aVar, aVar2, tVar.f5729b, tVar2.f5729b);
            } else if (i4 == 4) {
                K(aVar, aVar2, tVar.f5730c, tVar2.f5730c);
            }
            i3++;
        }
    }

    private void S(Animator animator, l.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(l.a<View, s> aVar, l.a<View, s> aVar2) {
        for (int i3 = 0; i3 < aVar.size(); i3++) {
            s sVarM = aVar.m(i3);
            if (G(sVarM.f5726b)) {
                this.f5698u.add(sVarM);
                this.f5699v.add(null);
            }
        }
        for (int i4 = 0; i4 < aVar2.size(); i4++) {
            s sVarM2 = aVar2.m(i4);
            if (G(sVarM2.f5726b)) {
                this.f5699v.add(sVarM2);
                this.f5698u.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.f5728a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f5729b.indexOfKey(id) >= 0) {
                tVar.f5729b.put(id, null);
            } else {
                tVar.f5729b.put(id, view);
            }
        }
        String strJ = e0.t.J(view);
        if (strJ != null) {
            if (tVar.f5731d.containsKey(strJ)) {
                tVar.f5731d.put(strJ, null);
            } else {
                tVar.f5731d.put(strJ, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f5730c.g(itemIdAtPosition) < 0) {
                    e0.t.u0(view, true);
                    tVar.f5730c.i(itemIdAtPosition, view);
                    return;
                }
                View viewE = tVar.f5730c.e(itemIdAtPosition);
                if (viewE != null) {
                    e0.t.u0(viewE, false);
                    tVar.f5730c.i(itemIdAtPosition, null);
                }
            }
        }
    }

    private void h(View view, boolean z2) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f5687j;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f5688k;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f5689l;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.f5689l.get(i3).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z2) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f5727c.add(this);
                    i(sVar);
                    if (z2) {
                        d(this.f5694q, view, sVar);
                    } else {
                        d(this.f5695r, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f5691n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.f5692o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f5693p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    if (this.f5693p.get(i4).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                                h(viewGroup.getChildAt(i5), z2);
                            }
                        }
                    }
                }
            }
        }
    }

    private static l.a<Animator, d> x() {
        l.a<Animator, d> aVar = K.get();
        if (aVar != null) {
            return aVar;
        }
        l.a<Animator, d> aVar2 = new l.a<>();
        K.set(aVar2);
        return aVar2;
    }

    public List<String> A() {
        return this.f5685h;
    }

    public List<Class<?>> B() {
        return this.f5686i;
    }

    public List<View> C() {
        return this.f5684g;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean z2) {
        q qVar = this.f5696s;
        if (qVar != null) {
            return qVar.E(view, z2);
        }
        return (z2 ? this.f5694q : this.f5695r).f5728a.get(view);
    }

    public boolean F(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrD = D();
        if (strArrD == null) {
            Iterator<String> it = sVar.f5725a.keySet().iterator();
            while (it.hasNext()) {
                if (H(sVar, sVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrD) {
            if (!H(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean G(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f5687j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f5688k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f5689l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f5689l.get(i3).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f5690m != null && e0.t.J(view) != null && this.f5690m.contains(e0.t.J(view))) {
            return false;
        }
        if ((this.f5683f.size() == 0 && this.f5684g.size() == 0 && (((arrayList = this.f5686i) == null || arrayList.isEmpty()) && ((arrayList2 = this.f5685h) == null || arrayList2.isEmpty()))) || this.f5683f.contains(Integer.valueOf(id)) || this.f5684g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f5685h;
        if (arrayList6 != null && arrayList6.contains(e0.t.J(view))) {
            return true;
        }
        if (this.f5686i != null) {
            for (int i4 = 0; i4 < this.f5686i.size(); i4++) {
                if (this.f5686i.get(i4).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void N(View view) {
        if (this.B) {
            return;
        }
        l.a<Animator, d> aVarX = x();
        int size = aVarX.size();
        m0 m0VarD = c0.d(view);
        for (int i3 = size - 1; i3 >= 0; i3--) {
            d dVarM = aVarX.m(i3);
            if (dVarM.f5707a != null && m0VarD.equals(dVarM.f5710d)) {
                p0.a.b(aVarX.i(i3));
            }
        }
        ArrayList<f> arrayList = this.C;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.C.clone();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((f) arrayList2.get(i4)).c(this);
            }
        }
        this.A = true;
    }

    void O(ViewGroup viewGroup) {
        d dVar;
        this.f5698u = new ArrayList<>();
        this.f5699v = new ArrayList<>();
        M(this.f5694q, this.f5695r);
        l.a<Animator, d> aVarX = x();
        int size = aVarX.size();
        m0 m0VarD = c0.d(viewGroup);
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator animatorI = aVarX.i(i3);
            if (animatorI != null && (dVar = aVarX.get(animatorI)) != null && dVar.f5707a != null && m0VarD.equals(dVar.f5710d)) {
                s sVar = dVar.f5709c;
                View view = dVar.f5707a;
                s sVarE = E(view, true);
                s sVarT = t(view, true);
                if (sVarE == null && sVarT == null) {
                    sVarT = this.f5695r.f5728a.get(view);
                }
                if (!(sVarE == null && sVarT == null) && dVar.f5711e.F(sVar, sVarT)) {
                    if (animatorI.isRunning() || animatorI.isStarted()) {
                        animatorI.cancel();
                    } else {
                        aVarX.remove(animatorI);
                    }
                }
            }
        }
        o(viewGroup, this.f5694q, this.f5695r, this.f5698u, this.f5699v);
        T();
    }

    public m P(f fVar) {
        ArrayList<f> arrayList = this.C;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.C.size() == 0) {
            this.C = null;
        }
        return this;
    }

    public m Q(View view) {
        this.f5684g.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.A) {
            if (!this.B) {
                l.a<Animator, d> aVarX = x();
                int size = aVarX.size();
                m0 m0VarD = c0.d(view);
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    d dVarM = aVarX.m(i3);
                    if (dVarM.f5707a != null && m0VarD.equals(dVarM.f5710d)) {
                        p0.a.c(aVarX.i(i3));
                    }
                }
                ArrayList<f> arrayList = this.C;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.C.clone();
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ((f) arrayList2.get(i4)).a(this);
                    }
                }
            }
            this.A = false;
        }
    }

    protected void T() {
        a0();
        l.a<Animator, d> aVarX = x();
        for (Animator animator : this.D) {
            if (aVarX.containsKey(animator)) {
                a0();
                S(animator, aVarX);
            }
        }
        this.D.clear();
        p();
    }

    public m U(long j3) {
        this.f5681d = j3;
        return this;
    }

    public void V(e eVar) {
        this.F = eVar;
    }

    public m W(TimeInterpolator timeInterpolator) {
        this.f5682e = timeInterpolator;
        return this;
    }

    public void X(g gVar) {
        if (gVar == null) {
            this.H = J;
        } else {
            this.H = gVar;
        }
    }

    public void Y(p pVar) {
    }

    public m Z(long j3) {
        this.f5680c = j3;
        return this;
    }

    public m a(f fVar) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(fVar);
        return this;
    }

    protected void a0() {
        if (this.f5703z == 0) {
            ArrayList<f> arrayList = this.C;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.C.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((f) arrayList2.get(i3)).d(this);
                }
            }
            this.B = false;
        }
        this.f5703z++;
    }

    public m b(View view) {
        this.f5684g.add(view);
        return this;
    }

    String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f5681d != -1) {
            str2 = str2 + "dur(" + this.f5681d + ") ";
        }
        if (this.f5680c != -1) {
            str2 = str2 + "dly(" + this.f5680c + ") ";
        }
        if (this.f5682e != null) {
            str2 = str2 + "interp(" + this.f5682e + ") ";
        }
        if (this.f5683f.size() <= 0 && this.f5684g.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f5683f.size() > 0) {
            for (int i3 = 0; i3 < this.f5683f.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f5683f.get(i3);
            }
        }
        if (this.f5684g.size() > 0) {
            for (int i4 = 0; i4 < this.f5684g.size(); i4++) {
                if (i4 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f5684g.get(i4);
            }
        }
        return str3 + ")";
    }

    protected void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    protected void f() {
        for (int size = this.f5702y.size() - 1; size >= 0; size--) {
            this.f5702y.get(size).cancel();
        }
        ArrayList<f> arrayList = this.C;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.C.clone();
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((f) arrayList2.get(i3)).e(this);
        }
    }

    public abstract void g(s sVar);

    void i(s sVar) {
    }

    public abstract void j(s sVar);

    void k(ViewGroup viewGroup, boolean z2) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        l.a<String, String> aVar;
        l(z2);
        if ((this.f5683f.size() > 0 || this.f5684g.size() > 0) && (((arrayList = this.f5685h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f5686i) == null || arrayList2.isEmpty()))) {
            for (int i3 = 0; i3 < this.f5683f.size(); i3++) {
                View viewFindViewById = viewGroup.findViewById(this.f5683f.get(i3).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z2) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f5727c.add(this);
                    i(sVar);
                    if (z2) {
                        d(this.f5694q, viewFindViewById, sVar);
                    } else {
                        d(this.f5695r, viewFindViewById, sVar);
                    }
                }
            }
            for (int i4 = 0; i4 < this.f5684g.size(); i4++) {
                View view = this.f5684g.get(i4);
                s sVar2 = new s(view);
                if (z2) {
                    j(sVar2);
                } else {
                    g(sVar2);
                }
                sVar2.f5727c.add(this);
                i(sVar2);
                if (z2) {
                    d(this.f5694q, view, sVar2);
                } else {
                    d(this.f5695r, view, sVar2);
                }
            }
        } else {
            h(viewGroup, z2);
        }
        if (z2 || (aVar = this.G) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList3.add(this.f5694q.f5731d.remove(this.G.i(i5)));
        }
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) arrayList3.get(i6);
            if (view2 != null) {
                this.f5694q.f5731d.put(this.G.m(i6), view2);
            }
        }
    }

    void l(boolean z2) {
        if (z2) {
            this.f5694q.f5728a.clear();
            this.f5694q.f5729b.clear();
            this.f5694q.f5730c.b();
        } else {
            this.f5695r.f5728a.clear();
            this.f5695r.f5729b.clear();
            this.f5695r.f5730c.b();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.D = new ArrayList<>();
            mVar.f5694q = new t();
            mVar.f5695r = new t();
            mVar.f5698u = null;
            mVar.f5699v = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    protected void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i3;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        l.a<Animator, d> aVarX = x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            s sVar3 = arrayList.get(i4);
            s sVar4 = arrayList2.get(i4);
            if (sVar3 != null && !sVar3.f5727c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f5727c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 == null && sVar4 == null) {
                i3 = size;
            } else {
                if (sVar3 == null || sVar4 == null || F(sVar3, sVar4)) {
                    Animator animatorN = n(viewGroup, sVar3, sVar4);
                    if (animatorN != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f5726b;
                            String[] strArrD = D();
                            if (strArrD != null && strArrD.length > 0) {
                                sVar2 = new s(view2);
                                s sVar5 = tVar2.f5728a.get(view2);
                                if (sVar5 != null) {
                                    int i5 = 0;
                                    while (i5 < strArrD.length) {
                                        sVar2.f5725a.put(strArrD[i5], sVar5.f5725a.get(strArrD[i5]));
                                        i5++;
                                        animatorN = animatorN;
                                        size = size;
                                        sVar5 = sVar5;
                                    }
                                }
                                Animator animator3 = animatorN;
                                i3 = size;
                                int size2 = aVarX.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    d dVar = aVarX.get(aVarX.i(i6));
                                    if (dVar.f5709c != null && dVar.f5707a == view2 && dVar.f5708b.equals(u()) && dVar.f5709c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                i3 = size;
                                animator2 = animatorN;
                                sVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            i3 = size;
                            view = sVar3.f5726b;
                            animator = animatorN;
                            sVar = null;
                        }
                        if (animator != null) {
                            aVarX.put(animator, new d(view, u(), this, c0.d(viewGroup), sVar));
                            this.D.add(animator);
                        }
                    }
                }
                i3 = size;
            }
            i4++;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator4 = this.D.get(sparseIntArray.keyAt(i7));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i7)) - Long.MAX_VALUE) + animator4.getStartDelay());
            }
        }
    }

    protected void p() {
        int i3 = this.f5703z - 1;
        this.f5703z = i3;
        if (i3 == 0) {
            ArrayList<f> arrayList = this.C;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.C.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((f) arrayList2.get(i4)).b(this);
                }
            }
            for (int i5 = 0; i5 < this.f5694q.f5730c.l(); i5++) {
                View viewM = this.f5694q.f5730c.m(i5);
                if (viewM != null) {
                    e0.t.u0(viewM, false);
                }
            }
            for (int i6 = 0; i6 < this.f5695r.f5730c.l(); i6++) {
                View viewM2 = this.f5695r.f5730c.m(i6);
                if (viewM2 != null) {
                    e0.t.u0(viewM2, false);
                }
            }
            this.B = true;
        }
    }

    public long q() {
        return this.f5681d;
    }

    public e r() {
        return this.F;
    }

    public TimeInterpolator s() {
        return this.f5682e;
    }

    s t(View view, boolean z2) {
        q qVar = this.f5696s;
        if (qVar != null) {
            return qVar.t(view, z2);
        }
        ArrayList<s> arrayList = z2 ? this.f5698u : this.f5699v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            s sVar = arrayList.get(i4);
            if (sVar == null) {
                return null;
            }
            if (sVar.f5726b == view) {
                i3 = i4;
                break;
            }
        }
        if (i3 >= 0) {
            return (z2 ? this.f5699v : this.f5698u).get(i3);
        }
        return null;
    }

    public String toString() {
        return b0(BuildConfig.FLAVOR);
    }

    public String u() {
        return this.f5679b;
    }

    public g v() {
        return this.H;
    }

    public p w() {
        return this.E;
    }

    public long y() {
        return this.f5680c;
    }

    public List<Integer> z() {
        return this.f5683f;
    }
}
