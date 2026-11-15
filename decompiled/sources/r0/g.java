package r0;

import android.text.TextUtils;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6001b;

    public g(String str, String str2) {
        this.f6000a = str;
        this.f6001b = str2;
    }

    public final String a() {
        return this.f6000a;
    }

    public final String b() {
        return this.f6001b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f6000a, gVar.f6000a) && TextUtils.equals(this.f6001b, gVar.f6001b);
    }

    public int hashCode() {
        return (this.f6000a.hashCode() * 31) + this.f6001b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f6000a + ",value=" + this.f6001b + "]";
    }
}
