package g;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: ActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f4689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4690c;

    /* JADX INFO: compiled from: ActionMode.java */
    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, Menu menu);

        void c(b bVar);

        boolean d(b bVar, MenuItem menuItem);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f4689b;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f4690c;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i3);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f4689b = obj;
    }

    public abstract void q(int i3);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z2) {
        this.f4690c = z2;
    }
}
