package p0;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TransitionSet.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends m {
    int N;
    private ArrayList<m> L = new ArrayList<>();
    private boolean M = true;
    boolean O = false;
    private int P = 0;

    /* JADX INFO: compiled from: TransitionSet.java */
    class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f5719b;

        a(m mVar) {
            this.f5719b = mVar;
        }

        @Override // p0.m.f
        public void b(m mVar) {
            this.f5719b.T();
            mVar.P(this);
        }
    }

    /* JADX INFO: compiled from: TransitionSet.java */
    static class b extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        q f5721b;

        b(q qVar) {
            this.f5721b = qVar;
        }

        @Override // p0.m.f
        public void b(m mVar) {
            q qVar = this.f5721b;
            int i3 = qVar.N - 1;
            qVar.N = i3;
            if (i3 == 0) {
                qVar.O = false;
                qVar.p();
            }
            mVar.P(this);
        }

        @Override // p0.n, p0.m.f
        public void d(m mVar) {
            q qVar = this.f5721b;
            if (qVar.O) {
                return;
            }
            qVar.a0();
            this.f5721b.O = true;
        }
    }

    private void f0(m mVar) {
        this.L.add(mVar);
        mVar.f5696s = this;
    }

    private void o0() {
        b bVar = new b(this);
        Iterator<m> it = this.L.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.N = this.L.size();
    }

    @Override // p0.m
    public void N(View view) {
        super.N(view);
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.L.get(i3).N(view);
        }
    }

    @Override // p0.m
    public void R(View view) {
        super.R(view);
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.L.get(i3).R(view);
        }
    }

    @Override // p0.m
    protected void T() {
        if (this.L.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (this.M) {
            Iterator<m> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().T();
            }
            return;
        }
        for (int i3 = 1; i3 < this.L.size(); i3++) {
            this.L.get(i3 - 1).a(new a(this.L.get(i3)));
        }
        m mVar = this.L.get(0);
        if (mVar != null) {
            mVar.T();
        }
    }

    @Override // p0.m
    public void V(m.e eVar) {
        super.V(eVar);
        this.P |= 8;
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.L.get(i3).V(eVar);
        }
    }

    @Override // p0.m
    public void X(g gVar) {
        super.X(gVar);
        this.P |= 4;
        if (this.L != null) {
            for (int i3 = 0; i3 < this.L.size(); i3++) {
                this.L.get(i3).X(gVar);
            }
        }
    }

    @Override // p0.m
    public void Y(p pVar) {
        super.Y(pVar);
        this.P |= 2;
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.L.get(i3).Y(pVar);
        }
    }

    @Override // p0.m
    String b0(String str) {
        String strB0 = super.b0(str);
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strB0);
            sb.append("\n");
            sb.append(this.L.get(i3).b0(str + "  "));
            strB0 = sb.toString();
        }
        return strB0;
    }

    @Override // p0.m
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public q a(m.f fVar) {
        return (q) super.a(fVar);
    }

    @Override // p0.m
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public q b(View view) {
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            this.L.get(i3).b(view);
        }
        return (q) super.b(view);
    }

    public q e0(m mVar) {
        f0(mVar);
        long j3 = this.f5681d;
        if (j3 >= 0) {
            mVar.U(j3);
        }
        if ((this.P & 1) != 0) {
            mVar.W(s());
        }
        if ((this.P & 2) != 0) {
            mVar.Y(w());
        }
        if ((this.P & 4) != 0) {
            mVar.X(v());
        }
        if ((this.P & 8) != 0) {
            mVar.V(r());
        }
        return this;
    }

    @Override // p0.m
    public void g(s sVar) {
        if (G(sVar.f5726b)) {
            for (m mVar : this.L) {
                if (mVar.G(sVar.f5726b)) {
                    mVar.g(sVar);
                    sVar.f5727c.add(mVar);
                }
            }
        }
    }

    public m g0(int i3) {
        if (i3 < 0 || i3 >= this.L.size()) {
            return null;
        }
        return this.L.get(i3);
    }

    public int h0() {
        return this.L.size();
    }

    @Override // p0.m
    void i(s sVar) {
        super.i(sVar);
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.L.get(i3).i(sVar);
        }
    }

    @Override // p0.m
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public q P(m.f fVar) {
        return (q) super.P(fVar);
    }

    @Override // p0.m
    public void j(s sVar) {
        if (G(sVar.f5726b)) {
            for (m mVar : this.L) {
                if (mVar.G(sVar.f5726b)) {
                    mVar.j(sVar);
                    sVar.f5727c.add(mVar);
                }
            }
        }
    }

    @Override // p0.m
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public q Q(View view) {
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            this.L.get(i3).Q(view);
        }
        return (q) super.Q(view);
    }

    @Override // p0.m
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public q U(long j3) {
        ArrayList<m> arrayList;
        super.U(j3);
        if (this.f5681d >= 0 && (arrayList = this.L) != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.L.get(i3).U(j3);
            }
        }
        return this;
    }

    @Override // p0.m
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public q W(TimeInterpolator timeInterpolator) {
        this.P |= 1;
        ArrayList<m> arrayList = this.L;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.L.get(i3).W(timeInterpolator);
            }
        }
        return (q) super.W(timeInterpolator);
    }

    @Override // p0.m
    /* JADX INFO: renamed from: m */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.L = new ArrayList<>();
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            qVar.f0(this.L.get(i3).clone());
        }
        return qVar;
    }

    public q m0(int i3) {
        if (i3 == 0) {
            this.M = true;
        } else {
            if (i3 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i3);
            }
            this.M = false;
        }
        return this;
    }

    @Override // p0.m
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public q Z(long j3) {
        return (q) super.Z(j3);
    }

    @Override // p0.m
    protected void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long jY = y();
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = this.L.get(i3);
            if (jY > 0 && (this.M || i3 == 0)) {
                long jY2 = mVar.y();
                if (jY2 > 0) {
                    mVar.Z(jY2 + jY);
                } else {
                    mVar.Z(jY);
                }
            }
            mVar.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
