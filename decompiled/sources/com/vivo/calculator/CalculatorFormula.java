package com.vivo.calculator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.TextView;
import com.vivo.seckeysdk.BuildConfig;
import vivo.util.VLog;
import z1.e;
import z1.g;

/* JADX INFO: loaded from: classes.dex */
public class CalculatorFormula extends EditText {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f3628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f3631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f3632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f3633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f3635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f3637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Calculator f3638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f3639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Calculator.c0 f3640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3641o;

    public interface a {
        void a(String str);
    }

    public interface b {
    }

    public CalculatorFormula(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3632f = new TextPaint();
        this.f3633g = new Rect();
        this.f3634h = false;
        this.f3635i = 1.0f;
        this.f3636j = -1;
        this.f3641o = -1;
        this.f3637k = context;
        this.f3638l = (Calculator) context;
        if (g2.b.o(context) && !this.f3638l.isInMultiWindowMode()) {
            this.f3629c = getResources().getDimension(R.dimen.max_result_text_size_nex);
            this.f3630d = getResources().getDimension(R.dimen.min_result_text_size_nex);
        } else if (getResources().getConfiguration().orientation != 1 || ((Activity) this.f3637k).isInMultiWindowMode()) {
            this.f3629c = getResources().getDimension(R.dimen.max_land_result_text_size);
            this.f3630d = getResources().getDimension(R.dimen.min_land_result_text_size);
        } else if (this.f3638l.R0()) {
            this.f3629c = getResources().getDimension(R.dimen.max_mul_free_result_text_size);
            this.f3630d = getResources().getDimension(R.dimen.min_mul_free_result_text_size);
        } else {
            this.f3629c = getResources().getDimension(R.dimen.max_result_text_size);
            this.f3630d = getResources().getDimension(R.dimen.min_result_text_size);
        }
        this.f3631e = this.f3629c - this.f3630d;
        if (d()) {
            setTextSize(0, this.f3629c);
        }
    }

    private boolean d() {
        if (Build.VERSION.SDK_INT >= 30) {
            return this.f3634h && !((Activity) this.f3637k).isInMultiWindowMode();
        }
        Activity activity = (Activity) this.f3637k;
        return this.f3634h && !((Activity) this.f3637k).isInMultiWindowMode() && (activity instanceof Calculator ? ((Calculator) activity).u0() : false);
    }

    public void a(CharSequence charSequence) {
        if (charSequence.length() > 0) {
            setSelection(charSequence.length());
        } else {
            setSelection(0);
        }
    }

    public void b(CharSequence charSequence) {
        Editable text = getText();
        CharSequence charSequenceB = g.b(charSequence, text, e.D(",").charAt(0));
        int length = TextUtils.isEmpty(charSequence) ? 0 : charSequence.length();
        int length2 = TextUtils.isEmpty(text) ? 0 : text.length();
        VLog.d("BBKCalculator/CalculatorFormula", "changeTextTo:oldText:" + ((Object) text) + ",newText:" + ((Object) charSequence));
        int selectionStart = getSelectionStart();
        if (selectionStart < 0) {
            selectionStart = 0;
        }
        if (!TextUtils.isEmpty(getTextString()) && selectionStart != getTextString().length() && ",".equals(String.valueOf(getTextString().charAt(selectionStart))) && length < length2 && length2 - length == 2) {
            length2--;
        }
        this.f3641o = (selectionStart + length) - length2;
        if (charSequenceB == null) {
            announceForAccessibility(charSequence);
        } else if (charSequenceB.length() == 1) {
            char cCharAt = charSequenceB.charAt(0);
            String strZ = e.z(getContext(), e.r(cCharAt));
            if (strZ != null) {
                announceForAccessibility(strZ);
            } else {
                announceForAccessibility(String.valueOf(cCharAt));
            }
        } else if (charSequenceB.length() != 0) {
            announceForAccessibility(charSequenceB);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setText(charSequence, TextView.BufferType.SPANNABLE);
        } else {
            setTextString(charSequence.toString());
        }
    }

