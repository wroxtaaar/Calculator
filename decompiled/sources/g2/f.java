package g2;

import android.icu.text.Transliterator;
import android.text.TextUtils;
import java.util.ArrayList;
import vivo.util.VLog;

/* JADX INFO: compiled from: HanziToPinyin.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f f4777c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Transliterator f4778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Transliterator f4779b;

    /* JADX INFO: compiled from: HanziToPinyin.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4782c;

        public a() {
        }

        public a(int i3, String str, String str2) {
            this.f4780a = i3;
            this.f4781b = str;
            this.f4782c = str2;
        }
    }

    private f() {
        try {
            this.f4778a = Transliterator.getInstance("Han-Latin/Names; Latin-Ascii; Any-Upper");
            this.f4779b = Transliterator.getInstance("Latin-Ascii");
        } catch (IllegalArgumentException unused) {
            VLog.w("HanziToPinyin", "Han-Latin/Names transliterator data is missing, HanziToPinyin is disabled");
        }
    }

    private void a(StringBuilder sb, ArrayList<a> arrayList, int i3) {
        String string = sb.toString();
        arrayList.add(new a(i3, string, string));
        sb.setLength(0);
    }

    public static f b() {
        f fVar;
        synchronized (f.class) {
            if (f4777c == null) {
                f4777c = new f();
            }
            fVar = f4777c;
        }
        return fVar;
    }

    private void e(char c3, a aVar) {
        String string = Character.toString(c3);
        aVar.f4781b = string;
        if (c3 < 128) {
            aVar.f4780a = 1;
            aVar.f4782c = string;
            return;
        }
        if (c3 < 592 || (7680 <= c3 && c3 < 7935)) {
            aVar.f4780a = 1;
            Transliterator transliterator = this.f4779b;
            if (transliterator != null) {
                string = transliterator.transliterate(string);
            }
            aVar.f4782c = string;
            return;
        }
        aVar.f4780a = 2;
        String strTransliterate = this.f4778a.transliterate(string);
        aVar.f4782c = strTransliterate;
        if (TextUtils.isEmpty(strTransliterate) || TextUtils.equals(aVar.f4781b, aVar.f4782c)) {
            aVar.f4780a = 3;
            aVar.f4782c = aVar.f4781b;
        }
    }

    public ArrayList<a> c(String str) {
        ArrayList<a> arrayList = new ArrayList<>();
        if (d() && !TextUtils.isEmpty(str)) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            a aVar = new a();
            int i3 = 1;
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = str.charAt(i4);
                if (!Character.isSpaceChar(cCharAt)) {
                    e(cCharAt, aVar);
                    int i5 = aVar.f4780a;
                    if (i5 == 2) {
                        if (sb.length() > 0) {
                            a(sb, arrayList, i3);
                        }
                        arrayList.add(aVar);
                        aVar = new a();
                    } else {
                        if (i3 != i5 && sb.length() > 0) {
                            a(sb, arrayList, i3);
                        }
                        sb.append(aVar.f4782c);
                    }
                    i3 = aVar.f4780a;
                } else if (sb.length() > 0) {
                    a(sb, arrayList, i3);
                }
            }
            if (sb.length() > 0) {
                a(sb, arrayList, i3);
            }
        }
        return arrayList;
    }

    public boolean d() {
        return this.f4778a != null;
    }
}
