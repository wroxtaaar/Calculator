package t;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.h;
import androidx.lifecycle.o;

/* JADX INFO: compiled from: ComponentActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends Activity implements androidx.lifecycle.g, e0.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l.g<Class<Object>, Object> f6231b = new l.g<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f6232c = new h(this);

    public androidx.lifecycle.d b() {
        return this.f6232c;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e0.e.d(decorView, keyEvent)) {
            return e0.e.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e0.e.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // e0.e.a
    public boolean f(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.f(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f6232c.k(androidx.lifecycle.d.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
