package p0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class a0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f5595a;

    a0(View view) {
        this.f5595a = view.getOverlay();
    }

    @Override // p0.b0
    public void b(Drawable drawable) {
        this.f5595a.add(drawable);
    }

    @Override // p0.b0
    public void d(Drawable drawable) {
        this.f5595a.remove(drawable);
    }
}
