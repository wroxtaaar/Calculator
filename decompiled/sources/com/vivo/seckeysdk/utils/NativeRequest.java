package com.vivo.seckeysdk.utils;

/* JADX INFO: loaded from: classes.dex */
public class NativeRequest {
    private int operateType = 0;
    private int encryptType = 0;
    private byte[] data = null;
    private int keyVersion = 0;

    public byte[] getData() {
        return this.data;
    }

    public int getEncryptType() {
        return this.encryptType;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setEncryptType(int i3) {
        this.encryptType = i3;
    }

    public void setKeyVersion(int i3) {
        this.keyVersion = i3;
    }

    public void setOperateType(int i3) {
        this.operateType = i3;
    }
}
