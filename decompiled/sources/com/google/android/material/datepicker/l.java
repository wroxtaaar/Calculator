package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: Month.java */
/* JADX INFO: loaded from: classes.dex */
final class l implements Comparable<l>, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Calendar f2915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f2916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f2917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f2918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f2919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f2920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2921h;

    /* JADX INFO: compiled from: Month.java */
    class a implements Parcelable.Creator<l> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return l.k(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i3) {
            return new l[i3];
        }
    }

    private l(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = s.d(calendar);
        this.f2915b = calendarD;
        this.f2916c = calendarD.get(2);
        this.f2917d = calendarD.get(1);
        this.f2918e = calendarD.getMaximum(7);
        this.f2919f = calendarD.getActualMaximum(5);
        this.f2920g = calendarD.getTimeInMillis();
    }

    static l k(int i3, int i4) {
        Calendar calendarK = s.k();
        calendarK.set(1, i3);
        calendarK.set(2, i4);
        return new l(calendarK);
    }

    static l l(long j3) {
        Calendar calendarK = s.k();
        calendarK.setTimeInMillis(j3);
        return new l(calendarK);
    }

    static l m() {
        return new l(s.i());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f2916c == lVar.f2916c && this.f2917d == lVar.f2917d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2916c), Integer.valueOf(this.f2917d)});
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return this.f2915b.compareTo(lVar.f2915b);
    }

    int n() {
        int firstDayOfWeek = this.f2915b.get(7) - this.f2915b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f2918e : firstDayOfWeek;
    }

    long o(int i3) {
        Calendar calendarD = s.d(this.f2915b);
        calendarD.set(5, i3);
        return calendarD.getTimeInMillis();
    }

    int p(long j3) {
        Calendar calendarD = s.d(this.f2915b);
        calendarD.setTimeInMillis(j3);
        return calendarD.get(5);
    }

    String q() {
        if (this.f2921h == null) {
            this.f2921h = e.c(this.f2915b.getTimeInMillis());
        }
        return this.f2921h;
    }

    long r() {
        return this.f2915b.getTimeInMillis();
    }

    l s(int i3) {
        Calendar calendarD = s.d(this.f2915b);
        calendarD.add(2, i3);
        return new l(calendarD);
    }

    int t(l lVar) {
        if (this.f2915b instanceof GregorianCalendar) {
            return ((lVar.f2917d - this.f2917d) * 12) + (lVar.f2916c - this.f2916c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2917d);
        parcel.writeInt(this.f2916c);
    }
}
