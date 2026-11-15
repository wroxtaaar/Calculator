package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements c0, e0.n, e0.l, e0.m {
    static final int[] G = {a.a.actionBarSize, R.attr.windowContentOverlay};
    private OverScroller A;
    ViewPropertyAnimator B;
    final AnimatorListenerAdapter C;
    private final Runnable D;
    private final Runnable E;
    private final e0.o F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ContentFrameLayout f333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ActionBarContainer f334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d0 f335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Rect f344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Rect f345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Rect f346q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f347r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f348s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f349t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Rect f350u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private e0.c0 f351v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private e0.c0 f352w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private e0.c0 f353x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private e0.c0 f354y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private d f355z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f341l = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f341l = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f334e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f334e.animate().translationY(-ActionBarOverlayLayout.this.f334e.getHeight()).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public interface d {
        void a(boolean z2);

        void b();

        void c();

        void d(int i3);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i3, int i4) {
            super(i3, i4);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    private void A() {
        u();
        this.D.run();
    }

    private boolean B(float f3) {
        this.A.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.A.getFinalY() > this.f334e.getHeight();
    }

    private void p() {
        u();
        this.E.run();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    private boolean q(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        e eVar = (e) view.getLayoutParams();
        if (z2) {
            int i3 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
            int i4 = rect.left;
            if (i3 != i4) {
                ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i4;
                z6 = true;
            } else {
                z6 = false;
            }
        } else {
            z6 = false;
        }
        if (z3) {
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
            int i6 = rect.top;
            if (i5 != i6) {
                ((ViewGroup.MarginLayoutParams) eVar).topMargin = i6;
                z6 = true;
            }
        }
        if (z5) {
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
            int i8 = rect.right;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i8;
                z6 = true;
            }
        }
        if (z4) {
            int i9 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i10 = rect.bottom;
            if (i9 != i10) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i10;
                return true;
            }
        }
        return z6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d0 t(View view) {
        if (view instanceof d0) {
            return (d0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        this.f331b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f336g = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f337h = context.getApplicationInfo().targetSdkVersion < 19;
        this.A = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.E, 600L);
    }

    private void y() {
        u();
        postDelayed(this.D, 600L);
    }

    @Override // androidx.appcompat.widget.c0
    public void a(Menu menu, androidx.appcompat.view.menu.j.a aVar) {
        z();
        this.f335f.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.c0
    public boolean b() {
        z();
        return this.f335f.b();
    }

    @Override // androidx.appcompat.widget.c0
    public boolean c() {
        z();
        return this.f335f.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.c0
    public boolean d() {
        z();
        return this.f335f.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f336g == null || this.f337h) {
            return;
        }
        int bottom = this.f334e.getVisibility() == 0 ? (int) (this.f334e.getBottom() + this.f334e.getTranslationY() + 0.5f) : 0;
        this.f336g.setBounds(0, bottom, getWidth(), this.f336g.getIntrinsicHeight() + bottom);
        this.f336g.draw(canvas);
    }

    @Override // androidx.appcompat.widget.c0
    public boolean e() {
        z();
        return this.f335f.e();
    }

    @Override // androidx.appcompat.widget.c0
    public void f() {
        z();
        this.f335f.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean zQ = q(this.f334e, rect, true, true, false, true);
        this.f347r.set(rect);
        c1.a(this, this.f347r, this.f344o);
        if (!this.f348s.equals(this.f347r)) {
            this.f348s.set(this.f347r);
            zQ = true;
        }
        if (!this.f345p.equals(this.f344o)) {
            this.f345p.set(this.f344o);
            zQ = true;
        }
        if (zQ) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.c0
    public boolean g() {
        z();
        return this.f335f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f334e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f335f.getTitle();
    }

    @Override // e0.l
    public void h(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // e0.l
    public void i(View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // e0.l
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i3, i4, iArr);
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void k(int i3) {
        z();
        if (i3 == 2) {
            this.f335f.r();
        } else if (i3 == 5) {
            this.f335f.t();
        } else {
            if (i3 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.c0
    public void l() {
        z();
        this.f335f.h();
    }

    @Override // e0.m
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        n(view, i3, i4, i5, i6, i7);
    }

    @Override // e0.l
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            onNestedScroll(view, i3, i4, i5, i6);
        }
    }

    @Override // e0.l
    public boolean o(View view, View view2, int i3, int i4) {
        return i4 == 0 && onStartNestedScroll(view, view2, i3);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        e0.c0 c0VarU = e0.c0.u(windowInsets);
        boolean zQ = q(this.f334e, new Rect(c0VarU.i(), c0VarU.k(), c0VarU.j(), c0VarU.h()), true, true, false, true);
        e0.t.g(this, c0VarU, this.f344o);
        Rect rect = this.f344o;
        e0.c0 c0VarL = c0VarU.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f351v = c0VarL;
        boolean z2 = true;
        if (!this.f352w.equals(c0VarL)) {
            this.f352w = this.f351v;
            zQ = true;
        }
        if (this.f345p.equals(this.f344o)) {
            z2 = zQ;
        } else {
            this.f345p.set(this.f344o);
        }
        if (z2) {
            requestLayout();
        }
        return c0VarU.a().c().b().t();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        e0.t.j0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i9 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int measuredHeight;
        z();
        measureChildWithMargins(this.f334e, i3, 0, i4, 0);
        e eVar = (e) this.f334e.getLayoutParams();
        int iMax = Math.max(0, this.f334e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f334e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f334e.getMeasuredState());
        boolean z2 = (e0.t.K(this) & 256) != 0;
        if (z2) {
            measuredHeight = this.f331b;
            if (this.f339j && this.f334e.getTabContainer() != null) {
                measuredHeight += this.f331b;
            }
        } else {
            measuredHeight = this.f334e.getVisibility() != 8 ? this.f334e.getMeasuredHeight() : 0;
        }
        this.f346q.set(this.f344o);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            this.f353x = this.f351v;
        } else {
            this.f349t.set(this.f347r);
        }
        if (!this.f338i && !z2) {
            Rect rect = this.f346q;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (i5 >= 21) {
                this.f353x = this.f353x.l(0, measuredHeight, 0, 0);
            }
        } else if (i5 >= 21) {
            this.f353x = new e0.c0.b(this.f353x).c(w.b.b(this.f353x.i(), this.f353x.k() + measuredHeight, this.f353x.j(), this.f353x.h() + 0)).a();
        } else {
            Rect rect2 = this.f349t;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        q(this.f333d, this.f346q, true, true, true, true);
        if (i5 >= 21 && !this.f354y.equals(this.f353x)) {
            e0.c0 c0Var = this.f353x;
            this.f354y = c0Var;
            e0.t.h(this.f333d, c0Var);
        } else if (i5 < 21 && !this.f350u.equals(this.f349t)) {
            this.f350u.set(this.f349t);
            this.f333d.a(this.f349t);
        }
        measureChildWithMargins(this.f333d, i3, 0, i4, 0);
        e eVar2 = (e) this.f333d.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f333d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f333d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f333d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        if (!this.f340k || !z2) {
            return false;
        }
        if (B(f4)) {
            p();
        } else {
            A();
        }
        this.f341l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        int i7 = this.f342m + i4;
        this.f342m = i7;
        setActionBarHideOffset(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.F.b(view, view2, i3);
        this.f342m = getActionBarHideOffset();
        u();
        d dVar = this.f355z;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        if ((i3 & 2) == 0 || this.f334e.getVisibility() != 0) {
            return false;
        }
        return this.f340k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onStopNestedScroll(View view) {
        if (this.f340k && !this.f341l) {
            if (this.f342m <= this.f334e.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f355z;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i3) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i3);
        }
        z();
        int i4 = this.f343n ^ i3;
        this.f343n = i3;
        boolean z2 = (i3 & 4) == 0;
        boolean z3 = (i3 & 256) != 0;
        d dVar = this.f355z;
        if (dVar != null) {
            dVar.a(!z3);
            if (z2 || !z3) {
                this.f355z.b();
            } else {
                this.f355z.e();
            }
        }
        if ((i4 & 256) == 0 || this.f355z == null) {
            return;
        }
        e0.t.j0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.f332c = i3;
        d dVar = this.f355z;
        if (dVar != null) {
            dVar.d(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i3) {
        u();
        this.f334e.setTranslationY(-Math.max(0, Math.min(i3, this.f334e.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f355z = dVar;
        if (getWindowToken() != null) {
            this.f355z.d(this.f332c);
            int i3 = this.f343n;
            if (i3 != 0) {
                onWindowSystemUiVisibilityChanged(i3);
                e0.t.j0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f339j = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f340k) {
            this.f340k = z2;
            if (z2) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i3) {
        z();
        this.f335f.setIcon(i3);
    }

    public void setLogo(int i3) {
        z();
        this.f335f.k(i3);
    }

    public void setOverlayMode(boolean z2) {
        this.f338i = z2;
        this.f337h = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i3) {
    }

    @Override // androidx.appcompat.widget.c0
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f335f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.c0
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f335f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f338i;
    }

    void z() {
        if (this.f333d == null) {
            this.f333d = (ContentFrameLayout) findViewById(a.f.action_bar_activity_content);
            this.f334e = (ActionBarContainer) findViewById(a.f.action_bar_container);
            this.f335f = t(findViewById(a.f.action_bar));
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f332c = 0;
        this.f344o = new Rect();
        this.f345p = new Rect();
        this.f346q = new Rect();
        this.f347r = new Rect();
        this.f348s = new Rect();
        this.f349t = new Rect();
        this.f350u = new Rect();
        e0.c0 c0Var = e0.c0.f4521b;
        this.f351v = c0Var;
        this.f352w = c0Var;
        this.f353x = c0Var;
        this.f354y = c0Var;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        v(context);
        this.F = new e0.o(this);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f335f.setIcon(drawable);
    }
}
