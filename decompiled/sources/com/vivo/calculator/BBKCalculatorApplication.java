package com.vivo.calculator;

import a2.e;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import com.vivo.seckeysdk.BuildConfig;
import com.vivo.seckeysdk.SecurityKeyCipher;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import g2.g;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import r0.o;
import s0.l;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class BBKCalculatorApplication extends Application {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static BBKCalculatorApplication f3494l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f3495m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f3496n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f3497o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static boolean f3498p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f3499q = "yes".equals(g.b("ro.vivo.product.overseas", BuildConfig.FLAVOR));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f3500b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o f3501c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SecurityKeyCipher f3502d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences f3503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences.Editor f3504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a2.a f3505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a2.b f3506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a2.c f3507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a2.d f3508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e f3509k;

    private static class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            VLog.e("BBKCalculator/BBKCalculatorApplication", "Task " + runnable.toString() + " rejected from mCachedThreadPool");
        }
    }

    public static BBKCalculatorApplication a() {
        return f3494l;
    }

    public static boolean f() {
        return f3496n;
    }

    public static boolean g() {
        return f3497o;
    }

    public static boolean h() {
        return f3498p;
    }

    public static boolean i() {
        return f3495m;
    }

    private void j() {
        a2.a aVar = this.f3505g;
        if (aVar != null) {
            aVar.c();
        }
    }

    public static void l(boolean z2) {
        f3496n = z2;
    }

    private void m(boolean z2) {
        a2.a aVar = this.f3505g;
        if (aVar != null) {
            aVar.a(z2);
        }
        a2.b bVar = this.f3506h;
        if (bVar != null) {
            bVar.a(z2);
        }
        e eVar = this.f3509k;
        if (eVar != null) {
            eVar.a(z2);
        }
        a2.d dVar = this.f3508j;
        if (dVar != null) {
            dVar.a(z2);
        }
        a2.c cVar = this.f3507i;
        if (cVar != null) {
            cVar.a(z2);
        }
    }

    public static void p(boolean z2) {
        f3497o = z2;
    }

    public static void q(boolean z2) {
        f3498p = z2;
    }

    public static void r(boolean z2) {
        f3495m = z2;
    }

    public SecurityKeyCipher b() throws SecurityKeyException {
        if (this.f3502d == null) {
            this.f3502d = SecurityKeyCipher.getInstance(this, "AAAAfwAAAAB0nHMzAAEAAAAEDmZvckNvbnN0cnVjdG9yE2NvbS52aXZvLmNhbGN1bGF0b3IQYTA5dklleGRZNFlIWjhqNQlFbmZvcmNpbmcteyJwcm90ZWN0aW9uVGhyZWFkTW9kZSI6MSwic2VjdXJpdHlNb2RlIjoxOTV9AA");
        }
        return this.f3502d;
    }

    public ExecutorService c() {
        int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        if (this.f3500b == null) {
            this.f3500b = new ThreadPoolExecutor(2, iAvailableProcessors, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(80), new a());
        }
        return this.f3500b;
    }

    public o d() {
        if (this.f3501c == null) {
            this.f3501c = l.a(getApplicationContext());
        }
        return this.f3501c;
    }

    public void e() {
        this.f3504f.putBoolean("HistoryListOpen", false);
        this.f3504f.putBoolean("IS_FOLD_DEVICE_INNER_SCREEN", g2.b.o(getApplicationContext()));
        this.f3504f.putInt("DispalyID", 0);
        this.f3504f.commit();
    }

    public void k(a2.a aVar) {
        this.f3505g = aVar;
    }

    public void n(a2.b bVar) {
        this.f3506h = bVar;
    }

    public void o(a2.c cVar) {
        this.f3507i = cVar;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VLog.d("BBKCalculator/BBKCalculatorApplication", "onConfigurationChanged: ");
        j();
        if (!this.f3503e.contains("IS_FOLD_DEVICE_INNER_SCREEN") || this.f3503e.getBoolean("IS_FOLD_DEVICE_INNER_SCREEN", false) == g2.b.o(getApplicationContext())) {
            m(false);
        } else {
            m(true);
        }
        this.f3504f.putBoolean("IS_FOLD_DEVICE_INNER_SCREEN", g2.b.o(getApplicationContext()));
        this.f3504f.commit();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        VLog.d("BBKCalculator/BBKCalculatorApplication", "onCreate: ");
        f3494l = this;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.f3503e = defaultSharedPreferences;
        this.f3504f = defaultSharedPreferences.edit();
        g2.d.b(this);
        e2.a.i().j(getApplicationContext());
        h2.b.a();
        h2.b.b("A790|10003", null);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        VLog.d("BBKCalculator/BBKCalculatorApplication", "onTerminate: ");
        e();
    }

    public void s(a2.d dVar) {
        this.f3508j = dVar;
    }

    public void t(e eVar) {
        this.f3509k = eVar;
    }
}
