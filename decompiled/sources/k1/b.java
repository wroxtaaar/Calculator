package k1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f5072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5073b;

    public b(float f3, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f5072a;
            f3 += ((b) cVar).f5073b;
        }
        this.f5072a = cVar;
        this.f5073b = f3;
    }

    @Override // k1.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f5072a.a(rectF) + this.f5073b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5072a.equals(bVar.f5072a) && this.f5073b == bVar.f5073b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5072a, Float.valueOf(this.f5073b)});
    }
}
