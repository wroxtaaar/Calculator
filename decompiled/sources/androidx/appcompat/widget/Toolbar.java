package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private ColorStateList B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    f H;
    private final ActionMenuView.e I;
    private x0 J;
    private androidx.appcompat.widget.c K;
    private d L;
    private androidx.appcompat.view.menu.j.a M;
    private androidx.appcompat.view.menu.e.a N;
    private boolean O;
    private final Runnable P;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActionMenuView f468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageButton f471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CharSequence f474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ImageButton f475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    View f476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f480n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f481o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f482p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f483q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f484r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f485s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f486t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private o0 f487u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f488v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f489w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f490x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CharSequence f491y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CharSequence f492z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.H;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.N();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements androidx.appcompat.view.menu.j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.e f496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        androidx.appcompat.view.menu.g f497c;

        d() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void b(androidx.appcompat.view.menu.e eVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean d() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void e(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f496b;
            if (eVar2 != null && (gVar = this.f497c) != null) {
                eVar2.f(gVar);
            }
            this.f496b = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.f476j;
            if (callback instanceof g.c) {
                ((g.c) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f476j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f475i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f476j = null;
            toolbar3.a();
            this.f497c = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean g(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f475i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f475i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f475i);
            }
            Toolbar.this.f476j = gVar.getActionView();
            this.f497c = gVar;
            ViewParent parent2 = Toolbar.this.f476j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f476j);
                }
                e eVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                eVarGenerateDefaultLayoutParams.f2229a = 8388611 | (toolbar4.f481o & 112);
                eVarGenerateDefaultLayoutParams.f499b = 2;
                toolbar4.f476j.setLayoutParams(eVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f476j);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f476j;
            if (callback instanceof g.c) {
                ((g.c) callback).c();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean i(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void j(boolean z2) {
            if (this.f497c != null) {
                androidx.appcompat.view.menu.e eVar = this.f496b;
                boolean z3 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.f496b.getItem(i3) == this.f497c) {
                            z3 = true;
                            break;
                        }
                    }
                }
                if (z3) {
                    return;
                }
                f(this.f496b, this.f497c);
            }
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private int B(View view, int i3, int[] iArr, int i4) {
        e eVar = (e) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = i3 + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        int iQ = q(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int C(View view, int i3, int[] iArr, int i4) {
        e eVar = (e) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i3 - Math.max(0, i5);
        iArr[1] = Math.max(0, -i5);
        int iQ = q(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int D(View view, int i3, int i4, int i5, int i6, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = marginLayoutParams.leftMargin - iArr[0];
        int i8 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i7) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i7);
        iArr[1] = Math.max(0, -i8);
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + iMax + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void E(View view, int i3, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.P);
        post(this.P);
    }

    private boolean L() {
        if (!this.O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (M(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean M(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i3) {
        boolean z2 = e0.t.B(this) == 1;
        int childCount = getChildCount();
        int iB = e0.d.b(i3, e0.t.B(this));
        list.clear();
        if (!z2) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f499b == 0 && M(childAt) && p(eVar.f2229a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f499b == 0 && M(childAt2) && p(eVar2.f2229a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        e eVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            eVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        }
        eVarGenerateLayoutParams.f499b = 1;
        if (!z2 || this.f476j == null) {
            addView(view, eVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateLayoutParams);
            this.F.add(view);
        }
    }

    private MenuInflater getMenuInflater() {
        return new g.g(getContext());
    }

    private void h() {
        if (this.f487u == null) {
            this.f487u = new o0();
        }
    }

    private void i() {
        if (this.f472f == null) {
            this.f472f = new o(getContext());
        }
    }

    private void j() {
        k();
        if (this.f468b.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f468b.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f468b.setExpandedActionViewsExclusive(true);
            eVar.c(this.L, this.f477k);
        }
    }

    private void k() {
        if (this.f468b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f468b = actionMenuView;
            actionMenuView.setPopupTheme(this.f478l);
            this.f468b.setOnMenuItemClickListener(this.I);
            this.f468b.O(this.M, this.N);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f2229a = 8388613 | (this.f481o & 112);
            this.f468b.setLayoutParams(eVarGenerateDefaultLayoutParams);
            c(this.f468b, false);
        }
    }

    private void l() {
        if (this.f471e == null) {
            this.f471e = new m(getContext(), null, a.a.toolbarNavigationButtonStyle);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f2229a = 8388611 | (this.f481o & 112);
            this.f471e.setLayoutParams(eVarGenerateDefaultLayoutParams);
        }
    }

    private int p(int i3) {
        int iB = e0.t.B(this);
        int iB2 = e0.d.b(i3, iB) & 7;
        if (iB2 == 1 || iB2 == 3 || iB2 == 5) {
            return iB2;
        }
        return iB == 1 ? 5 : 3;
    }

    private int q(View view, int i3) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i3 > 0 ? (measuredHeight - i3) / 2 : 0;
        int iR = r(eVar.f2229a);
        if (iR == 48) {
            return getPaddingTop() - i4;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i4;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i5) {
            iMax = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i6 < i7) {
                iMax = Math.max(0, iMax - (i7 - i6));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i3) {
        int i4 = i3 & 112;
        return (i4 == 16 || i4 == 48 || i4 == 80) ? i4 : this.f490x & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return e0.g.b(marginLayoutParams) + e0.g.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i3 = iArr[0];
        int i4 = iArr[1];
        int size = list.size();
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            View view = list.get(i5);
            e eVar = (e) view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i3;
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i4;
            int iMax = Math.max(0, i6);
            int iMax2 = Math.max(0, i7);
            int iMax3 = Math.max(0, -i6);
            int iMax4 = Math.max(0, -i7);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i5++;
            i4 = iMax4;
            i3 = iMax3;
        }
        return measuredWidth;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f468b;
        return actionMenuView != null && actionMenuView.J();
    }

    void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f499b != 2 && childAt != this.f468b) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public void H(int i3, int i4) {
        h();
        this.f487u.g(i3, i4);
    }

    public void I(androidx.appcompat.view.menu.e eVar, androidx.appcompat.widget.c cVar) {
        if (eVar == null && this.f468b == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarN = this.f468b.N();
        if (eVarN == eVar) {
            return;
        }
        if (eVarN != null) {
            eVarN.O(this.K);
            eVarN.O(this.L);
        }
        if (this.L == null) {
            this.L = new d();
        }
        cVar.G(true);
        if (eVar != null) {
            eVar.c(cVar, this.f477k);
            eVar.c(this.L, this.f477k);
        } else {
            cVar.e(this.f477k, null);
            this.L.e(this.f477k, null);
            cVar.j(true);
            this.L.j(true);
        }
        this.f468b.setPopupTheme(this.f478l);
        this.f468b.setPresenter(cVar);
        this.K = cVar;
    }

    public void J(Context context, int i3) {
        this.f480n = i3;
        TextView textView = this.f470d;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public void K(Context context, int i3) {
        this.f479m = i3;
        TextView textView = this.f469c;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public boolean N() {
        ActionMenuView actionMenuView = this.f468b;
        return actionMenuView != null && actionMenuView.P();
    }

    void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f468b) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.L;
        androidx.appcompat.view.menu.g gVar = dVar == null ? null : dVar.f497c;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f468b;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f475i == null) {
            m mVar = new m(getContext(), null, a.a.toolbarNavigationButtonStyle);
            this.f475i = mVar;
            mVar.setImageDrawable(this.f473g);
            this.f475i.setContentDescription(this.f474h);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f2229a = 8388611 | (this.f481o & 112);
            eVarGenerateDefaultLayoutParams.f499b = 2;
            this.f475i.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f475i.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f475i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f475i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        o0 o0Var = this.f487u;
        if (o0Var != null) {
            return o0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i3 = this.f489w;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        o0 o0Var = this.f487u;
        if (o0Var != null) {
            return o0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        o0 o0Var = this.f487u;
        if (o0Var != null) {
            return o0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        o0 o0Var = this.f487u;
        if (o0Var != null) {
            return o0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i3 = this.f488v;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarN;
        ActionMenuView actionMenuView = this.f468b;
        return actionMenuView != null && (eVarN = actionMenuView.N()) != null && eVarN.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.f489w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return e0.t.B(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return e0.t.B(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f488v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f472f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f472f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f468b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f471e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f471e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f468b.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f477k;
    }

    public int getPopupTheme() {
        return this.f478l;
    }

    public CharSequence getSubtitle() {
        return this.f492z;
    }

    final TextView getSubtitleTextView() {
        return this.f470d;
    }

    public CharSequence getTitle() {
        return this.f491y;
    }

    public int getTitleMarginBottom() {
        return this.f486t;
    }

    public int getTitleMarginEnd() {
        return this.f484r;
    }

    public int getTitleMarginStart() {
        return this.f483q;
    }

    public int getTitleMarginTop() {
        return this.f485s;
    }

    final TextView getTitleTextView() {
        return this.f469c;
    }

    public d0 getWrapper() {
        if (this.J == null) {
            this.J = new x0(this, true);
        }
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof b.a.C0024a) {
            return new e((b.a.C0024a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0289  */
    /* JADX WARN: Code duplicated, block: B:102:0x028c  */
    /* JADX WARN: Code duplicated, block: B:105:0x029f A[LOOP:0: B:104:0x029d->B:105:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x02c1 A[LOOP:1: B:107:0x02bf->B:108:0x02c1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x02eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:114:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02fa A[LOOP:2: B:116:0x02f8->B:117:0x02fa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0078  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:40:0x0100  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:43:0x011d  */
    /* JADX WARN: Code duplicated, block: B:49:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0130  */
    /* JADX WARN: Code duplicated, block: B:53:0x0134  */
    /* JADX WARN: Code duplicated, block: B:54:0x0137  */
    /* JADX WARN: Code duplicated, block: B:57:0x0147  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x0168  */
    /* JADX WARN: Code duplicated, block: B:68:0x016c  */
    /* JADX WARN: Code duplicated, block: B:70:0x017e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0181  */
    /* JADX WARN: Code duplicated, block: B:73:0x018c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0198  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:80:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x021b  */
    /* JADX WARN: Code duplicated, block: B:89:0x021e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0229  */
    /* JADX WARN: Code duplicated, block: B:93:0x022d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0241  */
    /* JADX WARN: Code duplicated, block: B:97:0x0264  */
    /* JADX WARN: Code duplicated, block: B:99:0x0267  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int iB;
        int iC;
        int iMax;
        int iMin;
        boolean zM;
        boolean zM2;
        int measuredHeight;
        TextView textView;
        TextView textView2;
        e eVar;
        e eVar2;
        boolean z3;
        int i7;
        int i8;
        int paddingTop;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iMax2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int size;
        int i21;
        int i22;
        int size2;
        int i23;
        int i24;
        int i25;
        int size3;
        boolean z4 = e0.t.B(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i26 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int iC2 = e0.t.C(this);
        int iMin2 = iC2 >= 0 ? Math.min(iC2, i6 - i4) : 0;
        if (M(this.f471e)) {
            if (z4) {
                iC = C(this.f471e, i26, iArr, iMin2);
                iB = paddingLeft;
            } else {
                iB = B(this.f471e, paddingLeft, iArr, iMin2);
            }
            if (M(this.f475i)) {
                if (z4) {
                    iC = C(this.f475i, iC, iArr, iMin2);
                } else {
                    iB = B(this.f475i, iB, iArr, iMin2);
                }
            }
            if (M(this.f468b)) {
                if (z4) {
                    iB = B(this.f468b, iB, iArr, iMin2);
                } else {
                    iC = C(this.f468b, iC, iArr, iMin2);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iB);
            iArr[1] = Math.max(0, currentContentInsetRight - (i26 - iC));
            iMax = Math.max(iB, currentContentInsetLeft);
            iMin = Math.min(iC, i26 - currentContentInsetRight);
            if (M(this.f476j)) {
                if (z4) {
                    iMin = C(this.f476j, iMin, iArr, iMin2);
                } else {
                    iMax = B(this.f476j, iMax, iArr, iMin2);
                }
            }
            if (M(this.f472f)) {
                if (z4) {
                    iMin = C(this.f472f, iMin, iArr, iMin2);
                } else {
                    iMax = B(this.f472f, iMax, iArr, iMin2);
                }
            }
            zM = M(this.f469c);
            zM2 = M(this.f470d);
            if (zM) {
                e eVar3 = (e) this.f469c.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.f469c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin + 0;
            } else {
                measuredHeight = 0;
            }
            if (zM2) {
                e eVar4 = (e) this.f470d.getLayoutParams();
                measuredHeight += ((ViewGroup.MarginLayoutParams) eVar4).topMargin + this.f470d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin;
            }
            if (!zM || zM2) {
                if (zM) {
                    textView = this.f469c;
                } else {
                    textView = this.f470d;
                }
                if (zM2) {
                    textView2 = this.f470d;
                } else {
                    textView2 = this.f469c;
                }
                eVar = (e) textView.getLayoutParams();
                eVar2 = (e) textView2.getLayoutParams();
                z3 = (!zM && this.f469c.getMeasuredWidth() > 0) || (zM2 && this.f470d.getMeasuredWidth() > 0);
                i7 = this.f490x & 112;
                i8 = paddingLeft;
                if (i7 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.f485s;
                } else if (i7 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                    i17 = this.f485s;
                    if (iMax2 < i16 + i17) {
                        iMax2 = i16 + i17;
                    } else {
                        i18 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                        i19 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                        i20 = this.f486t;
                        if (i18 < i19 + i20) {
                            iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i20) - i18));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - this.f486t) - measuredHeight;
                }
                if (z4) {
                    if (z3) {
                        i13 = this.f483q;
                    } else {
                        i13 = 0;
                    }
                    int i27 = i13 - iArr[1];
                    iMin -= Math.max(0, i27);
                    iArr[1] = Math.max(0, -i27);
                    if (zM) {
                        e eVar5 = (e) this.f469c.getLayoutParams();
                        int measuredWidth = iMin - this.f469c.getMeasuredWidth();
                        int measuredHeight2 = this.f469c.getMeasuredHeight() + paddingTop;
                        this.f469c.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                        i14 = measuredWidth - this.f484r;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) eVar5).bottomMargin;
                    } else {
                        i14 = iMin;
                    }
                    if (zM2) {
                        int i28 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f470d.getLayoutParams())).topMargin;
                        this.f470d.layout(iMin - this.f470d.getMeasuredWidth(), i28, iMin, this.f470d.getMeasuredHeight() + i28);
                        i15 = iMin - this.f484r;
                    } else {
                        i15 = iMin;
                    }
                    if (z3) {
                        iMin = Math.min(i14, i15);
                    }
                    iMax = iMax;
                } else {
                    if (z3) {
                        i10 = this.f483q;
                        i9 = 0;
                    } else {
                        i9 = 0;
                        i10 = 0;
                    }
                    int i29 = i10 - iArr[i9];
                    iMax += Math.max(i9, i29);
                    iArr[i9] = Math.max(i9, -i29);
                    if (zM) {
                        e eVar6 = (e) this.f469c.getLayoutParams();
                        int measuredWidth2 = this.f469c.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.f469c.getMeasuredHeight() + paddingTop;
                        this.f469c.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                        i11 = measuredWidth2 + this.f484r;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) eVar6).bottomMargin;
                    } else {
                        i11 = iMax;
                    }
                    if (zM2) {
                        int i30 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f470d.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.f470d.getMeasuredWidth() + iMax;
                        this.f470d.layout(iMax, i30, measuredWidth3, this.f470d.getMeasuredHeight() + i30);
                        i12 = measuredWidth3 + this.f484r;
                    } else {
                        i12 = iMax;
                    }
                    if (z3) {
                        iMax = Math.max(i11, i12);
                    }
                }
                b(this.E, 3);
                size = this.E.size();
                for (i21 = i9; i21 < size; i21++) {
                    iMax = B(this.E.get(i21), iMax, iArr, iMin2);
                }
                i22 = iMin2;
                b(this.E, 5);
                size2 = this.E.size();
                for (i23 = i9; i23 < size2; i23++) {
                    iMin = C(this.E.get(i23), iMin, iArr, i22);
                }
                b(this.E, 1);
                int iU = u(this.E, iArr);
                i24 = (i8 + (((width - i8) - paddingRight) / 2)) - (iU / 2);
                i25 = iU + i24;
                if (i24 >= iMax) {
                    if (i25 > iMin) {
                        iMax = i24 - (i25 - iMin);
                    } else {
                        iMax = i24;
                    }
                }
                size3 = this.E.size();
                while (i9 < size3) {
                    iMax = B(this.E.get(i9), iMax, iArr, i22);
                    i9++;
                }
                this.E.clear();
            }
            i8 = paddingLeft;
            iMin2 = iMin2;
            i9 = 0;
            b(this.E, 3);
            size = this.E.size();
            while (i21 < size) {
                iMax = B(this.E.get(i21), iMax, iArr, iMin2);
            }
            i22 = iMin2;
            b(this.E, 5);
            size2 = this.E.size();
            while (i23 < size2) {
                iMin = C(this.E.get(i23), iMin, iArr, i22);
            }
            b(this.E, 1);
            int iU2 = u(this.E, iArr);
            i24 = (i8 + (((width - i8) - paddingRight) / 2)) - (iU2 / 2);
            i25 = iU2 + i24;
            if (i24 >= iMax) {
                if (i25 > iMin) {
                    iMax = i24 - (i25 - iMin);
                } else {
                    iMax = i24;
                }
            }
            size3 = this.E.size();
            while (i9 < size3) {
                iMax = B(this.E.get(i9), iMax, iArr, i22);
                i9++;
            }
            this.E.clear();
        }
        iB = paddingLeft;
        iC = i26;
        if (M(this.f475i)) {
            if (z4) {
                iC = C(this.f475i, iC, iArr, iMin2);
            } else {
                iB = B(this.f475i, iB, iArr, iMin2);
            }
        }
        if (M(this.f468b)) {
            if (z4) {
                iB = B(this.f468b, iB, iArr, iMin2);
            } else {
                iC = C(this.f468b, iC, iArr, iMin2);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iB);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i26 - iC));
        iMax = Math.max(iB, currentContentInsetLeft2);
        iMin = Math.min(iC, i26 - currentContentInsetRight2);
        if (M(this.f476j)) {
            if (z4) {
                iMin = C(this.f476j, iMin, iArr, iMin2);
            } else {
                iMax = B(this.f476j, iMax, iArr, iMin2);
            }
        }
        if (M(this.f472f)) {
            if (z4) {
                iMin = C(this.f472f, iMin, iArr, iMin2);
            } else {
                iMax = B(this.f472f, iMax, iArr, iMin2);
            }
        }
        zM = M(this.f469c);
        zM2 = M(this.f470d);
        if (zM) {
            e eVar7 = (e) this.f469c.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar7).topMargin + this.f469c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar7).bottomMargin + 0;
        } else {
            measuredHeight = 0;
        }
        if (zM2) {
            e eVar8 = (e) this.f470d.getLayoutParams();
            measuredHeight += ((ViewGroup.MarginLayoutParams) eVar8).topMargin + this.f470d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar8).bottomMargin;
        }
        if (zM) {
            if (zM) {
                textView = this.f469c;
            } else {
                textView = this.f470d;
            }
            if (zM2) {
                textView2 = this.f470d;
            } else {
                textView2 = this.f469c;
            }
            eVar = (e) textView.getLayoutParams();
            eVar2 = (e) textView2.getLayoutParams();
            if (zM) {
            }
            i7 = this.f490x & 112;
            i8 = paddingLeft;
            if (i7 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.f485s;
            } else if (i7 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                i17 = this.f485s;
                if (iMax2 < i16 + i17) {
                    iMax2 = i16 + i17;
                } else {
                    i18 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i19 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    i20 = this.f486t;
                    if (i18 < i19 + i20) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i20) - i18));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - this.f486t) - measuredHeight;
            }
            if (z4) {
                if (z3) {
                    i13 = this.f483q;
                } else {
                    i13 = 0;
                }
                int i210 = i13 - iArr[1];
                iMin -= Math.max(0, i210);
                iArr[1] = Math.max(0, -i210);
                if (zM) {
                    e eVar9 = (e) this.f469c.getLayoutParams();
                    int measuredWidth4 = iMin - this.f469c.getMeasuredWidth();
                    int measuredHeight4 = this.f469c.getMeasuredHeight() + paddingTop;
                    this.f469c.layout(measuredWidth4, paddingTop, iMin, measuredHeight4);
                    i14 = measuredWidth4 - this.f484r;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) eVar9).bottomMargin;
                } else {
                    i14 = iMin;
                }
                if (zM2) {
                    int i211 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f470d.getLayoutParams())).topMargin;
                    this.f470d.layout(iMin - this.f470d.getMeasuredWidth(), i211, iMin, this.f470d.getMeasuredHeight() + i211);
                    i15 = iMin - this.f484r;
                } else {
                    i15 = iMin;
                }
                if (z3) {
                    iMin = Math.min(i14, i15);
                }
                iMax = iMax;
                i9 = 0;
            } else {
                if (z3) {
                    i10 = this.f483q;
                    i9 = 0;
                } else {
                    i9 = 0;
                    i10 = 0;
                }
                int i212 = i10 - iArr[i9];
                iMax += Math.max(i9, i212);
                iArr[i9] = Math.max(i9, -i212);
                if (zM) {
                    e eVar10 = (e) this.f469c.getLayoutParams();
                    int measuredWidth5 = this.f469c.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.f469c.getMeasuredHeight() + paddingTop;
                    this.f469c.layout(iMax, paddingTop, measuredWidth5, measuredHeight5);
                    i11 = measuredWidth5 + this.f484r;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) eVar10).bottomMargin;
                } else {
                    i11 = iMax;
                }
                if (zM2) {
                    int i31 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f470d.getLayoutParams())).topMargin;
                    int measuredWidth6 = this.f470d.getMeasuredWidth() + iMax;
                    this.f470d.layout(iMax, i31, measuredWidth6, this.f470d.getMeasuredHeight() + i31);
                    i12 = measuredWidth6 + this.f484r;
                } else {
                    i12 = iMax;
                }
                if (z3) {
                    iMax = Math.max(i11, i12);
                }
            }
        } else {
            if (zM) {
                textView = this.f469c;
            } else {
                textView = this.f470d;
            }
            if (zM2) {
                textView2 = this.f470d;
            } else {
                textView2 = this.f469c;
            }
            eVar = (e) textView.getLayoutParams();
            eVar2 = (e) textView2.getLayoutParams();
            if (zM) {
            }
            i7 = this.f490x & 112;
            i8 = paddingLeft;
            if (i7 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.f485s;
            } else if (i7 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                i17 = this.f485s;
                if (iMax2 < i16 + i17) {
                    iMax2 = i16 + i17;
                } else {
                    i18 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i19 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    i20 = this.f486t;
                    if (i18 < i19 + i20) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar2).bottomMargin + i20) - i18));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin) - this.f486t) - measuredHeight;
            }
            if (z4) {
                if (z3) {
                    i13 = this.f483q;
                } else {
                    i13 = 0;
                }
                int i213 = i13 - iArr[1];
                iMin -= Math.max(0, i213);
                iArr[1] = Math.max(0, -i213);
                if (zM) {
                    e eVar11 = (e) this.f469c.getLayoutParams();
                    int measuredWidth7 = iMin - this.f469c.getMeasuredWidth();
                    int measuredHeight6 = this.f469c.getMeasuredHeight() + paddingTop;
                    this.f469c.layout(measuredWidth7, paddingTop, iMin, measuredHeight6);
                    i14 = measuredWidth7 - this.f484r;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) eVar11).bottomMargin;
                } else {
                    i14 = iMin;
                }
                if (zM2) {
                    int i214 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f470d.getLayoutParams())).topMargin;
                    this.f470d.layout(iMin - this.f470d.getMeasuredWidth(), i214, iMin, this.f470d.getMeasuredHeight() + i214);
                    i15 = iMin - this.f484r;
                } else {
                    i15 = iMin;
                }
                if (z3) {
                    iMin = Math.min(i14, i15);
                }
                iMax = iMax;
                i9 = 0;
            } else {
                if (z3) {
                    i10 = this.f483q;
                    i9 = 0;
                } else {
                    i9 = 0;
                    i10 = 0;
                }
                int i215 = i10 - iArr[i9];
                iMax += Math.max(i9, i215);
                iArr[i9] = Math.max(i9, -i215);
                if (zM) {
                    e eVar12 = (e) this.f469c.getLayoutParams();
                    int measuredWidth8 = this.f469c.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.f469c.getMeasuredHeight() + paddingTop;
                    this.f469c.layout(iMax, paddingTop, measuredWidth8, measuredHeight7);
                    i11 = measuredWidth8 + this.f484r;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) eVar12).bottomMargin;
                } else {
                    i11 = iMax;
                }
                if (zM2) {
                    int i32 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f470d.getLayoutParams())).topMargin;
                    int measuredWidth9 = this.f470d.getMeasuredWidth() + iMax;
                    this.f470d.layout(iMax, i32, measuredWidth9, this.f470d.getMeasuredHeight() + i32);
                    i12 = measuredWidth9 + this.f484r;
                } else {
                    i12 = iMax;
                }
                if (z3) {
                    iMax = Math.max(i11, i12);
                }
            }
        }
        b(this.E, 3);
        size = this.E.size();
        while (i21 < size) {
            iMax = B(this.E.get(i21), iMax, iArr, iMin2);
        }
        i22 = iMin2;
        b(this.E, 5);
        size2 = this.E.size();
        while (i23 < size2) {
            iMin = C(this.E.get(i23), iMin, iArr, i22);
        }
        b(this.E, 1);
        int iU3 = u(this.E, iArr);
        i24 = (i8 + (((width - i8) - paddingRight) / 2)) - (iU3 / 2);
        i25 = iU3 + i24;
        if (i24 >= iMax) {
            if (i25 > iMin) {
                iMax = i24 - (i25 - iMin);
            } else {
                iMax = i24;
            }
        }
        size3 = this.E.size();
        while (i9 < size3) {
            iMax = B(this.E.get(i9), iMax, iArr, i22);
            i9++;
        }
        this.E.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.G;
        boolean zB = c1.b(this);
        int i5 = !zB ? 1 : 0;
        if (M(this.f471e)) {
            E(this.f471e, i3, 0, i4, 0, this.f482p);
            measuredWidth = this.f471e.getMeasuredWidth() + s(this.f471e);
            iMax = Math.max(0, this.f471e.getMeasuredHeight() + t(this.f471e));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f471e.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (M(this.f475i)) {
            E(this.f475i, i3, 0, i4, 0, this.f482p);
            measuredWidth = this.f475i.getMeasuredWidth() + s(this.f475i);
            iMax = Math.max(iMax, this.f475i.getMeasuredHeight() + t(this.f475i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f475i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (M(this.f468b)) {
            E(this.f468b, i3, iMax3, i4, 0, this.f482p);
            measuredWidth2 = this.f468b.getMeasuredWidth() + s(this.f468b);
            iMax = Math.max(iMax, this.f468b.getMeasuredHeight() + t(this.f468b));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f468b.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i5] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (M(this.f476j)) {
            iMax4 += D(this.f476j, i3, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f476j.getMeasuredHeight() + t(this.f476j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f476j.getMeasuredState());
        }
        if (M(this.f472f)) {
            iMax4 += D(this.f472f, i3, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f472f.getMeasuredHeight() + t(this.f472f));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f472f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (((e) childAt.getLayoutParams()).f499b == 0 && M(childAt)) {
                iMax4 += D(childAt, i3, iMax4, i4, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i7 = this.f485s + this.f486t;
        int i8 = this.f483q + this.f484r;
        if (M(this.f469c)) {
            D(this.f469c, i3, iMax4 + i8, i4, i7, iArr);
            int measuredWidth3 = this.f469c.getMeasuredWidth() + s(this.f469c);
            measuredHeight = this.f469c.getMeasuredHeight() + t(this.f469c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f469c.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (M(this.f470d)) {
            iMax2 = Math.max(iMax2, D(this.f470d, i3, iMax4 + i8, i4, measuredHeight + i7, iArr));
            measuredHeight += this.f470d.getMeasuredHeight() + t(this.f470d);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f470d.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, (-16777216) & iCombineMeasuredStates2), L() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.j());
        ActionMenuView actionMenuView = this.f468b;
        androidx.appcompat.view.menu.e eVarN = actionMenuView != null ? actionMenuView.N() : null;
        int i3 = gVar.f500d;
        if (i3 != 0 && this.L != null && eVarN != null && (menuItemFindItem = eVarN.findItem(i3)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (gVar.f501e) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i3);
        }
        h();
        this.f487u.f(i3 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        g gVar2 = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (dVar != null && (gVar = dVar.f497c) != null) {
            gVar2.f500d = gVar.getItemId();
        }
        gVar2.f501e = A();
        return gVar2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i3) {
        setCollapseContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setCollapseIcon(int i3) {
        setCollapseIcon(c.a.d(getContext(), i3));
    }

    public void setCollapsible(boolean z2) {
        this.O = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f489w) {
            this.f489w = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f488v) {
            this.f488v = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i3) {
        setLogo(c.a.d(getContext(), i3));
    }

    public void setLogoDescription(int i3) {
        setLogoDescription(getContext().getText(i3));
    }

    public void setNavigationContentDescription(int i3) {
        setNavigationContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setNavigationIcon(int i3) {
        setNavigationIcon(c.a.d(getContext(), i3));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f471e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f468b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i3) {
        if (this.f478l != i3) {
            this.f478l = i3;
            if (i3 == 0) {
                this.f477k = getContext();
            } else {
                this.f477k = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setSubtitle(int i3) {
        setSubtitle(getContext().getText(i3));
    }

    public void setSubtitleTextColor(int i3) {
        setSubtitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setTitle(int i3) {
        setTitle(getContext().getText(i3));
    }

    public void setTitleMarginBottom(int i3) {
        this.f486t = i3;
        requestLayout();
    }

    public void setTitleMarginEnd(int i3) {
        this.f484r = i3;
        requestLayout();
    }

    public void setTitleMarginStart(int i3) {
        this.f483q = i3;
        requestLayout();
    }

    public void setTitleMarginTop(int i3) {
        this.f485s = i3;
        requestLayout();
    }

    public void setTitleTextColor(int i3) {
        setTitleTextColor(ColorStateList.valueOf(i3));
    }

    public boolean v() {
        d dVar = this.L;
        return (dVar == null || dVar.f497c == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f468b;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i3) {
        getMenuInflater().inflate(i3, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f468b;
        return actionMenuView != null && actionMenuView.I();
    }

    public static class e extends b.a.C0024a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f499b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f499b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i3, int i4) {
            super(i3, i4);
            this.f499b = 0;
            this.f2229a = 8388627;
        }

        public e(e eVar) {
            super((b.a.C0024a) eVar);
            this.f499b = 0;
            this.f499b = eVar.f499b;
        }

        public e(b.a.C0024a c0024a) {
            super(c0024a);
            this.f499b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f499b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f499b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.toolbarStyle);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f475i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f475i.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f475i;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f473g);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f472f)) {
                c(this.f472f, true);
            }
        } else {
            ImageView imageView = this.f472f;
            if (imageView != null && y(imageView)) {
                removeView(this.f472f);
                this.F.remove(this.f472f);
            }
        }
        ImageView imageView2 = this.f472f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f472f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f471e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f471e)) {
                c(this.f471e, true);
            }
        } else {
            ImageButton imageButton = this.f471e;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f471e);
                this.F.remove(this.f471e);
            }
        }
        ImageButton imageButton2 = this.f471e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f470d;
            if (textView != null && y(textView)) {
                removeView(this.f470d);
                this.F.remove(this.f470d);
            }
        } else {
            if (this.f470d == null) {
                Context context = getContext();
                z zVar = new z(context);
                this.f470d = zVar;
                zVar.setSingleLine();
                this.f470d.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f480n;
                if (i3 != 0) {
                    this.f470d.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f470d.setTextColor(colorStateList);
                }
            }
            if (!y(this.f470d)) {
                c(this.f470d, true);
            }
        }
        TextView textView2 = this.f470d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f492z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f470d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f469c;
            if (textView != null && y(textView)) {
                removeView(this.f469c);
                this.F.remove(this.f469c);
            }
        } else {
            if (this.f469c == null) {
                Context context = getContext();
                z zVar = new z(context);
                this.f469c = zVar;
                zVar.setSingleLine();
                this.f469c.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f479m;
                if (i3 != 0) {
                    this.f469c.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f469c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f469c)) {
                c(this.f469c, true);
            }
        }
        TextView textView2 = this.f469c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f491y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f469c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class g extends i0.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f500d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f501e;

        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f500d = parcel.readInt();
            this.f501e = parcel.readInt() != 0;
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f500d);
            parcel.writeInt(this.f501e ? 1 : 0);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f490x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.P = new b();
        Context context2 = getContext();
        int[] iArr = a.j.Toolbar;
        w0 w0VarV = w0.v(context2, attributeSet, iArr, i3, 0);
        e0.t.k0(this, context, iArr, attributeSet, w0VarV.r(), i3, 0);
        this.f479m = w0VarV.n(a.j.Toolbar_titleTextAppearance, 0);
        this.f480n = w0VarV.n(a.j.Toolbar_subtitleTextAppearance, 0);
        this.f490x = w0VarV.l(a.j.Toolbar_android_gravity, this.f490x);
        this.f481o = w0VarV.l(a.j.Toolbar_buttonGravity, 48);
        int iE = w0VarV.e(a.j.Toolbar_titleMargin, 0);
        int i4 = a.j.Toolbar_titleMargins;
        iE = w0VarV.s(i4) ? w0VarV.e(i4, iE) : iE;
        this.f486t = iE;
        this.f485s = iE;
        this.f484r = iE;
        this.f483q = iE;
        int iE2 = w0VarV.e(a.j.Toolbar_titleMarginStart, -1);
        if (iE2 >= 0) {
            this.f483q = iE2;
        }
        int iE3 = w0VarV.e(a.j.Toolbar_titleMarginEnd, -1);
        if (iE3 >= 0) {
            this.f484r = iE3;
        }
        int iE4 = w0VarV.e(a.j.Toolbar_titleMarginTop, -1);
        if (iE4 >= 0) {
            this.f485s = iE4;
        }
        int iE5 = w0VarV.e(a.j.Toolbar_titleMarginBottom, -1);
        if (iE5 >= 0) {
            this.f486t = iE5;
        }
        this.f482p = w0VarV.f(a.j.Toolbar_maxButtonHeight, -1);
        int iE6 = w0VarV.e(a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iE7 = w0VarV.e(a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iF = w0VarV.f(a.j.Toolbar_contentInsetLeft, 0);
        int iF2 = w0VarV.f(a.j.Toolbar_contentInsetRight, 0);
        h();
        this.f487u.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f487u.g(iE6, iE7);
        }
        this.f488v = w0VarV.e(a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f489w = w0VarV.e(a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f473g = w0VarV.g(a.j.Toolbar_collapseIcon);
        this.f474h = w0VarV.p(a.j.Toolbar_collapseContentDescription);
        CharSequence charSequenceP = w0VarV.p(a.j.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = w0VarV.p(a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f477k = getContext();
        setPopupTheme(w0VarV.n(a.j.Toolbar_popupTheme, 0));
        Drawable drawableG = w0VarV.g(a.j.Toolbar_navigationIcon);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = w0VarV.p(a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = w0VarV.g(a.j.Toolbar_logo);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = w0VarV.p(a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i5 = a.j.Toolbar_titleTextColor;
        if (w0VarV.s(i5)) {
            setTitleTextColor(w0VarV.c(i5));
        }
        int i6 = a.j.Toolbar_subtitleTextColor;
        if (w0VarV.s(i6)) {
            setSubtitleTextColor(w0VarV.c(i6));
        }
        int i7 = a.j.Toolbar_menu;
        if (w0VarV.s(i7)) {
            x(w0VarV.n(i7, 0));
        }
        w0VarV.w();
    }
}
