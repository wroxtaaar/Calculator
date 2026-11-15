package v;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: FontResourcesParserCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public interface a {
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0092c[] f6295a;

        public b(C0092c[] c0092cArr) {
            this.f6295a = c0092cArr;
        }

        public C0092c[] a() {
            return this.f6295a;
        }
    }

    /* JADX INFO: renamed from: v.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class C0092c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f6299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f6300e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f6301f;

        public C0092c(String str, int i3, boolean z2, String str2, int i4, int i5) {
            this.f6296a = str;
            this.f6297b = i3;
            this.f6298c = z2;
            this.f6299d = str2;
            this.f6300e = i4;
            this.f6301f = i5;
        }

        public String a() {
            return this.f6296a;
        }

        public int b() {
            return this.f6301f;
        }

        public int c() {
            return this.f6300e;
        }

        public String d() {
            return this.f6299d;
        }

        public int e() {
            return this.f6297b;
        }

        public boolean f() {
            return this.f6298c;
        }
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b0.d f6302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f6305d;

        public d(b0.d dVar, int i3, int i4, String str) {
            this.f6302a = dVar;
            this.f6304c = i3;
            this.f6303b = i4;
            this.f6305d = str;
        }

        public int a() {
            return this.f6304c;
        }

        public b0.d b() {
            return this.f6302a;
        }

        public String c() {
            return this.f6305d;
        }

        public int d() {
            return this.f6303b;
        }
    }

    private static int a(TypedArray typedArray, int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i3);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i3, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i3) {
        if (i3 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i3);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i4 = 0; i4 < typedArrayObtainTypedArray.length(); i4++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i3)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), s.c.FontFamily);
        String string = typedArrayObtainAttributes.getString(s.c.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(s.c.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(s.c.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(s.c.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(s.c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(s.c.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = typedArrayObtainAttributes.getString(s.c.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new b0.d(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0092c[]) arrayList.toArray(new C0092c[arrayList.size()]));
    }

    private static C0092c f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), s.c.FontFamilyFont);
        int i3 = s.c.FontFamilyFont_fontWeight;
        if (!typedArrayObtainAttributes.hasValue(i3)) {
            i3 = s.c.FontFamilyFont_android_fontWeight;
        }
        int i4 = typedArrayObtainAttributes.getInt(i3, 400);
        int i5 = s.c.FontFamilyFont_fontStyle;
        if (!typedArrayObtainAttributes.hasValue(i5)) {
            i5 = s.c.FontFamilyFont_android_fontStyle;
        }
        boolean z2 = 1 == typedArrayObtainAttributes.getInt(i5, 0);
        int i6 = s.c.FontFamilyFont_ttcIndex;
        if (!typedArrayObtainAttributes.hasValue(i6)) {
            i6 = s.c.FontFamilyFont_android_ttcIndex;
        }
        int i7 = s.c.FontFamilyFont_fontVariationSettings;
        if (!typedArrayObtainAttributes.hasValue(i7)) {
            i7 = s.c.FontFamilyFont_android_fontVariationSettings;
        }
        String string = typedArrayObtainAttributes.getString(i7);
        int i8 = typedArrayObtainAttributes.getInt(i6, 0);
        int i9 = s.c.FontFamilyFont_font;
        if (!typedArrayObtainAttributes.hasValue(i9)) {
            i9 = s.c.FontFamilyFont_android_font;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i9, 0);
        String string2 = typedArrayObtainAttributes.getString(i9);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0092c(string2, i4, z2, string, i8, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i3 = 1;
        while (i3 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i3++;
            } else if (next == 3) {
                i3--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
