package q1;

/* JADX INFO: compiled from: JavaVersion.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f5899a = a();

    private static int a() {
        return d(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c() {
        return f5899a;
    }

    static int d(String str) {
        int iF = f(str);
        if (iF == -1) {
            iF = b(str);
        }
        if (iF == -1) {
            return 6;
        }
        return iF;
    }

    public static boolean e() {
        return f5899a >= 9;
    }

    private static int f(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i3 = Integer.parseInt(strArrSplit[0]);
            return (i3 != 1 || strArrSplit.length <= 1) ? i3 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
