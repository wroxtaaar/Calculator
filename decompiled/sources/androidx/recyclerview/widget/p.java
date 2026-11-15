package androidx.recyclerview.widget;

/* JADX INFO: compiled from: ViewInfoStore.java */
/* JADX INFO: loaded from: classes.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final l.g<RecyclerView.d0, a> f2100a = new l.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final l.d<RecyclerView.d0> f2101b = new l.d<>();

    /* JADX INFO: compiled from: ViewInfoStore.java */
    static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static d0.f<a> f2102d = new d0.g(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView.l.c f2104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RecyclerView.l.c f2105c;

        private a() {
        }

        static void a() {
            while (f2102d.b() != null) {
            }
        }

        static a b() {
            a aVarB = f2102d.b();
            return aVarB == null ? new a() : aVarB;
        }

        static void c(a aVar) {
            aVar.f2103a = 0;
            aVar.f2104b = null;
            aVar.f2105c = null;
            f2102d.a(aVar);
        }
    }

    /* JADX INFO: compiled from: ViewInfoStore.java */
    interface b {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    p() {
    }

    private RecyclerView.l.c l(RecyclerView.d0 d0Var, int i3) {
        a aVarM;
        RecyclerView.l.c cVar;
        int iF = this.f2100a.f(d0Var);
        if (iF >= 0 && (aVarM = this.f2100a.m(iF)) != null) {
            int i4 = aVarM.f2103a;
            if ((i4 & i3) != 0) {
                int i5 = (~i3) & i4;
                aVarM.f2103a = i5;
                if (i3 == 4) {
                    cVar = aVarM.f2104b;
                } else {
                    if (i3 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarM.f2105c;
                }
                if ((i5 & 12) == 0) {
                    this.f2100a.k(iF);
                    a.c(aVarM);
                }
                return cVar;
            }
        }
        return null;
    }

    void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = this.f2100a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f2100a.put(d0Var, aVarB);
        }
        aVarB.f2103a |= 2;
        aVarB.f2104b = cVar;
    }

    void b(RecyclerView.d0 d0Var) {
        a aVarB = this.f2100a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f2100a.put(d0Var, aVarB);
        }
        aVarB.f2103a |= 1;
    }

    void c(long j3, RecyclerView.d0 d0Var) {
        this.f2101b.i(j3, d0Var);
    }

    void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = this.f2100a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f2100a.put(d0Var, aVarB);
        }
        aVarB.f2105c = cVar;
        aVarB.f2103a |= 8;
    }

    void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = this.f2100a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f2100a.put(d0Var, aVarB);
        }
        aVarB.f2104b = cVar;
        aVarB.f2103a |= 4;
    }

    void f() {
        this.f2100a.clear();
        this.f2101b.b();
    }

    RecyclerView.d0 g(long j3) {
        return this.f2101b.e(j3);
    }

    boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.f2100a.get(d0Var);
        return (aVar == null || (aVar.f2103a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.f2100a.get(d0Var);
        return (aVar == null || (aVar.f2103a & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    void o(b bVar) {
        for (int size = this.f2100a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 d0VarI = this.f2100a.i(size);
            a aVarK = this.f2100a.k(size);
            int i3 = aVarK.f2103a;
            if ((i3 & 3) == 3) {
                bVar.a(d0VarI);
            } else if ((i3 & 1) != 0) {
                RecyclerView.l.c cVar = aVarK.f2104b;
                if (cVar == null) {
                    bVar.a(d0VarI);
                } else {
                    bVar.c(d0VarI, cVar, aVarK.f2105c);
                }
            } else if ((i3 & 14) == 14) {
                bVar.b(d0VarI, aVarK.f2104b, aVarK.f2105c);
            } else if ((i3 & 12) == 12) {
                bVar.d(d0VarI, aVarK.f2104b, aVarK.f2105c);
            } else if ((i3 & 4) != 0) {
                bVar.c(d0VarI, aVarK.f2104b, null);
            } else if ((i3 & 8) != 0) {
                bVar.b(d0VarI, aVarK.f2104b, aVarK.f2105c);
            }
            a.c(aVarK);
        }
    }

    void p(RecyclerView.d0 d0Var) {
        a aVar = this.f2100a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f2103a &= -2;
    }

    void q(RecyclerView.d0 d0Var) {
        for (int iL = this.f2101b.l() - 1; iL >= 0; iL--) {
            if (d0Var == this.f2101b.m(iL)) {
                this.f2101b.k(iL);
                break;
            }
        }
        a aVarRemove = this.f2100a.remove(d0Var);
        if (aVarRemove != null) {
            a.c(aVarRemove);
        }
    }
}
