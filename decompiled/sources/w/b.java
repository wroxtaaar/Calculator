package w;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: compiled from: Insets.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f6320e = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6324d;

    private b(int i3, int i4, int i5, int i6) {
        this.f6321a = i3;
        this.f6322b = i4;
        this.f6323c = i5;
        this.f6324d = i6;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f6321a, bVar2.f6321a), Math.max(bVar.f6322b, bVar2.f6322b), Math.max(bVar.f6323c, bVar2.f6323c), Math.max(bVar.f6324d, bVar2.f6324d));
    }

    public static b b(int i3, int i4, int i5, int i6) {
        return (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) ? f6320e : new b(i3, i4, i5, i6);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f6321a, this.f6322b, this.f6323c, this.f6324d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6324d == bVar.f6324d && this.f6321a == bVar.f6321a && this.f6323c == bVar.f6323c && this.f6322b == bVar.f6322b;
    }

    public int hashCode() {
        return (((((this.f6321a * 31) + this.f6322b) * 31) + this.f6323c) * 31) + this.f6324d;
    }

    public String toString() {
        return "Insets{left=" + this.f6321a + ", top=" + this.f6322b + ", right=" + this.f6323c + ", bottom=" + this.f6324d + '}';
    }
}
