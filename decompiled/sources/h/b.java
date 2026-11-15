package h;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import l.g;

/* JADX INFO: compiled from: BaseMenuWrapper.java */
/* JADX INFO: loaded from: classes.dex */
abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f4814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g<y.b, MenuItem> f4815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g<y.c, SubMenu> f4816c;

    b(Context context) {
        this.f4814a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof y.b)) {
            return menuItem;
        }
        y.b bVar = (y.b) menuItem;
        if (this.f4815b == null) {
            this.f4815b = new g<>();
        }
        MenuItem menuItem2 = this.f4815b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f4814a, bVar);
        this.f4815b.put(bVar, cVar);
        return cVar;
    }

    final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof y.c)) {
            return subMenu;
        }
        y.c cVar = (y.c) subMenu;
        if (this.f4816c == null) {
            this.f4816c = new g<>();
        }
        SubMenu subMenu2 = this.f4816c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        f fVar = new f(this.f4814a, cVar);
        this.f4816c.put(cVar, fVar);
        return fVar;
    }

    final void e() {
        g<y.b, MenuItem> gVar = this.f4815b;
        if (gVar != null) {
            gVar.clear();
        }
        g<y.c, SubMenu> gVar2 = this.f4816c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    final void f(int i3) {
        if (this.f4815b == null) {
            return;
        }
        int i4 = 0;
        while (i4 < this.f4815b.size()) {
            if (this.f4815b.i(i4).getGroupId() == i3) {
                this.f4815b.k(i4);
                i4--;
            }
            i4++;
        }
    }

    final void g(int i3) {
        if (this.f4815b == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f4815b.size(); i4++) {
            if (this.f4815b.i(i4).getItemId() == i3) {
                this.f4815b.k(i4);
                return;
            }
        }
    }
}
