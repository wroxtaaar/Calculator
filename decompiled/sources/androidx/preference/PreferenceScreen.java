package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean W;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, v.g.a(context, n0.f.preferenceScreenStyle, R.attr.preferenceScreenStyle));
        this.W = true;
    }

    @Override // androidx.preference.PreferenceGroup
    protected boolean G0() {
        return false;
    }

    public boolean L0() {
        return this.W;
    }

    @Override // androidx.preference.Preference
    protected void O() {
        f.b bVarG;
        if (n() != null || l() != null || F0() == 0 || (bVarG = x().g()) == null) {
            return;
        }
        bVarG.f(this);
    }
}
