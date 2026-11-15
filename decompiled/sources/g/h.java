package g;

import android.view.View;
import android.view.animation.Interpolator;
import e0.x;
import e0.y;
import e0.z;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f4746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    y f4747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4748e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4745b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final z f4749f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<x> f4744a = new ArrayList<>();

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
    class a extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4750a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4751b = 0;

        a() {
        }

        @Override // e0.y
        public void a(View view) {
            int i3 = this.f4751b + 1;
            this.f4751b = i3;
            if (i3 == h.this.f4744a.size()) {
                y yVar = h.this.f4747d;
                if (yVar != null) {
                    yVar.a(null);
                }
                d();
            }
        }

        @Override // e0.z, e0.y
        public void b(View view) {
            if (this.f4750a) {
                return;
            }
            this.f4750a = true;
            y yVar = h.this.f4747d;
            if (yVar != null) {
                yVar.b(null);
            }
        }

        void d() {
            this.f4751b = 0;
            this.f4750a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f4748e) {
            Iterator<x> it = this.f4744a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f4748e = false;
        }
    }

    void b() {
        this.f4748e = false;
    }

    public h c(x xVar) {
        if (!this.f4748e) {
            this.f4744a.add(xVar);
        }
        return this;
    }

    public h d(x xVar, x xVar2) {
        this.f4744a.add(xVar);
        xVar2.h(xVar.c());
        this.f4744a.add(xVar2);
        return this;
    }

    public h e(long j3) {
        if (!this.f4748e) {
            this.f4745b = j3;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f4748e) {
            this.f4746c = interpolator;
        }
        return this;
    }

    public h g(y yVar) {
        if (!this.f4748e) {
            this.f4747d = yVar;
        }
        return this;
    }

    public void h() {
        if (this.f4748e) {
            return;
        }
        for (x xVar : this.f4744a) {
            long j3 = this.f4745b;
            if (j3 >= 0) {
                xVar.d(j3);
            }
            Interpolator interpolator = this.f4746c;
            if (interpolator != null) {
                xVar.e(interpolator);
            }
            if (this.f4747d != null) {
                xVar.f(this.f4749f);
            }
            xVar.j();
        }
        this.f4748e = true;
    }
}
