package k1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: RelativeCornerSize.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5125a;

    public i(float f3) {
        this.f5125a = f3;
    }

    @Override // k1.c
    public float a(RectF rectF) {
        return this.f5125a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f5125a == ((i) obj).f5125a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5125a)});
    }
}
