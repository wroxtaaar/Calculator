package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Drawable f314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f317k;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f312f;
        if (drawable != null && drawable.isStateful()) {
            this.f312f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f313g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f313g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f314h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f314h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f309c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f312f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f313g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f314h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f310d = findViewById(a.f.action_bar);
        this.f311e = findViewById(a.f.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f308b || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[PHI: r0
  0x0048: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a5, B:33:0x00a9, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        Drawable drawable;
        super.onLayout(z2, i3, i4, i5, i6);
        View view = this.f309c;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i7 = layoutParams.bottomMargin;
            view.layout(i3, measuredHeight2 - i7, i5, measuredHeight - i7);
        }
        if (this.f315i) {
            Drawable drawable2 = this.f314h;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = z4;
            }
        } else {
            if (this.f312f != null) {
                if (this.f310d.getVisibility() == 0) {
                    this.f312f.setBounds(this.f310d.getLeft(), this.f310d.getTop(), this.f310d.getRight(), this.f310d.getBottom());
                } else {
                    View view2 = this.f311e;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f312f.setBounds(0, 0, 0, 0);
                    } else {
                        this.f312f.setBounds(this.f311e.getLeft(), this.f311e.getTop(), this.f311e.getRight(), this.f311e.getBottom());
                    }
                }
                z4 = true;
            }
            this.f316j = z5;
            if (!z5 || (drawable = this.f313g) == null) {
                z3 = z4;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        int iA;
        int i5;
        if (this.f310d == null && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE && (i5 = this.f317k) >= 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i4)), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i4);
        if (this.f310d == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        View view = this.f309c;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (b(this.f310d)) {
            iA = !b(this.f311e) ? a(this.f311e) : 0;
        } else {
            iA = a(this.f310d);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iA + a(this.f309c), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i4) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f312f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f312f);
        }
        this.f312f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f310d;
            if (view != null) {
                this.f312f.setBounds(view.getLeft(), this.f310d.getTop(), this.f310d.getRight(), this.f310d.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f315i ? this.f312f != null || this.f313g != null : this.f314h != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f314h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f314h);
        }
        this.f314h = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f315i && (drawable2 = this.f314h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f315i ? !(this.f312f != null || this.f313g != null) : this.f314h == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f313g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f313g);
        }
        this.f313g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f316j && (drawable2 = this.f313g) != null) {
                drawable2.setBounds(this.f309c.getLeft(), this.f309c.getTop(), this.f309c.getRight(), this.f309c.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f315i ? this.f312f != null || this.f313g != null : this.f314h != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(p0 p0Var) {
        View view = this.f309c;
        if (view != null) {
            removeView(view);
        }
        this.f309c = p0Var;
        if (p0Var != null) {
            addView(p0Var);
            ViewGroup.LayoutParams layoutParams = p0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            p0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z2) {
        this.f308b = z2;
        setDescendantFocusability(z2 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z2 = i3 == 0;
        Drawable drawable = this.f312f;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f313g;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f314h;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i3) {
        if (i3 != 0) {
            return super.startActionModeForChild(view, callback, i3);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f312f && !this.f315i) || (drawable == this.f313g && this.f316j) || ((drawable == this.f314h && this.f315i) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e0.t.p0(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBar);
        this.f312f = typedArrayObtainStyledAttributes.getDrawable(a.j.ActionBar_background);
        this.f313g = typedArrayObtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundStacked);
        this.f317k = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_height, -1);
        boolean z2 = true;
        if (getId() == a.f.split_action_bar) {
            this.f315i = true;
            this.f314h = typedArrayObtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f315i ? this.f312f != null || this.f313g != null : this.f314h != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }
}
