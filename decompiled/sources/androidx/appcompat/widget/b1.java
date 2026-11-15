package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: VectorEnabledTintResources.java */
/* JADX INFO: loaded from: classes.dex */
public class b1 extends Resources {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f541b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f542a;

    public b1(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f542a = new WeakReference<>(context);
    }

    public static boolean a() {
        return f541b;
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    final Drawable c(int i3) {
        return super.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        Context context = this.f542a.get();
        return context != null ? m0.h().t(context, this, i3) : super.getDrawable(i3);
    }
}
