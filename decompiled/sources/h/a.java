package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: ActionMenuItem.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements y.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f4797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f4798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Intent f4799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char f4800g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private char f4802i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f4804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f4805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f4806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CharSequence f4807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f4808o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4801h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4803j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f4809p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f4810q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f4811r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f4812s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4813t = 16;

    public a(Context context, int i3, int i4, int i5, int i6, CharSequence charSequence) {
        this.f4805l = context;
        this.f4794a = i4;
        this.f4795b = i3;
        this.f4796c = i6;
        this.f4797d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f4804k;
        if (drawable != null) {
            if (this.f4811r || this.f4812s) {
                Drawable drawableR = x.a.r(drawable);
                this.f4804k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f4804k = drawableMutate;
                if (this.f4811r) {
                    x.a.o(drawableMutate, this.f4809p);
                }
                if (this.f4812s) {
                    x.a.p(this.f4804k, this.f4810q);
                }
            }
        }
    }

    @Override // y.b
    public y.b a(e0.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // y.b
    public e0.b b() {
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // y.b, android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public y.b setActionView(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // y.b, android.view.MenuItem
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public y.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // y.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // y.b, android.view.MenuItem
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public y.b setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // y.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f4803j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f4802i;
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f4807n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f4795b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f4804k;
    }

    @Override // y.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f4809p;
    }

    @Override // y.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f4810q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f4799f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f4794a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // y.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f4801h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f4800g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f4796c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f4797d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4798e;
        return charSequence != null ? charSequence : this.f4797d;
    }

    @Override // y.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f4808o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // y.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f4813t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f4813t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f4813t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f4813t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.f4802i = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f4813t = (z2 ? 1 : 0) | (this.f4813t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f4813t = (z2 ? 2 : 0) | (this.f4813t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f4813t = (z2 ? 16 : 0) | (this.f4813t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f4804k = drawable;
        c();
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4809p = colorStateList;
        this.f4811r = true;
        c();
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4810q = mode;
        this.f4812s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f4799f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.f4800g = c3;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4806m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f4800g = c3;
        this.f4802i = Character.toLowerCase(c4);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public void setShowAsAction(int i3) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f4797d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4798e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        this.f4813t = (this.f4813t & 8) | (z2 ? 0 : 8);
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.f4802i = Character.toLowerCase(c3);
        this.f4803j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public y.b setContentDescription(CharSequence charSequence) {
        this.f4807n = charSequence;
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.f4800g = c3;
        this.f4801h = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.f4797d = this.f4805l.getResources().getString(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public y.b setTooltipText(CharSequence charSequence) {
        this.f4808o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f4804k = u.a.d(this.f4805l, i3);
        c();
        return this;
    }

    @Override // y.b, android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f4800g = c3;
        this.f4801h = KeyEvent.normalizeMetaState(i3);
        this.f4802i = Character.toLowerCase(c4);
        this.f4803j = KeyEvent.normalizeMetaState(i4);
        return this;
    }
}
