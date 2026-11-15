package v;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import d0.i;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourcesCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static abstract class a {

        /* JADX INFO: renamed from: v.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResourcesCompat.java */
        class RunnableC0093a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Typeface f6308b;

            RunnableC0093a(Typeface typeface) {
                this.f6308b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.e(this.f6308b);
            }
        }

        /* JADX INFO: compiled from: ResourcesCompat.java */
        class b implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f6310b;

            b(int i3) {
                this.f6310b = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.f6310b);
            }
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void a(int i3, Handler handler) {
            c(handler).post(new b(i3));
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new RunnableC0093a(typeface));
        }

        public abstract void d(int i3);

        public abstract void e(Typeface typeface);
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static final class b {

        /* JADX INFO: compiled from: ResourcesCompat.java */
        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Object f6312a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f6313b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static boolean f6314c;

            /* JADX WARN: Code duplicated, block: B:26:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            static void a(Resources.Theme theme) {
                Method method;
                synchronized (f6312a) {
                    if (f6314c) {
                        method = f6313b;
                        if (method != null) {
                            method.invoke(theme, new Object[0]);
                        }
                    } else {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f6313b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e3) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e3);
                        }
                        f6314c = true;
                        method = f6313b;
                        if (method != null) {
                            try {
                                method.invoke(theme, new Object[0]);
                            } catch (IllegalAccessException | InvocationTargetException e4) {
                                Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e4);
                                f6313b = null;
                            }
                        }
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: v.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResourcesCompat.java */
        static class C0094b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                C0094b.a(theme);
            } else if (i3 >= 23) {
                a.a(theme);
            }
        }
    }

    public static Typeface a(Context context, int i3) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, i3, new TypedValue(), 0, null, null, false, true);
    }

    public static Drawable b(Resources resources, int i3, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i3, theme) : resources.getDrawable(i3);
    }

    public static Typeface c(Context context, int i3) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, i3, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface d(Context context, int i3, TypedValue typedValue, int i4, a aVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, i3, typedValue, i4, aVar, null, true, false);
    }

    public static void e(Context context, int i3, a aVar, Handler handler) throws Resources.NotFoundException {
        i.c(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, handler);
        } else {
            f(context, i3, new TypedValue(), 0, aVar, handler, false, false);
        }
    }

    private static Typeface f(Context context, int i3, TypedValue typedValue, int i4, a aVar, Handler handler, boolean z2, boolean z3) {
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        Typeface typefaceG = g(context, resources, typedValue, i3, i4, aVar, handler, z2, z3);
        if (typefaceG != null || aVar != null || z3) {
            return typefaceG;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i3) + " could not be retrieved.");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
    private static Typeface g(Context context, Resources resources, TypedValue typedValue, int i3, int i4, a aVar, Handler handler, boolean z2, boolean z3) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i3) + "\" (" + Integer.toHexString(i3) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        }
        Typeface typefaceF = w.d.f(resources, i3, i4);
        if (typefaceF != null) {
            if (aVar != null) {
                aVar.b(typefaceF, handler);
            }
            return typefaceF;
        }
        if (z3) {
            return null;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceD = w.d.d(context, resources, i3, string, i4);
                if (aVar != null) {
                    if (typefaceD != null) {
                        aVar.b(typefaceD, handler);
                    } else {
                        aVar.a(-3, handler);
                    }
                }
                return typefaceD;
            }
            c.a aVarB = c.b(resources.getXml(i3), resources);
            if (aVarB != null) {
                return w.d.c(context, aVarB, resources, i3, i4, aVar, handler, z2);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        } catch (IOException e3) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + string, e3);
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e4) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e4);
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        }
    }
}
