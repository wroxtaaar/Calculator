package n0;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.preference.EditTextPreference;

/* JADX INFO: compiled from: EditTextPreferenceDialogFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.preference.b {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private EditText f5300u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private CharSequence f5301v0;

    private EditTextPreference L1() {
        return (EditTextPreference) E1();
    }

    public static a M1(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.m1(bundle);
        return aVar;
    }

    @Override // androidx.preference.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f5301v0);
    }

    @Override // androidx.preference.b
    protected boolean F1() {
        return true;
    }

    @Override // androidx.preference.b
    protected void G1(View view) {
        super.G1(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f5300u0 = editText;
        editText.requestFocus();
        EditText editText2 = this.f5300u0;
        if (editText2 == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText2.setText(this.f5301v0);
        EditText editText3 = this.f5300u0;
        editText3.setSelection(editText3.getText().length());
    }

    @Override // androidx.preference.b
    public void I1(boolean z2) {
        if (z2) {
            String string = this.f5300u0.getText().toString();
            if (L1().b(string)) {
                L1().G0(string);
            }
        }
    }

    @Override // androidx.preference.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        if (bundle == null) {
            this.f5301v0 = L1().F0();
        } else {
            this.f5301v0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }
}
