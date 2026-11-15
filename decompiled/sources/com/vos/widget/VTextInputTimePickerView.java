package com.vos.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.TtsSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Locale;
import y1.e;
import y1.f;

/* JADX INFO: loaded from: classes.dex */
public class VTextInputTimePickerView extends RelativeLayout {
    private final View.OnClickListener A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EditText f4414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EditText f4415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextView f4416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f4417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f4418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f4419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f4422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f4425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RadioButton f4426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RadioButton f4427o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f4428p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f4429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Locale f4430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f4431s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4432t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4433u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4434v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4435w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4436x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f4437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f4438z;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (VTextInputTimePickerView.this.s(editable.toString())) {
                editable.length();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            int i6 = !VTextInputTimePickerView.this.f4421i ? 1 : 0;
            int i7 = VTextInputTimePickerView.this.f4420h ? 23 : i6 + 11;
            String strValueOf = String.valueOf(charSequence);
            if (TextUtils.isEmpty(strValueOf)) {
                return;
            }
            int i8 = Integer.parseInt(strValueOf);
            boolean z2 = i8 > i7 || i8 < i6;
            VTextInputTimePickerView.this.f4437y = z2;
            VTextInputTimePickerView.this.setError(VTextInputTimePickerView.this.f4438z ? true : z2);
        }
    }

    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            VTextInputTimePickerView.this.t(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            String strValueOf = String.valueOf(charSequence);
            if (TextUtils.isEmpty(strValueOf)) {
                return;
            }
            int i6 = Integer.parseInt(strValueOf);
            boolean z2 = i6 > 59 || i6 < 0;
            VTextInputTimePickerView.this.f4438z = z2;
            VTextInputTimePickerView.this.setError(VTextInputTimePickerView.this.f4437y ? true : z2);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == e.am_input_label) {
                VTextInputTimePickerView.this.f4431s = true;
                VTextInputTimePickerView.this.f4432t = false;
                VTextInputTimePickerView.this.setAmOrPm(0);
                VTextInputTimePickerView.this.f4422j.a(2, 0);
                return;
            }
            if (id == e.pm_input_label) {
                VTextInputTimePickerView.this.f4431s = false;
                VTextInputTimePickerView.this.f4432t = true;
                VTextInputTimePickerView.this.setAmOrPm(1);
                VTextInputTimePickerView.this.f4422j.a(2, 1);
            }
        }
    }

    interface d {
        void a(int i3, int i4);
    }

    public VTextInputTimePickerView(Context context) {
        this(context, null);
    }

    private int n(int i3) {
        return (int) ((i3 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    private void o(TextView textView) {
        textView.measure(0, 0);
        int measuredWidth = textView.getMeasuredWidth();
        textView.setMinWidth(measuredWidth);
        textView.setMinimumWidth(measuredWidth);
    }

    private int p(int i3) {
        if (this.f4420h) {
            if (this.f4421i || i3 != 24) {
                return i3;
            }
            return 0;
        }
        if (!this.f4421i && i3 == 12) {
            i3 = 0;
        }
        return this.f4432t ? i3 + 12 : i3;
    }

    private boolean q(int i3) {
        int i4 = !this.f4421i ? 1 : 0;
        return i3 >= i4 && i3 <= (this.f4420h ? 23 : 11) + i4;
    }

    private CharSequence r(String str) {
        return new SpannableStringBuilder().append(str, new TtsSpan.VerbatimBuilder(str).build(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(String str) {
        try {
            int i3 = Integer.parseInt(str);
            if (q(i3)) {
                this.f4422j.a(0, p(i3));
                setTimeSet(true);
                return true;
            }
            int i4 = this.f4421i ? 0 : 1;
            this.f4422j.a(0, p(x2.b.a(i3, i4, this.f4420h ? 23 : i4 + 11)));
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmOrPm(int i3) {
        u(i3);
    }

    private void setAmPmStart(boolean z2) {
        int rule;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4425m.getLayoutParams();
        if (layoutParams.getRule(1) != 0 || layoutParams.getRule(0) != 0) {
            int i3 = (int) (getContext().getResources().getDisplayMetrics().density * 8.0f);
            if (TextUtils.getLayoutDirectionFromLocale(this.f4430r) == 0 ? z2 : !z2) {
                layoutParams.removeRule(1);
                layoutParams.addRule(0, this.f4414b.getId());
            } else {
                layoutParams.removeRule(0);
                layoutParams.addRule(1, this.f4415c.getId());
            }
            if (z2) {
                layoutParams.setMarginStart(0);
                layoutParams.setMarginEnd(i3);
            } else {
                layoutParams.setMarginStart(i3);
                layoutParams.setMarginEnd(0);
            }
        } else if (layoutParams.getRule(3) != 0 || layoutParams.getRule(2) != 0) {
            if (this.f4429q == z2) {
                return;
            }
            if (z2) {
                rule = layoutParams.getRule(3);
                layoutParams.removeRule(3);
                layoutParams.addRule(2, rule);
            } else {
                rule = layoutParams.getRule(2);
                layoutParams.removeRule(2);
                layoutParams.addRule(3, rule);
            }
            View viewFindViewById = this.f4425m.findViewById(rule);
            viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingBottom(), viewFindViewById.getPaddingRight(), viewFindViewById.getPaddingTop());
            this.f4429q = z2;
        }
        this.f4425m.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(boolean z2) {
        this.f4423k = z2;
        this.f4417e.setVisibility(z2 ? 0 : 8);
        this.f4418f.setVisibility(z2 ? 4 : 0);
        this.f4419g.setVisibility(z2 ? 4 : 0);
    }

    private void setTimeSet(boolean z2) {
        this.f4424l = this.f4424l || z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(String str) {
        try {
            int i3 = Integer.parseInt(str);
            if (i3 >= 0 && i3 <= 59) {
                this.f4422j.a(1, i3);
                setTimeSet(true);
                return true;
            }
            this.f4422j.a(1, x2.b.a(i3, 0, 59));
        } catch (NumberFormatException unused) {
        }
        return false;
    }

    private void u(int i3) {
        boolean z2 = i3 == 0;
        this.f4426n.setActivated(z2);
        this.f4426n.setChecked(z2);
        boolean z3 = i3 == 1;
        this.f4427o.setActivated(z3);
        this.f4427o.setChecked(z3);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    protected TextView getTopLabel() {
        return this.f4428p;
    }

    void setHourFormat(int i3) {
        this.f4414b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        this.f4415c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        LocaleList locales = getContext().getResources().getConfiguration().getLocales();
        this.f4414b.setImeHintLocales(locales);
        this.f4415c.setImeHintLocales(locales);
    }

    void setListener(d dVar) {
        this.f4422j = dVar;
    }

    public VTextInputTimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VTextInputTimePickerView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public VTextInputTimePickerView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f4429q = false;
        this.f4433u = 11;
        this.f4434v = 11;
        this.f4435w = 4;
        this.f4436x = 4;
        c cVar = new c();
        this.A = cVar;
        RelativeLayout.inflate(context, f.time_picker_text_input_vigour, this);
        this.f4430r = context.getResources().getConfiguration().locale;
        int iN = n(this.f4433u);
        int iN2 = n(this.f4434v);
        int iN3 = n(this.f4435w);
        int iN4 = n(this.f4436x);
        EditText editText = (EditText) findViewById(e.input_hour);
        this.f4414b = editText;
        EditText editText2 = (EditText) findViewById(e.input_minute);
        this.f4415c = editText2;
        editText.setPaddingRelative(iN3, iN, iN4, iN2);
        editText2.setPaddingRelative(iN3, iN, iN4, iN2);
        this.f4416d = (TextView) findViewById(e.input_separator);
        TextView textView = (TextView) findViewById(e.label_error);
        this.f4417e = textView;
        textView.setText(context.getResources().getString(context.getResources().getIdentifier("time_picker_input_error", "string", "android")));
        TextView textView2 = (TextView) findViewById(e.label_hour);
        this.f4418f = textView2;
        textView2.setText(context.getResources().getString(context.getResources().getIdentifier("time_picker_hour_label", "string", "android")));
        TextView textView3 = (TextView) findViewById(e.label_minute);
        this.f4419g = textView3;
        textView3.setText(context.getResources().getString(context.getResources().getIdentifier("time_picker_minute_label", "string", "android")));
        editText.addTextChangedListener(new a());
        editText2.addTextChangedListener(new b());
        this.f4425m = findViewById(e.ampm_input_layout);
        String[] strArrA = com.vos.widget.a.a(context);
        RadioButton radioButton = (RadioButton) this.f4425m.findViewById(e.am_input_label);
        this.f4426n = radioButton;
        radioButton.setText(r(strArrA[0]));
        this.f4426n.setOnClickListener(cVar);
        o(this.f4426n);
        RadioButton radioButton2 = (RadioButton) this.f4425m.findViewById(e.pm_input_label);
        this.f4427o = radioButton2;
        radioButton2.setText(r(strArrA[1]));
        this.f4427o.setOnClickListener(cVar);
        o(this.f4427o);
    }
}
