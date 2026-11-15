package com.vivo.calculator.exchangelist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.calculator.R;
import com.vivo.calculator.helper.CountryProvide;
import com.vivo.toastthumb.ToastThumb;
import com.vos.widget.VToolBar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class CountryList extends b.b implements AdapterView.OnItemClickListener, a2.b {
    private Intent A;
    private SharedPreferences B;
    private SharedPreferences.Editor C;
    private ImageButton D;
    private VToolBar H;
    private boolean I;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Context f4105t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ListView f4106u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private b2.a f4108w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ArrayList<c2.c> f4109x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ToastThumb f4107v = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private c2.b f4110y = new c2.b();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List<String> f4111z = Arrays.asList("#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
    private boolean E = false;
    private Handler F = new g(this, null);
    private ContentObserver G = new a(new Handler());
    private BroadcastReceiver J = new f();

    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            super.onChange(z2);
            if (CountryList.this.F != null) {
                Message messageObtainMessage = CountryList.this.F.obtainMessage();
                messageObtainMessage.what = 1;
                if (CountryList.this.F.hasMessages(messageObtainMessage.what)) {
                    CountryList.this.F.removeMessages(messageObtainMessage.what);
                }
                CountryList.this.F.sendMessageDelayed(messageObtainMessage, 100L);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CountryList.this.isInMultiWindowMode()) {
                BBKCalculatorApplication.q(true);
            }
            CountryList.this.onBackPressed();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CountryList.this.f4106u.smoothScrollToPosition(0);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CountryList.this.startActivityForResult(new Intent(CountryList.this.f4105t, (Class<?>) CountryListSearchResult.class), 0);
        }
    }

    class e implements t2.d.a {
        e() {
        }

        @Override // t2.d.a
        public void a(View view, int i3) {
            CountryList.this.U(view, i3);
        }

        @Override // t2.d.a
        public void b(View view, int i3) {
            CountryList.this.U(view, i3);
        }

        @Override // t2.d.a
        public void c(View view) {
        }
    }

    class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            VLog.d("BBKCalculator/CountryList", "mScreenReceiver action = " + action);
            if (!"android.intent.action.SCREEN_OFF".equals(action) || Build.VERSION.SDK_INT <= 26) {
                return;
            }
            CountryList.this.setShowWhenLocked(false);
        }
    }

    private static final class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<CountryList> f4118a;

        /* synthetic */ g(CountryList countryList, a aVar) {
            this(countryList);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CountryList countryList = this.f4118a.get();
            if (countryList == null || countryList.isFinishing()) {
                return;
            }
            countryList.N(message);
        }

        private g(CountryList countryList) {
            this.f4118a = null;
            this.f4118a = new WeakReference<>(countryList);
        }
    }

    private void K() {
        if (this.f4107v != null) {
            VLog.d("BBKCalculator/CountryList", "addAbcThumbsSelectListener: ");
            this.f4107v.setSlideListener(new e());
        }
    }

    private String L() {
        String string = this.B.getString("local_country", null);
        return this.B.getString("local_language", null) + "_" + string;
    }

    private void M(String str) {
        if ("ZH".equalsIgnoreCase(str)) {
            R();
        } else {
            Q("currency_name", "currency_name COLLATE LOCALIZED ASC");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Message message) {
        if (this.F != null && message.what == 1) {
            W();
        }
    }

    private void O() {
        this.D = (ImageButton) findViewById(R.id.search);
        ListView listView = (ListView) findViewById(R.id.country_list);
        this.f4106u = listView;
        listView.setSpringEffect(true);
        this.f4106u.setOverScrollMode(0);
        this.f4107v = (ToastThumb) findViewById(R.id.alphabet_indexer);
        W();
        this.f4107v.setToastDelayedTime(300L);
        this.f4107v.setAlphabet(this.f4111z);
        this.D.setOnClickListener(new d());
        K();
        if (this.f4109x != null) {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.listview_header_view, (ViewGroup) this.f4106u, false);
            if (viewInflate != null) {
                viewInflate.setEnabled(false);
                this.f4106u.addHeaderView(viewInflate);
            }
            b2.a aVar = new b2.a(getApplicationContext(), this.f4109x);
            this.f4108w = aVar;
            this.f4106u.setAdapter((ListAdapter) aVar);
            this.f4106u.setOnItemClickListener(this);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.search_move_container);
        if (!g2.b.b(this)) {
            this.f4107v.getToastTextView().setBackgroundColor(getColor(R.color.function_text_blue_stroke_color));
            return;
        }
        this.f4107v.getToastTextView().setBackgroundColor(getColor(R.color.function_text_blue_stroke_color_material));
        this.f4107v.setTextColor(getColor(R.color.code_text_color_material));
        relativeLayout.setBackgroundResource(R.color.setting_background_material);
    }

    private void Q(String str, String str2) {
        this.f4109x = this.f4110y.d(getApplicationContext(), CountryProvide.f4144c, null, null, null, str2);
    }

    private void R() {
        this.f4109x = this.f4110y.d(getApplicationContext(), CountryProvide.f4144c, null, null, null, "currency_name_py COLLATE LOCALIZED ASC");
    }

    private void S() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(this.J, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(View view, int i3) {
        int i4;
        if (i3 == 0) {
            this.f4106u.setSelection(0);
            return;
        }
        String string = this.B.getString("local_language", null);
        for (int i5 = 0; i5 < this.f4109x.size(); i5++) {
            try {
                if ("ZH".equalsIgnoreCase(string)) {
                    VLog.d("BBKCalculator/CountryList", " showThumbPopWin:2 " + this.f4109x.get(i5).d().substring(0, 1));
                    i4 = Integer.parseInt(V(this.f4109x.get(i5).d().substring(0, 1)));
                } else {
                    i4 = Integer.parseInt(V(this.f4109x.get(i5).c().substring(0, 1)));
                    VLog.d("BBKCalculator/CountryList", " showThumbPopWin:3" + this.f4109x.get(i5).c().substring(0, 1));
                }
                if (i4 >= Integer.parseInt(V(this.f4111z.get(i3)))) {
                    VLog.d("BBKCalculator/CountryList", " showThumbPopWin: " + i5);
                    this.f4106u.setSelection(i5 + 1);
                    return;
                }
            } catch (Exception e3) {
                VLog.e("BBKCalculator/CountryList", "showThumbPopWin，e " + e3);
                return;
            }
        }
    }

    private String V(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toUpperCase(Locale.getDefault()).toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (i3 != charArray.length - 1) {
                stringBuffer.append((int) charArray[i3]);
                stringBuffer.append(",");
            } else {
                stringBuffer.append((int) charArray[i3]);
            }
        }
        String string = stringBuffer.toString();
        VLog.d("BBKCalculator/CountryList", "stringToAscii: " + ((Object) stringBuffer));
        return string;
    }

    private void W() {
        String string = this.B.getString("local_language", null);
        ArrayList<c2.c> arrayList = this.f4109x;
        if (arrayList != null) {
            arrayList.clear();
        }
        M(string);
        T(this.f4109x);
        b2.a aVar = this.f4108w;
        if (aVar != null) {
            aVar.a(this.f4109x);
            this.f4108w.notifyDataSetChanged();
        }
    }

    public void P() {
        String strL = L();
        if (TextUtils.isEmpty(strL) || !("ZH_CN".equalsIgnoreCase(strL) || strL.startsWith("EN") || strL.startsWith("en"))) {
            this.f4107v.setVisibility(8);
        } else {
            this.f4107v.setVisibility(0);
        }
    }

    public void T(ArrayList<c2.c> arrayList) {
        ArrayList<c2.c> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            c2.c cVar = new c2.c();
            String strD = g2.e.d(arrayList.get(i3).c());
            if (i3 == 0) {
                cVar.l(true);
                cVar.i(strD);
                cVar.j(strD);
                arrayList2.add(cVar);
                arrayList2.add(arrayList.get(i3));
            } else {
                String strD2 = g2.e.d(arrayList.get(i3 - 1).c());
                if (TextUtils.isEmpty(strD) || !strD.equals(strD2)) {
                    cVar.l(true);
                    cVar.i(strD);
                    cVar.j(strD);
                    arrayList2.add(cVar);
                    arrayList2.add(arrayList.get(i3));
                } else {
                    cVar.l(false);
                    arrayList2.add(arrayList.get(i3));
                }
            }
        }
        this.f4109x.clear();
        this.f4109x = arrayList2;
    }

    @Override // a2.b
    public void a(boolean z2) {
        VLog.d("BBKCalculator/CountryList", "setCalculatorConfigurationInfo isNexScreenChange = " + z2);
        if (z2) {
            if (g2.b.o(this)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (intent == null) {
            return;
        }
        setResult(1, intent);
        finish();
    }

    @Override // b.b, androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VLog.d("BBKCalculator/CountryList", "onConfigurationChanged ");
        if (g2.b.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // b.b, androidx.fragment.app.d, androidx.activity.ComponentActivity, t.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        g2.d.a(this);
        if (!g2.b.b(this)) {
            setTheme(R.style.notitleBarThemeOverlay);
        }
        super.onCreate(bundle);
        this.f4105t = getApplicationContext();
        if (Build.VERSION.SDK_INT > 26) {
            setShowWhenLocked(true);
        }
        if (g2.b.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.country_view);
        VToolBar vToolBar = (VToolBar) findViewById(R.id.toolbar);
        this.H = vToolBar;
        vToolBar.setNavigationContentDescription(R.string.description_btn_back);
        this.H.setNavigationOnClickListener(new b());
        this.H.P(true);
        this.H.setOnClickListener(new c());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.B = defaultSharedPreferences;
        this.C = defaultSharedPreferences.edit();
        O();
        S();
        BBKCalculatorApplication.a().n(this);
    }

    @Override // b.b, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.F = null;
        }
        if (this.G != null) {
            getContentResolver().unregisterContentObserver(this.G);
        }
        unregisterReceiver(this.J);
        BBKCalculatorApplication.a().n(null);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        c2.c cVar = (c2.c) adapterView.getAdapter().getItem(i3);
        if (cVar == null) {
            return;
        }
        String strB = cVar.b();
        VLog.d("BBKCalculator/CountryList", "onItemClick : mOtherExchange ===" + cVar.e());
        this.C.putString("check_position", strB);
        this.C.apply();
        Intent intent = new Intent();
        this.A = intent;
        intent.putExtra("other_currency", cVar.c());
        this.A.putExtra("other_currency_code", strB);
        String strA = cVar.a();
        if (!TextUtils.isEmpty(strA)) {
            h2.a.a().b(strB);
            String[] strArrSplit = strA.split("\n");
            VLog.d("BBKCalculator/CountryList", "onItemClick  getCurrencyCode ===" + strArrSplit[0] + this.E);
            StringBuilder sb = new StringBuilder();
            sb.append("onItemClick  getCurrencyCode === isInMultiWindowMode() ");
            sb.append(isInMultiWindowMode());
            VLog.d("BBKCalculator/CountryList", sb.toString());
            if (isInMultiWindowMode()) {
                if (this.B.getInt("REQUEST_CODE", 1) == 0) {
                    this.C.putString("other_currency", cVar.c());
                    this.C.putString("other_currency_code", strB);
                    this.C.putString("other_country_code", strArrSplit[0]);
                    this.C.putString("exchange", cVar.e());
                    this.C.commit();
                } else {
                    this.C.putString("local_currency", cVar.c());
                    this.C.putString("local_currency_code", strB);
                    this.C.putString("local_country_code", strArrSplit[0]);
                    this.C.putString("exchange", cVar.e());
                    this.C.commit();
                }
            }
            this.A.putExtra("other_country_code", strArrSplit[0]);
            this.A.putExtra("exchange", cVar.e());
            setResult(1, this.A);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        super.onMultiWindowModeChanged(this.E, configuration);
        this.E = z2;
        g2.e.m(this.f4105t, this.I);
        VLog.d("BBKCalculator/CountryList", "onMultiWindowModeChanged: mIsInMultiWindowMode " + this.E + "isCalculator " + this.I);
        ToastThumb toastThumb = this.f4107v;
        if (toastThumb != null) {
            if (this.E) {
                toastThumb.setVisibility(8);
            } else {
                P();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.I = getIntent().getBooleanExtra("is_calculator", false);
        VLog.d("BBKCalculator/CountryList", "onResume: isInMultiWindowMode == " + isInMultiWindowMode());
        if (this.f4107v == null || isInMultiWindowMode()) {
            ToastThumb toastThumb = this.f4107v;
            if (toastThumb != null) {
                toastThumb.setVisibility(8);
            }
        } else {
            P();
        }
        getContentResolver().registerContentObserver(CountryProvide.f4144c, true, this.G);
    }

    @Override // b.b, androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        super.onStop();
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
