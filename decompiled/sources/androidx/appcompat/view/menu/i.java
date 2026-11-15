package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import e0.t;

/* JADX INFO: compiled from: MenuPopupHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private j.a f280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f283l;

    /* JADX INFO: compiled from: MenuPopupHelper.java */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z2, int i3) {
        this(context, eVar, view, z2, i3, 0);
    }

    private h a() {
        Display defaultDisplay = ((WindowManager) this.f272a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        h bVar = Math.min(point.x, point.y) >= this.f272a.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width) ? new b(this.f272a, this.f277f, this.f275d, this.f276e, this.f274c) : new l(this.f272a, this.f273b, this.f277f, this.f275d, this.f276e, this.f274c);
        bVar.k(this.f273b);
        bVar.u(this.f283l);
        bVar.p(this.f277f);
        bVar.h(this.f280i);
        bVar.r(this.f279h);
        bVar.s(this.f278g);
        return bVar;
    }

    private void l(int i3, int i4, boolean z2, boolean z3) {
        h hVarC = c();
        hVarC.v(z3);
        if (z2) {
            if ((e0.d.b(this.f278g, t.B(this.f277f)) & 7) == 5) {
                i3 -= this.f277f.getWidth();
            }
            hVarC.t(i3);
            hVarC.w(i4);
            int i5 = (int) ((this.f272a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            hVarC.q(new Rect(i3 - i5, i4 - i5, i3 + i5, i4 + i5));
        }
        hVarC.a();
    }

    public void b() {
        if (d()) {
            this.f281j.dismiss();
        }
    }

    public h c() {
        if (this.f281j == null) {
            this.f281j = a();
        }
        return this.f281j;
    }

    public boolean d() {
        h hVar = this.f281j;
        return hVar != null && hVar.c();
    }

    protected void e() {
        this.f281j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f282k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f277f = view;
    }

    public void g(boolean z2) {
        this.f279h = z2;
        h hVar = this.f281j;
        if (hVar != null) {
            hVar.r(z2);
        }
    }

    public void h(int i3) {
        this.f278g = i3;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f282k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f280i = aVar;
        h hVar = this.f281j;
        if (hVar != null) {
            hVar.h(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f277f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i3, int i4) {
        if (d()) {
            return true;
        }
        if (this.f277f == null) {
            return false;
        }
        l(i3, i4, true, true);
        return true;
    }

    public i(Context context, e eVar, View view, boolean z2, int i3, int i4) {
        this.f278g = 8388611;
        this.f283l = new a();
        this.f272a = context;
        this.f273b = eVar;
        this.f277f = view;
        this.f274c = z2;
        this.f275d = i3;
        this.f276e = i4;
    }
}
