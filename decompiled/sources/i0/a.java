package i0;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: AbsSavedState.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class a implements Parcelable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parcelable f4883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4882c = new C0066a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: i0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsSavedState.java */
    class C0066a extends a {
        C0066a() {
            super((C0066a) null);
        }
    }

    /* JADX INFO: compiled from: AbsSavedState.java */
    class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f4882c;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* synthetic */ a(C0066a c0066a) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable j() {
        return this.f4883b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f4883b, i3);
    }

    private a() {
        this.f4883b = null;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f4883b = parcelable == f4882c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f4883b = parcelable == null ? f4882c : parcelable;
    }
}
