package n0;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends androidx.preference.b {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    Set<String> f5306u0 = new HashSet();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    boolean f5307v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    CharSequence[] f5308w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    CharSequence[] f5309x0;

    /* JADX INFO: compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i3, boolean z2) {
            if (z2) {
                c cVar = c.this;
                cVar.f5307v0 |= cVar.f5306u0.add(cVar.f5309x0[i3].toString());
            } else {
                c cVar2 = c.this;
                cVar2.f5307v0 |= cVar2.f5306u0.remove(cVar2.f5309x0[i3].toString());
            }
        }
    }

    private AbstractMultiSelectListPreference L1() {
        return (AbstractMultiSelectListPreference) E1();
    }

    public static c M1(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.m1(bundle);
        return cVar;
    }

    @Override // androidx.preference.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f5306u0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f5307v0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f5308w0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f5309x0);
    }

    @Override // androidx.preference.b
    public void I1(boolean z2) {
        AbstractMultiSelectListPreference abstractMultiSelectListPreferenceL1 = L1();
        if (z2 && this.f5307v0) {
            Set<String> set = this.f5306u0;
            if (abstractMultiSelectListPreferenceL1.b(set)) {
                abstractMultiSelectListPreferenceL1.I0(set);
            }
        }
        this.f5307v0 = false;
    }

    @Override // androidx.preference.b
    protected void J1(androidx.appcompat.app.a.C0000a c0000a) {
        super.J1(c0000a);
        int length = this.f5309x0.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = this.f5306u0.contains(this.f5309x0[i3].toString());
        }
        c0000a.h(this.f5308w0, zArr, new a());
    }

    @Override // androidx.preference.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        if (bundle != null) {
            this.f5306u0.clear();
            this.f5306u0.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f5307v0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f5308w0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f5309x0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        AbstractMultiSelectListPreference abstractMultiSelectListPreferenceL1 = L1();
        if (abstractMultiSelectListPreferenceL1.F0() == null || abstractMultiSelectListPreferenceL1.G0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f5306u0.clear();
        this.f5306u0.addAll(abstractMultiSelectListPreferenceL1.H0());
        this.f5307v0 = false;
        this.f5308w0 = abstractMultiSelectListPreferenceL1.F0();
        this.f5309x0 = abstractMultiSelectListPreferenceL1.G0();
    }
}
