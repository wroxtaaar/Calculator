package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.material.internal.m;
import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class TextInputEditText extends androidx.appcompat.widget.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f3218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3219f;

    public TextInputEditText(Context context) {
        this(context, null);
    }

    private String a(TextInputLayout textInputLayout) {
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z2 = !TextUtils.isEmpty(text);
        boolean z3 = !TextUtils.isEmpty(hint);
        String str = BuildConfig.FLAVOR;
        String string = z3 ? hint.toString() : BuildConfig.FLAVOR;
        if (!z2) {
            return !TextUtils.isEmpty(string) ? string : BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) text);
        if (!TextUtils.isEmpty(string)) {
            str = ", " + string;
        }
        sb.append(str);
        return sb.toString();
    }

    private boolean b(TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f3219f;
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!b(textInputLayout) || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f3218e);
        rect.bottom = this.f3218e.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        return b(textInputLayout) ? textInputLayout.getGlobalVisibleRect(rect, point) : super.getGlobalVisibleRect(rect, point);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.O()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.O() && super.getHint() == null && com.google.android.material.internal.g.a()) {
            setHint(BuildConfig.FLAVOR);
        }
    }

    @Override // androidx.appcompat.widget.k, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        accessibilityNodeInfo.setText(a(textInputLayout));
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!b(textInputLayout) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        this.f3218e.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.f3218e);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z2) {
        this.f3219f = z2;
    }

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.editTextStyle);
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i3) {
        super(m1.a.c(context, attributeSet, i3, 0), attributeSet, i3);
        this.f3218e = new Rect();
        TypedArray typedArrayH = m.h(context, attributeSet, t0.k.TextInputEditText, i3, t0.j.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayH.getBoolean(t0.k.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayH.recycle();
    }
}
