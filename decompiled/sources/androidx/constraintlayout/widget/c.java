package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintLayoutStates.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f977b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f978c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SparseArray<a> f979d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray<d> f980e = new SparseArray<>();

    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<b> f982b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f983c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d f984d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f983c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == i.State_android_id) {
                    this.f981a = typedArrayObtainStyledAttributes.getResourceId(index, this.f981a);
                } else if (index == i.State_constraints) {
                    this.f983c = typedArrayObtainStyledAttributes.getResourceId(index, this.f983c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f983c);
                    context.getResources().getResourceName(this.f983c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f984d = dVar;
                        dVar.f(context, this.f983c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f982b.add(bVar);
        }
    }

    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f989e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        d f990f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f985a = Float.NaN;
            this.f986b = Float.NaN;
            this.f987c = Float.NaN;
            this.f988d = Float.NaN;
            this.f989e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == i.Variant_constraints) {
                    this.f989e = typedArrayObtainStyledAttributes.getResourceId(index, this.f989e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f989e);
                    context.getResources().getResourceName(this.f989e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f990f = dVar;
                        dVar.f(context, this.f989e);
                    }
                } else if (index == i.Variant_region_heightLessThan) {
                    this.f988d = typedArrayObtainStyledAttributes.getDimension(index, this.f988d);
                } else if (index == i.Variant_region_heightMoreThan) {
                    this.f986b = typedArrayObtainStyledAttributes.getDimension(index, this.f986b);
                } else if (index == i.Variant_region_widthLessThan) {
                    this.f987c = typedArrayObtainStyledAttributes.getDimension(index, this.f987c);
                } else if (index == i.Variant_region_widthMoreThan) {
                    this.f985a = typedArrayObtainStyledAttributes.getDimension(index, this.f985a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    c(Context context, ConstraintLayout constraintLayout, int i3) {
        this.f976a = constraintLayout;
        a(context, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    byte b3 = -1;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b3 = 4;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                b3 = 2;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b3 = 1;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                b3 = 0;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b3 = 3;
                            }
                            break;
                    }
                    if (b3 != 0 && b3 != 1) {
                        if (b3 == 2) {
                            aVar = new a(context, xml);
                            this.f979d.put(aVar.f981a, aVar);
                        } else if (b3 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        } else if (b3 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            b(context, xml);
                        }
                    }
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            if ("id".equals(xmlPullParser.getAttributeName(i3))) {
                String attributeValue = xmlPullParser.getAttributeValue(i3);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.n(context, xmlPullParser);
                this.f980e.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(f fVar) {
    }
}
