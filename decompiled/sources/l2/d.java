package l2;

import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/* JADX INFO: compiled from: HttpHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static String a(Map<String, String> map, boolean z2, boolean z3) throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList(map.keySet());
        if (z2) {
            Collections.sort(arrayList);
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String strEncode = (String) arrayList.get(i3);
            String strEncode2 = map.get(strEncode);
            if (!TextUtils.isEmpty(strEncode)) {
                strEncode = URLEncoder.encode(strEncode, "utf-8");
            }
            if (!TextUtils.isEmpty(strEncode2)) {
                strEncode2 = URLEncoder.encode(strEncode2, "utf-8");
            }
            if (i3 == arrayList.size() - 1) {
                sb.append(strEncode);
                sb.append("=");
                sb.append(strEncode2);
            } else {
                sb.append(strEncode);
                sb.append("=");
                sb.append(strEncode2);
                sb.append("&");
            }
        }
        String string = sb.toString();
        return z3 ? URLEncoder.encode(string, "utf-8") : string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    public static Map<String, String> b(String str) throws Throwable {
        Scanner scanner;
        String[] strArrSplit;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.isEmpty(str)) {
            return linkedHashMap;
        }
        Scanner scanner2 = 0;
        String str2 = (str.contains("?") && (strArrSplit = str.split("[?]")) != null && 2 == strArrSplit.length) ? strArrSplit[1] : null;
        ?? IsEmpty = TextUtils.isEmpty(str2);
        try {
            if (IsEmpty != 0) {
                return linkedHashMap;
            }
            try {
                scanner = new Scanner(str2);
                try {
                    scanner.useDelimiter("&");
                    while (scanner.hasNext()) {
                        String[] strArrSplit2 = scanner.next().split("=", 2);
                        if (strArrSplit2.length > 2) {
                            throw new SecurityKeyException("bad parameter", 1000);
                        }
                        String str3 = strArrSplit2[0];
                        String str4 = strArrSplit2.length == 1 ? BuildConfig.FLAVOR : strArrSplit2[1];
                        if (linkedHashMap.containsKey(str3)) {
                            throw new SecurityKeyException("contain same key", 1000);
                        }
                        linkedHashMap.put(str3, str4);
                    }
                    scanner.close();
                    return linkedHashMap;
                } catch (Exception e3) {
                    e = e3;
                    i.k("SecurityKey", "parseRequestParam" + e.getMessage());
                    if (scanner != null) {
                        scanner.close();
                    }
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                scanner = null;
            } catch (Throwable th) {
                th = th;
                if (scanner2 != 0) {
                    scanner2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            scanner2 = IsEmpty;
        }
    }

    public static Map<String, String> c(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (str2 != null && !str2.equals(BuildConfig.FLAVOR) && !str.equalsIgnoreCase("jvq_sign")) {
                    map2.put(str, str2);
                }
            }
        }
        return map2;
    }
}
