package y2;

/* JADX INFO: compiled from: ArityException.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends RuntimeException {
    public a(String str) {
        super(str);
    }

    public a(int i3) {
        this("Didn't expect " + i3 + " arguments");
    }
}
