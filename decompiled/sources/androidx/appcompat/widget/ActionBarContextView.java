package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f320l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f321m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LinearLayout f322n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f323o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f324p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f325q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f326r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f327s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f328t;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g.b f329b;

        a(g.b bVar) {
            this.f329b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f329b.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f322n == null) {
            LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f322n = linearLayout;
            this.f323o = (TextView) linearLayout.findViewById(a.f.action_bar_title);
            this.f324p = (TextView) this.f322n.findViewById(a.f.action_bar_subtitle);
            if (this.f325q != 0) {
                this.f323o.setTextAppearance(getContext(), this.f325q);
            }
            if (this.f326r != 0) {
                this.f324p.setTextAppearance(getContext(), this.f326r);
            }
        }
        this.f323o.setText(this.f318j);
        this.f324p.setText(this.f319k);
        boolean z2 = !TextUtils.isEmpty(this.f318j);
        boolean z3 = !TextUtils.isEmpty(this.f319k);
        int i3 = 0;
        this.f324p.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout2 = this.f322n;
        if (!z2 && !z3) {
            i3 = 8;
        }
        linearLayout2.setVisibility(i3);
        if (this.f322n.getParent() == null) {
            addView(this.f322n);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ e0.x f(int i3, long j3) {
        return super.f(i3, j3);
    }

    public void g() {
        if (this.f320l == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f319k;
    }

    public CharSequence getTitle() {
        return this.f318j;
    }

    public void h(g.b bVar) {
        View view = this.f320l;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f328t, (ViewGroup) this, false);
            this.f320l = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f320l);
        }
        this.f320l.findViewById(a.f.action_mode_close_button).setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) bVar.e();
        c cVar = this.f510e;
        if (cVar != null) {
            cVar.y();
        }
        c cVar2 = new c(getContext());
        this.f510e = cVar2;
        cVar2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f510e, this.f508c);
        ActionMenuView actionMenuView = (ActionMenuView) this.f510e.o(this);
        this.f509d = actionMenuView;
        e0.t.p0(actionMenuView, null);
        addView(this.f509d, layoutParams);
    }

    public boolean j() {
        return this.f327s;
    }

    public void k() {
        removeAllViews();
        this.f321m = null;
        this.f509d = null;
    }

    public boolean l() {
        c cVar = this.f510e;
        if (cVar != null) {
            return cVar.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f510e;
        if (cVar != null) {
            cVar.B();
            this.f510e.C();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f318j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        boolean zB = c1.b(this);
        int paddingRight = zB ? (i5 - i3) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
        View view = this.f320l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f320l.getLayoutParams();
            int i7 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = androidx.appcompat.widget.a.d(paddingRight, i7, zB);
            paddingRight = androidx.appcompat.widget.a.d(iD + e(this.f320l, iD, paddingTop, paddingTop2, zB), i8, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f322n;
        if (linearLayout != null && this.f321m == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f322n, iE, paddingTop, paddingTop2, zB);
        }
        int i9 = iE;
        View view2 = this.f321m;
        if (view2 != null) {
            e(view2, i9, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i5 - i3) - getPaddingRight();
        ActionMenuView actionMenuView = this.f509d;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i4) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = this.f511f;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i4);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f320l;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f320l.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f509d;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f509d, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f322n;
        if (linearLayout != null && this.f321m == null) {
            if (this.f327s) {
                this.f322n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f322n.getMeasuredWidth();
                boolean z2 = measuredWidth <= paddingLeft;
                if (z2) {
                    paddingLeft -= measuredWidth;
                }
                this.f322n.setVisibility(z2 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f321m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                iMin = Math.min(i7, iMin);
            }
            this.f321m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(iMin, i8));
        }
        if (this.f511f > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i9) {
                i9 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i9);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i3) {
        this.f511f = i3;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f321m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f321m = view;
        if (view != null && (linearLayout = this.f322n) != null) {
            removeView(linearLayout);
            this.f322n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f319k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f318j = charSequence;
        i();
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f327s) {
            requestLayout();
        }
        this.f327s = z2;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        w0 w0VarV = w0.v(context, attributeSet, a.j.ActionMode, i3, 0);
        e0.t.p0(this, w0VarV.g(a.j.ActionMode_background));
        this.f325q = w0VarV.n(a.j.ActionMode_titleTextStyle, 0);
        this.f326r = w0VarV.n(a.j.ActionMode_subtitleTextStyle, 0);
        this.f511f = w0VarV.m(a.j.ActionMode_height, 0);
        this.f328t = w0VarV.n(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
        w0VarV.w();
    }
}
