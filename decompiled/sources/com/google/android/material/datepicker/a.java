package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: CalendarConstraints.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0037a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f2827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f2828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f2829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l f2830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2832g;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CalendarConstraints.java */
    class C0037a implements Parcelable.Creator<a> {
        C0037a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((l) parcel.readParcelable(l.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* JADX INFO: compiled from: CalendarConstraints.java */
    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f2833e = s.a(l.k(1900, 0).f2920g);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f2834f = s.a(l.k(2100, 11).f2920g);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f2835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f2836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f2837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f2838d;

        b(a aVar) {
            this.f2835a = f2833e;
            this.f2836b = f2834f;
            this.f2838d = f.j(Long.MIN_VALUE);
            this.f2835a = aVar.f2827b.f2920g;
            this.f2836b = aVar.f2828c.f2920g;
            this.f2837c = Long.valueOf(aVar.f2830e.f2920g);
            this.f2838d = aVar.f2829d;
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f2838d);
            l lVarL = l.l(this.f2835a);
            l lVarL2 = l.l(this.f2836b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l3 = this.f2837c;
            return new a(lVarL, lVarL2, cVar, l3 == null ? null : l.l(l3.longValue()), null);
        }

        public b b(long j3) {
            this.f2837c = Long.valueOf(j3);
            return this;
        }
    }

    /* JADX INFO: compiled from: CalendarConstraints.java */
    public interface c extends Parcelable {
        boolean e(long j3);
    }

    /* synthetic */ a(l lVar, l lVar2, c cVar, l lVar3, C0037a c0037a) {
        this(lVar, lVar2, cVar, lVar3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2827b.equals(aVar.f2827b) && this.f2828c.equals(aVar.f2828c) && d0.d.a(this.f2830e, aVar.f2830e) && this.f2829d.equals(aVar.f2829d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2827b, this.f2828c, this.f2830e, this.f2829d});
    }

    l n(l lVar) {
        if (lVar.compareTo(this.f2827b) < 0) {
            return this.f2827b;
        }
        return lVar.compareTo(this.f2828c) > 0 ? this.f2828c : lVar;
    }

    public c o() {
        return this.f2829d;
    }

    l p() {
        return this.f2828c;
    }

    int q() {
        return this.f2832g;
    }

    l r() {
        return this.f2830e;
    }

    l s() {
        return this.f2827b;
    }

    int t() {
        return this.f2831f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f2827b, 0);
        parcel.writeParcelable(this.f2828c, 0);
        parcel.writeParcelable(this.f2830e, 0);
        parcel.writeParcelable(this.f2829d, 0);
    }

    private a(l lVar, l lVar2, c cVar, l lVar3) {
        this.f2827b = lVar;
        this.f2828c = lVar2;
        this.f2830e = lVar3;
        this.f2829d = cVar;
        if (lVar3 != null && lVar.compareTo(lVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (lVar3 != null && lVar3.compareTo(lVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f2832g = lVar.t(lVar2) + 1;
        this.f2831f = (lVar2.f2917d - lVar.f2917d) + 1;
    }
}
