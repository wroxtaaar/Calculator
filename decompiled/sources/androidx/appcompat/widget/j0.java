package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ListPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class j0 implements h.e {
    private static Method H;
    private static Method I;
    private static Method J;
    private final c A;
    private Runnable B;
    final Handler C;
    private final Rect D;
    private Rect E;
    private boolean F;
    PopupWindow G;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListAdapter f648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    f0 f649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f659n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f660o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f661p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f662q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f663r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DataSetObserver f664s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f665t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Drawable f666u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemClickListener f667v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f668w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final g f669x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final f f670y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final e f671z;

    /* JADX INFO: compiled from: ListPopupWindow.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewT = j0.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            j0.this.a();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            f0 f0Var;
            if (i3 == -1 || (f0Var = j0.this.f649d) == null) {
                return;
            }
            f0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.r();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (j0.this.c()) {
                j0.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            j0.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 != 1 || j0.this.A() || j0.this.G.getContentView() == null) {
                return;
            }
            j0 j0Var = j0.this;
            j0Var.C.removeCallbacks(j0Var.f669x);
            j0.this.f669x.run();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = j0.this.G) != null && popupWindow.isShowing() && x3 >= 0 && x3 < j0.this.G.getWidth() && y3 >= 0 && y3 < j0.this.G.getHeight()) {
                j0 j0Var = j0.this;
                j0Var.C.postDelayed(j0Var.f669x, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            j0 j0Var2 = j0.this;
            j0Var2.C.removeCallbacks(j0Var2.f669x);
            return false;
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    private class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = j0.this.f649d;
            if (f0Var == null || !e0.t.R(f0Var) || j0.this.f649d.getCount() <= j0.this.f649d.getChildCount()) {
                return;
            }
            int childCount = j0.this.f649d.getChildCount();
            j0 j0Var = j0.this;
            if (childCount <= j0Var.f661p) {
                j0Var.G.setInputMethodMode(2);
                j0.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                I = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public j0(Context context) {
        this(context, null, a.a.listPopupWindowStyle);
    }

    private void C() {
        View view = this.f662q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f662q);
            }
        }
    }

    private void N(boolean z2) {
        if (Build.VERSION.SDK_INT > 28) {
            this.G.setIsClippedToScreen(z2);
            return;
        }
        Method method = H;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z2));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int q() {
        int measuredHeight;
        int i3;
        int iMakeMeasureSpec;
        View view;
        int i4;
        if (this.f649d == null) {
            Context context = this.f647b;
            this.B = new a();
            f0 f0VarS = s(context, !this.F);
            this.f649d = f0VarS;
            Drawable drawable = this.f666u;
            if (drawable != null) {
                f0VarS.setSelector(drawable);
            }
            this.f649d.setAdapter(this.f648c);
            this.f649d.setOnItemClickListener(this.f667v);
            this.f649d.setFocusable(true);
            this.f649d.setFocusableInTouchMode(true);
            this.f649d.setOnItemSelectedListener(new b());
            this.f649d.setOnScrollListener(this.f671z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f668w;
            if (onItemSelectedListener != null) {
                this.f649d.setOnItemSelectedListener(onItemSelectedListener);
            }
            f0 f0Var = this.f649d;
            View view2 = this.f662q;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.f663r;
                if (i5 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(f0Var, layoutParams);
                } else if (i5 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f663r);
                } else {
                    linearLayout.addView(f0Var, layoutParams);
                    linearLayout.addView(view2);
                }
                int i6 = this.f651f;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = f0Var;
            }
            this.G.setContentView(view);
        } else {
            View view3 = this.f662q;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.f655j) {
                this.f653h = -i7;
            }
        } else {
            this.D.setEmpty();
            i3 = 0;
        }
        int iU = u(t(), this.f653h, this.G.getInputMethodMode() == 2);
        if (this.f659n || this.f650e == -1) {
            return iU + i3;
        }
        int i8 = this.f651f;
        if (i8 == -2) {
            int i9 = this.f647b.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            int i10 = this.f647b.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f649d.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i3 + this.f649d.getPaddingTop() + this.f649d.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i3, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.G.getMaxAvailableHeight(view, i3, z2);
        }
        Method method = I;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.G, view, Integer.valueOf(i3), Boolean.valueOf(z2))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.G.getMaxAvailableHeight(view, i3);
    }

    public boolean A() {
        return this.G.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.F;
    }

    public void D(View view) {
        this.f665t = view;
    }

    public void E(int i3) {
        this.G.setAnimationStyle(i3);
    }

    public void F(int i3) {
        Drawable background = this.G.getBackground();
        if (background == null) {
            Q(i3);
            return;
        }
        background.getPadding(this.D);
        Rect rect = this.D;
        this.f651f = rect.left + rect.right + i3;
    }

    public void G(int i3) {
        this.f658m = i3;
    }

    public void H(Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public void I(int i3) {
        this.G.setInputMethodMode(i3);
    }

    public void J(boolean z2) {
        this.F = z2;
        this.G.setFocusable(z2);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f667v = onItemClickListener;
    }

    public void M(boolean z2) {
        this.f657l = true;
        this.f656k = z2;
    }

    public void O(int i3) {
        this.f663r = i3;
    }

    public void P(int i3) {
        f0 f0Var = this.f649d;
        if (!c() || f0Var == null) {
            return;
        }
        f0Var.setListSelectionHidden(false);
        f0Var.setSelection(i3);
        if (f0Var.getChoiceMode() != 0) {
            f0Var.setItemChecked(i3, true);
        }
    }

    public void Q(int i3) {
        this.f651f = i3;
    }

    @Override // h.e
    public void a() {
        int iQ = q();
        boolean zA = A();
        androidx.core.widget.h.b(this.G, this.f654i);
        if (this.G.isShowing()) {
            if (e0.t.R(t())) {
                int width = this.f651f;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i3 = this.f650e;
                if (i3 == -1) {
                    if (!zA) {
                        iQ = -1;
                    }
                    if (zA) {
                        this.G.setWidth(this.f651f == -1 ? -1 : 0);
                        this.G.setHeight(0);
                    } else {
                        this.G.setWidth(this.f651f == -1 ? -1 : 0);
                        this.G.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    iQ = i3;
                }
                this.G.setOutsideTouchable((this.f660o || this.f659n) ? false : true);
                this.G.update(t(), this.f652g, this.f653h, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.f651f;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i4 = this.f650e;
        if (i4 == -1) {
            iQ = -1;
        } else if (i4 != -2) {
            iQ = i4;
        }
        this.G.setWidth(width2);
        this.G.setHeight(iQ);
        N(true);
        this.G.setOutsideTouchable((this.f660o || this.f659n) ? false : true);
        this.G.setTouchInterceptor(this.f670y);
        if (this.f657l) {
            androidx.core.widget.h.a(this.G, this.f656k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = J;
            if (method != null) {
                try {
                    method.invoke(this.G, this.E);
                } catch (Exception e3) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e3);
                }
            }
        } else {
            this.G.setEpicenterBounds(this.E);
        }
        androidx.core.widget.h.c(this.G, t(), this.f652g, this.f653h, this.f658m);
        this.f649d.setSelection(-1);
        if (!this.F || this.f649d.isInTouchMode()) {
            r();
        }
        if (this.F) {
            return;
        }
        this.C.post(this.A);
    }

    @Override // h.e
    public boolean c() {
        return this.G.isShowing();
    }

    public void d(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    @Override // h.e
    public void dismiss() {
        this.G.dismiss();
        C();
        this.G.setContentView(null);
        this.f649d = null;
        this.C.removeCallbacks(this.f669x);
    }

    public void e(int i3) {
        this.f652g = i3;
    }

    public int f() {
        return this.f652g;
    }

    public int h() {
        if (this.f655j) {
            return this.f653h;
        }
        return 0;
    }

    public Drawable j() {
        return this.G.getBackground();
    }

    @Override // h.e
    public ListView l() {
        return this.f649d;
    }

    public void n(int i3) {
        this.f653h = i3;
        this.f655j = true;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f664s;
        if (dataSetObserver == null) {
            this.f664s = new d();
        } else {
            ListAdapter listAdapter2 = this.f648c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f648c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f664s);
        }
        f0 f0Var = this.f649d;
        if (f0Var != null) {
            f0Var.setAdapter(this.f648c);
        }
    }

    public void r() {
        f0 f0Var = this.f649d;
        if (f0Var != null) {
            f0Var.setListSelectionHidden(true);
            f0Var.requestLayout();
        }
    }

    f0 s(Context context, boolean z2) {
        return new f0(context, z2);
    }

    public View t() {
        return this.f665t;
    }

    public Object v() {
        if (c()) {
            return this.f649d.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (c()) {
            return this.f649d.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (c()) {
            return this.f649d.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (c()) {
            return this.f649d.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.f651f;
    }

    public j0(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public j0(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f650e = -2;
        this.f651f = -2;
        this.f654i = 1002;
        this.f658m = 0;
        this.f659n = false;
        this.f660o = false;
        this.f661p = Integer.MAX_VALUE;
        this.f663r = 0;
        this.f669x = new g();
        this.f670y = new f();
        this.f671z = new e();
        this.A = new c();
        this.D = new Rect();
        this.f647b = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i3, i4);
        this.f652g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f653h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f655j = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i3, i4);
        this.G = qVar;
        qVar.setInputMethodMode(1);
    }
}
