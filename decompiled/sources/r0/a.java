package r0;

import android.content.Intent;

/* JADX INFO: compiled from: AuthFailureError.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Intent f5970d;

    public a(k kVar) {
        super(kVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f5970d != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
