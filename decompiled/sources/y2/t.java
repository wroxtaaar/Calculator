package y2;

import java.util.Stack;

/* JADX INFO: compiled from: RPN.java */
/* JADX INFO: loaded from: classes.dex */
class t extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Stack f6565a = new Stack();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f6566b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    z f6567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    x f6568d;

    t(x xVar) {
        this.f6568d = xVar;
    }

    static final boolean c(int i3) {
        return i3 == 8 || i3 == 14 || i3 == 9 || i3 == 10 || i3 == 17;
    }

    private void d(int i3) throws x {
        y yVarF = f();
        while (yVarF != null && yVarF.f6592a >= i3) {
            this.f6567c.a(yVarF);
            this.f6565a.pop();
            yVarF = f();
        }
    }

    private y f() {
        if (this.f6565a.empty()) {
            return null;
        }
        return (y) this.f6565a.peek();
    }

    @Override // y2.z
    void a(y yVar) throws x {
        int i3 = yVar.f6592a;
        int i4 = yVar.f6594c;
        switch (i4) {
            case 9:
            case 10:
                if (c(this.f6566b)) {
                    a(q.f6536f);
                }
                this.f6567c.a(yVar);
                break;
            case 11:
            case 13:
            default:
                if (yVar.f6593b == 1) {
                    if (c(this.f6566b)) {
                        a(q.f6536f);
                    }
                    this.f6565a.push(yVar);
                } else if (c(this.f6566b)) {
                    d(i3 + (yVar.f6593b != 3 ? 0 : 1));
                    this.f6565a.push(yVar);
                } else if (i4 != 2) {
                    if (i4 != 1) {
                        throw this.f6568d.a("operator without operand", yVar.f6599h);
                    }
                    return;
                } else {
                    yVar = q.f6539i;
                    this.f6565a.push(yVar);
                }
                break;
            case 12:
                if (!c(this.f6566b)) {
                    throw this.f6568d.a("misplaced COMMA", yVar.f6599h);
                }
                d(i3);
                y yVarF = f();
                if (yVarF == null || yVarF.f6594c != 11) {
                    throw this.f6568d.a("COMMA not inside CALL", yVar.f6599h);
                }
                yVarF.f6598g++;
                break;
                break;
            case 14:
                int i5 = this.f6566b;
                if (i5 == 11) {
                    f().f6598g--;
                } else if (!c(i5)) {
                    throw this.f6568d.a("unexpected ) or END", yVar.f6599h);
                }
                d(i3);
                y yVarF2 = f();
                if (yVarF2 != null) {
                    if (yVarF2.f6594c == 11) {
                        this.f6567c.a(yVarF2);
                    } else if (yVarF2 != q.f6544n) {
                        throw this.f6568d.a("expected LPAREN or CALL", yVar.f6599h);
                    }
                    this.f6565a.pop();
                }
                break;
            case 15:
                y yVar2 = q.f6545o;
                yVar2.f6599h = yVar.f6599h;
                do {
                    a(yVar2);
                } while (f() != null);
                break;
        }
        this.f6566b = yVar.f6594c;
    }

    @Override // y2.z
    void b() {
        this.f6565a.removeAllElements();
        this.f6566b = 0;
        this.f6567c.b();
    }

    void e(z zVar) {
        this.f6567c = zVar;
    }
}
