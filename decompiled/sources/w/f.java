package w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: TypefaceCompatApi24Impl.java */
/* JADX INFO: loaded from: classes.dex */
class f extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f6337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor<?> f6338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f6339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f6340e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi24Impl", e3.getClass().getName(), e3);
            cls = null;
            method = null;
            method2 = null;
        }
        f6338c = constructor;
        f6337b = cls;
        f6339d = method2;
        f6340e = method;
    }

    f() {
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i3, int i4, boolean z2) {
        try {
            return ((Boolean) f6339d.invoke(obj, byteBuffer, Integer.valueOf(i3), null, Integer.valueOf(i4), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f6337b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f6340e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = f6339d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            return f6338c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // w.j
    public Typeface b(Context context, v.c.b bVar, Resources resources, int i3) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (v.c.C0092c c0092c : bVar.a()) {
            ByteBuffer byteBufferB = k.b(context, resources, c0092c.b());
            if (byteBufferB == null || !k(objN, byteBufferB, c0092c.c(), c0092c.e(), c0092c.f())) {
                return null;
            }
        }
        return l(objN);
    }

    @Override // w.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b0.f.b[] bVarArr, int i3) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        l.g gVar = new l.g();
        for (b0.f.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) gVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = k.f(context, cancellationSignal, uriD);
                gVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !k(objN, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceL = l(objN);
        if (typefaceL == null) {
            return null;
        }
        return Typeface.create(typefaceL, i3);
    }
}
