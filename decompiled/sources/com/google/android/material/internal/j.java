package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes.dex */
final class j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f3123n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f3124o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Constructor<StaticLayout> f3125p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static Object f3126q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f3127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f3128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3129c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3131e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3138l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3130d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Layout.Alignment f3132f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3133g = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f3134h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f3135i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3136j = f3123n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3137k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextUtils.TruncateAt f3139m = null;

    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        f3123n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private j(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.f3127a = charSequence;
        this.f3128b = textPaint;
        this.f3129c = i3;
        this.f3131e = charSequence.length();
    }

    private void b() throws a {
        Class<?> cls;
        if (f3124o) {
            return;
        }
        try {
            boolean z2 = this.f3138l && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                f3126q = z2 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = j.class.getClassLoader();
                String str = this.f3138l ? "RTL" : "LTR";
                Class<?> clsLoadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> clsLoadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                f3126q = clsLoadClass2.getField(str).get(clsLoadClass2);
                cls = clsLoadClass;
            }
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
            f3125p = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f3124o = true;
        } catch (Exception e3) {
            throw new a(e3);
        }
    }

    public static j c(CharSequence charSequence, TextPaint textPaint, int i3) {
        return new j(charSequence, textPaint, i3);
    }

    public StaticLayout a() throws a {
        if (this.f3127a == null) {
            this.f3127a = BuildConfig.FLAVOR;
        }
        int iMax = Math.max(0, this.f3129c);
        CharSequence charSequenceEllipsize = this.f3127a;
        if (this.f3133g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f3128b, iMax, this.f3139m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f3131e);
        this.f3131e = iMin;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) d0.i.c(f3125p)).newInstance(charSequenceEllipsize, Integer.valueOf(this.f3130d), Integer.valueOf(this.f3131e), this.f3128b, Integer.valueOf(iMax), this.f3132f, d0.i.c(f3126q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f3137k), null, Integer.valueOf(iMax), Integer.valueOf(this.f3133g));
            } catch (Exception e3) {
                throw new a(e3);
            }
        }
        if (this.f3138l && this.f3133g == 1) {
            this.f3132f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f3130d, iMin, this.f3128b, iMax);
        builderObtain.setAlignment(this.f3132f);
        builderObtain.setIncludePad(this.f3137k);
        builderObtain.setTextDirection(this.f3138l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f3139m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f3133g);
        float f3 = this.f3134h;
        if (f3 != 0.0f || this.f3135i != 1.0f) {
            builderObtain.setLineSpacing(f3, this.f3135i);
        }
        if (this.f3133g > 1) {
            builderObtain.setHyphenationFrequency(this.f3136j);
        }
        return builderObtain.build();
    }

    public j d(Layout.Alignment alignment) {
        this.f3132f = alignment;
        return this;
    }

    public j e(TextUtils.TruncateAt truncateAt) {
        this.f3139m = truncateAt;
        return this;
    }

    public j f(int i3) {
        this.f3136j = i3;
        return this;
    }

    public j g(boolean z2) {
        this.f3137k = z2;
        return this;
    }

    public j h(boolean z2) {
        this.f3138l = z2;
        return this;
    }

    public j i(float f3, float f4) {
        this.f3134h = f3;
        this.f3135i = f4;
        return this;
    }

    public j j(int i3) {
        this.f3133g = i3;
        return this;
    }
}
