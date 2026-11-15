package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MenuItemWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends h.b implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y.b f4817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f4818e;

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class a extends e0.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ActionProvider f4819d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f4819d = actionProvider;
        }

        @Override // e0.b
        public boolean a() {
            return this.f4819d.hasSubMenu();
        }

        @Override // e0.b
        public View c() {
            return this.f4819d.onCreateActionView();
        }

        @Override // e0.b
        public boolean e() {
            return this.f4819d.onPerformDefaultAction();
        }

        @Override // e0.b
        public void f(SubMenu subMenu) {
            this.f4819d.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private e0.b.InterfaceC0056b f4821f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // e0.b
        public boolean b() {
            return this.f4819d.isVisible();
        }

        @Override // e0.b
        public View d(MenuItem menuItem) {
            return this.f4819d.onCreateActionView(menuItem);
        }

        @Override // e0.b
        public boolean g() {
            return this.f4819d.overridesItemVisibility();
        }

        @Override // e0.b
        public void j(e0.b.InterfaceC0056b interfaceC0056b) {
            this.f4821f = interfaceC0056b;
            ActionProvider actionProvider = this.f4819d;
            if (interfaceC0056b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z2) {
            e0.b.InterfaceC0056b interfaceC0056b = this.f4821f;
            if (interfaceC0056b != null) {
                interfaceC0056b.onActionProviderVisibilityChanged(z2);
            }
        }
    }

    /* JADX INFO: renamed from: h.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    static class C0062c extends FrameLayout implements g.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CollapsibleActionView f4823b;

        /* JADX WARN: Multi-variable type inference failed */
        C0062c(View view) {
            super(view.getContext());
            this.f4823b = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f4823b;
        }

        @Override // g.c
        public void c() {
            this.f4823b.onActionViewExpanded();
        }

        @Override // g.c
        public void f() {
            this.f4823b.onActionViewCollapsed();
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class d implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f4824a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f4824a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f4824a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f4824a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f4826a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f4826a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f4826a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, y.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f4817d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f4817d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f4817d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        e0.b bVarB = this.f4817d.b();
        if (bVarB instanceof a) {
            return ((a) bVarB).f4819d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f4817d.getActionView();
        return actionView instanceof C0062c ? ((C0062c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f4817d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f4817d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f4817d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f4817d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f4817d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f4817d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f4817d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f4817d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f4817d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f4817d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f4817d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f4817d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f4817d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f4817d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f4817d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f4817d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f4817d.getTooltipText();
    }

    public void h(boolean z2) {
        try {
            if (this.f4818e == null) {
                this.f4818e = this.f4817d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f4818e.invoke(this.f4817d, Boolean.valueOf(z2));
        } catch (Exception e3) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e3);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f4817d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f4817d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f4817d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f4817d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f4817d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f4817d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        e0.b bVar = Build.VERSION.SDK_INT >= 16 ? new b(this.f4814a, actionProvider) : new a(this.f4814a, actionProvider);
        y.b bVar2 = this.f4817d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0062c(view);
        }
        this.f4817d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.f4817d.setAlphabeticShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f4817d.setCheckable(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f4817d.setChecked(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f4817d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f4817d.setEnabled(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f4817d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4817d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4817d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f4817d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.f4817d.setNumericShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f4817d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4817d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f4817d.setShortcut(c3, c4);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i3) {
        this.f4817d.setShowAsAction(i3);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i3) {
        this.f4817d.setShowAsActionFlags(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f4817d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4817d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f4817d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        return this.f4817d.setVisible(z2);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.f4817d.setAlphabeticShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f4817d.setIcon(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.f4817d.setNumericShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f4817d.setShortcut(c3, c4, i3, i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.f4817d.setTitle(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i3) {
        this.f4817d.setActionView(i3);
        View actionView = this.f4817d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f4817d.setActionView(new C0062c(actionView));
        }
        return this;
    }
}
