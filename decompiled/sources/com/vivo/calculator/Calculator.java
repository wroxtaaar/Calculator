package com.vivo.calculator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.calculator.entry.InsertEntry;
import com.vivo.calculator.keybord.ColorButton;
import com.vivo.calculator.keybord.ColorSelectButton;
import com.vivo.seckeysdk.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class Calculator extends Activity implements com.vivo.calculator.b.j, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener, a2.a {
    public static boolean E1 = false;
    private static boolean F1 = true;
    public static boolean G1 = false;
    public static boolean H1 = false;
    public static boolean I1 = false;
    public static boolean J1 = false;
    public static float K1;
    public static float L1;
    private static float M1;
    private static float N1;
    private static int O1;
    private static int P1;
    private ColorButton A;
    private TextView A0;
    private String A1;
    private ColorButton B;
    private ColorButton B0;
    private String B1;
    private ColorButton C;
    private ColorButton C0;
    private ColorSelectButton C1;
    private ColorButton D;
    private View[] D0;
    private ColorButton E;
    private View[] E0;
    private ColorButton F;
    private ImageButton F0;
    private ColorButton G;
    private HistoryLayout G0;
    private ColorButton H;
    private HistoryLayout H0;
    private ColorButton I;
    private LinearLayout I0;
    private ColorButton J;
    private ValueAnimator J0;
    private ColorButton K;
    private ValueAnimator K0;
    private ColorButton L;
    private ValueAnimator L0;
    private ColorButton M;
    private ValueAnimator M0;
    private ColorButton N;
    private ClipboardManager N0;
    private ColorButton O;
    private ColorButton P;
    private androidx.appcompat.app.a P0;
    private ColorButton Q;
    private androidx.appcompat.app.a Q0;
    private ColorButton R;
    private ImageButton R0;
    private ColorButton S;
    private ImageButton S0;
    private ColorButton T;
    private DisplayManager T0;
    private ColorButton U;
    private boolean U0;
    private ColorButton V;
    private ColorButton W;
    private ColorButton X;
    private ColorButton Y;
    private AnimatorSet Y0;
    private ColorButton Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private ColorButton f3510a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f3512b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private ColorButton f3513b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f3515c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ColorButton f3516c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences.Editor f3518d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private ColorButton f3519d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private Handler f3520d1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f3521e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private ColorButton f3522e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private d0 f3523e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f3524f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private ColorButton f3525f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3527g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ColorButton f3528g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private ColorButton f3529g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private KeyguardManager f3530h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ColorButton f3531h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private ColorButton f3532h1;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ColorButton f3534i0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private ColorButton f3535i1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f3536j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ColorButton f3537j0;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public boolean f3538j1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f3539k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private ColorButton f3540k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private boolean f3541k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private LinearLayout f3542l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private ColorButton f3543l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LinearLayout f3545m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private ColorButton f3546m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LinearLayout f3548n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private ColorButton f3549n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Button f3551o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private ColorButton f3552o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorButton f3554p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private ColorButton f3555p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ColorButton f3557q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private ColorButton f3558q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ColorButton f3560r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private CalculatorFormula f3561r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ColorButton f3563s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private CalculatorResult f3564s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorButton f3566t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private com.vivo.calculator.b f3567t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ColorButton f3569u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private z f3570u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ColorButton f3572v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ColorButton f3575w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ColorButton f3578x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private ImageButton f3579x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ColorButton f3581y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private ImageButton f3582y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorButton f3584z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private ColorSelectButton f3585z0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ForegroundColorSpan f3533i = new ForegroundColorSpan(-65536);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f3573v0 = false;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private String f3576w0 = null;
    private boolean O0 = false;
    private a0 V0 = null;
    private boolean W0 = true;
    private boolean X0 = false;
    float Z0 = 0.0f;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private BroadcastReceiver f3511a1 = new k();

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private boolean f3514b1 = false;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private final int f3517c1 = 1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private View f3526f1 = null;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private boolean f3544l1 = false;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private final com.vivo.calculator.b.f f3547m1 = new i();

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private Runnable f3550n1 = new j();

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private DisplayManager.DisplayListener f3553o1 = new l();

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private f2.a f3556p1 = null;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private boolean f3559q1 = false;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private boolean f3562r1 = false;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private float f3565s1 = 0.0f;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private float f3568t1 = 0.0f;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private float f3571u1 = 0.0f;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private float f3574v1 = 0.0f;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private int f3577w1 = 0;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private int f3580x1 = 0;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private final c0 f3583y1 = new m();

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public View.OnClickListener f3586z1 = new n();
    private boolean D1 = false;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Calculator.this.getResources().getConfiguration().orientation == 1) {
                if (g2.b.o(Calculator.this.f3512b)) {
                    Calculator.this.B1();
                } else {
                    Calculator.this.C1();
                    h2.a.a().f(6);
                }
            } else if (g2.b.o(Calculator.this.f3512b)) {
                Calculator.this.B1();
            } else {
                Calculator.this.H1();
                h2.a.a().f(5);
            }
            BBKCalculatorApplication.r(true);
        }
    }

    private class a0 extends BroadcastReceiver {
        private a0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VLog.d("BBKCalculator/Calculator", "onReceive: ");
            g2.b.f4762c = g2.b.e();
            g2.b.f4763d = g2.b.z();
        }

        /* synthetic */ a0(Calculator calculator, k kVar) {
            this();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VLog.d("BBKCalculator/Calculator", "requestCurrency: NET_PERMISSION == " + Calculator.this.f3515c.getBoolean("NET_PERMISSION", true));
            if (!Calculator.this.f3515c.getBoolean("NET_PERMISSION", false)) {
                Calculator.this.L1();
                return;
            }
            Calculator.this.startActivity(new Intent(Calculator.this.f3512b, (Class<?>) ExchangeActivity.class));
            if (!g2.b.o(Calculator.this.f3512b)) {
                if (Calculator.this.f3585z0 == null) {
                    h2.a.a().f(17);
                    return;
                } else {
                    h2.a.a().f(16);
                    return;
                }
            }
            if (Calculator.this.f3524f == null || Calculator.this.f3524f.getVisibility() != 0) {
                h2.a.a().f(17);
            } else {
                h2.a.a().f(16);
            }
        }
    }

    private static final class b0 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<Calculator> f3590a;

        /* synthetic */ b0(Calculator calculator, k kVar) {
            this(calculator);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Calculator calculator = this.f3590a.get();
            if (calculator == null || calculator.isFinishing()) {
                return;
            }
            calculator.y0(message);
        }

        private b0(Calculator calculator) {
            this.f3590a = null;
            this.f3590a = new WeakReference<>(calculator);
        }
    }

    class c implements View.OnClickListener {

        class a extends KeyguardManager.KeyguardDismissCallback {
            a() {
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissCancelled() {
                VLog.d("BBKCalculator/Calculator", "onDismissCancelled: ");
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissError() {
                VLog.d("BBKCalculator/Calculator", "onDismissError: ");
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissSucceeded() {
                VLog.d("BBKCalculator/Calculator", "onDismissSucceeded: ");
                Calculator.this.N1();
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!Calculator.this.f3530h.isKeyguardLocked()) {
                Calculator.this.N1();
            } else {
                VLog.d("BBKCalculator/Calculator", "requestDismissKeyguard");
                Calculator.this.f3530h.requestDismissKeyguard(Calculator.this, new a());
            }
        }
    }

    public interface c0 {
    }

    class d implements View.OnClickListener {

        class a extends KeyguardManager.KeyguardDismissCallback {
            a() {
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissCancelled() {
                VLog.d("BBKCalculator/Calculator", "onDismissCancelled: ");
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissError() {
                VLog.d("BBKCalculator/Calculator", "onDismissError: ");
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissSucceeded() {
                VLog.d("BBKCalculator/Calculator", "onDismissSucceeded: ");
                Calculator.this.f1();
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h2.b.b("A790|10009", null);
            if (!Calculator.this.f3530h.isKeyguardLocked()) {
                Calculator.this.f1();
            } else {
                VLog.d("BBKCalculator/Calculator", "requestDismissKeyguard");
                Calculator.this.f3530h.requestDismissKeyguard(Calculator.this, new a());
            }
        }
    }

    final class d0 extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<Calculator> f3595a;

        /* synthetic */ d0(Calculator calculator, Calculator calculator2, k kVar) {
            this(calculator2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            Calculator calculator = this.f3595a.get();
            if (calculator == null) {
                return;
            }
            if (Settings.System.getInt(calculator.f3512b.getContentResolver(), "accelerometer_rotation", 0) == 0) {
                calculator.setRequestedOrientation(-1);
            } else {
                calculator.setRequestedOrientation(4);
            }
            super.onChange(z2);
        }

        private d0(Calculator calculator) {
            super(Calculator.this.f3520d1);
            this.f3595a = new WeakReference<>(calculator);
        }
    }

    class e extends ActionMode.Callback2 {
        e() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Calculator.this.T0(actionMode, menuItem, false);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Calculator.this.X0(actionMode, menu, false);
            return true;
        }
    }

    class f extends ActionMode.Callback2 {
        f() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Calculator.this.T0(actionMode, menuItem, false);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            Calculator.this.f3561r0.setSelectAllOnFocus(true);
            Calculator.this.f3561r0.selectAll();
            Calculator.this.O0 = true;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Calculator.this.f3561r0.setSelectAllOnFocus(false);
            Calculator.this.O0 = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Calculator.this.X0(actionMode, menu, false);
            return true;
        }
    }

    class g extends ActionMode.Callback2 {
        g() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Calculator.this.T0(actionMode, menuItem, true);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Calculator.this.X0(actionMode, menu, true);
            return true;
        }
    }

    class h extends ActionMode.Callback2 {
        h() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Calculator.this.T0(actionMode, menuItem, true);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            Calculator.this.f3564s0.setSelectAllOnFocus(true);
            Calculator.this.f3564s0.selectAll();
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Calculator.this.f3564s0.setSelectAllOnFocus(false);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Calculator.this.X0(actionMode, menu, true);
            return true;
        }
    }

    class i implements com.vivo.calculator.b.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<CalculatorFormula> f3601a = null;

        i() {
        }

        @Override // com.vivo.calculator.b.f
        public void a() {
            VLog.d("BBKCalculator/Calculator", "onMemoryStateChanged: ");
            WeakReference<CalculatorFormula> weakReference = new WeakReference<>(Calculator.this.f3561r0);
            this.f3601a = weakReference;
            CalculatorFormula calculatorFormula = weakReference.get();
            if (calculatorFormula != null) {
                calculatorFormula.e();
            }
        }

        @Override // com.vivo.calculator.b.f
        public void b(int i3, int i4, int i5, String str) {
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Calculator.this.setRequestedOrientation(4);
            BBKCalculatorApplication.r(false);
        }
    }

    class k extends BroadcastReceiver {
        k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            VLog.d("BBKCalculator/Calculator", "mScreenReceiver action = " + action);
            if (!"android.intent.action.SCREEN_OFF".equals(action) || Build.VERSION.SDK_INT <= 26) {
                return;
            }
            Calculator.this.setShowWhenLocked(false);
        }
    }

    class l implements DisplayManager.DisplayListener {
        l() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            Calculator.this.K1();
            Calculator.this.w1();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
        }
    }

    class m implements c0 {
        m() {
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Calculator.this.k0();
            if (view.getId() != R.id.eq && !Calculator.I1) {
                Calculator.J1 = false;
            }
            if (view.getId() != R.id.eq) {
                Calculator.this.f3562r1 = false;
            }
            int id = view.getId();
            switch (id) {
                case R.id.clear /* 2131230845 */:
                case R.id.del /* 2131230881 */:
                    Calculator.this.f3514b1 = false;
                    if (Calculator.I1) {
                        VLog.d("BBKCalculator/Calculator", "click del , IS_ANIMATION_PLAYING , return.");
                        return;
                    }
                    if (Calculator.this.O0) {
                        Calculator.this.V0();
                        return;
                    }
                    Calculator.this.f3573v0 = false;
                    Calculator.this.Y0();
                    Calculator calculator = Calculator.this;
                    calculator.O0(calculator.f3561r0.getTextString());
                    h2.a.a().f(27);
                    break;
                case R.id.clr /* 2131230851 */:
                    Calculator.this.f3514b1 = false;
                    Calculator.this.V0();
                    h2.a.a().f(26);
                    return;
                case R.id.eq /* 2131230954 */:
                    if (Calculator.I1) {
                        VLog.d("BBKCalculator/Calculator", "click eq , IS_ANIMATION_PLAYING , return.");
                        return;
                    }
                    if (Calculator.this.f3561r0 != null && !TextUtils.isEmpty(Calculator.this.f3561r0.getTextString()) && !TextUtils.isEmpty(Calculator.this.f3564s0.getTextString())) {
                        Calculator.this.U0();
                    }
                    Calculator.this.Z0();
                    h2.a.a().f(29);
                    break;
                case R.id.madd /* 2131231070 */:
                    h2.a.a().f(1);
                    if (Calculator.this.f3561r0.getTextString().isEmpty() || Calculator.this.f3570u0 == z.ERROR) {
                        return;
                    }
                    Calculator.this.f3564s0.o();
                    Calculator.this.E1(true);
                    break;
                case R.id.mc /* 2131231093 */:
                    Calculator.this.b1();
                    h2.a.a().f(0);
                    break;
                case R.id.mminus /* 2131231105 */:
                    h2.a.a().f(2);
                    if (Calculator.this.f3561r0.getTextString().isEmpty() || Calculator.this.f3570u0 == z.ERROR) {
                        return;
                    }
                    Calculator.this.f3573v0 = false;
                    Calculator.this.f3564s0.p();
                    Calculator.this.E1(true);
                    break;
                case R.id.mr /* 2131231114 */:
                    if (Calculator.this.G0 != null && Calculator.this.G0.T()) {
                        h2.a.a().f(3);
                        Calculator.this.n0();
                        if (Calculator.this.f3567t0.l1() != 0) {
                            if (Calculator.this.O0) {
                                Calculator.this.V0();
                            }
                            Calculator.this.d1();
                        }
                    } else if (Calculator.this.G0 != null && Calculator.this.G0.getHistoryListOpen()) {
                        Calculator.this.Y0();
                        h2.a.a().f(27);
                    } else {
                        h2.a.a().f(3);
                        Calculator.this.n0();
                        if (Calculator.this.f3567t0.l1() != 0) {
                            if (Calculator.this.O0) {
                                Calculator.this.V0();
                            }
                            Calculator.this.d1();
                        }
                    }
                    break;
                case R.id.toggle_inv /* 2131231354 */:
                    Calculator.this.a1(!Calculator.this.f3585z0.isSelected());
                    h2.a.a().f(58);
                    break;
                case R.id.toggle_mode /* 2131231355 */:
                    Calculator.this.j0(false);
                    boolean z2 = !Calculator.this.f3567t0.b(0L);
                    if (Calculator.this.f3570u0 == z.RESULT && Calculator.this.f3567t0.e(0L).L0()) {
                        Calculator.this.f3567t0.t0(Calculator.this.f3567t0.j1());
                        Calculator.this.j1();
                    }
                    Calculator.this.f3567t0.V1(z2);
                    Calculator.this.c1(z2);
                    boolean unused = Calculator.F1 = z2;
                    Calculator.this.J1(z.INPUT);
                    if (!Calculator.this.A0()) {
                        Calculator.this.q0();
                    }
                    if (z2) {
                        h2.a.a().f(11);
                        return;
                    } else {
                        h2.a.a().f(12);
                        return;
                    }
                default:
                    if (Calculator.this.f3514b1 && TextUtils.isDigitsOnly(z1.e.C(Calculator.this.f3512b, id)) && id != R.id.positive_and_negative) {
                        Calculator.this.V0();
                    }
                    Calculator.this.o1(id);
                    Calculator.this.f3514b1 = false;
                    VLog.d("BBKCalculator/Calculator", "onClick: default" + Calculator.this.A0());
                    Calculator.this.j0(false);
                    if (Calculator.this.O0) {
                        if (id == R.id.positive_and_negative) {
                            Calculator.this.f3561r0.setSelection(Calculator.this.f3561r0.getSelectionEnd());
                            return;
                        }
                        Calculator.this.V0();
                    }
                    Calculator.this.f3573v0 = false;
                    if (!Calculator.this.A0()) {
                        Calculator.this.d0(id);
                        Calculator.this.i1();
                    } else {
                        Calculator calculator2 = Calculator.this;
                        calculator2.c0(z1.e.C(calculator2.f3512b, id), true);
                    }
                    break;
            }
            Calculator calculator3 = Calculator.this;
            calculator3.D1(calculator3.f3561r0.getTextString());
        }
    }

    class o extends AnimatorListenerAdapter {
        o() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Calculator.this.f3521e.setVisibility(8);
        }
    }

    class p extends AnimatorListenerAdapter {
        p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Calculator.this.f3524f.setVisibility(8);
        }
    }

    static /* synthetic */ class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3610a;

        static {
            int[] iArr = new int[z.values().length];
            f3610a = iArr;
            try {
                iArr[z.RESULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3610a[z.INIT_FOR_RESULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3610a[z.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3610a[z.INIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3610a[z.EVALUATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3610a[z.INPUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    class r implements DialogInterface.OnClickListener {
        r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                if (!Calculator.this.Q0.isShowing() || Calculator.this.isDestroyed() || Calculator.this.isFinishing()) {
                    return;
                }
                Calculator.this.Q0.dismiss();
            } catch (Exception e3) {
                VLog.e("BBKCalculator/Calculator", "mAlertDialog.dismiss exception2 : " + e3.getMessage());
            }
        }
    }

    class s implements DialogInterface.OnClickListener {
        s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Calculator.this.f3518d.putBoolean("NET_PERMISSION", true);
            Calculator.this.f3518d.apply();
            Calculator.this.startActivity(new Intent(Calculator.this, (Class<?>) ExchangeActivity.class));
            try {
                if (!Calculator.this.Q0.isShowing() || Calculator.this.isDestroyed() || Calculator.this.isFinishing()) {
                    return;
                }
                Calculator.this.Q0.dismiss();
            } catch (Exception e3) {
                VLog.e("BBKCalculator/Calculator", "mAlertDialog.dismiss exception1 : " + e3.getMessage());
            }
        }
    }

    class t implements DialogInterface.OnCancelListener {
        t() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            try {
                if (!Calculator.this.Q0.isShowing() || Calculator.this.isDestroyed() || Calculator.this.isFinishing()) {
                    return;
                }
                Calculator.this.Q0.dismiss();
            } catch (Exception e3) {
                VLog.e("BBKCalculator/Calculator", "mAlertDialog.dismiss exception3 : " + e3.getMessage());
            }
        }
    }

    class u implements Runnable {
        u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h2.b.b("A790|10013", null);
        }
    }

    class v implements View.OnLongClickListener {
        v() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Calculator.this.V0();
            h2.a.a().f(68);
            return true;
        }
    }

    class w implements View.OnLongClickListener {
        w() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Calculator.this.V0();
            h2.a.a().f(68);
            return true;
        }
    }

    class x implements View.OnLongClickListener {
        x() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Calculator.this.V0();
            h2.a.a().f(68);
            return true;
        }
    }

    class y implements View.OnLongClickListener {
        y() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Calculator.this.V0();
            h2.a.a().f(68);
            return true;
        }
    }

    private enum z {
        INPUT,
        EVALUATE,
        INIT,
        INIT_FOR_RESULT,
        ANIMATE,
        RESULT,
        ERROR,
        MEMORY;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Enum) obj);
        }
    }

    public Calculator() {
        k kVar = null;
        this.f3520d1 = new b0(this, kVar);
        this.f3523e1 = new d0(this, this, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0() {
        String str = this.f3576w0;
        return (str == null || str.isEmpty()) ? false : true;
    }

    private void B0(ActionMode actionMode, int i3, Menu menu) {
        MenuInflater menuInflater = actionMode.getMenuInflater();
        menu.clear();
        if (menuInflater != null) {
            if (i3 == 12) {
                menuInflater.inflate(R.menu.select_select_all, menu);
            }
            if (i3 == 14) {
                menuInflater.inflate(R.menu.select_select_all_paste, menu);
                return;
            }
            switch (i3) {
                case 1:
                    menuInflater.inflate(R.menu.copy, menu);
                    break;
                case 2:
                    menuInflater.inflate(R.menu.paste, menu);
                    break;
                case 3:
                    menuInflater.inflate(R.menu.copy_paste, menu);
                    break;
                case 4:
                    menuInflater.inflate(R.menu.select_all, menu);
                    break;
                case 5:
                    menuInflater.inflate(R.menu.select_all_copy, menu);
                    break;
                case 6:
                    menuInflater.inflate(R.menu.select_all_paste, menu);
                    break;
                case 7:
                    menuInflater.inflate(R.menu.select_all_copy_paste, menu);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        AnimatorSet animatorSet = this.Y0;
        if (animatorSet == null || !animatorSet.isRunning()) {
            View view = this.f3521e;
            if (view != null && this.f3524f != null) {
                if (view.getVisibility() == 0) {
                    G0(this.H0);
                    HistoryLayout historyLayout = this.H0;
                    if (historyLayout != null) {
                        historyLayout.D();
                        this.H0.Y();
                        this.H0.setDelButton(null);
                        z1.d.r(this.f3512b).w(this.H0);
                    }
                    HistoryLayout historyLayout2 = this.G0;
                    if (historyLayout2 != null) {
                        historyLayout2.G();
                        this.G0.D();
                        this.G0.Y();
                    }
                    h2.a.a().f(6);
                } else {
                    G0(this.G0);
                    HistoryLayout historyLayout3 = this.G0;
                    if (historyLayout3 != null) {
                        historyLayout3.D();
                        this.G0.Y();
                        z1.d.r(this.f3512b).w(this.G0);
                    }
                    HistoryLayout historyLayout4 = this.H0;
                    if (historyLayout4 != null) {
                        historyLayout4.G();
                        this.H0.D();
                        this.H0.Y();
                    }
                    h2.a.a().f(5);
                }
            }
            M1();
            H0();
            this.f3579x0.setAlpha(1.0f);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    private void C0(String str, ActionMode actionMode, Menu menu, boolean z2) {
        int i3;
        if (z2 && this.f3564s0 != null) {
            B0(actionMode, 1, menu);
            return;
        }
        if (this.N0 != null) {
            VLog.d("BBKCalculator/Calculator", "inflateMenu: clipDataStrTrim ==  " + str);
            if (str != null) {
                i3 = 2;
            } else {
                i3 = 0;
            }
        } else {
            i3 = 0;
        }
        CalculatorFormula calculatorFormula = this.f3561r0;
        if (calculatorFormula != null) {
            int length = calculatorFormula.getTextString().length();
            int selectionStart = this.f3561r0.getSelectionStart();
            int selectionEnd = this.f3561r0.getSelectionEnd();
            if (length != 0 && selectionStart != selectionEnd) {
                i3 |= 1;
            }
        }
        B0(actionMode, i3, menu);
    }

    private void D0() {
        View view;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3512b);
        this.f3515c = defaultSharedPreferences;
        this.f3518d = defaultSharedPreferences.edit();
        this.C0 = (ColorButton) findViewById(R.id.del);
        this.G0 = (HistoryLayout) findViewById(R.id.history_layout);
        this.H0 = (HistoryLayout) findViewById(R.id.history_layout_land);
        this.f3521e = findViewById(R.id.keyboard_layout);
        this.f3524f = findViewById(R.id.keyboard_land_layout);
        this.C1 = (ColorSelectButton) findViewById(R.id.mr);
        VLog.d("BBKCalculator/Calculator", "initCalculatorView:    HistoryListOpen == " + this.f3515c.getBoolean("HistoryListOpen", false));
        if (this.f3515c.getBoolean("HistoryListOpen", false)) {
            this.f3544l1 = true;
            this.f3518d.putBoolean("HistoryListOpen", false);
            this.f3518d.commit();
        }
        VLog.d("BBKCalculator/Calculator", "initCalculatorView:  " + this.f3544l1);
        if (R0()) {
            ColorButton colorButton = (ColorButton) findViewById(R.id.clear);
            this.f3535i1 = colorButton;
            if (colorButton != null) {
                G1();
                this.f3535i1.setOnLongClickListener(new v());
            }
        } else {
            View view2 = this.f3521e;
            if (view2 != null) {
                this.f3529g1 = (ColorButton) view2.findViewById(R.id.clear);
            }
            View view3 = this.f3524f;
            if (view3 != null) {
                this.f3532h1 = (ColorButton) view3.findViewById(R.id.clear);
            }
            if (this.f3529g1 != null) {
                G1();
                this.f3529g1.setOnLongClickListener(new w());
            }
            if (this.f3532h1 != null) {
                G1();
                this.f3532h1.setOnLongClickListener(new x());
            }
            ColorButton colorButton2 = this.C0;
            if (colorButton2 != null) {
                colorButton2.setOnLongClickListener(new y());
            }
        }
        CalculatorFormula calculatorFormula = (CalculatorFormula) findViewById(R.id.formula);
        this.f3561r0 = calculatorFormula;
        calculatorFormula.setInputType(524289);
        this.f3561r0.setShowSoftInputOnFocus(false);
        this.f3561r0.setSingleLine(true);
        if (R0()) {
            this.f3561r0.setZoom(false);
        } else {
            this.f3561r0.setZoom(true);
        }
        this.f3561r0.setLongClickable(true);
        CalculatorResult calculatorResult = (CalculatorResult) findViewById(R.id.result);
        this.f3564s0 = calculatorResult;
        calculatorResult.s(this.f3567t0, 0L);
        this.f3564s0.setShowSoftInputOnFocus(false);
        this.f3564s0.setSingleLine(true);
        this.f3564s0.setCursorVisible(false);
        this.f3564s0.setFocusable(true);
        this.f3564s0.setLongClickable(true);
        this.f3564s0.setKeyListener(null);
        this.f3564s0.setTextIsSelectable(true);
        z1.e.x(this.f3526f1);
        z1.e.v(this);
        this.I0 = (LinearLayout) findViewById(R.id.touchlayout);
        F0();
        this.f3585z0 = (ColorSelectButton) findViewById(R.id.toggle_inv);
        this.B0 = (ColorButton) findViewById(R.id.toggle_mode);
        this.A0 = (TextView) findViewById(R.id.mode);
        I1(isInMultiWindowMode());
        F1 = !this.f3515c.getBoolean("radflag", false);
        this.f3573v0 = this.f3515c.getBoolean("ERROR_STATE", false);
        c1(F1);
        this.D0 = new View[]{findViewById(R.id.fun_sin), findViewById(R.id.fun_cos), findViewById(R.id.fun_tan), findViewById(R.id.fun_sinh), findViewById(R.id.fun_cosh), findViewById(R.id.fun_tanh), findViewById(R.id.fun_ln), findViewById(R.id.fun_exp)};
        this.E0 = new View[]{findViewById(R.id.fun_arcsin), findViewById(R.id.fun_arccos), findViewById(R.id.fun_arctan), findViewById(R.id.fun_arcsinh), findViewById(R.id.fun_arccosh), findViewById(R.id.fun_arctanh), findViewById(R.id.fun_log), findViewById(R.id.const_x)};
        if (!isInMultiWindowMode()) {
            ImageButton imageButton = (ImageButton) findViewById(R.id.calculator_mode_toge_button);
            this.f3579x0 = imageButton;
            if (imageButton != null) {
                imageButton.setNightMode(0);
                this.f3579x0.setOnClickListener(new a());
            }
            ImageButton imageButton2 = (ImageButton) findViewById(R.id.exchange_toge_button);
            this.f3582y0 = imageButton2;
            if (imageButton2 != null) {
                imageButton2.setOnClickListener(new b());
            }
        }
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.setting_button);
        this.R0 = imageButton3;
        if (imageButton3 != null) {
            imageButton3.setNightMode(0);
            this.R0.setOnClickListener(new c());
        }
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.open_window_button);
        this.S0 = imageButton4;
        if (imageButton4 != null) {
            if (g2.b.s(this.f3512b) && g2.g.e()) {
                if (!g2.b.t(this.f3512b)) {
                    this.S0.setVisibility(0);
                }
                this.S0.setNightMode(0);
                this.S0.setOnClickListener(new d());
            } else {
                this.S0.setVisibility(8);
            }
        }
        if (this.R0 != null && !g2.b.o(this.f3512b) && getResources().getConfiguration().orientation != 1) {
            this.R0.setVisibility(8);
            this.S0.setVisibility(8);
        }
        this.f3561r0.setCustomInsertionActionModeCallback(new e());
        this.f3561r0.setCustomSelectionActionModeCallback(new f());
        this.f3564s0.setCustomInsertionActionModeCallback(new g());
        this.f3564s0.setCustomSelectionActionModeCallback(new h());
        if (!g2.b.o(this)) {
            G0(this.G0);
        } else if (this.f3521e != null && this.f3524f != null) {
            if (this.f3515c.getInt("DispalyID", 0) == 0 || BBKCalculatorApplication.f()) {
                this.f3521e.setVisibility(0);
                this.f3524f.setVisibility(8);
                G0(this.G0);
                this.f3579x0.setImageResource(R.drawable.cal_toggle_btn_ordinary);
                this.X0 = false;
            } else {
                this.f3521e.setVisibility(8);
                this.f3524f.setVisibility(0);
                G0(this.H0);
                this.H0.setDelButton(null);
                this.f3579x0.setImageResource(R.drawable.cal_toggle_btn_science);
                this.X0 = true;
            }
        }
        this.H = (ColorButton) findViewById(R.id.dec_point);
        if (".".equals(g2.b.f4762c)) {
            if (isInMultiWindowMode()) {
                if (g2.b.b(this)) {
                    this.H.setImageResource(R.drawable.dot_mul_material);
                } else {
                    this.H.setImageResource(R.drawable.dot_mul);
                }
            } else if (g2.b.b(this)) {
                this.H.setImageResource(R.drawable.dot_material);
            } else {
                this.H.setImageResource(R.drawable.dot);
            }
        } else if (isInMultiWindowMode()) {
            if (g2.b.b(this)) {
                this.H.setImageResource(R.drawable.comma_mul_material);
            } else {
                this.H.setImageResource(R.drawable.comma_mul);
            }
        } else if (g2.b.b(this)) {
            this.H.setImageResource(R.drawable.comma_material);
        } else {
            this.H.setImageResource(R.drawable.comma);
        }
        if (g2.b.o(this) && (view = this.f3524f) != null) {
            this.I = (ColorButton) view.findViewById(R.id.dec_point);
            if (".".equals(g2.b.f4762c)) {
                if (g2.b.b(this)) {
                    this.I.setImageResource(R.drawable.dot_land_material);
                } else {
                    this.I.setImageResource(R.drawable.dot_land);
                }
            } else if (g2.b.b(this)) {
                this.I.setImageResource(R.drawable.comma_land_material);
            } else {
                this.I.setImageResource(R.drawable.comma_land);
            }
        }
        D1(this.f3561r0.getTextString());
        if (!G1 && this.f3515c.getBoolean("ScreenAsPad", false) != g2.b.o(this.f3512b)) {
            this.f3518d.putBoolean("ScreenAsPad", g2.b.o(this.f3512b));
            this.f3518d.commit();
            if (this.f3515c.getBoolean("DIALOG_SHOW", false)) {
                L1();
            }
        }
        H0();
        if (!g2.b.o(this.f3512b) || H1) {
            return;
        }
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (!g2.b.n()) {
            if (this.f3521e != null && isInMultiWindowMode()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3521e.getLayoutParams();
                if (rotation == 0 || 2 == rotation) {
                    layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_mul_port);
                } else if (1 == rotation || 3 == rotation) {
                    layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_mul_port_land);
                }
                this.f3521e.setLayoutParams(layoutParams);
            }
            if (1 == rotation || 3 == rotation) {
                ((LinearLayout.LayoutParams) this.f3561r0.getLayoutParams()).setMargins(0, 0, 0, 0);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.keyguard);
        if (!isInMultiWindowMode() && relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams2.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_large_size_land);
            relativeLayout.setLayoutParams(layoutParams2);
        }
        if (this.f3524f != null && !isInMultiWindowMode()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3524f.getLayoutParams();
            layoutParams3.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_large_size);
            layoutParams3.setMargins(0, getResources().getDimensionPixelOffset(R.dimen.keyguard_margin_top_nex), 0, 0);
            this.f3524f.setLayoutParams(layoutParams3);
        }
        if (this.f3521e != null && !isInMultiWindowMode()) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f3521e.getLayoutParams();
            layoutParams4.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_large_size);
            layoutParams4.setMargins(0, getResources().getDimensionPixelOffset(R.dimen.keyguard_margin_top_nex), 0, 0);
            this.f3521e.setLayoutParams(layoutParams4);
        }
        if (this.f3521e == null || !isInMultiWindowMode()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f3521e.getLayoutParams();
        if (rotation == 0 || 2 == rotation) {
            layoutParams5.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_large_size_mul);
            this.f3561r0.setTextSize(0, this.f3512b.getResources().getDimension(R.dimen.calculator_input_text_size_mul_large_display_nex));
            this.f3564s0.setTextSize(0, this.f3512b.getResources().getDimension(R.dimen.calculator_result_text_size_mul_large_display_nex));
        } else if (1 == rotation || 3 == rotation) {
            layoutParams5.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_large_size_mul_land);
        }
        this.f3521e.setLayoutParams(layoutParams5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(String str) {
        if (!g2.b.o(this.f3512b) || this.A0 == null) {
            Q0(str);
            return;
        }
        View view = this.f3524f;
        if (view == null || view.getVisibility() != 0) {
            this.A0.setVisibility(4);
        } else {
            Q0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(boolean z2) {
        ColorSelectButton colorSelectButton = this.C1;
        if (colorSelectButton == null) {
            return;
        }
        this.D1 = z2;
        int i3 = R.drawable.selectbutton_select;
        int i4 = R.drawable.selectbutton_select_material;
        int i5 = R.drawable.colornumber_select_land;
        int i6 = R.drawable.colornumber_select_land_material;
        if (colorSelectButton != null) {
            if (z2) {
                if (isInMultiWindowMode()) {
                    if (g2.b.b(this)) {
                        this.C1.setBackgroundResource(R.drawable.selectbutton_select_mul_material);
                    } else {
                        this.C1.setBackgroundResource(R.drawable.selectbutton_select_mul);
                    }
                } else if (g2.b.b(this)) {
                    ColorSelectButton colorSelectButton2 = this.C1;
                    if (g2.b.o(this.f3512b)) {
                        i4 = R.drawable.selectbutton_select_nex_material;
                    }
                    colorSelectButton2.setBackgroundResource(i4);
                } else {
                    ColorSelectButton colorSelectButton3 = this.C1;
                    if (g2.b.o(this.f3512b)) {
                        i3 = R.drawable.selectbutton_select_nex;
                    }
                    colorSelectButton3.setBackgroundResource(i3);
                }
            } else if (isInMultiWindowMode()) {
                if (g2.b.b(this)) {
                    this.C1.setBackgroundResource(R.drawable.colornumber_select_land_mul_material);
                } else {
                    this.C1.setBackgroundResource(R.drawable.colornumber_select_land_mul);
                }
            } else if (g2.b.b(this)) {
                ColorSelectButton colorSelectButton4 = this.C1;
                if (g2.b.o(this.f3512b)) {
                    i6 = R.drawable.colornumber_select_land_nex_material;
                }
                colorSelectButton4.setBackgroundResource(i6);
            } else {
                ColorSelectButton colorSelectButton5 = this.C1;
                if (g2.b.o(this.f3512b)) {
                    i5 = R.drawable.colornumber_select_land_nex;
                }
                colorSelectButton5.setBackgroundResource(i5);
            }
        }
        this.C1.setSelect(z2);
        this.C1.invalidate();
    }

    private void F0() {
        if (g2.b.n()) {
            CalculatorFormula calculatorFormula = this.f3561r0;
            if (calculatorFormula != null) {
                ((ViewGroup.MarginLayoutParams) calculatorFormula.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (R0()) {
                CalculatorFormula calculatorFormula2 = this.f3561r0;
                if (calculatorFormula2 != null) {
                    calculatorFormula2.setTextSize(0, this.f3512b.getResources().getDimension(R.dimen.windowmul_free_formula_text_size));
                }
                CalculatorResult calculatorResult = this.f3564s0;
                if (calculatorResult != null) {
                    calculatorResult.setTextSize(0, this.f3512b.getResources().getDimension(R.dimen.windowmul_free_result_text_size));
                }
            }
        }
    }

    private void F1() {
        if (this.f3515c.getLong("memory_index", 0L) != 0) {
            E1(true);
        }
    }

    private void G0(HistoryLayout historyLayout) {
        VLog.d("BBKCalculator/Calculator", "initHistory: ");
        ImageButton imageButton = (ImageButton) findViewById(R.id.history_toge_button);
        this.F0 = imageButton;
        if (imageButton != null) {
            imageButton.setNightMode(0);
        }
        if (historyLayout != null) {
            historyLayout.J(this, this.F0, this.I0, this.f3564s0, this.C1, this.C0);
            historyLayout.P();
            historyLayout.K();
            z1.d.r(this.f3512b).w(historyLayout);
            z1.d.r(this.f3512b).s();
            if (this.f3544l1) {
                historyLayout.X();
                if (this.f3515c.getBoolean("HISTORY_DIALOG_OPEN", false)) {
                    historyLayout.f0();
                }
            }
        }
    }

    private void G1() {
        if (Settings.System.getInt(getApplicationContext().getContentResolver(), "vivo_nightmode_used", -2) == 1) {
            if (this.f3529g1 != null) {
                VLog.d("BBKCalculator/Calculator", " mDelText setNightModeIfNeeded ");
                g2.g.f(this.f3529g1, 0);
            }
            ColorButton colorButton = this.f3535i1;
            if (colorButton != null) {
                g2.g.f(colorButton, 0);
            }
            if (this.f3532h1 != null) {
                VLog.d("BBKCalculator/Calculator", " mSciDelText setNightModeIfNeeded ");
                g2.g.f(this.f3532h1, 0);
            }
        }
    }

    private void H0() {
        View view;
        this.f3536j = findViewById(R.id.calculator_main_layout);
        this.f3539k = findViewById(R.id.pad_numeric);
        this.f3545m = (LinearLayout) findViewById(R.id.history_view);
        this.f3548n = (LinearLayout) findViewById(R.id.history_list_layout);
        this.f3542l = (LinearLayout) findViewById(R.id.delete_history_container);
        Button button = (Button) findViewById(R.id.delete_history);
        this.f3551o = button;
        button.setTextColor(this.f3512b.getApplicationContext().getColor(R.color.function_text_blue_color));
        View view2 = this.f3526f1;
        if ((this.X0 && (view = this.f3524f) != null) || (view = this.f3521e) != null) {
            view2 = view;
        }
        this.f3566t = (ColorButton) view2.findViewById(R.id.clr);
        this.f3554p = (ColorButton) view2.findViewById(R.id.clear);
        this.f3557q = (ColorButton) view2.findViewById(R.id.positive_and_negative);
        this.K = (ColorButton) view2.findViewById(R.id.mc);
        this.L = (ColorButton) view2.findViewById(R.id.madd);
        this.M = (ColorButton) view2.findViewById(R.id.mminus);
        this.f3560r = (ColorButton) view2.findViewById(R.id.op_div);
        this.f3563s = (ColorButton) view2.findViewById(R.id.op_mul);
        this.f3569u = (ColorButton) view2.findViewById(R.id.op_sub);
        this.f3572v = (ColorButton) view2.findViewById(R.id.op_add);
        this.f3575w = (ColorButton) view2.findViewById(R.id.digit_0);
        this.f3578x = (ColorButton) view2.findViewById(R.id.digit_1);
        this.f3581y = (ColorButton) view2.findViewById(R.id.digit_2);
        this.f3584z = (ColorButton) view2.findViewById(R.id.digit_3);
        this.A = (ColorButton) view2.findViewById(R.id.digit_4);
        this.B = (ColorButton) view2.findViewById(R.id.digit_5);
        this.C = (ColorButton) view2.findViewById(R.id.digit_6);
        this.D = (ColorButton) view2.findViewById(R.id.digit_7);
        this.E = (ColorButton) view2.findViewById(R.id.digit_8);
        this.F = (ColorButton) view2.findViewById(R.id.digit_9);
        this.G = (ColorButton) view2.findViewById(R.id.op_pct);
        this.H = (ColorButton) view2.findViewById(R.id.dec_point);
        this.J = (ColorButton) view2.findViewById(R.id.eq);
        this.N = (ColorButton) view2.findViewById(R.id.lparen);
        this.O = (ColorButton) view2.findViewById(R.id.rparen);
        this.P = (ColorButton) view2.findViewById(R.id.fun_10pow);
        this.Q = (ColorButton) view2.findViewById(R.id.countDown);
        this.R = (ColorButton) view2.findViewById(R.id.op_sqr);
        this.S = (ColorButton) view2.findViewById(R.id.op_sqrs);
        this.T = (ColorButton) view2.findViewById(R.id.yx);
        this.U = (ColorButton) view2.findViewById(R.id.op_fact);
        this.V = (ColorButton) view2.findViewById(R.id.op_sqrt);
        this.W = (ColorButton) view2.findViewById(R.id.xgenhaoy);
        this.X = (ColorButton) view2.findViewById(R.id.fun_lg);
        this.Y = (ColorButton) view2.findViewById(R.id.fun_sin);
        this.Z = (ColorButton) view2.findViewById(R.id.fun_cos);
        this.f3510a0 = (ColorButton) view2.findViewById(R.id.fun_tan);
        this.f3513b0 = (ColorButton) view2.findViewById(R.id.fun_ln);
        this.f3516c0 = (ColorButton) view2.findViewById(R.id.fun_sinh);
        this.f3519d0 = (ColorButton) view2.findViewById(R.id.fun_cosh);
        this.f3522e0 = (ColorButton) view2.findViewById(R.id.fun_tanh);
        this.f3525f0 = (ColorButton) view2.findViewById(R.id.fun_exp);
        this.f3528g0 = (ColorButton) view2.findViewById(R.id.fun_arcsin);
        this.f3531h0 = (ColorButton) view2.findViewById(R.id.fun_arccos);
        this.f3534i0 = (ColorButton) view2.findViewById(R.id.fun_arctan);
        this.f3537j0 = (ColorButton) view2.findViewById(R.id.fun_log);
        this.f3540k0 = (ColorButton) view2.findViewById(R.id.fun_arcsinh);
        this.f3543l0 = (ColorButton) view2.findViewById(R.id.fun_arccosh);
        this.f3546m0 = (ColorButton) view2.findViewById(R.id.fun_arctanh);
        this.f3549n0 = (ColorButton) view2.findViewById(R.id.const_x);
        this.f3552o0 = (ColorButton) view2.findViewById(R.id.const_pi);
        this.f3555p0 = (ColorButton) view2.findViewById(R.id.EE);
        this.f3558q0 = (ColorButton) view2.findViewById(R.id.rand);
        if (g2.b.b(this)) {
            VLog.d("BBKCalculator/Calculator", "material you overlay is open");
            if (isInMultiWindowMode()) {
                if (R0()) {
                    l0("_mul_select", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "_material", getPackageName());
                    return;
                } else if (getResources().getConfiguration().orientation == 1) {
                    l0("_mul_select", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "_material", getPackageName());
                    return;
                } else {
                    l0("_mul", "_land", BuildConfig.FLAVOR, "_material", getPackageName());
                    return;
                }
            }
            if (g2.b.o(this)) {
                if (this.X0) {
                    l0(BuildConfig.FLAVOR, "_land", "_nex", "_material", getPackageName());
                    return;
                } else {
                    l0(BuildConfig.FLAVOR, BuildConfig.FLAVOR, "_nex", "_material", getPackageName());
                    return;
                }
            }
            if (getResources().getConfiguration().orientation == 1) {
                l0(BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "_material", getPackageName());
            } else {
                l0(BuildConfig.FLAVOR, "_land", BuildConfig.FLAVOR, "_material", getPackageName());
            }
        }
    }

    private void I0() {
        getWindow().setSoftInputMode(3);
    }

    private void I1(boolean z2) {
        String str = "Rad (" + getResources().getString(R.string.radexplanation) + ")";
        String str2 = "Deg (" + getResources().getString(R.string.degexplanation) + ")";
        if (z2) {
            str = "Rad";
        }
        this.A1 = str;
        if (z2) {
            str2 = "Deg";
        }
        this.B1 = str2;
    }

    private void J0() {
        K1 = this.f3564s0.getY();
        L1 = this.f3561r0.getY();
        M1 = this.f3564s0.getTextSize();
        N1 = this.f3561r0.getTextSize();
        O1 = this.f3564s0.getLayoutParams().height;
        P1 = this.f3561r0.getLayoutParams().height;
        VLog.v("BBKCalculator/Calculator", "mResultTextSize = " + M1 + " , mInputEditSize = " + N1);
        this.f3577w1 = this.f3564s0.getTextColors().getDefaultColor();
        this.f3580x1 = this.f3561r0.getTextColors().getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(z zVar) {
        VLog.d("BBKCalculator/Calculator", "setState, mCurrentState:  " + this.f3570u0 + ",state:" + zVar);
        if (this.f3570u0 != zVar) {
            if (zVar == z.INPUT) {
                this.f3564s0.t(0, null);
                r1();
            }
            this.f3570u0 = zVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0 || 2 == rotation) {
            VLog.d("BBKCalculator/Calculator", "ROTATION_0/180 , clearFlags FLAG_FULLSCREEN");
            getWindow().clearFlags(1024);
            return;
        }
        if ((1 == rotation || 3 == rotation) && !isInMultiWindowMode() && !g2.b.o(this.f3512b)) {
            VLog.d("BBKCalculator/Calculator", "ROTATION_90/270 , FLAG_FULLSCREEN");
            getWindow().setFlags(1024, 1024);
        } else if (isInMultiWindowMode()) {
            VLog.d("BBKCalculator/Calculator", "setWindowStatus: isInMultiWindowMode  clearFlags FLAG_FULLSCREEN ");
            getWindow().clearFlags(1024);
        }
    }

    private String L0(String str) {
        char c3;
        boolean z2;
        if (str != null && (str.contains("(") || str.contains(")"))) {
            int i3 = 0;
            String strSubstring = str;
            while (true) {
                c3 = '(';
                z2 = true;
                if (strSubstring.indexOf(40) == -1) {
                    break;
                }
                strSubstring = strSubstring.substring(strSubstring.indexOf(40) + 1, strSubstring.length());
                i3++;
            }
            int i4 = 0;
            String strSubstring2 = str;
            while (strSubstring2.indexOf(41) != -1) {
                strSubstring2 = strSubstring2.substring(strSubstring2.indexOf(41) + 1, strSubstring2.length());
                i4++;
            }
            int iAbs = Math.abs(i3 - i4);
            VLog.d("BBKCalculator/Calculator", "leftParenNum = " + i3 + ",rightParenNum = " + i4);
            if (iAbs != 0) {
                if (i3 > i4) {
                    z2 = false;
                    c3 = ')';
                }
                StringBuilder sb = new StringBuilder(str);
                for (int i5 = 0; i5 < iAbs; i5++) {
                    if (z2) {
                        sb.insert(0, c3);
                    } else {
                        sb.append(c3);
                    }
                }
                str = sb.toString();
            }
            VLog.d("BBKCalculator/Calculator", "insertParen text end = " + str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1() {
        VLog.d("BBKCalculator/Calculator", "showDialogRequestPermission.");
        androidx.appcompat.app.a aVarA = new androidx.appcompat.app.a.C0000a(this).p(getResources().getString(R.string.dialog_title)).g(getResources().getString(R.string.dialog_content)).m(getResources().getString(R.string.dialog_continue), new s()).j(getResources().getString(R.string.dialog_back), new r()).a();
        this.Q0 = aVarA;
        aVarA.setOnCancelListener(new t());
        try {
            if (this.Q0.isShowing() || isDestroyed() || isFinishing()) {
                return;
            }
            this.Q0.show();
            this.Q0.f(-2).setAllCaps(false);
            this.Q0.f(-1).setAllCaps(false);
            VLog.d("BBKCalculator/Calculator", "mAlertDialog.show.");
        } catch (Exception e3) {
            VLog.d("BBKCalculator/Calculator", "mAlertDialog Exception " + e3);
        }
    }

    private void M1() {
        TextView textView;
        if (this.f3521e == null) {
            VLog.d("BBKCalculator/Calculator", "mOrdinaryKeyboard is null, return");
            return;
        }
        g2.a.a(this.f3579x0, 1.0f, 0.0f, 150L, g2.a.b(0.33f, 0.0f, 0.35f, 1.0f));
        g2.a.a(this.f3579x0, 0.0f, 1.0f, 150L, g2.a.b(0.33f, 0.0f, 0.67f, 1.0f));
        this.Y0 = new AnimatorSet();
        if (this.f3521e.getVisibility() == 0) {
            this.f3524f.setVisibility(0);
            D1(this.f3561r0.getTextString());
            this.X0 = true;
            List<Animator> listF0 = f0(this.f3521e, this.f3524f);
            this.Y0.addListener(new o());
            this.Y0.playTogether(listF0);
            this.Y0.start();
            this.f3579x0.setImageResource(R.drawable.cal_toggle_btn_science);
            return;
        }
        if (g2.b.o(this.f3512b) && (textView = this.A0) != null) {
            textView.setVisibility(4);
        }
        this.f3521e.setVisibility(0);
        this.X0 = false;
        List<Animator> listF1 = f0(this.f3524f, this.f3521e);
        this.Y0.addListener(new p());
        this.Y0.playTogether(listF1);
        this.Y0.start();
        this.f3579x0.setImageResource(R.drawable.cal_toggle_btn_ordinary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1() {
        VLog.d("BBKCalculator/Calculator", "start setting activity: ");
        Intent intent = new Intent(this.f3512b, (Class<?>) CalculatorSettingActivity.class);
        try {
            VLog.d("BBKCalculator/Calculator", "onClick: ");
            startActivity(intent);
        } catch (ActivityNotFoundException e3) {
            VLog.e("BBKCalculator/Calculator", e3.getMessage());
        }
    }

    private void O1(int i3) {
        if (z1.e.l(i3) || z1.e.p(i3)) {
            com.vivo.calculator.b bVar = this.f3567t0;
            bVar.t0(bVar.j1());
        } else {
            this.f3567t0.o0();
        }
        J1(z.INPUT);
    }

    private void P1(int i3, boolean z2) {
        z zVar;
        int i4 = 0;
        if ((i3 == R.id.positive_and_negative && ((zVar = this.f3570u0) == z.EVALUATE || zVar == z.RESULT)) || this.f3514b1) {
            this.f3514b1 = false;
            String textString = this.f3561r0.getTextString();
            this.f3567t0.o0();
            J1(z.INPUT);
            if (!TextUtils.isEmpty(textString)) {
                String strReplaceAll = textString.replaceAll(",", BuildConfig.FLAVOR);
                while (i4 < strReplaceAll.length()) {
                    int i5 = i4 + 1;
                    g0(z1.e.B(this.f3512b, strReplaceAll.substring(i4, i5)));
                    VLog.d("BBKCalculator/Calculator", "switchToInput: ");
                    this.f3564s0.c();
                    i4 = i5;
                }
            }
        } else if (!z1.e.l(i3) && !z1.e.p(i3)) {
            this.f3567t0.o0();
        } else if (i3 == R.id.positive_and_negative) {
            g2.b.f4760a = true;
            String textString2 = this.f3561r0.getTextString();
            int selectionStart = this.f3561r0.getSelectionStart();
            this.f3567t0.o0();
            M0(textString2, false);
            this.f3561r0.setSelection(selectionStart);
        } else {
            com.vivo.calculator.b bVar = this.f3567t0;
            bVar.t0(bVar.j1());
        }
        J1(z.INPUT);
    }

    private void Q1() {
        a0 a0Var = this.V0;
        if (a0Var != null) {
            unregisterReceiver(a0Var);
            this.V0 = null;
        }
        unregisterReceiver(this.f3511a1);
    }

    private z S0(z zVar) {
        switch (q.f3610a[zVar.ordinal()]) {
            case 1:
            case 2:
                return z.INIT_FOR_RESULT;
            case 3:
            case 4:
                return z.INIT;
            default:
                VLog.e("BBKCalculator/Calculator", "Impossible saved state:" + zVar);
            case 5:
            case 6:
                return zVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(ActionMode actionMode, MenuItem menuItem, boolean z2) {
        if (menuItem == null || this.f3561r0 == null) {
            return;
        }
        switch (menuItem.getItemId()) {
            case R.id.it_copy /* 2131231033 */:
                if (z2) {
                    g2.h.d(this.f3564s0, this.N0);
                } else {
                    g2.h.c(this.f3561r0, this.N0);
                }
                actionMode.finish();
                g2.b.B(this.f3512b, R.string.already_copy);
                h2.a.a().f(9);
                break;
            case R.id.it_cut /* 2131231034 */:
                g2.h.c(this.f3561r0, this.N0);
                SpannableStringBuilder spannableStringBuilderM1 = this.f3567t0.e(0L).m1(this.f3512b);
                if (!TextUtils.isEmpty(spannableStringBuilderM1)) {
                    String string = spannableStringBuilderM1.toString();
                    if (!TextUtils.isEmpty(string)) {
                        String strReplaceAll = string.replaceAll(",", BuildConfig.FLAVOR);
                        if (!TextUtils.isEmpty(strReplaceAll)) {
                            int selectionStart = this.f3561r0.getSelectionStart();
                            for (int length = strReplaceAll.length(); length > 0; length--) {
                                int iF1 = z.RESULT == this.f3570u0 ? this.f3567t0.f1(this.f3561r0.getTextString().length()) : this.f3567t0.f1(selectionStart + 1);
                                int i3 = selectionStart + 1;
                                String strA0 = this.f3567t0.A0(i3);
                                String strValueOf = String.valueOf(z1.e.i());
                                if (".".equals(strValueOf)) {
                                    strValueOf = "\\.";
                                }
                                if (!TextUtils.isEmpty(strA0)) {
                                    j1();
                                    CalculatorFormula calculatorFormula = this.f3561r0;
                                    calculatorFormula.f(iF1, calculatorFormula.length());
                                    String strReplaceAll2 = strA0.replaceAll(strValueOf, BuildConfig.FLAVOR);
                                    if (this.f3567t0.e0(strReplaceAll2)) {
                                        int length2 = strReplaceAll2.length();
                                        for (int i4 = 0; i4 < length2; i4++) {
                                            this.f3567t0.W(z1.e.r(strReplaceAll2.charAt(i4)), i3, this.f3561r0);
                                            j1();
                                        }
                                        this.f3561r0.a(this.f3567t0.e(0L).m1(this.f3512b));
                                        i1();
                                    }
                                }
                            }
                            J1(z.INPUT);
                            i1();
                            g2.h.c(this.f3561r0, this.N0);
                            actionMode.finish();
                            g2.b.B(this.f3512b, R.string.already_cut);
                            h2.a.a().f(8);
                            break;
                        }
                    }
                }
                break;
            case R.id.it_paste /* 2131231035 */:
                this.f3562r1 = false;
                K0(z1.g.d(s0()));
                actionMode.finish();
                h2.a.a().f(10);
                break;
            case R.id.it_select /* 2131231036 */:
                g2.h.h(this.f3561r0);
                break;
            case R.id.it_select_all /* 2131231037 */:
                this.f3561r0.selectAll();
                h2.a.a().f(7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        this.f3573v0 = false;
        if (this.f3567t0.e(0L).P0() && !A0()) {
            this.f3561r0.setText(BuildConfig.FLAVOR);
        } else {
            j0(true);
            W0();
        }
    }

    private void W0() {
        this.f3576w0 = null;
        this.f3564s0.c();
        this.f3567t0.o0();
        J1(z.INPUT);
        y1(false);
        j1();
        if (this.A0 != null) {
            if (g2.b.o(this.f3512b)) {
                this.A0.setVisibility(4);
            } else {
                this.A0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(ActionMode actionMode, Menu menu, boolean z2) {
        C0(s0(), actionMode, menu, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        if (j0(false)) {
            VLog.d("BBKCalculator/Calculator", "onDelete,cancelIfEvaluating,return.");
            J1(z.INPUT);
            return;
        }
        if (this.f3570u0 == z.RESULT) {
            p1();
        } else {
            if (A0()) {
                String str = this.f3576w0;
                this.f3576w0 = str.substring(0, str.length() - 1);
            } else {
                p0();
            }
            if (this.f3567t0.e(0L).P0() && !A0()) {
                h0();
            }
        }
        J1(z.INPUT);
        i1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        this.f3561r0.getTextString();
        z zVar = this.f3570u0;
        z zVar2 = z.INPUT;
        if (zVar != zVar2) {
            y1(true);
            if (this.f3570u0 == z.ERROR && this.f3564s0.isEnabled()) {
                J1(zVar2);
                return;
            }
            return;
        }
        if (A0()) {
            J1(z.EVALUATE);
            b(0L, R.string.error_syntax);
        } else if (this.f3567t0.e(0L).A0()) {
            J1(z.EVALUATE);
            this.f3567t0.L1(0L, this, this.f3564s0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(boolean z2) {
        VLog.d("BBKCalculator/Calculator", "onInverseToggled: showInverse " + z2);
        ColorSelectButton colorSelectButton = this.f3585z0;
        if (colorSelectButton == null) {
            return;
        }
        colorSelectButton.setSelected(z2);
        int i3 = R.drawable.selectbutton_select_material;
        int i4 = R.drawable.selectbutton_select_nex;
        int i5 = R.drawable.colornumber_select_land_material;
        int i6 = R.drawable.colornumber_select_land_nex;
        if (z2) {
            this.f3585z0.setContentDescription(getString(R.string.desc_inv_on));
            if (isInMultiWindowMode()) {
                if (g2.b.b(this)) {
                    this.f3585z0.setBackgroundResource(R.drawable.selectbutton_select_mul_material);
                } else {
                    this.f3585z0.setBackgroundResource(R.drawable.selectbutton_select);
                }
            } else if (g2.b.b(this)) {
                ColorSelectButton colorSelectButton2 = this.f3585z0;
                if (g2.b.o(this.f3512b)) {
                    i3 = R.drawable.selectbutton_select_nex_material;
                }
                colorSelectButton2.setBackgroundResource(i3);
            } else {
                ColorSelectButton colorSelectButton3 = this.f3585z0;
                if (!g2.b.o(this.f3512b)) {
                    i4 = R.drawable.selectbutton_select;
                }
                colorSelectButton3.setBackgroundResource(i4);
            }
            for (View view : this.D0) {
                view.setVisibility(8);
            }
            for (View view2 : this.E0) {
                view2.setVisibility(0);
            }
        } else {
            this.f3585z0.setContentDescription(getString(R.string.desc_inv_off));
            if (isInMultiWindowMode()) {
                if (g2.b.b(this)) {
                    this.f3585z0.setBackgroundResource(R.drawable.colornumber_select_land_mul_material);
                } else {
                    this.f3585z0.setBackgroundResource(R.drawable.colornumber_select_land);
                }
            } else if (g2.b.b(this)) {
                ColorSelectButton colorSelectButton4 = this.f3585z0;
                if (g2.b.o(this.f3512b)) {
                    i5 = R.drawable.colornumber_select_land_nex_material;
                }
                colorSelectButton4.setBackgroundResource(i5);
            } else {
                ColorSelectButton colorSelectButton5 = this.f3585z0;
                if (!g2.b.o(this.f3512b)) {
                    i6 = R.drawable.colornumber_select_land;
                }
                colorSelectButton5.setBackgroundResource(i6);
            }
            for (View view3 : this.D0) {
                view3.setVisibility(0);
            }
            for (View view4 : this.E0) {
                view4.setVisibility(8);
            }
        }
        this.f3585z0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        E1(false);
        long jL1 = this.f3567t0.l1();
        if (jL1 != 0) {
            this.f3567t0.s0(jL1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(String str, boolean z2) {
        int iQ0;
        if (this.f3576w0 != null) {
            str = this.f3576w0 + str;
        }
        int length = str.length();
        if (this.f3570u0 == z.RESULT && length != 0) {
            O1(z1.e.r(str.charAt(0)));
        }
        char cCharAt = z1.e.D(",").charAt(0);
        int iIndexOf = 0;
        boolean z3 = false;
        while (iIndexOf < length) {
            char cCharAt2 = str.charAt(iIndexOf);
            if (!Character.isSpaceChar(cCharAt2) && cCharAt2 != cCharAt) {
                int iR = z1.e.r(cCharAt2);
                if (!z2) {
                    if (!z3 || iIndexOf == (iQ0 = com.vivo.calculator.b.Q0(str, iIndexOf, false))) {
                        boolean z4 = z1.e.d(iR) != 10;
                        if (iIndexOf == 0 && ((z4 || iR == R.id.dec_point) && this.f3567t0.e(0L).K0())) {
                            e0(R.id.op_mul);
                        }
                        z3 = z4 || (z3 && iR == R.id.dec_point);
                    } else {
                        this.f3567t0.K(str, iIndexOf, iQ0);
                        z3 = false;
                        iIndexOf = iQ0;
                    }
                }
                if (iR != -1) {
                    if (z2) {
                        d0(iR);
                    } else {
                        e0(iR);
                    }
                    if (Character.isSurrogate(cCharAt2)) {
                        iIndexOf += 2;
                    }
                } else {
                    int iG = z1.e.g(str, iIndexOf);
                    if (iG == -1) {
                        this.f3576w0 = str.substring(iIndexOf);
                        i1();
                        return;
                    }
                    if (z2) {
                        d0(iG);
                    } else {
                        e0(iG);
                    }
                    if (iG == R.id.op_sqrt) {
                        VLog.d("BBKCalculator/Calculator", "addChars: ");
                        e0(R.id.lparen);
                    }
                    iIndexOf = str.indexOf(40, iIndexOf) + 1;
                }
            }
            iIndexOf++;
        }
        this.f3576w0 = null;
        i1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(boolean z2) {
        VLog.d("BBKCalculator/Calculator", "onModeChanged degreeMode = " + z2);
        if (this.B0 == null) {
            return;
        }
        if (z2) {
            if (isInMultiWindowMode()) {
                this.B0.setImageResource(R.drawable.rad_mul);
            } else {
                this.B0.setImageResource(R.drawable.rad);
            }
            TextView textView = this.A0;
            if (textView != null) {
                textView.setText(this.B1);
            }
            this.B0.setContentDescription(this.f3512b.getString(R.string.description_deg));
            return;
        }
        if (isInMultiWindowMode()) {
            this.B0.setImageResource(R.drawable.deg_mul);
        } else {
            this.B0.setImageResource(R.drawable.deg);
        }
        TextView textView2 = this.A0;
        if (textView2 != null) {
            textView2.setText(this.A1);
        }
        this.B0.setContentDescription(this.f3512b.getString(R.string.description_rad));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        VLog.d("BBKCalculator/Calculator", "addExplicitKeyToExpr:  insertProcess  " + this.f3570u0);
        if (this.f3570u0 == z.MEMORY && !z1.e.l(i3) && (!z1.e.p(i3) || z1.e.m(i3))) {
            this.f3567t0.l0();
        }
        e0(i3);
    }

    private void e0(int i3) {
        VLog.d("BBKCalculator/Calculator", "addKeyToExpr: mCurrentState == " + this.f3570u0);
        z zVar = this.f3570u0;
        if (zVar == z.ERROR) {
            J1(z.INPUT);
        } else {
            if (zVar == z.RESULT || zVar == z.INIT_FOR_RESULT) {
                P1(i3, this.f3561r0.getSelectionStart() < this.f3561r0.getText().length());
            } else if (i3 == R.id.positive_and_negative && this.f3514b1) {
                this.f3514b1 = false;
            }
        }
        this.f3567t0.W(i3, this.f3561r0.isCursorVisible() ? this.f3561r0.getSelectionStart() : this.f3561r0.getText().length(), this.f3561r0);
        if (this.f3561r0.isCursorVisible()) {
            return;
        }
        this.f3561r0.setCursorVisible(true);
        CalculatorFormula calculatorFormula = this.f3561r0;
        calculatorFormula.setSelection(calculatorFormula.getText().length());
    }

    private void e1(boolean z2, boolean z3) {
        String str;
        float minimumTextSize = this.f3561r0.getMinimumTextSize();
        if (!this.f3564s0.n()) {
            minimumTextSize = this.f3561r0.c(this.f3564s0.getTextString());
        }
        float textSize = minimumTextSize / this.f3564s0.getTextSize();
        CalculatorResult calculatorResult = this.f3564s0;
        calculatorResult.setPivotX(calculatorResult.getWidth() - this.f3564s0.getPaddingRight());
        CalculatorResult calculatorResult2 = this.f3564s0;
        calculatorResult2.setPivotY(calculatorResult2.getHeight() - this.f3564s0.getPaddingBottom());
        int currentTextColor = this.f3561r0.getCurrentTextColor();
        if (z3) {
            this.f3567t0.I1();
        } else {
            this.f3567t0.F1(0L, true);
            String string = this.f3561r0.getText().toString();
            String textString = this.f3564s0.getTextString();
            if (g2.b.r(string)) {
                string = g2.b.g(string);
            }
            if (textString != null && !textString.equals(string)) {
                HashMap map = new HashMap();
                Boolean boolValueOf = Boolean.valueOf(N0(this.f3561r0.getTextString()));
                VLog.d("BBKCalculator/Calculator", "mIsTrigonometricExit=" + boolValueOf);
                boolean zB = this.f3567t0.b(0L);
                if (boolValueOf.booleanValue()) {
                    str = zB ? "Deg" : "Rad";
                } else {
                    str = BuildConfig.FLAVOR;
                }
                map.put("degrad", str);
                map.put("history", g2.b.d(L0(string)));
                map.put("result", g2.b.d(textString));
                map.put("datetime", g2.c.a(System.currentTimeMillis()));
                HistoryLayout historyLayout = this.G0;
                if (historyLayout != null) {
                    historyLayout.Z(map);
                } else {
                    HistoryLayout historyLayout2 = this.H0;
                    if (historyLayout2 != null) {
                        historyLayout2.Z(map);
                    }
                }
            }
        }
        if (z2) {
            this.f3564s0.announceForAccessibility(getResources().getString(R.string.description_equal));
            CalculatorResult calculatorResult3 = this.f3564s0;
            calculatorResult3.announceForAccessibility(calculatorResult3.getText());
            v1();
            return;
        }
        this.f3564s0.setScaleX(textSize);
        this.f3564s0.setScaleY(textSize);
        this.f3564s0.setTextColor(currentTextColor);
        J1(z.RESULT);
    }

    private List<Animator> f0(View view, View view2) {
        ObjectAnimator objectAnimatorC = g2.a.c(view, 1.0f, 0.9f, 467L, g2.a.b(0.25f, 0.45f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorD = g2.a.d(view, 1.0f, 0.9f, 467L, g2.a.b(0.25f, 0.45f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorC2 = g2.a.c(view2, 1.1f, 1.0f, 467L, g2.a.b(0.25f, 0.45f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorD2 = g2.a.d(view2, 1.1f, 1.0f, 467L, g2.a.b(0.25f, 0.45f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorA = g2.a.a(view, 1.0f, 0.0f, 300L, g2.a.b(0.33f, 0.0f, 0.35f, 1.0f));
        ObjectAnimator objectAnimatorA2 = g2.a.a(view2, 0.0f, 1.0f, 300L, g2.a.b(0.33f, 0.0f, 0.67f, 1.0f));
        ArrayList arrayList = new ArrayList();
        arrayList.add(objectAnimatorC);
        arrayList.add(objectAnimatorD);
        arrayList.add(objectAnimatorC2);
        arrayList.add(objectAnimatorD2);
        arrayList.add(objectAnimatorA);
        arrayList.add(objectAnimatorA2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        VLog.d("BBKCalculator/Calculator", "openMultiWindow: ");
        h2.b.b("A790|10009", null);
        ComponentName componentName = new ComponentName("com.vivo.calculator", "com.vivo.calculator.Calculator");
        Bundle bundle = new Bundle();
        bundle.putString("source_package_name", "com.vivo.calculator");
        bundle.putParcelable("component_name", componentName);
        bundle.putInt("mirror_type", 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.vivo.smartmultiwindow", "com.vivo.smartmultiwindow.services.ManagerStateService"));
        intent.putExtras(bundle);
        this.f3512b.getApplicationContext().startService(intent);
    }

    private void h0() {
        this.f3564s0.announceForAccessibility(getResources().getString(R.string.cleared));
    }

    private void h1() {
        boolean zZ0 = z0();
        boolean z2 = this.f3515c.getBoolean("preferences_button_tone", false);
        StringBuilder sb = new StringBuilder();
        sb.append("should load rhythm: ");
        sb.append(z2);
        sb.append(!zZ0);
        VLog.d("BBKCalculator/Calculator", sb.toString());
        if (!z2) {
            m1();
        } else {
            if (zZ0) {
                return;
            }
            m1();
            f2.a aVar = new f2.a();
            this.f3556p1 = aVar;
            aVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        VLog.d("BBKCalculator/Calculator", "redisplayAfterFormulaChange: ");
        j1();
        J1(z.INPUT);
        if (g2.b.q(this.f3561r0.getTextString().replace(",", BuildConfig.FLAVOR))) {
            this.f3564s0.c();
        }
        if (this.f3561r0.getTextString().isEmpty()) {
            W0();
        } else if (A0()) {
            this.f3567t0.g2();
        } else {
            q0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j0(boolean z2) {
        if (this.f3570u0 != z.EVALUATE) {
            return false;
        }
        this.f3567t0.f0(0L, z2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        if (this.f3570u0 == z.INPUT) {
            this.f3567t0.f0(0L, true);
        }
    }

    private void k1() {
        if (this.V0 == null) {
            this.V0 = new a0(this, null);
            registerReceiver(this.V0, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        }
    }

    private void l0(String str, String str2, String str3, String str4, String str5) {
        int color = getColor(r0("calculator_background", str4, "color"));
        View view = this.f3536j;
        if (view != null) {
            view.setBackgroundColor(color);
        }
        View view2 = this.f3539k;
        if (view2 != null) {
            view2.setBackgroundColor(color);
        }
        LinearLayout linearLayout = this.f3545m;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(color);
        }
        LinearLayout linearLayout2 = this.f3542l;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundColor(color);
        }
        LinearLayout linearLayout3 = this.f3548n;
        if (linearLayout3 != null) {
            linearLayout3.setBackgroundResource(r0("history_list_bg", str4, "drawable"));
        }
        Button button = this.f3551o;
        if (button != null) {
            button.setBackgroundResource(r0("clear_history_selector", str4, "drawable"));
            this.f3551o.setTextColor(getColor(r0("clear_history_text_color", str4, "color")));
        }
        this.f3561r0.setTextCursorDrawable(getDrawable(R.drawable.my_cursor_material));
        this.f3561r0.setHighlightColor(getColor(r0("bt_special_button_background", str4, "color")));
        this.f3561r0.setTextSelectHandle(getDrawable(r0("vg_text_select_handle_middle", str4, "drawable")));
        this.f3561r0.setTextColor(getColor(r0("edit_text_color", str4, "color")));
        this.f3564s0.setTextColor(getColor(r0("result_text_color", str4, "color")));
        this.f3564s0.setHighlightColor(getColor(r0("bt_special_button_background", str4, "color")));
        TextView textView = this.A0;
        if (textView != null) {
            textView.setTextColor(getColor(r0("result_text_color", str4, "color")));
        }
        ColorButton colorButton = this.C0;
        if (colorButton != null) {
            colorButton.setImageResource(r0("del_select", str4, "drawable"));
        }
        if (BuildConfig.FLAVOR.equals(str)) {
            if (!"_land".equals(str2)) {
                if (g2.b.o(this)) {
                    this.J.setImageResource(r0("equal_bg_selector_nex", str4, "drawable"));
                } else {
                    this.J.setImageResource(r0("equal_bg_selector", str4, "drawable"));
                }
                this.J.setScaleType(ImageView.ScaleType.FIT_XY);
            } else if (g2.b.o(this)) {
                this.J.setBackgroundResource(r0("equal_bg_selector_land", str4, "drawable"));
            } else {
                this.J.setBackgroundResource(r0("equal_bg_selector", str4, "drawable"));
            }
        } else if ("_land".equals(str2)) {
            this.J.setBackgroundResource(r0("equal_bg_selector", "_mul" + str4, "drawable"));
        } else {
            this.J.setImageResource(r0("equal_bg_selector", "_mul" + str4, "drawable"));
        }
        Drawable drawableD = u.a.d(this.f3512b, R.drawable.exchange_denghao_bg_nex_material);
        Drawable drawableD2 = u.a.d(this.f3512b, R.drawable.exchange_denghao_bg_nex_material);
        if (drawableD2 != null) {
            Drawable drawableR = x.a.r(drawableD2);
            x.a.n(drawableR, g2.b.h(0.8f, getColor(R.color.function_text_blue_stroke_color_material)));
            drawableD = g2.b.l(u.a.d(this.f3512b, R.drawable.exchange_denghao_bg_nex_material), drawableR);
        }
        if (getResources().getConfiguration().orientation == 2 && (!g2.b.o(this) || isInMultiWindowMode())) {
            this.J.setBackground(drawableD);
        }
        int iR0 = "_mul".equals(str) ? r0("colorspecialbutton_select", str2 + str + str4, "drawable") : r0("colorspecialbutton_select", str2 + str3 + str4, "drawable");
        int iR1 = "_mul".equals(str) ? r0("colornumber_select", str2 + str + str4, "drawable") : r0("colornumber_select", str2 + str3 + str4, "drawable");
        ColorButton[] colorButtonArr = {this.f3566t, this.f3554p, this.f3557q, this.f3560r, this.f3563s, this.f3569u, this.f3572v, this.K, this.L, this.M, this.D, this.E, this.F, this.A, this.B, this.C, this.f3578x, this.f3581y, this.f3584z, this.G, this.f3575w, this.H, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.U, this.V, this.W, this.X, this.Y, this.f3528g0, this.Z, this.f3531h0, this.f3510a0, this.f3534i0, this.f3513b0, this.f3537j0, this.f3516c0, this.f3540k0, this.f3519d0, this.f3543l0, this.f3522e0, this.f3546m0, this.f3525f0, this.f3549n0, this.B0, this.f3552o0, this.f3555p0, this.f3558q0};
        String[] strArr = {"ac", "clear", "a_and_m", "chuhao", "chenghao", "minus", "plus", "mc", "madd", "mminus", "digit7", "digit8", "digit9", "digit4", "digit5", "digit6", "digit1", "digit2", "digit3", "percent", "digit0", "dot", "left", "right", "ten_x", "countdown", "x2", "x3", "ic_xy", "factorial", "genhao", "ic_xgenhaoy", "lg", "sin", "sin_1", "cos", "cos_1", "tan", "tan_1", "ln", "log2", "sinh", "sinh_1", "cosh", "cosh_1", "tanh", "tanh_1", "ex", "tx", "deg", "pi", "ee", "rand"};
        String[] strArr2 = {"ac_land", "clear_land", "a_and_m_land", "chuhao_land", "chenghao_land", "minus_land", "plus_land", "mc", "madd", "mminus", "digit7_land", "digit8_land", "digit9_land", "digit4_land", "digit5_land", "digit6_land", "digit1_land", "digit2_land", "digit3_land", "percent_land", "digit0_land", "dot_land", "left", "right", "ten_x", "countdown", "x2", "x3", "ic_xy", "factorial", "genhao", "ic_xgenhaoy", "lg", "sin", "sin_1", "cos", "cos_1", "tan", "tan_1", "ln", "log2", "sinh", "sinh_1", "cosh", "cosh_1", "tanh", "tanh_1", "ex", "tx", "deg", "pi", "ee", "rand"};
        for (int i3 = 0; i3 < 53; i3++) {
            if (colorButtonArr[i3] != null) {
                if (colorButtonArr[i3] != this.H || ".".equals(g2.b.f4762c)) {
                    if (!(g2.b.o(this) && this.X0) && (g2.b.o(this) || getResources().getConfiguration().orientation != 2 || isInMultiWindowMode())) {
                        colorButtonArr[i3].setImageResource(r0(strArr[i3], str + str4, "drawable"));
                    } else {
                        colorButtonArr[i3].setImageResource(r0(strArr2[i3], str4, "drawable"));
                    }
                } else if ("_mul_select".equals(str)) {
                    colorButtonArr[i3].setImageResource(R.drawable.comma_mul_material);
                } else if (g2.b.o(this) && this.X0) {
                    colorButtonArr[i3].setImageResource(R.drawable.comma_land_material);
                } else {
                    colorButtonArr[i3].setImageResource(R.drawable.comma_material);
                }
                if (i3 < 7) {
                    if ("_mul_select".equals(str)) {
                        colorButtonArr[i3].setBackground(null);
                    } else {
                        colorButtonArr[i3].setBackgroundResource(iR0);
                    }
                } else if ("_mul_select".equals(str)) {
                    colorButtonArr[i3].setBackground(null);
                } else {
                    colorButtonArr[i3].setBackgroundResource(iR1);
                }
            }
        }
        ColorSelectButton colorSelectButton = this.f3585z0;
        if (colorSelectButton != null) {
            colorSelectButton.setImageResource(r0("tnd_normal", str + str4, "drawable"));
            this.f3585z0.setBackgroundResource(iR1);
        }
        ColorSelectButton colorSelectButton2 = this.C1;
        if (colorSelectButton2 != null) {
            colorSelectButton2.setImageResource(r0("mr", str + str4, "drawable"));
            this.C1.setBackgroundResource(iR1);
        }
    }

    private void l1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(this.f3511a1, intentFilter);
    }

    private SpannableString m0(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        SpannableString spannableString = new SpannableString(str);
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 + 3;
            if (i4 <= length && i3 != 0 && (str.charAt(i3) == 'n' || str.charAt(i3) == 's' || str.charAt(i3) == 'h')) {
                int i5 = i3 + 1;
                if (str.charAt(i5) == '-') {
                    spannableString.setSpan(new SuperscriptSpan(), i5, i4, 33);
                    spannableString.setSpan(new RelativeSizeSpan(0.5f), i5, i4, 33);
                }
            }
        }
        return spannableString;
    }

    private void m1() {
        f2.a aVar = this.f3556p1;
        if (aVar != null) {
            aVar.n();
            this.f3556p1 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (this.f3570u0 == z.RESULT) {
            J1(z.INPUT);
            this.f3567t0.o0();
        }
    }

    private void n1() {
        String string = this.f3515c.getString("preferences_report_day", BuildConfig.FLAVOR);
        String strI = g2.b.i();
        VLog.d("BBKCalculator/Calculator", "reportStatusIfNeeded,lastReportDay:" + string + ",currentReportDay:" + strI);
        if (TextUtils.equals(string, strI)) {
            return;
        }
        h2.a.a().d(this.f3515c.getBoolean("preferences_button_tone", false));
        this.f3515c.edit().putString("preferences_report_day", strI).commit();
    }

    private void o0(int i3) {
        if (!isInMultiWindowMode() && Settings.System.getInt(this.f3512b.getContentResolver(), "accelerometer_rotation", 0) == 1 && BBKCalculatorApplication.i()) {
            this.f3520d1.postDelayed(this.f3550n1, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(int i3) {
        switch (i3) {
            case R.id.EE /* 2131230724 */:
                h2.a.a().f(50);
                break;
            case R.id.countDown /* 2131230864 */:
                h2.a.a().f(30);
                break;
            case R.id.dec_point /* 2131230876 */:
                h2.a.a().f(66);
                break;
            case R.id.lparen /* 2131231069 */:
                h2.a.a().f(57);
                break;
            case R.id.positive_and_negative /* 2131231207 */:
                h2.a.a().f(28);
                break;
            case R.id.rand /* 2131231219 */:
                h2.a.a().f(60);
                break;
            case R.id.rparen /* 2131231236 */:
                h2.a.a().f(56);
                break;
            default:
                switch (i3) {
                    case R.id.const_pi /* 2131230856 */:
                        h2.a.a().f(39);
                        break;
                    case R.id.const_x /* 2131230857 */:
                        h2.a.a().f(31);
                        break;
                    default:
                        switch (i3) {
                            case R.id.fun_10pow /* 2131230977 */:
                                h2.a.a().f(61);
                                break;
                            case R.id.fun_arccos /* 2131230978 */:
                                h2.a.a().f(43);
                                break;
                            case R.id.fun_arccosh /* 2131230979 */:
                                h2.a.a().f(33);
                                break;
                            case R.id.fun_arcsin /* 2131230980 */:
                                h2.a.a().f(44);
                                break;
                            case R.id.fun_arcsinh /* 2131230981 */:
                                h2.a.a().f(34);
                                break;
                            case R.id.fun_arctan /* 2131230982 */:
                                h2.a.a().f(42);
                                break;
                            case R.id.fun_arctanh /* 2131230983 */:
                                h2.a.a().f(32);
                                break;
                            case R.id.fun_cos /* 2131230984 */:
                                h2.a.a().f(47);
                                break;
                            case R.id.fun_cosh /* 2131230985 */:
                                h2.a.a().f(37);
                                break;
                            case R.id.fun_exp /* 2131230986 */:
                                h2.a.a().f(35);
                                break;
                            case R.id.fun_lg /* 2131230987 */:
                                h2.a.a().f(40);
                                break;
                            case R.id.fun_ln /* 2131230988 */:
                                h2.a.a().f(45);
                                break;
                            case R.id.fun_log /* 2131230989 */:
                                h2.a.a().f(41);
                                break;
                            case R.id.fun_sin /* 2131230990 */:
                                h2.a.a().f(48);
                                break;
                            case R.id.fun_sinh /* 2131230991 */:
                                h2.a.a().f(38);
                                break;
                            case R.id.fun_tan /* 2131230992 */:
                                h2.a.a().f(46);
                                break;
                            case R.id.fun_tanh /* 2131230993 */:
                                h2.a.a().f(36);
                                break;
                            default:
                                switch (i3) {
                                    case R.id.op_add /* 2131231170 */:
                                        h2.a.a().f(62);
                                        break;
                                    case R.id.op_div /* 2131231171 */:
                                        h2.a.a().f(64);
                                        break;
                                    case R.id.op_fact /* 2131231172 */:
                                        h2.a.a().f(49);
                                        break;
                                    case R.id.op_mul /* 2131231173 */:
                                        h2.a.a().f(63);
                                        break;
                                    case R.id.op_pct /* 2131231174 */:
                                        h2.a.a().f(4);
                                        break;
                                    default:
                                        switch (i3) {
                                            case R.id.op_sqr /* 2131231176 */:
                                                h2.a.a().f(55);
                                                break;
                                            case R.id.op_sqrs /* 2131231177 */:
                                                h2.a.a().f(54);
                                                break;
                                            case R.id.op_sqrt /* 2131231178 */:
                                                h2.a.a().f(53);
                                                break;
                                            case R.id.op_sub /* 2131231179 */:
                                                h2.a.a().f(65);
                                                break;
                                            default:
                                                switch (i3) {
                                                    case R.id.xgenhaoy /* 2131231387 */:
                                                        h2.a.a().f(51);
                                                        break;
                                                    case R.id.yx /* 2131231388 */:
                                                        h2.a.a().f(52);
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    private void p0() {
        if (this.f3561r0.getSelectionStart() <= 0) {
            return;
        }
        int iF1 = z.RESULT == this.f3570u0 ? this.f3567t0.f1(this.f3561r0.getTextString().length()) : this.f3567t0.f1(this.f3561r0.getSelectionStart());
        int length = this.f3561r0.getTextString().length();
        String strA0 = this.f3567t0.A0(this.f3561r0.getSelectionStart());
        String strValueOf = String.valueOf(z1.e.i());
        if (".".equals(strValueOf)) {
            strValueOf = "\\.";
        }
        if (TextUtils.isEmpty(strA0)) {
            return;
        }
        j1();
        CalculatorFormula calculatorFormula = this.f3561r0;
        calculatorFormula.f(iF1, calculatorFormula.length());
        String strReplaceAll = strA0.replaceAll(strValueOf, BuildConfig.FLAVOR);
        if (this.f3567t0.e0(strReplaceAll)) {
            int length2 = strReplaceAll.length();
            for (int i3 = 0; i3 < length2; i3++) {
                this.f3567t0.W(z1.e.B(this.f3512b, String.valueOf(strReplaceAll.charAt(i3))), this.f3561r0.getSelectionStart(), this.f3561r0);
                j1();
            }
            if (length == this.f3567t0.e(0L).m1(this.f3512b).length()) {
                iF1++;
            }
            this.f3561r0.a(this.f3567t0.e(0L).m1(this.f3512b));
            i1();
            CalculatorFormula calculatorFormula2 = this.f3561r0;
            calculatorFormula2.f(iF1, calculatorFormula2.length());
        }
    }

    private void q1() {
        this.f3514b1 = this.f3515c.getBoolean("result_state", false);
        z zVar = this.f3570u0;
        if (zVar == z.RESULT || zVar == z.INIT_FOR_RESULT) {
            V0();
            if (this.f3515c.getBoolean("hasMessage", false)) {
                this.f3514b1 = true;
                M0(this.f3515c.getString("result", null), false);
            }
            J1(S0(this.f3570u0));
            this.f3564s0.t(0, this);
        } else {
            if (!this.f3515c.getBoolean("hasMessage", false)) {
                this.f3567t0.o0();
                this.f3570u0 = z.INPUT;
            }
            j1();
            z zVar2 = this.f3570u0;
            if (zVar2 == z.INPUT) {
                this.f3564s0.t(1, this);
            } else {
                J1(S0(zVar2));
                this.f3564s0.t(2, this);
            }
        }
        if (TextUtils.isEmpty(this.f3561r0.getTextString()) && !this.f3515c.getBoolean("IS_CALCULATOR_UPDATE", false)) {
            V0();
            boolean z2 = this.f3515c.getBoolean("radflag", false);
            boolean z3 = this.f3515c.getBoolean("positivefuncflag", true);
            a1(!z3);
            this.f3518d.putBoolean("Calculator_inverse_mode", !z3);
            this.f3567t0.V1(!z2);
            c1(!z2);
            if (this.f3515c.getBoolean("euqalflag", false)) {
                VLog.d("BBKCalculator/Calculator", "restoreDisplay: result ==  " + this.f3515c.getString("result", BuildConfig.FLAVOR));
                M0(this.f3515c.getString("result", null), false);
                J1(z.INPUT);
            } else {
                VLog.d("BBKCalculator/Calculator", "restoreDisplay: editStr == " + this.f3515c.getString("editStr", BuildConfig.FLAVOR));
                M0(this.f3515c.getString("editStr", null), false);
            }
            if (!this.f3515c.getBoolean("IS_CALCULATOR_UPDATE", false) && !this.f3515c.getBoolean("euqalflag", false)) {
                this.f3518d.putBoolean("IS_CALCULATOR_UPDATE", true);
                this.f3518d.commit();
            }
            if (!TextUtils.isEmpty(this.f3515c.getString("mcmrResult", BuildConfig.FLAVOR))) {
                this.f3564s0.q();
                E1(true);
            }
        }
        O0(this.f3561r0.getTextString());
    }

    private int r0(String str, String str2, String str3) {
        return getResources().getIdentifier(str + str2, str3, getPackageName());
    }

    private void r1() {
        this.f3564s0.setScaleX(1.0f);
        this.f3564s0.setScaleY(1.0f);
        this.f3564s0.setTranslationX(0.0f);
        this.f3564s0.setTranslationY(0.0f);
        if (g2.b.t(this.f3512b)) {
            this.f3561r0.clearFocus();
        } else {
            this.f3561r0.requestFocus();
        }
    }

    private void s1() {
        this.f3518d.putBoolean("ScreenAsPad", !g2.b.o(this.f3512b));
        androidx.appcompat.app.a aVar = this.Q0;
        if (aVar == null || !aVar.isShowing()) {
            this.f3518d.putBoolean("DIALOG_SHOW", false);
        } else {
            this.f3518d.putBoolean("DIALOG_SHOW", true);
        }
        this.f3518d.commit();
    }

    private float t0() {
        return O1 - P1;
    }

    private void t1(boolean z2) {
        if (z2) {
            this.f3518d.putBoolean("ERROR_STATE", true);
        } else {
            this.f3518d.putBoolean("ERROR_STATE", false);
        }
        this.f3518d.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        VLog.d("BBKCalculator/Calculator", "setCalLayoutPadding:");
        if (!isInMultiWindowMode() || H1 || Build.VERSION.SDK_INT <= 30 || this.f3536j == null) {
            return;
        }
        g2.b.A(this, this.f3536j, getWindowManager().getDefaultDisplay().getRotation(), getWindowManager().getDefaultDisplay().getCutout(), false);
    }

    private void y1(boolean z2) {
        VLog.d("BBKCalculator/Calculator", "setErrorState,mCurrentState:" + this.f3570u0 + ",state:" + z2);
        this.f3573v0 = z2;
        if (z2) {
            z zVar = this.f3570u0;
            if (zVar == z.ERROR || zVar == z.INIT) {
                this.f3564s0.setVisibility(0);
            }
        }
    }

    private void z1() {
        if (g2.b.t(this)) {
            ImageButton imageButton = this.S0;
            if (imageButton != null) {
                imageButton.setImportantForAccessibility(2);
                return;
            }
            return;
        }
        ImageButton imageButton2 = this.S0;
        if (imageButton2 != null) {
            imageButton2.setImportantForAccessibility(1);
        }
    }

    public void A1() {
        if (P0()) {
            HistoryLayout historyLayout = this.H0;
            if (historyLayout == null) {
                this.f3559q1 = false;
                return;
            } else {
                this.f3559q1 = historyLayout.getHistoryListOpen();
                return;
            }
        }
        HistoryLayout historyLayout2 = this.G0;
        if (historyLayout2 == null) {
            this.f3559q1 = false;
        } else {
            this.f3559q1 = historyLayout2.getHistoryListOpen();
        }
    }

    public void C1() {
        setRequestedOrientation(0);
    }

    public void E0() {
        J1(z.values()[this.f3515c.getInt("Calculator_display_state", z.INPUT.ordinal())]);
        String string = this.f3515c.getString("Calculator_unprocessed_chars", null);
        if (string != null) {
            this.f3576w0 = string.toString();
        }
        if (this.f3570u0 != z.RESULT) {
            this.f3567t0.m();
        }
        a1(this.f3515c.getBoolean("Calculator_inverse_mode", false));
    }

    public void H1() {
        setRequestedOrientation(1);
    }

    public void K0(String str) {
        String str2;
        String str3;
        int i3;
        int i4;
        int i5;
        String str4;
        VLog.d("BBKCalculator/Calculator", "insertClipProcess: start process = " + str);
        if (TextUtils.isEmpty(str) || this.f3561r0 == null) {
            return;
        }
        String str5 = ",";
        String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
        int selectionStart = this.f3561r0.getSelectionStart();
        int selectionEnd = this.f3561r0.getSelectionEnd();
        SpannableStringBuilder spannableStringBuilderM1 = this.f3567t0.e(0L).m1(this.f3512b);
        if (selectionStart != selectionEnd || this.f3570u0 == z.RESULT || spannableStringBuilderM1 == null) {
            V0();
        } else {
            String string = spannableStringBuilderM1.toString();
            if (!TextUtils.isEmpty(string)) {
                boolean zContains = strReplaceAll.contains(".");
                if (selectionStart > string.length()) {
                    selectionStart = string.length();
                } else if (selectionStart < 0) {
                    selectionStart = 0;
                }
                String strSubstring = string.substring(0, selectionStart);
                String strSubstring2 = string.substring(selectionStart);
                if (!g2.h.b(strSubstring2)) {
                    int i6 = selectionStart;
                    while (i6 < string.length()) {
                        int i7 = i6 + 1;
                        if (!g2.h.b(string.substring(i6, i7)) && !",".equals(string.substring(i6, i7))) {
                            break;
                        }
                        strSubstring2 = string.substring(selectionStart, i6);
                        i6 = i7;
                    }
                }
                if (!g2.h.b(strSubstring)) {
                    for (int i8 = selectionStart; i8 > 0; i8--) {
                        int i9 = i8 - 1;
                        if (!g2.h.b(string.substring(i9, i8)) && !",".equals(string.substring(i9, i8))) {
                            break;
                        }
                        strSubstring = string.substring(i9, selectionStart);
                    }
                }
                VLog.d("BBKCalculator/Calculator", "insertClipProcess:    startString end  = " + strSubstring2);
                VLog.d("BBKCalculator/Calculator", "insertClipProcess:    endString end  = " + strSubstring);
                if (zContains && ((g2.h.b(string) && string.contains(".")) || ((g2.h.b(strSubstring2) && strSubstring2.contains(".")) || (g2.h.b(strSubstring) && strSubstring.contains("."))))) {
                    VLog.d("BBKCalculator/Calculator", "insertClipProcess:contains(.)  invalid return");
                    g2.b.B(this, R.string.invalid_clip_data);
                    return;
                }
            }
        }
        VLog.d("BBKCalculator/Calculator", "insertClipProcess: process ing  ==   " + strReplaceAll);
        ArrayList<InsertEntry> arrayList = new ArrayList();
        String string2 = BuildConfig.FLAVOR;
        int i10 = 0;
        while (i10 < strReplaceAll.length()) {
            int i11 = i10 + 1;
            String strSubstring3 = strReplaceAll.substring(i10, i11);
            int iB = z1.e.B(this.f3512b, strSubstring3);
            if (-1 == iB) {
                VLog.d("BBKCalculator/Calculator", "insertClipProcess char " + strSubstring3 + "have no id and str == " + string2);
                StringBuilder sb = new StringBuilder();
                sb.append(string2);
                sb.append(BuildConfig.FLAVOR);
                sb.append(strSubstring3);
                string2 = sb.toString();
                if (TextUtils.isEmpty(string2)) {
                    str3 = str5;
                } else if (N0(string2) && strReplaceAll.length() >= (i5 = i10 + 2) && "h".equalsIgnoreCase(strReplaceAll.substring(i11, i5))) {
                    int i12 = i10 + 4;
                    if (strReplaceAll.length() >= i12) {
                        int i13 = i10 + 3;
                        str3 = str5;
                        if ("-".equals(strReplaceAll.substring(i5, i13)) || "−".equals(strReplaceAll.substring(i5, i13))) {
                            int i14 = i10 + 5;
                            if (strReplaceAll.length() < i14 || !"-1(".equals(strReplaceAll.substring(i5, i14))) {
                                g2.b.B(this, R.string.invalid_clip_data);
                                return;
                            }
                            str4 = string2 + strReplaceAll.substring(i11, i12);
                            i10 = i11 + 1;
                        }
                        arrayList.add(new InsertEntry(str4, z1.e.B(this.f3512b, str4), true));
                        i10 = i10 + 1 + 1;
                        string2 = BuildConfig.FLAVOR;
                        i3 = 1;
                    } else {
                        str3 = str5;
                    }
                    int i15 = i10 + 3;
                    if (strReplaceAll.length() < i15 || !"(".equals(strReplaceAll.substring(i5, i15))) {
                        g2.b.B(this, R.string.invalid_clip_data);
                        return;
                    }
                    str4 = string2 + strReplaceAll.substring(i11, i5);
                    arrayList.add(new InsertEntry(str4, z1.e.B(this.f3512b, str4), true));
                    i10 = i10 + 1 + 1;
                    string2 = BuildConfig.FLAVOR;
                    i3 = 1;
                } else {
                    str3 = str5;
                    if (N0(string2) && strReplaceAll.length() >= (i4 = i10 + 3)) {
                        int i16 = i10 + 2;
                        if ("-".equals(strReplaceAll.substring(i11, i16)) || "−".equals(strReplaceAll.substring(i11, i16))) {
                            int i17 = i10 + 4;
                            if (strReplaceAll.length() < i17 || !"-1(".equals(strReplaceAll.substring(i11, i17))) {
                                g2.b.B(this, R.string.invalid_clip_data);
                                return;
                            }
                            String str6 = string2 + strReplaceAll.substring(i11, i4);
                            arrayList.add(new InsertEntry(str6, z1.e.B(this.f3512b, str6), true));
                            i10 = i11 + 1 + 1;
                            string2 = BuildConfig.FLAVOR;
                            i3 = 1;
                        }
                    }
                    if (N0(string2)) {
                        int i18 = i10 + 2;
                        if (strReplaceAll.length() < i18 || !"(".equals(strReplaceAll.substring(i11, i18))) {
                            g2.b.B(this, R.string.invalid_clip_data);
                            return;
                        }
                        arrayList.add(new InsertEntry(string2, z1.e.B(this.f3512b, string2), true));
                    } else {
                        if ("log".equals(string2)) {
                            int i19 = i10 + 3;
                            if (strReplaceAll.length() < i19 || !"2(".equals(strReplaceAll.substring(i11, i19))) {
                                g2.b.B(this, R.string.invalid_clip_data);
                                return;
                            } else {
                                arrayList.add(new InsertEntry(string2, z1.e.B(this.f3512b, string2), true));
                                i10 = i11 + 1;
                            }
                        } else if ("lg".equals(string2) || "ln".equals(string2)) {
                            int i20 = i10 + 2;
                            if (strReplaceAll.length() < i20 || !"(".equals(strReplaceAll.substring(i11, i20))) {
                                g2.b.B(this, R.string.invalid_clip_data);
                                return;
                            }
                            arrayList.add(new InsertEntry(string2, z1.e.B(this.f3512b, string2), true));
                        } else if ("e".equals(string2)) {
                            int i21 = i10 + 2;
                            if (strReplaceAll.length() < i21 || !"^".equals(strReplaceAll.substring(i11, i21))) {
                                g2.b.B(this, R.string.invalid_clip_data);
                                return;
                            }
                            String str7 = string2 + strReplaceAll.substring(i11, i21);
                            arrayList.add(new InsertEntry(str7, z1.e.B(this.f3512b, str7), true));
                        } else if (-1 != z1.e.B(this.f3512b, string2)) {
                            arrayList.add(new InsertEntry(string2, z1.e.B(this.f3512b, string2), true));
                        } else {
                            VLog.d("BBKCalculator/Calculator", "insertClipProcess wait input  " + string2);
                        }
                        string2 = BuildConfig.FLAVOR;
                    }
                    string2 = BuildConfig.FLAVOR;
                    i10 = i11;
                }
                i3 = 1;
            } else {
                str3 = str5;
                VLog.d("BBKCalculator/Calculator", "insertClipProcess char " + strSubstring3 + "have id  and str == " + string2);
                if (!TextUtils.isEmpty(string2)) {
                    g2.b.B(this, R.string.invalid_clip_data);
                    return;
                } else {
                    if (!" ".equals(strSubstring3)) {
                        arrayList.add(new InsertEntry(strSubstring3, iB, false));
                    }
                    i3 = 1;
                }
            }
            i10 += i3;
            str5 = str3;
        }
        String str8 = str5;
        if (!TextUtils.isEmpty(string2)) {
            VLog.d("BBKCalculator/Calculator", "insertClipProcess invalid suffix " + string2);
            g2.b.B(this, R.string.invalid_clip_data);
            return;
        }
        VLog.d("BBKCalculator/Calculator", "insertClipProcess process start ");
        for (InsertEntry insertEntry : arrayList) {
            if (insertEntry.isExplicit()) {
                d0(insertEntry.getId());
            } else {
                g0(insertEntry.getId());
            }
            j1();
            J1(z.INPUT);
            if (this.f3561r0.getTextString().isEmpty()) {
                str2 = str8;
            } else {
                str2 = str8;
                if (g2.b.q(this.f3561r0.getTextString().replace(str2, BuildConfig.FLAVOR))) {
                }
                str8 = str2;
            }
            this.f3564s0.c();
            str8 = str2;
        }
        if (A0()) {
            this.f3567t0.g2();
        } else {
            q0();
        }
        D1(this.f3561r0.getTextString());
    }

    /* JADX WARN: Code duplicated, block: B:124:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:126:0x0317  */
    /* JADX WARN: Code duplicated, block: B:128:0x031d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0323  */
    /* JADX WARN: Code duplicated, block: B:132:0x0347  */
    /* JADX WARN: Code duplicated, block: B:142:0x0373  */
    /* JADX WARN: Code duplicated, block: B:145:0x039a  */
    /* JADX WARN: Code duplicated, block: B:147:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:149:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:163:0x03e4 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:124:0x02fd, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:142:0x0373, please report this as an issue */
    public void M0(String str, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        String str2;
        int i7;
        int i8;
        VLog.d("BBKCalculator/Calculator", "insertProcess: start process = " + str);
        if (TextUtils.isEmpty(str) || this.f3561r0 == null) {
            return;
        }
        String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
        int selectionStart = this.f3561r0.getSelectionStart();
        int selectionEnd = this.f3561r0.getSelectionEnd();
        SpannableStringBuilder spannableStringBuilderM1 = this.f3567t0.e(0L).m1(this.f3512b);
        int i9 = 0;
        if (selectionStart != selectionEnd || this.f3570u0 == z.RESULT || spannableStringBuilderM1 == null) {
            V0();
        } else {
            String string = spannableStringBuilderM1.toString();
            if (!TextUtils.isEmpty(string)) {
                boolean zContains = strReplaceAll.contains(".");
                if (selectionStart > string.length()) {
                    selectionStart = string.length();
                } else if (selectionStart < 0) {
                    selectionStart = 0;
                }
                String strSubstring = string.substring(0, selectionStart);
                String strSubstring2 = string.substring(selectionStart);
                if (!g2.h.b(strSubstring2)) {
                    int i10 = selectionStart;
                    while (i10 < string.length()) {
                        int i11 = i10 + 1;
                        if (!g2.h.b(string.substring(i10, i11)) && !",".equals(string.substring(i10, i11))) {
                            break;
                        }
                        strSubstring2 = string.substring(selectionStart, i10);
                        i10 = i11;
                    }
                }
                if (!g2.h.b(strSubstring)) {
                    for (int i12 = selectionStart; i12 > 0; i12--) {
                        int i13 = i12 - 1;
                        if (!g2.h.b(string.substring(i13, i12)) && !",".equals(string.substring(i13, i12))) {
                            break;
                        }
                        strSubstring = string.substring(i13, selectionStart);
                    }
                }
                VLog.d("BBKCalculator/Calculator", "insertProcess:    startString end  = " + strSubstring2);
                VLog.d("BBKCalculator/Calculator", "insertProcess:    endString end  = " + strSubstring);
                if (zContains && ((g2.h.b(string) && string.contains(".")) || ((g2.h.b(strSubstring2) && strSubstring2.contains(".")) || (g2.h.b(strSubstring) && strSubstring.contains("."))))) {
                    VLog.d("BBKCalculator/Calculator", "insertProcess:contains(.)  return");
                    return;
                }
            }
        }
        if (!this.f3514b1 && z2 && (strReplaceAll.indexOf(8722) >= 0 || strReplaceAll.indexOf(45) >= 0 || strReplaceAll.indexOf(69) >= 0)) {
            strReplaceAll = "(" + strReplaceAll + ")";
        }
        VLog.d("BBKCalculator/Calculator", "insertProcess: process ing  ==   " + strReplaceAll);
        String str3 = BuildConfig.FLAVOR;
        while (i9 < strReplaceAll.length()) {
            int i14 = i9 + 1;
            String strSubstring3 = strReplaceAll.substring(i9, i14);
            int iB = z1.e.B(this.f3512b, strSubstring3);
            if (-1 == iB || "x".equals(str3)) {
                str3 = str3 + BuildConfig.FLAVOR + strSubstring3;
                if (!TextUtils.isEmpty(str3)) {
                    if (i14 < strReplaceAll.length() && "(".equals(strReplaceAll.substring(i14, i9 + 2))) {
                        i9 = i14;
                    }
                    if (N0(str3) && strReplaceAll.length() >= (i6 = i9 + 2)) {
                        int i15 = i9 + 1;
                        if ("h".equalsIgnoreCase(strReplaceAll.substring(i15, i6))) {
                            int i16 = i9 + 4;
                            if (strReplaceAll.length() >= i16) {
                                int i17 = i9 + 3;
                                if ("-".equals(strReplaceAll.substring(i6, i17)) || "−".equals(strReplaceAll.substring(i6, i17))) {
                                    str2 = str3 + strReplaceAll.substring(i15, i16);
                                    i9 = i15 + 1;
                                } else {
                                    str2 = str3 + "h";
                                }
                            } else {
                                str2 = str3 + "h";
                            }
                            d0(z1.e.B(this.f3512b, str2));
                        } else if ("e".equals(str3)) {
                            if (N0(str3)) {
                                i4 = i9 + 1;
                                i5 = i9 + 2;
                                if (!"-".equals(strReplaceAll.substring(i4, i5))) {
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                    d0(z1.e.B(this.f3512b, str3 + strReplaceAll.substring(i4, i3)));
                                    str3 = BuildConfig.FLAVOR;
                                    i9 = i4;
                                }
                            }
                            if ("log".equals(str3)) {
                                d0(z1.e.B(this.f3512b, str3));
                            } else if (-1 != z1.e.B(this.f3512b, str3)) {
                                d0(z1.e.B(this.f3512b, str3));
                                str3 = BuildConfig.FLAVOR;
                            }
                        } else if (!TextUtils.isEmpty(str3)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            int i18 = i9 + 1;
                            sb.append(strReplaceAll.substring(i18, i9 + 2));
                            d0(z1.e.B(this.f3512b, sb.toString()));
                            i9 = i18;
                            str3 = BuildConfig.FLAVOR;
                        }
                        i9 = i9 + 1 + 1;
                        str3 = BuildConfig.FLAVOR;
                    } else if ("e".equals(str3)) {
                        if (N0(str3) && strReplaceAll.length() >= (i3 = i9 + 3)) {
                            i4 = i9 + 1;
                            i5 = i9 + 2;
                            if (!"-".equals(strReplaceAll.substring(i4, i5)) || "−".equals(strReplaceAll.substring(i4, i5))) {
                                if (!TextUtils.isEmpty(str3)) {
                                    d0(z1.e.B(this.f3512b, str3 + strReplaceAll.substring(i4, i3)));
                                    str3 = BuildConfig.FLAVOR;
                                    i9 = i4;
                                }
                            }
                        }
                        if ("log".equals(str3)) {
                            d0(z1.e.B(this.f3512b, str3));
                            i9 = i9 + 1 + 1;
                            str3 = BuildConfig.FLAVOR;
                        } else if (-1 != z1.e.B(this.f3512b, str3)) {
                            d0(z1.e.B(this.f3512b, str3));
                            str3 = BuildConfig.FLAVOR;
                        }
                    } else if (!TextUtils.isEmpty(str3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str3);
                        int i19 = i9 + 1;
                        sb2.append(strReplaceAll.substring(i19, i9 + 2));
                        d0(z1.e.B(this.f3512b, sb2.toString()));
                        i9 = i19;
                        str3 = BuildConfig.FLAVOR;
                    }
                }
                i9++;
            } else {
                VLog.d("BBKCalculator/Calculator", "insertProcess: str have id == " + str3);
                if (!TextUtils.isEmpty(str3)) {
                    if (N0(str3) && "h".equalsIgnoreCase(strReplaceAll.substring(i14, i9 + 2))) {
                        g0(z1.e.B(this.f3512b, str3 + "h"));
                        i14++;
                    } else if (!"e".equals(str3) || strReplaceAll.length() < (i8 = i9 + 2)) {
                        if (N0(str3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("insertProcess: 22  - = ");
                            int i20 = i9 + 2;
                            sb3.append(strReplaceAll.substring(i14, i20));
                            VLog.d("BBKCalculator/Calculator", sb3.toString());
                            if (TextUtils.isEmpty(str3) || strReplaceAll.length() < (i7 = i9 + 3) || !("-".equals(strReplaceAll.substring(i14, i20)) || "−".equals(strReplaceAll.substring(i14, i20)))) {
                                g0(z1.e.B(this.f3512b, str3));
                            } else {
                                g0(z1.e.B(this.f3512b, str3 + strReplaceAll.substring(i14, i7)));
                            }
                        } else {
                            g0(z1.e.B(this.f3512b, str3));
                        }
                        str3 = BuildConfig.FLAVOR;
                    } else {
                        g0(z1.e.B(this.f3512b, str3 + strReplaceAll.substring(i14, i8)));
                    }
                    str3 = BuildConfig.FLAVOR;
                    i9 = i14;
                }
                g0(iB);
            }
            j1();
            J1(z.INPUT);
            if (this.f3561r0.getTextString().isEmpty() || g2.b.q(this.f3561r0.getTextString().replace(",", BuildConfig.FLAVOR))) {
                this.f3564s0.c();
            }
            i9++;
        }
        if (A0()) {
            this.f3567t0.g2();
        } else {
            q0();
        }
    }

    public boolean N0(String str) {
        return str != null && (str.contains(this.f3512b.getResources().getString(R.string.fun_tan)) || str.contains(this.f3512b.getResources().getString(R.string.fun_sin)) || str.contains(this.f3512b.getResources().getString(R.string.fun_cos)) || str.contains(this.f3512b.getResources().getString(R.string.fun_arctan)) || str.contains(this.f3512b.getResources().getString(R.string.fun_arcsin)) || str.contains(this.f3512b.getResources().getString(R.string.fun_arccos)));
    }

    public void O0(String str) {
        if (this.A0 == null || N0(str) || this.A0 == null) {
            return;
        }
        if (g2.b.o(this.f3512b)) {
            this.A0.setVisibility(4);
        } else {
            this.A0.setVisibility(8);
        }
    }

    public boolean P0() {
        View view = this.f3524f;
        return view != null && view.getVisibility() == 0;
    }

    public void Q0(String str) {
        TextView textView;
        if (this.A0 == null || !N0(str) || (textView = this.A0) == null) {
            return;
        }
        textView.setVisibility(0);
        if (this.f3567t0.b(0L)) {
            this.A0.setText(this.B1);
        } else {
            this.A0.setText(this.A1);
        }
    }

    public boolean R0() {
        int i3 = Build.VERSION.SDK_INT;
        boolean zBooleanValue = false;
        if (i3 >= 30) {
            zBooleanValue = g2.b.u(this.f3512b);
        } else if (i3 >= 28) {
            Object objC = g2.g.c(this, "android.app.Activity", "isInVivoFreeformMode");
            if (objC != null) {
                zBooleanValue = ((Boolean) objC).booleanValue();
            }
        } else {
            Object objC2 = g2.g.c(this, "android.app.Activity", "getWindowStackId");
            if (objC2 != null && ((Integer) objC2).intValue() == 2) {
                zBooleanValue = true;
            }
        }
        VLog.d("BBKCalculator/Calculator", "isWindowModeFreeForm，ret = " + zBooleanValue);
        return zBooleanValue;
    }

    public void U0() {
        View view;
        View view2;
        if (this.G0 != null && (view2 = this.f3521e) != null && view2.getVisibility() == 0 && this.G0.getHistoryListOpen()) {
            this.G0.F(3);
        }
        if (this.H0 == null || (view = this.f3524f) == null || view.getVisibility() != 0 || !this.H0.getHistoryListOpen()) {
            return;
        }
        this.H0.F(3);
    }

    @Override // a2.a
    public void a(boolean z2) {
        x1(z2);
    }

    @Override // com.vivo.calculator.b.j
    public void b(long j3, int i3) {
        VLog.d("BBKCalculator/Calculator", "onError: ");
        if (j3 != 0) {
            throw new AssertionError("Unexpected error source");
        }
        VLog.d("BBKCalculator/Calculator", "onError: " + this.f3570u0);
        J1(z.ERROR);
        z zVar = this.f3570u0;
        if (zVar == z.EVALUATE || zVar == z.INIT || zVar != z.INIT_FOR_RESULT) {
            this.f3564s0.b(j3, R.string.error);
        } else {
            this.f3564s0.b(j3, R.string.error);
        }
        if (this.f3573v0) {
            this.f3564s0.setVisibility(0);
        } else {
            this.f3564s0.setVisibility(4);
        }
        this.f3564s0.setEnabled(false);
    }

    @Override // a2.a
    public void c() {
        w1();
    }

    public void d() {
        if (this.f3561r0.getTextString() == null || TextUtils.isEmpty(this.f3561r0.getTextString())) {
            this.f3518d.putBoolean("hasMessage", false);
        } else {
            this.f3518d.putBoolean("hasMessage", true);
        }
        z zVar = this.f3570u0;
        if (zVar == z.RESULT || zVar == z.INIT_FOR_RESULT) {
            this.f3518d.putString("result", this.f3561r0.getTextString());
        } else {
            this.f3567t0.O1(0L);
        }
        this.f3518d.putInt("Calculator_display_state", this.f3570u0.ordinal());
        this.f3518d.putString("Calculator_unprocessed_chars", this.f3576w0);
        ColorSelectButton colorSelectButton = this.f3585z0;
        if (colorSelectButton != null) {
            this.f3518d.putBoolean("Calculator_inverse_mode", colorSelectButton.isSelected());
        }
        this.f3518d.commit();
        this.f3567t0.l2();
    }

    public void d1() {
        String strZ = this.f3567t0.Z(this.f3561r0.getSelectionStart(), this.f3567t0.l1());
        String textString = this.f3561r0.getTextString();
        if (!TextUtils.isEmpty(textString) && this.f3561r0.getSelectionStart() == this.f3561r0.getSelectionEnd()) {
            int selectionStart = this.f3561r0.getSelectionStart();
            if (selectionStart == 0 || selectionStart >= textString.length()) {
                if (selectionStart == textString.length()) {
                    if (TextUtils.isDigitsOnly(textString.substring(selectionStart - 1, selectionStart))) {
                        return;
                    }
                } else if (selectionStart != 0 || TextUtils.isDigitsOnly(textString.substring(selectionStart, selectionStart + 1))) {
                    return;
                }
            } else if (TextUtils.isDigitsOnly(textString.substring(selectionStart - 1, selectionStart)) || TextUtils.isDigitsOnly(textString.substring(selectionStart, selectionStart + 1))) {
                return;
            }
        }
        M0(strZ, false);
        CalculatorFormula calculatorFormula = this.f3561r0;
        calculatorFormula.setSelection(calculatorFormula.length());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        View view;
        VLog.d("BBKCalculator/Calculator", "SaveDispalyID");
        if (this.f3538j1 || (view = this.f3521e) == null) {
            return;
        }
        if (view.getVisibility() == 0) {
            this.f3518d.putInt("DispalyID", 0);
        } else {
            this.f3518d.putInt("DispalyID", 1);
        }
        this.f3518d.commit();
    }

    @Override // com.vivo.calculator.b.j
    public void f(long j3) {
        J1(z.INPUT);
    }

    @Override // com.vivo.calculator.b.j
    public void g(long j3) {
        VLog.d("BBKCalculator/Calculator", "onReevaluate: ");
    }

    public void g0(int i3) {
        this.f3567t0.W(i3, this.f3561r0.isCursorVisible() ? this.f3561r0.getSelectionStart() : this.f3561r0.getText().length(), this.f3561r0);
        if (this.f3561r0.isCursorVisible()) {
            return;
        }
        this.f3561r0.setCursorVisible(true);
        CalculatorFormula calculatorFormula = this.f3561r0;
        calculatorFormula.setSelection(calculatorFormula.getText().length());
    }

    public void g1(int i3) {
        if (this.f3556p1 != null) {
            int ringerMode = ((AudioManager) this.f3512b.getSystemService("audio")).getRingerMode();
            if (ringerMode == 0 || ringerMode == 1) {
                VLog.e("BBKCalculator/Calculator", "playTone  ringerMode return ");
            } else {
                this.f3556p1.m(i3);
            }
        }
    }

    @Override // com.vivo.calculator.b.j
    public void h(long j3, int i3, int i4, int i5, String str) {
        VLog.d("BBKCalculator/Calculator", "onEvaluate: ");
        if (j3 != 0) {
            throw new AssertionError("Unexpected evaluation result index\n");
        }
        if (this.f3514b1 || this.f3562r1) {
            VLog.d("BBKCalculator/Calculator", "onEvaluate: isResultState true return");
            return;
        }
        if (g2.h.b(this.f3561r0.getTextString())) {
            this.f3564s0.c();
        } else {
            this.f3564s0.setEnabled(true);
            this.f3564s0.h(j3, i3, i4, i5, str);
            VLog.d("BBKCalculator/Calculator", "onEvaluate: mCurrentState: " + this.f3570u0);
            z zVar = this.f3570u0;
            if (zVar != z.INPUT && zVar != z.INIT && zVar != z.ERROR) {
                e1(zVar == z.EVALUATE, zVar == z.INIT_FOR_RESULT || zVar == z.RESULT);
            }
        }
        if (this.f3515c.getBoolean("IS_CALCULATOR_UPDATE", false) || !this.f3515c.getBoolean("euqalflag", false)) {
            return;
        }
        this.f3564s0.setTextString(BuildConfig.FLAVOR);
        this.f3518d.putBoolean("IS_CALCULATOR_UPDATE", true);
        this.f3518d.commit();
    }

    public void i0() {
        ValueAnimator valueAnimator = this.J0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.J0 = null;
        }
        ValueAnimator valueAnimator2 = this.K0;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.K0 = null;
        }
        ValueAnimator valueAnimator3 = this.L0;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.L0 = null;
        }
        ValueAnimator valueAnimator4 = this.M0;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
            this.M0 = null;
        }
    }

    void j1() {
        SpannableStringBuilder spannableStringBuilderM1 = this.f3567t0.e(0L).m1(this.f3512b);
        VLog.d("BBKCalculator/Calculator", "redisplayFormula: formula ==  insertProcess " + ((Object) spannableStringBuilderM1));
        String str = this.f3576w0;
        if (str != null) {
            spannableStringBuilderM1.append(str, this.f3533i, 33);
        }
        this.f3561r0.b(spannableStringBuilderM1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        E1 = false;
        this.f3564s0.setScaleY(1.0f);
        if (animator == this.J0) {
            this.f3561r0.setAlpha(1.0f);
            String textString = this.f3564s0.getTextString();
            this.f3561r0.setText(m0(textString).toString());
            this.f3561r0.setContentDescription(g2.b.w(this, textString));
            this.f3561r0.setSelection(textString.length());
            this.f3564s0.setText(BuildConfig.FLAVOR);
            this.f3561r0.setY(L1);
            this.f3564s0.setY(K1);
            this.f3564s0.getLayoutParams().height = O1;
            this.f3564s0.setTextSize(0, M1);
            this.f3564s0.setScaleX(1.0f);
            this.f3564s0.setScaleY(1.0f);
            this.f3564s0.setTextColor(this.f3577w1);
            J1(z.RESULT);
            this.f3561r0.clearFocus();
            this.f3561r0.requestFocus();
        } else if (animator == this.L0) {
            this.f3564s0.setAlpha(1.0f);
            this.f3564s0.setY(K1);
            this.f3564s0.getLayoutParams().height = O1;
            this.f3564s0.setTextSize(0, M1);
            this.f3564s0.setScaleX(1.0f);
            this.f3564s0.setScaleY(1.0f);
            this.f3564s0.setTextColor(this.f3577w1);
            VLog.d("BBKCalculator/Calculator", "mResultText-->" + this.f3564s0);
        } else if (animator == this.M0) {
            this.f3561r0.setAlpha(1.0f);
            CalculatorFormula calculatorFormula = this.f3561r0;
            calculatorFormula.setSelection(calculatorFormula.getText().length());
            this.f3561r0.setY(L1);
            this.f3561r0.getLayoutParams().height = P1;
            this.f3561r0.setTextSize(0, N1);
            this.f3561r0.setTextColor(this.f3580x1);
        }
        I1 = false;
        i0();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (animator == this.J0) {
            float fC = this.f3561r0.c(this.f3564s0.getTextString());
            N1 = fC;
            float fM = g2.b.m(this.f3512b, fC);
            float fM2 = g2.b.m(this.f3512b, M1);
            this.f3565s1 = (P1 - ((O1 * fM) / fM2)) / 2.0f;
            if (g2.b.u(this.f3512b)) {
                this.f3568t1 = (K1 - L1) - ((fM - fM2) / 0.3f);
                return;
            } else {
                this.f3568t1 = (K1 + O1) - ((L1 + P1) - this.f3565s1);
                return;
            }
        }
        if (animator == this.L0) {
            this.f3564s0.setY(L1);
            this.f3564s0.setTextSize(0, N1);
            float fM3 = g2.b.m(this.f3512b, N1);
            float fM4 = g2.b.m(this.f3512b, M1);
            this.f3571u1 = (((P1 * fM4) / fM3) - O1) / 2.0f;
            if (!g2.b.u(this.f3512b)) {
                this.f3574v1 = ((K1 + O1) + this.f3571u1) - (L1 + P1);
                return;
            }
            float f3 = L1;
            float f4 = fM4 / 2.0f;
            this.Z0 = f3 + f4;
            this.f3574v1 = (((K1 + O1) + this.f3571u1) - (f3 + P1)) - (((fM3 / 2.0f) - f4) * 9.2f);
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f3 = L1;
        int i3 = P1;
        float f4 = f3 + i3;
        if (valueAnimator == this.J0) {
            float f5 = (((N1 / M1) - 1.0f) * fFloatValue) + 1.0f;
            this.f3564s0.setTextColor(((double) fFloatValue) > 0.5d ? this.f3580x1 : this.f3577w1);
            this.f3564s0.setY(K1 - (fFloatValue * this.f3568t1));
            CalculatorResult calculatorResult = this.f3564s0;
            calculatorResult.setPivotX(calculatorResult.getWidth());
            CalculatorResult calculatorResult2 = this.f3564s0;
            calculatorResult2.setPivotY(calculatorResult2.getHeight());
            this.f3564s0.setScaleX(f5);
            this.f3564s0.setScaleY(f5);
        } else if (valueAnimator == this.K0) {
            this.f3561r0.setAlpha(1.0f - fFloatValue);
            this.f3561r0.setY(L1 - (fFloatValue * f4));
        } else if (valueAnimator == this.L0) {
            double d3 = fFloatValue;
            int iT0 = (int) (i3 + (t0() * fFloatValue));
            float f6 = (((M1 / N1) - 1.0f) * fFloatValue) + 1.0f;
            if (R0()) {
                this.f3564s0.setY(this.Z0 + (fFloatValue * this.f3574v1));
            } else {
                this.f3564s0.setY(L1 + (fFloatValue * this.f3574v1));
            }
            CalculatorResult calculatorResult3 = this.f3564s0;
            calculatorResult3.setPivotX(calculatorResult3.getWidth());
            CalculatorResult calculatorResult4 = this.f3564s0;
            calculatorResult4.setPivotY(calculatorResult4.getHeight());
            this.f3564s0.setScaleX(f6);
            this.f3564s0.setScaleY(f6);
            this.f3564s0.setTextColor(d3 > 0.5d ? this.f3577w1 : this.f3580x1);
            this.f3564s0.getLayoutParams().height = iT0;
        } else if (valueAnimator == this.M0) {
            this.f3561r0.setAlpha(fFloatValue);
            this.f3561r0.setY((fFloatValue * f4) - P1);
        }
        I1 = true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (v0()) {
            U0();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        g2.d.a(this);
        if (!g2.b.b(this)) {
            setTheme(R.style.AppThemeOverlay);
        }
        super.onCreate(bundle);
        VLog.d("BBKCalculator/Calculator", "onCreate savedInstanceState = " + bundle);
        this.f3512b = this;
        try {
            this.f3527g = getIntent().getBooleanExtra("isFromKeyguard", false);
        } catch (ActivityNotFoundException e3) {
            VLog.e("BBKCalculator/Calculator", "get isFromKeyguard error : " + e3.getMessage());
        }
        if (Build.VERSION.SDK_INT > 26 && this.f3527g) {
            setShowWhenLocked(true);
        }
        this.f3530h = (KeyguardManager) this.f3512b.getSystemService("keyguard");
        VLog.d("BBKCalculator/Calculator", "onCreate()  isFromKeyguard: " + this.f3527g + " isKeyguardLocked: " + this.f3530h.isKeyguardLocked());
        com.vivo.calculator.b bVarC1 = com.vivo.calculator.b.c1(getApplicationContext());
        this.f3567t0 = bVarC1;
        bVarC1.U1(this.f3547m1);
        this.N0 = (ClipboardManager) this.f3512b.getSystemService("clipboard");
        VLog.d("BBKCalculator/Calculator", "onCreateView: isInMultiWindowMode == " + isInMultiWindowMode() + ", isWindowModeFreeForm():" + R0());
        G1 = isInMultiWindowMode();
        H1 = R0();
        if (R0()) {
            setRequestedOrientation(1);
        }
        I0();
        if (R0()) {
            setContentView(R.layout.activity_calculator_port_mul_free_new);
            this.f3526f1 = View.inflate(this.f3512b, R.layout.activity_calculator_port_mul_free_new, null);
            BBKCalculatorApplication.a().c().execute(new u());
        } else if (isInMultiWindowMode()) {
            if (g2.b.o(this)) {
                setContentView(R.layout.nex_activity_calculator_port_mul);
                this.f3526f1 = View.inflate(this.f3512b, R.layout.nex_activity_calculator_port_mul, null);
            } else {
                setContentView(R.layout.activity_calculator_port_mul);
                this.f3526f1 = View.inflate(this.f3512b, R.layout.activity_calculator_port_mul, null);
            }
        } else if (g2.b.o(this)) {
            setContentView(R.layout.nex_activity_calculator_port);
            this.f3526f1 = View.inflate(this.f3512b, R.layout.nex_activity_calculator_port, null);
        } else {
            setContentView(R.layout.activity_calculator_port);
            this.f3526f1 = View.inflate(this.f3512b, R.layout.activity_calculator_port, null);
        }
        this.W0 = 1 == getResources().getConfiguration().orientation;
        g2.b.f4762c = g2.b.e();
        g2.b.f4763d = g2.b.z();
        D0();
        getApplicationContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f3523e1);
        k1();
        l1();
        n1();
        BBKCalculatorApplication.a().k(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        VLog.d("BBKCalculator/Calculator", "onDestroy: ");
        HistoryLayout historyLayout = this.G0;
        if (historyLayout != null) {
            historyLayout.G();
        }
        HistoryLayout historyLayout2 = this.H0;
        if (historyLayout2 != null) {
            historyLayout2.G();
        }
        if (Settings.System.getInt(this.f3512b.getContentResolver(), "accelerometer_rotation", 0) == 1 && !R0() && g2.g.d()) {
            setRequestedOrientation(-1);
        }
        m1();
        getApplicationContext().getContentResolver().unregisterContentObserver(this.f3523e1);
        Handler handler = this.f3520d1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3520d1.removeCallbacks(this.f3550n1);
            this.f3520d1 = null;
        }
        androidx.appcompat.app.a aVar = this.P0;
        if (aVar != null && aVar.isShowing()) {
            this.P0.dismiss();
            this.P0 = null;
        }
        androidx.appcompat.app.a aVar2 = this.Q0;
        if (aVar2 != null && aVar2.isShowing()) {
            this.Q0.dismiss();
            this.Q0 = null;
        }
        this.f3523e1 = null;
        HistoryLayout historyLayout3 = this.G0;
        if (historyLayout3 != null) {
            historyLayout3.D();
            this.G0.Y();
            this.G0 = null;
        }
        HistoryLayout historyLayout4 = this.H0;
        if (historyLayout4 != null) {
            historyLayout4.D();
            this.H0.Y();
            this.H0 = null;
        }
        BBKCalculatorApplication.a().k(null);
        super.onDestroy();
        Q1();
        System.gc();
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        super.onMultiWindowModeChanged(z2);
        VLog.d("BBKCalculator/Calculator", "onMultiWindowModeChanged, isInMultiWindowMode:" + z2);
        G1 = z2;
        if (z2 || g2.b.j() != 0) {
            return;
        }
        e();
        this.f3518d.putBoolean("result_state", this.f3514b1);
        this.f3518d.apply();
        g2.b.y(this.f3512b, !F1);
        d();
        t1(this.f3573v0);
        setContentView(R.layout.activity_calculator_port);
        setRequestedOrientation(-1);
        D0();
        E0();
        q1();
        this.f3561r0.requestFocus();
        this.f3561r0.setFocusableInTouchMode(true);
        this.f3561r0.setCursorVisible(true);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        e();
        this.f3518d.putBoolean("result_state", this.f3514b1);
        this.f3518d.apply();
        VLog.d("BBKCalculator/Calculator", "onPause: degMode = " + F1);
        g2.b.y(this.f3512b, F1 ^ true);
        d();
        t1(this.f3573v0);
        DisplayManager displayManager = this.T0;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.f3553o1);
        }
        if (BBKCalculatorApplication.i() || isInMultiWindowMode()) {
            return;
        }
        setRequestedOrientation(-1);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        F1();
        this.f3541k1 = true;
        VLog.d("BBKCalculator/Calculator", "onResume:  ");
        K1();
        w1();
        h1();
        DisplayManager displayManager = (DisplayManager) getSystemService("display");
        this.T0 = displayManager;
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.f3553o1, null);
        }
        z1();
        E0();
        if (BBKCalculatorApplication.f()) {
            this.f3520d1.sendEmptyMessageDelayed(1, 100L);
        } else {
            q1();
            this.f3561r0.setOnDisplayMemoryOperationsListener(this.f3583y1);
            BBKCalculatorApplication.l(false);
        }
        o0(3000);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f3541k1 = false;
        VLog.d("BBKCalculator/Calculator", "onStop:  ");
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z2) {
        super.onTopResumedActivityChanged(z2);
        VLog.d("BBKCalculator/Calculator", "onTopResumedActivityChanged:" + z2);
        if (Build.VERSION.SDK_INT < 30) {
            if (z2) {
                this.U0 = true;
            } else {
                this.U0 = false;
            }
        }
    }

    public void p1() {
        J1 = true;
        if (I1) {
            return;
        }
        J0();
        if (this.M0 == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.M0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.M0.addListener(this);
            this.M0.addUpdateListener(this);
        }
        this.M0.start();
        if (this.L0 == null) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.L0 = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(300L);
            this.L0.addListener(this);
            this.L0.addUpdateListener(this);
        }
        this.L0.start();
    }

    public void q0() {
        if (this.f3570u0 != z.INPUT || TextUtils.isEmpty(this.f3567t0.e(0L).m1(this.f3512b))) {
            return;
        }
        this.f3567t0.K0(0L, this, this.f3564s0);
    }

    public String s0() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence text;
        ClipboardManager clipboardManager = this.N0;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null) {
            return null;
        }
        return text.toString().trim().replace(",", BuildConfig.FLAVOR);
    }

    public boolean u0() {
        return this.U0;
    }

    public void u1() {
        A1();
        VLog.d("BBKCalculator/Calculator", "saveScreenDevice:   isHistoryOpen == " + this.f3559q1);
        boolean z2 = false;
        if (P0()) {
            this.f3518d.putBoolean("HistoryListOpen", this.f3559q1);
            SharedPreferences.Editor editor = this.f3518d;
            HistoryLayout historyLayout = this.H0;
            if (historyLayout != null && historyLayout.S()) {
                z2 = true;
            }
            editor.putBoolean("HISTORY_DIALOG_OPEN", z2);
        } else {
            if (this.A0 == null) {
                this.f3518d.putInt("DispalyID", 0);
            } else {
                this.f3518d.putInt("DispalyID", 1);
            }
            this.f3518d.putBoolean("HistoryListOpen", this.f3559q1);
            SharedPreferences.Editor editor2 = this.f3518d;
            HistoryLayout historyLayout2 = this.G0;
            if (historyLayout2 != null && historyLayout2.S()) {
                z2 = true;
            }
            editor2.putBoolean("HISTORY_DIALOG_OPEN", z2);
        }
        this.f3518d.commit();
    }

    public boolean v0() {
        View view;
        if (this.G0 != null && (view = this.f3521e) != null && view.getVisibility() == 0) {
            return this.G0.getHistoryListOpen();
        }
        if (this.H0 == null || this.f3521e == null || this.f3524f.getVisibility() != 0) {
            return false;
        }
        return this.H0.getHistoryListOpen();
    }

    public void v1() {
        J1 = true;
        if (I1) {
            return;
        }
        J1(z.ANIMATE);
        this.f3562r1 = true;
        J0();
        if (this.K0 == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.K0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.K0.addListener(this);
            this.K0.addUpdateListener(this);
        }
        this.K0.start();
        if (this.J0 == null) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.J0 = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(300L);
            this.J0.addListener(this);
            this.J0.addUpdateListener(this);
        }
        this.J0.start();
    }

    public boolean w0() {
        return this.D1;
    }

    public View.OnClickListener x0() {
        return this.f3586z1;
    }

    public void x1(boolean z2) {
        VLog.d("BBKCalculator/Calculator", "setConfigurationInfo:  " + z2);
        this.f3538j1 = z2;
        if (z2 && this.f3541k1) {
            s1();
            u1();
        }
    }

    public void y0(Message message) {
        if (this.f3520d1 != null && message.what == 1) {
            q1();
            this.f3561r0.setOnDisplayMemoryOperationsListener(this.f3583y1);
            this.f3564s0.requestLayout();
            BBKCalculatorApplication.l(false);
        }
    }

    public boolean z0() {
        f2.a aVar = this.f3556p1;
        return aVar != null && aVar.g();
    }
}
