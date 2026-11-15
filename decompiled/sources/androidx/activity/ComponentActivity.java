package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.savedstate.SavedStateRegistry;
import t.d;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends d implements s, androidx.savedstate.b, c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private r f15f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f13d = new h(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.savedstate.a f14e = androidx.savedstate.a.a(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final OnBackPressedDispatcher f16g = new OnBackPressedDispatcher(new a());

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        r f22b;

        b() {
        }
    }

    public ComponentActivity() {
        if (b() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            b().a(new e() { // from class: androidx.activity.ComponentActivity.2
                @Override // androidx.lifecycle.e
                public void d(g gVar, androidx.lifecycle.d.a aVar) {
                    if (aVar == androidx.lifecycle.d.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        b().a(new e() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.e
            public void d(g gVar, androidx.lifecycle.d.a aVar) {
                if (aVar != androidx.lifecycle.d.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.i().a();
            }
        });
        if (19 > i3 || i3 > 23) {
            return;
        }
        b().a(new ImmLeaksCleaner(this));
    }

    @Override // t.d, androidx.lifecycle.g
    public androidx.lifecycle.d b() {
        return this.f13d;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher c() {
        return this.f16g;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry d() {
        return this.f14e.b();
    }

    @Override // androidx.lifecycle.s
    public r i() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f15f == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.f15f = bVar.f22b;
            }
            if (this.f15f == null) {
                this.f15f = new r();
            }
        }
        return this.f15f;
    }

    @Deprecated
    public Object l() {
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f16g.c();
    }

    @Override // t.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14e.c(bundle);
        o.f(this);
        int i3 = this.f17h;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object objL = l();
        r rVar = this.f15f;
        if (rVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            rVar = bVar.f22b;
        }
        if (rVar == null && objL == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f21a = objL;
        bVar2.f22b = rVar;
        return bVar2;
    }

    @Override // t.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.d dVarB = b();
        if (dVarB instanceof h) {
            ((h) dVarB).p(androidx.lifecycle.d.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f14e.d(bundle);
    }
}
