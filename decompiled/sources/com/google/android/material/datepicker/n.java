package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class n extends RecyclerView.g<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.material.datepicker.a f2928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d<?> f2929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h.l f2930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2931f;

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f2932b;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f2932b = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (this.f2932b.getAdapter().n(i3)) {
                n.this.f2930e.a(this.f2932b.getAdapter().getItem(i3).longValue());
            }
        }
    }

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    public static class b extends RecyclerView.d0 {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final TextView f2934t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final MaterialCalendarGridView f2935u;

        b(LinearLayout linearLayout, boolean z2) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(t0.f.month_title);
            this.f2934t = textView;
            e0.t.n0(textView, true);
            this.f2935u = (MaterialCalendarGridView) linearLayout.findViewById(t0.f.month_grid);
            if (z2) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    n(Context context, d<?> dVar, com.google.android.material.datepicker.a aVar, h.l lVar) {
        l lVarS = aVar.s();
        l lVarP = aVar.p();
        l lVarR = aVar.r();
        if (lVarS.compareTo(lVarR) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (lVarR.compareTo(lVarP) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f2931f = (m.f2922g * h.J1(context)) + (i.U1(context) ? h.J1(context) : 0);
        this.f2928c = aVar;
        this.f2929d = dVar;
        this.f2930e = lVar;
        v(true);
    }

    int A(l lVar) {
        return this.f2928c.s().t(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void m(b bVar, int i3) {
        l lVarS = this.f2928c.s().s(i3);
        bVar.f2934t.setText(lVarS.q());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f2935u.findViewById(t0.f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !lVarS.equals(materialCalendarGridView.getAdapter().f2923b)) {
            m mVar = new m(lVarS, this.f2929d, this.f2928c);
            materialCalendarGridView.setNumColumns(lVarS.f2918e);
            materialCalendarGridView.setAdapter((ListAdapter) mVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().m(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public b o(ViewGroup viewGroup, int i3) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(t0.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!i.U1(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f2931f));
        return new b(linearLayout, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f2928c.q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i3) {
        return this.f2928c.s().s(i3).r();
    }

    l y(int i3) {
        return this.f2928c.s().s(i3);
    }

    CharSequence z(int i3) {
        return y(i3).q();
    }
}
