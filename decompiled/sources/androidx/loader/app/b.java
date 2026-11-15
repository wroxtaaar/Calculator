package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import l.h;

/* JADX INFO: compiled from: LoaderManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f1578c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f1579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0010b f1580b;

    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class a<D> extends l<D> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f1581k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Bundle f1582l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final m0.a<D> f1583m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private g f1584n;

        @Override // androidx.lifecycle.LiveData
        protected void d() {
            if (b.f1578c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void e() {
            if (b.f1578c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void f(m<? super D> mVar) {
            super.f(mVar);
            this.f1584n = null;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void g(D d3) {
            super.g(d3);
        }

        m0.a<D> h(boolean z2) {
            if (b.f1578c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1581k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f1582l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f1583m);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        void j() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f1581k);
            sb.append(" : ");
            d0.b.a(this.f1583m, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    static class C0010b extends p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final q.a f1585e = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h<a> f1586c = new h<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1587d = false;

        /* JADX INFO: renamed from: androidx.loader.app.b$b$a */
        /* JADX INFO: compiled from: LoaderManagerImpl.java */
        static class a implements q.a {
            a() {
            }

            @Override // androidx.lifecycle.q.a
            public <T extends p> T a(Class<T> cls) {
                return new C0010b();
            }
        }

        C0010b() {
        }

        static C0010b f(r rVar) {
            return (C0010b) new q(rVar, f1585e).a(C0010b.class);
        }

        @Override // androidx.lifecycle.p
        protected void d() {
            super.d();
            int iK = this.f1586c.k();
            for (int i3 = 0; i3 < iK; i3++) {
                this.f1586c.l(i3).h(true);
            }
            this.f1586c.b();
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1586c.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i3 = 0; i3 < this.f1586c.k(); i3++) {
                    a aVarL = this.f1586c.l(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f1586c.h(i3));
                    printWriter.print(": ");
                    printWriter.println(aVarL.toString());
                    aVarL.i(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void g() {
            int iK = this.f1586c.k();
            for (int i3 = 0; i3 < iK; i3++) {
                this.f1586c.l(i3).j();
            }
        }
    }

    b(g gVar, r rVar) {
        this.f1579a = gVar;
        this.f1580b = C0010b.f(rVar);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1580b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f1580b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d0.b.a(this.f1579a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
