package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;

/* JADX INFO: compiled from: SavedStateRegistryController.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f2114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SavedStateRegistry f2115b = new SavedStateRegistry();

    private a(b bVar) {
        this.f2114a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f2115b;
    }

    public void c(Bundle bundle) {
        d dVarB = this.f2114a.b();
        if (dVarB.b() != d.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        dVarB.a(new Recreator(this.f2114a));
        this.f2115b.b(dVarB, bundle);
    }

    public void d(Bundle bundle) {
        this.f2115b.c(bundle);
    }
}
