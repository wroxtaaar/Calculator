package com.vivo.seckeysdk.utils;

import com.vivo.seckeysdk.BuildConfig;
import l2.i;

/* JADX INFO: loaded from: classes.dex */
public class NativeResponse {
    private int err;
    private int keyVersion;
    private byte[] output;
    private byte[] pubicKeyHash;

    public int getErr() {
        return this.err;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public byte[] getOutput() {
        return this.output;
    }

    public byte[] getPubicKeyHash() {
        return this.pubicKeyHash;
    }

    public void setErr(int i3) {
        this.err = i3;
    }

    public void setKeyVersion(int i3) {
        this.keyVersion = i3;
    }

    public void setOutput(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            i.d("SecurityKey", "output is null");
        }
        this.output = bArr;
    }

    public void setPubicKeyHash(byte[] bArr) {
        this.pubicKeyHash = bArr;
    }

    public String toString() {
        String str = (BuildConfig.FLAVOR + "err:" + this.err + ";") + "key version:" + this.keyVersion + ";";
        byte[] bArr = this.output;
        if (bArr != null && bArr.length != 0) {
            str = str + "output:" + new String(this.output) + ";";
        }
        byte[] bArr2 = this.pubicKeyHash;
        if (bArr2 == null || bArr2.length == 0) {
            return str;
        }
        return str + "pubicKeyHash:" + new String(this.pubicKeyHash) + ";";
    }
}
