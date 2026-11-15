package b2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.vivo.calculator.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: CurrencyAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends BaseAdapter implements SectionIndexer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<c2.c> f2420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f2421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f2422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences f2423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences.Editor f2424f;

    /* JADX INFO: compiled from: CurrencyAdapter.java */
    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f2425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f2426b;

        private b() {
        }
    }

    /* JADX INFO: compiled from: CurrencyAdapter.java */
    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f2428a;

        private c() {
        }
    }

    public a(Context context, ArrayList<c2.c> arrayList) {
        this.f2421c = LayoutInflater.from(context);
        this.f2420b = arrayList;
        this.f2422d = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f2423e = defaultSharedPreferences;
        this.f2424f = defaultSharedPreferences.edit();
    }

    public void a(ArrayList<c2.c> arrayList) {
        this.f2420b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2420b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f2420b.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        ArrayList<c2.c> arrayList = this.f2420b;
        if (arrayList == null || i3 >= arrayList.size()) {
            return super.getItemViewType(i3);
        }
        return this.f2420b.get(i3).f() ? 0 : 1;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i3) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i3) {
        return i3;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return new Object[0];
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View viewInflate;
        c cVar;
        b bVar;
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 0) {
            if (view == null) {
                cVar = new c();
                viewInflate = this.f2421c.inflate(R.layout.item_tag, (ViewGroup) null);
                cVar.f2428a = (TextView) viewInflate.findViewById(R.id.item_tag);
                viewInflate.setTag(cVar);
            } else {
                viewInflate = view;
                cVar = (c) view.getTag();
            }
            cVar.f2428a.setText(this.f2420b.get(i3).c());
            if (g2.b.b(this.f2422d)) {
                cVar.f2428a.setTextColor(this.f2422d.getColor(R.color.edit_text_color_material));
            } else {
                cVar.f2428a.setTextColor(this.f2422d.getColor(R.color.edit_text_color));
            }
            return viewInflate;
        }
        if (itemViewType != 1) {
            return view;
        }
        if (view == null) {
            view = this.f2421c.inflate(R.layout.item_list, (ViewGroup) null);
            bVar = new b();
            bVar.f2425a = (TextView) view.findViewById(R.id.country_info);
            bVar.f2426b = (TextView) view.findViewById(R.id.country_info_code);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f2425a.setText(this.f2420b.get(i3).c());
        bVar.f2426b.setText(this.f2420b.get(i3).b());
        if (g2.b.b(this.f2422d)) {
            bVar.f2425a.setTextColor(this.f2422d.getColor(R.color.edit_text_color_material));
            bVar.f2426b.setTextColor(this.f2422d.getColor(R.color.code_text_color_material));
            return view;
        }
        bVar.f2425a.setTextColor(this.f2422d.getColor(R.color.edit_text_color));
        bVar.f2426b.setTextColor(this.f2422d.getColor(R.color.currency_code_text_color));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        if (this.f2420b.get(i3).f()) {
            return false;
        }
        return super.isEnabled(i3);
    }
}
