package g2;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.seckeysdk.BuildConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import vivo.util.VLog;

/* JADX INFO: compiled from: ExchangeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStreamReader] */
    private static String a(String str) throws Throwable {
        StringBuilder sb;
        String[] strArrSplit;
        String strB = g.b("persist.radio.vivo.mcc", "0");
        String str2 = str + strB;
        VLog.d("BBKCalculator/ExchangeUtils", "getAreaCode mcc = " + strB + ", areaCode ： " + str2);
        ?? r3 = 0;
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(BBKCalculatorApplication.a().getAssets().open("country_code_mapping.CSV"), "UTF-8");
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader2);
                    bufferedReader.readLine();
                    do {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            strArrSplit = line.split(",");
                        } else {
                            try {
                                inputStreamReader2.close();
                                r3 = bufferedReader;
                            } catch (IOException e3) {
                                e = e3;
                                sb = new StringBuilder();
                                sb.append("finally getAreaCode : ");
                                sb.append(e);
                                VLog.e("BBKCalculator/ExchangeUtils", sb.toString());
                                return BuildConfig.FLAVOR;
                            }
                        }
                        return BuildConfig.FLAVOR;
                    } while (!str2.equals(strArrSplit[1]));
                    String str3 = strArrSplit[2];
                    VLog.d("BBKCalculator/ExchangeUtils", "getAreaCode code = " + str3 + ", str[2] ： " + strArrSplit[2]);
                    try {
                        inputStreamReader2.close();
                    } catch (IOException e4) {
                        VLog.e("BBKCalculator/ExchangeUtils", "finally getAreaCode : " + e4);
                    }
                    return str3;
                } catch (IOException e5) {
                    e = e5;
                    inputStreamReader = inputStreamReader2;
                    VLog.e("BBKCalculator/ExchangeUtils", "getAreaCode : " + e);
                    r3 = inputStreamReader;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                            r3 = inputStreamReader;
                        } catch (IOException e6) {
                            e = e6;
                            sb = new StringBuilder();
                            sb.append("finally getAreaCode : ");
                            sb.append(e);
                            VLog.e("BBKCalculator/ExchangeUtils", sb.toString());
                            return BuildConfig.FLAVOR;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r3 = inputStreamReader2;
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e7) {
                            VLog.e("BBKCalculator/ExchangeUtils", "finally getAreaCode : " + e7);
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static String c() throws Throwable {
        String str = "N";
        String strB = g.b("ro.product.country.region", "N");
        VLog.d("BBKCalculator/ExchangeUtils", "getCountryCode countryCode = " + strB);
        if (!"N".equals(strB)) {
            if ("EEA".equals(strB) || "ENA".equals(strB) || "AFR".equals(strB) || "MDE".equals(strB) || "MEA".equals(strB) || "CSA".equals(strB) || "PSA".equals(strB) || "SCA".equals(strB)) {
                String strA = a(strB);
                if (!TextUtils.isEmpty(strA)) {
                    str = strA;
                } else if ("EEA".equals(strB) || "ENA".equals(strB)) {
                    strB = "DE";
                } else if ("AFR".equals(strB)) {
                    strB = "NG";
                } else if ("MDE".equals(strB)) {
                    strB = "SA";
                } else if ("MEA".equals(strB)) {
                    strB = "JO";
                } else if ("CSA".equals(strB)) {
                    strB = "UA";
                } else if ("PSA".equals(strB)) {
                    strB = "MM";
                } else if ("SCA".equals(strB)) {
                    strB = "CL";
                } else {
                    VLog.i("BBKCalculator/ExchangeUtils", "area code not in region country list ");
                }
            } else {
                VLog.i("BBKCalculator/ExchangeUtils", " not in region country list ");
            }
            str = strB;
        }
        VLog.d("BBKCalculator/ExchangeUtils", "return getCountryCode countryCode = " + str);
        return str;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return e(str).substring(0, 1);
    }

    public static String e(String str) {
        ArrayList<f.a> arrayListC = f.b().c(str);
        StringBuilder sb = new StringBuilder();
        if (arrayListC != null && arrayListC.size() > 0) {
            for (f.a aVar : arrayListC) {
                if (2 == aVar.f4780a) {
                    sb.append(aVar.f4782c);
                } else {
                    sb.append(aVar.f4781b);
                }
            }
        }
        return sb.toString().toUpperCase(Locale.getDefault());
    }

    public static void f(Context context, boolean z2, boolean z3) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("LOCAL_UP", z2);
        editorEdit.putBoolean("OTHER_UP", z3);
        editorEdit.commit();
    }

    public static void g(Context context, String str, String str2) {
        VLog.d("BBKCalculator/ExchangeUtils", " saveCurrencyName:  otherCurrency " + str + ", localCurrency" + str2);
        if (str2 == null || str == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString("other_currency", str);
        editorEdit.putString("local_currency", str2);
        editorEdit.commit();
    }

    public static void h(Context context, String str, String str2) {
        VLog.d("BBKCalculator/ExchangeUtils", "saveDefaultInput: " + str + " " + str2);
        if (context == null) {
            VLog.d("BBKCalculator/ExchangeUtils", "saveDefaultInput context null , return.");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString("default_other_exchange", str);
        editorEdit.putString("default_local_exchange", str2);
        editorEdit.apply();
    }

    public static void i(Context context, String str, String str2, String str3) {
        VLog.d("BBKCalculator/ExchangeUtils", "saveExchange: exchange = " + str + ", localExchange = " + str2 + ",otherExchange:" + str3);
        if (context == null) {
            VLog.d("BBKCalculator/ExchangeUtils", "saveExchange context null , return.");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString("exchange", str);
        editorEdit.putString("local_exchange", str2);
        editorEdit.putString("other_exchange", str3);
        editorEdit.commit();
    }

    public static void j(Context context, Boolean bool) {
        if (context == null) {
            VLog.d("BBKCalculator/ExchangeUtils", "saveInputType context null , return.");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("input_type", bool.booleanValue());
        editorEdit.apply();
    }

    public static void k(Context context, boolean z2) {
        if (context == null) {
            VLog.d("BBKCalculator/ExchangeUtils", "saveIsFocusAs context null , return.");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("focus", z2);
        editorEdit.apply();
    }

    public static void l(Context context, String str, String str2) {
        if (context == null) {
            VLog.d("BBKCalculator/ExchangeUtils", "saveLanguage context null , return.");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString("local_language", str);
        editorEdit.putString("local_country", str2);
        editorEdit.apply();
    }

    public static void m(Context context, boolean z2) {
        if (context == null) {
            VLog.d("BBKCalculator/ExchangeUtils", "savePageLabel context null , return.");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("is_calculator", z2);
        editorEdit.commit();
    }

    public static void n(Context context, String str, String str2) {
        if (context == null) {
            VLog.d("BBKCalculator/ExchangeUtils", "saveResource context null , return.");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString("resource_en", str2);
        editorEdit.putString("resource_cn", str);
        editorEdit.apply();
    }

    public static void o(Context context, long j3) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong("update_date", j3);
        editorEdit.commit();
    }

    public static void p(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        VLog.d("BBKCalculator/ExchangeUtils", " saveView:  otherCurrency: " + str5 + ",localCurrency: " + str6 + ",otherCode:" + str3 + ",localCode:" + str4);
        if (str6 == null || str5 == null || str3 == null || str4 == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString("other_country_code", str);
        editorEdit.putString("local_country_code", str2);
        editorEdit.putString("local_currency_code", str4);
        editorEdit.putString("other_currency_code", str3);
        editorEdit.putString("other_currency", str5);
        editorEdit.putString("local_currency", str6);
        editorEdit.putString("other_input", str7);
        editorEdit.putString("local_input", str8);
        editorEdit.commit();
    }
}
