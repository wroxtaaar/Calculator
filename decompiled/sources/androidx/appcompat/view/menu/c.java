package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: ListMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements j, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LayoutInflater f198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    e f199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ExpandedMenuView f200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private j.a f204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    a f205j;

    /* JADX INFO: compiled from: ListMenuPresenter.java */
    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f206b = -1;

        public a() {
            a();
        }

        void a() {
            g gVarV = c.this.f199d.v();
            if (gVarV != null) {
                ArrayList<g> arrayListZ = c.this.f199d.z();
                int size = arrayListZ.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (arrayListZ.get(i3) == gVarV) {
                        this.f206b = i3;
                        return;
                    }
                }
            }
            this.f206b = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g getItem(int i3) {
            ArrayList<g> arrayListZ = c.this.f199d.z();
            int i4 = i3 + c.this.f201f;
            int i5 = this.f206b;
            if (i5 >= 0 && i4 >= i5) {
                i4++;
            }
            return arrayListZ.get(i4);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f199d.z().size() - c.this.f201f;
            return this.f206b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f198c.inflate(cVar.f203h, viewGroup, false);
            }
            ((k.a) view).e(getItem(i3), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(Context context, int i3) {
        this(i3, 0);
        this.f197b = context;
        this.f198c = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f205j == null) {
            this.f205j = new a();
        }
        return this.f205j;
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z2) {
        j.a aVar = this.f204i;
        if (aVar != null) {
            aVar.b(eVar, z2);
        }
    }

    public k c(ViewGroup viewGroup) {
        if (this.f200e == null) {
            this.f200e = (ExpandedMenuView) this.f198c.inflate(a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f205j == null) {
                this.f205j = new a();
            }
            this.f200e.setAdapter((ListAdapter) this.f205j);
            this.f200e.setOnItemClickListener(this);
        }
        return this.f200e;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void e(Context context, e eVar) {
        if (this.f202g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f202g);
            this.f197b = contextThemeWrapper;
            this.f198c = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f197b != null) {
            this.f197b = context;
            if (this.f198c == null) {
                this.f198c = LayoutInflater.from(context);
            }
        }
        this.f199d = eVar;
        a aVar = this.f205j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f204i = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).d(null);
        j.a aVar = this.f204i;
        if (aVar == null) {
            return true;
        }
        aVar.c(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        a aVar = this.f205j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        this.f199d.M(this.f205j.getItem(i3), this, 0);
    }

    public c(int i3, int i4) {
        this.f203h = i3;
        this.f202g = i4;
    }
}
