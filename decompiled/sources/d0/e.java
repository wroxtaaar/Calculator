package d0;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public class e<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f4502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f4503b;

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return d.a(eVar.f4502a, this.f4502a) && d.a(eVar.f4503b, this.f4503b);
    }

    public int hashCode() {
        F f3 = this.f4502a;
        int iHashCode = f3 == null ? 0 : f3.hashCode();
        S s3 = this.f4503b;
        return iHashCode ^ (s3 != null ? s3.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f4502a + " " + this.f4503b + "}";
    }
}
