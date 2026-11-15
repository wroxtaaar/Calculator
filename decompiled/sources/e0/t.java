package e0;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.vivo.seckeysdk.SecurityKeyCipher;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f4578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f4580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f4581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static WeakHashMap<View, String> f4582f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Field f4584h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ThreadLocal<Rect> f4586j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f4577a = new AtomicInteger(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static WeakHashMap<View, x> f4583g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f4585i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f4587k = {s.b.accessibility_custom_action_0, s.b.accessibility_custom_action_1, s.b.accessibility_custom_action_2, s.b.accessibility_custom_action_3, s.b.accessibility_custom_action_4, s.b.accessibility_custom_action_5, s.b.accessibility_custom_action_6, s.b.accessibility_custom_action_7, s.b.accessibility_custom_action_8, s.b.accessibility_custom_action_9, s.b.accessibility_custom_action_10, s.b.accessibility_custom_action_11, s.b.accessibility_custom_action_12, s.b.accessibility_custom_action_13, s.b.accessibility_custom_action_14, s.b.accessibility_custom_action_15, s.b.accessibility_custom_action_16, s.b.accessibility_custom_action_17, s.b.accessibility_custom_action_18, s.b.accessibility_custom_action_19, s.b.accessibility_custom_action_20, s.b.accessibility_custom_action_21, s.b.accessibility_custom_action_22, s.b.accessibility_custom_action_23, s.b.accessibility_custom_action_24, s.b.accessibility_custom_action_25, s.b.accessibility_custom_action_26, s.b.accessibility_custom_action_27, s.b.accessibility_custom_action_28, s.b.accessibility_custom_action_29, s.b.accessibility_custom_action_30, s.b.accessibility_custom_action_31};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final q f4588l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static f f4589m = new f();

    /* JADX INFO: compiled from: ViewCompat.java */
    class a implements q {
        a() {
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class b extends g<Boolean> {
        b(int i3, Class cls, int i4) {
            super(i3, cls, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class c extends g<CharSequence> {
        c(int i3, Class cls, int i4, int i5) {
            super(i3, cls, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class d extends g<CharSequence> {
        d(int i3, Class cls, int i4, int i5) {
            super(i3, cls, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    class e extends g<Boolean> {
        e(int i3, Class cls, int i4) {
            super(i3, cls, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e0.t.g
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f4590b = new WeakHashMap<>();

        f() {
        }

        private void a(View view, boolean z2) {
            boolean z3 = view.getVisibility() == 0;
            if (z2 != z3) {
                t.W(view, z3 ? 16 : 32);
                this.f4590b.put(view, Boolean.valueOf(z3));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f4590b.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    static abstract class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f4592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4594d;

        g(int i3, Class<T> cls, int i4) {
            this(i3, cls, 0, i4);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f4593c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        abstract T d(View view);

        abstract void e(View view, T t3);

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t3 = (T) view.getTag(this.f4591a);
            if (this.f4592b.isInstance(t3)) {
                return t3;
            }
            return null;
        }

        void g(View view, T t3) {
            if (c()) {
                e(view, t3);
            } else if (b() && h(f(view), t3)) {
                t.E(view);
                view.setTag(this.f4591a, t3);
                t.W(view, this.f4594d);
            }
        }

        abstract boolean h(T t3, T t4);

        g(int i3, Class<T> cls, int i4, int i5) {
            this.f4591a = i3;
            this.f4592b = cls;
            this.f4594d = i4;
            this.f4593c = i5;
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    private static class h {

        /* JADX INFO: compiled from: ViewCompat.java */
        class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            c0 f4595a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f4596b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ p f4597c;

            a(View view, p pVar) {
                this.f4596b = view;
                this.f4597c = pVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                c0 c0VarV = c0.v(windowInsets, view);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 30) {
                    h.a(windowInsets, this.f4596b);
                    if (c0VarV.equals(this.f4595a)) {
                        return this.f4597c.a(view, c0VarV).t();
                    }
                }
                this.f4595a = c0VarV;
                c0 c0VarA = this.f4597c.a(view, c0VarV);
                if (i3 >= 30) {
                    return c0VarA.t();
                }
                t.j0(view);
                return c0VarA.t();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(s.b.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static c0 b(View view, c0 c0Var, Rect rect) {
            WindowInsets windowInsetsT = c0Var.t();
            if (windowInsetsT != null) {
                return c0.v(view.computeSystemWindowInsets(windowInsetsT, rect), view);
            }
            rect.setEmpty();
            return c0Var;
        }

        public static c0 c(View view) {
            return c0.a.a(view);
        }

        static void d(View view, p pVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(s.b.tag_on_apply_window_listener, pVar);
            }
            if (pVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(s.b.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, pVar));
            }
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    private static class i {
        public static c0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            c0 c0VarU = c0.u(rootWindowInsets);
            c0VarU.r(c0VarU);
            c0VarU.d(view.getRootView());
            return c0VarU;
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    private static class j {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i3, i4);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public interface k {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    static class l {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f4598d = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f4599a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f4600b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference<KeyEvent> f4601c = null;

        l() {
        }

        static l a(View view) {
            int i3 = s.b.tag_unhandled_key_event_manager;
            l lVar = (l) view.getTag(i3);
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l();
            view.setTag(i3, lVar2);
            return lVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f4599a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f4600b == null) {
                this.f4600b = new SparseArray<>();
            }
            return this.f4600b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(s.b.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((k) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f4599a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f4598d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f4599a == null) {
                    this.f4599a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f4598d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f4599a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f4599a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f4601c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f4601c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayD = d();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && t.R(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void A0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f4582f == null) {
            f4582f = new WeakHashMap<>();
        }
        f4582f.put(view, str);
    }

    public static int B(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    private static void B0(View view) {
        if (z(view) == 0) {
            v0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (z((View) parent) == 4) {
                v0(view, 2);
                return;
            }
        }
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f4581e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f4580d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4581e = true;
        }
        Field field = f4580d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    private static g<CharSequence> C0() {
        return new d(s.b.tag_state_description, CharSequence.class, 64, 30);
    }

    public static int D(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f4579c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f4578b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4579c = true;
        }
        Field field = f4578b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void D0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof e0.j) {
            ((e0.j) view).stopNestedScroll();
        }
    }

    static e0.a E(View view) {
        e0.a aVarL = l(view);
        if (aVarL == null) {
            aVarL = new e0.a();
        }
        m0(view, aVarL);
        return aVarL;
    }

    private static void E0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static int F(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static int G(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static c0 H(View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return i.a(view);
        }
        if (i3 >= 21) {
            return h.c(view);
        }
        return null;
    }

    public static final CharSequence I(View view) {
        return C0().f(view);
    }

    public static String J(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f4582f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int K(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float L(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean M(View view) {
        return m(view) != null;
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean O(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean P(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean Q(View view) {
        Boolean boolF = a().f(view);
        if (boolF == null) {
            return false;
        }
        return boolF.booleanValue();
    }

    public static boolean R(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean T(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof e0.j) {
            return ((e0.j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean U(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean V(View view) {
        Boolean boolF = l0().f(view);
        if (boolF == null) {
            return false;
        }
        return boolF.booleanValue();
    }

    static void W(View view, int i3) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = p(view) != null && view.getVisibility() == 0;
            if (o(view) != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : SecurityKeyCipher.SECURITY_DATA_SIZE_MAX);
                accessibilityEventObtain.setContentChangeTypes(i3);
                if (z2) {
                    accessibilityEventObtain.getText().add(p(view));
                    B0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i3 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i3);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(p(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i3);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e3);
                }
            }
        }
    }

    public static void X(View view, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            view.offsetLeftAndRight(i3);
            return;
        }
        if (i4 < 21) {
            e(view, i3);
            return;
        }
        Rect rectX = x();
        boolean z2 = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectX.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectX.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        e(view, i3);
        if (z2 && rectX.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectX);
        }
    }

    public static void Y(View view, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            view.offsetTopAndBottom(i3);
            return;
        }
        if (i4 < 21) {
            f(view, i3);
            return;
        }
        Rect rectX = x();
        boolean z2 = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectX.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectX.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        f(view, i3);
        if (z2 && rectX.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectX);
        }
    }

    public static c0 Z(View view, c0 c0Var) {
        WindowInsets windowInsetsT;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsT = c0Var.t()) != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsT);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsT)) {
                return c0.v(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return c0Var;
    }

    private static g<Boolean> a() {
        return new e(s.b.tag_accessibility_heading, Boolean.class, 28);
    }

    public static void a0(View view, f0.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.w0());
    }

    public static int b(View view, CharSequence charSequence, f0.g gVar) {
        int iR = r(view);
        if (iR != -1) {
            c(view, new f0.d.a(iR, charSequence, gVar));
        }
        return iR;
    }

    private static g<CharSequence> b0() {
        return new c(s.b.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    private static void c(View view, f0.d.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            E(view);
            h0(aVar.b(), view);
            q(view).add(aVar);
            W(view, 0);
        }
    }

    public static boolean c0(View view, int i3, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i3, bundle);
        }
        return false;
    }

    public static x d(View view) {
        if (f4583g == null) {
            f4583g = new WeakHashMap<>();
        }
        x xVar = f4583g.get(view);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(view);
        f4583g.put(view, xVar2);
        return xVar2;
    }

    public static void d0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    private static void e(View view, int i3) {
        view.offsetLeftAndRight(i3);
        if (view.getVisibility() == 0) {
            E0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                E0((View) parent);
            }
        }
    }

    public static void e0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    private static void f(View view, int i3) {
        view.offsetTopAndBottom(i3);
        if (view.getVisibility() == 0) {
            E0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                E0((View) parent);
            }
        }
    }

    public static void f0(View view, Runnable runnable, long j3) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j3);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j3);
        }
    }

    public static c0 g(View view, c0 c0Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? h.b(view, c0Var, rect) : c0Var;
    }

    public static void g0(View view, int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            h0(i3, view);
            W(view, 0);
        }
    }

    public static c0 h(View view, c0 c0Var) {
        WindowInsets windowInsetsT;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsT = c0Var.t()) != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsT);
            if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsT)) {
                return c0.v(windowInsetsDispatchApplyWindowInsets, view);
            }
        }
        return c0Var;
    }

    private static void h0(int i3, View view) {
        List<f0.d.a> listQ = q(view);
        for (int i4 = 0; i4 < listQ.size(); i4++) {
            if (listQ.get(i4).b() == i3) {
                listQ.remove(i4);
                return;
            }
        }
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).b(view, keyEvent);
    }

    public static void i0(View view, f0.d.a aVar, CharSequence charSequence, f0.g gVar) {
        if (gVar == null && charSequence == null) {
            g0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, gVar));
        }
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).f(keyEvent);
    }

    public static void j0(View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 20) {
            view.requestApplyInsets();
        } else if (i3 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static int k() {
        AtomicInteger atomicInteger;
        int i3;
        int i4;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f4577a;
            i3 = atomicInteger.get();
            i4 = i3 + 1;
            if (i4 > 16777215) {
                i4 = 1;
            }
        } while (!atomicInteger.compareAndSet(i3, i4));
        return i3;
    }

    public static void k0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, iArr, attributeSet, typedArray, i3, i4);
        }
    }

    public static e0.a l(View view) {
        View.AccessibilityDelegate accessibilityDelegateM = m(view);
        if (accessibilityDelegateM == null) {
            return null;
        }
        return accessibilityDelegateM instanceof e0.a.C0055a ? ((e0.a.C0055a) accessibilityDelegateM).f4516a : new e0.a(accessibilityDelegateM);
    }

    private static g<Boolean> l0() {
        return new b(s.b.tag_screen_reader_focusable, Boolean.class, 28);
    }

    private static View.AccessibilityDelegate m(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : n(view);
    }

    public static void m0(View view, e0.a aVar) {
        if (aVar == null && (m(view) instanceof e0.a.C0055a)) {
            aVar = new e0.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    private static View.AccessibilityDelegate n(View view) {
        if (f4585i) {
            return null;
        }
        if (f4584h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f4584h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f4585i = true;
                return null;
            }
        }
        try {
            Object obj = f4584h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f4585i = true;
            return null;
        }
    }

    public static void n0(View view, boolean z2) {
        a().g(view, Boolean.valueOf(z2));
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void o0(View view, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i3);
        }
    }

    public static CharSequence p(View view) {
        return b0().f(view);
    }

    public static void p0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    private static List<f0.d.a> q(View view) {
        int i3 = s.b.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i3);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i3, arrayList2);
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q0(View view, ColorStateList colorStateList) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            if (view instanceof s) {
                ((s) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        view.setBackgroundTintList(colorStateList);
        if (i3 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static int r(View view) {
        List<f0.d.a> listQ = q(view);
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[] iArr = f4587k;
            if (i4 >= iArr.length || i3 != -1) {
                break;
            }
            int i5 = iArr[i4];
            boolean z2 = true;
            for (int i6 = 0; i6 < listQ.size(); i6++) {
                z2 &= listQ.get(i6).b() != i5;
            }
            if (z2) {
                i3 = i5;
            }
            i4++;
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r0(View view, PorterDuff.Mode mode) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
            if (view instanceof s) {
                ((s) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        view.setBackgroundTintMode(mode);
        if (i3 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof s) {
            return ((s) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void s0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof s) {
            return ((s) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void t0(View view, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f3);
        }
    }

    public static Rect u(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static void u0(View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z2);
        }
    }

    public static Display v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (R(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void v0(View view, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 19) {
            view.setImportantForAccessibility(i3);
        } else if (i4 >= 16) {
            if (i3 == 4) {
                i3 = 2;
            }
            view.setImportantForAccessibility(i3);
        }
    }

    public static float w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void w0(View view, int i3) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i3);
        }
    }

    private static Rect x() {
        if (f4586j == null) {
            f4586j = new ThreadLocal<>();
        }
        Rect rect = f4586j.get();
        if (rect == null) {
            rect = new Rect();
            f4586j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void x0(View view, p pVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.d(view, pVar);
        }
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static void y0(View view, int i3, int i4, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i3, i4, i5, i6);
        } else {
            view.setPadding(i3, i4, i5, i6);
        }
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void z0(View view, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i3, i4);
        }
    }
}