    public float c(String str) {
        if (this.f3636j < 0 || this.f3629c <= this.f3630d || !d()) {
            return getTextSize();
        }
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            return this.f3629c;
        }
        this.f3632f.set(getPaint());
        float f3 = this.f3630d;
        while (true) {
            float f4 = this.f3629c;
            if (f3 >= f4) {
                break;
            }
            float fMin = Math.min(this.f3631e + f3, f4);
            this.f3632f.setTextSize(fMin);
            if (this.f3632f.measureText(str) > this.f3636j) {
                break;
            }
            f3 = fMin;
        }
        VLog.d("BBKCalculator/CalculatorFormula", "lastFitTextSize = " + f3);
        return f3;
    }

    public void e() {
    }

    public void f(int i3, int i4) {
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
        getPaint().getTextBounds("H", 0, 1, this.f3633g);
        return super.getCompoundPaddingTop() - Math.min(getPaddingTop(), -(getPaint().getFontMetricsInt().ascent + this.f3633g.height()));
    }

    public float getMaximumTextSize() {
        return this.f3629c;
    }

    public float getMinimumTextSize() {
        return this.f3630d;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return super.getText();
    }

    public String getTextString() {
        return g2.b.d(getText().toString());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (TextUtils.isEmpty(getContentDescription())) {
            return;
        }
        accessibilityNodeInfo.setText(getContentDescription());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        this.f3636j = (View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight();
        if (Calculator.I1) {
            return;
        }
        setTextSize(0, c(getTextString()));
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        VLog.d("BBKCalculator/CalculatorFormula", "text = " + ((Object) charSequence) + ", isCallZoom = " + d() + ", mZoom = " + this.f3634h);
        if (charSequence == null || BuildConfig.FLAVOR.equals(charSequence)) {
            return;
        }
        int length = charSequence.length();
        if (getSelectionStart() != length || getSelectionEnd() != length) {
            setSelection(length);
        }
        String string = getText().toString();
        a aVar = this.f3628b;
        if (aVar != null) {
            aVar.a(string);
        }
        if (d()) {
            float textSize = getTextSize();
            float fC = c(string);
            VLog.d("BBKCalculator/CalculatorFormula", "oldTextSize:" + textSize + ",newTextSize:" + fC + ",IS_ANIMATION_PLAYING:" + Calculator.I1);
            setTextSize(0, fC);
            if (fC != textSize && !Calculator.J1 && !Calculator.I1 && !BBKCalculatorApplication.f()) {
                float fC2 = textSize / c(getTextString());
                setPivotX(getWidth());
                setPivotY(getHeight() / 2.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CalculatorFormula, Float>) View.SCALE_X, fC2, 1.0f), ObjectAnimator.ofFloat(this, (Property<CalculatorFormula, Float>) View.SCALE_Y, fC2, 1.0f));
                animatorSet.setDuration(300L);
                animatorSet.setInterpolator(new PathInterpolator(0.15f, 0.25f, 0.15f, 1.0f));
                animatorSet.start();
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(null);
        } else {
            setContentDescription(g2.b.w(getContext(), charSequence.toString()));
        }
        VLog.d("BBKCalculator/CalculatorFormula", "mEditIndex:" + this.f3641o + ",textLength:" + length);
        int i6 = this.f3641o;
        if (i6 < 0 && length == 0) {
            setSelection(0);
        } else if (i6 < 0 || i6 > length || length == 1) {
            setSelection(length);
        } else {
            setSelection(i6);
        }
        this.f3641o = -1;
    }

    public void setOnDisplayMemoryOperationsListener(Calculator.c0 c0Var) {
        this.f3640n = c0Var;
    }

    public void setOnTextChangeListener(a aVar) {
        this.f3628b = aVar;
    }

    public void setOnTextSizeChangeListener(b bVar) {
        this.f3639m = bVar;
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        getTextSize();
        super.setTextSize(i3, f3);
    }

    public void setTextString(String str) {
        if (g2.b.b(this.f3637k)) {
            setText(g.c(this.f3637k.getResources().getColor(R.color.thumbsSelect_background_color_material), g2.b.c(str)), TextView.BufferType.SPANNABLE);
        } else {
            setText(g.c(this.f3637k.getResources().getColor(R.color.function_text_blue_color), g2.b.c(str)), TextView.BufferType.SPANNABLE);
        }
    }

    public void setZoom(boolean z2) {
        this.f3634h = z2;
    }
}
