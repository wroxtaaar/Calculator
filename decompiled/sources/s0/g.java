package s0;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import r0.v;

/* JADX INFO: compiled from: HttpHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    static String a(long j3) {
        return b().format(new Date(j3));
    }

    private static SimpleDateFormat b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static r0.b.a c(r0.k kVar) {
        boolean z2;
        long j3;
        long j4;
        long j5;
        long j6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = kVar.f6009c;
        String str = map.get("Date");
        long jE = str != null ? e(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i3 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            int i4 = 0;
            j3 = 0;
            j4 = 0;
            while (i3 < strArrSplit.length) {
                String strTrim = strArrSplit[i3].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j4 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i4 = 1;
                }
                i3++;
            }
            i3 = i4;
            z2 = true;
        } else {
            z2 = false;
            j3 = 0;
            j4 = 0;
        }
        String str3 = map.get("Expires");
        long jE2 = str3 != null ? e(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jE3 = str4 != null ? e(str4) : 0L;
        String str5 = map.get("ETag");
        if (z2) {
            j6 = jCurrentTimeMillis + (j3 * 1000);
            j5 = i3 != 0 ? j6 : (j4 * 1000) + j6;
        } else {
            j5 = 0;
            if (jE <= 0 || jE2 < jE) {
                j6 = 0;
            } else {
                j6 = jCurrentTimeMillis + (jE2 - jE);
                j5 = j6;
            }
        }
        r0.b.a aVar = new r0.b.a();
        aVar.f5971a = kVar.f6008b;
        aVar.f5972b = str5;
        aVar.f5976f = j6;
        aVar.f5975e = j5;
        aVar.f5973c = jE;
        aVar.f5974d = jE3;
        aVar.f5977g = map;
        aVar.f5978h = kVar.f6010d;
        return aVar;
    }

    public static String d(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i3 = 1; i3 < strArrSplit.length; i3++) {
                String[] strArrSplit2 = strArrSplit[i3].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long e(String str) {
        try {
            return b().parse(str).getTime();
        } catch (ParseException e3) {
            v.d(e3, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static List<r0.g> f(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new r0.g(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    static Map<String, String> g(List<r0.g> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (r0.g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }
}
