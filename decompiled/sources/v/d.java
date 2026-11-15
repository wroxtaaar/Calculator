package v;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: GradientColorInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
final class d {
    private static a a(a aVar, int i3, int i4, boolean z2, int i5) {
        if (aVar != null) {
            return aVar;
        }
        return z2 ? new a(i3, i5, i4) : new a(i3, i4);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayS = g.s(resources, theme, attributeSet, s.c.GradientColor);
        float fJ = g.j(typedArrayS, xmlPullParser, "startX", s.c.GradientColor_android_startX, 0.0f);
        float fJ2 = g.j(typedArrayS, xmlPullParser, "startY", s.c.GradientColor_android_startY, 0.0f);
        float fJ3 = g.j(typedArrayS, xmlPullParser, "endX", s.c.GradientColor_android_endX, 0.0f);
        float fJ4 = g.j(typedArrayS, xmlPullParser, "endY", s.c.GradientColor_android_endY, 0.0f);
        float fJ5 = g.j(typedArrayS, xmlPullParser, "centerX", s.c.GradientColor_android_centerX, 0.0f);
        float fJ6 = g.j(typedArrayS, xmlPullParser, "centerY", s.c.GradientColor_android_centerY, 0.0f);
        int iK = g.k(typedArrayS, xmlPullParser, "type", s.c.GradientColor_android_type, 0);
        int iF = g.f(typedArrayS, xmlPullParser, "startColor", s.c.GradientColor_android_startColor, 0);
        boolean zR = g.r(xmlPullParser, "centerColor");
        int iF2 = g.f(typedArrayS, xmlPullParser, "centerColor", s.c.GradientColor_android_centerColor, 0);
        int iF3 = g.f(typedArrayS, xmlPullParser, "endColor", s.c.GradientColor_android_endColor, 0);
        int iK2 = g.k(typedArrayS, xmlPullParser, "tileMode", s.c.GradientColor_android_tileMode, 0);
        float fJ7 = g.j(typedArrayS, xmlPullParser, "gradientRadius", s.c.GradientColor_android_gradientRadius, 0.0f);
        typedArrayS.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zR, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.f6306a, aVarA.f6307b, d(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.f6306a, aVarA.f6307b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.f6306a, aVarA.f6307b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayS = g.s(resources, theme, attributeSet, s.c.GradientColorItem);
                int i3 = s.c.GradientColorItem_android_color;
                boolean zHasValue = typedArrayS.hasValue(i3);
                int i4 = s.c.GradientColorItem_android_offset;
                boolean zHasValue2 = typedArrayS.hasValue(i4);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayS.getColor(i3, 0);
                float f3 = typedArrayS.getFloat(i4, 0.0f);
                typedArrayS.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f3));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i3) {
        if (i3 != 1) {
            return i3 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: compiled from: GradientColorInflaterCompat.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f6306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f6307b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f6306a = new int[size];
            this.f6307b = new float[size];
            for (int i3 = 0; i3 < size; i3++) {
                this.f6306a[i3] = list.get(i3).intValue();
                this.f6307b[i3] = list2.get(i3).floatValue();
            }
        }

        a(int i3, int i4) {
            this.f6306a = new int[]{i3, i4};
            this.f6307b = new float[]{0.0f, 1.0f};
        }

        a(int i3, int i4, int i5) {
            this.f6306a = new int[]{i3, i4, i5};
            this.f6307b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
