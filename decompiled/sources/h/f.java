package h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: SubMenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
class f extends d implements SubMenu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y.c f4829e;

    f(Context context, y.c cVar) {
        super(context, cVar);
        this.f4829e = cVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f4829e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f4829e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i3) {
        this.f4829e.setHeaderIcon(i3);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i3) {
        this.f4829e.setHeaderTitle(i3);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f4829e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i3) {
        this.f4829e.setIcon(i3);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f4829e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f4829e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f4829e.setIcon(drawable);
        return this;
    }
}
