package androidx.preference;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    @Override // androidx.preference.Preference
    public boolean D() {
        return false;
    }

    @Override // androidx.preference.Preference
    public void N(g gVar) {
        super.N(gVar);
        if (Build.VERSION.SDK_INT >= 28) {
            gVar.f1813a.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public void S(f0.d dVar) {
        f0.d.c cVarQ;
        super.S(dVar);
        if (Build.VERSION.SDK_INT >= 28 || (cVarQ = dVar.q()) == null) {
            return;
        }
        dVar.a0(f0.d.c.f(cVarQ.c(), cVarQ.d(), cVarQ.a(), cVarQ.b(), true, cVarQ.e()));
    }

    @Override // androidx.preference.Preference
    public boolean u0() {
        return !super.D();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.preferenceCategoryStyle, R.attr.preferenceCategoryStyle));
    }
}
