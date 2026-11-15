package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import p.k;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    SparseArray<View> f878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<androidx.constraintlayout.widget.b> f879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected p.f f880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d f887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected androidx.constraintlayout.widget.c f888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HashMap<String, Integer> f890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f891o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f892p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f893q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f894r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f895s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f896t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SparseArray<p.e> f897u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    c f898v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f899w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f900x;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f901a;

        static {
            int[] iArr = new int[p.e.b.values().length];
            f901a = iArr;
            try {
                iArr[p.e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f901a[p.e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f901a[p.e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f901a[p.e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class c implements q.b.InterfaceC0082b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintLayout f944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f946c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f947d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f948e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f949f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f950g;

        public c(ConstraintLayout constraintLayout) {
            this.f944a = constraintLayout;
        }

        @Override // q.b.InterfaceC0082b
        public final void a() {
            int childCount = this.f944a.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f944a.getChildAt(i3);
                if (childAt instanceof g) {
                    ((g) childAt).a(this.f944a);
                }
            }
            int size = this.f944a.f879c.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    ((androidx.constraintlayout.widget.b) this.f944a.f879c.get(i4)).j(this.f944a);
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0163  */
        /* JADX WARN: Code duplicated, block: B:104:0x016e A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:112:0x0183  */
        /* JADX WARN: Code duplicated, block: B:114:0x0187  */
        /* JADX WARN: Code duplicated, block: B:117:0x0195  */
        /* JADX WARN: Code duplicated, block: B:120:0x01a6  */
        /* JADX WARN: Code duplicated, block: B:121:0x01af  */
        /* JADX WARN: Code duplicated, block: B:123:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:124:0x01c2  */
        /* JADX WARN: Code duplicated, block: B:127:0x01ce  */
        /* JADX WARN: Code duplicated, block: B:128:0x01d3  */
        /* JADX WARN: Code duplicated, block: B:131:0x01d8  */
        /* JADX WARN: Code duplicated, block: B:134:0x01e0  */
        /* JADX WARN: Code duplicated, block: B:135:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:138:0x01ea  */
        /* JADX WARN: Code duplicated, block: B:141:0x01f2 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:143:0x01fb A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:144:0x01fd A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:147:0x0208 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:151:0x020e  */
        /* JADX WARN: Code duplicated, block: B:153:0x0212  */
        /* JADX WARN: Code duplicated, block: B:155:0x0218  */
        /* JADX WARN: Code duplicated, block: B:158:0x022f  */
        /* JADX WARN: Code duplicated, block: B:159:0x0231  */
        /* JADX WARN: Code duplicated, block: B:162:0x0237  */
        /* JADX WARN: Code duplicated, block: B:166:0x023f  */
        /* JADX WARN: Code duplicated, block: B:169:0x0246  */
        /* JADX WARN: Code duplicated, block: B:170:0x0248  */
        /* JADX WARN: Code duplicated, block: B:172:0x024b  */
        /* JADX WARN: Code duplicated, block: B:42:0x00ba A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:43:0x00bc A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:44:0x00be  */
        /* JADX WARN: Code duplicated, block: B:46:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:47:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:49:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:53:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:54:0x00de  */
        /* JADX WARN: Code duplicated, block: B:58:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:63:0x00f3 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:65:0x0100  */
        /* JADX WARN: Code duplicated, block: B:67:0x0112  */
        /* JADX WARN: Code duplicated, block: B:69:0x0120  */
        /* JADX WARN: Code duplicated, block: B:73:0x012f  */
        /* JADX WARN: Code duplicated, block: B:74:0x0131  */
        /* JADX WARN: Code duplicated, block: B:76:0x0134  */
        /* JADX WARN: Code duplicated, block: B:77:0x0136  */
        /* JADX WARN: Code duplicated, block: B:80:0x013b  */
        /* JADX WARN: Code duplicated, block: B:84:0x0142  */
        /* JADX WARN: Code duplicated, block: B:86:0x0145  */
        /* JADX WARN: Code duplicated, block: B:90:0x014c  */
        /* JADX WARN: Code duplicated, block: B:93:0x0150  */
        /* JADX WARN: Code duplicated, block: B:96:0x0158  */
        /* JADX WARN: Code duplicated, block: B:98:0x015b  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // q.b.InterfaceC0082b
        @SuppressLint({"WrongCall"})
        public final void b(p.e eVar, q.b.a aVar) {
            int iMakeMeasureSpec;
            boolean z2;
            int i3;
            int iMakeMeasureSpec2;
            boolean z3;
            p.e.b bVar;
            boolean z4;
            boolean z5;
            p.e.b bVar2;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            b bVar3;
            int measuredWidth;
            int measuredHeight;
            int baseline;
            int i4;
            int i5;
            int measuredWidth2;
            int i6;
            int i7;
            int iMin;
            int i8;
            int measuredHeight2;
            int i9;
            int i10;
            boolean z10;
            boolean z11;
            int childMeasureSpec;
            int childMeasureSpec2;
            boolean z12;
            int[] iArr;
            if (eVar == null) {
                return;
            }
            if (eVar.M() == 8 && !eVar.U()) {
                aVar.f5786e = 0;
                aVar.f5787f = 0;
                aVar.f5788g = 0;
                return;
            }
            p.e.b bVar4 = aVar.f5782a;
            p.e.b bVar5 = aVar.f5783b;
            int i11 = aVar.f5784c;
            int i12 = aVar.f5785d;
            int i13 = this.f945b + this.f946c;
            int i14 = this.f947d;
            View view = (View) eVar.o();
            int[] iArr2 = a.f901a;
            int i15 = iArr2[bVar4.ordinal()];
            if (i15 != 1) {
                if (i15 == 2) {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f949f, i14, -2);
                    eVar.f5541h[2] = -2;
                } else if (i15 == 3) {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f949f, i14 + eVar.x(), -1);
                    eVar.f5541h[2] = -1;
                } else if (i15 != 4) {
                    iMakeMeasureSpec = 0;
                } else {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f949f, i14, -2);
                    boolean z13 = eVar.f5549l == 1;
                    int[] iArr3 = eVar.f5541h;
                    iArr3[2] = 0;
                    if (aVar.f5791j) {
                        boolean z14 = !(!z13 || iArr3[3] == 0 || iArr3[0] == eVar.N()) || (view instanceof g);
                        if (!z13 || z14) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.N(), 1073741824);
                        }
                        i3 = iArr2[bVar5.ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        z3 = false;
                                        iMakeMeasureSpec2 = 0;
                                    } else {
                                        childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f950g, i13, -2);
                                        if (eVar.f5551m == 1) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        iArr = eVar.f5541h;
                                        iArr[3] = 0;
                                        if (aVar.f5791j) {
                                            boolean z15 = !(z12 || iArr[2] == 0 || iArr[1] == eVar.t()) || (view instanceof g);
                                            if (z12 || z15) {
                                                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.t(), 1073741824);
                                            }
                                        }
                                    }
                                    bVar = p.e.b.MATCH_CONSTRAINT;
                                    if (bVar4 == bVar) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (bVar5 == bVar) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    bVar2 = p.e.b.MATCH_PARENT;
                                    if (bVar5 != bVar2 || bVar5 == p.e.b.FIXED) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (bVar4 != bVar2 || bVar4 == p.e.b.FIXED) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    if (z4 || eVar.Q <= 0.0f) {
                                        z8 = false;
                                    } else {
                                        z8 = true;
                                    }
                                    if (z5 || eVar.Q <= 0.0f) {
                                        z9 = false;
                                    } else {
                                        z9 = true;
                                    }
                                    bVar3 = (b) view.getLayoutParams();
                                    if (aVar.f5791j && z4 && eVar.f5549l == 0 && z5 && eVar.f5551m == 0) {
                                        measuredWidth2 = 0;
                                        measuredHeight2 = 0;
                                        i9 = -1;
                                        baseline = 0;
                                        i4 = 0;
                                    } else {
                                        if ((view instanceof j) || !(eVar instanceof k)) {
                                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                        } else {
                                            ((j) view).n((k) eVar, iMakeMeasureSpec, iMakeMeasureSpec2);
                                        }
                                        measuredWidth = view.getMeasuredWidth();
                                        measuredHeight = view.getMeasuredHeight();
                                        baseline = view.getBaseline();
                                        if (z2) {
                                            int[] iArr4 = eVar.f5541h;
                                            i4 = 0;
                                            iArr4[0] = measuredWidth;
                                            iArr4[2] = measuredHeight;
                                        } else {
                                            i4 = 0;
                                            int[] iArr5 = eVar.f5541h;
                                            iArr5[0] = 0;
                                            iArr5[2] = 0;
                                        }
                                        if (z3) {
                                            int[] iArr6 = eVar.f5541h;
                                            iArr6[1] = measuredHeight;
                                            iArr6[3] = measuredWidth;
                                        } else {
                                            int[] iArr7 = eVar.f5541h;
                                            iArr7[1] = i4;
                                            iArr7[3] = i4;
                                        }
                                        i5 = eVar.f5555o;
                                        if (i5 > 0) {
                                            measuredWidth2 = Math.max(i5, measuredWidth);
                                        } else {
                                            measuredWidth2 = measuredWidth;
                                        }
                                        i6 = eVar.f5557p;
                                        if (i6 > 0) {
                                            measuredWidth2 = Math.min(i6, measuredWidth2);
                                        }
                                        i7 = eVar.f5561r;
                                        if (i7 > 0) {
                                            iMin = Math.max(i7, measuredHeight);
                                        } else {
                                            iMin = measuredHeight;
                                        }
                                        i8 = eVar.f5563s;
                                        if (i8 > 0) {
                                            iMin = Math.min(i8, iMin);
                                        }
                                        if (!z8 && z6) {
                                            measuredWidth2 = (int) ((iMin * eVar.Q) + 0.5f);
                                        } else if (z9 && z7) {
                                            iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                        }
                                        if (measuredWidth == measuredWidth2 || measuredHeight != iMin) {
                                            if (measuredWidth != measuredWidth2) {
                                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                            }
                                            if (measuredHeight != iMin) {
                                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                            }
                                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                            measuredWidth2 = view.getMeasuredWidth();
                                            measuredHeight2 = view.getMeasuredHeight();
                                            baseline = view.getBaseline();
                                        } else {
                                            measuredHeight2 = iMin;
                                        }
                                        i9 = -1;
                                    }
                                    if (baseline != i9) {
                                        i10 = 1;
                                    } else {
                                        i10 = i4;
                                    }
                                    if (measuredWidth2 == aVar.f5784c || measuredHeight2 != aVar.f5785d) {
                                        z10 = 1;
                                    } else {
                                        z10 = i4;
                                    }
                                    aVar.f5790i = z10;
                                    if (bVar3.Y) {
                                        z11 = 1;
                                    } else {
                                        z11 = i10;
                                    }
                                    if (z11 != 0 && baseline != -1 && eVar.l() != baseline) {
                                        aVar.f5790i = true;
                                    }
                                    aVar.f5786e = measuredWidth2;
                                    aVar.f5787f = measuredHeight2;
                                    aVar.f5789h = z11;
                                    aVar.f5788g = baseline;
                                }
                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f950g, i13 + eVar.L(), -1);
                                eVar.f5541h[3] = -1;
                                iMakeMeasureSpec2 = childMeasureSpec2;
                            } else {
                                childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f950g, i13, -2);
                                eVar.f5541h[3] = -2;
                            }
                            iMakeMeasureSpec2 = childMeasureSpec;
                            z3 = true;
                            bVar = p.e.b.MATCH_CONSTRAINT;
                            if (bVar4 == bVar) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (bVar5 == bVar) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            bVar2 = p.e.b.MATCH_PARENT;
                            if (bVar5 != bVar2) {
                                z6 = true;
                            } else {
                                z6 = true;
                            }
                            if (bVar4 != bVar2) {
                                z7 = true;
                            } else {
                                z7 = true;
                            }
                            if (z4) {
                                z8 = false;
                            } else {
                                z8 = false;
                            }
                            if (z5) {
                                z9 = false;
                            } else {
                                z9 = false;
                            }
                            bVar3 = (b) view.getLayoutParams();
                            if (aVar.f5791j) {
                                if (view instanceof j) {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                } else {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                }
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                                if (z2) {
                                    int[] iArr8 = eVar.f5541h;
                                    i4 = 0;
                                    iArr8[0] = measuredWidth;
                                    iArr8[2] = measuredHeight;
                                } else {
                                    i4 = 0;
                                    int[] iArr9 = eVar.f5541h;
                                    iArr9[0] = 0;
                                    iArr9[2] = 0;
                                }
                                if (z3) {
                                    int[] iArr10 = eVar.f5541h;
                                    iArr10[1] = measuredHeight;
                                    iArr10[3] = measuredWidth;
                                } else {
                                    int[] iArr11 = eVar.f5541h;
                                    iArr11[1] = i4;
                                    iArr11[3] = i4;
                                }
                                i5 = eVar.f5555o;
                                if (i5 > 0) {
                                    measuredWidth2 = Math.max(i5, measuredWidth);
                                } else {
                                    measuredWidth2 = measuredWidth;
                                }
                                i6 = eVar.f5557p;
                                if (i6 > 0) {
                                    measuredWidth2 = Math.min(i6, measuredWidth2);
                                }
                                i7 = eVar.f5561r;
                                if (i7 > 0) {
                                    iMin = Math.max(i7, measuredHeight);
                                } else {
                                    iMin = measuredHeight;
                                }
                                i8 = eVar.f5563s;
                                if (i8 > 0) {
                                    iMin = Math.min(i8, iMin);
                                }
                                if (!z8) {
                                    if (z9) {
                                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                    }
                                } else if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                                if (measuredWidth == measuredWidth2) {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                } else {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                }
                                i9 = -1;
                            } else {
                                if (view instanceof j) {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                } else {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                }
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                                if (z2) {
                                    int[] iArr12 = eVar.f5541h;
                                    i4 = 0;
                                    iArr12[0] = measuredWidth;
                                    iArr12[2] = measuredHeight;
                                } else {
                                    i4 = 0;
                                    int[] iArr13 = eVar.f5541h;
                                    iArr13[0] = 0;
                                    iArr13[2] = 0;
                                }
                                if (z3) {
                                    int[] iArr14 = eVar.f5541h;
                                    iArr14[1] = measuredHeight;
                                    iArr14[3] = measuredWidth;
                                } else {
                                    int[] iArr15 = eVar.f5541h;
                                    iArr15[1] = i4;
                                    iArr15[3] = i4;
                                }
                                i5 = eVar.f5555o;
                                if (i5 > 0) {
                                    measuredWidth2 = Math.max(i5, measuredWidth);
                                } else {
                                    measuredWidth2 = measuredWidth;
                                }
                                i6 = eVar.f5557p;
                                if (i6 > 0) {
                                    measuredWidth2 = Math.min(i6, measuredWidth2);
                                }
                                i7 = eVar.f5561r;
                                if (i7 > 0) {
                                    iMin = Math.max(i7, measuredHeight);
                                } else {
                                    iMin = measuredHeight;
                                }
                                i8 = eVar.f5563s;
                                if (i8 > 0) {
                                    iMin = Math.min(i8, iMin);
                                }
                                if (!z8) {
                                    if (z9) {
                                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                    }
                                } else if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                                if (measuredWidth == measuredWidth2) {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                } else {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                }
                                i9 = -1;
                            }
                            if (baseline != i9) {
                                i10 = 1;
                            } else {
                                i10 = i4;
                            }
                            if (measuredWidth2 == aVar.f5784c) {
                                z10 = 1;
                            } else {
                                z10 = 1;
                            }
                            aVar.f5790i = z10;
                            if (bVar3.Y) {
                                z11 = 1;
                            } else {
                                z11 = i10;
                            }
                            if (z11 != 0) {
                                aVar.f5790i = true;
                            }
                            aVar.f5786e = measuredWidth2;
                            aVar.f5787f = measuredHeight2;
                            aVar.f5789h = z11;
                            aVar.f5788g = baseline;
                        }
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                        eVar.f5541h[3] = i12;
                        z3 = false;
                        bVar = p.e.b.MATCH_CONSTRAINT;
                        if (bVar4 == bVar) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (bVar5 == bVar) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        bVar2 = p.e.b.MATCH_PARENT;
                        if (bVar5 != bVar2) {
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                        if (bVar4 != bVar2) {
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                        if (z4) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z5) {
                            z9 = false;
                        } else {
                            z9 = false;
                        }
                        bVar3 = (b) view.getLayoutParams();
                        if (aVar.f5791j) {
                            if (view instanceof j) {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            } else {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            }
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                            if (z2) {
                                int[] iArr16 = eVar.f5541h;
                                i4 = 0;
                                iArr16[0] = measuredWidth;
                                iArr16[2] = measuredHeight;
                            } else {
                                i4 = 0;
                                int[] iArr17 = eVar.f5541h;
                                iArr17[0] = 0;
                                iArr17[2] = 0;
                            }
                            if (z3) {
                                int[] iArr18 = eVar.f5541h;
                                iArr18[1] = measuredHeight;
                                iArr18[3] = measuredWidth;
                            } else {
                                int[] iArr19 = eVar.f5541h;
                                iArr19[1] = i4;
                                iArr19[3] = i4;
                            }
                            i5 = eVar.f5555o;
                            if (i5 > 0) {
                                measuredWidth2 = Math.max(i5, measuredWidth);
                            } else {
                                measuredWidth2 = measuredWidth;
                            }
                            i6 = eVar.f5557p;
                            if (i6 > 0) {
                                measuredWidth2 = Math.min(i6, measuredWidth2);
                            }
                            i7 = eVar.f5561r;
                            if (i7 > 0) {
                                iMin = Math.max(i7, measuredHeight);
                            } else {
                                iMin = measuredHeight;
                            }
                            i8 = eVar.f5563s;
                            if (i8 > 0) {
                                iMin = Math.min(i8, iMin);
                            }
                            if (!z8) {
                                if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                            } else if (z9) {
                                iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                            }
                            if (measuredWidth == measuredWidth2) {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            } else {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            }
                            i9 = -1;
                        } else {
                            if (view instanceof j) {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            } else {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            }
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                            if (z2) {
                                int[] iArr110 = eVar.f5541h;
                                i4 = 0;
                                iArr110[0] = measuredWidth;
                                iArr110[2] = measuredHeight;
                            } else {
                                i4 = 0;
                                int[] iArr111 = eVar.f5541h;
                                iArr111[0] = 0;
                                iArr111[2] = 0;
                            }
                            if (z3) {
                                int[] iArr112 = eVar.f5541h;
                                iArr112[1] = measuredHeight;
                                iArr112[3] = measuredWidth;
                            } else {
                                int[] iArr113 = eVar.f5541h;
                                iArr113[1] = i4;
                                iArr113[3] = i4;
                            }
                            i5 = eVar.f5555o;
                            if (i5 > 0) {
                                measuredWidth2 = Math.max(i5, measuredWidth);
                            } else {
                                measuredWidth2 = measuredWidth;
                            }
                            i6 = eVar.f5557p;
                            if (i6 > 0) {
                                measuredWidth2 = Math.min(i6, measuredWidth2);
                            }
                            i7 = eVar.f5561r;
                            if (i7 > 0) {
                                iMin = Math.max(i7, measuredHeight);
                            } else {
                                iMin = measuredHeight;
                            }
                            i8 = eVar.f5563s;
                            if (i8 > 0) {
                                iMin = Math.min(i8, iMin);
                            }
                            if (!z8) {
                                if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                            } else if (z9) {
                                iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                            }
                            if (measuredWidth == measuredWidth2) {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            } else {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            }
                            i9 = -1;
                        }
                        if (baseline != i9) {
                            i10 = 1;
                        } else {
                            i10 = i4;
                        }
                        if (measuredWidth2 == aVar.f5784c) {
                            z10 = 1;
                        } else {
                            z10 = 1;
                        }
                        aVar.f5790i = z10;
                        if (bVar3.Y) {
                            z11 = 1;
                        } else {
                            z11 = i10;
                        }
                        if (z11 != 0) {
                            aVar.f5790i = true;
                        }
                        aVar.f5786e = measuredWidth2;
                        aVar.f5787f = measuredHeight2;
                        aVar.f5789h = z11;
                        aVar.f5788g = baseline;
                    }
                }
                z2 = true;
                i3 = iArr2[bVar5.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                z3 = false;
                                iMakeMeasureSpec2 = 0;
                            } else {
                                childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f950g, i13, -2);
                                if (eVar.f5551m == 1) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                iArr = eVar.f5541h;
                                iArr[3] = 0;
                                if (aVar.f5791j) {
                                    if (z12) {
                                    }
                                    if (z12) {
                                    }
                                    childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.t(), 1073741824);
                                }
                            }
                            bVar = p.e.b.MATCH_CONSTRAINT;
                            if (bVar4 == bVar) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (bVar5 == bVar) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            bVar2 = p.e.b.MATCH_PARENT;
                            if (bVar5 != bVar2) {
                                z6 = true;
                            } else {
                                z6 = true;
                            }
                            if (bVar4 != bVar2) {
                                z7 = true;
                            } else {
                                z7 = true;
                            }
                            if (z4) {
                                z8 = false;
                            } else {
                                z8 = false;
                            }
                            if (z5) {
                                z9 = false;
                            } else {
                                z9 = false;
                            }
                            bVar3 = (b) view.getLayoutParams();
                            if (aVar.f5791j) {
                                if (view instanceof j) {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                } else {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                }
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                                if (z2) {
                                    int[] iArr114 = eVar.f5541h;
                                    i4 = 0;
                                    iArr114[0] = measuredWidth;
                                    iArr114[2] = measuredHeight;
                                } else {
                                    i4 = 0;
                                    int[] iArr115 = eVar.f5541h;
                                    iArr115[0] = 0;
                                    iArr115[2] = 0;
                                }
                                if (z3) {
                                    int[] iArr116 = eVar.f5541h;
                                    iArr116[1] = measuredHeight;
                                    iArr116[3] = measuredWidth;
                                } else {
                                    int[] iArr117 = eVar.f5541h;
                                    iArr117[1] = i4;
                                    iArr117[3] = i4;
                                }
                                i5 = eVar.f5555o;
                                if (i5 > 0) {
                                    measuredWidth2 = Math.max(i5, measuredWidth);
                                } else {
                                    measuredWidth2 = measuredWidth;
                                }
                                i6 = eVar.f5557p;
                                if (i6 > 0) {
                                    measuredWidth2 = Math.min(i6, measuredWidth2);
                                }
                                i7 = eVar.f5561r;
                                if (i7 > 0) {
                                    iMin = Math.max(i7, measuredHeight);
                                } else {
                                    iMin = measuredHeight;
                                }
                                i8 = eVar.f5563s;
                                if (i8 > 0) {
                                    iMin = Math.min(i8, iMin);
                                }
                                if (!z8) {
                                    if (z9) {
                                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                    }
                                } else if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                                if (measuredWidth == measuredWidth2) {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                } else {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                }
                                i9 = -1;
                            } else {
                                if (view instanceof j) {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                } else {
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                }
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                                if (z2) {
                                    int[] iArr118 = eVar.f5541h;
                                    i4 = 0;
                                    iArr118[0] = measuredWidth;
                                    iArr118[2] = measuredHeight;
                                } else {
                                    i4 = 0;
                                    int[] iArr119 = eVar.f5541h;
                                    iArr119[0] = 0;
                                    iArr119[2] = 0;
                                }
                                if (z3) {
                                    int[] iArr1110 = eVar.f5541h;
                                    iArr1110[1] = measuredHeight;
                                    iArr1110[3] = measuredWidth;
                                } else {
                                    int[] iArr1111 = eVar.f5541h;
                                    iArr1111[1] = i4;
                                    iArr1111[3] = i4;
                                }
                                i5 = eVar.f5555o;
                                if (i5 > 0) {
                                    measuredWidth2 = Math.max(i5, measuredWidth);
                                } else {
                                    measuredWidth2 = measuredWidth;
                                }
                                i6 = eVar.f5557p;
                                if (i6 > 0) {
                                    measuredWidth2 = Math.min(i6, measuredWidth2);
                                }
                                i7 = eVar.f5561r;
                                if (i7 > 0) {
                                    iMin = Math.max(i7, measuredHeight);
                                } else {
                                    iMin = measuredHeight;
                                }
                                i8 = eVar.f5563s;
                                if (i8 > 0) {
                                    iMin = Math.min(i8, iMin);
                                }
                                if (!z8) {
                                    if (z9) {
                                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                    }
                                } else if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                                if (measuredWidth == measuredWidth2) {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                } else {
                                    if (measuredWidth != measuredWidth2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                    }
                                    if (measuredHeight != iMin) {
                                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                }
                                i9 = -1;
                            }
                            if (baseline != i9) {
                                i10 = 1;
                            } else {
                                i10 = i4;
                            }
                            if (measuredWidth2 == aVar.f5784c) {
                                z10 = 1;
                            } else {
                                z10 = 1;
                            }
                            aVar.f5790i = z10;
                            if (bVar3.Y) {
                                z11 = 1;
                            } else {
                                z11 = i10;
                            }
                            if (z11 != 0) {
                                aVar.f5790i = true;
                            }
                            aVar.f5786e = measuredWidth2;
                            aVar.f5787f = measuredHeight2;
                            aVar.f5789h = z11;
                            aVar.f5788g = baseline;
                        }
                        childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f950g, i13 + eVar.L(), -1);
                        eVar.f5541h[3] = -1;
                        iMakeMeasureSpec2 = childMeasureSpec2;
                    } else {
                        childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f950g, i13, -2);
                        eVar.f5541h[3] = -2;
                    }
                    iMakeMeasureSpec2 = childMeasureSpec;
                    z3 = true;
                    bVar = p.e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (bVar5 == bVar) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    bVar2 = p.e.b.MATCH_PARENT;
                    if (bVar5 != bVar2) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (bVar4 != bVar2) {
                        z7 = true;
                    } else {
                        z7 = true;
                    }
                    if (z4) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (z5) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    bVar3 = (b) view.getLayoutParams();
                    if (aVar.f5791j) {
                        if (view instanceof j) {
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        } else {
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        }
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                        if (z2) {
                            int[] iArr1112 = eVar.f5541h;
                            i4 = 0;
                            iArr1112[0] = measuredWidth;
                            iArr1112[2] = measuredHeight;
                        } else {
                            i4 = 0;
                            int[] iArr1113 = eVar.f5541h;
                            iArr1113[0] = 0;
                            iArr1113[2] = 0;
                        }
                        if (z3) {
                            int[] iArr1114 = eVar.f5541h;
                            iArr1114[1] = measuredHeight;
                            iArr1114[3] = measuredWidth;
                        } else {
                            int[] iArr1115 = eVar.f5541h;
                            iArr1115[1] = i4;
                            iArr1115[3] = i4;
                        }
                        i5 = eVar.f5555o;
                        if (i5 > 0) {
                            measuredWidth2 = Math.max(i5, measuredWidth);
                        } else {
                            measuredWidth2 = measuredWidth;
                        }
                        i6 = eVar.f5557p;
                        if (i6 > 0) {
                            measuredWidth2 = Math.min(i6, measuredWidth2);
                        }
                        i7 = eVar.f5561r;
                        if (i7 > 0) {
                            iMin = Math.max(i7, measuredHeight);
                        } else {
                            iMin = measuredHeight;
                        }
                        i8 = eVar.f5563s;
                        if (i8 > 0) {
                            iMin = Math.min(i8, iMin);
                        }
                        if (!z8) {
                            if (z9) {
                                iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                            }
                        } else if (z9) {
                            iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                        }
                        if (measuredWidth == measuredWidth2) {
                            if (measuredWidth != measuredWidth2) {
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                            }
                            if (measuredHeight != iMin) {
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            }
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            measuredWidth2 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                        } else {
                            if (measuredWidth != measuredWidth2) {
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                            }
                            if (measuredHeight != iMin) {
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            }
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            measuredWidth2 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                        }
                        i9 = -1;
                    } else {
                        if (view instanceof j) {
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        } else {
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        }
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                        if (z2) {
                            int[] iArr1116 = eVar.f5541h;
                            i4 = 0;
                            iArr1116[0] = measuredWidth;
                            iArr1116[2] = measuredHeight;
                        } else {
                            i4 = 0;
                            int[] iArr1117 = eVar.f5541h;
                            iArr1117[0] = 0;
                            iArr1117[2] = 0;
                        }
                        if (z3) {
                            int[] iArr1118 = eVar.f5541h;
                            iArr1118[1] = measuredHeight;
                            iArr1118[3] = measuredWidth;
                        } else {
                            int[] iArr1119 = eVar.f5541h;
                            iArr1119[1] = i4;
                            iArr1119[3] = i4;
                        }
                        i5 = eVar.f5555o;
                        if (i5 > 0) {
                            measuredWidth2 = Math.max(i5, measuredWidth);
                        } else {
                            measuredWidth2 = measuredWidth;
                        }
                        i6 = eVar.f5557p;
                        if (i6 > 0) {
                            measuredWidth2 = Math.min(i6, measuredWidth2);
                        }
                        i7 = eVar.f5561r;
                        if (i7 > 0) {
                            iMin = Math.max(i7, measuredHeight);
                        } else {
                            iMin = measuredHeight;
                        }
                        i8 = eVar.f5563s;
                        if (i8 > 0) {
                            iMin = Math.min(i8, iMin);
                        }
                        if (!z8) {
                            if (z9) {
                                iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                            }
                        } else if (z9) {
                            iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                        }
                        if (measuredWidth == measuredWidth2) {
                            if (measuredWidth != measuredWidth2) {
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                            }
                            if (measuredHeight != iMin) {
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            }
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            measuredWidth2 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                        } else {
                            if (measuredWidth != measuredWidth2) {
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                            }
                            if (measuredHeight != iMin) {
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                            }
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            measuredWidth2 = view.getMeasuredWidth();
                            measuredHeight2 = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                        }
                        i9 = -1;
                    }
                    if (baseline != i9) {
                        i10 = 1;
                    } else {
                        i10 = i4;
                    }
                    if (measuredWidth2 == aVar.f5784c) {
                        z10 = 1;
                    } else {
                        z10 = 1;
                    }
                    aVar.f5790i = z10;
                    if (bVar3.Y) {
                        z11 = 1;
                    } else {
                        z11 = i10;
                    }
                    if (z11 != 0) {
                        aVar.f5790i = true;
                    }
                    aVar.f5786e = measuredWidth2;
                    aVar.f5787f = measuredHeight2;
                    aVar.f5789h = z11;
                    aVar.f5788g = baseline;
                }
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                eVar.f5541h[3] = i12;
                z3 = false;
                bVar = p.e.b.MATCH_CONSTRAINT;
                if (bVar4 == bVar) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (bVar5 == bVar) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                bVar2 = p.e.b.MATCH_PARENT;
                if (bVar5 != bVar2) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (bVar4 != bVar2) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                if (z4) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                if (z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                bVar3 = (b) view.getLayoutParams();
                if (aVar.f5791j) {
                    if (view instanceof j) {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    } else {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    if (z2) {
                        int[] iArr11110 = eVar.f5541h;
                        i4 = 0;
                        iArr11110[0] = measuredWidth;
                        iArr11110[2] = measuredHeight;
                    } else {
                        i4 = 0;
                        int[] iArr11111 = eVar.f5541h;
                        iArr11111[0] = 0;
                        iArr11111[2] = 0;
                    }
                    if (z3) {
                        int[] iArr11112 = eVar.f5541h;
                        iArr11112[1] = measuredHeight;
                        iArr11112[3] = measuredWidth;
                    } else {
                        int[] iArr11113 = eVar.f5541h;
                        iArr11113[1] = i4;
                        iArr11113[3] = i4;
                    }
                    i5 = eVar.f5555o;
                    if (i5 > 0) {
                        measuredWidth2 = Math.max(i5, measuredWidth);
                    } else {
                        measuredWidth2 = measuredWidth;
                    }
                    i6 = eVar.f5557p;
                    if (i6 > 0) {
                        measuredWidth2 = Math.min(i6, measuredWidth2);
                    }
                    i7 = eVar.f5561r;
                    if (i7 > 0) {
                        iMin = Math.max(i7, measuredHeight);
                    } else {
                        iMin = measuredHeight;
                    }
                    i8 = eVar.f5563s;
                    if (i8 > 0) {
                        iMin = Math.min(i8, iMin);
                    }
                    if (!z8) {
                        if (z9) {
                            iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                        }
                    } else if (z9) {
                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                    }
                    if (measuredWidth == measuredWidth2) {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                    i9 = -1;
                } else {
                    if (view instanceof j) {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    } else {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    if (z2) {
                        int[] iArr11114 = eVar.f5541h;
                        i4 = 0;
                        iArr11114[0] = measuredWidth;
                        iArr11114[2] = measuredHeight;
                    } else {
                        i4 = 0;
                        int[] iArr11115 = eVar.f5541h;
                        iArr11115[0] = 0;
                        iArr11115[2] = 0;
                    }
                    if (z3) {
                        int[] iArr11116 = eVar.f5541h;
                        iArr11116[1] = measuredHeight;
                        iArr11116[3] = measuredWidth;
                    } else {
                        int[] iArr11117 = eVar.f5541h;
                        iArr11117[1] = i4;
                        iArr11117[3] = i4;
                    }
                    i5 = eVar.f5555o;
                    if (i5 > 0) {
                        measuredWidth2 = Math.max(i5, measuredWidth);
                    } else {
                        measuredWidth2 = measuredWidth;
                    }
                    i6 = eVar.f5557p;
                    if (i6 > 0) {
                        measuredWidth2 = Math.min(i6, measuredWidth2);
                    }
                    i7 = eVar.f5561r;
                    if (i7 > 0) {
                        iMin = Math.max(i7, measuredHeight);
                    } else {
                        iMin = measuredHeight;
                    }
                    i8 = eVar.f5563s;
                    if (i8 > 0) {
                        iMin = Math.min(i8, iMin);
                    }
                    if (!z8) {
                        if (z9) {
                            iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                        }
                    } else if (z9) {
                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                    }
                    if (measuredWidth == measuredWidth2) {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                    i9 = -1;
                }
                if (baseline != i9) {
                    i10 = 1;
                } else {
                    i10 = i4;
                }
                if (measuredWidth2 == aVar.f5784c) {
                    z10 = 1;
                } else {
                    z10 = 1;
                }
                aVar.f5790i = z10;
                if (bVar3.Y) {
                    z11 = 1;
                } else {
                    z11 = i10;
                }
                if (z11 != 0) {
                    aVar.f5790i = true;
                }
                aVar.f5786e = measuredWidth2;
                aVar.f5787f = measuredHeight2;
                aVar.f5789h = z11;
                aVar.f5788g = baseline;
            }
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            eVar.f5541h[2] = i11;
            iMakeMeasureSpec = iMakeMeasureSpec3;
            z2 = false;
            i3 = iArr2[bVar5.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            z3 = false;
                            iMakeMeasureSpec2 = 0;
                        } else {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f950g, i13, -2);
                            if (eVar.f5551m == 1) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            iArr = eVar.f5541h;
                            iArr[3] = 0;
                            if (aVar.f5791j) {
                                if (z12) {
                                }
                                if (z12) {
                                }
                                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.t(), 1073741824);
                            }
                        }
                        bVar = p.e.b.MATCH_CONSTRAINT;
                        if (bVar4 == bVar) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (bVar5 == bVar) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        bVar2 = p.e.b.MATCH_PARENT;
                        if (bVar5 != bVar2) {
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                        if (bVar4 != bVar2) {
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                        if (z4) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z5) {
                            z9 = false;
                        } else {
                            z9 = false;
                        }
                        bVar3 = (b) view.getLayoutParams();
                        if (aVar.f5791j) {
                            if (view instanceof j) {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            } else {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            }
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                            if (z2) {
                                int[] iArr11118 = eVar.f5541h;
                                i4 = 0;
                                iArr11118[0] = measuredWidth;
                                iArr11118[2] = measuredHeight;
                            } else {
                                i4 = 0;
                                int[] iArr11119 = eVar.f5541h;
                                iArr11119[0] = 0;
                                iArr11119[2] = 0;
                            }
                            if (z3) {
                                int[] iArr111110 = eVar.f5541h;
                                iArr111110[1] = measuredHeight;
                                iArr111110[3] = measuredWidth;
                            } else {
                                int[] iArr111111 = eVar.f5541h;
                                iArr111111[1] = i4;
                                iArr111111[3] = i4;
                            }
                            i5 = eVar.f5555o;
                            if (i5 > 0) {
                                measuredWidth2 = Math.max(i5, measuredWidth);
                            } else {
                                measuredWidth2 = measuredWidth;
                            }
                            i6 = eVar.f5557p;
                            if (i6 > 0) {
                                measuredWidth2 = Math.min(i6, measuredWidth2);
                            }
                            i7 = eVar.f5561r;
                            if (i7 > 0) {
                                iMin = Math.max(i7, measuredHeight);
                            } else {
                                iMin = measuredHeight;
                            }
                            i8 = eVar.f5563s;
                            if (i8 > 0) {
                                iMin = Math.min(i8, iMin);
                            }
                            if (!z8) {
                                if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                            } else if (z9) {
                                iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                            }
                            if (measuredWidth == measuredWidth2) {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            } else {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            }
                            i9 = -1;
                        } else {
                            if (view instanceof j) {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            } else {
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            }
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                            if (z2) {
                                int[] iArr111112 = eVar.f5541h;
                                i4 = 0;
                                iArr111112[0] = measuredWidth;
                                iArr111112[2] = measuredHeight;
                            } else {
                                i4 = 0;
                                int[] iArr111113 = eVar.f5541h;
                                iArr111113[0] = 0;
                                iArr111113[2] = 0;
                            }
                            if (z3) {
                                int[] iArr111114 = eVar.f5541h;
                                iArr111114[1] = measuredHeight;
                                iArr111114[3] = measuredWidth;
                            } else {
                                int[] iArr111115 = eVar.f5541h;
                                iArr111115[1] = i4;
                                iArr111115[3] = i4;
                            }
                            i5 = eVar.f5555o;
                            if (i5 > 0) {
                                measuredWidth2 = Math.max(i5, measuredWidth);
                            } else {
                                measuredWidth2 = measuredWidth;
                            }
                            i6 = eVar.f5557p;
                            if (i6 > 0) {
                                measuredWidth2 = Math.min(i6, measuredWidth2);
                            }
                            i7 = eVar.f5561r;
                            if (i7 > 0) {
                                iMin = Math.max(i7, measuredHeight);
                            } else {
                                iMin = measuredHeight;
                            }
                            i8 = eVar.f5563s;
                            if (i8 > 0) {
                                iMin = Math.min(i8, iMin);
                            }
                            if (!z8) {
                                if (z9) {
                                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                                }
                            } else if (z9) {
                                iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                            }
                            if (measuredWidth == measuredWidth2) {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            } else {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != iMin) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            }
                            i9 = -1;
                        }
                        if (baseline != i9) {
                            i10 = 1;
                        } else {
                            i10 = i4;
                        }
                        if (measuredWidth2 == aVar.f5784c) {
                            z10 = 1;
                        } else {
                            z10 = 1;
                        }
                        aVar.f5790i = z10;
                        if (bVar3.Y) {
                            z11 = 1;
                        } else {
                            z11 = i10;
                        }
                        if (z11 != 0) {
                            aVar.f5790i = true;
                        }
                        aVar.f5786e = measuredWidth2;
                        aVar.f5787f = measuredHeight2;
                        aVar.f5789h = z11;
                        aVar.f5788g = baseline;
                    }
                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f950g, i13 + eVar.L(), -1);
                    eVar.f5541h[3] = -1;
                    iMakeMeasureSpec2 = childMeasureSpec2;
                } else {
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f950g, i13, -2);
                    eVar.f5541h[3] = -2;
                }
                iMakeMeasureSpec2 = childMeasureSpec;
                z3 = true;
                bVar = p.e.b.MATCH_CONSTRAINT;
                if (bVar4 == bVar) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (bVar5 == bVar) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                bVar2 = p.e.b.MATCH_PARENT;
                if (bVar5 != bVar2) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (bVar4 != bVar2) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                if (z4) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                if (z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                bVar3 = (b) view.getLayoutParams();
                if (aVar.f5791j) {
                    if (view instanceof j) {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    } else {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    if (z2) {
                        int[] iArr111116 = eVar.f5541h;
                        i4 = 0;
                        iArr111116[0] = measuredWidth;
                        iArr111116[2] = measuredHeight;
                    } else {
                        i4 = 0;
                        int[] iArr111117 = eVar.f5541h;
                        iArr111117[0] = 0;
                        iArr111117[2] = 0;
                    }
                    if (z3) {
                        int[] iArr111118 = eVar.f5541h;
                        iArr111118[1] = measuredHeight;
                        iArr111118[3] = measuredWidth;
                    } else {
                        int[] iArr111119 = eVar.f5541h;
                        iArr111119[1] = i4;
                        iArr111119[3] = i4;
                    }
                    i5 = eVar.f5555o;
                    if (i5 > 0) {
                        measuredWidth2 = Math.max(i5, measuredWidth);
                    } else {
                        measuredWidth2 = measuredWidth;
                    }
                    i6 = eVar.f5557p;
                    if (i6 > 0) {
                        measuredWidth2 = Math.min(i6, measuredWidth2);
                    }
                    i7 = eVar.f5561r;
                    if (i7 > 0) {
                        iMin = Math.max(i7, measuredHeight);
                    } else {
                        iMin = measuredHeight;
                    }
                    i8 = eVar.f5563s;
                    if (i8 > 0) {
                        iMin = Math.min(i8, iMin);
                    }
                    if (!z8) {
                        if (z9) {
                            iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                        }
                    } else if (z9) {
                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                    }
                    if (measuredWidth == measuredWidth2) {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                    i9 = -1;
                } else {
                    if (view instanceof j) {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    } else {
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    if (z2) {
                        int[] iArr1111110 = eVar.f5541h;
                        i4 = 0;
                        iArr1111110[0] = measuredWidth;
                        iArr1111110[2] = measuredHeight;
                    } else {
                        i4 = 0;
                        int[] iArr1111111 = eVar.f5541h;
                        iArr1111111[0] = 0;
                        iArr1111111[2] = 0;
                    }
                    if (z3) {
                        int[] iArr1111112 = eVar.f5541h;
                        iArr1111112[1] = measuredHeight;
                        iArr1111112[3] = measuredWidth;
                    } else {
                        int[] iArr1111113 = eVar.f5541h;
                        iArr1111113[1] = i4;
                        iArr1111113[3] = i4;
                    }
                    i5 = eVar.f5555o;
                    if (i5 > 0) {
                        measuredWidth2 = Math.max(i5, measuredWidth);
                    } else {
                        measuredWidth2 = measuredWidth;
                    }
                    i6 = eVar.f5557p;
                    if (i6 > 0) {
                        measuredWidth2 = Math.min(i6, measuredWidth2);
                    }
                    i7 = eVar.f5561r;
                    if (i7 > 0) {
                        iMin = Math.max(i7, measuredHeight);
                    } else {
                        iMin = measuredHeight;
                    }
                    i8 = eVar.f5563s;
                    if (i8 > 0) {
                        iMin = Math.min(i8, iMin);
                    }
                    if (!z8) {
                        if (z9) {
                            iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                        }
                    } else if (z9) {
                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                    }
                    if (measuredWidth == measuredWidth2) {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != iMin) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                    i9 = -1;
                }
                if (baseline != i9) {
                    i10 = 1;
                } else {
                    i10 = i4;
                }
                if (measuredWidth2 == aVar.f5784c) {
                    z10 = 1;
                } else {
                    z10 = 1;
                }
                aVar.f5790i = z10;
                if (bVar3.Y) {
                    z11 = 1;
                } else {
                    z11 = i10;
                }
                if (z11 != 0) {
                    aVar.f5790i = true;
                }
                aVar.f5786e = measuredWidth2;
                aVar.f5787f = measuredHeight2;
                aVar.f5789h = z11;
                aVar.f5788g = baseline;
            }
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            eVar.f5541h[3] = i12;
            z3 = false;
            bVar = p.e.b.MATCH_CONSTRAINT;
            if (bVar4 == bVar) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (bVar5 == bVar) {
                z5 = true;
            } else {
                z5 = false;
            }
            bVar2 = p.e.b.MATCH_PARENT;
            if (bVar5 != bVar2) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (bVar4 != bVar2) {
                z7 = true;
            } else {
                z7 = true;
            }
            if (z4) {
                z8 = false;
            } else {
                z8 = false;
            }
            if (z5) {
                z9 = false;
            } else {
                z9 = false;
            }
            bVar3 = (b) view.getLayoutParams();
            if (aVar.f5791j) {
                if (view instanceof j) {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                if (z2) {
                    int[] iArr1111114 = eVar.f5541h;
                    i4 = 0;
                    iArr1111114[0] = measuredWidth;
                    iArr1111114[2] = measuredHeight;
                } else {
                    i4 = 0;
                    int[] iArr1111115 = eVar.f5541h;
                    iArr1111115[0] = 0;
                    iArr1111115[2] = 0;
                }
                if (z3) {
                    int[] iArr1111116 = eVar.f5541h;
                    iArr1111116[1] = measuredHeight;
                    iArr1111116[3] = measuredWidth;
                } else {
                    int[] iArr1111117 = eVar.f5541h;
                    iArr1111117[1] = i4;
                    iArr1111117[3] = i4;
                }
                i5 = eVar.f5555o;
                if (i5 > 0) {
                    measuredWidth2 = Math.max(i5, measuredWidth);
                } else {
                    measuredWidth2 = measuredWidth;
                }
                i6 = eVar.f5557p;
                if (i6 > 0) {
                    measuredWidth2 = Math.min(i6, measuredWidth2);
                }
                i7 = eVar.f5561r;
                if (i7 > 0) {
                    iMin = Math.max(i7, measuredHeight);
                } else {
                    iMin = measuredHeight;
                }
                i8 = eVar.f5563s;
                if (i8 > 0) {
                    iMin = Math.min(i8, iMin);
                }
                if (!z8) {
                    if (z9) {
                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                    }
                } else if (z9) {
                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                }
                if (measuredWidth == measuredWidth2) {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != iMin) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != iMin) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i9 = -1;
            } else {
                if (view instanceof j) {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                if (z2) {
                    int[] iArr1111118 = eVar.f5541h;
                    i4 = 0;
                    iArr1111118[0] = measuredWidth;
                    iArr1111118[2] = measuredHeight;
                } else {
                    i4 = 0;
                    int[] iArr1111119 = eVar.f5541h;
                    iArr1111119[0] = 0;
                    iArr1111119[2] = 0;
                }
                if (z3) {
                    int[] iArr11111110 = eVar.f5541h;
                    iArr11111110[1] = measuredHeight;
                    iArr11111110[3] = measuredWidth;
                } else {
                    int[] iArr11111111 = eVar.f5541h;
                    iArr11111111[1] = i4;
                    iArr11111111[3] = i4;
                }
                i5 = eVar.f5555o;
                if (i5 > 0) {
                    measuredWidth2 = Math.max(i5, measuredWidth);
                } else {
                    measuredWidth2 = measuredWidth;
                }
                i6 = eVar.f5557p;
                if (i6 > 0) {
                    measuredWidth2 = Math.min(i6, measuredWidth2);
                }
                i7 = eVar.f5561r;
                if (i7 > 0) {
                    iMin = Math.max(i7, measuredHeight);
                } else {
                    iMin = measuredHeight;
                }
                i8 = eVar.f5563s;
                if (i8 > 0) {
                    iMin = Math.min(i8, iMin);
                }
                if (!z8) {
                    if (z9) {
                        iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                    }
                } else if (z9) {
                    iMin = (int) ((measuredWidth2 / eVar.Q) + 0.5f);
                }
                if (measuredWidth == measuredWidth2) {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != iMin) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != iMin) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i9 = -1;
            }
            if (baseline != i9) {
                i10 = 1;
            } else {
                i10 = i4;
            }
            if (measuredWidth2 == aVar.f5784c) {
                z10 = 1;
            } else {
                z10 = 1;
            }
            aVar.f5790i = z10;
            if (bVar3.Y) {
                z11 = 1;
            } else {
                z11 = i10;
            }
            if (z11 != 0) {
                aVar.f5790i = true;
            }
            aVar.f5786e = measuredWidth2;
            aVar.f5787f = measuredHeight2;
            aVar.f5789h = z11;
            aVar.f5788g = baseline;
        }

        public void c(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f945b = i5;
            this.f946c = i6;
            this.f947d = i7;
            this.f948e = i8;
            this.f949f = i3;
            this.f950g = i4;
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.f878b = new SparseArray<>();
        this.f879c = new ArrayList<>(4);
        this.f880d = new p.f();
        this.f881e = 0;
        this.f882f = 0;
        this.f883g = Integer.MAX_VALUE;
        this.f884h = Integer.MAX_VALUE;
        this.f885i = true;
        this.f886j = 263;
        this.f887k = null;
        this.f888l = null;
        this.f889m = -1;
        this.f890n = new HashMap<>();
        this.f891o = -1;
        this.f892p = -1;
        this.f893q = -1;
        this.f894r = -1;
        this.f895s = 0;
        this.f896t = 0;
        this.f897u = new SparseArray<>();
        this.f898v = new c(this);
        this.f899w = 0;
        this.f900x = 0;
        j(null, 0, 0);
    }

    private final p.e g(int i3) {
        if (i3 == 0) {
            return this.f880d;
        }
        View viewFindViewById = this.f878b.get(i3);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i3)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f880d;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f929n0;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Build.VERSION.SDK_INT >= 17 ? Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd()) : 0;
        return iMax2 > 0 ? iMax2 : iMax;
    }

    private void j(AttributeSet attributeSet, int i3, int i4) {
        this.f880d.Z(this);
        this.f880d.b1(this.f898v);
        this.f878b.put(getId(), this);
        this.f887k = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout, i3, i4);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.ConstraintLayout_Layout_android_minWidth) {
                    this.f881e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f881e);
                } else if (index == i.ConstraintLayout_Layout_android_minHeight) {
                    this.f882f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f882f);
                } else if (index == i.ConstraintLayout_Layout_android_maxWidth) {
                    this.f883g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f883g);
                } else if (index == i.ConstraintLayout_Layout_android_maxHeight) {
                    this.f884h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f884h);
                } else if (index == i.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f886j = typedArrayObtainStyledAttributes.getInt(index, this.f886j);
                } else if (index == i.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f888l = null;
                        }
                    }
                } else if (index == i.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f887k = dVar;
                        dVar.m(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f887k = null;
                    }
                    this.f889m = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f880d.c1(this.f886j);
    }

    private void l() {
        this.f885i = true;
        this.f891o = -1;
        this.f892p = -1;
        this.f893q = -1;
        this.f894r = -1;
        this.f895s = 0;
        this.f896t = 0;
    }

    private void p() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            p.e eVarI = i(getChildAt(i3));
            if (eVarI != null) {
                eVarI.W();
            }
        }
        if (zIsInEditMode) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    q(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    g(childAt.getId()).a0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f889m != -1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getId() == this.f889m && (childAt2 instanceof e)) {
                    this.f887k = ((e) childAt2).getConstraintSet();
                }
            }
        }
        d dVar = this.f887k;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.f880d.J0();
        int size = this.f879c.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.f879c.get(i6).l(this);
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt3 = getChildAt(i7);
            if (childAt3 instanceof g) {
                ((g) childAt3).b(this);
            }
        }
        this.f897u.clear();
        this.f897u.put(0, this.f880d);
        this.f897u.put(getId(), this.f880d);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt4 = getChildAt(i8);
            this.f897u.put(childAt4.getId(), i(childAt4));
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt5 = getChildAt(i9);
            p.e eVarI2 = i(childAt5);
            if (eVarI2 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.f880d.c(eVarI2);
                c(zIsInEditMode, childAt5, eVarI2, bVar, this.f897u);
            }
        }
    }

    private boolean s() {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (getChildAt(i3).isLayoutRequested()) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            p();
        }
        return z2;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0212  */
    /* JADX WARN: Code duplicated, block: B:110:0x0216  */
    /* JADX WARN: Code duplicated, block: B:112:0x021a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0220  */
    /* JADX WARN: Code duplicated, block: B:115:0x023a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0243  */
    /* JADX WARN: Code duplicated, block: B:118:0x0251  */
    /* JADX WARN: Code duplicated, block: B:121:0x025a  */
    /* JADX WARN: Code duplicated, block: B:123:0x025e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0262  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:128:0x0282  */
    /* JADX WARN: Code duplicated, block: B:129:0x028b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0299  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:61:0x010f  */
    /* JADX WARN: Code duplicated, block: B:62:0x011c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0136  */
    /* JADX WARN: Code duplicated, block: B:70:0x013f  */
    /* JADX WARN: Code duplicated, block: B:71:0x014c  */
    /* JADX WARN: Code duplicated, block: B:78:0x016a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0173  */
    /* JADX WARN: Code duplicated, block: B:81:0x0181  */
    /* JADX WARN: Code duplicated, block: B:88:0x019e  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01fb  */
    protected void c(boolean z2, View view, p.e eVar, b bVar, SparseArray<p.e> sparseArray) {
        int i3;
        int i4;
        int i5;
        float f3;
        int i6;
        float f4;
        p.e eVar2;
        p.e eVar3;
        int i7;
        int i8;
        p.e eVar4;
        int i9;
        int i10;
        p.e eVar5;
        int i11;
        float f5;
        float f6;
        View view2;
        p.e eVar6;
        p.e eVar7;
        p.e eVar8;
        p.e eVar9;
        p.e eVar10;
        int i12;
        p.e eVar11;
        bVar.a();
        bVar.f931o0 = false;
        eVar.A0(view.getVisibility());
        if (bVar.f905b0) {
            eVar.m0(true);
            eVar.A0(8);
        }
        eVar.Z(view);
        if (view instanceof androidx.constraintlayout.widget.b) {
            ((androidx.constraintlayout.widget.b) view).h(eVar, this.f880d.W0());
        }
        if (bVar.Z) {
            p.g gVar = (p.g) eVar;
            int i13 = bVar.f923k0;
            int i14 = bVar.f925l0;
            float f7 = bVar.f927m0;
            if (Build.VERSION.SDK_INT < 17) {
                i13 = bVar.f902a;
                i14 = bVar.f904b;
                f7 = bVar.f906c;
            }
            if (f7 != -1.0f) {
                gVar.N0(f7);
                return;
            } else if (i13 != -1) {
                gVar.L0(i13);
                return;
            } else {
                if (i14 != -1) {
                    gVar.M0(i14);
                    return;
                }
                return;
            }
        }
        int i15 = bVar.f909d0;
        int i16 = bVar.f911e0;
        int i17 = bVar.f913f0;
        int i18 = bVar.f915g0;
        int i19 = bVar.f917h0;
        int i20 = bVar.f919i0;
        float f8 = bVar.f921j0;
        if (Build.VERSION.SDK_INT < 17) {
            i15 = bVar.f908d;
            int i21 = bVar.f910e;
            int i22 = bVar.f912f;
            i18 = bVar.f914g;
            int i23 = bVar.f936t;
            int i24 = bVar.f938v;
            f8 = bVar.f942z;
            if (i15 == -1 && i21 == -1) {
                int i25 = bVar.f933q;
                if (i25 != -1) {
                    i15 = i25;
                } else {
                    int i26 = bVar.f932p;
                    if (i26 != -1) {
                        i21 = i26;
                    }
                }
            }
            if (i22 == -1 && i18 == -1) {
                i4 = bVar.f934r;
                if (i4 == -1) {
                    int i27 = bVar.f935s;
                    if (i27 != -1) {
                        i3 = i24;
                        f3 = f8;
                        i19 = i23;
                        i5 = i27;
                        i16 = i21;
                        i4 = i22;
                    } else {
                        i4 = i22;
                        i3 = i24;
                        i19 = i23;
                        i16 = i21;
                    }
                } else {
                    i3 = i24;
                    i19 = i23;
                    i16 = i21;
                }
            } else {
                i4 = i22;
                i3 = i24;
                i19 = i23;
                i16 = i21;
            }
            i6 = bVar.f926m;
            if (i6 != -1) {
                eVar11 = sparseArray.get(i6);
                if (eVar11 != null) {
                    eVar.i(eVar11, bVar.f930o, bVar.f928n);
                }
            } else {
                if (i15 != -1) {
                    eVar10 = sparseArray.get(i15);
                    if (eVar10 != null) {
                        p.d.b bVar2 = p.d.b.LEFT;
                        f4 = f3;
                        eVar.R(bVar2, eVar10, bVar2, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i19);
                    } else {
                        f4 = f3;
                    }
                } else {
                    f4 = f3;
                    if (i16 != -1 && (eVar2 = sparseArray.get(i16)) != null) {
                        eVar.R(p.d.b.LEFT, eVar2, p.d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i19);
                    }
                }
                if (i4 != -1) {
                    eVar9 = sparseArray.get(i4);
                    if (eVar9 != null) {
                        eVar.R(p.d.b.RIGHT, eVar9, p.d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i3);
                    }
                } else if (i5 != -1 && (eVar3 = sparseArray.get(i5)) != null) {
                    p.d.b bVar3 = p.d.b.RIGHT;
                    eVar.R(bVar3, eVar3, bVar3, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i3);
                }
                i7 = bVar.f916h;
                if (i7 != -1) {
                    eVar8 = sparseArray.get(i7);
                    if (eVar8 != null) {
                        p.d.b bVar4 = p.d.b.TOP;
                        eVar.R(bVar4, eVar8, bVar4, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f937u);
                    }
                } else {
                    i8 = bVar.f918i;
                    if (i8 != -1 && (eVar4 = sparseArray.get(i8)) != null) {
                        eVar.R(p.d.b.TOP, eVar4, p.d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f937u);
                    }
                }
                i9 = bVar.f920j;
                if (i9 != -1) {
                    eVar7 = sparseArray.get(i9);
                    if (eVar7 != null) {
                        eVar.R(p.d.b.BOTTOM, eVar7, p.d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f939w);
                    }
                } else {
                    i10 = bVar.f922k;
                    if (i10 != -1 && (eVar5 = sparseArray.get(i10)) != null) {
                        p.d.b bVar5 = p.d.b.BOTTOM;
                        eVar.R(bVar5, eVar5, bVar5, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f939w);
                    }
                }
                i11 = bVar.f924l;
                if (i11 != -1) {
                    view2 = this.f878b.get(i11);
                    eVar6 = sparseArray.get(bVar.f924l);
                    if (eVar6 != null && view2 != null && (view2.getLayoutParams() instanceof b)) {
                        b bVar6 = (b) view2.getLayoutParams();
                        bVar.Y = true;
                        bVar6.Y = true;
                        p.d.b bVar7 = p.d.b.BASELINE;
                        eVar.k(bVar7).a(eVar6.k(bVar7), 0, -1, true);
                        eVar.d0(true);
                        bVar6.f929n0.d0(true);
                        eVar.k(p.d.b.TOP).k();
                        eVar.k(p.d.b.BOTTOM).k();
                    }
                }
                f5 = f4;
                if (f5 >= 0.0f) {
                    eVar.f0(f5);
                }
                f6 = bVar.A;
                if (f6 >= 0.0f) {
                    eVar.u0(f6);
                }
            }
            if (z2 && ((i12 = bVar.Q) != -1 || bVar.R != -1)) {
                eVar.s0(i12, bVar.R);
            }
            if (!bVar.W) {
                eVar.i0(p.e.b.FIXED);
                eVar.B0(((ViewGroup.MarginLayoutParams) bVar).width);
                if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                    eVar.i0(p.e.b.WRAP_CONTENT);
                }
            } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
                if (bVar.T) {
                    eVar.i0(p.e.b.MATCH_CONSTRAINT);
                } else {
                    eVar.i0(p.e.b.MATCH_PARENT);
                }
                eVar.k(p.d.b.LEFT).f5512e = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
                eVar.k(p.d.b.RIGHT).f5512e = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            } else {
                eVar.i0(p.e.b.MATCH_CONSTRAINT);
                eVar.B0(0);
            }
            if (!bVar.X) {
                eVar.x0(p.e.b.FIXED);
                eVar.e0(((ViewGroup.MarginLayoutParams) bVar).height);
                if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                    eVar.x0(p.e.b.WRAP_CONTENT);
                }
            } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
                if (bVar.U) {
                    eVar.x0(p.e.b.MATCH_CONSTRAINT);
                } else {
                    eVar.x0(p.e.b.MATCH_PARENT);
                }
                eVar.k(p.d.b.TOP).f5512e = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                eVar.k(p.d.b.BOTTOM).f5512e = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            } else {
                eVar.x0(p.e.b.MATCH_CONSTRAINT);
                eVar.e0(0);
            }
            eVar.b0(bVar.B);
            eVar.k0(bVar.E);
            eVar.z0(bVar.F);
            eVar.g0(bVar.G);
            eVar.v0(bVar.H);
            eVar.j0(bVar.I, bVar.K, bVar.M, bVar.O);
            eVar.y0(bVar.J, bVar.L, bVar.N, bVar.P);
        }
        i3 = i20;
        i4 = i17;
        float f9 = f8;
        i5 = i18;
        f3 = f9;
        i6 = bVar.f926m;
        if (i6 != -1) {
            eVar11 = sparseArray.get(i6);
            if (eVar11 != null) {
                eVar.i(eVar11, bVar.f930o, bVar.f928n);
            }
        } else {
            if (i15 != -1) {
                eVar10 = sparseArray.get(i15);
                if (eVar10 != null) {
                    p.d.b bVar8 = p.d.b.LEFT;
                    f4 = f3;
                    eVar.R(bVar8, eVar10, bVar8, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i19);
                } else {
                    f4 = f3;
                }
            } else {
                f4 = f3;
                if (i16 != -1) {
                    eVar.R(p.d.b.LEFT, eVar2, p.d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i19);
                }
            }
            if (i4 != -1) {
                eVar9 = sparseArray.get(i4);
                if (eVar9 != null) {
                    eVar.R(p.d.b.RIGHT, eVar9, p.d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i3);
                }
            } else if (i5 != -1) {
                p.d.b bVar9 = p.d.b.RIGHT;
                eVar.R(bVar9, eVar3, bVar9, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i3);
            }
            i7 = bVar.f916h;
            if (i7 != -1) {
                eVar8 = sparseArray.get(i7);
                if (eVar8 != null) {
                    p.d.b bVar10 = p.d.b.TOP;
                    eVar.R(bVar10, eVar8, bVar10, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f937u);
                }
            } else {
                i8 = bVar.f918i;
                if (i8 != -1) {
                    eVar.R(p.d.b.TOP, eVar4, p.d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f937u);
                }
            }
            i9 = bVar.f920j;
            if (i9 != -1) {
                eVar7 = sparseArray.get(i9);
                if (eVar7 != null) {
                    eVar.R(p.d.b.BOTTOM, eVar7, p.d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f939w);
                }
            } else {
                i10 = bVar.f922k;
                if (i10 != -1) {
                    p.d.b bVar11 = p.d.b.BOTTOM;
                    eVar.R(bVar11, eVar5, bVar11, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f939w);
                }
            }
            i11 = bVar.f924l;
            if (i11 != -1) {
                view2 = this.f878b.get(i11);
                eVar6 = sparseArray.get(bVar.f924l);
                if (eVar6 != null) {
                    b bVar12 = (b) view2.getLayoutParams();
                    bVar.Y = true;
                    bVar12.Y = true;
                    p.d.b bVar13 = p.d.b.BASELINE;
                    eVar.k(bVar13).a(eVar6.k(bVar13), 0, -1, true);
                    eVar.d0(true);
                    bVar12.f929n0.d0(true);
                    eVar.k(p.d.b.TOP).k();
                    eVar.k(p.d.b.BOTTOM).k();
                }
            }
            f5 = f4;
            if (f5 >= 0.0f) {
                eVar.f0(f5);
            }
            f6 = bVar.A;
            if (f6 >= 0.0f) {
                eVar.u0(f6);
            }
        }
        if (z2) {
            eVar.s0(i12, bVar.R);
        }
        if (!bVar.W) {
            eVar.i0(p.e.b.FIXED);
            eVar.B0(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                eVar.i0(p.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
            if (bVar.T) {
                eVar.i0(p.e.b.MATCH_CONSTRAINT);
            } else {
                eVar.i0(p.e.b.MATCH_PARENT);
            }
            eVar.k(p.d.b.LEFT).f5512e = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            eVar.k(p.d.b.RIGHT).f5512e = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            eVar.i0(p.e.b.MATCH_CONSTRAINT);
            eVar.B0(0);
        }
        if (!bVar.X) {
            eVar.x0(p.e.b.FIXED);
            eVar.e0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                eVar.x0(p.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
            if (bVar.U) {
                eVar.x0(p.e.b.MATCH_CONSTRAINT);
            } else {
                eVar.x0(p.e.b.MATCH_PARENT);
            }
            eVar.k(p.d.b.TOP).f5512e = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            eVar.k(p.d.b.BOTTOM).f5512e = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        } else {
            eVar.x0(p.e.b.MATCH_CONSTRAINT);
            eVar.e0(0);
        }
        eVar.b0(bVar.B);
        eVar.k0(bVar.E);
        eVar.z0(bVar.F);
        eVar.g0(bVar.G);
        eVar.v0(bVar.H);
        eVar.j0(bVar.I, bVar.K, bVar.M, bVar.O);
        eVar.y0(bVar.J, bVar.L, bVar.N, bVar.P);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f879c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.f879c.get(i3).k(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i5 = Integer.parseInt(strArrSplit[0]);
                        int i6 = Integer.parseInt(strArrSplit[1]);
                        int i7 = Integer.parseInt(strArrSplit[2]);
                        int i8 = (int) ((i5 / 1080.0f) * width);
                        int i9 = (int) ((i6 / 1920.0f) * height);
                        int i10 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f3 = i8;
                        float f4 = i9;
                        float f5 = i8 + ((int) ((i7 / 1080.0f) * width));
                        canvas.drawLine(f3, f4, f5, f4, paint);
                        float f6 = i9 + i10;
                        canvas.drawLine(f5, f4, f5, f6, paint);
                        canvas.drawLine(f5, f6, f3, f6, paint);
                        canvas.drawLine(f3, f6, f3, f4, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f3, f4, f5, f6, paint);
                        canvas.drawLine(f3, f6, f5, f4, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object f(int i3, Object obj) {
        if (i3 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.f890n;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f890n.get(str);
    }

    @Override // android.view.View
    public void forceLayout() {
        l();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f884h;
    }

    public int getMaxWidth() {
        return this.f883g;
    }

    public int getMinHeight() {
        return this.f882f;
    }

    public int getMinWidth() {
        return this.f881e;
    }

    public int getOptimizationLevel() {
        return this.f880d.S0();
    }

    public View h(int i3) {
        return this.f878b.get(i3);
    }

    public final p.e i(View view) {
        if (view == this) {
            return this.f880d;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f929n0;
    }

    protected boolean k() {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
        }
        return false;
    }

    protected void m(int i3) {
        this.f888l = new androidx.constraintlayout.widget.c(getContext(), this, i3);
    }

    protected void n(int i3, int i4, int i5, int i6, boolean z2, boolean z3) {
        c cVar = this.f898v;
        int i7 = cVar.f948e;
        int i8 = i5 + cVar.f947d;
        int i9 = i6 + i7;
        if (Build.VERSION.SDK_INT < 11) {
            setMeasuredDimension(i8, i9);
            this.f891o = i8;
            this.f892p = i9;
            return;
        }
        int iResolveSizeAndState = ViewGroup.resolveSizeAndState(i8, i3, 0);
        int iResolveSizeAndState2 = ViewGroup.resolveSizeAndState(i9, i4, 0) & 16777215;
        int iMin = Math.min(this.f883g, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f884h, iResolveSizeAndState2);
        if (z2) {
            iMin |= 16777216;
        }
        if (z3) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f891o = iMin;
        this.f892p = iMin2;
    }

    protected void o(p.f fVar, int i3, int i4, int i5) {
        int iMax;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        int iMax2 = Math.max(0, getPaddingTop());
        int iMax3 = Math.max(0, getPaddingBottom());
        int i6 = iMax2 + iMax3;
        int paddingWidth = getPaddingWidth();
        this.f898v.c(i4, i5, iMax2, iMax3, paddingWidth, i6);
        if (Build.VERSION.SDK_INT >= 17) {
            int iMax4 = Math.max(0, getPaddingStart());
            int iMax5 = Math.max(0, getPaddingEnd());
            if (iMax4 <= 0 && iMax5 <= 0) {
                iMax4 = Math.max(0, getPaddingLeft());
            } else if (k()) {
                iMax4 = iMax5;
            }
            iMax = iMax4;
        } else {
            iMax = Math.max(0, getPaddingLeft());
        }
        int i7 = size - paddingWidth;
        int i8 = size2 - i6;
        r(fVar, mode, i7, mode2, i8);
        fVar.Y0(i3, mode, i7, mode2, i8, this.f891o, this.f892p, iMax, iMax2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            b bVar = (b) childAt.getLayoutParams();
            p.e eVar = bVar.f929n0;
            if ((childAt.getVisibility() != 8 || bVar.Z || bVar.f903a0 || bVar.f907c0 || zIsInEditMode) && !bVar.f905b0) {
                int iO = eVar.O();
                int iP = eVar.P();
                int iN = eVar.N() + iO;
                int iT = eVar.t() + iP;
                childAt.layout(iO, iP, iN, iT);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iO, iP, iN, iT);
                }
            }
        }
        int size = this.f879c.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f879c.get(i8).i(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        this.f899w = i3;
        this.f900x = i4;
        this.f880d.d1(k());
        if (this.f885i) {
            this.f885i = false;
            if (s()) {
                this.f880d.f1();
            }
        }
        o(this.f880d, this.f886j, i3, i4);
        n(i3, i4, this.f880d.N(), this.f880d.t(), this.f880d.X0(), this.f880d.V0());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        p.e eVarI = i(view);
        if ((view instanceof Guideline) && !(eVarI instanceof p.g)) {
            b bVar = (b) view.getLayoutParams();
            p.g gVar = new p.g();
            bVar.f929n0 = gVar;
            bVar.Z = true;
            gVar.O0(bVar.S);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.m();
            ((b) view.getLayoutParams()).f903a0 = true;
            if (!this.f879c.contains(bVar2)) {
                this.f879c.add(bVar2);
            }
        }
        this.f878b.put(view.getId(), view);
        this.f885i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f878b.remove(view.getId());
        this.f880d.I0(i(view));
        this.f879c.remove(view);
        this.f885i = true;
    }

    public void q(int i3, Object obj, Object obj2) {
        if (i3 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f890n == null) {
                this.f890n = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.f890n.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[PHI: r2
  0x003e: PHI (r2v4 p.e$b) = (r2v3 p.e$b), (r2v0 p.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    protected void r(p.f fVar, int i3, int i4, int i5, int i6) {
        p.e.b bVar;
        c cVar = this.f898v;
        int i7 = cVar.f948e;
        int i8 = cVar.f947d;
        p.e.b bVar2 = p.e.b.FIXED;
        int childCount = getChildCount();
        if (i3 == Integer.MIN_VALUE) {
            bVar = p.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.f881e);
            }
        } else if (i3 == 0) {
            bVar = p.e.b.WRAP_CONTENT;
            i4 = childCount == 0 ? Math.max(0, this.f881e) : 0;
        } else if (i3 != 1073741824) {
            bVar = bVar2;
        } else {
            i4 = Math.min(this.f883g - i8, i4);
            bVar = bVar2;
        }
        if (i5 == Integer.MIN_VALUE) {
            bVar2 = p.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i6 = Math.max(0, this.f882f);
            }
        } else if (i5 == 0) {
            bVar2 = p.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i6 = Math.max(0, this.f882f);
            } else {
                i6 = 0;
            }
        } else if (i5 != 1073741824) {
            i6 = 0;
        } else {
            i6 = Math.min(this.f884h - i7, i6);
        }
        if (i4 != fVar.N() || i6 != fVar.t()) {
            fVar.U0();
        }
        fVar.C0(0);
        fVar.D0(0);
        fVar.p0(this.f883g - i8);
        fVar.o0(this.f884h - i7);
        fVar.r0(0);
        fVar.q0(0);
        fVar.i0(bVar);
        fVar.B0(i4);
        fVar.x0(bVar2);
        fVar.e0(i6);
        fVar.r0(this.f881e - i8);
        fVar.q0(this.f882f - i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        l();
        super.requestLayout();
    }

    public void setConstraintSet(d dVar) {
        this.f887k = dVar;
    }

    @Override // android.view.View
    public void setId(int i3) {
        this.f878b.remove(getId());
        super.setId(i3);
        this.f878b.put(getId(), this);
    }

    public void setMaxHeight(int i3) {
        if (i3 == this.f884h) {
            return;
        }
        this.f884h = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        if (i3 == this.f883g) {
            return;
        }
        this.f883g = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        if (i3 == this.f882f) {
            return;
        }
        this.f882f = i3;
        requestLayout();
    }

    public void setMinWidth(int i3) {
        if (i3 == this.f881e) {
            return;
        }
        this.f881e = i3;
        requestLayout();
    }

    public void setOnConstraintsChanged(f fVar) {
        androidx.constraintlayout.widget.c cVar = this.f888l;
        if (cVar != null) {
            cVar.c(fVar);
        }
    }

    public void setOptimizationLevel(int i3) {
        this.f886j = i3;
        this.f880d.c1(i3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f878b = new SparseArray<>();
        this.f879c = new ArrayList<>(4);
        this.f880d = new p.f();
        this.f881e = 0;
        this.f882f = 0;
        this.f883g = Integer.MAX_VALUE;
        this.f884h = Integer.MAX_VALUE;
        this.f885i = true;
        this.f886j = 263;
        this.f887k = null;
        this.f888l = null;
        this.f889m = -1;
        this.f890n = new HashMap<>();
        this.f891o = -1;
        this.f892p = -1;
        this.f893q = -1;
        this.f894r = -1;
        this.f895s = 0;
        this.f896t = 0;
        this.f897u = new SparseArray<>();
        this.f898v = new c(this);
        this.f899w = 0;
        this.f900x = 0;
        j(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f878b = new SparseArray<>();
        this.f879c = new ArrayList<>(4);
        this.f880d = new p.f();
        this.f881e = 0;
        this.f882f = 0;
        this.f883g = Integer.MAX_VALUE;
        this.f884h = Integer.MAX_VALUE;
        this.f885i = true;
        this.f886j = 263;
        this.f887k = null;
        this.f888l = null;
        this.f889m = -1;
        this.f890n = new HashMap<>();
        this.f891o = -1;
        this.f892p = -1;
        this.f893q = -1;
        this.f894r = -1;
        this.f895s = 0;
        this.f896t = 0;
        this.f897u = new SparseArray<>();
        this.f898v = new c(this);
        this.f899w = 0;
        this.f900x = 0;
        j(attributeSet, i3, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f878b = new SparseArray<>();
        this.f879c = new ArrayList<>(4);
        this.f880d = new p.f();
        this.f881e = 0;
        this.f882f = 0;
        this.f883g = Integer.MAX_VALUE;
        this.f884h = Integer.MAX_VALUE;
        this.f885i = true;
        this.f886j = 263;
        this.f887k = null;
        this.f888l = null;
        this.f889m = -1;
        this.f890n = new HashMap<>();
        this.f891o = -1;
        this.f892p = -1;
        this.f893q = -1;
        this.f894r = -1;
        this.f895s = 0;
        this.f896t = 0;
        this.f897u = new SparseArray<>();
        this.f898v = new c(this);
        this.f899w = 0;
        this.f900x = 0;
        j(attributeSet, i3, i4);
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        public String V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f902a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        boolean f903a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f904b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        boolean f905b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f906c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        boolean f907c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f908d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        int f909d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f910e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        int f911e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f912f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        int f913f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f914g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        int f915g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f916h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        int f917h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f918i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        int f919i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f920j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        float f921j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f922k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        int f923k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f924l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        int f925l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f926m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        float f927m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f928n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        p.e f929n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f930o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f931o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f932p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f933q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f934r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f935s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f936t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f937u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f938v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f939w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f940x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f941y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f942z;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f943a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f943a = sparseIntArray;
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(i.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(i.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            int i3;
            super(context, attributeSet);
            this.f902a = -1;
            this.f904b = -1;
            this.f906c = -1.0f;
            this.f908d = -1;
            this.f910e = -1;
            this.f912f = -1;
            this.f914g = -1;
            this.f916h = -1;
            this.f918i = -1;
            this.f920j = -1;
            this.f922k = -1;
            this.f924l = -1;
            this.f926m = -1;
            this.f928n = 0;
            this.f930o = 0.0f;
            this.f932p = -1;
            this.f933q = -1;
            this.f934r = -1;
            this.f935s = -1;
            this.f936t = -1;
            this.f937u = -1;
            this.f938v = -1;
            this.f939w = -1;
            this.f940x = -1;
            this.f941y = -1;
            this.f942z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.f903a0 = false;
            this.f905b0 = false;
            this.f907c0 = false;
            this.f909d0 = -1;
            this.f911e0 = -1;
            this.f913f0 = -1;
            this.f915g0 = -1;
            this.f917h0 = -1;
            this.f919i0 = -1;
            this.f921j0 = 0.5f;
            this.f929n0 = new p.e();
            this.f931o0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                int i5 = a.f943a.get(index);
                switch (i5) {
                    case 1:
                        this.S = typedArrayObtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f926m);
                        this.f926m = resourceId;
                        if (resourceId == -1) {
                            this.f926m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f928n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f928n);
                        break;
                    case 4:
                        float f3 = typedArrayObtainStyledAttributes.getFloat(index, this.f930o) % 360.0f;
                        this.f930o = f3;
                        if (f3 < 0.0f) {
                            this.f930o = (360.0f - f3) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f902a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f902a);
                        break;
                    case 6:
                        this.f904b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f904b);
                        break;
                    case 7:
                        this.f906c = typedArrayObtainStyledAttributes.getFloat(index, this.f906c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f908d);
                        this.f908d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f908d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f910e);
                        this.f910e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f910e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f912f);
                        this.f912f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f912f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f914g);
                        this.f914g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f914g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f916h);
                        this.f916h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f916h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f918i);
                        this.f918i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f918i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f920j);
                        this.f920j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f920j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f922k);
                        this.f922k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f922k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f924l);
                        this.f924l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f924l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f932p);
                        this.f932p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f932p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f933q);
                        this.f933q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f933q = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f934r);
                        this.f934r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f934r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f935s);
                        this.f935s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f935s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.f936t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f936t);
                        break;
                    case 22:
                        this.f937u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f937u);
                        break;
                    case 23:
                        this.f938v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f938v);
                        break;
                    case 24:
                        this.f939w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f939w);
                        break;
                    case 25:
                        this.f940x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f940x);
                        break;
                    case 26:
                        this.f941y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f941y);
                        break;
                    case 27:
                        this.T = typedArrayObtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = typedArrayObtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.f942z = typedArrayObtainStyledAttributes.getFloat(index, this.f942z);
                        break;
                    case 30:
                        this.A = typedArrayObtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.I = i6;
                        if (i6 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i7 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.J = i7;
                        if (i7 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                        break;
                    case 35:
                        this.O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        break;
                    case 36:
                        try {
                            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                        break;
                    case 38:
                        this.P = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.P));
                        this.J = 2;
                        break;
                    default:
                        switch (i5) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i3 = 0;
                                    } else {
                                        String strSubstring = this.B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i3 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.B.substring(i3);
                                        if (strSubstring2.length() > 0) {
                                            this.C = Float.parseFloat(strSubstring2);
                                        }
                                    } else {
                                        String strSubstring3 = this.B.substring(i3, iIndexOf2);
                                        String strSubstring4 = this.B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                            try {
                                                float f4 = Float.parseFloat(strSubstring3);
                                                float f5 = Float.parseFloat(strSubstring4);
                                                if (f4 > 0.0f && f5 > 0.0f) {
                                                    if (this.D == 1) {
                                                        this.C = Math.abs(f5 / f4);
                                                    } else {
                                                        this.C = Math.abs(f4 / f5);
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 46:
                                this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                                break;
                            case 47:
                                this.G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.H = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 50:
                                this.R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                break;
                            case 51:
                                this.V = typedArrayObtainStyledAttributes.getString(index);
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Z = false;
            this.W = true;
            this.X = true;
            int i3 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i3 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            int i4 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i4 == -2 && this.U) {
                this.X = false;
                if (this.J == 0) {
                    this.J = 1;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.W = false;
                if (i3 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (i4 == 0 || i4 == -1) {
                this.X = false;
                if (i4 == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.f906c == -1.0f && this.f902a == -1 && this.f904b == -1) {
                return;
            }
            this.Z = true;
            this.W = true;
            this.X = true;
            if (!(this.f929n0 instanceof p.g)) {
                this.f929n0 = new p.g();
            }
            ((p.g) this.f929n0).O0(this.S);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0052  */
        /* JADX WARN: Code duplicated, block: B:22:0x0059  */
        /* JADX WARN: Code duplicated, block: B:25:0x0060  */
        /* JADX WARN: Code duplicated, block: B:28:0x0066  */
        /* JADX WARN: Code duplicated, block: B:31:0x006c  */
        /* JADX WARN: Code duplicated, block: B:38:0x007e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0086 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x0088  */
        /* JADX WARN: Code duplicated, block: B:41:0x008f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:42:0x0091  */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int i3) {
            boolean z2;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            boolean z3 = false;
            if (Build.VERSION.SDK_INT >= 17) {
                super.resolveLayoutDirection(i3);
                if (1 == getLayoutDirection()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            this.f913f0 = -1;
            this.f915g0 = -1;
            this.f909d0 = -1;
            this.f911e0 = -1;
            this.f917h0 = -1;
            this.f919i0 = -1;
            this.f917h0 = this.f936t;
            this.f919i0 = this.f938v;
            float f3 = this.f942z;
            this.f921j0 = f3;
            int i10 = this.f902a;
            this.f923k0 = i10;
            int i11 = this.f904b;
            this.f925l0 = i11;
            float f4 = this.f906c;
            this.f927m0 = f4;
            if (z2) {
                int i12 = this.f932p;
                if (i12 != -1) {
                    this.f913f0 = i12;
                } else {
                    int i13 = this.f933q;
                    if (i13 != -1) {
                        this.f915g0 = i13;
                    } else {
                        i4 = this.f934r;
                        if (i4 != -1) {
                            this.f911e0 = i4;
                            z3 = true;
                        }
                        i5 = this.f935s;
                        if (i5 != -1) {
                            this.f909d0 = i5;
                            z3 = true;
                        }
                        i6 = this.f940x;
                        if (i6 != -1) {
                            this.f919i0 = i6;
                        }
                        i7 = this.f941y;
                        if (i7 != -1) {
                            this.f917h0 = i7;
                        }
                        if (z3) {
                            this.f921j0 = 1.0f - f3;
                        }
                        if (this.Z && this.S == 1) {
                            if (f4 != -1.0f) {
                                this.f927m0 = 1.0f - f4;
                                this.f923k0 = -1;
                                this.f925l0 = -1;
                            } else if (i10 != -1) {
                                this.f925l0 = i10;
                                this.f923k0 = -1;
                                this.f927m0 = -1.0f;
                            } else if (i11 != -1) {
                                this.f923k0 = i11;
                                this.f925l0 = -1;
                                this.f927m0 = -1.0f;
                            }
                        }
                    }
                }
                z3 = true;
                i4 = this.f934r;
                if (i4 != -1) {
                    this.f911e0 = i4;
                    z3 = true;
                }
                i5 = this.f935s;
                if (i5 != -1) {
                    this.f909d0 = i5;
                    z3 = true;
                }
                i6 = this.f940x;
                if (i6 != -1) {
                    this.f919i0 = i6;
                }
                i7 = this.f941y;
                if (i7 != -1) {
                    this.f917h0 = i7;
                }
                if (z3) {
                    this.f921j0 = 1.0f - f3;
                }
                if (this.Z) {
                    if (f4 != -1.0f) {
                        this.f927m0 = 1.0f - f4;
                        this.f923k0 = -1;
                        this.f925l0 = -1;
                    } else if (i10 != -1) {
                        this.f925l0 = i10;
                        this.f923k0 = -1;
                        this.f927m0 = -1.0f;
                    } else if (i11 != -1) {
                        this.f923k0 = i11;
                        this.f925l0 = -1;
                        this.f927m0 = -1.0f;
                    }
                }
            } else {
                int i14 = this.f932p;
                if (i14 != -1) {
                    this.f911e0 = i14;
                }
                int i15 = this.f933q;
                if (i15 != -1) {
                    this.f909d0 = i15;
                }
                int i16 = this.f934r;
                if (i16 != -1) {
                    this.f913f0 = i16;
                }
                int i17 = this.f935s;
                if (i17 != -1) {
                    this.f915g0 = i17;
                }
                int i18 = this.f940x;
                if (i18 != -1) {
                    this.f917h0 = i18;
                }
                int i19 = this.f941y;
                if (i19 != -1) {
                    this.f919i0 = i19;
                }
            }
            if (this.f934r == -1 && this.f935s == -1 && this.f933q == -1 && this.f932p == -1) {
                int i20 = this.f912f;
                if (i20 != -1) {
                    this.f913f0 = i20;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                    }
                } else {
                    int i21 = this.f914g;
                    if (i21 != -1) {
                        this.f915g0 = i21;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                        }
                    }
                }
                int i22 = this.f908d;
                if (i22 != -1) {
                    this.f909d0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                    return;
                }
                int i23 = this.f910e;
                if (i23 != -1) {
                    this.f911e0 = i23;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
            }
        }

        public b(int i3, int i4) {
            super(i3, i4);
            this.f902a = -1;
            this.f904b = -1;
            this.f906c = -1.0f;
            this.f908d = -1;
            this.f910e = -1;
            this.f912f = -1;
            this.f914g = -1;
            this.f916h = -1;
            this.f918i = -1;
            this.f920j = -1;
            this.f922k = -1;
            this.f924l = -1;
            this.f926m = -1;
            this.f928n = 0;
            this.f930o = 0.0f;
            this.f932p = -1;
            this.f933q = -1;
            this.f934r = -1;
            this.f935s = -1;
            this.f936t = -1;
            this.f937u = -1;
            this.f938v = -1;
            this.f939w = -1;
            this.f940x = -1;
            this.f941y = -1;
            this.f942z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.f903a0 = false;
            this.f905b0 = false;
            this.f907c0 = false;
            this.f909d0 = -1;
            this.f911e0 = -1;
            this.f913f0 = -1;
            this.f915g0 = -1;
            this.f917h0 = -1;
            this.f919i0 = -1;
            this.f921j0 = 0.5f;
            this.f929n0 = new p.e();
            this.f931o0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f902a = -1;
            this.f904b = -1;
            this.f906c = -1.0f;
            this.f908d = -1;
            this.f910e = -1;
            this.f912f = -1;
            this.f914g = -1;
            this.f916h = -1;
            this.f918i = -1;
            this.f920j = -1;
            this.f922k = -1;
            this.f924l = -1;
            this.f926m = -1;
            this.f928n = 0;
            this.f930o = 0.0f;
            this.f932p = -1;
            this.f933q = -1;
            this.f934r = -1;
            this.f935s = -1;
            this.f936t = -1;
            this.f937u = -1;
            this.f938v = -1;
            this.f939w = -1;
            this.f940x = -1;
            this.f941y = -1;
            this.f942z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.f903a0 = false;
            this.f905b0 = false;
            this.f907c0 = false;
            this.f909d0 = -1;
            this.f911e0 = -1;
            this.f913f0 = -1;
            this.f915g0 = -1;
            this.f917h0 = -1;
            this.f919i0 = -1;
            this.f921j0 = 0.5f;
            this.f929n0 = new p.e();
            this.f931o0 = false;
        }
    }
}
