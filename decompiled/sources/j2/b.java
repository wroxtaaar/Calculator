package j2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: VivoSecurityKeyResult.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f5012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f5015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5016g;

    /* JADX INFO: compiled from: VivoSecurityKeyResult.java */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(int i3) {
        this.f5011b = i3;
        this.f5012c = null;
        this.f5013d = -1;
        this.f5014e = null;
        this.f5015f = null;
        this.f5016g = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeInt(this.f5011b);
            parcel.writeByteArray(this.f5012c);
            parcel.writeInt(this.f5013d);
            parcel.writeString(this.f5014e);
            parcel.writeByteArray(this.f5015f);
            parcel.writeInt(this.f5016g);
        }
    }

    public b(int i3, byte[] bArr, int i4, String str, byte[] bArr2, int i5) {
        this.f5011b = i3;
        this.f5012c = bArr;
        this.f5013d = i4;
        this.f5014e = str;
        this.f5015f = bArr2;
        this.f5016g = i5;
    }

    protected b(Parcel parcel) {
        this.f5011b = parcel.readInt();
        this.f5012c = parcel.createByteArray();
        this.f5013d = parcel.readInt();
        this.f5014e = parcel.readString();
        this.f5015f = parcel.createByteArray();
        this.f5016g = parcel.readInt();
    }
}
