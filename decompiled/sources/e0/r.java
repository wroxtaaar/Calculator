package e0;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* JADX INFO: compiled from: OneShotPreDrawListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f4574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewTreeObserver f4575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f4576d;

    private r(View view, Runnable runnable) {
        this.f4574b = view;
        this.f4575c = view.getViewTreeObserver();
        this.f4576d = runnable;
    }

    public static r a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        r rVar = new r(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(rVar);
        view.addOnAttachStateChangeListener(rVar);
        return rVar;
    }

    public void b() {
        if (this.f4575c.isAlive()) {
            this.f4575c.removeOnPreDrawListener(this);
        } else {
            this.f4574b.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4574b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f4576d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f4575c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
