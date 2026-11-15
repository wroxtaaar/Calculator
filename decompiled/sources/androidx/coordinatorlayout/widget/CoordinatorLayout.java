package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import e0.c0;
import e0.l;
import e0.m;
import e0.o;
import e0.p;
import e0.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements l, m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final String f1083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final Class<?>[] f1084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<c>>> f1085x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final Comparator<View> f1086y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final d0.f<Rect> f1087z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<View> f1088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a<View> f1089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<View> f1090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<View> f1091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f1092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f1093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f1094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f1097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f1098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f1099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private g f1100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private c0 f1102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1103q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f1104r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f1105s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private p f1106t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final o f1107u;

    class a implements p {
        a() {
        }

        @Override // e0.p
        public c0 a(View view, c0 c0Var) {
            return CoordinatorLayout.this.W(c0Var);
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i3, int i4) {
            if (i4 == 0) {
                return z(coordinatorLayout, v3, view, view2, i3);
            }
            return false;
        }

        @Deprecated
        public void B(CoordinatorLayout coordinatorLayout, V v3, View view) {
        }

        public void C(CoordinatorLayout coordinatorLayout, V v3, View view, int i3) {
            if (i3 == 0) {
                B(coordinatorLayout, v3, view);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v3) {
            return d(coordinatorLayout, v3) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v3, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v3) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v3) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v3, View view) {
            return false;
        }

        public c0 f(CoordinatorLayout coordinatorLayout, V v3, c0 c0Var) {
            return c0Var;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v3, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v3, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v3, int i3) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v3, int i3, int i4, int i5, int i6) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v3, View view, float f3, float f4, boolean z2) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v3, View view, float f3, float f4) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int[] iArr, int i5) {
            if (i5 == 0) {
                p(coordinatorLayout, v3, view, i3, i4, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int i5, int i6) {
        }

        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int i5, int i6, int i7) {
            if (i7 == 0) {
                r(coordinatorLayout, v3, view, i3, i4, i5, i6);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, V v3, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            iArr[0] = iArr[0] + i5;
            iArr[1] = iArr[1] + i6;
            s(coordinatorLayout, v3, view, i3, i4, i5, i6, i7);
        }

        @Deprecated
        public void u(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i3) {
        }

        public void v(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i3, int i4) {
            if (i4 == 0) {
                u(coordinatorLayout, v3, view, view2, i3);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, V v3, Rect rect, boolean z2) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, V v3, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, V v3) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i3) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1105s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1105s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fL = t.L(view);
            float fL2 = t.L(view2);
            if (fL > fL2) {
                return -1;
            }
            return fL < fL2 ? 1 : 0;
        }
    }

    static {
        Package r3 = CoordinatorLayout.class.getPackage();
        f1083v = r3 != null ? r3.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f1086y = new i();
        } else {
            f1086y = null;
        }
        f1084w = new Class[]{Context.class, AttributeSet.class};
        f1085x = new ThreadLocal<>();
        f1087z = new d0.h(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private boolean A(View view) {
        return this.f1089c.j(view);
    }

    private void C(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        Rect rectA = a();
        rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f1102p != null && t.y(this) && !t.y(view)) {
            rectA.left += this.f1102p.i();
            rectA.top += this.f1102p.k();
            rectA.right -= this.f1102p.j();
            rectA.bottom -= this.f1102p.h();
        }
        Rect rectA2 = a();
        e0.d.a(S(fVar.f1112c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i3);
        view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        O(rectA);
        O(rectA2);
    }

    private void D(View view, View view2, int i3) {
        Rect rectA = a();
        Rect rectA2 = a();
        try {
            t(view2, rectA);
            u(view, i3, rectA, rectA2);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        } finally {
            O(rectA);
            O(rectA2);
        }
    }

    private void E(View view, int i3, int i4) {
        f fVar = (f) view.getLayoutParams();
        int iB = e0.d.b(T(fVar.f1112c), i4);
        int i5 = iB & 7;
        int i6 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i4 == 1) {
            i3 = width - i3;
        }
        int iW = w(i3) - measuredWidth;
        int i7 = 0;
        if (i5 == 1) {
            iW += measuredWidth / 2;
        } else if (i5 == 5) {
            iW += measuredWidth;
        }
        if (i6 == 16) {
            i7 = 0 + (measuredHeight / 2);
        } else if (i6 == 80) {
            i7 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iW, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void F(View view, Rect rect, int i3) {
        boolean z2;
        boolean z3;
        int width;
        int i4;
        int i5;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        if (t.S(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            Rect rectA = a();
            Rect rectA2 = a();
            rectA2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarF == null || !cVarF.b(this, view, rectA)) {
                rectA.set(rectA2);
            } else if (!rectA2.contains(rectA)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA.toShortString() + " | Bounds:" + rectA2.toShortString());
            }
            O(rectA2);
            if (rectA.isEmpty()) {
                O(rectA);
                return;
            }
            int iB = e0.d.b(fVar.f1117h, i3);
            boolean z4 = true;
            if ((iB & 48) != 48 || (i8 = (rectA.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f1119j) >= (i9 = rect.top)) {
                z2 = false;
            } else {
                V(view, i9 - i8);
                z2 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectA.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f1119j) < (i7 = rect.bottom)) {
                V(view, height - i7);
                z2 = true;
            }
            if (!z2) {
                V(view, 0);
            }
            if ((iB & 3) != 3 || (i5 = (rectA.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f1118i) >= (i6 = rect.left)) {
                z3 = false;
            } else {
                U(view, i6 - i5);
                z3 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectA.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f1118i) >= (i4 = rect.right)) {
                z4 = z3;
            } else {
                U(view, width - i4);
            }
            if (!z4) {
                U(view, 0);
            }
            O(rectA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static c K(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f1083v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f1085x;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f1084w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e3) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e3);
        }
    }

    private boolean L(MotionEvent motionEvent, int i3) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f1090d;
        z(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            if (!(zK || z2) || actionMasked == 0) {
                if (!zK && cVarF != null) {
                    if (i3 == 0) {
                        zK = cVarF.k(this, view, motionEvent);
                    } else if (i3 == 1) {
                        zK = cVarF.D(this, view, motionEvent);
                    }
                    if (zK) {
                        this.f1098l = view;
                    }
                }
                boolean zC = fVar.c();
                boolean zI = fVar.i(this, view);
                z2 = zI && !zC;
                if (zI && !z2) {
                    break;
                }
            } else if (cVarF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    cVarF.k(this, view, motionEventObtain);
                } else if (i3 == 1) {
                    cVarF.D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    private void M() {
        this.f1088b.clear();
        this.f1089c.c();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVarY = y(childAt);
            fVarY.d(this, childAt);
            this.f1089c.b(childAt);
            for (int i4 = 0; i4 < childCount; i4++) {
                if (i4 != i3) {
                    View childAt2 = getChildAt(i4);
                    if (fVarY.b(this, childAt, childAt2)) {
                        if (!this.f1089c.d(childAt2)) {
                            this.f1089c.b(childAt2);
                        }
                        this.f1089c.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f1088b.addAll(this.f1089c.i());
        Collections.reverse(this.f1088b);
    }

    private static void O(Rect rect) {
        rect.setEmpty();
        f1087z.a(rect);
    }

    private void Q(boolean z2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (cVarF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    cVarF.k(this, childAt, motionEventObtain);
                } else {
                    cVarF.D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            ((f) getChildAt(i4).getLayoutParams()).m();
        }
        this.f1098l = null;
        this.f1095i = false;
    }

    private static int R(int i3) {
        if (i3 == 0) {
            return 17;
        }
        return i3;
    }

    private static int S(int i3) {
        if ((i3 & 7) == 0) {
            i3 |= 8388611;
        }
        return (i3 & 112) == 0 ? i3 | 48 : i3;
    }

    private static int T(int i3) {
        if (i3 == 0) {
            return 8388661;
        }
        return i3;
    }

    private void U(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        int i4 = fVar.f1118i;
        if (i4 != i3) {
            t.X(view, i3 - i4);
            fVar.f1118i = i3;
        }
    }

    private void V(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        int i4 = fVar.f1119j;
        if (i4 != i3) {
            t.Y(view, i3 - i4);
            fVar.f1119j = i3;
        }
    }

    private void X() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!t.y(this)) {
            t.x0(this, null);
            return;
        }
        if (this.f1106t == null) {
            this.f1106t = new a();
        }
        t.x0(this, this.f1106t);
        setSystemUiVisibility(1280);
    }

    private static Rect a() {
        Rect rectB = f1087z.b();
        return rectB == null ? new Rect() : rectB;
    }

    private static int c(int i3, int i4, int i5) {
        if (i3 < i4) {
            return i4;
        }
        return i3 > i5 ? i5 : i3;
    }

    private void d(f fVar, Rect rect, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i4) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i3 + iMax, i4 + iMax2);
    }

    private c0 e(c0 c0Var) {
        c cVarF;
        if (c0Var.n()) {
            return c0Var;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (t.y(childAt) && (cVarF = ((f) childAt.getLayoutParams()).f()) != null) {
                c0Var = cVarF.f(this, childAt, c0Var);
                if (c0Var.n()) {
                    break;
                }
            }
        }
        return c0Var;
    }

    private void v(View view, int i3, Rect rect, Rect rect2, f fVar, int i4, int i5) {
        int iWidth;
        int iHeight;
        int iB = e0.d.b(R(fVar.f1112c), i3);
        int iB2 = e0.d.b(S(fVar.f1113d), i3);
        int i6 = iB & 7;
        int i7 = iB & 112;
        int i8 = iB2 & 7;
        int i9 = iB2 & 112;
        if (i8 != 1) {
            iWidth = i8 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i9 != 16) {
            iHeight = i9 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i6 == 1) {
            iWidth -= i4 / 2;
        } else if (i6 != 5) {
            iWidth -= i4;
        }
        if (i7 == 16) {
            iHeight -= i5 / 2;
        } else if (i7 != 80) {
            iHeight -= i5;
        }
        rect2.set(iWidth, iHeight, i4 + iWidth, i5 + iHeight);
    }

    private int w(int i3) {
        int[] iArr = this.f1097k;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i3);
            return 0;
        }
        if (i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i3 + " out of range for " + this);
        return 0;
    }

    private void z(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator<View> comparator = f1086y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public boolean B(View view, int i3, int i4) {
        Rect rectA = a();
        t(view, rectA);
        try {
            return rectA.contains(i3, i4);
        } finally {
            O(rectA);
        }
    }

    void G(View view, int i3) {
        c cVarF;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f1120k != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            Rect rectA3 = a();
            t(fVar.f1120k, rectA);
            q(view, false, rectA2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            v(view, i3, rectA, rectA3, fVar, measuredWidth, measuredHeight);
            boolean z2 = (rectA3.left == rectA2.left && rectA3.top == rectA2.top) ? false : true;
            d(fVar, rectA3, measuredWidth, measuredHeight);
            int i4 = rectA3.left - rectA2.left;
            int i5 = rectA3.top - rectA2.top;
            if (i4 != 0) {
                t.X(view, i4);
            }
            if (i5 != 0) {
                t.Y(view, i5);
            }
            if (z2 && (cVarF = fVar.f()) != null) {
                cVarF.h(this, view, fVar.f1120k);
            }
            O(rectA);
            O(rectA2);
            O(rectA3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    final void H(int i3) {
        int i4;
        c cVarF;
        boolean zH;
        int iB = t.B(this);
        int size = this.f1088b.size();
        Rect rectA = a();
        Rect rectA2 = a();
        Rect rectA3 = a();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f1088b.get(i5);
            f fVar = (f) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (fVar.f1121l == this.f1088b.get(i6)) {
                        G(view, iB);
                    }
                }
                q(view, true, rectA2);
                if (fVar.f1116g != 0 && !rectA2.isEmpty()) {
                    int iB2 = e0.d.b(fVar.f1116g, iB);
                    int i7 = iB2 & 112;
                    if (i7 == 48) {
                        rectA.top = Math.max(rectA.top, rectA2.bottom);
                    } else if (i7 == 80) {
                        rectA.bottom = Math.max(rectA.bottom, getHeight() - rectA2.top);
                    }
                    int i8 = iB2 & 7;
                    if (i8 == 3) {
                        rectA.left = Math.max(rectA.left, rectA2.right);
                    } else if (i8 == 5) {
                        rectA.right = Math.max(rectA.right, getWidth() - rectA2.left);
                    }
                }
                if (fVar.f1117h != 0 && view.getVisibility() == 0) {
                    F(view, rectA, iB);
                }
                if (i3 != 2) {
                    x(view, rectA3);
                    if (!rectA3.equals(rectA2)) {
                        N(view, rectA2);
                        for (i4 = i5 + 1; i4 < size; i4++) {
                            View view2 = this.f1088b.get(i4);
                            f fVar2 = (f) view2.getLayoutParams();
                            cVarF = fVar2.f();
                            if (cVarF == null && cVarF.e(this, view2, view)) {
                                if (i3 == 0 && fVar2.g()) {
                                    fVar2.k();
                                } else {
                                    if (i3 != 2) {
                                        zH = cVarF.h(this, view2, view);
                                    } else {
                                        cVarF.i(this, view2, view);
                                        zH = true;
                                    }
                                    if (i3 == 1) {
                                        fVar2.p(zH);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i4 < size) {
                        View view3 = this.f1088b.get(i4);
                        f fVar3 = (f) view3.getLayoutParams();
                        cVarF = fVar3.f();
                        if (cVarF == null) {
                        }
                    }
                }
            }
        }
        O(rectA);
        O(rectA2);
        O(rectA3);
    }

    public void I(View view, int i3) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f1120k;
        if (view2 != null) {
            D(view, view2, i3);
            return;
        }
        int i4 = fVar.f1114e;
        if (i4 >= 0) {
            E(view, i4, i3);
        } else {
            C(view, i3);
        }
    }

    public void J(View view, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    void N(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    void P() {
        if (this.f1096j && this.f1100n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1100n);
        }
        this.f1101o = false;
    }

    final c0 W(c0 c0Var) {
        if (d0.d.a(this.f1102p, c0Var)) {
            return c0Var;
        }
        this.f1102p = c0Var;
        boolean z2 = c0Var != null && c0Var.k() > 0;
        this.f1103q = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        c0 c0VarE = e(c0Var);
        requestLayout();
        return c0VarE;
    }

    void b() {
        if (this.f1096j) {
            if (this.f1100n == null) {
                this.f1100n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1100n);
        }
        this.f1101o = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f1110a;
        if (cVar != null) {
            float fD = cVar.d(this, view);
            if (fD > 0.0f) {
                if (this.f1092f == null) {
                    this.f1092f = new Paint();
                }
                this.f1092f.setColor(fVar.f1110a.c(this, view));
                this.f1092f.setAlpha(c(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f1092f);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1104r;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public void f(View view) {
        List listG = this.f1089c.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < listG.size(); i3++) {
            View view2 = (View) listG.get(i3);
            c cVarF = ((f) view2.getLayoutParams()).f();
            if (cVarF != null) {
                cVarF.h(this, view2, view);
            }
        }
    }

    void g() {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            if (A(getChildAt(i3))) {
                z2 = true;
                break;
            }
        }
        if (z2 != this.f1101o) {
            if (z2) {
                b();
            } else {
                P();
            }
        }
    }

    final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.f1088b);
    }

    public final c0 getLastWindowInsets() {
        return this.f1102p;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1107u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f1104r;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // e0.l
    public void h(View view, View view2, int i3, int i4) {
        c cVarF;
        this.f1107u.c(view, view2, i3, i4);
        this.f1099m = view2;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i4) && (cVarF = fVar.f()) != null) {
                cVarF.v(this, childAt, view, view2, i3, i4);
            }
        }
    }

    @Override // e0.l
    public void i(View view, int i3) {
        this.f1107u.d(view, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i3)) {
                c cVarF = fVar.f();
                if (cVarF != null) {
                    cVarF.C(this, childAt, view, i3);
                }
                fVar.l(i3);
                fVar.k();
            }
        }
        this.f1099m = null;
    }

    @Override // e0.l
    public void j(View view, int i3, int i4, int[] iArr, int i5) {
        c cVarF;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i5) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f1093g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.q(this, childAt, view, i3, i4, iArr2, i5);
                    int[] iArr3 = this.f1093g;
                    iMax = i3 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f1093g;
                    iMax2 = i4 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z2) {
            H(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // e0.m
    public void m(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        c cVarF;
        boolean z2;
        int iMin;
        int childCount = getChildCount();
        boolean z3 = false;
        int iMax = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i7) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f1093g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.t(this, childAt, view, i3, i4, i5, i6, i7, iArr2);
                    int[] iArr3 = this.f1093g;
                    iMax = i5 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i6 > 0) {
                        z2 = true;
                        iMin = Math.max(i8, this.f1093g[1]);
                    } else {
                        z2 = true;
                        iMin = Math.min(i8, this.f1093g[1]);
                    }
                    i8 = iMin;
                    z3 = z2;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i8;
        if (z3) {
            H(1);
        }
    }

    @Override // e0.l
    public void n(View view, int i3, int i4, int i5, int i6, int i7) {
        m(view, i3, i4, i5, i6, 0, this.f1094h);
    }

    @Override // e0.l
    public boolean o(View view, View view2, int i3, int i4) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVarF = fVar.f();
                if (cVarF != null) {
                    boolean zA = cVarF.A(this, childAt, view, view2, i3, i4);
                    z2 |= zA;
                    fVar.r(i4, zA);
                } else {
                    fVar.r(i4, false);
                }
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.f1101o) {
            if (this.f1100n == null) {
                this.f1100n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1100n);
        }
        if (this.f1102p == null && t.y(this)) {
            t.j0(this);
        }
        this.f1096j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.f1101o && this.f1100n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1100n);
        }
        View view = this.f1099m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f1096j = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1103q || this.f1104r == null) {
            return;
        }
        c0 c0Var = this.f1102p;
        int iK = c0Var != null ? c0Var.k() : 0;
        if (iK > 0) {
            this.f1104r.setBounds(0, 0, getWidth(), iK);
            this.f1104r.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q(true);
        }
        boolean zL = L(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            Q(true);
        }
        return zL;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        c cVarF;
        int iB = t.B(this);
        int size = this.f1088b.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.f1088b.get(i7);
            if (view.getVisibility() != 8 && ((cVarF = ((f) view.getLayoutParams()).f()) == null || !cVarF.l(this, view, iB))) {
                I(view, iB);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x011d  */
    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        c cVarF;
        f fVar;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        M();
        g();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iB = t.B(this);
        boolean z2 = iB == 1;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int i12 = paddingLeft + paddingRight;
        int i13 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z3 = this.f1102p != null && t.y(this);
        int size3 = this.f1088b.size();
        int i14 = suggestedMinimumWidth;
        int i15 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i16 = 0;
        while (i16 < size3) {
            View view = this.f1088b.get(i16);
            if (view.getVisibility() == 8) {
                i10 = i16;
                i7 = size3;
                i8 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i17 = fVar2.f1114e;
                if (i17 < 0 || mode == 0) {
                    i5 = iCombineMeasuredStates;
                } else {
                    int iW = w(i17);
                    int iB2 = e0.d.b(T(fVar2.f1112c), iB) & 7;
                    i5 = iCombineMeasuredStates;
                    if ((iB2 == 3 && !z2) || (iB2 == 5 && z2)) {
                        iMax = Math.max(0, (size - paddingRight) - iW);
                    } else if ((iB2 == 5 && !z2) || (iB2 == 3 && z2)) {
                        iMax = Math.max(0, iW - paddingLeft);
                    }
                    if (z3 || t.y(view)) {
                        iMakeMeasureSpec = i3;
                        iMakeMeasureSpec2 = i4;
                    } else {
                        int i18 = this.f1102p.i() + this.f1102p.j();
                        int iK = this.f1102p.k() + this.f1102p.h();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - i18, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iK, mode2);
                    }
                    cVarF = fVar2.f();
                    if (cVarF != null) {
                        fVar = fVar2;
                        i9 = i5;
                        i10 = i16;
                        i6 = i15;
                        i8 = paddingLeft;
                        i11 = i14;
                        i7 = size3;
                        if (!cVarF.m(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        f fVar3 = fVar;
                        int iMax2 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin + ((ViewGroup.MarginLayoutParams) fVar3).rightMargin);
                        int iMax3 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                        i14 = iMax2;
                        i15 = iMax3;
                    } else {
                        fVar = fVar2;
                        i6 = i15;
                        i7 = size3;
                        i8 = paddingLeft;
                        i9 = i5;
                        i10 = i16;
                        i11 = i14;
                    }
                    J(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    f fVar4 = fVar;
                    int iMax4 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin + ((ViewGroup.MarginLayoutParams) fVar4).rightMargin);
                    int iMax5 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin + ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                    i14 = iMax4;
                    i15 = iMax5;
                }
                iMax = 0;
                if (z3) {
                    iMakeMeasureSpec = i3;
                    iMakeMeasureSpec2 = i4;
                } else {
                    iMakeMeasureSpec = i3;
                    iMakeMeasureSpec2 = i4;
                }
                cVarF = fVar2.f();
                if (cVarF != null) {
                    fVar = fVar2;
                    i9 = i5;
                    i10 = i16;
                    i6 = i15;
                    i8 = paddingLeft;
                    i11 = i14;
                    i7 = size3;
                    if (!cVarF.m(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                    }
                    f fVar5 = fVar;
                    int iMax6 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar5).leftMargin + ((ViewGroup.MarginLayoutParams) fVar5).rightMargin);
                    int iMax7 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar5).topMargin + ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                    i14 = iMax6;
                    i15 = iMax7;
                } else {
                    fVar = fVar2;
                    i6 = i15;
                    i7 = size3;
                    i8 = paddingLeft;
                    i9 = i5;
                    i10 = i16;
                    i11 = i14;
                }
                J(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                f fVar6 = fVar;
                int iMax8 = Math.max(i11, i12 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar6).leftMargin + ((ViewGroup.MarginLayoutParams) fVar6).rightMargin);
                int iMax9 = Math.max(i6, i13 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar6).topMargin + ((ViewGroup.MarginLayoutParams) fVar6).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(i9, view.getMeasuredState());
                i14 = iMax8;
                i15 = iMax9;
            }
            i16 = i10 + 1;
            paddingLeft = i8;
            size3 = i7;
        }
        int i19 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i14, i3, (-16777216) & i19), View.resolveSizeAndState(i15, i4, i19 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        c cVarF;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zN |= cVarF.n(this, childAt, view, f3, f4, z2);
                }
            }
        }
        if (zN) {
            H(1);
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onNestedPreFling(View view, float f3, float f4) {
        c cVarF;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zO |= cVarF.o(this, childAt, view, f3, f4);
                }
            }
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        j(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        n(view, i3, i4, i5, i6, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        h(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.j());
        SparseArray<Parcelable> sparseArray = hVar.f1129d;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            c cVarF = y(childAt).f();
            if (id != -1 && cVarF != null && (parcelable2 = sparseArray.get(id)) != null) {
                cVarF.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableY;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && cVarF != null && (parcelableY = cVarF.y(this, childAt)) != null) {
                sparseArray.append(id, parcelableY);
            }
        }
        hVar.f1129d = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return o(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, e0.n
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[PHI: r3
  0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zL;
        boolean zD;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f1098l == null) {
            zL = L(motionEvent, 1);
            if (!zL) {
                zD = false;
            }
            motionEventObtain = null;
            if (this.f1098l == null) {
                zD |= super.onTouchEvent(motionEvent);
            } else if (zL) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                Q(false);
            }
            return zD;
        }
        zL = false;
        c cVarF = ((f) this.f1098l.getLayoutParams()).f();
        if (cVarF != null) {
            zD = cVarF.D(this, this.f1098l, motionEvent);
        } else {
            zD = false;
        }
        motionEventObtain = null;
        if (this.f1098l == null) {
            zD |= super.onTouchEvent(motionEvent);
        } else if (zL) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked != 1) {
            Q(false);
        } else {
            Q(false);
        }
        return zD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void q(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            t(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> r(View view) {
        List<View> listH = this.f1089c.h(view);
        this.f1091e.clear();
        if (listH != null) {
            this.f1091e.addAll(listH);
        }
        return this.f1091e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c cVarF = ((f) view.getLayoutParams()).f();
        if (cVarF == null || !cVarF.w(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (!z2 || this.f1095i) {
            return;
        }
        Q(false);
        this.f1095i = true;
    }

    public List<View> s(View view) {
        List listG = this.f1089c.g(view);
        this.f1091e.clear();
        if (listG != null) {
            this.f1091e.addAll(listG);
        }
        return this.f1091e;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        X();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1105s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1104r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f1104r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f1104r.setState(getDrawableState());
                }
                x.a.m(this.f1104r, t.B(this));
                this.f1104r.setVisible(getVisibility() == 0, false);
                this.f1104r.setCallback(this);
            }
            t.d0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i3) {
        setStatusBarBackground(new ColorDrawable(i3));
    }

    public void setStatusBarBackgroundResource(int i3) {
        setStatusBarBackground(i3 != 0 ? u.a.d(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z2 = i3 == 0;
        Drawable drawable = this.f1104r;
        if (drawable == null || drawable.isVisible() == z2) {
            return;
        }
        this.f1104r.setVisible(z2, false);
    }

    void t(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void u(View view, int i3, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        v(view, i3, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1104r;
    }

    void x(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f y(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f1111b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f1111b = true;
            } else {
                d dVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    dVar = (d) superclass.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e3) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e3);
                    }
                }
                fVar.f1111b = true;
            }
        }
        return fVar;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, r.a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i3) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i3);
        this.f1088b = new ArrayList();
        this.f1089c = new androidx.coordinatorlayout.widget.a<>();
        this.f1090d = new ArrayList();
        this.f1091e = new ArrayList();
        this.f1093g = new int[2];
        this.f1094h = new int[2];
        this.f1107u = new o(this);
        if (i3 == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.c.CoordinatorLayout, 0, r.b.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.c.CoordinatorLayout, i3, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i3 == 0) {
                saveAttributeDataForStyleable(context, r.c.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, r.b.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, r.c.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(r.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f1097k = resources.getIntArray(resourceId);
            float f3 = resources.getDisplayMetrics().density;
            int length = this.f1097k.length;
            for (int i4 = 0; i4 < length; i4++) {
                int[] iArr = this.f1097k;
                iArr[i4] = (int) (iArr[i4] * f3);
            }
        }
        this.f1104r = typedArrayObtainStyledAttributes.getDrawable(r.c.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        X();
        super.setOnHierarchyChangeListener(new e());
        if (t.z(this) == 0) {
            t.v0(this, 1);
        }
    }

    protected static class h extends i0.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        SparseArray<Parcelable> f1129d;

        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i3 = parcel.readInt();
            int[] iArr = new int[i3];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f1129d = new SparseArray<>(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                this.f1129d.append(iArr[i4], parcelableArray[i4]);
            }
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            SparseArray<Parcelable> sparseArray = this.f1129d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = this.f1129d.keyAt(i4);
                parcelableArr[i4] = this.f1129d.valueAt(i4);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i3);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f1110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1117h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f1118i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f1119j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        View f1120k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        View f1121l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f1122m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f1123n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f1124o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f1125p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final Rect f1126q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Object f1127r;

        public f(int i3, int i4) {
            super(i3, i4);
            this.f1111b = false;
            this.f1112c = 0;
            this.f1113d = 0;
            this.f1114e = -1;
            this.f1115f = -1;
            this.f1116g = 0;
            this.f1117h = 0;
            this.f1126q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f1115f);
            this.f1120k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f1121l = null;
                    this.f1120k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1115f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f1121l = null;
                this.f1120k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f1121l = null;
                    this.f1120k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f1121l = viewFindViewById;
        }

        private boolean s(View view, int i3) {
            int iB = e0.d.b(((f) view.getLayoutParams()).f1116g, i3);
            return iB != 0 && (e0.d.b(this.f1117h, i3) & iB) == iB;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1120k.getId() != this.f1115f) {
                return false;
            }
            View view2 = this.f1120k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f1121l = null;
                    this.f1120k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f1121l = view2;
            return true;
        }

        boolean a() {
            return this.f1120k == null && this.f1115f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f1121l || s(view2, t.B(coordinatorLayout)) || ((cVar = this.f1110a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f1110a == null) {
                this.f1122m = false;
            }
            return this.f1122m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1115f == -1) {
                this.f1121l = null;
                this.f1120k = null;
                return null;
            }
            if (this.f1120k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f1120k;
        }

        public int e() {
            return this.f1115f;
        }

        public c f() {
            return this.f1110a;
        }

        boolean g() {
            return this.f1125p;
        }

        Rect h() {
            return this.f1126q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z2 = this.f1122m;
            if (z2) {
                return true;
            }
            c cVar = this.f1110a;
            boolean zA = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z2;
            this.f1122m = zA;
            return zA;
        }

        boolean j(int i3) {
            if (i3 == 0) {
                return this.f1123n;
            }
            if (i3 != 1) {
                return false;
            }
            return this.f1124o;
        }

        void k() {
            this.f1125p = false;
        }

        void l(int i3) {
            r(i3, false);
        }

        void m() {
            this.f1122m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.f1110a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.f1110a = cVar;
                this.f1127r = null;
                this.f1111b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        void p(boolean z2) {
            this.f1125p = z2;
        }

        void q(Rect rect) {
            this.f1126q.set(rect);
        }

        void r(int i3, boolean z2) {
            if (i3 == 0) {
                this.f1123n = z2;
            } else {
                if (i3 != 1) {
                    return;
                }
                this.f1124o = z2;
            }
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1111b = false;
            this.f1112c = 0;
            this.f1113d = 0;
            this.f1114e = -1;
            this.f1115f = -1;
            this.f1116g = 0;
            this.f1117h = 0;
            this.f1126q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.c.CoordinatorLayout_Layout);
            this.f1112c = typedArrayObtainStyledAttributes.getInteger(r.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f1115f = typedArrayObtainStyledAttributes.getResourceId(r.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f1113d = typedArrayObtainStyledAttributes.getInteger(r.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f1114e = typedArrayObtainStyledAttributes.getInteger(r.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f1116g = typedArrayObtainStyledAttributes.getInt(r.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f1117h = typedArrayObtainStyledAttributes.getInt(r.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i3 = r.c.CoordinatorLayout_Layout_layout_behavior;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i3);
            this.f1111b = zHasValue;
            if (zHasValue) {
                this.f1110a = CoordinatorLayout.K(context, attributeSet, typedArrayObtainStyledAttributes.getString(i3));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f1110a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f1111b = false;
            this.f1112c = 0;
            this.f1113d = 0;
            this.f1114e = -1;
            this.f1115f = -1;
            this.f1116g = 0;
            this.f1117h = 0;
            this.f1126q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1111b = false;
            this.f1112c = 0;
            this.f1113d = 0;
            this.f1114e = -1;
            this.f1115f = -1;
            this.f1116g = 0;
            this.f1117h = 0;
            this.f1126q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1111b = false;
            this.f1112c = 0;
            this.f1113d = 0;
            this.f1114e = -1;
            this.f1115f = -1;
            this.f1116g = 0;
            this.f1117h = 0;
            this.f1126q = new Rect();
        }
    }
}
