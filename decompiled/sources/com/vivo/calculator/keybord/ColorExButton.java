package com.vivo.calculator.keybord;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.vivo.calculator.ExchangeActivity;
import com.vivo.calculator.R;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class ColorExButton extends ImageButton implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View.OnClickListener f4149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExchangeActivity f4150c;

    public ColorExButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4150c = null;
        this.f4150c = (ExchangeActivity) context;
        setOnClickListener(this);
        this.f4149b = this.f4150c.t1();
        setSoundEffectsEnabled(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        this.f4149b.onClick(this);
        switch (view.getId()) {
            case R.id.e_clr /* 2131230924 */:
                i3 = 4;
                break;
            case R.id.e_dec_point /* 2131230925 */:
            case R.id.e_digit_0 /* 2131230927 */:
            case R.id.e_digit_00 /* 2131230928 */:
            case R.id.e_digit_1 /* 2131230929 */:
            case R.id.e_digit_2 /* 2131230930 */:
            case R.id.e_digit_3 /* 2131230931 */:
            case R.id.e_digit_4 /* 2131230932 */:
            case R.id.e_digit_5 /* 2131230933 */:
            case R.id.e_digit_6 /* 2131230934 */:
            case R.id.e_digit_7 /* 2131230935 */:
            case R.id.e_digit_8 /* 2131230936 */:
            case R.id.e_digit_9 /* 2131230937 */:
                i3 = 0;
                break;
            case R.id.e_del /* 2131230926 */:
                i3 = 3;
                break;
            case R.id.e_eq /* 2131230938 */:
                i3 = 2;
                break;
            default:
                i3 = 1;
                break;
        }
        VLog.d("BBKCalculator/ColorButton", "index:" + i3);
        this.f4150c.C3(true);
        this.f4150c.y2(i3);
    }
}
