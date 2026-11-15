package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: compiled from: MenuDialogHelper.java */
/* JADX INFO: loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.appcompat.app.a f241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    c f242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j.a f243e;

    public f(e eVar) {
        this.f240b = eVar;
    }

    public void a() {
        androidx.appcompat.app.a aVar = this.f241c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void b(e eVar, boolean z2) {
        if (z2 || eVar == this.f240b) {
            a();
        }
        j.a aVar = this.f243e;
        if (aVar != null) {
            aVar.b(eVar, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c(e eVar) {
        j.a aVar = this.f243e;
        if (aVar != null) {
            return aVar.c(eVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        e eVar = this.f240b;
        androidx.appcompat.app.a.C0000a c0000a = new androidx.appcompat.app.a.C0000a(eVar.u());
        c cVar = new c(c0000a.b(), a.g.abc_list_menu_item_layout);
        this.f242d = cVar;
        cVar.h(this);
        this.f240b.b(this.f242d);
        c0000a.c(this.f242d.a(), this);
        View viewY = eVar.y();
        if (viewY != null) {
            c0000a.d(viewY);
        } else {
            c0000a.e(eVar.w()).p(eVar.x());
        }
        c0000a.k(this);
        androidx.appcompat.app.a aVarA = c0000a.a();
        this.f241c = aVarA;
        aVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f241c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f241c.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f240b.L((g) this.f242d.a().getItem(i3), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f242d.b(this.f240b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i3 == 82 || i3 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f241c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f241c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f240b.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f240b.performShortcut(i3, keyEvent, 0);
    }
}
