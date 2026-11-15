package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: AppCompatAutoCompleteTextView.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends AutoCompleteTextView implements e0.s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f568d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f570c;

    public d(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f569b;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f570c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // e0.s
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f569b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // e0.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f569b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f569b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        e eVar = this.f569b;
        if (eVar != null) {
            eVar.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i3) {
        setDropDownBackgroundDrawable(c.a.d(getContext(), i3));
    }

    @Override // e0.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f569b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f569b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        y yVar = this.f570c;
        if (yVar != null) {
            yVar.q(context, i3);
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.autoCompleteTextViewStyle);
    }

    public d(Context context, AttributeSet attributeSet, int i3) {
        super(t0.b(context), attributeSet, i3);
        r0.a(this, getContext());
        w0 w0VarV = w0.v(getContext(), attributeSet, f568d, i3, 0);
        if (w0VarV.s(0)) {
            setDropDownBackgroundDrawable(w0VarV.g(0));
        }
        w0VarV.w();
        e eVar = new e(this);
        this.f569b = eVar;
        eVar.e(attributeSet, i3);
        y yVar = new y(this);
        this.f570c = yVar;
        yVar.m(attributeSet, i3);
        yVar.b();
    }
}
