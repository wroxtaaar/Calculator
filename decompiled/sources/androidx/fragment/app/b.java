package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackStackState.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int[] f1276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<String> f1277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f1278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int[] f1279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f1280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f1281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f1282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f1283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final CharSequence f1284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f1285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final CharSequence f1286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ArrayList<String> f1287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final ArrayList<String> f1288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f1289o;

    /* JADX INFO: compiled from: BackStackState.java */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f1419c.size();
        this.f1276b = new int[size * 5];
        if (!aVar.f1425i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1277c = new ArrayList<>(size);
        this.f1278d = new int[size];
        this.f1279e = new int[size];
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            s.a aVar2 = aVar.f1419c.get(i3);
            int i5 = i4 + 1;
            this.f1276b[i4] = aVar2.f1436a;
            ArrayList<String> arrayList = this.f1277c;
            Fragment fragment = aVar2.f1437b;
            arrayList.add(fragment != null ? fragment.f1227f : null);
            int[] iArr = this.f1276b;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.f1438c;
            int i7 = i6 + 1;
            iArr[i6] = aVar2.f1439d;
            int i8 = i7 + 1;
            iArr[i7] = aVar2.f1440e;
            iArr[i8] = aVar2.f1441f;
            this.f1278d[i3] = aVar2.f1442g.ordinal();
            this.f1279e[i3] = aVar2.f1443h.ordinal();
            i3++;
            i4 = i8 + 1;
        }
        this.f1280f = aVar.f1424h;
        this.f1281g = aVar.f1427k;
        this.f1282h = aVar.f1275v;
        this.f1283i = aVar.f1428l;
        this.f1284j = aVar.f1429m;
        this.f1285k = aVar.f1430n;
        this.f1286l = aVar.f1431o;
        this.f1287m = aVar.f1432p;
        this.f1288n = aVar.f1433q;
        this.f1289o = aVar.f1434r;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.a j(l lVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(lVar);
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.f1276b.length) {
            s.a aVar2 = new s.a();
            int i5 = i3 + 1;
            aVar2.f1436a = this.f1276b[i3];
            if (l.p0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i4 + " base fragment #" + this.f1276b[i5]);
            }
            String str = this.f1277c.get(i4);
            if (str != null) {
                aVar2.f1437b = lVar.V(str);
            } else {
                aVar2.f1437b = null;
            }
            aVar2.f1442g = androidx.lifecycle.d.b.values()[this.f1278d[i4]];
            aVar2.f1443h = androidx.lifecycle.d.b.values()[this.f1279e[i4]];
            int[] iArr = this.f1276b;
            int i6 = i5 + 1;
            int i7 = iArr[i5];
            aVar2.f1438c = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            aVar2.f1439d = i9;
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            aVar2.f1440e = i11;
            int i12 = iArr[i10];
            aVar2.f1441f = i12;
            aVar.f1420d = i7;
            aVar.f1421e = i9;
            aVar.f1422f = i11;
            aVar.f1423g = i12;
            aVar.e(aVar2);
            i4++;
            i3 = i10 + 1;
        }
        aVar.f1424h = this.f1280f;
        aVar.f1427k = this.f1281g;
        aVar.f1275v = this.f1282h;
        aVar.f1425i = true;
        aVar.f1428l = this.f1283i;
        aVar.f1429m = this.f1284j;
        aVar.f1430n = this.f1285k;
        aVar.f1431o = this.f1286l;
        aVar.f1432p = this.f1287m;
        aVar.f1433q = this.f1288n;
        aVar.f1434r = this.f1289o;
        aVar.p(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.f1276b);
        parcel.writeStringList(this.f1277c);
        parcel.writeIntArray(this.f1278d);
        parcel.writeIntArray(this.f1279e);
        parcel.writeInt(this.f1280f);
        parcel.writeString(this.f1281g);
        parcel.writeInt(this.f1282h);
        parcel.writeInt(this.f1283i);
        TextUtils.writeToParcel(this.f1284j, parcel, 0);
        parcel.writeInt(this.f1285k);
        TextUtils.writeToParcel(this.f1286l, parcel, 0);
        parcel.writeStringList(this.f1287m);
        parcel.writeStringList(this.f1288n);
        parcel.writeInt(this.f1289o ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f1276b = parcel.createIntArray();
        this.f1277c = parcel.createStringArrayList();
        this.f1278d = parcel.createIntArray();
        this.f1279e = parcel.createIntArray();
        this.f1280f = parcel.readInt();
        this.f1281g = parcel.readString();
        this.f1282h = parcel.readInt();
        this.f1283i = parcel.readInt();
        this.f1284j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1285k = parcel.readInt();
        this.f1286l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1287m = parcel.createStringArrayList();
        this.f1288n = parcel.createStringArrayList();
        this.f1289o = parcel.readInt() != 0;
    }
}
