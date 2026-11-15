package g;

import a.j;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.w0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: SupportMenuInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Class<?>[] f4709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Class<?>[] f4710f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object[] f4711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f4712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f4713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f4714d;

    /* JADX INFO: compiled from: SupportMenuInflater.java */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Class<?>[] f4715c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f4716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f4717b;

        public a(Object obj, String str) {
            this.f4716a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f4717b = cls.getMethod(str, f4715c);
            } catch (Exception e3) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e3);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f4717b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f4717b.invoke(this.f4716a, menuItem)).booleanValue();
                }
                this.f4717b.invoke(this.f4716a, menuItem);
                return true;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    /* JADX INFO: compiled from: SupportMenuInflater.java */
    private class b {
        e0.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Menu f4718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4721d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4722e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4723f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f4724g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f4725h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f4726i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f4727j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CharSequence f4728k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private CharSequence f4729l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f4730m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private char f4731n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f4732o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private char f4733p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f4734q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f4735r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f4736s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f4737t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f4738u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f4739v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f4740w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private String f4741x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f4742y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private String f4743z;

        public b(Menu menu) {
            this.f4718a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f4713c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e3) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e3);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.f4736s).setVisible(this.f4737t).setEnabled(this.f4738u).setCheckable(this.f4735r >= 1).setTitleCondensed(this.f4729l).setIcon(this.f4730m);
            int i3 = this.f4739v;
            if (i3 >= 0) {
                menuItem.setShowAsAction(i3);
            }
            if (this.f4743z != null) {
                if (g.this.f4713c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f4743z));
            }
            if (this.f4735r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof h.c) {
                    ((h.c) menuItem).h(true);
                }
            }
            String str = this.f4741x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f4709e, g.this.f4711a));
                z2 = true;
            }
            int i4 = this.f4740w;
            if (i4 > 0) {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i4);
                }
            }
            e0.b bVar = this.A;
            if (bVar != null) {
                e0.h.a(menuItem, bVar);
            }
            e0.h.c(menuItem, this.B);
            e0.h.g(menuItem, this.C);
            e0.h.b(menuItem, this.f4731n, this.f4732o);
            e0.h.f(menuItem, this.f4733p, this.f4734q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                e0.h.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                e0.h.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f4725h = true;
            i(this.f4718a.add(this.f4719b, this.f4726i, this.f4727j, this.f4728k));
        }

        public SubMenu b() {
            this.f4725h = true;
            SubMenu subMenuAddSubMenu = this.f4718a.addSubMenu(this.f4719b, this.f4726i, this.f4727j, this.f4728k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f4725h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f4713c.obtainStyledAttributes(attributeSet, j.MenuGroup);
            this.f4719b = typedArrayObtainStyledAttributes.getResourceId(j.MenuGroup_android_id, 0);
            this.f4720c = typedArrayObtainStyledAttributes.getInt(j.MenuGroup_android_menuCategory, 0);
            this.f4721d = typedArrayObtainStyledAttributes.getInt(j.MenuGroup_android_orderInCategory, 0);
            this.f4722e = typedArrayObtainStyledAttributes.getInt(j.MenuGroup_android_checkableBehavior, 0);
            this.f4723f = typedArrayObtainStyledAttributes.getBoolean(j.MenuGroup_android_visible, true);
            this.f4724g = typedArrayObtainStyledAttributes.getBoolean(j.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            w0 w0VarU = w0.u(g.this.f4713c, attributeSet, j.MenuItem);
            this.f4726i = w0VarU.n(j.MenuItem_android_id, 0);
            this.f4727j = (w0VarU.k(j.MenuItem_android_menuCategory, this.f4720c) & (-65536)) | (w0VarU.k(j.MenuItem_android_orderInCategory, this.f4721d) & 65535);
            this.f4728k = w0VarU.p(j.MenuItem_android_title);
            this.f4729l = w0VarU.p(j.MenuItem_android_titleCondensed);
            this.f4730m = w0VarU.n(j.MenuItem_android_icon, 0);
            this.f4731n = c(w0VarU.o(j.MenuItem_android_alphabeticShortcut));
            this.f4732o = w0VarU.k(j.MenuItem_alphabeticModifiers, 4096);
            this.f4733p = c(w0VarU.o(j.MenuItem_android_numericShortcut));
            this.f4734q = w0VarU.k(j.MenuItem_numericModifiers, 4096);
            int i3 = j.MenuItem_android_checkable;
            if (w0VarU.s(i3)) {
                this.f4735r = w0VarU.a(i3, false) ? 1 : 0;
            } else {
                this.f4735r = this.f4722e;
            }
            this.f4736s = w0VarU.a(j.MenuItem_android_checked, false);
            this.f4737t = w0VarU.a(j.MenuItem_android_visible, this.f4723f);
            this.f4738u = w0VarU.a(j.MenuItem_android_enabled, this.f4724g);
            this.f4739v = w0VarU.k(j.MenuItem_showAsAction, -1);
            this.f4743z = w0VarU.o(j.MenuItem_android_onClick);
            this.f4740w = w0VarU.n(j.MenuItem_actionLayout, 0);
            this.f4741x = w0VarU.o(j.MenuItem_actionViewClass);
            String strO = w0VarU.o(j.MenuItem_actionProviderClass);
            this.f4742y = strO;
            boolean z2 = strO != null;
            if (z2 && this.f4740w == 0 && this.f4741x == null) {
                this.A = (e0.b) e(strO, g.f4710f, g.this.f4712b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = w0VarU.p(j.MenuItem_contentDescription);
            this.C = w0VarU.p(j.MenuItem_tooltipText);
            int i4 = j.MenuItem_iconTintMode;
            if (w0VarU.s(i4)) {
                this.E = e0.e(w0VarU.k(i4, -1), this.E);
            } else {
                this.E = null;
            }
            int i5 = j.MenuItem_iconTint;
            if (w0VarU.s(i5)) {
                this.D = w0VarU.c(i5);
            } else {
                this.D = null;
            }
            w0VarU.w();
            this.f4725h = false;
        }

        public void h() {
            this.f4719b = 0;
            this.f4720c = 0;
            this.f4721d = 0;
            this.f4722e = 0;
            this.f4723f = true;
            this.f4724g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f4709e = clsArr;
        f4710f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f4713c = context;
        Object[] objArr = {context};
        this.f4711a = objArr;
        this.f4712b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z3 && name2.equals(str)) {
                        str = null;
                        z3 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            e0.b bVar2 = bVar.A;
                            if (bVar2 == null || !bVar2.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z2 = true;
                    }
                }
            } else if (!z3) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z3 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f4714d == null) {
            this.f4714d = a(this.f4713c);
        }
        return this.f4714d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i3, Menu menu) {
        if (!(menu instanceof y.a)) {
            super.inflate(i3, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f4713c.getResources().getLayout(i3);
                    c(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (IOException e3) {
                    throw new InflateException("Error inflating menu XML", e3);
                }
            } catch (XmlPullParserException e4) {
                throw new InflateException("Error inflating menu XML", e4);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
