package com.vivo.calculator.exchange;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
public class CalculatorLocResult extends EditText implements b.j, b.g {
    private final BackgroundColorSpan A;
    private boolean B;
    private Context C;
    private SharedPreferences D;
    private final int E;
    private a F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final OverScroller f4034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f4036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExchangeActivity f4037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4044l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4045m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f4046n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4048p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f4049q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f4050r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Object f4051s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4052t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f4053u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f4054v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f4055w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4056x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4057y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private b.j f4058z;

    private enum a {
        LOCINPUT,
        LOCRESULT;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }
    }

    public CalculatorLocResult(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4038f = false;
        this.f4039g = false;
        this.f4051s = new Object();
        this.f4052t = 0;
        this.f4053u = 1.0f;
        this.f4057y = 2;
        this.f4058z = this;
        this.B = false;
        this.E = 1000000;
        this.C = context;
        this.D = PreferenceManager.getDefaultSharedPreferences(context);
        this.f4034b = new OverScroller(context);
        this.A = new BackgroundColorSpan(getHighlightColor());
    }

    private final int d(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return ((int) Math.ceil(Math.log10(Math.abs(i3)) + 1.0E-10d)) + (i3 >= 0 ? 1 : 2);
    }

    /* JADX WARN: Code duplicated, block: B:129:0x0337 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:0x033a  */
    /* JADX WARN: Code duplicated, block: B:133:0x035c  */
    /* JADX WARN: Code duplicated, block: B:134:0x035f  */
    /* JADX WARN: Code duplicated, block: B:144:0x03c0  */
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
    private String e(String str, int i3, int i4, boolean z2, boolean z3, int[] iArr, boolean z4) {
        int i5;
        int integer;
        int integer2;
        int i6;
        String string;
        int i7;
        boolean z5;
        int i8;
        int iD;
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
        int iL = z2 ? -1 : l(str);
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
                        VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: insertCommas ");
                        length2 = strSubstring3.length();
                        VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: orig_length " + length2);
                        VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: decIndex == " + iIndexOf2);
                        if (iIndexOf2 != -1) {
                            fA = a(strSubstring3, iIndexOf2);
                            strA = g.a(strSubstring3, i5, iIndexOf2) + strSubstring3.substring(iIndexOf2, length2);
                        } else {
                            fA = a(strSubstring3, length2);
                            strA = g.a(strSubstring3, i5, length2);
                        }
                        VLog.d("BBKCalculator/CalculatorLocResult", "formatResult:decIndex   result " + strA);
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
                            noEllipsisCredit = this.f4049q;
                        } else {
                            noEllipsisCredit = getNoEllipsisCredit();
                        }
                        if (f4 - noEllipsisCredit > (i4 - i5) + 1.0E-4f) {
                            i9 = 0;
                            while ((f4 - this.f4049q) - f3 > i4 - 1) {
                                if (strA.charAt(i9) == ',') {
                                    f5 = this.f4054v;
                                } else {
                                    f5 = 1.0f;
                                }
                                f3 += f5;
                                i9++;
                            }
                        } else {
                            i9 = 0;
                        }
                        VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult:  deletedChars == " + i9);
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
                                VLog.e("BBKCalculator/CalculatorLocResult", "formatResult,Exception 2 " + e3);
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
            VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult: result == " + strSubstring3);
            return strSubstring3;
        }
        if (iL != Integer.MAX_VALUE) {
            if (iL - iIndexOf2 > 4) {
                i10 = -1;
                if (i3 == i10) {
                }
                VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult: result == " + strSubstring3);
                return strSubstring3;
            }
            i10 = -1;
        }
        if (strSubstring3.length() > integer2) {
            if (z4) {
                VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: insertCommas ");
                length2 = strSubstring3.length();
                VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: orig_length " + length2);
                VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: decIndex == " + iIndexOf2);
                if (iIndexOf2 != -1) {
                    fA = a(strSubstring3, iIndexOf2);
                    strA = g.a(strSubstring3, i5, iIndexOf2) + strSubstring3.substring(iIndexOf2, length2);
                } else {
                    fA = a(strSubstring3, length2);
                    strA = g.a(strSubstring3, i5, length2);
                }
                VLog.d("BBKCalculator/CalculatorLocResult", "formatResult:decIndex   result " + strA);
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
                    noEllipsisCredit = this.f4049q;
                } else {
                    noEllipsisCredit = getNoEllipsisCredit();
                }
                if (f4 - noEllipsisCredit > (i4 - i5) + 1.0E-4f) {
                    i9 = 0;
                    while ((f4 - this.f4049q) - f3 > i4 - 1) {
                        if (strA.charAt(i9) == ',') {
                            f5 = this.f4054v;
                        } else {
                            f5 = 1.0f;
                        }
                        f3 += f5;
                        i9++;
                    }
                } else {
                    i9 = 0;
                }
                VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult:  deletedChars == " + i9);
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
            VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: insertCommas ");
            length2 = strSubstring3.length();
            VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: orig_length " + length2);
            VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: decIndex == " + iIndexOf2);
            if (iIndexOf2 != -1) {
                fA = a(strSubstring3, iIndexOf2);
                strA = g.a(strSubstring3, i5, iIndexOf2) + strSubstring3.substring(iIndexOf2, length2);
            } else {
                fA = a(strSubstring3, length2);
                strA = g.a(strSubstring3, i5, length2);
            }
            VLog.d("BBKCalculator/CalculatorLocResult", "formatResult:decIndex   result " + strA);
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
                noEllipsisCredit = this.f4049q;
            } else {
                noEllipsisCredit = getNoEllipsisCredit();
            }
            if (f4 - noEllipsisCredit > (i4 - i5) + 1.0E-4f) {
                i9 = 0;
                while ((f4 - this.f4049q) - f3 > i4 - 1) {
                    if (strA.charAt(i9) == ',') {
                        f5 = this.f4054v;
                    } else {
                        f5 = 1.0f;
                    }
                    f3 += f5;
                    i9++;
                }
            } else {
                i9 = 0;
            }
            VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult:  deletedChars == " + i9);
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
        VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult: result == " + strSubstring3);
        return strSubstring3;
        int i11 = -i3;
        if (i3 <= 0) {
            i11--;
        }
        VLog.e("BBKCalculator/CalculatorLocResult", "formatResult: exponent == " + i11);
        if ((z2 || iL >= i4 - 1 || (strSubstring3.length() - iL) + 1 + (z3 ? 1 : 0) > i4 + 1) && (!z4 || iIndexOf2 == -1)) {
            i6 = 1;
            string = strSubstring3;
            i7 = i11;
            z5 = false;
        } else {
            if (iIndexOf2 > iL) {
                strSubstring3 = strSubstring3.substring(0, iIndexOf2) + strSubstring3.substring(iIndexOf2 + 1, strSubstring3.length());
                VLog.d("BBKCalculator/CalculatorLocResult", "formatResult:   result = decIndex > msdIndex == " + strSubstring3);
            }
            int length7 = strSubstring3.length();
            int i12 = iL + 1;
            String strSubstring4 = strSubstring3.substring(i12, length7);
            VLog.d("BBKCalculator/CalculatorLocResult", "formatResult: fraction " + strSubstring4);
            StringBuilder sb = new StringBuilder();
            sb.append(z3 ? "-" : BuildConfig.FLAVOR);
            sb.append(strSubstring3.substring(iL, i12));
            sb.append(".");
            sb.append(strSubstring4);
            int i13 = (length7 + i11) - iL;
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
                if (d(i8) <= i15) {
                    break;
                }
                i15++;
            }
            if (i3 - i15 > this.f4046n) {
                iD = i15 + 1;
                i7 = i8 + 1;
            } else {
                iD = i15;
            }
            if (iD >= string.length() - 1) {
                return "…E…";
            }
            VLog.d("BBKCalculator/CalculatorLocResult", "formatResult,result.length():" + string.length() + "dropDigits:" + iD);
            if (i8 > 0) {
                integer3 = integer - 2;
            } else {
                integer3 = this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2;
            }
            try {
                strSubstring = g2.b.x(Double.parseDouble(string.replaceAll(",", BuildConfig.FLAVOR)), integer3);
                c3 = 0;
            } catch (Exception e4) {
                VLog.e("BBKCalculator/CalculatorLocResult", "formatResult,Exception 1 " + e4);
                int i16 = integer3 + 2;
                if (string.length() - iD > i16) {
                    c3 = 0;
                    strSubstring = string.substring(0, i16);
                } else {
                    c3 = 0;
                    strSubstring = string.substring(0, string.length() - iD);
                }
            }
            VLog.i("BBKCalculator/CalculatorLocResult", "formatResult,after dropDigits, result :" + strSubstring);
            if (iArr != null) {
                iArr[c3] = iArr[c3] - iD;
            }
            if (strSubstring.indexOf(".") > 0 && strSubstring.endsWith("0")) {
                for (length = strSubstring.length(); length >= 0 && strSubstring.endsWith("0"); length--) {
                    strSubstring = strSubstring.substring(0, length);
                }
            }
            strSubstring3 = strSubstring + "E" + i8;
            VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult: result == " + strSubstring3);
            return strSubstring3;
        }
        iD = d(i7);
        if (iD >= string.length() - i6) {
            iD = Math.max(string.length() - 2, 0);
        }
        i8 = i7;
        if (iD >= string.length() - 1) {
            return "…E…";
        }
        VLog.d("BBKCalculator/CalculatorLocResult", "formatResult,result.length():" + string.length() + "dropDigits:" + iD);
        if (i8 > 0) {
            integer3 = integer - 2;
        } else {
            integer3 = this.C.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2;
        }
        strSubstring = g2.b.x(Double.parseDouble(string.replaceAll(",", BuildConfig.FLAVOR)), integer3);
        c3 = 0;
        VLog.i("BBKCalculator/CalculatorLocResult", "formatResult,after dropDigits, result :" + strSubstring);
        if (iArr != null) {
            iArr[c3] = iArr[c3] - iD;
        }
        if (strSubstring.indexOf(".") > 0) {
            while (length >= 0) {
                strSubstring = strSubstring.substring(0, length);
            }
        }
        strSubstring3 = strSubstring + "E" + i8;
        VLog.d("BBKCalculator/CalculatorLocResult", "  formatResult: result == " + strSubstring3);
        return strSubstring3;
    }

    private String j(int i3, int i4, int[] iArr, boolean z2, boolean z3) {
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = {i3};
        VLog.d("BBKCalculator/CalculatorLocResult", "getFormattedResult  mIndex ==  " + this.f4035c);
        b bVar = this.f4036d;
        String strZ0 = bVar != null ? bVar.Z0(this.f4035c, iArr2, this.f4045m, i4, zArr, zArr2, this) : BuildConfig.FLAVOR;
        VLog.d("BBKCalculator/CalculatorLocResult", "getFormattedResult: mEvaluator.getString result  ==  " + strZ0);
        return e(strZ0, iArr2[0], i4, zArr[0], zArr2[0], iArr, z2);
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
        this.f4044l = str.length();
        int iCeil = (int) Math.ceil((a(str, str.length()) - getNoEllipsisCredit()) - 1.0E-4f);
        this.f4048p = this.f4044l + iCeil <= maxChars;
        this.f4041i = 10010000;
        this.f4046n = i5;
        this.f4050r = false;
        int iRound = Math.round(i3 * this.f4053u);
        this.f4042j = iRound;
        this.f4040h = iRound;
        if (i4 == Integer.MAX_VALUE) {
            if (i5 == Integer.MIN_VALUE) {
                this.f4043k = iRound;
                this.f4045m = Math.round(iRound / this.f4053u);
                this.f4038f = false;
                return;
            } else {
                this.f4045m = 10000000;
                this.f4043k = 10000000;
                this.f4042j = (int) (iRound - this.f4053u);
                this.f4038f = true;
                return;
            }
        }
        int i6 = str.charAt(0) == '-' ? 1 : 0;
        int i7 = this.f4044l;
        if (i4 > i7 && i4 <= i7 + 3) {
            i4 = i7 - 1;
        }
        int i8 = i4 - i7;
        if (i8 > -1 && i8 < 5) {
            i8 = -1;
        }
        if (i5 >= 10000000) {
            this.f4045m = 10000000;
            this.f4043k = 10000000;
            this.f4038f = true;
            return;
        }
        this.f4045m = i5;
        if (i5 < -1 && i5 > -5) {
            this.f4045m = -1;
        }
        int i9 = this.f4045m;
        if (i9 < -1) {
            iD = d((-i8) - 1);
        } else {
            iD = (i8 > -1 || i9 >= maxChars) ? d(-i8) : 0;
        }
        boolean z2 = this.f4048p;
        if (!z2 || i8 >= -3) {
            iCeil = 0;
        }
        int i10 = this.f4045m;
        boolean z3 = (((i10 + iD) + iCeil) - i8) + i6 >= maxChars;
        this.f4038f = z3;
        if (iD > 0) {
            int iD2 = z3 ? i10 + d(-i5) : i10 + iD;
            if (this.f4045m > -1 || iD2 <= -1) {
                this.f4045m = Math.min(iD2, 10000000);
            } else {
                this.f4045m = -1;
            }
            this.f4043k = Math.min(Math.round(this.f4045m * this.f4053u), 10000000);
        } else if (z2 || z3) {
            this.f4043k = Math.min(Math.round(i10 * this.f4053u), 10000000);
        } else {
            boolean z4 = ((i10 + d((-i8) - 1)) - i8) + i6 >= maxChars;
            this.f4038f = z4;
            if (z4) {
                this.f4043k = (int) Math.ceil(this.f4042j + this.f4053u);
            } else {
                this.f4043k = this.f4042j;
                this.f4050r = true;
            }
        }
        if (this.f4038f) {
            return;
        }
        this.f4040h = this.f4043k;
    }

    @Override // com.vivo.calculator.b.g
    public float a(String str, int i3) {
        float f3;
        int i4 = 0;
        while (i4 < i3 && !Character.isDigit(str.charAt(i4))) {
            i4++;
        }
        int i5 = ((i3 - i4) - 1) / 3;
        synchronized (this.f4051s) {
            f3 = i5 * this.f4054v;
        }
        return f3;
    }

    @Override // com.vivo.calculator.b.j
    public void b(long j3, int i3) {
        VLog.d("BBKCalculator/CalculatorLocResult", "onError: localresult");
        this.B = false;
        this.f4039g = false;
        setLongClickable(false);
        this.f4038f = false;
        String string = getContext().getString(R.string.error);
        float desiredWidth = Layout.getDesiredWidth(string, getPaint());
        int i4 = this.f4052t;
        if (desiredWidth <= i4) {
            setText(string);
            return;
        }
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan((i4 * 0.99f) / desiredWidth);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(relativeSizeSpan, 0, string.length(), 33);
        setText(spannableString);
    }

    public void c() {
        this.f4039g = false;
        this.f4038f = false;
        setText(BuildConfig.FLAVOR);
        setLongClickable(false);
    }

    @Override // com.vivo.calculator.b.j
    public void f(long j3) {
        c();
        this.B = false;
    }

    @Override // com.vivo.calculator.b.j
    public void g(long j3) {
        o();
    }

    @Override // com.vivo.calculator.b.g
    public float getDecimalCredit() {
        float f3;
        synchronized (this.f4051s) {
            f3 = this.f4055w;
        }
        return f3;
    }

    @Override // com.vivo.calculator.b.g
    public int getMaxChars() {
        int iFloor;
        synchronized (this.f4051s) {
            iFloor = (int) Math.floor(this.f4052t / this.f4053u);
        }
        return iFloor;
    }

    @Override // com.vivo.calculator.b.g
    public float getNoEllipsisCredit() {
        float f3;
        synchronized (this.f4051s) {
            f3 = this.f4056x;
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
        if (this.B) {
            this.f4036d.z0(j3);
            this.B = false;
        }
        o();
    }

    int i(int i3) {
        return Math.round(i3 / this.f4053u);
    }

    public boolean n() {
        return this.f4038f;
    }

    public void o() {
        setVisibility(0);
        int maxChars = getMaxChars();
        if (maxChars < 4) {
            return;
        }
        if (this.f4034b.isFinished() && length() > 0) {
            setAccessibilityLiveRegion(1);
        }
        int[] iArr = new int[1];
        String strJ = j(i(this.f4040h), maxChars, iArr, this.f4048p, true);
        VLog.d("BBKCalculator/CalculatorLocResult", "  redisplay,result1 = " + strJ);
        int iIndexOf = strJ.indexOf(69);
        String strD = e.D(strJ);
        VLog.d("BBKCalculator/CalculatorLocResult", "  redisplay,result2 = " + strD);
        StringBuilder sb = new StringBuilder();
        sb.append("  redisplay,mLocState == LocState.LOCINPUT = ");
        a aVar = this.F;
        a aVar2 = a.LOCINPUT;
        sb.append(aVar == aVar2);
        VLog.d("BBKCalculator/CalculatorLocResult", sb.toString());
        if (this.f4037e != null) {
            VLog.d("BBKCalculator/CalculatorLocResult", "  redisplay,mLocState == exchangeFragment.isIsLocalInput() = " + this.f4037e.X1());
            if ((!this.f4037e.X1() && this.F == aVar2) || !this.D.getBoolean("input_type", false) || this.f4037e.Z1()) {
                this.F = a.LOCRESULT;
                this.f4037e.n3(false);
                this.f4037e.T1(strD);
            }
            if (iIndexOf > 0 && strD.indexOf(46) == -1) {
                SpannableString spannableString = new SpannableString(strD);
                if (this.f4037e.X1() && this.D.getBoolean("input_type", false)) {
                    setTextString(((Object) spannableString) + BuildConfig.FLAVOR);
                }
            } else if (this.f4037e.X1() && this.D.getBoolean("input_type", false)) {
                setTextString(strD);
            }
            if (this.f4037e.e2()) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        }
        this.f4047o = iArr[0];
        this.f4039g = true;
        setLongClickable(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        com.vivo.calculator.a aVarI;
        super.onLayout(z2, i3, i4, i5, i6);
        b bVar = this.f4036d;
        if (bVar == null || this.f4057y == 0 || (aVarI = bVar.i(this.f4035c)) == null || !aVarI.B0()) {
            return;
        }
        if (this.f4057y == 2) {
            this.f4036d.M1(this.f4035c, this.f4058z, this);
        } else {
            this.f4036d.L0(this.f4035c, this.f4058z, this);
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
        this.f4049q = fMax5 / fK;
        synchronized (this.f4051s) {
            this.f4052t = size;
            this.f4053u = fK;
            this.f4056x = f3 / fK;
            this.f4055w = fMax6 / fK;
            this.f4054v = desiredWidth2 / fK;
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        if (!this.f4038f || this.f4034b.isFinished()) {
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

    public void p(b bVar, long j3) {
        this.f4036d = bVar;
        this.f4035c = j3;
        requestLayout();
    }

    public void q() {
        this.F = a.LOCINPUT;
    }

    public void r(int i3, b.j jVar) {
        this.f4058z = jVar;
        this.f4057y = i3;
    }

    public void setExchangeActivity(ExchangeActivity exchangeActivity) {
        this.f4037e = exchangeActivity;
    }

    public void setTextString(String str) {
        setText(g2.b.c(str));
    }
}
