package w;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: compiled from: TypefaceCompatApi26Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final Class<?> f6341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final Constructor<?> f6342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final Method f6343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final Method f6344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final Method f6345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final Method f6346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final Method f6347m;

    public g() throws NoSuchMethodException {
        Method methodX;
        Constructor<?> constructorZ;
        Method methodV;
        Method methodW;
        Method methodA;
        Method methodU;
        Class<?> cls = null;
        try {
            Class<?> clsY = y();
            constructorZ = z(clsY);
            methodV = v(clsY);
            methodW = w(clsY);
            methodA = A(clsY);
            methodU = u(clsY);
            methodX = x(clsY);
            cls = clsY;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e3.getClass().getName(), e3);
            methodX = null;
            constructorZ = null;
            methodV = null;
            methodW = null;
            methodA = null;
            methodU = null;
        }
        this.f6341g = cls;
        this.f6342h = constructorZ;
        this.f6343i = methodV;
        this.f6344j = methodW;
        this.f6345k = methodA;
        this.f6346l = methodU;
        this.f6347m = methodX;
    }

    private Object o() {
        try {
            return this.f6342h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void p(Object obj) {
        try {
            this.f6346l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean q(Context context, Object obj, String str, int i3, int i4, int i5, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f6343i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r(Object obj, ByteBuffer byteBuffer, int i3, int i4, int i5) {
        try {
            return ((Boolean) this.f6344j.invoke(obj, byteBuffer, Integer.valueOf(i3), null, Integer.valueOf(i4), Integer.valueOf(i5))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj) {
        try {
            return ((Boolean) this.f6345k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t() {
        if (this.f6343i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f6343i != null;
    }

    protected Method A(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // w.e, w.j
    public Typeface b(Context context, v.c.b bVar, Resources resources, int i3) {
        if (!t()) {
            return super.b(context, bVar, resources, i3);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        for (v.c.C0092c c0092c : bVar.a()) {
            if (!q(context, objO, c0092c.a(), c0092c.c(), c0092c.e(), c0092c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0092c.d()))) {
                p(objO);
                return null;
            }
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    @Override // w.e, w.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b0.f.b[] bVarArr, int i3) {
        Typeface typefaceL;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!t()) {
            b0.f.b bVarH = h(bVarArr, i3);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarH.d(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarH.e()).setItalic(bVarH.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapH = k.h(context, bVarArr, cancellationSignal);
        Object objO = o();
        if (objO == null) {
            return null;
        }
        boolean z2 = false;
        for (b0.f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = mapH.get(bVar.d());
            if (byteBuffer != null) {
                if (!r(objO, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    p(objO);
                    return null;
                }
                z2 = true;
            }
        }
        if (!z2) {
            p(objO);
            return null;
        }
        if (s(objO) && (typefaceL = l(objO)) != null) {
            return Typeface.create(typefaceL, i3);
        }
        return null;
    }

    @Override // w.j
    public Typeface e(Context context, Resources resources, int i3, String str, int i4) {
        if (!t()) {
            return super.e(context, resources, i3, str, i4);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        if (!q(context, objO, str, 0, -1, -1, null)) {
            p(objO);
            return null;
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    protected Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f6341g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f6347m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method u(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method v(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method w(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> y() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> z(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
