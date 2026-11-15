package com.vivo.services.cipher.utils;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class VivoSecurityKeyResult implements Parcelable {
    public static final Parcelable.Creator<VivoSecurityKeyResult> CREATOR = new Parcelable.Creator<VivoSecurityKeyResult>() { // from class: com.vivo.services.cipher.utils.VivoSecurityKeyResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VivoSecurityKeyResult createFromParcel(Parcel parcel) {
            return new VivoSecurityKeyResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VivoSecurityKeyResult[] newArray(int i3) {
            return new VivoSecurityKeyResult[i3];
        }
    };
    public final int keyVersion;
    public final int needUpdateKey;
    public final byte[] operateData;
    public final byte[] publicKeyHash;
    public final int resultCode;
    public final String uniqueId;

    public VivoSecurityKeyResult(int i3) {
        this.resultCode = i3;
        this.operateData = null;
        this.keyVersion = -1;
        this.uniqueId = null;
        this.publicKeyHash = null;
        this.needUpdateKey = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public byte[] getOperateData() {
        return this.operateData;
    }

    public String getUniqueID() {
        return this.uniqueId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeInt(this.resultCode);
            parcel.writeByteArray(this.operateData);
            parcel.writeInt(this.keyVersion);
            parcel.writeString(this.uniqueId);
            parcel.writeByteArray(this.publicKeyHash);
            parcel.writeInt(this.needUpdateKey);
        }
    }

    public VivoSecurityKeyResult(int i3, byte[] bArr, int i4, String str, byte[] bArr2, int i5) {
        this.resultCode = i3;
        this.operateData = bArr;
        this.keyVersion = i4;
        this.uniqueId = str;
        this.publicKeyHash = bArr2;
        this.needUpdateKey = i5;
    }

    protected VivoSecurityKeyResult(Parcel parcel) {
        this.resultCode = parcel.readInt();
        this.operateData = parcel.createByteArray();
        this.keyVersion = parcel.readInt();
        this.uniqueId = parcel.readString();
        this.publicKeyHash = parcel.createByteArray();
        this.needUpdateKey = parcel.readInt();
    }
}
