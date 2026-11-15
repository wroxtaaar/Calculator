package com.vivo.calculator.keybord;

import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.vivo.calculator.Calculator;
import com.vivo.calculator.R;
import g2.b;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class ColorSelectButton extends ImageButton implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View.OnClickListener f4151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Calculator f4158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f4159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4160k;

    public ColorSelectButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4152c = false;
        this.f4153d = false;
        this.f4154e = false;
        this.f4158i = null;
        this.f4159j = null;
        Context applicationContext = context.getApplicationContext();
        this.f4159j = applicationContext;
        this.f4158i = (Calculator) context;
        this.f4160k = b.f(applicationContext, 1.0f);
        this.f4155f = this.f4159j.getColor(R.color.button_select_stroke_color);
        if (Settings.System.getInt(this.f4159j.getContentResolver(), "vivo_nightmode_used", -2) == 1) {
            this.f4156g = this.f4159j.getColor(R.color.button_select_stroke_fill_color_dark);
        } else {
            this.f4156g = this.f4159j.getColor(R.color.button_select_stroke_fill_color);
        }
        this.f4157h = this.f4159j.getColor(R.color.button_pressed_background_color);
        setOnClickListener(this);
        this.f4151b = this.f4158i.x0();
        setSoundEffectsEnabled(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4151b.onClick(this);
        int i3 = this.f4154e ? 3 : 1;
        VLog.d("BBKCalculator/ColorSelectText", "index:" + i3);
        this.f4158i.g1(i3);
    }

    public void setClearState(boolean z2) {
        this.f4154e = z2;
    }

    public void setSelect(boolean z2) {
        this.f4153d = z2;
    }
}
