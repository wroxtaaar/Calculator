package p0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ViewGroupOverlayApi14.java */
/* JADX INFO: loaded from: classes.dex */
class u extends z implements w {
    u(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static u g(ViewGroup viewGroup) {
        return (u) z.e(viewGroup);
    }

    @Override // p0.w
    public void a(View view) {
        this.f5739a.b(view);
    }

    @Override // p0.w
    public void c(View view) {
        this.f5739a.g(view);
    }
}
