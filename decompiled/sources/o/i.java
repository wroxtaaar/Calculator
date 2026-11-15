package o;

import com.vivo.seckeysdk.BuildConfig;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: SolverVariable.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f5375o = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5377b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5381f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    a f5385j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5378c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5379d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5380e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5382g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float[] f5383h = new float[9];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float[] f5384i = new float[9];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    b[] f5386k = new b[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f5387l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5388m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    HashSet<b> f5389n = null;

    /* JADX INFO: compiled from: SolverVariable.java */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f5385j = aVar;
    }

    static void b() {
        f5375o++;
    }

    public final void a(b bVar) {
        int i3 = 0;
        while (true) {
            int i4 = this.f5387l;
            if (i3 >= i4) {
                b[] bVarArr = this.f5386k;
                if (i4 >= bVarArr.length) {
                    this.f5386k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f5386k;
                int i5 = this.f5387l;
                bVarArr2[i5] = bVar;
                this.f5387l = i5 + 1;
                return;
            }
            if (this.f5386k[i3] == bVar) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void c(b bVar) {
        int i3 = this.f5387l;
        int i4 = 0;
        while (i4 < i3) {
            if (this.f5386k[i4] == bVar) {
                while (i4 < i3 - 1) {
                    b[] bVarArr = this.f5386k;
                    int i5 = i4 + 1;
                    bVarArr[i4] = bVarArr[i5];
                    i4 = i5;
                }
                this.f5387l--;
                return;
            }
            i4++;
        }
    }

    public void d() {
        this.f5377b = null;
        this.f5385j = a.UNKNOWN;
        this.f5380e = 0;
        this.f5378c = -1;
        this.f5379d = -1;
        this.f5381f = 0.0f;
        this.f5382g = false;
        int i3 = this.f5387l;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f5386k[i4] = null;
        }
        this.f5387l = 0;
        this.f5388m = 0;
        this.f5376a = false;
        Arrays.fill(this.f5384i, 0.0f);
    }

    public void e(d dVar, float f3) {
        this.f5381f = f3;
        this.f5382g = true;
        int i3 = this.f5387l;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f5386k[i4].B(dVar, this, false);
        }
        this.f5387l = 0;
    }

    public void f(a aVar, String str) {
        this.f5385j = aVar;
    }

    public final void g(b bVar) {
        int i3 = this.f5387l;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f5386k[i4].C(bVar, false);
        }
        this.f5387l = 0;
    }

    public String toString() {
        if (this.f5377b != null) {
            return BuildConfig.FLAVOR + this.f5377b;
        }
        return BuildConfig.FLAVOR + this.f5378c;
    }
}
