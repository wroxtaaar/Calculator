package p0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: compiled from: ViewGroupOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class v implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f5732a;

    v(ViewGroup viewGroup) {
        this.f5732a = viewGroup.getOverlay();
    }

    @Override // p0.w
    public void a(View view) {
        this.f5732a.add(view);
    }

    @Override // p0.b0
    public void b(Drawable drawable) {
        this.f5732a.add(drawable);
    }

    @Override // p0.w
    public void c(View view) {
        this.f5732a.remove(view);
    }

    @Override // p0.b0
    public void d(Drawable drawable) {
        this.f5732a.remove(drawable);
    }
}
