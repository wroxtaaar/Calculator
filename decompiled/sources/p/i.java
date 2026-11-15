package p;

import java.util.Arrays;

/* JADX INFO: compiled from: HelperWidget.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends e implements h {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public e[] f5589w0 = new e[4];

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f5590x0 = 0;

    @Override // p.h
    public void a() {
        this.f5590x0 = 0;
        Arrays.fill(this.f5589w0, (Object) null);
    }

    @Override // p.h
    public void b(f fVar) {
    }

    @Override // p.h
    public void c(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i3 = this.f5590x0 + 1;
        e[] eVarArr = this.f5589w0;
        if (i3 > eVarArr.length) {
            this.f5589w0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f5589w0;
        int i4 = this.f5590x0;
        eVarArr2[i4] = eVar;
        this.f5590x0 = i4 + 1;
    }
}
