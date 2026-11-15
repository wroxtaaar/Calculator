package com.vos.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.SwitchPreferenceCompat;
import x2.d;

/* JADX INFO: loaded from: classes.dex */
public class VSwitchPreferenceCompat extends SwitchPreferenceCompat {
    private d V;
    private boolean W;

    public VSwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.W = true;
        this.V = new d(context);
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    protected void O() {
        super.O();
        d dVar = this.V;
        if (dVar == null || !this.W) {
            return;
        }
        dVar.a();
    }

    public VSwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.W = true;
        this.V = new d(context);
    }

    public VSwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = true;
        this.V = new d(context);
    }

    public VSwitchPreferenceCompat(Context context) {
        super(context);
        this.W = true;
        this.V = new d(context);
    }
}
