package com.vivo.calculator;

import a2.e;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class CalculatorSettingActivity extends b.b implements e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private b.a f3667t;

    @Override // a2.e
    public void a(boolean z2) {
        VLog.d("BBKCalculator/CalculatorSettingActivity", "setCalculatorConfigurationInfo isNexScreenChange = " + z2);
        if (z2) {
            if (g2.b.o(this)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    @Override // b.b, androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VLog.d("BBKCalculator/CalculatorSettingActivity", "onConfigurationChanged: ");
        if (g2.b.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // b.b, androidx.fragment.app.d, androidx.activity.ComponentActivity, t.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        g2.d.a(this);
        if (!g2.b.b(this)) {
            setTheme(R.style.SettingThemeOverlay);
        }
        if (g2.b.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        VLog.d("BBKCalculator/CalculatorSettingActivity", "onCreate.");
        b.a aVarW = w();
        this.f3667t = aVarW;
        aVarW.s(true);
        this.f3667t.v(getResources().getString(R.string.setting));
        this.f3667t.t(true);
        setContentView(R.layout.base_preference);
        o().i().m(R.id.settings_container, new z1.b()).f();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.settings_container);
        if (g2.b.b(this)) {
            linearLayout.setBackgroundResource(R.color.setting_background_material);
        }
        BBKCalculatorApplication.a().t(this);
    }

    @Override // b.b, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        VLog.d("BBKCalculator/CalculatorSettingActivity", "onDestroy.");
        super.onDestroy();
        BBKCalculatorApplication.a().t(null);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        super.onMultiWindowModeChanged(z2);
        VLog.d("BBKCalculator/CalculatorSettingActivity", "onMultiWindowModeChanged: ");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
