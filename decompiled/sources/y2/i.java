package y2;

import java.util.Vector;

/* JADX INFO: compiled from: DeclarationParser.java */
/* JADX INFO: loaded from: classes.dex */
class i extends z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String[] f6511e = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f6513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Vector f6514c = new Vector();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x f6515d;

    i(x xVar) {
        this.f6515d = xVar;
    }

    @Override // y2.z
    void a(y yVar) throws x {
        switch (yVar.f6594c) {
            case 10:
                if (this.f6512a == null) {
                    this.f6512a = yVar.f6597f;
                    this.f6513b = -2;
                    return;
                }
                if (this.f6513b < 0) {
                    throw this.f6515d.a("Invalid declaration", yVar.f6599h);
                }
                this.f6514c.addElement(yVar.f6597f);
                int i3 = this.f6513b + 1;
                this.f6513b = i3;
                if (i3 <= 5) {
                    return;
                }
                throw this.f6515d.a("Arity too large " + this.f6513b, yVar.f6599h);
            case 11:
                if (this.f6512a != null) {
                    throw this.f6515d.a("repeated CALL in declaration", yVar.f6599h);
                }
                this.f6512a = yVar.f6597f;
                this.f6513b = 0;
                return;
            case 12:
            case 14:
            case 15:
                return;
            case 13:
            default:
                throw this.f6515d.a("invalid token in declaration", yVar.f6599h);
        }
    }

    @Override // y2.z
    void b() {
        this.f6512a = null;
        this.f6513b = -2;
        this.f6514c.setSize(0);
    }

    String[] c() {
        int i3 = this.f6513b;
        if (i3 <= 0) {
            return f6511e;
        }
        String[] strArr = new String[i3];
        this.f6514c.copyInto(strArr);
        return strArr;
    }
}
