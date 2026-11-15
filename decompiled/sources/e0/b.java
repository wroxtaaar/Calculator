package e0;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: ActionProvider.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0056b f4519c;

    /* JADX INFO: compiled from: ActionProvider.java */
    public interface a {
    }

    /* JADX INFO: renamed from: e0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionProvider.java */
    public interface InterfaceC0056b {
        void onActionProviderVisibilityChanged(boolean z2);
    }

    public b(Context context) {
        this.f4517a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f4519c = null;
        this.f4518b = null;
    }

    public void i(a aVar) {
        this.f4518b = aVar;
    }

    public void j(InterfaceC0056b interfaceC0056b) {
        if (this.f4519c != null && interfaceC0056b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f4519c = interfaceC0056b;
    }
}
