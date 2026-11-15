package g2;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: DateUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4776a = "yyyy.MM.dd";

    public static String a(long j3) {
        return new SimpleDateFormat(f4776a, Locale.getDefault()).format(Long.valueOf(j3));
    }

    public static String b() {
        return new SimpleDateFormat(f4776a, Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
    }
}
