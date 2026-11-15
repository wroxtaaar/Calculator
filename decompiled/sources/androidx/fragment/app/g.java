package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: FragmentController.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i<?> f1333a;

    private g(i<?> iVar) {
        this.f1333a = iVar;
    }

    public static g b(i<?> iVar) {
        return new g((i) d0.i.d(iVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        i<?> iVar = this.f1333a;
        iVar.f1339f.g(iVar, iVar, fragment);
    }

    public void c() {
        this.f1333a.f1339f.r();
    }

    public void d(Configuration configuration) {
        this.f1333a.f1339f.s(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f1333a.f1339f.t(menuItem);
    }

    public void f() {
        this.f1333a.f1339f.u();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f1333a.f1339f.v(menu, menuInflater);
    }

    public void h() {
        this.f1333a.f1339f.w();
    }

    public void i() {
        this.f1333a.f1339f.y();
    }

    public void j(boolean z2) {
        this.f1333a.f1339f.z(z2);
    }

    public boolean k(MenuItem menuItem) {
        return this.f1333a.f1339f.A(menuItem);
    }

    public void l(Menu menu) {
        this.f1333a.f1339f.B(menu);
    }

    public void m() {
        this.f1333a.f1339f.D();
    }

    public void n(boolean z2) {
        this.f1333a.f1339f.E(z2);
    }

    public boolean o(Menu menu) {
        return this.f1333a.f1339f.F(menu);
    }

    public void p() {
        this.f1333a.f1339f.H();
    }

    public void q() {
        this.f1333a.f1339f.I();
    }

    public void r() {
        this.f1333a.f1339f.K();
    }

    public boolean s() {
        return this.f1333a.f1339f.Q(true);
    }

    public Fragment t(String str) {
        return this.f1333a.f1339f.Y(str);
    }

    public l u() {
        return this.f1333a.f1339f;
    }

    public void v() {
        this.f1333a.f1339f.C0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1333a.f1339f.g0().onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        i<?> iVar = this.f1333a;
        if (!(iVar instanceof androidx.lifecycle.s)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        iVar.f1339f.O0(parcelable);
    }

    public Parcelable y() {
        return this.f1333a.f1339f.Q0();
    }
}
