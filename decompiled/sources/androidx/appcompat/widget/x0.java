package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

/* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class x0 implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Toolbar f819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    CharSequence f827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Window.Callback f830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f832n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f833o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f835q;

    /* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a f836b;

        a() {
            this.f836b = new h.a(x0.this.f819a.getContext(), 0, R.id.home, 0, 0, x0.this.f827i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x0 x0Var = x0.this;
            Window.Callback callback = x0Var.f830l;
            if (callback == null || !x0Var.f831m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f836b);
        }
    }

    /* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
    class b extends e0.z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f838a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f839b;

        b(int i3) {
            this.f839b = i3;
        }

        @Override // e0.y
        public void a(View view) {
            if (this.f838a) {
                return;
            }
            x0.this.f819a.setVisibility(this.f839b);
        }

        @Override // e0.z, e0.y
        public void b(View view) {
            x0.this.f819a.setVisibility(0);
        }

        @Override // e0.z, e0.y
        public void c(View view) {
            this.f838a = true;
        }
    }

    public x0(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    private void E(CharSequence charSequence) {
        this.f827i = charSequence;
        if ((this.f820b & 8) != 0) {
            this.f819a.setTitle(charSequence);
        }
    }

    private void F() {
        if ((this.f820b & 4) != 0) {
            if (TextUtils.isEmpty(this.f829k)) {
                this.f819a.setNavigationContentDescription(this.f834p);
            } else {
                this.f819a.setNavigationContentDescription(this.f829k);
            }
        }
    }

    private void G() {
        if ((this.f820b & 4) == 0) {
            this.f819a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f819a;
        Drawable drawable = this.f825g;
        if (drawable == null) {
            drawable = this.f835q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void H() {
        Drawable drawable;
        int i3 = this.f820b;
        if ((i3 & 2) == 0) {
            drawable = null;
        } else if ((i3 & 1) == 0 || (drawable = this.f824f) == null) {
            drawable = this.f823e;
        }
        this.f819a.setLogo(drawable);
    }

    private int w() {
        if (this.f819a.getNavigationIcon() == null) {
            return 11;
        }
        this.f835q = this.f819a.getNavigationIcon();
        return 15;
    }

    public void A(int i3) {
        B(i3 == 0 ? null : o().getString(i3));
    }

    public void B(CharSequence charSequence) {
        this.f829k = charSequence;
        F();
    }

    public void C(Drawable drawable) {
        this.f825g = drawable;
        G();
    }

    public void D(CharSequence charSequence) {
        this.f828j = charSequence;
        if ((this.f820b & 8) != 0) {
            this.f819a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.d0
    public void a(Menu menu, androidx.appcompat.view.menu.j.a aVar) {
        if (this.f832n == null) {
            c cVar = new c(this.f819a.getContext());
            this.f832n = cVar;
            cVar.p(a.f.action_menu_presenter);
        }
        this.f832n.h(aVar);
        this.f819a.I((androidx.appcompat.view.menu.e) menu, this.f832n);
    }

    @Override // androidx.appcompat.widget.d0
    public boolean b() {
        return this.f819a.z();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean c() {
        return this.f819a.A();
    }

    @Override // androidx.appcompat.widget.d0
    public void collapseActionView() {
        this.f819a.e();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean d() {
        return this.f819a.w();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean e() {
        return this.f819a.N();
    }

    @Override // androidx.appcompat.widget.d0
    public void f() {
        this.f831m = true;
    }

    @Override // androidx.appcompat.widget.d0
    public boolean g() {
        return this.f819a.d();
    }

    @Override // androidx.appcompat.widget.d0
    public CharSequence getTitle() {
        return this.f819a.getTitle();
    }

    @Override // androidx.appcompat.widget.d0
    public void h() {
        this.f819a.f();
    }

    @Override // androidx.appcompat.widget.d0
    public int i() {
        return this.f820b;
    }

    @Override // androidx.appcompat.widget.d0
    public void j(int i3) {
        this.f819a.setVisibility(i3);
    }

    @Override // androidx.appcompat.widget.d0
    public void k(int i3) {
        z(i3 != 0 ? c.a.d(o(), i3) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void l(p0 p0Var) {
        View view = this.f821c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f819a;
            if (parent == toolbar) {
                toolbar.removeView(this.f821c);
            }
        }
        this.f821c = p0Var;
        if (p0Var == null || this.f833o != 2) {
            return;
        }
        this.f819a.addView(p0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f821c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f2229a = 8388691;
        p0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.d0
    public ViewGroup m() {
        return this.f819a;
    }

    @Override // androidx.appcompat.widget.d0
    public void n(boolean z2) {
    }

    @Override // androidx.appcompat.widget.d0
    public Context o() {
        return this.f819a.getContext();
    }

    @Override // androidx.appcompat.widget.d0
    public int p() {
        return this.f833o;
    }

    @Override // androidx.appcompat.widget.d0
    public e0.x q(int i3, long j3) {
        return e0.t.d(this.f819a).a(i3 == 0 ? 1.0f : 0.0f).d(j3).f(new b(i3));
    }

    @Override // androidx.appcompat.widget.d0
    public void r() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public boolean s() {
        return this.f819a.v();
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(int i3) {
        setIcon(i3 != 0 ? c.a.d(o(), i3) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void setTitle(CharSequence charSequence) {
        this.f826h = true;
        E(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowCallback(Window.Callback callback) {
        this.f830l = callback;
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f826h) {
            return;
        }
        E(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public void u(boolean z2) {
        this.f819a.setCollapsible(z2);
    }

    @Override // androidx.appcompat.widget.d0
    public void v(int i3) {
        View view;
        int i4 = this.f820b ^ i3;
        this.f820b = i3;
        if (i4 != 0) {
            if ((i4 & 4) != 0) {
                if ((i3 & 4) != 0) {
                    F();
                }
                G();
            }
            if ((i4 & 3) != 0) {
                H();
            }
            if ((i4 & 8) != 0) {
                if ((i3 & 8) != 0) {
                    this.f819a.setTitle(this.f827i);
                    this.f819a.setSubtitle(this.f828j);
                } else {
                    this.f819a.setTitle((CharSequence) null);
                    this.f819a.setSubtitle((CharSequence) null);
                }
            }
            if ((i4 & 16) == 0 || (view = this.f822d) == null) {
                return;
            }
            if ((i3 & 16) != 0) {
                this.f819a.addView(view);
            } else {
                this.f819a.removeView(view);
            }
        }
    }

    public void x(View view) {
        View view2 = this.f822d;
        if (view2 != null && (this.f820b & 16) != 0) {
            this.f819a.removeView(view2);
        }
        this.f822d = view;
        if (view == null || (this.f820b & 16) == 0) {
            return;
        }
        this.f819a.addView(view);
    }

    public void y(int i3) {
        if (i3 == this.f834p) {
            return;
        }
        this.f834p = i3;
        if (TextUtils.isEmpty(this.f819a.getNavigationContentDescription())) {
            A(this.f834p);
        }
    }

    public void z(Drawable drawable) {
        this.f824f = drawable;
        H();
    }

    public x0(Toolbar toolbar, boolean z2, int i3, int i4) {
        Drawable drawable;
        this.f833o = 0;
        this.f834p = 0;
        this.f819a = toolbar;
        this.f827i = toolbar.getTitle();
        this.f828j = toolbar.getSubtitle();
        this.f826h = this.f827i != null;
        this.f825g = toolbar.getNavigationIcon();
        w0 w0VarV = w0.v(toolbar.getContext(), null, a.j.ActionBar, a.a.actionBarStyle, 0);
        this.f835q = w0VarV.g(a.j.ActionBar_homeAsUpIndicator);
        if (z2) {
            CharSequence charSequenceP = w0VarV.p(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                setTitle(charSequenceP);
            }
            CharSequence charSequenceP2 = w0VarV.p(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                D(charSequenceP2);
            }
            Drawable drawableG = w0VarV.g(a.j.ActionBar_logo);
            if (drawableG != null) {
                z(drawableG);
            }
            Drawable drawableG2 = w0VarV.g(a.j.ActionBar_icon);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f825g == null && (drawable = this.f835q) != null) {
                C(drawable);
            }
            v(w0VarV.k(a.j.ActionBar_displayOptions, 0));
            int iN = w0VarV.n(a.j.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                x(LayoutInflater.from(this.f819a.getContext()).inflate(iN, (ViewGroup) this.f819a, false));
                v(this.f820b | 16);
            }
            int iM = w0VarV.m(a.j.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f819a.getLayoutParams();
                layoutParams.height = iM;
                this.f819a.setLayoutParams(layoutParams);
            }
            int iE = w0VarV.e(a.j.ActionBar_contentInsetStart, -1);
            int iE2 = w0VarV.e(a.j.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f819a.H(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = w0VarV.n(a.j.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f819a;
                toolbar2.K(toolbar2.getContext(), iN2);
            }
            int iN3 = w0VarV.n(a.j.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f819a;
                toolbar3.J(toolbar3.getContext(), iN3);
            }
            int iN4 = w0VarV.n(a.j.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.f819a.setPopupTheme(iN4);
            }
        } else {
            this.f820b = w();
        }
        w0VarV.w();
        y(i3);
        this.f829k = this.f819a.getNavigationContentDescription();
        this.f819a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(Drawable drawable) {
        this.f823e = drawable;
        H();
    }
}
