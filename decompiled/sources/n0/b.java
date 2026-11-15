package n0;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.preference.ListPreference;

/* JADX INFO: compiled from: ListPreferenceDialogFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.preference.b {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    int f5302u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private CharSequence[] f5303v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private CharSequence[] f5304w0;

    /* JADX INFO: compiled from: ListPreferenceDialogFragmentCompat.java */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            b bVar = b.this;
            bVar.f5302u0 = i3;
            bVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private ListPreference L1() {
        return (ListPreference) E1();
    }

    public static b M1(String str) {
        b bVar = new b();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        bVar.m1(bundle);
        return bVar;
    }

    @Override // androidx.preference.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f5302u0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f5303v0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f5304w0);
    }

    @Override // androidx.preference.b
    public void I1(boolean z2) {
        int i3;
        ListPreference listPreferenceL1 = L1();
        if (!z2 || (i3 = this.f5302u0) < 0) {
            return;
        }
        String string = this.f5304w0[i3].toString();
        if (listPreferenceL1.b(string)) {
            listPreferenceL1.L0(string);
        }
    }

    @Override // androidx.preference.b
    protected void J1(androidx.appcompat.app.a.C0000a c0000a) {
        super.J1(c0000a);
        c0000a.o(this.f5303v0, this.f5302u0, new a());
        c0000a.m(null, null);
    }

    @Override // androidx.preference.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        if (bundle != null) {
            this.f5302u0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f5303v0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f5304w0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceL1 = L1();
        if (listPreferenceL1.G0() == null || listPreferenceL1.I0() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f5302u0 = listPreferenceL1.F0(listPreferenceL1.J0());
        this.f5303v0 = listPreferenceL1.G0();
        this.f5304w0 = listPreferenceL1.I0();
    }
}
