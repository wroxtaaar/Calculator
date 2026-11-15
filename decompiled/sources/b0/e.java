package b0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: FontRequestWorker.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final l.e<String, Typeface> f2388a = new l.e<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f2389b = g.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f2390c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final l.g<String, ArrayList<d0.a<C0027e>>> f2391d = new l.g<>();

    /* JADX INFO: compiled from: FontRequestWorker.java */
    class a implements Callable<C0027e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f2393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b0.d f2394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f2395d;

        a(String str, Context context, b0.d dVar, int i3) {
            this.f2392a = str;
            this.f2393b = context;
            this.f2394c = dVar;
            this.f2395d = i3;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0027e call() {
            return e.c(this.f2392a, this.f2393b, this.f2394c, this.f2395d);
        }
    }

    /* JADX INFO: compiled from: FontRequestWorker.java */
    class b implements d0.a<C0027e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0.a f2396a;

        b(b0.a aVar) {
            this.f2396a = aVar;
        }

        @Override // d0.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0027e c0027e) {
            this.f2396a.b(c0027e);
        }
    }

    /* JADX INFO: compiled from: FontRequestWorker.java */
    class c implements Callable<C0027e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f2398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b0.d f2399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f2400d;

        c(String str, Context context, b0.d dVar, int i3) {
            this.f2397a = str;
            this.f2398b = context;
            this.f2399c = dVar;
            this.f2400d = i3;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0027e call() {
            return e.c(this.f2397a, this.f2398b, this.f2399c, this.f2400d);
        }
    }

    /* JADX INFO: compiled from: FontRequestWorker.java */
    class d implements d0.a<C0027e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2401a;

        d(String str) {
            this.f2401a = str;
        }

        @Override // d0.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0027e c0027e) {
            synchronized (e.f2390c) {
                l.g<String, ArrayList<d0.a<C0027e>>> gVar = e.f2391d;
                ArrayList<d0.a<C0027e>> arrayList = gVar.get(this.f2401a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.f2401a);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    arrayList.get(i3).a(c0027e);
                }
            }
        }
    }

    private static String a(b0.d dVar, int i3) {
        return dVar.d() + "-" + i3;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(f.a aVar) {
        int i3 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        f.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i3 = 0;
            for (f.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i3;
    }

    static C0027e c(String str, Context context, b0.d dVar, int i3) {
        l.e<String, Typeface> eVar = f2388a;
        Typeface typefaceC = eVar.c(str);
        if (typefaceC != null) {
            return new C0027e(typefaceC);
        }
        try {
            f.a aVarD = b0.c.d(context, dVar, null);
            int iB = b(aVarD);
            if (iB != 0) {
                return new C0027e(iB);
            }
            Typeface typefaceB = w.d.b(context, null, aVarD.b(), i3);
            if (typefaceB == null) {
                return new C0027e(-3);
            }
            eVar.d(str, typefaceB);
            return new C0027e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0027e(-1);
        }
    }

    static Typeface d(Context context, b0.d dVar, int i3, Executor executor, b0.a aVar) {
        String strA = a(dVar, i3);
        Typeface typefaceC = f2388a.c(strA);
        if (typefaceC != null) {
            aVar.b(new C0027e(typefaceC));
            return typefaceC;
        }
        b bVar = new b(aVar);
        synchronized (f2390c) {
            l.g<String, ArrayList<d0.a<C0027e>>> gVar = f2391d;
            ArrayList<d0.a<C0027e>> arrayList = gVar.get(strA);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<d0.a<C0027e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            gVar.put(strA, arrayList2);
            c cVar = new c(strA, context, dVar, i3);
            if (executor == null) {
                executor = f2389b;
            }
            g.b(executor, cVar, new d(strA));
            return null;
        }
    }

    static Typeface e(Context context, b0.d dVar, b0.a aVar, int i3, int i4) {
        String strA = a(dVar, i3);
        Typeface typefaceC = f2388a.c(strA);
        if (typefaceC != null) {
            aVar.b(new C0027e(typefaceC));
            return typefaceC;
        }
        if (i4 == -1) {
            C0027e c0027eC = c(strA, context, dVar, i3);
            aVar.b(c0027eC);
            return c0027eC.f2402a;
        }
        try {
            C0027e c0027e = (C0027e) g.c(f2389b, new a(strA, context, dVar, i3), i4);
            aVar.b(c0027e);
            return c0027e.f2402a;
        } catch (InterruptedException unused) {
            aVar.b(new C0027e(-3));
            return null;
        }
    }

    /* JADX INFO: renamed from: b0.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FontRequestWorker.java */
    static final class C0027e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f2402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f2403b;

        C0027e(int i3) {
            this.f2402a = null;
            this.f2403b = i3;
        }

        @SuppressLint({"WrongConstant"})
        boolean a() {
            return this.f2403b == 0;
        }

        @SuppressLint({"WrongConstant"})
        C0027e(Typeface typeface) {
            this.f2402a = typeface;
            this.f2403b = 0;
        }
    }
}
