package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: compiled from: AppCompatCheckedTextView.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends CheckedTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f602c = {R.attr.checkMark};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f603b;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f603b;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i3) {
        setCheckMarkDrawable(c.a.d(getContext(), i3));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        y yVar = this.f603b;
        if (yVar != null) {
            yVar.q(context, i3);
        }
    }

    public h(Context context, AttributeSet attributeSet, int i3) {
        super(t0.b(context), attributeSet, i3);
        r0.a(this, getContext());
        y yVar = new y(this);
        this.f603b = yVar;
        yVar.m(attributeSet, i3);
        yVar.b();
        w0 w0VarV = w0.v(getContext(), attributeSet, f602c, i3, 0);
        setCheckMarkDrawable(w0VarV.g(0));
        w0VarV.w();
    }
}
