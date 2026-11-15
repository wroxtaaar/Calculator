package z1;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.vivo.calculator.R;
import com.vivo.seckeysdk.BuildConfig;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import vivo.util.VLog;

/* JADX INFO: compiled from: KeyMaps.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char f6654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static char f6655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HashMap<String, Integer> f6656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HashMap<Character, String> f6657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Locale f6658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Activity f6659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static View f6660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static View f6661h;

    public static int A(Context context, String str) {
        str.hashCode();
        switch (str) {
            case " ":
            case ".":
                return R.id.e_dec_point;
            case "(":
                return R.id.lparen;
            case ")":
                return R.id.rparen;
            case "+":
                return R.id.e_op_add;
            case "-":
            case "−":
                return R.id.e_op_sub;
            case "0":
                return R.id.e_digit_0;
            case "1":
                return R.id.e_digit_1;
            case "2":
                return R.id.e_digit_2;
            case "3":
                return R.id.e_digit_3;
            case "4":
                return R.id.e_digit_4;
            case "5":
                return R.id.e_digit_5;
            case "6":
                return R.id.e_digit_6;
            case "7":
                return R.id.e_digit_7;
            case "8":
                return R.id.e_digit_8;
            case "9":
                return R.id.e_digit_9;
            case "E":
                return R.id.EE;
            case "×":
                return R.id.e_op_mul;
            case "÷":
                return R.id.e_op_div;
            default:
                VLog.d("BBKCalculator/KeyMaps", "toPadeExId:" + str + " not match ");
                return -1;
        }
    }

    public static int B(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "cosh-1":
                return R.id.fun_arccosh;
            case "sinh-1":
                return R.id.fun_arcsinh;
            case "tanh-1":
                return R.id.fun_arctanh;
            case " ":
            case ".":
                return R.id.dec_point;
            case "!":
                return R.id.op_fact;
            case "%":
                return R.id.op_pct;
            case "(":
                return R.id.lparen;
            case ")":
                return R.id.rparen;
            case "+":
                return R.id.op_add;
            case "-":
            case "−":
                return R.id.op_sub;
            case "0":
                return R.id.digit_0;
            case "1":
                return R.id.digit_1;
            case "2":
                return R.id.digit_2;
            case "3":
                return R.id.digit_3;
            case "4":
                return R.id.digit_4;
            case "5":
                return R.id.digit_5;
            case "6":
                return R.id.digit_6;
            case "7":
                return R.id.digit_7;
            case "8":
                return R.id.digit_8;
            case "9":
                return R.id.digit_9;
            case "E":
                return R.id.EE;
            case "^":
                return R.id.yx;
            case "×":
                return R.id.op_mul;
            case "÷":
                return R.id.op_div;
            case "π":
                return R.id.const_pi;
            case "e^":
            case "eˣ":
                return R.id.fun_exp;
            case "lg":
                return R.id.fun_lg;
            case "ln":
                return R.id.fun_ln;
            case "√":
                return R.id.op_sqrt;
            case "cos":
                return R.id.fun_cos;
            case "log":
                return R.id.fun_log;
            case "sin":
                return R.id.fun_sin;
            case "tan":
                return R.id.fun_tan;
            case "x√y":
                return R.id.xgenhaoy;
            case "Rand":
            case "rand":
                return R.id.rand;
            case "cosh":
                return R.id.fun_cosh;
            case "sinh":
                return R.id.fun_sinh;
            case "tanh":
                return R.id.fun_tanh;
            case "cos-1":
                return R.id.fun_arccos;
            case "sin-1":
                return R.id.fun_arcsin;
            case "tan-1":
                return R.id.fun_arctan;
            default:
                VLog.d("BBKCalculator/KeyMaps", "insertProcess toPadeId:" + str + " not match ");
                return -1;
        }
    }

    public static String C(Context context, int i3) {
        switch (i3) {
            case R.id.EE /* 2131230724 */:
                return context.getString(R.string.text_E);
            case R.id.dec_point /* 2131230876 */:
                return context.getString(R.string.description_dot);
            case R.id.e_dec_point /* 2131230925 */:
                return context.getString(R.string.description_dot);
            case R.id.lparen /* 2131231069 */:
                return context.getString(R.string.lparen);
            case R.id.rand /* 2131231219 */:
                return context.getString(R.string.text_Rand);
            case R.id.rparen /* 2131231236 */:
                return context.getString(R.string.rparen);
            case R.id.xgenhaoy /* 2131231387 */:
                return context.getString(R.string.xgenhaoy);
            default:
                switch (i3) {
                    case R.id.const_e /* 2131230855 */:
                        return context.getString(R.string.const_e);
                    case R.id.const_pi /* 2131230856 */:
                        return context.getString(R.string.const_pi);
                    default:
                        switch (i3) {
                            case R.id.digit_0 /* 2131230891 */:
                                return context.getString(R.string.digit_0);
                            case R.id.digit_1 /* 2131230892 */:
                                return context.getString(R.string.digit_1);
                            case R.id.digit_2 /* 2131230893 */:
                                return context.getString(R.string.digit_2);
                            case R.id.digit_3 /* 2131230894 */:
                                return context.getString(R.string.digit_3);
                            case R.id.digit_4 /* 2131230895 */:
                                return context.getString(R.string.digit_4);
                            case R.id.digit_5 /* 2131230896 */:
                                return context.getString(R.string.digit_5);
                            case R.id.digit_6 /* 2131230897 */:
                                return context.getString(R.string.digit_6);
                            case R.id.digit_7 /* 2131230898 */:
                                return context.getString(R.string.digit_7);
                            case R.id.digit_8 /* 2131230899 */:
                                return context.getString(R.string.digit_8);
                            case R.id.digit_9 /* 2131230900 */:
                                return context.getString(R.string.digit_9);
                            default:
                                switch (i3) {
                                    case R.id.e_digit_0 /* 2131230927 */:
                                        return context.getString(R.string.digit_0);
                                    case R.id.e_digit_00 /* 2131230928 */:
                                        return context.getString(R.string.digit_00);
                                    case R.id.e_digit_1 /* 2131230929 */:
                                        return context.getString(R.string.digit_1);
                                    case R.id.e_digit_2 /* 2131230930 */:
                                        return context.getString(R.string.digit_2);
                                    case R.id.e_digit_3 /* 2131230931 */:
                                        return context.getString(R.string.digit_3);
                                    case R.id.e_digit_4 /* 2131230932 */:
                                        return context.getString(R.string.digit_4);
                                    case R.id.e_digit_5 /* 2131230933 */:
                                        return context.getString(R.string.digit_5);
                                    case R.id.e_digit_6 /* 2131230934 */:
                                        return context.getString(R.string.digit_6);
                                    case R.id.e_digit_7 /* 2131230935 */:
                                        return context.getString(R.string.digit_7);
                                    case R.id.e_digit_8 /* 2131230936 */:
                                        return context.getString(R.string.digit_8);
                                    case R.id.e_digit_9 /* 2131230937 */:
                                        return context.getString(R.string.digit_9);
                                    default:
                                        switch (i3) {
                                            case R.id.e_op_add /* 2131230939 */:
                                                return context.getString(R.string.op_add);
                                            case R.id.e_op_div /* 2131230940 */:
                                                return context.getString(R.string.op_div);
                                            case R.id.e_op_mul /* 2131230941 */:
                                                return context.getString(R.string.op_mul);
                                            case R.id.e_op_sub /* 2131230942 */:
                                                return context.getString(R.string.op_sub);
                                            default:
                                                switch (i3) {
                                                    case R.id.fun_arccos /* 2131230978 */:
                                                        return context.getString(R.string.fun_arccos) + context.getString(R.string.lparen);
                                                    case R.id.fun_arccosh /* 2131230979 */:
                                                        return context.getString(R.string.fun_arccosh) + context.getString(R.string.lparen);
                                                    case R.id.fun_arcsin /* 2131230980 */:
                                                        return context.getString(R.string.fun_arcsin) + context.getString(R.string.lparen);
                                                    case R.id.fun_arcsinh /* 2131230981 */:
                                                        return context.getString(R.string.fun_arcsinh) + context.getString(R.string.lparen);
                                                    case R.id.fun_arctan /* 2131230982 */:
                                                        return context.getString(R.string.fun_arctan) + context.getString(R.string.lparen);
                                                    case R.id.fun_arctanh /* 2131230983 */:
                                                        return context.getString(R.string.fun_arctanh) + context.getString(R.string.lparen);
                                                    case R.id.fun_cos /* 2131230984 */:
                                                        return context.getString(R.string.fun_cos) + context.getString(R.string.lparen);
                                                    case R.id.fun_cosh /* 2131230985 */:
                                                        return context.getString(R.string.fun_cosh) + context.getString(R.string.lparen);
                                                    case R.id.fun_exp /* 2131230986 */:
                                                        return context.getString(R.string.exponential) + context.getString(R.string.op_pow);
                                                    case R.id.fun_lg /* 2131230987 */:
                                                        return context.getString(R.string.text_lg) + context.getString(R.string.lparen);
                                                    case R.id.fun_ln /* 2131230988 */:
                                                        return context.getString(R.string.fun_ln) + context.getString(R.string.lparen);
                                                    case R.id.fun_log /* 2131230989 */:
                                                        return context.getString(R.string.fun_log) + context.getString(R.string.digit_2) + context.getString(R.string.lparen);
                                                    case R.id.fun_sin /* 2131230990 */:
                                                        return context.getString(R.string.fun_sin) + context.getString(R.string.lparen);
                                                    case R.id.fun_sinh /* 2131230991 */:
                                                        return context.getString(R.string.fun_sinh) + context.getString(R.string.lparen);
                                                    case R.id.fun_tan /* 2131230992 */:
                                                        return context.getString(R.string.fun_tan) + context.getString(R.string.lparen);
                                                    case R.id.fun_tanh /* 2131230993 */:
                                                        return context.getString(R.string.fun_tanh) + context.getString(R.string.lparen);
                                                    default:
                                                        switch (i3) {
                                                            case R.id.op_add /* 2131231170 */:
                                                                return context.getString(R.string.op_add);
                                                            case R.id.op_div /* 2131231171 */:
                                                                return context.getString(R.string.op_div);
                                                            case R.id.op_fact /* 2131231172 */:
                                                                return context.getString(R.string.op_fact);
                                                            case R.id.op_mul /* 2131231173 */:
                                                                return context.getString(R.string.op_mul);
                                                            case R.id.op_pct /* 2131231174 */:
                                                                return context.getString(R.string.op_pct);
                                                            case R.id.op_pow /* 2131231175 */:
                                                                return context.getString(R.string.op_pow);
                                                            case R.id.op_sqr /* 2131231176 */:
                                                                return context.getString(R.string.squared);
                                                            default:
                                                                switch (i3) {
                                                                    case R.id.op_sqrt /* 2131231178 */:
                                                                        return context.getString(R.string.op_sqrt);
                                                                    case R.id.op_sub /* 2131231179 */:
                                                                        return context.getString(R.string.op_sub);
                                                                    default:
                                                                        return BuildConfig.FLAVOR;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static String D(String str) {
        return str.toString();
    }

    static void E() {
        Locale locale = Locale.getDefault();
        if (locale.equals(f6658e)) {
            return;
        }
        VLog.v("BBKCalculator/KeyMaps", "Setting locale to: " + locale.toLanguageTag());
        f6656c = new HashMap<>();
        f6657d = new HashMap<>();
        c('-', R.id.e_op_sub);
        c('.', R.id.e_dec_point);
        for (int i3 = 0; i3 <= 9; i3++) {
            c((char) (i3 + 48), u(i3));
        }
        f6658e = locale;
    }

    static void F() {
        int i3;
        Locale locale = Locale.getDefault();
        if (locale.equals(f6658e)) {
            return;
        }
        VLog.v("BBKCalculator/KeyMaps", "Setting locale to: " + locale.toLanguageTag());
        f6656c = new HashMap<>();
        f6657d = new HashMap<>();
        Resources resources = f6659f.getResources();
        if (resources.getConfiguration().orientation != 1) {
            f6656c.put("sin", Integer.valueOf(R.id.fun_sin));
            f6656c.put("cos", Integer.valueOf(R.id.fun_cos));
            f6656c.put("tan", Integer.valueOf(R.id.fun_tan));
            f6656c.put("sinh", Integer.valueOf(R.id.fun_sinh));
            f6656c.put("cosh", Integer.valueOf(R.id.fun_cosh));
            f6656c.put("tanh", Integer.valueOf(R.id.fun_tanh));
            f6656c.put("arcsin", Integer.valueOf(R.id.fun_arcsin));
            f6656c.put("arccos", Integer.valueOf(R.id.fun_arccos));
            f6656c.put("arctan", Integer.valueOf(R.id.fun_arctan));
            f6656c.put("arcsinh", Integer.valueOf(R.id.fun_arcsinh));
            f6656c.put("arccosh", Integer.valueOf(R.id.fun_arccosh));
            f6656c.put("arctanh", Integer.valueOf(R.id.fun_arctanh));
            f6656c.put("asin", Integer.valueOf(R.id.fun_arcsin));
            f6656c.put("acos", Integer.valueOf(R.id.fun_arccos));
            f6656c.put("atan", Integer.valueOf(R.id.fun_arctan));
            f6656c.put("ln", Integer.valueOf(R.id.fun_ln));
            f6656c.put("VLog", Integer.valueOf(R.id.fun_log));
            f6656c.put("sqrt", Integer.valueOf(R.id.op_sqrt));
            a(R.id.fun_sin);
            a(R.id.fun_cos);
            a(R.id.fun_tan);
            a(R.id.fun_arcsin);
            a(R.id.fun_arccos);
            a(R.id.fun_arctan);
            a(R.id.fun_sinh);
            a(R.id.fun_cosh);
            a(R.id.fun_tanh);
            a(R.id.fun_arcsinh);
            a(R.id.fun_arccosh);
            a(R.id.fun_arctanh);
            a(R.id.fun_ln);
            a(R.id.fun_log);
            f6654a = DecimalFormatSymbols.getInstance().getDecimalSeparator();
            f6655b = (char) 0;
            String string = resources.getString(R.string.const_pi);
            if (string.length() == 1) {
                f6655b = string.charAt(0);
            }
            f6657d.put('e', "E");
            f6657d.put('E', "K");
            f6657d.put(' ', String.valueOf((char) 8199));
            i3 = 0;
            f6657d.put(Character.valueOf("…".charAt(0)), "…");
            f6657d.put('/', "/");
            f6657d.put('(', "(");
            f6657d.put(')', ")");
            f6657d.put('l', "l");
            f6657d.put('n', "n");
            f6657d.put(',', String.valueOf(DecimalFormatSymbols.getInstance().getGroupingSeparator()));
            f6657d.put((char) 8730, "√");
            f6657d.put((char) 960, "π");
        } else {
            i3 = 0;
        }
        b('-', R.id.op_sub);
        b('.', R.id.dec_point);
        for (int i4 = i3; i4 <= 9; i4++) {
            b((char) (i4 + 48), t(i4));
        }
        f6658e = locale;
    }

    static void a(int i3) {
    }

    static void b(char c3, int i3) {
    }

    static void c(char c3, int i3) {
    }

    public static int d(int i3) {
        switch (i3) {
            case R.id.digit_0 /* 2131230891 */:
                return 0;
            case R.id.digit_1 /* 2131230892 */:
                return 1;
            case R.id.digit_2 /* 2131230893 */:
                return 2;
            case R.id.digit_3 /* 2131230894 */:
                return 3;
            case R.id.digit_4 /* 2131230895 */:
                return 4;
            case R.id.digit_5 /* 2131230896 */:
                return 5;
            case R.id.digit_6 /* 2131230897 */:
                return 6;
            case R.id.digit_7 /* 2131230898 */:
                return 7;
            case R.id.digit_8 /* 2131230899 */:
                return 8;
            case R.id.digit_9 /* 2131230900 */:
                return 9;
            default:
                switch (i3) {
                    case R.id.e_digit_0 /* 2131230927 */:
                    case R.id.e_digit_00 /* 2131230928 */:
                        return 0;
                    case R.id.e_digit_1 /* 2131230929 */:
                        return 1;
                    case R.id.e_digit_2 /* 2131230930 */:
                        return 2;
                    case R.id.e_digit_3 /* 2131230931 */:
                        return 3;
                    case R.id.e_digit_4 /* 2131230932 */:
                        return 4;
                    case R.id.e_digit_5 /* 2131230933 */:
                        return 5;
                    case R.id.e_digit_6 /* 2131230934 */:
                        return 6;
                    case R.id.e_digit_7 /* 2131230935 */:
                        return 7;
                    case R.id.e_digit_8 /* 2131230936 */:
                        return 8;
                    case R.id.e_digit_9 /* 2131230937 */:
                        return 9;
                    default:
                        return 10;
                }
        }
    }

    public static boolean e(int i3) {
        switch (i3) {
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
                return true;
            case R.id.e_del /* 2131230926 */:
            default:
                return false;
        }
    }

    public static int f(byte b3) {
        char c3 = (char) b3;
        if (c3 == 'o') {
            return R.id.fun_cosh;
        }
        if (c3 == 'p') {
            return R.id.const_pi;
        }
        switch (c3) {
            case '!':
                return R.id.op_fact;
            case '%':
                return R.id.op_pct;
            case '-':
                return R.id.op_sub;
            case '/':
                return R.id.op_div;
            case '2':
                return R.id.op_sqr;
            case 'A':
                return R.id.fun_arctanh;
            case 'C':
                return R.id.fun_arccos;
            case 'E':
                return R.id.fun_exp;
            case 'I':
                return R.id.fun_arcsinh;
            case 'O':
                return R.id.fun_arccosh;
            case '^':
                return R.id.op_pow;
            case 'a':
                return R.id.fun_tanh;
            case 'c':
                return R.id.fun_cos;
            case 'e':
                return R.id.const_e;
            case 'g':
                return R.id.fun_lg;
            case 'i':
                return R.id.fun_sinh;
            case 'l':
                return R.id.fun_ln;
            default:
                switch (c3) {
                    case '(':
                        return R.id.lparen;
                    case ')':
                        return R.id.rparen;
                    case '*':
                        return R.id.op_mul;
                    case '+':
                        return R.id.op_add;
                    default:
                        switch (c3) {
                            case 'K':
                                return R.id.EE;
                            case 'L':
                                return R.id.fun_log;
                            case 'M':
                                return R.id.e_op_mul;
                            default:
                                switch (c3) {
                                    case 'R':
                                        return R.id.rand;
                                    case 'S':
                                        return R.id.fun_arcsin;
                                    case 'T':
                                        return R.id.fun_arctan;
                                    case 'U':
                                        return R.id.e_op_div;
                                    case 'V':
                                        return R.id.e_op_sub;
                                    case 'W':
                                        return R.id.e_op_add;
                                    default:
                                        switch (c3) {
                                            case 'r':
                                                return R.id.op_sqrt;
                                            case 's':
                                                return R.id.fun_sin;
                                            case 't':
                                                return R.id.fun_tan;
                                            default:
                                                VLog.d("BBKCalculator/KeyMaps", "fromByte key Byte:" + ((int) b3));
                                                throw new AssertionError("Unexpected single byte operator encoding");
                                        }
                                }
                        }
                }
        }
    }

    public static int g(String str, int i3) {
        E();
        int iIndexOf = str.indexOf(40, i3);
        if (iIndexOf == -1) {
            return -1;
        }
        Integer num = f6656c.get(str.substring(i3, iIndexOf));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static char h() {
        return '.';
    }

    public static char i() {
        return ',';
    }

    public static String j(String str) {
        int iIndexOf = str.indexOf(46);
        int iIndexOf2 = str.indexOf("…");
        if (str.indexOf(69) != -1 || iIndexOf2 != -1) {
            return str;
        }
        if (iIndexOf == -1) {
            return k(str);
        }
        return k(str.substring(0, iIndexOf)) + str.substring(iIndexOf);
    }

    public static String k(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        boolean z2 = str.charAt(0) == '-';
        if (z2) {
            str = str.substring(1, str.length());
        }
        int length = str.length();
        if (length <= 3) {
            if (!z2) {
                return str;
            }
            return "-" + str;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (int i4 = length - 1; i4 >= 0; i4--) {
            if (i3 != 0 && i3 % 3 == 0) {
                sb.insert(0, ',');
            }
            sb.insert(0, str.charAt(i4));
            i3++;
        }
        if (!z2) {
            return sb.toString();
        }
        return "-" + sb.toString();
    }

    public static boolean l(int i3) {
        switch (i3) {
            case R.id.e_op_add /* 2131230939 */:
            case R.id.e_op_div /* 2131230940 */:
            case R.id.e_op_mul /* 2131230941 */:
            case R.id.e_op_sub /* 2131230942 */:
            case R.id.op_add /* 2131231170 */:
            case R.id.op_div /* 2131231171 */:
            case R.id.op_mul /* 2131231173 */:
            case R.id.op_sub /* 2131231179 */:
                return true;
            default:
                return false;
        }
    }

    public static boolean m(int i3) {
        return i3 == R.id.fun_10pow;
    }

    public static boolean n(int i3) {
        if (q(i3)) {
            return true;
        }
        switch (i3) {
            case R.id.fun_exp /* 2131230986 */:
            case R.id.fun_lg /* 2131230987 */:
            case R.id.fun_ln /* 2131230988 */:
            case R.id.fun_log /* 2131230989 */:
                return true;
            default:
                return false;
        }
    }

    public static boolean o(int i3) {
        return i3 == R.id.op_sqrt;
    }

    public static boolean p(int i3) {
        switch (i3) {
            case R.id.EE /* 2131230724 */:
            case R.id.countDown /* 2131230864 */:
            case R.id.op_fact /* 2131231172 */:
            case R.id.op_pct /* 2131231174 */:
            case R.id.rand /* 2131231219 */:
                return true;
            default:
                switch (i3) {
                    case R.id.const_pi /* 2131230856 */:
                    case R.id.const_x /* 2131230857 */:
                        return true;
                    default:
                        switch (i3) {
                            case R.id.fun_10pow /* 2131230977 */:
                            case R.id.fun_arccos /* 2131230978 */:
                            case R.id.fun_arccosh /* 2131230979 */:
                            case R.id.fun_arcsin /* 2131230980 */:
                            case R.id.fun_arcsinh /* 2131230981 */:
                            case R.id.fun_arctan /* 2131230982 */:
                            case R.id.fun_arctanh /* 2131230983 */:
                            case R.id.fun_cos /* 2131230984 */:
                            case R.id.fun_cosh /* 2131230985 */:
                            case R.id.fun_exp /* 2131230986 */:
                            case R.id.fun_lg /* 2131230987 */:
                            case R.id.fun_ln /* 2131230988 */:
                            case R.id.fun_log /* 2131230989 */:
                            case R.id.fun_sin /* 2131230990 */:
                            case R.id.fun_sinh /* 2131230991 */:
                            case R.id.fun_tan /* 2131230992 */:
                            case R.id.fun_tanh /* 2131230993 */:
                                return true;
                            default:
                                switch (i3) {
                                    case R.id.op_sqr /* 2131231176 */:
                                    case R.id.op_sqrs /* 2131231177 */:
                                    case R.id.op_sqrt /* 2131231178 */:
                                        return true;
                                    default:
                                        switch (i3) {
                                            case R.id.xgenhaoy /* 2131231387 */:
                                            case R.id.yx /* 2131231388 */:
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }

    public static boolean q(int i3) {
        switch (i3) {
            case R.id.fun_arccos /* 2131230978 */:
            case R.id.fun_arcsin /* 2131230980 */:
            case R.id.fun_arctan /* 2131230982 */:
            case R.id.fun_cos /* 2131230984 */:
            case R.id.fun_sin /* 2131230990 */:
            case R.id.fun_tan /* 2131230992 */:
                return true;
            default:
                return false;
        }
    }

    public static int r(char c3) {
        F();
        if (Character.isDigit(c3)) {
            return t(Character.digit(c3, 10));
        }
        if (c3 == '!') {
            return R.id.op_fact;
        }
        if (c3 == '%') {
            return R.id.op_pct;
        }
        if (c3 == 'K') {
            return R.id.EE;
        }
        if (c3 != 'P') {
            if (c3 == '^') {
                return R.id.op_pow;
            }
            if (c3 == 'e') {
                return R.id.const_e;
            }
            if (c3 != 'p') {
                if (c3 == 215) {
                    return R.id.op_mul;
                }
                if (c3 == 247) {
                    return R.id.op_div;
                }
                if (c3 == 8722) {
                    return R.id.op_sub;
                }
                switch (c3) {
                    case '(':
                        return R.id.lparen;
                    case ')':
                        return R.id.rparen;
                    case '*':
                        return R.id.op_mul;
                    case '+':
                        return R.id.op_add;
                    case ',':
                    case '.':
                        return R.id.dec_point;
                    case '-':
                        return R.id.op_sub;
                    case '/':
                        return R.id.op_div;
                    default:
                        if (c3 == f6654a) {
                            return R.id.dec_point;
                        }
                        if (c3 == f6655b) {
                            return R.id.const_pi;
                        }
                        return -1;
                }
            }
        }
        return R.id.const_pi;
    }

    public static int s(char c3) {
        E();
        if (Character.isDigit(c3)) {
            return u(Character.digit(c3, 10));
        }
        switch (c3) {
            case '!':
                return R.id.op_fact;
            case '%':
                return R.id.op_pct;
            case '(':
                return R.id.lparen;
            case ')':
                return R.id.rparen;
            case ',':
            case '.':
                return R.id.e_dec_point;
            case 'E':
            case 'e':
                return R.id.const_e;
            case 'K':
                return R.id.EE;
            case 'M':
            case 215:
                return R.id.e_op_mul;
            case 'P':
            case 'p':
                return R.id.const_pi;
            case 'U':
            case 247:
                return R.id.e_op_div;
            case 'V':
            case 8722:
                return R.id.e_op_sub;
            case 'W':
                return R.id.e_op_add;
            case '^':
                return R.id.op_pow;
            default:
                if (c3 == f6654a) {
                    return R.id.e_dec_point;
                }
                if (c3 == f6655b) {
                    return R.id.const_pi;
                }
                VLog.d("BBKCalculator/KeyMaps", "keyForCharEx,c:" + c3 + ",id:-1");
                return -1;
        }
    }

    public static int t(int i3) {
        switch (i3) {
            case 0:
                return R.id.digit_0;
            case 1:
                return R.id.digit_1;
            case 2:
                return R.id.digit_2;
            case 3:
                return R.id.digit_3;
            case 4:
                return R.id.digit_4;
            case 5:
                return R.id.digit_5;
            case 6:
                return R.id.digit_6;
            case 7:
                return R.id.digit_7;
            case 8:
                return R.id.digit_8;
            case 9:
                return R.id.digit_9;
            default:
                return -1;
        }
    }

    public static int u(int i3) {
        switch (i3) {
            case 0:
                return R.id.e_digit_0;
            case 1:
                return R.id.e_digit_1;
            case 2:
                return R.id.e_digit_2;
            case 3:
                return R.id.e_digit_3;
            case 4:
                return R.id.e_digit_4;
            case 5:
                return R.id.e_digit_5;
            case 6:
                return R.id.e_digit_6;
            case 7:
                return R.id.e_digit_7;
            case 8:
                return R.id.e_digit_8;
            case 9:
                return R.id.e_digit_9;
            default:
                return -1;
        }
    }

    public static void v(Activity activity) {
        f6659f = activity;
    }

    public static void w(View view) {
        f6661h = view;
    }

    public static void x(View view) {
        f6660g = view;
    }

    public static byte y(int i3) {
        int i4;
        switch (i3) {
            case R.id.EE /* 2131230724 */:
                i4 = 75;
                break;
            case R.id.lparen /* 2131231069 */:
                i4 = 40;
                break;
            case R.id.rand /* 2131231219 */:
                i4 = 82;
                break;
            case R.id.rparen /* 2131231236 */:
                i4 = 41;
                break;
            default:
                switch (i3) {
                    case R.id.const_e /* 2131230855 */:
                        i4 = 101;
                        break;
                    case R.id.const_pi /* 2131230856 */:
                        i4 = 112;
                        break;
                    default:
                        switch (i3) {
                            case R.id.e_op_add /* 2131230939 */:
                                i4 = 87;
                                break;
                            case R.id.e_op_div /* 2131230940 */:
                                i4 = 85;
                                break;
                            case R.id.e_op_mul /* 2131230941 */:
                                i4 = 77;
                                break;
                            case R.id.e_op_sub /* 2131230942 */:
                                i4 = 86;
                                break;
                            default:
                                switch (i3) {
                                    case R.id.fun_arccos /* 2131230978 */:
                                        i4 = 67;
                                        break;
                                    case R.id.fun_arccosh /* 2131230979 */:
                                        i4 = 79;
                                        break;
                                    case R.id.fun_arcsin /* 2131230980 */:
                                        i4 = 83;
                                        break;
                                    case R.id.fun_arcsinh /* 2131230981 */:
                                        i4 = 73;
                                        break;
                                    case R.id.fun_arctan /* 2131230982 */:
                                        i4 = 84;
                                        break;
                                    case R.id.fun_arctanh /* 2131230983 */:
                                        i4 = 65;
                                        break;
                                    case R.id.fun_cos /* 2131230984 */:
                                        i4 = 99;
                                        break;
                                    case R.id.fun_cosh /* 2131230985 */:
                                        i4 = 111;
                                        break;
                                    case R.id.fun_exp /* 2131230986 */:
                                        i4 = 69;
                                        break;
                                    case R.id.fun_lg /* 2131230987 */:
                                        i4 = 103;
                                        break;
                                    case R.id.fun_ln /* 2131230988 */:
                                        i4 = 108;
                                        break;
                                    case R.id.fun_log /* 2131230989 */:
                                        i4 = 76;
                                        break;
                                    case R.id.fun_sin /* 2131230990 */:
                                        i4 = 115;
                                        break;
                                    case R.id.fun_sinh /* 2131230991 */:
                                        i4 = 105;
                                        break;
                                    case R.id.fun_tan /* 2131230992 */:
                                        i4 = 116;
                                        break;
                                    case R.id.fun_tanh /* 2131230993 */:
                                        i4 = 97;
                                        break;
                                    default:
                                        switch (i3) {
                                            case R.id.op_add /* 2131231170 */:
                                                i4 = 43;
                                                break;
                                            case R.id.op_div /* 2131231171 */:
                                                i4 = 47;
                                                break;
                                            case R.id.op_fact /* 2131231172 */:
                                                i4 = 33;
                                                break;
                                            case R.id.op_mul /* 2131231173 */:
                                                i4 = 42;
                                                break;
                                            case R.id.op_pct /* 2131231174 */:
                                                i4 = 37;
                                                break;
                                            case R.id.op_pow /* 2131231175 */:
                                                i4 = 94;
                                                break;
                                            case R.id.op_sqr /* 2131231176 */:
                                                i4 = 50;
                                                break;
                                            default:
                                                switch (i3) {
                                                    case R.id.op_sqrt /* 2131231178 */:
                                                        i4 = 114;
                                                        break;
                                                    case R.id.op_sub /* 2131231179 */:
                                                        i4 = 45;
                                                        break;
                                                    default:
                                                        VLog.d("BBKCalculator/KeyMaps", "Unexpected key id:" + i3);
                                                        throw new AssertionError("Unexpected key id");
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
        return (byte) i4;
    }

    public static String z(Context context, int i3) {
        switch (i3) {
            case R.id.const_x /* 2131230857 */:
                return context.getString(R.string.description_xy);
            case R.id.dec_point /* 2131230876 */:
                return context.getString(R.string.description_dot);
            case R.id.lparen /* 2131231069 */:
                return context.getString(R.string.description_leftparen);
            case R.id.op_fact /* 2131231172 */:
                return context.getString(R.string.description_factorial);
            case R.id.op_pow /* 2131231175 */:
                return context.getString(R.string.description_xy);
            case R.id.rand /* 2131231219 */:
                return context.getString(R.string.description_rand) + " " + context.getString(R.string.description_leftparen);
            case R.id.rparen /* 2131231236 */:
                return context.getString(R.string.description_leftparen);
            default:
                switch (i3) {
                    case R.id.fun_arccos /* 2131230978 */:
                        return context.getString(R.string.description_cos_1) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_arccosh /* 2131230979 */:
                        return context.getString(R.string.fun_arccosh) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_arcsin /* 2131230980 */:
                        return context.getString(R.string.description_sin_1) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_arcsinh /* 2131230981 */:
                        return context.getString(R.string.fun_arcsinh) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_arctan /* 2131230982 */:
                        return context.getString(R.string.description_tan_1) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_arctanh /* 2131230983 */:
                        return context.getString(R.string.fun_arctanh) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_cos /* 2131230984 */:
                        return context.getString(R.string.description_cos) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_cosh /* 2131230985 */:
                        return context.getString(R.string.fun_cosh) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_exp /* 2131230986 */:
                        return context.getString(R.string.description_ex) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_lg /* 2131230987 */:
                        return context.getString(R.string.description_lg) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_ln /* 2131230988 */:
                        return context.getString(R.string.description_ln) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_log /* 2131230989 */:
                        return context.getString(R.string.description_lg) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_sin /* 2131230990 */:
                        return context.getString(R.string.description_sin) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_sinh /* 2131230991 */:
                        return context.getString(R.string.fun_sinh) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_tan /* 2131230992 */:
                        return context.getString(R.string.description_tan) + " " + context.getString(R.string.description_leftparen);
                    case R.id.fun_tanh /* 2131230993 */:
                        return context.getString(R.string.fun_tanh) + " " + context.getString(R.string.description_leftparen);
                    default:
                        return null;
                }
        }
    }
}
