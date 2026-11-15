package z1;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.vivo.seckeysdk.BuildConfig;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vivo.util.VLog;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(String str, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        int i5 = i3;
        while (i5 < i4 && (str.charAt(i5) == '-' || str.charAt(i5) == ' ')) {
            i5++;
        }
        sb.append((CharSequence) str, i3, i5);
        while (i5 < i4) {
            sb.append(str.charAt(i5));
            i5++;
            if ((i4 - i5) % 3 == 0 && i4 != i5) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public static CharSequence b(CharSequence charSequence, CharSequence charSequence2, char c3) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= length2 || charSequence2.charAt(i3) != c3) {
                    while (i4 < length && charSequence.charAt(i4) == c3) {
                        i4++;
                    }
                    if (i3 == length2) {
                        while (i4 < length && charSequence.charAt(i4) == c3) {
                            i4++;
                        }
                        return charSequence.subSequence(i4, length);
                    }
                    if (i4 != length && charSequence.charAt(i4) == charSequence2.charAt(i3)) {
                        i3++;
                        i4++;
                    }
                } else {
                    i3++;
                }
            }
        }
        return null;
    }

    public static SpannableString c(int i3, String str) {
        VLog.d("BBKCalculator/StringUtils", "matcherSearchText: text " + str);
        if (TextUtils.isEmpty(str)) {
            return SpannableString.valueOf(BuildConfig.FLAVOR);
        }
        String str2 = str.length() == 1 ? "[+−×÷]" : "\\d[−]|\\)[−]|\\%[−]|\\.[−]|[+×÷]";
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(str2).matcher(new SpannableString(str.toLowerCase(Locale.getDefault())));
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            int i4 = iEnd - 1;
            if (iStart < i4) {
                iStart = i4;
            }
            spannableString.setSpan(new ForegroundColorSpan(i3), iStart, iEnd, 33);
        }
        return spannableString;
    }

    public static String d(String str) {
        VLog.d("BBKCalculator/StringUtils", "regulateClipData:  " + str);
        String strReplaceAll = str.replaceAll("\\*", "×").replaceAll("/", "÷").replaceAll("（", "(").replaceAll("）", ")").replaceAll("，", ",");
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        while (i3 < strReplaceAll.length()) {
            int i4 = i3 + 1;
            String strSubstring = strReplaceAll.substring(i3, i4);
            if ("E".equals(strSubstring)) {
                stringBuffer.append(strSubstring);
            } else {
                stringBuffer.append(strSubstring.toLowerCase(Locale.getDefault()));
            }
            i3 = i4;
        }
        return stringBuffer.toString();
    }

    public static String e(char c3, int i3) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(c3);
        }
        return sb.toString();
    }
}
