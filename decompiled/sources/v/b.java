package v;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ComplexColorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shader f6292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f6293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6294c;

    private b(Shader shader, ColorStateList colorStateList, int i3) {
        this.f6292a = shader;
        this.f6293b = colorStateList;
        this.f6294c = i3;
    }

    private static b a(Resources resources, int i3, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i3);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(d.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(a.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static b b(int i3) {
        return new b(null, null, i3);
    }

    static b c(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    static b d(Shader shader) {
        return new b(shader, null, 0);
    }

    public static b g(Resources resources, int i3, Resources.Theme theme) {
        try {
            return a(resources, i3, theme);
        } catch (Exception e3) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e3);
            return null;
        }
    }

    public int e() {
        return this.f6294c;
    }

    public Shader f() {
        return this.f6292a;
    }

    public boolean h() {
        return this.f6292a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f6292a == null && (colorStateList = this.f6293b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f6293b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f6294c) {
                this.f6294c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i3) {
        this.f6294c = i3;
    }

    public boolean l() {
        return h() || this.f6294c != 0;
    }
}
