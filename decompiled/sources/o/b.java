package o;

import com.vivo.seckeysdk.BuildConfig;
import java.util.ArrayList;

/* JADX INFO: compiled from: ArrayRow.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f5335e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    i f5331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f5332b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f5333c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<i> f5334d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f5336f = false;

    /* JADX INFO: compiled from: ArrayRow.java */
    public interface a {
        float a(int i3);

        void b(i iVar, float f3, boolean z2);

        boolean c(i iVar);

        void clear();

        float d(b bVar, boolean z2);

        void e(i iVar, float f3);

        float f(i iVar);

        i g(int i3);

        void h(float f3);

        float i(i iVar, boolean z2);

        void j();

        int k();
    }

    public b() {
    }

    private boolean v(i iVar, d dVar) {
        return iVar.f5388m <= 1;
    }

    private i x(boolean[] zArr, i iVar) {
        i.a aVar;
        int iK = this.f5335e.k();
        i iVar2 = null;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < iK; i3++) {
            float fA = this.f5335e.a(i3);
            if (fA < 0.0f) {
                i iVarG = this.f5335e.g(i3);
                if ((zArr == null || !zArr[iVarG.f5378c]) && iVarG != iVar && (((aVar = iVarG.f5385j) == i.a.SLACK || aVar == i.a.ERROR) && fA < f3)) {
                    f3 = fA;
                    iVar2 = iVarG;
                }
            }
        }
        return iVar2;
    }

    String A() {
        boolean z2;
        String str = (this.f5331a == null ? BuildConfig.FLAVOR + "0" : BuildConfig.FLAVOR + this.f5331a) + " = ";
        if (this.f5332b != 0.0f) {
            str = str + this.f5332b;
            z2 = true;
        } else {
            z2 = false;
        }
        int iK = this.f5335e.k();
        for (int i3 = 0; i3 < iK; i3++) {
            i iVarG = this.f5335e.g(i3);
            if (iVarG != null) {
                float fA = this.f5335e.a(i3);
                if (fA != 0.0f) {
                    String string = iVarG.toString();
                    if (z2) {
                        if (fA > 0.0f) {
                            str = str + " + ";
                        } else {
                            str = str + " - ";
                            fA *= -1.0f;
                        }
                    } else if (fA < 0.0f) {
                        str = str + "- ";
                        fA *= -1.0f;
                    }
                    str = fA == 1.0f ? str + string : str + fA + " " + string;
                    z2 = true;
                }
            }
        }
        if (z2) {
            return str;
        }
        return str + "0.0";
    }

    public void B(d dVar, i iVar, boolean z2) {
        if (iVar.f5382g) {
            this.f5332b += iVar.f5381f * this.f5335e.f(iVar);
            this.f5335e.i(iVar, z2);
            if (z2) {
                iVar.c(this);
            }
        }
    }

    public void C(b bVar, boolean z2) {
        this.f5332b += bVar.f5332b * this.f5335e.d(bVar, z2);
        if (z2) {
            bVar.f5331a.c(this);
        }
    }

    public void D(d dVar) {
        if (dVar.f5351f.length == 0) {
            return;
        }
        boolean z2 = false;
        while (!z2) {
            int iK = this.f5335e.k();
            for (int i3 = 0; i3 < iK; i3++) {
                i iVarG = this.f5335e.g(i3);
                if (iVarG.f5379d != -1 || iVarG.f5382g) {
                    this.f5334d.add(iVarG);
                }
            }
            if (this.f5334d.size() > 0) {
                for (i iVar : this.f5334d) {
                    if (iVar.f5382g) {
                        B(dVar, iVar, true);
                    } else {
                        C(dVar.f5351f[iVar.f5379d], true);
                    }
                }
                this.f5334d.clear();
            } else {
                z2 = true;
            }
        }
    }

    @Override // o.d.a
    public void a(i iVar) {
        int i3 = iVar.f5380e;
        float f3 = 1.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                f3 = 1000.0f;
            } else if (i3 == 3) {
                f3 = 1000000.0f;
            } else if (i3 == 4) {
                f3 = 1.0E9f;
            } else if (i3 == 5) {
                f3 = 1.0E12f;
            }
        }
        this.f5335e.e(iVar, f3);
    }

    @Override // o.d.a
    public i b(d dVar, boolean[] zArr) {
        return x(zArr, null);
    }

    @Override // o.d.a
    public void c(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f5331a = null;
            this.f5335e.clear();
            for (int i3 = 0; i3 < bVar.f5335e.k(); i3++) {
                this.f5335e.b(bVar.f5335e.g(i3), bVar.f5335e.a(i3), true);
            }
        }
    }

    @Override // o.d.a
    public void clear() {
        this.f5335e.clear();
        this.f5331a = null;
        this.f5332b = 0.0f;
    }

    public b d(d dVar, int i3) {
        this.f5335e.e(dVar.o(i3, "ep"), 1.0f);
        this.f5335e.e(dVar.o(i3, "em"), -1.0f);
        return this;
    }

    b e(i iVar, int i3) {
        this.f5335e.e(iVar, i3);
        return this;
    }

    boolean f(d dVar) {
        boolean z2;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z2 = true;
        } else {
            y(iVarG);
            z2 = false;
        }
        if (this.f5335e.k() == 0) {
            this.f5336f = true;
        }
        return z2;
    }

    i g(d dVar) {
        int iK = this.f5335e.k();
        i iVar = null;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.0f;
        i iVar2 = null;
        for (int i3 = 0; i3 < iK; i3++) {
            float fA = this.f5335e.a(i3);
            i iVarG = this.f5335e.g(i3);
            if (iVarG.f5385j == i.a.UNRESTRICTED) {
                if (iVar == null || f3 > fA) {
                    boolean zV = v(iVarG, dVar);
                    z2 = zV;
                    f3 = fA;
                    iVar = iVarG;
                } else if (!z2 && v(iVarG, dVar)) {
                    f3 = fA;
                    iVar = iVarG;
                    z2 = true;
                }
            } else if (iVar == null && fA < 0.0f) {
                if (iVar2 == null || f4 > fA) {
                    boolean zV2 = v(iVarG, dVar);
                    z3 = zV2;
                    f4 = fA;
                    iVar2 = iVarG;
                } else if (!z3 && v(iVarG, dVar)) {
                    f4 = fA;
                    iVar2 = iVarG;
                    z3 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // o.d.a
    public i getKey() {
        return this.f5331a;
    }

    b h(i iVar, i iVar2, int i3, float f3, i iVar3, i iVar4, int i4) {
        if (iVar2 == iVar3) {
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar4, 1.0f);
            this.f5335e.e(iVar2, -2.0f);
            return this;
        }
        if (f3 == 0.5f) {
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar2, -1.0f);
            this.f5335e.e(iVar3, -1.0f);
            this.f5335e.e(iVar4, 1.0f);
            if (i3 > 0 || i4 > 0) {
                this.f5332b = (-i3) + i4;
            }
        } else if (f3 <= 0.0f) {
            this.f5335e.e(iVar, -1.0f);
            this.f5335e.e(iVar2, 1.0f);
            this.f5332b = i3;
        } else if (f3 >= 1.0f) {
            this.f5335e.e(iVar4, -1.0f);
            this.f5335e.e(iVar3, 1.0f);
            this.f5332b = -i4;
        } else {
            float f4 = 1.0f - f3;
            this.f5335e.e(iVar, f4 * 1.0f);
            this.f5335e.e(iVar2, f4 * (-1.0f));
            this.f5335e.e(iVar3, (-1.0f) * f3);
            this.f5335e.e(iVar4, 1.0f * f3);
            if (i3 > 0 || i4 > 0) {
                this.f5332b = ((-i3) * f4) + (i4 * f3);
            }
        }
        return this;
    }

    b i(i iVar, int i3) {
        this.f5331a = iVar;
        float f3 = i3;
        iVar.f5381f = f3;
        this.f5332b = f3;
        this.f5336f = true;
        return this;
    }

    b j(i iVar, i iVar2, float f3) {
        this.f5335e.e(iVar, -1.0f);
        this.f5335e.e(iVar2, f3);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f3) {
        this.f5335e.e(iVar, -1.0f);
        this.f5335e.e(iVar2, 1.0f);
        this.f5335e.e(iVar3, f3);
        this.f5335e.e(iVar4, -f3);
        return this;
    }

    public b l(float f3, float f4, float f5, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f5332b = 0.0f;
        if (f4 == 0.0f || f3 == f5) {
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar2, -1.0f);
            this.f5335e.e(iVar4, 1.0f);
            this.f5335e.e(iVar3, -1.0f);
        } else if (f3 == 0.0f) {
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar2, -1.0f);
        } else if (f5 == 0.0f) {
            this.f5335e.e(iVar3, 1.0f);
            this.f5335e.e(iVar4, -1.0f);
        } else {
            float f6 = (f3 / f4) / (f5 / f4);
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar2, -1.0f);
            this.f5335e.e(iVar4, f6);
            this.f5335e.e(iVar3, -f6);
        }
        return this;
    }

    public b m(i iVar, int i3) {
        if (i3 < 0) {
            this.f5332b = i3 * (-1);
            this.f5335e.e(iVar, 1.0f);
        } else {
            this.f5332b = i3;
            this.f5335e.e(iVar, -1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, int i3) {
        boolean z2 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z2 = true;
            }
            this.f5332b = i3;
        }
        if (z2) {
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar2, -1.0f);
        } else {
            this.f5335e.e(iVar, -1.0f);
            this.f5335e.e(iVar2, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i3) {
        boolean z2 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z2 = true;
            }
            this.f5332b = i3;
        }
        if (z2) {
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar2, -1.0f);
            this.f5335e.e(iVar3, -1.0f);
        } else {
            this.f5335e.e(iVar, -1.0f);
            this.f5335e.e(iVar2, 1.0f);
            this.f5335e.e(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i3) {
        boolean z2 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z2 = true;
            }
            this.f5332b = i3;
        }
        if (z2) {
            this.f5335e.e(iVar, 1.0f);
            this.f5335e.e(iVar2, -1.0f);
            this.f5335e.e(iVar3, 1.0f);
        } else {
            this.f5335e.e(iVar, -1.0f);
            this.f5335e.e(iVar2, 1.0f);
            this.f5335e.e(iVar3, -1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f3) {
        this.f5335e.e(iVar3, 0.5f);
        this.f5335e.e(iVar4, 0.5f);
        this.f5335e.e(iVar, -0.5f);
        this.f5335e.e(iVar2, -0.5f);
        this.f5332b = -f3;
        return this;
    }

    void r() {
        float f3 = this.f5332b;
        if (f3 < 0.0f) {
            this.f5332b = f3 * (-1.0f);
            this.f5335e.j();
        }
    }

    boolean s() {
        i iVar = this.f5331a;
        return iVar != null && (iVar.f5385j == i.a.UNRESTRICTED || this.f5332b >= 0.0f);
    }

    boolean t(i iVar) {
        return this.f5335e.c(iVar);
    }

    public String toString() {
        return A();
    }

    public boolean u() {
        return this.f5331a == null && this.f5332b == 0.0f && this.f5335e.k() == 0;
    }

    public i w(i iVar) {
        return x(null, iVar);
    }

    void y(i iVar) {
        i iVar2 = this.f5331a;
        if (iVar2 != null) {
            this.f5335e.e(iVar2, -1.0f);
            this.f5331a = null;
        }
        float fI = this.f5335e.i(iVar, true) * (-1.0f);
        this.f5331a = iVar;
        if (fI == 1.0f) {
            return;
        }
        this.f5332b /= fI;
        this.f5335e.h(fI);
    }

    public void z() {
        this.f5331a = null;
        this.f5335e.clear();
        this.f5332b = 0.0f;
        this.f5336f = false;
    }

    public b(c cVar) {
        this.f5335e = new o.a(this, cVar);
    }
}
