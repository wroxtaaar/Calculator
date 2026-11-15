package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    private final a S;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (CheckBoxPreference.this.b(Boolean.valueOf(z2))) {
                CheckBoxPreference.this.A0(z2);
            } else {
                compoundButton.setChecked(!z2);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G0(View view) {
        boolean z2 = view instanceof CompoundButton;
        if (z2) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.P);
        }
        if (z2) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.S);
        }
    }

    private void H0(View view) {
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            G0(view.findViewById(R.id.checkbox));
            E0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void N(g gVar) {
        super.N(gVar);
        G0(gVar.M(R.id.checkbox));
        F0(gVar);
    }

    @Override // androidx.preference.Preference
    protected void Z(View view) {
        super.Z(view);
        H0(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.S = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.CheckBoxPreference, i3, i4);
        D0(v.g.o(typedArrayObtainStyledAttributes, l.CheckBoxPreference_summaryOn, l.CheckBoxPreference_android_summaryOn));
        C0(v.g.o(typedArrayObtainStyledAttributes, l.CheckBoxPreference_summaryOff, l.CheckBoxPreference_android_summaryOff));
        B0(v.g.b(typedArrayObtainStyledAttributes, l.CheckBoxPreference_disableDependentsState, l.CheckBoxPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.checkBoxPreferenceStyle, R.attr.checkBoxPreferenceStyle));
    }
}
