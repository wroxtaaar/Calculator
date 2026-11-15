package g;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: StandaloneActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends b implements androidx.appcompat.view.menu.e.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f4696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ActionBarContextView f4697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b.a f4698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WeakReference<View> f4699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f4702j;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z2) {
        this.f4696d = context;
        this.f4697e = actionBarContextView;
        this.f4698f = aVar;
        androidx.appcompat.view.menu.e eVarS = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.f4702j = eVarS;
        eVarS.R(this);
        this.f4701i = z2;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f4698f.d(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f4697e.l();
    }

    @Override // g.b
    public void c() {
        if (this.f4700h) {
            return;
        }
        this.f4700h = true;
        this.f4697e.sendAccessibilityEvent(32);
        this.f4698f.c(this);
    }

    @Override // g.b
    public View d() {
        WeakReference<View> weakReference = this.f4699g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // g.b
    public Menu e() {
        return this.f4702j;
    }

    @Override // g.b
    public MenuInflater f() {
        return new g(this.f4697e.getContext());
    }

    @Override // g.b
    public CharSequence g() {
        return this.f4697e.getSubtitle();
    }

    @Override // g.b
    public CharSequence i() {
        return this.f4697e.getTitle();
    }

    @Override // g.b
    public void k() {
        this.f4698f.a(this, this.f4702j);
    }

    @Override // g.b
    public boolean l() {
        return this.f4697e.j();
    }

    @Override // g.b
    public void m(View view) {
        this.f4697e.setCustomView(view);
        this.f4699g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // g.b
    public void n(int i3) {
        o(this.f4696d.getString(i3));
    }

    @Override // g.b
    public void o(CharSequence charSequence) {
        this.f4697e.setSubtitle(charSequence);
    }

    @Override // g.b
    public void q(int i3) {
        r(this.f4696d.getString(i3));
    }

    @Override // g.b
    public void r(CharSequence charSequence) {
        this.f4697e.setTitle(charSequence);
    }

    @Override // g.b
    public void s(boolean z2) {
        super.s(z2);
        this.f4697e.setTitleOptional(z2);
    }
}
