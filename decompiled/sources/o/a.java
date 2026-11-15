package o;

import com.vivo.seckeysdk.BuildConfig;
import java.util.Arrays;

/* JADX INFO: compiled from: ArrayLinkedVariables.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static float f5319l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f5321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final c f5322c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5320a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5323d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f5324e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f5325f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f5326g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f5327h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5328i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5329j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5330k = false;

    a(b bVar, c cVar) {
        this.f5321b = bVar;
        this.f5322c = cVar;
    }

    @Override // o.b.a
    public float a(int i3) {
        int i4 = this.f5328i;
        for (int i5 = 0; i4 != -1 && i5 < this.f5320a; i5++) {
            if (i5 == i3) {
                return this.f5327h[i4];
            }
            i4 = this.f5326g[i4];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void b(i iVar, float f3, boolean z2) {
        float f4 = f5319l;
        if (f3 <= (-f4) || f3 >= f4) {
            int i3 = this.f5328i;
            if (i3 == -1) {
                this.f5328i = 0;
                this.f5327h[0] = f3;
                this.f5325f[0] = iVar.f5378c;
                this.f5326g[0] = -1;
                iVar.f5388m++;
                iVar.a(this.f5321b);
                this.f5320a++;
                if (this.f5330k) {
                    return;
                }
                int i4 = this.f5329j + 1;
                this.f5329j = i4;
                int[] iArr = this.f5325f;
                if (i4 >= iArr.length) {
                    this.f5330k = true;
                    this.f5329j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i5 = -1;
            for (int i6 = 0; i3 != -1 && i6 < this.f5320a; i6++) {
                int[] iArr2 = this.f5325f;
                int i7 = iArr2[i3];
                int i8 = iVar.f5378c;
                if (i7 == i8) {
                    float[] fArr = this.f5327h;
                    float f5 = fArr[i3] + f3;
                    float f6 = f5319l;
                    if (f5 > (-f6) && f5 < f6) {
                        f5 = 0.0f;
                    }
                    fArr[i3] = f5;
                    if (f5 == 0.0f) {
                        if (i3 == this.f5328i) {
                            this.f5328i = this.f5326g[i3];
                        } else {
                            int[] iArr3 = this.f5326g;
                            iArr3[i5] = iArr3[i3];
                        }
                        if (z2) {
                            iVar.c(this.f5321b);
                        }
                        if (this.f5330k) {
                            this.f5329j = i3;
                        }
                        iVar.f5388m--;
                        this.f5320a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i3] < i8) {
                    i5 = i3;
                }
                i3 = this.f5326g[i3];
            }
            int length = this.f5329j;
            int i9 = length + 1;
            if (this.f5330k) {
                int[] iArr4 = this.f5325f;
                if (iArr4[length] != -1) {
                    length = iArr4.length;
                }
            } else {
                length = i9;
            }
            int[] iArr5 = this.f5325f;
            if (length >= iArr5.length && this.f5320a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f5325f;
                    if (i10 >= iArr6.length) {
                        break;
                    }
                    if (iArr6[i10] == -1) {
                        length = i10;
                        break;
                    }
                    i10++;
                }
            }
            int[] iArr7 = this.f5325f;
            if (length >= iArr7.length) {
                length = iArr7.length;
                int i11 = this.f5323d * 2;
                this.f5323d = i11;
                this.f5330k = false;
                this.f5329j = length - 1;
                this.f5327h = Arrays.copyOf(this.f5327h, i11);
                this.f5325f = Arrays.copyOf(this.f5325f, this.f5323d);
                this.f5326g = Arrays.copyOf(this.f5326g, this.f5323d);
            }
            this.f5325f[length] = iVar.f5378c;
            this.f5327h[length] = f3;
            if (i5 != -1) {
                int[] iArr8 = this.f5326g;
                iArr8[length] = iArr8[i5];
                iArr8[i5] = length;
            } else {
                this.f5326g[length] = this.f5328i;
                this.f5328i = length;
            }
            iVar.f5388m++;
            iVar.a(this.f5321b);
            this.f5320a++;
            if (!this.f5330k) {
                this.f5329j++;
            }
            int i12 = this.f5329j;
            int[] iArr9 = this.f5325f;
            if (i12 >= iArr9.length) {
                this.f5330k = true;
                this.f5329j = iArr9.length - 1;
            }
        }
    }

    @Override // o.b.a
    public boolean c(i iVar) {
        int i3 = this.f5328i;
        if (i3 == -1) {
            return false;
        }
        for (int i4 = 0; i3 != -1 && i4 < this.f5320a; i4++) {
            if (this.f5325f[i3] == iVar.f5378c) {
                return true;
            }
            i3 = this.f5326g[i3];
        }
        return false;
    }

    @Override // o.b.a
    public final void clear() {
        int i3 = this.f5328i;
        for (int i4 = 0; i3 != -1 && i4 < this.f5320a; i4++) {
            i iVar = this.f5322c.f5340d[this.f5325f[i3]];
            if (iVar != null) {
                iVar.c(this.f5321b);
            }
            i3 = this.f5326g[i3];
        }
        this.f5328i = -1;
        this.f5329j = -1;
        this.f5330k = false;
        this.f5320a = 0;
    }

    @Override // o.b.a
    public float d(b bVar, boolean z2) {
        float f3 = f(bVar.f5331a);
        i(bVar.f5331a, z2);
        b.a aVar = bVar.f5335e;
        int iK = aVar.k();
        for (int i3 = 0; i3 < iK; i3++) {
            i iVarG = aVar.g(i3);
            b(iVarG, aVar.f(iVarG) * f3, z2);
        }
        return f3;
    }

    @Override // o.b.a
    public final void e(i iVar, float f3) {
        if (f3 == 0.0f) {
            i(iVar, true);
            return;
        }
        int i3 = this.f5328i;
        if (i3 == -1) {
            this.f5328i = 0;
            this.f5327h[0] = f3;
            this.f5325f[0] = iVar.f5378c;
            this.f5326g[0] = -1;
            iVar.f5388m++;
            iVar.a(this.f5321b);
            this.f5320a++;
            if (this.f5330k) {
                return;
            }
            int i4 = this.f5329j + 1;
            this.f5329j = i4;
            int[] iArr = this.f5325f;
            if (i4 >= iArr.length) {
                this.f5330k = true;
                this.f5329j = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i3 != -1 && i6 < this.f5320a; i6++) {
            int[] iArr2 = this.f5325f;
            int i7 = iArr2[i3];
            int i8 = iVar.f5378c;
            if (i7 == i8) {
                this.f5327h[i3] = f3;
                return;
            }
            if (iArr2[i3] < i8) {
                i5 = i3;
            }
            i3 = this.f5326g[i3];
        }
        int length = this.f5329j;
        int i9 = length + 1;
        if (this.f5330k) {
            int[] iArr3 = this.f5325f;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i9;
        }
        int[] iArr4 = this.f5325f;
        if (length >= iArr4.length && this.f5320a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f5325f;
                if (i10 >= iArr5.length) {
                    break;
                }
                if (iArr5[i10] == -1) {
                    length = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr6 = this.f5325f;
        if (length >= iArr6.length) {
            length = iArr6.length;
            int i11 = this.f5323d * 2;
            this.f5323d = i11;
            this.f5330k = false;
            this.f5329j = length - 1;
            this.f5327h = Arrays.copyOf(this.f5327h, i11);
            this.f5325f = Arrays.copyOf(this.f5325f, this.f5323d);
            this.f5326g = Arrays.copyOf(this.f5326g, this.f5323d);
        }
        this.f5325f[length] = iVar.f5378c;
        this.f5327h[length] = f3;
        if (i5 != -1) {
            int[] iArr7 = this.f5326g;
            iArr7[length] = iArr7[i5];
            iArr7[i5] = length;
        } else {
            this.f5326g[length] = this.f5328i;
            this.f5328i = length;
        }
        iVar.f5388m++;
        iVar.a(this.f5321b);
        int i12 = this.f5320a + 1;
        this.f5320a = i12;
        if (!this.f5330k) {
            this.f5329j++;
        }
        int[] iArr8 = this.f5325f;
        if (i12 >= iArr8.length) {
            this.f5330k = true;
        }
        if (this.f5329j >= iArr8.length) {
            this.f5330k = true;
            this.f5329j = iArr8.length - 1;
        }
    }

    @Override // o.b.a
    public final float f(i iVar) {
        int i3 = this.f5328i;
        for (int i4 = 0; i3 != -1 && i4 < this.f5320a; i4++) {
            if (this.f5325f[i3] == iVar.f5378c) {
                return this.f5327h[i3];
            }
            i3 = this.f5326g[i3];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public i g(int i3) {
        int i4 = this.f5328i;
        for (int i5 = 0; i4 != -1 && i5 < this.f5320a; i5++) {
            if (i5 == i3) {
                return this.f5322c.f5340d[this.f5325f[i4]];
            }
            i4 = this.f5326g[i4];
        }
        return null;
    }

    @Override // o.b.a
    public void h(float f3) {
        int i3 = this.f5328i;
        for (int i4 = 0; i3 != -1 && i4 < this.f5320a; i4++) {
            float[] fArr = this.f5327h;
            fArr[i3] = fArr[i3] / f3;
            i3 = this.f5326g[i3];
        }
    }

    @Override // o.b.a
    public final float i(i iVar, boolean z2) {
        if (this.f5324e == iVar) {
            this.f5324e = null;
        }
        int i3 = this.f5328i;
        if (i3 == -1) {
            return 0.0f;
        }
        int i4 = 0;
        int i5 = -1;
        while (i3 != -1 && i4 < this.f5320a) {
            if (this.f5325f[i3] == iVar.f5378c) {
                if (i3 == this.f5328i) {
                    this.f5328i = this.f5326g[i3];
                } else {
                    int[] iArr = this.f5326g;
                    iArr[i5] = iArr[i3];
                }
                if (z2) {
                    iVar.c(this.f5321b);
                }
                iVar.f5388m--;
                this.f5320a--;
                this.f5325f[i3] = -1;
                if (this.f5330k) {
                    this.f5329j = i3;
                }
                return this.f5327h[i3];
            }
            i4++;
            i5 = i3;
            i3 = this.f5326g[i3];
        }
        return 0.0f;
    }

    @Override // o.b.a
    public void j() {
        int i3 = this.f5328i;
        for (int i4 = 0; i3 != -1 && i4 < this.f5320a; i4++) {
            float[] fArr = this.f5327h;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f5326g[i3];
        }
    }

    @Override // o.b.a
    public int k() {
        return this.f5320a;
    }

    public String toString() {
        int i3 = this.f5328i;
        String str = BuildConfig.FLAVOR;
        for (int i4 = 0; i3 != -1 && i4 < this.f5320a; i4++) {
            str = ((str + " -> ") + this.f5327h[i3] + " : ") + this.f5322c.f5340d[this.f5325f[i3]];
            i3 = this.f5326g[i3];
        }
        return str;
    }
}
