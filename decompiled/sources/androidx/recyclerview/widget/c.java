package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import e0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static TimeInterpolator f1962s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f1963h = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f1964i = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<j> f1965j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<i> f1966k = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.d0>> f1967l = new ArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ArrayList<ArrayList<j>> f1968m = new ArrayList<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ArrayList<ArrayList<i>> f1969n = new ArrayList<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1970o = new ArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1971p = new ArrayList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1972q = new ArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f1973r = new ArrayList<>();

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1974b;

        a(ArrayList arrayList) {
            this.f1974b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f1974b) {
                c.this.S(jVar.f2008a, jVar.f2009b, jVar.f2010c, jVar.f2011d, jVar.f2012e);
            }
            this.f1974b.clear();
            c.this.f1968m.remove(this.f1974b);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1976b;

        b(ArrayList arrayList) {
            this.f1976b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1976b.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f1976b.clear();
            c.this.f1969n.remove(this.f1976b);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class RunnableC0020c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1978b;

        RunnableC0020c(ArrayList arrayList) {
            this.f1978b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1978b.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.d0) it.next());
            }
            this.f1978b.clear();
            c.this.f1967l.remove(this.f1978b);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f1982d;

        d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1980b = d0Var;
            this.f1981c = viewPropertyAnimator;
            this.f1982d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1981c.setListener(null);
            this.f1982d.setAlpha(1.0f);
            c.this.G(this.f1980b);
            c.this.f1972q.remove(this.f1980b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f1980b);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1986d;

        e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1984b = d0Var;
            this.f1985c = view;
            this.f1986d = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1985c.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1986d.setListener(null);
            c.this.A(this.f1984b);
            c.this.f1970o.remove(this.f1984b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f1984b);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f1988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f1990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f1991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1992f;

        f(RecyclerView.d0 d0Var, int i3, View view, int i4, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1988b = d0Var;
            this.f1989c = i3;
            this.f1990d = view;
            this.f1991e = i4;
            this.f1992f = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1989c != 0) {
                this.f1990d.setTranslationX(0.0f);
            }
            if (this.f1991e != 0) {
                this.f1990d.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1992f.setListener(null);
            c.this.E(this.f1988b);
            c.this.f1971p.remove(this.f1988b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f1988b);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f1994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f1996d;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1994b = iVar;
            this.f1995c = viewPropertyAnimator;
            this.f1996d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1995c.setListener(null);
            this.f1996d.setAlpha(1.0f);
            this.f1996d.setTranslationX(0.0f);
            this.f1996d.setTranslationY(0.0f);
            c.this.C(this.f1994b.f2002a, true);
            c.this.f1973r.remove(this.f1994b.f2002a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f1994b.f2002a, true);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f1998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f2000d;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1998b = iVar;
            this.f1999c = viewPropertyAnimator;
            this.f2000d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1999c.setListener(null);
            this.f2000d.setAlpha(1.0f);
            this.f2000d.setTranslationX(0.0f);
            this.f2000d.setTranslationY(0.0f);
            c.this.C(this.f1998b.f2003b, false);
            c.this.f1973r.remove(this.f1998b.f2003b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f1998b.f2003b, false);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f2008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2012e;

        j(RecyclerView.d0 d0Var, int i3, int i4, int i5, int i6) {
            this.f2008a = d0Var;
            this.f2009b = i3;
            this.f2010c = i4;
            this.f2011d = i5;
            this.f2012e = i6;
        }
    }

    private void T(RecyclerView.d0 d0Var) {
        View view = d0Var.f1813a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1972q.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(d0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    private void W(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (Y(iVar, d0Var) && iVar.f2002a == null && iVar.f2003b == null) {
                list.remove(iVar);
            }
        }
    }

    private void X(i iVar) {
        RecyclerView.d0 d0Var = iVar.f2002a;
        if (d0Var != null) {
            Y(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f2003b;
        if (d0Var2 != null) {
            Y(iVar, d0Var2);
        }
    }

    private boolean Y(i iVar, RecyclerView.d0 d0Var) {
        boolean z2 = false;
        if (iVar.f2003b == d0Var) {
            iVar.f2003b = null;
        } else {
            if (iVar.f2002a != d0Var) {
                return false;
            }
            iVar.f2002a = null;
            z2 = true;
        }
        d0Var.f1813a.setAlpha(1.0f);
        d0Var.f1813a.setTranslationX(0.0f);
        d0Var.f1813a.setTranslationY(0.0f);
        C(d0Var, z2);
        return true;
    }

    private void Z(RecyclerView.d0 d0Var) {
        if (f1962s == null) {
            f1962s = new ValueAnimator().getInterpolator();
        }
        d0Var.f1813a.animate().setInterpolator(f1962s);
        j(d0Var);
    }

    void Q(RecyclerView.d0 d0Var) {
        View view = d0Var.f1813a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1970o.add(d0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new e(d0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    void R(i iVar) {
        RecyclerView.d0 d0Var = iVar.f2002a;
        View view = d0Var == null ? null : d0Var.f1813a;
        RecyclerView.d0 d0Var2 = iVar.f2003b;
        View view2 = d0Var2 != null ? d0Var2.f1813a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f1973r.add(iVar.f2002a);
            duration.translationX(iVar.f2006e - iVar.f2004c);
            duration.translationY(iVar.f2007f - iVar.f2005d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f1973r.add(iVar.f2003b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    void S(RecyclerView.d0 d0Var, int i3, int i4, int i5, int i6) {
        View view = d0Var.f1813a;
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        if (i7 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i8 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1971p.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new f(d0Var, i7, view, i8, viewPropertyAnimatorAnimate)).start();
    }

    void U(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f1813a.animate().cancel();
        }
    }

    void V() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.f1813a;
        view.animate().cancel();
        int size = this.f1965j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f1965j.get(size).f2008a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(d0Var);
                this.f1965j.remove(size);
            }
        }
        W(this.f1966k, d0Var);
        if (this.f1963h.remove(d0Var)) {
            view.setAlpha(1.0f);
            G(d0Var);
        }
        if (this.f1964i.remove(d0Var)) {
            view.setAlpha(1.0f);
            A(d0Var);
        }
        for (int size2 = this.f1969n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f1969n.get(size2);
            W(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f1969n.remove(size2);
            }
        }
        for (int size3 = this.f1968m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f1968m.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).f2008a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(d0Var);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.f1968m.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.f1967l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.f1967l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                A(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f1967l.remove(size5);
                }
            }
        }
        this.f1972q.remove(d0Var);
        this.f1970o.remove(d0Var);
        this.f1973r.remove(d0Var);
        this.f1971p.remove(d0Var);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f1965j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f1965j.get(size);
            View view = jVar.f2008a.f1813a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f2008a);
            this.f1965j.remove(size);
        }
        for (int size2 = this.f1963h.size() - 1; size2 >= 0; size2--) {
            G(this.f1963h.get(size2));
            this.f1963h.remove(size2);
        }
        int size3 = this.f1964i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f1964i.get(size3);
            d0Var.f1813a.setAlpha(1.0f);
            A(d0Var);
            this.f1964i.remove(size3);
        }
        for (int size4 = this.f1966k.size() - 1; size4 >= 0; size4--) {
            X(this.f1966k.get(size4));
        }
        this.f1966k.clear();
        if (p()) {
            for (int size5 = this.f1968m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f1968m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f2008a.f1813a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f2008a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1968m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1967l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.f1967l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f1813a.setAlpha(1.0f);
                    A(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1967l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1969n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f1969n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1969n.remove(arrayList3);
                    }
                }
            }
            U(this.f1972q);
            U(this.f1971p);
            U(this.f1970o);
            U(this.f1973r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f1964i.isEmpty() && this.f1966k.isEmpty() && this.f1965j.isEmpty() && this.f1963h.isEmpty() && this.f1971p.isEmpty() && this.f1972q.isEmpty() && this.f1970o.isEmpty() && this.f1973r.isEmpty() && this.f1968m.isEmpty() && this.f1967l.isEmpty() && this.f1969n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean z2 = !this.f1963h.isEmpty();
        boolean z3 = !this.f1965j.isEmpty();
        boolean z4 = !this.f1966k.isEmpty();
        boolean z5 = !this.f1964i.isEmpty();
        if (z2 || z3 || z5 || z4) {
            Iterator<RecyclerView.d0> it = this.f1963h.iterator();
            while (it.hasNext()) {
                T(it.next());
            }
            this.f1963h.clear();
            if (z3) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f1965j);
                this.f1968m.add(arrayList);
                this.f1965j.clear();
                a aVar = new a(arrayList);
                if (z2) {
                    t.f0(arrayList.get(0).f2008a.f1813a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z4) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f1966k);
                this.f1969n.add(arrayList2);
                this.f1966k.clear();
                b bVar = new b(arrayList2);
                if (z2) {
                    t.f0(arrayList2.get(0).f2002a.f1813a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z5) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1964i);
                this.f1967l.add(arrayList3);
                this.f1964i.clear();
                RunnableC0020c runnableC0020c = new RunnableC0020c(arrayList3);
                if (z2 || z3 || z4) {
                    t.f0(arrayList3.get(0).f1813a, runnableC0020c, (z2 ? o() : 0L) + Math.max(z3 ? n() : 0L, z4 ? m() : 0L));
                } else {
                    runnableC0020c.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.m
    public boolean w(RecyclerView.d0 d0Var) {
        Z(d0Var);
        d0Var.f1813a.setAlpha(0.0f);
        this.f1964i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i3, int i4, int i5, int i6) {
        if (d0Var == d0Var2) {
            return y(d0Var, i3, i4, i5, i6);
        }
        float translationX = d0Var.f1813a.getTranslationX();
        float translationY = d0Var.f1813a.getTranslationY();
        float alpha = d0Var.f1813a.getAlpha();
        Z(d0Var);
        int i7 = (int) ((i5 - i3) - translationX);
        int i8 = (int) ((i6 - i4) - translationY);
        d0Var.f1813a.setTranslationX(translationX);
        d0Var.f1813a.setTranslationY(translationY);
        d0Var.f1813a.setAlpha(alpha);
        if (d0Var2 != null) {
            Z(d0Var2);
            d0Var2.f1813a.setTranslationX(-i7);
            d0Var2.f1813a.setTranslationY(-i8);
            d0Var2.f1813a.setAlpha(0.0f);
        }
        this.f1966k.add(new i(d0Var, d0Var2, i3, i4, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean y(RecyclerView.d0 d0Var, int i3, int i4, int i5, int i6) {
        View view = d0Var.f1813a;
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i4 + ((int) d0Var.f1813a.getTranslationY());
        Z(d0Var);
        int i7 = i5 - translationX;
        int i8 = i6 - translationY;
        if (i7 == 0 && i8 == 0) {
            E(d0Var);
            return false;
        }
        if (i7 != 0) {
            view.setTranslationX(-i7);
        }
        if (i8 != 0) {
            view.setTranslationY(-i8);
        }
        this.f1965j.add(new j(d0Var, translationX, translationY, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean z(RecyclerView.d0 d0Var) {
        Z(d0Var);
        this.f1963h.add(d0Var);
        return true;
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    private static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f2002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.d0 f2003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2006e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2007f;

        private i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f2002a = d0Var;
            this.f2003b = d0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2002a + ", newHolder=" + this.f2003b + ", fromX=" + this.f2004c + ", fromY=" + this.f2005d + ", toX=" + this.f2006e + ", toY=" + this.f2007f + '}';
        }

        i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i3, int i4, int i5, int i6) {
            this(d0Var, d0Var2);
            this.f2004c = i3;
            this.f2005d = i4;
            this.f2006e = i5;
            this.f2007f = i6;
        }
    }
}
