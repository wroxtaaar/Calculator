package q1;

import java.math.BigDecimal;

/* JADX INFO: compiled from: LazilyParsedNumber.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends Number {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5901b;

    public g(String str) {
        this.f5901b = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f5901b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f5901b;
        String str2 = ((g) obj).f5901b;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f5901b);
    }

    public int hashCode() {
        return this.f5901b.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f5901b);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f5901b).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.f5901b);
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f5901b);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f5901b).longValue();
        }
    }

    public String toString() {
        return this.f5901b;
    }
}
