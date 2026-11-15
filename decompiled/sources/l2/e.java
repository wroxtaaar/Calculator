package l2;

import android.text.TextUtils;
import com.vivo.seckeysdk.utils.SecurityKeyException;

/* JADX INFO: compiled from: ProtocolPackageV3.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f5289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f5291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f5292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f5293g;

    public e(String str, int i3, int i4, byte[] bArr) {
        this.f5287a = i3;
        this.f5288b = i4;
        this.f5289c = bArr;
        this.f5290d = str;
    }

    public static e d(byte[] bArr) throws SecurityKeyException {
        k2.f fVar = (k2.f) k2.d.b(bArr);
        k2.b bVarH = fVar.h();
        if (bVarH == null) {
            i.k("SecurityKey", "buildProtocolPackage head is null!");
            throw new SecurityKeyException("crypto header problem", 150);
        }
        String strA = bVarH.a();
        if (TextUtils.isEmpty(strA)) {
            i.k("SecurityKey", "buildProtocolPackage packageName is empty!");
            throw new SecurityKeyException("crypto header problem", 150);
        }
        byte[] bArrI = fVar.i();
        if (bArrI == null) {
            i.k("SecurityKey", "buildProtocolPackage body is null!");
            throw new SecurityKeyException("crypto body problem", 151);
        }
        e eVar = new e(strA, bVarH.b(), bVarH.c(), bArrI);
        eVar.f5291e = fVar.s();
        eVar.f5292f = fVar.u();
        eVar.f5293g = fVar.w();
        return eVar;
    }

    public final void a(byte[] bArr) {
        this.f5291e = bArr;
    }

    public final byte[] b() {
        return this.f5291e;
    }

    public final int c() {
        return this.f5287a;
    }

    public final byte[] e() {
        return this.f5289c;
    }

    public final byte[] f() throws SecurityKeyException {
        k2.f fVar = (k2.f) k2.d.a(3);
        fVar.j(this.f5287a);
        fVar.f(this.f5288b);
        fVar.e(this.f5289c);
        fVar.g(this.f5290d);
        byte[] bArr = this.f5291e;
        if (bArr != null) {
            fVar.r(bArr);
        }
        byte[] bArr2 = this.f5292f;
        if (bArr2 != null) {
            fVar.t(bArr2);
        }
        byte[] bArr3 = this.f5293g;
        if (bArr3 != null) {
            fVar.v(bArr3);
        }
        fVar.k();
        return fVar.l();
    }

    public final byte[] g() throws SecurityKeyException {
        k2.f fVar = (k2.f) k2.d.a(3);
        fVar.j(this.f5287a);
        fVar.f(this.f5288b);
        fVar.g(this.f5290d);
        byte[] bArr = this.f5291e;
        if (bArr != null) {
            fVar.r(bArr);
        }
        byte[] bArr2 = this.f5292f;
        if (bArr2 != null) {
            fVar.t(bArr2);
        }
        byte[] bArr3 = this.f5293g;
        if (bArr3 != null) {
            fVar.v(bArr3);
        }
        fVar.k();
        return fVar.d();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ProtocolPackageV3 keyVersion " + this.f5287a + ",");
        stringBuffer.append("package token " + this.f5290d + ",");
        stringBuffer.append("package type " + this.f5288b + ",");
        stringBuffer.append("package data len= " + this.f5289c.length + ",");
        return stringBuffer.toString();
    }
}
