package q1;

import java.util.Objects;

/* JADX INFO: compiled from: $Gson$Preconditions.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t3) {
        Objects.requireNonNull(t3);
        return t3;
    }
}
