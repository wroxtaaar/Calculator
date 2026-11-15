package b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.b1;

/* JADX INFO: compiled from: AppCompatActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.fragment.app.d implements c, t.g.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private d f2230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Resources f2231s;

    private boolean C(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Deprecated
    public void A() {
    }

    public boolean B() {
        Intent intentG = g();
        if (intentG == null) {
            return false;
        }
        if (!E(intentG)) {
            D(intentG);
            return true;
        }
        t.g gVarD = t.g.d(this);
        x(gVarD);
        z(gVarD);
        gVarD.e();
        try {
            t.a.f(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void D(Intent intent) {
        t.e.e(this, intent);
    }

    public boolean E(Intent intent) {
        return t.e.f(this, intent);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(v().f(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a aVarW = w();
        if (getWindow().hasFeature(0)) {
            if (aVarW == null || !aVarW.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // t.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a aVarW = w();
        if (keyCode == 82 && aVarW != null && aVarW.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // b.c
    public void e(g.b bVar) {
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i3) {
        return (T) v().i(i3);
    }

    @Override // t.g.a
    public Intent g() {
        return t.e.a(this);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return v().l();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f2231s == null && b1.b()) {
            this.f2231s = new b1(this, super.getResources());
        }
        Resources resources = this.f2231s;
        return resources == null ? super.getResources() : resources;
    }

    @Override // b.c
    public g.b h(g.b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        v().o();
    }

    @Override // b.c
    public void j(g.b bVar) {
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2231s != null) {
            this.f2231s.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        v().p(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        A();
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, t.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        d dVarV = v();
        dVarV.n();
        dVarV.q(bundle);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        v().r();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (C(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        a aVarW = w();
        if (menuItem.getItemId() != 16908332 || aVarW == null || (aVarW.j() & 4) == 0) {
            return false;
        }
        return B();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i3, Menu menu) {
        return super.onMenuOpened(i3, menu);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        v().s(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        v().t();
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, t.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        v().u(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        super.onStart();
        v().v();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        super.onStop();
        v().w();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i3) {
        super.onTitleChanged(charSequence, i3);
        v().E(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a aVarW = w();
        if (getWindow().hasFeature(0)) {
            if (aVarW == null || !aVarW.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i3) {
        v().A(i3);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        super.setTheme(i3);
        v().D(i3);
    }

    @Override // androidx.fragment.app.d
    public void u() {
        v().o();
    }

    public d v() {
        if (this.f2230r == null) {
            this.f2230r = d.g(this, this);
        }
        return this.f2230r;
    }

    public a w() {
        return v().m();
    }

    public void x(t.g gVar) {
        gVar.b(this);
    }

    protected void y(int i3) {
    }

    public void z(t.g gVar) {
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        v().B(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().C(view, layoutParams);
    }
}
