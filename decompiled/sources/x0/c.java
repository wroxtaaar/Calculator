package x0;

import android.os.Build;

/* JADX INFO: compiled from: CircularRevealHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6428a;

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            f6428a = 2;
        } else if (i3 >= 18) {
            f6428a = 1;
        } else {
            f6428a = 0;
        }
    }
}
