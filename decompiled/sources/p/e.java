package p;

import com.vivo.seckeysdk.BuildConfig;
import java.util.ArrayList;
import q.m;

/* JADX INFO: compiled from: ConstraintWidget.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static float f5526v0 = 0.5f;
    d I;
    public d[] J;
    protected ArrayList<d> K;
    private boolean[] L;
    public b[] M;
    public e N;
    int O;
    int P;
    public float Q;
    protected int R;
    protected int S;
    protected int T;
    int U;
    int V;
    protected int W;
    protected int X;
    int Y;
    protected int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected int f5528a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    float f5530b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q.c f5531c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    float f5532c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q.c f5533d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Object f5534d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f5536e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f5538f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private String f5540g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private String f5542h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    boolean f5544i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    boolean f5546j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    boolean f5548k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    boolean f5550l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    int f5552m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f5554n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    boolean f5556o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    boolean f5558p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float[] f5560q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    protected e[] f5562r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected e[] f5564s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    e f5566t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    e f5568u0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5573z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5527a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m[] f5529b = new m[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q.j f5535e = new q.j(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q.l f5537f = new q.l(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f5539g = {true, true};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f5541h = {0, 0, 0, 0};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f5543i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5545j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5547k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5549l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5551m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f5553n = new int[2];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5555o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5557p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f5559q = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5561r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5563s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f5565t = 1.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f5567u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    float f5569v = 1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int[] f5570w = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f5571x = 0.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f5572y = false;
    private boolean A = false;
    public d B = new d(this, d.b.LEFT);
    public d C = new d(this, d.b.TOP);
    public d D = new d(this, d.b.RIGHT);
    public d E = new d(this, d.b.BOTTOM);
    d F = new d(this, d.b.BASELINE);
    d G = new d(this, d.b.CENTER_X);
    d H = new d(this, d.b.CENTER_Y);

    /* JADX INFO: compiled from: ConstraintWidget.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f5575b;

        static {
            int[] iArr = new int[b.values().length];
            f5575b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5575b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5575b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5575b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f5574a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5574a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5574a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5574a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5574a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5574a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5574a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5574a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f5574a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: ConstraintWidget.java */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.I = dVar;
        this.J = new d[]{this.B, this.D, this.C, this.E, this.F, dVar};
        this.K = new ArrayList<>();
        this.L = new boolean[2];
        b bVar = b.FIXED;
        this.M = new b[]{bVar, bVar};
        this.N = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f3 = f5526v0;
        this.f5530b0 = f3;
        this.f5532c0 = f3;
        this.f5536e0 = 0;
        this.f5538f0 = 0;
        this.f5540g0 = null;
        this.f5542h0 = null;
        this.f5548k0 = false;
        this.f5550l0 = false;
        this.f5552m0 = 0;
        this.f5554n0 = 0;
        this.f5560q0 = new float[]{-1.0f, -1.0f};
        this.f5562r0 = new e[]{null, null};
        this.f5564s0 = new e[]{null, null};
        this.f5566t0 = null;
        this.f5568u0 = null;
        d();
    }

    private boolean S(int i3) {
        int i4 = i3 * 2;
        d[] dVarArr = this.J;
        if (dVarArr[i4].f5511d != null && dVarArr[i4].f5511d.f5511d != dVarArr[i4]) {
            int i5 = i4 + 1;
            if (dVarArr[i5].f5511d != null && dVarArr[i5].f5511d.f5511d == dVarArr[i5]) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        this.K.add(this.B);
        this.K.add(this.C);
        this.K.add(this.D);
        this.K.add(this.E);
        this.K.add(this.G);
        this.K.add(this.H);
        this.K.add(this.I);
        this.K.add(this.F);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0177  */
    /* JADX WARN: Code duplicated, block: B:103:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:160:0x0286  */
    /* JADX WARN: Code duplicated, block: B:161:0x028a  */
    /* JADX WARN: Code duplicated, block: B:183:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:185:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:187:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:188:0x0302  */
    /* JADX WARN: Code duplicated, block: B:190:0x032f  */
    /* JADX WARN: Code duplicated, block: B:193:0x0343 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:194:0x0344 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:195:0x0346  */
    /* JADX WARN: Code duplicated, block: B:203:0x0359  */
    /* JADX WARN: Code duplicated, block: B:206:0x0373  */
    /* JADX WARN: Code duplicated, block: B:214:0x038b  */
    /* JADX WARN: Code duplicated, block: B:216:0x0393  */
    /* JADX WARN: Code duplicated, block: B:227:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:232:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:234:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:235:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:247:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:249:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:250:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:252:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:253:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:262:0x0407  */
    /* JADX WARN: Code duplicated, block: B:273:0x0429 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:275:0x0437 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:27:0x0077  */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    /* JADX WARN: Code duplicated, block: B:294:0x046b  */
    /* JADX WARN: Code duplicated, block: B:302:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:34:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:0x009b  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:73:0x0106  */
    /* JADX WARN: Code duplicated, block: B:75:0x0111  */
    /* JADX WARN: Code duplicated, block: B:79:0x0118  */
    /* JADX WARN: Code duplicated, block: B:81:0x011b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0121  */
    /* JADX WARN: Code duplicated, block: B:84:0x0128  */
    /* JADX WARN: Code duplicated, block: B:87:0x012d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x012f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0135  */
    /* JADX WARN: Code duplicated, block: B:91:0x013d  */
    /* JADX WARN: Code duplicated, block: B:93:0x014a  */
    /* JADX WARN: Code duplicated, block: B:95:0x014d  */
    private void h(o.d dVar, boolean z2, boolean z3, boolean z4, boolean z5, o.i iVar, o.i iVar2, b bVar, boolean z6, d dVar2, d dVar3, int i3, int i4, int i5, int i6, float f3, boolean z7, boolean z8, boolean z9, boolean z10, int i7, int i8, int i9, int i10, float f4, boolean z11) {
        int i11;
        boolean z12;
        int iMin;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z13;
        d.b bVarG;
        d.b bVar2;
        o.i iVarQ;
        o.i iVarQ2;
        boolean z14;
        int i18;
        char c3;
        char c4;
        d dVar4;
        boolean z15;
        boolean z16;
        boolean z17;
        int i19;
        boolean z18;
        int i20;
        boolean z19;
        boolean z20;
        o.i iVar3;
        boolean z21;
        int i21;
        int i22;
        o.i iVar4;
        e eVar;
        o.i iVar5;
        int iMax;
        int i23;
        boolean z22;
        int i24;
        int i25;
        int iB;
        int iMin2;
        int i26;
        int i27;
        int i28;
        boolean z23;
        int i29;
        int i30;
        int i31;
        int i32;
        boolean z24;
        o.i iVarQ3 = dVar.q(dVar2);
        o.i iVarQ4 = dVar.q(dVar3);
        o.i iVarQ5 = dVar.q(dVar2.f());
        o.i iVarQ6 = dVar.q(dVar3.f());
        o.d.w();
        boolean zI = dVar2.i();
        boolean zI2 = dVar3.i();
        boolean zI3 = this.I.i();
        int i33 = zI2 ? (zI ? 1 : 0) + 1 : zI ? 1 : 0;
        if (zI3) {
            i33++;
        }
        int i34 = z7 ? 3 : i7;
        int i35 = a.f5575b[bVar.ordinal()];
        if (i35 != 1 && i35 != 2 && i35 != 3 && i35 == 4) {
            i11 = i34;
            if (i11 != 4) {
                z12 = true;
            }
            if (this.f5538f0 == 8) {
                iMin = 0;
                z12 = false;
            } else {
                iMin = i4;
            }
            if (!z11) {
                if (zI && !zI2 && !zI3) {
                    dVar.f(iVarQ3, i3);
                } else if (zI && !zI2) {
                    i12 = 8;
                    dVar.e(iVarQ3, iVarQ5, dVar2.b(), 8);
                }
                i12 = 8;
            } else {
                i12 = 8;
            }
            if (!z12) {
                if (i33 == 2 && !z7 && (i11 == 1 || i11 == 0)) {
                    int iMax2 = Math.max(i9, iMin);
                    if (i10 > 0) {
                        iMax2 = Math.min(i10, iMax2);
                    }
                    dVar.e(iVarQ4, iVarQ3, iMax2, 8);
                    i17 = i9;
                    i14 = i10;
                    iVarQ5 = iVarQ5;
                    iVarQ4 = iVarQ4;
                    z13 = false;
                    i16 = i33;
                } else {
                    if (i9 == -2) {
                        i13 = iMin;
                    } else {
                        i13 = i9;
                    }
                    if (i10 == -2) {
                        i14 = iMin;
                    } else {
                        i14 = i10;
                    }
                    if (iMin > 0 && i11 != 1) {
                        iMin = 0;
                    }
                    if (i13 > 0) {
                        dVar.h(iVarQ4, iVarQ3, i13, 8);
                        iMin = Math.max(iMin, i13);
                    }
                    if (i14 > 0) {
                        if (z3 || i11 != 1) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z14) {
                            i15 = 8;
                            dVar.j(iVarQ4, iVarQ3, i14, 8);
                        } else {
                            i15 = 8;
                        }
                        iMin = Math.min(iMin, i14);
                    } else {
                        i15 = 8;
                    }
                    if (i11 == 1) {
                        if (z3) {
                            dVar.e(iVarQ4, iVarQ3, iMin, i15);
                        } else if (z8) {
                            dVar.e(iVarQ4, iVarQ3, iMin, 5);
                            dVar.j(iVarQ4, iVarQ3, iMin, i15);
                        } else {
                            dVar.e(iVarQ4, iVarQ3, iMin, 5);
                            dVar.j(iVarQ4, iVarQ3, iMin, i15);
                        }
                        i17 = i13;
                    } else if (i11 == 2) {
                        bVarG = dVar2.g();
                        bVar2 = d.b.TOP;
                        if (bVarG != bVar2 || dVar2.g() == d.b.BOTTOM) {
                            iVarQ = dVar.q(this.N.k(bVar2));
                            iVarQ2 = dVar.q(this.N.k(d.b.BOTTOM));
                        } else {
                            iVarQ = dVar.q(this.N.k(d.b.LEFT));
                            iVarQ2 = dVar.q(this.N.k(d.b.RIGHT));
                        }
                        o.i iVar6 = iVarQ;
                        o.b bVarR = dVar.r();
                        int i36 = i13;
                        iVarQ6 = iVarQ6;
                        iVarQ5 = iVarQ5;
                        i16 = i33 == true ? 1 : 0;
                        iVarQ4 = iVarQ4;
                        dVar.d(bVarR.k(iVarQ4, iVarQ3, iVarQ2, iVar6, f4));
                        z5 = z5;
                        i17 = i36;
                        z13 = false;
                    } else {
                        iVarQ5 = iVarQ5;
                        iVarQ4 = iVarQ4;
                        int i37 = i13;
                        iVarQ6 = iVarQ6;
                        i16 = i33;
                        i17 = i37;
                        z13 = z12;
                        z5 = true;
                    }
                }
                if (z11 || z8) {
                    i18 = 8;
                    c3 = 2;
                    c4 = 1;
                    if (i16 >= c3 && z3 && z5) {
                        dVar.h(iVarQ3, iVar, 0, i18);
                        char c5 = (z2 || this.F.f5511d == null) ? c4 : (char) 0;
                        if (z2 || (dVar4 = this.F.f5511d) == null) {
                            c4 = c5;
                        } else {
                            e eVar2 = dVar4.f5509b;
                            if (eVar2.Q != 0.0f) {
                                b[] bVarArr = eVar2.M;
                                b bVar3 = bVarArr[0];
                                b bVar4 = b.MATCH_CONSTRAINT;
                                if (bVar3 != bVar4 || bVarArr[c4] != bVar4) {
                                    c4 = 0;
                                }
                            } else {
                                c4 = 0;
                            }
                        }
                        if (c4 != 0) {
                            dVar.h(iVar2, iVarQ4, 0, i18);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((zI || zI2 || zI3) && (!zI || zI2)) {
                    if (!zI && zI2) {
                        dVar.e(iVarQ4, iVarQ6, -dVar3.b(), 8);
                        if (z3) {
                            dVar.h(iVarQ3, iVar, 0, 5);
                        }
                    } else if (zI && zI2) {
                        e eVar3 = dVar2.f5511d.f5509b;
                        e eVar4 = dVar3.f5511d.f5509b;
                        e eVarE = E();
                        int i38 = 6;
                        if (z13) {
                            if (i11 == 0) {
                                if (i14 == 0 && i17 == 0) {
                                    z24 = false;
                                    i31 = 8;
                                    i32 = 8;
                                    z18 = true;
                                } else {
                                    z18 = false;
                                    i31 = 5;
                                    i32 = 5;
                                    z24 = true;
                                }
                                if ((eVar3 instanceof p.a) || (eVar4 instanceof p.a)) {
                                    i20 = i31;
                                    z17 = z24;
                                    z16 = false;
                                    z15 = true;
                                    i19 = 4;
                                } else {
                                    i20 = i31;
                                    i38 = 6;
                                    z17 = z24;
                                    z16 = false;
                                    z15 = true;
                                    i19 = i32;
                                }
                            } else if (i11 == 1) {
                                i20 = 8;
                                i38 = 6;
                                z16 = true;
                                z15 = true;
                                i19 = 4;
                                z18 = false;
                                z17 = true;
                            } else if (i11 != 3) {
                                z15 = true;
                                z16 = false;
                                i19 = 4;
                                z18 = false;
                                z17 = false;
                            } else if (this.f5567u == -1) {
                                if (z9) {
                                    i38 = z3 ? 5 : 4;
                                } else {
                                    i38 = 8;
                                }
                                z16 = true;
                                z15 = true;
                                i19 = 5;
                                z18 = true;
                                z17 = true;
                                i20 = 8;
                            } else if (z7) {
                                if (i8 != 2) {
                                    z15 = true;
                                    if (i8 != 1) {
                                        z23 = false;
                                    }
                                    if (z23) {
                                        i29 = 5;
                                        i30 = 4;
                                    } else {
                                        i29 = 8;
                                        i30 = 5;
                                    }
                                    i20 = i29;
                                    i19 = i30;
                                    z16 = z15;
                                    z18 = z16;
                                    z17 = z18;
                                    i38 = 6;
                                } else {
                                    z15 = true;
                                }
                                z23 = z15;
                                if (z23) {
                                    i29 = 8;
                                    i30 = 5;
                                } else {
                                    i29 = 5;
                                    i30 = 4;
                                }
                                i20 = i29;
                                i19 = i30;
                                z16 = z15;
                                z18 = z16;
                                z17 = z18;
                                i38 = 6;
                            } else {
                                z15 = true;
                                if (i14 > 0) {
                                    z16 = true;
                                    z18 = true;
                                    z17 = true;
                                    i19 = 5;
                                } else if (i14 != 0 || i17 != 0) {
                                    z16 = true;
                                    z18 = true;
                                    z17 = true;
                                    i19 = 4;
                                } else if (z9) {
                                    i20 = (eVar3 == eVarE || eVar4 == eVarE) ? 5 : 4;
                                    z16 = true;
                                    z18 = true;
                                    z17 = true;
                                    i19 = 4;
                                } else {
                                    z16 = true;
                                    z18 = true;
                                    z17 = true;
                                    i19 = 8;
                                }
                            }
                            if (z16 || iVarQ5 != iVarQ6 || eVar3 == eVarE) {
                                z19 = z16;
                                z20 = z15;
                            } else {
                                z19 = false;
                                z20 = false;
                            }
                            if (z17) {
                                if (this.f5538f0 == 8) {
                                    i28 = 4;
                                } else {
                                    i28 = i38;
                                }
                                iVar3 = iVarQ4;
                                i22 = 4;
                                z21 = true;
                                i21 = 8;
                                dVar.c(iVarQ3, iVarQ5, dVar2.b(), f3, iVarQ6, iVar3, dVar3.b(), i28);
                            } else {
                                iVar3 = iVarQ4;
                                z21 = z15;
                                i21 = 8;
                                i22 = 4;
                            }
                            if (this.f5538f0 == i21) {
                                return;
                            }
                            if (z19) {
                                if (z3 || iVarQ5 == iVarQ6 || z13) {
                                    eVar = eVar3;
                                } else {
                                    eVar = eVar3;
                                    if ((eVar instanceof p.a) || (eVar4 instanceof p.a)) {
                                        i27 = 6;
                                    }
                                    iVar5 = iVarQ3;
                                    dVar.h(iVar5, iVarQ5, dVar2.b(), i27);
                                    iVar4 = iVar3;
                                    dVar.j(iVar4, iVarQ6, -dVar3.b(), i27);
                                    i20 = i27;
                                }
                                i27 = i20;
                                iVar5 = iVarQ3;
                                dVar.h(iVar5, iVarQ5, dVar2.b(), i27);
                                iVar4 = iVar3;
                                dVar.j(iVar4, iVarQ6, -dVar3.b(), i27);
                                i20 = i27;
                            } else {
                                iVar4 = iVar3;
                                eVar = eVar3;
                                iVar5 = iVarQ3;
                            }
                            if (z3 || !z10 || (eVar instanceof p.a) || (eVar4 instanceof p.a)) {
                                iMax = i19;
                                i23 = i20;
                                z22 = z20;
                            } else {
                                iMax = 6;
                                i23 = 6;
                                z22 = z21;
                            }
                            if (z22) {
                                if (z18 && (!z9 || z4)) {
                                    if (eVar != eVarE && eVar4 != eVarE) {
                                        i38 = iMax;
                                    }
                                    if ((eVar instanceof g) || (eVar4 instanceof g)) {
                                        i38 = 5;
                                    }
                                    if ((eVar instanceof p.a) || (eVar4 instanceof p.a)) {
                                        i38 = 5;
                                    }
                                    if (z9) {
                                        i26 = 5;
                                    } else {
                                        i26 = i38;
                                    }
                                    iMax = Math.max(i26, iMax);
                                }
                                iMin2 = iMax;
                                if (z3) {
                                    iMin2 = Math.min(i23, iMin2);
                                    if (z7 && !z9 && (eVar == eVarE || eVar4 == eVarE)) {
                                        iMin2 = i22;
                                    }
                                }
                                dVar.e(iVar5, iVarQ5, dVar2.b(), iMin2);
                                dVar.e(iVar4, iVarQ6, -dVar3.b(), iMin2);
                            }
                            if (z3) {
                                i24 = i21;
                                if (iVar == iVarQ5) {
                                    iB = dVar2.b();
                                } else {
                                    iB = 0;
                                }
                                if (iVarQ5 != iVar) {
                                    dVar.h(iVar5, iVar, iB, 5);
                                }
                            } else {
                                i24 = i21;
                            }
                            if (z3 && z13 && i5 == 0 && i17 == 0) {
                                if (z13 || i25 != 3) {
                                    i25 = i11;
                                    dVar.h(iVar4, iVar5, 0, 5);
                                } else {
                                    dVar.h(iVar4, iVar5, 0, i24);
                                }
                            }
                        } else {
                            z15 = true;
                            z16 = true;
                            z17 = true;
                            i19 = 4;
                            z18 = false;
                        }
                        i20 = 5;
                        if (z16) {
                            z19 = z16;
                            z20 = z15;
                        } else {
                            z19 = z16;
                            z20 = z15;
                        }
                        if (z17) {
                            if (this.f5538f0 == 8) {
                                i28 = 4;
                            } else {
                                i28 = i38;
                            }
                            iVar3 = iVarQ4;
                            i22 = 4;
                            z21 = true;
                            i21 = 8;
                            dVar.c(iVarQ3, iVarQ5, dVar2.b(), f3, iVarQ6, iVar3, dVar3.b(), i28);
                        } else {
                            iVar3 = iVarQ4;
                            z21 = z15;
                            i21 = 8;
                            i22 = 4;
                        }
                        if (this.f5538f0 == i21) {
                            return;
                        }
                        if (z19) {
                            if (z3) {
                                eVar = eVar3;
                                i27 = i20;
                            } else {
                                eVar = eVar3;
                                i27 = i20;
                            }
                            iVar5 = iVarQ3;
                            dVar.h(iVar5, iVarQ5, dVar2.b(), i27);
                            iVar4 = iVar3;
                            dVar.j(iVar4, iVarQ6, -dVar3.b(), i27);
                            i20 = i27;
                        } else {
                            iVar4 = iVar3;
                            eVar = eVar3;
                            iVar5 = iVarQ3;
                        }
                        if (z3) {
                            iMax = i19;
                            i23 = i20;
                            z22 = z20;
                        } else {
                            iMax = i19;
                            i23 = i20;
                            z22 = z20;
                        }
                        if (z22) {
                            if (z18) {
                                if (eVar != eVarE) {
                                    i38 = iMax;
                                }
                                if (eVar instanceof g) {
                                    i38 = 5;
                                } else {
                                    i38 = 5;
                                }
                                if (eVar instanceof p.a) {
                                    i38 = 5;
                                } else {
                                    i38 = 5;
                                }
                                if (z9) {
                                    i26 = 5;
                                } else {
                                    i26 = i38;
                                }
                                iMax = Math.max(i26, iMax);
                            }
                            iMin2 = iMax;
                            if (z3) {
                                iMin2 = Math.min(i23, iMin2);
                                if (z7) {
                                    iMin2 = i22;
                                }
                            }
                            dVar.e(iVar5, iVarQ5, dVar2.b(), iMin2);
                            dVar.e(iVar4, iVarQ6, -dVar3.b(), iMin2);
                        }
                        if (z3) {
                            i24 = i21;
                            if (iVar == iVarQ5) {
                                iB = dVar2.b();
                            } else {
                                iB = 0;
                            }
                            if (iVarQ5 != iVar) {
                                dVar.h(iVar5, iVar, iB, 5);
                            }
                        } else {
                            i24 = i21;
                        }
                        if (z3) {
                            if (z13) {
                                i25 = i11;
                                dVar.h(iVar4, iVar5, 0, 5);
                            } else {
                                i25 = i11;
                                dVar.h(iVar4, iVar5, 0, 5);
                            }
                        }
                    }
                    iVar4 = iVarQ4;
                } else {
                    iVar4 = iVarQ4;
                }
                if (!z3) {
                    i25 = i11;
                    return;
                }
                if (z5) {
                    int iB2 = dVar3.f5511d != null ? dVar3.b() : 0;
                    if (iVarQ6 != iVar2) {
                        dVar.h(iVar2, iVar4, iB2, 5);
                        return;
                    }
                    return;
                }
                return;
            }
            if (z6) {
                dVar.e(iVarQ4, iVarQ3, 0, 3);
                if (i5 > 0) {
                    dVar.h(iVarQ4, iVarQ3, i5, 8);
                }
                if (i6 < Integer.MAX_VALUE) {
                    dVar.j(iVarQ4, iVarQ3, i6, 8);
                }
            } else {
                dVar.e(iVarQ4, iVarQ3, iMin, i12);
            }
            i17 = i9;
            i14 = i10;
            z13 = z12;
            i16 = i33;
            if (z11) {
                i18 = 8;
                c3 = 2;
                c4 = 1;
            } else {
                i18 = 8;
                c3 = 2;
                c4 = 1;
            }
            if (i16 >= c3) {
            }
        }
        i11 = i34;
        z12 = false;
        if (this.f5538f0 == 8) {
            iMin = 0;
            z12 = false;
        } else {
            iMin = i4;
        }
        if (!z11) {
            i12 = 8;
        } else if (zI) {
            if (zI) {
                i12 = 8;
            } else {
                i12 = 8;
            }
        } else if (zI) {
            i12 = 8;
        } else {
            i12 = 8;
        }
        if (!z12) {
            if (i33 == 2) {
            }
            if (i9 == -2) {
                i13 = iMin;
            } else {
                i13 = i9;
            }
            if (i10 == -2) {
                i14 = iMin;
            } else {
                i14 = i10;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i13 > 0) {
                dVar.h(iVarQ4, iVarQ3, i13, 8);
                iMin = Math.max(iMin, i13);
            }
            if (i14 > 0) {
                if (z3) {
                    z14 = true;
                } else {
                    z14 = true;
                }
                if (z14) {
                    i15 = 8;
                    dVar.j(iVarQ4, iVarQ3, i14, 8);
                } else {
                    i15 = 8;
                }
                iMin = Math.min(iMin, i14);
            } else {
                i15 = 8;
            }
            if (i11 == 1) {
                if (z3) {
                    dVar.e(iVarQ4, iVarQ3, iMin, i15);
                } else if (z8) {
                    dVar.e(iVarQ4, iVarQ3, iMin, 5);
                    dVar.j(iVarQ4, iVarQ3, iMin, i15);
                } else {
                    dVar.e(iVarQ4, iVarQ3, iMin, 5);
                    dVar.j(iVarQ4, iVarQ3, iMin, i15);
                }
                i17 = i13;
            } else if (i11 == 2) {
                bVarG = dVar2.g();
                bVar2 = d.b.TOP;
                if (bVarG != bVar2) {
                    iVarQ = dVar.q(this.N.k(bVar2));
                    iVarQ2 = dVar.q(this.N.k(d.b.BOTTOM));
                } else {
                    iVarQ = dVar.q(this.N.k(bVar2));
                    iVarQ2 = dVar.q(this.N.k(d.b.BOTTOM));
                }
                o.i iVar7 = iVarQ;
                o.b bVarR2 = dVar.r();
                int i39 = i13;
                iVarQ6 = iVarQ6;
                iVarQ5 = iVarQ5;
                i16 = i33 == true ? 1 : 0;
                iVarQ4 = iVarQ4;
                dVar.d(bVarR2.k(iVarQ4, iVarQ3, iVarQ2, iVar7, f4));
                z5 = z5;
                i17 = i39;
                z13 = false;
            } else {
                iVarQ5 = iVarQ5;
                iVarQ4 = iVarQ4;
                int i310 = i13;
                iVarQ6 = iVarQ6;
                i16 = i33;
                i17 = i310;
                z13 = z12;
                z5 = true;
            }
            if (z11) {
                i18 = 8;
                c3 = 2;
                c4 = 1;
            } else {
                i18 = 8;
                c3 = 2;
                c4 = 1;
            }
            if (i16 >= c3) {
            }
        }
        if (z6) {
            dVar.e(iVarQ4, iVarQ3, 0, 3);
            if (i5 > 0) {
                dVar.h(iVarQ4, iVarQ3, i5, 8);
            }
            if (i6 < Integer.MAX_VALUE) {
                dVar.j(iVarQ4, iVarQ3, i6, 8);
            }
        } else {
            dVar.e(iVarQ4, iVarQ3, iMin, i12);
        }
        i17 = i9;
        i14 = i10;
        z13 = z12;
        i16 = i33;
        if (z11) {
            i18 = 8;
            c3 = 2;
            c4 = 1;
        } else {
            i18 = 8;
            c3 = 2;
            c4 = 1;
        }
        if (i16 >= c3) {
        }
    }

    public int A() {
        return this.f5570w[0];
    }

    public void A0(int i3) {
        this.f5538f0 = i3;
    }

    public int B() {
        return this.f5528a0;
    }

    public void B0(int i3) {
        this.O = i3;
        int i4 = this.Z;
        if (i3 < i4) {
            this.O = i4;
        }
    }

    public int C() {
        return this.Z;
    }

    public void C0(int i3) {
        this.S = i3;
    }

    public e D(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.E).f5511d) != null && dVar2.f5511d == dVar) {
                return dVar2.f5509b;
            }
            return null;
        }
        d dVar3 = this.D;
        d dVar4 = dVar3.f5511d;
        if (dVar4 == null || dVar4.f5511d != dVar3) {
            return null;
        }
        return dVar4.f5509b;
    }

    public void D0(int i3) {
        this.T = i3;
    }

    public e E() {
        return this.N;
    }

    public void E0(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.f5567u == -1) {
            if (z4 && !z5) {
                this.f5567u = 0;
            } else if (!z4 && z5) {
                this.f5567u = 1;
                if (this.R == -1) {
                    this.f5569v = 1.0f / this.f5569v;
                }
            }
        }
        if (this.f5567u == 0 && (!this.C.i() || !this.E.i())) {
            this.f5567u = 1;
        } else if (this.f5567u == 1 && (!this.B.i() || !this.D.i())) {
            this.f5567u = 0;
        }
        if (this.f5567u == -1 && (!this.C.i() || !this.E.i() || !this.B.i() || !this.D.i())) {
            if (this.C.i() && this.E.i()) {
                this.f5567u = 0;
            } else if (this.B.i() && this.D.i()) {
                this.f5569v = 1.0f / this.f5569v;
                this.f5567u = 1;
            }
        }
        if (this.f5567u == -1) {
            int i3 = this.f5555o;
            if (i3 > 0 && this.f5561r == 0) {
                this.f5567u = 0;
            } else {
                if (i3 != 0 || this.f5561r <= 0) {
                    return;
                }
                this.f5569v = 1.0f / this.f5569v;
                this.f5567u = 1;
            }
        }
    }

    public e F(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.C).f5511d) != null && dVar2.f5511d == dVar) {
                return dVar2.f5509b;
            }
            return null;
        }
        d dVar3 = this.B;
        d dVar4 = dVar3.f5511d;
        if (dVar4 == null || dVar4.f5511d != dVar3) {
            return null;
        }
        return dVar4.f5509b;
    }

    public void F0(boolean z2, boolean z3) {
        int i3;
        int i4;
        boolean zK = z2 & this.f5535e.k();
        boolean zK2 = z3 & this.f5537f.k();
        q.j jVar = this.f5535e;
        int i5 = jVar.f5845h.f5809g;
        q.l lVar = this.f5537f;
        int i6 = lVar.f5845h.f5809g;
        int i7 = jVar.f5846i.f5809g;
        int i8 = lVar.f5846i.f5809g;
        int i9 = i8 - i6;
        if (i7 - i5 < 0 || i9 < 0 || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE) {
            i7 = 0;
            i5 = 0;
            i8 = 0;
            i6 = 0;
        }
        int i10 = i7 - i5;
        int i11 = i8 - i6;
        if (zK) {
            this.S = i5;
        }
        if (zK2) {
            this.T = i6;
        }
        if (this.f5538f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        if (zK) {
            if (this.M[0] == b.FIXED && i10 < (i4 = this.O)) {
                i10 = i4;
            }
            this.O = i10;
            int i12 = this.Z;
            if (i10 < i12) {
                this.O = i12;
            }
        }
        if (zK2) {
            if (this.M[1] == b.FIXED && i11 < (i3 = this.P)) {
                i11 = i3;
            }
            this.P = i11;
            int i13 = this.f5528a0;
            if (i11 < i13) {
                this.P = i13;
            }
        }
    }

    public int G() {
        return O() + this.O;
    }

    public void G0(o.d dVar) {
        int iX = dVar.x(this.B);
        int iX2 = dVar.x(this.C);
        int iX3 = dVar.x(this.D);
        int iX4 = dVar.x(this.E);
        q.j jVar = this.f5535e;
        q.f fVar = jVar.f5845h;
        if (fVar.f5812j) {
            q.f fVar2 = jVar.f5846i;
            if (fVar2.f5812j) {
                iX = fVar.f5809g;
                iX3 = fVar2.f5809g;
            }
        }
        q.l lVar = this.f5537f;
        q.f fVar3 = lVar.f5845h;
        if (fVar3.f5812j) {
            q.f fVar4 = lVar.f5846i;
            if (fVar4.f5812j) {
                iX2 = fVar3.f5809g;
                iX4 = fVar4.f5809g;
            }
        }
        int i3 = iX4 - iX2;
        if (iX3 - iX < 0 || i3 < 0 || iX == Integer.MIN_VALUE || iX == Integer.MAX_VALUE || iX2 == Integer.MIN_VALUE || iX2 == Integer.MAX_VALUE || iX3 == Integer.MIN_VALUE || iX3 == Integer.MAX_VALUE || iX4 == Integer.MIN_VALUE || iX4 == Integer.MAX_VALUE) {
            iX4 = 0;
            iX = 0;
            iX2 = 0;
            iX3 = 0;
        }
        c0(iX, iX2, iX3, iX4);
    }

    public m H(int i3) {
        if (i3 == 0) {
            return this.f5535e;
        }
        if (i3 == 1) {
            return this.f5537f;
        }
        return null;
    }

    public float I() {
        return this.f5532c0;
    }

    public int J() {
        return this.f5554n0;
    }

    public b K() {
        return this.M[1];
    }

    public int L() {
        int i3 = this.B != null ? 0 + this.C.f5512e : 0;
        return this.D != null ? i3 + this.E.f5512e : i3;
    }

    public int M() {
        return this.f5538f0;
    }

    public int N() {
        if (this.f5538f0 == 8) {
            return 0;
        }
        return this.O;
    }

    public int O() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.S : ((f) eVar).C0 + this.S;
    }

    public int P() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.T : ((f) eVar).D0 + this.T;
    }

    public boolean Q() {
        return this.f5572y;
    }

    public void R(d.b bVar, e eVar, d.b bVar2, int i3, int i4) {
        k(bVar).a(eVar.k(bVar2), i3, i4, true);
    }

    public boolean T() {
        d dVar = this.B;
        d dVar2 = dVar.f5511d;
        if (dVar2 != null && dVar2.f5511d == dVar) {
            return true;
        }
        d dVar3 = this.D;
        d dVar4 = dVar3.f5511d;
        return dVar4 != null && dVar4.f5511d == dVar3;
    }

    public boolean U() {
        return this.f5573z;
    }

    public boolean V() {
        d dVar = this.C;
        d dVar2 = dVar.f5511d;
        if (dVar2 != null && dVar2.f5511d == dVar) {
            return true;
        }
        d dVar3 = this.E;
        d dVar4 = dVar3.f5511d;
        return dVar4 != null && dVar4.f5511d == dVar3;
    }

    public void W() {
        this.B.k();
        this.C.k();
        this.D.k();
        this.E.k();
        this.F.k();
        this.G.k();
        this.H.k();
        this.I.k();
        this.N = null;
        this.f5571x = 0.0f;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f5528a0 = 0;
        float f3 = f5526v0;
        this.f5530b0 = f3;
        this.f5532c0 = f3;
        b[] bVarArr = this.M;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f5534d0 = null;
        this.f5536e0 = 0;
        this.f5538f0 = 0;
        this.f5542h0 = null;
        this.f5544i0 = false;
        this.f5546j0 = false;
        this.f5552m0 = 0;
        this.f5554n0 = 0;
        this.f5556o0 = false;
        this.f5558p0 = false;
        float[] fArr = this.f5560q0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f5545j = -1;
        this.f5547k = -1;
        int[] iArr = this.f5570w;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f5549l = 0;
        this.f5551m = 0;
        this.f5559q = 1.0f;
        this.f5565t = 1.0f;
        this.f5557p = Integer.MAX_VALUE;
        this.f5563s = Integer.MAX_VALUE;
        this.f5555o = 0;
        this.f5561r = 0;
        this.f5543i = false;
        this.f5567u = -1;
        this.f5569v = 1.0f;
        this.f5548k0 = false;
        this.f5550l0 = false;
        boolean[] zArr = this.f5539g;
        zArr[0] = true;
        zArr[1] = true;
        this.A = false;
        boolean[] zArr2 = this.L;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void X(o.c cVar) {
        this.B.l(cVar);
        this.C.l(cVar);
        this.D.l(cVar);
        this.E.l(cVar);
        this.F.l(cVar);
        this.I.l(cVar);
        this.G.l(cVar);
        this.H.l(cVar);
    }

    public void Y(int i3) {
        this.Y = i3;
        this.f5572y = i3 > 0;
    }

    public void Z(Object obj) {
        this.f5534d0 = obj;
    }

    public void a0(String str) {
        this.f5540g0 = str;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0084 A[PHI: r0
  0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:45:0x0084, B:35:0x007d, B:23:0x004f, B:25:0x0055, B:27:0x0061, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void b0(String str) {
        float fAbs;
        int i3 = 0;
        if (str == null || str.length() == 0) {
            this.Q = 0.0f;
            return;
        }
        int i4 = -1;
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i5 = 0;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (strSubstring.equalsIgnoreCase("W")) {
                i4 = 0;
            } else if (strSubstring.equalsIgnoreCase("H")) {
                i4 = 1;
            }
            i5 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i5);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = i3;
                }
            } else {
                String strSubstring3 = str.substring(i5, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = i3;
                } else {
                    float f3 = Float.parseFloat(strSubstring3);
                    float f4 = Float.parseFloat(strSubstring4);
                    if (f3 <= 0.0f || f4 <= 0.0f) {
                        fAbs = i3;
                    } else {
                        fAbs = i4 == 1 ? Math.abs(f4 / f3) : Math.abs(f3 / f4);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i3 = (fAbs > i3 ? 1 : (fAbs == i3 ? 0 : -1));
        if (i3 > 0) {
            this.Q = fAbs;
            this.R = i4;
        }
    }

    public void c0(int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i5 - i3;
        int i10 = i6 - i4;
        this.S = i3;
        this.T = i4;
        if (this.f5538f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        b[] bVarArr = this.M;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i9 < (i8 = this.O)) {
            i9 = i8;
        }
        if (bVarArr[1] == bVar2 && i10 < (i7 = this.P)) {
            i10 = i7;
        }
        this.O = i9;
        this.P = i10;
        int i11 = this.f5528a0;
        if (i10 < i11) {
            this.P = i11;
        }
        int i12 = this.Z;
        if (i9 < i12) {
            this.O = i12;
        }
    }

    public void d0(boolean z2) {
        this.f5572y = z2;
    }

    boolean e() {
        return (this instanceof k) || (this instanceof g);
    }

    public void e0(int i3) {
        this.P = i3;
        int i4 = this.f5528a0;
        if (i3 < i4) {
            this.P = i4;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12621. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void f(o.d r48) {
        /*
            Method dump skipped, instruction units count: 1262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p.e.f(o.d):void");
    }

    public void f0(float f3) {
        this.f5530b0 = f3;
    }

    public boolean g() {
        return this.f5538f0 != 8;
    }

    public void g0(int i3) {
        this.f5552m0 = i3;
    }

    public void h0(int i3, int i4) {
        this.S = i3;
        int i5 = i4 - i3;
        this.O = i5;
        int i6 = this.Z;
        if (i5 < i6) {
            this.O = i6;
        }
    }

    public void i(e eVar, float f3, int i3) {
        d.b bVar = d.b.CENTER;
        R(bVar, eVar, bVar, i3, 0);
        this.f5571x = f3;
    }

    public void i0(b bVar) {
        this.M[0] = bVar;
    }

    public void j(o.d dVar) {
        dVar.q(this.B);
        dVar.q(this.C);
        dVar.q(this.D);
        dVar.q(this.E);
        if (this.Y > 0) {
            dVar.q(this.F);
        }
    }

    public void j0(int i3, int i4, int i5, float f3) {
        this.f5549l = i3;
        this.f5555o = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.f5557p = i5;
        this.f5559q = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f5549l = 2;
    }

    public d k(d.b bVar) {
        switch (a.f5574a[bVar.ordinal()]) {
            case 1:
                return this.B;
            case 2:
                return this.C;
            case 3:
                return this.D;
            case 4:
                return this.E;
            case 5:
                return this.F;
            case 6:
                return this.I;
            case 7:
                return this.G;
            case 8:
                return this.H;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void k0(float f3) {
        this.f5560q0[0] = f3;
    }

    public int l() {
        return this.Y;
    }

    protected void l0(int i3, boolean z2) {
        this.L[i3] = z2;
    }

    public float m(int i3) {
        if (i3 == 0) {
            return this.f5530b0;
        }
        if (i3 == 1) {
            return this.f5532c0;
        }
        return -1.0f;
    }

    public void m0(boolean z2) {
        this.f5573z = z2;
    }

    public int n() {
        return P() + this.P;
    }

    public void n0(boolean z2) {
        this.A = z2;
    }

    public Object o() {
        return this.f5534d0;
    }

    public void o0(int i3) {
        this.f5570w[1] = i3;
    }

    public String p() {
        return this.f5540g0;
    }

    public void p0(int i3) {
        this.f5570w[0] = i3;
    }

    public b q(int i3) {
        if (i3 == 0) {
            return w();
        }
        if (i3 == 1) {
            return K();
        }
        return null;
    }

    public void q0(int i3) {
        if (i3 < 0) {
            this.f5528a0 = 0;
        } else {
            this.f5528a0 = i3;
        }
    }

    public float r() {
        return this.Q;
    }

    public void r0(int i3) {
        if (i3 < 0) {
            this.Z = 0;
        } else {
            this.Z = i3;
        }
    }

    public int s() {
        return this.R;
    }

    public void s0(int i3, int i4) {
        this.S = i3;
        this.T = i4;
    }

    public int t() {
        if (this.f5538f0 == 8) {
            return 0;
        }
        return this.P;
    }

    public void t0(e eVar) {
        this.N = eVar;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.f5542h0;
        String str3 = BuildConfig.FLAVOR;
        if (str2 != null) {
            str = "type: " + this.f5542h0 + " ";
        } else {
            str = BuildConfig.FLAVOR;
        }
        sb.append(str);
        if (this.f5540g0 != null) {
            str3 = "id: " + this.f5540g0 + " ";
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.S);
        sb.append(", ");
        sb.append(this.T);
        sb.append(") - (");
        sb.append(this.O);
        sb.append(" x ");
        sb.append(this.P);
        sb.append(")");
        return sb.toString();
    }

    public float u() {
        return this.f5530b0;
    }

    public void u0(float f3) {
        this.f5532c0 = f3;
    }

    public int v() {
        return this.f5552m0;
    }

    public void v0(int i3) {
        this.f5554n0 = i3;
    }

    public b w() {
        return this.M[0];
    }

    public void w0(int i3, int i4) {
        this.T = i3;
        int i5 = i4 - i3;
        this.P = i5;
        int i6 = this.f5528a0;
        if (i5 < i6) {
            this.P = i6;
        }
    }

    public int x() {
        d dVar = this.B;
        int i3 = dVar != null ? 0 + dVar.f5512e : 0;
        d dVar2 = this.D;
        return dVar2 != null ? i3 + dVar2.f5512e : i3;
    }

    public void x0(b bVar) {
        this.M[1] = bVar;
    }

    public int y(int i3) {
        if (i3 == 0) {
            return N();
        }
        if (i3 == 1) {
            return t();
        }
        return 0;
    }

    public void y0(int i3, int i4, int i5, float f3) {
        this.f5551m = i3;
        this.f5561r = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.f5563s = i5;
        this.f5565t = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f5551m = 2;
    }

    public int z() {
        return this.f5570w[1];
    }

    public void z0(float f3) {
        this.f5560q0[1] = f3;
    }
}
