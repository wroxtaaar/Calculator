package com.vivo.seckeysdk.utils;

import android.text.TextUtils;
import k2.d;
import l2.i;

/* JADX INFO: loaded from: classes.dex */
public class ProtocolPackage {
    private byte[] mData;
    private int mKeyVersion;
    private String mToken;
    private int mType;

    public ProtocolPackage() {
    }

    public static ProtocolPackage buildProtocolPackage(byte[] bArr) throws SecurityKeyException {
        k2.a aVarB = d.b(bArr);
        k2.b bVarH = aVarB.h();
        if (bVarH == null) {
            i.k("SecurityKey", "buildProtocolPackage head is null!");
            throw new SecurityKeyException("crypto header problem", 150);
        }
        String strA = bVarH.a();
        if (TextUtils.isEmpty(strA)) {
            i.k("SecurityKey", "buildProtocolPackage packageName is empty!");
            throw new SecurityKeyException("crypto header problem", 150);
        }
        byte[] bArrI = aVarB.i();
        if (bArrI != null) {
            return new ProtocolPackage(strA, bVarH.b(), bVarH.c(), bArrI);
        }
        i.k("SecurityKey", "buildProtocolPackage body is null!");
        throw new SecurityKeyException("crypto body problem", 151);
    }

    public static String kv2EnvStr(int i3) {
        if (i3 <= 0 || i3 > 255) {
            return "Invalid KeyVersion";
        }
        if (i3 > 230) {
            return "Test";
        }
        return i3 > 220 ? "Pre" : "Online";
    }

    public byte[] getCipherData() {
        return this.mData;
    }

    public int getCipherMode() {
        return this.mToken.contains("jnisgmain") ? 3 : 2;
    }

    public byte[] getData() {
        return this.mData;
    }

    public byte[] getHeaderbytes() throws SecurityKeyException {
        k2.a aVarA = d.a(1);
        aVarA.j(this.mKeyVersion);
        aVarA.f(this.mType);
        aVarA.g(this.mToken);
        aVarA.k();
        return aVarA.d();
    }

    public int getKeyVersion() {
        return this.mKeyVersion;
    }

    public String getToken() {
        return this.mToken;
    }

    public int getType() {
        return this.mType;
    }

    public byte[] getbytes() throws SecurityKeyException {
        k2.a aVarA = d.a(1);
        aVarA.j(this.mKeyVersion);
        aVarA.f(this.mType);
        aVarA.e(this.mData);
        aVarA.g(this.mToken);
        aVarA.k();
        return aVarA.l();
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setKeyVersion(int i3) {
        this.mKeyVersion = i3;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ProtocolPackage keyVersion " + this.mKeyVersion + ",");
        stringBuffer.append("package token " + this.mToken + ",");
        stringBuffer.append("package type " + this.mType + ",");
        stringBuffer.append("package data len= " + this.mData.length + ",");
        stringBuffer.append("package env= ");
        stringBuffer.append(kv2EnvStr(this.mKeyVersion));
        return stringBuffer.toString();
    }

    public ProtocolPackage(String str, int i3, int i4, byte[] bArr) {
        this.mKeyVersion = i3;
        this.mType = i4;
        this.mData = bArr;
        this.mToken = str;
    }
}
