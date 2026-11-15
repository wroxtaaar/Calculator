package o1;

import java.math.BigInteger;

/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f5450a;

    public o(Boolean bool) {
        this.f5450a = q1.a.b(bool);
    }

    private static boolean o(o oVar) {
        Object obj = oVar.f5450a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f5450a == null) {
            return oVar.f5450a == null;
        }
        if (o(this) && o(oVar)) {
            return l().longValue() == oVar.l().longValue();
        }
        Object obj2 = this.f5450a;
        if (!(obj2 instanceof Number) || !(oVar.f5450a instanceof Number)) {
            return obj2.equals(oVar.f5450a);
        }
        double dDoubleValue = l().doubleValue();
        double dDoubleValue2 = oVar.l().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public boolean h() {
        return n() ? ((Boolean) this.f5450a).booleanValue() : Boolean.parseBoolean(m());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f5450a == null) {
            return 31;
        }
        if (o(this)) {
            jDoubleToLongBits = l().longValue();
        } else {
            Object obj = this.f5450a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(l().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public double i() {
        return p() ? l().doubleValue() : Double.parseDouble(m());
    }

    public int j() {
        return p() ? l().intValue() : Integer.parseInt(m());
    }

    public long k() {
        return p() ? l().longValue() : Long.parseLong(m());
    }

    public Number l() {
        Object obj = this.f5450a;
        return obj instanceof String ? new q1.g((String) obj) : (Number) obj;
    }

    public String m() {
        if (p()) {
            return l().toString();
        }
        return n() ? ((Boolean) this.f5450a).toString() : (String) this.f5450a;
    }

    public boolean n() {
        return this.f5450a instanceof Boolean;
    }

    public boolean p() {
        return this.f5450a instanceof Number;
    }

    public boolean q() {
        return this.f5450a instanceof String;
    }

    public o(Number number) {
        this.f5450a = q1.a.b(number);
    }

    public o(String str) {
        this.f5450a = q1.a.b(str);
    }
}
