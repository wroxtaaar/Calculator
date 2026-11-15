package com.vivo.calculator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.calculator.keybord.ColorButton;
import com.vivo.calculator.keybord.ColorSelectButton;
import com.vivo.seckeysdk.BuildConfig;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class HistoryLayout extends RelativeLayout {
    private Map<String, String> A;
    private String B;
    public boolean C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Calculator f3792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Calculator f3796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f3797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f3798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f3799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ValueAnimator f3800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ValueAnimator f3801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImageButton f3802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorSelectButton f3803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorButton f3804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ValueAnimator f3805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator f3806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AnimatorSet f3807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AnimatorSet f3808r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ArrayList<Map<String, String>> f3809s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ListView f3810t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private l f3811u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Button f3812v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private androidx.appcompat.app.a f3813w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private LinearLayout f3814x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f3815y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f3816z;

    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (HistoryLayout.this.f3795e) {
                HistoryLayout.this.f3802l.setImageDrawable(HistoryLayout.this.f3792b.getResources().getDrawable(R.drawable.history_open));
                HistoryLayout.this.f3802l.setContentDescription(HistoryLayout.this.f3792b.getString(R.string.description_history_open));
                HistoryLayout.this.E();
            } else {
                HistoryLayout.this.f3802l.setImageDrawable(HistoryLayout.this.f3792b.getResources().getDrawable(R.drawable.history_close_select));
                HistoryLayout.this.f3802l.setContentDescription(HistoryLayout.this.f3792b.getString(R.string.description_history_close));
                if (!HistoryLayout.this.T() && HistoryLayout.this.f3803m != null && HistoryLayout.this.f3803m.getId() == R.id.mr) {
                    HistoryLayout.this.f3803m.setContentDescription(HistoryLayout.this.f3792b.getResources().getString(R.string.description_clear1));
                }
                HistoryLayout.this.f3795e = true;
                HistoryLayout.this.W();
            }
            HistoryLayout.this.D();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (HistoryLayout.this.f3815y && HistoryLayout.this.f3816z) {
                z1.d.r(HistoryLayout.this.f3792b).n();
                HistoryLayout.this.V();
            }
            if (HistoryLayout.this.f3815y && !HistoryLayout.this.f3816z && HistoryLayout.this.A != null) {
                z1.d.r(HistoryLayout.this.f3792b).u(HistoryLayout.this.A);
                HistoryLayout.this.U();
            }
            HistoryLayout.this.f3815y = false;
            HistoryLayout.this.f3816z = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class c extends z1.c {
        c() {
        }

        @Override // z1.c
        public void b(View view) {
            if (z1.d.r(HistoryLayout.this.f3792b).q().isEmpty() || HistoryLayout.this.f3792b.isDestroyed() || HistoryLayout.this.f3792b.isFinishing()) {
                return;
            }
            if (HistoryLayout.this.f3813w != null && !HistoryLayout.this.f3813w.isShowing()) {
                HistoryLayout.this.f3813w.show();
                HistoryLayout.this.f3813w.f(-2).setAllCaps(false);
                HistoryLayout.this.f3813w.f(-1).setAllCaps(false);
                VLog.d("BBKCalculator/HistoryLayout", "mClearHistoryConfirmDialog.show.");
                return;
            }
            HistoryLayout.this.O();
            HistoryLayout.this.f3813w.show();
            HistoryLayout.this.f3813w.f(-2).setAllCaps(false);
            HistoryLayout.this.f3813w.f(-1).setAllCaps(false);
            VLog.d("BBKCalculator/HistoryLayout", "mClearHistoryConfirmDialog.show.");
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Map map;
            if (HistoryLayout.this.f3809s == null || i3 >= HistoryLayout.this.f3809s.size() || (map = (Map) HistoryLayout.this.f3809s.get((HistoryLayout.this.f3809s.size() - i3) - 1)) == null) {
                return;
            }
            String str = map.containsKey("result") ? (String) map.get("result") : null;
            if (str != null) {
                HistoryLayout.this.f3796f.M0(str.replace(",", BuildConfig.FLAVOR), true);
            }
        }
    }

    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            VLog.d("BBKCalculator/HistoryLayout", "ConfirmDialog click PositiveButton");
            VLog.d("BBKCalculator/HistoryLayout", "index:5");
            HistoryLayout.this.f3792b.g1(5);
            HistoryLayout.this.a0(true);
            HistoryLayout.this.F(1);
        }
    }

    class f implements View.OnClickListener {

        class a extends KeyguardManager.KeyguardDismissCallback {
            a() {
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissCancelled() {
                VLog.d("BBKCalculator/HistoryLayout", "onDismissCancelled: ");
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissError() {
                VLog.d("BBKCalculator/HistoryLayout", "onDismissError: ");
            }

            @Override // android.app.KeyguardManager.KeyguardDismissCallback
            public void onDismissSucceeded() {
                VLog.d("BBKCalculator/HistoryLayout", "onDismissSucceeded: ");
                HistoryLayout.this.g0();
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VLog.d("BBKCalculator/HistoryLayout", "setmHistoryTogeButton onClick : ");
            KeyguardManager keyguardManager = (KeyguardManager) HistoryLayout.this.f3792b.getSystemService("keyguard");
            if (!keyguardManager.isKeyguardLocked()) {
                HistoryLayout.this.g0();
            } else {
                VLog.d("BBKCalculator/HistoryLayout", "requestDismissKeyguard");
                keyguardManager.requestDismissKeyguard(HistoryLayout.this.f3796f, new a());
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HistoryLayout.this.d0();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HistoryLayout.this.d0();
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f3 = g2.b.f(HistoryLayout.this.f3792b, 0.0f);
            HistoryLayout.this.f3798h.setX(f3 - (HistoryLayout.this.f3793c * fFloatValue));
            HistoryLayout.this.f3814x.setX(f3 - (HistoryLayout.this.f3793c * fFloatValue));
            if (HistoryLayout.this.f3804n != null) {
                HistoryLayout.this.f3804n.setAlpha(1.0f - fFloatValue);
            }
            HistoryLayout.this.invalidate();
        }
    }

    class j implements Animator.AnimatorListener {
        j() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HistoryLayout.this.f3798h.setX(HistoryLayout.this.f3793c * (-2.0f));
            HistoryLayout.this.f3814x.setX(HistoryLayout.this.f3793c * (-2.0f));
            HistoryLayout.this.f3798h.setVisibility(4);
            HistoryLayout.this.D();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            HistoryLayout.this.f3798h.setVisibility(0);
            HistoryLayout.this.f3814x.setVisibility(0);
            if (HistoryLayout.this.f3809s != null && HistoryLayout.this.f3809s.isEmpty()) {
                HistoryLayout.this.f3799i.setVisibility(0);
                HistoryLayout.this.f3810t.setVisibility(8);
                HistoryLayout.this.f3812v.setImportantForAccessibility(2);
                HistoryLayout.this.f3812v.setTextAppearance(R.style.clearhistorybuttonstylenone);
            }
            if (HistoryLayout.this.f3809s == null || HistoryLayout.this.f3809s.isEmpty() || HistoryLayout.this.f3795e) {
                return;
            }
            HistoryLayout.this.f3799i.setVisibility(8);
            HistoryLayout.this.f3810t.setVisibility(0);
            HistoryLayout.this.f3812v.setImportantForAccessibility(1);
            HistoryLayout.this.f3812v.setTextAppearance(R.style.clearhistorybuttonstyle);
            HistoryLayout.this.b0();
        }
    }

    class k implements ValueAnimator.AnimatorUpdateListener {
        k() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (!HistoryLayout.this.T() && HistoryLayout.this.f3803m != null && HistoryLayout.this.f3803m.getId() == R.id.mr && !g2.b.o(HistoryLayout.this.f3792b)) {
                HistoryLayout.this.f3803m.setAlpha(fFloatValue);
            }
            HistoryLayout.this.f3802l.setAlpha(fFloatValue);
        }
    }

    private class l extends BaseAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<Map<String, String>> f3829b;

        final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private TextView f3831a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextView f3832b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private TextView f3833c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private TextView f3834d;

            a() {
            }
        }

        private l() {
        }

        public void a(ArrayList<Map<String, String>> arrayList) {
            if (arrayList != null) {
                this.f3829b = (ArrayList) arrayList.clone();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<Map<String, String>> arrayList = this.f3829b;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            ArrayList<Map<String, String>> arrayList = this.f3829b;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            Calculator calculator;
            int i4;
            if (view == null) {
                view = LayoutInflater.from(HistoryLayout.this.f3792b).inflate(R.layout.history_item, (ViewGroup) null);
                aVar = new a();
                aVar.f3831a = (TextView) view.findViewById(R.id.calculator_process);
                aVar.f3832b = (TextView) view.findViewById(R.id.calculator_result);
                aVar.f3833c = (TextView) view.findViewById(R.id.raddeg);
                aVar.f3834d = (TextView) view.findViewById(R.id.datetime);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            ArrayList<Map<String, String>> arrayList = this.f3829b;
            if (arrayList != null && arrayList.size() > 0 && i3 > -1 && i3 < this.f3829b.size()) {
                ArrayList<Map<String, String>> arrayList2 = this.f3829b;
                if (arrayList2.get((arrayList2.size() - 1) - i3) != null) {
                    ArrayList<Map<String, String>> arrayList3 = this.f3829b;
                    String str = arrayList3.get((arrayList3.size() - 1) - i3).get("degrad");
                    ArrayList<Map<String, String>> arrayList4 = this.f3829b;
                    String str2 = arrayList4.get((arrayList4.size() - 1) - i3).get("datetime");
                    if (str == null || BuildConfig.FLAVOR.equals(str)) {
                        aVar.f3833c.setVisibility(8);
                    } else {
                        aVar.f3833c.setVisibility(0);
                        TextView textView = aVar.f3833c;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(" (");
                        if ("Rad".equals(str)) {
                            calculator = HistoryLayout.this.f3792b;
                            i4 = R.string.radexplanation;
                        } else {
                            calculator = HistoryLayout.this.f3792b;
                            i4 = R.string.degexplanation;
                        }
                        sb.append(calculator.getString(i4));
                        sb.append(")");
                        textView.setText(sb.toString());
                        if (g2.b.b(HistoryLayout.this.f3792b)) {
                            aVar.f3833c.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.history_input_edit_color_material));
                        } else {
                            aVar.f3833c.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.history_input_edit_color));
                        }
                    }
                    TextView textView2 = aVar.f3831a;
                    ArrayList<Map<String, String>> arrayList5 = this.f3829b;
                    textView2.setText(g2.b.c(arrayList5.get((arrayList5.size() - 1) - i3).get("history")));
                    TextView textView3 = aVar.f3832b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("=");
                    ArrayList<Map<String, String>> arrayList6 = this.f3829b;
                    sb2.append(g2.b.c(arrayList6.get((arrayList6.size() - 1) - i3).get("result")));
                    textView3.setText(sb2.toString());
                    if (TextUtils.isEmpty(str2) || !str2.equals(g2.c.b())) {
                        aVar.f3834d.setText(TextUtils.isEmpty(str2) ? HistoryLayout.this.getResources().getString(R.string.earlier) : str2);
                    } else {
                        aVar.f3834d.setText(HistoryLayout.this.getResources().getString(R.string.today));
                    }
                    if (g2.b.b(HistoryLayout.this.f3792b)) {
                        aVar.f3831a.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.history_input_edit_color_material));
                        aVar.f3832b.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.history_result_text_color_material));
                        aVar.f3834d.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.symbol_text_color_material));
                    } else {
                        aVar.f3831a.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.history_input_edit_color));
                        aVar.f3832b.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.history_result_text_color));
                        aVar.f3834d.setTextColor(HistoryLayout.this.f3792b.getColor(R.color.function_text_blue_color));
                    }
                    if (i3 == 0) {
                        aVar.f3834d.setVisibility(0);
                    } else {
                        ArrayList<Map<String, String>> arrayList7 = this.f3829b;
                        String str3 = arrayList7.get((arrayList7.size() - 1) - (i3 - 1)).get("datetime");
                        if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                            aVar.f3834d.setVisibility(0);
                        } else if (!TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
                            aVar.f3834d.setVisibility(8);
                        } else {
                            aVar.f3834d.setVisibility(0);
                        }
                    }
                }
            }
            return view;
        }

        /* synthetic */ l(HistoryLayout historyLayout, c cVar) {
            this();
        }
    }

    public HistoryLayout(Context context) {
        super(context);
        this.f3792b = null;
        this.f3795e = false;
        this.f3811u = new l(this, null);
        this.f3815y = false;
        this.f3816z = false;
        this.C = false;
        I(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        ColorSelectButton colorSelectButton;
        if (!T() && (colorSelectButton = this.f3803m) != null && colorSelectButton.getId() == R.id.mr) {
            this.f3803m.setContentDescription(this.f3792b.getResources().getString(R.string.description_mr));
            this.f3803m.setSelect(this.f3796f.w0());
            this.f3803m.setClearState(false);
            this.f3803m.invalidate();
        }
        this.f3795e = false;
        W();
    }

    private void I(Context context) {
        this.f3792b = (Calculator) context;
    }

    private ValueAnimator L(float f3, float f4) {
        PathInterpolator pathInterpolator = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f3, f4);
        valueAnimatorOfFloat.setInterpolator(pathInterpolator);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new k());
        if (f3 > f4) {
            valueAnimatorOfFloat.addListener(new a());
        }
        return valueAnimatorOfFloat;
    }

    private void M() {
        this.f3800j = Q(1.0f, 0.0f, 350, true);
        this.f3801k = Q(0.0f, 1.0f, 250, false);
        this.f3805o = L(1.0f, 0.0f);
        this.f3806p = L(0.0f, 1.0f);
    }

    private void N() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f3807q = animatorSet;
        animatorSet.play(this.f3800j).with(this.f3806p).after(this.f3805o);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f3808r = animatorSet2;
        animatorSet2.play(this.f3801k).with(this.f3806p).after(this.f3805o);
        this.f3808r.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.f3813w = new androidx.appcompat.app.a.C0000a(this.f3792b).f(R.string.dialog_delete_history).l(R.string.delete_history_ok, new e()).i(R.string.delete_history_cancel, null).a();
    }

    private ValueAnimator Q(float f3, float f4, int i3, boolean z2) {
        PathInterpolator pathInterpolator = z2 ? new PathInterpolator(0.2f, 0.45f, 0.32f, 1.0f) : new PathInterpolator(0.4f, 0.01f, 0.63f, 0.87f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f3, f4);
        valueAnimatorOfFloat.setInterpolator(pathInterpolator);
        valueAnimatorOfFloat.setDuration(i3);
        valueAnimatorOfFloat.addUpdateListener(new i());
        if (f3 < f4) {
            valueAnimatorOfFloat.addListener(new j());
        }
        return valueAnimatorOfFloat;
    }

    private void R(LinearLayout linearLayout, CalculatorResult calculatorResult) {
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new g());
        }
        if (calculatorResult != null) {
            calculatorResult.setOnClickListener(new h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        ArrayList<Map<String, String>> arrayListQ = z1.d.r(this.f3792b).q();
        this.f3809s = arrayListQ;
        if (arrayListQ == null) {
            VLog.d("BBKCalculator/HistoryLayout", "mHistoryData=null");
        }
        this.f3811u.a(this.f3809s);
        this.f3811u.notifyDataSetChanged();
        ListView listView = this.f3810t;
        if (listView != null) {
            listView.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (!this.f3795e) {
            this.f3798h.setVisibility(4);
            this.f3814x.setVisibility(4);
            this.f3812v.setImportantForAccessibility(1);
            this.f3812v.setTextAppearance(R.style.clearhistorybuttonstyle);
            b0();
            return;
        }
        this.f3798h.setVisibility(0);
        this.f3814x.setVisibility(0);
        ArrayList<Map<String, String>> arrayList = this.f3809s;
        if (arrayList != null && arrayList.isEmpty()) {
            this.f3799i.setVisibility(0);
            this.f3810t.setVisibility(8);
            this.f3812v.setImportantForAccessibility(2);
            this.f3812v.setTextAppearance(R.style.clearhistorybuttonstylenone);
        }
        ArrayList<Map<String, String>> arrayList2 = this.f3809s;
        if (arrayList2 == null || arrayList2.isEmpty() || this.f3795e) {
            return;
        }
        this.f3799i.setVisibility(8);
        this.f3810t.setVisibility(0);
    }

    private boolean a() {
        String strA = g2.c.a(System.currentTimeMillis());
        VLog.d("BBKCalculator/HistoryLayout", "DateTimeIsChanges: preDateTime === " + this.B + ", nowDateTime : " + strA);
        if (this.B == strA) {
            return false;
        }
        this.B = strA;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(boolean z2) {
        this.f3815y = true;
        this.f3816z = z2;
        VLog.d("BBKCalculator/HistoryLayout", "scheduleNotifyHistoryDataChange " + this.f3815y + " " + this.f3816z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if (this.f3812v == null) {
            return;
        }
        if (g2.b.b(this.f3792b)) {
            this.f3812v.setTextColor(getResources().getColor(R.color.function_text_blue_color_material));
        } else {
            this.f3812v.setTextColor(getResources().getColor(R.color.function_text_blue_color));
        }
    }

    private void c0() {
        float f3 = this.f3792b.getResources().getDisplayMetrics().density;
        if (this.f3792b.getResources().getConfiguration().orientation != 1) {
            int paddingRightLand = getPaddingRightLand();
            LinearLayout linearLayout = this.f3798h;
            if (linearLayout != null) {
                linearLayout.setPadding(0, 0, paddingRightLand, 0);
                return;
            }
            return;
        }
        int paddingRight = getPaddingRight();
        getPaddingTop();
        LinearLayout linearLayout2 = this.f3798h;
        if (linearLayout2 != null) {
            linearLayout2.setPadding((int) (f3 * 0.0f), 0, paddingRight, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        if (this.f3807q.isRunning() || this.f3808r.isRunning() || !this.f3795e) {
            return;
        }
        F(2);
    }

    private void e0() {
        float f3 = this.f3792b.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.delete_history_container);
        if (this.f3792b.getResources().getConfiguration().orientation == 1) {
            int paddingRight = getPaddingRight();
            if (linearLayout != null) {
                linearLayout.setPadding((int) (f3 * 0.0f), 0, paddingRight, 0);
                return;
            }
            return;
        }
        int paddingRightLand = getPaddingRightLand();
        if (linearLayout != null) {
            linearLayout.setPadding(0, 0, paddingRightLand, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        VLog.d("BBKCalculator/HistoryLayout", "togeHistoryList isRunning1 = " + this.f3807q.isRunning() + " isRunning2 = " + this.f3808r.isRunning());
        if (this.f3807q.isRunning() || this.f3808r.isRunning()) {
            return;
        }
        VLog.d("BBKCalculator/HistoryLayout", "togeHistoryList mHistoryListOpen = " + this.f3795e);
        if (this.f3795e) {
            F(1);
        } else {
            X();
            h2.a.a().f(13);
        }
    }

    private void getChildView() {
        this.f3798h = (LinearLayout) findViewById(R.id.history_view);
        this.f3797g = (LinearLayout) getChildAt(1);
    }

    private int getPaddingRightLand() {
        double d3 = this.f3792b.getResources().getDisplayMetrics().density;
        int iH = (int) (((((double) this.f3793c) - (20.0d * d3)) - (d3 * 264.0d)) / 7.0d);
        if (iH < 0) {
            iH = 0;
        }
        if (getId() == R.id.history_layout) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f3792b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iH = (int) (((float) H(displayMetrics.widthPixels - (getResources().getDimension(R.dimen.keybord_margin) * 2.0f), getResources().getInteger(R.integer.keguard_main_weight) + getResources().getInteger(R.integer.keguard_one_col_weight), 4)) * getResources().getInteger(R.integer.keyguard_middle_layout_columnWeight));
        }
        VLog.d("BBKCalculator/HistoryLayout", "getPaddingRightLand: paddingRight === " + iH);
        return iH;
    }

    private void setCalculator(Calculator calculator) {
        this.f3796f = calculator;
    }

    private void setmHistoryTogeButton(ImageButton imageButton) {
        this.f3802l = imageButton;
        imageButton.setOnClickListener(new f());
    }

    private void setmMrView(ColorSelectButton colorSelectButton) {
        this.f3803m = colorSelectButton;
    }

    public void D() {
        ValueAnimator valueAnimator = this.f3800j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f3800j = null;
        }
        ValueAnimator valueAnimator2 = this.f3801k;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f3801k = null;
        }
        ValueAnimator valueAnimator3 = this.f3805o;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.f3805o = null;
        }
        ValueAnimator valueAnimator4 = this.f3806p;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
            this.f3806p = null;
        }
    }

    public void F(int i3) {
        VLog.d("BBKCalculator/HistoryLayout", "closeHistoryList mHistoryListOpen " + this.f3795e);
        if (this.f3795e) {
            VLog.d("BBKCalculator/HistoryLayout", "mCloseHistoryAnimationSet.start()");
            ColorButton colorButton = this.f3804n;
            if (colorButton != null) {
                colorButton.setEnabled(false);
            }
            this.f3808r.start();
            if (i3 != -1) {
                h2.a.a().e(i3);
                h2.a.a().f(70);
            }
        }
    }

    public void G() {
        if (this.f3795e) {
            androidx.appcompat.app.a aVar = this.f3813w;
            if (aVar != null && aVar.isShowing()) {
                this.f3813w.dismiss();
            }
            this.f3797g.setX(g2.b.f(this.f3792b, 0.0f));
            this.f3802l.setImageDrawable(this.f3792b.getResources().getDrawable(R.drawable.history_open));
            E();
            ColorButton colorButton = this.f3804n;
            if (colorButton != null) {
                colorButton.setEnabled(false);
                this.f3804n.setAlpha(0.0f);
            }
        }
    }

    public double H(double d3, double d4, int i3) {
        return new BigDecimal(Double.toString(d3)).divide(new BigDecimal(Double.toString(d4)), i3, 4).doubleValue();
    }

    public void J(Calculator calculator, ImageButton imageButton, LinearLayout linearLayout, CalculatorResult calculatorResult, ColorSelectButton colorSelectButton, ColorButton colorButton) {
        getChildView();
        setCalculator(calculator);
        setDelButton(colorButton);
        setmHistoryTogeButton(imageButton);
        setmMrView(colorSelectButton);
        R(linearLayout, calculatorResult);
        M();
        N();
    }

    public void K() {
        this.f3812v = (Button) findViewById(R.id.delete_history);
        this.f3814x = (LinearLayout) findViewById(R.id.delete_history_container);
        LayoutInflater.from(this.f3792b);
        O();
        this.f3812v.setOnClickListener(new c());
        this.f3810t.setOnItemClickListener(new d());
    }

    public void P() {
        if (this.f3810t == null) {
            g2.g.f((LinearLayout) findViewById(R.id.history_list_layout), 0);
            ListView listView = (ListView) findViewById(R.id.history_list);
            this.f3810t = listView;
            listView.setAdapter((ListAdapter) this.f3811u);
            this.f3810t.setVerticalScrollBarEnabled(false);
            if (g2.b.b(this.f3792b)) {
                this.f3810t.setSelector(this.f3792b.getDrawable(R.drawable.list_item_background_selector_material));
            } else {
                this.f3810t.setSelector(this.f3792b.getDrawable(R.drawable.list_item_background_selector));
            }
            try {
                Method declaredMethod = AbsListView.class.getDeclaredMethod("setHoldingModeEnabled", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f3810t, Boolean.FALSE);
            } catch (Exception unused) {
                VLog.d("BBKCalculator/HistoryLayout", "setHoldingModeEnabled FAIL");
            }
            try {
                Method declaredMethod2 = AbsListView.class.getDeclaredMethod("setSpringEffect", Boolean.TYPE);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(this.f3810t, Boolean.TRUE);
            } catch (Exception unused2) {
                VLog.d("BBKCalculator/HistoryLayout", "setSpringEffect FAIL");
            }
        }
        this.f3799i = (LinearLayout) findViewById(R.id.no_history);
        TextView textView = (TextView) findViewById(R.id.no_history_text);
        if (g2.b.o(this.f3792b) || !g2.b.n() || textView == null || textView.getVisibility() != 0) {
            return;
        }
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).setMargins(0, 0, 0, 0);
    }

    public boolean S() {
        androidx.appcompat.app.a aVar = this.f3813w;
        if (aVar != null) {
            return aVar.isShowing();
        }
        return false;
    }

    public boolean T() {
        LinearLayout linearLayout = this.f3797g;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout.getChildCount() == 9) {
            return true;
        }
        return this.f3797g.getChildCount() != 11 && getResources().getConfiguration().orientation == 2;
    }

    public void U() {
        LinearLayout linearLayout;
        V();
        ArrayList<Map<String, String>> arrayList = this.f3809s;
        if (arrayList != null && arrayList.isEmpty()) {
            this.f3799i.setVisibility(0);
            this.f3810t.setVisibility(8);
            this.f3812v.setImportantForAccessibility(2);
            this.f3812v.setTextAppearance(R.style.clearhistorybuttonstylenone);
        }
        ArrayList<Map<String, String>> arrayList2 = this.f3809s;
        if (arrayList2 == null || arrayList2.isEmpty() || this.f3795e || (linearLayout = this.f3799i) == null) {
            return;
        }
        linearLayout.setVisibility(8);
        this.f3810t.setVisibility(0);
        this.f3812v.setImportantForAccessibility(1);
        this.f3812v.setTextAppearance(R.style.clearhistorybuttonstyle);
        b0();
    }

    public void X() {
        VLog.d("BBKCalculator/HistoryLayout", " openHistoryList");
        if (this.f3795e) {
            return;
        }
        ColorButton colorButton = this.f3804n;
        if (colorButton != null) {
            colorButton.setEnabled(true);
        }
        ArrayList<Map<String, String>> arrayList = this.f3809s;
        if (arrayList != null && !arrayList.isEmpty() && a()) {
            z1.d.r(this.f3792b).s();
        }
        c0();
        e0();
        ListView listView = this.f3810t;
        if (listView != null) {
            listView.setSelection(0);
        }
        AnimatorSet animatorSet = this.f3807q;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void Y() {
        androidx.appcompat.app.a aVar = this.f3813w;
        if (aVar != null) {
            if (aVar.isShowing()) {
                this.f3813w.dismiss();
            }
            this.f3813w = null;
        }
    }

    public void Z(Map<String, String> map) {
        if (this.f3795e) {
            this.A = map;
            a0(false);
        } else {
            z1.d.r(this.f3792b).u(map);
            U();
        }
    }

    public void f0() {
        androidx.appcompat.app.a aVar = this.f3813w;
        if (aVar != null) {
            aVar.show();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public boolean getHistoryListOpen() {
        return this.f3795e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        double d3;
        double d4;
        double d5;
        float f3 = this.f3792b.getResources().getDisplayMetrics().density;
        if (T()) {
            d3 = f3;
            d4 = (((double) this.f3793c) - (0.0d * d3)) / 4.0d;
            d5 = 60.0d;
        } else {
            d3 = f3;
            d4 = (((double) this.f3793c) - (0.0d * d3)) / 3.0d;
            d5 = 130.0d;
        }
        int iH = (int) (d4 - (d3 * d5));
        if (iH < 0) {
            iH = 0;
        }
        if (getId() == R.id.history_layout) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f3792b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iH = (int) (((float) H(displayMetrics.widthPixels - (getResources().getDimension(R.dimen.keybord_margin) * 2.0f), getResources().getInteger(R.integer.keguard_main_weight) + getResources().getInteger(R.integer.keguard_one_col_weight), 4)) * getResources().getInteger(R.integer.keyguard_middle_layout_columnWeight));
        }
        VLog.d("BBKCalculator/HistoryLayout", "getPaddingRight: paddingRight === " + iH);
        return iH;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        int i3 = (int) ((((double) this.f3794d) / 6.0d) - (((double) this.f3792b.getResources().getDisplayMetrics().density) * 60.0d));
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        this.f3793c = View.MeasureSpec.getSize(i3);
        this.f3794d = View.MeasureSpec.getSize(i4);
    }

    public void setDelButton(ColorButton colorButton) {
        this.f3804n = colorButton;
        if (colorButton != null) {
            colorButton.setEnabled(false);
        }
    }

    public HistoryLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3792b = null;
        this.f3795e = false;
        this.f3811u = new l(this, null);
        this.f3815y = false;
        this.f3816z = false;
        this.C = false;
        I(context);
    }

    public HistoryLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3792b = null;
        this.f3795e = false;
        this.f3811u = new l(this, null);
        this.f3815y = false;
        this.f3816z = false;
        this.C = false;
        I(context);
    }
}
