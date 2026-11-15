package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.l;
import com.google.android.material.internal.o;
import com.google.android.material.textfield.TextInputLayout;
import t0.f;
import t0.h;

/* JADX INFO: loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Chip f3384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextInputLayout f3385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EditText f3386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextWatcher f3387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f3388f;

    private class b extends l {
        private b() {
        }

        @Override // com.google.android.material.internal.l, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f3384b.setText(ChipTextInputComboView.this.c("00"));
            } else {
                ChipTextInputComboView.this.f3384b.setText(ChipTextInputComboView.this.c(editable));
            }
        }
    }

    public ChipTextInputComboView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return c.j(getResources(), charSequence);
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f3386d.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f3384b.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        this.f3384b.setChecked(z2);
        this.f3386d.setVisibility(z2 ? 0 : 4);
        this.f3384b.setVisibility(z2 ? 8 : 0);
        if (isChecked()) {
            o.h(this.f3386d);
            if (TextUtils.isEmpty(this.f3386d.getText())) {
                return;
            }
            EditText editText = this.f3386d;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3384b.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        this.f3384b.setTag(i3, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f3384b.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(h.material_time_chip, (ViewGroup) this, false);
        this.f3384b = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(h.material_time_input, (ViewGroup) this, false);
        this.f3385c = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f3386d = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f3387e = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f3388f = (TextView) findViewById(f.material_label);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
