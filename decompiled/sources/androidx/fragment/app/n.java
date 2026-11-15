package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentManagerState.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<p> f1386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<String> f1387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b[] f1388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f1390f;

    /* JADX INFO: compiled from: FragmentManagerState.java */
    static class a implements Parcelable.Creator<n> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i3) {
            return new n[i3];
        }
    }

    public n() {
        this.f1390f = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f1386b);
        parcel.writeStringList(this.f1387c);
        parcel.writeTypedArray(this.f1388d, i3);
        parcel.writeInt(this.f1389e);
        parcel.writeString(this.f1390f);
    }

    public n(Parcel parcel) {
        this.f1390f = null;
        this.f1386b = parcel.createTypedArrayList(p.CREATOR);
        this.f1387c = parcel.createStringArrayList();
        this.f1388d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1389e = parcel.readInt();
        this.f1390f = parcel.readString();
    }
}
