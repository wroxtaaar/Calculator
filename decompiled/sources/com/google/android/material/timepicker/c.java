package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: TimeModel.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.material.timepicker.a f3422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.material.timepicker.a f3423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f3424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f3425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f3427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3428h;

    /* JADX INFO: compiled from: TimeModel.java */
    class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c() {
        this(0);
    }

    public static String j(Resources resources, CharSequence charSequence) {
        return k(resources, charSequence, "%02d");
    }

    public static String k(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int l(int i3) {
        return i3 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3425e == cVar.f3425e && this.f3426f == cVar.f3426f && this.f3424d == cVar.f3424d && this.f3427g == cVar.f3427g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3424d), Integer.valueOf(this.f3425e), Integer.valueOf(this.f3426f), Integer.valueOf(this.f3427g)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f3425e);
        parcel.writeInt(this.f3426f);
        parcel.writeInt(this.f3427g);
        parcel.writeInt(this.f3424d);
    }

    public c(int i3) {
        this(0, 0, 10, i3);
    }

    public c(int i3, int i4, int i5, int i6) {
        this.f3425e = i3;
        this.f3426f = i4;
        this.f3427g = i5;
        this.f3424d = i6;
        this.f3428h = l(i3);
        this.f3422b = new com.google.android.material.timepicker.a(59);
        this.f3423c = new com.google.android.material.timepicker.a(i6 == 1 ? 24 : 12);
    }

    protected c(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
