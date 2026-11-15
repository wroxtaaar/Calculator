package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: compiled from: FragmentHostCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i<E> extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f1335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f1336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f1337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final l f1339f;

    i(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.f
    public View e(int i3) {
        return null;
    }

    @Override // androidx.fragment.app.f
    public boolean f() {
        return true;
    }

    Activity g() {
        return this.f1335b;
    }

    Context h() {
        return this.f1336c;
    }

    Handler j() {
        return this.f1337d;
    }

    void k(Fragment fragment) {
    }

    public abstract E l();

    public LayoutInflater m() {
        return LayoutInflater.from(this.f1336c);
    }

    public boolean n(Fragment fragment) {
        return true;
    }

    public void o() {
    }

    i(Activity activity, Context context, Handler handler, int i3) {
        this.f1339f = new m();
        this.f1335b = activity;
        this.f1336c = (Context) d0.i.d(context, "context == null");
        this.f1337d = (Handler) d0.i.d(handler, "handler == null");
        this.f1338e = i3;
    }
}
