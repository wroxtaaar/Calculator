package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.y0;
import com.vivo.seckeysdk.SecurityKeyCipher;
import e0.t;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends f implements androidx.appcompat.view.menu.k.a {
    private static final int[] G = {R.attr.state_checked};
    private FrameLayout A;
    private androidx.appcompat.view.menu.g B;
    private ColorStateList C;
    private boolean D;
    private Drawable E;
    private final e0.a F;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3045w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f3046x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f3047y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final CheckedTextView f3048z;

    class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            super.g(view, dVar);
            dVar.V(NavigationMenuItemView.this.f3047y);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void B() {
        if (D()) {
            this.f3048z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                i0.a aVar = (i0.a) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) aVar).width = -1;
                this.A.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f3048z.setVisibility(0);
        FrameLayout frameLayout2 = this.A;
        if (frameLayout2 != null) {
            i0.a aVar2 = (i0.a) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) aVar2).width = -2;
            this.A.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(a.a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(t0.f.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(androidx.appcompat.view.menu.g gVar, int i3) {
        this.B = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            t.p0(this, C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        y0.a(this, gVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public androidx.appcompat.view.menu.g getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        androidx.appcompat.view.menu.g gVar = this.B;
        if (gVar != null && gVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(iArrOnCreateDrawableState, G);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.f3047y != z2) {
            this.f3047y = z2;
            this.F.l(this.f3048z, SecurityKeyCipher.SECURITY_DATA_SIZE_MAX);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.f3048z.setChecked(z2);
    }

    public void setHorizontalPadding(int i3) {
        setPadding(i3, getPaddingTop(), i3, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = x.a.r(drawable).mutate();
                x.a.o(drawable, this.C);
            }
            int i3 = this.f3045w;
            drawable.setBounds(0, 0, i3, i3);
        } else if (this.f3046x) {
            if (this.E == null) {
                Drawable drawableB = v.f.b(getResources(), t0.e.navigation_empty_icon, getContext().getTheme());
                this.E = drawableB;
                if (drawableB != null) {
                    int i4 = this.f3045w;
                    drawableB.setBounds(0, 0, i4, i4);
                }
            }
            drawable = this.E;
        }
        androidx.core.widget.i.i(this.f3048z, drawable, null, null, null);
    }

    public void setIconPadding(int i3) {
        this.f3048z.setCompoundDrawablePadding(i3);
    }

    public void setIconSize(int i3) {
        this.f3045w = i3;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        androidx.appcompat.view.menu.g gVar = this.B;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i3) {
        this.f3048z.setMaxLines(i3);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.f3046x = z2;
    }

    public void setTextAppearance(int i3) {
        androidx.core.widget.i.n(this.f3048z, i3);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f3048z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f3048z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a aVar = new a();
        this.F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(t0.h.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(t0.d.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(t0.f.design_menu_item_text);
        this.f3048z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        t.m0(checkedTextView, aVar);
    }
}
