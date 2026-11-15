package b;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.w;
import androidx.appcompat.widget.z;
import com.vivo.seckeysdk.BuildConfig;
import e0.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: AppCompatViewInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f2308b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f2309c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f2310d = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final l.g<String, Constructor<? extends View>> f2311e = new l.g<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f2312a = new Object[2];

    /* JADX INFO: compiled from: AppCompatViewInflater.java */
    private static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f2313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f2314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Method f2315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Context f2316e;

        public a(View view, String str) {
            this.f2313b = view;
            this.f2314c = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f2314c, View.class)) != null) {
                        this.f2315d = method;
                        this.f2316e = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f2313b.getId();
            if (id == -1) {
                str = BuildConfig.FLAVOR;
            } else {
                str = " with id '" + this.f2313b.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f2314c + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f2313b.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f2315d == null) {
                a(this.f2313b.getContext());
            }
            try {
                this.f2315d.invoke(this.f2316e, view);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("Could not execute method for android:onClick", e4);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || t.N(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2309c);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private View r(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        String str3;
        l.g<String, Constructor<? extends View>> gVar = f2311e;
        Constructor<? extends View> constructor = gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f2308b);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f2312a);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f2312a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return r(context, str, null);
            }
            int i3 = 0;
            while (true) {
                String[] strArr = f2310d;
                if (i3 >= strArr.length) {
                    return null;
                }
                View viewR = r(context, str, strArr[i3]);
                if (viewR != null) {
                    return viewR;
                }
                i3++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f2312a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z2, boolean z3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.View, 0, 0);
        int resourceId = z2 ? typedArrayObtainStyledAttributes.getResourceId(a.j.View_android_theme, 0) : 0;
        if (z3 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(a.j.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return ((context instanceof g.d) && ((g.d) context).c() == resourceId) ? context : new g.d(context, resourceId);
        }
        return context;
    }

    private void u(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected androidx.appcompat.widget.d b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    protected androidx.appcompat.widget.f c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    protected androidx.appcompat.widget.g d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.g(context, attributeSet);
    }

    protected androidx.appcompat.widget.h e(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.h(context, attributeSet);
    }

    protected androidx.appcompat.widget.k f(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.k(context, attributeSet);
    }

    protected m g(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    protected o h(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    protected p i(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    protected s j(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    protected androidx.appcompat.widget.t k(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.t(context, attributeSet);
    }

    protected u l(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    protected w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    protected z n(Context context, AttributeSet attributeSet) {
        return new z(context, attributeSet);
    }

    protected b0 o(Context context, AttributeSet attributeSet) {
        return new b0(context, attributeSet);
    }

    protected View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z2, boolean z3, boolean z4, boolean z5) {
        View viewK;
        Context context2 = (!z2 || view == null) ? context : view.getContext();
        if (z3 || z4) {
            context2 = t(context2, attributeSet, z3, z4);
        }
        if (z5) {
            context2 = t0.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                viewK = k(context2, attributeSet);
                u(viewK, str);
                break;
            case "CheckedTextView":
                viewK = e(context2, attributeSet);
                u(viewK, str);
                break;
            case "MultiAutoCompleteTextView":
                viewK = i(context2, attributeSet);
                u(viewK, str);
                break;
            case "TextView":
                viewK = n(context2, attributeSet);
                u(viewK, str);
                break;
            case "ImageButton":
                viewK = g(context2, attributeSet);
                u(viewK, str);
                break;
            case "SeekBar":
                viewK = l(context2, attributeSet);
                u(viewK, str);
                break;
            case "Spinner":
                viewK = m(context2, attributeSet);
                u(viewK, str);
                break;
            case "RadioButton":
                viewK = j(context2, attributeSet);
                u(viewK, str);
                break;
            case "ToggleButton":
                viewK = o(context2, attributeSet);
                u(viewK, str);
                break;
            case "ImageView":
                viewK = h(context2, attributeSet);
                u(viewK, str);
                break;
            case "AutoCompleteTextView":
                viewK = b(context2, attributeSet);
                u(viewK, str);
                break;
            case "CheckBox":
                viewK = d(context2, attributeSet);
                u(viewK, str);
                break;
            case "EditText":
                viewK = f(context2, attributeSet);
                u(viewK, str);
                break;
            case "Button":
                viewK = c(context2, attributeSet);
                u(viewK, str);
                break;
            default:
                viewK = p(context2, str, attributeSet);
                break;
        }
        if (viewK == null && context != context2) {
            viewK = s(context2, str, attributeSet);
        }
        if (viewK != null) {
            a(viewK, attributeSet);
        }
        return viewK;
    }
}
