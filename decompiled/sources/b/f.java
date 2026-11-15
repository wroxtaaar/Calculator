package b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: AppCompatDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends Dialog implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f2305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e0.e.a f2306c;

    /* JADX INFO: compiled from: AppCompatDialog.java */
    class a implements e0.e.a {
        a() {
        }

        @Override // e0.e.a
        public boolean f(KeyEvent keyEvent) {
            return f.this.c(keyEvent);
        }
    }

    public f(Context context, int i3) {
        super(context, b(context, i3));
        this.f2306c = new a();
        d dVarA = a();
        dVarA.D(b(context, i3));
        dVarA.q(null);
    }

    private static int b(Context context, int i3) {
        if (i3 != 0) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public d a() {
        if (this.f2305b == null) {
            this.f2305b = d.h(this, this);
        }
        return this.f2305b;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i3) {
        return a().z(i3);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().r();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return e0.e.e(this.f2306c, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // b.c
    public void e(g.b bVar) {
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i3) {
        return (T) a().i(i3);
    }

    @Override // b.c
    public g.b h(g.b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().o();
    }

    @Override // b.c
    public void j(g.b bVar) {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        a().n();
        super.onCreate(bundle);
        a().q(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().w();
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        a().A(i3);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().E(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().B(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().C(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        super.setTitle(i3);
        a().E(getContext().getString(i3));
    }
}
