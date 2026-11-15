package o1;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements o1.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f5411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f5412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f5413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f5414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f5415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f5416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ c[] f5417h;

    /* JADX INFO: compiled from: FieldNamingPolicy.java */
    final enum a extends c {
        a(String str, int i3) {
            super(str, i3, null);
        }

        @Override // o1.d
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f5411b = aVar;
        c cVar = new c("UPPER_CAMEL_CASE", 1) { // from class: o1.c.b
            {
                a aVar2 = null;
            }

            @Override // o1.d
            public String a(Field field) {
                return c.c(field.getName());
            }
        };
        f5412c = cVar;
        c cVar2 = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: o1.c.c
            {
                a aVar2 = null;
            }

            @Override // o1.d
            public String a(Field field) {
                return c.c(c.b(field.getName(), " "));
            }
        };
        f5413d = cVar2;
        c cVar3 = new c("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: o1.c.d
            {
                a aVar2 = null;
            }

            @Override // o1.d
            public String a(Field field) {
                return c.b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        f5414e = cVar3;
        c cVar4 = new c("LOWER_CASE_WITH_DASHES", 4) { // from class: o1.c.e
            {
                a aVar2 = null;
            }

            @Override // o1.d
            public String a(Field field) {
                return c.b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        f5415f = cVar4;
        c cVar5 = new c("LOWER_CASE_WITH_DOTS", 5) { // from class: o1.c.f
            {
                a aVar2 = null;
            }

            @Override // o1.d
            public String a(Field field) {
                return c.b(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        f5416g = cVar5;
        f5417h = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5};
    }

    private c(String str, int i3) {
        super(str, i3);
    }

    static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String c(String str) {
        int length = str.length() - 1;
        int i3 = 0;
        while (!Character.isLetter(str.charAt(i3)) && i3 < length) {
            i3++;
        }
        char cCharAt = str.charAt(i3);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i3 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i3) + upperCase + str.substring(i3 + 1);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f5417h.clone();
    }

    /* synthetic */ c(String str, int i3, a aVar) {
        this(str, i3);
    }
}
