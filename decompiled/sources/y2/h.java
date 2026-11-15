package y2;

/* JADX INFO: compiled from: Declaration.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f6506e = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String[] f6508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f6510d;

    h() {
    }

    void a(String str, q qVar, i iVar) throws x {
        int iIndexOf = str.indexOf(61);
        if (iIndexOf == -1) {
            this.f6510d = str;
            this.f6507a = null;
            this.f6508b = f6506e;
            this.f6509c = -2;
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        this.f6510d = str.substring(iIndexOf + 1);
        qVar.c(strSubstring, iVar);
        this.f6507a = iVar.f6512a;
        this.f6508b = iVar.c();
        this.f6509c = iVar.f6513b;
    }
}
