package com.vivo.calculator.exchange;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.vivo.calculator.Calculator;
import com.vivo.calculator.ExchangeActivity;
import com.vivo.calculator.R;
import com.vivo.seckeysdk.BuildConfig;
import vivo.util.VLog;
import z1.e;
import z1.g;

/* JADX INFO: loaded from: classes.dex */
public class InputTextView extends EditText {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f4090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f4091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f4094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f4095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f4098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private c f4099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f4100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Calculator.c0 f4102n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ClipboardManager f4103o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f4104p;

    public interface a {
    }

    public interface b {
        void a(String str);
    }

    public interface c {
    }

    public InputTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4094f = new TextPaint();
        this.f4095g = new Rect();
        this.f4096h = false;
        this.f4097i = -1;
        this.f4101m = 1.0f;
        this.f4104p = -1;
        VLog.d("BBKCalculator/InputTextView", "InputTextView:");
        this.f4098j = context;
        this.f4103o = (ClipboardManager) context.getSystemService("clipboard");
        this.f4091c = getResources().getDimension(R.dimen.exchange_input_text_size);
        float dimension = getResources().getDimension(R.dimen.exchange_input_text_small_size);
        this.f4092d = dimension;
        this.f4093e = this.f4091c - dimension;
        if (d()) {
            setTextSize(0, this.f4091c);
        }
    }

    private boolean d() {
        VLog.d("BBKCalculator/InputTextView", "isCallZoom:");
        return getResources().getConfiguration().orientation == 1 && this.f4096h && !((Activity) this.f4098j).isInMultiWindowMode();
    }

    public void a(CharSequence charSequence) {
        VLog.d("BBKCalculator/InputTextView", "changeSectionToEnd:");
        if (charSequence.length() > 0) {
            setSelection(charSequence.length());
        } else {
            setSelection(0);
        }
    }

    public void b(CharSequence charSequence) {
        VLog.d("BBKCalculator/InputTextView", "changeTextTo:");
        Editable text = getText();
        g.b(charSequence, text, e.D(",").charAt(0));
        int length = TextUtils.isEmpty(charSequence) ? 0 : charSequence.length();
        int length2 = TextUtils.isEmpty(text) ? 0 : text.length();
        int selectionStart = getSelectionStart();
        int i3 = selectionStart >= 0 ? selectionStart : 0;
        if (!TextUtils.isEmpty(getTextString()) && i3 != getTextString().length() && ",".equals(String.valueOf(getTextString().charAt(i3))) && length < length2 && length2 - length == 2) {
            length2--;
        }
        this.f4104p = (i3 + length) - length2;
        if (TextUtils.isEmpty(charSequence)) {
            setText(charSequence);
        } else {
            setTextString(charSequence.toString());
        }
    }

    public float c(String str) {
        VLog.d("BBKCalculator/InputTextView", "getVariableTextSize:");
        if (this.f4097i < 0 || this.f4091c <= this.f4092d || !d() || str == null || str.equals(BuildConfig.FLAVOR)) {
            return getTextSize();
        }
        this.f4094f.set(getPaint());
        float f3 = this.f4092d;
        while (true) {
            float f4 = this.f4091c;
            if (f3 >= f4) {
                break;
            }
            float fMin = Math.min(this.f4093e + f3, f4);
            this.f4094f.setTextSize(fMin);
            if (this.f4094f.measureText(str) > this.f4097i) {
                break;
            }
            f3 = fMin;
        }
        return f3;
    }

    public void e(int i3, int i4) {
        VLog.d("BBKCalculator/InputTextView", "setSectionBeforeOperator:");
        if (i3 > i4) {
            setSelection(i4);
        } else if (i3 < 0) {
            setSelection(0);
        } else {
            setSelection(i3);
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingBottom() {
        return super.getCompoundPaddingBottom() - Math.min(getPaddingBottom(), getPaint().getFontMetricsInt().descent);
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingTop() {
        getPaint().getTextBounds("H", 0, 1, this.f4095g);
        return super.getCompoundPaddingTop() - Math.min(getPaddingTop(), -(getPaint().getFontMetricsInt().ascent + this.f4095g.height()));
    }

    public float getMaxTextSize() {
        VLog.d("BBKCalculator/InputTextView", "getMaxTextSize:");
        return this.f4091c;
    }

    public float getMinimumTextSize() {
        VLog.d("BBKCalculator/InputTextView", "getMinimumTextSize:");
        return this.f4092d;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return super.getText();
    }

    public String getTextString() {
        VLog.d("BBKCalculator/InputTextView", "getTextString:");
        return g2.b.d(getText().toString());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        VLog.d("BBKCalculator/InputTextView", "onInitializeAccessibilityNodeInfo:");
        if (TextUtils.isEmpty(getContentDescription())) {
            return;
        }
        accessibilityNodeInfo.setText(getContentDescription());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        this.f4097i = (View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight();
        if (ExchangeActivity.N1) {
            return;
        }
        setTextSize(0, c(getTextString()));
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        VLog.d("BBKCalculator/InputTextView", "text = " + ((Object) charSequence) + ", isCallZoom = " + d() + ", mZoom = " + this.f4096h);
        if (charSequence == null || BuildConfig.FLAVOR.equals(charSequence)) {
            return;
        }
        int length = charSequence.length();
        if (getSelectionStart() != length || getSelectionEnd() != length) {
            setSelection(length);
        }
        String textString = getTextString();
        b bVar = this.f4090b;
        if (bVar != null) {
            bVar.a(textString);
        }
        if (d()) {
            setTextSize(0, c(textString));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(null);
        } else {
            setContentDescription(g2.b.w(getContext(), charSequence.toString()));
        }
        VLog.d("BBKCalculator/InputTextView", "mEditIndex:" + this.f4104p + ",textLength:" + length);
        int i6 = this.f4104p;
        if (i6 > 0 && i6 < length) {
            setSelection(i6);
        } else if ((i6 > 0 || length <= 0) && i6 <= 0) {
            setSelection(0);
        } else {
            setSelection(length);
        }
        this.f4104p = -1;
    }

    public void setOnContextMenuClickListener(a aVar) {
        this.f4100l = aVar;
    }

    public void setOnDisplayMemoryOperationsListener(Calculator.c0 c0Var) {
        this.f4102n = c0Var;
    }

    public void setOnTextChangeListener(b bVar) {
        this.f4090b = bVar;
    }

    public void setOnTextSizeChangeListener(c cVar) {
        this.f4099k = cVar;
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        VLog.d("BBKCalculator/InputTextView", "setTextSize:");
        getTextSize();
        super.setTextSize(i3, f3);
    }

    public void setTextString(String str) {
        VLog.e("BBKCalculator/InputTextView", "setTextString : " + str);
        if (g2.b.b(this.f4098j)) {
            setText(g.c(this.f4098j.getResources().getColor(R.color.thumbsSelect_background_color_material), g2.b.c(str)), TextView.BufferType.SPANNABLE);
        } else {
            setText(g.c(this.f4098j.getResources().getColor(R.color.thumbsSelect_background_color), g2.b.c(str)), TextView.BufferType.SPANNABLE);
        }
    }

    public void setZoom(boolean z2) {
        VLog.d("BBKCalculator/InputTextView", "setZoom:");
        this.f4096h = z2;
    }
}
