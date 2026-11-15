package y2;

/* JADX INFO: compiled from: SyntaxException.java */
/* JADX INFO: loaded from: classes.dex */
public class x extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6591d;

    x a(String str, int i3) {
        this.f6590c = str;
        this.f6591d = i3;
        fillInStackTrace();
        return this;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "SyntaxException: " + this.f6590c + " in '" + this.f6589b + "' at position " + this.f6591d;
    }
}
