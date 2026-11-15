package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f3209e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f3210a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3211b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f3212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f3213d;

    /* JADX INFO: compiled from: SnackbarManager.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SnackbarManager.java */
    interface InterfaceC0041b {
        void a();

        void b(int i3);
    }

    /* JADX INFO: compiled from: SnackbarManager.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<InterfaceC0041b> f3215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f3217c;

        boolean a(InterfaceC0041b interfaceC0041b) {
            return interfaceC0041b != null && this.f3215a.get() == interfaceC0041b;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i3) {
        InterfaceC0041b interfaceC0041b = cVar.f3215a.get();
        if (interfaceC0041b == null) {
            return false;
        }
        this.f3211b.removeCallbacksAndMessages(cVar);
        interfaceC0041b.b(i3);
        return true;
    }

    static b c() {
        if (f3209e == null) {
            f3209e = new b();
        }
        return f3209e;
    }

    private boolean f(InterfaceC0041b interfaceC0041b) {
        c cVar = this.f3212c;
        return cVar != null && cVar.a(interfaceC0041b);
    }

    private boolean g(InterfaceC0041b interfaceC0041b) {
        c cVar = this.f3213d;
        return cVar != null && cVar.a(interfaceC0041b);
    }

    private void l(c cVar) {
        int i3 = cVar.f3216b;
        if (i3 == -2) {
            return;
        }
        if (i3 <= 0) {
            i3 = i3 == -1 ? 1500 : 2750;
        }
        this.f3211b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f3211b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i3);
    }

    private void m() {
        c cVar = this.f3213d;
        if (cVar != null) {
            this.f3212c = cVar;
            this.f3213d = null;
            InterfaceC0041b interfaceC0041b = cVar.f3215a.get();
            if (interfaceC0041b != null) {
                interfaceC0041b.a();
            } else {
                this.f3212c = null;
            }
        }
    }

    public void b(InterfaceC0041b interfaceC0041b, int i3) {
        synchronized (this.f3210a) {
            if (f(interfaceC0041b)) {
                a(this.f3212c, i3);
            } else if (g(interfaceC0041b)) {
                a(this.f3213d, i3);
            }
        }
    }

    void d(c cVar) {
        synchronized (this.f3210a) {
            if (this.f3212c == cVar || this.f3213d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0041b interfaceC0041b) {
        boolean z2;
        synchronized (this.f3210a) {
            z2 = f(interfaceC0041b) || g(interfaceC0041b);
        }
        return z2;
    }

    public void h(InterfaceC0041b interfaceC0041b) {
        synchronized (this.f3210a) {
            if (f(interfaceC0041b)) {
                this.f3212c = null;
                if (this.f3213d != null) {
                    m();
                }
            }
        }
    }

    public void i(InterfaceC0041b interfaceC0041b) {
        synchronized (this.f3210a) {
            if (f(interfaceC0041b)) {
                l(this.f3212c);
            }
        }
    }

    public void j(InterfaceC0041b interfaceC0041b) {
        synchronized (this.f3210a) {
            if (f(interfaceC0041b)) {
                c cVar = this.f3212c;
                if (!cVar.f3217c) {
                    cVar.f3217c = true;
                    this.f3211b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(InterfaceC0041b interfaceC0041b) {
        synchronized (this.f3210a) {
            if (f(interfaceC0041b)) {
                c cVar = this.f3212c;
                if (cVar.f3217c) {
                    cVar.f3217c = false;
                    l(cVar);
                }
            }
        }
    }
}
