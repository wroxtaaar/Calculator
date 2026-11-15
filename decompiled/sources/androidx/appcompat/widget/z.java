package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: AppCompatTextView.java */
/* JADX INFO: loaded from: classes.dex */
public class z extends TextView implements e0.s, androidx.core.widget.k, androidx.core.widget.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x f860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Future<c0.c> f861e;

    public z(Context context) {
        this(context, null);
    }

    private void c() {
        Future<c0.c> future = this.f861e;
        if (future != null) {
            try {
                this.f861e = null;
                androidx.core.widget.i.m(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f858b;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f1209a) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f859c;
        if (yVar != null) {
            return yVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.f1209a) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f859c;
        if (yVar != null) {
            return yVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.f1209a) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f859c;
        if (yVar != null) {
            return yVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.f1209a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f859c;
        return yVar != null ? yVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f1209a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f859c;
        if (yVar != null) {
            return yVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.c(this);
    }

    @Override // e0.s
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f858b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // e0.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f858b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f859c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f859c.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        c();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        x xVar;
        return (Build.VERSION.SDK_INT >= 28 || (xVar = this.f860d) == null) ? super.getTextClassifier() : xVar.a();
    }

    public c0.c.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.o(z2, i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        c();
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        y yVar = this.f859c;
        if (yVar == null || androidx.core.widget.b.f1209a || !yVar.l()) {
            return;
        }
        this.f859c.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) throws IllegalArgumentException {
        if (androidx.core.widget.b.f1209a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
            return;
        }
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.s(i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) throws IllegalArgumentException {
        if (androidx.core.widget.b.f1209a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
            return;
        }
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.t(iArr, i3);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (androidx.core.widget.b.f1209a) {
            super.setAutoSizeTextTypeWithDefaults(i3);
            return;
        }
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.u(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f858b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        e eVar = this.f858b;
        if (eVar != null) {
            eVar.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i3);
        } else {
            androidx.core.widget.i.j(this, i3);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i3);
        } else {
            androidx.core.widget.i.k(this, i3);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i3) {
        androidx.core.widget.i.l(this, i3);
    }

    public void setPrecomputedText(c0.c cVar) {
        androidx.core.widget.i.m(this, cVar);
    }

    @Override // e0.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f858b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f858b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f859c.v(colorStateList);
        this.f859c.b();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f859c.w(mode);
        this.f859c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.f860d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            xVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<c0.c> future) {
        this.f861e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c0.c.a aVar) {
        androidx.core.widget.i.o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        if (androidx.core.widget.b.f1209a) {
            super.setTextSize(i3, f3);
            return;
        }
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.z(i3, f3);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i3) {
        Typeface typefaceA = (typeface == null || i3 <= 0) ? null : w.d.a(getContext(), typeface, i3);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        super.setTypeface(typeface, i3);
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public z(Context context, AttributeSet attributeSet, int i3) {
        super(t0.b(context), attributeSet, i3);
        r0.a(this, getContext());
        e eVar = new e(this);
        this.f858b = eVar;
        eVar.e(attributeSet, i3);
        y yVar = new y(this);
        this.f859c = yVar;
        yVar.m(attributeSet, i3);
        yVar.b();
        this.f860d = new x(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i3 != 0 ? c.a.d(context, i3) : null, i4 != 0 ? c.a.d(context, i4) : null, i5 != 0 ? c.a.d(context, i5) : null, i6 != 0 ? c.a.d(context, i6) : null);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i3 != 0 ? c.a.d(context, i3) : null, i4 != 0 ? c.a.d(context, i4) : null, i5 != 0 ? c.a.d(context, i5) : null, i6 != 0 ? c.a.d(context, i6) : null);
        y yVar = this.f859c;
        if (yVar != null) {
            yVar.p();
        }
    }
}
