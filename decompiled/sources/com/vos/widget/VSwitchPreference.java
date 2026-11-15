package com.vos.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.SwitchPreference;
import x2.d;

/* JADX INFO: loaded from: classes.dex */
public class VSwitchPreference extends SwitchPreference {
    private d V;
    private boolean W;

    public VSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
}
