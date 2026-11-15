package com.vivo.calculator;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.OverScroller;
import com.vivo.seckeysdk.BuildConfig;
import vivo.util.VLog;
import z1.e;
import z1.g;

/* JADX INFO: loaded from: classes.dex */
public class CalculatorResult extends EditText implements b.j, b.g {
    private boolean A;
    private Context B;
    private final int C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final OverScroller f3642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f3644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f3655o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f3656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f3657q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f3658r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3659s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f3660t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f3661u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f3662v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f3663w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3664x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private b.j f3665y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final BackgroundColorSpan f3666z;

    public CalculatorResult(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3645e = false;
        this.f3646f = false;
        this.f3658r = new Object();
        this.f3659s = 0;
        this.f3660t = 1.0f;
        this.f3664x = 2;
        this.f3665y = this;
        this.A = false;
        this.C = 1000000;
        this.B = context;
        this.f3642b = new OverScroller(context);
        this.f3666z = new BackgroundColorSpan(getHighlightColor());
    }

    private final int d(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return ((int) Math.ceil(Math.log10(Math.abs(i3)) + 1.0E-10d)) + (i3 >= 0 ? 1 : 2);
    }

    private String e(String str, int i3, int i4, boolean z2, boolean z3, int[] iArr, boolean z4) {
        int i5;
        int integer;
        int integer2;
        int i6;
        boolean z5;
        int iD;
        char c3;
        String strSubstring;
        float fA;
        int i7;
        String string = str;
        int iL = z2 ? -1 : l(str);
        if (z2 || (z3 && string.charAt(0) != '-')) {
            string = "…" + string.substring(1, str.length());
            i5 = 1;
        } else {
            i5 = 0;
        }
        int iIndexOf = string.indexOf(46);
        if (iArr != null) {
            iArr[0] = i3;
        }
        if (g2.b.o(this.B) && Calculator.G1 && getResources().getConfiguration().orientation == 1 && g2.b.n()) {
            if (Calculator.H1) {
                integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number_small_largesize);
                integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places_small_largesize);
            } else {
                integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number_fold_por_mul_largesize);
                integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places_fold_por_mul_largesize);
            }
        } else if (g2.b.o(this.B) && Calculator.G1 && getResources().getConfiguration().orientation == 2 && g2.b.n()) {
            integer = this.B.getResources().getInteger(R.integer.science_result_decimal_places_number_largesize_mul);
            integer2 = this.B.getResources().getInteger(R.integer.science_result_decimal_places_largesize);
        } else if (g2.b.o(this.B) && Calculator.G1 && getResources().getConfiguration().orientation == 1) {
            if (Calculator.H1) {
                integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number_fold_small);
                integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places_fold_small);
            } else {
                integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number_fold_por_mul);
                integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places_fold_por_mul);
            }
        } else if (g2.b.o(this.B) && g2.b.n()) {
            integer = this.B.getResources().getInteger(R.integer.science_result_decimal_places_number_fold_largesize);
            integer2 = this.B.getResources().getInteger(R.integer.science_result_decimal_places_fold_largesize);
        } else if (g2.b.o(this.B) && !Calculator.H1) {
            integer = this.B.getResources().getInteger(R.integer.science_result_decimal_places_number);
            integer2 = this.B.getResources().getInteger(R.integer.science_result_decimal_places);
        } else if (Calculator.H1 || (getResources().getConfiguration().orientation == 1 && (g2.b.n() || Calculator.G1))) {
            if (Calculator.H1 && g2.b.n()) {
                integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number_small_largesize);
                integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places_small_largesize);
            } else {
                integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number_largesize);
                integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places_largesize);
            }
        } else if (!Calculator.H1 && getResources().getConfiguration().orientation == 2 && (g2.b.n() || Calculator.G1)) {
            integer = this.B.getResources().getInteger(R.integer.science_result_decimal_places_number_largesize);
            integer2 = this.B.getResources().getInteger(R.integer.science_result_decimal_places_largesize);
        } else if (!Calculator.H1 && getResources().getConfiguration().orientation == 1 && g2.b.n()) {
            integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number_largesize);
            integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places_largesize);
        } else {
            integer = this.B.getResources().getInteger(R.integer.result_decimal_places_number);
            integer2 = this.B.getResources().getInteger(R.integer.result_decimal_places);
        }
        String str2 = BuildConfig.FLAVOR;
        if (((iIndexOf == -1 || (iL != Integer.MAX_VALUE && iL - iIndexOf > integer)) && i3 != -1) || ((string.length() > integer2 && iIndexOf == -1) || (iIndexOf >= 0 && iIndexOf > integer2))) {
            int i8 = -i3;
            if (i3 < 0) {
                i8--;
            }
            VLog.d("BBKCalculator/CalculatorResult", "formatResult: exponent == " + i8);
            if ((z2 || iL >= i4 - 1 || (string.length() - iL) + 1 + (z3 ? 1 : 0) > i4 + 1) && (!z4 || iIndexOf == -1)) {
                i6 = i8;
                z5 = false;
            } else {
                if (iIndexOf > iL) {
                    string = string.substring(0, iIndexOf) + string.substring(iIndexOf + 1, string.length());
                    VLog.d("BBKCalculator/CalculatorResult", "formatResult:   result = decIndex > msdIndex == " + string);
                }
                int length = string.length();
                int i9 = iL + 1;
                String strSubstring2 = string.substring(i9, length);
                VLog.d("BBKCalculator/CalculatorResult", "formatResult: fraction " + strSubstring2);
                StringBuilder sb = new StringBuilder();
                if (z3) {
                    str2 = "-";
                }
                sb.append(str2);
                sb.append(string.substring(iL, i9));
                sb.append(".");
                sb.append(strSubstring2);
                string = sb.toString();
                i6 = ((length + i8) - iL) - 1;
                z5 = true;
            }
            if (z5) {
                iD = d(i6);
                if (iD >= string.length() - 1) {
                    iD = Math.max(string.length() - 2, 0);
                }
            } else {
                int i10 = 2;
                while (true) {
                    i6 = i8 + i10;
                    if (d(i6) <= i10) {
                        break;
                    }
                    i10++;
                }
                if (i3 - i10 > this.f3653m) {
                    iD = i10 + 1;
                    i6++;
                } else {
                    iD = i10;
                }
            }
            if (iD >= string.length() - 1) {
                return "…E…";
            }
            VLog.d("BBKCalculator/CalculatorResult", "formatResult: dropDigits == " + iD);
            if (string.length() - iD > integer) {
                c3 = 0;
                strSubstring = string.substring(0, integer);
            } else {
                c3 = 0;
                strSubstring = string.substring(0, string.length() - iD);
            }
            VLog.i("BBKCalculator/CalculatorResult", "formatResult: start  == result  " + strSubstring);
            if (iArr != null) {
                iArr[c3] = iArr[c3] - iD;
            }
            if (strSubstring.indexOf(".") > 0 && strSubstring.endsWith("0")) {
                for (int length2 = strSubstring.length(); length2 >= 0 && strSubstring.endsWith("0"); length2--) {
                    strSubstring = strSubstring.substring(0, length2);
                }
            }
            string = strSubstring + "E" + Integer.toString(i6);
        } else if (z4) {
            VLog.d("BBKCalculator/CalculatorResult", "formatResult:  insertCommas ");
            int length3 = string.length();
            VLog.d("BBKCalculator/CalculatorResult", "formatResult: orig_length " + length3);
            VLog.d("BBKCalculator/CalculatorResult", "formatResult: decIndex == " + iIndexOf);
            if (iIndexOf != -1) {
                fA = a(string, iIndexOf);
                string = g.a(string, i5, iIndexOf) + string.substring(iIndexOf, length3);
            } else {
                fA = a(string, length3);
                string = g.a(string, i5, length3);
            }
            VLog.d("BBKCalculator/CalculatorResult", "formatResult:decIndex   result " + string);
            if (i5 != 0) {
                length3--;
            }
            float f3 = length3 + fA;
            getNoEllipsisCredit();
            getDecimalCredit();
            float f4 = 0.0f;
            float decimalCredit = f3 - (iIndexOf == -1 ? 0.0f : getDecimalCredit());
            if (decimalCredit - (i5 != 0 ? this.f3656p : getNoEllipsisCredit()) > (i4 - i5) + 1.0E-4f) {
                i7 = 0;
                while ((decimalCredit - this.f3656p) - f4 > i4 - 1) {
                    f4 += string.charAt(i7) == ',' ? this.f3661u : 1.0f;
                    i7++;
                }
            } else {
                i7 = 0;
            }
            VLog.d("BBKCalculator/CalculatorResult", "  formatResult:  deletedChars == " + i7);
            if ((i7 > 0 && string.replaceAll(",", BuildConfig.FLAVOR).length() > integer2) || string.replaceAll(",", BuildConfig.FLAVOR).length() > integer2) {
                if (z3) {
                    integer2++;
                }
                string = string.substring(0, (string.length() - string.replaceAll(",", BuildConfig.FLAVOR).length()) + integer2);
            } else if (i5 != 0) {
                string = "…" + string;
            }
            if (string.indexOf(".") > 0 && string.endsWith("0")) {
                for (int length4 = string.length(); length4 >= 0 && string.endsWith("0"); length4--) {
                    string = string.substring(0, length4);
                }
            }
            if (string.endsWith(".")) {
                string = string.substring(0, string.length() - 1);
            }
        }
        VLog.d("BBKCalculator/CalculatorResult", "  formatResult: result == " + string);
        return string;
    }

    private String j(int i3, int i4, int[] iArr, boolean z2) {
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = {i3};
        b bVar = this.f3644d;
        String strV1 = bVar != null ? bVar.v1(this.f3643c, iArr2, this.f3652l, i4, zArr, zArr2, this) : BuildConfig.FLAVOR;
        VLog.d("BBKCalculator/CalculatorResult", "getFormattedResult: mEvaluator.getString result  ==  " + strV1 + "insertCommas: " + z2);
        return e(strV1, iArr2[0], i4, zArr[0], zArr2[0], iArr, z2);
    }

    private static float k(TextPaint textPaint) {
        float[] fArr = new float[10];
        textPaint.getTextWidths("0123456789", fArr);
        float fMax = 0.0f;
        for (int i3 = 0; i3 < 10; i3++) {
            fMax = Math.max(fArr[i3], fMax);
        }
        return fMax;
    }

    public static int l(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '-' && cCharAt != '.' && cCharAt != '0') {
                return i3;
            }
        }
        return Integer.MAX_VALUE;
    }

    private void m(int i3, int i4, int i5, String str) {
        int iD;
        int maxChars = getMaxChars();
        this.f3651k = str.length();
        int iCeil = (int) Math.ceil((a(str, str.length()) - getNoEllipsisCredit()) - 1.0E-4f);
        this.f3655o = this.f3651k + iCeil <= maxChars;
        this.f3648h = 10010000;
        this.f3653m = i5;
        this.f3657q = false;
        int iRound = Math.round(i3 * this.f3660t);
        this.f3649i = iRound;
        this.f3647g = iRound;
        if (i4 == Integer.MAX_VALUE) {
            if (i5 == Integer.MIN_VALUE) {
                this.f3650j = iRound;
                this.f3652l = Math.round(iRound / this.f3660t);
                this.f3645e = false;
                return;
            } else {
                this.f3652l = 10000000;
                this.f3650j = 10000000;
                this.f3649i = (int) (iRound - this.f3660t);
                this.f3645e = true;
                return;
            }
        }
        int i6 = str.charAt(0) == '-' ? 1 : 0;
        int i7 = this.f3651k;
        if (i4 > i7 && i4 <= i7 + 3) {
            i4 = i7 - 1;
        }
        int i8 = i4 - i7;
        if (i8 > -1 && i8 < 14) {
            i8 = -1;
        }
        if (i5 >= 10000000) {
            this.f3652l = 10000000;
            this.f3650j = 10000000;
            this.f3645e = true;
            return;
        }
        this.f3652l = i5;
        if (i5 < -1 && i5 > -14) {
            this.f3652l = -1;
        }
        int i9 = this.f3652l;
        if (i9 < -1) {
            iD = d((-i8) - 1);
        } else {
            iD = (i8 > -1 || i9 >= maxChars) ? d(-i8) : 0;
        }
        boolean z2 = this.f3655o;
        if (!z2 || i8 >= -3) {
            iCeil = 0;
        }
        int i10 = this.f3652l;
        boolean z3 = (((i10 + iD) + iCeil) - i8) + i6 >= maxChars;
        this.f3645e = z3;
        if (iD > 0) {
            int iD2 = z3 ? i10 + d(-i5) : i10 + iD;
            if (this.f3652l > -1 || iD2 <= -1) {
                this.f3652l = Math.min(iD2, 10000000);
            } else {
                this.f3652l = -1;
            }
            this.f3650j = Math.min(Math.round(this.f3652l * this.f3660t), 10000000);
        } else if (z2 || z3) {
            this.f3650j = Math.min(Math.round(i10 * this.f3660t), 10000000);
        } else {
            boolean z4 = ((i10 + d((-i8) - 1)) - i8) + i6 >= maxChars;
            this.f3645e = z4;
            if (z4) {
                this.f3650j = (int) Math.ceil(this.f3649i + this.f3660t);
            } else {
                this.f3650j = this.f3649i;
                this.f3657q = true;
            }
        }
        if (this.f3645e) {
            return;
        }
        this.f3647g = this.f3650j;
    }

    @Override // com.vivo.calculator.b.g
    public float a(String str, int i3) {
        float f3;
        int i4 = 0;
        while (i4 < i3 && !Character.isDigit(str.charAt(i4))) {
            i4++;
        }
        int i5 = ((i3 - i4) - 1) / 3;
        synchronized (this.f3658r) {
            f3 = i5 * this.f3661u;
        }
        return f3;
    }

    @Override // com.vivo.calculator.b.j
    public void b(long j3, int i3) {
        VLog.d("BBKCalculator/CalculatorResult", "onError: ");
        this.A = false;
        this.f3646f = false;
        setLongClickable(false);
        this.f3645e = false;
        String string = getContext().getString(R.string.error);
        float desiredWidth = Layout.getDesiredWidth(string, getPaint());
        int i4 = this.f3659s;
        if (desiredWidth <= i4) {
            setText(string);
            return;
        }
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan((i4 * 0.99f) / desiredWidth);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(relativeSizeSpan, 0, string.length(), 33);
        setText(spannableString);
    }

    void c() {
        this.f3646f = false;
        this.f3645e = false;
        setText(BuildConfig.FLAVOR);
        setLongClickable(false);
    }

    @Override // com.vivo.calculator.b.j
    public void f(long j3) {
        c();
        this.A = false;
    }

    @Override // com.vivo.calculator.b.j
    public void g(long j3) {
        r();
    }

    @Override // com.vivo.calculator.b.g
    public float getDecimalCredit() {
        float f3;
        synchronized (this.f3658r) {
            f3 = this.f3662v;
        }
        return f3;
    }

    @Override // com.vivo.calculator.b.g
    public int getMaxChars() {
        int iFloor;
        synchronized (this.f3658r) {
            iFloor = (int) Math.floor(this.f3659s / this.f3660t);
        }
        return iFloor;
    }

    @Override // com.vivo.calculator.b.g
    public float getNoEllipsisCredit() {
        float f3;
        synchronized (this.f3658r) {
            f3 = this.f3663w;
        }
        return f3;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return super.getText();
    }

    public String getTextString() {
        return getText().toString();
    }

    @Override // com.vivo.calculator.b.j
    public void h(long j3, int i3, int i4, int i5, String str) {
        m(i3, i4, i5, str);
        if (this.A) {
            this.f3644d.z0(j3);
            this.A = false;
        }
        r();
    }

    int i(int i3) {
        return Math.round(i3 / this.f3660t);
    }

    public boolean n() {
        return this.f3645e;
    }

    public void o() {
        this.f3644d.T(this.f3643c);
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
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        a aVarE;
        super.onLayout(z2, i3, i4, i5, i6);
        b bVar = this.f3644d;
        if (bVar == null || this.f3664x == 0 || (aVarE = bVar.e(this.f3643c)) == null || !aVarE.A0()) {
            return;
        }
        if (this.f3664x == 2) {
            this.f3644d.L1(this.f3643c, this.f3665y, this);
        } else {
            this.f3644d.K0(this.f3643c, this.f3665y, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (!isLaidOut()) {
            super.onMeasure(i3, i4);
            setMinimumHeight(getLineHeight() + getCompoundPaddingBottom() + getCompoundPaddingTop());
        }
        TextPaint paint = getPaint();
        Context context = getContext();
        float fK = k(paint);
        float desiredWidth = Layout.getDesiredWidth(context.getString(R.string.text_dot), paint);
        float fMax = Math.max(Layout.getDesiredWidth(context.getString(R.string.op_sub), paint) - fK, 0.0f);
        float fMax2 = Math.max(Layout.getDesiredWidth("…", paint) - fK, 0.0f);
        float fMax3 = Math.max(Layout.getDesiredWidth(e.D("e"), paint) - fK, 0.0f);
        float fMax4 = Math.max((2.0f * fMax) + fMax3 + desiredWidth, fMax3 + fMax2 + fMax);
        int size = (View.MeasureSpec.getSize(i3) - (getPaddingLeft() + getPaddingRight())) - (((int) Math.ceil(fMax4)) + 1);
        float desiredWidth2 = Layout.getDesiredWidth(e.D(","), paint);
        float fMax5 = fMax4 - Math.max(fMax2, fMax);
        float f3 = fMax4 - fMax;
        float fMax6 = Math.max(fK - desiredWidth, 0.0f);
        this.f3656p = fMax5 / fK;
        synchronized (this.f3658r) {
            this.f3659s = size;
            this.f3660t = fK;
            this.f3663w = f3 / fK;
            this.f3662v = fMax6 / fK;
            this.f3661u = desiredWidth2 / fK;
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        if (!this.f3645e || this.f3642b.isFinished()) {
            if (i4 == 0 && i5 > 0) {
                setAccessibilityLiveRegion(1);
                setContentDescription(null);
            } else if (i4 > 0 && i5 == 0) {
                setAccessibilityLiveRegion(0);
                setContentDescription(getContext().getString(R.string.desc_result));
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(null);
            setImportantForAccessibility(2);
        } else {
            setContentDescription(g2.b.w(getContext(), charSequence.toString()));
            setImportantForAccessibility(1);
        }
    }

    public void p() {
        this.f3644d.e2(this.f3643c);
    }

    public void q() {
        this.f3644d.M();
    }

    public void r() {
        setVisibility(0);
        int maxChars = getMaxChars();
        VLog.d("BBKCalculator/CalculatorResult", "  redisplay, maxChars = " + maxChars);
        if (maxChars < 4) {
            VLog.e("BBKCalculator/CalculatorResult", "  redisplay Display currently too small to display a reasonable result ");
            return;
        }
        if (this.f3642b.isFinished() && length() > 0) {
            setAccessibilityLiveRegion(1);
        }
        int[] iArr = new int[1];
        String strJ = j(i(this.f3647g), maxChars, iArr, this.f3655o);
        VLog.d("BBKCalculator/CalculatorResult", "  redisplay,result1 = " + strJ);
        int iIndexOf = strJ.indexOf(69);
        String strD = e.D(strJ);
        VLog.d("BBKCalculator/CalculatorResult", "  redisplay,result2 = " + strD);
        if (iIndexOf <= 0 || strD.indexOf(46) != -1) {
            setTextString(strD);
        } else {
            setTextString(((Object) new SpannableString(strD)) + BuildConfig.FLAVOR);
        }
        this.f3654n = iArr[0];
        this.f3646f = true;
        setLongClickable(true);
    }

    void s(b bVar, long j3) {
        this.f3644d = bVar;
        this.f3643c = j3;
        requestLayout();
    }

    public void setTextString(String str) {
        setText(g2.b.c(str));
    }

    public void t(int i3, b.j jVar) {
        this.f3665y = jVar;
        this.f3664x = i3;
    }
}
