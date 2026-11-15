package p;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ConstraintAnchor.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f5509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f5511d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    o.i f5514g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet<d> f5508a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5512e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5513f = -1;

    /* JADX INFO: compiled from: ConstraintAnchor.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5515a;

        static {
            int[] iArr = new int[b.values().length];
            f5515a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5515a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5515a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5515a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5515a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5515a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5515a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5515a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5515a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f5509b = eVar;
        this.f5510c = bVar;
    }

    public boolean a(d dVar, int i3, int i4, boolean z2) {
        if (dVar == null) {
            k();
            return true;
        }
        if (!z2 && !j(dVar)) {
            return false;
        }
        this.f5511d = dVar;
        if (dVar.f5508a == null) {
            dVar.f5508a = new HashSet<>();
        }
        this.f5511d.f5508a.add(this);
        if (i3 > 0) {
            this.f5512e = i3;
        } else {
            this.f5512e = 0;
        }
        this.f5513f = i4;
        return true;
    }

    public int b() {
        d dVar;
        if (this.f5509b.M() == 8) {
            return 0;
        }
        return (this.f5513f <= -1 || (dVar = this.f5511d) == null || dVar.f5509b.M() != 8) ? this.f5512e : this.f5513f;
    }

    public final d c() {
        switch (a.f5515a[this.f5510c.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f5509b.D;
            case 3:
                return this.f5509b.B;
            case 4:
                return this.f5509b.E;
            case 5:
                return this.f5509b.C;
            default:
                throw new AssertionError(this.f5510c.name());
        }
    }

    public e d() {
        return this.f5509b;
    }

    public o.i e() {
        return this.f5514g;
    }

    public d f() {
        return this.f5511d;
    }

    public b g() {
        return this.f5510c;
    }

    public boolean h() {
        HashSet<d> hashSet = this.f5508a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().c().i()) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        return this.f5511d != null;
    }

    public boolean j(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarG = dVar.g();
        b bVar = this.f5510c;
        if (bVarG == bVar) {
            return bVar != b.BASELINE || (dVar.d().Q() && d().Q());
        }
        switch (a.f5515a[bVar.ordinal()]) {
            case 1:
                return (bVarG == b.BASELINE || bVarG == b.CENTER_X || bVarG == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z2 = bVarG == b.LEFT || bVarG == b.RIGHT;
                if (dVar.d() instanceof g) {
                    return z2 || bVarG == b.CENTER_X;
                }
                return z2;
            case 4:
            case 5:
                boolean z3 = bVarG == b.TOP || bVarG == b.BOTTOM;
                if (dVar.d() instanceof g) {
                    return z3 || bVarG == b.CENTER_Y;
                }
                return z3;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f5510c.name());
        }
    }

    public void k() {
        HashSet<d> hashSet;
        d dVar = this.f5511d;
        if (dVar != null && (hashSet = dVar.f5508a) != null) {
            hashSet.remove(this);
        }
        this.f5511d = null;
        this.f5512e = 0;
        this.f5513f = -1;
    }

    public void l(o.c cVar) {
        o.i iVar = this.f5514g;
        if (iVar == null) {
            this.f5514g = new o.i(o.i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.f5509b.p() + ":" + this.f5510c.toString();
    }
}
