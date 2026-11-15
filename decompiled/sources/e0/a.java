package e0;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f4513c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f4514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f4515b;

    /* JADX INFO: renamed from: e0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
    static final class C0055a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f4516a;

        C0055a(a aVar) {
            this.f4516a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f4516a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            f0.e eVarB = this.f4516a.b(view);
            if (eVarB != null) {
                return (AccessibilityNodeProvider) eVarB.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4516a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            f0.d dVarX0 = f0.d.x0(accessibilityNodeInfo);
            dVarX0.o0(t.V(view));
            dVarX0.g0(t.Q(view));
            dVarX0.l0(t.p(view));
            dVarX0.s0(t.I(view));
            this.f4516a.g(view, dVarX0);
            dVarX0.e(accessibilityNodeInfo.getText(), view);
            List<f0.d.a> listC = a.c(view);
            for (int i3 = 0; i3 < listC.size(); i3++) {
                dVarX0.b(listC.get(i3));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4516a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f4516a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            return this.f4516a.j(view, i3, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            this.f4516a.l(view, i3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f4516a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(f4513c);
    }

    static List<f0.d.a> c(View view) {
        List<f0.d.a> list = (List) view.getTag(s.b.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrP = f0.d.p(view.createAccessibilityNodeInfo().getText());
            for (int i3 = 0; clickableSpanArrP != null && i3 < clickableSpanArrP.length; i3++) {
                if (clickableSpan.equals(clickableSpanArrP[i3])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i3, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(s.b.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i3)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f4514a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public f0.e b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f4514a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new f0.e(accessibilityNodeProvider);
    }

    View.AccessibilityDelegate d() {
        return this.f4515b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f4514a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, f0.d dVar) {
        this.f4514a.onInitializeAccessibilityNodeInfo(view, dVar.w0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f4514a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f4514a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i3, Bundle bundle) {
        List<f0.d.a> listC = c(view);
        boolean zPerformAccessibilityAction = false;
        for (int i4 = 0; i4 < listC.size(); i4++) {
            f0.d.a aVar = listC.get(i4);
            if (aVar.b() == i3) {
                zPerformAccessibilityAction = aVar.d(view, bundle);
                break;
            }
        }
        if (!zPerformAccessibilityAction && Build.VERSION.SDK_INT >= 16) {
            zPerformAccessibilityAction = this.f4514a.performAccessibilityAction(view, i3, bundle);
        }
        return (zPerformAccessibilityAction || i3 != s.b.accessibility_action_clickable_span) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i3) {
        this.f4514a.sendAccessibilityEvent(view, i3);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f4514a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f4514a = accessibilityDelegate;
        this.f4515b = new C0055a(this);
    }
}
