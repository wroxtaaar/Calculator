package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class t extends RecyclerView.g<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h<?> f2941c;

    /* JADX INFO: compiled from: YearGridAdapter.java */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f2942b;

        a(int i3) {
            this.f2942b = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.this.f2941c.O1(t.this.f2941c.F1().n(l.k(this.f2942b, t.this.f2941c.H1().f2916c)));
            t.this.f2941c.P1(h.k.DAY);
        }
    }

    /* JADX INFO: compiled from: YearGridAdapter.java */
    public static class b extends RecyclerView.d0 {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final TextView f2944t;

        b(TextView textView) {
            super(textView);
            this.f2944t = textView;
        }
    }

    t(h<?> hVar) {
        this.f2941c = hVar;
    }

    private View.OnClickListener y(int i3) {
        return new a(i3);
    }

    int A(int i3) {
        return this.f2941c.F1().s().f2917d + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void m(b bVar, int i3) {
        int iA = A(i3);
        String string = bVar.f2944t.getContext().getString(t0.i.mtrl_picker_navigate_to_year_description);
        bVar.f2944t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iA)));
        bVar.f2944t.setContentDescription(String.format(string, Integer.valueOf(iA)));
        c cVarG1 = this.f2941c.G1();
        Calendar calendarI = s.i();
        com.google.android.material.datepicker.b bVar2 = calendarI.get(1) == iA ? cVarG1.f2850f : cVarG1.f2848d;
        Iterator<Long> it = this.f2941c.I1().i().iterator();
        while (it.hasNext()) {
            calendarI.setTimeInMillis(it.next().longValue());
            if (calendarI.get(1) == iA) {
                bVar2 = cVarG1.f2849e;
            }
        }
        bVar2.d(bVar.f2944t);
        bVar.f2944t.setOnClickListener(y(iA));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public b o(ViewGroup viewGroup, int i3) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(t0.h.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f2941c.F1().t();
    }

    int z(int i3) {
        return i3 - this.f2941c.F1().s().f2917d;
    }
}
