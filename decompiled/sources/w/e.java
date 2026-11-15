package w;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TypefaceCompatApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class e extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f6332b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor<?> f6333c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f6334d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f6335e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f6336f = false;

    e() {
    }

    private static boolean k(Object obj, String str, int i3, boolean z2) throws NoSuchMethodException {
        n();
        try {
            return ((Boolean) f6334d.invoke(obj, str, Integer.valueOf(i3), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Typeface l(Object obj) throws NoSuchMethodException {
        n();
        try {
            Object objNewInstance = Array.newInstance(f6332b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f6335e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f6336f) {
            return;
        }
        f6336f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi21Impl", e3.getClass().getName(), e3);
            method = null;
            cls = null;
            method2 = null;
        }
        f6333c = constructor;
        f6332b = cls;
        f6334d = method2;
        f6335e = method;
    }

    private static Object o() throws NoSuchMethodException {
        n();
        try {
            return f6333c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // w.j
    public Typeface b(Context context, v.c.b bVar, Resources resources, int i3) throws NoSuchMethodException {
        Object objO = o();
        for (v.c.C0092c c0092c : bVar.a()) {
            File fileE = k.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!k.c(fileE, resources, c0092c.b())) {
                    return null;
                }
                if (!k(objO, fileE.getPath(), c0092c.e(), c0092c.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return l(objO);
    }

    @Override // w.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b0.f.b[] bVarArr, int i3) {
        if (bVarArr.length < 1) {
            return null;
        }
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
                File fileM = m(parcelFileDescriptorOpenFileDescriptor);
                if (fileM != null && fileM.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileM);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceD = super.d(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceD;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
