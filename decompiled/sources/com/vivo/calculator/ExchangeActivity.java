package com.vivo.calculator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.vivo.calculator.entry.CurrencyEntry;
import com.vivo.calculator.entry.ExchangeEntry;
import com.vivo.calculator.exchange.CalculatorLocResult;
import com.vivo.calculator.exchange.CalculatorOthResult;
import com.vivo.calculator.exchange.InputTextView;
import com.vivo.calculator.exchangelist.CountryList;
import com.vivo.calculator.helper.CountryProvide;
import com.vivo.calculator.keybord.ColorExButton;
import com.vivo.calculator.pulltorefresh.PullToRefreshScrollView;
import com.vivo.seckeysdk.BuildConfig;
import com.vos.widget.VToolBar;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class ExchangeActivity extends Activity implements View.OnTouchListener, View.OnClickListener, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener, com.vivo.calculator.b.j, com.vivo.calculator.b.i, a2.c {
    public static boolean N1 = false;
    private static f2.a O1 = null;
    public static String P1 = "";
    public static float Q1 = 0.0f;
    public static float R1 = 0.0f;
    public static float S1 = 0.0f;
    public static float T1 = 0.0f;
    public static float U1 = 0.0f;
    public static float V1 = 0.0f;
    public static float W1 = 0.0f;
    public static float X1 = 0.0f;
    private static float Y1 = 0.0f;
    private static float Z1 = 0.0f;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    private static float f3668a2 = 0.0f;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private static float f3669b2 = 0.0f;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    private static float f3670c2 = 0.0f;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    private static float f3671d2 = 0.0f;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    private static int f3672e2 = 0;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    private static int f3673f2 = 0;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    private static int f3674g2 = 0;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    private static int f3675h2 = 0;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    private static int f3676i2 = 0;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static boolean f3677j2 = false;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    private static AudioManager f3678k2;
    private LinearLayout A;
    private boolean A0;
    private x A1;
    private LinearLayout B;
    private String B0;
    private x B1;
    private ImageView C;
    private String C0;
    private ImageView D;
    private String[] D0;
    private String[] E0;
    private String F0;
    private boolean F1;
    private View G;
    private boolean G1;
    private View H;
    private boolean H0;
    private Handler H1;
    private RelativeLayout I;
    private RelativeLayout J;
    private RelativeLayout K;
    private ValueAnimator K0;
    private RefreshLinearLayout L;
    private ValueAnimator L0;
    private String M;
    private ValueAnimator M0;
    private String N;
    private ValueAnimator N0;
    private String O;
    private ValueAnimator O0;
    private String P;
    private ValueAnimator P0;
    private String Q;
    private ValueAnimator Q0;
    private String R;
    private ValueAnimator R0;
    private String S;
    private ValueAnimator S0;
    private String T;
    private ValueAnimator T0;
    private String U;
    private ValueAnimator U0;
    private String V;
    private ValueAnimator V0;
    private ValueAnimator W0;
    private ValueAnimator X0;
    private ValueAnimator Y0;
    private ValueAnimator Z0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private c2.b f3682b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f3684c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ClipboardManager f3685c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.vivo.calculator.b f3687d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f3688d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.vivo.calculator.b f3690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SQLiteDatabase f3693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewStub f3696g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private SharedPreferences f3697g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ViewStub f3699h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private SharedPreferences.Editor f3700h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private Intent f3703i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private RelativeLayout f3706j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorExButton f3708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private InputTextView f3711l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private ColorExButton f3712l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private InputTextView f3714m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private ColorExButton f3715m0;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private int f3716m1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CalculatorLocResult f3717n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private VToolBar f3718n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CalculatorOthResult f3720o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    boolean f3721o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f3723p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    boolean f3724p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f3726q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f3729r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f3732s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f3735t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f3738u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f3741v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f3742v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Button f3744w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f3745w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Button f3747x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Button f3750y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Button f3753z;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    private View f3755z1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3681b = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PullToRefreshScrollView f3702i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RefreshHeaderLayout f3705j = null;
    private View E = null;
    private View F = null;
    private String W = BuildConfig.FLAVOR;
    private String X = BuildConfig.FLAVOR;
    private String Y = BuildConfig.FLAVOR;
    private y Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private g2.e f3679a0 = new g2.e();

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f3691e0 = false;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f3694f0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private View f3709k0 = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f3727q0 = false;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f3730r0 = false;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f3733s0 = true;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f3736t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f3739u0 = false;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f3748x0 = 0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    String f3751y0 = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private y2.w f3754z0 = new y2.w();
    private final com.vivo.calculator.b.f G0 = new l();
    private boolean I0 = false;
    private boolean J0 = false;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private float f3680a1 = 0.0f;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private float f3683b1 = 0.0f;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private float f3686c1 = 0.0f;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private float f3689d1 = 0.0f;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private float f3692e1 = 0.0f;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private float f3695f1 = 0.0f;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private float f3698g1 = 0.0f;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private float f3701h1 = 0.0f;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private float f3704i1 = 0.0f;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private float f3707j1 = 0.0f;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private float f3710k1 = 0.0f;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private float f3713l1 = 0.0f;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private float f3719n1 = 0.0f;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private float f3722o1 = 0.0f;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private float f3725p1 = 0.0f;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private float f3728q1 = 0.0f;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private float f3731r1 = 0.0f;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private int f3734s1 = 0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private int f3737t1 = 0;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private boolean f3740u1 = false;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private boolean f3743v1 = false;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private boolean f3746w1 = false;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private boolean f3749x1 = false;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private boolean f3752y1 = false;
    private String C1 = null;
    private boolean D1 = false;
    private boolean E1 = false;
    public View.OnClickListener I1 = new m();
    private ForegroundColorSpan J1 = new ForegroundColorSpan(-65536);
    private boolean K1 = false;
    private BroadcastReceiver L1 = new n();
    private boolean M1 = false;

    class a extends ActionMode.Callback2 {
        a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 1);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.f3714m.setSelectAllOnFocus(true);
            ExchangeActivity.this.f3714m.selectAll();
            ExchangeActivity.this.f3694f0 = true;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            ExchangeActivity.this.f3714m.setSelectAllOnFocus(false);
            ExchangeActivity.this.f3694f0 = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.p2(actionMode, menu, 1);
            return true;
        }
    }

    class b implements View.OnDragListener {
        b() {
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            return true;
        }
    }

    class c extends ActionMode.Callback2 {
        c() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 2);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return !TextUtils.isEmpty(ExchangeActivity.this.f3717n.getText());
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.p2(actionMode, menu, 2);
            return true;
        }
    }

    class d extends ActionMode.Callback2 {
        d() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 2);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.f3717n.setSelectAllOnFocus(true);
            ExchangeActivity.this.f3717n.selectAll();
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            ExchangeActivity.this.f3717n.setSelectAllOnFocus(false);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.p2(actionMode, menu, 2);
            return true;
        }
    }

    class e implements View.OnDragListener {
        e() {
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            return true;
        }
    }

    class f extends ActionMode.Callback2 {
        f() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 3);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return !TextUtils.isEmpty(ExchangeActivity.this.f3720o.getText());
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.p2(actionMode, menu, 3);
            return true;
        }
    }

    class g extends ActionMode.Callback2 {
        g() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 3);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.f3720o.setSelectAllOnFocus(true);
            ExchangeActivity.this.f3720o.selectAll();
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            ExchangeActivity.this.f3720o.setSelectAllOnFocus(false);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.p2(actionMode, menu, 3);
            return true;
        }
    }

    class h implements View.OnDragListener {
        h() {
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            return true;
        }
    }

    class i implements com.vivo.calculator.pulltorefresh.f.i {
        i() {
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void a() {
            VLog.d("BBKCalculator/ExchangeActivity", "SJSCROLL refreshing ");
            if (ExchangeActivity.this.f3705j != null) {
                ExchangeActivity.this.f3705j.c();
            }
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void b() {
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void c(float f3) {
            if (ExchangeActivity.this.f3705j != null) {
                ExchangeActivity.this.f3705j.a(f3);
            }
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void d() {
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void e() {
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void f(int i3) {
            int dimensionPixelSize = ExchangeActivity.this.getResources().getDimensionPixelSize(R.dimen.head_layout_padding);
            if (ExchangeActivity.this.f3705j != null) {
                if (i3 < dimensionPixelSize || i3 > 0) {
                    ExchangeActivity.this.f3705j.setTranslationY(0.0f);
                } else {
                    ExchangeActivity.this.f3705j.setVisibility(0);
                    ExchangeActivity.this.f3705j.setTranslationY(dimensionPixelSize + Math.abs(i3));
                }
            }
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void g(int i3, int i4) {
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void h(int i3, int i4) {
            VLog.d("BBKCalculator/ExchangeActivity", "SJSCROLL onMainScrolled scrollY : " + i3);
            ExchangeActivity.this.f3702i.r();
            ExchangeActivity.this.f3702i.setCurScrollY(i3);
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void i() {
            VLog.d("BBKCalculator/ExchangeActivity", "SJSCROLL releaseToRefresh ");
            if (ExchangeActivity.this.f3705j != null) {
                ExchangeActivity.this.f3705j.d();
            }
        }

        @Override // com.vivo.calculator.pulltorefresh.f.i
        public void j() {
            VLog.d("BBKCalculator/ExchangeActivity", "SJSCROLL pullToRefresh ");
            if (ExchangeActivity.this.f3705j != null) {
                ExchangeActivity.this.f3705j.b();
            }
        }
    }

    class j implements com.vivo.calculator.pulltorefresh.f.h<ScrollView> {
        j() {
        }

        @Override // com.vivo.calculator.pulltorefresh.f.h
        public void a(com.vivo.calculator.pulltorefresh.f<ScrollView> fVar) throws Throwable {
            ExchangeActivity.this.L3();
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExchangeActivity.this.onBackPressed();
        }
    }

    class l implements com.vivo.calculator.b.f {
        l() {
        }

        @Override // com.vivo.calculator.b.f
        public void a() {
            VLog.d("BBKCalculator/ExchangeActivity", "onMemoryStateChanged: ");
        }

        @Override // com.vivo.calculator.b.f
        public void b(int i3, int i4, int i5, String str) {
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExchangeActivity.this.f3755z1 = view;
            ExchangeActivity.this.L0();
            ExchangeActivity.f3677j2 = false;
            ExchangeActivity.this.C3(true);
            int id = view.getId();
            if (id == R.id.e_clr) {
                if (!ExchangeActivity.this.f3697g0.getBoolean("input_type", false)) {
                    VLog.d("BBKCalculator/ExchangeActivity", "onClick: e_clr，default status，return.");
                    return;
                } else {
                    ExchangeActivity.this.i2();
                    h2.a.a().f(23);
                    return;
                }
            }
            if (id == R.id.e_del) {
                if (!ExchangeActivity.this.f3697g0.getBoolean("input_type", false)) {
                    VLog.d("BBKCalculator/ExchangeActivity", "e_del,default status，return.");
                    return;
                }
                if (ExchangeActivity.N1) {
                    VLog.d("BBKCalculator/ExchangeActivity", "click e_del , IS_ANIMATION_PLAYING , return.");
                    return;
                }
                ExchangeActivity.this.e3();
                if (ExchangeActivity.this.H0) {
                    ExchangeActivity.this.F1 = false;
                    ExchangeActivity.this.q2();
                    ExchangeActivity.this.S1(ExchangeActivity.P1);
                } else {
                    ExchangeActivity.this.G1 = false;
                    ExchangeActivity.this.r2();
                    ExchangeActivity.this.U1(ExchangeActivity.P1);
                }
                h2.a.a().f(22);
                return;
            }
            if (id == R.id.e_eq) {
                if (ExchangeActivity.N1) {
                    VLog.d("BBKCalculator/ExchangeActivity", "click e_eq , IS_ANIMATION_PLAYING , return.");
                    return;
                } else {
                    ExchangeActivity.this.s2(false);
                    h2.a.a().f(24);
                    return;
                }
            }
            VLog.d("BBKCalculator/ExchangeActivity", "onClick: default == " + ExchangeActivity.this.w1());
            ExchangeActivity.this.M2(id);
            ExchangeActivity.this.J0(false);
            ExchangeActivity.this.K0(false);
            ExchangeActivity.this.e3();
            if (!ExchangeActivity.this.f3697g0.getBoolean("input_type", false)) {
                ExchangeActivity.this.i2();
                ExchangeActivity.this.f3711l.setTextString(BuildConfig.FLAVOR);
                ExchangeActivity.this.f3714m.setTextString(BuildConfig.FLAVOR);
                ExchangeActivity.this.S = BuildConfig.FLAVOR;
                ExchangeActivity.this.T = BuildConfig.FLAVOR;
                if (ExchangeActivity.this.X1()) {
                    ExchangeActivity.this.k3();
                } else {
                    ExchangeActivity.this.u3();
                }
            }
            g2.e.j(ExchangeActivity.this.f3684c, Boolean.TRUE);
            if (!ExchangeActivity.this.H0) {
                ExchangeActivity.this.G1 = false;
                if (ExchangeActivity.this.w1()) {
                    return;
                }
                VLog.d("BBKCalculator/ExchangeActivity", "onClick: other input " + z1.e.e(id));
                if (!z1.e.e(id)) {
                    ExchangeActivity exchangeActivity = ExchangeActivity.this;
                    exchangeActivity.v3(exchangeActivity.f3714m.getTextString(), true);
                }
                if (id == R.id.e_digit_00) {
                    ExchangeActivity.this.C0(id, true);
                    ExchangeActivity exchangeActivity2 = ExchangeActivity.this;
                    exchangeActivity2.E2(exchangeActivity2.f3714m);
                }
                ExchangeActivity.this.C0(id, true);
                ExchangeActivity exchangeActivity3 = ExchangeActivity.this;
                exchangeActivity3.E2(exchangeActivity3.f3714m);
                ExchangeActivity.this.U1(ExchangeActivity.P1);
                return;
            }
            ExchangeActivity.this.F1 = false;
            if (ExchangeActivity.this.w1()) {
                return;
            }
            VLog.d("BBKCalculator/ExchangeActivity", "onClick: local input " + z1.e.e(id));
            if (!z1.e.e(id)) {
                ExchangeActivity exchangeActivity4 = ExchangeActivity.this;
                exchangeActivity4.l3(exchangeActivity4.f3711l.getTextString(), true);
            }
            if (id == R.id.e_digit_00) {
                ExchangeActivity.this.B0(id, true);
                ExchangeActivity exchangeActivity5 = ExchangeActivity.this;
                exchangeActivity5.C2(exchangeActivity5.f3711l);
            }
            ExchangeActivity.this.B0(id, true);
            ExchangeActivity exchangeActivity6 = ExchangeActivity.this;
            exchangeActivity6.C2(exchangeActivity6.f3711l);
            ExchangeActivity.this.S1(ExchangeActivity.P1);
            VLog.d("BBKCalculator/ExchangeActivity", "onClick: mLocResultText == " + ExchangeActivity.this.f3717n.getTextString());
        }
    }

    class n extends BroadcastReceiver {
        n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            VLog.d("BBKCalculator/ExchangeActivity", "mScreenReceiver action = " + action);
            if (!"android.intent.action.SCREEN_OFF".equals(action) || Build.VERSION.SDK_INT <= 26) {
                return;
            }
            ExchangeActivity.this.setShowWhenLocked(false);
        }
    }

    static /* synthetic */ class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3770a;

        static {
            int[] iArr = new int[x.values().length];
            f3770a = iArr;
            try {
                iArr[x.RESULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3770a[x.INIT_FOR_RESULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3770a[x.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3770a[x.INIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3770a[x.EVALUATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3770a[x.INPUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    class p implements d2.c<CurrencyEntry> {
        p() {
        }

        @Override // r0.p.a
        public void b(r0.u uVar) {
            if (uVar != null) {
                VLog.d("BBKCalculator/ExchangeActivity", " requestCurrency  NoConnectionErrorvv:" + uVar.toString());
                if (TextUtils.isEmpty(ExchangeActivity.this.Y)) {
                    ExchangeActivity.this.J1();
                } else {
                    ExchangeActivity.this.B3();
                    ExchangeActivity exchangeActivity = ExchangeActivity.this;
                    exchangeActivity.x3(exchangeActivity.getResources().getString(R.string.network_connection_failed));
                }
            }
            ExchangeActivity.this.B1();
            ExchangeActivity.this.n2();
            ExchangeActivity.this.o2();
        }

        @Override // d2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(CurrencyEntry currencyEntry) {
            ExchangeActivity exchangeActivity = ExchangeActivity.this;
            exchangeActivity.f3682b0 = new c2.b(exchangeActivity.f3684c);
            VLog.d("BBKCalculator/ExchangeActivity", "requestCurrency,onSuccessResponse. currencyEntry == " + currencyEntry);
            if (currencyEntry == null || currencyEntry.getRetcode() != 0 || currencyEntry.getData() == null || currencyEntry.getData().size() <= 0) {
                VLog.d("BBKCalculator/ExchangeActivity", "requestCurrency onSuccessResponse:  mVer" + ExchangeActivity.this.Y);
                if (TextUtils.isEmpty(ExchangeActivity.this.Y)) {
                    ExchangeActivity.this.J1();
                } else {
                    ExchangeActivity.this.B3();
                    ExchangeActivity exchangeActivity2 = ExchangeActivity.this;
                    exchangeActivity2.x3(exchangeActivity2.getResources().getString(R.string.connection_server_abnormal));
                }
                ExchangeActivity.this.n2();
                ExchangeActivity.this.o2();
            } else {
                List<CurrencyEntry.DataBean> data = currencyEntry.getData();
                VLog.d("BBKCalculator/ExchangeActivity", "requestCurrency onSuccessResponse: " + currencyEntry.getVer());
                ExchangeActivity.this.f3700h0.putString("ver", currencyEntry.getVer());
                if (ExchangeActivity.this.f3697g0.getBoolean("is_first", true)) {
                    c2.a.c(ExchangeActivity.this.f3684c).onUpgrade(ExchangeActivity.this.f3693f, 1, 1);
                }
                ExchangeActivity.this.x2();
                ExchangeActivity.this.f3693f.beginTransaction();
                for (int i3 = 0; i3 < data.size(); i3++) {
                    try {
                        try {
                            String curr = data.get(i3).getCurr();
                            if (!curr.equals("BYR")) {
                                ExchangeActivity.this.F3(data.get(i3).getCy(), curr, data.get(i3).getName());
                            }
                            c2.b bVar = ExchangeActivity.this.f3682b0;
                            String curr2 = data.get(i3).getCurr();
                            String cy = data.get(i3).getCy();
                            String name = data.get(i3).getName();
                            g2.e unused = ExchangeActivity.this.f3679a0;
                            ContentValues contentValuesA = bVar.a(curr2, cy, name, g2.e.e(data.get(i3).getName()));
                            ExchangeActivity.this.E0 = new String[]{data.get(i3).getCurr()};
                            if (!ExchangeActivity.this.f3682b0.f(ExchangeActivity.this.f3684c, contentValuesA, "curr=?", ExchangeActivity.this.E0)) {
                                ExchangeActivity.this.f3682b0.c(ExchangeActivity.this.f3684c, CountryProvide.f4144c, contentValuesA);
                            }
                        } catch (Exception e3) {
                            VLog.e("BBKCalculator/ExchangeActivity", "requestCurrency  e == " + e3);
                            ExchangeActivity.this.f3693f.endTransaction();
                            if (ExchangeActivity.this.f3693f.isOpen()) {
                            }
                            VLog.d("BBKCalculator/ExchangeActivity", "requestCurrency onSuccessResponse:  Name ==" + ExchangeActivity.this.O + ExchangeActivity.this.P);
                            if (!TextUtils.isEmpty(ExchangeActivity.this.O)) {
                                g2.e unused2 = ExchangeActivity.this.f3679a0;
                                g2.e.g(ExchangeActivity.this.f3684c, ExchangeActivity.this.P, ExchangeActivity.this.O);
                            }
                            ExchangeActivity.this.V2();
                            ExchangeActivity.this.W1();
                            ExchangeActivity exchangeActivity3 = ExchangeActivity.this;
                            exchangeActivity3.O2(exchangeActivity3.M, ExchangeActivity.this.N);
                            ExchangeActivity.this.f3700h0.apply();
                        }
                    } catch (Throwable th) {
                        ExchangeActivity.this.f3693f.endTransaction();
                        if (ExchangeActivity.this.f3693f.isOpen()) {
                            ExchangeActivity.this.Q0();
                        }
                        throw th;
                    }
                }
                ExchangeActivity.this.f3693f.setTransactionSuccessful();
                ExchangeActivity.this.f3693f.endTransaction();
                if (ExchangeActivity.this.f3693f.isOpen()) {
                    ExchangeActivity.this.Q0();
                }
                VLog.d("BBKCalculator/ExchangeActivity", "requestCurrency onSuccessResponse:  Name ==" + ExchangeActivity.this.O + ExchangeActivity.this.P);
                if (!TextUtils.isEmpty(ExchangeActivity.this.O) && !TextUtils.isEmpty(ExchangeActivity.this.P)) {
                    g2.e unused3 = ExchangeActivity.this.f3679a0;
                    g2.e.g(ExchangeActivity.this.f3684c, ExchangeActivity.this.P, ExchangeActivity.this.O);
                }
                ExchangeActivity.this.V2();
                ExchangeActivity.this.W1();
                ExchangeActivity exchangeActivity4 = ExchangeActivity.this;
                exchangeActivity4.O2(exchangeActivity4.M, ExchangeActivity.this.N);
                ExchangeActivity.this.f3700h0.apply();
            }
            ExchangeActivity.this.B1();
        }
    }

    class q implements d2.c<ExchangeEntry> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3773b;

        q(String str, String str2) {
            this.f3772a = str;
            this.f3773b = str2;
        }

        @Override // r0.p.a
        public void b(r0.u uVar) {
            VLog.d("BBKCalculator/ExchangeActivity", "onErrorResponse " + uVar);
            if (uVar instanceof r0.j) {
                if (TextUtils.isEmpty(ExchangeActivity.this.Y)) {
                    ExchangeActivity.this.J1();
                } else {
                    ExchangeActivity exchangeActivity = ExchangeActivity.this;
                    exchangeActivity.x3(exchangeActivity.getResources().getString(R.string.network_connection_failed));
                    ExchangeActivity.this.B3();
                }
            } else if (TextUtils.isEmpty(ExchangeActivity.this.Y)) {
                ExchangeActivity.this.J1();
            } else {
                ExchangeActivity exchangeActivity2 = ExchangeActivity.this;
                exchangeActivity2.x3(exchangeActivity2.getResources().getString(R.string.connection_server_abnormal));
                ExchangeActivity.this.B3();
            }
            ExchangeActivity.this.B1();
            ExchangeActivity.this.n2();
            ExchangeActivity.this.o2();
        }

        @Override // d2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(ExchangeEntry exchangeEntry) {
            VLog.d("BBKCalculator/ExchangeActivity", "requestExchange,onSuccessResponse.");
            if (exchangeEntry == null || exchangeEntry.getRetcode() != 0 || exchangeEntry.getData() == null) {
                VLog.d("BBKCalculator/ExchangeActivity", "onSuccessResponse: update_fail");
                if (!TextUtils.isEmpty(ExchangeActivity.this.Y)) {
                    ExchangeActivity exchangeActivity = ExchangeActivity.this;
                    exchangeActivity.x3(exchangeActivity.getResources().getString(R.string.connection_server_abnormal));
                    ExchangeActivity.this.B3();
                }
            } else {
                VLog.d("BBKCalculator/ExchangeActivity", "exchange:" + this.f3772a + ":" + this.f3773b);
                if (ExchangeActivity.this.U != null && ExchangeActivity.this.V != null && !TextUtils.isEmpty(ExchangeActivity.this.U)) {
                    TextUtils.isEmpty(ExchangeActivity.this.V);
                }
                ExchangeActivity exchangeActivity2 = ExchangeActivity.this;
                exchangeActivity2.f3682b0 = new c2.b(exchangeActivity2.f3684c);
                BBKCalculatorApplication.p(false);
                ExchangeActivity.this.x2();
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(String.valueOf(exchangeEntry.getData().getRate()));
                        Iterator<String> itKeys = jSONObject.keys();
                        ExchangeActivity.this.f3693f.beginTransaction();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            String string = jSONObject.getString(next);
                            if (next.equalsIgnoreCase(ExchangeActivity.this.M)) {
                                ExchangeActivity.this.X = string;
                            }
                            if (next.equalsIgnoreCase(ExchangeActivity.this.N)) {
                                ExchangeActivity.this.W = string;
                            }
                            ContentValues contentValuesB = ExchangeActivity.this.f3682b0.b(next, string);
                            ExchangeActivity.this.E0 = new String[]{next};
                            ExchangeActivity.this.f3682b0.f(ExchangeActivity.this.f3684c, contentValuesB, "curr=?", ExchangeActivity.this.E0);
                        }
                        ExchangeActivity.this.f3693f.setTransactionSuccessful();
                    } catch (Exception e3) {
                        VLog.e("BBKCalculator/ExchangeActivity", "requestExchange,Exception " + e3);
                    }
                    ExchangeActivity.this.f3693f.endTransaction();
                    ExchangeActivity.this.Q0();
                    ExchangeActivity.this.W0();
                    ExchangeActivity exchangeActivity3 = ExchangeActivity.this;
                    ExchangeActivity.P1 = exchangeActivity3.t2(exchangeActivity3.W, ExchangeActivity.this.X);
                    VLog.d("BBKCalculator/ExchangeActivity", "onSuccessResponse: mExchange  == " + ExchangeActivity.P1);
                    if (ExchangeActivity.this.f3697g0.getBoolean("input_type", false)) {
                        x xVar = ExchangeActivity.this.A1;
                        x xVar2 = x.ERROR;
                        if (xVar != xVar2 && ExchangeActivity.this.B1 != xVar2) {
                            if (ExchangeActivity.this.f3697g0.getBoolean("input_type", false) && ExchangeActivity.this.X1()) {
                                ExchangeActivity.this.f3720o.p();
                                ExchangeActivity.this.D1 = true;
                                ExchangeActivity.this.S1(ExchangeActivity.P1);
                            } else {
                                ExchangeActivity.this.f3717n.q();
                                ExchangeActivity.this.E1 = true;
                                ExchangeActivity.this.U1(ExchangeActivity.P1);
                            }
                        }
                    } else {
                        ExchangeActivity.this.U = "1";
                        ExchangeActivity.this.V = ExchangeActivity.P1;
                        ExchangeActivity.this.P0();
                        ExchangeActivity.this.c3();
                        g2.e unused = ExchangeActivity.this.f3679a0;
                        g2.e.j(ExchangeActivity.this.f3684c, Boolean.FALSE);
                        g2.e unused2 = ExchangeActivity.this.f3679a0;
                        g2.e.h(ExchangeActivity.this.f3684c, "1", ExchangeActivity.P1 + BuildConfig.FLAVOR);
                        ExchangeActivity.this.D1();
                    }
                    g2.e unused3 = ExchangeActivity.this.f3679a0;
                    g2.e.n(ExchangeActivity.this.f3684c, exchangeEntry.getData().getCfrom(), exchangeEntry.getData().getCfromEn());
                    ExchangeActivity.this.a3(System.currentTimeMillis());
                    g2.e unused4 = ExchangeActivity.this.f3679a0;
                    g2.e.i(ExchangeActivity.this.f3684c, ExchangeActivity.P1 + BuildConfig.FLAVOR, ExchangeActivity.this.X, ExchangeActivity.this.W);
                    if (ExchangeActivity.this.K != null) {
                        ExchangeActivity.this.N1();
                        if (!TextUtils.isEmpty(ExchangeActivity.this.Y) && ExchangeActivity.this.f3738u != null) {
                            ExchangeActivity.this.f3738u.setVisibility(0);
                            ExchangeActivity.this.A3();
                        }
                        ExchangeActivity.this.f3();
                        ExchangeActivity.this.E3(false);
                        ExchangeActivity.this.f3735t.setVisibility(8);
                        if (ExchangeActivity.this.f3697g0 != null && ExchangeActivity.this.f3697g0.getBoolean("is_first", true)) {
                            ExchangeActivity.this.k1();
                            ExchangeActivity.this.f3700h0.putBoolean("is_first", false);
                            ExchangeActivity.this.f3700h0.apply();
                        }
                        VLog.d("BBKCalculator/ExchangeActivity", "requestExchange: KEY_IS_FIRST = " + ExchangeActivity.this.f3697g0.getBoolean("is_first", true));
                    }
                } catch (Throwable th) {
                    ExchangeActivity.this.f3693f.endTransaction();
                    ExchangeActivity.this.Q0();
                    throw th;
                }
            }
            ExchangeActivity.this.B1();
            ExchangeActivity.this.n2();
            ExchangeActivity.this.o2();
        }
    }

    class r implements Runnable {
        r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExchangeActivity.this.f3714m.setVisibility(0);
            ExchangeActivity.this.f3711l.setVisibility(0);
        }
    }

    class s implements View.OnLongClickListener {
        s() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!ExchangeActivity.this.f3697g0.getBoolean("input_type", false)) {
                VLog.d("BBKCalculator/ExchangeActivity", "onLongClick,default status，return.");
                return true;
            }
            ExchangeActivity.this.i2();
            h2.a.a().f(69);
            return true;
        }
    }

    class t extends ActionMode.Callback2 {
        t() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 0);
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
            ExchangeActivity.this.p2(actionMode, menu, 0);
            return true;
        }
    }

    class u extends ActionMode.Callback2 {
        u() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 0);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.f3711l.setSelectAllOnFocus(true);
            ExchangeActivity.this.f3711l.selectAll();
            ExchangeActivity.this.f3691e0 = true;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            ExchangeActivity.this.f3711l.setSelectAllOnFocus(false);
            ExchangeActivity.this.f3691e0 = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.p2(actionMode, menu, 0);
            return true;
        }
    }

    class v implements View.OnDragListener {
        v() {
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            return true;
        }
    }

    class w extends ActionMode.Callback2 {
        w() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            ExchangeActivity.this.g2(actionMode, menuItem, 1);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            ExchangeActivity.this.f3714m.setSelectAllOnFocus(false);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ExchangeActivity.this.p2(actionMode, menu, 1);
            return true;
        }
    }

    private enum x {
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

    private class y extends BroadcastReceiver {
        private y() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Throwable {
            VLog.d("BBKCalculator/ExchangeActivity", "onReceive: ");
            ExchangeActivity exchangeActivity = ExchangeActivity.this;
            exchangeActivity.N2(exchangeActivity.o1(), BuildConfig.FLAVOR);
            ExchangeActivity.this.K1 = true;
        }

        /* synthetic */ y(ExchangeActivity exchangeActivity, k kVar) {
            this();
        }
    }

    private static final class z extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<ExchangeActivity> f3791a;

        /* synthetic */ z(ExchangeActivity exchangeActivity, k kVar) {
            this(exchangeActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            super.handleMessage(message);
            ExchangeActivity exchangeActivity = this.f3791a.get();
            if (exchangeActivity == null || exchangeActivity.isFinishing()) {
                return;
            }
            exchangeActivity.u1(message);
        }

        private z(ExchangeActivity exchangeActivity) {
            this.f3791a = null;
            this.f3791a = new WeakReference<>(exchangeActivity);
        }
    }

    private void A1() {
        TextView textView;
        InputTextView inputTextView = this.f3714m;
        if (inputTextView != null && this.f3711l != null) {
            inputTextView.setVisibility(4);
            this.f3711l.setVisibility(4);
            this.f3714m.setTextString(this.U);
            this.f3711l.setTextString(this.V);
        }
        if (TextUtils.isEmpty(this.Y) || (textView = this.f3738u) == null) {
            return;
        }
        textView.setVisibility(0);
        A3();
    }

    private void A2() {
        boolean zV1 = v1();
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(this.f3684c).getBoolean("preferences_button_tone", false);
        StringBuilder sb = new StringBuilder();
        sb.append("should load rhythm: ");
        sb.append(z2);
        sb.append(!zV1);
        VLog.d("BBKCalculator/ExchangeActivity", sb.toString());
        if (!z2) {
            K2();
        } else {
            if (zV1) {
                return;
            }
            K2();
            f2.a aVar = new f2.a();
            O1 = aVar;
            aVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i3, boolean z2) {
        if (this.A1 == x.INPUT && i3 == R.id.e_op_sub) {
            this.f3687d.i(0L).h1();
        }
        D0(i3, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        if (this.f3714m.getVisibility() == 4 || this.f3711l.getVisibility() == 4) {
            this.H1.postDelayed(new r(), 100L);
        }
    }

    private void B2(InputTextView inputTextView) {
        SpannableStringBuilder spannableStringBuilderN1 = this.f3687d.i(0L).n1(this.f3684c);
        VLog.d("BBKCalculator/ExchangeActivity", "redisplayAfterLocalForExChange: formula == " + ((Object) spannableStringBuilderN1));
        VLog.d("BBKCalculator/ExchangeActivity", "redisplayAfterLocalForExChange: mUnprocessedChars == " + this.C1);
        String str = this.C1;
        if (str != null) {
            spannableStringBuilderN1.append(str, this.J1, 33);
        }
        y3(x.INPUT);
        if (w1()) {
            this.f3687d.h2();
        } else {
            Y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3() {
        m1();
        D1();
        N1();
        if (this.K != null) {
            E3(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i3, boolean z2) {
        E0(i3, z2);
    }

    private void C1() {
        InputTextView inputTextView = this.f3714m;
        if (inputTextView == null || this.f3717n == null) {
            return;
        }
        Z1 = inputTextView.getTextSize();
        Y1 = this.f3711l.getTextSize();
        f3671d2 = this.f3717n.getTextSize();
        f3670c2 = this.f3720o.getTextSize();
        f3669b2 = this.f3684c.getResources().getDimension(R.dimen.exchange_input_text_small_size);
        f3668a2 = this.f3684c.getResources().getDimension(R.dimen.exchange_input_text_small_size);
        f3675h2 = this.f3711l.getLayoutParams().height;
        f3674g2 = this.f3714m.getLayoutParams().height;
        f3676i2 = (int) this.f3684c.getResources().getDimension(R.dimen.exchange_input_small_height);
        f3672e2 = this.f3717n.getLayoutParams().height;
        f3673f2 = this.f3720o.getLayoutParams().height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2(InputTextView inputTextView) {
        G2(inputTextView);
        y3(x.INPUT);
        if (g2.b.q(inputTextView.getTextString().replace(",", BuildConfig.FLAVOR))) {
            this.f3717n.c();
        }
        if (inputTextView.getTextString().isEmpty()) {
            i2();
        } else if (w1()) {
            this.f3687d.h2();
        } else {
            Y0();
        }
    }

    private void D0(int i3, boolean z2) {
        x xVar = this.A1;
        if (xVar == x.ERROR) {
            y3(x.INPUT);
        } else if (xVar == x.RESULT || xVar == x.INIT_FOR_RESULT) {
            G3(i3, this.f3711l.getSelectionStart() < this.f3711l.getText().length());
        }
        this.f3687d.X(i3, this.f3711l.isCursorVisible() ? this.f3711l.getSelectionStart() : this.f3711l.getText().length(), z2);
        if (this.f3711l.isCursorVisible() || !this.H0) {
            return;
        }
        this.f3711l.setCursorVisible(true);
        InputTextView inputTextView = this.f3711l;
        inputTextView.setSelection(inputTextView.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        TextView textView;
        if (this.f3714m != null && this.f3711l != null && !this.f3697g0.getBoolean("input_type", false)) {
            this.H0 = false;
            this.f3714m.setTextString("1");
            this.f3717n.q();
            this.E1 = true;
            V1("1");
            U1(P1);
        }
        if (TextUtils.isEmpty(this.Y) || (textView = this.f3738u) == null) {
            return;
        }
        textView.setVisibility(0);
        A3();
    }

    private void D2(InputTextView inputTextView) {
        SpannableStringBuilder spannableStringBuilderO1 = this.f3690e.k(0L).o1(this.f3684c);
        VLog.d("BBKCalculator/ExchangeActivity", "redisplayAfterOtherForExChange:   formula == " + ((Object) spannableStringBuilderO1));
        VLog.d("BBKCalculator/ExchangeActivity", "redisplayAfterOtherForExChange: mUnprocessedChars == " + this.C1);
        String str = this.C1;
        if (str != null) {
            spannableStringBuilderO1.append(str, this.J1, 33);
        }
        g3(x.INPUT);
        if (w1()) {
            this.f3690e.i2();
        } else {
            Z0();
        }
    }

    private void D3() {
        Intent intent = new Intent("android.settings.panel.action.INTERNET_CONNECTIVITY");
        intent.setFlags(268435456);
        try {
            this.f3684c.startActivity(intent);
        } catch (ActivityNotFoundException e3) {
            VLog.e("BBKCalculator/ExchangeActivity", "settingNet e" + e3);
        }
    }

    private void E0(int i3, boolean z2) {
        x xVar = this.B1;
        if (xVar == x.ERROR) {
            g3(x.INPUT);
        } else if (xVar == x.RESULT || xVar == x.INIT_FOR_RESULT) {
            H3(i3, this.f3714m.getSelectionStart() < this.f3714m.getText().length());
        }
        this.f3690e.Y(i3, this.f3714m.isCursorVisible() ? this.f3714m.getSelectionStart() : this.f3714m.getText().length(), z2);
        if (this.f3714m.isCursorVisible() || this.H0) {
            return;
        }
        this.f3714m.setCursorVisible(true);
        InputTextView inputTextView = this.f3714m;
        inputTextView.setSelection(inputTextView.getText().length());
    }

    private void E1() throws Throwable {
        VLog.d("BBKCalculator/ExchangeActivity", "initExchangeView: ");
        f3();
        k1();
        if (this.f3697g0.getBoolean("is_first", true)) {
            M3(0);
            N2(o1(), BuildConfig.FLAVOR);
            return;
        }
        if (BBKCalculatorApplication.g()) {
            A1();
            M3(0);
            b3();
            N2(o1(), BuildConfig.FLAVOR);
            return;
        }
        if (!TextUtils.isEmpty(this.Y)) {
            this.K.setVisibility(0);
            K3();
        } else {
            D1();
            f3();
            M3(0);
            N2(o1(), BuildConfig.FLAVOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2(InputTextView inputTextView) {
        F2(inputTextView);
        g3(x.INPUT);
        if (g2.b.q(inputTextView.getTextString().replace(",", BuildConfig.FLAVOR))) {
            this.f3720o.b();
        }
        if (inputTextView.getTextString().isEmpty()) {
            i2();
        } else if (w1()) {
            this.f3690e.i2();
        } else {
            Z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E3(boolean z2) {
        this.K.setAlpha(0.0f);
        this.K.setVisibility(0);
        z3(z2);
        g2.a.a(this.K, 0.0f, 1.0f, 250L, g2.a.b(0.4f, 0.0f, 0.6f, 1.0f)).start();
    }

    private void F0(CalculatorLocResult calculatorLocResult) {
        calculatorLocResult.announceForAccessibility(getResources().getString(R.string.cleared));
    }

    private void F1() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.source_layout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.keyboard_ex_layout);
        ImageView imageView = (ImageView) findViewById(R.id.arrow_icon1);
        ImageView imageView2 = (ImageView) findViewById(R.id.arrow_icon);
        ColorExButton colorExButton = (ColorExButton) findViewById(R.id.e_clr);
        ColorExButton colorExButton2 = (ColorExButton) findViewById(R.id.e_del);
        ColorExButton colorExButton3 = (ColorExButton) findViewById(R.id.e_op_mul);
        ColorExButton colorExButton4 = (ColorExButton) findViewById(R.id.e_op_div);
        ColorExButton colorExButton5 = (ColorExButton) findViewById(R.id.e_op_sub);
        ColorExButton colorExButton6 = (ColorExButton) findViewById(R.id.e_op_add);
        ColorExButton colorExButton7 = (ColorExButton) findViewById(R.id.e_digit_00);
        ColorExButton colorExButton8 = (ColorExButton) findViewById(R.id.e_digit_1);
        ColorExButton colorExButton9 = (ColorExButton) findViewById(R.id.e_digit_2);
        ColorExButton colorExButton10 = (ColorExButton) findViewById(R.id.e_digit_3);
        ColorExButton colorExButton11 = (ColorExButton) findViewById(R.id.e_digit_4);
        ColorExButton colorExButton12 = (ColorExButton) findViewById(R.id.e_digit_5);
        ColorExButton colorExButton13 = (ColorExButton) findViewById(R.id.e_digit_6);
        ColorExButton colorExButton14 = (ColorExButton) findViewById(R.id.e_digit_7);
        ColorExButton colorExButton15 = (ColorExButton) findViewById(R.id.e_digit_8);
        ColorExButton colorExButton16 = (ColorExButton) findViewById(R.id.e_digit_9);
        ColorExButton colorExButton17 = (ColorExButton) findViewById(R.id.e_digit_0);
        if (g2.b.b(this)) {
            this.f3706j0.setBackgroundColor(getColor(R.color.calculator_background_material));
            linearLayout.setBackgroundColor(getColor(R.color.calculator_background_material));
            linearLayout2.setBackgroundColor(getColor(R.color.calculator_background_material));
            this.f3726q.setTextColor(getColor(R.color.input_text_color_material));
            this.f3714m.setTextColor(getColor(R.color.input_text_color_material));
            this.f3723p.setTextColor(getColor(R.color.input_text_color_material));
            this.f3711l.setTextColor(getColor(R.color.input_text_color_material));
            this.f3732s.setTextColor(getColor(R.color.code_text_color_material));
            this.f3729r.setTextColor(getColor(R.color.code_text_color_material));
            this.f3717n.setTextColor(getColor(R.color.exchange_result_color_material));
            this.f3720o.setTextColor(getColor(R.color.exchange_result_color_material));
            imageView.setImageResource(R.drawable.arrow_icon_material);
            imageView2.setImageResource(R.drawable.arrow_icon_material);
            this.f3714m.setTextCursorDrawable(getDrawable(R.drawable.my_excursor_material));
            this.f3714m.setTextSelectHandle(getDrawable(R.drawable.vg_text_select_handle_middle_material));
            this.f3714m.setTextColor(getColor(R.color.input_text_color_material));
            this.f3714m.setHighlightColor(getColor(R.color.bt_special_button_background_material));
            this.f3711l.setTextCursorDrawable(getDrawable(R.drawable.my_excursor_material));
            this.f3711l.setTextSelectHandle(getDrawable(R.drawable.vg_text_select_handle_middle_material));
            this.f3711l.setTextColor(getColor(R.color.input_text_color_material));
            this.f3711l.setHighlightColor(getColor(R.color.bt_special_button_background_material));
            this.f3717n.setHighlightColor(getColor(R.color.bt_special_button_background_material));
            this.f3720o.setHighlightColor(getColor(R.color.bt_special_button_background_material));
            Drawable drawableD = u.a.d(this.f3684c, R.drawable.exchange_denghao_bg_nex_material);
            Drawable drawableD2 = u.a.d(this.f3684c, R.drawable.exchange_denghao_bg_nex_material);
            if (drawableD2 != null) {
                Drawable drawableR = x.a.r(drawableD2);
                x.a.n(drawableR, g2.b.h(0.8f, getColor(R.color.function_text_blue_stroke_color_material)));
                drawableD = g2.b.l(u.a.d(this.f3684c, R.drawable.exchange_denghao_bg_nex_material), drawableR);
            }
            if (g2.b.o(this)) {
                this.f3712l0.setBackground(drawableD);
                this.f3715m0.setBackgroundResource(R.drawable.colornumber_select_nex_material);
            } else {
                this.f3712l0.setImageResource(R.drawable.exchange_equal_bg_selector_material);
                this.f3715m0.setBackgroundResource(R.drawable.colornumber_select_material);
            }
            ColorExButton[] colorExButtonArr = {colorExButton, colorExButton2, colorExButton3, colorExButton4, colorExButton5, colorExButton6, colorExButton7, colorExButton8, colorExButton9, colorExButton10, colorExButton11, colorExButton12, colorExButton13, colorExButton14, colorExButton15, colorExButton16, colorExButton17};
            int[] iArr = {R.drawable.ac_material, R.drawable.clear_material, R.drawable.chenghao_material, R.drawable.chuhao_material, R.drawable.minus_material, R.drawable.plus_material, R.drawable.digit00_material, R.drawable.digit1_material, R.drawable.digit2_material, R.drawable.digit3_material, R.drawable.digit4_material, R.drawable.digit5_material, R.drawable.digit6_material, R.drawable.digit7_material, R.drawable.digit8_material, R.drawable.digit9_material, R.drawable.digit0_material};
            for (int i3 = 0; i3 < 17; i3++) {
                if (colorExButtonArr[i3] != null) {
                    colorExButtonArr[i3].setImageResource(iArr[i3]);
                    if (i3 <= 5) {
                        if (g2.b.o(this)) {
                            colorExButtonArr[i3].setBackgroundResource(R.drawable.colorspecialbutton_select_nex_material);
                        } else {
                            colorExButtonArr[i3].setBackgroundResource(R.drawable.colorspecialbutton_select_material);
                        }
                    } else if (g2.b.o(this)) {
                        colorExButtonArr[i3].setBackgroundResource(R.drawable.colornumber_select_nex_material);
                    } else {
                        colorExButtonArr[i3].setBackgroundResource(R.drawable.colornumber_select_material);
                    }
                }
            }
        }
    }

    private void G0(CalculatorOthResult calculatorOthResult) {
        calculatorOthResult.announceForAccessibility(getResources().getString(R.string.cleared));
    }

    private void G1() {
        this.F1 = this.f3697g0.getBoolean("LOC_ERROR_STATE", false);
        this.G1 = this.f3697g0.getBoolean("OTH_ERROR_STATE", false);
        this.N = this.f3697g0.getString("other_currency_code", null);
        this.M = this.f3697g0.getString("local_currency_code", null);
        this.P = this.f3697g0.getString("other_currency", null);
        this.O = this.f3697g0.getString("local_currency", null);
        this.Q = this.f3697g0.getString("local_country_code", null);
        this.R = this.f3697g0.getString("other_country_code", null);
        this.W = this.f3697g0.getString("other_exchange", null);
        String string = this.f3697g0.getString("local_exchange", null);
        this.X = string;
        P1 = t2(this.W, string);
        this.Y = this.f3697g0.getString("ver", BuildConfig.FLAVOR);
        VLog.d("BBKCalculator/ExchangeActivity", "initInputData: mOtherCurrencyCode == " + this.N + "  mLocalCurrencyCode == " + this.M);
        VLog.d("BBKCalculator/ExchangeActivity", "initInputData: mOtherExchange == " + this.W + "  mLocalExchange == " + this.X + ",mExchange:" + P1);
    }

    private void G3(int i3, boolean z2) {
        if (z1.e.l(i3) || z1.e.p(i3)) {
            g2.b.f4760a = true;
            com.vivo.calculator.b bVar = this.f3687d;
            bVar.u0(bVar.j1());
        } else {
            this.f3687d.q0();
        }
        y3(x.INPUT);
    }

    private double H0(String str, double d3) {
        String strValueOf = String.valueOf(d3);
        if ("Infinity".equals(strValueOf) || !strValueOf.contains(".") || !b2(str)) {
            return d3;
        }
        int iMax = 0;
        for (String str2 : str.split("[+]|[−]|-")) {
            if (str2.contains(".")) {
                String strSubstring = str2.trim().substring(str2.indexOf("."));
                while (strSubstring != null && strSubstring.endsWith("0")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                }
                if (strSubstring != null) {
                    iMax = Math.max(iMax, strSubstring.length() - 1);
                }
            }
        }
        VLog.d("BBKCalculator/ExchangeActivity", "digitLengthMax：" + iMax);
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
        numberInstance.setMaximumFractionDigits(iMax);
        double d4 = Double.parseDouble(numberInstance.format(d3).replace(",", BuildConfig.FLAVOR));
        VLog.d("BBKCalculator/ExchangeActivity", "avoidFloatingPointNumErrorInAddAndSub result=" + d4);
        return d4;
    }

    private void H3(int i3, boolean z2) {
        if (z1.e.l(i3) || z1.e.p(i3)) {
            g2.b.f4760a = true;
            com.vivo.calculator.b bVar = this.f3690e;
            bVar.v0(bVar.j1());
        } else {
            VLog.d("BBKCalculator/ExchangeActivity", "switchToInputEx: AsyncExchangeReevaluator ");
            this.f3690e.r0();
        }
        g3(x.INPUT);
    }

    private void I2() {
        if (this.Z == null) {
            this.Z = new y(this, null);
            this.f3684c.registerReceiver(this.Z, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        }
    }

    private String I3(double d3, int i3) {
        String strSubstring;
        String strValueOf;
        String strValueOf2 = String.valueOf(d3);
        if (strValueOf2 == null) {
            return "NaN";
        }
        int iIndexOf = strValueOf2.indexOf(69);
        if (iIndexOf != -1) {
            strSubstring = strValueOf2.substring(0, iIndexOf);
            String strSubstring2 = strValueOf2.substring(iIndexOf + 1);
            if (strSubstring2.startsWith("+")) {
                strSubstring2 = strSubstring2.substring(1);
            }
            strValueOf = String.valueOf(Integer.parseInt(strSubstring2));
        } else {
            strSubstring = strValueOf2;
            strValueOf = null;
        }
        if (strValueOf != null) {
            strSubstring = strSubstring + 'E' + strValueOf;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "tryFormattingWithExPrecision,result:" + strSubstring);
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J0(boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "cancelIfEvaluating: mCurrentState == " + this.A1);
        if (this.A1 != x.EVALUATE) {
            return false;
        }
        this.f3687d.h0(0L, z2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1() {
        ViewStub viewStub = this.f3699h;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
        LinearLayout linearLayout = this.B;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        f3();
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.net_error_viewstub);
        this.f3696g = viewStub2;
        if (this.F != null || viewStub2 == null || this.A != null) {
            if (this.A != null) {
                this.D.setBackground(getResources().getDrawable(R.drawable.reconnet_network_svg));
                this.A.setVisibility(0);
                return;
            }
            return;
        }
        View viewInflate = viewStub2.inflate();
        this.F = viewInflate;
        this.A = (LinearLayout) viewInflate.findViewById(R.id.net_error);
        this.D = (ImageView) this.F.findViewById(R.id.net_error_image);
        this.f3747x = (Button) this.F.findViewById(R.id.net_refresh);
        this.f3744w = (Button) this.F.findViewById(R.id.net_setting);
        this.f3747x.setOnClickListener(this);
        this.f3744w.setOnClickListener(this);
    }

    private void J2() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(this.L1, intentFilter);
    }

    private void J3() {
        y yVar = this.Z;
        if (yVar != null) {
            this.f3684c.unregisterReceiver(yVar);
            this.Z = null;
        }
        unregisterReceiver(this.L1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K0(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("cancelIfEvaluatingEx: mExCurrentState ");
        x xVar = this.B1;
        x xVar2 = x.EVALUATE;
        sb.append(xVar == xVar2);
        VLog.d("BBKCalculator/ExchangeActivity", sb.toString());
        if (this.B1 != xVar2) {
            return false;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "cancelIfEvaluatingEx: cancelExchange ");
        this.f3690e.j0(0L, z2);
        return true;
    }

    private void K1() {
        ViewStub viewStub = this.f3696g;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
        f3();
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.no_net_viewstub);
        this.f3699h = viewStub2;
        if (this.E != null || viewStub2 == null) {
            LinearLayout linearLayout = this.B;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                this.C.setBackground(getResources().getDrawable(R.drawable.reconnet_network_svg));
                return;
            }
            return;
        }
        View viewInflate = viewStub2.inflate();
        this.E = viewInflate;
        this.B = (LinearLayout) viewInflate.findViewById(R.id.no_net_view);
        this.C = (ImageView) this.E.findViewById(R.id.no_connect_image);
        this.f3753z = (Button) this.E.findViewById(R.id.no_net_refresh);
        this.f3750y = (Button) this.E.findViewById(R.id.no_net_setting);
        this.f3741v = (TextView) this.E.findViewById(R.id.net_title);
        this.f3753z.setOnClickListener(this);
        this.f3750y.setOnClickListener(this);
        if (g2.b.b(this)) {
            this.f3741v.setTextColor(getColor(R.color.exchange_net_notification_text_color_material));
            this.f3750y.setTextColor(getColor(R.color.function_text_blue_color_material));
            this.f3750y.setBackgroundResource(R.drawable.connect_background_selector_material);
            this.f3753z.setTextColor(getColor(R.color.function_text_blue_color_material));
            this.f3753z.setBackgroundResource(R.drawable.connect_background_selector_material);
        }
    }

    private void K2() {
        f2.a aVar = O1;
        if (aVar != null) {
            aVar.n();
            O1 = null;
        }
    }

    private void K3() throws Throwable {
        VLog.d("BBKCalculator/ExchangeActivity", "upDateView: ");
        String country = getResources().getConfiguration().locale.getCountry();
        String string = this.f3697g0.getString("local_country", null);
        P0();
        if (!country.equalsIgnoreCase(string)) {
            VLog.d("BBKCalculator/ExchangeActivity", "upDateView: oldLocal = " + string);
            M3(0);
            N2(o1(), BuildConfig.FLAVOR);
        }
        N1();
        m1();
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        x xVar = this.A1;
        x xVar2 = x.INPUT;
        if (xVar == xVar2) {
            this.f3687d.h0(0L, true);
        }
        if (this.B1 == xVar2) {
            this.f3687d.j0(0L, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3() throws Throwable {
        this.Y = this.f3697g0.getString("ver", BuildConfig.FLAVOR);
        VLog.i("BBKCalculator/ExchangeActivity", "updateOntouch: " + Y1());
        C3(true);
        if (Y1()) {
            N2(o1(), BuildConfig.FLAVOR);
        } else if (this.K != null) {
            O2(this.M, this.N);
        }
        U2();
    }

    private SpannableString M0(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void M2(int i3) {
        if (i3 == R.id.e_dec_point) {
            h2.a.a().f(67);
        }
        if (i3 == R.id.e_digit_00) {
            h2.a.a().f(25);
            return;
        }
        switch (i3) {
            case R.id.e_op_add /* 2131230939 */:
                h2.a.a().f(21);
                break;
            case R.id.e_op_div /* 2131230940 */:
                h2.a.a().f(19);
                break;
            case R.id.e_op_mul /* 2131230941 */:
                h2.a.a().f(20);
                break;
            case R.id.e_op_sub /* 2131230942 */:
                h2.a.a().f(18);
                break;
        }
    }

    private void M3(int i3) {
        RefreshLinearLayout refreshLinearLayout = this.L;
        if (refreshLinearLayout != null) {
            refreshLinearLayout.setHeadViewPaddingTop(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1() {
        TextView textView;
        if (this.f3732s == null || this.f3729r == null || (textView = this.f3726q) == null || this.f3723p == null) {
            return;
        }
        textView.setText(this.P);
        this.f3723p.setText(this.O);
        this.f3732s.setText(this.N);
        this.f3729r.setText(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2(String str, String str2) throws Throwable {
        String strC = g2.e.c();
        this.f3748x0 = 0;
        if (TextUtils.isEmpty(this.Q) || TextUtils.isEmpty(this.R)) {
            b1(strC);
        }
        if (g2.e.b(this.f3684c)) {
            VLog.d("BBKCalculator/ExchangeActivity", "requestCurrency: KEY_IS_FIRST == " + this.f3697g0.getBoolean("is_first", true));
            String strC2 = d2.b.g().c();
            String strB = d2.b.g().b(str, str2);
            BBKCalculatorApplication.a().d().b("tag_load_currencylist");
            d2.a aVar = new d2.a(1, strC2, strB, CurrencyEntry.class, new p());
            aVar.L(new r0.e(20000, 1, 1.0f));
            aVar.N(false);
            aVar.O("tag_load_currencylist");
            BBKCalculatorApplication.a().d().a(aVar);
            return;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "requestCurrency: getConnectionStatus is false mVer : " + this.Y);
        if (TextUtils.isEmpty(this.Y)) {
            K1();
        } else {
            x3(getResources().getString(R.string.no_internet));
            m1();
            D1();
            N1();
            RelativeLayout relativeLayout = this.K;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
        B1();
        M3(-1);
        n2();
        o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2(String str, String str2) {
        VLog.d("BBKCalculator/ExchangeActivity", " requestExchange," + str + ":" + str2 + this.Y);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (!g2.e.b(this.f3684c)) {
            if (!TextUtils.isEmpty(this.Y)) {
                x3(getResources().getString(R.string.no_internet));
                m1();
                D1();
            }
            B1();
            n2();
            o2();
            return;
        }
        String strD = d2.b.g().d();
        String strF = d2.b.g().f(str, str2);
        BBKCalculatorApplication.a().d().b("tag_load_exchange");
        d2.a aVar = new d2.a(1, strD, strF, ExchangeEntry.class, new q(str, str2));
        aVar.L(new r0.e(20000, 1, 1.0f));
        aVar.N(false);
        aVar.O("tag_load_exchange");
        BBKCalculatorApplication.a().d().a(aVar);
    }

    private void R2() {
        String str;
        if (X1()) {
            H1();
            L1();
        } else {
            L1();
            H1();
        }
        VLog.d("BBKCalculator/ExchangeActivity", "restoreDisplay mCurrentState " + this.A1);
        VLog.d("BBKCalculator/ExchangeActivity", "restoreDisplay mExCurrentState " + this.B1);
        VLog.d("BBKCalculator/ExchangeActivity", "restoreDisplay: mIsLocalInput " + this.H0);
        if (X1()) {
            I1();
            M1();
        } else {
            M1();
            I1();
        }
        if (TextUtils.isEmpty(this.f3711l.getTextString()) && TextUtils.isEmpty(this.f3714m.getTextString())) {
            boolean z2 = false;
            if (!this.f3697g0.getBoolean("IS_EXCHANGE_UPDATE", false)) {
                this.U = this.f3697g0.getString("other_input", null);
                this.V = this.f3697g0.getString("local_input", null);
                this.S = this.f3697g0.getString("local_result", null);
                this.T = this.f3697g0.getString("other_result", null);
                x xVar = x.INPUT;
                this.B1 = xVar;
                this.A1 = xVar;
                boolean z3 = this.f3697g0.getBoolean("IS_EQUP", false);
                if (this.H0) {
                    if (!this.f3688d0 && (str = this.V) != null && !g2.h.b(str) && !TextUtils.isEmpty(this.S)) {
                        z2 = true;
                    }
                    this.E1 = z2;
                    this.f3727q0 = z2;
                    this.f3749x1 = z2;
                    T1(this.V);
                    S1(P1);
                } else {
                    if (!z3 && !TextUtils.isEmpty(this.T) && !g2.h.b(this.U)) {
                        z2 = true;
                    }
                    this.D1 = z2;
                    this.f3730r0 = z2;
                    this.f3740u1 = z2;
                    V1(this.U);
                    U1(P1);
                }
                this.f3700h0.putBoolean("IS_EXCHANGE_UPDATE", true);
                this.f3700h0.commit();
            }
        }
        b3();
    }

    private void S2() {
        if (g2.b.t(this.f3684c)) {
            this.f3714m.clearFocus();
        }
    }

    private void U0(InputTextView inputTextView) {
        if (inputTextView.getSelectionStart() <= 0) {
            return;
        }
        int iG1 = x.RESULT == this.A1 ? this.f3687d.g1(inputTextView.getTextString().length()) : this.f3687d.g1(inputTextView.getSelectionStart());
        int length = inputTextView.getTextString().length();
        String strB0 = this.f3687d.B0(inputTextView.getSelectionStart());
        String strValueOf = String.valueOf(z1.e.i());
        if (".".equals(strValueOf)) {
            strValueOf = "\\.";
        }
        if (TextUtils.isEmpty(strB0)) {
            return;
        }
        G2(inputTextView);
        inputTextView.e(iG1, inputTextView.length());
        String strReplaceAll = strB0.replaceAll(strValueOf, BuildConfig.FLAVOR);
        if (this.f3687d.e0(strReplaceAll)) {
            int length2 = strReplaceAll.length();
            for (int i3 = 0; i3 < length2; i3++) {
                this.f3687d.X(z1.e.A(this.f3684c, String.valueOf(strReplaceAll.charAt(i3))), inputTextView.getSelectionStart(), true);
                G2(inputTextView);
            }
            if (length == this.f3687d.i(0L).n1(this.f3684c).length()) {
                iG1++;
            }
            inputTextView.a(this.f3687d.i(0L).n1(this.f3684c));
            C2(this.f3711l);
            inputTextView.e(iG1, inputTextView.length());
        }
    }

    private void V0(InputTextView inputTextView) {
        if (inputTextView.getSelectionStart() <= 0) {
            return;
        }
        int iH1 = x.RESULT == this.B1 ? this.f3690e.h1(inputTextView.getTextString().length()) : this.f3690e.h1(inputTextView.getSelectionStart());
        int length = inputTextView.getTextString().length();
        String strC0 = this.f3690e.C0(inputTextView.getSelectionStart());
        String strValueOf = String.valueOf(z1.e.i());
        if (".".equals(strValueOf)) {
            strValueOf = "\\.";
        }
        if (TextUtils.isEmpty(strC0)) {
            return;
        }
        F2(this.f3714m);
        inputTextView.e(iH1, inputTextView.length());
        String strReplaceAll = strC0.replaceAll(strValueOf, BuildConfig.FLAVOR);
        if (this.f3690e.e0(strReplaceAll)) {
            int length2 = strReplaceAll.length();
            for (int i3 = 0; i3 < length2; i3++) {
                this.f3690e.Y(z1.e.A(this.f3684c, String.valueOf(strReplaceAll.charAt(i3))), inputTextView.getSelectionStart(), true);
                F2(inputTextView);
            }
            if (length == this.f3690e.k(0L).o1(this.f3684c).length()) {
                iH1++;
            }
            inputTextView.a(this.f3690e.k(0L).o1(this.f3684c));
            E2(this.f3714m);
            inputTextView.e(iH1, inputTextView.length());
        }
    }

    private void X2(boolean z2) {
        if (z2) {
            this.f3700h0.putBoolean("LOC_ERROR_STATE", true);
        } else {
            this.f3700h0.putBoolean("LOC_ERROR_STATE", false);
        }
        this.f3700h0.commit();
    }

    private boolean Y1() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        return TextUtils.isEmpty(language) || TextUtils.isEmpty(country) || !language.equalsIgnoreCase(this.f3697g0.getString("local_language", null)) || !country.equalsIgnoreCase(this.f3697g0.getString("local_country", null));
    }

    private void Z2(boolean z2) {
        if (z2) {
            this.f3700h0.putBoolean("OTH_ERROR_STATE", true);
        } else {
            this.f3700h0.putBoolean("OTH_ERROR_STATE", false);
        }
        this.f3700h0.commit();
    }

    private boolean b2(String str) {
        if (str == null) {
            return false;
        }
        for (char c3 : str.toCharArray()) {
            if (!g2.h.b(String.valueOf(c3)) && !"-".equals(String.valueOf(c3)) && !"−".equals(String.valueOf(c3)) && !"+".equals(String.valueOf(c3)) && !"(".equals(String.valueOf(c3)) && !")".equals(String.valueOf(c3))) {
                return false;
            }
        }
        return true;
    }

    private void b3() {
        if (this.f3697g0.getBoolean("input_type", false)) {
            if (X1()) {
                k3();
            } else {
                u3();
            }
        }
    }

    static boolean c2(char c3) {
        return "+−×÷/*".indexOf(c3) != -1;
    }

    private float d1() {
        return f3672e2 - f3675h2;
    }

    private x f2(x xVar) {
        switch (o.f3770a[xVar.ordinal()]) {
            case 1:
            case 2:
                return x.INIT_FOR_RESULT;
            case 3:
            case 4:
                return x.INIT;
            default:
                VLog.e("BBKCalculator/ExchangeActivity", "Impossible saved state:" + xVar);
            case 5:
            case 6:
                return xVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g2(ActionMode actionMode, MenuItem menuItem, int i3) {
        if (menuItem != null) {
            int itemId = menuItem.getItemId();
            if (itemId != R.id.it_copy) {
                if (itemId != R.id.it_paste) {
                    return;
                }
                String strD = z1.g.d(a1());
                if (i3 == 0) {
                    O1(strD);
                } else if (i3 == 1) {
                    P1(strD);
                }
                actionMode.finish();
                return;
            }
            if (i3 == 0) {
                g2.h.g(this.f3711l, this.f3685c0);
            } else if (i3 == 1) {
                g2.h.g(this.f3714m, this.f3685c0);
            } else if (i3 == 2) {
                g2.h.e(this.f3717n, this.f3685c0);
            } else {
                g2.h.f(this.f3720o, this.f3685c0);
            }
            actionMode.finish();
            g2.b.B(this.f3684c, R.string.already_copy);
        }
    }

    private void g3(x xVar) {
        VLog.d("BBKCalculator/ExchangeActivity", "setExState: " + xVar);
        if (this.B1 != xVar) {
            if (xVar == x.INPUT) {
                this.f3720o.q(0, null);
                S2();
            }
            this.B1 = xVar;
        }
    }

    private void h2() {
        J0(true);
    }

    private void i3() {
        this.F1 = true;
        x xVar = this.A1;
        if (xVar == x.ERROR || xVar == x.INIT) {
            this.f3717n.setText(this.f3684c.getResources().getString(R.string.error));
            this.f3717n.setVisibility(0);
            this.f3714m.setTextString(this.f3684c.getResources().getString(R.string.error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        InputTextView inputTextView = this.f3711l;
        if (inputTextView == null || this.f3714m == null || this.f3720o == null || this.f3717n == null) {
            return;
        }
        float f3 = ((ViewGroup.MarginLayoutParams) inputTextView.getLayoutParams()).topMargin;
        Q1 = f3;
        S1 = f3;
        float f4 = ((ViewGroup.MarginLayoutParams) this.f3714m.getLayoutParams()).topMargin;
        R1 = f4;
        T1 = f4;
        X1 = ((ViewGroup.MarginLayoutParams) this.f3711l.getLayoutParams()).topMargin + this.f3711l.getLayoutParams().height + ((ViewGroup.MarginLayoutParams) this.f3717n.getLayoutParams()).topMargin;
        W1 = ((ViewGroup.MarginLayoutParams) this.f3714m.getLayoutParams()).topMargin + this.f3714m.getLayoutParams().height + ((ViewGroup.MarginLayoutParams) this.f3720o.getLayoutParams()).topMargin;
        U1 = ((ViewGroup.MarginLayoutParams) this.f3717n.getLayoutParams()).topMargin;
        V1 = ((ViewGroup.MarginLayoutParams) this.f3720o.getLayoutParams()).topMargin;
    }

    private void k2() {
        K0(true);
    }

    private String l1(String str) {
        for (int length = str.length() - 5; length >= 0; length--) {
            if (str.charAt(length) == 't' && str.charAt(length + 1) == 'a' && str.charAt(length + 2) == 'n' && str.charAt(length + 3) == '(' && (length <= 0 || str.charAt(length - 1) != 'a')) {
                int i3 = length + 4;
                int i4 = 1;
                for (int i5 = i3; i5 < str.length(); i5++) {
                    if (str.charAt(i5) == '(') {
                        i4++;
                    }
                    if (str.charAt(i5) == ')') {
                        i4--;
                        if (i4 == 0) {
                            String strSubstring = str.substring(i3, i5);
                            str = str.substring(0, length) + "(sin(" + strSubstring + ")÷cos(" + strSubstring + "))" + str.substring(i5);
                            break;
                        }
                    } else {
                        if (i5 == str.length() - 1) {
                            StringBuilder sb = new StringBuilder(str.substring(i3, i5));
                            for (int i6 = 0; i6 < i4; i6++) {
                                sb.append(')');
                            }
                            str = str.substring(0, length) + "(sin(" + ((Object) sb) + ")÷cos(" + ((Object) sb) + "))";
                            break;
                        }
                    }
                }
            }
        }
        return str;
    }

    private void l2() {
        J0(true);
        this.f3687d.q0();
        y3(x.INPUT);
    }

    private void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append("getInput: INPUT_TYPE = ");
        sb.append(!this.f3697g0.getBoolean("input_type", false));
        VLog.d("BBKCalculator/ExchangeActivity", sb.toString());
        if (this.f3697g0.getBoolean("input_type", false)) {
            if (X1()) {
                k3();
                return;
            } else {
                u3();
                return;
            }
        }
        g2.e.j(this.f3684c, Boolean.FALSE);
        this.V = this.f3697g0.getString("exchange", null);
        this.U = "1";
        c3();
    }

    private void m2() {
        K0(true);
        this.f3690e.r0();
        g3(x.INPUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o1() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        VLog.d("BBKCalculator/ExchangeActivity", "getLanguage  ==" + language + "-" + country);
        return language + "-" + country;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(ActionMode actionMode, Menu menu, int i3) {
        y1(a1(), actionMode, menu, i3);
    }

    private void p3() {
        VLog.d("BBKCalculator/ExchangeActivity", "setMessage: ");
        M3(0);
        Message messageObtainMessage = this.H1.obtainMessage();
        messageObtainMessage.what = 1;
        if (this.H1.hasMessages(1)) {
            this.H1.removeMessages(messageObtainMessage.what);
            BBKCalculatorApplication.a().d().b("tag_load_exchange");
            BBKCalculatorApplication.a().d().b("tag_load_currencylist");
        }
        this.H1.sendMessageDelayed(messageObtainMessage, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        if (J0(false)) {
            VLog.d("BBKCalculator/ExchangeActivity", "onDeleteLocal,cancelIfEvaluating,return.");
            return;
        }
        x xVar = this.A1;
        x xVar2 = x.RESULT;
        if (xVar == xVar2) {
            P2(this.H0);
        } else {
            if (w1()) {
                String str = this.C1;
                this.C1 = str.substring(0, str.length() - 1);
            } else {
                U0(this.f3711l);
            }
            if (this.f3687d.i(0L).Q0() && !w1()) {
                F0(this.f3717n);
            }
        }
        y3(x.INPUT);
        C2(this.f3711l);
        if (this.A1 == xVar2 || !g2.h.b(this.f3711l.getTextString())) {
            return;
        }
        j3(this.f3711l.getTextString(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2() {
        if (K0(false)) {
            VLog.d("BBKCalculator/ExchangeActivity", "onDeleteOther,cancelIfEvaluatingEx,return.");
            return;
        }
        x xVar = this.B1;
        x xVar2 = x.RESULT;
        if (xVar == xVar2) {
            Q2(this.H0);
        } else {
            if (w1()) {
                String str = this.C1;
                this.C1 = str.substring(0, str.length() - 1);
            } else {
                V0(this.f3714m);
            }
            if (this.f3690e.k(0L).R0() && !w1()) {
                G0(this.f3720o);
            }
        }
        g3(x.INPUT);
        E2(this.f3714m);
        if (this.B1 == xVar2 || !g2.h.b(this.f3714m.getTextString())) {
            return;
        }
        t3(this.f3714m.getTextString(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2(boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "onEquals: isTouch == " + z2);
        if (this.H0) {
            this.f3711l.getTextString();
            VLog.d("BBKCalculator/ExchangeActivity", "onEquals: mCurrentState == " + this.A1);
            if (this.A1 != x.INPUT) {
                if (z2) {
                    this.f3717n.setText((CharSequence) null);
                    return;
                } else {
                    i3();
                    return;
                }
            }
            if (w1()) {
                y3(x.EVALUATE);
                b(0L, R.string.error_syntax);
                return;
            } else {
                if (this.f3687d.i(0L).B0()) {
                    y3(x.EVALUATE);
                    this.f3687d.M1(0L, this, this.f3717n);
                    return;
                }
                return;
            }
        }
        VLog.d("BBKCalculator/ExchangeActivity", "onEquals: mExCurrentState == " + this.B1);
        this.f3714m.getTextString();
        if (this.B1 != x.INPUT) {
            if (z2) {
                this.f3720o.setText((CharSequence) null);
                return;
            } else {
                s3();
                return;
            }
        }
        if (w1()) {
            g3(x.EVALUATE);
            b(0L, R.string.error_syntax);
        } else if (this.f3690e.k(0L).C0()) {
            g3(x.EVALUATE);
            this.f3690e.N1(0L, this, this.f3720o);
        }
    }

    private void s3() {
        this.G1 = true;
        x xVar = this.B1;
        if (xVar == x.ERROR || xVar == x.INIT) {
            this.f3720o.setVisibility(0);
            this.f3711l.setTextString(this.f3684c.getResources().getString(R.string.error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(Message message) throws Throwable {
        if (this.H1 != null && message.what == 1) {
            H2();
        }
    }

    private void v2(boolean z2, boolean z3) {
        VLog.d("BBKCalculator/ExchangeActivity", "onResult animate == " + z2);
        VLog.d("BBKCalculator/ExchangeActivity", "onResult resultWasPreserved == " + z3);
        this.f3711l.getMinimumTextSize();
        if (!this.f3717n.n()) {
            this.f3711l.c(this.f3717n.getText().toString());
        }
        this.f3717n.getTextSize();
        CalculatorLocResult calculatorLocResult = this.f3717n;
        calculatorLocResult.setPivotX(calculatorLocResult.getWidth() - this.f3717n.getPaddingRight());
        CalculatorLocResult calculatorLocResult2 = this.f3717n;
        calculatorLocResult2.setPivotY(calculatorLocResult2.getHeight() - this.f3717n.getPaddingBottom());
        this.f3711l.getCurrentTextColor();
        if (z3) {
            this.f3687d.J1();
        } else {
            this.f3687d.G1(0L, true);
            String textString = this.f3711l.getTextString();
            this.f3717n.getTextString();
            if (g2.b.r(textString)) {
                g2.b.g(textString);
            }
        }
        if (!z2) {
            y3(x.RESULT);
            return;
        }
        this.f3717n.announceForAccessibility(getResources().getString(R.string.description_equal));
        CalculatorLocResult calculatorLocResult3 = this.f3717n;
        calculatorLocResult3.announceForAccessibility(calculatorLocResult3.getText());
        y3(x.ANIMATE);
        m3(this.f3717n.getText().toString(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w1() {
        String str = this.C1;
        return (str == null || str.isEmpty()) ? false : true;
    }

    private void w2(boolean z2, boolean z3) {
        VLog.d("BBKCalculator/ExchangeActivity", "onResultEx animate == " + z2);
        VLog.d("BBKCalculator/ExchangeActivity", "onResultEx resultWasPreserved == " + z3);
        this.f3714m.getMinimumTextSize();
        if (!this.f3720o.m()) {
            this.f3714m.c(this.f3720o.getText().toString());
        }
        this.f3720o.getTextSize();
        CalculatorOthResult calculatorOthResult = this.f3720o;
        calculatorOthResult.setPivotX(calculatorOthResult.getWidth() - this.f3720o.getPaddingRight());
        CalculatorOthResult calculatorOthResult2 = this.f3720o;
        calculatorOthResult2.setPivotY(calculatorOthResult2.getHeight() - this.f3720o.getPaddingBottom());
        this.f3714m.getCurrentTextColor();
        if (z3) {
            this.f3690e.K1();
        } else {
            this.f3690e.H1(0L, true);
            String textString = this.f3714m.getTextString();
            this.f3720o.getTextString();
            if (g2.b.r(textString)) {
                g2.b.g(textString);
            }
        }
        if (!z2) {
            g3(x.RESULT);
            return;
        }
        this.f3720o.announceForAccessibility(getResources().getString(R.string.description_equal));
        CalculatorOthResult calculatorOthResult3 = this.f3720o;
        calculatorOthResult3.announceForAccessibility(calculatorOthResult3.getText());
        g3(x.ANIMATE);
        w3(this.f3720o.getText().toString(), true);
    }

    private void x1(ActionMode actionMode, int i3, Menu menu) {
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

    /* JADX WARN: Code duplicated, block: B:19:0x0059 A[PHI: r1
  0x0059: PHI (r1v6 boolean) = (r1v5 boolean), (r1v9 boolean), (r1v3 boolean), (r1v3 boolean), (r1v3 boolean) binds: [B:33:0x008f, B:26:0x0075, B:17:0x0056, B:7:0x0028, B:12:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    private void y1(String str, ActionMode actionMode, Menu menu, int i3) {
        VLog.d("BBKCalculator/ExchangeActivity", "inflateMeun: inputType " + i3 + " clipDataStrTrim == " + str);
        int i4 = 2;
        boolean z2 = true;
        if (i3 == 0) {
            z2 = (this.f3711l.length() == 0 || this.f3711l.getSelectionStart() == this.f3711l.getSelectionEnd()) ? false : true;
            if (str == null) {
                i4 = 0;
            }
        } else if (i3 == 1) {
            z2 = (this.f3714m.length() == 0 || this.f3714m.getSelectionStart() == this.f3714m.getSelectionEnd()) ? false : true;
            if (str == null) {
                i4 = 0;
            }
        } else if (i3 != 2) {
            i4 = 0;
            z2 = false;
        } else {
            i4 = 0;
            z2 = false;
        }
        if (z2) {
            i4 |= 1;
        }
        x1(actionMode, i4, menu);
    }

    private void y3(x xVar) {
        VLog.d("BBKCalculator/ExchangeActivity", "setState: " + xVar);
        if (this.A1 != xVar) {
            if (xVar == x.INPUT) {
                this.f3717n.r(0, null);
                S2();
            }
            this.A1 = xVar;
        }
    }

    private void z1() {
        ColorExButton colorExButton = (ColorExButton) findViewById(R.id.e_del);
        this.f3708k = colorExButton;
        if (colorExButton != null) {
            colorExButton.setOnLongClickListener(new s());
        }
        I2();
        J2();
        this.f3706j0 = (RelativeLayout) findViewById(R.id.calculator_exchange_layout);
        this.f3702i = (PullToRefreshScrollView) findViewById(R.id.pull_to_refresh);
        this.K = (RelativeLayout) findViewById(R.id.countrys);
        this.I = (RelativeLayout) findViewById(R.id.local_country_info);
        this.J = (RelativeLayout) findViewById(R.id.other_country_info);
        this.f3714m = (InputTextView) findViewById(R.id.other_input);
        this.f3711l = (InputTextView) findViewById(R.id.local_input);
        this.f3717n = (CalculatorLocResult) findViewById(R.id.local_result);
        this.f3720o = (CalculatorOthResult) findViewById(R.id.other_result);
        this.f3723p = (TextView) findViewById(R.id.local_currency);
        this.f3726q = (TextView) findViewById(R.id.other_currency);
        this.f3729r = (TextView) findViewById(R.id.local_currency_code);
        this.f3732s = (TextView) findViewById(R.id.other_currency_code);
        this.G = findViewById(R.id.line_one);
        this.H = findViewById(R.id.line_two);
        g2.g.f(this.G, 0);
        g2.g.f(this.H, 0);
        this.f3735t = (TextView) findViewById(R.id.net_notification);
        this.f3738u = (TextView) findViewById(R.id.data_notification);
        this.L = (RefreshLinearLayout) findViewById(R.id.refresh_layout);
        this.f3705j = (RefreshHeaderLayout) findViewById(R.id.header_layout);
        this.f3712l0 = (ColorExButton) findViewById(R.id.e_eq);
        this.f3715m0 = (ColorExButton) findViewById(R.id.e_dec_point);
        if (".".equals(g2.b.f4762c)) {
            if (g2.b.b(this)) {
                this.f3715m0.setImageResource(R.drawable.dot_material);
            } else {
                this.f3715m0.setImageResource(R.drawable.dot);
            }
        } else if (g2.b.b(this)) {
            this.f3715m0.setImageResource(R.drawable.comma_material);
        } else {
            this.f3715m0.setImageResource(R.drawable.comma);
        }
        F1();
        G1();
        this.K.setOnTouchListener(this);
        this.J.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.f3711l.setInputType(524289);
        this.f3711l.setShowSoftInputOnFocus(false);
        this.f3711l.setSingleLine(true);
        this.f3711l.setZoom(true);
        this.f3711l.setCursorVisible(false);
        this.f3711l.setOnTouchListener(this);
        this.f3711l.setLongClickable(true);
        this.f3714m.setInputType(524289);
        this.f3714m.setShowSoftInputOnFocus(false);
        this.f3714m.setSingleLine(true);
        this.f3714m.setCursorVisible(false);
        this.f3714m.setZoom(true);
        this.f3714m.setOnTouchListener(this);
        this.f3714m.setLongClickable(true);
        this.f3717n.setShowSoftInputOnFocus(false);
        this.f3717n.setSingleLine(true);
        this.f3717n.setCursorVisible(false);
        this.f3717n.setLongClickable(true);
        this.f3717n.setFocusable(true);
        this.f3717n.setKeyListener(null);
        this.f3717n.setTextIsSelectable(true);
        this.f3720o.setShowSoftInputOnFocus(false);
        this.f3720o.setSingleLine(true);
        this.f3720o.setCursorVisible(false);
        this.f3720o.setLongClickable(true);
        this.f3720o.setFocusable(true);
        this.f3720o.setKeyListener(null);
        this.f3720o.setTextIsSelectable(true);
        this.f3717n.setExchangeActivity(this);
        this.f3720o.setExchangeActivity(this);
        this.f3717n.p(this.f3687d, 0L);
        this.f3720o.o(this.f3690e, 0L);
        z1.e.v(this);
        this.f3711l.setCustomInsertionActionModeCallback(new t());
        this.f3711l.setCustomSelectionActionModeCallback(new u());
        this.f3711l.setOnDragListener(new v());
        this.f3714m.setCustomInsertionActionModeCallback(new w());
        this.f3714m.setCustomSelectionActionModeCallback(new a());
        this.f3714m.setOnDragListener(new b());
        this.f3717n.setCustomInsertionActionModeCallback(new c());
        this.f3717n.setCustomSelectionActionModeCallback(new d());
        this.f3717n.setOnDragListener(new e());
        this.f3720o.setCustomInsertionActionModeCallback(new f());
        this.f3720o.setCustomSelectionActionModeCallback(new g());
        this.f3720o.setOnDragListener(new h());
        this.f3702i.setOnScrollViewListener(new i());
        this.f3702i.setOnRefreshListener(new j());
    }

    private String z2(double d3, int i3) {
        String strTrim = I3(d3, i3).trim();
        if (!strTrim.equals("NaN") && !strTrim.equals(this.C0)) {
            return strTrim.replace((char) 8722, '-').replace("Infinity", "∞");
        }
        this.A0 = true;
        return this.C0;
    }

    public void A3() {
        Long lValueOf = Long.valueOf(this.f3697g0.getLong("update_date", 0L));
        if (TextUtils.isEmpty(lValueOf + BuildConfig.FLAVOR) || this.f3738u == null) {
            return;
        }
        this.f3738u.setText(s1(lValueOf.longValue()));
    }

    public void C3(boolean z2) {
        this.M1 = z2;
    }

    void F2(InputTextView inputTextView) {
        SpannableStringBuilder spannableStringBuilderO1 = this.f3690e.k(0L).o1(this.f3684c);
        VLog.d("BBKCalculator/ExchangeActivity", "redisplayExFormula:  formula == " + ((Object) spannableStringBuilderO1));
        VLog.d("BBKCalculator/ExchangeActivity", "redisplayExFormula:  mUnprocessedChars == " + this.C1);
        String str = this.C1;
        if (str != null) {
            spannableStringBuilderO1.append(str, this.J1, 33);
        }
        this.V = ((Object) spannableStringBuilderO1) + BuildConfig.FLAVOR;
        inputTextView.b(spannableStringBuilderO1);
    }

    public void F3(String str, String str2, String str3) {
        if (this.f3748x0 == 2) {
            return;
        }
        this.f3682b0 = new c2.b(this.f3684c);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3682b0 = new c2.b(this.f3684c);
        String[] strArrSplit = str.split("\n");
        for (int i3 = 0; i3 < strArrSplit.length && !TextUtils.isEmpty(this.R) && !TextUtils.isEmpty(this.Q); i3++) {
            if (this.R.equals(strArrSplit[i3])) {
                this.N = str2;
                this.P = str3;
                this.f3748x0++;
            }
            if (this.Q.equals(strArrSplit[i3])) {
                this.M = str2;
                this.O = str3;
                this.f3748x0++;
            }
        }
    }

    void G2(InputTextView inputTextView) {
        SpannableStringBuilder spannableStringBuilderN1 = this.f3687d.i(0L).n1(this.f3684c);
        VLog.d("BBKCalculator/ExchangeActivity", " redisplayFormula:  formula == " + ((Object) spannableStringBuilderN1));
        String str = this.C1;
        if (str != null) {
            spannableStringBuilderN1.append(str, this.J1, 33);
        }
        this.U = ((Object) spannableStringBuilderN1) + BuildConfig.FLAVOR;
        inputTextView.b(spannableStringBuilderN1);
    }

    public void H1() {
        y3(x.values()[this.f3697g0.getInt("Exchange_display_loc_state", x.INPUT.ordinal())]);
        this.f3721o0 = this.A1 == x.ERROR;
        String string = this.f3697g0.getString("Exchange_unprocessed_chars", null);
        if (string != null) {
            this.C1 = string.toString();
        }
        if (this.A1 != x.RESULT) {
            this.f3687d.n();
        }
    }

    public void H2() throws Throwable {
        VLog.i("BBKCalculator/ExchangeActivity", "refreshOntouch: ");
        N2(o1(), BuildConfig.FLAVOR);
    }

    public void I0() {
        ValueAnimator valueAnimator = this.K0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.K0 = null;
        }
        ValueAnimator valueAnimator2 = this.M0;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.M0 = null;
        }
        ValueAnimator valueAnimator3 = this.O0;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.O0 = null;
        }
        ValueAnimator valueAnimator4 = this.Q0;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
            this.Q0 = null;
        }
        ValueAnimator valueAnimator5 = this.S0;
        if (valueAnimator5 != null) {
            valueAnimator5.cancel();
            this.S0 = null;
        }
    }

    public void I1() {
        x xVar = this.A1;
        if (xVar == x.RESULT || xVar == x.INIT_FOR_RESULT) {
            this.f3690e.r0();
            this.f3687d.q0();
            x xVar2 = x.INPUT;
            this.B1 = xVar2;
            this.A1 = xVar2;
            T1(this.f3697g0.getString("local_result", null));
        } else if (this.H0) {
            G2(this.f3711l);
        }
        x xVar3 = this.A1;
        if (xVar3 == x.INPUT) {
            this.f3717n.r(1, this);
        } else {
            y3(f2(xVar3));
            this.f3717n.r(2, this);
        }
        if (TextUtils.isEmpty(this.f3714m.getTextString()) && this.f3697g0.getBoolean("IS_EXCHANGE_UPDATE", false)) {
            this.D1 = true;
            this.f3739u0 = true;
            S1(P1);
        }
    }

    public void L1() {
        VLog.d("BBKCalculator/ExchangeActivity", "initOthData: ");
        g3(x.values()[this.f3697g0.getInt("Exchange_display_oth_state", x.INPUT.ordinal())]);
        this.f3724p0 = this.B1 == x.ERROR;
        String string = this.f3697g0.getString("Exchange_unprocessed_chars", null);
        if (string != null) {
            this.C1 = string.toString();
        }
        if (this.B1 != x.RESULT) {
            VLog.d("BBKCalculator/ExchangeActivity", "initOthData: InstanceStateOth ");
            this.f3690e.o();
        }
    }

    public void L2() {
        VLog.d("BBKCalculator/ExchangeActivity", "reportExchangeInfoIfNeeded , mIsUsedExchange:" + this.M1);
        if (this.M1) {
            C3(false);
            h2.a.a().c(this.M, this.N);
        }
    }

    public void M1() {
        x xVar = this.B1;
        if (xVar == x.RESULT || xVar == x.INIT_FOR_RESULT) {
            this.f3690e.r0();
            this.f3687d.q0();
            x xVar2 = x.INPUT;
            this.B1 = xVar2;
            this.A1 = xVar2;
            V1(this.f3697g0.getString("other_result", null));
        } else if (!this.H0) {
            F2(this.f3714m);
        }
        x xVar3 = this.B1;
        if (xVar3 == x.INPUT) {
            this.f3720o.q(1, this);
        } else {
            g3(f2(xVar3));
            this.f3720o.q(2, this);
        }
        if (TextUtils.isEmpty(this.f3711l.getTextString()) && this.f3697g0.getBoolean("IS_EXCHANGE_UPDATE", false)) {
            this.E1 = true;
            this.f3736t0 = true;
            U1(P1);
        }
    }

    public void N0() {
        this.f3717n.setText(BuildConfig.FLAVOR);
    }

    public void N3() {
        this.Q = "US";
        this.M = "USD";
        this.O = getResources().getString(R.string.dollar);
    }

    public void O0() {
        this.f3720o.setText(BuildConfig.FLAVOR);
    }

    public void O1(String str) {
        VLog.d("BBKCalculator/ExchangeActivity", "insertClipLocalProcess  ==  " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int selectionStart = this.f3711l.getSelectionStart();
        int selectionEnd = this.f3711l.getSelectionEnd();
        SpannableStringBuilder spannableStringBuilderN1 = this.f3687d.i(0L).n1(this.f3684c);
        if (selectionStart != selectionEnd) {
            h2();
            j2();
        } else if (this.A1 == x.RESULT || spannableStringBuilderN1 == null) {
            h2();
        } else {
            String string = spannableStringBuilderN1.toString();
            if (!TextUtils.isEmpty(string)) {
                boolean zContains = str.contains(".");
                if (selectionStart > string.length()) {
                    selectionStart = string.length();
                } else if (selectionStart < 0) {
                    selectionStart = 0;
                }
                String strSubstring = string.substring(0, selectionStart);
                String strSubstring2 = string.substring(selectionStart);
                if (!g2.h.b(strSubstring2)) {
                    int i3 = selectionStart;
                    while (i3 < string.length()) {
                        int i4 = i3 + 1;
                        if (!g2.h.b(string.substring(i3, i4)) && !",".equals(string.substring(i3, i4))) {
                            break;
                        }
                        strSubstring2 = string.substring(selectionStart, i3);
                        i3 = i4;
                    }
                }
                if (!g2.h.b(strSubstring)) {
                    for (int i5 = selectionStart; i5 > 0; i5--) {
                        int i6 = i5 - 1;
                        if (!g2.h.b(string.substring(i6, i5)) && !",".equals(string.substring(i6, i5))) {
                            break;
                        }
                        strSubstring = string.substring(i6, selectionStart);
                    }
                }
                VLog.d("BBKCalculator/ExchangeActivity", "insertClipLocalProcess:    startString end  = " + strSubstring2);
                VLog.d("BBKCalculator/ExchangeActivity", "insertClipLocalProcess:    endString start  = " + strSubstring);
                if (zContains && ((g2.h.b(string) && string.contains(".")) || ((g2.h.b(strSubstring2) && strSubstring2.contains(".")) || (g2.h.b(strSubstring) && strSubstring.contains("."))))) {
                    VLog.d("BBKCalculator/ExchangeActivity", "insertClipLocalProcess contains(.)  invalid return");
                    g2.b.B(this, R.string.invalid_clip_data);
                    return;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
        int i7 = 0;
        while (i7 < strReplaceAll.length()) {
            int i8 = i7 + 1;
            int iA = z1.e.A(this.f3684c, strReplaceAll.substring(i7, i8));
            if (-1 == iA) {
                g2.b.B(this, R.string.invalid_clip_data);
                return;
            } else {
                arrayList.add(Integer.valueOf(iA));
                i7 = i8;
            }
        }
        VLog.d("BBKCalculator/ExchangeActivity", "insertClipLocalProcess  start: ");
        J0(false);
        K0(false);
        e3();
        this.F1 = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            B0(((Integer) it.next()).intValue(), true);
            G2(this.f3711l);
        }
        C2(this.f3711l);
        if (!g2.h.b(this.f3711l.getTextString())) {
            l3(this.f3711l.getTextString(), true);
        }
        S1(P1);
    }

    public void O3() {
        this.R = "US";
        this.N = "USD";
        this.P = getResources().getString(R.string.renminbi);
    }

    public void P0() {
        InputTextView inputTextView = this.f3714m;
        if (inputTextView != null) {
            inputTextView.clearFocus();
        }
        InputTextView inputTextView2 = this.f3711l;
        if (inputTextView2 != null) {
            inputTextView2.clearFocus();
        }
    }

    public void P1(String str) {
        VLog.d("BBKCalculator/ExchangeActivity", "insertClipOtherProcess  ==  " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int selectionStart = this.f3714m.getSelectionStart();
        int selectionEnd = this.f3714m.getSelectionEnd();
        SpannableStringBuilder spannableStringBuilderO1 = this.f3690e.k(0L).o1(this.f3684c);
        if (selectionStart != selectionEnd) {
            h2();
            j2();
        } else if (this.B1 == x.RESULT || spannableStringBuilderO1 == null) {
            h2();
        } else {
            String string = spannableStringBuilderO1.toString();
            if (!TextUtils.isEmpty(string)) {
                boolean zContains = str.contains(".");
                if (selectionStart > string.length()) {
                    selectionStart = string.length();
                } else if (selectionStart < 0) {
                    selectionStart = 0;
                }
                String strSubstring = string.substring(0, selectionStart);
                String strSubstring2 = string.substring(selectionStart);
                if (!g2.h.b(strSubstring2)) {
                    int i3 = selectionStart;
                    while (i3 < string.length()) {
                        int i4 = i3 + 1;
                        if (!g2.h.b(string.substring(i3, i4)) && !",".equals(string.substring(i3, i4))) {
                            break;
                        }
                        strSubstring2 = string.substring(selectionStart, i3);
                        i3 = i4;
                    }
                }
                if (!g2.h.b(strSubstring)) {
                    for (int i5 = selectionStart; i5 > 0; i5--) {
                        int i6 = i5 - 1;
                        if (!g2.h.b(string.substring(i6, i5)) && !",".equals(string.substring(i6, i5))) {
                            break;
                        }
                        strSubstring = string.substring(i6, selectionStart);
                    }
                }
                VLog.d("BBKCalculator/ExchangeActivity", "insertClipOtherProcess:    startString end  = " + strSubstring2);
                VLog.d("BBKCalculator/ExchangeActivity", "insertClipOtherProcess:    endString start  = " + strSubstring);
                if (zContains && ((g2.h.b(string) && string.contains(".")) || ((g2.h.b(strSubstring2) && strSubstring2.contains(".")) || (g2.h.b(strSubstring) && strSubstring.contains("."))))) {
                    VLog.d("BBKCalculator/ExchangeActivity", "insertClipOtherProcess contains(.)  invalid return");
                    g2.b.B(this, R.string.invalid_clip_data);
                    return;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
        int i7 = 0;
        while (i7 < strReplaceAll.length()) {
            int i8 = i7 + 1;
            int iA = z1.e.A(this.f3684c, strReplaceAll.substring(i7, i8));
            if (-1 == iA) {
                g2.b.B(this, R.string.invalid_clip_data);
                return;
            } else {
                arrayList.add(Integer.valueOf(iA));
                i7 = i8;
            }
        }
        VLog.d("BBKCalculator/ExchangeActivity", "insertClipOtherProcess  start: ");
        J0(false);
        K0(false);
        e3();
        this.G1 = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0(((Integer) it.next()).intValue(), true);
            F2(this.f3714m);
        }
        E2(this.f3714m);
        if (!g2.h.b(this.f3714m.getTextString())) {
            v3(this.f3714m.getTextString(), true);
        }
        U1(P1);
    }

    public void P2(boolean z2) {
        String strG1 = g1();
        if (this.f3688d0 && !g2.h.i(strG1)) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            C1();
            if (this.T0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.T0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.T0.addListener(this);
                this.T0.addUpdateListener(this);
            }
            this.T0.start();
            if (this.V0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.V0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.V0.addListener(this);
                this.V0.addUpdateListener(this);
            }
            this.V0.start();
        }
        this.f3688d0 = false;
        this.f3749x1 = true;
    }

    public synchronized void Q0() {
        SQLiteDatabase sQLiteDatabase = this.f3693f;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public void Q1(String str, String str2) {
        if (!str.equals(this.C0)) {
            str = g2.b.D(str);
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            B0(z1.e.A(this.f3684c, str.substring((str.length() - i3) - 1, str.length() - i3)), false);
        }
        B0(R.id.e_op_mul, false);
        if (str2.length() == 1) {
            B0(z1.e.A(this.f3684c, str2), false);
            return;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "insertExprToLocal:  input == " + str2);
        for (int length = str2.length(); length > 0; length--) {
            B0(z1.e.A(this.f3684c, str2.substring(length - 1, length)), false);
        }
    }

    public void Q2(boolean z2) {
        String strI1 = i1();
        if (this.f3743v1 && !g2.h.i(strI1)) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            C1();
            if (this.X0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.X0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.X0.addListener(this);
                this.X0.addUpdateListener(this);
            }
            this.X0.start();
            if (this.Z0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.Z0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.Z0.addListener(this);
                this.Z0.addUpdateListener(this);
            }
            this.Z0.start();
        }
        this.f3743v1 = false;
        this.f3740u1 = true;
    }

    public void R0() {
        this.Q = "CN";
        this.M = "CNY";
        this.O = getResources().getString(R.string.renminbi);
    }

    public void R1(String str, String str2) {
        if (!str.equals(this.C0)) {
            str = g2.b.D(str);
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            C0(z1.e.A(this.f3684c, str.substring((str.length() - i3) - 1, str.length() - i3)), false);
        }
        C0(R.id.e_op_div, false);
        if (str2.length() == 1) {
            C0(z1.e.A(this.f3684c, str2), false);
            return;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "insertExprToLocal:  input == " + str2);
        for (int length = str2.length(); length > 0; length--) {
            C0(z1.e.A(this.f3684c, str2.substring(length - 1, length)), false);
        }
    }

    public void S0() {
        this.R = "CN";
        this.N = "CNY";
        this.P = getResources().getString(R.string.renminbi);
    }

    public void S1(String str) {
        m2();
        VLog.d("BBKCalculator/ExchangeActivity", "insertExchange process " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String textString = this.f3711l.getTextString();
        if (TextUtils.isEmpty(textString)) {
            return;
        }
        String strReplaceAll = textString.replaceAll(",", BuildConfig.FLAVOR);
        String strReplaceAll2 = str.replaceAll(",", BuildConfig.FLAVOR);
        if (g2.h.b(strReplaceAll)) {
            R1(strReplaceAll2, strReplaceAll);
        } else if (strReplaceAll.equals(this.f3684c.getResources().getString(R.string.text_dot)) || strReplaceAll.equals(this.f3684c.getResources().getString(R.string.op_add)) || strReplaceAll.equals(this.f3684c.getResources().getString(R.string.op_sub)) || strReplaceAll.equals(this.f3684c.getResources().getString(R.string.op_mul)) || strReplaceAll.equals(this.f3684c.getResources().getString(R.string.op_div))) {
            C0(R.id.e_digit_0, false);
        } else {
            this.f3717n.getTextString();
            VLog.d("BBKCalculator/ExchangeActivity", "insertLocToExchange: input " + strReplaceAll);
            VLog.d("BBKCalculator/ExchangeActivity", "insertLocToExchange: isError " + this.f3721o0);
            String strReplaceAll3 = this.f3711l.getTextString().replaceAll(",", BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(strReplaceAll3) && !g2.h.b(strReplaceAll3.substring(strReplaceAll3.length() - 1))) {
                strReplaceAll3 = strReplaceAll3.substring(0, strReplaceAll3.length() - 1);
            }
            String str2 = "(" + strReplaceAll3.replaceAll(",", BuildConfig.FLAVOR) + ")";
            VLog.d("BBKCalculator/ExchangeActivity", "insertLocExchange:  input result === " + str2);
            R1(strReplaceAll2, str2);
        }
        D2(this.f3714m);
    }

    public void T0() {
        if ("US".equalsIgnoreCase(this.R)) {
            R0();
            return;
        }
        if ("US".equalsIgnoreCase(this.M)) {
            S0();
        } else if ("CN".equalsIgnoreCase(this.M)) {
            N3();
        } else {
            O3();
        }
    }

    public void T1(String str) {
        l2();
        VLog.d("BBKCalculator/ExchangeActivity", "insertProcess process ==  " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
        strReplaceAll.length();
        for (int i3 = 0; i3 < strReplaceAll.length(); i3++) {
            B0(z1.e.A(this.f3684c, strReplaceAll.substring((strReplaceAll.length() - i3) - 1, strReplaceAll.length() - i3)), false);
        }
        G2(this.f3711l);
        y3(x.INPUT);
    }

    public void T2() {
        g2.e.p(this.f3684c, this.R, this.Q, this.N, this.M, this.P, this.O, this.U, this.V);
    }

    public void U1(String str) {
        VLog.d("BBKCalculator/ExchangeActivity", "insertOthToExchange: exchange == " + str);
        l2();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
        String textString = this.f3714m.getTextString();
        VLog.d("BBKCalculator/ExchangeActivity", "insertOthToExchange: other input == " + textString);
        if (TextUtils.isEmpty(textString)) {
            return;
        }
        String strReplaceAll2 = textString.replaceAll(",", BuildConfig.FLAVOR);
        if (g2.h.b(strReplaceAll2)) {
            VLog.d("BBKCalculator/ExchangeActivity", "insertOthToExchange: input  isDigital === " + strReplaceAll2);
            Q1(strReplaceAll, strReplaceAll2);
        } else if (strReplaceAll2.equals(this.f3684c.getResources().getString(R.string.text_dot)) || strReplaceAll2.equals(this.f3684c.getResources().getString(R.string.op_add)) || strReplaceAll2.equals(this.f3684c.getResources().getString(R.string.op_sub)) || strReplaceAll2.equals(this.f3684c.getResources().getString(R.string.op_mul)) || strReplaceAll2.equals(this.f3684c.getResources().getString(R.string.op_div))) {
            B0(R.id.e_digit_0, false);
        } else {
            VLog.d("BBKCalculator/ExchangeActivity", "insertOthToExchange: result ==" + this.f3720o.getTextString());
            String strReplaceAll3 = this.f3714m.getTextString().replaceAll(",", BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(strReplaceAll3) && !g2.h.b(strReplaceAll3.substring(strReplaceAll3.length() - 1))) {
                strReplaceAll3 = strReplaceAll3.substring(0, strReplaceAll3.length() - 1);
            }
            String str2 = "(" + strReplaceAll3.replaceAll(",", BuildConfig.FLAVOR) + ")";
            VLog.d("BBKCalculator/ExchangeActivity", "insertOthToExchange:  input result === " + str2);
            Q1(strReplaceAll, str2);
        }
        B2(this.f3711l);
    }

    public void U2() {
        this.V = this.f3711l.getTextString();
        this.U = this.f3714m.getTextString();
        this.S = this.f3717n.getTextString();
        this.T = this.f3720o.getTextString();
    }

    public void V1(String str) {
        m2();
        VLog.d("BBKCalculator/ExchangeActivity", "insertOtherProcess process " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strReplaceAll = str.replaceAll(",", BuildConfig.FLAVOR);
        strReplaceAll.length();
        VLog.d("BBKCalculator/ExchangeActivity", "insertOtherProcess:  process == " + strReplaceAll);
        for (int i3 = 0; i3 < strReplaceAll.length(); i3++) {
            C0(z1.e.A(this.f3684c, strReplaceAll.substring((strReplaceAll.length() - i3) - 1, strReplaceAll.length() - i3)), false);
        }
        F2(this.f3714m);
        g3(x.INPUT);
    }

    public void V2() {
        g2.e.l(this.f3684c, Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
    }

    public void W0() {
        if ("0".equalsIgnoreCase(this.X) || "0.0".equalsIgnoreCase(this.X) || TextUtils.isEmpty(this.X)) {
            if (!TextUtils.isEmpty(this.Y)) {
                x3(getResources().getString(R.string.connection_server_abnormal));
                return;
            } else if ("US".equalsIgnoreCase(this.R)) {
                R0();
                return;
            } else {
                N3();
                return;
            }
        }
        if ("0".equalsIgnoreCase(this.W) || "0.0".equalsIgnoreCase(this.W) || TextUtils.isEmpty(this.W)) {
            if (!TextUtils.isEmpty(this.Y)) {
                x3(getResources().getString(R.string.connection_server_abnormal));
            } else if ("US".equalsIgnoreCase(this.Q)) {
                R0();
            } else {
                N3();
            }
        }
    }

    public void W1() {
        if (TextUtils.isEmpty(this.N) || TextUtils.isEmpty(this.P) || TextUtils.isEmpty(this.M) || TextUtils.isEmpty(this.O)) {
            T0();
        }
    }

    public void W2() {
        x xVar = this.A1;
        if (xVar == x.RESULT || xVar == x.INIT_FOR_RESULT) {
            InputTextView inputTextView = this.f3711l;
            if (inputTextView != null) {
                this.f3700h0.putString("local_result", inputTextView.getTextString());
            }
        } else {
            this.f3687d.P1(0L);
        }
        this.f3700h0.putInt("Exchange_display_loc_state", this.A1.ordinal());
        this.f3700h0.putString("Exchange_unprocessed_chars", this.C1);
        this.f3700h0.commit();
        this.f3687d.l2();
    }

    String X0(String str) throws y2.x {
        if (str == null) {
            return this.C0;
        }
        String strReplace = str.trim().replace(",", BuildConfig.FLAVOR);
        for (int length = strReplace.length(); length > 0; length--) {
            int i3 = length - 1;
            if (!c2(strReplace.charAt(i3))) {
                break;
            }
            strReplace = strReplace.substring(0, i3);
        }
        String strL1 = l1(strReplace);
        VLog.v("BBKCalculator/ExchangeActivity", "evaluateEx input:" + strL1 + ",input.length:" + strL1.length());
        boolean z2 = true;
        if (BuildConfig.FLAVOR.equals(strL1)) {
            this.A0 = true;
            return this.C0;
        }
        for (int length2 = strL1.length() - 1; length2 >= 0; length2--) {
            if (!Character.isDigit(strL1.charAt(length2))) {
                z2 = false;
            }
        }
        double dDoubleValue = z2 ? Double.valueOf(strL1).doubleValue() : this.f3754z0.g(strL1);
        if (dDoubleValue == 0.0d) {
            dDoubleValue = 0.0d;
        }
        VLog.v("BBKCalculator/ExchangeActivity", "value:" + dDoubleValue);
        String strZ2 = z2(H0(strL1, dDoubleValue), 22);
        this.B0 = strZ2;
        if (strZ2.contains("∞")) {
            this.B0 = this.C0;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "precisionExControl,exresultLandscape=" + this.B0);
        return this.B0;
    }

    public boolean X1() {
        return this.H0;
    }

    public void Y0() {
        VLog.d("BBKCalculator/ExchangeActivity", "evaluateInstantIfNecessary:  ");
        if (this.A1 != x.INPUT || TextUtils.isEmpty(this.f3687d.i(0L).n1(this.f3684c))) {
            return;
        }
        this.f3687d.L0(0L, this, this.f3717n);
    }

    public void Y2() {
        x xVar = this.B1;
        if (xVar == x.RESULT || xVar == x.INIT_FOR_RESULT) {
            InputTextView inputTextView = this.f3714m;
            if (inputTextView != null) {
                this.f3700h0.putString("other_result", inputTextView.getTextString());
            }
        } else {
            this.f3690e.Q1(0L);
        }
        this.f3700h0.putInt("Exchange_display_oth_state", this.B1.ordinal());
        this.f3700h0.putString("Exchange_unprocessed_chars", this.C1);
        this.f3700h0.commit();
        this.f3690e.l2();
    }

    public void Z0() {
        VLog.d("BBKCalculator/ExchangeActivity", "evaluateInstantIfNecessaryEx:  ");
        if (this.B1 != x.INPUT || TextUtils.isEmpty(this.f3690e.k(0L).o1(this.f3684c))) {
            return;
        }
        this.f3690e.M0(0L, this, this.f3720o);
    }

    public boolean Z1() {
        return this.f3736t0;
    }

    @Override // a2.c
    public void a(boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "setCalculatorConfigurationInfo isNexScreenChange = " + z2);
        if (z2) {
            if (g2.b.o(this)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public String a1() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence text;
        ClipboardManager clipboardManager = this.f3685c0;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null) {
            return null;
        }
        return text.toString().trim().replace(",", BuildConfig.FLAVOR);
    }

    public boolean a2() {
        return this.f3739u0;
    }

    public void a3(long j3) {
        String strS1 = s1(j3);
        if (TextUtils.isEmpty(strS1)) {
            return;
        }
        TextView textView = this.f3738u;
        if (textView != null) {
            textView.setText(strS1);
            this.f3738u.setVisibility(0);
        }
        g2.e.o(this.f3684c, j3);
    }

    @Override // com.vivo.calculator.b.j
    public void b(long j3, int i3) {
        if (j3 != 0) {
            throw new AssertionError("Unexpected error source");
        }
        this.f3721o0 = true;
        VLog.d("BBKCalculator/ExchangeActivity", "onError: mCurrentState " + this.A1);
        x xVar = this.A1;
        if (xVar == x.EVALUATE || xVar == x.INIT || xVar != x.INIT_FOR_RESULT) {
            y3(x.ERROR);
        } else {
            y3(x.ERROR);
        }
        this.f3717n.b(j3, i3);
        if (this.H0) {
            if (this.F1) {
                this.f3717n.setVisibility(0);
            } else {
                this.f3717n.setVisibility(8);
            }
            r3();
        } else {
            h3();
        }
        this.f3717n.setEnabled(false);
    }

    public void b1(String str) {
        if (str == null || str.equalsIgnoreCase("N")) {
            this.R = "US";
            this.Q = "CN";
        } else if (str.equals("US")) {
            this.R = "CN";
            this.Q = "US";
        } else {
            this.R = "US";
            this.Q = str;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "getCountry:mOtherCountryCode = " + this.R + " mLocalCountryCode =" + this.Q);
    }

    @Override // com.vivo.calculator.b.i
    public void c(long j3, int i3) {
        VLog.d("BBKCalculator/ExchangeActivity", "onExError: ");
        if (j3 != 0) {
            throw new AssertionError("Unexpected error source");
        }
        this.f3724p0 = true;
        VLog.d("BBKCalculator/ExchangeActivity", "onExError: mExCurrentState " + this.B1);
        x xVar = this.B1;
        if (xVar == x.EVALUATE || xVar == x.INIT || xVar != x.INIT_FOR_RESULT) {
            g3(x.ERROR);
        } else {
            g3(x.ERROR);
        }
        this.f3720o.c(j3, i3);
        if (this.H0) {
            r3();
        } else {
            if (this.G1) {
                this.f3720o.setVisibility(0);
            } else {
                this.f3720o.setVisibility(8);
            }
            h3();
        }
        this.f3720o.setEnabled(false);
    }

    public int c1() {
        return this.f3684c.getResources().getColor(R.color.input_text_default_color);
    }

    public void c3() {
        VLog.d("BBKCalculator/ExchangeActivity", "setDefaultType: mExInputLocal === " + this.f3711l);
        InputTextView inputTextView = this.f3711l;
        if (inputTextView == null || this.f3714m == null) {
            return;
        }
        inputTextView.setTextColor(c1());
        this.f3714m.setTextColor(c1());
    }

    @Override // com.vivo.calculator.b.i
    public void d(long j3) {
        g3(x.INPUT);
    }

    public boolean d2() {
        return this.f3740u1;
    }

    public void d3(boolean z2) {
        this.f3688d0 = z2;
    }

    @Override // com.vivo.calculator.b.i
    public void e(long j3, int i3, int i4, int i5, String str) {
        VLog.d("BBKCalculator/ExchangeActivity", "onExEvaluate:  ");
        if (j3 != 0) {
            throw new AssertionError("Unexpected evaluation result index\n");
        }
        this.f3724p0 = false;
        if (!g2.h.b(this.f3714m.getTextString()) || this.D1) {
            VLog.d("BBKCalculator/ExchangeActivity", "onExEvaluate:   onExEvaluate");
            this.f3720o.setEnabled(true);
            this.D1 = false;
            this.f3720o.e(j3, i3, i4, i5, str);
            x xVar = this.B1;
            if (xVar != x.INPUT) {
                w2(xVar == x.EVALUATE, xVar == x.INIT_FOR_RESULT || xVar == x.RESULT);
            }
        }
        VLog.d("BBKCalculator/ExchangeActivity", "onExEvaluate: display ");
        if (!this.H0 && !this.J0) {
            VLog.d("BBKCalculator/ExchangeActivity", "onExEvaluate: display insertOthToExchange isLocExchange =  " + this.E1);
            this.f3717n.q();
            this.E1 = true;
        }
        this.J0 = false;
    }

    public String e1() {
        return this.C0;
    }

    public boolean e2() {
        return this.f3749x1;
    }

    public void e3() {
        if (this.f3691e0 || this.f3694f0 || ((X1() && this.B1 == x.ERROR && TextUtils.isEmpty(this.f3711l.getTextString())) || (this.A1 == x.ERROR && TextUtils.isEmpty(this.f3714m.getTextString()) && !X1()))) {
            i2();
        }
    }

    @Override // com.vivo.calculator.b.j
    public void f(long j3) {
        y3(x.INPUT);
    }

    public int f1() {
        return this.f3716m1;
    }

    public void f3() {
        LinearLayout linearLayout = this.B;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.A;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @Override // com.vivo.calculator.b.j
    public void g(long j3) {
    }

    public String g1() {
        InputTextView inputTextView = this.f3711l;
        return inputTextView != null ? inputTextView.getTextString() : BuildConfig.FLAVOR;
    }

    @Override // com.vivo.calculator.b.j
    public void h(long j3, int i3, int i4, int i5, String str) {
        VLog.d("BBKCalculator/ExchangeActivity", "onEvaluate: ");
        if (j3 != 0) {
            throw new AssertionError("Unexpected evaluation result index\n");
        }
        this.f3721o0 = false;
        if (!g2.h.b(this.f3711l.getTextString()) || this.E1) {
            this.f3717n.setEnabled(true);
            this.E1 = false;
            this.f3717n.h(j3, i3, i4, i5, str);
            x xVar = this.A1;
            if (xVar != x.INPUT) {
                v2(xVar == x.EVALUATE, xVar == x.INIT_FOR_RESULT || xVar == x.RESULT);
            }
        }
        if (this.H0 && !this.I0) {
            VLog.d("BBKCalculator/ExchangeActivity", "onEvaluate: insertLocToExchange ");
            this.f3720o.p();
            this.D1 = true;
        }
        this.I0 = false;
    }

    public String h1() {
        CalculatorLocResult calculatorLocResult = this.f3717n;
        return calculatorLocResult != null ? calculatorLocResult.getText().toString() : BuildConfig.FLAVOR;
    }

    public void h3() {
        if (this.G1) {
            this.f3711l.setTextString(this.f3684c.getResources().getString(R.string.error));
        } else {
            this.f3711l.setTextString(BuildConfig.FLAVOR);
        }
        this.f3717n.setVisibility(8);
    }

    public void i() {
        if (X1()) {
            W2();
            Y2();
        } else {
            Y2();
            W2();
        }
    }

    public String i1() {
        InputTextView inputTextView = this.f3714m;
        return inputTextView != null ? inputTextView.getTextString() : BuildConfig.FLAVOR;
    }

    public void i2() {
        this.F1 = false;
        this.G1 = false;
        h2();
        k2();
        g2.e.j(this.f3684c, Boolean.TRUE);
        j3(null, true);
        t3(null, true);
        j2();
    }

    public String j1() {
        CalculatorOthResult calculatorOthResult = this.f3720o;
        return calculatorOthResult != null ? calculatorOthResult.getText().toString() : BuildConfig.FLAVOR;
    }

    public void j2() {
        this.C1 = null;
        this.f3717n.c();
        this.f3720o.b();
        this.f3687d.q0();
        this.f3690e.r0();
        x xVar = x.INPUT;
        y3(xVar);
        g3(xVar);
        G2(this.f3711l);
        F2(this.f3714m);
    }

    public void j3(String str, boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "setLocalInputDown:  isUping " + this.f3749x1);
        if (z2 && this.f3749x1) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            VLog.d("BBKCalculator/ExchangeActivity", "setLocalInputDown:  start anim ");
            C1();
            if (this.M0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.M0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.M0.addListener(this);
                this.M0.addUpdateListener(this);
            }
            this.M0.start();
            if (this.Q0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.Q0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.Q0.addListener(this);
                this.Q0.addUpdateListener(this);
            }
            this.Q0.start();
        }
        this.f3749x1 = false;
    }

    public void k3() {
        this.f3711l.setTextColor(n1());
        this.f3711l.requestFocus();
        this.f3711l.setFocusableInTouchMode(true);
        this.f3711l.setCursorVisible(true);
        this.f3714m.setTextColor(n1());
    }

    public void l3(String str, boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "setLocalInputUp:  isUping ==  " + this.f3749x1);
        if (z2 && (!this.f3749x1 || this.f3727q0)) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            C1();
            if (this.K0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.K0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.K0.addListener(this);
                this.K0.addUpdateListener(this);
            }
            this.K0.start();
            if (this.O0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.O0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.O0.addListener(this);
                this.O0.addUpdateListener(this);
            }
            this.O0.start();
        }
        this.f3749x1 = true;
        this.f3688d0 = false;
    }

    public void m3(String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("setLocalResultText:  isUping ");
        sb.append(this.f3749x1);
        sb.append(!this.f3688d0);
        VLog.d("BBKCalculator/ExchangeActivity", sb.toString());
        if (z2 && this.f3749x1 && !this.f3688d0 && !TextUtils.isEmpty(str)) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            C1();
            if (this.S0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.S0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.S0.addListener(this);
                this.S0.addUpdateListener(this);
            }
            this.S0.start();
            if (this.U0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.U0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.U0.addListener(this);
                this.U0.addUpdateListener(this);
            }
            this.U0.start();
        }
        this.f3688d0 = true;
        this.f3749x1 = false;
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            N0();
        }
        if (z2 || BuildConfig.FLAVOR.equals(str) || N1) {
            return;
        }
        this.f3711l.setTextString(str);
    }

    public int n1() {
        return this.f3684c.getResources().getColor(R.color.edit_text_color);
    }

    public void n2() {
        RefreshLinearLayout refreshLinearLayout = this.L;
        if (refreshLinearLayout != null) {
            refreshLinearLayout.c();
        }
    }

    public void n3(boolean z2) {
        this.f3736t0 = z2;
    }

    public void o2() {
        PullToRefreshScrollView pullToRefreshScrollView;
        if (this.f3705j == null || (pullToRefreshScrollView = this.f3702i) == null) {
            return;
        }
        pullToRefreshScrollView.r();
    }

    public void o3(boolean z2) {
        this.f3739u0 = z2;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i3, int i4, Intent intent) throws Throwable {
        super.onActivityResult(i3, i4, intent);
        if (intent == null) {
            return;
        }
        SharedPreferences sharedPreferences = this.f3697g0;
        if (sharedPreferences != null) {
            i3 = sharedPreferences.getInt("REQUEST_CODE", 1);
        }
        if (i3 == 0 && i4 == 1) {
            this.P = intent.getStringExtra("other_currency");
            this.N = intent.getStringExtra("other_currency_code");
            this.R = intent.getStringExtra("other_country_code");
            this.W = intent.getStringExtra("exchange");
            u2();
        } else if (i3 == 1 && i4 == 1) {
            this.O = intent.getStringExtra("other_currency");
            this.M = intent.getStringExtra("other_currency_code");
            this.Q = intent.getStringExtra("other_country_code");
            this.X = intent.getStringExtra("exchange");
            u2();
        }
        K3();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (animator == this.O0) {
            this.f3717n.setAlpha(1.0f);
        } else if (animator == this.P0) {
            this.f3720o.setAlpha(1.0f);
        } else if (animator == this.M0) {
            ViewGroup.LayoutParams layoutParams = this.f3711l.getLayoutParams();
            layoutParams.width = f1();
            this.f3711l.setLayoutParams(layoutParams);
        } else if (animator == this.Q0) {
            this.f3717n.setAlpha(0.0f);
        } else if (animator == this.N0) {
            ViewGroup.LayoutParams layoutParams2 = this.f3714m.getLayoutParams();
            layoutParams2.width = f1();
            this.f3714m.setLayoutParams(layoutParams2);
        } else if (animator == this.R0) {
            this.f3720o.setAlpha(0.0f);
        } else if (animator == this.S0) {
            this.f3711l.setY(Q1);
            InputTextView inputTextView = this.f3711l;
            inputTextView.setPivotX(inputTextView.getWidth());
            InputTextView inputTextView2 = this.f3711l;
            inputTextView2.setPivotY(inputTextView2.getHeight());
            float fP1 = p1();
            this.f3711l.setScaleX(fP1);
            this.f3711l.setScaleY(fP1);
        } else if (animator == this.W0) {
            this.f3714m.setY(R1);
            InputTextView inputTextView3 = this.f3714m;
            inputTextView3.setPivotX(inputTextView3.getWidth());
            InputTextView inputTextView4 = this.f3714m;
            inputTextView4.setPivotY(inputTextView4.getHeight());
            float fQ1 = q1();
            this.f3714m.setScaleX(fQ1);
            this.f3714m.setScaleY(fQ1);
        } else if (animator == this.U0) {
            this.f3711l.setAlpha(1.0f);
            String strH1 = h1();
            this.f3711l.setTextString(M0(strH1).toString());
            this.f3711l.setSelection(strH1.length());
            this.f3717n.setText(BuildConfig.FLAVOR);
            this.f3711l.setY(Q1);
            this.f3717n.setY(X1);
            this.f3717n.getLayoutParams().height = f3672e2;
            this.f3717n.setTextSize(0, f3671d2);
            this.f3717n.setScaleX(1.0f);
            this.f3717n.setScaleY(1.0f);
            this.f3717n.setTextColor(r1());
            this.f3717n.setAlpha(0.0f);
            y3(x.RESULT);
        } else if (animator == this.Y0) {
            this.f3714m.setAlpha(1.0f);
            String strJ1 = j1();
            this.f3714m.setTextString(M0(strJ1).toString());
            InputTextView inputTextView5 = this.f3714m;
            inputTextView5.setContentDescription(g2.b.w(this.f3684c, inputTextView5.getTextString()));
            this.f3714m.setSelection(strJ1.length());
            this.f3720o.setText(BuildConfig.FLAVOR);
            this.f3714m.setY(R1);
            this.f3720o.setY(W1);
            this.f3720o.getLayoutParams().height = f3673f2;
            this.f3720o.setTextSize(0, f3670c2);
            this.f3720o.setScaleX(1.0f);
            this.f3720o.setScaleY(1.0f);
            this.f3720o.setTextColor(r1());
            this.f3720o.setAlpha(0.0f);
            this.f3714m.clearFocus();
            g3(x.RESULT);
        } else if (animator == this.T0) {
            this.f3711l.setAlpha(1.0f);
            InputTextView inputTextView6 = this.f3711l;
            inputTextView6.setSelection(inputTextView6.getText().length());
            this.f3711l.setY(Q1 - this.f3683b1);
            this.f3711l.setTextSize(0, this.f3684c.getResources().getDimension(R.dimen.exchange_input_text_size));
            this.f3711l.setTextColor(n1());
        } else if (animator == this.X0) {
            this.f3714m.setAlpha(1.0f);
            InputTextView inputTextView7 = this.f3714m;
            inputTextView7.setSelection(inputTextView7.getText().length());
            this.f3714m.setY(R1 - this.f3689d1);
            this.f3714m.setTextSize(0, this.f3684c.getResources().getDimension(R.dimen.exchange_input_text_size));
            this.f3714m.setTextColor(n1());
        } else if (animator == this.V0) {
            this.f3717n.setAlpha(1.0f);
            this.f3717n.setY(X1 - this.f3683b1);
            this.f3717n.getLayoutParams().height = f3672e2;
            this.f3717n.setTextSize(0, f3671d2);
            this.f3717n.setScaleX(1.0f);
            this.f3717n.setScaleY(1.0f);
            this.f3717n.setTextColor(r1());
            VLog.d("BBKCalculator/ExchangeActivity", "mLocResultText-->" + this.f3717n);
        } else if (animator == this.Z0) {
            this.f3720o.setAlpha(1.0f);
            this.f3720o.setY(W1 - this.f3689d1);
            this.f3720o.getLayoutParams().height = f3673f2;
            this.f3720o.setTextSize(0, f3670c2);
            this.f3720o.setScaleX(1.0f);
            this.f3720o.setScaleY(1.0f);
            this.f3720o.setTextColor(r1());
            VLog.d("BBKCalculator/ExchangeActivity", "mOthResultText-->" + this.f3720o);
        }
        N1 = false;
        I0();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (animator == this.K0) {
            InputTextView inputTextView = this.f3711l;
            Y1 = inputTextView.c(inputTextView.getTextString());
            float fM = g2.b.m(this.f3684c, f3669b2);
            float fM2 = g2.b.m(this.f3684c, Y1);
            int i3 = f3675h2;
            float f3 = (i3 * fM) / fM2;
            int i4 = f3676i2;
            float f4 = (i4 - f3) / 2.0f;
            this.f3680a1 = f4;
            this.f3683b1 = (Q1 + i3) - (((S1 / 2.0f) + i4) + f4);
            if (f3669b2 < Y1) {
                ViewGroup.LayoutParams layoutParams = this.f3711l.getLayoutParams();
                layoutParams.width = (int) ((Y1 / f3669b2) * f1());
                this.f3711l.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (animator == this.L0) {
            InputTextView inputTextView2 = this.f3714m;
            Z1 = inputTextView2.c(inputTextView2.getTextString());
            float fM3 = g2.b.m(this.f3684c, f3668a2);
            float fM4 = g2.b.m(this.f3684c, Z1);
            int i5 = f3674g2;
            float f5 = (i5 * fM3) / fM4;
            int i6 = f3676i2;
            float f6 = (i6 - f5) / 2.0f;
            this.f3686c1 = f6;
            this.f3689d1 = (R1 + i5) - (((T1 / 2.0f) + i6) + f6);
            if (f3668a2 < Z1) {
                ViewGroup.LayoutParams layoutParams2 = this.f3714m.getLayoutParams();
                layoutParams2.width = (int) ((Z1 / f3668a2) * f1());
                this.f3714m.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        if (animator == this.U0) {
            float maxTextSize = this.f3711l.getMaxTextSize();
            Y1 = maxTextSize;
            float fM5 = g2.b.m(this.f3684c, maxTextSize);
            float fM6 = g2.b.m(this.f3684c, f3671d2);
            int i7 = f3672e2;
            float f7 = (i7 * fM5) / fM6;
            int i8 = f3675h2;
            float f8 = (i8 - f7) / 2.0f;
            this.f3692e1 = f8;
            this.f3698g1 = ((X1 - this.f3683b1) + i7) - ((Q1 + i8) - f8);
            return;
        }
        if (animator == this.Y0) {
            float maxTextSize2 = this.f3714m.getMaxTextSize();
            Z1 = maxTextSize2;
            float fM7 = g2.b.m(this.f3684c, maxTextSize2);
            float fM8 = g2.b.m(this.f3684c, f3670c2);
            int i9 = f3673f2;
            float f9 = (i9 * fM7) / fM8;
            int i10 = f3674g2;
            float f10 = (i10 - f9) / 2.0f;
            this.f3695f1 = f10;
            this.f3701h1 = ((W1 - this.f3689d1) + i9) - ((R1 + i10) - f10);
            return;
        }
        if (animator == this.T0) {
            InputTextView inputTextView3 = this.f3711l;
            Y1 = inputTextView3.c(inputTextView3.getTextString());
            float fM9 = g2.b.m(this.f3684c, f3669b2);
            float fM10 = g2.b.m(this.f3684c, Y1);
            int i11 = f3675h2;
            float f11 = (i11 * fM9) / fM10;
            int i12 = f3676i2;
            float f12 = (i12 - f11) / 2.0f;
            this.f3680a1 = f12;
            this.f3683b1 = (Q1 + i11) - (((S1 / 2.0f) + i12) + f12);
            if (f3669b2 < Y1) {
                ViewGroup.LayoutParams layoutParams3 = this.f3711l.getLayoutParams();
                layoutParams3.width = (int) ((Y1 / f3669b2) * f1());
                this.f3711l.setLayoutParams(layoutParams3);
                return;
            }
            return;
        }
        if (animator == this.X0) {
            InputTextView inputTextView4 = this.f3714m;
            Z1 = inputTextView4.c(inputTextView4.getTextString());
            float fM11 = g2.b.m(this.f3684c, f3668a2);
            float fM12 = g2.b.m(this.f3684c, Z1);
            int i13 = f3674g2;
            float f13 = (i13 * fM11) / fM12;
            int i14 = f3676i2;
            float f14 = (i14 - f13) / 2.0f;
            this.f3686c1 = f14;
            this.f3689d1 = (R1 + i13) - (((T1 / 2.0f) + i14) + f14);
            if (f3668a2 < Z1) {
                ViewGroup.LayoutParams layoutParams4 = this.f3714m.getLayoutParams();
                layoutParams4.width = (int) ((Z1 / f3668a2) * f1());
                this.f3714m.setLayoutParams(layoutParams4);
                return;
            }
            return;
        }
        if (animator == this.V0) {
            this.f3717n.setY(Q1);
            this.f3717n.setTextSize(0, Y1);
            float fM13 = g2.b.m(this.f3684c, Y1);
            float fM14 = g2.b.m(this.f3684c, f3671d2);
            int i15 = f3672e2;
            float f15 = (i15 * fM13) / fM14;
            int i16 = f3675h2;
            float f16 = (i16 - f15) / 2.0f;
            this.f3692e1 = f16;
            this.f3698g1 = ((X1 - this.f3683b1) + i15) - ((Q1 + i16) - f16);
            this.f3717n.setAlpha(1.0f);
            this.f3717n.setTextColor(n1());
            return;
        }
        if (animator == this.Z0) {
            this.f3720o.setTextSize(0, Z1);
            this.f3720o.setY(R1);
            float fM15 = g2.b.m(this.f3684c, Z1);
            float fM16 = g2.b.m(this.f3684c, f3670c2);
            int i17 = f3673f2;
            float f17 = (i17 * fM15) / fM16;
            int i18 = f3674g2;
            float f18 = (i18 - f17) / 2.0f;
            this.f3695f1 = f18;
            this.f3701h1 = ((W1 - this.f3689d1) + i17) - ((R1 + i18) - f18);
            this.f3720o.setAlpha(1.0f);
            this.f3720o.setTextColor(n1());
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f3 = Q1;
        int i3 = f3676i2;
        float f4 = i3 + f3;
        float f5 = R1;
        float f6 = i3 + f5;
        if (valueAnimator == this.K0) {
            float f7 = 1.0f - ((1.0f - (f3669b2 / Y1)) * fFloatValue);
            this.f3711l.setY(f3 - (fFloatValue * this.f3683b1));
            InputTextView inputTextView = this.f3711l;
            inputTextView.setPivotX(inputTextView.getWidth());
            InputTextView inputTextView2 = this.f3711l;
            inputTextView2.setPivotY(inputTextView2.getHeight());
            this.f3711l.setScaleX(f7);
            this.f3711l.setScaleY(f7);
        } else if (valueAnimator == this.L0) {
            float f8 = 1.0f - ((1.0f - (f3668a2 / Z1)) * fFloatValue);
            this.f3714m.setY(f5 - (fFloatValue * this.f3689d1));
            InputTextView inputTextView3 = this.f3714m;
            inputTextView3.setPivotX(inputTextView3.getWidth());
            InputTextView inputTextView4 = this.f3714m;
            inputTextView4.setPivotY(inputTextView4.getHeight());
            this.f3714m.setScaleX(f8);
            this.f3714m.setScaleY(f8);
        } else if (valueAnimator == this.M0) {
            float f9 = 1.0f - ((1.0f - (f3669b2 / Y1)) * fFloatValue);
            this.f3711l.setY(f3 - (fFloatValue * this.f3683b1));
            InputTextView inputTextView5 = this.f3711l;
            inputTextView5.setPivotX(inputTextView5.getWidth());
            InputTextView inputTextView6 = this.f3711l;
            inputTextView6.setPivotY(inputTextView6.getHeight());
            this.f3711l.setScaleX(f9);
            this.f3711l.setScaleY(f9);
        } else if (valueAnimator == this.N0) {
            float f10 = 1.0f - ((1.0f - (f3668a2 / Z1)) * fFloatValue);
            this.f3714m.setY(f5 - (fFloatValue * this.f3689d1));
            InputTextView inputTextView7 = this.f3714m;
            inputTextView7.setPivotX(inputTextView7.getWidth());
            InputTextView inputTextView8 = this.f3714m;
            inputTextView8.setPivotY(inputTextView8.getHeight());
            this.f3714m.setScaleX(f10);
            this.f3714m.setScaleY(f10);
        } else if (valueAnimator == this.O0) {
            this.f3717n.setY(W1 - (this.f3683b1 * fFloatValue));
            if (this.f3733s0) {
                this.f3717n.setAlpha(fFloatValue);
            }
        } else if (valueAnimator == this.P0) {
            this.f3720o.setY(W1 - (this.f3689d1 * fFloatValue));
            if (this.f3733s0) {
                this.f3720o.setAlpha(fFloatValue);
            }
        } else if (valueAnimator == this.Q0) {
            this.f3717n.setY(W1 - (this.f3683b1 * fFloatValue));
            this.f3717n.setAlpha(fFloatValue);
        } else if (valueAnimator == this.R0) {
            this.f3720o.setY(W1 - (this.f3689d1 * fFloatValue));
            this.f3720o.setAlpha(fFloatValue);
        } else if (valueAnimator == this.S0) {
            this.f3711l.setY((f3 - this.f3683b1) - (f4 * fFloatValue));
            this.f3711l.setAlpha(1.0f - fFloatValue);
        } else if (valueAnimator == this.W0) {
            this.f3714m.setY((f5 - this.f3689d1) - (f6 * fFloatValue));
            this.f3714m.setAlpha(1.0f - fFloatValue);
        } else if (valueAnimator == this.U0) {
            float f11 = (((Y1 / f3671d2) - 1.0f) * fFloatValue) + 1.0f;
            this.f3717n.setTextColor(((double) fFloatValue) > 0.5d ? n1() : r1());
            this.f3717n.setY((X1 - this.f3683b1) - (fFloatValue * this.f3698g1));
            CalculatorLocResult calculatorLocResult = this.f3717n;
            calculatorLocResult.setPivotX(calculatorLocResult.getWidth());
            CalculatorLocResult calculatorLocResult2 = this.f3717n;
            calculatorLocResult2.setPivotY(calculatorLocResult2.getHeight());
            this.f3717n.setScaleX(f11);
            this.f3717n.setScaleY(f11);
        } else if (valueAnimator == this.Y0) {
            float f12 = (((Z1 / f3670c2) - 1.0f) * fFloatValue) + 1.0f;
            this.f3720o.setTextColor(((double) fFloatValue) > 0.5d ? n1() : r1());
            this.f3720o.setY((W1 - this.f3689d1) - (fFloatValue * this.f3701h1));
            CalculatorOthResult calculatorOthResult = this.f3720o;
            calculatorOthResult.setPivotX(calculatorOthResult.getWidth());
            CalculatorOthResult calculatorOthResult2 = this.f3720o;
            calculatorOthResult2.setPivotY(calculatorOthResult2.getHeight());
            this.f3720o.setScaleX(f12);
            this.f3720o.setScaleY(f12);
        } else if (valueAnimator == this.T0) {
            float f13 = (((f3669b2 / Y1) - 1.0f) * fFloatValue) + 1.0f;
            this.f3711l.setY(((f4 * fFloatValue) - i3) - this.f3683b1);
            InputTextView inputTextView9 = this.f3711l;
            inputTextView9.setPivotX(inputTextView9.getWidth());
            InputTextView inputTextView10 = this.f3711l;
            inputTextView10.setPivotY(inputTextView10.getHeight());
            this.f3711l.setScaleX(f13);
            this.f3711l.setScaleY(f13);
            this.f3711l.setAlpha(fFloatValue);
        } else if (valueAnimator == this.X0) {
            float f14 = (((f3668a2 / Z1) - 1.0f) * fFloatValue) + 1.0f;
            this.f3714m.setY(((f6 * fFloatValue) - i3) - this.f3689d1);
            InputTextView inputTextView11 = this.f3714m;
            inputTextView11.setPivotX(inputTextView11.getWidth());
            InputTextView inputTextView12 = this.f3714m;
            inputTextView12.setPivotY(inputTextView12.getHeight());
            this.f3714m.setScaleX(f14);
            this.f3714m.setScaleY(f14);
            this.f3714m.setAlpha(fFloatValue);
        } else if (valueAnimator == this.V0) {
            int iD1 = (int) (f3675h2 + (d1() * fFloatValue));
            float f15 = (((f3671d2 / Y1) - 1.0f) * fFloatValue) + 1.0f;
            this.f3717n.setY(Q1 + (this.f3698g1 * fFloatValue));
            CalculatorLocResult calculatorLocResult3 = this.f3717n;
            calculatorLocResult3.setPivotX(calculatorLocResult3.getWidth());
            CalculatorLocResult calculatorLocResult4 = this.f3717n;
            calculatorLocResult4.setPivotY(calculatorLocResult4.getHeight());
            this.f3717n.setScaleX(f15);
            this.f3717n.setScaleY(f15);
            this.f3717n.setTextColor(((double) (1.0f - fFloatValue)) > 0.5d ? n1() : r1());
            this.f3717n.getLayoutParams().height = iD1;
        } else if (valueAnimator == this.Z0) {
            int iD2 = (int) (f3674g2 + (d1() * fFloatValue));
            float f16 = (((f3670c2 / Z1) - 1.0f) * fFloatValue) + 1.0f;
            this.f3720o.setY(R1 + (this.f3701h1 * fFloatValue));
            CalculatorOthResult calculatorOthResult3 = this.f3720o;
            calculatorOthResult3.setPivotX(calculatorOthResult3.getWidth());
            CalculatorOthResult calculatorOthResult4 = this.f3720o;
            calculatorOthResult4.setPivotY(calculatorOthResult4.getHeight());
            this.f3720o.setScaleX(f16);
            this.f3720o.setScaleY(f16);
            this.f3720o.setTextColor(((double) (1.0f - fFloatValue)) > 0.5d ? n1() : r1());
            this.f3720o.getLayoutParams().height = iD2;
        }
        N1 = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
        switch (view.getId()) {
            case R.id.local_country_info /* 2131231062 */:
            case R.id.other_country_info /* 2131231181 */:
                if (this.K.getVisibility() == 0) {
                    U2();
                    if (view.getId() == R.id.other_country_info) {
                        C3(true);
                        this.f3700h0.putString("check_position", this.N);
                        this.f3700h0.putInt("REQUEST_CODE", 0);
                        this.f3700h0.apply();
                        Intent intent = new Intent();
                        this.f3703i0 = intent;
                        intent.setAction(BuildConfig.FLAVOR);
                        this.f3703i0.setClass(this, CountryList.class);
                        this.f3703i0.putExtra("is_calculator", false);
                        startActivityForResult(this.f3703i0, 0);
                    } else if (view.getId() == R.id.local_country_info) {
                        C3(true);
                        this.f3700h0.putString("check_position", this.M);
                        this.f3700h0.putInt("REQUEST_CODE", 1);
                        this.f3700h0.apply();
                        Intent intent2 = new Intent();
                        this.f3703i0 = intent2;
                        intent2.setClass(this, CountryList.class);
                        this.f3703i0.putExtra("is_calculator", false);
                        startActivityForResult(this.f3703i0, 1);
                    }
                }
                break;
            case R.id.net_refresh /* 2131231151 */:
                this.A.setVisibility(8);
                p3();
                break;
            case R.id.net_setting /* 2131231152 */:
            case R.id.no_net_setting /* 2131231160 */:
                D3();
                break;
            case R.id.no_net_refresh /* 2131231159 */:
                this.B.setVisibility(8);
                p3();
                break;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        RelativeLayout.LayoutParams layoutParams;
        g2.d.a(this);
        if (!g2.b.b(this)) {
            setTheme(R.style.SettingThemeOverlay);
        }
        super.onCreate(bundle);
        getWindow().setSoftInputMode(3);
        if (isInMultiWindowMode() && BBKCalculatorApplication.h()) {
            VLog.d("BBKCalculator/ExchangeActivity", "onCreate:  isInMultiWindowMode and back form countrylist : " + isInMultiWindowMode());
            BBKCalculatorApplication.q(false);
            finish();
            return;
        }
        VLog.d("BBKCalculator/ExchangeActivity", "onCreate:  ");
        if (Build.VERSION.SDK_INT > 26) {
            setShowWhenLocked(true);
        }
        this.f3684c = this;
        k kVar = null;
        if (g2.b.o(this)) {
            setRequestedOrientation(-1);
            setContentView(R.layout.nex_calculator_vivo_exchange);
            this.f3709k0 = View.inflate(this.f3684c, R.layout.nex_calculator_vivo_exchange, null);
        } else {
            setRequestedOrientation(1);
            setContentView(R.layout.calculator_vivo_exchange);
            this.f3709k0 = View.inflate(this.f3684c, R.layout.calculator_vivo_exchange, null);
        }
        VToolBar vToolBar = (VToolBar) findViewById(R.id.toolbar);
        this.f3718n0 = vToolBar;
        vToolBar.P(true);
        this.f3718n0.setNavigationContentDescription(R.string.description_btn_back);
        this.f3718n0.setNavigationOnClickListener(new k());
        z1.e.w(this.f3709k0);
        if (this.H1 == null) {
            this.H1 = new z(this, kVar);
        }
        this.f3687d = com.vivo.calculator.b.d1(this.f3684c);
        this.f3690e = com.vivo.calculator.b.e1(this.f3684c);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3684c);
        this.f3697g0 = defaultSharedPreferences;
        this.f3700h0 = defaultSharedPreferences.edit();
        f3678k2 = (AudioManager) this.f3684c.getSystemService("audio");
        boolean z2 = this.f3697g0.getBoolean("focus", false);
        this.H0 = z2;
        if (z2) {
            this.f3746w1 = this.f3697g0.getBoolean("IS_EQUP", false);
        } else {
            this.f3752y1 = this.f3697g0.getBoolean("IS_EQUP", false);
        }
        VLog.d("BBKCalculator/ExchangeActivity", "onCreate:  mIsLocalInput == " + this.H0);
        q3(this.f3752y1);
        d3(this.f3746w1);
        this.C0 = this.f3684c.getResources().getString(R.string.error);
        this.f3685c0 = (ClipboardManager) this.f3684c.getSystemService("clipboard");
        this.f3716m1 = getWindowManager().getDefaultDisplay().getWidth() - (((int) getResources().getDimension(R.dimen.exchange_input_margin_start)) * 2);
        z1();
        E1();
        R2();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.keyboard_ex_layout);
        if (g2.b.o(this.f3684c) && g2.b.n()) {
            RelativeLayout relativeLayout = this.f3706j0;
            if (relativeLayout != null) {
                relativeLayout.setPadding(0, 0, 0, 0);
            }
            RelativeLayout relativeLayout2 = this.J;
            if (relativeLayout2 != null) {
                ((RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                if (getResources().getConfiguration().orientation == 2) {
                    layoutParams2.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_large_size_exchange_land);
                    RelativeLayout relativeLayout3 = this.I;
                    if (relativeLayout3 != null) {
                        ((RelativeLayout.LayoutParams) relativeLayout3.getLayoutParams()).setMargins(0, 0, 0, 0);
                    }
                    View view = this.G;
                    if (view != null) {
                        ((RelativeLayout.LayoutParams) view.getLayoutParams()).setMargins(0, 0, 0, 0);
                    }
                } else {
                    layoutParams2.height = getResources().getDimensionPixelOffset(R.dimen.keyboard_height_nex_large_size_exchange);
                }
                linearLayout.setLayoutParams(layoutParams2);
            }
        } else if (g2.b.o(this.f3684c) && getResources().getConfiguration().orientation == 2 && linearLayout != null && (layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams()) != null) {
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.keybord_ex_height_nex_land);
            linearLayout.setLayoutParams(layoutParams);
        }
        BBKCalculatorApplication.a().o(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VLog.d("BBKCalculator/ExchangeActivity", "onDestroy: ");
        if (this.K1) {
            T2();
        }
        Handler handler = this.H1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.H1 = null;
        }
        J3();
        K2();
        n2();
        o2();
        BBKCalculatorApplication.a().o(null);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "onMultiWindowModeChanged = " + z2);
        finish();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        VLog.d("BBKCalculator/ExchangeActivity", "onPause  mHideState == " + this.f3681b);
        f2.a aVar = O1;
        if (aVar != null) {
            aVar.l();
        }
        I0();
        if (!this.f3681b) {
            g2.e.f(this.f3684c, this.f3749x1, this.f3740u1);
            T2();
            if (TextUtils.isEmpty(this.f3714m.getTextString()) && TextUtils.isEmpty(this.f3711l.getTextString())) {
                g2.e.j(this.f3684c, Boolean.FALSE);
            }
            i();
            if (this.H0) {
                X2(this.F1);
            } else {
                Z2(this.G1);
            }
        }
        L2();
    }

    @Override // android.app.Activity
    public void onResume() {
        InputTextView inputTextView;
        VLog.d("BBKCalculator/ExchangeActivity", "onResume: ");
        super.onResume();
        if (this.f3697g0 == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3684c);
            this.f3697g0 = defaultSharedPreferences;
            this.f3700h0 = defaultSharedPreferences.edit();
        }
        this.f3742v0 = this.f3697g0.getBoolean("LOCAL_UP", false);
        this.f3745w0 = this.f3697g0.getBoolean("OTHER_UP", false);
        VLog.d("BBKCalculator/ExchangeActivity", "onResume: mLocUpType == " + this.f3742v0);
        VLog.d("BBKCalculator/ExchangeActivity", "onResume: mOthUpType == " + this.f3745w0);
        if (!this.f3697g0.getBoolean("input_type", false) && !this.f3697g0.getBoolean("is_first", true)) {
            m1();
            D1();
        }
        if (this.K.getVisibility() == 0) {
            z3(false);
        }
        A2();
        if (this.H0 && (inputTextView = this.f3711l) != null) {
            G2(inputTextView);
            return;
        }
        InputTextView inputTextView2 = this.f3714m;
        if (inputTextView2 != null) {
            F2(inputTextView2);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        VLog.d("BBKCalculator/ExchangeActivity", "onStop: ");
        BBKCalculatorApplication.a().d().b("tag_load_exchange");
        BBKCalculatorApplication.a().d().b("tag_load_currencylist");
        Handler handler = this.H1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (view.getId() == R.id.local_input) {
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: getExLocalInputString == " + TextUtils.isEmpty(i1()));
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: isOthUping() == " + d2());
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: mIsLocalInput == " + this.H0);
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: INPUT_TYPE == " + this.f3697g0.getBoolean("input_type", false));
                if (!this.f3697g0.getBoolean("input_type", false) || (!TextUtils.isEmpty(g1()) && e1().equals(g1()))) {
                    this.f3711l.setTextString(BuildConfig.FLAVOR);
                    this.f3714m.setTextString(BuildConfig.FLAVOR);
                    this.f3720o.setTextString(BuildConfig.FLAVOR);
                    this.f3717n.setTextString(BuildConfig.FLAVOR);
                    i2();
                }
                if (!TextUtils.isEmpty(i1()) && d2() && !this.H0 && this.B1 == x.INPUT) {
                    this.f3746w1 = false;
                    this.J0 = true;
                    VLog.d("BBKCalculator/ExchangeActivity", "onTouch:  onEquals Other");
                    s2(true);
                }
                k3();
                this.H0 = true;
            } else if (view.getId() == R.id.other_input) {
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: getExOtherInputString == " + TextUtils.isEmpty(g1()));
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: isUping() == " + e2());
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: mIsLocalInput == " + this.H0);
                VLog.d("BBKCalculator/ExchangeActivity", "onTouch: INPUT_TYPE == " + this.f3697g0.getBoolean("input_type", false));
                if (!this.f3697g0.getBoolean("input_type", false) || (!TextUtils.isEmpty(i1()) && e1().equals(i1()))) {
                    this.f3711l.setTextString(BuildConfig.FLAVOR);
                    this.f3714m.setTextString(BuildConfig.FLAVOR);
                    this.f3720o.setTextString(BuildConfig.FLAVOR);
                    this.f3717n.setTextString(BuildConfig.FLAVOR);
                    i2();
                }
                if (!TextUtils.isEmpty(g1()) && e2() && this.H0 && this.A1 == x.INPUT) {
                    VLog.d("BBKCalculator/ExchangeActivity", "onTouch:  onEquals  Local ");
                    this.I0 = true;
                    s2(true);
                    this.f3752y1 = true;
                }
                u3();
                this.H0 = false;
            }
            VLog.d("BBKCalculator/ExchangeActivity", "onTouch mIsLocalInput = " + this.H0);
            g2.e.k(this.f3684c, this.H0);
        }
        return false;
    }

    public float p1() {
        float fMeasureText = this.f3717n.getPaint().measureText(this.f3717n.getText().toString());
        float textSize = (fMeasureText * (this.f3711l.getTextSize() / this.f3717n.getTextSize())) / this.f3711l.getPaint().measureText(this.f3717n.getText().toString());
        if (Float.isNaN(textSize)) {
            return 2.0f;
        }
        return textSize;
    }

    public float q1() {
        float fMeasureText = this.f3720o.getPaint().measureText(this.f3720o.getText().toString());
        float textSize = (fMeasureText * (this.f3714m.getTextSize() / this.f3720o.getTextSize())) / this.f3714m.getPaint().measureText(this.f3720o.getText().toString());
        if (Float.isNaN(textSize)) {
            return 2.0f;
        }
        return textSize;
    }

    public void q3(boolean z2) {
        this.f3743v1 = z2;
    }

    public int r1() {
        return this.f3684c.getResources().getColor(R.color.result_text_color);
    }

    public void r3() {
        if (this.F1) {
            this.f3714m.setTextString(this.f3684c.getResources().getString(R.string.error));
        } else {
            this.f3714m.setTextString(BuildConfig.FLAVOR);
        }
        this.f3720o.setVisibility(8);
    }

    public String s1(long j3) {
        String str;
        VLog.d("BBKCalculator/ExchangeActivity", "getTimeFormat: time " + j3);
        try {
            str = DateFormat.getDateTimeInstance(2, 2, Locale.getDefault()).format(new Date(j3));
        } catch (Exception e3) {
            new SimpleDateFormat("M/d/yyyy " + getResources().getString(R.string.time_format_with_second), Locale.getDefault());
            VLog.e("BBKCalculator/ExchangeActivity", "getTimeFormat,Exception " + e3.getMessage());
            str = null;
        }
        String string = getResources().getString(R.string.content_update_time);
        if (str == null) {
            return null;
        }
        return "zh-cn".equalsIgnoreCase(o1()) ? String.format(string, this.f3697g0.getString("resource_cn", BuildConfig.FLAVOR), str) : String.format(string, this.f3697g0.getString("resource_en", BuildConfig.FLAVOR), str);
    }

    public View.OnClickListener t1() {
        return this.I1;
    }

    String t2(String str, String str2) {
        VLog.d("BBKCalculator/ExchangeActivity", "onExChange otherexchanger == " + str + " localexchagne ===" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return BuildConfig.FLAVOR;
        }
        String str3 = str + "÷" + str2;
        try {
            this.B0 = X0(str3);
        } catch (y2.x unused) {
            this.A0 = true;
            this.B0 = this.C0;
        }
        if (str3.equals(this.B0)) {
            this.A0 = false;
        }
        return this.B0;
    }

    public void t3(String str, boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "setExOthInputDown:  isOthUping " + this.f3740u1);
        if (z2 && this.f3740u1) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            C1();
            if (this.N0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.N0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.N0.addListener(this);
                this.N0.addUpdateListener(this);
            }
            this.N0.start();
            if (this.R0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.R0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.R0.addListener(this);
                this.R0.addUpdateListener(this);
            }
            this.R0.start();
        }
        this.f3740u1 = false;
    }

    public void u2() {
        VLog.d("BBKCalculator/ExchangeActivity", "onQueryExchange: mOtherExchange  == " + this.W + "  mLocalExchange == " + this.X);
        this.f3682b0 = new c2.b(this.f3684c);
        this.F0 = "curr=?";
        this.D0 = new String[]{"exchange"};
        P1 = t2(this.W, this.X);
        VLog.d("BBKCalculator/ExchangeActivity", "onQueryExchange   mLocalInput === " + this.V);
        VLog.d("BBKCalculator/ExchangeActivity", "onQueryExchange   mOtherInput === " + this.U);
        if (TextUtils.isEmpty(this.f3711l.getTextString()) || TextUtils.isEmpty(this.f3714m.getTextString())) {
            this.U = "1";
            this.V = P1;
        } else {
            x xVar = this.A1;
            x xVar2 = x.ERROR;
            if (xVar != xVar2 && this.B1 != xVar2) {
                if (this.f3697g0.getBoolean("input_type", false) && X1()) {
                    this.f3720o.p();
                    this.D1 = true;
                    S1(P1);
                } else {
                    this.f3717n.q();
                    this.E1 = true;
                    U1(P1);
                }
            }
        }
        U2();
        T2();
        g2.e.i(this.f3684c, P1, this.X, this.W);
        g2.e.h(this.f3684c, "1", P1 + BuildConfig.FLAVOR);
        VLog.d("BBKCalculator/ExchangeActivity", "onQueryExchange  mExchange === " + P1);
    }

    public void u3() {
        this.f3714m.setTextColor(n1());
        this.f3714m.requestFocus();
        this.f3714m.setFocusableInTouchMode(true);
        this.f3714m.setCursorVisible(true);
        this.f3711l.setTextColor(n1());
    }

    public boolean v1() {
        f2.a aVar = O1;
        return aVar != null && aVar.g();
    }

    public void v3(String str, boolean z2) {
        VLog.d("BBKCalculator/ExchangeActivity", "setOtherInputUp:  ");
        if (z2 && (!this.f3740u1 || this.f3730r0)) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            C1();
            if (this.L0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.L0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.L0.addListener(this);
                this.L0.addUpdateListener(this);
            }
            this.L0.start();
            if (this.P0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.P0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.P0.addListener(this);
                this.P0.addUpdateListener(this);
            }
            this.P0.start();
        }
        this.f3740u1 = true;
        this.f3743v1 = false;
    }

    public void w3(String str, boolean z2) {
        if (z2 && this.f3740u1 && !this.f3743v1 && !TextUtils.isEmpty(str)) {
            f3677j2 = true;
            if (N1) {
                return;
            }
            C1();
            if (this.W0 == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.W0 = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(300L);
                this.W0.addListener(this);
                this.W0.addUpdateListener(this);
            }
            this.W0.start();
            if (this.Y0 == null) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.Y0 = valueAnimatorOfFloat2;
                valueAnimatorOfFloat2.setDuration(300L);
                this.Y0.addListener(this);
                this.Y0.addUpdateListener(this);
            }
            this.Y0.start();
        }
        this.f3743v1 = true;
        this.f3740u1 = false;
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            O0();
        }
        if (z2 || BuildConfig.FLAVOR.equals(str) || N1) {
            return;
        }
        this.f3714m.setTextString(str);
    }

    public synchronized SQLiteDatabase x2() {
        SQLiteDatabase writableDatabase;
        writableDatabase = c2.a.c(this.f3684c).getWritableDatabase();
        this.f3693f = writableDatabase;
        return writableDatabase;
    }

    public void x3(String str) {
        TextView textView = this.f3735t;
        if (textView != null) {
            textView.setText(str);
            this.f3735t.setVisibility(0);
        }
    }

    public void y2(int i3) {
        if (O1 != null) {
            int ringerMode = f3678k2.getRingerMode();
            VLog.d("BBKCalculator/ExchangeActivity", "ringerMode:" + ringerMode);
            if (ringerMode == 0 || ringerMode == 1) {
                return;
            }
            O1.m(i3);
        }
    }

    public void z3(boolean z2) {
        x xVar;
        x xVar2;
        if (!this.H0) {
            if (!this.f3714m.hasFocus() && this.f3697g0.getBoolean("input_type", false)) {
                this.f3714m.requestFocus();
            }
            if ((TextUtils.isEmpty(this.f3714m.getTextString()) || g2.h.b(this.f3714m.getTextString().replace(",", BuildConfig.FLAVOR)) || (((xVar = this.B1) == x.RESULT && xVar == x.INIT_FOR_RESULT) || !this.f3745w0)) && !this.f3730r0) {
                return;
            }
            this.f3733s0 = false;
            this.f3720o.setAlpha(1.0f);
            this.f3720o.setVisibility(0);
            v3(this.f3714m.getTextString(), z2);
            this.f3720o.setAlpha(1.0f);
            this.f3730r0 = false;
            this.f3733s0 = true;
            return;
        }
        if (!this.f3711l.hasFocus() && this.f3697g0.getBoolean("input_type", false)) {
            VLog.d("BBKCalculator/ExchangeActivity", "setUpAnimation: mExLocalEdit.requestFocus()");
            this.f3711l.requestFocus();
        }
        if ((TextUtils.isEmpty(this.f3711l.getTextString()) || g2.h.b(this.f3711l.getTextString().replace(",", BuildConfig.FLAVOR)) || (((xVar2 = this.A1) == x.RESULT && xVar2 == x.INIT_FOR_RESULT) || !this.f3742v0)) && !this.f3727q0) {
            return;
        }
        this.f3733s0 = false;
        this.f3717n.setAlpha(1.0f);
        this.f3717n.setVisibility(0);
        l3(this.f3711l.getTextString(), z2);
        this.f3717n.setAlpha(1.0f);
        this.f3727q0 = false;
        this.f3733s0 = true;
    }
}
