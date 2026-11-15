package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: DialogFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler Y;
    private Runnable Z = new a();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f1290a0 = new b();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private DialogInterface.OnDismissListener f1291b0 = new DialogInterfaceOnDismissListenerC0007c();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f1292c0 = 0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f1293d0 = 0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f1294e0 = true;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f1295f0 = true;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f1296g0 = -1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f1297h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private Dialog f1298i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f1299j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f1300k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f1301l0;

    /* JADX INFO: compiled from: DialogFragment.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            c.this.f1291b0.onDismiss(c.this.f1298i0);
        }
    }

    /* JADX INFO: compiled from: DialogFragment.java */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.f1298i0 != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.f1298i0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DialogFragment.java */
    class DialogInterfaceOnDismissListenerC0007c implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC0007c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.f1298i0 != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.f1298i0);
            }
        }
    }

    private void x1(boolean z2, boolean z3) {
        if (this.f1300k0) {
            return;
        }
        this.f1300k0 = true;
        this.f1301l0 = false;
        Dialog dialog = this.f1298i0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f1298i0.dismiss();
            if (!z3) {
                if (Looper.myLooper() == this.Y.getLooper()) {
                    onDismiss(this.f1298i0);
                } else {
                    this.Y.post(this.Z);
                }
            }
        }
        this.f1299j0 = true;
        if (this.f1296g0 >= 0) {
            F().E0(this.f1296g0, 1);
            this.f1296g0 = -1;
            return;
        }
        s sVarI = F().i();
        sVarI.l(this);
        if (z2) {
            sVarI.g();
        } else {
            sVarI.f();
        }
    }

    public Dialog A1(Bundle bundle) {
        return new Dialog(g1(), z1());
    }

    public final Dialog B1() {
        Dialog dialogY1 = y1();
        if (dialogY1 != null) {
            return dialogY1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void C1(Dialog dialog, int i3) {
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        Dialog dialog = this.f1298i0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
        }
        int i3 = this.f1292c0;
        if (i3 != 0) {
            bundle.putInt("android:style", i3);
        }
        int i4 = this.f1293d0;
        if (i4 != 0) {
            bundle.putInt("android:theme", i4);
        }
        boolean z2 = this.f1294e0;
        if (!z2) {
            bundle.putBoolean("android:cancelable", z2);
        }
        boolean z3 = this.f1295f0;
        if (!z3) {
            bundle.putBoolean("android:showsDialog", z3);
        }
        int i5 = this.f1296g0;
        if (i5 != -1) {
            bundle.putInt("android:backStackId", i5);
        }
    }

    public void D1(l lVar, String str) {
        this.f1300k0 = false;
        this.f1301l0 = true;
        s sVarI = lVar.i();
        sVarI.d(this, str);
        sVarI.f();
    }

    @Override // androidx.fragment.app.Fragment
    public void E0() {
        super.E0();
        Dialog dialog = this.f1298i0;
        if (dialog != null) {
            this.f1299j0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F0() {
        super.F0();
        Dialog dialog = this.f1298i0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void b0(Bundle bundle) {
        Bundle bundle2;
        super.b0(bundle);
        if (this.f1295f0) {
            View viewP = P();
            if (this.f1298i0 != null) {
                if (viewP != null) {
                    if (viewP.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    this.f1298i0.setContentView(viewP);
                }
                d dVarN = n();
                if (dVarN != null) {
                    this.f1298i0.setOwnerActivity(dVarN);
                }
                this.f1298i0.setCancelable(this.f1294e0);
                this.f1298i0.setOnCancelListener(this.f1290a0);
                this.f1298i0.setOnDismissListener(this.f1291b0);
                if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                    return;
                }
                this.f1298i0.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Context context) {
        super.e0(context);
        if (this.f1301l0) {
            return;
        }
        this.f1300k0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        this.Y = new Handler();
        this.f1295f0 = this.f1245x == 0;
        if (bundle != null) {
            this.f1292c0 = bundle.getInt("android:style", 0);
            this.f1293d0 = bundle.getInt("android:theme", 0);
            this.f1294e0 = bundle.getBoolean("android:cancelable", true);
            this.f1295f0 = bundle.getBoolean("android:showsDialog", this.f1295f0);
            this.f1296g0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0() {
        super.o0();
        Dialog dialog = this.f1298i0;
        if (dialog != null) {
            this.f1299j0 = true;
            dialog.setOnDismissListener(null);
            this.f1298i0.dismiss();
            if (!this.f1300k0) {
                onDismiss(this.f1298i0);
            }
            this.f1298i0 = null;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f1299j0) {
            return;
        }
        x1(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void p0() {
        super.p0();
        if (this.f1301l0 || this.f1300k0) {
            return;
        }
        this.f1300k0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater q0(Bundle bundle) {
        LayoutInflater layoutInflaterQ0 = super.q0(bundle);
        if (!this.f1295f0 || this.f1297h0) {
            return layoutInflaterQ0;
        }
        try {
            this.f1297h0 = true;
            Dialog dialogA1 = A1(bundle);
            this.f1298i0 = dialogA1;
            C1(dialogA1, this.f1292c0);
            return layoutInflaterQ0.cloneInContext(B1().getContext());
        } finally {
            this.f1297h0 = false;
        }
    }

    public void w1() {
        x1(false, false);
    }

    public Dialog y1() {
        return this.f1298i0;
    }

    public int z1() {
        return this.f1293d0;
    }
}
