package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialogLayout extends i0 {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    private void A(View view, int i3, int i4, int i5, int i6) {
        view.layout(i3, i4, i5 + i3, i6 + i4);
    }

    private static int B(View view) {
        int iC = e0.t.C(view);
        if (iC > 0) {
            return iC;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return B(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean C(int i3, int i4) {
        int iCombineMeasuredStates;
        int iB;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == a.f.topPanel) {
                    view = childAt;
                } else if (id == a.f.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != a.f.contentPanel && id != a.f.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i3, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i3, 0);
            iB = B(view2);
            measuredHeight = view2.getMeasuredHeight() - iB;
            paddingTop += iB;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iB = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i3, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i6 = size - paddingTop;
        if (view2 != null) {
            int i7 = paddingTop - iB;
            int iMin = Math.min(i6, measuredHeight);
            if (iMin > 0) {
                i6 -= iMin;
                iB += iMin;
            }
            view2.measure(i3, View.MeasureSpec.makeMeasureSpec(iB, 1073741824));
            paddingTop = i7 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i6 > 0) {
            view3.measure(i3, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i6, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = getChildAt(i8);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i3, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i4, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        l(childCount, i4);
        return true;
    }

    private void l(int i3, int i4) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i5 = 0; i5 < i3; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                i0.a aVar = (i0.a) childAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i6 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i4, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i6;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int paddingLeft = getPaddingLeft();
        int i10 = i5 - i3;
        int paddingRight = i10 - getPaddingRight();
        int paddingRight2 = (i10 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i11 = gravity & 112;
        int i12 = gravity & 8388615;
        int paddingTop = i11 != 16 ? i11 != 80 ? getPaddingTop() : ((getPaddingTop() + i6) - i4) - measuredHeight : getPaddingTop() + (((i6 - i4) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                i0.a aVar = (i0.a) childAt.getLayoutParams();
                int i14 = aVar.f637b;
                if (i14 < 0) {
                    i14 = i12;
                }
                int iB = e0.d.b(i14, e0.t.B(this)) & 7;
                if (iB != 1) {
                    if (iB != 5) {
                        i9 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    } else {
                        i7 = paddingRight - measuredWidth;
                        i8 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    }
                    if (t(i13)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i15 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    A(childAt, i9, i15, measuredWidth, measuredHeight2);
                    paddingTop = i15 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                } else {
                    i7 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                    i8 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                }
                i9 = i7 - i8;
                if (t(i13)) {
                    paddingTop += intrinsicHeight;
                }
                int i16 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                A(childAt, i9, i16, measuredWidth, measuredHeight2);
                paddingTop = i16 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            }
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (C(i3, i4)) {
            return;
        }
        super.onMeasure(i3, i4);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
