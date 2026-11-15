package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintSet.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f991d = {0, 4, 8};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static SparseIntArray f992e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, androidx.constraintlayout.widget.a> f993a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f994b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<Integer, a> f995c = new HashMap<>();

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0005d f997b = new C0005d();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f998c = new c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f999d = new b();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e f1000e = new e();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.a> f1001f = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i3, ConstraintLayout.b bVar) {
            this.f996a = i3;
            b bVar2 = this.f999d;
            bVar2.f1017h = bVar.f908d;
            bVar2.f1019i = bVar.f910e;
            bVar2.f1021j = bVar.f912f;
            bVar2.f1023k = bVar.f914g;
            bVar2.f1024l = bVar.f916h;
            bVar2.f1025m = bVar.f918i;
            bVar2.f1026n = bVar.f920j;
            bVar2.f1027o = bVar.f922k;
            bVar2.f1028p = bVar.f924l;
            bVar2.f1029q = bVar.f932p;
            bVar2.f1030r = bVar.f933q;
            bVar2.f1031s = bVar.f934r;
            bVar2.f1032t = bVar.f935s;
            bVar2.f1033u = bVar.f942z;
            bVar2.f1034v = bVar.A;
            bVar2.f1035w = bVar.B;
            bVar2.f1036x = bVar.f926m;
            bVar2.f1037y = bVar.f928n;
            bVar2.f1038z = bVar.f930o;
            bVar2.A = bVar.Q;
            bVar2.B = bVar.R;
            bVar2.C = bVar.S;
            bVar2.f1015g = bVar.f906c;
            bVar2.f1011e = bVar.f902a;
            bVar2.f1013f = bVar.f904b;
            bVar2.f1007c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f1009d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.D = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.E = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.F = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.P = bVar.F;
            bVar2.Q = bVar.E;
            bVar2.S = bVar.H;
            bVar2.R = bVar.G;
            bVar2.f1018h0 = bVar.T;
            bVar2.f1020i0 = bVar.U;
            bVar2.T = bVar.I;
            bVar2.U = bVar.J;
            bVar2.V = bVar.M;
            bVar2.W = bVar.N;
            bVar2.X = bVar.K;
            bVar2.Y = bVar.L;
            bVar2.Z = bVar.O;
            bVar2.f1004a0 = bVar.P;
            bVar2.f1016g0 = bVar.V;
            bVar2.K = bVar.f937u;
            bVar2.M = bVar.f939w;
            bVar2.J = bVar.f936t;
            bVar2.L = bVar.f938v;
            bVar2.O = bVar.f940x;
            bVar2.N = bVar.f941y;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar2.H = bVar.getMarginEnd();
                this.f999d.I = bVar.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i3, androidx.constraintlayout.widget.e.a aVar) {
            f(i3, aVar);
            this.f997b.f1050d = aVar.f1067p0;
            e eVar = this.f1000e;
            eVar.f1054b = aVar.f1070s0;
            eVar.f1055c = aVar.f1071t0;
            eVar.f1056d = aVar.f1072u0;
            eVar.f1057e = aVar.f1073v0;
            eVar.f1058f = aVar.f1074w0;
            eVar.f1059g = aVar.f1075x0;
            eVar.f1060h = aVar.f1076y0;
            eVar.f1061i = aVar.f1077z0;
            eVar.f1062j = aVar.A0;
            eVar.f1063k = aVar.B0;
            eVar.f1065m = aVar.f1069r0;
            eVar.f1064l = aVar.f1068q0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(androidx.constraintlayout.widget.b bVar, int i3, androidx.constraintlayout.widget.e.a aVar) {
            g(i3, aVar);
            if (bVar instanceof Barrier) {
                b bVar2 = this.f999d;
                bVar2.f1010d0 = 1;
                Barrier barrier = (Barrier) bVar;
                bVar2.f1006b0 = barrier.getType();
                this.f999d.f1012e0 = barrier.getReferencedIds();
                this.f999d.f1008c0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f999d;
            bVar.f908d = bVar2.f1017h;
            bVar.f910e = bVar2.f1019i;
            bVar.f912f = bVar2.f1021j;
            bVar.f914g = bVar2.f1023k;
            bVar.f916h = bVar2.f1024l;
            bVar.f918i = bVar2.f1025m;
            bVar.f920j = bVar2.f1026n;
            bVar.f922k = bVar2.f1027o;
            bVar.f924l = bVar2.f1028p;
            bVar.f932p = bVar2.f1029q;
            bVar.f933q = bVar2.f1030r;
            bVar.f934r = bVar2.f1031s;
            bVar.f935s = bVar2.f1032t;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.D;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.E;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.F;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.G;
            bVar.f940x = bVar2.O;
            bVar.f941y = bVar2.N;
            bVar.f937u = bVar2.K;
            bVar.f939w = bVar2.M;
            bVar.f942z = bVar2.f1033u;
            bVar.A = bVar2.f1034v;
            bVar.f926m = bVar2.f1036x;
            bVar.f928n = bVar2.f1037y;
            bVar.f930o = bVar2.f1038z;
            bVar.B = bVar2.f1035w;
            bVar.Q = bVar2.A;
            bVar.R = bVar2.B;
            bVar.F = bVar2.P;
            bVar.E = bVar2.Q;
            bVar.H = bVar2.S;
            bVar.G = bVar2.R;
            bVar.T = bVar2.f1018h0;
            bVar.U = bVar2.f1020i0;
            bVar.I = bVar2.T;
            bVar.J = bVar2.U;
            bVar.M = bVar2.V;
            bVar.N = bVar2.W;
            bVar.K = bVar2.X;
            bVar.L = bVar2.Y;
            bVar.O = bVar2.Z;
            bVar.P = bVar2.f1004a0;
            bVar.S = bVar2.C;
            bVar.f906c = bVar2.f1015g;
            bVar.f902a = bVar2.f1011e;
            bVar.f904b = bVar2.f1013f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f1007c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f1009d;
            String str = bVar2.f1016g0;
            if (str != null) {
                bVar.V = str;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.setMarginStart(bVar2.I);
                bVar.setMarginEnd(this.f999d.H);
            }
            bVar.a();
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f999d.a(this.f999d);
            aVar.f998c.a(this.f998c);
            aVar.f997b.a(this.f997b);
            aVar.f1000e.a(this.f1000e);
            aVar.f996a = this.f996a;
            return aVar;
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class b {

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        private static SparseIntArray f1002k0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1009d;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int[] f1012e0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public String f1014f0;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public String f1016g0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1003a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1005b = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1011e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1013f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f1015g = -1.0f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1017h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1019i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1021j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1023k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1024l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1025m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1026n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1027o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1028p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1029q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f1030r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f1031s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f1032t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f1033u = 0.5f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public float f1034v = 0.5f;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f1035w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f1036x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f1037y = 0;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f1038z = 0.0f;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public float f1004a0 = 1.0f;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f1006b0 = -1;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f1008c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f1010d0 = -1;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f1018h0 = false;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f1020i0 = false;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public boolean f1022j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1002k0 = sparseIntArray;
            sparseIntArray.append(i.Layout_layout_constraintLeft_toLeftOf, 24);
            f1002k0.append(i.Layout_layout_constraintLeft_toRightOf, 25);
            f1002k0.append(i.Layout_layout_constraintRight_toLeftOf, 28);
            f1002k0.append(i.Layout_layout_constraintRight_toRightOf, 29);
            f1002k0.append(i.Layout_layout_constraintTop_toTopOf, 35);
            f1002k0.append(i.Layout_layout_constraintTop_toBottomOf, 34);
            f1002k0.append(i.Layout_layout_constraintBottom_toTopOf, 4);
            f1002k0.append(i.Layout_layout_constraintBottom_toBottomOf, 3);
            f1002k0.append(i.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f1002k0.append(i.Layout_layout_editor_absoluteX, 6);
            f1002k0.append(i.Layout_layout_editor_absoluteY, 7);
            f1002k0.append(i.Layout_layout_constraintGuide_begin, 17);
            f1002k0.append(i.Layout_layout_constraintGuide_end, 18);
            f1002k0.append(i.Layout_layout_constraintGuide_percent, 19);
            f1002k0.append(i.Layout_android_orientation, 26);
            f1002k0.append(i.Layout_layout_constraintStart_toEndOf, 31);
            f1002k0.append(i.Layout_layout_constraintStart_toStartOf, 32);
            f1002k0.append(i.Layout_layout_constraintEnd_toStartOf, 10);
            f1002k0.append(i.Layout_layout_constraintEnd_toEndOf, 9);
            f1002k0.append(i.Layout_layout_goneMarginLeft, 13);
            f1002k0.append(i.Layout_layout_goneMarginTop, 16);
            f1002k0.append(i.Layout_layout_goneMarginRight, 14);
            f1002k0.append(i.Layout_layout_goneMarginBottom, 11);
            f1002k0.append(i.Layout_layout_goneMarginStart, 15);
            f1002k0.append(i.Layout_layout_goneMarginEnd, 12);
            f1002k0.append(i.Layout_layout_constraintVertical_weight, 38);
            f1002k0.append(i.Layout_layout_constraintHorizontal_weight, 37);
            f1002k0.append(i.Layout_layout_constraintHorizontal_chainStyle, 39);
            f1002k0.append(i.Layout_layout_constraintVertical_chainStyle, 40);
            f1002k0.append(i.Layout_layout_constraintHorizontal_bias, 20);
            f1002k0.append(i.Layout_layout_constraintVertical_bias, 36);
            f1002k0.append(i.Layout_layout_constraintDimensionRatio, 5);
            f1002k0.append(i.Layout_layout_constraintLeft_creator, 76);
            f1002k0.append(i.Layout_layout_constraintTop_creator, 76);
            f1002k0.append(i.Layout_layout_constraintRight_creator, 76);
            f1002k0.append(i.Layout_layout_constraintBottom_creator, 76);
            f1002k0.append(i.Layout_layout_constraintBaseline_creator, 76);
            f1002k0.append(i.Layout_android_layout_marginLeft, 23);
            f1002k0.append(i.Layout_android_layout_marginRight, 27);
            f1002k0.append(i.Layout_android_layout_marginStart, 30);
            f1002k0.append(i.Layout_android_layout_marginEnd, 8);
            f1002k0.append(i.Layout_android_layout_marginTop, 33);
            f1002k0.append(i.Layout_android_layout_marginBottom, 2);
            f1002k0.append(i.Layout_android_layout_width, 22);
            f1002k0.append(i.Layout_android_layout_height, 21);
            f1002k0.append(i.Layout_layout_constraintCircle, 61);
            f1002k0.append(i.Layout_layout_constraintCircleRadius, 62);
            f1002k0.append(i.Layout_layout_constraintCircleAngle, 63);
            f1002k0.append(i.Layout_layout_constraintWidth_percent, 69);
            f1002k0.append(i.Layout_layout_constraintHeight_percent, 70);
            f1002k0.append(i.Layout_chainUseRtl, 71);
            f1002k0.append(i.Layout_barrierDirection, 72);
            f1002k0.append(i.Layout_barrierMargin, 73);
            f1002k0.append(i.Layout_constraint_referenced_ids, 74);
            f1002k0.append(i.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(b bVar) {
            this.f1003a = bVar.f1003a;
            this.f1007c = bVar.f1007c;
            this.f1005b = bVar.f1005b;
            this.f1009d = bVar.f1009d;
            this.f1011e = bVar.f1011e;
            this.f1013f = bVar.f1013f;
            this.f1015g = bVar.f1015g;
            this.f1017h = bVar.f1017h;
            this.f1019i = bVar.f1019i;
            this.f1021j = bVar.f1021j;
            this.f1023k = bVar.f1023k;
            this.f1024l = bVar.f1024l;
            this.f1025m = bVar.f1025m;
            this.f1026n = bVar.f1026n;
            this.f1027o = bVar.f1027o;
            this.f1028p = bVar.f1028p;
            this.f1029q = bVar.f1029q;
            this.f1030r = bVar.f1030r;
            this.f1031s = bVar.f1031s;
            this.f1032t = bVar.f1032t;
            this.f1033u = bVar.f1033u;
            this.f1034v = bVar.f1034v;
            this.f1035w = bVar.f1035w;
            this.f1036x = bVar.f1036x;
            this.f1037y = bVar.f1037y;
            this.f1038z = bVar.f1038z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f1004a0 = bVar.f1004a0;
            this.f1006b0 = bVar.f1006b0;
            this.f1008c0 = bVar.f1008c0;
            this.f1010d0 = bVar.f1010d0;
            this.f1016g0 = bVar.f1016g0;
            int[] iArr = bVar.f1012e0;
            if (iArr != null) {
                this.f1012e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f1012e0 = null;
            }
            this.f1014f0 = bVar.f1014f0;
            this.f1018h0 = bVar.f1018h0;
            this.f1020i0 = bVar.f1020i0;
            this.f1022j0 = bVar.f1022j0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Layout);
            this.f1005b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = f1002k0.get(index);
                if (i4 == 80) {
                    this.f1018h0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1018h0);
                } else if (i4 != 81) {
                    switch (i4) {
                        case 1:
                            this.f1028p = d.o(typedArrayObtainStyledAttributes, index, this.f1028p);
                            break;
                        case 2:
                            this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        case 3:
                            this.f1027o = d.o(typedArrayObtainStyledAttributes, index, this.f1027o);
                            break;
                        case 4:
                            this.f1026n = d.o(typedArrayObtainStyledAttributes, index, this.f1026n);
                            break;
                        case 5:
                            this.f1035w = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            break;
                        case 7:
                            this.B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            break;
                        case 8:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            }
                            break;
                        case 9:
                            this.f1032t = d.o(typedArrayObtainStyledAttributes, index, this.f1032t);
                            break;
                        case 10:
                            this.f1031s = d.o(typedArrayObtainStyledAttributes, index, this.f1031s);
                            break;
                        case 11:
                            this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        case 12:
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        case 13:
                            this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        case 14:
                            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        case 15:
                            this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        case 16:
                            this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        case 17:
                            this.f1011e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1011e);
                            break;
                        case 18:
                            this.f1013f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1013f);
                            break;
                        case 19:
                            this.f1015g = typedArrayObtainStyledAttributes.getFloat(index, this.f1015g);
                            break;
                        case 20:
                            this.f1033u = typedArrayObtainStyledAttributes.getFloat(index, this.f1033u);
                            break;
                        case 21:
                            this.f1009d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f1009d);
                            break;
                        case 22:
                            this.f1007c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f1007c);
                            break;
                        case 23:
                            this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            break;
                        case 24:
                            this.f1017h = d.o(typedArrayObtainStyledAttributes, index, this.f1017h);
                            break;
                        case 25:
                            this.f1019i = d.o(typedArrayObtainStyledAttributes, index, this.f1019i);
                            break;
                        case 26:
                            this.C = typedArrayObtainStyledAttributes.getInt(index, this.C);
                            break;
                        case 27:
                            this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            break;
                        case 28:
                            this.f1021j = d.o(typedArrayObtainStyledAttributes, index, this.f1021j);
                            break;
                        case 29:
                            this.f1023k = d.o(typedArrayObtainStyledAttributes, index, this.f1023k);
                            break;
                        case 30:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            }
                            break;
                        case 31:
                            this.f1029q = d.o(typedArrayObtainStyledAttributes, index, this.f1029q);
                            break;
                        case 32:
                            this.f1030r = d.o(typedArrayObtainStyledAttributes, index, this.f1030r);
                            break;
                        case 33:
                            this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            break;
                        case 34:
                            this.f1025m = d.o(typedArrayObtainStyledAttributes, index, this.f1025m);
                            break;
                        case 35:
                            this.f1024l = d.o(typedArrayObtainStyledAttributes, index, this.f1024l);
                            break;
                        case 36:
                            this.f1034v = typedArrayObtainStyledAttributes.getFloat(index, this.f1034v);
                            break;
                        case 37:
                            this.Q = typedArrayObtainStyledAttributes.getFloat(index, this.Q);
                            break;
                        case 38:
                            this.P = typedArrayObtainStyledAttributes.getFloat(index, this.P);
                            break;
                        case 39:
                            this.R = typedArrayObtainStyledAttributes.getInt(index, this.R);
                            break;
                        case 40:
                            this.S = typedArrayObtainStyledAttributes.getInt(index, this.S);
                            break;
                        default:
                            switch (i4) {
                                case 54:
                                    this.T = typedArrayObtainStyledAttributes.getInt(index, this.T);
                                    break;
                                case 55:
                                    this.U = typedArrayObtainStyledAttributes.getInt(index, this.U);
                                    break;
                                case 56:
                                    this.V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    break;
                                case 57:
                                    this.W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    break;
                                case 58:
                                    this.X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    break;
                                case 59:
                                    this.Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    break;
                                default:
                                    switch (i4) {
                                        case 61:
                                            this.f1036x = d.o(typedArrayObtainStyledAttributes, index, this.f1036x);
                                            break;
                                        case 62:
                                            this.f1037y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1037y);
                                            break;
                                        case 63:
                                            this.f1038z = typedArrayObtainStyledAttributes.getFloat(index, this.f1038z);
                                            break;
                                        default:
                                            switch (i4) {
                                                case 69:
                                                    this.Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f1004a0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.f1006b0 = typedArrayObtainStyledAttributes.getInt(index, this.f1006b0);
                                                    break;
                                                case 73:
                                                    this.f1008c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1008c0);
                                                    break;
                                                case 74:
                                                    this.f1014f0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.f1022j0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1022j0);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1002k0.get(index));
                                                    break;
                                                case 77:
                                                    this.f1016g0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1002k0.get(index));
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    this.f1020i0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1020i0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static SparseIntArray f1039h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1040a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1041b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1042c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1043d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1044e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f1045f = Float.NaN;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f1046g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1039h = sparseIntArray;
            sparseIntArray.append(i.Motion_motionPathRotate, 1);
            f1039h.append(i.Motion_pathMotionArc, 2);
            f1039h.append(i.Motion_transitionEasing, 3);
            f1039h.append(i.Motion_drawPath, 4);
            f1039h.append(i.Motion_animate_relativeTo, 5);
            f1039h.append(i.Motion_motionStagger, 6);
        }

        public void a(c cVar) {
            this.f1040a = cVar.f1040a;
            this.f1041b = cVar.f1041b;
            this.f1042c = cVar.f1042c;
            this.f1043d = cVar.f1043d;
            this.f1044e = cVar.f1044e;
            this.f1046g = cVar.f1046g;
            this.f1045f = cVar.f1045f;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Motion);
            this.f1040a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                switch (f1039h.get(index)) {
                    case 1:
                        this.f1046g = typedArrayObtainStyledAttributes.getFloat(index, this.f1046g);
                        break;
                    case 2:
                        this.f1043d = typedArrayObtainStyledAttributes.getInt(index, this.f1043d);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f1042c = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f1042c = m.a.f5296c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f1044e = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1041b = d.o(typedArrayObtainStyledAttributes, index, this.f1041b);
                        break;
                    case 6:
                        this.f1045f = typedArrayObtainStyledAttributes.getFloat(index, this.f1045f);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class C0005d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1047a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1048b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1049c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1050d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1051e = Float.NaN;

        public void a(C0005d c0005d) {
            this.f1047a = c0005d.f1047a;
            this.f1048b = c0005d.f1048b;
            this.f1050d = c0005d.f1050d;
            this.f1051e = c0005d.f1051e;
            this.f1049c = c0005d.f1049c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.PropertySet);
            this.f1047a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == i.PropertySet_android_alpha) {
                    this.f1050d = typedArrayObtainStyledAttributes.getFloat(index, this.f1050d);
                } else if (index == i.PropertySet_android_visibility) {
                    this.f1048b = typedArrayObtainStyledAttributes.getInt(index, this.f1048b);
                    this.f1048b = d.f991d[this.f1048b];
                } else if (index == i.PropertySet_visibilityMode) {
                    this.f1049c = typedArrayObtainStyledAttributes.getInt(index, this.f1049c);
                } else if (index == i.PropertySet_motionProgress) {
                    this.f1051e = typedArrayObtainStyledAttributes.getFloat(index, this.f1051e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class e {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static SparseIntArray f1052n;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1053a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1054b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1055c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1056d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1057e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f1058f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f1059g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f1060h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f1061i = 0.0f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f1062j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f1063k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f1064l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f1065m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1052n = sparseIntArray;
            sparseIntArray.append(i.Transform_android_rotation, 1);
            f1052n.append(i.Transform_android_rotationX, 2);
            f1052n.append(i.Transform_android_rotationY, 3);
            f1052n.append(i.Transform_android_scaleX, 4);
            f1052n.append(i.Transform_android_scaleY, 5);
            f1052n.append(i.Transform_android_transformPivotX, 6);
            f1052n.append(i.Transform_android_transformPivotY, 7);
            f1052n.append(i.Transform_android_translationX, 8);
            f1052n.append(i.Transform_android_translationY, 9);
            f1052n.append(i.Transform_android_translationZ, 10);
            f1052n.append(i.Transform_android_elevation, 11);
        }

        public void a(e eVar) {
            this.f1053a = eVar.f1053a;
            this.f1054b = eVar.f1054b;
            this.f1055c = eVar.f1055c;
            this.f1056d = eVar.f1056d;
            this.f1057e = eVar.f1057e;
            this.f1058f = eVar.f1058f;
            this.f1059g = eVar.f1059g;
            this.f1060h = eVar.f1060h;
            this.f1061i = eVar.f1061i;
            this.f1062j = eVar.f1062j;
            this.f1063k = eVar.f1063k;
            this.f1064l = eVar.f1064l;
            this.f1065m = eVar.f1065m;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Transform);
            this.f1053a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                switch (f1052n.get(index)) {
                    case 1:
                        this.f1054b = typedArrayObtainStyledAttributes.getFloat(index, this.f1054b);
                        break;
                    case 2:
                        this.f1055c = typedArrayObtainStyledAttributes.getFloat(index, this.f1055c);
                        break;
                    case 3:
                        this.f1056d = typedArrayObtainStyledAttributes.getFloat(index, this.f1056d);
                        break;
                    case 4:
                        this.f1057e = typedArrayObtainStyledAttributes.getFloat(index, this.f1057e);
                        break;
                    case 5:
                        this.f1058f = typedArrayObtainStyledAttributes.getFloat(index, this.f1058f);
                        break;
                    case 6:
                        this.f1059g = typedArrayObtainStyledAttributes.getDimension(index, this.f1059g);
                        break;
                    case 7:
                        this.f1060h = typedArrayObtainStyledAttributes.getDimension(index, this.f1060h);
                        break;
                    case 8:
                        this.f1061i = typedArrayObtainStyledAttributes.getDimension(index, this.f1061i);
                        break;
                    case 9:
                        this.f1062j = typedArrayObtainStyledAttributes.getDimension(index, this.f1062j);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f1063k = typedArrayObtainStyledAttributes.getDimension(index, this.f1063k);
                        }
                        break;
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f1064l = true;
                            this.f1065m = typedArrayObtainStyledAttributes.getDimension(index, this.f1065m);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f992e = sparseIntArray;
        sparseIntArray.append(i.Constraint_layout_constraintLeft_toLeftOf, 25);
        f992e.append(i.Constraint_layout_constraintLeft_toRightOf, 26);
        f992e.append(i.Constraint_layout_constraintRight_toLeftOf, 29);
        f992e.append(i.Constraint_layout_constraintRight_toRightOf, 30);
        f992e.append(i.Constraint_layout_constraintTop_toTopOf, 36);
        f992e.append(i.Constraint_layout_constraintTop_toBottomOf, 35);
        f992e.append(i.Constraint_layout_constraintBottom_toTopOf, 4);
        f992e.append(i.Constraint_layout_constraintBottom_toBottomOf, 3);
        f992e.append(i.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f992e.append(i.Constraint_layout_editor_absoluteX, 6);
        f992e.append(i.Constraint_layout_editor_absoluteY, 7);
        f992e.append(i.Constraint_layout_constraintGuide_begin, 17);
        f992e.append(i.Constraint_layout_constraintGuide_end, 18);
        f992e.append(i.Constraint_layout_constraintGuide_percent, 19);
        f992e.append(i.Constraint_android_orientation, 27);
        f992e.append(i.Constraint_layout_constraintStart_toEndOf, 32);
        f992e.append(i.Constraint_layout_constraintStart_toStartOf, 33);
        f992e.append(i.Constraint_layout_constraintEnd_toStartOf, 10);
        f992e.append(i.Constraint_layout_constraintEnd_toEndOf, 9);
        f992e.append(i.Constraint_layout_goneMarginLeft, 13);
        f992e.append(i.Constraint_layout_goneMarginTop, 16);
        f992e.append(i.Constraint_layout_goneMarginRight, 14);
        f992e.append(i.Constraint_layout_goneMarginBottom, 11);
        f992e.append(i.Constraint_layout_goneMarginStart, 15);
        f992e.append(i.Constraint_layout_goneMarginEnd, 12);
        f992e.append(i.Constraint_layout_constraintVertical_weight, 40);
        f992e.append(i.Constraint_layout_constraintHorizontal_weight, 39);
        f992e.append(i.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f992e.append(i.Constraint_layout_constraintVertical_chainStyle, 42);
        f992e.append(i.Constraint_layout_constraintHorizontal_bias, 20);
        f992e.append(i.Constraint_layout_constraintVertical_bias, 37);
        f992e.append(i.Constraint_layout_constraintDimensionRatio, 5);
        f992e.append(i.Constraint_layout_constraintLeft_creator, 82);
        f992e.append(i.Constraint_layout_constraintTop_creator, 82);
        f992e.append(i.Constraint_layout_constraintRight_creator, 82);
        f992e.append(i.Constraint_layout_constraintBottom_creator, 82);
        f992e.append(i.Constraint_layout_constraintBaseline_creator, 82);
        f992e.append(i.Constraint_android_layout_marginLeft, 24);
        f992e.append(i.Constraint_android_layout_marginRight, 28);
        f992e.append(i.Constraint_android_layout_marginStart, 31);
        f992e.append(i.Constraint_android_layout_marginEnd, 8);
        f992e.append(i.Constraint_android_layout_marginTop, 34);
        f992e.append(i.Constraint_android_layout_marginBottom, 2);
        f992e.append(i.Constraint_android_layout_width, 23);
        f992e.append(i.Constraint_android_layout_height, 21);
        f992e.append(i.Constraint_android_visibility, 22);
        f992e.append(i.Constraint_android_alpha, 43);
        f992e.append(i.Constraint_android_elevation, 44);
        f992e.append(i.Constraint_android_rotationX, 45);
        f992e.append(i.Constraint_android_rotationY, 46);
        f992e.append(i.Constraint_android_rotation, 60);
        f992e.append(i.Constraint_android_scaleX, 47);
        f992e.append(i.Constraint_android_scaleY, 48);
        f992e.append(i.Constraint_android_transformPivotX, 49);
        f992e.append(i.Constraint_android_transformPivotY, 50);
        f992e.append(i.Constraint_android_translationX, 51);
        f992e.append(i.Constraint_android_translationY, 52);
        f992e.append(i.Constraint_android_translationZ, 53);
        f992e.append(i.Constraint_layout_constraintWidth_default, 54);
        f992e.append(i.Constraint_layout_constraintHeight_default, 55);
        f992e.append(i.Constraint_layout_constraintWidth_max, 56);
        f992e.append(i.Constraint_layout_constraintHeight_max, 57);
        f992e.append(i.Constraint_layout_constraintWidth_min, 58);
        f992e.append(i.Constraint_layout_constraintHeight_min, 59);
        f992e.append(i.Constraint_layout_constraintCircle, 61);
        f992e.append(i.Constraint_layout_constraintCircleRadius, 62);
        f992e.append(i.Constraint_layout_constraintCircleAngle, 63);
        f992e.append(i.Constraint_animate_relativeTo, 64);
        f992e.append(i.Constraint_transitionEasing, 65);
        f992e.append(i.Constraint_drawPath, 66);
        f992e.append(i.Constraint_transitionPathRotate, 67);
        f992e.append(i.Constraint_motionStagger, 79);
        f992e.append(i.Constraint_android_id, 38);
        f992e.append(i.Constraint_motionProgress, 68);
        f992e.append(i.Constraint_layout_constraintWidth_percent, 69);
        f992e.append(i.Constraint_layout_constraintHeight_percent, 70);
        f992e.append(i.Constraint_chainUseRtl, 71);
        f992e.append(i.Constraint_barrierDirection, 72);
        f992e.append(i.Constraint_barrierMargin, 73);
        f992e.append(i.Constraint_constraint_referenced_ids, 74);
        f992e.append(i.Constraint_barrierAllowsGoneWidgets, 75);
        f992e.append(i.Constraint_pathMotionArc, 76);
        f992e.append(i.Constraint_layout_constraintTag, 77);
        f992e.append(i.Constraint_visibilityMode, 78);
        f992e.append(i.Constraint_layout_constrainedWidth, 80);
        f992e.append(i.Constraint_layout_constrainedHeight, 81);
    }

    private int[] j(View view, String str) {
        int iIntValue;
        Object objF;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < strArrSplit.length) {
            String strTrim = strArrSplit[i3].trim();
            try {
                iIntValue = h.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objF = ((ConstraintLayout) view.getParent()).f(0, strTrim)) != null && (objF instanceof Integer)) {
                iIntValue = ((Integer) objF).intValue();
            }
            iArr[i4] = iIntValue;
            i3++;
            i4++;
        }
        return i4 != strArrSplit.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private a k(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.Constraint);
        p(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private a l(int i3) {
        if (!this.f995c.containsKey(Integer.valueOf(i3))) {
            this.f995c.put(Integer.valueOf(i3), new a());
        }
        return this.f995c.get(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(TypedArray typedArray, int i3, int i4) {
        int resourceId = typedArray.getResourceId(i3, i4);
        return resourceId == -1 ? typedArray.getInt(i3, -1) : resourceId;
    }

    private void p(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index != i.Constraint_android_id && i.Constraint_android_layout_marginStart != index && i.Constraint_android_layout_marginEnd != index) {
                aVar.f998c.f1040a = true;
                aVar.f999d.f1005b = true;
                aVar.f997b.f1047a = true;
                aVar.f1000e.f1053a = true;
            }
            switch (f992e.get(index)) {
                case 1:
                    b bVar = aVar.f999d;
                    bVar.f1028p = o(typedArray, index, bVar.f1028p);
                    break;
                case 2:
                    b bVar2 = aVar.f999d;
                    bVar2.G = typedArray.getDimensionPixelSize(index, bVar2.G);
                    break;
                case 3:
                    b bVar3 = aVar.f999d;
                    bVar3.f1027o = o(typedArray, index, bVar3.f1027o);
                    break;
                case 4:
                    b bVar4 = aVar.f999d;
                    bVar4.f1026n = o(typedArray, index, bVar4.f1026n);
                    break;
                case 5:
                    aVar.f999d.f1035w = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f999d;
                    bVar5.A = typedArray.getDimensionPixelOffset(index, bVar5.A);
                    break;
                case 7:
                    b bVar6 = aVar.f999d;
                    bVar6.B = typedArray.getDimensionPixelOffset(index, bVar6.B);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.f999d;
                        bVar7.H = typedArray.getDimensionPixelSize(index, bVar7.H);
                    }
                    break;
                case 9:
                    b bVar8 = aVar.f999d;
                    bVar8.f1032t = o(typedArray, index, bVar8.f1032t);
                    break;
                case 10:
                    b bVar9 = aVar.f999d;
                    bVar9.f1031s = o(typedArray, index, bVar9.f1031s);
                    break;
                case 11:
                    b bVar10 = aVar.f999d;
                    bVar10.M = typedArray.getDimensionPixelSize(index, bVar10.M);
                    break;
                case 12:
                    b bVar11 = aVar.f999d;
                    bVar11.N = typedArray.getDimensionPixelSize(index, bVar11.N);
                    break;
                case 13:
                    b bVar12 = aVar.f999d;
                    bVar12.J = typedArray.getDimensionPixelSize(index, bVar12.J);
                    break;
                case 14:
                    b bVar13 = aVar.f999d;
                    bVar13.L = typedArray.getDimensionPixelSize(index, bVar13.L);
                    break;
                case 15:
                    b bVar14 = aVar.f999d;
                    bVar14.O = typedArray.getDimensionPixelSize(index, bVar14.O);
                    break;
                case 16:
                    b bVar15 = aVar.f999d;
                    bVar15.K = typedArray.getDimensionPixelSize(index, bVar15.K);
                    break;
                case 17:
                    b bVar16 = aVar.f999d;
                    bVar16.f1011e = typedArray.getDimensionPixelOffset(index, bVar16.f1011e);
                    break;
                case 18:
                    b bVar17 = aVar.f999d;
                    bVar17.f1013f = typedArray.getDimensionPixelOffset(index, bVar17.f1013f);
                    break;
                case 19:
                    b bVar18 = aVar.f999d;
                    bVar18.f1015g = typedArray.getFloat(index, bVar18.f1015g);
                    break;
                case 20:
                    b bVar19 = aVar.f999d;
                    bVar19.f1033u = typedArray.getFloat(index, bVar19.f1033u);
                    break;
                case 21:
                    b bVar20 = aVar.f999d;
                    bVar20.f1009d = typedArray.getLayoutDimension(index, bVar20.f1009d);
                    break;
                case 22:
                    C0005d c0005d = aVar.f997b;
                    c0005d.f1048b = typedArray.getInt(index, c0005d.f1048b);
                    C0005d c0005d2 = aVar.f997b;
                    c0005d2.f1048b = f991d[c0005d2.f1048b];
                    break;
                case 23:
                    b bVar21 = aVar.f999d;
                    bVar21.f1007c = typedArray.getLayoutDimension(index, bVar21.f1007c);
                    break;
                case 24:
                    b bVar22 = aVar.f999d;
                    bVar22.D = typedArray.getDimensionPixelSize(index, bVar22.D);
                    break;
                case 25:
                    b bVar23 = aVar.f999d;
                    bVar23.f1017h = o(typedArray, index, bVar23.f1017h);
                    break;
                case 26:
                    b bVar24 = aVar.f999d;
                    bVar24.f1019i = o(typedArray, index, bVar24.f1019i);
                    break;
                case 27:
                    b bVar25 = aVar.f999d;
                    bVar25.C = typedArray.getInt(index, bVar25.C);
                    break;
                case 28:
                    b bVar26 = aVar.f999d;
                    bVar26.E = typedArray.getDimensionPixelSize(index, bVar26.E);
                    break;
                case 29:
                    b bVar27 = aVar.f999d;
                    bVar27.f1021j = o(typedArray, index, bVar27.f1021j);
                    break;
                case 30:
                    b bVar28 = aVar.f999d;
                    bVar28.f1023k = o(typedArray, index, bVar28.f1023k);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.f999d;
                        bVar29.I = typedArray.getDimensionPixelSize(index, bVar29.I);
                    }
                    break;
                case 32:
                    b bVar30 = aVar.f999d;
                    bVar30.f1029q = o(typedArray, index, bVar30.f1029q);
                    break;
                case 33:
                    b bVar31 = aVar.f999d;
                    bVar31.f1030r = o(typedArray, index, bVar31.f1030r);
                    break;
                case 34:
                    b bVar32 = aVar.f999d;
                    bVar32.F = typedArray.getDimensionPixelSize(index, bVar32.F);
                    break;
                case 35:
                    b bVar33 = aVar.f999d;
                    bVar33.f1025m = o(typedArray, index, bVar33.f1025m);
                    break;
                case 36:
                    b bVar34 = aVar.f999d;
                    bVar34.f1024l = o(typedArray, index, bVar34.f1024l);
                    break;
                case 37:
                    b bVar35 = aVar.f999d;
                    bVar35.f1034v = typedArray.getFloat(index, bVar35.f1034v);
                    break;
                case 38:
                    aVar.f996a = typedArray.getResourceId(index, aVar.f996a);
                    break;
                case 39:
                    b bVar36 = aVar.f999d;
                    bVar36.Q = typedArray.getFloat(index, bVar36.Q);
                    break;
                case 40:
                    b bVar37 = aVar.f999d;
                    bVar37.P = typedArray.getFloat(index, bVar37.P);
                    break;
                case 41:
                    b bVar38 = aVar.f999d;
                    bVar38.R = typedArray.getInt(index, bVar38.R);
                    break;
                case 42:
                    b bVar39 = aVar.f999d;
                    bVar39.S = typedArray.getInt(index, bVar39.S);
                    break;
                case 43:
                    C0005d c0005d3 = aVar.f997b;
                    c0005d3.f1050d = typedArray.getFloat(index, c0005d3.f1050d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.f1000e;
                        eVar.f1064l = true;
                        eVar.f1065m = typedArray.getDimension(index, eVar.f1065m);
                    }
                    break;
                case 45:
                    e eVar2 = aVar.f1000e;
                    eVar2.f1055c = typedArray.getFloat(index, eVar2.f1055c);
                    break;
                case 46:
                    e eVar3 = aVar.f1000e;
                    eVar3.f1056d = typedArray.getFloat(index, eVar3.f1056d);
                    break;
                case 47:
                    e eVar4 = aVar.f1000e;
                    eVar4.f1057e = typedArray.getFloat(index, eVar4.f1057e);
                    break;
                case 48:
                    e eVar5 = aVar.f1000e;
                    eVar5.f1058f = typedArray.getFloat(index, eVar5.f1058f);
                    break;
                case 49:
                    e eVar6 = aVar.f1000e;
                    eVar6.f1059g = typedArray.getDimension(index, eVar6.f1059g);
                    break;
                case 50:
                    e eVar7 = aVar.f1000e;
                    eVar7.f1060h = typedArray.getDimension(index, eVar7.f1060h);
                    break;
                case 51:
                    e eVar8 = aVar.f1000e;
                    eVar8.f1061i = typedArray.getDimension(index, eVar8.f1061i);
                    break;
                case 52:
                    e eVar9 = aVar.f1000e;
                    eVar9.f1062j = typedArray.getDimension(index, eVar9.f1062j);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.f1000e;
                        eVar10.f1063k = typedArray.getDimension(index, eVar10.f1063k);
                    }
                    break;
                case 54:
                    b bVar40 = aVar.f999d;
                    bVar40.T = typedArray.getInt(index, bVar40.T);
                    break;
                case 55:
                    b bVar41 = aVar.f999d;
                    bVar41.U = typedArray.getInt(index, bVar41.U);
                    break;
                case 56:
                    b bVar42 = aVar.f999d;
                    bVar42.V = typedArray.getDimensionPixelSize(index, bVar42.V);
                    break;
                case 57:
                    b bVar43 = aVar.f999d;
                    bVar43.W = typedArray.getDimensionPixelSize(index, bVar43.W);
                    break;
                case 58:
                    b bVar44 = aVar.f999d;
                    bVar44.X = typedArray.getDimensionPixelSize(index, bVar44.X);
                    break;
                case 59:
                    b bVar45 = aVar.f999d;
                    bVar45.Y = typedArray.getDimensionPixelSize(index, bVar45.Y);
                    break;
                case 60:
                    e eVar11 = aVar.f1000e;
                    eVar11.f1054b = typedArray.getFloat(index, eVar11.f1054b);
                    break;
                case 61:
                    b bVar46 = aVar.f999d;
                    bVar46.f1036x = o(typedArray, index, bVar46.f1036x);
                    break;
                case 62:
                    b bVar47 = aVar.f999d;
                    bVar47.f1037y = typedArray.getDimensionPixelSize(index, bVar47.f1037y);
                    break;
                case 63:
                    b bVar48 = aVar.f999d;
                    bVar48.f1038z = typedArray.getFloat(index, bVar48.f1038z);
                    break;
                case 64:
                    c cVar = aVar.f998c;
                    cVar.f1041b = o(typedArray, index, cVar.f1041b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f998c.f1042c = typedArray.getString(index);
                    } else {
                        aVar.f998c.f1042c = m.a.f5296c[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    aVar.f998c.f1044e = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f998c;
                    cVar2.f1046g = typedArray.getFloat(index, cVar2.f1046g);
                    break;
                case 68:
                    C0005d c0005d4 = aVar.f997b;
                    c0005d4.f1051e = typedArray.getFloat(index, c0005d4.f1051e);
                    break;
                case 69:
                    aVar.f999d.Z = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f999d.f1004a0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f999d;
                    bVar49.f1006b0 = typedArray.getInt(index, bVar49.f1006b0);
                    break;
                case 73:
                    b bVar50 = aVar.f999d;
                    bVar50.f1008c0 = typedArray.getDimensionPixelSize(index, bVar50.f1008c0);
                    break;
                case 74:
                    aVar.f999d.f1014f0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f999d;
                    bVar51.f1022j0 = typedArray.getBoolean(index, bVar51.f1022j0);
                    break;
                case 76:
                    c cVar3 = aVar.f998c;
                    cVar3.f1043d = typedArray.getInt(index, cVar3.f1043d);
                    break;
                case 77:
                    aVar.f999d.f1016g0 = typedArray.getString(index);
                    break;
                case 78:
                    C0005d c0005d5 = aVar.f997b;
                    c0005d5.f1049c = typedArray.getInt(index, c0005d5.f1049c);
                    break;
                case 79:
                    c cVar4 = aVar.f998c;
                    cVar4.f1045f = typedArray.getFloat(index, cVar4.f1045f);
                    break;
                case 80:
                    b bVar52 = aVar.f999d;
                    bVar52.f1018h0 = typedArray.getBoolean(index, bVar52.f1018h0);
                    break;
                case 81:
                    b bVar53 = aVar.f999d;
                    bVar53.f1020i0 = typedArray.getBoolean(index, bVar53.f1020i0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f992e.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f992e.get(index));
                    break;
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    void d(ConstraintLayout constraintLayout, boolean z2) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f995c.keySet());
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!this.f995c.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + n.a.a(childAt));
            } else {
                if (this.f994b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f995c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f995c.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f999d.f1010d0 = 1;
                        }
                        int i4 = aVar.f999d.f1010d0;
                        if (i4 != -1 && i4 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.f999d.f1006b0);
                            barrier.setMargin(aVar.f999d.f1008c0);
                            barrier.setAllowsGoneWidget(aVar.f999d.f1022j0);
                            b bVar = aVar.f999d;
                            int[] iArr = bVar.f1012e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f1014f0;
                                if (str != null) {
                                    bVar.f1012e0 = j(barrier, str);
                                    barrier.setReferencedIds(aVar.f999d.f1012e0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.d(bVar2);
                        if (z2) {
                            androidx.constraintlayout.widget.a.c(childAt, aVar.f1001f);
                        }
                        childAt.setLayoutParams(bVar2);
                        C0005d c0005d = aVar.f997b;
                        if (c0005d.f1049c == 0) {
                            childAt.setVisibility(c0005d.f1048b);
                        }
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 >= 17) {
                            childAt.setAlpha(aVar.f997b.f1050d);
                            childAt.setRotation(aVar.f1000e.f1054b);
                            childAt.setRotationX(aVar.f1000e.f1055c);
                            childAt.setRotationY(aVar.f1000e.f1056d);
                            childAt.setScaleX(aVar.f1000e.f1057e);
                            childAt.setScaleY(aVar.f1000e.f1058f);
                            if (!Float.isNaN(aVar.f1000e.f1059g)) {
                                childAt.setPivotX(aVar.f1000e.f1059g);
                            }
                            if (!Float.isNaN(aVar.f1000e.f1060h)) {
                                childAt.setPivotY(aVar.f1000e.f1060h);
                            }
                            childAt.setTranslationX(aVar.f1000e.f1061i);
                            childAt.setTranslationY(aVar.f1000e.f1062j);
                            if (i5 >= 21) {
                                childAt.setTranslationZ(aVar.f1000e.f1063k);
                                e eVar = aVar.f1000e;
                                if (eVar.f1064l) {
                                    childAt.setElevation(eVar.f1065m);
                                }
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = this.f995c.get(num);
            int i6 = aVar2.f999d.f1010d0;
            if (i6 != -1 && i6 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.f999d;
                int[] iArr2 = bVar3.f1012e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.f1014f0;
                    if (str2 != null) {
                        bVar3.f1012e0 = j(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f999d.f1012e0);
                    }
                }
                barrier2.setType(aVar2.f999d.f1006b0);
                barrier2.setMargin(aVar2.f999d.f1008c0);
                ConstraintLayout.b bVarD = constraintLayout.generateDefaultLayoutParams();
                barrier2.m();
                aVar2.d(bVarD);
                constraintLayout.addView(barrier2, bVarD);
            }
            if (aVar2.f999d.f1003a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b bVarD2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.d(bVarD2);
                constraintLayout.addView(guideline, bVarD2);
            }
        }
    }

    public void e(int i3, int i4) {
        if (this.f995c.containsKey(Integer.valueOf(i3))) {
            a aVar = this.f995c.get(Integer.valueOf(i3));
            switch (i4) {
                case 1:
                    b bVar = aVar.f999d;
                    bVar.f1019i = -1;
                    bVar.f1017h = -1;
                    bVar.D = -1;
                    bVar.J = -1;
                    return;
                case 2:
                    b bVar2 = aVar.f999d;
                    bVar2.f1023k = -1;
                    bVar2.f1021j = -1;
                    bVar2.E = -1;
                    bVar2.L = -1;
                    return;
                case 3:
                    b bVar3 = aVar.f999d;
                    bVar3.f1025m = -1;
                    bVar3.f1024l = -1;
                    bVar3.F = -1;
                    bVar3.K = -1;
                    return;
                case 4:
                    b bVar4 = aVar.f999d;
                    bVar4.f1026n = -1;
                    bVar4.f1027o = -1;
                    bVar4.G = -1;
                    bVar4.M = -1;
                    return;
                case 5:
                    aVar.f999d.f1028p = -1;
                    return;
                case 6:
                    b bVar5 = aVar.f999d;
                    bVar5.f1029q = -1;
                    bVar5.f1030r = -1;
                    bVar5.I = -1;
                    bVar5.O = -1;
                    return;
                case 7:
                    b bVar6 = aVar.f999d;
                    bVar6.f1031s = -1;
                    bVar6.f1032t = -1;
                    bVar6.H = -1;
                    bVar6.N = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void f(Context context, int i3) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i3, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f995c.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f994b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f995c.containsKey(Integer.valueOf(id))) {
                this.f995c.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f995c.get(Integer.valueOf(id));
            aVar.f1001f = androidx.constraintlayout.widget.a.a(this.f993a, childAt);
            aVar.f(id, bVar);
            aVar.f997b.f1048b = childAt.getVisibility();
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 17) {
                aVar.f997b.f1050d = childAt.getAlpha();
                aVar.f1000e.f1054b = childAt.getRotation();
                aVar.f1000e.f1055c = childAt.getRotationX();
                aVar.f1000e.f1056d = childAt.getRotationY();
                aVar.f1000e.f1057e = childAt.getScaleX();
                aVar.f1000e.f1058f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f1000e;
                    eVar.f1059g = pivotX;
                    eVar.f1060h = pivotY;
                }
                aVar.f1000e.f1061i = childAt.getTranslationX();
                aVar.f1000e.f1062j = childAt.getTranslationY();
                if (i4 >= 21) {
                    aVar.f1000e.f1063k = childAt.getTranslationZ();
                    e eVar2 = aVar.f1000e;
                    if (eVar2.f1064l) {
                        eVar2.f1065m = childAt.getElevation();
                    }
                }
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.f999d.f1022j0 = barrier.n();
                aVar.f999d.f1012e0 = barrier.getReferencedIds();
                aVar.f999d.f1006b0 = barrier.getType();
                aVar.f999d.f1008c0 = barrier.getMargin();
            }
        }
    }

    public void h(androidx.constraintlayout.widget.e eVar) {
        int childCount = eVar.getChildCount();
        this.f995c.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = eVar.getChildAt(i3);
            androidx.constraintlayout.widget.e.a aVar = (androidx.constraintlayout.widget.e.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f994b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f995c.containsKey(Integer.valueOf(id))) {
                this.f995c.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.f995c.get(Integer.valueOf(id));
            if (childAt instanceof androidx.constraintlayout.widget.b) {
                aVar2.h((androidx.constraintlayout.widget.b) childAt, id, aVar);
            }
            aVar2.g(id, aVar);
        }
    }

    public void i(int i3, int i4, int i5, float f3) {
        b bVar = l(i3).f999d;
        bVar.f1036x = i4;
        bVar.f1037y = i5;
        bVar.f1038z = f3;
    }

    public void m(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarK = k(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarK.f999d.f1003a = true;
                    }
                    this.f995c.put(Integer.valueOf(aVarK.f996a), aVarK);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    public void n(Context context, XmlPullParser xmlPullParser) {
        a aVarK;
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        switch (xmlPullParser.getName()) {
                            case "Constraint":
                                aVarK = k(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case "Guideline":
                                aVarK = k(context, Xml.asAttributeSet(xmlPullParser));
                                b bVar = aVarK.f999d;
                                bVar.f1003a = true;
                                bVar.f1005b = true;
                                break;
                            case "Barrier":
                                aVarK = k(context, Xml.asAttributeSet(xmlPullParser));
                                aVarK.f999d.f1010d0 = 1;
                                break;
                            case "PropertySet":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f997b.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "Transform":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f1000e.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "Layout":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f999d.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "Motion":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f998c.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "CustomAttribute":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                androidx.constraintlayout.widget.a.b(context, xmlPullParser, aVar.f1001f);
                                continue;
                                break;
                                break;
                            default:
                                continue;
                                break;
                        }
                        aVar = aVarK;
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name = xmlPullParser.getName();
                        if ("ConstraintSet".equals(name)) {
                            return;
                        }
                        if (name.equalsIgnoreCase("Constraint")) {
                            this.f995c.put(Integer.valueOf(aVar.f996a), aVar);
                            aVar = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }
}
