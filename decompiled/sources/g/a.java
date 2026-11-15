package g;

import a.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: ActionBarPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4688a;

    private a(Context context) {
        this.f4688a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f4688a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f4688a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f4688a.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600) {
            return 5;
        }
        if (i3 > 960 && i4 > 720) {
            return 5;
        }
        if (i3 > 720 && i4 > 960) {
            return 5;
        }
        if (i3 >= 500) {
            return 4;
        }
        if (i3 > 640 && i4 > 480) {
            return 4;
        }
        if (i3 <= 480 || i4 <= 640) {
            return i3 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f4688a.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width);
    }

    public int f() {
        TypedArray typedArrayObtainStyledAttributes = this.f4688a.obtainStyledAttributes(null, j.ActionBar, a.a.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0);
        Resources resources = this.f4688a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f4688a.getResources().getBoolean(a.b.abc_action_bar_embed_tabs);
    }

    public boolean h() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f4688a).hasPermanentMenuKey();
    }
}
