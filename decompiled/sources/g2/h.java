package g2;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.vivo.calculator.CalculatorFormula;
import com.vivo.calculator.CalculatorResult;
import com.vivo.calculator.exchange.CalculatorLocResult;
import com.vivo.calculator.exchange.CalculatorOthResult;
import com.vivo.calculator.exchange.InputTextView;
import com.vivo.seckeysdk.BuildConfig;
import java.util.regex.Pattern;
import vivo.util.VLog;

/* JADX INFO: compiled from: StringUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: compiled from: StringUtil.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f4783a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f4784b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f4785c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static String f4786d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static String f4787e = "";

        public static String a(String str, int i3, int i4) {
            if (str == null) {
                return BuildConfig.FLAVOR;
            }
            int length = str.length();
            if (i3 < 0 || i3 > length || i3 > i4 || i4 < 0 || i4 > length) {
                return BuildConfig.FLAVOR;
            }
            String strC = g2.b.C(str, 0, i3);
            String strC2 = g2.b.C(str, i4, length);
            String strC3 = BuildConfig.FLAVOR;
            for (int length2 = strC.length() - 1; length2 >= 0; length2--) {
                if (length2 == 0) {
                    strC3 = strC;
                }
                if (!h.b(String.valueOf(strC.charAt(length2)))) {
                    strC3 = g2.b.C(strC, length2 + 1, strC.length());
                    break;
                }
            }
            String strC4 = BuildConfig.FLAVOR;
            for (int i5 = 0; i5 < strC2.length(); i5++) {
                if (i5 == strC2.length() - 1) {
                    strC4 = strC2;
                }
                if (!h.b(String.valueOf(strC2.charAt(i5)))) {
                    strC4 = g2.b.C(strC2, 0, i5);
                    break;
                }
            }
            f4784b = i3 - strC3.length();
            int length3 = strC4.length() + i4;
            f4785c = length3;
            if (f4784b < 0) {
                f4784b = 0;
            }
            if (length3 > str.length()) {
                f4785c = str.length();
            }
            if (BuildConfig.FLAVOR.equals(strC3) && BuildConfig.FLAVOR.equals(strC4)) {
                if (i3 != i4) {
                    String strC5 = g2.b.C(str, i3, i4);
                    if (h.b(strC5)) {
                        f4783a = true;
                        return strC5;
                    }
                }
                f4783a = false;
            } else {
                f4783a = true;
            }
            f4786d = strC4;
            f4787e = strC3;
            return strC3 + strC4;
        }
    }

    /* JADX INFO: compiled from: StringUtil.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f4788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f4789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f4790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String[] f4791d = {"e^", "x√y", "ln(", "^-1", "lg(", "log2(", "cos(", "cosh(", "cos-1(", "cosh-1(", "sin(", "sinh(", "sin-1(", "sinh-1(", "tan(", "tanh(", "tan-1(", "tanh-1(", "Rand"};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String[] f4792e = {"(", ")", "√", "^", "E", "!", "π", "+", "×", "÷", "−", "-", "%", "^", "e"};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String[] f4793f = {"sin-1(", "cos-1(", "tan-1(", "sin(", "cos(", "tan("};

        public static boolean a(String str, String str2, String str3) {
            if (str == null) {
                return false;
            }
            String[] strArr = null;
            str3.hashCode();
            if (str3.equals("TRIGONOMETRIC")) {
                strArr = f4793f;
            } else if (str3.equals("All Operations")) {
                strArr = f4791d;
            }
            if (strArr == null) {
                return false;
            }
            for (String str4 : strArr) {
                str2.hashCode();
                switch (str2) {
                    case "END_WITH":
                        if (str.endsWith(str4)) {
                            return true;
                        }
                        break;
                        break;
                    case "START_WITH":
                        if (str.startsWith(str4)) {
                            return true;
                        }
                        break;
                        break;
                    case "CONTAINS":
                        if (str.contains(str4)) {
                            return true;
                        }
                        break;
                        break;
                }
            }
            return false;
        }

        public static String b(String str, int i3, int i4) {
            int length;
            int i5;
            VLog.d("BBKCalculator/StringUtil", "isOperationReturnOperation , text = " + str + ", start = " + i3 + ", end = " + i4);
            if (str != null && i3 >= 0 && i4 >= 0 && i3 <= i4 && i3 <= (length = str.length()) && i4 <= length) {
                int i6 = 0;
                while (i6 < 7 && (i5 = i3 - i6) >= 0 && !c(str, i5)) {
                    i6++;
                }
                int i7 = i3 - i6;
                int i8 = 0;
                while (i8 < 7) {
                    int i9 = i4 + i8;
                    if (i9 > length || c(str, i9)) {
                        break;
                    }
                    i8++;
                }
                int i10 = i4 + i8;
                String strC = g2.b.C(str, i7, i10);
                for (String str2 : f4791d) {
                    if (str2.equals(strC)) {
                        f4788a = true;
                        f4789b = i7;
                        f4790c = i10;
                        return str2;
                    }
                }
            }
            return BuildConfig.FLAVOR;
        }

        public static boolean c(String str, int i3) {
            if (i3 < 0 || str == null) {
                return false;
            }
            if (i3 >= str.length() || i3 == 0) {
                return true;
            }
            String strValueOf = String.valueOf(str.charAt(i3 - 1));
            String strValueOf2 = String.valueOf(str.charAt(i3));
            if (h.b(strValueOf) || h.b(strValueOf2)) {
                return (("-".equals(strValueOf) && "1".equals(strValueOf2)) || ("1".equals(strValueOf) && "(".equals(strValueOf2)) || (("2".equals(strValueOf) && "(".equals(strValueOf2)) || ("g".equals(strValueOf) && "2".equals(strValueOf2)))) ? false : true;
            }
            for (String str2 : f4791d) {
                if (str2.endsWith(strValueOf) || str2.startsWith(strValueOf2)) {
                    return "o".equals(strValueOf) && "s".equals(strValueOf2);
                }
            }
            return false;
        }
    }

    public static String a(CalculatorFormula calculatorFormula, boolean z2) {
        if (calculatorFormula == null) {
            return BuildConfig.FLAVOR;
        }
        a.f4783a = false;
        b.f4788a = false;
        int selectionStart = calculatorFormula.getSelectionStart();
        int selectionEnd = calculatorFormula.getSelectionEnd();
        String textString = calculatorFormula.getTextString();
        String strB = selectionStart == selectionEnd ? BuildConfig.FLAVOR : b.b(textString, selectionStart, selectionEnd);
        if (BuildConfig.FLAVOR.equals(strB)) {
            strB = a.a(textString, selectionStart, selectionEnd);
            VLog.d("BBKCalculator/StringUtil", "getSelectIndexDigitOr2COperation res=" + strB);
            if (z2) {
                calculatorFormula.setSelection(a.f4784b, a.f4785c);
            }
        }
        return strB;
    }

    public static boolean b(String str) {
        return Pattern.compile("(\\d|,)*[.]?[0-9]*").matcher(str).matches();
    }

    public static void c(CalculatorFormula calculatorFormula, ClipboardManager clipboardManager) {
        int selectionStart;
        int selectionEnd;
        if (calculatorFormula == null || clipboardManager == null || (selectionStart = calculatorFormula.getSelectionStart()) == (selectionEnd = calculatorFormula.getSelectionEnd())) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, g2.b.C(calculatorFormula.getText().toString(), selectionStart, selectionEnd)));
    }

    public static void d(CalculatorResult calculatorResult, ClipboardManager clipboardManager) {
        int selectionStart;
        int selectionEnd;
        if (calculatorResult == null || clipboardManager == null || (selectionStart = calculatorResult.getSelectionStart()) == (selectionEnd = calculatorResult.getSelectionEnd())) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, g2.b.C(calculatorResult.getTextString(), selectionStart, selectionEnd)));
    }

    public static void e(CalculatorLocResult calculatorLocResult, ClipboardManager clipboardManager) {
        int selectionStart;
        int selectionEnd;
        if (calculatorLocResult == null || clipboardManager == null || (selectionStart = calculatorLocResult.getSelectionStart()) == (selectionEnd = calculatorLocResult.getSelectionEnd())) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, g2.b.C(calculatorLocResult.getTextString(), selectionStart, selectionEnd)));
    }

    public static void f(CalculatorOthResult calculatorOthResult, ClipboardManager clipboardManager) {
        int selectionStart;
        int selectionEnd;
        if (calculatorOthResult == null || clipboardManager == null || (selectionStart = calculatorOthResult.getSelectionStart()) == (selectionEnd = calculatorOthResult.getSelectionEnd())) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, g2.b.C(calculatorOthResult.getTextString(), selectionStart, selectionEnd)));
    }

    public static void g(InputTextView inputTextView, ClipboardManager clipboardManager) {
        int selectionStart;
        int selectionEnd;
        if (inputTextView == null || clipboardManager == null || (selectionStart = inputTextView.getSelectionStart()) == (selectionEnd = inputTextView.getSelectionEnd())) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, g2.b.C(inputTextView.getText().toString(), selectionStart, selectionEnd)));
    }

    public static void h(CalculatorFormula calculatorFormula) {
        if (calculatorFormula == null) {
            return;
        }
        int selectionStart = calculatorFormula.getSelectionStart();
        int selectionEnd = calculatorFormula.getSelectionEnd();
        String textString = calculatorFormula.getTextString();
        if (selectionEnd == selectionStart) {
            if (b.c(textString, selectionEnd) && ((selectionEnd > 0 && b.a(textString.substring(0, selectionEnd), "END_WITH", "All Operations")) || (selectionEnd == 0 && b.a(textString, "START_WITH", "All Operations")))) {
                calculatorFormula.setSelection(selectionEnd > 0 ? selectionEnd - 1 : selectionEnd + 1);
            }
            a(calculatorFormula, true);
            if (calculatorFormula.getSelectionStart() != calculatorFormula.getSelectionEnd() || calculatorFormula.getTextString().length() < selectionEnd) {
                return;
            }
            int i3 = selectionEnd > 0 ? selectionEnd - 1 : selectionEnd;
            if (selectionEnd <= 0) {
                selectionEnd++;
            }
            calculatorFormula.setSelection(i3, selectionEnd);
        }
    }

    public static boolean i(String str) {
        return str == null || str.equals(BuildConfig.FLAVOR) || str.equals("null");
    }
}
