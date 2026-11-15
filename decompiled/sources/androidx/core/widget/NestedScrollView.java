package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import e0.m;
import e0.o;
import e0.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements m, e0.j {
    private static final a B = new a();
    private static final int[] C = {R.attr.fillViewport};
    private b A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f1154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OverScroller f1155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private EdgeEffect f1156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EdgeEffect f1157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f1161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f1163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1165n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1166o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1167p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1168q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1169r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int[] f1170s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int[] f1171t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1172u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f1173v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private c f1174w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final o f1175x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final e0.k f1176y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f1177z;

    static class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            f0.f.a(accessibilityEvent, nestedScrollView.getScrollX());
            f0.f.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            int scrollRange;
            super.g(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.X(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.p0(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.b(f0.d.a.f4655r);
                dVar.b(f0.d.a.C);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.b(f0.d.a.f4654q);
                dVar.b(f0.d.a.E);
            }
        }

        @Override // e0.a
        public boolean j(View view, int i3, Bundle bundle) {
            if (super.j(view, i3, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i3 != 4096) {
                if (i3 == 8192 || i3 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.O(0, iMax, true);
                    return true;
                }
                if (i3 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.O(0, iMin, true);
            return true;
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6);
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1178b;

        class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1178b + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f1178b);
        }

        c(Parcel parcel) {
            super(parcel);
            this.f1178b = parcel.readInt();
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    private static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    private boolean B(View view, int i3, int i4) {
        view.getDrawingRect(this.f1154c);
        offsetDescendantRectToMyCoords(view, this.f1154c);
        return this.f1154c.bottom + i3 >= getScrollY() && this.f1154c.top - i3 <= getScrollY() + i4;
    }

    private void C(int i3, int i4, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i3);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1176y.e(0, scrollY2, 0, i3 - scrollY2, null, i4, iArr);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1169r) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f1158g = (int) motionEvent.getY(i3);
            this.f1169r = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f1163l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.f1163l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1163l = null;
        }
    }

    private void H(boolean z2) {
        if (z2) {
            P(2, 1);
        } else {
            Q(1);
        }
        this.f1173v = getScrollY();
        t.d0(this);
    }

    private boolean I(int i3, int i4, int i5) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i3 == 33;
        View viewR = r(z3, i4, i5);
        if (viewR == null) {
            viewR = this;
        }
        if (i4 < scrollY || i5 > i6) {
            k(z3 ? i4 - scrollY : i5 - i6);
            z2 = true;
        }
        if (viewR != findFocus()) {
            viewR.requestFocus(i3);
        }
        return z2;
    }

    private void J(View view) {
        view.getDrawingRect(this.f1154c);
        offsetDescendantRectToMyCoords(view, this.f1154c);
        int iE = e(this.f1154c);
        if (iE != 0) {
            scrollBy(0, iE);
        }
    }

    private boolean K(Rect rect, boolean z2) {
        int iE = e(rect);
        boolean z3 = iE != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, iE);
            } else {
                L(0, iE);
            }
        }
        return z3;
    }

    private void M(int i3, int i4, int i5, boolean z2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1153b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f1155d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i4 + scrollY, Math.max(0, height - height2))) - scrollY, i5);
            H(z2);
        } else {
            if (!this.f1155d.isFinished()) {
                a();
            }
            scrollBy(i3, i4);
        }
        this.f1153b = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a() {
        this.f1155d.abortAnimation();
        Q(1);
    }

    private boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int d(int i3, int i4, int i5) {
        if (i4 >= i5 || i3 < 0) {
            return 0;
        }
        return i4 + i3 > i5 ? i5 - i4 : i3;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1177z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1177z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1177z;
    }

    private void k(int i3) {
        if (i3 != 0) {
            if (this.f1165n) {
                L(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    private void l() {
        this.f1162k = false;
        G();
        Q(0);
        EdgeEffect edgeEffect = this.f1156e;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f1157f.onRelease();
        }
    }

    private void p() {
        if (getOverScrollMode() == 2) {
            this.f1156e = null;
            this.f1157f = null;
        } else if (this.f1156e == null) {
            Context context = getContext();
            this.f1156e = new EdgeEffect(context);
            this.f1157f = new EdgeEffect(context);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    private View r(boolean z2, int i3, int i4) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i4) {
                boolean z4 = i3 < top && bottom < i4;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4 && z5) {
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean v(int i3, int i4) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i4 >= childAt.getTop() - scrollY && i4 < childAt.getBottom() - scrollY && i3 >= childAt.getLeft() && i3 < childAt.getRight();
    }

    private void w() {
        VelocityTracker velocityTracker = this.f1163l;
        if (velocityTracker == null) {
            this.f1163l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        this.f1155d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1166o = viewConfiguration.getScaledTouchSlop();
        this.f1167p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1168q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void y() {
        if (this.f1163l == null) {
            this.f1163l = VelocityTracker.obtain();
        }
    }

    private boolean z(View view) {
        return !B(view, 0, getHeight());
    }

    boolean E(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2) {
        boolean z3;
        boolean z4;
        int overScrollMode = getOverScrollMode();
        boolean z5 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z6 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && z6);
        int i11 = i5 + i3;
        int i12 = !z7 ? 0 : i9;
        int i13 = i6 + i4;
        int i14 = !z8 ? 0 : i10;
        int i15 = -i12;
        int i16 = i12 + i7;
        int i17 = -i14;
        int i18 = i14 + i8;
        if (i11 > i16) {
            i11 = i16;
            z3 = true;
        } else if (i11 < i15) {
            z3 = true;
            i11 = i15;
        } else {
            z3 = false;
        }
        if (i13 > i18) {
            i13 = i18;
            z4 = true;
        } else if (i13 < i17) {
            z4 = true;
            i13 = i17;
        } else {
            z4 = false;
        }
        if (z4 && !u(1)) {
            this.f1155d.springBack(i11, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i11, i13, z3, z4);
        return z3 || z4;
    }

    public boolean F(int i3) {
        boolean z2 = i3 == 130;
        int height = getHeight();
        if (z2) {
            this.f1154c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f1154c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f1154c.top = getScrollY() - height;
            Rect rect2 = this.f1154c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f1154c;
        int i4 = rect3.top;
        int i5 = height + i4;
        rect3.bottom = i5;
        return I(i3, i4, i5);
    }

    public final void L(int i3, int i4) {
        M(i3, i4, 250, false);
    }

    void N(int i3, int i4, int i5, boolean z2) {
        M(i3 - getScrollX(), i4 - getScrollY(), i5, z2);
    }

    void O(int i3, int i4, boolean z2) {
        N(i3, i4, 250, z2);
    }

    public boolean P(int i3, int i4) {
        return this.f1176y.p(i3, i4);
    }

    public void Q(int i3) {
        this.f1176y.r(i3);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean b(int i3) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !B(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            k(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f1154c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f1154c);
            k(e(this.f1154c));
            viewFindNextFocus.requestFocus(i3);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !z(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f1155d.isFinished()) {
            return;
        }
        this.f1155d.computeScrollOffset();
        int currY = this.f1155d.getCurrY();
        int i3 = currY - this.f1173v;
        this.f1173v = currY;
        int[] iArr = this.f1171t;
        boolean z2 = false;
        iArr[1] = 0;
        f(0, i3, iArr, null, 1);
        int i4 = i3 - this.f1171t[1];
        int scrollRange = getScrollRange();
        if (i4 != 0) {
            int scrollY = getScrollY();
            E(0, i4, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i5 = i4 - scrollY2;
            int[] iArr2 = this.f1171t;
            iArr2[1] = 0;
            g(0, scrollY2, 0, i5, this.f1170s, 1, iArr2);
            i4 = i5 - this.f1171t[1];
        }
        if (i4 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z2 = true;
            }
            if (z2) {
                p();
                if (i4 < 0) {
                    if (this.f1156e.isFinished()) {
                        this.f1156e.onAbsorb((int) this.f1155d.getCurrVelocity());
                    }
                } else if (this.f1157f.isFinished()) {
                    this.f1157f.onAbsorb((int) this.f1155d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f1155d.isFinished()) {
            Q(1);
        } else {
            t.d0(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z2) {
        return this.f1176y.a(f3, f4, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return this.f1176y.b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return f(i3, i4, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return this.f1176y.f(i3, i4, i5, i6, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f1156e != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f1156e.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (i3 >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f1156e.setSize(width, height);
                if (this.f1156e.draw(canvas)) {
                    t.d0(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f1157f.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (i4 >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f1157f.setSize(width2, height2);
            if (this.f1157f.draw(canvas)) {
                t.d0(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    protected int e(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        int i5 = rect.bottom;
        if (i5 > i4 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i4) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || i5 >= i4) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i4 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public boolean f(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return this.f1176y.d(i3, i4, iArr, iArr2, i5);
    }

    public void g(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        this.f1176y.e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1175x.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // e0.l
    public void h(View view, View view2, int i3, int i4) {
        this.f1175x.c(view, view2, i3, i4);
        P(2, i4);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    @Override // e0.l
    public void i(View view, int i3) {
        this.f1175x.d(view, i3);
        Q(i3);
    }

    @Override // android.view.View, e0.j
    public boolean isNestedScrollingEnabled() {
        return this.f1176y.l();
    }

    @Override // e0.l
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        f(i3, i4, iArr, null, i5);
    }

    @Override // e0.m
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        C(i6, i7, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i3, int i4) {
        view.measure(FrameLayout.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // e0.l
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        C(i6, i7, null);
    }

    @Override // e0.l
    public boolean o(View view, View view2, int i3, int i4) {
        return (i3 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1160i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f1162k) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY - verticalScrollFactorCompat;
                if (i3 < 0) {
                    scrollRange = 0;
                } else if (i3 <= scrollRange) {
                    scrollRange = i3;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    /* JADX WARN: Code duplicated, block: B:33:0x009b  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f1162k) {
            return true;
        }
        int i3 = action & 255;
        if (i3 == 0) {
            int y3 = (int) motionEvent.getY();
            if (v((int) motionEvent.getX(), y3)) {
                this.f1158g = y3;
                this.f1169r = motionEvent.getPointerId(0);
                w();
                this.f1163l.addMovement(motionEvent);
                this.f1155d.computeScrollOffset();
                this.f1162k = !this.f1155d.isFinished();
                P(2, 0);
            } else {
                this.f1162k = false;
                G();
            }
        } else if (i3 == 1) {
            this.f1162k = false;
            this.f1169r = -1;
            G();
            if (this.f1155d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                t.d0(this);
            }
            Q(0);
        } else if (i3 == 2) {
            int i4 = this.f1169r;
            if (i4 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i4);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i4 + " in onInterceptTouchEvent");
                } else {
                    int y4 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y4 - this.f1158g) > this.f1166o && (2 & getNestedScrollAxes()) == 0) {
                        this.f1162k = true;
                        this.f1158g = y4;
                        y();
                        this.f1163l.addMovement(motionEvent);
                        this.f1172u = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i3 == 3) {
            this.f1162k = false;
            this.f1169r = -1;
            G();
            if (this.f1155d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                t.d0(this);
            }
            Q(0);
        } else if (i3 == 6) {
            D(motionEvent);
        }
        return this.f1162k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        int measuredHeight = 0;
        this.f1159h = false;
        View view = this.f1161j;
        if (view != null && A(view, this)) {
            J(this.f1161j);
        }
        this.f1161j = null;
        if (!this.f1160i) {
            if (this.f1174w != null) {
                scrollTo(getScrollX(), this.f1174w.f1178b);
                this.f1174w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iD = d(scrollY, paddingTop, measuredHeight);
            if (iD != scrollY) {
                scrollTo(getScrollX(), iD);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1160i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f1164m && View.MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f4, true);
        s((int) f4);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return dispatchNestedPreFling(f3, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        j(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        C(i6, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        h(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i3, int i4, boolean z2, boolean z3) {
        super.scrollTo(i3, i4);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i3) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        if (viewFindNextFocus == null || z(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f1174w = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f1178b = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i4, int i5, int i6) {
        super.onScrollChanged(i3, i4, i5, i6);
        b bVar = this.A;
        if (bVar != null) {
            bVar.a(this, i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !B(viewFindFocus, 0, i6)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f1154c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f1154c);
        k(e(this.f1154c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return o(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        y();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1172u = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f1172u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f1163l;
                velocityTracker.computeCurrentVelocity(1000, this.f1168q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f1169r);
                if (Math.abs(yVelocity) >= this.f1167p) {
                    int i3 = -yVelocity;
                    float f3 = i3;
                    if (!dispatchNestedPreFling(0.0f, f3)) {
                        dispatchNestedFling(0.0f, f3, true);
                        s(i3);
                    }
                } else if (this.f1155d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    t.d0(this);
                }
                this.f1169r = -1;
                l();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1169r);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f1169r + " in onTouchEvent");
                } else {
                    int y3 = (int) motionEvent.getY(iFindPointerIndex);
                    int i4 = this.f1158g - y3;
                    if (!this.f1162k && Math.abs(i4) > this.f1166o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1162k = true;
                        i4 = i4 > 0 ? i4 - this.f1166o : i4 + this.f1166o;
                    }
                    int i5 = i4;
                    if (this.f1162k) {
                        if (f(0, i5, this.f1171t, this.f1170s, 0)) {
                            i5 -= this.f1171t[1];
                            this.f1172u += this.f1170s[1];
                        }
                        int i6 = i5;
                        this.f1158g = y3 - this.f1170s[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (E(0, i6, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !u(0)) {
                            this.f1163l.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f1171t;
                        iArr[1] = 0;
                        g(0, scrollY2, 0, i6 - scrollY2, this.f1170s, 0, iArr);
                        int i7 = this.f1158g;
                        int[] iArr2 = this.f1170s;
                        this.f1158g = i7 - iArr2[1];
                        this.f1172u += iArr2[1];
                        if (z2) {
                            int i8 = i6 - this.f1171t[1];
                            p();
                            int i9 = scrollY + i8;
                            if (i9 < 0) {
                                d.a(this.f1156e, i8 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.f1157f.isFinished()) {
                                    this.f1157f.onRelease();
                                }
                            } else if (i9 > scrollRange) {
                                d.a(this.f1157f, i8 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.f1156e.isFinished()) {
                                    this.f1156e.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f1156e;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f1157f.isFinished())) {
                                t.d0(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f1162k && getChildCount() > 0 && this.f1155d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    t.d0(this);
                }
                this.f1169r = -1;
                l();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f1158g = (int) motionEvent.getY(actionIndex);
                this.f1169r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                D(motionEvent);
                this.f1158g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1169r));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z3 = !this.f1155d.isFinished();
            this.f1162k = z3;
            if (z3 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f1155d.isFinished()) {
                a();
            }
            this.f1158g = (int) motionEvent.getY();
            this.f1169r = motionEvent.getPointerId(0);
            P(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f1163l;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public boolean q(KeyEvent keyEvent) {
        this.f1154c.setEmpty();
        if (!c()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? b(33) : t(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? b(130) : t(130);
        }
        if (keyCode != 62) {
            return false;
        }
        F(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f1159h) {
            this.f1161j = view2;
        } else {
            J(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return K(rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1159h = true;
        super.requestLayout();
    }

    public void s(int i3) {
        if (getChildCount() > 0) {
            this.f1155d.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iD = d(i3, width, width2);
            int iD2 = d(i4, height, height2);
            if (iD == getScrollX() && iD2 == getScrollY()) {
                return;
            }
            super.scrollTo(iD, iD2);
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.f1164m) {
            this.f1164m = z2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f1176y.m(z2);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.A = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.f1165n = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return P(i3, 0);
    }

    @Override // android.view.View, e0.j
    public void stopNestedScroll() {
        Q(0);
    }

    public boolean t(int i3) {
        int childCount;
        boolean z2 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f1154c;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f1154c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f1154c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f1154c;
        return I(i3, rect3.top, rect3.bottom);
    }

    public boolean u(int i3) {
        return this.f1176y.k(i3);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1154c = new Rect();
        this.f1159h = true;
        this.f1160i = false;
        this.f1161j = null;
        this.f1162k = false;
        this.f1165n = true;
        this.f1169r = -1;
        this.f1170s = new int[2];
        this.f1171t = new int[2];
        x();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C, i3, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f1175x = new o(this);
        this.f1176y = new e0.k(this);
        setNestedScrollingEnabled(true);
        t.m0(this, B);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i3);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
