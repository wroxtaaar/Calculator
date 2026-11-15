package g;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: SupportActionModeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f4703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f4704b;

    /* JADX INFO: compiled from: SupportActionModeWrapper.java */
    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f4705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f4706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<f> f4707c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final l.g<Menu, Menu> f4708d = new l.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f4706b = context;
            this.f4705a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f4708d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            h.d dVar = new h.d(this.f4706b, (y.a) menu);
            this.f4708d.put(menu, dVar);
            return dVar;
        }

        @Override // g.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f4705a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // g.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f4705a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // g.b.a
        public void c(b bVar) {
            this.f4705a.onDestroyActionMode(e(bVar));
        }

        @Override // g.b.a
        public boolean d(b bVar, MenuItem menuItem) {
            return this.f4705a.onActionItemClicked(e(bVar), new h.c(this.f4706b, (y.b) menuItem));
        }

        public ActionMode e(b bVar) {
            int size = this.f4707c.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.f4707c.get(i3);
                if (fVar != null && fVar.f4704b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f4706b, bVar);
            this.f4707c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f4703a = context;
        this.f4704b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f4704b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f4704b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new h.d(this.f4703a, (y.a) this.f4704b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f4704b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f4704b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f4704b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f4704b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f4704b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f4704b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f4704b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f4704b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f4704b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f4704b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f4704b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z2) {
        this.f4704b.s(z2);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i3) {
        this.f4704b.n(i3);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i3) {
        this.f4704b.q(i3);
    }
}
