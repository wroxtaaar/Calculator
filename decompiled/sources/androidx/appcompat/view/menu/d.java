package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: MenuAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    e f208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f209c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LayoutInflater f212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f213g;

    public d(e eVar, LayoutInflater layoutInflater, boolean z2, int i3) {
        this.f211e = z2;
        this.f212f = layoutInflater;
        this.f208b = eVar;
        this.f213g = i3;
        a();
    }

    void a() {
        g gVarV = this.f208b.v();
        if (gVarV != null) {
            ArrayList<g> arrayListZ = this.f208b.z();
            int size = arrayListZ.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayListZ.get(i3) == gVarV) {
                    this.f209c = i3;
                    return;
                }
            }
        }
        this.f209c = -1;
    }

    public e b() {
        return this.f208b;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i3) {
        ArrayList<g> arrayListZ = this.f211e ? this.f208b.z() : this.f208b.E();
        int i4 = this.f209c;
        if (i4 >= 0 && i3 >= i4) {
            i3++;
        }
        return arrayListZ.get(i3);
    }

    public void d(boolean z2) {
        this.f210d = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<g> arrayListZ = this.f211e ? this.f208b.z() : this.f208b.E();
        return this.f209c < 0 ? arrayListZ.size() : arrayListZ.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f212f.inflate(this.f213g, viewGroup, false);
        }
        int groupId = getItem(i3).getGroupId();
        int i4 = i3 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f208b.F() && groupId != (i4 >= 0 ? getItem(i4).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f210d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i3), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
