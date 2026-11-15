package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: DropDownListView.java */
/* JADX INFO: loaded from: classes.dex */
class f0 extends ListView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Field f589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f592k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f593l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e0.x f594m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private androidx.core.widget.f f595n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    b f596o;

    /* JADX INFO: compiled from: DropDownListView.java */
    private static class a extends d.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f597c;

        a(Drawable drawable) {
            super(drawable);
            this.f597c = true;
        }

        void c(boolean z2) {
            this.f597c = z2;
        }

        @Override // d.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f597c) {
                super.draw(canvas);
            }
        }

        @Override // d.c, android.graphics.drawable.Drawable
        public void setHotspot(float f3, float f4) {
            if (this.f597c) {
                super.setHotspot(f3, f4);
            }
        }

        @Override // d.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i3, int i4, int i5, int i6) {
            if (this.f597c) {
                super.setHotspotBounds(i3, i4, i5, i6);
            }
        }

        @Override // d.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f597c) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // d.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f597c) {
                return super.setVisible(z2, z3);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: DropDownListView.java */
    private class b implements Runnable {
        b() {
        }

        public void a() {
            f0 f0Var = f0.this;
            f0Var.f596o = null;
            f0Var.removeCallbacks(this);
        }

        public void b() {
            f0.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = f0.this;
            f0Var.f596o = null;
            f0Var.drawableStateChanged();
        }
    }

    f0(Context context, boolean z2) {
        super(context, null, a.a.dropDownListViewStyle);
        this.f583b = new Rect();
        this.f584c = 0;
        this.f585d = 0;
        this.f586e = 0;
        this.f587f = 0;
        this.f592k = z2;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f589h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    private void a() {
        this.f593l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f588g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        e0.x xVar = this.f594m;
        if (xVar != null) {
            xVar.b();
            this.f594m = null;
        }
    }

    private void b(View view, int i3) {
        performItemClick(view, i3, getItemIdAtPosition(i3));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f583b.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f583b);
        selector.draw(canvas);
    }

    private void f(int i3, View view) {
        Rect rect = this.f583b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f584c;
        rect.top -= this.f585d;
        rect.right += this.f586e;
        rect.bottom += this.f587f;
        try {
            boolean z2 = this.f589h.getBoolean(this);
            if (view.isEnabled() != z2) {
                this.f589h.set(this, Boolean.valueOf(!z2));
                if (i3 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    private void g(int i3, View view) {
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i3 == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        f(i3, view);
        if (z2) {
            Rect rect = this.f583b;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            x.a.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i3, View view, float f3, float f4) {
        g(i3, view);
        Drawable selector = getSelector();
        if (selector == null || i3 == -1) {
            return;
        }
        x.a.k(selector, f3, f4);
    }

    private void i(View view, int i3, float f3, float f4) {
        View childAt;
        this.f593l = true;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            drawableHotspotChanged(f3, f4);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i5 = this.f588g;
        if (i5 != -1 && (childAt = getChildAt(i5 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f588g = i3;
        float left = f3 - view.getLeft();
        float top = f4 - view.getTop();
        if (i4 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i3, view, f3, f4);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return this.f593l;
    }

    private void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z2) {
        a aVar = this.f590i;
        if (aVar != null) {
            aVar.c(z2);
        }
    }

    public int d(int i3, int i4, int i5, int i6, int i7) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        View view = null;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i11 = layoutParams.height;
            view.measure(i3, i11 > 0 ? View.MeasureSpec.makeMeasureSpec(i11, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i6) {
                return (i7 < 0 || i8 <= i7 || i10 <= 0 || measuredHeight == i6) ? i6 : i10;
            }
            if (i7 >= 0 && i8 >= i7) {
                i10 = measuredHeight;
            }
            i8++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f596o != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        k();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    public boolean e(MotionEvent motionEvent, int i3) {
        boolean z2;
        boolean z3;
        androidx.core.widget.f fVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z2 = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z3 = false;
                    z2 = true;
                } else {
                    z3 = false;
                    z2 = false;
                }
                if (z2 || z3) {
                    a();
                }
                if (z2) {
                    if (this.f595n == null) {
                        this.f595n = new androidx.core.widget.f(this);
                    }
                    this.f595n.m(true);
                    this.f595n.onTouch(this, motionEvent);
                } else {
                    fVar = this.f595n;
                    if (fVar != null) {
                        fVar.m(false);
                    }
                }
                return z2;
            }
            z2 = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i3);
        if (iFindPointerIndex < 0) {
            z3 = false;
            z2 = false;
        } else {
            int x3 = (int) motionEvent.getX(iFindPointerIndex);
            int y3 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x3, y3);
            if (iPointToPosition == -1) {
                z3 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                i(childAt, iPointToPosition, x3, y3);
                if (actionMasked == 1) {
                    b(childAt, iPointToPosition);
                }
                z3 = false;
                z2 = true;
            }
        }
        if (z2) {
            a();
        } else {
            a();
        }
        if (z2) {
            if (this.f595n == null) {
                this.f595n = new androidx.core.widget.f(this);
            }
            this.f595n.m(true);
            this.f595n.onTouch(this, motionEvent);
        } else {
            fVar = this.f595n;
            if (fVar != null) {
                fVar.m(false);
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f592k || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f592k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f592k || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f592k && this.f591j) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f596o = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f596o == null) {
            b bVar = new b();
            this.f596o = bVar;
            bVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f588g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f596o;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z2) {
        this.f591j = z2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f590i = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f584c = rect.left;
        this.f585d = rect.top;
        this.f586e = rect.right;
        this.f587f = rect.bottom;
    }
}
