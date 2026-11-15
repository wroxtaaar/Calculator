package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import n0.h;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final Context Y;
    private final ArrayAdapter Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Spinner f1589a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f1590b0;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (i3 >= 0) {
                String string = DropDownPreference.this.I0()[i3].toString();
                if (string.equals(DropDownPreference.this.J0()) || !DropDownPreference.this.b(string)) {
                    return;
                }
                DropDownPreference.this.L0(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, n0.f.dropdownPreferenceStyle);
    }

    private void O0() {
        this.Z.clear();
        if (G0() != null) {
            for (CharSequence charSequence : G0()) {
                this.Z.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void H() {
        super.H();
        this.Z.notifyDataSetChanged();
    }

    protected ArrayAdapter M0() {
        return new ArrayAdapter(this.Y, R.layout.simple_spinner_dropdown_item);
    }

    @Override // androidx.preference.Preference
    public void N(g gVar) {
        Spinner spinner = (Spinner) gVar.f1813a.findViewById(h.spinner);
        this.f1589a0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.Z);
        this.f1589a0.setOnItemSelectedListener(this.f1590b0);
        this.f1589a0.setSelection(N0(J0()));
        super.N(gVar);
    }

    public int N0(String str) {
        CharSequence[] charSequenceArrI0 = I0();
        if (str == null || charSequenceArrI0 == null) {
            return -1;
        }
        for (int length = charSequenceArrI0.length - 1; length >= 0; length--) {
            if (charSequenceArrI0[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void O() {
        this.f1589a0.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f1590b0 = new a();
        this.Y = context;
        this.Z = M0();
        O0();
    }
}
