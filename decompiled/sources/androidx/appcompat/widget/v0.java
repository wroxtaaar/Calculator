package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TintResources.java */
/* JADX INFO: loaded from: classes.dex */
class v0 extends n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f789b;

    public v0(Context context, Resources resources) {
        super(resources);
        this.f789b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.n0, android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i3);
        Context context = this.f789b.get();
        if (drawable != null && context != null) {
            m0.h().x(context, i3, drawable);
        }
        return drawable;
    }
}
