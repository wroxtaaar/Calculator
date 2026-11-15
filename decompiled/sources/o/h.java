package o;

import com.vivo.seckeysdk.BuildConfig;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: PriorityGoalRow.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends o.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i[] f5366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i[] f5367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    b f5369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    c f5370l;

    /* JADX INFO: compiled from: PriorityGoalRow.java */
    class a implements Comparator<i> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f5378c - iVar2.f5378c;
        }
    }

    /* JADX INFO: compiled from: PriorityGoalRow.java */
    class b implements Comparable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        i f5372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h f5373c;

        public b(h hVar) {
            this.f5373c = hVar;
        }

        public boolean a(i iVar, float f3) {
            boolean z2 = true;
            if (!this.f5372b.f5376a) {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f4 = iVar.f5384i[i3];
                    if (f4 != 0.0f) {
                        float f5 = f4 * f3;
                        if (Math.abs(f5) < 1.0E-4f) {
                            f5 = 0.0f;
                        }
                        this.f5372b.f5384i[i3] = f5;
                    } else {
                        this.f5372b.f5384i[i3] = 0.0f;
                    }
                }
                return true;
            }
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.f5372b.f5384i;
                fArr[i4] = fArr[i4] + (iVar.f5384i[i4] * f3);
                if (Math.abs(fArr[i4]) < 1.0E-4f) {
                    this.f5372b.f5384i[i4] = 0.0f;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                h.this.G(this.f5372b);
            }
            return false;
        }

        public void b(i iVar) {
            this.f5372b = iVar;
        }

        public final boolean c() {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f3 = this.f5372b.f5384i[i3];
                if (f3 > 0.0f) {
                    return false;
                }
                if (f3 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f5372b.f5378c - ((i) obj).f5378c;
        }

        public final boolean d(i iVar) {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f3 = iVar.f5384i[i3];
                float f4 = this.f5372b.f5384i[i3];
                if (f4 != f3) {
                    if (f4 < f3) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f5372b.f5384i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f5372b != null) {
                for (int i3 = 0; i3 < 9; i3++) {
                    str = str + this.f5372b.f5384i[i3] + " ";
                }
            }
            return str + "] " + this.f5372b;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f5365g = 128;
        this.f5366h = new i[128];
        this.f5367i = new i[128];
        this.f5368j = 0;
        this.f5369k = new b(this);
        this.f5370l = cVar;
    }

    private final void F(i iVar) {
        int i3;
        int i4 = this.f5368j + 1;
        i[] iVarArr = this.f5366h;
        if (i4 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f5366h = iVarArr2;
            this.f5367i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f5366h;
        int i5 = this.f5368j;
        iVarArr3[i5] = iVar;
        int i6 = i5 + 1;
        this.f5368j = i6;
        if (i6 > 1 && iVarArr3[i6 - 1].f5378c > iVar.f5378c) {
            int i7 = 0;
            while (true) {
                i3 = this.f5368j;
                if (i7 >= i3) {
                    break;
                }
                this.f5367i[i7] = this.f5366h[i7];
                i7++;
            }
            Arrays.sort(this.f5367i, 0, i3, new a());
            for (int i8 = 0; i8 < this.f5368j; i8++) {
                this.f5366h[i8] = this.f5367i[i8];
            }
        }
        iVar.f5376a = true;
        iVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i3 = 0;
        while (i3 < this.f5368j) {
            if (this.f5366h[i3] == iVar) {
                while (true) {
                    int i4 = this.f5368j;
                    if (i3 >= i4 - 1) {
                        this.f5368j = i4 - 1;
                        iVar.f5376a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f5366h;
                        int i5 = i3 + 1;
                        iVarArr[i3] = iVarArr[i5];
                        i3 = i5;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // o.b
    public void C(o.b bVar, boolean z2) {
        i iVar = bVar.f5331a;
        if (iVar == null) {
            return;
        }
        o.b.a aVar = bVar.f5335e;
        int iK = aVar.k();
        for (int i3 = 0; i3 < iK; i3++) {
            i iVarG = aVar.g(i3);
            float fA = aVar.a(i3);
            this.f5369k.b(iVarG);
            if (this.f5369k.a(iVar, fA)) {
                F(iVarG);
            }
            this.f5332b += bVar.f5332b * fA;
        }
        G(iVar);
    }

    @Override // o.b, o.d.a
    public void a(i iVar) {
        this.f5369k.b(iVar);
        this.f5369k.e();
        iVar.f5384i[iVar.f5380e] = 1.0f;
        F(iVar);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // o.b, o.d.a
    public i b(d dVar, boolean[] zArr) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.f5368j; i4++) {
            i iVar = this.f5366h[i4];
            if (!zArr[iVar.f5378c]) {
                this.f5369k.b(iVar);
                if (i3 == -1) {
                    if (this.f5369k.c()) {
                        i3 = i4;
                    }
                } else if (this.f5369k.d(this.f5366h[i3])) {
                    i3 = i4;
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        return this.f5366h[i3];
    }

    @Override // o.b, o.d.a
    public void clear() {
        this.f5368j = 0;
        this.f5332b = 0.0f;
    }

    @Override // o.b
    public String toString() {
        String str = BuildConfig.FLAVOR + " goal -> (" + this.f5332b + ") : ";
        for (int i3 = 0; i3 < this.f5368j; i3++) {
            this.f5369k.b(this.f5366h[i3]);
            str = str + this.f5369k + " ";
        }
        return str;
    }
}
