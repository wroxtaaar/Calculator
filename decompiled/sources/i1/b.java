package i1;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

/* JADX INFO: compiled from: RippleUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f4887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f4888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f4889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f4890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f4891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f4892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f4893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f4894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f4895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f4896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f4897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f4898l;

    static {
        f4887a = Build.VERSION.SDK_INT >= 21;
        f4888b = new int[]{R.attr.state_pressed};
        f4889c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f4890d = new int[]{R.attr.state_focused};
        f4891e = new int[]{R.attr.state_hovered};
        f4892f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f4893g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f4894h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f4895i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f4896j = new int[]{R.attr.state_selected};
        f4897k = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f4898l = b.class.getSimpleName();
    }

    private b() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 22 && i3 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f4897k, 0)) != 0) {
            Log.w(f4898l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean b(int[] iArr) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 : iArr) {
            if (i3 == 16842910) {
                z2 = true;
            } else if (i3 == 16842908 || i3 == 16842919 || i3 == 16843623) {
                z3 = true;
            }
        }
        return z2 && z3;
    }
}
