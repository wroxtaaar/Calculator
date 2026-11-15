package b;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.w0;
import e0.x;
import e0.z;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class e extends b.d implements androidx.appcompat.view.menu.e.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final l.g<String, Integer> f2235b0 = new l.g<>();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final boolean f2236c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final int[] f2237d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final boolean f2238e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final boolean f2239f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static boolean f2240g0;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private s[] H;
    private s I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    boolean N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private l S;
    private l T;
    boolean U;
    int V;
    private final Runnable W;
    private boolean X;
    private Rect Y;
    private Rect Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private b.g f2241a0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Object f2242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Context f2243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Window f2244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f2245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final b.c f2246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    b.a f2247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    MenuInflater f2248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CharSequence f2249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private c0 f2250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private h f2251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private t f2252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    g.b f2253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ActionBarContextView f2254q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    PopupWindow f2255r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Runnable f2256s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    x f2257t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2258u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f2259v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    ViewGroup f2260w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f2261x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View f2262y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f2263z;

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f2264a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f2264a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f2264a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f2264a.uncaughtException(thread, notFoundException);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if ((eVar.V & 1) != 0) {
                eVar.U(0);
            }
            e eVar2 = e.this;
            if ((eVar2.V & 4096) != 0) {
                eVar2.U(108);
            }
            e eVar3 = e.this;
            eVar3.U = false;
            eVar3.V = 0;
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class c implements e0.p {
        c() {
        }

        @Override // e0.p
        public e0.c0 a(View view, e0.c0 c0Var) {
            int iK = c0Var.k();
            int iL0 = e.this.L0(c0Var, null);
            if (iK != iL0) {
                c0Var = c0Var.o(c0Var.i(), iL0, c0Var.j(), c0Var.h());
            }
            return e0.t.Z(view, c0Var);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class d implements g0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.g0.a
        public void a(Rect rect) {
            rect.top = e.this.L0(null, rect);
        }
    }

    /* JADX INFO: renamed from: b.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class C0025e implements ContentFrameLayout.a {
        C0025e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            e.this.S();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class f implements Runnable {

        /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
        class a extends z {
            a() {
            }

            @Override // e0.y
            public void a(View view) {
                e.this.f2254q.setAlpha(1.0f);
                e.this.f2257t.f(null);
                e.this.f2257t = null;
            }

            @Override // e0.z, e0.y
            public void b(View view) {
                e.this.f2254q.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f2255r.showAtLocation(eVar.f2254q, 55, 0, 0);
            e.this.V();
            if (!e.this.D0()) {
                e.this.f2254q.setAlpha(1.0f);
                e.this.f2254q.setVisibility(0);
            } else {
                e.this.f2254q.setAlpha(0.0f);
                e eVar2 = e.this;
                eVar2.f2257t = e0.t.d(eVar2.f2254q).a(1.0f);
                e.this.f2257t.f(new a());
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class g extends z {
        g() {
        }

        @Override // e0.y
        public void a(View view) {
            e.this.f2254q.setAlpha(1.0f);
            e.this.f2257t.f(null);
            e.this.f2257t = null;
        }

        @Override // e0.z, e0.y
        public void b(View view) {
            e.this.f2254q.setVisibility(0);
            e.this.f2254q.sendAccessibilityEvent(32);
            if (e.this.f2254q.getParent() instanceof View) {
                e0.t.j0((View) e.this.f2254q.getParent());
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private final class h implements androidx.appcompat.view.menu.j.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z2) {
            e.this.L(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackF0 = e.this.f0();
            if (callbackF0 == null) {
                return true;
            }
            callbackF0.onMenuOpened(108, eVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class i implements g.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g.b.a f2273a;

        /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
        class a extends z {
            a() {
            }

            @Override // e0.y
            public void a(View view) {
                e.this.f2254q.setVisibility(8);
                e eVar = e.this;
                PopupWindow popupWindow = eVar.f2255r;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (eVar.f2254q.getParent() instanceof View) {
                    e0.t.j0((View) e.this.f2254q.getParent());
                }
                e.this.f2254q.removeAllViews();
                e.this.f2257t.f(null);
                e eVar2 = e.this;
                eVar2.f2257t = null;
                e0.t.j0(eVar2.f2260w);
            }
        }

        public i(g.b.a aVar) {
            this.f2273a = aVar;
        }

        @Override // g.b.a
        public boolean a(g.b bVar, Menu menu) {
            e0.t.j0(e.this.f2260w);
            return this.f2273a.a(bVar, menu);
        }

        @Override // g.b.a
        public boolean b(g.b bVar, Menu menu) {
            return this.f2273a.b(bVar, menu);
        }

        @Override // g.b.a
        public void c(g.b bVar) {
            this.f2273a.c(bVar);
            e eVar = e.this;
            if (eVar.f2255r != null) {
                eVar.f2244g.getDecorView().removeCallbacks(e.this.f2256s);
            }
            e eVar2 = e.this;
            if (eVar2.f2254q != null) {
                eVar2.V();
                e eVar3 = e.this;
                eVar3.f2257t = e0.t.d(eVar3.f2254q).a(0.0f);
                e.this.f2257t.f(new a());
            }
            e eVar4 = e.this;
            b.c cVar = eVar4.f2246i;
            if (cVar != null) {
                cVar.e(eVar4.f2253p);
            }
            e eVar5 = e.this;
            eVar5.f2253p = null;
            e0.t.j0(eVar5.f2260w);
        }

        @Override // g.b.a
        public boolean d(g.b bVar, MenuItem menuItem) {
            return this.f2273a.d(bVar, menuItem);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private class k extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f2277c;

        k(Context context) {
            super();
            this.f2277c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // b.e.l
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // b.e.l
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !this.f2277c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // b.e.l
        public void d() {
            e.this.F();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f2279a;

        /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                l.this.d();
            }
        }

        l() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f2279a;
            if (broadcastReceiver != null) {
                try {
                    e.this.f2243f.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f2279a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f2279a == null) {
                this.f2279a = new a();
            }
            e.this.f2243f.registerReceiver(this.f2279a, intentFilterB);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private class m extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b.j f2282c;

        m(b.j jVar) {
            super();
            this.f2282c = jVar;
        }

        @Override // b.e.l
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // b.e.l
        public int c() {
            return this.f2282c.d() ? 2 : 1;
        }

        @Override // b.e.l
        public void d() {
            e.this.F();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i3 = configuration.densityDpi;
            int i4 = configuration2.densityDpi;
            if (i3 != i4) {
                configuration3.densityDpi = i4;
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    static class p {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i3 = configuration.colorMode & 3;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 3)) {
                configuration3.colorMode |= i4 & 3;
            }
            int i5 = configuration.colorMode & 12;
            int i6 = configuration2.colorMode;
            if (i5 != (i6 & 12)) {
                configuration3.colorMode |= i6 & 12;
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private static class q {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        private boolean c(int i3, int i4) {
            return i3 < -5 || i4 < -5 || i3 > getWidth() + 5 || i4 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            e.this.N(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i3) {
            setBackgroundDrawable(c.a.d(getContext(), i3));
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    protected static final class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2289e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2290f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f2291g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        View f2292h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        View f2293i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.e f2294j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.c f2295k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Context f2296l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f2297m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f2298n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f2299o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f2300p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f2301q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f2302r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Bundle f2303s;

        s(int i3) {
            this.f2285a = i3;
        }

        androidx.appcompat.view.menu.k a(androidx.appcompat.view.menu.j.a aVar) {
            if (this.f2294j == null) {
                return null;
            }
            if (this.f2295k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f2296l, a.g.abc_list_menu_item_layout);
                this.f2295k = cVar;
                cVar.h(aVar);
                this.f2294j.b(this.f2295k);
            }
            return this.f2295k.c(this.f2291g);
        }

        public boolean b() {
            if (this.f2292h == null) {
                return false;
            }
            return this.f2293i != null || this.f2295k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f2294j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.O(this.f2295k);
            }
            this.f2294j = eVar;
            if (eVar == null || (cVar = this.f2295k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(a.a.actionBarPopupTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                themeNewTheme.applyStyle(i3, true);
            }
            themeNewTheme.resolveAttribute(a.a.panelMenuListTheme, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                themeNewTheme.applyStyle(i4, true);
            } else {
                themeNewTheme.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
            }
            g.d dVar = new g.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f2296l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(a.j.AppCompatTheme);
            this.f2286b = typedArrayObtainStyledAttributes.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f2290f = typedArrayObtainStyledAttributes.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private final class t implements androidx.appcompat.view.menu.j.a {
        t() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z2) {
            androidx.appcompat.view.menu.e eVarD = eVar.D();
            boolean z3 = eVarD != eVar;
            e eVar2 = e.this;
            if (z3) {
                eVar = eVarD;
            }
            s sVarY = eVar2.Y(eVar);
            if (sVarY != null) {
                if (!z3) {
                    e.this.O(sVarY, z2);
                } else {
                    e.this.K(sVarY.f2285a, sVarY, eVarD);
                    e.this.O(sVarY, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackF0;
            if (eVar != eVar.D()) {
                return true;
            }
            e eVar2 = e.this;
            if (!eVar2.B || (callbackF0 = eVar2.f0()) == null || e.this.N) {
                return true;
            }
            callbackF0.onMenuOpened(108, eVar);
            return true;
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        boolean z2 = i3 < 21;
        f2236c0 = z2;
        f2237d0 = new int[]{R.attr.windowBackground};
        f2238e0 = !"robolectric".equals(Build.FINGERPRINT);
        f2239f0 = i3 >= 17;
        if (!z2 || f2240g0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        f2240g0 = true;
    }

    e(Activity activity, b.c cVar) {
        this(activity, null, cVar, activity);
    }

    private boolean A0(s sVar, KeyEvent keyEvent) {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        if (this.N) {
            return false;
        }
        if (sVar.f2297m) {
            return true;
        }
        s sVar2 = this.I;
        if (sVar2 != null && sVar2 != sVar) {
            O(sVar2, false);
        }
        Window.Callback callbackF0 = f0();
        if (callbackF0 != null) {
            sVar.f2293i = callbackF0.onCreatePanelView(sVar.f2285a);
        }
        int i3 = sVar.f2285a;
        boolean z2 = i3 == 0 || i3 == 108;
        if (z2 && (c0Var3 = this.f2250m) != null) {
            c0Var3.f();
        }
        if (sVar.f2293i == null) {
            if (z2) {
                y0();
            }
            androidx.appcompat.view.menu.e eVar = sVar.f2294j;
            if (eVar == null || sVar.f2302r) {
                if (eVar == null && (!j0(sVar) || sVar.f2294j == null)) {
                    return false;
                }
                if (z2 && this.f2250m != null) {
                    if (this.f2251n == null) {
                        this.f2251n = new h();
                    }
                    this.f2250m.a(sVar.f2294j, this.f2251n);
                }
                sVar.f2294j.d0();
                if (!callbackF0.onCreatePanelMenu(sVar.f2285a, sVar.f2294j)) {
                    sVar.c(null);
                    if (z2 && (c0Var = this.f2250m) != null) {
                        c0Var.a(null, this.f2251n);
                    }
                    return false;
                }
                sVar.f2302r = false;
            }
            sVar.f2294j.d0();
            Bundle bundle = sVar.f2303s;
            if (bundle != null) {
                sVar.f2294j.P(bundle);
                sVar.f2303s = null;
            }
            if (!callbackF0.onPreparePanel(0, sVar.f2293i, sVar.f2294j)) {
                if (z2 && (c0Var2 = this.f2250m) != null) {
                    c0Var2.a(null, this.f2251n);
                }
                sVar.f2294j.c0();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            sVar.f2300p = z3;
            sVar.f2294j.setQwertyMode(z3);
            sVar.f2294j.c0();
        }
        sVar.f2297m = true;
        sVar.f2298n = false;
        this.I = sVar;
        return true;
    }

    private void B0(boolean z2) {
        c0 c0Var = this.f2250m;
        if (c0Var == null || !c0Var.g() || (ViewConfiguration.get(this.f2243f).hasPermanentMenuKey() && !this.f2250m.b())) {
            s sVarD0 = d0(0, true);
            sVarD0.f2301q = true;
            O(sVarD0, false);
            x0(sVarD0, null);
            return;
        }
        Window.Callback callbackF0 = f0();
        if (this.f2250m.c() && z2) {
            this.f2250m.d();
            if (this.N) {
                return;
            }
            callbackF0.onPanelClosed(108, d0(0, true).f2294j);
            return;
        }
        if (callbackF0 == null || this.N) {
            return;
        }
        if (this.U && (this.V & 1) != 0) {
            this.f2244g.getDecorView().removeCallbacks(this.W);
            this.W.run();
        }
        s sVarD1 = d0(0, true);
        androidx.appcompat.view.menu.e eVar = sVarD1.f2294j;
        if (eVar == null || sVarD1.f2302r || !callbackF0.onPreparePanel(0, sVarD1.f2293i, eVar)) {
            return;
        }
        callbackF0.onMenuOpened(108, sVarD1.f2294j);
        this.f2250m.e();
    }

    private int C0(int i3) {
        if (i3 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i3 != 9) {
            return i3;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean E0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f2244g.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || e0.t.R((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean G(boolean z2) {
        if (this.N) {
            return false;
        }
        int iJ = J();
        boolean zJ0 = J0(n0(this.f2243f, iJ), z2);
        if (iJ == 0) {
            c0(this.f2243f).e();
        } else {
            l lVar = this.S;
            if (lVar != null) {
                lVar.a();
            }
        }
        if (iJ == 3) {
            b0(this.f2243f).e();
        } else {
            l lVar2 = this.T;
            if (lVar2 != null) {
                lVar2.a();
            }
        }
        return zJ0;
    }

    private void H() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f2260w.findViewById(R.id.content);
        View decorView = this.f2244g.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f2243f.obtainStyledAttributes(a.j.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i3 = a.j.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMajor());
        }
        int i4 = a.j.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedWidthMinor());
        }
        int i5 = a.j.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMajor());
        }
        int i6 = a.j.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            typedArrayObtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void H0() {
        if (this.f2259v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void I(Window window) {
        if (this.f2244g != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof j) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        j jVar = new j(callback);
        this.f2245h = jVar;
        window.setCallback(jVar);
        w0 w0VarU = w0.u(this.f2243f, null, f2237d0);
        Drawable drawableH = w0VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        w0VarU.w();
        this.f2244g = window;
    }

    private b.b I0() {
        for (Context baseContext = this.f2243f; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof b.b) {
                return (b.b) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private int J() {
        int i3 = this.O;
        return i3 != -100 ? i3 : b.d.j();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    private boolean J0(int i3, boolean z2) {
        boolean z3;
        Configuration configurationP = P(this.f2243f, i3, null);
        boolean zL0 = l0();
        int i4 = this.f2243f.getResources().getConfiguration().uiMode & 48;
        int i5 = configurationP.uiMode & 48;
        boolean z4 = true;
        if (i4 != i5 && z2 && !zL0 && this.K && (f2238e0 || this.L)) {
            Object obj = this.f2242e;
            if (!(obj instanceof Activity) || ((Activity) obj).isChild()) {
                z3 = false;
            } else {
                t.a.h((Activity) this.f2242e);
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3 || i4 == i5) {
            z4 = z3;
        } else {
            K0(i5, zL0, null);
        }
        if (z4) {
            Object obj2 = this.f2242e;
            if (obj2 instanceof b.b) {
                ((b.b) obj2).y(i3);
            }
        }
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K0(int i3, boolean z2, Configuration configuration) {
        Resources resources = this.f2243f.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i3 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 26) {
            b.h.a(resources);
        }
        int i5 = this.P;
        if (i5 != 0) {
            this.f2243f.setTheme(i5);
            if (i4 >= 23) {
                this.f2243f.getTheme().applyStyle(this.P, true);
            }
        }
        if (z2) {
            Object obj = this.f2242e;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.g) {
                    if (((androidx.lifecycle.g) activity).b().b().a(androidx.lifecycle.d.b.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.M) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void M() {
        l lVar = this.S;
        if (lVar != null) {
            lVar.a();
        }
        l lVar2 = this.T;
        if (lVar2 != null) {
            lVar2.a();
        }
    }

    private void M0(View view) {
        view.setBackgroundColor((e0.t.K(view) & 8192) != 0 ? u.a.b(this.f2243f, a.c.abc_decor_view_status_guard_light) : u.a.b(this.f2243f, a.c.abc_decor_view_status_guard));
    }

    private Configuration P(Context context, int i3, Configuration configuration) {
        int i4;
        if (i3 != 1) {
            i4 = i3 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i4 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup Q() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f2243f.obtainStyledAttributes(a.j.AppCompatTheme);
        int i3 = a.j.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
            z(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i3, false)) {
            z(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            z(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            z(10);
        }
        this.E = typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        X();
        this.f2244g.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2243f);
        if (this.F) {
            viewGroup = this.D ? (ViewGroup) layoutInflaterFrom.inflate(a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(a.g.abc_screen_simple, (ViewGroup) null);
        } else if (this.E) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(a.g.abc_dialog_title_material, (ViewGroup) null);
            this.C = false;
            this.B = false;
        } else if (this.B) {
            TypedValue typedValue = new TypedValue();
            this.f2243f.getTheme().resolveAttribute(a.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new g.d(this.f2243f, typedValue.resourceId) : this.f2243f).inflate(a.g.abc_screen_toolbar, (ViewGroup) null);
            c0 c0Var = (c0) viewGroup.findViewById(a.f.decor_content_parent);
            this.f2250m = c0Var;
            c0Var.setWindowCallback(f0());
            if (this.C) {
                this.f2250m.k(109);
            }
            if (this.f2263z) {
                this.f2250m.k(2);
            }
            if (this.A) {
                this.f2250m.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            e0.t.x0(viewGroup, new c());
        } else if (viewGroup instanceof g0) {
            ((g0) viewGroup).setOnFitSystemWindowsListener(new d());
        }
        if (this.f2250m == null) {
            this.f2261x = (TextView) viewGroup.findViewById(a.f.title);
        }
        c1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f2244g.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f2244g.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C0025e());
        return viewGroup;
    }

    private void W() {
        if (this.f2259v) {
            return;
        }
        this.f2260w = Q();
        CharSequence charSequenceE0 = e0();
        if (!TextUtils.isEmpty(charSequenceE0)) {
            c0 c0Var = this.f2250m;
            if (c0Var != null) {
                c0Var.setWindowTitle(charSequenceE0);
            } else if (y0() != null) {
                y0().w(charSequenceE0);
            } else {
                TextView textView = this.f2261x;
                if (textView != null) {
                    textView.setText(charSequenceE0);
                }
            }
        }
        H();
        w0(this.f2260w);
        this.f2259v = true;
        s sVarD0 = d0(0, false);
        if (this.N) {
            return;
        }
        if (sVarD0 == null || sVarD0.f2294j == null) {
            k0(108);
        }
    }

    private void X() {
        if (this.f2244g == null) {
            Object obj = this.f2242e;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.f2244g == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration Z(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f3 = configuration.fontScale;
            float f4 = configuration2.fontScale;
            if (f3 != f4) {
                configuration3.fontScale = f4;
            }
            int i3 = configuration.mcc;
            int i4 = configuration2.mcc;
            if (i3 != i4) {
                configuration3.mcc = i4;
            }
            int i5 = configuration.mnc;
            int i6 = configuration2.mnc;
            if (i5 != i6) {
                configuration3.mnc = i6;
            }
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 24) {
                o.a(configuration, configuration2, configuration3);
            } else if (!d0.d.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i8 = configuration.touchscreen;
            int i9 = configuration2.touchscreen;
            if (i8 != i9) {
                configuration3.touchscreen = i9;
            }
            int i10 = configuration.keyboard;
            int i11 = configuration2.keyboard;
            if (i10 != i11) {
                configuration3.keyboard = i11;
            }
            int i12 = configuration.keyboardHidden;
            int i13 = configuration2.keyboardHidden;
            if (i12 != i13) {
                configuration3.keyboardHidden = i13;
            }
            int i14 = configuration.navigation;
            int i15 = configuration2.navigation;
            if (i14 != i15) {
                configuration3.navigation = i15;
            }
            int i16 = configuration.navigationHidden;
            int i17 = configuration2.navigationHidden;
            if (i16 != i17) {
                configuration3.navigationHidden = i17;
            }
            int i18 = configuration.orientation;
            int i19 = configuration2.orientation;
            if (i18 != i19) {
                configuration3.orientation = i19;
            }
            int i20 = configuration.screenLayout & 15;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 15)) {
                configuration3.screenLayout |= i21 & 15;
            }
            int i22 = configuration.screenLayout & 192;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 192)) {
                configuration3.screenLayout |= i23 & 192;
            }
            int i24 = configuration.screenLayout & 48;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 48)) {
                configuration3.screenLayout |= i25 & 48;
            }
            int i26 = configuration.screenLayout & 768;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & 768)) {
                configuration3.screenLayout |= i27 & 768;
            }
            if (i7 >= 26) {
                p.a(configuration, configuration2, configuration3);
            }
            int i28 = configuration.uiMode & 15;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 15)) {
                configuration3.uiMode |= i29 & 15;
            }
            int i30 = configuration.uiMode & 48;
            int i31 = configuration2.uiMode;
            if (i30 != (i31 & 48)) {
                configuration3.uiMode |= i31 & 48;
            }
            int i32 = configuration.screenWidthDp;
            int i33 = configuration2.screenWidthDp;
            if (i32 != i33) {
                configuration3.screenWidthDp = i33;
            }
            int i34 = configuration.screenHeightDp;
            int i35 = configuration2.screenHeightDp;
            if (i34 != i35) {
                configuration3.screenHeightDp = i35;
            }
            int i36 = configuration.smallestScreenWidthDp;
            int i37 = configuration2.smallestScreenWidthDp;
            if (i36 != i37) {
                configuration3.smallestScreenWidthDp = i37;
            }
            if (i7 >= 17) {
                n.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private l b0(Context context) {
        if (this.T == null) {
            this.T = new k(context);
        }
        return this.T;
    }

    private l c0(Context context) {
        if (this.S == null) {
            this.S = new m(b.j.a(context));
        }
        return this.S;
    }

    private void g0() {
        W();
        if (this.B && this.f2247j == null) {
            Object obj = this.f2242e;
            if (obj instanceof Activity) {
                this.f2247j = new b.k((Activity) this.f2242e, this.C);
            } else if (obj instanceof Dialog) {
                this.f2247j = new b.k((Dialog) this.f2242e);
            }
            b.a aVar = this.f2247j;
            if (aVar != null) {
                aVar.r(this.X);
            }
        }
    }

    private boolean h0(s sVar) {
        View view = sVar.f2293i;
        if (view != null) {
            sVar.f2292h = view;
            return true;
        }
        if (sVar.f2294j == null) {
            return false;
        }
        if (this.f2252o == null) {
            this.f2252o = new t();
        }
        View view2 = (View) sVar.a(this.f2252o);
        sVar.f2292h = view2;
        return view2 != null;
    }

    private boolean i0(s sVar) {
        sVar.d(a0());
        sVar.f2291g = new r(sVar.f2296l);
        sVar.f2287c = 81;
        return true;
    }

    private boolean j0(s sVar) {
        Context context = this.f2243f;
        int i3 = sVar.f2285a;
        if ((i3 == 0 || i3 == 108) && this.f2250m != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.a.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                g.d dVar = new g.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.R(this);
        sVar.c(eVar);
        return true;
    }

    private void k0(int i3) {
        this.V = (1 << i3) | this.V;
        if (this.U) {
            return;
        }
        e0.t.e0(this.f2244g.getDecorView(), this.W);
        this.U = true;
    }

    private boolean l0() {
        int i3;
        if (!this.R && (this.f2242e instanceof Activity)) {
            PackageManager packageManager = this.f2243f.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 29) {
                    i3 = 269221888;
                } else {
                    i3 = i4 >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f2243f, this.f2242e.getClass()), i3);
                this.Q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e3);
                this.Q = false;
            }
        }
        this.R = true;
        return this.Q;
    }

    private boolean q0(int i3, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        s sVarD0 = d0(i3, true);
        if (sVarD0.f2299o) {
            return false;
        }
        return A0(sVarD0, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    private boolean t0(int i3, KeyEvent keyEvent) {
        boolean zA0;
        c0 c0Var;
        if (this.f2253p != null) {
            return false;
        }
        boolean zD = true;
        s sVarD0 = d0(i3, true);
        if (i3 != 0 || (c0Var = this.f2250m) == null || !c0Var.g() || ViewConfiguration.get(this.f2243f).hasPermanentMenuKey()) {
            boolean z2 = sVarD0.f2299o;
            if (z2 || sVarD0.f2298n) {
                O(sVarD0, true);
                zD = z2;
            } else if (sVarD0.f2297m) {
                if (sVarD0.f2302r) {
                    sVarD0.f2297m = false;
                    zA0 = A0(sVarD0, keyEvent);
                } else {
                    zA0 = true;
                }
                if (zA0) {
                    x0(sVarD0, keyEvent);
                } else {
                    zD = false;
                }
            } else {
                zD = false;
            }
        } else if (this.f2250m.c()) {
            zD = this.f2250m.d();
        } else if (this.N || !A0(sVarD0, keyEvent)) {
            zD = false;
        } else {
            zD = this.f2250m.e();
        }
        if (zD) {
            AudioManager audioManager = (AudioManager) this.f2243f.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zD;
    }

    private void x0(s sVar, KeyEvent keyEvent) {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        if (sVar.f2299o || this.N) {
            return;
        }
        if (sVar.f2285a == 0) {
            if ((this.f2243f.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackF0 = f0();
        if (callbackF0 != null && !callbackF0.onMenuOpened(sVar.f2285a, sVar.f2294j)) {
            O(sVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2243f.getSystemService("window");
        if (windowManager != null && A0(sVar, keyEvent)) {
            ViewGroup viewGroup = sVar.f2291g;
            if (viewGroup != null && !sVar.f2301q) {
                View view = sVar.f2293i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i3 = -1;
                }
                sVar.f2298n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i3, -2, sVar.f2288d, sVar.f2289e, 1002, 8519680, -3);
                layoutParams2.gravity = sVar.f2287c;
                layoutParams2.windowAnimations = sVar.f2290f;
                windowManager.addView(sVar.f2291g, layoutParams2);
                sVar.f2299o = true;
            }
            if (viewGroup == null) {
                if (!i0(sVar) || sVar.f2291g == null) {
                    return;
                }
            } else if (sVar.f2301q && viewGroup.getChildCount() > 0) {
                sVar.f2291g.removeAllViews();
            }
            if (!h0(sVar) || !sVar.b()) {
                sVar.f2301q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = sVar.f2292h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            sVar.f2291g.setBackgroundResource(sVar.f2286b);
            ViewParent parent = sVar.f2292h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(sVar.f2292h);
            }
            sVar.f2291g.addView(sVar.f2292h, layoutParams3);
            if (!sVar.f2292h.hasFocus()) {
                sVar.f2292h.requestFocus();
            }
            i3 = -2;
            sVar.f2298n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i3, -2, sVar.f2288d, sVar.f2289e, 1002, 8519680, -3);
            layoutParams4.gravity = sVar.f2287c;
            layoutParams4.windowAnimations = sVar.f2290f;
            windowManager.addView(sVar.f2291g, layoutParams4);
            sVar.f2299o = true;
        }
    }

    private boolean z0(s sVar, int i3, KeyEvent keyEvent, int i4) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((sVar.f2297m || A0(sVar, keyEvent)) && (eVar = sVar.f2294j) != null) {
            zPerformShortcut = eVar.performShortcut(i3, keyEvent, i4);
        }
        if (zPerformShortcut && (i4 & 1) == 0 && this.f2250m == null) {
            O(sVar, true);
        }
        return zPerformShortcut;
    }

    @Override // b.d
    public void A(int i3) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.f2260w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2243f).inflate(i3, viewGroup);
        this.f2245h.a().onContentChanged();
    }

    @Override // b.d
    public void B(View view) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.f2260w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2245h.a().onContentChanged();
    }

    @Override // b.d
    public void C(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.f2260w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2245h.a().onContentChanged();
    }

    @Override // b.d
    public void D(int i3) {
        this.P = i3;
    }

    final boolean D0() {
        ViewGroup viewGroup;
        return this.f2259v && (viewGroup = this.f2260w) != null && e0.t.S(viewGroup);
    }

    @Override // b.d
    public final void E(CharSequence charSequence) {
        this.f2249l = charSequence;
        c0 c0Var = this.f2250m;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        if (y0() != null) {
            y0().w(charSequence);
            return;
        }
        TextView textView = this.f2261x;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean F() {
        return G(true);
    }

    public g.b F0(g.b.a aVar) {
        b.c cVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        g.b bVar = this.f2253p;
        if (bVar != null) {
            bVar.c();
        }
        i iVar = new i(aVar);
        b.a aVarM = m();
        if (aVarM != null) {
            g.b bVarX = aVarM.x(iVar);
            this.f2253p = bVarX;
            if (bVarX != null && (cVar = this.f2246i) != null) {
                cVar.j(bVarX);
            }
        }
        if (this.f2253p == null) {
            this.f2253p = G0(iVar);
        }
        return this.f2253p;
    }

    g.b G0(g.b.a aVar) {
        g.b bVarH;
        Context dVar;
        b.c cVar;
        V();
        g.b bVar = this.f2253p;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof i)) {
            aVar = new i(aVar);
        }
        b.c cVar2 = this.f2246i;
        if (cVar2 == null || this.N) {
            bVarH = null;
        } else {
            try {
                bVarH = cVar2.h(aVar);
            } catch (AbstractMethodError unused) {
                bVarH = null;
            }
        }
        if (bVarH != null) {
            this.f2253p = bVarH;
        } else {
            if (this.f2254q == null) {
                if (this.E) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f2243f.getTheme();
                    theme.resolveAttribute(a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f2243f.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new g.d(this.f2243f, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f2243f;
                    }
                    this.f2254q = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, a.a.actionModePopupWindowStyle);
                    this.f2255r = popupWindow;
                    androidx.core.widget.h.b(popupWindow, 2);
                    this.f2255r.setContentView(this.f2254q);
                    this.f2255r.setWidth(-1);
                    dVar.getTheme().resolveAttribute(a.a.actionBarSize, typedValue, true);
                    this.f2254q.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f2255r.setHeight(-2);
                    this.f2256s = new f();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f2260w.findViewById(a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(a0()));
                        this.f2254q = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f2254q != null) {
                V();
                this.f2254q.k();
                g.e eVar = new g.e(this.f2254q.getContext(), this.f2254q, aVar, this.f2255r == null);
                if (aVar.b(eVar, eVar.e())) {
                    eVar.k();
                    this.f2254q.h(eVar);
                    this.f2253p = eVar;
                    if (D0()) {
                        this.f2254q.setAlpha(0.0f);
                        x xVarA = e0.t.d(this.f2254q).a(1.0f);
                        this.f2257t = xVarA;
                        xVarA.f(new g());
                    } else {
                        this.f2254q.setAlpha(1.0f);
                        this.f2254q.setVisibility(0);
                        this.f2254q.sendAccessibilityEvent(32);
                        if (this.f2254q.getParent() instanceof View) {
                            e0.t.j0((View) this.f2254q.getParent());
                        }
                    }
                    if (this.f2255r != null) {
                        this.f2244g.getDecorView().post(this.f2256s);
                    }
                } else {
                    this.f2253p = null;
                }
            }
        }
        g.b bVar2 = this.f2253p;
        if (bVar2 != null && (cVar = this.f2246i) != null) {
            cVar.j(bVar2);
        }
        return this.f2253p;
    }

    void K(int i3, s sVar, Menu menu) {
        if (menu == null) {
            if (sVar == null && i3 >= 0) {
                s[] sVarArr = this.H;
                if (i3 < sVarArr.length) {
                    sVar = sVarArr[i3];
                }
            }
            if (sVar != null) {
                menu = sVar.f2294j;
            }
        }
        if ((sVar == null || sVar.f2299o) && !this.N) {
            this.f2245h.a().onPanelClosed(i3, menu);
        }
    }

    void L(androidx.appcompat.view.menu.e eVar) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.f2250m.l();
        Window.Callback callbackF0 = f0();
        if (callbackF0 != null && !this.N) {
            callbackF0.onPanelClosed(108, eVar);
        }
        this.G = false;
    }

    final int L0(e0.c0 c0Var, Rect rect) {
        int iK;
        boolean z2;
        boolean z3;
        if (c0Var != null) {
            iK = c0Var.k();
        } else {
            iK = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.f2254q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2254q.getLayoutParams();
            boolean z4 = true;
            if (this.f2254q.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect2 = this.Y;
                Rect rect3 = this.Z;
                if (c0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(c0Var.i(), c0Var.k(), c0Var.j(), c0Var.h());
                }
                c1.a(this.f2260w, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                e0.c0 c0VarH = e0.t.H(this.f2260w);
                int i6 = c0VarH == null ? 0 : c0VarH.i();
                int iJ = c0VarH == null ? 0 : c0VarH.j();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z3 = true;
                }
                if (i3 <= 0 || this.f2262y != null) {
                    View view = this.f2262y;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i7 = marginLayoutParams2.height;
                        int i8 = marginLayoutParams.topMargin;
                        if (i7 != i8 || marginLayoutParams2.leftMargin != i6 || marginLayoutParams2.rightMargin != iJ) {
                            marginLayoutParams2.height = i8;
                            marginLayoutParams2.leftMargin = i6;
                            marginLayoutParams2.rightMargin = iJ;
                            this.f2262y.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f2243f);
                    this.f2262y = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i6;
                    layoutParams.rightMargin = iJ;
                    this.f2260w.addView(this.f2262y, -1, layoutParams);
                }
                View view3 = this.f2262y;
                z4 = view3 != null;
                if (z4 && view3.getVisibility() != 0) {
                    M0(this.f2262y);
                }
                if (!this.D && z4) {
                    iK = 0;
                }
                z2 = z4;
                z4 = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.f2254q.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f2262y;
        if (view4 != null) {
            view4.setVisibility(z2 ? 0 : 8);
        }
        return iK;
    }

    void N(int i3) {
        O(d0(i3, true), true);
    }

    void O(s sVar, boolean z2) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (z2 && sVar.f2285a == 0 && (c0Var = this.f2250m) != null && c0Var.c()) {
            L(sVar.f2294j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2243f.getSystemService("window");
        if (windowManager != null && sVar.f2299o && (viewGroup = sVar.f2291g) != null) {
            windowManager.removeView(viewGroup);
            if (z2) {
                K(sVar.f2285a, sVar, null);
            }
        }
        sVar.f2297m = false;
        sVar.f2298n = false;
        sVar.f2299o = false;
        sVar.f2292h = null;
        sVar.f2301q = true;
        if (this.I == sVar) {
            this.I = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View R(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zE0 = false;
        if (this.f2241a0 == null) {
            String string = this.f2243f.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f2241a0 = new b.g();
            } else {
                try {
                    this.f2241a0 = (b.g) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f2241a0 = new b.g();
                }
            }
        }
        boolean z2 = f2236c0;
        if (z2) {
            if (!(attributeSet instanceof XmlPullParser)) {
                zE0 = E0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                zE0 = true;
            }
        }
        return this.f2241a0.q(view, str, context, attributeSet, zE0, z2, true, b1.b());
    }

    void S() {
        androidx.appcompat.view.menu.e eVar;
        c0 c0Var = this.f2250m;
        if (c0Var != null) {
            c0Var.l();
        }
        if (this.f2255r != null) {
            this.f2244g.getDecorView().removeCallbacks(this.f2256s);
            if (this.f2255r.isShowing()) {
                try {
                    this.f2255r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f2255r = null;
        }
        V();
        s sVarD0 = d0(0, false);
        if (sVarD0 == null || (eVar = sVarD0.f2294j) == null) {
            return;
        }
        eVar.close();
    }

    boolean T(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f2242e;
        if (((obj instanceof e0.e.a) || (obj instanceof b.f)) && (decorView = this.f2244g.getDecorView()) != null && e0.e.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f2245h.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? p0(keyCode, keyEvent) : s0(keyCode, keyEvent);
    }

    void U(int i3) {
        s sVarD0;
        s sVarD1 = d0(i3, true);
        if (sVarD1.f2294j != null) {
            Bundle bundle = new Bundle();
            sVarD1.f2294j.Q(bundle);
            if (bundle.size() > 0) {
                sVarD1.f2303s = bundle;
            }
            sVarD1.f2294j.d0();
            sVarD1.f2294j.clear();
        }
        sVarD1.f2302r = true;
        sVarD1.f2301q = true;
        if ((i3 != 108 && i3 != 0) || this.f2250m == null || (sVarD0 = d0(0, false)) == null) {
            return;
        }
        sVarD0.f2297m = false;
        A0(sVarD0, null);
    }

    void V() {
        x xVar = this.f2257t;
        if (xVar != null) {
            xVar.b();
        }
    }

    s Y(Menu menu) {
        s[] sVarArr = this.H;
        int length = sVarArr != null ? sVarArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            s sVar = sVarArr[i3];
            if (sVar != null && sVar.f2294j == menu) {
                return sVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        s sVarY;
        Window.Callback callbackF0 = f0();
        if (callbackF0 == null || this.N || (sVarY = Y(eVar.D())) == null) {
            return false;
        }
        return callbackF0.onMenuItemSelected(sVarY.f2285a, menuItem);
    }

    final Context a0() {
        b.a aVarM = m();
        Context contextK = aVarM != null ? aVarM.k() : null;
        return contextK == null ? this.f2243f : contextK;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        B0(true);
    }

    @Override // b.d
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ((ViewGroup) this.f2260w.findViewById(R.id.content)).addView(view, layoutParams);
        this.f2245h.a().onContentChanged();
    }

    protected s d0(int i3, boolean z2) {
        s[] sVarArr = this.H;
        if (sVarArr == null || sVarArr.length <= i3) {
            s[] sVarArr2 = new s[i3 + 1];
            if (sVarArr != null) {
                System.arraycopy(sVarArr, 0, sVarArr2, 0, sVarArr.length);
            }
            this.H = sVarArr2;
            sVarArr = sVarArr2;
        }
        s sVar = sVarArr[i3];
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(i3);
        sVarArr[i3] = sVar2;
        return sVar2;
    }

    final CharSequence e0() {
        Object obj = this.f2242e;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f2249l;
    }

    @Override // b.d
    public Context f(Context context) {
        this.K = true;
        int iN0 = n0(context, J());
        if (f2239f0 && (context instanceof ContextThemeWrapper)) {
            try {
                q.a((ContextThemeWrapper) context, P(context, iN0, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof g.d) {
            try {
                ((g.d) context).a(P(context, iN0, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f2238e0) {
            return super.f(context);
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration configurationP = P(context, iN0, configuration.equals(configuration2) ? null : Z(configuration, configuration2));
            g.d dVar = new g.d(context, a.i.Theme_AppCompat_Empty);
            dVar.a(configurationP);
            boolean z2 = false;
            try {
                z2 = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z2) {
                v.f.b.a(dVar.getTheme());
            }
            return super.f(dVar);
        } catch (PackageManager.NameNotFoundException e3) {
            throw new RuntimeException("Application failed to obtain resources from itself", e3);
        }
    }

    final Window.Callback f0() {
        return this.f2244g.getCallback();
    }

    @Override // b.d
    public <T extends View> T i(int i3) {
        W();
        return (T) this.f2244g.findViewById(i3);
    }

    @Override // b.d
    public int k() {
        return this.O;
    }

    @Override // b.d
    public MenuInflater l() {
        if (this.f2248k == null) {
            g0();
            b.a aVar = this.f2247j;
            this.f2248k = new g.g(aVar != null ? aVar.k() : this.f2243f);
        }
        return this.f2248k;
    }

    @Override // b.d
    public b.a m() {
        g0();
        return this.f2247j;
    }

    public boolean m0() {
        return this.f2258u;
    }

    @Override // b.d
    public void n() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2243f);
        if (layoutInflaterFrom.getFactory() == null) {
            e0.f.b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof e) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    int n0(Context context, int i3) {
        if (i3 == -100) {
            return -1;
        }
        if (i3 != -1) {
            if (i3 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                    return c0(context).c();
                }
                return -1;
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    return b0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i3;
    }

    @Override // b.d
    public void o() {
        b.a aVarM = m();
        if (aVarM == null || !aVarM.l()) {
            k0(0);
        }
    }

    boolean o0() {
        g.b bVar = this.f2253p;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        b.a aVarM = m();
        return aVarM != null && aVarM.h();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return R(view, str, context, attributeSet);
    }

    @Override // b.d
    public void p(Configuration configuration) {
        b.a aVarM;
        if (this.B && this.f2259v && (aVarM = m()) != null) {
            aVarM.m(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.f2243f);
        G(false);
    }

    boolean p0(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.J = (keyEvent.getFlags() & 128) != 0;
        } else if (i3 == 82) {
            q0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // b.d
    public void q(Bundle bundle) {
        this.K = true;
        G(false);
        X();
        Object obj = this.f2242e;
        if (obj instanceof Activity) {
            String strC = null;
            try {
                strC = t.e.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strC != null) {
                b.a aVarY0 = y0();
                if (aVarY0 == null) {
                    this.X = true;
                } else {
                    aVarY0.r(true);
                }
            }
            b.d.c(this);
        }
        this.L = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    @Override // b.d
    public void r() {
        if (this.f2242e instanceof Activity) {
            b.d.x(this);
        }
        if (this.U) {
            this.f2244g.getDecorView().removeCallbacks(this.W);
        }
        this.M = false;
        this.N = true;
        if (this.O != -100) {
            Object obj = this.f2242e;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f2235b0.put(this.f2242e.getClass().getName(), Integer.valueOf(this.O));
            } else {
                f2235b0.remove(this.f2242e.getClass().getName());
            }
        } else {
            f2235b0.remove(this.f2242e.getClass().getName());
        }
        b.a aVar = this.f2247j;
        if (aVar != null) {
            aVar.n();
        }
        M();
    }

    boolean r0(int i3, KeyEvent keyEvent) {
        b.a aVarM = m();
        if (aVarM != null && aVarM.o(i3, keyEvent)) {
            return true;
        }
        s sVar = this.I;
        if (sVar != null && z0(sVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            s sVar2 = this.I;
            if (sVar2 != null) {
                sVar2.f2298n = true;
            }
            return true;
        }
        if (this.I == null) {
            s sVarD0 = d0(0, true);
            A0(sVarD0, keyEvent);
            boolean zZ0 = z0(sVarD0, keyEvent.getKeyCode(), keyEvent, 1);
            sVarD0.f2297m = false;
            if (zZ0) {
                return true;
            }
        }
        return false;
    }

    @Override // b.d
    public void s(Bundle bundle) {
        W();
    }

    boolean s0(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            boolean z2 = this.J;
            this.J = false;
            s sVarD0 = d0(0, false);
            if (sVarD0 != null && sVarD0.f2299o) {
                if (!z2) {
                    O(sVarD0, true);
                }
                return true;
            }
            if (o0()) {
                return true;
            }
        } else if (i3 == 82) {
            t0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // b.d
    public void t() {
        b.a aVarM = m();
        if (aVarM != null) {
            aVarM.u(true);
        }
    }

    @Override // b.d
    public void u(Bundle bundle) {
    }

    void u0(int i3) {
        b.a aVarM;
        if (i3 != 108 || (aVarM = m()) == null) {
            return;
        }
        aVarM.i(true);
    }

    @Override // b.d
    public void v() {
        this.M = true;
        F();
    }

    void v0(int i3) {
        if (i3 == 108) {
            b.a aVarM = m();
            if (aVarM != null) {
                aVarM.i(false);
                return;
            }
            return;
        }
        if (i3 == 0) {
            s sVarD0 = d0(i3, true);
            if (sVarD0.f2299o) {
                O(sVarD0, false);
            }
        }
    }

    @Override // b.d
    public void w() {
        this.M = false;
        b.a aVarM = m();
        if (aVarM != null) {
            aVarM.u(false);
        }
    }

    void w0(ViewGroup viewGroup) {
    }

    final b.a y0() {
        return this.f2247j;
    }

    @Override // b.d
    public boolean z(int i3) {
        int iC0 = C0(i3);
        if (this.F && iC0 == 108) {
            return false;
        }
        if (this.B && iC0 == 1) {
            this.B = false;
        }
        if (iC0 == 1) {
            H0();
            this.F = true;
            return true;
        }
        if (iC0 == 2) {
            H0();
            this.f2263z = true;
            return true;
        }
        if (iC0 == 5) {
            H0();
            this.A = true;
            return true;
        }
        if (iC0 == 10) {
            H0();
            this.D = true;
            return true;
        }
        if (iC0 == 108) {
            H0();
            this.B = true;
            return true;
        }
        if (iC0 != 109) {
            return this.f2244g.requestFeature(iC0);
        }
        H0();
        this.C = true;
        return true;
    }

    e(Dialog dialog, b.c cVar) {
        this(dialog.getContext(), dialog.getWindow(), cVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private e(Context context, Window window, b.c cVar, Object obj) {
        l.g<String, Integer> gVar;
        Integer num;
        b.b bVarI0;
        this.f2257t = null;
        this.f2258u = true;
        this.O = -100;
        this.W = new b();
        this.f2243f = context;
        this.f2246i = cVar;
        this.f2242e = obj;
        if (this.O == -100 && (obj instanceof Dialog) && (bVarI0 = I0()) != null) {
            this.O = bVarI0.v().k();
        }
        if (this.O == -100 && (num = (gVar = f2235b0).get(obj.getClass().getName())) != null) {
            this.O = num.intValue();
            gVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            I(window);
        }
        androidx.appcompat.widget.j.h();
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class j extends g.i {
        j(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            g.f.a aVar = new g.f.a(e.this.f2243f, callback);
            g.b bVarF0 = e.this.F0(aVar);
            if (bVarF0 != null) {
                return aVar.e(bVarF0);
            }
            return null;
        }

        @Override // g.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // g.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || e.this.r0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // g.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i3, Menu menu) {
            if (i3 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i3, menu);
            }
            return false;
        }

        @Override // g.i, android.view.Window.Callback
        public boolean onMenuOpened(int i3, Menu menu) {
            super.onMenuOpened(i3, menu);
            e.this.u0(i3);
            return true;
        }

        @Override // g.i, android.view.Window.Callback
        public void onPanelClosed(int i3, Menu menu) {
            super.onPanelClosed(i3, menu);
            e.this.v0(i3);
        }

        @Override // g.i, android.view.Window.Callback
        public boolean onPreparePanel(int i3, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i3 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.a0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i3, view, menu);
            if (eVar != null) {
                eVar.a0(false);
            }
            return zOnPreparePanel;
        }

        @Override // g.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
            androidx.appcompat.view.menu.e eVar;
            s sVarD0 = e.this.d0(0, true);
            if (sVarD0 == null || (eVar = sVarD0.f2294j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i3);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i3);
            }
        }

        @Override // g.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return e.this.m0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // g.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
            if (e.this.m0() && i3 == 0) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback, i3);
        }
    }
}
