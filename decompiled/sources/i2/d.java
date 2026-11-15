package i2;

import android.content.Context;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import l2.i;

/* JADX INFO: compiled from: PlatformCipherProxy.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4908a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f4909b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4910c;

    private d(Context context) {
        this.f4910c = context;
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        ClassLoader classLoader = c.class.getClassLoader();
        if (classLoader == null) {
            i.k("PlatformCipherProxy", "classLoader is null");
            return null;
        }
        return (a) Proxy.newProxyInstance(classLoader, c.class.getInterfaces(), new d(context));
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws SecurityKeyException {
        if (method.getName().equals("toString")) {
            return toString();
        }
        if (!this.f4908a) {
            synchronized (this) {
                if (!this.f4908a) {
                    i.g("PlatformCipherProxy", "init target");
                    this.f4909b = c.B(this.f4910c);
                    this.f4908a = true;
                }
            }
        }
        c cVar = this.f4909b;
        if (cVar == null) {
            i.k("PlatformCipherProxy", "target is null");
            throw new SecurityKeyException("target is null", -1000);
        }
        try {
            return method.invoke(cVar, objArr);
        } catch (Throwable th) {
            th = th;
            if (th instanceof InvocationTargetException) {
                th = th.getCause();
            }
            i.k("PlatformCipherProxy", method.getName() + " invoke error, msg=" + th.toString());
            if (th instanceof SecurityKeyException) {
                throw ((SecurityKeyException) th);
            }
            throw new SecurityKeyException(th, -1000);
        }
    }
}
