package b2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.vivo.calculator.R;
import com.vivo.calculator.exchangelist.CountryListSearchResult;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchContentItemAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends ArrayAdapter<c2.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f2431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ListView f2432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountryListSearchResult f2433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c2.c f2434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SharedPreferences f2435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SharedPreferences.Editor f2436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f2437i;

    /* JADX INFO: compiled from: SearchContentItemAdapter.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f2438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f2439b;

        public a() {
        }
    }

    public b(Context context, int i3, List<c2.c> list) {
        super(context, i3, list);
        this.f2433e = new CountryListSearchResult();
        this.f2430b = i3;
        this.f2431c = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f2435g = defaultSharedPreferences;
        this.f2436h = defaultSharedPreferences.edit();
        if (this.f2432d == null) {
            this.f2432d = new ListView(this.f2431c);
            this.f2432d = this.f2433e.a0(this.f2431c);
        }
    }

    private SpannableString a(int i3, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return SpannableString.valueOf(str);
        }
        String str3 = "(?i)" + str2;
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(str3).matcher(new SpannableString(str.toLowerCase(Locale.getDefault())));
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(i3), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public void b(String str) {
        this.f2437i = str;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        this.f2434f = getItem(i3);
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(getContext()).inflate(this.f2430b, viewGroup, false);
            aVar.f2438a = (TextView) view.findViewById(R.id.country_info);
            aVar.f2439b = (TextView) view.findViewById(R.id.country_info_code);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (g2.b.b(this.f2431c)) {
            aVar.f2438a.setText(a(this.f2431c.getResources().getColor(R.color.clear_history_text_color_material), this.f2434f.c(), this.f2437i));
            aVar.f2439b.setText(a(this.f2431c.getResources().getColor(R.color.clear_history_text_color_material), this.f2434f.b(), this.f2437i));
            aVar.f2438a.setTextColor(this.f2431c.getColor(R.color.edit_text_color_material));
            aVar.f2439b.setTextColor(this.f2431c.getColor(R.color.edit_text_color_material));
        } else {
            aVar.f2438a.setText(a(this.f2431c.getResources().getColor(R.color.function_text_blue_color), this.f2434f.c(), this.f2437i));
            aVar.f2439b.setText(a(this.f2431c.getResources().getColor(R.color.function_text_blue_color), this.f2434f.b(), this.f2437i));
            aVar.f2438a.setTextColor(this.f2431c.getColor(R.color.edit_text_color));
            aVar.f2439b.setTextColor(this.f2431c.getColor(R.color.edit_text_color));
        }
        return view;
    }
}
