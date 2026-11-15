package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends i0 implements androidx.appcompat.view.menu.e.b, androidx.appcompat.view.menu.k {
    private int A;
    e B;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f359q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f360r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f361s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f362t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private androidx.appcompat.widget.c f363u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private androidx.appcompat.view.menu.j.a f364v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    androidx.appcompat.view.menu.e.a f365w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f366x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f367y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f368z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements androidx.appcompat.view.menu.j.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    public static class c extends i0.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f371e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f372f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f373g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f374h;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f369c = cVar.f369c;
        }

        public c(int i3, int i4) {
            super(i3, i4);
            this.f369c = false;
        }
    }

    private class d implements androidx.appcompat.view.menu.e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.B;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.e.a aVar = ActionMenuView.this.f365w;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    static int L(View view, int i3, int i4, int i5, int i6) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5) - i6, View.MeasureSpec.getMode(i5));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.f();
        int i7 = 2;
        if (i4 <= 0 || (z2 && i4 < 2)) {
            i7 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i4 * i3, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i8 = measuredWidth / i3;
            if (measuredWidth % i3 != 0) {
                i8++;
            }
            if (!z2 || i8 >= 2) {
                i7 = i8;
            }
        }
        cVar.f372f = !cVar.f369c && z2;
        cVar.f370d = i7;
        view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i7, 1073741824), iMakeMeasureSpec);
        return i7;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void M(int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        boolean z3;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingTop, -2);
        int i7 = size - paddingLeft;
        int i8 = this.f368z;
        int i9 = i7 / i8;
        int i10 = i7 % i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i11 = i8 + (i10 / i9);
        int childCount = getChildCount();
        int iMax = 0;
        int i12 = 0;
        boolean z4 = false;
        int i13 = 0;
        int iMax2 = 0;
        int i14 = 0;
        long j3 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            int i15 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i16 = i13 + 1;
                if (z5) {
                    int i17 = this.A;
                    r14 = 0;
                    childAt.setPadding(i17, 0, i17, 0);
                } else {
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f374h = r14;
                cVar.f371e = r14;
                cVar.f370d = r14;
                cVar.f372f = r14;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = r14;
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = r14;
                cVar.f373g = z5 && ((ActionMenuItemView) childAt).f();
                int iL = L(childAt, i11, cVar.f369c ? 1 : i9, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                if (cVar.f372f) {
                    i14++;
                }
                if (cVar.f369c) {
                    z4 = true;
                }
                i9 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j3 |= (long) (1 << i12);
                    iMax = iMax;
                }
                i13 = i16;
            }
            i12++;
            size2 = i15;
        }
        int i18 = size2;
        boolean z6 = z4 && i13 == 2;
        boolean z7 = false;
        while (true) {
            if (i14 <= 0 || i9 <= 0) {
                z2 = z7;
                i5 = iMax;
                break;
            }
            int i19 = Integer.MAX_VALUE;
            int i20 = 0;
            int i21 = 0;
            long j4 = 0;
            while (i21 < childCount) {
                boolean z8 = z7;
                c cVar2 = (c) getChildAt(i21).getLayoutParams();
                int i22 = iMax;
                if (cVar2.f372f) {
                    int i23 = cVar2.f370d;
                    if (i23 < i19) {
                        j4 = 1 << i21;
                        i19 = i23;
                        i20 = 1;
                    } else if (i23 == i19) {
                        i20++;
                        j4 |= 1 << i21;
                    }
                }
                i21++;
                iMax = i22;
                z7 = z8;
            }
            z2 = z7;
            i5 = iMax;
            j3 |= j4;
            if (i20 > i9) {
                break;
            }
            int i24 = i19 + 1;
            int i25 = 0;
            while (i25 < childCount) {
                View childAt2 = getChildAt(i25);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i26 = i7;
                int i27 = mode;
                long j5 = 1 << i25;
                if ((j4 & j5) == 0) {
                    if (cVar3.f370d == i24) {
                        j3 |= j5;
                    }
                    z6 = z6;
                } else {
                    if (z6 && cVar3.f373g && i9 == 1) {
                        int i28 = this.A;
                        childAt2.setPadding(i28 + i11, 0, i28, 0);
                    }
                    cVar3.f370d++;
                    cVar3.f374h = true;
                    i9--;
                }
                i25++;
                mode = i27;
                i7 = i26;
                z6 = z6;
            }
            iMax = i5;
            z7 = true;
        }
        boolean z9 = !z4 && i13 == 1;
        if (i9 <= 0 || j3 == 0 || (i9 >= i13 - 1 && !z9 && iMax2 <= 1)) {
            i6 = 0;
            z3 = z2;
        } else {
            float fBitCount = Long.bitCount(j3);
            if (z9) {
                i6 = 0;
            } else {
                i6 = 0;
                if ((j3 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f373g) {
                    fBitCount -= 0.5f;
                }
                int i29 = childCount - 1;
                if ((j3 & ((long) (1 << i29))) != 0 && !((c) getChildAt(i29).getLayoutParams()).f373g) {
                    fBitCount -= 0.5f;
                }
            }
            int i30 = fBitCount > 0.0f ? (int) ((i9 * i11) / fBitCount) : i6;
            z3 = z2;
            for (int i31 = i6; i31 < childCount; i31++) {
                if ((j3 & ((long) (1 << i31))) != 0) {
                    View childAt3 = getChildAt(i31);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f371e = i30;
                        cVar4.f374h = true;
                        if (i31 == 0 && !cVar4.f373g) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = (-i30) / 2;
                        }
                        z3 = true;
                    } else if (cVar4.f369c) {
                        cVar4.f371e = i30;
                        cVar4.f374h = true;
                        ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = (-i30) / 2;
                        z3 = true;
                    } else {
                        if (i31 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = i30 / 2;
                        }
                        if (i31 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = i30 / 2;
                        }
                    }
                }
            }
        }
        if (z3) {
            for (int i32 = i6; i32 < childCount; i32++) {
                View childAt4 = getChildAt(i32);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f374h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f370d * i11) + cVar5.f371e, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i7, mode != 1073741824 ? i5 : i18);
    }

    public void B() {
        androidx.appcompat.widget.c cVar = this.f363u;
        if (cVar != null) {
            cVar.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.f637b = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.f637b <= 0) {
            cVar.f637b = 16;
        }
        return cVar;
    }

    public c F() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f369c = true;
        return cVarGenerateDefaultLayoutParams;
    }

    protected boolean G(int i3) {
        boolean zA = false;
        if (i3 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i3 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i3);
        if (i3 < getChildCount() && (childAt instanceof a)) {
            zA = false | ((a) childAt).a();
        }
        return (i3 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).b();
    }

    public boolean H() {
        androidx.appcompat.widget.c cVar = this.f363u;
        return cVar != null && cVar.B();
    }

    public boolean I() {
        androidx.appcompat.widget.c cVar = this.f363u;
        return cVar != null && cVar.D();
    }

    public boolean J() {
        androidx.appcompat.widget.c cVar = this.f363u;
        return cVar != null && cVar.E();
    }

    public boolean K() {
        return this.f362t;
    }

    public androidx.appcompat.view.menu.e N() {
        return this.f359q;
    }

    public void O(androidx.appcompat.view.menu.j.a aVar, androidx.appcompat.view.menu.e.a aVar2) {
        this.f364v = aVar;
        this.f365w = aVar2;
    }

    public boolean P() {
        androidx.appcompat.widget.c cVar = this.f363u;
        return cVar != null && cVar.K();
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(androidx.appcompat.view.menu.g gVar) {
        return this.f359q.L(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(androidx.appcompat.view.menu.e eVar) {
        this.f359q = eVar;
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f359q == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.f359q = eVar;
            eVar.R(new d());
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.f363u = cVar;
            cVar.J(true);
            androidx.appcompat.widget.c cVar2 = this.f363u;
            androidx.appcompat.view.menu.j.a bVar = this.f364v;
            if (bVar == null) {
                bVar = new b();
            }
            cVar2.h(bVar);
            this.f359q.c(this.f363u, this.f360r);
            this.f363u.H(this);
        }
        return this.f359q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f363u.A();
    }

    public int getPopupTheme() {
        return this.f361s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.f363u;
        if (cVar != null) {
            cVar.j(false);
            if (this.f363u.E()) {
                this.f363u.B();
                this.f363u.K();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int width;
        int paddingLeft;
        if (!this.f366x) {
            super.onLayout(z2, i3, i4, i5, i6);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i6 - i4) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i5 - i3;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zB = c1.b(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f369c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    G(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int iMax = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f369c) {
                    int i17 = width2 - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f369c) {
                int i20 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft2 = i20 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.View
    protected void onMeasure(int i3, int i4) {
        androidx.appcompat.view.menu.e eVar;
        boolean z2 = this.f366x;
        boolean z3 = View.MeasureSpec.getMode(i3) == 1073741824;
        this.f366x = z3;
        if (z2 != z3) {
            this.f367y = 0;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (this.f366x && (eVar = this.f359q) != null && size != this.f367y) {
            this.f367y = size;
            eVar.K(true);
        }
        int childCount = getChildCount();
        if (this.f366x && childCount > 0) {
            M(i3, i4);
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            c cVar = (c) getChildAt(i5).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i3, i4);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f363u.G(z2);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f363u.I(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.f362t = z2;
    }

    public void setPopupTheme(int i3) {
        if (this.f361s != i3) {
            this.f361s = i3;
            if (i3 == 0) {
                this.f360r = getContext();
            } else {
                this.f360r = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.f363u = cVar;
        cVar.H(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f368z = (int) (56.0f * f3);
        this.A = (int) (f3 * 4.0f);
        this.f360r = context;
        this.f361s = 0;
    }
}
