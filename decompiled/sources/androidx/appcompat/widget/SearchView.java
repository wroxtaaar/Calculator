package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.vivo.seckeysdk.BuildConfig;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends i0 implements g.c {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    static final n f390r0;
    private Rect A;
    private Rect B;
    private int[] C;
    private int[] D;
    private final ImageView E;
    private final Drawable F;
    private final int G;
    private final int H;
    private final Intent I;
    private final Intent J;
    private final CharSequence K;
    private l L;
    private k M;
    View.OnFocusChangeListener N;
    private m O;
    private View.OnClickListener P;
    private boolean Q;
    private boolean R;
    h0.a S;
    private boolean T;
    private CharSequence U;
    private boolean V;
    private boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f391a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f392b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private CharSequence f393c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private CharSequence f394d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f395e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f396f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    SearchableInfo f397g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Bundle f398h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Runnable f399i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private Runnable f400j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f401k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final View.OnClickListener f402l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    View.OnKeyListener f403m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final TextView.OnEditorActionListener f404n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f405o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f406p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final SearchAutoComplete f407q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private TextWatcher f408q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final View f409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final View f410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final View f411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final ImageView f412u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final ImageView f413v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final ImageView f414w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final ImageView f415x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final View f416y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private p f417z;

    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private SearchView f419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Runnable f421h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i4 = configuration.screenHeightDp;
            if (i3 >= 960 && i4 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i3 < 600) {
                return (i3 < 640 || i4 < 480) ? 160 : 192;
            }
            return 192;
        }

        void a() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f390r0.c(this);
                return;
            }
            setInputMethodMode(1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void c() {
            if (this.f420g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f420g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f418e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f420g) {
                removeCallbacks(this.f421h);
                post(this.f421h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z2, int i3, Rect rect) {
            super.onFocusChanged(z2, i3, rect);
            this.f419f.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f419f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i3, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z2) {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f419f.hasFocus() && getVisibility() == 0) {
                this.f420g = true;
                if (SearchView.M(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z2) {
                this.f420g = false;
                removeCallbacks(this.f421h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f420g = true;
                    return;
                }
                this.f420g = false;
                removeCallbacks(this.f421h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f419f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i3) {
            super.setThreshold(i3);
            this.f418e = i3;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f421h = new a();
            this.f418e = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            SearchView.this.Y(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h0.a aVar = SearchView.this.S;
            if (aVar instanceof q0) {
                aVar.b(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.N;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z2);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            SearchView.this.B();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f412u) {
                searchView.V();
                return;
            }
            if (view == searchView.f414w) {
                searchView.R();
                return;
            }
            if (view == searchView.f413v) {
                searchView.W();
            } else if (view == searchView.f415x) {
                searchView.a0();
            } else if (view == searchView.f407q) {
                searchView.H();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f397g0 == null) {
                return false;
            }
            if (searchView.f407q.isPopupShowing() && SearchView.this.f407q.getListSelection() != -1) {
                return SearchView.this.X(view, i3, keyEvent);
            }
            if (SearchView.this.f407q.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i3 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.f407q.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            SearchView.this.S(i3, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            SearchView.this.T(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        boolean a();
    }

    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    public interface m {
        boolean a(int i3);

        boolean b(int i3);
    }

    private static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f435c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        n() {
            this.f433a = null;
            this.f434b = null;
            this.f435c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f433a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f434b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f435c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f434b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f433a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f435c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    static class o extends i0.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f436d;

        class a implements Parcelable.ClassLoaderCreator<o> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public o[] newArray(int i3) {
                return new o[i3];
            }
        }

        o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f436d + "}";
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Boolean.valueOf(this.f436d));
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f436d = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    private static class p extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Rect f439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f441e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f442f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f441e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f438b = new Rect();
            this.f440d = new Rect();
            this.f439c = new Rect();
            a(rect, rect2);
            this.f437a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f438b.set(rect);
            this.f440d.set(rect);
            Rect rect3 = this.f440d;
            int i3 = this.f441e;
            rect3.inset(-i3, -i3);
            this.f439c.set(rect2);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003f  */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z2;
            boolean z3;
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z4 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z3 = this.f442f;
                    if (z3 && !this.f440d.contains(x3, y3)) {
                        z4 = z3;
                        z2 = false;
                    }
                } else if (action != 3) {
                    z2 = true;
                    z4 = false;
                } else {
                    z3 = this.f442f;
                    this.f442f = false;
                }
                z4 = z3;
                z2 = true;
            } else if (this.f438b.contains(x3, y3)) {
                this.f442f = true;
                z2 = true;
            } else {
                z2 = true;
                z4 = false;
            }
            if (!z4) {
                return false;
            }
            if (!z2 || this.f439c.contains(x3, y3)) {
                Rect rect = this.f439c;
                motionEvent.setLocation(x3 - rect.left, y3 - rect.top);
            } else {
                motionEvent.setLocation(this.f437a.getWidth() / 2, this.f437a.getHeight() / 2);
            }
            return this.f437a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f390r0 = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i3, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f394d0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f398h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i3 != 0) {
            intent.putExtra("action_key", i3);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f397g0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i3, String str) {
        int position;
        String strO;
        try {
            String strO2 = q0.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.f397g0.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = q0.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.f397g0.getSuggestIntentData();
            }
            if (strO3 != null && (strO = q0.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + "/" + Uri.encode(strO);
            }
            return C(str2, strO3 == null ? null : Uri.parse(strO3), q0.o(cursor, "suggest_intent_extra_data"), q0.o(cursor, "suggest_intent_query"), i3, str);
        } catch (RuntimeException e3) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e3);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f398h0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f407q.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i3 = iArr[1];
        int[] iArr2 = this.D;
        int i4 = i3 - iArr2[1];
        int i5 = iArr[0] - iArr2[0];
        rect.set(i5, i4, view.getWidth() + i5, view.getHeight() + i4);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.Q || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f407q.getTextSize()) * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.f397g0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f397g0.getVoiceSearchLaunchWebSearch()) {
            intent = this.I;
        } else if (this.f397g0.getVoiceSearchLaunchRecognizer()) {
            intent = this.J;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.T || this.f392b0) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e3) {
            Log.e("SearchView", "Failed launch activity: " + intent, e3);
        }
    }

    private boolean Q(int i3, int i4, String str) {
        Cursor cursorC = this.S.c();
        if (cursorC == null || !cursorC.moveToPosition(i3)) {
            return false;
        }
        O(D(cursorC, i4, str));
        return true;
    }

    private void b0() {
        post(this.f399i0);
    }

    private void c0(int i3) {
        Editable text = this.f407q.getText();
        Cursor cursorC = this.S.c();
        if (cursorC == null) {
            return;
        }
        if (!cursorC.moveToPosition(i3)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceA = this.S.a(cursorC);
        if (charSequenceA != null) {
            setQuery(charSequenceA);
        } else {
            setQuery(text);
        }
    }

    private void e0() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f407q.getText());
        if (!z3 && (!this.Q || this.f395e0)) {
            z2 = false;
        }
        this.f414w.setVisibility(z2 ? 0 : 8);
        Drawable drawable = this.f414w.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f407q;
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
    }

    private void h0() {
        this.f407q.setThreshold(this.f397g0.getSuggestThreshold());
        this.f407q.setImeOptions(this.f397g0.getImeOptions());
        int inputType = this.f397g0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f397g0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f407q.setInputType(inputType);
        h0.a aVar = this.S;
        if (aVar != null) {
            aVar.b(null);
        }
        if (this.f397g0.getSuggestAuthority() != null) {
            q0 q0Var = new q0(getContext(), this, this.f397g0, this.f401k0);
            this.S = q0Var;
            this.f407q.setAdapter(q0Var);
            ((q0) this.S).x(this.V ? 2 : 1);
        }
    }

    private void i0() {
        this.f411t.setVisibility((N() && (this.f413v.getVisibility() == 0 || this.f415x.getVisibility() == 0)) ? 0 : 8);
    }

    private void j0(boolean z2) {
        this.f413v.setVisibility((this.T && N() && hasFocus() && (z2 || !this.f392b0)) ? 0 : 8);
    }

    private void k0(boolean z2) {
        this.R = z2;
        int i3 = z2 ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f407q.getText());
        this.f412u.setVisibility(i3);
        j0(z3);
        this.f409r.setVisibility(z2 ? 8 : 0);
        this.E.setVisibility((this.E.getDrawable() == null || this.Q) ? 8 : 0);
        e0();
        l0(!z3);
        i0();
    }

    private void l0(boolean z2) {
        int i3 = 8;
        if (this.f392b0 && !L() && z2) {
            this.f413v.setVisibility(8);
            i3 = 0;
        }
        this.f415x.setVisibility(i3);
    }

    private void setQuery(CharSequence charSequence) {
        this.f407q.setText(charSequence);
        this.f407q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.f416y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f410s.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = c1.b(this);
            int dimensionPixelSize = this.Q ? resources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left) : 0;
            this.f407q.getDropDownBackground().getPadding(rect);
            this.f407q.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f407q.setDropDownWidth((((this.f416y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f407q.refreshAutoCompleteResults();
            return;
        }
        n nVar = f390r0;
        nVar.b(this.f407q);
        nVar.a(this.f407q);
    }

    public boolean L() {
        return this.R;
    }

    void P(int i3, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i3, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.f407q.getText())) {
            this.f407q.setText(BuildConfig.FLAVOR);
            this.f407q.requestFocus();
            this.f407q.setImeVisibility(true);
        } else if (this.Q) {
            k kVar = this.M;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                k0(true);
            }
        }
    }

    boolean S(int i3, int i4, String str) {
        m mVar = this.O;
        if (mVar != null && mVar.b(i3)) {
            return false;
        }
        Q(i3, 0, null);
        this.f407q.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i3) {
        m mVar = this.O;
        if (mVar != null && mVar.a(i3)) {
            return false;
        }
        c0(i3);
        return true;
    }

    void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.f407q.requestFocus();
        this.f407q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.f407q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        l lVar = this.L;
        if (lVar == null || !lVar.b(text.toString())) {
            if (this.f397g0 != null) {
                P(0, null, text.toString());
            }
            this.f407q.setImeVisibility(false);
            G();
        }
    }

    boolean X(View view, int i3, KeyEvent keyEvent) {
        if (this.f397g0 != null && this.S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i3 == 66 || i3 == 84 || i3 == 61) {
                return S(this.f407q.getListSelection(), 0, null);
            }
            if (i3 == 21 || i3 == 22) {
                this.f407q.setSelection(i3 == 21 ? 0 : this.f407q.length());
                this.f407q.setListSelection(0);
                this.f407q.clearListSelection();
                this.f407q.a();
                return true;
            }
            if (i3 == 19) {
                this.f407q.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.f407q.getText();
        this.f394d0 = text;
        boolean z2 = !TextUtils.isEmpty(text);
        j0(z2);
        l0(!z2);
        e0();
        i0();
        if (this.L != null && !TextUtils.equals(charSequence, this.f393c0)) {
            this.L.a(charSequence.toString());
        }
        this.f393c0 = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.f407q.hasFocus()) {
            H();
        }
    }

    void a0() {
        SearchableInfo searchableInfo = this.f397g0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(F(this.I, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(E(this.J, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // g.c
    public void c() {
        if (this.f395e0) {
            return;
        }
        this.f395e0 = true;
        int imeOptions = this.f407q.getImeOptions();
        this.f396f0 = imeOptions;
        this.f407q.setImeOptions(imeOptions | 33554432);
        this.f407q.setText(BuildConfig.FLAVOR);
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.W = true;
        super.clearFocus();
        this.f407q.clearFocus();
        this.f407q.setImeVisibility(false);
        this.W = false;
    }

    public void d0(CharSequence charSequence, boolean z2) {
        this.f407q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f407q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f394d0 = charSequence;
        }
        if (!z2 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    @Override // g.c
    public void f() {
        d0(BuildConfig.FLAVOR, false);
        clearFocus();
        k0(true);
        this.f407q.setImeOptions(this.f396f0);
        this.f395e0 = false;
    }

    void f0() {
        int[] iArr = this.f407q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f410s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f411t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f407q.getImeOptions();
    }

    public int getInputType() {
        return this.f407q.getInputType();
    }

    public int getMaxWidth() {
        return this.f391a0;
    }

    public CharSequence getQuery() {
        return this.f407q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f397g0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.f397g0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.H;
    }

    int getSuggestionRowLayout() {
        return this.G;
    }

    public h0.a getSuggestionsAdapter() {
        return this.S;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f399i0);
        post(this.f400j0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        if (z2) {
            I(this.f407q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i6 - i4);
            p pVar = this.f417z;
            if (pVar != null) {
                pVar.a(this.B, this.A);
                return;
            }
            p pVar2 = new p(this.B, this.A, this.f407q);
            this.f417z = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        if (L()) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            int i6 = this.f391a0;
            size = i6 > 0 ? Math.min(i6, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f391a0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i5 = this.f391a0) > 0) {
            size = Math.min(i5, size);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.j());
        k0(oVar.f436d);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f436d = L();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i3, Rect rect) {
        if (this.W || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i3, rect);
        }
        boolean zRequestFocus = this.f407q.requestFocus(i3, rect);
        if (zRequestFocus) {
            k0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f398h0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.Q == z2) {
            return;
        }
        this.Q = z2;
        k0(z2);
        g0();
    }

    public void setImeOptions(int i3) {
        this.f407q.setImeOptions(i3);
    }

    public void setInputType(int i3) {
        this.f407q.setInputType(i3);
    }

    public void setMaxWidth(int i3) {
        this.f391a0 = i3;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.M = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.L = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.O = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.U = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.V = z2;
        h0.a aVar = this.S;
        if (aVar instanceof q0) {
            ((q0) aVar).x(z2 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f397g0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean zK = K();
        this.f392b0 = zK;
        if (zK) {
            this.f407q.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.T = z2;
        k0(L());
    }

    public void setSuggestionsAdapter(h0.a aVar) {
        this.S = aVar;
        this.f407q.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.f399i0 = new b();
        this.f400j0 = new c();
        this.f401k0 = new WeakHashMap<>();
        f fVar = new f();
        this.f402l0 = fVar;
        this.f403m0 = new g();
        h hVar = new h();
        this.f404n0 = hVar;
        i iVar = new i();
        this.f405o0 = iVar;
        j jVar = new j();
        this.f406p0 = jVar;
        this.f408q0 = new a();
        w0 w0VarV = w0.v(context, attributeSet, a.j.SearchView, i3, 0);
        LayoutInflater.from(context).inflate(w0VarV.n(a.j.SearchView_layout, a.g.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(a.f.search_src_text);
        this.f407q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f409r = findViewById(a.f.search_edit_frame);
        View viewFindViewById = findViewById(a.f.search_plate);
        this.f410s = viewFindViewById;
        View viewFindViewById2 = findViewById(a.f.submit_area);
        this.f411t = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(a.f.search_button);
        this.f412u = imageView;
        ImageView imageView2 = (ImageView) findViewById(a.f.search_go_btn);
        this.f413v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(a.f.search_close_btn);
        this.f414w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(a.f.search_voice_btn);
        this.f415x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(a.f.search_mag_icon);
        this.E = imageView5;
        e0.t.p0(viewFindViewById, w0VarV.g(a.j.SearchView_queryBackground));
        e0.t.p0(viewFindViewById2, w0VarV.g(a.j.SearchView_submitBackground));
        int i4 = a.j.SearchView_searchIcon;
        imageView.setImageDrawable(w0VarV.g(i4));
        imageView2.setImageDrawable(w0VarV.g(a.j.SearchView_goIcon));
        imageView3.setImageDrawable(w0VarV.g(a.j.SearchView_closeIcon));
        imageView4.setImageDrawable(w0VarV.g(a.j.SearchView_voiceIcon));
        imageView5.setImageDrawable(w0VarV.g(i4));
        this.F = w0VarV.g(a.j.SearchView_searchHintIcon);
        y0.a(imageView, getResources().getString(a.h.abc_searchview_description_search));
        this.G = w0VarV.n(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
        this.H = w0VarV.n(a.j.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f408q0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f403m0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(w0VarV.a(a.j.SearchView_iconifiedByDefault, true));
        int iF = w0VarV.f(a.j.SearchView_android_maxWidth, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.K = w0VarV.p(a.j.SearchView_defaultQueryHint);
        this.U = w0VarV.p(a.j.SearchView_queryHint);
        int iK = w0VarV.k(a.j.SearchView_android_imeOptions, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = w0VarV.k(a.j.SearchView_android_inputType, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(w0VarV.a(a.j.SearchView_android_focusable, true));
        w0VarV.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f416y = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.Q);
        g0();
    }
}
