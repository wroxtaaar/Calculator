package z0;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
final class d {
    static void a(Context context, int i3) {
        Resources.Theme themeB;
        context.getTheme().applyStyle(i3, true);
        if (!(context instanceof Activity) || (themeB = b((Activity) context)) == null) {
            return;
        }
        themeB.applyStyle(i3, true);
    }

    private static Resources.Theme b(Activity activity) {
        View viewPeekDecorView;
        Context context;
        Window window = activity.getWindow();
        if (window == null || (viewPeekDecorView = window.peekDecorView()) == null || (context = viewPeekDecorView.getContext()) == null) {
            return null;
        }
        return context.getTheme();
    }
}
