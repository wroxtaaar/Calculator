package com.vivo.calculator.exchangelist;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import b2.c;
import com.vivo.calculator.R;
import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class CurrencySearchView extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageButton f4135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EditText f4136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageButton f4137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f4138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f4139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextWatcher f4140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView.OnEditorActionListener f4141h;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (CurrencySearchView.this.f4138e != null) {
                CurrencySearchView.this.f4138e.a(editable.toString());
            }
            if (editable.toString().length() > 0) {
                CurrencySearchView.this.f4137d.setVisibility(0);
                CurrencySearchView.this.f4137d.setImageResource(R.drawable.btn_icon_clear_selector);
            } else {
                CurrencySearchView.this.f4137d.setVisibility(8);
                CurrencySearchView.this.f4137d.setImageResource(R.drawable.btn_icon_search_selector);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            CurrencySearchView.this.g();
        }
    }

    class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (i3 != 3) {
                return false;
            }
            CurrencySearchView.this.e();
            return true;
        }
    }

    public CurrencySearchView(Context context) {
        super(context);
        this.f4140g = new a();
        this.f4141h = new b();
    }

    private void f(Context context) {
        this.f4139f = context.getApplicationContext();
        LayoutInflater.from(context).inflate(R.layout.search_view, this);
        this.f4135b = (ImageButton) findViewById(R.id.search_back);
        this.f4137d = (ImageButton) findViewById(R.id.search_or_clear);
        EditText editText = (EditText) findViewById(R.id.search_edit);
        this.f4136c = editText;
        editText.addTextChangedListener(this.f4140g);
        this.f4136c.setSingleLine();
        this.f4136c.setTextDirection(2);
        this.f4136c.setTextAlignment(5);
        this.f4136c.setImeOptions(3);
        this.f4136c.setOnEditorActionListener(this.f4141h);
        this.f4137d.setOnClickListener(this);
        this.f4135b.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Editable text = this.f4136c.getText();
        if (text.toString().trim().length() > 200) {
            int selectionEnd = Selection.getSelectionEnd(text);
            this.f4136c.setText(text.toString().substring(0, 200));
            Editable text2 = this.f4136c.getText();
            if (selectionEnd > text2.length()) {
                selectionEnd = text2.length();
            }
            Selection.setSelection(text2, selectionEnd);
        }
    }

    public void d() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f4139f.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f4136c.getWindowToken(), 0);
        }
        this.f4136c.setText(BuildConfig.FLAVOR);
        this.f4136c.setFocusableInTouchMode(false);
    }

    public void e() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f4139f.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f4136c.getWindowToken(), 0);
        }
        this.f4136c.setFocusableInTouchMode(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void h() {
        this.f4136c.setFocusableInTouchMode(true);
        this.f4136c.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f4139f.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f4136c, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.search_back) {
            if (id != R.id.search_or_clear) {
                return;
            }
            this.f4136c.setText(BuildConfig.FLAVOR);
        } else {
            c cVar = this.f4138e;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public void setSearchListener(c cVar) {
        this.f4138e = cVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public CurrencySearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4140g = new a();
        this.f4141h = new b();
        f(context);
    }

    public CurrencySearchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4140g = new a();
        this.f4141h = new b();
    }
}
