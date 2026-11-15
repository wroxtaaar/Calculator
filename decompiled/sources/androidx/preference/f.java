package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: PreferenceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1676a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f1678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n0.d f1679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences.Editor f1680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1683h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PreferenceScreen f1685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d f1686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f1687l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f1688m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private b f1689n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1677b = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1684i = 0;

    /* JADX INFO: compiled from: PreferenceManager.java */
    public interface a {
        void e(Preference preference);
    }

    /* JADX INFO: compiled from: PreferenceManager.java */
    public interface b {
        void f(PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: compiled from: PreferenceManager.java */
    public interface c {
        boolean g(Preference preference);
    }

    /* JADX INFO: compiled from: PreferenceManager.java */
    public static abstract class d {
    }

    public f(Context context) {
        this.f1676a = context;
        s(d(context));
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d(context), c());
    }

    private static int c() {
        return 0;
    }

    private static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private void n(boolean z2) {
        SharedPreferences.Editor editor;
        if (!z2 && (editor = this.f1680e) != null) {
            editor.apply();
        }
        this.f1681f = z2;
    }

    public Preference a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f1685j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.B0(charSequence);
    }

    SharedPreferences.Editor e() {
        if (!this.f1681f) {
            return l().edit();
        }
        if (this.f1680e == null) {
            this.f1680e = l().edit();
        }
        return this.f1680e;
    }

    long f() {
        long j3;
        synchronized (this) {
            j3 = this.f1677b;
            this.f1677b = 1 + j3;
        }
        return j3;
    }

    public b g() {
        return this.f1689n;
    }

    public c h() {
        return this.f1687l;
    }

    public d i() {
        return this.f1686k;
    }

    public n0.d j() {
        return this.f1679d;
    }

    public PreferenceScreen k() {
        return this.f1685j;
    }

    public SharedPreferences l() {
        j();
        if (this.f1678c == null) {
            this.f1678c = (this.f1684i != 1 ? this.f1676a : u.a.a(this.f1676a)).getSharedPreferences(this.f1682g, this.f1683h);
        }
        return this.f1678c;
    }

    public PreferenceScreen m(Context context, int i3, PreferenceScreen preferenceScreen) {
        n(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new e(context, this).d(i3, preferenceScreen);
        preferenceScreen2.L(this);
        n(false);
        return preferenceScreen2;
    }

    public void o(a aVar) {
        this.f1688m = aVar;
    }

    public void p(b bVar) {
        this.f1689n = bVar;
    }

    public void q(c cVar) {
        this.f1687l = cVar;
    }

    public boolean r(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f1685j;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.Q();
        }
        this.f1685j = preferenceScreen;
        return true;
    }

    public void s(String str) {
        this.f1682g = str;
        this.f1678c = null;
    }

    boolean t() {
        return !this.f1681f;
    }

    public void u(Preference preference) {
        a aVar = this.f1688m;
        if (aVar != null) {
            aVar.e(preference);
        }
    }
}
