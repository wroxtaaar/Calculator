package p;

import java.util.ArrayList;

/* JADX INFO: compiled from: WidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends e {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ArrayList<e> f5594w0 = new ArrayList<>();

    public void H0() {
        ArrayList<e> arrayList = this.f5594w0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = this.f5594w0.get(i3);
            if (eVar instanceof l) {
                ((l) eVar).H0();
            }
        }
    }

    public void I0(e eVar) {
        this.f5594w0.remove(eVar);
        eVar.t0(null);
    }

    public void J0() {
        this.f5594w0.clear();
    }

    @Override // p.e
    public void W() {
        this.f5594w0.clear();
        super.W();
    }

    @Override // p.e
    public void X(o.c cVar) {
        super.X(cVar);
        int size = this.f5594w0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f5594w0.get(i3).X(cVar);
        }
    }

    public void c(e eVar) {
        this.f5594w0.add(eVar);
        if (eVar.E() != null) {
            ((l) eVar.E()).I0(eVar);
        }
        eVar.t0(this);
    }
}
