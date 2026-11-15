package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: PreferenceInflater.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Class<?>[] f1670e = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Constructor> f1671f = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f1673b = new Object[2];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f1674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f1675d;

    public e(Context context, f fVar) {
        this.f1672a = context;
        f(fVar);
    }

    private Preference a(String str, String[] strArr, AttributeSet attributeSet) throws InflateException, ClassNotFoundException {
        Class<?> clsLoadClass;
        Constructor<?> constructor = f1671f.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f1672a.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        clsLoadClass = classLoader.loadClass(str);
                    } else {
                        clsLoadClass = null;
                        ClassNotFoundException e3 = null;
                        for (String str2 : strArr) {
                            try {
                                clsLoadClass = classLoader.loadClass(str2 + str);
                                break;
                            } catch (ClassNotFoundException e4) {
                                e3 = e4;
                            }
                        }
                        if (clsLoadClass == null) {
                            if (e3 != null) {
                                throw e3;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                    }
                    constructor = clsLoadClass.getConstructor(f1670e);
                    constructor.setAccessible(true);
                    f1671f.put(str, constructor);
                } catch (Exception e5) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e5);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e6) {
                throw e6;
            }
        }
        Object[] objArr = this.f1673b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    private Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? g(str, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e3) {
            throw e3;
        } catch (ClassNotFoundException e4) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e4);
            throw inflateException;
        } catch (Exception e5) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e5);
            throw inflateException2;
        }
    }

    private void f(f fVar) {
        this.f1674c = fVar;
        j(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    private PreferenceGroup h(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.L(this.f1674c);
        return preferenceGroup2;
    }

    private void i(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.l0(Intent.parseIntent(c().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e3) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e3);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    c().getResources().parseBundleExtra("extra", attributeSet, preference.j());
                    try {
                        k(xmlPullParser);
                    } catch (IOException e4) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e4);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    ((PreferenceGroup) preference).z0(preferenceB);
                    i(xmlPullParser, preferenceB, attributeSet);
                }
            }
        }
    }

    private static void k(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    public Context c() {
        return this.f1672a;
    }

    public Preference d(int i3, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = c().getResources().getXml(i3);
        try {
            return e(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public Preference e(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup preferenceGroupH;
        synchronized (this.f1673b) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f1673b[0] = this.f1672a;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e3) {
                    throw e3;
                } catch (IOException e4) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e4.getMessage());
                    inflateException.initCause(e4);
                    throw inflateException;
                } catch (XmlPullParserException e5) {
                    InflateException inflateException2 = new InflateException(e5.getMessage());
                    inflateException2.initCause(e5);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroupH = h(preferenceGroup, (PreferenceGroup) b(xmlPullParser.getName(), attributeSetAsAttributeSet));
            i(xmlPullParser, preferenceGroupH, attributeSetAsAttributeSet);
        }
        return preferenceGroupH;
    }

    protected Preference g(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return a(str, this.f1675d, attributeSet);
    }

    public void j(String[] strArr) {
        this.f1675d = strArr;
    }
}
