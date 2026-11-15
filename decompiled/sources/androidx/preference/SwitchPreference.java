package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private final a S;
    private CharSequence T;
    private CharSequence U;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (SwitchPreference.this.b(Boolean.valueOf(z2))) {
                SwitchPreference.this.A0(z2);
            } else {
                compoundButton.setChecked(!z2);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.S = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.SwitchPreference, i3, i4);
        D0(v.g.o(typedArrayObtainStyledAttributes, l.SwitchPreference_summaryOn, l.SwitchPreference_android_summaryOn));
        C0(v.g.o(typedArrayObtainStyledAttributes, l.SwitchPreference_summaryOff, l.SwitchPreference_android_summaryOff));
        H0(v.g.o(typedArrayObtainStyledAttributes, l.SwitchPreference_switchTextOn, l.SwitchPreference_android_switchTextOn));
        G0(v.g.o(typedArrayObtainStyledAttributes, l.SwitchPreference_switchTextOff, l.SwitchPreference_android_switchTextOff));
        B0(v.g.b(typedArrayObtainStyledAttributes, l.SwitchPreference_disableDependentsState, l.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void I0(View view) {
        boolean z2 = view instanceof Switch;
        if (z2) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.P);
        }
        if (z2) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.T);
            r4.setTextOff(this.U);
            r4.setOnCheckedChangeListener(this.S);
        }
    }

    private void J0(View view) {
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            I0(view.findViewById(R.id.switch_widget));
            E0(view.findViewById(R.id.summary));
        }
    }

    public void G0(CharSequence charSequence) {
        this.U = charSequence;
        H();
    }

    public void H0(CharSequence charSequence) {
        this.T = charSequence;
        H();
    }

    @Override // androidx.preference.Preference
    public void N(g gVar) {
        super.N(gVar);
        I0(gVar.M(R.id.switch_widget));
        F0(gVar);
    }

    @Override // androidx.preference.Preference
    protected void Z(View view) {
        super.Z(view);
        J0(view);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.switchPreferenceStyle, R.attr.switchPreferenceStyle));
    }
}
