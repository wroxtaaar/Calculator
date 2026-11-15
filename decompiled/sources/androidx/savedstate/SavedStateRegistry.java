package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f2109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Recreator.a f2111d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j.b<String, b> f2108a = new j.b<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2112e = true;

    public interface a {
        void a(androidx.savedstate.b bVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public Bundle a(String str) {
        if (!this.f2110c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2109b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f2109b.remove(str);
        if (this.f2109b.isEmpty()) {
            this.f2109b = null;
        }
        return bundle2;
    }

    void b(d dVar, Bundle bundle) {
        if (this.f2110c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f2109b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        dVar.a(new e() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.e
            public void d(g gVar, d.a aVar) {
                if (aVar == d.a.ON_START) {
                    SavedStateRegistry.this.f2112e = true;
                } else if (aVar == d.a.ON_STOP) {
                    SavedStateRegistry.this.f2112e = false;
                }
            }
        });
        this.f2110c = true;
    }

    void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2109b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        j.b<String, b>.d dVarD = this.f2108a.d();
        while (dVarD.hasNext()) {
            Map.Entry next = dVarD.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.f2108a.g(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (!this.f2112e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f2111d == null) {
            this.f2111d = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.f2111d.b(cls.getName());
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
        }
    }
}
