package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: compiled from: PreferenceDialogFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends androidx.fragment.app.c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private DialogPreference f1636m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private CharSequence f1637n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private CharSequence f1638o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private CharSequence f1639p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private CharSequence f1640q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f1641r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private BitmapDrawable f1642s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f1643t0;

    private void K1(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    @Override // androidx.fragment.app.c
    public Dialog A1(Bundle bundle) {
        androidx.fragment.app.d dVarN = n();
        this.f1643t0 = -2;
        androidx.appcompat.app.a.C0000a c0000aJ = new androidx.appcompat.app.a.C0000a(dVarN).p(this.f1637n0).e(this.f1642s0).m(this.f1638o0, this).j(this.f1639p0, this);
        View viewH1 = H1(dVarN);
        if (viewH1 != null) {
            G1(viewH1);
            c0000aJ.q(viewH1);
        } else {
            c0000aJ.g(this.f1640q0);
        }
        J1(c0000aJ);
        androidx.appcompat.app.a aVarA = c0000aJ.a();
        if (F1()) {
            K1(aVarA);
        }
        return aVarA;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f1637n0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f1638o0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f1639p0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f1640q0);
        bundle.putInt("PreferenceDialogFragment.layout", this.f1641r0);
        BitmapDrawable bitmapDrawable = this.f1642s0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public DialogPreference E1() {
        if (this.f1636m0 == null) {
            this.f1636m0 = (DialogPreference) ((DialogPreference.a) O()).h(s().getString("key"));
        }
        return this.f1636m0;
    }

    protected boolean F1() {
        return false;
    }

    protected void G1(View view) {
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f1640q0;
            int i3 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i3 = 0;
            }
            if (viewFindViewById.getVisibility() != i3) {
                viewFindViewById.setVisibility(i3);
            }
        }
    }

    protected View H1(Context context) {
        int i3 = this.f1641r0;
        if (i3 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
    }

    public abstract void I1(boolean z2);

    protected void J1(androidx.appcompat.app.a.C0000a c0000a) {
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        androidx.lifecycle.g gVarO = O();
        if (!(gVarO instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) gVarO;
        String string = s().getString("key");
        if (bundle != null) {
            this.f1637n0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f1638o0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f1639p0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f1640q0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f1641r0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f1642s0 = new BitmapDrawable(H(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.h(string);
        this.f1636m0 = dialogPreference;
        this.f1637n0 = dialogPreference.C0();
        this.f1638o0 = this.f1636m0.E0();
        this.f1639p0 = this.f1636m0.D0();
        this.f1640q0 = this.f1636m0.B0();
        this.f1641r0 = this.f1636m0.A0();
        Drawable drawableZ0 = this.f1636m0.z0();
        if (drawableZ0 == null || (drawableZ0 instanceof BitmapDrawable)) {
            this.f1642s0 = (BitmapDrawable) drawableZ0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableZ0.getIntrinsicWidth(), drawableZ0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableZ0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableZ0.draw(canvas);
        this.f1642s0 = new BitmapDrawable(H(), bitmapCreateBitmap);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f1643t0 = i3;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        I1(this.f1643t0 == -1);
    }
}
