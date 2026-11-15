package o;

import java.util.Arrays;

/* JADX INFO: compiled from: SolverVariableValues.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static float f5396n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5397a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5398b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5399c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f5400d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int[] f5401e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f5402f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float[] f5403g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int[] f5404h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f5405i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f5406j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f5407k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b f5408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final c f5409m;

    j(b bVar, c cVar) {
        this.f5408l = bVar;
        this.f5409m = cVar;
        clear();
    }

    private void l(i iVar, int i3) {
        int[] iArr;
        int i4 = iVar.f5378c % this.f5399c;
        int[] iArr2 = this.f5400d;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            iArr2[i4] = i3;
        } else {
            while (true) {
                iArr = this.f5401e;
                if (iArr[i5] == -1) {
                    break;
                } else {
                    i5 = iArr[i5];
                }
            }
            iArr[i5] = i3;
        }
        this.f5401e[i3] = -1;
    }

    private void m(int i3, i iVar, float f3) {
        this.f5402f[i3] = iVar.f5378c;
        this.f5403g[i3] = f3;
        this.f5404h[i3] = -1;
        this.f5405i[i3] = -1;
        iVar.a(this.f5408l);
        iVar.f5388m++;
        this.f5406j++;
    }

    private int n() {
        for (int i3 = 0; i3 < this.f5398b; i3++) {
            if (this.f5402f[i3] == -1) {
                return i3;
            }
        }
        return -1;
    }

    private void o() {
        int i3 = this.f5398b * 2;
        this.f5402f = Arrays.copyOf(this.f5402f, i3);
        this.f5403g = Arrays.copyOf(this.f5403g, i3);
        this.f5404h = Arrays.copyOf(this.f5404h, i3);
        this.f5405i = Arrays.copyOf(this.f5405i, i3);
        this.f5401e = Arrays.copyOf(this.f5401e, i3);
        for (int i4 = this.f5398b; i4 < i3; i4++) {
            this.f5402f[i4] = -1;
            this.f5401e[i4] = -1;
        }
        this.f5398b = i3;
    }

    private void q(int i3, i iVar, float f3) {
        int iN = n();
        m(iN, iVar, f3);
        if (i3 != -1) {
            this.f5404h[iN] = i3;
            int[] iArr = this.f5405i;
            iArr[iN] = iArr[i3];
            iArr[i3] = iN;
        } else {
            this.f5404h[iN] = -1;
            if (this.f5406j > 0) {
                this.f5405i[iN] = this.f5407k;
                this.f5407k = iN;
            } else {
                this.f5405i[iN] = -1;
            }
        }
        int[] iArr2 = this.f5405i;
        if (iArr2[iN] != -1) {
            this.f5404h[iArr2[iN]] = iN;
        }
        l(iVar, iN);
    }

    private void r(i iVar) {
        int[] iArr;
        int i3 = iVar.f5378c;
        int i4 = i3 % this.f5399c;
        int[] iArr2 = this.f5400d;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            return;
        }
        if (this.f5402f[i5] == i3) {
            int[] iArr3 = this.f5401e;
            iArr2[i4] = iArr3[i5];
            iArr3[i5] = -1;
            return;
        }
        while (true) {
            iArr = this.f5401e;
            if (iArr[i5] == -1 || this.f5402f[iArr[i5]] == i3) {
                break;
            } else {
                i5 = iArr[i5];
            }
        }
        int i6 = iArr[i5];
        if (i6 == -1 || this.f5402f[i6] != i3) {
            return;
        }
        iArr[i5] = iArr[i6];
        iArr[i6] = -1;
    }

    @Override // o.b.a
    public float a(int i3) {
        int i4 = this.f5406j;
        int i5 = this.f5407k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3) {
                return this.f5403g[i5];
            }
            i5 = this.f5405i[i5];
            if (i5 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void b(i iVar, float f3, boolean z2) {
        float f4 = f5396n;
        if (f3 <= (-f4) || f3 >= f4) {
            int iP = p(iVar);
            if (iP == -1) {
                e(iVar, f3);
                return;
            }
            float[] fArr = this.f5403g;
            fArr[iP] = fArr[iP] + f3;
            float f5 = fArr[iP];
            float f6 = f5396n;
            if (f5 <= (-f6) || fArr[iP] >= f6) {
                return;
            }
            fArr[iP] = 0.0f;
            i(iVar, z2);
        }
    }

    @Override // o.b.a
    public boolean c(i iVar) {
        return p(iVar) != -1;
    }

    @Override // o.b.a
    public void clear() {
        int i3 = this.f5406j;
        for (int i4 = 0; i4 < i3; i4++) {
            i iVarG = g(i4);
            if (iVarG != null) {
                iVarG.c(this.f5408l);
            }
        }
        for (int i5 = 0; i5 < this.f5398b; i5++) {
            this.f5402f[i5] = -1;
            this.f5401e[i5] = -1;
        }
        for (int i6 = 0; i6 < this.f5399c; i6++) {
            this.f5400d[i6] = -1;
        }
        this.f5406j = 0;
        this.f5407k = -1;
    }

    @Override // o.b.a
    public float d(b bVar, boolean z2) {
        float f3 = f(bVar.f5331a);
        i(bVar.f5331a, z2);
        j jVar = (j) bVar.f5335e;
        int iK = jVar.k();
        int i3 = 0;
        int i4 = 0;
        while (i3 < iK) {
            int[] iArr = jVar.f5402f;
            if (iArr[i4] != -1) {
                b(this.f5409m.f5340d[iArr[i4]], jVar.f5403g[i4] * f3, z2);
                i3++;
            }
            i4++;
        }
        return f3;
    }

    @Override // o.b.a
    public void e(i iVar, float f3) {
        float f4 = f5396n;
        if (f3 > (-f4) && f3 < f4) {
            i(iVar, true);
            return;
        }
        if (this.f5406j == 0) {
            m(0, iVar, f3);
            l(iVar, 0);
            this.f5407k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f5403g[iP] = f3;
            return;
        }
        if (this.f5406j + 1 >= this.f5398b) {
            o();
        }
        int i3 = this.f5406j;
        int i4 = this.f5407k;
        int i5 = -1;
        for (int i6 = 0; i6 < i3; i6++) {
            int[] iArr = this.f5402f;
            int i7 = iArr[i4];
            int i8 = iVar.f5378c;
            if (i7 == i8) {
                this.f5403g[i4] = f3;
                return;
            }
            if (iArr[i4] < i8) {
                i5 = i4;
            }
            i4 = this.f5405i[i4];
            if (i4 == -1) {
                break;
            }
        }
        q(i5, iVar, f3);
    }

    @Override // o.b.a
    public float f(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f5403g[iP];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public i g(int i3) {
        int i4 = this.f5406j;
        if (i4 == 0) {
            return null;
        }
        int i5 = this.f5407k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3 && i5 != -1) {
                return this.f5409m.f5340d[this.f5402f[i5]];
            }
            i5 = this.f5405i[i5];
            if (i5 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // o.b.a
    public void h(float f3) {
        int i3 = this.f5406j;
        int i4 = this.f5407k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f5403g;
            fArr[i4] = fArr[i4] / f3;
            i4 = this.f5405i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // o.b.a
    public float i(i iVar, boolean z2) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f3 = this.f5403g[iP];
        if (this.f5407k == iP) {
            this.f5407k = this.f5405i[iP];
        }
        this.f5402f[iP] = -1;
        int[] iArr = this.f5404h;
        if (iArr[iP] != -1) {
            int[] iArr2 = this.f5405i;
            iArr2[iArr[iP]] = iArr2[iP];
        }
        int[] iArr3 = this.f5405i;
        if (iArr3[iP] != -1) {
            iArr[iArr3[iP]] = iArr[iP];
        }
        this.f5406j--;
        iVar.f5388m--;
        if (z2) {
            iVar.c(this.f5408l);
        }
        return f3;
    }

    @Override // o.b.a
    public void j() {
        int i3 = this.f5406j;
        int i4 = this.f5407k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f5403g;
            fArr[i4] = fArr[i4] * (-1.0f);
            i4 = this.f5405i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // o.b.a
    public int k() {
        return this.f5406j;
    }

    public int p(i iVar) {
        int[] iArr;
        if (this.f5406j == 0) {
            return -1;
        }
        int i3 = iVar.f5378c;
        int i4 = this.f5400d[i3 % this.f5399c];
        if (i4 == -1) {
            return -1;
        }
        if (this.f5402f[i4] == i3) {
            return i4;
        }
        while (true) {
            iArr = this.f5401e;
            if (iArr[i4] == -1 || this.f5402f[iArr[i4]] == i3) {
                break;
            }
            i4 = iArr[i4];
        }
        if (iArr[i4] != -1 && this.f5402f[iArr[i4]] == i3) {
            return iArr[i4];
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i3 = this.f5406j;
        for (int i4 = 0; i4 < i3; i4++) {
            i iVarG = g(i4);
            if (iVarG != null) {
                String str2 = str + iVarG + " = " + a(i4) + " ";
                int iP = p(iVarG);
                String str3 = str2 + "[p: ";
                String str4 = (this.f5404h[iP] != -1 ? str3 + this.f5409m.f5340d[this.f5402f[this.f5404h[iP]]] : str3 + "none") + ", n: ";
                str = (this.f5405i[iP] != -1 ? str4 + this.f5409m.f5340d[this.f5402f[this.f5405i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
