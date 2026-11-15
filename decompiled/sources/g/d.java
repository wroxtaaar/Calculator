package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* JADX INFO: compiled from: ContextThemeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f4692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f4693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Configuration f4694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Resources f4695e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f4695e == null) {
            Configuration configuration = this.f4694d;
            if (configuration == null) {
                this.f4695e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f4695e = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration2 = new Configuration(resources.getConfiguration());
                configuration2.updateFrom(this.f4694d);
                this.f4695e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
            }
        }
        return this.f4695e;
    }

    private void d() {
        boolean z2 = this.f4692b == null;
        if (z2) {
            this.f4692b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f4692b.setTo(theme);
            }
        }
        e(this.f4692b, this.f4691a, z2);
    }

    public void a(Configuration configuration) {
        if (this.f4695e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f4694d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f4694d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f4691a;
    }

    protected void e(Resources.Theme theme, int i3, boolean z2) {
        theme.applyStyle(i3, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f4693c == null) {
            this.f4693c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f4693c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f4692b;
        if (theme != null) {
            return theme;
        }
        if (this.f4691a == 0) {
            this.f4691a = a.i.Theme_AppCompat_Light;
        }
        d();
        return this.f4692b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        if (this.f4691a != i3) {
            this.f4691a = i3;
            d();
        }
    }

    public d(Context context, int i3) {
        super(context);
        this.f4691a = i3;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f4692b = theme;
    }
}
