package com.vivo.calculator.keybord;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.vivo.calculator.Calculator;
import com.vivo.calculator.R;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class ColorButton extends ImageButton implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View.OnClickListener f4147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Calculator f4148c;

    public ColorButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4148c = null;
        this.f4148c = (Calculator) context;
        setOnClickListener(this);
        this.f4147b = this.f4148c.x0();
        setSoundEffectsEnabled(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        this.f4147b.onClick(this);
        int id = view.getId();
        switch (id) {
            case R.id.clear /* 2131230845 */:
            case R.id.del /* 2131230881 */:
                i3 = 3;
                break;
            case R.id.clr /* 2131230851 */:
                i3 = 4;
                break;
            case R.id.dec_point /* 2131230876 */:
            case R.id.op_pct /* 2131231174 */:
                i3 = 0;
                break;
            case R.id.eq /* 2131230954 */:
                i3 = 2;
                break;
            default:
                switch (id) {
                    case R.id.digit_0 /* 2131230891 */:
                    case R.id.digit_1 /* 2131230892 */:
                    case R.id.digit_2 /* 2131230893 */:
                    case R.id.digit_3 /* 2131230894 */:
                    case R.id.digit_4 /* 2131230895 */:
                    case R.id.digit_5 /* 2131230896 */:
                    case R.id.digit_6 /* 2131230897 */:
                    case R.id.digit_7 /* 2131230898 */:
                    case R.id.digit_8 /* 2131230899 */:
                    case R.id.digit_9 /* 2131230900 */:
                        i3 = 0;
                        break;
                    default:
                        i3 = 1;
                        break;
                }
                break;
        }
        VLog.d("BBKCalculator/ColorButton", "index:" + i3);
        this.f4148c.g1(i3);
    }
}
