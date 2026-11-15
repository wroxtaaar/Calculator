package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.vivo.seckeysdk.BuildConfig;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VersionedParcelParcel.java */
/* JADX INFO: loaded from: classes.dex */
class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f2219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f2220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f2223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2226k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR, new l.a(), new l.a(), new l.a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f2220e.writeInt(-1);
        } else {
            this.f2220e.writeInt(bArr.length);
            this.f2220e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2220e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i3) {
        this.f2220e.writeInt(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f2220e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f2220e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i3 = this.f2224i;
        if (i3 >= 0) {
            int i4 = this.f2219d.get(i3);
            int iDataPosition = this.f2220e.dataPosition();
            this.f2220e.setDataPosition(i4);
            this.f2220e.writeInt(iDataPosition - i4);
            this.f2220e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f2220e;
        int iDataPosition = parcel.dataPosition();
        int i3 = this.f2225j;
        if (i3 == this.f2221f) {
            i3 = this.f2222g;
        }
        return new b(parcel, iDataPosition, i3, this.f2223h + "  ", this.f2216a, this.f2217b, this.f2218c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f2220e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int i3 = this.f2220e.readInt();
        if (i3 < 0) {
            return null;
        }
        byte[] bArr = new byte[i3];
        this.f2220e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2220e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i3) {
        while (this.f2225j < this.f2222g) {
            int i4 = this.f2226k;
            if (i4 == i3) {
                return true;
            }
            if (String.valueOf(i4).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            this.f2220e.setDataPosition(this.f2225j);
            int i5 = this.f2220e.readInt();
            this.f2226k = this.f2220e.readInt();
            this.f2225j += i5;
        }
        return this.f2226k == i3;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f2220e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f2220e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f2220e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i3) {
        a();
        this.f2224i = i3;
        this.f2219d.put(i3, this.f2220e.dataPosition());
        E(0);
        E(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z2) {
        this.f2220e.writeInt(z2 ? 1 : 0);
    }

    private b(Parcel parcel, int i3, int i4, String str, l.a<String, Method> aVar, l.a<String, Method> aVar2, l.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2219d = new SparseIntArray();
        this.f2224i = -1;
        this.f2225j = 0;
        this.f2226k = -1;
        this.f2220e = parcel;
        this.f2221f = i3;
        this.f2222g = i4;
        this.f2225j = i3;
        this.f2223h = str;
    }
}
