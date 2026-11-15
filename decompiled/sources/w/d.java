package w;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: compiled from: TypefaceCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final j f6329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l.e<String, Typeface> f6330b;

    /* JADX INFO: compiled from: TypefaceCompat.java */
    public static class a extends b0.f.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v.f.a f6331a;

        public a(v.f.a aVar) {
            this.f6331a = aVar;
        }

        @Override // b0.f.c
        public void a(int i3) {
            v.f.a aVar = this.f6331a;
            if (aVar != null) {
                aVar.d(i3);
            }
        }

        @Override // b0.f.c
        public void b(Typeface typeface) {
            v.f.a aVar = this.f6331a;
            if (aVar != null) {
                aVar.e(typeface);
            }
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            f6329a = new i();
        } else if (i3 >= 28) {
            f6329a = new h();
        } else if (i3 >= 26) {
            f6329a = new g();
        } else if (i3 >= 24 && f.m()) {
            f6329a = new f();
        } else if (i3 >= 21) {
            f6329a = new e();
        } else {
            f6329a = new j();
        }
        f6330b = new l.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i3) {
        Typeface typefaceG;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceG = g(context, typeface, i3)) == null) ? Typeface.create(typeface, i3) : typefaceG;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, b0.f.b[] bVarArr, int i3) {
        return f6329a.c(context, cancellationSignal, bVarArr, i3);
    }

    public static Typeface c(Context context, v.c.a aVar, Resources resources, int i3, int i4, v.f.a aVar2, Handler handler, boolean z2) {
        Typeface typefaceB;
        if (aVar instanceof v.c.d) {
            v.c.d dVar = (v.c.d) aVar;
            Typeface typefaceH = h(dVar.c());
            if (typefaceH != null) {
                if (aVar2 != null) {
                    aVar2.b(typefaceH, handler);
                }
                return typefaceH;
            }
            boolean z3 = !z2 ? aVar2 != null : dVar.a() != 0;
            int iD = z2 ? dVar.d() : -1;
            typefaceB = b0.f.a(context, dVar.b(), i4, z3, iD, v.f.a.c(handler), new a(aVar2));
        } else {
            typefaceB = f6329a.b(context, (v.c.b) aVar, resources, i4);
            if (aVar2 != null) {
                if (typefaceB != null) {
                    aVar2.b(typefaceB, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f6330b.d(e(resources, i3, i4), typefaceB);
        }
        return typefaceB;
    }

    public static Typeface d(Context context, Resources resources, int i3, String str, int i4) {
        Typeface typefaceE = f6329a.e(context, resources, i3, str, i4);
        if (typefaceE != null) {
            f6330b.d(e(resources, i3, i4), typefaceE);
        }
        return typefaceE;
    }

    private static String e(Resources resources, int i3, int i4) {
        return resources.getResourcePackageName(i3) + "-" + i3 + "-" + i4;
    }

    public static Typeface f(Resources resources, int i3, int i4) {
        return f6330b.c(e(resources, i3, i4));
    }

    private static Typeface g(Context context, Typeface typeface, int i3) {
        j jVar = f6329a;
        v.c.b bVarI = jVar.i(typeface);
        if (bVarI == null) {
            return null;
        }
        return jVar.b(context, bVarI, context.getResources(), i3);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
