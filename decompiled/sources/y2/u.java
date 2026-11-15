package y2;

/* JADX INFO: compiled from: SimpleCodeGen.java */
/* JADX INFO: loaded from: classes.dex */
class u extends z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final x f6569f = new x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f6570a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    k f6571b = new k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    o f6572c = new o();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    w f6573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    x f6574e;

    u(x xVar) {
        this.f6574e = xVar;
    }

    @Override // y2.z
    void a(y yVar) throws x {
        byte b3 = 2;
        switch (yVar.f6594c) {
            case 9:
                this.f6571b.e(yVar.f6596e, 0.0d);
                b3 = 1;
                this.f6570a.c(b3);
                return;
            case 10:
            case 11:
                v vVarD = d(yVar);
                if (yVar.a()) {
                    this.f6572c.c(vVarD.f6578d.k());
                } else {
                    byte b4 = vVarD.f6577c;
                    if (b4 <= 0) {
                        m mVar = vVarD.f6578d;
                        if (mVar != null) {
                            this.f6572c.c(mVar);
                        } else {
                            this.f6571b.e(vVarD.f6579e, vVarD.f6580f);
                            b3 = 1;
                        }
                    } else {
                        if (b4 >= 38 && b4 <= 42) {
                            throw f6569f.a("eval() on implicit function", this.f6574e.f6591d);
                        }
                        b3 = b4;
                    }
                }
                this.f6570a.c(b3);
                return;
            default:
                b3 = yVar.f6595d;
                if (b3 <= 0) {
                    throw new Error("wrong vmop: " + ((int) b3) + ", id " + yVar.f6594c + " in \"" + this.f6574e.f6589b + '\"');
                }
                this.f6570a.c(b3);
                return;
        }
    }

    @Override // y2.z
    void b() {
        this.f6570a.a();
        this.f6571b.a();
        this.f6572c.a();
    }

    c c() {
        return new c(0, this.f6570a.d(), this.f6571b.c(), this.f6571b.b(), this.f6572c.d());
    }

    v d(y yVar) throws x {
        byte b3;
        String strSubstring = yVar.f6597f;
        boolean zA = yVar.a();
        if (zA) {
            if (yVar.f6598g != 1) {
                throw this.f6574e.a("Derivative expects arity 1 but found " + yVar.f6598g, yVar.f6599h);
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        v vVarH = this.f6573d.h(strSubstring, yVar.f6598g);
        if (vVarH == null) {
            throw this.f6574e.a("undefined '" + strSubstring + "' with arity " + yVar.f6598g, yVar.f6599h);
        }
        if (zA && (b3 = vVarH.f6577c) > 0 && vVarH.f6578d == null) {
            vVarH.f6578d = c.y(b3);
        }
        if (!zA || vVarH.f6578d != null) {
            return vVarH;
        }
        throw this.f6574e.a("Invalid derivative " + strSubstring, yVar.f6599h);
    }

    u e(w wVar) {
        this.f6573d = wVar;
        return this;
    }
}
