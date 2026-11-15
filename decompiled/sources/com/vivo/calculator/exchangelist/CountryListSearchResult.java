package com.vivo.calculator.exchangelist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.calculator.R;
import com.vivo.seckeysdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import vivo.util.VLog;

/* JADX INFO: loaded from: classes.dex */
public class CountryListSearchResult extends b.b implements a2.d {
    private Context C;
    private String[] I;
    private String J;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ListView f4119t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private LinearLayout f4120u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Intent f4121v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private SharedPreferences f4122w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private SharedPreferences.Editor f4123x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CurrencySearchView f4124y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List<c2.c> f4125z = new ArrayList();
    private f A = null;
    private String B = BuildConfig.FLAVOR;
    private c2.b D = new c2.b();
    private b2.c E = new b();
    private AdapterView.OnItemClickListener F = new c();
    private long G = 0;
    private AdapterView.OnItemLongClickListener H = new d();
    private BroadcastReceiver K = new e();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CountryListSearchResult.this.f4124y.h();
        }
    }

    class b implements b2.c {
        b() {
        }

        @Override // b2.c
        public void a(String str) {
            CountryListSearchResult.this.b0(str);
        }

        @Override // b2.c
        public void b() {
            CountryListSearchResult.this.f4124y.d();
            CountryListSearchResult.this.finish();
        }
    }

    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (CountryListSearchResult.this.f4124y != null) {
                CountryListSearchResult.this.f4124y.e();
            }
            c2.c cVar = (c2.c) CountryListSearchResult.this.f4125z.get(i3);
            String strB = cVar.b();
            VLog.d("BBKCalculator/CountryListSearchResult", "search onItemClick: getCurrencyCode ===" + strB);
            CountryListSearchResult.this.f4123x.putString("check_position", strB);
            CountryListSearchResult.this.f4123x.apply();
            CountryListSearchResult.this.f4121v = new Intent();
            CountryListSearchResult.this.f4121v.putExtra("other_currency", cVar.c());
            String strA = cVar.a();
            if (!TextUtils.isEmpty(strA)) {
                String[] strArrSplit = strA.split("\n");
                VLog.d("BBKCalculator/CountryListSearchResult", "search onItemClick: getCurrencyCode ===" + strArrSplit[0]);
                CountryListSearchResult.this.f4121v.putExtra("other_currency_code", strB);
                CountryListSearchResult.this.f4121v.putExtra("other_country_code", strArrSplit[0]);
                CountryListSearchResult.this.f4121v.putExtra("exchange", cVar.e());
                CountryListSearchResult countryListSearchResult = CountryListSearchResult.this;
                countryListSearchResult.setResult(1, countryListSearchResult.f4121v);
                if (CountryListSearchResult.this.isInMultiWindowMode()) {
                    if (CountryListSearchResult.this.f4122w.getInt("REQUEST_CODE", 1) == 0) {
                        CountryListSearchResult.this.f4123x.putString("other_currency", cVar.c());
                        CountryListSearchResult.this.f4123x.putString("other_currency_code", strB);
                        CountryListSearchResult.this.f4123x.putString("other_country_code", strArrSplit[0]);
                        CountryListSearchResult.this.f4123x.putString("exchange", cVar.e());
                        CountryListSearchResult.this.f4123x.commit();
                    } else {
                        CountryListSearchResult.this.f4123x.putString("local_currency", cVar.c());
                        CountryListSearchResult.this.f4123x.putString("local_currency_code", strB);
                        CountryListSearchResult.this.f4123x.putString("local_country_code", strArrSplit[0]);
                        CountryListSearchResult.this.f4123x.putString("exchange", cVar.e());
                        CountryListSearchResult.this.f4123x.commit();
                    }
                }
            }
            CountryListSearchResult.this.finish();
        }
    }

    class d implements AdapterView.OnItemLongClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (Math.abs(CountryListSearchResult.this.G - SystemClock.uptimeMillis()) < 500) {
                return true;
            }
            CountryListSearchResult.this.G = SystemClock.uptimeMillis();
            return false;
        }
    }

    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            VLog.d("BBKCalculator/CountryListSearchResult", "mScreenReceiver action = " + action);
            if (!"android.intent.action.SCREEN_OFF".equals(action) || Build.VERSION.SDK_INT <= 26) {
                return;
            }
            CountryListSearchResult.this.setShowWhenLocked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(String str) {
        this.B = str;
        a aVar = null;
        this.f4119t.setAdapter((ListAdapter) null);
        f fVar = this.A;
        if (fVar != null) {
            fVar.cancel(true);
            this.A = null;
        }
        if (this.A != null || str == null) {
            return;
        }
        f fVar2 = new f(this, aVar);
        this.A = fVar2;
        fVar2.execute(str);
    }

    private void c0() {
        CurrencySearchView currencySearchView = (CurrencySearchView) findViewById(R.id.search_view);
        this.f4124y = currencySearchView;
        currencySearchView.setSearchListener(this.E);
        new Handler().postDelayed(new a(), 400L);
        this.f4120u = (LinearLayout) findViewById(R.id.search_emptyText);
        ListView listView = (ListView) findViewById(R.id.search_list);
        this.f4119t = listView;
        listView.setOnItemClickListener(this.F);
        this.f4119t.setOnItemLongClickListener(this.H);
        this.f4119t.setSpringEffect(true);
        this.f4119t.setOverScrollMode(0);
        this.f4119t.setOnItemClickListener(this.F);
        EditText editText = (EditText) findViewById(R.id.search_edit);
        if (g2.b.b(this)) {
            editText.setTextColor(getColor(R.color.input_text_color_material));
        }
    }

    private void d0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(this.K, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(boolean z2) {
        if (z2) {
            this.f4120u.setVisibility(0);
        } else {
            this.f4120u.setVisibility(8);
        }
    }

    @Override // a2.d
    public void a(boolean z2) {
        VLog.d("BBKCalculator/CountryListSearchResult", "setCalculatorConfigurationInfo isNexScreenChange = " + z2);
        if (z2) {
            if (g2.b.o(this)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public ListView a0(Context context) {
        VLog.d("BBKCalculator/CountryListSearchResult", "getListViewObj: ");
        if (this.f4119t == null) {
            this.f4119t = new ListView(context);
        }
        return this.f4119t;
    }

    @Override // b.b, androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VLog.d("BBKCalculator/CountryListSearchResult", "onConfigurationChanged ");
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
        this.C = getApplicationContext();
        if (Build.VERSION.SDK_INT > 26) {
            setShowWhenLocked(true);
        }
        if (g2.b.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.layout_search);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.f4122w = defaultSharedPreferences;
        this.f4123x = defaultSharedPreferences.edit();
        c0();
        d0();
        BBKCalculatorApplication.a().s(this);
    }

    @Override // b.b, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.K);
        BBKCalculatorApplication.a().s(null);
    }

    private class f extends AsyncTask<String, Boolean, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Cursor f4131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<c2.c> f4132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b2.b f4133c;

        private f() {
            this.f4132b = new ArrayList();
            this.f4133c = new b2.b(CountryListSearchResult.this.C, R.layout.search_item_list, this.f4132b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            CountryListSearchResult.this.B = strArr[0];
            this.f4133c.b(CountryListSearchResult.this.B);
            if (CountryListSearchResult.this.f4124y.getVisibility() == 8) {
                return Boolean.FALSE;
            }
            if (TextUtils.isEmpty(strArr[0])) {
                return Boolean.FALSE;
            }
            CountryListSearchResult countryListSearchResult = CountryListSearchResult.this;
            countryListSearchResult.D = new c2.b(countryListSearchResult.C);
            CountryListSearchResult.this.J = "curr LIKE '%" + CountryListSearchResult.this.B + "%' OR currency_name LIKE '%" + CountryListSearchResult.this.B + "%'";
            CountryListSearchResult countryListSearchResult2 = CountryListSearchResult.this;
            countryListSearchResult2.I = new String[]{countryListSearchResult2.B};
            try {
                if ("zh".equalsIgnoreCase(CountryListSearchResult.this.f4122w.getString("local_language", null))) {
                    this.f4131a = CountryListSearchResult.this.D.e(null, CountryListSearchResult.this.J, null, "currency_name_py COLLATE LOCALIZED ASC");
                } else {
                    this.f4131a = CountryListSearchResult.this.D.e(null, CountryListSearchResult.this.J, null, "currency_name COLLATE LOCALIZED ASC");
                }
                if (this.f4131a == null) {
                    return Boolean.TRUE;
                }
                if (!isCancelled() && !this.f4131a.isClosed()) {
                    while (this.f4131a.moveToNext()) {
                        c2.c cVar = new c2.c();
                        this.f4131a.getColumnIndex("id");
                        int columnIndex = this.f4131a.getColumnIndex("curr");
                        if (columnIndex != -1) {
                            cVar.h(this.f4131a.getString(columnIndex));
                        }
                        int columnIndex2 = this.f4131a.getColumnIndex("code");
                        if (columnIndex2 != -1) {
                            cVar.g(this.f4131a.getString(columnIndex2));
                        }
                        int columnIndex3 = this.f4131a.getColumnIndex("currency_name");
                        if (columnIndex3 != -1) {
                            cVar.i(this.f4131a.getString(columnIndex3));
                        }
                        int columnIndex4 = this.f4131a.getColumnIndex("exchange");
                        if (columnIndex4 != -1) {
                            cVar.k(this.f4131a.getString(columnIndex4));
                        }
                        int columnIndex5 = this.f4131a.getColumnIndex("currency_name_py");
                        if (columnIndex5 != -1) {
                            cVar.j(this.f4131a.getString(columnIndex5));
                        }
                        String strC = cVar.c();
                        String strB = cVar.b();
                        String strE = cVar.e();
                        if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(strB) && !"0".equalsIgnoreCase(strE) && !"0.0".equalsIgnoreCase(strE) && !TextUtils.isEmpty(strE)) {
                            this.f4132b.add(cVar);
                        }
                    }
                }
                return Boolean.TRUE;
            } catch (Exception e3) {
                VLog.e("BBKCalculator/CountryListSearchResult", "doInBackground e " + e3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            VLog.d("BBKCalculator/CountryListSearchResult", "onPostExecute: ");
            if (CountryListSearchResult.this.f4125z != null && CountryListSearchResult.this.f4125z.size() > 0) {
                CountryListSearchResult.this.f4125z.clear();
            }
            Cursor cursor = this.f4131a;
            if (cursor != null) {
                cursor.close();
            }
            CountryListSearchResult.this.f4125z = this.f4132b;
            if (bool.booleanValue()) {
                if (!isCancelled()) {
                    VLog.d("BBKCalculator/CountryListSearchResult", "onPostExecute: setAdapter  " + this.f4132b);
                    CountryListSearchResult.this.f4119t.setAdapter((ListAdapter) this.f4133c);
                }
                if (this.f4132b.size() == 0) {
                    CountryListSearchResult.this.f4120u.setVisibility(0);
                } else {
                    CountryListSearchResult.this.f4120u.setVisibility(8);
                }
            } else {
                this.f4132b.clear();
                CountryListSearchResult.this.f4119t.setAdapter((ListAdapter) null);
                CountryListSearchResult.this.e0(false);
            }
            super.onPostExecute(bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Boolean... boolArr) {
            super.onProgressUpdate(boolArr);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            VLog.d("BBKCalculator/CountryListSearchResult", "onCancelled: ");
            List<c2.c> list = this.f4132b;
            if (list != null) {
                list.clear();
            }
            Cursor cursor = this.f4131a;
            if (cursor != null) {
                cursor.close();
            }
            this.f4133c.clear();
            CountryListSearchResult.this.f4119t.setAdapter((ListAdapter) null);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            VLog.d("BBKCalculator/CountryListSearchResult", "onPreExecute: ");
            List<c2.c> list = this.f4132b;
            if (list != null) {
                list.clear();
            }
            if (CountryListSearchResult.this.f4125z == null || CountryListSearchResult.this.f4125z.size() <= 0) {
                return;
            }
            CountryListSearchResult.this.f4125z.clear();
        }

        /* synthetic */ f(CountryListSearchResult countryListSearchResult, a aVar) {
            this();
        }
    }
}
