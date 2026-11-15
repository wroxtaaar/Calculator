package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: compiled from: AppCompatButton.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends Button implements e0.s, androidx.core.widget.b, androidx.core.widget.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f582c;

    public f(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f581b;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f582c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f1209a) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f582c;
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
        y yVar = this.f582c;
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
        y yVar = this.f582c;
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
        y yVar = this.f582c;
        return yVar != null ? yVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f1209a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f582c;
        if (yVar != null) {
            return yVar.i();
        }
        return 0;
    }

    @Override // e0.s
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f581b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // e0.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f581b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f582c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f582c.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        y yVar = this.f582c;
        if (yVar != null) {
            yVar.o(z2, i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        y yVar = this.f582c;
        if (yVar == null || androidx.core.widget.b.f1209a || !yVar.l()) {
            return;
        }
        this.f582c.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) throws IllegalArgumentException {
        if (androidx.core.widget.b.f1209a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
            return;
        }
        y yVar = this.f582c;
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
        y yVar = this.f582c;
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
        y yVar = this.f582c;
        if (yVar != null) {
            yVar.u(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f581b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        e eVar = this.f581b;
        if (eVar != null) {
            eVar.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setSupportAllCaps(boolean z2) {
        y yVar = this.f582c;
        if (yVar != null) {
            yVar.r(z2);
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f581b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f581b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f582c.v(colorStateList);
        this.f582c.b();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f582c.w(mode);
        this.f582c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        y yVar = this.f582c;
        if (yVar != null) {
            yVar.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        if (androidx.core.widget.b.f1209a) {
            super.setTextSize(i3, f3);
            return;
        }
        y yVar = this.f582c;
        if (yVar != null) {
            yVar.z(i3, f3);
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.buttonStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i3) {
        super(t0.b(context), attributeSet, i3);
        r0.a(this, getContext());
        e eVar = new e(this);
        this.f581b = eVar;
        eVar.e(attributeSet, i3);
        y yVar = new y(this);
        this.f582c = yVar;
        yVar.m(attributeSet, i3);
        yVar.b();
    }
}
