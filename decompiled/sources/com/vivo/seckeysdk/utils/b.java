package com.vivo.seckeysdk.utils;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SecurityKeyConfigure.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f4280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4281c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4286h;

    public final int a(int i3) {
        int i4;
        if (i3 == 1) {
            i4 = this.f4285g;
        } else if (i3 == 2) {
            i4 = this.f4285g >> 8;
        } else {
            if (i3 != 4) {
                return 0;
            }
            i4 = this.f4285g >> 16;
        }
        return i4 & 255;
    }

    public final void b(Context context) {
        this.f4280b = context;
    }

    public final void c(String str) {
        this.f4279a = str;
    }

    public final Context d() {
        return this.f4280b;
    }

    public final void e(int i3) {
        this.f4285g = i3;
    }

    public final void f(String str) {
        this.f4282d = str;
    }

    public final int g() {
        return this.f4281c;
    }

    final String h(int i3) {
        if (i3 == 1) {
            return "jnisgmain@" + this.f4283e;
        }
        if (i3 != 2) {
            return this.f4286h;
        }
        return "jnisgmain_v2@" + this.f4283e;
    }

    public final void i(String str) {
        this.f4283e = str;
        this.f4284f = str;
        if (str == null || TextUtils.isEmpty(str)) {
            this.f4284f = "unknown";
        } else {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                this.f4284f = str.substring(iLastIndexOf + 1);
            }
        }
        if (this.f4284f.length() > 16) {
            this.f4284f = this.f4284f.substring(0, 15);
        }
    }

    public final void j() {
        this.f4281c = 4;
    }

    public final void k(String str) {
        this.f4286h = str;
    }

    public final String l() {
        return this.f4283e;
    }

    public final String m() {
        return this.f4286h;
    }
}
