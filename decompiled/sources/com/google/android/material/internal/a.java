package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CheckableGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T extends h<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, T> f3050a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f3051b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f3052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3054e;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CheckableGroup.java */
    class C0040a implements h.a<T> {
        C0040a() {
        }

        @Override // com.google.android.material.internal.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(T t3, boolean z2) {
            if (!z2) {
                a aVar = a.this;
                if (!aVar.r(t3, aVar.f3054e)) {
                    return;
                }
            } else if (!a.this.g(t3)) {
                return;
            }
            a.this.m();
        }
    }

    /* JADX INFO: compiled from: CheckableGroup.java */
    public interface b {
        void a(Set<Integer> set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(h<T> hVar) {
        int id = hVar.getId();
        if (this.f3051b.contains(Integer.valueOf(id))) {
            return false;
        }
        T t3 = this.f3050a.get(Integer.valueOf(k()));
        if (t3 != null) {
            r(t3, false);
        }
        boolean zAdd = this.f3051b.add(Integer.valueOf(id));
        if (!hVar.isChecked()) {
            hVar.setChecked(true);
        }
        return zAdd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        b bVar = this.f3052c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(h<T> hVar, boolean z2) {
        int id = hVar.getId();
        if (!this.f3051b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z2 && this.f3051b.size() == 1 && this.f3051b.contains(Integer.valueOf(id))) {
            hVar.setChecked(true);
            return false;
        }
        boolean zRemove = this.f3051b.remove(Integer.valueOf(id));
        if (hVar.isChecked()) {
            hVar.setChecked(false);
        }
        return zRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(T t3) {
        this.f3050a.put(Integer.valueOf(t3.getId()), t3);
        if (t3.isChecked()) {
            g(t3);
        }
        t3.setInternalOnCheckedChangeListener(new C0040a());
    }

    public void f(int i3) {
        T t3 = this.f3050a.get(Integer.valueOf(i3));
        if (t3 != null && g(t3)) {
            m();
        }
    }

    public void h() {
        boolean z2 = !this.f3051b.isEmpty();
        Iterator<T> it = this.f3050a.values().iterator();
        while (it.hasNext()) {
            r(it.next(), false);
        }
        if (z2) {
            m();
        }
    }

    public Set<Integer> i() {
        return new HashSet(this.f3051b);
    }

    public List<Integer> j(ViewGroup viewGroup) {
        Set<Integer> setI = i();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof h) && setI.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.f3053d || this.f3051b.isEmpty()) {
            return -1;
        }
        return this.f3051b.iterator().next().intValue();
    }

    public boolean l() {
        return this.f3053d;
    }

    public void n(T t3) {
        t3.setInternalOnCheckedChangeListener(null);
        this.f3050a.remove(Integer.valueOf(t3.getId()));
        this.f3051b.remove(Integer.valueOf(t3.getId()));
    }

    public void o(b bVar) {
        this.f3052c = bVar;
    }

    public void p(boolean z2) {
        this.f3054e = z2;
    }

    public void q(boolean z2) {
        if (this.f3053d != z2) {
            this.f3053d = z2;
            h();
        }
    }
}
