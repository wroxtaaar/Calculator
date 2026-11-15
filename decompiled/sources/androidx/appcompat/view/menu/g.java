package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: compiled from: MenuItemImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements y.b {
    private View A;
    private e0.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Intent f250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private char f251h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private char f253j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f255l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    e f257n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private m f258o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f259p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f260q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f261r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f262s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f269z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f252i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f254k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f256m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorStateList f263t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f264u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f265v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f266w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f267x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f268y = 16;
    private boolean D = false;

    /* JADX INFO: compiled from: MenuItemImpl.java */
    class a implements e0.b.InterfaceC0056b {
        a() {
        }

        @Override // e0.b.InterfaceC0056b
        public void onActionProviderVisibilityChanged(boolean z2) {
            g gVar = g.this;
            gVar.f257n.J(gVar);
        }
    }

    g(e eVar, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        this.f269z = 0;
        this.f257n = eVar;
        this.f244a = i4;
        this.f245b = i3;
        this.f246c = i5;
        this.f247d = i6;
        this.f248e = charSequence;
        this.f269z = i7;
    }

    private static void d(StringBuilder sb, int i3, int i4, String str) {
        if ((i3 & i4) == i4) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f267x && (this.f265v || this.f266w)) {
            drawable = x.a.r(drawable).mutate();
            if (this.f265v) {
                x.a.o(drawable, this.f263t);
            }
            if (this.f266w) {
                x.a.p(drawable, this.f264u);
            }
            this.f267x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f257n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f269z & 4) == 4;
    }

    @Override // y.b
    public y.b a(e0.b bVar) {
        e0.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f257n.K(true);
        e0.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    @Override // y.b
    public e0.b b() {
        return this.B;
    }

    public void c() {
        this.f257n.I(this);
    }

    @Override // y.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f269z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f257n.f(this);
        }
        return false;
    }

    @Override // y.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f257n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f247d;
    }

    char g() {
        return this.f257n.G() ? this.f253j : this.f251h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // y.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        e0.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View viewD = bVar.d(this);
        this.A = viewD;
        return viewD;
    }

    @Override // y.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f254k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f253j;
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f261r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f245b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f255l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f256m == 0) {
            return null;
        }
        Drawable drawableD = c.a.d(this.f257n.u(), this.f256m);
        this.f256m = 0;
        this.f255l = drawableD;
        return e(drawableD);
    }

    @Override // y.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f263t;
    }

    @Override // y.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f264u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f250g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f244a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // y.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f252i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f251h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f246c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f258o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f248e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f249f;
        if (charSequence == null) {
            charSequence = this.f248e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f262s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return BuildConfig.FLAVOR;
        }
        Resources resources = this.f257n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f257n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(a.h.abc_prepend_shortcut_label));
        }
        int i3 = this.f257n.G() ? this.f254k : this.f252i;
        d(sb, i3, 65536, resources.getString(a.h.abc_menu_meta_shortcut_label));
        d(sb, i3, 4096, resources.getString(a.h.abc_menu_ctrl_shortcut_label));
        d(sb, i3, 2, resources.getString(a.h.abc_menu_alt_shortcut_label));
        d(sb, i3, 1, resources.getString(a.h.abc_menu_shift_shortcut_label));
        d(sb, i3, 4, resources.getString(a.h.abc_menu_sym_shortcut_label));
        d(sb, i3, 8, resources.getString(a.h.abc_menu_function_shortcut_label));
        if (cG == '\b') {
            sb.append(resources.getString(a.h.abc_menu_delete_shortcut_label));
        } else if (cG == '\n') {
            sb.append(resources.getString(a.h.abc_menu_enter_shortcut_label));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(a.h.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f258o != null;
    }

    CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // y.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f268y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f268y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f268y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        e0.b bVar = this.B;
        if (bVar == null || !bVar.g()) {
            return (this.f268y & 8) == 0;
        }
        return (this.f268y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        e0.b bVar;
        if ((this.f269z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f260q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f257n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f259p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f250g != null) {
            try {
                this.f257n.u().startActivity(this.f250g);
                return true;
            } catch (ActivityNotFoundException e3) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e3);
            }
        }
        e0.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.f268y & 32) == 32;
    }

    public boolean m() {
        return (this.f268y & 4) != 0;
    }

    public boolean n() {
        return (this.f269z & 1) == 1;
    }

    public boolean o() {
        return (this.f269z & 2) == 2;
    }

    @Override // y.b, android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public y.b setActionView(int i3) {
        Context contextU = this.f257n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i3, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    @Override // y.b, android.view.MenuItem
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public y.b setActionView(View view) {
        int i3;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i3 = this.f244a) > 0) {
            view.setId(i3);
        }
        this.f257n.I(this);
        return this;
    }

    public void r(boolean z2) {
        this.D = z2;
        this.f257n.K(false);
    }

    void s(boolean z2) {
        int i3 = this.f268y;
        int i4 = (z2 ? 2 : 0) | (i3 & (-3));
        this.f268y = i4;
        if (i3 != i4) {
            this.f257n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        if (this.f253j == c3) {
            return this;
        }
        this.f253j = Character.toLowerCase(c3);
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        int i3 = this.f268y;
        int i4 = (z2 ? 1 : 0) | (i3 & (-2));
        this.f268y = i4;
        if (i3 != i4) {
            this.f257n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        if ((this.f268y & 4) != 0) {
            this.f257n.T(this);
        } else {
            s(z2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f268y |= 16;
        } else {
            this.f268y &= -17;
        }
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f256m = 0;
        this.f255l = drawable;
        this.f267x = true;
        this.f257n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f263t = colorStateList;
        this.f265v = true;
        this.f267x = true;
        this.f257n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f264u = mode;
        this.f266w = true;
        this.f267x = true;
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f250g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        if (this.f251h == c3) {
            return this;
        }
        this.f251h = c3;
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f260q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f251h = c3;
        this.f253j = Character.toLowerCase(c4);
        this.f257n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public void setShowAsAction(int i3) {
        int i4 = i3 & 3;
        if (i4 != 0 && i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f269z = i3;
        this.f257n.I(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f248e = charSequence;
        this.f257n.K(false);
        m mVar = this.f258o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f249f = charSequence;
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        if (y(z2)) {
            this.f257n.J(this);
        }
        return this;
    }

    public void t(boolean z2) {
        this.f268y = (z2 ? 4 : 0) | (this.f268y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f248e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z2) {
        if (z2) {
            this.f268y |= 32;
        } else {
            this.f268y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // y.b, android.view.MenuItem
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public y.b setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    public void x(m mVar) {
        this.f258o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    boolean y(boolean z2) {
        int i3 = this.f268y;
        int i4 = (z2 ? 0 : 8) | (i3 & (-9));
        this.f268y = i4;
        return i3 != i4;
    }

    public boolean z() {
        return this.f257n.A();
    }

    @Override // android.view.MenuItem
    public y.b setContentDescription(CharSequence charSequence) {
        this.f261r = charSequence;
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public y.b setTooltipText(CharSequence charSequence) {
        this.f262s = charSequence;
        this.f257n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        if (this.f253j == c3 && this.f254k == i3) {
            return this;
        }
        this.f253j = Character.toLowerCase(c3);
        this.f254k = KeyEvent.normalizeMetaState(i3);
        this.f257n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        if (this.f251h == c3 && this.f252i == i3) {
            return this;
        }
        this.f251h = c3;
        this.f252i = KeyEvent.normalizeMetaState(i3);
        this.f257n.K(false);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f251h = c3;
        this.f252i = KeyEvent.normalizeMetaState(i3);
        this.f253j = Character.toLowerCase(c4);
        this.f254k = KeyEvent.normalizeMetaState(i4);
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f255l = null;
        this.f256m = i3;
        this.f267x = true;
        this.f257n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        return setTitle(this.f257n.u().getString(i3));
    }
}
