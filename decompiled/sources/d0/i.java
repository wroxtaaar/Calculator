package d0;

import java.util.Objects;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static void a(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int b(int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T c(T t3) {
        Objects.requireNonNull(t3);
        return t3;
    }

    public static <T> T d(T t3, Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
