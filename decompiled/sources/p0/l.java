package p0;

import android.view.ViewGroup;

/* JADX INFO: compiled from: Scene.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f5676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f5677b;

    public static l b(ViewGroup viewGroup) {
        return (l) viewGroup.getTag(j.transition_current_scene);
    }

    static void c(ViewGroup viewGroup, l lVar) {
        viewGroup.setTag(j.transition_current_scene, lVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f5676a) != this || (runnable = this.f5677b) == null) {
            return;
        }
        runnable.run();
    }
}
