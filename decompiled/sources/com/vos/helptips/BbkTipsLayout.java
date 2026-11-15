package com.vos.helptips;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import y1.a;
import y1.g;
import y1.h;

/* JADX INFO: loaded from: classes.dex */
public class BbkTipsLayout extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f4328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f4329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Path f4330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f4331j;

    public BbkTipsLayout(Context context) {
        this(context, null);
    }

    protected PointF a(PointF pointF) {
        int i3 = this.f4323b;
        if (i3 == 3 || i3 == 5) {
            pointF.y += this.f4326e;
        } else if (i3 == 48 || i3 == 80) {
            pointF.x += this.f4326e;
        }
        return pointF;
    }

    protected void b(Canvas canvas) {
        Log.d("BbkTipsLayout", "drawArrow mGravity:" + this.f4323b + " mArrowWidth: " + this.f4324c + " mArrowHeight:" + this.f4325d + " mArrowTopOffset:" + this.f4326e);
        this.f4329h.setColor(this.f4327f);
        this.f4329h.setAntiAlias(true);
        this.f4330i.reset();
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        PointF arrowTopPoint = getArrowTopPoint();
        int i3 = this.f4323b;
        if (i3 == 3) {
            this.f4330i.moveTo(this.f4325d, arrowTopPoint.y - (this.f4324c / 2));
            this.f4330i.lineTo(arrowTopPoint.x, arrowTopPoint.y);
            this.f4330i.lineTo(this.f4325d, arrowTopPoint.y + (this.f4324c / 2));
        } else if (i3 == 5) {
            float f3 = measuredWidth;
            this.f4330i.moveTo(f3, arrowTopPoint.y - (this.f4324c / 2));
            this.f4330i.lineTo(arrowTopPoint.x, arrowTopPoint.y);
            this.f4330i.lineTo(f3, arrowTopPoint.y + (this.f4324c / 2));
        } else if (i3 == 48) {
            this.f4330i.moveTo(arrowTopPoint.x - (this.f4324c / 2), this.f4325d);
            this.f4330i.lineTo(arrowTopPoint.x, arrowTopPoint.y);
            this.f4330i.lineTo(arrowTopPoint.x + (this.f4324c / 2), this.f4325d);
        } else if (i3 == 80) {
            float f4 = measuredHeight;
            this.f4330i.moveTo(arrowTopPoint.x - (this.f4324c / 2), f4);
            this.f4330i.lineTo(arrowTopPoint.x, arrowTopPoint.y);
            this.f4330i.lineTo(arrowTopPoint.x + (this.f4324c / 2), f4);
        }
        canvas.drawPath(this.f4330i, this.f4329h);
    }

    protected PointF c() {
        PointF pointF = new PointF(0.0f, 0.0f);
        View childAt = getChildAt(0);
        if (childAt == null) {
            return pointF;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i3 = this.f4323b;
        if (i3 == 3) {
            pointF.x = 0.0f;
            pointF.y = measuredHeight / 2.0f;
        } else if (i3 == 5) {
            pointF.x = getMeasuredWidth();
            pointF.y = measuredHeight / 2.0f;
        } else if (i3 == 48) {
            pointF.x = measuredWidth / 2.0f;
            pointF.y = 0.0f;
        } else if (i3 == 80) {
            pointF.x = measuredWidth / 2.0f;
            pointF.y = getMeasuredHeight();
        }
        return pointF;
    }

    public void d() {
        Drawable drawable;
        this.f4331j = getChildAt(0);
        Log.d("BbkTipsLayout", "BbkTipsLayout mTipsContent: " + this.f4331j);
        if (this.f4331j == null || (drawable = this.f4328g) == null) {
            return;
        }
        drawable.setTint(this.f4327f);
        this.f4331j.setBackground(this.f4328g);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        b(canvas);
    }

    public int getArrowHeight() {
        return this.f4325d;
    }

    public PointF getArrowTopPoint() {
        return a(c());
    }

    public int getArrowWidth() {
        return this.f4324c;
    }

    public Size getContentSize() {
        View childAt = getChildAt(0);
        this.f4331j = childAt;
        if (childAt == null) {
            return null;
        }
        childAt.measure(childAt.getMeasuredWidth(), this.f4331j.getMeasuredHeight());
        return new Size(this.f4331j.getMeasuredWidth(), this.f4331j.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        Log.d("BbkTipsLayout", "onLayout mGravity:" + this.f4323b);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
        int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
        int i7 = this.f4323b;
        if (i7 == 3) {
            paddingLeft += this.f4325d;
            measuredWidth = paddingLeft + childAt.getMeasuredWidth();
        } else if (i7 == 48) {
            paddingTop += this.f4325d;
            measuredHeight = paddingTop + childAt.getMeasuredHeight();
        }
        childAt.layout(paddingLeft, paddingTop, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        measureChild(childAt, i3, i4);
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int iCombineMeasuredStates = ViewGroup.combineMeasuredStates(0, childAt.getMeasuredState());
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        int i5 = this.f4323b;
        if (i5 == 3 || i5 == 5) {
            paddingLeft += this.f4325d;
        } else if (i5 == 48 || i5 == 80) {
            paddingTop += this.f4325d;
        }
        setMeasuredDimension(ViewGroup.resolveSizeAndState(paddingLeft, i3, iCombineMeasuredStates), ViewGroup.resolveSizeAndState(paddingTop, i4, iCombineMeasuredStates));
    }

    public void setArrowGravity(int i3) {
        this.f4323b = i3;
        requestLayout();
    }

    public void setArrowHeight(int i3) {
        this.f4325d = i3;
        requestLayout();
    }

    public void setArrowOffset(float f3) {
        this.f4326e = f3;
        requestLayout();
    }

    public void setArrowWidth(int i3) {
        this.f4324c = i3;
        requestLayout();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.f4327f = i3;
        d();
        requestLayout();
    }

    public BbkTipsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.BbkHelpTipsStyle);
    }

    public BbkTipsLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, g.BbkHelpTips);
    }

    public BbkTipsLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f4326e = 0.0f;
        this.f4328g = null;
        this.f4329h = new Paint();
        this.f4330i = new Path();
        this.f4331j = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.BbkHelpTips, i3, i4);
        this.f4323b = typedArrayObtainStyledAttributes.getInt(h.BbkHelpTips_android_gravity, 48);
        this.f4324c = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.BbkHelpTips_tipsArrowWidth, 0);
        this.f4325d = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.BbkHelpTips_tipsArrowHeight, 0);
        this.f4327f = typedArrayObtainStyledAttributes.getColor(h.BbkHelpTips_tipsBackgroundColor, 0);
        this.f4328g = typedArrayObtainStyledAttributes.getDrawable(h.BbkHelpTips_tipsContentBackground);
        typedArrayObtainStyledAttributes.recycle();
    }
}
