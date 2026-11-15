package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.l0;
import e0.t;

/* JADX INFO: compiled from: StandardMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
final class l extends h implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f285w = a.g.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f292i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final l0 f293j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PopupWindow.OnDismissListener f296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f297n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    View f298o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private j.a f299p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ViewTreeObserver f300q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f301r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f302s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f303t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f305v;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f294k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f295l = new b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f304u = 0;

    /* JADX INFO: compiled from: StandardMenuPopup.java */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!l.this.c() || l.this.f293j.B()) {
                return;
            }
            View view = l.this.f298o;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.f293j.a();
            }
        }
    }

    /* JADX INFO: compiled from: StandardMenuPopup.java */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f300q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f300q = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f300q.removeGlobalOnLayoutListener(lVar.f294k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i3, int i4, boolean z2) {
        this.f286c = context;
        this.f287d = eVar;
        this.f289f = z2;
        this.f288e = new d(eVar, LayoutInflater.from(context), z2, f285w);
        this.f291h = i3;
        this.f292i = i4;
        Resources resources = context.getResources();
        this.f290g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.f297n = view;
        this.f293j = new l0(context, null, i3, i4);
        eVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (c()) {
            return true;
        }
        if (this.f301r || (view = this.f297n) == null) {
            return false;
        }
        this.f298o = view;
        this.f293j.K(this);
        this.f293j.L(this);
        this.f293j.J(true);
        View view2 = this.f298o;
        boolean z2 = this.f300q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f300q = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f294k);
        }
        view2.addOnAttachStateChangeListener(this.f295l);
        this.f293j.D(view2);
        this.f293j.G(this.f304u);
        if (!this.f302s) {
            this.f303t = h.o(this.f288e, null, this.f286c, this.f290g);
            this.f302s = true;
        }
        this.f293j.F(this.f303t);
        this.f293j.I(2);
        this.f293j.H(n());
        this.f293j.a();
        ListView listViewL = this.f293j.l();
        listViewL.setOnKeyListener(this);
        if (this.f305v && this.f287d.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f286c).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewL, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f287d.x());
            }
            frameLayout.setEnabled(false);
            listViewL.addHeaderView(frameLayout, null, false);
        }
        this.f293j.o(this.f288e);
        this.f293j.a();
        return true;
    }

    @Override // h.e
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z2) {
        if (eVar != this.f287d) {
            return;
        }
        dismiss();
        j.a aVar = this.f299p;
        if (aVar != null) {
            aVar.b(eVar, z2);
        }
    }

    @Override // h.e
    public boolean c() {
        return !this.f301r && this.f293j.c();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean d() {
        return false;
    }

    @Override // h.e
    public void dismiss() {
        if (c()) {
            this.f293j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f299p = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f286c, mVar, this.f298o, this.f289f, this.f291h, this.f292i);
            iVar.j(this.f299p);
            iVar.g(h.x(mVar));
            iVar.i(this.f296m);
            this.f296m = null;
            this.f287d.e(false);
            int iF = this.f293j.f();
            int iH = this.f293j.h();
            if ((Gravity.getAbsoluteGravity(this.f304u, t.B(this.f297n)) & 7) == 5) {
                iF += this.f297n.getWidth();
            }
            if (iVar.n(iF, iH)) {
                j.a aVar = this.f299p;
                if (aVar == null) {
                    return true;
                }
                aVar.c(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        this.f302s = false;
        d dVar = this.f288e;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void k(e eVar) {
    }

    @Override // h.e
    public ListView l() {
        return this.f293j.l();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f301r = true;
        this.f287d.close();
        ViewTreeObserver viewTreeObserver = this.f300q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f300q = this.f298o.getViewTreeObserver();
            }
            this.f300q.removeGlobalOnLayoutListener(this.f294k);
            this.f300q = null;
        }
        this.f298o.removeOnAttachStateChangeListener(this.f295l);
        PopupWindow.OnDismissListener onDismissListener = this.f296m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i3 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void p(View view) {
        this.f297n = view;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z2) {
        this.f288e.d(z2);
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i3) {
        this.f304u = i3;
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i3) {
        this.f293j.e(i3);
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f296m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z2) {
        this.f305v = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i3) {
        this.f293j.n(i3);
    }
}
