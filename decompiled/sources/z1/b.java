package z1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.vivo.calculator.R;
import com.vos.widget.VSwitchPreferenceCompat;
import vivo.util.VLog;

/* JADX INFO: compiled from: CalculatorSettingFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.preference.c implements Preference.d {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private VSwitchPreferenceCompat f6639i0;

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
    }

    @Override // androidx.preference.c
    public void C1(Bundle bundle, String str) {
        VLog.d("BBKCalculator/CalculatorSettingActivity", "onCreatePreferences.");
        u1(R.xml.setting_preferences);
        VSwitchPreferenceCompat vSwitchPreferenceCompat = (VSwitchPreferenceCompat) h("preferences_button_tone");
        this.f6639i0 = vSwitchPreferenceCompat;
        if (vSwitchPreferenceCompat != null) {
            vSwitchPreferenceCompat.o0(this);
        }
    }

    @Override // androidx.preference.c
    public RecyclerView D1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (u().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.base_fragment, viewGroup, true).findViewById(R.id.recycler_view);
        recyclerView2.setLayoutManager(B1());
        recyclerView2.setAccessibilityDelegateCompat(new n0.e(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.preference.Preference.d
    public boolean a(Preference preference, Object obj) {
        String strO = preference.o();
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (!"preferences_button_tone".equals(strO)) {
            return true;
        }
        androidx.preference.f.b(n()).edit().putBoolean("preferences_button_tone", zBooleanValue).commit();
        this.f6639i0.A0(zBooleanValue);
        if (zBooleanValue) {
            h2.a.a().f(14);
            return true;
        }
        h2.a.a().f(15);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void m0() {
        VLog.d("BBKCalculator/CalculatorSettingActivity", "onDestroy.");
        super.m0();
    }
}
