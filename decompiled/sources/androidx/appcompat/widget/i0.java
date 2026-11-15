package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: LinearLayoutCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class i0 extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f635p;

    public i0(Context context) {
        this(context, null);
    }

    private void A(View view, int i3, int i4, int i5, int i6) {
        view.layout(i3, i4, i5 + i3, i6 + i4);
    }

    private void k(int i3, int i4) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i5 = 0; i5 < i3; i5++) {
            View viewS = s(i5);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i6 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = viewS.getMeasuredWidth();
                    measureChildWithMargins(viewS, i4, 0, iMakeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i6;
                }
            }
        }
    }

    private void l(int i3, int i4) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i5 = 0; i5 < i3; i5++) {
            View viewS = s(i5);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i6 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = viewS.getMeasuredHeight();
                    measureChildWithMargins(viewS, iMakeMeasureSpec, 0, i4, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i6;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i3;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = c1.b(this);
        for (int i4 = 0; i4 < virtualChildCount; i4++) {
            View viewS = s(i4);
            if (viewS != null && viewS.getVisibility() != 8 && t(i4)) {
                a aVar = (a) viewS.getLayoutParams();
                j(canvas, zB ? viewS.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (viewS.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.f632m);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            if (viewS2 != null) {
                a aVar2 = (a) viewS2.getLayoutParams();
                if (zB) {
                    left = viewS2.getLeft() - ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    i3 = this.f632m;
                    right = left - i3;
                } else {
                    right = viewS2.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i3 = this.f632m;
                right = left - i3;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i3;
        if (this.f622c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i4 = this.f622c;
        if (childCount <= i4) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i4);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f622c == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f623d;
        if (this.f624e == 1 && (i3 = this.f625f & 112) != 48) {
            if (i3 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f626g) / 2;
            } else if (i3 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f626g;
            }
        }
        return bottom + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f622c;
    }

    public Drawable getDividerDrawable() {
        return this.f631l;
    }

    public int getDividerPadding() {
        return this.f635p;
    }

    public int getDividerWidth() {
        return this.f632m;
    }

    public int getGravity() {
        return this.f625f;
    }

    public int getOrientation() {
        return this.f624e;
    }

    public int getShowDividers() {
        return this.f634o;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f627h;
    }

    void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View viewS = s(i3);
            if (viewS != null && viewS.getVisibility() != 8 && t(i3)) {
                i(canvas, (viewS.getTop() - ((ViewGroup.MarginLayoutParams) ((a) viewS.getLayoutParams())).topMargin) - this.f633n);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            i(canvas, viewS2 == null ? (getHeight() - getPaddingBottom()) - this.f633n : viewS2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) viewS2.getLayoutParams())).bottomMargin);
        }
    }

    void i(Canvas canvas, int i3) {
        this.f631l.setBounds(getPaddingLeft() + this.f635p, i3, (getWidth() - getPaddingRight()) - this.f635p, this.f633n + i3);
        this.f631l.draw(canvas);
    }

    void j(Canvas canvas, int i3) {
        this.f631l.setBounds(i3, getPaddingTop() + this.f635p, this.f632m + i3, (getHeight() - getPaddingBottom()) - this.f635p);
        this.f631l.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i3 = this.f624e;
        if (i3 == 0) {
            return new a(-2, -2);
        }
        if (i3 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f631l == null) {
            return;
        }
        if (this.f624e == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        if (this.f624e == 1) {
            v(i3, i4, i5, i6);
        } else {
            u(i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f624e == 1) {
            z(i3, i4);
        } else {
            x(i3, i4);
        }
    }

    int p(View view, int i3) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i3) {
        return getChildAt(i3);
    }

    public void setBaselineAligned(boolean z2) {
        this.f621b = z2;
    }

    public void setBaselineAlignedChildIndex(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.f622c = i3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f631l) {
            return;
        }
        this.f631l = drawable;
        if (drawable != null) {
            this.f632m = drawable.getIntrinsicWidth();
            this.f633n = drawable.getIntrinsicHeight();
        } else {
            this.f632m = 0;
            this.f633n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i3) {
        this.f635p = i3;
    }

    public void setGravity(int i3) {
        if (this.f625f != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f625f = i3;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i3) {
        int i4 = i3 & 8388615;
        int i5 = this.f625f;
        if ((8388615 & i5) != i4) {
            this.f625f = i4 | ((-8388616) & i5);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f628i = z2;
    }

    public void setOrientation(int i3) {
        if (this.f624e != i3) {
            this.f624e = i3;
            requestLayout();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.f634o) {
            requestLayout();
        }
        this.f634o = i3;
    }

    public void setVerticalGravity(int i3) {
        int i4 = i3 & 112;
        int i5 = this.f625f;
        if ((i5 & 112) != i4) {
            this.f625f = i4 | (i5 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f3) {
        this.f627h = Math.max(0.0f, f3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected boolean t(int i3) {
        if (i3 == 0) {
            return (this.f634o & 1) != 0;
        }
        if (i3 == getChildCount()) {
            return (this.f634o & 4) != 0;
        }
        if ((this.f634o & 2) == 0) {
            return false;
        }
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            if (getChildAt(i4).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00df  */
    /* JADX WARN: Code duplicated, block: B:44:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ff  */
    void u(int i3, int i4, int i5, int i6) {
        int paddingLeft;
        int i7;
        int i8;
        boolean z2;
        int baseline;
        int i9;
        int i10;
        int measuredHeight;
        boolean zB = c1.b(this);
        int paddingTop = getPaddingTop();
        int i11 = i6 - i4;
        int paddingBottom = i11 - getPaddingBottom();
        int paddingBottom2 = (i11 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i12 = this.f625f;
        int i13 = i12 & 112;
        boolean z3 = this.f621b;
        int[] iArr = this.f629j;
        int[] iArr2 = this.f630k;
        int iB = e0.d.b(8388615 & i12, e0.t.B(this));
        boolean z4 = true;
        if (iB != 1) {
            paddingLeft = iB != 5 ? getPaddingLeft() : ((getPaddingLeft() + i5) - i3) - this.f626g;
        } else {
            paddingLeft = getPaddingLeft() + (((i5 - i3) - this.f626g) / 2);
        }
        if (zB) {
            i7 = virtualChildCount - 1;
            i8 = -1;
        } else {
            i7 = 0;
            i8 = 1;
        }
        int iP = 0;
        while (iP < virtualChildCount) {
            int i14 = i7 + (i8 * iP);
            View viewS = s(i14);
            if (viewS == null) {
                paddingLeft += y(i14);
                z2 = z4;
            } else {
                if (viewS.getVisibility() != 8) {
                    int measuredWidth = viewS.getMeasuredWidth();
                    int measuredHeight2 = viewS.getMeasuredHeight();
                    a aVar = (a) viewS.getLayoutParams();
                    int i15 = iP;
                    if (z3) {
                        virtualChildCount = virtualChildCount;
                        baseline = ((ViewGroup.MarginLayoutParams) aVar).height != -1 ? viewS.getBaseline() : -1;
                        i9 = aVar.f637b;
                        if (i9 < 0) {
                            i9 = i13;
                        }
                        i10 = i9 & 112;
                        i13 = i13;
                        if (i10 != 16) {
                            if (i10 != 48) {
                                measuredHeight = ((ViewGroup.MarginLayoutParams) aVar).topMargin + paddingTop;
                                if (baseline != -1) {
                                    z2 = true;
                                    measuredHeight += iArr[1] - baseline;
                                }
                            } else if (i10 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight -= iArr2[2] - (viewS.getMeasuredHeight() - baseline);
                                }
                            }
                            z2 = true;
                        } else {
                            z2 = true;
                            measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) aVar).topMargin) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        }
                        if (t(i14)) {
                            paddingLeft += this.f632m;
                        }
                        int i16 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                        paddingTop = paddingTop;
                        A(viewS, i16 + q(viewS), measuredHeight, measuredWidth, measuredHeight2);
                        int iR = i16 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(viewS);
                        iP = i15 + p(viewS, i14);
                        paddingLeft = iR;
                    } else {
                        virtualChildCount = virtualChildCount;
                    }
                    i9 = aVar.f637b;
                    if (i9 < 0) {
                        i9 = i13;
                    }
                    i10 = i9 & 112;
                    i13 = i13;
                    if (i10 != 16) {
                        if (i10 != 48) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) aVar).topMargin + paddingTop;
                            if (baseline != -1) {
                                z2 = true;
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i10 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewS.getMeasuredHeight() - baseline);
                            }
                        }
                        z2 = true;
                    } else {
                        z2 = true;
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) aVar).topMargin) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                    }
                    if (t(i14)) {
                        paddingLeft += this.f632m;
                    }
                    int i17 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    paddingTop = paddingTop;
                    A(viewS, i17 + q(viewS), measuredHeight, measuredWidth, measuredHeight2);
                    int iR2 = i17 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(viewS);
                    iP = i15 + p(viewS, i14);
                    paddingLeft = iR2;
                } else {
                    z2 = true;
                }
                iP++;
                virtualChildCount = virtualChildCount;
                i13 = i13;
                z4 = z2;
                paddingTop = paddingTop;
            }
            iP++;
            virtualChildCount = virtualChildCount;
            i13 = i13;
            z4 = z2;
            paddingTop = paddingTop;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009f  */
    void v(int i3, int i4, int i5, int i6) {
        int paddingTop;
        int i7;
        int i8;
        int i9;
        int i10;
        int paddingLeft = getPaddingLeft();
        int i11 = i5 - i3;
        int paddingRight = i11 - getPaddingRight();
        int paddingRight2 = (i11 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i12 = this.f625f;
        int i13 = i12 & 112;
        int i14 = i12 & 8388615;
        if (i13 != 16) {
            paddingTop = i13 != 80 ? getPaddingTop() : ((getPaddingTop() + i6) - i4) - this.f626g;
        } else {
            paddingTop = getPaddingTop() + (((i6 - i4) - this.f626g) / 2);
        }
        int iP = 0;
        while (iP < virtualChildCount) {
            View viewS = s(iP);
            if (viewS == null) {
                paddingTop += y(iP);
            } else {
                if (viewS.getVisibility() != 8) {
                    int measuredWidth = viewS.getMeasuredWidth();
                    int measuredHeight = viewS.getMeasuredHeight();
                    a aVar = (a) viewS.getLayoutParams();
                    int i15 = aVar.f637b;
                    if (i15 < 0) {
                        i15 = i14;
                    }
                    int iB = e0.d.b(i15, e0.t.B(this)) & 7;
                    if (iB != 1) {
                        if (iB != 5) {
                            i9 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                        } else {
                            i7 = paddingRight - measuredWidth;
                            i8 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                        }
                        int i16 = i9;
                        if (t(iP)) {
                            paddingTop += this.f633n;
                        }
                        int i17 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                        A(viewS, i16, i17 + q(viewS), measuredWidth, measuredHeight);
                        int iR = i17 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(viewS);
                        iP += p(viewS, iP);
                        paddingTop = iR;
                        i10 = 1;
                    } else {
                        i7 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                        i8 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    }
                    i9 = i7 - i8;
                    int i18 = i9;
                    if (t(iP)) {
                        paddingTop += this.f633n;
                    }
                    int i19 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    A(viewS, i18, i19 + q(viewS), measuredWidth, measuredHeight);
                    int iR2 = i19 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(viewS);
                    iP += p(viewS, iP);
                    paddingTop = iR2;
                    i10 = 1;
                }
                iP += i10;
            }
            i10 = 1;
            iP += i10;
        }
    }

    void w(View view, int i3, int i4, int i5, int i6, int i7) {
        measureChildWithMargins(view, i4, i5, i6, i7);
    }

    /* JADX WARN: Code duplicated, block: B:197:0x0453  */
    /* JADX WARN: Code duplicated, block: B:60:0x0177  */
    /* JADX WARN: Code duplicated, block: B:67:0x0199  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x01dd  */
    void x(int i3, int i4) {
        int[] iArr;
        int i5;
        int iMax;
        int iMax2;
        int i6;
        int i7;
        int baseline;
        int i8;
        int i9;
        byte b3;
        int i10;
        int i11;
        boolean z2;
        boolean z3;
        View view;
        int i12;
        boolean z4;
        int i13;
        int measuredHeight;
        int iP;
        int baseline2;
        int i14;
        this.f626g = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        if (this.f629j == null || this.f630k == null) {
            this.f629j = new int[4];
            this.f630k = new int[4];
        }
        int[] iArr2 = this.f629j;
        int[] iArr3 = this.f630k;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.f621b;
        boolean z6 = this.f628i;
        int i15 = 1073741824;
        boolean z7 = mode == 1073741824;
        int iP2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        int iMax6 = 0;
        boolean z8 = false;
        int iCombineMeasuredStates = 0;
        boolean z9 = false;
        boolean z10 = true;
        float f3 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (iP2 >= virtualChildCount) {
                break;
            }
            View viewS = s(iP2);
            if (viewS == null) {
                this.f626g += y(iP2);
            } else {
                if (viewS.getVisibility() == 8) {
                    iP2 += p(viewS, iP2);
                } else {
                    if (t(iP2)) {
                        this.f626g += this.f632m;
                    }
                    a aVar = (a) viewS.getLayoutParams();
                    float f4 = aVar.f636a;
                    float f5 = f3 + f4;
                    if (mode == i15 && ((ViewGroup.MarginLayoutParams) aVar).width == 0 && f4 > 0.0f) {
                        if (z7) {
                            this.f626g += ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                        } else {
                            int i16 = this.f626g;
                            this.f626g = Math.max(i16, ((ViewGroup.MarginLayoutParams) aVar).leftMargin + i16 + ((ViewGroup.MarginLayoutParams) aVar).rightMargin);
                        }
                        if (z5) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            viewS.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i11 = iP2;
                            z2 = z6;
                            z3 = z5;
                            view = viewS;
                        } else {
                            i11 = iP2;
                            z2 = z6;
                            z3 = z5;
                            view = viewS;
                            z8 = true;
                            i12 = 1073741824;
                        }
                        if (mode2 == i12 && ((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                            z4 = true;
                            z9 = true;
                        } else {
                            z4 = false;
                        }
                        i13 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i13;
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            i14 = aVar.f637b;
                            if (i14 < 0) {
                                i14 = this.f625f;
                            }
                            int i17 = (((i14 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i17] = Math.max(iArr2[i17], baseline2);
                            iArr[i17] = Math.max(iArr[i17], measuredHeight - baseline2);
                        }
                        iMax4 = Math.max(iMax4, measuredHeight);
                        if (z10 || ((ViewGroup.MarginLayoutParams) aVar).height != -1) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (aVar.f636a > 0.0f) {
                            if (!z4) {
                                i13 = measuredHeight;
                            }
                            iMax6 = Math.max(iMax6, i13);
                        } else {
                            int i18 = iMax6;
                            if (!z4) {
                                i13 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i13);
                            iMax6 = i18;
                        }
                        int i19 = i11;
                        iP = p(view, i19) + i19;
                        f3 = f5;
                    } else {
                        if (((ViewGroup.MarginLayoutParams) aVar).width != 0 || f4 <= 0.0f) {
                            b3 = -2;
                            i10 = Integer.MIN_VALUE;
                        } else {
                            b3 = -2;
                            ((ViewGroup.MarginLayoutParams) aVar).width = -2;
                            i10 = 0;
                        }
                        i11 = iP2;
                        int i20 = i10;
                        z2 = z6;
                        z3 = z5;
                        w(viewS, i11, i3, f5 == 0.0f ? this.f626g : 0, i4, 0);
                        if (i20 != Integer.MIN_VALUE) {
                            ((ViewGroup.MarginLayoutParams) aVar).width = i20;
                        }
                        int measuredWidth = viewS.getMeasuredWidth();
                        if (z7) {
                            view = viewS;
                            this.f626g += ((ViewGroup.MarginLayoutParams) aVar).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view);
                        } else {
                            view = viewS;
                            int i21 = this.f626g;
                            this.f626g = Math.max(i21, i21 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view));
                        }
                        if (z2) {
                            iMax3 = Math.max(measuredWidth, iMax3);
                        }
                    }
                    i12 = 1073741824;
                    if (mode2 == i12) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    i13 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i13;
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    if (z3) {
                        i14 = aVar.f637b;
                        if (i14 < 0) {
                            i14 = this.f625f;
                        }
                        int i110 = (((i14 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i110] = Math.max(iArr2[i110], baseline2);
                        iArr[i110] = Math.max(iArr[i110], measuredHeight - baseline2);
                    }
                    iMax4 = Math.max(iMax4, measuredHeight);
                    if (z10) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    if (aVar.f636a > 0.0f) {
                        if (!z4) {
                            i13 = measuredHeight;
                        }
                        iMax6 = Math.max(iMax6, i13);
                    } else {
                        int i111 = iMax6;
                        if (!z4) {
                            i13 = measuredHeight;
                        }
                        iMax5 = Math.max(iMax5, i13);
                        iMax6 = i111;
                    }
                    int i112 = i11;
                    iP = p(view, i112) + i112;
                    f3 = f5;
                }
                int i22 = iP + 1;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i15 = i12;
                iP2 = i22;
            }
            z2 = z6;
            z3 = z5;
            int i23 = i15;
            iP = iP2;
            i12 = i23;
            int i24 = iP + 1;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i15 = i12;
            iP2 = i24;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i25 = iMax4;
        int i26 = iMax5;
        int i27 = iMax6;
        int i28 = iCombineMeasuredStates;
        if (this.f626g > 0 && t(virtualChildCount)) {
            this.f626g += this.f632m;
        }
        int iMax7 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i25 : Math.max(i25, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f626g = 0;
            int iP3 = 0;
            while (iP3 < virtualChildCount) {
                View viewS2 = s(iP3);
                if (viewS2 == null) {
                    this.f626g += y(iP3);
                } else if (viewS2.getVisibility() == 8) {
                    iP3 += p(viewS2, iP3);
                } else {
                    a aVar2 = (a) viewS2.getLayoutParams();
                    if (z7) {
                        this.f626g += ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + iMax3 + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(viewS2);
                    } else {
                        int i29 = this.f626g;
                        this.f626g = Math.max(i29, i29 + iMax3 + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(viewS2));
                    }
                    iP3++;
                    iMax7 = iMax7;
                }
                iP3++;
                iMax7 = iMax7;
            }
        }
        int i30 = iMax7;
        int paddingLeft = this.f626g + getPaddingLeft() + getPaddingRight();
        this.f626g = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, 0);
        int i31 = (16777215 & iResolveSizeAndState) - this.f626g;
        if (z8 || (i31 != 0 && f3 > 0.0f)) {
            float f6 = this.f627h;
            if (f6 > 0.0f) {
                f3 = f6;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f626g = 0;
            int i32 = i26;
            int iMax8 = -1;
            int iCombineMeasuredStates2 = i28;
            int i33 = 0;
            while (i33 < virtualChildCount) {
                View viewS3 = s(i33);
                if (viewS3 == null || viewS3.getVisibility() == 8) {
                    i6 = i31;
                    virtualChildCount = virtualChildCount;
                } else {
                    a aVar3 = (a) viewS3.getLayoutParams();
                    float f7 = aVar3.f636a;
                    if (f7 > 0.0f) {
                        int i34 = (int) ((i31 * f7) / f3);
                        float f8 = f3 - f7;
                        int i35 = i31 - i34;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin, ((ViewGroup.MarginLayoutParams) aVar3).height);
                        if (((ViewGroup.MarginLayoutParams) aVar3).width == 0) {
                            i9 = 1073741824;
                            if (mode == 1073741824) {
                                if (i34 <= 0) {
                                    i34 = 0;
                                }
                                viewS3.measure(View.MeasureSpec.makeMeasureSpec(i34, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewS3.getMeasuredState() & (-16777216));
                            f3 = f8;
                            i6 = i35;
                        } else {
                            i9 = 1073741824;
                        }
                        int measuredWidth2 = viewS3.getMeasuredWidth() + i34;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewS3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i9), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewS3.getMeasuredState() & (-16777216));
                        f3 = f8;
                        i6 = i35;
                    } else {
                        i6 = i31;
                    }
                    if (z7) {
                        this.f626g += viewS3.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(viewS3);
                    } else {
                        int i36 = this.f626g;
                        this.f626g = Math.max(i36, viewS3.getMeasuredWidth() + i36 + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(viewS3));
                    }
                    boolean z13 = mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) aVar3).height == -1;
                    int i37 = ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = viewS3.getMeasuredHeight() + i37;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z13) {
                        i37 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i32, i37);
                    if (z10) {
                        i7 = -1;
                        boolean z14 = ((ViewGroup.MarginLayoutParams) aVar3).height == -1;
                        if (z12 && (baseline = viewS3.getBaseline()) != i7) {
                            i8 = aVar3.f637b;
                            if (i8 < 0) {
                                i8 = this.f625f;
                            }
                            int i38 = (((i8 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i38] = Math.max(iArr2[i38], baseline);
                            iArr[i38] = Math.max(iArr[i38], measuredHeight2 - baseline);
                        }
                        z10 = z14;
                        i32 = iMax9;
                        f3 = f3;
                    } else {
                        i7 = -1;
                    }
                    if (z12) {
                        i8 = aVar3.f637b;
                        if (i8 < 0) {
                            i8 = this.f625f;
                        }
                        int i39 = (((i8 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i39] = Math.max(iArr2[i39], baseline);
                        iArr[i39] = Math.max(iArr[i39], measuredHeight2 - baseline);
                    }
                    z10 = z14;
                    i32 = iMax9;
                    f3 = f3;
                }
                i33++;
                i31 = i6;
                virtualChildCount = virtualChildCount;
            }
            i5 = virtualChildCount;
            this.f626g += getPaddingLeft() + getPaddingRight();
            iMax = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax2 = i32;
            i28 = iCombineMeasuredStates2;
        } else {
            iMax2 = Math.max(i26, i27);
            if (z11 && mode != 1073741824) {
                for (int i40 = 0; i40 < virtualChildCount; i40++) {
                    View viewS4 = s(i40);
                    if (viewS4 != null && viewS4.getVisibility() != 8 && ((a) viewS4.getLayoutParams()).f636a > 0.0f) {
                        viewS4.measure(View.MeasureSpec.makeMeasureSpec(iMax3, 1073741824), View.MeasureSpec.makeMeasureSpec(viewS4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i5 = virtualChildCount;
            iMax = i30;
        }
        if (z10 || mode2 == 1073741824) {
            iMax2 = iMax;
        }
        setMeasuredDimension(iResolveSizeAndState | (i28 & (-16777216)), View.resolveSizeAndState(Math.max(iMax2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, i28 << 16));
        if (z9) {
            k(i5, i3);
        }
    }

    int y(int i3) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0325  */
    /* JADX WARN: Code duplicated, block: B:156:0x0333  */
    void z(int i3, int i4) {
        int i5;
        int iCombineMeasuredStates;
        int iMax;
        int i6;
        int i7;
        int i8;
        boolean z2;
        boolean z3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        View view;
        int iMax2;
        boolean z4;
        int iMax3;
        this.f626g = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int i18 = this.f622c;
        boolean z5 = this.f628i;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int iMax4 = 0;
        int i22 = 0;
        int iP = 0;
        boolean z6 = false;
        boolean z7 = false;
        float f3 = 0.0f;
        boolean z8 = true;
        while (true) {
            int i23 = 8;
            int i24 = iMax4;
            if (iP >= virtualChildCount) {
                int i25 = i19;
                int i26 = i21;
                int i27 = i22;
                int i28 = virtualChildCount;
                int i29 = mode2;
                int iMax5 = i20;
                if (this.f626g > 0) {
                    i5 = i28;
                    if (t(i5)) {
                        this.f626g += this.f633n;
                    }
                } else {
                    i5 = i28;
                }
                if (z5 && (i29 == Integer.MIN_VALUE || i29 == 0)) {
                    this.f626g = 0;
                    int iP2 = 0;
                    while (iP2 < i5) {
                        View viewS = s(iP2);
                        if (viewS == null) {
                            this.f626g += y(iP2);
                        } else if (viewS.getVisibility() == i23) {
                            iP2 += p(viewS, iP2);
                        } else {
                            a aVar = (a) viewS.getLayoutParams();
                            int i30 = this.f626g;
                            this.f626g = Math.max(i30, i30 + i26 + ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(viewS));
                        }
                        iP2++;
                        i23 = 8;
                    }
                }
                int paddingTop = this.f626g + getPaddingTop() + getPaddingBottom();
                this.f626g = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, 0);
                int i31 = (16777215 & iResolveSizeAndState) - this.f626g;
                if (z6 || (i31 != 0 && f3 > 0.0f)) {
                    float f4 = this.f627h;
                    if (f4 > 0.0f) {
                        f3 = f4;
                    }
                    this.f626g = 0;
                    int i32 = i31;
                    int i33 = i27;
                    iCombineMeasuredStates = i25;
                    int i34 = 0;
                    while (i34 < i5) {
                        View viewS2 = s(i34);
                        if (viewS2.getVisibility() == 8) {
                            i6 = i32;
                        } else {
                            a aVar2 = (a) viewS2.getLayoutParams();
                            float f5 = aVar2.f636a;
                            if (f5 > 0.0f) {
                                int i35 = (int) ((i32 * f5) / f3);
                                float f6 = f3 - f5;
                                i6 = i32 - i35;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin, ((ViewGroup.MarginLayoutParams) aVar2).width);
                                if (((ViewGroup.MarginLayoutParams) aVar2).height == 0) {
                                    i9 = 1073741824;
                                    if (i29 == 1073741824) {
                                        if (i35 <= 0) {
                                            i35 = 0;
                                        }
                                        viewS2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i35, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS2.getMeasuredState() & (-256));
                                    f3 = f6;
                                } else {
                                    i9 = 1073741824;
                                }
                                int measuredHeight = viewS2.getMeasuredHeight() + i35;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewS2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i9));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS2.getMeasuredState() & (-256));
                                f3 = f6;
                            } else {
                                i6 = i32;
                            }
                            int i36 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                            int measuredWidth = viewS2.getMeasuredWidth() + i36;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f7 = f3;
                            if (mode != 1073741824) {
                                i7 = iCombineMeasuredStates;
                                i8 = -1;
                                z2 = ((ViewGroup.MarginLayoutParams) aVar2).width == -1;
                                if (!z2) {
                                    i36 = measuredWidth;
                                }
                                int iMax6 = Math.max(i33, i36);
                                if (z8 || ((ViewGroup.MarginLayoutParams) aVar2).width != i8) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                int i37 = this.f626g;
                                this.f626g = Math.max(i37, viewS2.getMeasuredHeight() + i37 + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin + r(viewS2));
                                z8 = z3;
                                iCombineMeasuredStates = i7;
                                i33 = iMax6;
                                f3 = f7;
                            } else {
                                i7 = iCombineMeasuredStates;
                                i8 = -1;
                            }
                            if (!z2) {
                                i36 = measuredWidth;
                            }
                            int iMax7 = Math.max(i33, i36);
                            if (z8) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                            int i38 = this.f626g;
                            this.f626g = Math.max(i38, viewS2.getMeasuredHeight() + i38 + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin + r(viewS2));
                            z8 = z3;
                            iCombineMeasuredStates = i7;
                            i33 = iMax7;
                            f3 = f7;
                        }
                        i34++;
                        i32 = i6;
                    }
                    this.f626g += getPaddingTop() + getPaddingBottom();
                    iMax = i33;
                } else {
                    iMax = Math.max(i27, i24);
                    if (z5 && i29 != 1073741824) {
                        for (int i39 = 0; i39 < i5; i39++) {
                            View viewS3 = s(i39);
                            if (viewS3 != null && viewS3.getVisibility() != 8 && ((a) viewS3.getLayoutParams()).f636a > 0.0f) {
                                viewS3.measure(View.MeasureSpec.makeMeasureSpec(viewS3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i26, 1073741824));
                            }
                        }
                    }
                    iCombineMeasuredStates = i25;
                }
                if (z8 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, iCombineMeasuredStates), iResolveSizeAndState);
                if (z7) {
                    l(i5, i4);
                    return;
                }
                return;
            }
            View viewS4 = s(iP);
            if (viewS4 == null) {
                this.f626g += y(iP);
                i13 = virtualChildCount;
                i14 = mode2;
                iMax4 = i24;
            } else {
                int i40 = i19;
                if (viewS4.getVisibility() == 8) {
                    iP += p(viewS4, iP);
                    i13 = virtualChildCount;
                    iMax4 = i24;
                    i19 = i40;
                    i14 = mode2;
                } else {
                    if (t(iP)) {
                        this.f626g += this.f633n;
                    }
                    a aVar3 = (a) viewS4.getLayoutParams();
                    float f8 = aVar3.f636a;
                    float f9 = f3 + f8;
                    if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) aVar3).height == 0 && f8 > 0.0f) {
                        int i41 = this.f626g;
                        this.f626g = Math.max(i41, ((ViewGroup.MarginLayoutParams) aVar3).topMargin + i41 + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin);
                        iMax2 = i21;
                        view = viewS4;
                        i16 = i22;
                        z6 = true;
                        i11 = i40;
                        i12 = i20;
                        i13 = virtualChildCount;
                        i14 = mode2;
                        i15 = i24;
                        i17 = iP;
                    } else {
                        int i42 = i20;
                        if (((ViewGroup.MarginLayoutParams) aVar3).height != 0 || f8 <= 0.0f) {
                            i10 = Integer.MIN_VALUE;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = -2;
                            i10 = 0;
                        }
                        i11 = i40;
                        int i43 = i10;
                        i12 = i42;
                        int i44 = i21;
                        i13 = virtualChildCount;
                        i14 = mode2;
                        i15 = i24;
                        i16 = i22;
                        i17 = iP;
                        w(viewS4, iP, i3, 0, i4, f9 == 0.0f ? this.f626g : 0);
                        if (i43 != Integer.MIN_VALUE) {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = i43;
                        }
                        int measuredHeight2 = viewS4.getMeasuredHeight();
                        int i45 = this.f626g;
                        view = viewS4;
                        this.f626g = Math.max(i45, i45 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin + r(view));
                        iMax2 = z5 ? Math.max(measuredHeight2, i44) : i44;
                    }
                    if (i18 >= 0 && i18 == i17 + 1) {
                        this.f623d = this.f626g;
                    }
                    if (i17 < i18 && aVar3.f636a > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((ViewGroup.MarginLayoutParams) aVar3).width != -1) {
                        z4 = false;
                    } else {
                        z4 = true;
                        z7 = true;
                    }
                    int i46 = ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i46;
                    int iMax8 = Math.max(i12, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i11, view.getMeasuredState());
                    z8 = z8 && ((ViewGroup.MarginLayoutParams) aVar3).width == -1;
                    if (aVar3.f636a > 0.0f) {
                        if (!z4) {
                            i46 = measuredWidth2;
                        }
                        iMax4 = Math.max(i15, i46);
                        iMax3 = i16;
                    } else {
                        if (!z4) {
                            i46 = measuredWidth2;
                        }
                        iMax3 = Math.max(i16, i46);
                        iMax4 = i15;
                    }
                    int iP3 = p(view, i17) + i17;
                    i21 = iMax2;
                    f3 = f9;
                    i22 = iMax3;
                    i19 = iCombineMeasuredStates2;
                    iP = iP3;
                    i20 = iMax8;
                }
            }
            iP++;
            mode2 = i14;
            virtualChildCount = i13;
        }
    }

    public i0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i0(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f621b = true;
        this.f622c = -1;
        this.f623d = 0;
        this.f625f = 8388659;
        int[] iArr = a.j.LinearLayoutCompat;
        w0 w0VarV = w0.v(context, attributeSet, iArr, i3, 0);
        e0.t.k0(this, context, iArr, attributeSet, w0VarV.r(), i3, 0);
        int iK = w0VarV.k(a.j.LinearLayoutCompat_android_orientation, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = w0VarV.k(a.j.LinearLayoutCompat_android_gravity, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = w0VarV.a(a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f627h = w0VarV.i(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f622c = w0VarV.k(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f628i = w0VarV.a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(w0VarV.g(a.j.LinearLayoutCompat_divider));
        this.f634o = w0VarV.k(a.j.LinearLayoutCompat_showDividers, 0);
        this.f635p = w0VarV.f(a.j.LinearLayoutCompat_dividerPadding, 0);
        w0VarV.w();
    }

    /* JADX INFO: compiled from: LinearLayoutCompat.java */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f637b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f637b = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.f636a = typedArrayObtainStyledAttributes.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f637b = typedArrayObtainStyledAttributes.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(int i3, int i4) {
            super(i3, i4);
            this.f637b = -1;
            this.f636a = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f637b = -1;
        }
    }
}
