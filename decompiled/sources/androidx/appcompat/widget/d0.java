package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: compiled from: DecorToolbar.java */
/* JADX INFO: loaded from: classes.dex */
public interface d0 {
    void a(Menu menu, androidx.appcompat.view.menu.j.a aVar);

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    void f();

    boolean g();

    CharSequence getTitle();

    void h();

    int i();

    void j(int i3);

    void k(int i3);

    void l(p0 p0Var);

    ViewGroup m();

    void n(boolean z2);

    Context o();

    int p();

    e0.x q(int i3, long j3);

    void r();

    boolean s();

    void setIcon(int i3);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    void u(boolean z2);

    void v(int i3);
}
