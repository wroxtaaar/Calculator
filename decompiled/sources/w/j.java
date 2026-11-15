package w;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, v.c.b> f6348a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    class a implements c<b0.f.b> {
        a() {
        }

        @Override // w.j.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(b0.f.b bVar) {
            return bVar.e();
        }

        @Override // w.j.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(b0.f.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    class b implements c<v.c.C0092c> {
        b() {
        }

        @Override // w.j.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(v.c.C0092c c0092c) {
            return c0092c.e();
        }

        @Override // w.j.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(v.c.C0092c c0092c) {
            return c0092c.f();
        }
    }

    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    private interface c<T> {
        int a(T t3);

        boolean b(T t3);
    }

    j() {
    }

    private void a(Typeface typeface, v.c.b bVar) {
        long j3 = j(typeface);
        if (j3 != 0) {
            this.f6348a.put(Long.valueOf(j3), bVar);
        }
    }

    private v.c.C0092c f(v.c.b bVar, int i3) {
        return (v.c.C0092c) g(bVar.a(), i3, new b());
    }

    private static <T> T g(T[] tArr, int i3, c<T> cVar) {
        int i4 = (i3 & 1) == 0 ? 400 : 700;
        boolean z2 = (i3 & 2) != 0;
        T t3 = null;
        int i5 = Integer.MAX_VALUE;
        for (T t4 : tArr) {
            int iAbs = (Math.abs(cVar.a(t4) - i4) * 2) + (cVar.b(t4) == z2 ? 0 : 1);
            if (t3 == null || i5 > iAbs) {
                t3 = t4;
                i5 = iAbs;
            }
        }
        return t3;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        } catch (NoSuchFieldException e4) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e4);
            return 0L;
        }
    }

    public Typeface b(Context context, v.c.b bVar, Resources resources, int i3) {
        v.c.C0092c c0092cF = f(bVar, i3);
        if (c0092cF == null) {
            return null;
        }
        Typeface typefaceD = d.d(context, resources, c0092cF.b(), c0092cF.a(), i3);
        a(typefaceD, bVar);
        return typefaceD;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, b0.f.b[] bVarArr, int i3) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(h(bVarArr, i3).d());
            try {
                Typeface typefaceD = d(context, inputStreamOpenInputStream);
                k.a(inputStreamOpenInputStream);
                return typefaceD;
            } catch (IOException unused) {
                k.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                k.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected Typeface d(Context context, InputStream inputStream) {
        File fileE = k.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (k.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i3, String str, int i4) {
        File fileE = k.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (k.c(fileE, resources, i3)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected b0.f.b h(b0.f.b[] bVarArr, int i3) {
        return (b0.f.b) g(bVarArr, i3, new a());
    }

    v.c.b i(Typeface typeface) {
        long j3 = j(typeface);
        if (j3 == 0) {
            return null;
        }
        return this.f6348a.get(Long.valueOf(j3));
    }
}
