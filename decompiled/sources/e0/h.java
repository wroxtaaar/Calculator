package e0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* JADX INFO: compiled from: MenuItemCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static MenuItem a(MenuItem menuItem, b bVar) {
        if (menuItem instanceof y.b) {
            return ((y.b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c3, int i3) {
        if (menuItem instanceof y.b) {
            ((y.b) menuItem).setAlphabeticShortcut(c3, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c3, i3);
        }
    }

    public static void c(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof y.b) {
            ((y.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void d(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof y.b) {
            ((y.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof y.b) {
            ((y.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void f(MenuItem menuItem, char c3, int i3) {
        if (menuItem instanceof y.b) {
            ((y.b) menuItem).setNumericShortcut(c3, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c3, i3);
        }
    }

    public static void g(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof y.b) {
            ((y.b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}
