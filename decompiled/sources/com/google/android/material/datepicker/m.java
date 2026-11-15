package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class m extends BaseAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f2922g = s.k().getMaximum(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final l f2923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final d<?> f2924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Collection<Long> f2925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    c f2926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final a f2927f;

    m(l lVar, d<?> dVar, a aVar) {
        this.f2923b = lVar;
        this.f2924c = dVar;
        this.f2927f = aVar;
        this.f2925d = dVar.i();
    }

    private void e(Context context) {
        if (this.f2926e == null) {
            this.f2926e = new c(context);
        }
    }

    private boolean h(long j3) {
        Iterator<Long> it = this.f2924c.i().iterator();
        while (it.hasNext()) {
            if (s.a(j3) == s.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(TextView textView, long j3) {
        b bVar;
        if (textView == null) {
            return;
        }
        if (this.f2927f.o().e(j3)) {
            textView.setEnabled(true);
            if (h(j3)) {
                bVar = this.f2926e.f2846b;
            } else {
                bVar = s.i().getTimeInMillis() == j3 ? this.f2926e.f2847c : this.f2926e.f2845a;
            }
        } else {
            textView.setEnabled(false);
            bVar = this.f2926e.f2851g;
        }
        bVar.d(textView);
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j3) {
        if (l.l(j3).equals(this.f2923b)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f2923b.p(j3)) - materialCalendarGridView.getFirstVisiblePosition()), j3);
        }
    }

    int a(int i3) {
        return b() + (i3 - 1);
    }

    int b() {
        return this.f2923b.n();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i3) {
        if (i3 < this.f2923b.n() || i3 > i()) {
            return null;
        }
        return Long.valueOf(this.f2923b.o(j(i3)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0075  */
    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TextView getView(int i3, View view, ViewGroup viewGroup) {
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(t0.h.mtrl_calendar_day, viewGroup, false);
        }
        int iB = i3 - b();
        if (iB >= 0) {
            l lVar = this.f2923b;
            if (iB >= lVar.f2919f) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                int i4 = iB + 1;
                textView.setTag(lVar);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i4)));
                long jO = this.f2923b.o(i4);
                if (this.f2923b.f2917d == l.m().f2917d) {
                    textView.setContentDescription(e.a(jO));
                } else {
                    textView.setContentDescription(e.d(jO));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
        }
        Long item = getItem(i3);
        if (item == null) {
            return textView;
        }
        k(textView, item.longValue());
        return textView;
    }

    boolean f(int i3) {
        return i3 % this.f2923b.f2918e == 0;
    }

    boolean g(int i3) {
        return (i3 + 1) % this.f2923b.f2918e == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2923b.f2919f + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3 / this.f2923b.f2918e;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i() {
        return (this.f2923b.n() + this.f2923b.f2919f) - 1;
    }

    int j(int i3) {
        return (i3 - this.f2923b.n()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f2925d.iterator();
        while (it.hasNext()) {
            l(materialCalendarGridView, it.next().longValue());
        }
        d<?> dVar = this.f2924c;
        if (dVar != null) {
            Iterator<Long> it2 = dVar.i().iterator();
            while (it2.hasNext()) {
                l(materialCalendarGridView, it2.next().longValue());
            }
            this.f2925d = this.f2924c.i();
        }
    }

    boolean n(int i3) {
        return i3 >= b() && i3 <= i();
    }
}
