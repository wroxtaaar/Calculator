package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.j0;
import com.google.android.material.internal.m;
import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.appcompat.widget.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j0 f3362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AccessibilityManager f3363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f3364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f3365h;

    /* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            h hVar = h.this;
            h.this.e(i3 < 0 ? hVar.f3362e.v() : hVar.getAdapter().getItem(i3));
            AdapterView.OnItemClickListener onItemClickListener = h.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i3 < 0) {
                    view = h.this.f3362e.y();
                    i3 = h.this.f3362e.x();
                    j3 = h.this.f3362e.w();
                }
                onItemClickListener.onItemClick(h.this.f3362e.l(), view, i3, j3);
            }
            h.this.f3362e.dismiss();
        }
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.autoCompleteTextViewStyle);
    }

    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutC = c();
        int i3 = 0;
        if (adapter == null || textInputLayoutC == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f3362e.x()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutC);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableJ = this.f3362e.j();
        if (drawableJ != null) {
            drawableJ.getPadding(this.f3364g);
            Rect rect = this.f3364g;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutC.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void e(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutC = c();
        return (textInputLayoutC == null || !textInputLayoutC.O()) ? super.getHint() : textInputLayoutC.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutC = c();
        if (textInputLayoutC != null && textInputLayoutC.O() && super.getHint() == null && com.google.android.material.internal.g.a()) {
            setHint(BuildConfig.FLAVOR);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t3) {
        super.setAdapter(t3);
        this.f3362e.o(getAdapter());
    }

    public void setSimpleItems(int i3) {
        setSimpleItems(getResources().getStringArray(i3));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f3363f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f3362e.a();
        }
    }

    public h(Context context, AttributeSet attributeSet, int i3) {
        super(m1.a.c(context, attributeSet, i3, 0), attributeSet, i3);
        this.f3364g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayH = m.h(context2, attributeSet, t0.k.MaterialAutoCompleteTextView, i3, t0.j.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i4 = t0.k.MaterialAutoCompleteTextView_android_inputType;
        if (typedArrayH.hasValue(i4) && typedArrayH.getInt(i4, 0) == 0) {
            setKeyListener(null);
        }
        this.f3365h = typedArrayH.getResourceId(t0.k.MaterialAutoCompleteTextView_simpleItemLayout, t0.h.mtrl_auto_complete_simple_item);
        this.f3363f = (AccessibilityManager) context2.getSystemService("accessibility");
        j0 j0Var = new j0(context2);
        this.f3362e = j0Var;
        j0Var.J(true);
        j0Var.D(this);
        j0Var.I(2);
        j0Var.o(getAdapter());
        j0Var.L(new a());
        int i5 = t0.k.MaterialAutoCompleteTextView_simpleItems;
        if (typedArrayH.hasValue(i5)) {
            setSimpleItems(typedArrayH.getResourceId(i5, 0));
        }
        typedArrayH.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.f3365h, strArr));
    }
}
