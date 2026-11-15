package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourceManagerInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static m0 f689i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, l.h<ColorStateList>> f691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l.g<String, d> f692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l.h<String> f693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakHashMap<Context, l.d<WeakReference<Drawable.ConstantState>>> f694d = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f688h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final c f690j = new c(6);

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.m0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return d.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e3);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.m0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e3);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class c extends l.e<Integer, PorterDuffColorFilter> {
        public c(int i3) {
            super(i3);
        }

        private static int h(int i3, PorterDuff.Mode mode) {
            return ((i3 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i3, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(i3, mode)));
        }

        PorterDuffColorFilter j(int i3, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(h(i3, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    interface e {
        Drawable a(m0 m0Var, Context context, int i3);

        boolean b(Context context, int i3, Drawable drawable);

        ColorStateList c(Context context, int i3);

        boolean d(Context context, int i3, Drawable drawable);

        PorterDuff.Mode e(int i3);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class f implements d {
        f() {
        }

        @Override // androidx.appcompat.widget.m0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.h.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e3);
                return null;
            }
        }
    }

    private void a(String str, d dVar) {
        if (this.f692b == null) {
            this.f692b = new l.g<>();
        }
        this.f692b.put(str, dVar);
    }

    private synchronized boolean b(Context context, long j3, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        l.d<WeakReference<Drawable.ConstantState>> dVar = this.f694d.get(context);
        if (dVar == null) {
            dVar = new l.d<>();
            this.f694d.put(context, dVar);
        }
        dVar.i(j3, new WeakReference<>(constantState));
        return true;
    }

    private void c(Context context, int i3, ColorStateList colorStateList) {
        if (this.f691a == null) {
            this.f691a = new WeakHashMap<>();
        }
        l.h<ColorStateList> hVar = this.f691a.get(context);
        if (hVar == null) {
            hVar = new l.h<>();
            this.f691a.put(context, hVar);
        }
        hVar.a(i3, colorStateList);
    }

    private void d(Context context) {
        if (this.f696f) {
            return;
        }
        this.f696f = true;
        Drawable drawableJ = j(context, e.a.abc_vector_test);
        if (drawableJ == null || !q(drawableJ)) {
            this.f696f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(Context context, int i3) {
        if (this.f695e == null) {
            this.f695e = new TypedValue();
        }
        TypedValue typedValue = this.f695e;
        context.getResources().getValue(i3, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        e eVar = this.f697g;
        Drawable drawableA = eVar == null ? null : eVar.a(this, context, i3);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableA);
        }
        return drawableA;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized m0 h() {
        if (f689i == null) {
            m0 m0Var = new m0();
            f689i = m0Var;
            p(m0Var);
        }
        return f689i;
    }

    private synchronized Drawable i(Context context, long j3) {
        l.d<WeakReference<Drawable.ConstantState>> dVar = this.f694d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceE = dVar.e(j3);
        if (weakReferenceE != null) {
            Drawable.ConstantState constantState = weakReferenceE.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.j(j3);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        c cVar = f690j;
        porterDuffColorFilterI = cVar.i(i3, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i3, mode);
            cVar.j(i3, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList n(Context context, int i3) {
        l.h<ColorStateList> hVar;
        WeakHashMap<Context, l.h<ColorStateList>> weakHashMap = this.f691a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.e(i3);
    }

    private static void p(m0 m0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            m0Var.a("vector", new f());
            m0Var.a("animated-vector", new b());
            m0Var.a("animated-selector", new a());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.h) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i3) {
        int next;
        l.g<String, d> gVar = this.f692b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        l.h<String> hVar = this.f693c;
        if (hVar != null) {
            String strE = hVar.e(i3);
            if ("appcompat_skip_skip".equals(strE) || (strE != null && this.f692b.get(strE) == null)) {
                return null;
            }
        } else {
            this.f693c = new l.h<>();
        }
        if (this.f695e == null) {
            this.f695e = new TypedValue();
        }
        TypedValue typedValue = this.f695e;
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
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
                this.f693c.a(i3, name);
                d dVar = this.f692b.get(name);
                if (dVar != null) {
                    drawableI = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e3) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e3);
            }
        }
        if (drawableI == null) {
            this.f693c.a(i3, "appcompat_skip_skip");
        }
        return drawableI;
    }

    private Drawable v(Context context, int i3, boolean z2, Drawable drawable) {
        ColorStateList colorStateListM = m(context, i3);
        if (colorStateListM == null) {
            e eVar = this.f697g;
            if ((eVar == null || !eVar.d(context, i3, drawable)) && !x(context, i3, drawable) && z2) {
                return null;
            }
            return drawable;
        }
        if (e0.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableR = x.a.r(drawable);
        x.a.o(drawableR, colorStateListM);
        PorterDuff.Mode modeO = o(i3);
        if (modeO == null) {
            return drawableR;
        }
        x.a.p(drawableR, modeO);
        return drawableR;
    }

    static void w(Drawable drawable, u0 u0Var, int[] iArr) {
        if (e0.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z2 = u0Var.f782d;
        if (z2 || u0Var.f781c) {
            drawable.setColorFilter(g(z2 ? u0Var.f779a : null, u0Var.f781c ? u0Var.f780b : f688h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i3) {
        return k(context, i3, false);
    }

    synchronized Drawable k(Context context, int i3, boolean z2) {
        Drawable drawableR;
        d(context);
        drawableR = r(context, i3);
        if (drawableR == null) {
            drawableR = f(context, i3);
        }
        if (drawableR == null) {
            drawableR = u.a.d(context, i3);
        }
        if (drawableR != null) {
            drawableR = v(context, i3, z2, drawableR);
        }
        if (drawableR != null) {
            e0.b(drawableR);
        }
        return drawableR;
    }

    synchronized ColorStateList m(Context context, int i3) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i3);
        if (colorStateListN == null) {
            e eVar = this.f697g;
            colorStateListN = eVar == null ? null : eVar.c(context, i3);
            if (colorStateListN != null) {
                c(context, i3, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i3) {
        e eVar = this.f697g;
        if (eVar == null) {
            return null;
        }
        return eVar.e(i3);
    }

    public synchronized void s(Context context) {
        l.d<WeakReference<Drawable.ConstantState>> dVar = this.f694d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    synchronized Drawable t(Context context, b1 b1Var, int i3) {
        Drawable drawableR = r(context, i3);
        if (drawableR == null) {
            drawableR = b1Var.c(i3);
        }
        if (drawableR == null) {
            return null;
        }
        return v(context, i3, false, drawableR);
    }

    public synchronized void u(e eVar) {
        this.f697g = eVar;
    }

    boolean x(Context context, int i3, Drawable drawable) {
        e eVar = this.f697g;
        return eVar != null && eVar.b(context, i3, drawable);
    }
}
