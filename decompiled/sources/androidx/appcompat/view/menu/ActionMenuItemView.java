package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.y0;
import androidx.appcompat.widget.z;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends z implements k.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    g f121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CharSequence f122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    e.b f124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h0 f125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    b f126k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f127l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f128m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f129n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f130o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f131p;

    private class a extends h0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.h0
        public h.e b() {
            b bVar = ActionMenuItemView.this.f126k;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.h0
        protected boolean c() {
            h.e eVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f124i;
            return bVar != null && bVar.a(actionMenuItemView.f121f) && (eVarB = b()) != null && eVarB.c();
        }
    }

    public static abstract class b {
        public abstract h.e a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        return i3 >= 480 || (i3 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f122g);
        if (this.f123h != null && (!this.f121f.B() || (!this.f127l && !this.f128m))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        setText(z4 ? this.f122g : null);
        CharSequence contentDescription = this.f121f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z4 ? null : this.f121f.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f121f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            y0.a(this, z4 ? null : this.f121f.getTitle());
        } else {
            y0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f121f.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i3) {
        this.f121f = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f125j == null) {
            this.f125j = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f121f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f124i;
        if (bVar != null) {
            bVar.a(this.f121f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f127l = g();
        h();
    }

    @Override // androidx.appcompat.widget.z, android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        boolean zF = f();
        if (zF && (i5 = this.f130o) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f129n) : this.f129n;
        if (mode != 1073741824 && this.f129n > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i4);
        }
        if (zF || this.f123h == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f123h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var;
        if (this.f121f.hasSubMenu() && (h0Var = this.f125j) != null && h0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f128m != z2) {
            this.f128m = z2;
            g gVar = this.f121f;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f123h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i3 = this.f131p;
            if (intrinsicWidth > i3) {
                intrinsicHeight = (int) (intrinsicHeight * (i3 / intrinsicWidth));
                intrinsicWidth = i3;
            }
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (intrinsicWidth * (i3 / intrinsicHeight));
            } else {
                i3 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i3);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(e.b bVar) {
        this.f124i = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
        this.f130o = i3;
        super.setPadding(i3, i4, i5, i6);
    }

    public void setPopupCallback(b bVar) {
        this.f126k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f122g = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Resources resources = context.getResources();
        this.f127l = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionMenuItemView, i3, 0);
        this.f129n = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f131p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f130o = -1;
        setSaveEnabled(false);
    }
}
