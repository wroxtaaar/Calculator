package c1;

import android.content.Context;
import android.graphics.Color;
import h1.b;
import z0.c;

/* JADX INFO: compiled from: ElevationOverlayProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f2491f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f2496e;

    public a(Context context) {
        this(b.b(context, t0.b.elevationOverlayEnabled, false), c.b(context, t0.b.elevationOverlayColor, 0), c.b(context, t0.b.elevationOverlayAccentColor, 0), c.b(context, t0.b.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean e(int i3) {
        return w.a.h(i3, 255) == this.f2495d;
    }

    public float a(float f3) {
        float f4 = this.f2496e;
        if (f4 <= 0.0f || f3 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f3 / f4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i3, float f3) {
        int i4;
        float fA = a(f3);
        int iAlpha = Color.alpha(i3);
        int iH = c.h(w.a.h(i3, 255), this.f2493b, fA);
        if (fA > 0.0f && (i4 = this.f2494c) != 0) {
            iH = c.g(iH, w.a.h(i4, f2491f));
        }
        return w.a.h(iH, iAlpha);
    }

    public int c(int i3, float f3) {
        return (this.f2492a && e(i3)) ? b(i3, f3) : i3;
    }

    public boolean d() {
        return this.f2492a;
    }

    public a(boolean z2, int i3, int i4, int i5, float f3) {
        this.f2492a = z2;
        this.f2493b = i3;
        this.f2494c = i4;
        this.f2495d = i5;
        this.f2496e = f3;
    }
}
