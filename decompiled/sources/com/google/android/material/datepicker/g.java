package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class g extends BaseAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f2854e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Calendar f2855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2857d;

    static {
        f2854e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public g() {
        Calendar calendarK = s.k();
        this.f2855b = calendarK;
        this.f2856c = calendarK.getMaximum(7);
        this.f2857d = calendarK.getFirstDayOfWeek();
    }

    private int b(int i3) {
        int i4 = i3 + this.f2857d;
        int i5 = this.f2856c;
        return i4 > i5 ? i4 - i5 : i4;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i3) {
        if (i3 >= this.f2856c) {
            return null;
        }
        return Integer.valueOf(b(i3));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2856c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(t0.h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f2855b.set(7, b(i3));
        textView.setText(this.f2855b.getDisplayName(7, f2854e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(t0.i.mtrl_picker_day_of_week_column_header), this.f2855b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
