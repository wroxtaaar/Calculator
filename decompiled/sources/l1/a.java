package l1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import l.g;

/* JADX INFO: compiled from: ExtendableSavedState.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends i0.a {
    public static final Parcelable.Creator<a> CREATOR = new C0074a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g<String, Bundle> f5269d;

    /* JADX INFO: renamed from: l1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExtendableSavedState.java */
    class C0074a implements Parcelable.ClassLoaderCreator<a> {
        C0074a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0074a c0074a) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f5269d + "}";
    }

    @Override // i0.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        int size = this.f5269d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = this.f5269d.i(i4);
            bundleArr[i4] = this.f5269d.m(i4);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f5269d = new g<>();
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i3 = parcel.readInt();
        String[] strArr = new String[i3];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i3];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f5269d = new g<>(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            this.f5269d.put(strArr[i4], bundleArr[i4]);
        }
    }
}
