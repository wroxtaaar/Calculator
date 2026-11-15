package com.vivo.calculator.exchange;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.OverScroller;
import com.vivo.calculator.ExchangeActivity;
import com.vivo.calculator.R;
import com.vivo.calculator.b;
import com.vivo.seckeysdk.BuildConfig;
import vivo.util.VLog;
import z1.e;
import z1.g;

/* JADX INFO: loaded from: classes.dex */
public class CalculatorOthResult extends EditText implements b.i, b.g {
    private final BackgroundColorSpan A;
    private boolean B;
    private Context C;
    private final int D;
    private a E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final OverScroller f4062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f4064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExchangeActivity f4065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f4074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4076p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f4077q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f4078r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Object f4079s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4080t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f4081u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f4082v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f4083w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4084x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4085y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private b.i f4086z;

    private enum a {
        OTHINPUT,
        OTHRESULT;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }
    }

    public CalculatorOthResult(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4066f = false;
        this.f4067g = false;
        this.f4079s = new Object();
        this.f4080t = 0;
        this.f4081u = 1.0f;
        this.f4085y = 2;
        this.f4086z = this;
        this.B = false;
        this.D = 1000000;
        this.C = context;
        this.f4062b = new OverScroller(context);
        this.A = new BackgroundColorSpan(getHighlightColor());
    }

    private final int f(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return ((int) Math.ceil(Math.log10(Math.abs(i3)) + 1.0E-10d)) + (i3 >= 0 ? 1 : 2);
    }

    /* JADX WARN: Code duplicated, block: B:129:0x0337 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:0x033a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0350  */
    /* JADX WARN: Code duplicated, block: B:134:0x0353  */
    /* JADX WARN: Code duplicated, block: B:144:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:43:0x011b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0129  */
    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0132  */
    /* JADX WARN: Code duplicated, block: B:51:0x0135  */
    /* JADX WARN: Code duplicated, block: B:54:0x0146  */
    /* JADX WARN: Code duplicated, block: B:57:0x0154  */
    /* JADX WARN: Code duplicated, block: B:59:0x015c  */
    /* JADX WARN: Code duplicated, block: B:60:0x015f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0165  */
    /* JADX WARN: Code duplicated, block: B:65:0x017c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0186  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:83:0x021d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0229  */
    /* JADX WARN: Code duplicated, block: B:92:0x023e  */
    /* JADX WARN: Instruction removed from duplicated block: B:131:0x033a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x00ad, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x00e1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x01a7, please report this as an issue */
    private String g(String str, int i3, int i4, boolean z2, boolean z3, int[] iArr, boolean z4) {
        int i5;
        int integer;
        int integer2;
        int i6;
        String string;
        int i7;
        boolean z5;
        int i8;
        int iF;
        int integer3;
        char c3;
        String strSubstring;
        int length;
        int length2;
        float fA;
        String strA;
        float f3;
        float decimalCredit;
        float f4;
        float noEllipsisCredit;
        int i9;
        String strSubstring2;
        int iIndexOf;
        int length3;
        float f5;
        String strSubstring3 = str;
        int i10 = -1;
        int iK = z2 ? -1 : k(str);
        if (z2 || (z3 && strSubstring3.charAt(0) != '-')) {
            strSubstring3 = "…" + strSubstring3.substring(1, str.length());
            i5 = 1;
        } else {
            i5 = 0;
        }
        int iIndexOf2 = strSubstring3.indexOf(46);
        if (iArr != null) {
            iArr[0] = i3;
        }
        if (g2.b.n()) {
            integer = this.C.getResources().getInteger(R.integer.result_decimal_places_number_largesize);
            integer2 = this.C.getResources().getInteger(R.integer.result_decimal_places_largesize);
        } else {
            integer = this.C.getResources().getInteger(R.integer.result_decimal_places_number);
            integer2 = this.C.getResources().getInteger(R.integer.result_decimal_places);
        }
        if (iIndexOf2 == -1) {
            if (i3 == i10) {
                if ((strSubstring3.length() > integer2 || iIndexOf2 != i10) && (iIndexOf2 < 0 || iIndexOf2 <= integer2)) {
                    if (z4) {
                        VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: insertCommas ");
                        length2 = strSubstring3.length();
                        VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: orig_length " + length2);
                        VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: decIndex == " + iIndexOf2);
                        if (iIndexOf2 != -1) {
                            fA = a(strSubstring3, iIndexOf2);
                            strA = g.a(strSubstring3, i5, iIndexOf2) + strSubstring3.substring(iIndexOf2, length2);
                        } else {
                            fA = a(strSubstring3, length2);
                            strA = g.a(strSubstring3, i5, length2);
                        }
                        VLog.d("BBKCalculator/CalculatorOthResult", "formatResult:decIndex   result " + strA);
                        if (i5 != 0) {
                            length2--;
                        }
                        float f6 = length2 + fA;
                        getNoEllipsisCredit();
                        getDecimalCredit();
                        f3 = 0.0f;
                        if (iIndexOf2 == -1) {
                            decimalCredit = 0.0f;
                        } else {
                            decimalCredit = getDecimalCredit();
                        }
                        f4 = f6 - decimalCredit;
                        if (i5 != 0) {
                            noEllipsisCredit = this.f4077q;
                        } else {
                            noEllipsisCredit = getNoEllipsisCredit();
                        }
                        if (f4 - noEllipsisCredit > (i4 - i5) + 1.0E-4f) {
                            i9 = 0;
                            while ((f4 - this.f4077q) - f3 > i4 - 1) {
                                if (strA.charAt(i9) == ',') {
                                    f5 = this.f4082v;
                                } else {
                                    f5 = 1.0f;
                                }
                                f3 += f5;
                                i9++;
                            }
                        } else {
                            i9 = 0;
                        }
                        VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult:  deletedChars == " + i9);
                        if ((i9 <= 0 && strA.replaceAll(",", BuildConfig.FLAVOR).length() > integer2) || strA.replaceAll(",", BuildConfig.FLAVOR).length() > integer2) {
                            strA = strA.substring(0, (strA.length() - strA.replaceAll(",", BuildConfig.FLAVOR).length()) + integer2);
                        } else if (i5 != 0) {
                            strA = "…" + strA;
                        }
                        strSubstring2 = strA;
                        iIndexOf = strSubstring2.indexOf(".");
                        int length4 = strSubstring2.length();
                        if (iIndexOf > 0 && length4 - iIndexOf >= this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number)) {
                            try {
                                strSubstring2 = g2.b.x(Double.parseDouble(strSubstring2.replaceAll(",", BuildConfig.FLAVOR)), this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2);
                            } catch (Exception e3) {
                                VLog.e("BBKCalculator/CalculatorOthResult", "formatResult,Exception 2 " + e3);
                                strSubstring2 = strSubstring2.substring(0, (iIndexOf + this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number)) - 1);
                            }
                        }
                        if (strSubstring2.indexOf(".") > 0 && strSubstring2.endsWith("0")) {
                            for (length3 = strSubstring2.length(); length3 >= 0 && strSubstring2.endsWith("0"); length3--) {
                                strSubstring2 = strSubstring2.substring(0, length3);
                            }
                        }
                        strSubstring3 = strSubstring2;
                        if (strSubstring3.endsWith(".")) {
                            strSubstring3 = strSubstring3.substring(0, strSubstring3.length() - 1);
                        }
                    }
                }
            }
            VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult: result == " + strSubstring3);
            return strSubstring3;
        }
        if (iK != Integer.MAX_VALUE) {
            if (iK - iIndexOf2 > 4) {
                i10 = -1;
                if (i3 == i10) {
                }
                VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult: result == " + strSubstring3);
                return strSubstring3;
            }
            i10 = -1;
        }
        if (strSubstring3.length() > integer2) {
            if (z4) {
                VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: insertCommas ");
                length2 = strSubstring3.length();
                VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: orig_length " + length2);
                VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: decIndex == " + iIndexOf2);
                if (iIndexOf2 != -1) {
                    fA = a(strSubstring3, iIndexOf2);
                    strA = g.a(strSubstring3, i5, iIndexOf2) + strSubstring3.substring(iIndexOf2, length2);
                } else {
                    fA = a(strSubstring3, length2);
                    strA = g.a(strSubstring3, i5, length2);
                }
                VLog.d("BBKCalculator/CalculatorOthResult", "formatResult:decIndex   result " + strA);
                if (i5 != 0) {
                    length2--;
                }
                float f7 = length2 + fA;
                getNoEllipsisCredit();
                getDecimalCredit();
                f3 = 0.0f;
                if (iIndexOf2 == -1) {
                    decimalCredit = 0.0f;
                } else {
                    decimalCredit = getDecimalCredit();
                }
                f4 = f7 - decimalCredit;
                if (i5 != 0) {
                    noEllipsisCredit = this.f4077q;
                } else {
                    noEllipsisCredit = getNoEllipsisCredit();
                }
                if (f4 - noEllipsisCredit > (i4 - i5) + 1.0E-4f) {
                    i9 = 0;
                    while ((f4 - this.f4077q) - f3 > i4 - 1) {
                        if (strA.charAt(i9) == ',') {
                            f5 = this.f4082v;
                        } else {
                            f5 = 1.0f;
                        }
                        f3 += f5;
                        i9++;
                    }
                } else {
                    i9 = 0;
                }
                VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult:  deletedChars == " + i9);
                if (i9 <= 0) {
                    if (i5 != 0) {
                        strA = "…" + strA;
                    }
                } else if (i5 != 0) {
                    strA = "…" + strA;
                }
                strSubstring2 = strA;
                iIndexOf = strSubstring2.indexOf(".");
                int length5 = strSubstring2.length();
                if (iIndexOf > 0) {
                    strSubstring2 = g2.b.x(Double.parseDouble(strSubstring2.replaceAll(",", BuildConfig.FLAVOR)), this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2);
                }
                if (strSubstring2.indexOf(".") > 0) {
                    while (length3 >= 0) {
                        strSubstring2 = strSubstring2.substring(0, length3);
                    }
                }
                strSubstring3 = strSubstring2;
                if (strSubstring3.endsWith(".")) {
                    strSubstring3 = strSubstring3.substring(0, strSubstring3.length() - 1);
                }
            }
        } else if (z4) {
            VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: insertCommas ");
            length2 = strSubstring3.length();
            VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: orig_length " + length2);
            VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: decIndex == " + iIndexOf2);
            if (iIndexOf2 != -1) {
                fA = a(strSubstring3, iIndexOf2);
                strA = g.a(strSubstring3, i5, iIndexOf2) + strSubstring3.substring(iIndexOf2, length2);
            } else {
                fA = a(strSubstring3, length2);
                strA = g.a(strSubstring3, i5, length2);
            }
            VLog.d("BBKCalculator/CalculatorOthResult", "formatResult:decIndex   result " + strA);
            if (i5 != 0) {
                length2--;
            }
            float f8 = length2 + fA;
            getNoEllipsisCredit();
            getDecimalCredit();
            f3 = 0.0f;
            if (iIndexOf2 == -1) {
                decimalCredit = 0.0f;
            } else {
                decimalCredit = getDecimalCredit();
            }
            f4 = f8 - decimalCredit;
            if (i5 != 0) {
                noEllipsisCredit = this.f4077q;
            } else {
                noEllipsisCredit = getNoEllipsisCredit();
            }
            if (f4 - noEllipsisCredit > (i4 - i5) + 1.0E-4f) {
                i9 = 0;
                while ((f4 - this.f4077q) - f3 > i4 - 1) {
                    if (strA.charAt(i9) == ',') {
                        f5 = this.f4082v;
                    } else {
                        f5 = 1.0f;
                    }
                    f3 += f5;
                    i9++;
                }
            } else {
                i9 = 0;
            }
            VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult:  deletedChars == " + i9);
            if (i9 <= 0) {
                if (i5 != 0) {
                    strA = "…" + strA;
                }
            } else if (i5 != 0) {
                strA = "…" + strA;
            }
            strSubstring2 = strA;
            iIndexOf = strSubstring2.indexOf(".");
            int length6 = strSubstring2.length();
            if (iIndexOf > 0) {
                strSubstring2 = g2.b.x(Double.parseDouble(strSubstring2.replaceAll(",", BuildConfig.FLAVOR)), this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2);
            }
            if (strSubstring2.indexOf(".") > 0) {
                while (length3 >= 0) {
                    strSubstring2 = strSubstring2.substring(0, length3);
                }
            }
            strSubstring3 = strSubstring2;
            if (strSubstring3.endsWith(".")) {
                strSubstring3 = strSubstring3.substring(0, strSubstring3.length() - 1);
            }
        }
        VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult: result == " + strSubstring3);
        return strSubstring3;
        int i11 = -i3;
        if (i3 <= 0) {
            i11--;
        }
        VLog.e("BBKCalculator/CalculatorOthResult", "formatResult: exponent == " + i11);
        if ((z2 || iK >= i4 - 1 || (strSubstring3.length() - iK) + 1 + (z3 ? 1 : 0) > i4 + 1) && (!z4 || iIndexOf2 == -1)) {
            i6 = 1;
            string = strSubstring3;
            i7 = i11;
            z5 = false;
        } else {
            if (iIndexOf2 > iK) {
                strSubstring3 = strSubstring3.substring(0, iIndexOf2) + strSubstring3.substring(iIndexOf2 + 1, strSubstring3.length());
                VLog.d("BBKCalculator/CalculatorOthResult", "formatResult:   result = decIndex > msdIndex == " + strSubstring3);
            }
            int length7 = strSubstring3.length();
            int i12 = iK + 1;
            String strSubstring4 = strSubstring3.substring(i12, length7);
            VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: fraction " + strSubstring4);
            StringBuilder sb = new StringBuilder();
            sb.append(z3 ? "-" : BuildConfig.FLAVOR);
            sb.append(strSubstring3.substring(iK, i12));
            sb.append(".");
            sb.append(strSubstring4);
            int i13 = (length7 + i11) - iK;
            i6 = 1;
            int i14 = i13 - 1;
            z5 = true;
            string = sb.toString();
            i7 = i14;
        }
        if (!z5) {
            int i15 = 2;
            while (true) {
                i8 = i11 + i15;
                if (f(i8) <= i15) {
                    break;
                }
                i15++;
            }
            if (i3 - i15 > this.f4074n) {
                iF = i15 + 1;
                i7 = i8 + 1;
            } else {
                iF = i15;
            }
            if (iF >= string.length() - 1) {
                return "…E…";
            }
            VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: dropDigits == " + iF);
            if (i8 > 0) {
                integer3 = integer - 2;
            } else {
                integer3 = this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2;
            }
            try {
                strSubstring = g2.b.x(Double.parseDouble(string.replaceAll(",", BuildConfig.FLAVOR)), integer3);
                c3 = 0;
            } catch (Exception e4) {
                VLog.e("BBKCalculator/CalculatorOthResult", "formatResult,Exception 1 " + e4);
                int i16 = integer3 + 2;
                if (string.length() - iF > i16) {
                    c3 = 0;
                    strSubstring = string.substring(0, i16);
                } else {
                    c3 = 0;
                    strSubstring = string.substring(0, string.length() - iF);
                }
            }
            VLog.i("BBKCalculator/CalculatorOthResult", "formatResult: start  == result  " + strSubstring);
            if (iArr != null) {
                iArr[c3] = iArr[c3] - iF;
            }
            if (strSubstring.indexOf(".") > 0 && strSubstring.endsWith("0")) {
                for (length = strSubstring.length(); length >= 0 && strSubstring.endsWith("0"); length--) {
                    strSubstring = strSubstring.substring(0, length);
                }
            }
            strSubstring3 = strSubstring + "E" + i8;
            VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult: result == " + strSubstring3);
            return strSubstring3;
        }
        iF = f(i7);
        if (iF >= string.length() - i6) {
            iF = Math.max(string.length() - 2, 0);
        }
        i8 = i7;
        if (iF >= string.length() - 1) {
            return "…E…";
        }
        VLog.d("BBKCalculator/CalculatorOthResult", "formatResult: dropDigits == " + iF);
        if (i8 > 0) {
            integer3 = integer - 2;
        } else {
            integer3 = this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2;
        }
        strSubstring = g2.b.x(Double.parseDouble(string.replaceAll(",", BuildConfig.FLAVOR)), integer3);
        c3 = 0;
        VLog.i("BBKCalculator/CalculatorOthResult", "formatResult: start  == result  " + strSubstring);
        if (iArr != null) {
            iArr[c3] = iArr[c3] - iF;
        }
        if (strSubstring.indexOf(".") > 0) {
            while (length >= 0) {
                strSubstring = strSubstring.substring(0, length);
            }
        }
        strSubstring3 = strSubstring + "E" + i8;
        VLog.d("BBKCalculator/CalculatorOthResult", "  formatResult: result == " + strSubstring3);
        return strSubstring3;
    }

    private String i(int i3, int i4, int[] iArr, boolean z2, boolean z3) {
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = {i3};
        VLog.d("BBKCalculator/CalculatorOthResult", "getFormattedResult  mIndex ==  " + this.f4063c);
        b bVar = this.f4064d;
        String strB1 = bVar != null ? bVar.b1(this.f4063c, iArr2, this.f4073m, i4, zArr, zArr2, this) : BuildConfig.FLAVOR;
        VLog.e("BBKCalculator/CalculatorOthResult", "getFormattedResult: mEvaluator.getString result  ==  " + strB1);
        return g(strB1, iArr2[0], i4, zArr[0], zArr2[0], iArr, z2);
    }

    private static float j(TextPaint textPaint) {
        float[] fArr = new float[10];
        textPaint.getTextWidths("0123456789", fArr);
        float fMax = 0.0f;
        for (int i3 = 0; i3 < 10; i3++) {
            fMax = Math.max(fArr[i3], fMax);
        }
        return fMax;
    }

    public static int k(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '-' && cCharAt != '.' && cCharAt != '0') {
                return i3;
            }
        }
        return Integer.MAX_VALUE;
    }

    private void l(int i3, int i4, int i5, String str) {
        int iF;
        int maxChars = getMaxChars();
        this.f4072l = str.length();
        int iCeil = (int) Math.ceil((a(str, str.length()) - getNoEllipsisCredit()) - 1.0E-4f);
        this.f4076p = this.f4072l + iCeil <= maxChars;
        this.f4069i = 10010000;
        this.f4074n = i5;
        this.f4078r = false;
        int iRound = Math.round(i3 * this.f4081u);
        this.f4070j = iRound;
        this.f4068h = iRound;
        if (i4 == Integer.MAX_VALUE) {
            if (i5 == Integer.MIN_VALUE) {
                this.f4071k = iRound;
                this.f4073m = Math.round(iRound / this.f4081u);
                this.f4066f = false;
                return;
            } else {
                this.f4073m = 10000000;
                this.f4071k = 10000000;
                this.f4070j = (int) (iRound - this.f4081u);
                this.f4066f = true;
                return;
            }
        }
        int i6 = str.charAt(0) == '-' ? 1 : 0;
        int i7 = this.f4072l;
        if (i4 > i7 && i4 <= i7 + 3) {
            i4 = i7 - 1;
        }
        int i8 = i4 - i7;
        if (i8 > -1 && i8 < 5) {
            i8 = -1;
        }
        if (i5 >= 10000000) {
            this.f4073m = 10000000;
            this.f4071k = 10000000;
            this.f4066f = true;
            return;
        }
        this.f4073m = i5;
        if (i5 < -1 && i5 > -5) {
            this.f4073m = -1;
        }
        int i9 = this.f4073m;
        if (i9 < -1) {
            iF = f((-i8) - 1);
        } else {
            iF = (i8 > -1 || i9 >= maxChars) ? f(-i8) : 0;
        }
        boolean z2 = this.f4076p;
        if (!z2 || i8 >= -3) {
            iCeil = 0;
        }
        int i10 = this.f4073m;
        boolean z3 = (((i10 + iF) + iCeil) - i8) + i6 >= maxChars;
        this.f4066f = z3;
        if (iF > 0) {
            int iF2 = z3 ? i10 + f(-i5) : i10 + iF;
            if (this.f4073m > -1 || iF2 <= -1) {
                this.f4073m = Math.min(iF2, 10000000);
            } else {
                this.f4073m = -1;
            }
            this.f4071k = Math.min(Math.round(this.f4073m * this.f4081u), 10000000);
        } else if (z2 || z3) {
            this.f4071k = Math.min(Math.round(i10 * this.f4081u), 10000000);
        } else {
            boolean z4 = ((i10 + f((-i8) - 1)) - i8) + i6 >= maxChars;
            this.f4066f = z4;
            if (z4) {
                this.f4071k = (int) Math.ceil(this.f4070j + this.f4081u);
            } else {
                this.f4071k = this.f4070j;
                this.f4078r = true;
            }
        }
        if (this.f4066f) {
            return;
        }
        this.f4068h = this.f4071k;
    }

    @Override // com.vivo.calculator.b.g
    public float a(String str, int i3) {
        float f3;
        int i4 = 0;
        while (i4 < i3 && !Character.isDigit(str.charAt(i4))) {
            i4++;
        }
        int i5 = ((i3 - i4) - 1) / 3;
        synchronized (this.f4079s) {
            f3 = i5 * this.f4082v;
        }
        return f3;
    }

    public void b() {
        this.f4067g = false;
        this.f4066f = false;
        setText(BuildConfig.FLAVOR);
        setLongClickable(false);
    }

    @Override // com.vivo.calculator.b.i
    public void c(long j3, int i3) {
        VLog.d("BBKCalculator/CalculatorOthResult", "onExError: ");
        this.B = false;
        this.f4067g = false;
        setLongClickable(false);
        this.f4066f = false;
        String string = getContext().getString(R.string.error);
        float desiredWidth = Layout.getDesiredWidth(string, getPaint());
        int i4 = this.f4080t;
        if (desiredWidth <= i4) {
            setText(string);
            return;
        }
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan((i4 * 0.99f) / desiredWidth);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(relativeSizeSpan, 0, string.length(), 33);
        setText(spannableString);
    }

    @Override // com.vivo.calculator.b.i
    public void d(long j3) {
        b();
        this.B = false;
    }

    @Override // com.vivo.calculator.b.i
    public void e(long j3, int i3, int i4, int i5, String str) {
        l(i3, i4, i5, str);
        n();
    }

    @Override // com.vivo.calculator.b.g
    public float getDecimalCredit() {
        float f3;
        synchronized (this.f4079s) {
            f3 = this.f4083w;
        }
        return f3;
    }

    @Override // com.vivo.calculator.b.g
    public int getMaxChars() {
        int iFloor;
        synchronized (this.f4079s) {
            iFloor = (int) Math.floor(this.f4080t / this.f4081u);
        }
        return iFloor;
    }

    @Override // com.vivo.calculator.b.g
    public float getNoEllipsisCredit() {
        float f3;
        synchronized (this.f4079s) {
            f3 = this.f4084x;
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

    int h(int i3) {
        return Math.round(i3 / this.f4081u);
    }

    public boolean m() {
        return this.f4066f;
    }

    public void n() {
        setVisibility(0);
        int maxChars = getMaxChars();
        if (maxChars < 4) {
            return;
        }
        if (this.f4062b.isFinished() && length() > 0) {
            setAccessibilityLiveRegion(1);
        }
        int[] iArr = new int[1];
        String strI = i(h(this.f4068h), maxChars, iArr, this.f4076p, true);
        VLog.d("BBKCalculator/CalculatorOthResult", "  redisplay,result1 = " + strI);
        int iIndexOf = strI.indexOf(69);
        String strD = e.D(strI);
        if (this.f4065e != null) {
            VLog.d("BBKCalculator/CalculatorOthResult", "  redisplay,result  = " + strD);
            if ((this.f4065e.X1() && this.E == a.OTHINPUT) || this.f4065e.a2()) {
                this.E = a.OTHRESULT;
                this.f4065e.o3(false);
                this.f4065e.V1(strD);
            }
            if (iIndexOf > 0 && strD.indexOf(46) == -1) {
                SpannableString spannableString = new SpannableString(strD);
                StringBuilder sb = new StringBuilder();
                sb.append("redisplay:  isIsLocalInput == ");
                sb.append(!this.f4065e.X1());
                VLog.d("BBKCalculator/CalculatorOthResult", sb.toString());
                if (!this.f4065e.X1()) {
                    setTextString(((Object) spannableString) + BuildConfig.FLAVOR);
                }
            } else if (!this.f4065e.X1()) {
                setTextString(strD);
            }
            if (this.f4065e.d2()) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        }
        this.f4075o = iArr[0];
        this.f4067g = true;
        setLongClickable(true);
    }

    public void o(b bVar, long j3) {
        this.f4064d = bVar;
        this.f4063c = j3;
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        com.vivo.calculator.a aVarK;
        super.onLayout(z2, i3, i4, i5, i6);
        b bVar = this.f4064d;
        if (bVar == null || this.f4085y == 0 || (aVarK = bVar.k(this.f4063c)) == null || !aVarK.C0()) {
            return;
        }
        if (this.f4085y == 2) {
            this.f4064d.N1(this.f4063c, this.f4086z, this);
        } else {
            this.f4064d.M0(this.f4063c, this.f4086z, this);
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
        float fJ = j(paint);
        float desiredWidth = Layout.getDesiredWidth(context.getString(R.string.text_dot), paint);
        float fMax = Math.max(Layout.getDesiredWidth(context.getString(R.string.op_sub), paint) - fJ, 0.0f);
        float fMax2 = Math.max(Layout.getDesiredWidth("…", paint) - fJ, 0.0f);
        float fMax3 = Math.max(Layout.getDesiredWidth(e.D("e"), paint) - fJ, 0.0f);
        float fMax4 = Math.max((2.0f * fMax) + fMax3 + desiredWidth, fMax3 + fMax2 + fMax);
        int size = (View.MeasureSpec.getSize(i3) - (getPaddingLeft() + getPaddingRight())) - (((int) Math.ceil(fMax4)) + 1);
        float desiredWidth2 = Layout.getDesiredWidth(e.D(","), paint);
        float fMax5 = fMax4 - Math.max(fMax2, fMax);
        float f3 = fMax4 - fMax;
        float fMax6 = Math.max(fJ - desiredWidth, 0.0f);
        this.f4077q = fMax5 / fJ;
        synchronized (this.f4079s) {
            this.f4080t = size;
            this.f4081u = fJ;
            this.f4084x = f3 / fJ;
            this.f4083w = fMax6 / fJ;
            this.f4082v = desiredWidth2 / fJ;
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        if (!this.f4066f || this.f4062b.isFinished()) {
            if (i4 == 0 && i5 > 0) {
                setAccessibilityLiveRegion(1);
                setContentDescription(null);
            } else {
                if (i4 <= 0 || i5 != 0) {
                    return;
                }
                setAccessibilityLiveRegion(0);
                setContentDescription(getContext().getString(R.string.desc_result));
            }
        }
    }

    public void p() {
        this.E = a.OTHINPUT;
    }

    public void q(int i3, b.i iVar) {
        this.f4086z = iVar;
        this.f4085y = i3;
    }

    public void setExchangeActivity(ExchangeActivity exchangeActivity) {
        this.f4065e = exchangeActivity;
    }

    public void setTextString(String str) {
        setText(g2.b.c(str));
    }
}
