package b0;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import d0.i;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b[] f2405b;

        @Deprecated
        public a(int i3, b[] bVarArr) {
            this.f2404a = i3;
            this.f2405b = bVarArr;
        }

        static a a(int i3, b[] bVarArr) {
            return new a(i3, bVarArr);
        }

        public b[] b() {
            return this.f2405b;
        }

        public int c() {
            return this.f2404a;
        }
    }

    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f2406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f2409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2410e;

        @Deprecated
        public b(Uri uri, int i3, int i4, boolean z2, int i5) {
            this.f2406a = (Uri) i.c(uri);
            this.f2407b = i3;
            this.f2408c = i4;
            this.f2409d = z2;
            this.f2410e = i5;
        }

        static b a(Uri uri, int i3, int i4, boolean z2, int i5) {
            return new b(uri, i3, i4, z2, i5);
        }

        public int b() {
            return this.f2410e;
        }

        public int c() {
            return this.f2407b;
        }

        public Uri d() {
            return this.f2406a;
        }

        public int e() {
            return this.f2408c;
        }

        public boolean f() {
            return this.f2409d;
        }
    }

    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class c {
        public void a(int i3) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, d dVar, int i3, boolean z2, int i4, Handler handler, c cVar) {
        b0.a aVar = new b0.a(cVar, handler);
        return z2 ? e.e(context, dVar, aVar, i3, i4) : e.d(context, dVar, i3, null, aVar);
    }
}
