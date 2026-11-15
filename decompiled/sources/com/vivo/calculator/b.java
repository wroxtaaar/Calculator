package com.vivo.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import vivo.util.VLog;

/* JADX INFO: compiled from: Evaluator.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.vivo.calculator.a.g {
    public static String A = "timeout";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static b f3876x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static b f3877y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static b f3878z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f3882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f3883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f3885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3890l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.vivo.calculator.c f3894p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private m f3895q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private k f3896r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private l f3897s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private SharedPreferences f3898t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f3879a = new h();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<Long, m> f3891m = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ConcurrentHashMap<Long, k> f3892n = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ConcurrentHashMap<Long, l> f3893o = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Handler f3899u = new Handler();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Handler f3900v = new Handler();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Handler f3901w = new Handler();

    /* JADX INFO: renamed from: com.vivo.calculator.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Evaluator.java */
    class AsyncTaskC0047b extends AsyncTask<Void, Void, n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f3905d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private j f3906e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g f3907f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f3908g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private m f3909h;

        /* JADX INFO: renamed from: com.vivo.calculator.b$b$a */
        /* JADX INFO: compiled from: Evaluator.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AsyncTaskC0047b.this.d();
            }
        }

        AsyncTaskC0047b(long j3, j jVar, g gVar, boolean z2, boolean z3) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator: Asynchronous calculation ");
            this.f3908g = j3;
            this.f3906e = jVar;
            this.f3907f = gVar;
            this.f3902a = z2;
            this.f3903b = z3;
            this.f3904c = (z3 && j3 == 0) ? false : true;
            m mVar = (m) b.this.f3891m.get(Long.valueOf(this.f3908g));
            this.f3909h = mVar;
            if (mVar.f3964c != null) {
                throw new AssertionError("Evaluation already in progress!");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            VLog.d("BBKCalculator/Evaluator ", "handleTimeout.");
            if ((getStatus() != AsyncTask.Status.FINISHED) && cancel(true)) {
                ((m) b.this.f3891m.get(Long.valueOf(this.f3908g))).f3964c = null;
                if (this.f3903b && this.f3908g == 0) {
                    b.this.f3895q.f3962a = (com.vivo.calculator.a) b.this.f3895q.f3962a.clone();
                    h();
                    b.this.F0(this.f3909h.f3970i);
                }
            }
        }

        private boolean e(com.vivo.calculator.d dVar) {
            return dVar.d(this.f3903b ? b.this.k1(this.f3909h.f3970i) : 150000);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f3904c = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public n doInBackground(Void... voidArr) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator doInBackground: ");
            try {
                try {
                    try {
                        try {
                            com.vivo.calculator.d dVarC = this.f3909h.f3965d.get();
                            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator doInBackground: res " + dVarC);
                            if (dVarC == null) {
                                try {
                                    com.vivo.calculator.d dVarP = this.f3909h.f3962a.P(this.f3902a, b.this);
                                    VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator doInBackground: res2 == " + dVarP);
                                    if (isCancelled()) {
                                        new n(R.string.error_aborted);
                                        return null;
                                    }
                                    dVarC = b.this.c(this.f3908g, dVarP);
                                    VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator doInBackground: res3  == " + dVarC);
                                } catch (StackOverflowError unused) {
                                    new n(R.string.timeout);
                                    return null;
                                }
                            }
                            if (e(dVarC)) {
                                new n(R.string.timeout);
                                return null;
                            }
                            int iCeil = 50;
                            String strZ = dVarC.Z(50);
                            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator doInBackground,initResult:" + strZ);
                            int iN1 = b.n1(strZ);
                            if (iN1 == Integer.MAX_VALUE) {
                                int iL = dVarC.L();
                                VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator doInBackground,leadingZeroBits:" + iL);
                                if (iL < 150000) {
                                    iCeil = ((int) Math.ceil((Math.log(2.0d) / Math.log(10.0d)) * ((double) iL))) + 30;
                                    strZ = dVarC.Z(iCeil);
                                    iN1 = b.n1(strZ);
                                    if (iN1 == Integer.MAX_VALUE) {
                                        throw new AssertionError("Impossible zero result");
                                    }
                                } else {
                                    iCeil = 1100;
                                    strZ = dVarC.Z(1100);
                                    iN1 = b.n1(strZ);
                                }
                            }
                            int iO1 = b.o1(strZ, iN1, b.i1(dVarC, strZ, strZ.indexOf(46)), this.f3907f);
                            int i3 = iO1 + 20;
                            if (i3 > iCeil) {
                                strZ = dVarC.Z(i3);
                                iCeil = i3;
                            }
                            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator doInBackground,initResult2:" + strZ);
                            return new n(dVarC, strZ, iCeil, iO1);
                        } catch (com.vivo.calculator.d.a unused2) {
                            return new n(R.string.error_zero_divide);
                        } catch (x1.a.C0099a unused3) {
                            return new n(R.string.error_aborted);
                        }
                    } catch (com.vivo.calculator.a.j unused4) {
                        return new n(R.string.error_syntax);
                    } catch (x1.a.b unused5) {
                        return new n(R.string.error_overflow);
                    }
                } catch (ArithmeticException unused6) {
                    return new n(R.string.error_nan);
                }
            } catch (Throwable unused7) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onCancelled(n nVar) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator onCancelled: ");
            b.this.f3899u.removeCallbacks(this.f3905d);
            if (!this.f3904c) {
                b.this.E0();
            }
            this.f3906e.b(this.f3908g, R.string.error_overflow);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(n nVar) {
            if (nVar == null) {
                return;
            }
            b.this.a0(this.f3909h, this.f3905d, nVar, this.f3903b, this.f3908g, this.f3906e, this.f3907f);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator onPreExecute, mRequired :" + this.f3903b);
            long jW1 = this.f3903b ? b.this.w1(this.f3909h.f3970i) : 1000L;
            if (this.f3908g != 0) {
                jW1 = 100000;
            }
            this.f3905d = new a();
            VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator onPreExecute，timeout: " + jW1);
            b.this.f3899u.removeCallbacks(this.f3905d);
            b.this.f3899u.postDelayed(this.f3905d, jW1);
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    class c extends AsyncTask<Void, Void, n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f3915d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private j f3916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g f3917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f3918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private k f3919h;

        /* JADX INFO: compiled from: Evaluator.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d();
            }
        }

        c(long j3, j jVar, g gVar, boolean z2, boolean z3) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator: Asynchronous calculation ");
            this.f3918g = j3;
            this.f3916e = jVar;
            this.f3917f = gVar;
            this.f3912a = z2;
            this.f3913b = z3;
            this.f3914c = (z3 && j3 == 0) ? false : true;
            k kVar = (k) b.this.f3892n.get(Long.valueOf(this.f3918g));
            this.f3919h = kVar;
            if (kVar.f3939c != null) {
                throw new AssertionError("Evaluation already in progress!");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            VLog.d("BBKCalculator/Evaluator ", "handleTimeout:AsyncExEvaluator");
            if ((getStatus() != AsyncTask.Status.FINISHED) && cancel(true)) {
                ((k) b.this.f3892n.get(Long.valueOf(this.f3918g))).f3939c = null;
                if (this.f3913b && this.f3918g == 0) {
                    b.this.f3896r.f3937a = (com.vivo.calculator.a) b.this.f3896r.f3937a.clone();
                    h();
                    b.this.F0(this.f3919h.f3946j);
                }
            }
        }

        private boolean e(com.vivo.calculator.d dVar) {
            return dVar.d(this.f3913b ? b.this.k1(this.f3919h.f3946j) : 150000);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f3914c = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public n doInBackground(Void... voidArr) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator doInBackground: local");
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    com.vivo.calculator.d dVarL = this.f3919h.f3940d.get();
                                    VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator doInBackground: local  res " + dVarL);
                                    if (dVarL == null) {
                                        try {
                                            com.vivo.calculator.d dVarQ = this.f3919h.f3937a.Q(this.f3912a, b.this);
                                            VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator doInBackground: local res start == " + dVarQ);
                                            if (isCancelled()) {
                                                new n(R.string.error_aborted);
                                                return null;
                                            }
                                            dVarL = b.this.l(this.f3918g, dVarQ);
                                            VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator doInBackground: res end  == " + dVarL);
                                        } catch (StackOverflowError unused) {
                                            new n(R.string.timeout);
                                            return null;
                                        }
                                    }
                                    if (e(dVarL)) {
                                        new n(R.string.timeout);
                                        return null;
                                    }
                                    int iCeil = 50;
                                    String strZ = dVarL.Z(50);
                                    int iN1 = b.n1(strZ);
                                    if (iN1 == Integer.MAX_VALUE) {
                                        int iL = dVarL.L();
                                        if (iL < 150000) {
                                            iCeil = ((int) Math.ceil((Math.log(2.0d) / Math.log(10.0d)) * ((double) iL))) + 30;
                                            strZ = dVarL.Z(iCeil);
                                            iN1 = b.n1(strZ);
                                            if (iN1 == Integer.MAX_VALUE) {
                                                throw new AssertionError("Impossible zero result");
                                            }
                                        } else {
                                            iCeil = 1100;
                                            strZ = dVarL.Z(1100);
                                            iN1 = b.n1(strZ);
                                        }
                                    }
                                    int iO1 = b.o1(strZ, iN1, b.i1(dVarL, strZ, strZ.indexOf(46)), this.f3917f);
                                    int i3 = iO1 + 20;
                                    if (i3 > iCeil) {
                                        strZ = dVarL.Z(i3);
                                        iCeil = i3;
                                    }
                                    VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator doInBackground,initResult2:" + strZ);
                                    return new n(dVarL, strZ, iCeil, iO1);
                                } catch (x1.a.C0099a unused2) {
                                    return new n(R.string.error_aborted);
                                }
                            } catch (com.vivo.calculator.a.j unused3) {
                                return new n(R.string.error_syntax);
                            }
                        } catch (x1.a.b unused4) {
                            return new n(R.string.error_overflow);
                        }
                    } catch (ArithmeticException unused5) {
                        return new n(R.string.error_nan);
                    }
                } catch (com.vivo.calculator.d.a unused6) {
                    return new n(R.string.error_zero_divide);
                }
            } catch (Throwable unused7) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onCancelled(n nVar) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator onCancelled: ");
            b.this.f3899u.removeCallbacks(this.f3915d);
            if (!this.f3914c) {
                b.this.E0();
            }
            this.f3916e.f(this.f3918g);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(n nVar) {
            if (nVar == null) {
                return;
            }
            b.this.b0(this.f3919h, this.f3915d, nVar, this.f3913b, this.f3918g, this.f3916e, this.f3917f);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator onPreExecute: local");
            long jW1 = this.f3913b ? b.this.w1(this.f3919h.f3946j) : 1000L;
            if (this.f3918g != 0) {
                jW1 = 100000;
            }
            this.f3915d = new a();
            b.this.f3899u.removeCallbacks(this.f3915d);
            b.this.f3899u.postDelayed(this.f3915d, jW1);
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    class d extends AsyncTask<Void, Void, n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f3925d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private i f3926e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g f3927f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f3928g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private l f3929h;

        /* JADX INFO: compiled from: Evaluator.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.d();
            }
        }

        d(long j3, i iVar, g gVar, boolean z2, boolean z3) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator: Asynchronous calculation ");
            this.f3928g = j3;
            this.f3926e = iVar;
            this.f3927f = gVar;
            this.f3922a = z2;
            this.f3923b = z3;
            this.f3924c = (z3 && j3 == 0) ? false : true;
            l lVar = (l) b.this.f3893o.get(Long.valueOf(this.f3928g));
            this.f3929h = lVar;
            if (lVar.f3952c != null) {
                throw new AssertionError("Evaluation already in progress!");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator handleTimeout: AsyncExchangeReevaluator  AsyncExchangeEvaluator ");
            if ((getStatus() != AsyncTask.Status.FINISHED) && cancel(true)) {
                ((l) b.this.f3893o.get(Long.valueOf(this.f3928g))).f3952c = null;
                VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator handleTimeout: AsyncExchangeEvaluator AsyncExchangeReevaluator  mExprsExchange.get(mIndex).mExchangeEvaluator  == " + ((l) b.this.f3893o.get(Long.valueOf(this.f3928g))).f3952c);
                if (this.f3923b && this.f3928g == 0) {
                    b.this.f3897s.f3950a = (com.vivo.calculator.a) b.this.f3897s.f3950a.G();
                    h();
                    b.this.F0(this.f3929h.f3958i);
                }
            }
        }

        private boolean e(com.vivo.calculator.d dVar) {
            return dVar.d(this.f3923b ? b.this.k1(this.f3929h.f3958i) : 150000);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f3924c = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public n doInBackground(Void... voidArr) {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator doInBackground: ");
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    com.vivo.calculator.d dVarJ = this.f3929h.f3953d.get();
                                    VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator doInBackground: res " + dVarJ);
                                    if (dVarJ == null) {
                                        try {
                                            com.vivo.calculator.d dVarR = this.f3929h.f3950a.R(this.f3922a, b.this);
                                            VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator doInBackground: res 2 == " + dVarR);
                                            if (isCancelled()) {
                                                new n(R.string.error_aborted);
                                                return null;
                                            }
                                            dVarJ = b.this.j(this.f3928g, dVarR);
                                            VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator doInBackground: res2  == " + dVarJ);
                                        } catch (StackOverflowError unused) {
                                            new n(R.string.timeout);
                                            return null;
                                        }
                                    }
                                    if (e(dVarJ)) {
                                        new n(R.string.timeout);
                                        return null;
                                    }
                                    int iCeil = 50;
                                    String strZ = dVarJ.Z(50);
                                    int iN1 = b.n1(strZ);
                                    if (iN1 == Integer.MAX_VALUE) {
                                        int iL = dVarJ.L();
                                        if (iL < 150000) {
                                            iCeil = ((int) Math.ceil((Math.log(2.0d) / Math.log(10.0d)) * ((double) iL))) + 30;
                                            strZ = dVarJ.Z(iCeil);
                                            iN1 = b.n1(strZ);
                                            if (iN1 == Integer.MAX_VALUE) {
                                                throw new AssertionError("Impossible zero result");
                                            }
                                        } else {
                                            iCeil = 1100;
                                            strZ = dVarJ.Z(1100);
                                            iN1 = b.n1(strZ);
                                        }
                                    }
                                    int iO1 = b.o1(strZ, iN1, b.i1(dVarJ, strZ, strZ.indexOf(46)), this.f3927f);
                                    int i3 = iO1 + 20;
                                    if (i3 > iCeil) {
                                        strZ = dVarJ.Z(i3);
                                        iCeil = i3;
                                    }
                                    VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator doInBackground,initResult2: other " + strZ);
                                    return new n(dVarJ, strZ, iCeil, iO1);
                                } catch (x1.a.C0099a unused2) {
                                    return new n(R.string.error_aborted);
                                }
                            } catch (com.vivo.calculator.a.j unused3) {
                                return new n(R.string.error_syntax);
                            }
                        } catch (x1.a.b unused4) {
                            return new n(R.string.error_overflow);
                        }
                    } catch (ArithmeticException unused5) {
                        return new n(R.string.error_nan);
                    }
                } catch (com.vivo.calculator.d.a unused6) {
                    return new n(R.string.error_zero_divide);
                }
            } catch (Throwable unused7) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onCancelled(n nVar) {
            VLog.e("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator onCancelled: other ");
            b.this.f3899u.removeCallbacks(this.f3925d);
            if (!this.f3924c) {
                b.this.E0();
            }
            this.f3926e.d(this.f3928g);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(n nVar) {
            if (nVar == null) {
                return;
            }
            b.this.c0(this.f3929h, this.f3925d, nVar, this.f3923b, this.f3928g, this.f3926e, this.f3927f);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator onPreExecute: 2");
            long jW1 = this.f3923b ? b.this.w1(this.f3929h.f3958i) : 1000L;
            if (this.f3928g != 0) {
                jW1 = 100000;
            }
            this.f3925d = new a();
            b.this.f3899u.removeCallbacks(this.f3925d);
            b.this.f3899u.postDelayed(this.f3925d, jW1);
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private class e extends AsyncTask<Integer, Void, o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f3932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j f3933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private m f3934c;

        e(long j3, j jVar) {
            this.f3932a = j3;
            this.f3933b = jVar;
            this.f3934c = (m) b.this.f3891m.get(Long.valueOf(this.f3932a));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o doInBackground(Integer... numArr) {
            try {
                int iIntValue = numArr[0].intValue();
                VLog.d("BBKCalculator/Evaluator ", "doInBackground: ");
                return new o(this.f3934c.f3965d.get().Z(iIntValue), iIntValue);
            } catch (ArithmeticException | x1.a.C0099a | x1.a.b unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(o oVar) {
            if (oVar == null) {
                this.f3934c.f3966e = "ERR";
                this.f3933b.b(this.f3932a, R.string.error_nan);
            } else {
                int i3 = oVar.f3980b;
                m mVar = this.f3934c;
                int i4 = mVar.f3967f;
                if (i3 < i4) {
                    throw new AssertionError("Unexpected onPostExecute timing");
                }
                mVar.f3966e = b.j2(mVar.f3966e, i4, oVar.f3979a, i3);
                this.f3934c.f3967f = oVar.f3980b;
                this.f3933b.g(this.f3932a);
            }
            this.f3934c.f3964c = null;
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    public interface f {
        void a();

        void b(int i3, int i4, int i5, String str);
    }

    /* JADX INFO: compiled from: Evaluator.java */
    public interface g {
        float a(String str, int i3);

        float getDecimalCredit();

        int getMaxChars();

        float getNoEllipsisCredit();
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private class h implements g {
        private h() {
        }

        @Override // com.vivo.calculator.b.g
        public float a(String str, int i3) {
            return 0.0f;
        }

        @Override // com.vivo.calculator.b.g
        public float getDecimalCredit() {
            return 0.0f;
        }

        @Override // com.vivo.calculator.b.g
        public int getMaxChars() {
            return 18;
        }

        @Override // com.vivo.calculator.b.g
        public float getNoEllipsisCredit() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    public interface i {
        void c(long j3, int i3);

        void d(long j3);

        void e(long j3, int i3, int i4, int i5, String str);
    }

    /* JADX INFO: compiled from: Evaluator.java */
    public interface j {
        void b(long j3, int i3);

        void f(long j3);

        void g(long j3);

        void h(long j3, int i3, int i4, int i5, String str);
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.vivo.calculator.a f3937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AsyncTask f3939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicReference<com.vivo.calculator.d> f3940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3941e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3942f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3943g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3944h = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3945i = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f3946j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f3947k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f3948l;

        public k(com.vivo.calculator.a aVar, boolean z2) {
            this.f3937a = aVar;
            VLog.d("BBKCalculator/Evaluator ", "ExprExInfo:  mExprEx == " + this.f3937a);
            this.f3938b = z2;
            this.f3940d = new AtomicReference<>();
        }

        public String toString() {
            return "mExpr:" + this.f3937a + ",mDegreeMode:" + this.f3938b;
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.vivo.calculator.a f3950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AsyncTask f3952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicReference<com.vivo.calculator.d> f3953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3954e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3955f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3956g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3957h = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f3958i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f3959j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3960k;

        public l(com.vivo.calculator.a aVar, boolean z2) {
            this.f3950a = aVar;
            VLog.d("BBKCalculator/Evaluator ", "ExprExchangeInfo:  mExprExchange == " + this.f3950a);
            this.f3951b = z2;
            this.f3953d = new AtomicReference<>();
        }

        public String toString() {
            return "mExpr:" + this.f3950a + ",mDegreeMode:" + this.f3951b;
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.vivo.calculator.a f3962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AsyncTask f3964c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3966e;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f3971j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3972k;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3967f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3968g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3969h = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f3970i = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicReference<com.vivo.calculator.d> f3965d = new AtomicReference<>();

        public m(com.vivo.calculator.a aVar, boolean z2) {
            this.f3962a = aVar;
            this.f3963b = z2;
        }

        public String toString() {
            return "mExpr:" + this.f3962a + ",mDegreeMode:" + this.f3963b;
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3980b;

        o(String str, int i3) {
            this.f3979a = str;
            this.f3980b = i3;
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private class p extends r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f3981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f3982d;

        p(long j3, boolean z2) {
            super();
            this.f3981c = j3;
            this.f3982d = z2;
        }

        @Override // com.vivo.calculator.b.r
        void c() {
            if (b.this.f3881c != 0) {
                VLog.e("BBKCalculator/Evaluator ", "setNow,Overwriting nonzero memory index:" + b.this.f3881c);
                return;
            }
            if (this.f3982d) {
                b.this.Z1(this.f3981c);
            } else {
                b.this.f3881c = this.f3981c;
            }
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private class q extends r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f3984c;

        q(long j3) {
            super();
            this.f3984c = j3;
        }

        @Override // com.vivo.calculator.b.r
        void c() {
            b.this.f3880b = this.f3984c;
        }
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private abstract class r implements j {
        private r() {
        }

        private void a() {
            throw new AssertionError("unexpected callback");
        }

        @Override // com.vivo.calculator.b.j
        public void b(long j3, int i3) {
        }

        abstract void c();

        @Override // com.vivo.calculator.b.j
        public void f(long j3) {
        }

        @Override // com.vivo.calculator.b.j
        public void g(long j3) {
            a();
        }

        @Override // com.vivo.calculator.b.j
        public void h(long j3, int i3, int i4, int i5, String str) {
            VLog.d("BBKCalculator/Evaluator ", "onEvaluate: ");
            c();
        }
    }

    b(Context context) {
        this.f3883e = context;
        W1(new m(new com.vivo.calculator.a(), false));
        this.f3884f = "none";
        this.f3894p = new com.vivo.calculator.c(context);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f3898t = defaultSharedPreferences;
        this.f3895q.f3963b = !defaultSharedPreferences.getBoolean("radflag", false);
        long j3 = this.f3898t.getLong("saved_index", 0L);
        long j4 = this.f3898t.getLong("memory_index", 0L);
        if (j3 != 0 && j3 != -1) {
            b2(j3);
        }
        if (j4 != 0 && j4 != -1) {
            a2(j4, false);
        }
        this.f3884f = this.f3898t.getString("saved_name", "none");
    }

    private boolean A1(long j3) {
        return j3 == 0;
    }

    private boolean B1(long j3) {
        return j3 == 0;
    }

    private m D0(long j3, long j4) {
        return S0(j3, j4, R.id.op_sub);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        f fVar = this.f3882d;
        if (fVar != null) {
            fVar.b(0, R.string.cancelled, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(boolean z2) {
        f fVar = this.f3882d;
        if (fVar != null) {
            fVar.b(R.string.dialog_timeout, R.string.timeout, z2 ? 0 : R.string.ok_remove_timeout, A);
        }
    }

    private void G0(long j3, int i3, j jVar) {
        m mVar = this.f3891m.get(Long.valueOf(j3));
        if ((mVar.f3966e != null && mVar.f3967f >= i3) || mVar.f3968g >= i3) {
            VLog.e("BBKCalculator/Evaluator ", " ensureCachePrec: return  ");
            return;
        }
        AsyncTask asyncTask = mVar.f3964c;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            mVar.f3964c = null;
        }
        e eVar = new e(j3, jVar);
        mVar.f3964c = eVar;
        int i4 = i3 + 30;
        mVar.f3968g = i4;
        if (mVar.f3966e != null) {
            mVar.f3968g = i4 + (i4 / 5);
        }
        VLog.d("BBKCalculator/Evaluator ", " ensureCachePrec: " + mVar.f3968g);
        eVar.execute(Integer.valueOf(mVar.f3968g));
    }

    private k H0(long j3) {
        k kVar = this.f3892n.get(Long.valueOf(j3));
        if (kVar != null) {
            VLog.d("BBKCalculator/Evaluator ", "ensureExExprIsCached: ei 11== " + kVar.f3940d);
            return kVar;
        }
        if (j3 == 0) {
            throw new AssertionError("Main expression should be cached");
        }
        VLog.d("BBKCalculator/Evaluator ", "ensureExExprIsCached: read database");
        com.vivo.calculator.c.e eVarT = this.f3894p.t(j3, 1);
        if (eVarT != null) {
            try {
                k kVar2 = new k(new com.vivo.calculator.a((DataInput) new DataInputStream(new ByteArrayInputStream(eVarT.f4004a)), true), eVarT.a());
                kVar2.f3947k = eVarT.f4006c;
                kVar2.f3946j = eVarT.d();
                kVar2.f3948l = eVarT.f4007d;
                kVar = kVar2;
            } catch (Exception e3) {
                throw new AssertionError("IO Exception without real IO:" + e3);
            }
        }
        k kVarPutIfAbsent = this.f3892n.putIfAbsent(Long.valueOf(j3), kVar);
        return kVarPutIfAbsent == null ? kVar : kVarPutIfAbsent;
    }

    private void I(int i3, int i4) {
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        aVar.e(R.id.digit_1);
        aVar.e(R.id.digit_0);
        this.f3887i = true;
        com.vivo.calculator.a aVar2 = this.f3895q.f3962a;
        int i5 = aVar2.E0(this.f3883e, i4) ? i4 : i4 + 1;
        this.f3895q.f3962a.f(this.f3883e, R.id.lparen, i4);
        int i6 = i5 + 1 + 1;
        this.f3895q.f3962a.s(this.f3883e, aVar, i5, false);
        this.f3895q.f3962a.f(this.f3883e, R.id.rparen, i6);
        aVar2.f(this.f3883e, R.id.op_pow, i6 + 1);
    }

    private l I0(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "ensureExchagneExprIsCached: index === " + j3);
        l lVar = this.f3893o.get(Long.valueOf(j3));
        VLog.d("BBKCalculator/Evaluator ", "ensureExchagneExprIsCached: ei === " + lVar);
        if (lVar != null) {
            VLog.d("BBKCalculator/Evaluator ", "ensureExchagneExprIsCached: ei 11== " + lVar.f3953d);
            return lVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ensureExchagneExprIsCached:  ");
        sb.append(j3 == 0);
        VLog.d("BBKCalculator/Evaluator ", sb.toString());
        if (j3 == 0) {
            throw new AssertionError("Main expression should be cached");
        }
        VLog.d("BBKCalculator/Evaluator ", "ensureExchagneExprIsCached: read database ");
        com.vivo.calculator.c.e eVarT = this.f3894p.t(j3, 2);
        if (eVarT != null) {
            try {
                l lVar2 = new l(new com.vivo.calculator.a((DataInput) new DataInputStream(new ByteArrayInputStream(eVarT.f4004a)), false), eVarT.a());
                lVar2.f3959j = eVarT.f4006c;
                lVar2.f3958i = eVarT.d();
                lVar2.f3960k = eVarT.f4007d;
                lVar = lVar2;
            } catch (Exception e3) {
                throw new AssertionError("IO Exception without real IO:" + e3);
            }
        }
        l lVarPutIfAbsent = this.f3893o.putIfAbsent(Long.valueOf(j3), lVar);
        return lVarPutIfAbsent == null ? lVar : lVarPutIfAbsent;
    }

    private void J(int i3, int i4) {
        VLog.d("BBKCalculator/Evaluator ", "add2x: ");
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        aVar.e(R.id.digit_2);
        this.f3887i = true;
        com.vivo.calculator.a aVar2 = this.f3895q.f3962a;
        int i5 = aVar2.E0(this.f3883e, i4) ? i4 : i4 + 1;
        this.f3895q.f3962a.s(this.f3883e, aVar, i4, false);
        aVar2.f(this.f3883e, R.id.op_pow, i5);
    }

    private m J0(long j3) {
        m mVar = this.f3891m.get(Long.valueOf(j3));
        if (mVar != null) {
            VLog.d("BBKCalculator/Evaluator ", "ensureExprIsCached: ei 11== " + mVar.f3965d);
            return mVar;
        }
        if (j3 == 0) {
            throw new AssertionError("Main expression should be cached");
        }
        VLog.d("BBKCalculator/Evaluator ", "ensureExprIsCached: read database");
        com.vivo.calculator.c.e eVarT = this.f3894p.t(j3, 0);
        if (eVarT != null) {
            try {
                m mVar2 = new m(new com.vivo.calculator.a(new DataInputStream(new ByteArrayInputStream(eVarT.f4004a))), eVarT.a());
                mVar2.f3971j = eVarT.f4006c;
                mVar2.f3970i = eVarT.d();
                mVar2.f3972k = eVarT.f4007d;
                mVar = mVar2;
            } catch (Exception e3) {
                throw new AssertionError("IO Exception without real IO:" + e3);
            }
        }
        m mVarPutIfAbsent = this.f3891m.putIfAbsent(Long.valueOf(j3), mVar);
        return mVarPutIfAbsent == null ? mVar : mVarPutIfAbsent;
    }

    private void L(int i3, int i4) {
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        aVar.e(R.id.digit_1);
        this.f3887i = true;
        com.vivo.calculator.a aVar2 = this.f3895q.f3962a;
        int i5 = aVar2.E0(this.f3883e, i4) ? i4 : i4 + 1;
        aVar2.f(this.f3883e, R.id.op_pow, i4);
        this.f3895q.f3962a.f(this.f3883e, R.id.op_sub, i5);
        this.f3895q.f3962a.s(this.f3883e, aVar, i5 + 1, false);
    }

    private void N(int i3, int i4, CalculatorFormula calculatorFormula) {
        int length = calculatorFormula.getText().toString().length();
        if (!this.f3895q.f3962a.Y0()) {
            if (length >= 4) {
                this.f3887i = true;
                this.f3895q.f3962a.D0();
                return;
            }
            return;
        }
        this.f3895q.f3962a.M0();
        this.f3887i = true;
        this.f3895q.f3962a.j(R.id.lparen, false);
        this.f3895q.f3962a.j(R.id.op_sub, false);
        this.f3895q.f3962a.j(R.id.rparen, true);
    }

    private void N0(long j3, j jVar, g gVar, boolean z2) {
        VLog.d("BBKCalculator/Evaluator ", "evaluateExResult: index:" + j3 + ",required:" + z2);
        k kVar = this.f3892n.get(Long.valueOf(j3));
        StringBuilder sb = new StringBuilder();
        sb.append("evaluateExResult: ExprInfo ei:");
        sb.append(kVar.f3940d);
        VLog.d("BBKCalculator/Evaluator ", sb.toString());
        if (j3 == 0) {
            VLog.d("BBKCalculator/Evaluator ", "evaluateExResult: index == MAIN_EXINDEX");
            m0();
        }
        c cVar = new c(j3, jVar, gVar, kVar.f3938b, z2);
        kVar.f3939c = cVar;
        cVar.execute(new Void[0]);
        if (j3 == 0) {
            this.f3888j = false;
            VLog.d("BBKCalculator/Evaluator ", "evaluateExResult:  mExChangedValue " + this.f3888j);
        }
    }

    private void O(int i3, int i4) {
        VLog.d("BBKCalculator/Evaluator ", "addSquare: ");
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        aVar.e(R.id.digit_2);
        this.f3887i = true;
        com.vivo.calculator.a aVar2 = this.f3895q.f3962a;
        int i5 = aVar2.E0(this.f3883e, i4) ? i4 : i4 + 1;
        aVar2.f(this.f3883e, R.id.op_pow, i4);
        this.f3895q.f3962a.s(this.f3883e, aVar, i5, false);
    }

    private void O0(long j3, i iVar, g gVar, boolean z2) {
        VLog.d("BBKCalculator/Evaluator ", "evaluateExchangeResult: index:" + j3 + ",required:" + z2);
        l lVar = this.f3893o.get(Long.valueOf(j3));
        StringBuilder sb = new StringBuilder();
        sb.append("evaluateExchangeResult: ExprInfo ei:");
        sb.append(lVar.f3953d);
        VLog.d("BBKCalculator/Evaluator ", sb.toString());
        if (j3 == 0) {
            n0();
        }
        d dVar = new d(j3, iVar, gVar, lVar.f3951b, z2);
        lVar.f3952c = dVar;
        dVar.execute(new Void[0]);
        if (j3 == 0) {
            this.f3889k = false;
            VLog.d("BBKCalculator/Evaluator ", "evaluateExchangeResult:mExExChangedValue ==  " + this.f3889k);
        }
    }

    private void P(int i3, int i4) {
        VLog.d("BBKCalculator/Evaluator ", "addSquares: ");
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        aVar.e(R.id.digit_3);
        this.f3887i = true;
        com.vivo.calculator.a aVar2 = this.f3895q.f3962a;
        int i5 = aVar2.E0(this.f3883e, i4) ? i4 : i4 + 1;
        aVar2.f(this.f3883e, R.id.op_pow, i4);
        this.f3895q.f3962a.s(this.f3883e, aVar, i5, false);
    }

    private void P0(long j3, j jVar, g gVar, boolean z2) {
        VLog.d("BBKCalculator/Evaluator ", "evaluateResult:index:" + j3 + ",required:" + z2);
        m mVar = this.f3891m.get(Long.valueOf(j3));
        StringBuilder sb = new StringBuilder();
        sb.append("evaluateResult:ExprInfo ei:");
        sb.append(mVar.f3965d);
        VLog.d("BBKCalculator/Evaluator ", sb.toString());
        if (j3 == 0) {
            p0();
        }
        AsyncTaskC0047b asyncTaskC0047b = new AsyncTaskC0047b(j3, jVar, gVar, mVar.f3963b, z2);
        mVar.f3964c = asyncTaskC0047b;
        asyncTaskC0047b.execute(new Void[0]);
        if (j3 == 0) {
            this.f3887i = false;
        }
    }

    private long Q(boolean z2, m mVar, int i3) {
        com.vivo.calculator.c.e eVar = new com.vivo.calculator.c.e(mVar.f3962a.i1(), mVar.f3963b, mVar.f3970i, i3, 0L);
        VLog.d("BBKCalculator/Evaluator ", "addToDB: rd == " + eVar);
        long jQ = this.f3894p.q(z2 ^ true, eVar);
        if (this.f3891m.get(Long.valueOf(jQ)) != null) {
            throw new AssertionError("result slot already occupied! + Slot = " + jQ);
        }
        mVar.f3971j = eVar.f4006c;
        mVar.f3972k = eVar.f4007d;
        if (jQ == 0) {
            throw new AssertionError("Should not store main expression");
        }
        VLog.d("BBKCalculator/Evaluator ", "addToDB: ");
        this.f3891m.put(Long.valueOf(jQ), mVar);
        return jQ;
    }

    public static int Q0(String str, int i3, boolean z2) {
        int length = str.length();
        if (i3 < length - 1 && str.charAt(i3) == 'E') {
            int i4 = i3 + 1;
            if (!z2 ? z1.e.r(str.charAt(i4)) == R.id.op_sub : z1.e.s(str.charAt(i4)) == R.id.e_op_sub) {
                i4++;
            }
            if (i4 != length && Character.isDigit(str.charAt(i4))) {
                int i5 = i4 + 1;
                while (i5 < length && Character.isDigit(str.charAt(i5))) {
                    i5++;
                    if (i5 > i3 + 8) {
                        return i3;
                    }
                }
                return i5;
            }
        }
        return i3;
    }

    private long R(boolean z2, k kVar, int i3) {
        com.vivo.calculator.c.e eVar = new com.vivo.calculator.c.e(kVar.f3937a.j1(), kVar.f3938b, kVar.f3946j, i3, 0L);
        VLog.d("BBKCalculator/Evaluator ", "addToDBEx: rd == " + eVar);
        long jQ = this.f3894p.q(z2 ^ true, eVar);
        if (this.f3892n.get(Long.valueOf(jQ)) != null) {
            throw new AssertionError("result slot already occupied! + Slot = " + jQ);
        }
        kVar.f3947k = eVar.f4006c;
        kVar.f3948l = eVar.f4007d;
        if (jQ == 0) {
            throw new AssertionError("Should not store main expression");
        }
        VLog.d("BBKCalculator/Evaluator ", "addToDBEx: ");
        this.f3892n.put(Long.valueOf(jQ), kVar);
        return jQ;
    }

    private int R0(Boolean bool) {
        return bool.booleanValue() ? 1 : 0;
    }

    private long S(boolean z2, l lVar, int i3) {
        com.vivo.calculator.c.e eVar = new com.vivo.calculator.c.e(lVar.f3950a.k1(), lVar.f3951b, lVar.f3958i, i3, 0L);
        VLog.d("BBKCalculator/Evaluator ", "addToDBExchange: rd == " + eVar);
        long jQ = this.f3894p.q(z2 ^ true, eVar);
        if (this.f3893o.get(Long.valueOf(jQ)) != null) {
            throw new AssertionError("result slot already occupied! + Slot = " + jQ);
        }
        lVar.f3959j = eVar.f4006c;
        lVar.f3960k = eVar.f4007d;
        if (jQ == 0) {
            throw new AssertionError("Should not store main expression");
        }
        VLog.d("BBKCalculator/Evaluator ", "addToDB: ");
        this.f3893o.put(Long.valueOf(jQ), lVar);
        return jQ;
    }

    private m S0(long j3, long j4, int i3) {
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        com.vivo.calculator.a aVarT0 = T0(j3);
        com.vivo.calculator.a aVarT1 = T0(j4);
        if (aVarT0 == null || aVarT1 == null) {
            return null;
        }
        if (j3 == 0) {
            aVar.e(R.id.digit_0);
        } else {
            aVar.t(aVarT0);
        }
        aVar.e(i3);
        aVar.t(aVarT1);
        m mVar = new m(aVar, false);
        mVar.f3970i = this.f3891m.get(Long.valueOf(j3)).f3970i || this.f3891m.get(Long.valueOf(j4)).f3970i;
        return mVar;
    }

    private com.vivo.calculator.a T0(long j3) {
        if (z1(j3)) {
            j3 = F1(j3, false);
        }
        m mVar = this.f3891m.get(Long.valueOf(j3));
        String str = mVar.f3966e;
        if (str == "ERR" || str == null) {
            return null;
        }
        int iI1 = i1(mVar.f3965d.get(), str, str.indexOf(46));
        VLog.d("BBKCalculator/Evaluator ", "getCollapsedExpr: getShortStringResult " + u1(this.f3883e, str, n1(str), iI1));
        return mVar.f3962a.a(j3, u1(this.f3883e, str, n1(str), iI1), str);
    }

    private void U(int i3, int i4) {
        VLog.d("BBKCalculator/Evaluator ", "addSquares: ");
        this.f3895q.f3962a.E0(this.f3883e, i4);
        this.f3895q.f3962a.f(this.f3883e, R.id.op_pow, i4);
        this.f3887i = true;
    }

    private com.vivo.calculator.a U0(long j3) {
        if (A1(j3)) {
            j3 = G1(j3, false);
        }
        k kVar = this.f3892n.get(Long.valueOf(j3));
        String str = kVar.f3941e;
        if (str == "ERR" || str == null) {
            return null;
        }
        String strY0 = Y0(this.f3883e, str, n1(str), i1(kVar.f3940d.get(), str, str.indexOf(46)));
        VLog.d("BBKCalculator/Evaluator ", "getCollapsedExprEx:  " + strY0);
        return kVar.f3937a.b(j3, strY0, str);
    }

    private void V(int i3, int i4) {
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        aVar.e(R.id.digit_1);
        this.f3887i = true;
        int i5 = this.f3895q.f3962a.E0(this.f3883e, i4) ? i4 : i4 + 1;
        this.f3895q.f3962a.f(this.f3883e, R.id.op_pow, i4);
        this.f3895q.f3962a.f(this.f3883e, R.id.lparen, i5);
        int i6 = i5 + 1;
        this.f3895q.f3962a.s(this.f3883e, aVar, i6, false);
        this.f3895q.f3962a.f(this.f3883e, R.id.op_div, i6 + 1);
    }

    private com.vivo.calculator.a V0(long j3) {
        if (B1(j3)) {
            j3 = H1(j3, false);
        }
        l lVar = this.f3893o.get(Long.valueOf(j3));
        String str = lVar.f3954e;
        VLog.d("BBKCalculator/Evaluator ", "getCollapsedExprExchange: mExchangeResultString == " + str);
        if (str == "ERR" || str == null) {
            return null;
        }
        String strY0 = Y0(this.f3883e, str, n1(str), i1(lVar.f3953d.get(), str, str.indexOf(46)));
        VLog.d("BBKCalculator/Evaluator ", "getCollapsedExprExchange:  " + strY0);
        return lVar.f3950a.c(j3, strY0, str);
    }

    private com.vivo.calculator.a W0(long j3) {
        if (z1(j3)) {
            j3 = F1(j3, false);
        }
        m mVar = this.f3891m.get(Long.valueOf(j3));
        String str = mVar.f3966e;
        if (str == "ERR" || str == null) {
            return null;
        }
        String strU1 = u1(this.f3883e, str, n1(str), i1(mVar.f3965d.get(), str, str.indexOf(46)));
        VLog.d("BBKCalculator/Evaluator ", "getCollapsedExprMr:  " + strU1);
        return mVar.f3962a.d(j3, strU1, str);
    }

    private void W1(m mVar) {
        this.f3895q = mVar;
        this.f3891m.put(0L, mVar);
    }

    private int X0(long j3) {
        k kVar;
        String str;
        ConcurrentHashMap<Long, k> concurrentHashMap = this.f3892n;
        if (concurrentHashMap == null || (kVar = concurrentHashMap.get(Long.valueOf(j3))) == null) {
            return Integer.MAX_VALUE;
        }
        int i3 = kVar.f3944h;
        if (i3 != Integer.MAX_VALUE) {
            if (kVar.f3941e.charAt(i3) == '0') {
                kVar.f3944h++;
            }
            return kVar.f3944h;
        }
        AtomicReference<com.vivo.calculator.d> atomicReference = kVar.f3940d;
        if (atomicReference == null || atomicReference.get() == null || kVar.f3940d.get().w() || (str = kVar.f3941e) == null) {
            return Integer.MAX_VALUE;
        }
        int iN1 = n1(str);
        kVar.f3944h = iN1;
        return iN1;
    }

    private void X1(k kVar) {
        this.f3896r = kVar;
        this.f3892n.put(0L, kVar);
    }

    private void Y1(l lVar) {
        this.f3897s = lVar;
        this.f3893o.put(0L, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(long j3) {
        this.f3881c = j3;
        this.f3898t.edit().putLong("memory_index", j3).apply();
        f fVar = this.f3882d;
        if (fVar != null) {
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(m mVar, Runnable runnable, n nVar, boolean z2, long j3, j jVar, g gVar) {
        VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator onPostExecute.");
        mVar.f3964c = null;
        this.f3899u.removeCallbacks(runnable);
        if (nVar.a()) {
            int i3 = nVar.f3974a;
            if (i3 != R.string.timeout) {
                if (z2) {
                    mVar.f3966e = "ERR";
                }
                jVar.b(j3, i3);
                return;
            } else {
                if (z2 && j3 == 0) {
                    F0(this.f3891m.get(Long.valueOf(j3)).f3970i);
                }
                jVar.f(j3);
                return;
            }
        }
        VLog.d("BBKCalculator/Evaluator ", "AsyncEvaluator onPostExecute:newResultString  " + nVar.f3976c);
        String str = nVar.f3976c;
        mVar.f3966e = str;
        mVar.f3967f = nVar.f3977d;
        int iIndexOf = str.indexOf(46);
        String strSubstring = mVar.f3966e.substring(0, iIndexOf);
        int i4 = nVar.f3978e;
        mVar.f3969h = n1(mVar.f3966e);
        int iI1 = i1(nVar.f3975b, mVar.f3966e, iIndexOf);
        int iO1 = o1(mVar.f3966e, mVar.f3969h, iI1, gVar);
        if (iO1 < i4) {
            i4 = iO1;
        }
        VLog.d("BBKCalculator/Evaluator ", "onPostExecute: AsyncEvaluator mListener.onEvaluate");
        jVar.h(j3, i4, mVar.f3969h, iI1, strSubstring);
    }

    private int a1(long j3) {
        l lVar;
        ConcurrentHashMap<Long, l> concurrentHashMap = this.f3893o;
        if (concurrentHashMap == null || (lVar = concurrentHashMap.get(Long.valueOf(j3))) == null) {
            return Integer.MAX_VALUE;
        }
        if (lVar.f3957h != Integer.MAX_VALUE) {
            VLog.d("BBKCalculator/Evaluator ", "getExchangeMsdIndex: mExchangeResultString == " + lVar.f3954e);
            if (lVar.f3954e.charAt(lVar.f3957h) == '0') {
                lVar.f3957h++;
            }
            return lVar.f3957h;
        }
        AtomicReference<com.vivo.calculator.d> atomicReference = lVar.f3953d;
        if (atomicReference == null || atomicReference.get() == null || lVar.f3953d.get().w()) {
            return Integer.MAX_VALUE;
        }
        VLog.d("BBKCalculator/Evaluator ", "getExchangeMsdIndex: mExchangeResultString == " + lVar.f3954e);
        String str = lVar.f3954e;
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        int iN1 = n1(str);
        lVar.f3957h = iN1;
        return iN1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(k kVar, Runnable runnable, n nVar, boolean z2, long j3, j jVar, g gVar) {
        VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator onPostExecute: local ");
        kVar.f3939c = null;
        this.f3899u.removeCallbacks(runnable);
        if (nVar.a()) {
            int i3 = nVar.f3974a;
            if (i3 != R.string.timeout) {
                if (z2) {
                    kVar.f3941e = "ERR";
                }
                jVar.b(j3, i3);
                return;
            } else {
                if (z2 && j3 == 0) {
                    F0(this.f3891m.get(Long.valueOf(j3)).f3970i);
                }
                jVar.f(j3);
                return;
            }
        }
        VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator onPostExecute: mExResultString  " + nVar.f3976c);
        String str = nVar.f3976c;
        kVar.f3941e = str;
        kVar.f3942f = nVar.f3977d;
        int iIndexOf = str.indexOf(46);
        String strSubstring = kVar.f3941e.substring(0, iIndexOf);
        int i4 = nVar.f3978e;
        kVar.f3944h = n1(kVar.f3941e);
        int iI1 = i1(nVar.f3975b, kVar.f3941e, iIndexOf);
        int iO1 = o1(kVar.f3941e, kVar.f3944h, iI1, gVar);
        if (iO1 < i4) {
            i4 = iO1;
        }
        VLog.d("BBKCalculator/Evaluator ", "AsyncExEvaluator onPostExecute: mListener.onEvaluate");
        jVar.h(j3, i4, kVar.f3944h, iI1, strSubstring);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(l lVar, Runnable runnable, n nVar, boolean z2, long j3, i iVar, g gVar) {
        VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator onPostExecute: other  ");
        lVar.f3952c = null;
        this.f3899u.removeCallbacks(runnable);
        if (nVar.a()) {
            int i3 = nVar.f3974a;
            if (i3 != R.string.timeout) {
                if (z2) {
                    lVar.f3954e = "ERR";
                }
                iVar.c(j3, i3);
                return;
            } else {
                if (z2 && j3 == 0) {
                    F0(this.f3891m.get(Long.valueOf(j3)).f3970i);
                }
                iVar.d(j3);
                return;
            }
        }
        VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator onPostExecute:newResultString other " + nVar.f3976c);
        String str = nVar.f3976c;
        lVar.f3954e = str;
        lVar.f3955f = nVar.f3977d;
        int iIndexOf = str.indexOf(46);
        String strSubstring = lVar.f3954e.substring(0, iIndexOf);
        int i4 = nVar.f3978e;
        lVar.f3957h = n1(lVar.f3954e);
        int iI1 = i1(nVar.f3975b, lVar.f3954e, iIndexOf);
        int iO1 = o1(lVar.f3954e, lVar.f3957h, iI1, gVar);
        if (iO1 < i4) {
            i4 = iO1;
        }
        VLog.d("BBKCalculator/Evaluator ", "AsyncExchangeEvaluator onPostExecute: mListener.onExEvaluate");
        iVar.e(j3, i4, lVar.f3957h, iI1, strSubstring);
    }

    public static b c1(Context context) {
        if (f3876x == null) {
            f3876x = new b(context.getApplicationContext());
        }
        return f3876x;
    }

    private boolean d0(String str, int i3) {
        try {
            Number number = NumberFormat.getInstance(Locale.getDefault()).parse(str);
            return number != null && number.toString().length() == i3;
        } catch (NumberFormatException e3) {
            VLog.i("Evaluator", "NumberFormatException " + e3);
            return false;
        } catch (ParseException e4) {
            VLog.i("Evaluator", "ParseException " + e4);
            return false;
        }
    }

    public static b d1(Context context) {
        VLog.d("BBKCalculator/Evaluator ", "getInstanceEx:  local evaluatorEx == " + f3877y);
        if (f3877y == null) {
            f3877y = new b(context.getApplicationContext(), Boolean.TRUE);
        }
        return f3877y;
    }

    public static b e1(Context context) {
        VLog.d("BBKCalculator/Evaluator ", "getInstanceEx:  other evaluatorExchange == " + f3878z);
        if (f3878z == null) {
            f3878z = new b(context.getApplicationContext(), Boolean.FALSE, false);
        }
        return f3878z;
    }

    private m f2(long j3, long j4) {
        return S0(j3, j4, R.id.op_add);
    }

    private boolean g0(m mVar, boolean z2) {
        AsyncTask asyncTask = mVar.f3964c;
        if (asyncTask == null) {
            return false;
        }
        if (z2 && (asyncTask instanceof AsyncTaskC0047b)) {
            ((AsyncTaskC0047b) asyncTask).h();
        }
        if (mVar.f3965d.get() != null) {
            mVar.f3964c.cancel(true);
            mVar.f3968g = mVar.f3967f;
            mVar.f3964c = null;
            return false;
        }
        mVar.f3964c.cancel(true);
        m mVar2 = this.f3895q;
        if (mVar == mVar2) {
            mVar2.f3962a = (com.vivo.calculator.a) mVar2.f3962a.clone();
            this.f3887i = true;
        }
        mVar.f3964c = null;
        return true;
    }

    private boolean i0(k kVar, boolean z2) {
        VLog.d("BBKCalculator/Evaluator ", "cancelEx: ");
        AsyncTask asyncTask = kVar.f3939c;
        if (asyncTask == null) {
            return false;
        }
        if (z2 && (asyncTask instanceof c)) {
            ((c) asyncTask).h();
        }
        AtomicReference<com.vivo.calculator.d> atomicReference = kVar.f3940d;
        if (atomicReference != null && atomicReference.get() != null) {
            kVar.f3939c.cancel(true);
            kVar.f3943g = kVar.f3942f;
            kVar.f3939c = null;
            return false;
        }
        kVar.f3939c.cancel(true);
        k kVar2 = this.f3896r;
        if (kVar == kVar2) {
            kVar2.f3937a = (com.vivo.calculator.a) kVar2.f3937a.F();
            this.f3888j = true;
            VLog.d("BBKCalculator/Evaluator ", "cancelEx:  mExChangedValue " + this.f3888j);
        }
        kVar.f3939c = null;
        VLog.d("BBKCalculator/Evaluator ", "cancelExchange: return expr.mExEvaluator = null");
        return true;
    }

    static int i1(com.vivo.calculator.d dVar, String str, int i3) {
        if (dVar == null || dVar.w()) {
            return Integer.MIN_VALUE;
        }
        int iX = dVar.x();
        if (iX == 0) {
            iX = -1;
            while (true) {
                int i4 = i3 + iX;
                if (i4 <= 0 || str.charAt(i4) != '0') {
                    break;
                }
                iX--;
            }
        }
        return iX;
    }

    public static String j2(String str, int i3, String str2, int i4) {
        VLog.d("BBKCalculator/Evaluator ", "unflipZeroes: ");
        if (str == null && str2 == null) {
            return BuildConfig.FLAVOR;
        }
        if (str == null && str2 != null) {
            return str2;
        }
        if (str != null && str2 == null) {
            return str;
        }
        if (str.charAt(str.length() - 1) != '9') {
            return str2;
        }
        int length = str2.length();
        int i5 = i4 - i3;
        if (str2.charAt((length - 1) - i5) != '0') {
            return str2;
        }
        if (!str2.substring(length - i5).equals(z1.g.e('0', i5))) {
            throw new AssertionError("New approximation invalidates old one!");
        }
        return str + z1.g.e('9', i5);
    }

    private boolean k0(l lVar, boolean z2) {
        VLog.d("BBKCalculator/Evaluator ", "cancelExchange: ");
        AsyncTask asyncTask = lVar.f3952c;
        if (asyncTask == null) {
            return false;
        }
        if (z2 && (asyncTask instanceof d)) {
            ((d) asyncTask).h();
        }
        if (lVar.f3953d.get() != null) {
            lVar.f3952c.cancel(true);
            lVar.f3956g = lVar.f3955f;
            lVar.f3952c = null;
            return false;
        }
        lVar.f3952c.cancel(true);
        l lVar2 = this.f3897s;
        if (lVar == lVar2) {
            lVar2.f3950a = (com.vivo.calculator.a) lVar2.f3950a.G();
            VLog.d("BBKCalculator/Evaluator ", "cancelExchange:  mExExChangedValue == " + this.f3889k);
            this.f3889k = true;
        }
        lVar.f3952c = null;
        VLog.d("BBKCalculator/Evaluator ", "cancelExchange: return expr.mExchangeEvaluator = null");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k1(boolean z2) {
        return z2 ? 700000 : 240000;
    }

    private void m0() {
        k kVar = this.f3896r;
        if (kVar == null) {
            return;
        }
        AtomicReference<com.vivo.calculator.d> atomicReference = kVar.f3940d;
        if (atomicReference != null) {
            atomicReference.set(null);
        }
        VLog.d("BBKCalculator/Evaluator ", "clearExMainCache: ");
        k kVar2 = this.f3896r;
        kVar2.f3941e = null;
        kVar2.f3943g = 0;
        kVar2.f3942f = 0;
        kVar2.f3944h = Integer.MAX_VALUE;
    }

    private int m1(long j3) {
        m mVar;
        String str;
        ConcurrentHashMap<Long, m> concurrentHashMap = this.f3891m;
        if (concurrentHashMap == null || (mVar = concurrentHashMap.get(Long.valueOf(j3))) == null) {
            return Integer.MAX_VALUE;
        }
        int i3 = mVar.f3969h;
        if (i3 != Integer.MAX_VALUE) {
            if (mVar.f3966e.charAt(i3) == '0') {
                mVar.f3969h++;
            }
            return mVar.f3969h;
        }
        AtomicReference<com.vivo.calculator.d> atomicReference = mVar.f3965d;
        if (atomicReference == null || atomicReference.get() == null || mVar.f3965d.get().w() || (str = mVar.f3966e) == null) {
            return Integer.MAX_VALUE;
        }
        int iN1 = n1(str);
        mVar.f3969h = iN1;
        return iN1;
    }

    private void n0() {
        l lVar = this.f3897s;
        if (lVar == null) {
            return;
        }
        AtomicReference<com.vivo.calculator.d> atomicReference = lVar.f3953d;
        if (atomicReference != null) {
            atomicReference.set(null);
        }
        VLog.d("BBKCalculator/Evaluator ", "clearExchangeMainCache: ");
        l lVar2 = this.f3897s;
        lVar2.f3954e = null;
        lVar2.f3956g = 0;
        lVar2.f3955f = 0;
        lVar2.f3957h = Integer.MAX_VALUE;
    }

    public static int n1(String str) {
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '-' && cCharAt != '.' && cCharAt != '0') {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            return Integer.MAX_VALUE;
        }
        if (i3 < length - 1 || str.charAt(i3) != '1') {
            return i3;
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o1(String str, int i3, int i4, g gVar) {
        int maxChars = gVar.getMaxChars();
        int iIndexOf = str.indexOf(46);
        float fA = gVar.a(str, iIndexOf) - gVar.getNoEllipsisCredit();
        float decimalCredit = fA - gVar.getDecimalCredit();
        int iCeil = (int) Math.ceil(Math.max(fA, 0.0f));
        int iCeil2 = (int) Math.ceil(Math.max(decimalCredit, 0.0f));
        int i5 = str.charAt(0) == '-' ? 1 : 0;
        if (i4 == 0) {
            i4 = -1;
        }
        if (i4 != Integer.MAX_VALUE) {
            if (iIndexOf <= maxChars - iCeil && i4 <= 0) {
                return -1;
            }
            if (i4 >= 0 && iIndexOf + i4 + 1 <= maxChars - iCeil2) {
                return i4;
            }
        }
        if (i3 > iIndexOf && i3 <= iIndexOf + 3 + 1) {
            i3 = iIndexOf - 1;
        }
        if (i3 > 150000) {
            return maxChars - 2;
        }
        int i6 = (((i3 - iIndexOf) + maxChars) - i5) - 1;
        if (iIndexOf <= maxChars - iCeil) {
            return iIndexOf < maxChars - iCeil2 ? i6 - iCeil2 : i6 - iCeil;
        }
        return i6;
    }

    private void p0() {
        m mVar = this.f3895q;
        if (mVar == null) {
            return;
        }
        AtomicReference<com.vivo.calculator.d> atomicReference = mVar.f3965d;
        if (atomicReference != null) {
            atomicReference.set(null);
        }
        m mVar2 = this.f3895q;
        mVar2.f3966e = null;
        mVar2.f3968g = 0;
        mVar2.f3967f = 0;
        mVar2.f3969h = Integer.MAX_VALUE;
    }

    public static String p1(Context context, String str, int i3, int i4, int i5, int i6, int i7, int i8, String str2, boolean z2) {
        String str3 = str;
        if (i3 > i4) {
            str3 = str.substring(0, i3) + str.substring(i3 + 1, str.length());
            VLog.d("BBKCalculator/Evaluator ", "formatResult:   result = decIndex > msdIndex == " + str3);
        }
        int i9 = i4 + 1;
        String strSubstring = str3.substring(i9, str3.length());
        VLog.d("BBKCalculator/Evaluator ", "formatResult:   fraction " + strSubstring);
        String strX = str2 + str3.substring(i4, i9) + "." + strSubstring;
        VLog.d("BBKCalculator/Evaluator ", "formatResult:   result== " + strX);
        try {
            strX = g2.b.x(Double.parseDouble(strX.replaceAll(",", BuildConfig.FLAVOR)), (i8 > 0 ? context.getResources().getInteger(R.integer.result_decimal_places_number) : context.getResources().getInteger(R.integer.ex_result_decimal_places_number)) - 2);
            if (strX.indexOf(".") > 0 && strX.endsWith("0")) {
                for (int length = strX.length(); length >= 0 && strX.endsWith("0"); length--) {
                    strX = strX.substring(0, length);
                }
            }
            return strX + "E" + i8;
        } catch (Exception e3) {
            VLog.e("BBKCalculator/Evaluator ", "formatResult,Exception 1 " + e3);
            if (z2) {
                return str2 + strX.charAt(i4) + "." + strX.substring(i9, i5 + 1) + "E" + i8;
            }
            return str2 + strX.charAt(i4) + "." + strX.substring(i9, (((i4 + i6) - i7) - 4) + 1) + "E" + i8;
        }
    }

    private static String t1(Context context, String str, int i3, int i4, boolean z2) {
        int i5;
        int i6 = i4;
        int integer = context.getResources().getInteger(R.integer.result_decimal_places_number);
        int integer2 = context.getResources().getInteger(R.integer.result_decimal_places);
        int iIndexOf = str.indexOf(46);
        int i7 = str.charAt(0) == '-' ? 1 : 0;
        String str2 = i7 == 1 ? "-" : BuildConfig.FLAVOR;
        int i8 = i3;
        if (i8 >= str.length() - integer) {
            i8 = Integer.MAX_VALUE;
        }
        if (i8 == Integer.MAX_VALUE) {
            return i6 < 50 ? "0" : "0.00000";
        }
        int i9 = z2 ? 3 : 12;
        if (i6 < -1 && (iIndexOf - i8) + i7 <= integer && i6 >= -13) {
            i6 = -1;
        }
        int i10 = (i8 <= iIndexOf || (i8 > (iIndexOf + 3) + 1 && (i6 > (integer - i7) + (-2) || i6 > i9 + 1))) ? i8 : iIndexOf - 1;
        int i11 = iIndexOf - i10;
        if (i11 > 0) {
            i11--;
        }
        if (i7 == 1) {
            integer2++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getShortString:   subLength == ");
        sb.append(iIndexOf > 0 && Math.abs(i11) <= integer);
        VLog.d("BBKCalculator/Evaluator ", sb.toString());
        if (!z2 && iIndexOf > 0 && Math.abs(i11) <= integer) {
            String strSubstring = str.substring(0, integer2);
            VLog.d("BBKCalculator/Evaluator ", "getShortString:  cache = " + strSubstring);
            return strSubstring;
        }
        if (i6 != Integer.MAX_VALUE) {
            int i12 = iIndexOf + i6;
            int i13 = (i12 - i10) + i7 + 1;
            if (i13 <= integer && iIndexOf > i10 && i6 >= -1) {
                return str2 + z1.g.a(str, i10, iIndexOf) + str.substring(iIndexOf, i12 + 1);
            }
            if (i13 <= integer - 3) {
                if (z2) {
                    return p1(context, str, iIndexOf, i10, i12, integer, i7, i11, str2, true);
                }
                return str2 + str.charAt(i10) + "." + str.substring(i10 + 1, i12 + 1) + "E" + i11;
            }
        }
        if (iIndexOf > i10 && iIndexOf < (i5 = ((i10 + integer) - i7) - 1)) {
            return str2 + z1.g.a(str, i10, iIndexOf) + str.substring(iIndexOf, i5);
        }
        if (z2) {
            return p1(context, str, iIndexOf, i10, 0, integer, i7, i11, str2, false);
        }
        return str2 + str.charAt(i10) + "." + str.substring(i10 + 1, ((i10 + integer) - i7) - 1) + "E" + i11;
    }

    private m w0(long j3, boolean z2) {
        m mVar = this.f3891m.get(Long.valueOf(j3));
        m mVar2 = new m((com.vivo.calculator.a) mVar.f3962a.clone(), mVar.f3963b);
        while (mVar2.f3962a.F0()) {
            mVar2.f3962a.H();
        }
        if (z2) {
            mVar2.f3965d = new AtomicReference<>(mVar.f3965d.get());
            mVar2.f3966e = mVar.f3966e;
            int i3 = mVar.f3967f;
            mVar2.f3968g = i3;
            mVar2.f3967f = i3;
            mVar2.f3969h = mVar.f3969h;
        }
        mVar2.f3970i = mVar.f3970i;
        return mVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long w1(boolean z2) {
        return z2 ? 15000L : 1000L;
    }

    private k x0(long j3, boolean z2) {
        k kVar = this.f3892n.get(Long.valueOf(j3));
        k kVar2 = new k((com.vivo.calculator.a) kVar.f3937a.F(), kVar.f3938b);
        while (kVar2.f3937a.I0()) {
            kVar2.f3937a.N();
        }
        if (z2) {
            kVar2.f3940d = new AtomicReference<>(kVar.f3940d.get());
            kVar2.f3941e = kVar.f3941e;
            int i3 = kVar.f3942f;
            kVar2.f3943g = i3;
            kVar2.f3942f = i3;
            VLog.d("BBKCalculator/Evaluator ", "copyEx:  ei.mExResultString  == " + kVar2.f3941e);
            VLog.d("BBKCalculator/Evaluator ", "copyEx:  ei.mExResultStringOffset  == " + kVar2.f3942f);
            kVar2.f3944h = kVar.f3944h;
        }
        kVar2.f3946j = kVar.f3946j;
        return kVar2;
    }

    private m x1(int i3) {
        com.vivo.calculator.a aVar = new com.vivo.calculator.a();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3883e);
        String string = defaultSharedPreferences.getString("mcmrResult", null);
        defaultSharedPreferences.edit();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        aVar.e(R.id.digit_0);
        if (string.indexOf("−") <= 0 && string.indexOf("-") <= 0) {
            aVar.e(i3);
        }
        int i4 = 0;
        while (i4 < string.length()) {
            int i5 = i4 + 1;
            aVar.e(z1.e.B(this.f3883e, string.substring(i4, i5)));
            i4 = i5;
        }
        return new m(aVar, false);
    }

    private l y0(long j3, boolean z2) {
        l lVar = this.f3893o.get(Long.valueOf(j3));
        l lVar2 = new l((com.vivo.calculator.a) lVar.f3950a.G(), lVar.f3951b);
        VLog.d("BBKCalculator/Evaluator ", "copyExchange: mExchangeResultString == " + lVar2.f3954e);
        while (lVar2.f3950a.J0()) {
            lVar2.f3950a.O();
        }
        if (z2) {
            lVar2.f3953d = new AtomicReference<>(lVar.f3953d.get());
            lVar2.f3954e = lVar.f3954e;
            int i3 = lVar.f3955f;
            lVar2.f3956g = i3;
            lVar2.f3955f = i3;
            lVar2.f3957h = lVar.f3957h;
        }
        lVar2.f3958i = lVar.f3958i;
        return lVar2;
    }

    private boolean z1(long j3) {
        return j3 == 0 || j3 == -1;
    }

    public String A0(int i3) {
        this.f3887i = true;
        String strK = this.f3895q.f3962a.K(this.f3883e, i3);
        if (this.f3895q.f3962a.P0()) {
            this.f3895q.f3970i = false;
        }
        if (strK != null) {
            return strK;
        }
        return null;
    }

    public String B0(int i3) {
        this.f3888j = true;
        String strL = this.f3896r.f3937a.L(this.f3883e, i3);
        if (this.f3896r.f3937a.Q0()) {
            this.f3896r.f3946j = false;
        }
        if (strL != null) {
            return strL;
        }
        return null;
    }

    public String C0(int i3) {
        this.f3889k = true;
        String strM = this.f3897s.f3950a.M(this.f3883e, i3);
        if (this.f3897s.f3950a.R0()) {
            this.f3897s.f3958i = false;
        }
        if (strM != null) {
            return strM;
        }
        return null;
    }

    void C1(long j3, k kVar, j jVar, g gVar, boolean z2) {
        VLog.d("BBKCalculator/Evaluator ", "notifyImmediately: ");
        if (kVar == null || kVar.f3940d == null) {
            return;
        }
        int iIndexOf = kVar.f3941e.indexOf(46);
        String strSubstring = kVar.f3941e.substring(0, iIndexOf);
        int iI1 = i1(kVar.f3940d.get(), kVar.f3941e, iIndexOf);
        int iX0 = X0(j3);
        jVar.h(j3, o1(kVar.f3941e, iX0, iI1, gVar), iX0, iI1, strSubstring);
    }

    void D1(long j3, l lVar, i iVar, g gVar, boolean z2) {
        if (lVar == null || lVar.f3953d == null) {
            return;
        }
        VLog.d("BBKCalculator/Evaluator ", "notifyImmediately: mExchangeResultString == " + lVar.f3954e);
        int iIndexOf = lVar.f3954e.indexOf(46);
        String strSubstring = lVar.f3954e.substring(0, iIndexOf);
        int iI1 = i1(lVar.f3953d.get(), lVar.f3954e, iIndexOf);
        int iA1 = a1(j3);
        iVar.e(j3, o1(lVar.f3954e, iA1, iI1, gVar), iA1, iI1, strSubstring);
    }

    void E1(long j3, m mVar, j jVar, g gVar) {
        VLog.d("BBKCalculator/Evaluator ", "notifyImmediately: ei:" + mVar);
        if (mVar == null || mVar.f3965d == null) {
            VLog.d("BBKCalculator/Evaluator ", "notifyImmediately,null,return.");
            return;
        }
        int iIndexOf = mVar.f3966e.indexOf(46);
        String strSubstring = mVar.f3966e.substring(0, iIndexOf);
        int iI1 = i1(mVar.f3965d.get(), mVar.f3966e, iIndexOf);
        int iM1 = m1(j3);
        jVar.h(j3, o1(mVar.f3966e, iM1, iI1, gVar), iM1, iI1, strSubstring);
    }

    public long F1(long j3, boolean z2) {
        m mVarW0 = w0(j3, true);
        VLog.d("BBKCalculator/Evaluator ", "preserve  ei == " + mVarW0.f3965d);
        String str = mVarW0.f3966e;
        if (str == null || str == "ERR") {
            VLog.d("BBKCalculator/Evaluator ", "preserve Preserving unevaluated expression");
        }
        return Q(z2, mVarW0, R0(Boolean.valueOf(z2)));
    }

    public long G1(long j3, boolean z2) {
        k kVarX0 = x0(j3, true);
        VLog.d("BBKCalculator/Evaluator ", "preserveEx  ei == " + kVarX0.f3940d);
        String str = kVarX0.f3941e;
        if (str == null || str == "ERR") {
            VLog.d("BBKCalculator/Evaluator ", "preserveEx Preserving unevaluated expression");
        }
        return R(z2, kVarX0, R0(Boolean.valueOf(z2)));
    }

    public long H1(long j3, boolean z2) {
        l lVarY0 = y0(j3, true);
        VLog.d("BBKCalculator/Evaluator ", "preserveExchange  ei == " + lVarY0.f3953d);
        VLog.d("BBKCalculator/Evaluator ", "preserveExchange  mExchangeResultString  == " + lVarY0.f3954e);
        String str = lVarY0.f3954e;
        if (str == null || str == "ERR") {
            VLog.d("BBKCalculator/Evaluator ", "preserveExchange Preserving unevaluated expression");
        }
        return S(z2, lVarY0, R0(Boolean.valueOf(z2)));
    }

    public void I1() {
        VLog.d("BBKCalculator/Evaluator ", "represerve: ");
        J0(j1());
    }

    public void J1() {
        VLog.d("BBKCalculator/Evaluator ", "represerve: ");
        H0(j1());
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0017 -> B:5:0x0011). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public void K(java.lang.String r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 1
            int r7 = r7 + r0
            char r1 = r6.charAt(r7)
            int r1 = z1.e.r(r1)
            r2 = 0
            r3 = 2131231179(0x7f0801cb, float:1.8078432E38)
            if (r1 != r3) goto L14
            r1 = -1
        L11:
            int r7 = r7 + 1
            goto L15
        L14:
            r1 = r0
        L15:
            if (r7 >= r8) goto L25
            int r2 = r2 * 10
            char r3 = r6.charAt(r7)
            r4 = 10
            int r3 = java.lang.Character.digit(r3, r4)
            int r2 = r2 + r3
            goto L11
        L25:
            com.vivo.calculator.b$m r6 = r5.f3895q
            com.vivo.calculator.a r6 = r6.f3962a
            int r1 = r1 * r2
            r6.i(r1)
            r5.f3887i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.calculator.b.K(java.lang.String, int, int):void");
    }

    public void K0(long j3, j jVar, g gVar) {
        if (gVar.getMaxChars() == 0) {
            VLog.d("BBKCalculator/Evaluator ", "evaluateAndNotify: cmi.getMaxChars() == 0");
            return;
        }
        m mVarJ0 = J0(j3);
        StringBuilder sb = new StringBuilder();
        sb.append("evaluateAndNotify: Calculator");
        String str = mVarJ0.f3966e;
        sb.append((str == null || str == "ERR" || (j3 == 0 && this.f3887i)) ? false : true);
        VLog.d("BBKCalculator/Evaluator ", sb.toString());
        String str2 = mVarJ0.f3966e;
        if (str2 != null && str2 != "ERR" && (j3 != 0 || !this.f3887i)) {
            VLog.d("BBKCalculator/Evaluator ", "evaluateAndNotifyEx: calculator transfer notifyImmediately ");
            E1(0L, this.f3895q, jVar, gVar);
        } else {
            if (mVarJ0.f3964c != null) {
                return;
            }
            P0(j3, jVar, gVar, false);
        }
    }

    public void K1() {
        VLog.d("BBKCalculator/Evaluator ", "represerve: ");
        I0(j1());
    }

    public void L0(long j3, j jVar, g gVar) {
        if (gVar.getMaxChars() == 0) {
            VLog.d("BBKCalculator/Evaluator ", "evaluateAndNotifyEx: cmi.getMaxChars() == 0");
            return;
        }
        k kVarH0 = H0(j3);
        StringBuilder sb = new StringBuilder();
        sb.append(" evaluateAndNotifyEx: 1");
        sb.append(kVarH0.f3941e != null);
        VLog.i("BBKCalculator/Evaluator ", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" evaluateAndNotifyEx: 2");
        sb2.append(kVarH0.f3941e != "ERR");
        VLog.i("BBKCalculator/Evaluator ", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" evaluateAndNotifyEx: 3 ");
        sb3.append((j3 == 0 && this.f3888j) ? false : true);
        VLog.i("BBKCalculator/Evaluator ", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" evaluateAndNotifyEx: 4");
        sb4.append(j3 == 0);
        VLog.i("BBKCalculator/Evaluator ", sb4.toString());
        VLog.i("BBKCalculator/Evaluator ", " evaluateAndNotifyEx: 5 mExChangedValue " + this.f3888j);
        String str = kVarH0.f3941e;
        if (str != null && str != "ERR" && (j3 != 0 || !this.f3888j)) {
            VLog.d("BBKCalculator/Evaluator ", "evaluateAndNotifyEx: local transfer notifyImmediately ");
            C1(0L, this.f3896r, jVar, gVar, true);
        } else {
            if (kVarH0.f3939c != null) {
                return;
            }
            N0(j3, jVar, gVar, false);
        }
    }

    public void L1(long j3, j jVar, g gVar) {
        VLog.d("BBKCalculator/Evaluator ", "requireResult: ");
        if (gVar.getMaxChars() == 0) {
            VLog.d("BBKCalculator/Evaluator ", "requireResult: cmi.getMaxChars() == 0");
            return;
        }
        m mVarJ0 = J0(j3);
        String str = mVarJ0.f3966e;
        if (str != null && (j3 != 0 || !this.f3887i)) {
            if (str != "ERR") {
                E1(j3, mVarJ0, jVar, gVar);
                return;
            } else {
                g0(mVarJ0, true);
                P0(j3, jVar, gVar, true);
                return;
            }
        }
        if (j3 == -1) {
            jVar.f(j3);
            return;
        }
        AsyncTask asyncTask = mVarJ0.f3964c;
        if ((asyncTask instanceof AsyncTaskC0047b) && ((AsyncTaskC0047b) asyncTask).f3903b) {
            g0(mVarJ0, true);
            P0(j3, jVar, gVar, true);
        } else {
            g0(mVarJ0, true);
            P0(j3, jVar, gVar, true);
        }
    }

    public void M() {
        m mVarX1 = x1(R.id.op_add);
        if (mVarX1 != null) {
            long jQ = Q(false, mVarX1, 2);
            this.f3881c = 0L;
            a2(jQ, true);
        }
    }

    public void M0(long j3, i iVar, g gVar) {
        if (gVar.getMaxChars() == 0) {
            VLog.d("BBKCalculator/Evaluator ", "evaluateAndNotifyExchange: cmi.getMaxChars() == 0");
            return;
        }
        l lVarI0 = I0(j3);
        VLog.i("BBKCalculator/Evaluator ", " evaluateAndNotifyExchange: 1mExchangeResultString === " + lVarI0.f3954e);
        StringBuilder sb = new StringBuilder();
        sb.append(" evaluateAndNotifyExchange: 2");
        sb.append(lVarI0.f3954e != "ERR");
        VLog.i("BBKCalculator/Evaluator ", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" evaluateAndNotifyExchange: 3");
        sb2.append((j3 == 0 && this.f3889k) ? false : true);
        VLog.i("BBKCalculator/Evaluator ", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" evaluateAndNotifyExchange: 4");
        sb3.append(j3 == 0);
        VLog.i("BBKCalculator/Evaluator ", sb3.toString());
        VLog.i("BBKCalculator/Evaluator ", " evaluateAndNotifyExchange: 5 mExExChangedValue " + this.f3889k);
        String str = lVarI0.f3954e;
        if (str != null && str != "ERR" && (j3 != 0 || !this.f3889k)) {
            VLog.d("BBKCalculator/Evaluator ", " evaluateAndNotifyExchange: other transfer notifyImmediately ");
            D1(0L, this.f3897s, iVar, gVar, false);
        } else {
            if (lVarI0.f3952c != null) {
                return;
            }
            O0(j3, iVar, gVar, false);
        }
    }

    public void M1(long j3, j jVar, g gVar) {
        VLog.d("BBKCalculator/Evaluator ", "requireResultEx: ");
        if (gVar.getMaxChars() == 0) {
            VLog.d("BBKCalculator/Evaluator ", "requireResultEx: cmi.getMaxChars() == 0");
            return;
        }
        k kVarH0 = H0(j3);
        String str = kVarH0.f3941e;
        if (str != null && (j3 != 0 || !this.f3888j)) {
            if (str != "ERR") {
                C1(j3, kVarH0, jVar, gVar, true);
                return;
            } else {
                i0(kVarH0, true);
                N0(j3, jVar, gVar, true);
                return;
            }
        }
        if (j3 == -1) {
            jVar.f(j3);
            return;
        }
        AsyncTask asyncTask = kVarH0.f3939c;
        if ((asyncTask instanceof c) && ((c) asyncTask).f3913b) {
            return;
        }
        i0(kVarH0, true);
        N0(j3, jVar, gVar, true);
    }

    public void N1(long j3, i iVar, g gVar) {
        if (gVar.getMaxChars() == 0) {
            VLog.d("BBKCalculator/Evaluator ", "requireResultExchange: cmi.getMaxChars() == 0");
            return;
        }
        l lVarI0 = I0(j3);
        VLog.d("BBKCalculator/Evaluator ", "requireResultExchange: mExchangeResultString == " + lVarI0.f3954e);
        String str = lVarI0.f3954e;
        if (str != null && (j3 != 0 || !this.f3889k)) {
            if (str != "ERR") {
                D1(j3, lVarI0, iVar, gVar, true);
                return;
            } else {
                k0(lVarI0, true);
                O0(j3, iVar, gVar, true);
                return;
            }
        }
        if (j3 == -1) {
            iVar.d(j3);
            return;
        }
        AsyncTask asyncTask = lVarI0.f3952c;
        if ((asyncTask instanceof d) && ((d) asyncTask).f3923b) {
            return;
        }
        k0(lVarI0, true);
        O0(j3, iVar, gVar, true);
    }

    public void O1(long j3) {
        m mVar = this.f3891m.get(Long.valueOf(j3));
        String str = mVar.f3966e;
        if (str == null || str == "ERR") {
            VLog.e("BBKCalculator/Evaluator ", "saveData Preserving unevaluated expression");
        }
        R1(mVar);
    }

    public void P1(long j3) {
        k kVar = this.f3892n.get(Long.valueOf(j3));
        VLog.d("BBKCalculator/Evaluator ", "saveDataLoc mExResultString:" + kVar.f3941e);
        VLog.d("BBKCalculator/Evaluator ", "saveDataLoc mExVal:" + kVar.f3940d);
        String str = kVar.f3941e;
        if (str == null || str == "ERR") {
            VLog.e("BBKCalculator/Evaluator ", "saveDataLoc Preserving unevaluated expression");
        }
        S1(kVar);
    }

    public void Q1(long j3) {
        l lVar = this.f3893o.get(Long.valueOf(j3));
        VLog.d("BBKCalculator/Evaluator ", "saveDataOth mExchangeResultString" + lVar.f3954e);
        VLog.d("BBKCalculator/Evaluator ", "saveDataOth mExchangeVal" + lVar.f3953d);
        String str = lVar.f3954e;
        if (str == null || str == "ERR") {
            VLog.e("BBKCalculator/Evaluator ", "saveDataOth Preserving unevaluated expression");
        }
        T1(lVar);
    }

    public void R1(m mVar) {
        byte[] bArrI1 = mVar.f3962a.i1();
        VLog.d("BBKCalculator/Evaluator ", "saveToDB:  serializedExpr == " + bArrI1);
        com.vivo.calculator.c.e eVar = new com.vivo.calculator.c.e(bArrI1, mVar.f3963b, mVar.f3970i, 2, mVar.f3971j);
        boolean zD = this.f3894p.D(eVar, 2);
        VLog.d("BBKCalculator/Evaluator ", "saveToDB:  resultIndex == " + zD);
        if (zD) {
            return;
        }
        this.f3894p.y(eVar);
    }

    public void S1(k kVar) {
        byte[] bArrJ1 = kVar.f3937a.j1();
        VLog.d("BBKCalculator/Evaluator ", "saveToDBLoc: serializedExpr == " + bArrJ1);
        com.vivo.calculator.c.e eVar = new com.vivo.calculator.c.e(bArrJ1, kVar.f3938b, kVar.f3946j, 3, kVar.f3947k);
        boolean zD = this.f3894p.D(eVar, 3);
        VLog.d("BBKCalculator/Evaluator ", "saveToDBLoc: resultIndex == " + zD);
        if (zD) {
            return;
        }
        this.f3894p.y(eVar);
    }

    public void T(long j3) {
        m mVarF2 = f2(this.f3881c, j3);
        if (mVarF2 != null) {
            long jQ = Q(false, mVarF2, 2);
            this.f3881c = 0L;
            a2(jQ, true);
        }
    }

    public void T1(l lVar) {
        byte[] bArrK1 = lVar.f3950a.k1();
        VLog.d("BBKCalculator/Evaluator ", "saveToDBOth: serializedExpr == " + bArrK1);
        com.vivo.calculator.c.e eVar = new com.vivo.calculator.c.e(bArrK1, lVar.f3951b, lVar.f3958i, 4, lVar.f3959j);
        boolean zD = this.f3894p.D(eVar, 4);
        VLog.d("BBKCalculator/Evaluator ", "saveToDBOth: resultIndex == " + zD);
        if (zD) {
            return;
        }
        this.f3894p.y(eVar);
    }

    public void U1(f fVar) {
        this.f3882d = fVar;
    }

    public void V1(boolean z2) {
        this.f3887i = true;
        this.f3895q.f3963b = z2;
        g2.b.y(this.f3883e, !z2);
    }

    public boolean W(int i3, int i4, CalculatorFormula calculatorFormula) {
        VLog.d("BBKCalculator/Evaluator ", "append:  in ");
        if (i3 == R.id.fun_10pow) {
            I(i3, i4);
            return true;
        }
        if (i3 == R.id.countDown) {
            L(i3, i4);
            return true;
        }
        if (i3 == R.id.xgenhaoy) {
            V(i3, i4);
            return true;
        }
        if (i3 == R.id.op_sqr) {
            O(i3, i4);
            return true;
        }
        if (i3 == R.id.op_sqrs) {
            P(i3, i4);
            return true;
        }
        if (i3 == R.id.yx) {
            U(i3, i4);
            return true;
        }
        if (i3 == R.id.const_x) {
            J(i3, i4);
            return true;
        }
        if (i3 == R.id.positive_and_negative) {
            N(i3, i4, calculatorFormula);
            return true;
        }
        this.f3887i = this.f3887i || !z1.e.l(i3);
        if (this.f3895q.f3962a.N0(this.f3883e, i3, i4)) {
            this.f3887i = true;
        }
        VLog.d("BBKCalculator/Evaluator ", "append: calculator default ");
        boolean zE = (calculatorFormula != null && calculatorFormula.getSelectionStart() == calculatorFormula.getSelectionEnd() && calculatorFormula.getSelectionStart() == calculatorFormula.getText().length()) ? this.f3895q.f3962a.e(i3) : this.f3895q.f3962a.f(this.f3883e, i3, i4);
        VLog.d("BBKCalculator/Evaluator ", "append: calculator addResult ==  " + zE);
        if (i3 == R.id.op_pow) {
            com.vivo.calculator.a aVar = this.f3895q.f3962a;
            if (!aVar.E0(this.f3883e, i4)) {
                i4++;
            }
            aVar.f(this.f3883e, R.id.lparen, i4);
        }
        if (!zE) {
            return false;
        }
        if (!this.f3890l) {
            this.f3890l = z1.e.q(i3);
        }
        return true;
    }

    public boolean X(int i3, int i4, boolean z2) {
        if (!z2) {
            i4 = 0;
        }
        this.f3888j = this.f3888j || !z1.e.l(i3);
        if (this.f3896r.f3937a.O0(this.f3883e, i3, i4, true)) {
            this.f3888j = true;
        }
        boolean zG = this.f3896r.f3937a.g(this.f3883e, i3, i4, true);
        VLog.d("BBKCalculator/Evaluator ", "append: addResult == local " + zG);
        if (!zG) {
            return false;
        }
        if (!this.f3890l) {
            this.f3890l = z1.e.q(i3);
        }
        return true;
    }

    public boolean Y(int i3, int i4, boolean z2) {
        if (!z2) {
            i4 = 0;
        }
        this.f3889k = this.f3889k || !z1.e.l(i3);
        if (this.f3897s.f3950a.O0(this.f3883e, i3, i4, false)) {
            this.f3889k = true;
        }
        boolean zH = this.f3897s.f3950a.h(this.f3883e, i3, i4, false);
        VLog.d("BBKCalculator/Evaluator ", "append: addResult ==  " + zH);
        if (!zH) {
            return false;
        }
        if (!this.f3890l) {
            this.f3890l = z1.e.q(i3);
        }
        return true;
    }

    public String Y0(Context context, String str, int i3, int i4) {
        VLog.d("BBKCalculator/Evaluator ", "getExShortStringResult:   cache == " + str);
        String strT1 = t1(context, str, i3, i4, true);
        VLog.d("BBKCalculator/Evaluator ", "getExShortStringResult:  result = " + strT1);
        int iIndexOf = strT1.indexOf("E");
        if (iIndexOf > 0 && !TextUtils.isEmpty(strT1.substring(iIndexOf - 1, iIndexOf)) && g2.h.b(strT1.substring(iIndexOf, iIndexOf + 1))) {
            VLog.d("BBKCalculator/Evaluator ", "getExShortStringResult: result == " + strT1);
            return strT1;
        }
        if (iIndexOf <= 0) {
            int iIndexOf2 = strT1.indexOf(".");
            int length = strT1.length();
            if (iIndexOf2 > 0 && length - iIndexOf2 >= this.f3883e.getResources().getInteger(R.integer.ex_result_decimal_places_number)) {
                try {
                    strT1 = g2.b.x(Double.parseDouble(strT1.replaceAll(",", BuildConfig.FLAVOR)), this.f3883e.getResources().getInteger(R.integer.ex_result_decimal_places_number) - 2);
                } catch (Exception e3) {
                    VLog.e("BBKCalculator/Evaluator ", "getExShortStringResult,Exception 2 " + e3);
                    strT1 = strT1.substring(0, (iIndexOf2 + this.f3883e.getResources().getInteger(R.integer.ex_result_decimal_places_number)) - 1);
                }
            }
            if (strT1.indexOf(".") > 0 && strT1.endsWith("0")) {
                for (int length2 = strT1.length(); length2 >= 0 && strT1.endsWith("0"); length2--) {
                    strT1 = strT1.substring(0, length2);
                }
            }
            return strT1.endsWith(".") ? strT1.substring(0, strT1.length() - 1) : strT1;
        }
        String strSubstring = strT1.substring(0, iIndexOf);
        String strSubstring2 = strT1.substring(iIndexOf, strT1.length());
        try {
            int integer = (Integer.parseInt(strSubstring2) > 0 ? this.f3883e.getResources().getInteger(R.integer.result_decimal_places_number) : this.f3883e.getResources().getInteger(R.integer.ex_result_decimal_places_number)) - 2;
            int iIndexOf3 = strSubstring.indexOf(".");
            int length3 = strSubstring.length();
            if (iIndexOf3 > 0 && length3 - iIndexOf3 >= integer + 2) {
                try {
                    strSubstring = g2.b.x(Double.parseDouble(strSubstring.replaceAll(",", BuildConfig.FLAVOR)), integer);
                } catch (Exception e4) {
                    VLog.e("BBKCalculator/Evaluator ", "getExShortStringResult,Exception 1 " + e4);
                    strSubstring = strSubstring.substring(0, (iIndexOf3 + integer) - 1);
                }
            }
            if (strSubstring.indexOf(".") > 0 && strSubstring.endsWith("0")) {
                for (int length4 = strSubstring.length(); length4 >= 0 && strSubstring.endsWith("0"); length4--) {
                    strSubstring = strSubstring.substring(0, length4);
                }
            }
            if (strSubstring.endsWith(".")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            return strSubstring + strSubstring2;
        } catch (Exception e5) {
            VLog.e("BBKCalculator/Evaluator ", "getExShortStringResult,Integer.parseInt : " + e5.getMessage() + ", end : " + strSubstring2);
            return strT1;
        }
    }

    public String Z(int i3, long j3) {
        m mVar = this.f3891m.get(Long.valueOf(j3));
        this.f3887i = true;
        m mVar2 = this.f3895q;
        mVar2.f3970i = mVar.f3970i | mVar2.f3970i;
        com.vivo.calculator.a aVarW0 = W0(j3);
        if (aVarW0 != null) {
            return aVarW0.m1(this.f3883e).toString();
        }
        return null;
    }

    public String Z0(long j3, int[] iArr, int i3, int i4, boolean[] zArr, boolean[] zArr2, j jVar) {
        int iMin;
        k kVar = this.f3892n.get(Long.valueOf(j3));
        VLog.d("BBKCalculator/Evaluator ", "getExString: index " + j3);
        VLog.d("BBKCalculator/Evaluator ", "getExString: ei " + kVar);
        String str = kVar.f3941e;
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        int i5 = iArr[0];
        int length = str.length();
        boolean z2 = kVar.f3941e.charAt(0) == '-';
        zArr2[0] = z2;
        int i6 = length - kVar.f3942f;
        if (z2) {
            i6--;
        }
        int iMin2 = Math.min(Math.max(i5, Math.min(5 - i6, -1)), i3);
        iArr[0] = iMin2;
        VLog.d("BBKCalculator/Evaluator ", "getExString: currentPrecOffset == " + iMin2);
        int i7 = kVar.f3942f;
        int i8 = i7 - iMin2;
        if (i8 < 0) {
            iMin = Math.min(iMin2 - i7, i4);
            i8 = 0;
        } else {
            iMin = 0;
        }
        int i9 = length - i8;
        if (i9 < 1) {
            return " ";
        }
        zArr[0] = Math.max((i9 + iMin) - i4, 0) > X0(j3);
        String strSubstring = kVar.f3941e.substring(0, i9);
        if (iMin > 0) {
            strSubstring = strSubstring + z1.g.e(' ', iMin);
        }
        VLog.d("BBKCalculator/Evaluator ", " getExString: result " + strSubstring);
        return strSubstring;
    }

    @Override // com.vivo.calculator.a.g
    public boolean a(long j3) {
        return H0(j3).f3938b;
    }

    void a2(long j3, boolean z2) {
        L1(j3, new p(j3, z2), this.f3879a);
    }

    @Override // com.vivo.calculator.a.g
    public boolean b(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "getDegreeMode: ");
        return J0(j3).f3963b;
    }

    public String b1(long j3, int[] iArr, int i3, int i4, boolean[] zArr, boolean[] zArr2, i iVar) {
        int iMin;
        VLog.d("BBKCalculator/Evaluator ", "getExchangeString: index  === " + j3);
        l lVar = this.f3893o.get(Long.valueOf(j3));
        VLog.d("BBKCalculator/Evaluator ", "getExchangeString:  ei === " + lVar);
        int i5 = iArr[0];
        VLog.d("BBKCalculator/Evaluator ", "getExchangeString: mExchangeResultString " + lVar.f3954e);
        String str = lVar.f3954e;
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        int length = str.length();
        boolean z2 = lVar.f3954e.charAt(0) == '-';
        zArr2[0] = z2;
        int i6 = length - lVar.f3955f;
        if (z2) {
            i6--;
        }
        int iMin2 = Math.min(Math.max(i5, Math.min(5 - i6, -1)), i3);
        iArr[0] = iMin2;
        VLog.d("BBKCalculator/Evaluator ", "getString: currentPrecOffset == " + iMin2);
        int i7 = lVar.f3955f;
        int i8 = i7 - iMin2;
        if (i8 < 0) {
            iMin = Math.min(iMin2 - i7, i4);
            i8 = 0;
        } else {
            iMin = 0;
        }
        int i9 = length - i8;
        if (i9 < 1) {
            return " ";
        }
        zArr[0] = Math.max((i9 + iMin) - i4, 0) > a1(j3);
        String strSubstring = lVar.f3954e.substring(0, i9);
        if (iMin > 0) {
            strSubstring = strSubstring + z1.g.e(' ', iMin);
        }
        VLog.d("BBKCalculator/Evaluator ", " getString:  result " + strSubstring);
        return strSubstring;
    }

    void b2(long j3) {
        L1(j3, new q(j3), this.f3879a);
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.d c(long j3, com.vivo.calculator.d dVar) {
        m mVar = this.f3891m.get(Long.valueOf(j3));
        return mVar.f3965d.compareAndSet(null, dVar) ? dVar : mVar.f3965d.get();
    }

    void c2(long j3) {
        M1(j3, new q(j3), this.f3879a);
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.d d(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "getExchangeResult: ");
        return I0(j3).f3953d.get();
    }

    void d2(long j3) {
        N1(j3, (i) new q(j3), this.f3879a);
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.a e(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "getExpr:  ensureExprIsCached == " + J0(j3).f3962a);
        return J0(j3).f3962a;
    }

    public boolean e0(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e3) {
            if (d0(str, length)) {
                return true;
            }
            VLog.e("Evaluator", "Error turning string to float. Ignoring paste.", e3);
            return false;
        }
    }

    public void e2(long j3) {
        m mVarD0 = D0(this.f3881c, j3);
        if (mVarD0 != null) {
            long jQ = Q(false, mVarD0, 2);
            this.f3881c = 0L;
            a2(jQ, true);
        }
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.d f(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "getExResult: ");
        return H0(j3).f3940d.get();
    }

    public boolean f0(long j3, boolean z2) {
        m mVar = this.f3891m.get(Long.valueOf(j3));
        if (mVar == null) {
            return false;
        }
        return g0(mVar, z2);
    }

    public int f1(int i3) {
        return this.f3895q.f3962a.m0(this.f3883e, i3);
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.d g(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "getResult: ");
        return J0(j3).f3965d.get();
    }

    public int g1(int i3) {
        return this.f3896r.f3937a.n0(this.f3883e, i3, true);
    }

    public void g2() {
        this.f3887i = true;
    }

    @Override // com.vivo.calculator.a.g
    public boolean h(long j3) {
        return I0(j3).f3951b;
    }

    public boolean h0(long j3, boolean z2) {
        k kVar = this.f3892n.get(Long.valueOf(j3));
        if (kVar == null) {
            return false;
        }
        return i0(kVar, z2);
    }

    public int h1(int i3) {
        return this.f3897s.f3950a.n0(this.f3883e, i3, false);
    }

    public void h2() {
        this.f3888j = true;
        VLog.d("BBKCalculator/Evaluator ", "touchEx:  mExChangedValue " + this.f3888j);
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.a i(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "getExprEx:  ");
        return H0(j3).f3937a;
    }

    public void i2() {
        this.f3889k = true;
        VLog.d("BBKCalculator/Evaluator ", "touchExchange:  mExExChangedValue " + this.f3889k);
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.d j(long j3, com.vivo.calculator.d dVar) {
        l lVar = this.f3893o.get(Long.valueOf(j3));
        return lVar.f3953d.compareAndSet(null, dVar) ? dVar : lVar.f3953d.get();
    }

    public boolean j0(long j3, boolean z2) {
        l lVar = this.f3893o.get(Long.valueOf(j3));
        if (lVar == null) {
            return false;
        }
        return k0(lVar, z2);
    }

    public long j1() {
        return this.f3894p.s();
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.a k(long j3) {
        VLog.d("BBKCalculator/Evaluator ", "getExprExchagne:  ");
        return I0(j3).f3950a;
    }

    public void k2(boolean z2, m mVar, int i3) {
        VLog.d("BBKCalculator/Evaluator ", "updateToDB: ");
        this.f3894p.C(z2, new com.vivo.calculator.c.e(mVar.f3962a.i1(), mVar.f3963b, mVar.f3970i, i3, 0L));
    }

    @Override // com.vivo.calculator.a.g
    public com.vivo.calculator.d l(long j3, com.vivo.calculator.d dVar) {
        k kVar = this.f3892n.get(Long.valueOf(j3));
        return kVar.f3940d.compareAndSet(null, dVar) ? dVar : kVar.f3940d.get();
    }

    public void l0() {
        this.f3895q.f3962a.C();
        ResourceBundle.clearCache();
        this.f3895q.f3970i = false;
    }

    public long l1() {
        return this.f3881c;
    }

    public void l2() {
        this.f3894p.F();
    }

    public void m() {
        this.f3887i = true;
        try {
            m mVarQ1 = q1();
            if (mVarQ1 != null) {
                m mVar = this.f3895q;
                mVar.f3963b = mVarQ1.f3963b;
                mVar.f3970i = mVarQ1.f3970i;
                mVar.f3962a = mVarQ1.f3962a;
            }
            this.f3890l = y1();
        } catch (Exception e3) {
            VLog.v("BBKCalculator/Evaluator ", "Exception while restoring:\n" + e3);
        }
    }

    public void n() {
        VLog.d("BBKCalculator/Evaluator ", "InstanceStateLoc: ");
        this.f3888j = true;
        try {
            k kVarR1 = r1();
            if (kVarR1 != null) {
                k kVar = this.f3896r;
                kVar.f3938b = kVarR1.f3938b;
                kVar.f3946j = kVarR1.f3946j;
                kVar.f3937a = kVarR1.f3937a;
            }
            VLog.d("BBKCalculator/Evaluator ", "InstanceStateLoc: mExVal ==  " + this.f3896r.f3940d);
            this.f3890l = y1();
        } catch (Exception e3) {
            VLog.v("BBKCalculator/Evaluator ", "Exception while restoring:\n" + e3);
        }
    }

    public void o() {
        this.f3889k = true;
        try {
            l lVarS1 = s1();
            if (lVarS1 != null) {
                l lVar = this.f3897s;
                lVar.f3951b = lVarS1.f3951b;
                lVar.f3958i = lVarS1.f3958i;
                lVar.f3950a = lVarS1.f3950a;
            }
            this.f3890l = y1();
        } catch (Exception e3) {
            VLog.v("BBKCalculator/Evaluator ", "Exception while restoring:\n" + e3);
        }
    }

    public void o0() {
        m mVar = this.f3895q;
        if (mVar != null) {
            com.vivo.calculator.a aVar = mVar.f3962a;
            if (aVar != null) {
                aVar.C();
            }
            this.f3890l = false;
            p0();
            this.f3895q.f3970i = false;
        }
    }

    public void q0() {
        VLog.d("BBKCalculator/Evaluator ", "clearMainEx: ");
        k kVar = this.f3896r;
        if (kVar != null) {
            com.vivo.calculator.a aVar = kVar.f3937a;
            if (aVar != null) {
                aVar.D();
            }
            m0();
            this.f3896r.f3946j = false;
        }
    }

    public m q1() {
        com.vivo.calculator.c.e eVarW = this.f3894p.w("2");
        m mVar = null;
        if (eVarW == null) {
            return null;
        }
        try {
            m mVar2 = new m(new com.vivo.calculator.a(new DataInputStream(new ByteArrayInputStream(eVarW.f4004a))), eVarW.a());
            try {
                mVar2.f3971j = eVarW.f4006c;
                mVar2.f3972k = eVarW.f4007d;
                mVar2.f3970i = eVarW.d();
                return mVar2;
            } catch (Exception e3) {
                e = e3;
                mVar = mVar2;
                VLog.e("BBKCalculator/Evaluator ", "getSaveData e == " + e);
                return mVar;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void r0() {
        VLog.d("BBKCalculator/Evaluator ", "clearMainExchagne: mMainExprExchange " + this.f3897s);
        l lVar = this.f3897s;
        if (lVar != null) {
            com.vivo.calculator.a aVar = lVar.f3950a;
            if (aVar != null) {
                aVar.E();
            }
            n0();
            this.f3897s.f3958i = false;
        }
    }

    public k r1() {
        VLog.d("BBKCalculator/Evaluator ", "getSaveDataLoc e == ");
        com.vivo.calculator.c.e eVarW = this.f3894p.w("3");
        VLog.e("BBKCalculator/Evaluator ", "getSaveDataLoc row == " + eVarW);
        k kVar = null;
        if (eVarW == null) {
            return null;
        }
        try {
            k kVar2 = new k(new com.vivo.calculator.a((DataInput) new DataInputStream(new ByteArrayInputStream(eVarW.f4004a)), true), eVarW.a());
            try {
                kVar2.f3947k = eVarW.f4006c;
                kVar2.f3948l = eVarW.f4007d;
                kVar2.f3946j = eVarW.d();
                return kVar2;
            } catch (Exception e3) {
                e = e3;
                kVar = kVar2;
                VLog.e("BBKCalculator/Evaluator ", "getSaveDataLoc e == " + e);
                return kVar;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void s0(long j3) {
        m mVarD0 = D0(this.f3881c, j3);
        if (mVarD0 != null) {
            k2(false, mVarD0, 2);
            this.f3881c = 0L;
            Z1(0L);
        }
    }

    public l s1() {
        VLog.e("BBKCalculator/Evaluator ", "getSaveDataOth  == ");
        com.vivo.calculator.c.e eVarW = this.f3894p.w("4");
        VLog.e("BBKCalculator/Evaluator ", "getSaveDataOth row == " + eVarW);
        l lVar = null;
        if (eVarW == null) {
            return null;
        }
        try {
            l lVar2 = new l(new com.vivo.calculator.a((DataInput) new DataInputStream(new ByteArrayInputStream(eVarW.f4004a)), false), eVarW.a());
            try {
                lVar2.f3959j = eVarW.f4006c;
                lVar2.f3960k = eVarW.f4007d;
                lVar2.f3958i = eVarW.d();
                return lVar2;
            } catch (Exception e3) {
                e = e3;
                lVar = lVar2;
                VLog.e("BBKCalculator/Evaluator ", "getSaveDataOth e == " + e);
                return lVar;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void t0(long j3) {
        m mVar;
        ConcurrentHashMap<Long, m> concurrentHashMap = this.f3891m;
        if (concurrentHashMap == null || concurrentHashMap.get(Long.valueOf(j3)) == null || (mVar = this.f3895q) == null || mVar.f3962a == null) {
            VLog.i("BBKCalculator/Evaluator ", "collapse , object null , return.");
            return;
        }
        boolean z2 = this.f3891m.get(Long.valueOf(j3)).f3970i;
        com.vivo.calculator.a aVarT0 = T0(j3);
        o0();
        if (aVarT0 != null) {
            this.f3895q.f3962a.t(aVarT0);
            this.f3895q.f3970i = z2;
        }
        this.f3887i = true;
        this.f3890l = false;
    }

    public void u0(long j3) {
        k kVar;
        ConcurrentHashMap<Long, k> concurrentHashMap = this.f3892n;
        if (concurrentHashMap == null || concurrentHashMap.get(Long.valueOf(j3)) == null || (kVar = this.f3896r) == null || kVar.f3937a == null) {
            VLog.i("BBKCalculator/Evaluator ", "collapseEx , object null , return.");
            return;
        }
        boolean z2 = this.f3892n.get(Long.valueOf(j3)).f3946j;
        com.vivo.calculator.a aVarU0 = U0(j3);
        q0();
        if (aVarU0 != null) {
            this.f3896r.f3937a.u(aVarU0);
            this.f3896r.f3946j = z2;
        }
        this.f3888j = true;
        VLog.d("BBKCalculator/Evaluator ", "collapseEx:  mExChangedValue " + this.f3888j);
    }

    public String u1(Context context, String str, int i3, int i4) {
        String strT1 = t1(context, str, i3, i4, false);
        VLog.d("BBKCalculator/Evaluator ", "getShortStringResult:   result = " + strT1);
        int iIndexOf = strT1.indexOf("E");
        if (iIndexOf <= 0) {
            if (strT1.indexOf(".") > 0 && strT1.endsWith("0")) {
                for (int length = strT1.length(); length >= 0 && strT1.endsWith("0"); length--) {
                    strT1 = strT1.substring(0, length);
                }
            }
            return strT1.endsWith(".") ? strT1.substring(0, strT1.length() - 1) : strT1;
        }
        String strSubstring = strT1.substring(0, iIndexOf);
        String strSubstring2 = strT1.substring(iIndexOf, strT1.length());
        if (strSubstring.indexOf(".") > 0 && strSubstring.endsWith("0")) {
            for (int length2 = strSubstring.length(); length2 >= 0 && strSubstring.endsWith("0"); length2--) {
                strSubstring = strSubstring.substring(0, length2);
            }
        }
        if (strSubstring.endsWith(".")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return strSubstring + strSubstring2;
    }

    public void v0(long j3) {
        l lVar;
        ConcurrentHashMap<Long, l> concurrentHashMap = this.f3893o;
        if (concurrentHashMap == null || concurrentHashMap.get(Long.valueOf(j3)) == null || (lVar = this.f3897s) == null || lVar.f3950a == null) {
            VLog.i("BBKCalculator/Evaluator ", "collapseExchange , object null , return.");
            return;
        }
        boolean z2 = this.f3893o.get(Long.valueOf(j3)).f3958i;
        com.vivo.calculator.a aVarV0 = V0(j3);
        r0();
        if (aVarV0 != null) {
            this.f3897s.f3950a.v(aVarV0);
            this.f3897s.f3958i = z2;
        }
        this.f3889k = true;
        VLog.d("BBKCalculator/Evaluator ", "collapseExchange: mExExChangedValue " + this.f3889k);
    }

    public String v1(long j3, int[] iArr, int i3, int i4, boolean[] zArr, boolean[] zArr2, j jVar) {
        int iMin;
        m mVar = this.f3891m.get(Long.valueOf(j3));
        VLog.d("BBKCalculator/Evaluator ", "getString:  index ==" + j3);
        int i5 = iArr[0];
        VLog.d("BBKCalculator/Evaluator ", "getString:  ei ==" + mVar);
        String str = mVar.f3966e;
        if (str == null) {
            G0(j3, i5 + 20, jVar);
            return " ";
        }
        G0(j3, i5 + 20 + (str.length() / 5), jVar);
        int length = mVar.f3966e.length();
        boolean z2 = mVar.f3966e.charAt(0) == '-';
        zArr2[0] = z2;
        int i6 = length - mVar.f3967f;
        if (z2) {
            i6--;
        }
        int iMin2 = Math.min(Math.max(i5, Math.min(5 - i6, -1)), i3);
        iArr[0] = iMin2;
        VLog.d("BBKCalculator/Evaluator ", "getString: currentPrecOffset == " + iMin2);
        int i7 = mVar.f3967f;
        int i8 = i7 - iMin2;
        if (i8 < 0) {
            iMin = Math.min(iMin2 - i7, i4);
            i8 = 0;
        } else {
            iMin = 0;
        }
        int i9 = length - i8;
        if (i9 < 1) {
            return " ";
        }
        zArr[0] = Math.max((i9 + iMin) - i4, 0) > m1(j3);
        String strSubstring = mVar.f3966e.substring(0, i9);
        if (iMin > 0) {
            strSubstring = strSubstring + z1.g.e(' ', iMin);
        }
        VLog.d("BBKCalculator/Evaluator ", " getString: result " + strSubstring);
        return strSubstring;
    }

    public boolean y1() {
        return this.f3890l;
    }

    public void z0(long j3) {
        if (z1(j3)) {
            j3 = F1(j3, false);
        }
        Z1(j3);
    }

    /* JADX INFO: compiled from: Evaluator.java */
    private static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.vivo.calculator.d f3975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f3978e;

        n(com.vivo.calculator.d dVar, String str, int i3, int i4) {
            this.f3974a = -1;
            this.f3975b = dVar;
            this.f3976c = str;
            this.f3977d = i3;
            this.f3978e = i4;
        }

        boolean a() {
            return this.f3974a != -1;
        }

        n(int i3) {
            switch (i3) {
                case R.string.cancelled /* 2131689509 */:
                    VLog.d("BBKCalculator/Evaluator ", "cancelled.");
                    break;
                case R.string.error_aborted /* 2131689625 */:
                    VLog.d("BBKCalculator/Evaluator ", "error_aborted.");
                    break;
                case R.string.error_nan /* 2131689627 */:
                    VLog.d("BBKCalculator/Evaluator ", "error_nan.");
                    break;
                case R.string.error_syntax /* 2131689629 */:
                    VLog.d("BBKCalculator/Evaluator ", "error_syntax.");
                    break;
                case R.string.error_zero_divide /* 2131689630 */:
                    VLog.d("BBKCalculator/Evaluator ", "error_zero_divide.");
                    break;
                case R.string.timeout /* 2131689832 */:
                    VLog.d("BBKCalculator/Evaluator ", "timeout.");
                    break;
                default:
                    VLog.d("BBKCalculator/Evaluator ", "errorId:" + i3);
                    break;
            }
            this.f3974a = i3;
            this.f3975b = com.vivo.calculator.d.f4024s;
            this.f3976c = "BAD";
            this.f3977d = 0;
            this.f3978e = 0;
        }
    }

    b(Context context, Boolean bool) {
        this.f3883e = context;
        this.f3894p = new com.vivo.calculator.c(context);
        X1(new k(new com.vivo.calculator.a(true), false));
        this.f3885g = "none";
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f3898t = defaultSharedPreferences;
        this.f3896r.f3938b = defaultSharedPreferences.getBoolean("degree_exmode", false);
        long j3 = this.f3898t.getLong("saved_exindex", 0L);
        this.f3898t.getLong("memory_exindex", 0L);
        if (j3 != 0 && j3 != -1) {
            c2(j3);
        }
        this.f3885g = this.f3898t.getString("saved_exname", "none");
    }

    b(Context context, Boolean bool, boolean z2) {
        this.f3883e = context;
        this.f3894p = new com.vivo.calculator.c(context);
        Y1(new l(new com.vivo.calculator.a(false, false), false));
        this.f3886h = "none";
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f3898t = defaultSharedPreferences;
        this.f3897s.f3951b = defaultSharedPreferences.getBoolean("degree_exmode", false);
        long j3 = this.f3898t.getLong("saved_exchagneindex", 0L);
        this.f3898t.getLong("memory_exchagneindex", 0L);
        if (j3 != 0 && j3 != -1) {
            d2(j3);
        }
        this.f3885g = this.f3898t.getString("saved_exchagnename", "none");
    }
}
