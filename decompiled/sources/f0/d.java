package f0;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.vivo.seckeysdk.SecurityKeyCipher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f4638d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f4639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4640b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4641c = -1;

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f4642e = new a(1, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4643f = new a(2, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f4644g = new a(4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f4645h = new a(8, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f4646i = new a(16, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f4647j = new a(32, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f4648k = new a(64, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f4649l = new a(128, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f4650m = new a(256, (CharSequence) null, (Class<? extends g.a>) g.b.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f4651n = new a(512, (CharSequence) null, (Class<? extends g.a>) g.b.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f4652o = new a(1024, (CharSequence) null, (Class<? extends g.a>) g.c.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f4653p = new a(SecurityKeyCipher.SECURITY_DATA_SIZE_MAX, (CharSequence) null, (Class<? extends g.a>) g.c.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f4654q = new a(4096, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f4655r = new a(8192, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f4656s = new a(16384, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f4657t = new a(32768, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f4658u = new a(65536, null);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f4659v = new a(131072, (CharSequence) null, (Class<? extends g.a>) g.C0060g.class);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f4660w = new a(262144, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f4661x = new a(524288, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f4662y = new a(1048576, null);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f4663z = new a(2097152, (CharSequence) null, (Class<? extends g.a>) g.h.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f4664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<? extends g.a> f4666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final g f4667d;

        static {
            int i3 = Build.VERSION.SDK_INT;
            A = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);
            C = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            D = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            E = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            F = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            G = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            H = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            I = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            J = new a(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            K = new a(i3 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            L = new a(i3 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, g.f.class);
            M = new a(i3 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, g.d.class);
            N = new a(i3 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            O = new a(i3 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            P = new a(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new a(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        }

        public a(int i3, CharSequence charSequence) {
            this(null, i3, charSequence, null, null);
        }

        public a a(CharSequence charSequence, g gVar) {
            return new a(null, this.f4665b, charSequence, gVar, this.f4666c);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f4664a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f4664a).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle) {
            if (this.f4667d == null) {
                return false;
            }
            g.a aVar = null;
            Class<? extends g.a> cls = this.f4666c;
            if (cls != null) {
                try {
                    g.a aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVarNewInstance.a(bundle);
                        aVar = aVarNewInstance;
                    } catch (Exception e3) {
                        e = e3;
                        aVar = aVarNewInstance;
                        Class<? extends g.a> cls2 = this.f4666c;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            }
            return this.f4667d.a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f4664a;
            if (obj2 == null) {
                return aVar.f4664a == null;
            }
            return obj2.equals(aVar.f4664a);
        }

        public int hashCode() {
            Object obj = this.f4664a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(int i3, CharSequence charSequence, g gVar) {
            this(null, i3, charSequence, gVar, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i3, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i3, charSequence, null, cls);
        }

        a(Object obj, int i3, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.f4665b = i3;
            this.f4667d = gVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f4664a = new AccessibilityNodeInfo.AccessibilityAction(i3, charSequence);
            } else {
                this.f4664a = obj;
            }
            this.f4666c = cls;
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f4668a;

        b(Object obj) {
            this.f4668a = obj;
        }

        public static b a(int i3, int i4, boolean z2, int i5) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z2, i5));
            }
            return i6 >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z2)) : new b(null);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f4669a;

        c(Object obj) {
            this.f4669a = obj;
        }

        public static c f(int i3, int i4, int i5, int i6, boolean z2, boolean z3) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i4, i5, i6, z2, z3));
            }
            return i7 >= 19 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i4, i5, i6, z2)) : new c(null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f4669a).getColumnIndex();
            }
            return 0;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f4669a).getColumnSpan();
            }
            return 0;
        }

        public int c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f4669a).getRowIndex();
            }
            return 0;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f4669a).getRowSpan();
            }
            return 0;
        }

        public boolean e() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f4669a).isSelected();
            }
            return false;
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4639a = accessibilityNodeInfo;
    }

    public static d L() {
        return x0(AccessibilityNodeInfo.obtain());
    }

    public static d M(View view) {
        return x0(AccessibilityNodeInfo.obtain(view));
    }

    public static d N(d dVar) {
        return x0(AccessibilityNodeInfo.obtain(dVar.f4639a));
    }

    private void Q(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayV = v(view);
        if (sparseArrayV != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArrayV.size(); i3++) {
                if (sparseArrayV.valueAt(i3).get() == null) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                sparseArrayV.remove(((Integer) arrayList.get(i4)).intValue());
            }
        }
    }

    private void S(int i3, boolean z2) {
        Bundle bundleS = s();
        if (bundleS != null) {
            int i4 = bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i3);
            if (!z2) {
                i3 = 0;
            }
            bundleS.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i3 | i4);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i3) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i3));
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4639a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f4639a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f4639a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f4639a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> g(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f4639a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f4639a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String i(int i3) {
        if (i3 == 1) {
            return "ACTION_FOCUS";
        }
        if (i3 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i3) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case SecurityKeyCipher.SECURITY_DATA_SIZE_MAX /* 2048 */:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                switch (i3) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i3) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private boolean k(int i3) {
        Bundle bundleS = s();
        return bundleS != null && (bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i3) == i3;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> t(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayV = v(view);
        if (sparseArrayV != null) {
            return sparseArrayV;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(s.b.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> v(View view) {
        return (SparseArray) view.getTag(s.b.tag_accessibility_clickable_spans);
    }

    public static d x0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    private boolean y() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int z(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (clickableSpan.equals(sparseArray.valueAt(i3).get())) {
                    return sparseArray.keyAt(i3);
                }
            }
        }
        int i4 = f4638d;
        f4638d = i4 + 1;
        return i4;
    }

    public boolean A() {
        return this.f4639a.isCheckable();
    }

    public boolean B() {
        return this.f4639a.isChecked();
    }

    public boolean C() {
        return this.f4639a.isClickable();
    }

    public boolean D() {
        return this.f4639a.isEnabled();
    }

    public boolean E() {
        return this.f4639a.isFocusable();
    }

    public boolean F() {
        return this.f4639a.isFocused();
    }

    public boolean G() {
        return this.f4639a.isLongClickable();
    }

    public boolean H() {
        return this.f4639a.isPassword();
    }

    public boolean I() {
        return this.f4639a.isScrollable();
    }

    public boolean J() {
        return this.f4639a.isSelected();
    }

    public boolean K() {
        return Build.VERSION.SDK_INT >= 26 ? this.f4639a.isShowingHintText() : k(4);
    }

    public boolean O(int i3, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f4639a.performAction(i3, bundle);
        }
        return false;
    }

    public void P() {
        this.f4639a.recycle();
    }

    public void R(boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4639a.setAccessibilityFocused(z2);
        }
    }

    @Deprecated
    public void T(Rect rect) {
        this.f4639a.setBoundsInParent(rect);
    }

    public void U(Rect rect) {
        this.f4639a.setBoundsInScreen(rect);
    }

    public void V(boolean z2) {
        this.f4639a.setCheckable(z2);
    }

    public void W(boolean z2) {
        this.f4639a.setChecked(z2);
    }

    public void X(CharSequence charSequence) {
        this.f4639a.setClassName(charSequence);
    }

    public void Y(boolean z2) {
        this.f4639a.setClickable(z2);
    }

    public void Z(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4639a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f4668a);
        }
    }

    public void a(int i3) {
        this.f4639a.addAction(i3);
    }

    public void a0(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4639a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f4669a);
        }
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4639a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f4664a);
        }
    }

    public void b0(CharSequence charSequence) {
        this.f4639a.setContentDescription(charSequence);
    }

    public void c(View view, int i3) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4639a.addChild(view, i3);
        }
    }

    public void c0(boolean z2) {
        this.f4639a.setEnabled(z2);
    }

    public void d0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4639a.setError(charSequence);
        }
    }

    public void e(CharSequence charSequence, View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 19 || i3 >= 26) {
            return;
        }
        f();
        Q(view);
        ClickableSpan[] clickableSpanArrP = p(charSequence);
        if (clickableSpanArrP == null || clickableSpanArrP.length <= 0) {
            return;
        }
        s().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", s.b.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> sparseArrayT = t(view);
        for (int i4 = 0; i4 < clickableSpanArrP.length; i4++) {
            int iZ = z(clickableSpanArrP[i4], sparseArrayT);
            sparseArrayT.put(iZ, new WeakReference<>(clickableSpanArrP[i4]));
            d(clickableSpanArrP[i4], (Spanned) charSequence, iZ);
        }
    }

    public void e0(boolean z2) {
        this.f4639a.setFocusable(z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4639a;
        if (accessibilityNodeInfo == null) {
            if (dVar.f4639a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f4639a)) {
            return false;
        }
        return this.f4641c == dVar.f4641c && this.f4640b == dVar.f4640b;
    }

    public void f0(boolean z2) {
        this.f4639a.setFocused(z2);
    }

    public void g0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4639a.setHeading(z2);
        } else {
            S(2, z2);
        }
    }

    public List<a> h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f4639a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new a(actionList.get(i3)));
        }
        return arrayList;
    }

    public void h0(CharSequence charSequence) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            this.f4639a.setHintText(charSequence);
        } else if (i3 >= 19) {
            this.f4639a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4639a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f4639a.setLabelFor(view);
        }
    }

    public int j() {
        return this.f4639a.getActions();
    }

    public void j0(int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4639a.setMaxTextLength(i3);
        }
    }

    public void k0(CharSequence charSequence) {
        this.f4639a.setPackageName(charSequence);
    }

    @Deprecated
    public void l(Rect rect) {
        this.f4639a.getBoundsInParent(rect);
    }

    public void l0(CharSequence charSequence) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            this.f4639a.setPaneTitle(charSequence);
        } else if (i3 >= 19) {
            this.f4639a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void m(Rect rect) {
        this.f4639a.getBoundsInScreen(rect);
    }

    public void m0(View view) {
        this.f4640b = -1;
        this.f4639a.setParent(view);
    }

    public int n() {
        return this.f4639a.getChildCount();
    }

    public void n0(View view, int i3) {
        this.f4640b = i3;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4639a.setParent(view, i3);
        }
    }

    public CharSequence o() {
        return this.f4639a.getClassName();
    }

    public void o0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4639a.setScreenReaderFocusable(z2);
        } else {
            S(1, z2);
        }
    }

    public void p0(boolean z2) {
        this.f4639a.setScrollable(z2);
    }

    public c q() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.f4639a.getCollectionItemInfo()) == null) {
            return null;
        }
        return new c(collectionItemInfo);
    }

    public void q0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4639a.setShowingHintText(z2);
        } else {
            S(4, z2);
        }
    }

    public CharSequence r() {
        return this.f4639a.getContentDescription();
    }

    public void r0(View view, int i3) {
        this.f4641c = i3;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4639a.setSource(view, i3);
        }
    }

    public Bundle s() {
        return Build.VERSION.SDK_INT >= 19 ? this.f4639a.getExtras() : new Bundle();
    }

    public void s0(CharSequence charSequence) {
        if (a0.a.a()) {
            this.f4639a.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f4639a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void t0(CharSequence charSequence) {
        this.f4639a.setText(charSequence);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(u());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(w());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; viewId: ");
        sb.append(x());
        sb.append("; checkable: ");
        sb.append(A());
        sb.append("; checked: ");
        sb.append(B());
        sb.append("; focusable: ");
        sb.append(E());
        sb.append("; focused: ");
        sb.append(F());
        sb.append("; selected: ");
        sb.append(J());
        sb.append("; clickable: ");
        sb.append(C());
        sb.append("; longClickable: ");
        sb.append(G());
        sb.append("; enabled: ");
        sb.append(D());
        sb.append("; password: ");
        sb.append(H());
        sb.append("; scrollable: " + I());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> listH = h();
            for (int i3 = 0; i3 < listH.size(); i3++) {
                a aVar = listH.get(i3);
                String strI = i(aVar.b());
                if (strI.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    strI = aVar.c().toString();
                }
                sb.append(strI);
                if (i3 != listH.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int iJ = j();
            while (iJ != 0) {
                int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iJ);
                iJ &= ~iNumberOfTrailingZeros;
                sb.append(i(iNumberOfTrailingZeros));
                if (iJ != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f4639a.getPackageName();
    }

    public void u0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f4639a.setTraversalAfter(view);
        }
    }

    public void v0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4639a.setVisibleToUser(z2);
        }
    }

    public CharSequence w() {
        if (!y()) {
            return this.f4639a.getText();
        }
        List<Integer> listG = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listG2 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listG3 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listG4 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f4639a.getText(), 0, this.f4639a.getText().length()));
        for (int i3 = 0; i3 < listG.size(); i3++) {
            spannableString.setSpan(new f0.a(listG4.get(i3).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listG.get(i3).intValue(), listG2.get(i3).intValue(), listG3.get(i3).intValue());
        }
        return spannableString;
    }

    public AccessibilityNodeInfo w0() {
        return this.f4639a;
    }

    public String x() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f4639a.getViewIdResourceName();
        }
        return null;
    }
}
