package y2;

/* JADX INFO: compiled from: FunctionStack.java */
/* JADX INFO: loaded from: classes.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m[] f6532a = new m[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6533b = 0;

    o() {
    }

    void a() {
        this.f6533b = 0;
    }

    m b() {
        m[] mVarArr = this.f6532a;
        int i3 = this.f6533b - 1;
        this.f6533b = i3;
        return mVarArr[i3];
    }

    void c(m mVar) {
        int i3 = this.f6533b;
        m[] mVarArr = this.f6532a;
        if (i3 >= mVarArr.length) {
            m[] mVarArr2 = new m[mVarArr.length << 1];
            System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
            this.f6532a = mVarArr2;
        }
        m[] mVarArr3 = this.f6532a;
        int i4 = this.f6533b;
        this.f6533b = i4 + 1;
        mVarArr3[i4] = mVar;
    }

    m[] d() {
        int i3 = this.f6533b;
        m[] mVarArr = new m[i3];
        System.arraycopy(this.f6532a, 0, mVarArr, 0, i3);
        return mVarArr;
    }
}
