package c0;

import android.text.SpannableStringBuilder;
import com.vivo.seckeysdk.BuildConfig;
import java.util.Locale;

/* JADX INFO: compiled from: BidiFormatter.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final d f2446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final a f2449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final a f2450h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f2453c;

    /* JADX INFO: renamed from: c0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidiFormatter.java */
    public static final class C0031a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f2456c;

        public C0031a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z2) {
            return z2 ? a.f2450h : a.f2449g;
        }

        private void c(boolean z2) {
            this.f2454a = z2;
            this.f2456c = a.f2446d;
            this.f2455b = 2;
        }

        public a a() {
            return (this.f2455b == 2 && this.f2456c == a.f2446d) ? b(this.f2454a) : new a(this.f2454a, this.f2455b, this.f2456c);
        }
    }

    /* JADX INFO: compiled from: BidiFormatter.java */
    private static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f2457f = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f2458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f2459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private char f2462e;

        static {
            for (int i3 = 0; i3 < 1792; i3++) {
                f2457f[i3] = Character.getDirectionality(i3);
            }
        }

        b(CharSequence charSequence, boolean z2) {
            this.f2458a = charSequence;
            this.f2459b = z2;
            this.f2460c = charSequence.length();
        }

        private static byte c(char c3) {
            return c3 < 1792 ? f2457f[c3] : Character.getDirectionality(c3);
        }

        private byte f() {
            char cCharAt;
            int i3 = this.f2461d;
            do {
                int i4 = this.f2461d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2458a;
                int i5 = i4 - 1;
                this.f2461d = i5;
                cCharAt = charSequence.charAt(i5);
                this.f2462e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f2461d = i3;
            this.f2462e = ';';
            return (byte) 13;
        }

        private byte g() {
            char cCharAt;
            do {
                int i3 = this.f2461d;
                if (i3 >= this.f2460c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f2458a;
                this.f2461d = i3 + 1;
                cCharAt = charSequence.charAt(i3);
                this.f2462e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char cCharAt;
            int i3 = this.f2461d;
            while (true) {
                int i4 = this.f2461d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2458a;
                int i5 = i4 - 1;
                this.f2461d = i5;
                char cCharAt2 = charSequence.charAt(i5);
                this.f2462e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i6 = this.f2461d;
                        if (i6 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f2458a;
                        int i7 = i6 - 1;
                        this.f2461d = i7;
                        cCharAt = charSequence2.charAt(i7);
                        this.f2462e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f2461d = i3;
            this.f2462e = '>';
            return (byte) 13;
        }

        private byte i() {
            char cCharAt;
            int i3 = this.f2461d;
            while (true) {
                int i4 = this.f2461d;
                if (i4 >= this.f2460c) {
                    this.f2461d = i3;
                    this.f2462e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f2458a;
                this.f2461d = i4 + 1;
                char cCharAt2 = charSequence.charAt(i4);
                this.f2462e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i5 = this.f2461d;
                        if (i5 >= this.f2460c) {
                            break;
                        }
                        CharSequence charSequence2 = this.f2458a;
                        this.f2461d = i5 + 1;
                        cCharAt = charSequence2.charAt(i5);
                        this.f2462e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.f2458a.charAt(this.f2461d - 1);
            this.f2462e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f2458a, this.f2461d);
                this.f2461d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f2461d--;
            byte bC = c(this.f2462e);
            if (!this.f2459b) {
                return bC;
            }
            char c3 = this.f2462e;
            if (c3 == '>') {
                return h();
            }
            return c3 == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.f2458a.charAt(this.f2461d);
            this.f2462e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f2458a, this.f2461d);
                this.f2461d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f2461d++;
            byte bC = c(this.f2462e);
            if (!this.f2459b) {
                return bC;
            }
            char c3 = this.f2462e;
            if (c3 == '<') {
                return i();
            }
            return c3 == '&' ? g() : bC;
        }

        int d() {
            this.f2461d = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (this.f2461d < this.f2460c && i3 == 0) {
                byte b3 = b();
                if (b3 != 0) {
                    if (b3 == 1 || b3 == 2) {
                        if (i5 == 0) {
                            return 1;
                        }
                    } else if (b3 != 9) {
                        switch (b3) {
                            case 14:
                            case 15:
                                i5++;
                                i4 = -1;
                                continue;
                            case 16:
                            case 17:
                                i5++;
                                i4 = 1;
                                continue;
                            case 18:
                                i5--;
                                i4 = 0;
                                continue;
                        }
                    }
                } else if (i5 == 0) {
                    return -1;
                }
                i3 = i5;
            }
            if (i3 == 0) {
                return 0;
            }
            if (i4 != 0) {
                return i4;
            }
            while (this.f2461d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i3 == i5) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i3 == i5) {
                            return 1;
                        }
                        break;
                    case 18:
                        i5++;
                        continue;
                    default:
                        continue;
                }
                i5--;
            }
            return 0;
        }

        int e() {
            this.f2461d = this.f2460c;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                while (this.f2461d > 0) {
                    byte bA = a();
                    if (bA == 0) {
                        if (i3 == 0) {
                            return -1;
                        }
                        if (i4 == 0) {
                        }
                    } else if (bA == 1 || bA == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                        if (i4 == 0) {
                        }
                    } else if (bA != 9) {
                        switch (bA) {
                            case 14:
                            case 15:
                                if (i4 == i3) {
                                    return -1;
                                }
                                i3--;
                                break;
                            case 16:
                            case 17:
                                if (i4 == i3) {
                                    return 1;
                                }
                                i3--;
                                break;
                            case 18:
                                i3++;
                                break;
                            default:
                                if (i4 != 0) {
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        }
    }

    static {
        d dVar = e.f2480c;
        f2446d = dVar;
        f2447e = Character.toString((char) 8206);
        f2448f = Character.toString((char) 8207);
        f2449g = new a(false, 2, dVar);
        f2450h = new a(true, 2, dVar);
    }

    a(boolean z2, int i3, d dVar) {
        this.f2451a = z2;
        this.f2452b = i3;
        this.f2453c = dVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0031a().a();
    }

    static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    private String f(CharSequence charSequence, d dVar) {
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f2451a && (zA || b(charSequence) == 1)) {
            return f2447e;
        }
        if (this.f2451a) {
            return (!zA || b(charSequence) == -1) ? f2448f : BuildConfig.FLAVOR;
        }
        return BuildConfig.FLAVOR;
    }

    private String g(CharSequence charSequence, d dVar) {
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f2451a && (zA || a(charSequence) == 1)) {
            return f2447e;
        }
        if (this.f2451a) {
            return (!zA || a(charSequence) == -1) ? f2448f : BuildConfig.FLAVOR;
        }
        return BuildConfig.FLAVOR;
    }

    public boolean d() {
        return (this.f2452b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f2453c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z2) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z2) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? e.f2479b : e.f2478a));
        }
        if (zA != this.f2451a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z2) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? e.f2479b : e.f2478a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f2453c, true);
    }

    public String k(String str, d dVar, boolean z2) {
        if (str == null) {
            return null;
        }
        return i(str, dVar, z2).toString();
    }
}
