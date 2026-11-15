package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: FragmentState.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f1398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f1399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f1400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f1401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f1402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f1403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f1404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f1405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f1406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Bundle f1407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f1408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final int f1409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Bundle f1410n;

    /* JADX INFO: compiled from: FragmentState.java */
    static class a implements Parcelable.Creator<p> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p[] newArray(int i3) {
            return new p[i3];
        }
    }

    p(Fragment fragment) {
        this.f1398b = fragment.getClass().getName();
        this.f1399c = fragment.f1227f;
        this.f1400d = fragment.f1235n;
        this.f1401e = fragment.f1244w;
        this.f1402f = fragment.f1245x;
        this.f1403g = fragment.f1246y;
        this.f1404h = fragment.B;
        this.f1405i = fragment.f1234m;
        this.f1406j = fragment.A;
        this.f1407k = fragment.f1228g;
        this.f1408l = fragment.f1247z;
        this.f1409m = fragment.R.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1398b);
        sb.append(" (");
        sb.append(this.f1399c);
        sb.append(")}:");
        if (this.f1400d) {
            sb.append(" fromLayout");
        }
        if (this.f1402f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1402f));
        }
        String str = this.f1403g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1403g);
        }
        if (this.f1404h) {
            sb.append(" retainInstance");
        }
        if (this.f1405i) {
            sb.append(" removing");
        }
        if (this.f1406j) {
            sb.append(" detached");
        }
        if (this.f1408l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f1398b);
        parcel.writeString(this.f1399c);
        parcel.writeInt(this.f1400d ? 1 : 0);
        parcel.writeInt(this.f1401e);
        parcel.writeInt(this.f1402f);
        parcel.writeString(this.f1403g);
        parcel.writeInt(this.f1404h ? 1 : 0);
        parcel.writeInt(this.f1405i ? 1 : 0);
        parcel.writeInt(this.f1406j ? 1 : 0);
        parcel.writeBundle(this.f1407k);
        parcel.writeInt(this.f1408l ? 1 : 0);
        parcel.writeBundle(this.f1410n);
        parcel.writeInt(this.f1409m);
    }

    p(Parcel parcel) {
        this.f1398b = parcel.readString();
        this.f1399c = parcel.readString();
        this.f1400d = parcel.readInt() != 0;
        this.f1401e = parcel.readInt();
        this.f1402f = parcel.readInt();
        this.f1403g = parcel.readString();
        this.f1404h = parcel.readInt() != 0;
        this.f1405i = parcel.readInt() != 0;
        this.f1406j = parcel.readInt() != 0;
        this.f1407k = parcel.readBundle();
        this.f1408l = parcel.readInt() != 0;
        this.f1410n = parcel.readBundle();
        this.f1409m = parcel.readInt();
    }
}
