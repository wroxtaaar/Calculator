package androidx.coordinatorlayout.widget;

import d0.f;
import d0.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: DirectedAcyclicGraph.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<ArrayList<T>> f1130a = new g(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l.g<T, ArrayList<T>> f1131b = new l.g<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f1132c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<T> f1133d = new HashSet<>();

    private void e(T t3, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t3)) {
            return;
        }
        if (hashSet.contains(t3)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t3);
        ArrayList<T> arrayList2 = this.f1131b.get(t3);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                e(arrayList2.get(i3), arrayList, hashSet);
            }
        }
        hashSet.remove(t3);
        arrayList.add(t3);
    }

    private ArrayList<T> f() {
        ArrayList<T> arrayListB = this.f1130a.b();
        return arrayListB == null ? new ArrayList<>() : arrayListB;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1130a.a(arrayList);
    }

    public void a(T t3, T t4) {
        if (!this.f1131b.containsKey(t3) || !this.f1131b.containsKey(t4)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f1131b.get(t3);
        if (arrayListF == null) {
            arrayListF = f();
            this.f1131b.put(t3, arrayListF);
        }
        arrayListF.add(t4);
    }

    public void b(T t3) {
        if (this.f1131b.containsKey(t3)) {
            return;
        }
        this.f1131b.put(t3, null);
    }

    public void c() {
        int size = this.f1131b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<T> arrayListM = this.f1131b.m(i3);
            if (arrayListM != null) {
                k(arrayListM);
            }
        }
        this.f1131b.clear();
    }

    public boolean d(T t3) {
        return this.f1131b.containsKey(t3);
    }

    public List g(T t3) {
        return this.f1131b.get(t3);
    }

    public List<T> h(T t3) {
        int size = this.f1131b.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<T> arrayListM = this.f1131b.m(i3);
            if (arrayListM != null && arrayListM.contains(t3)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1131b.i(i3));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f1132c.clear();
        this.f1133d.clear();
        int size = this.f1131b.size();
        for (int i3 = 0; i3 < size; i3++) {
            e(this.f1131b.i(i3), this.f1132c, this.f1133d);
        }
        return this.f1132c;
    }

    public boolean j(T t3) {
        int size = this.f1131b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<T> arrayListM = this.f1131b.m(i3);
            if (arrayListM != null && arrayListM.contains(t3)) {
                return true;
            }
        }
        return false;
    }
}
