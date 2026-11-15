package f0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4670a;

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f4671a;

        a(e eVar) {
            this.f4671a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
            d dVarB = this.f4671a.b(i3);
            if (dVarB == null) {
                return null;
            }
            return dVarB.w0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i3) {
            List<d> listC = this.f4671a.c(str, i3);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i4 = 0; i4 < size; i4++) {
                arrayList.add(listC.get(i4).w0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i3, int i4, Bundle bundle) {
            return this.f4671a.f(i3, i4, bundle);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i3) {
            d dVarD = this.f4671a.d(i3);
            if (dVarD == null) {
                return null;
            }
            return dVarD.w0();
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class c extends b {
        c(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f4671a.a(i3, d.x0(accessibilityNodeInfo), str, bundle);
        }
    }

    public e() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            this.f4670a = new c(this);
            return;
        }
        if (i3 >= 19) {
            this.f4670a = new b(this);
        } else if (i3 >= 16) {
            this.f4670a = new a(this);
        } else {
            this.f4670a = null;
        }
    }

    public void a(int i3, d dVar, String str, Bundle bundle) {
    }

    public d b(int i3) {
        return null;
    }

    public List<d> c(String str, int i3) {
        return null;
    }

    public d d(int i3) {
        return null;
    }

    public Object e() {
        return this.f4670a;
    }

    public boolean f(int i3, int i4, Bundle bundle) {
        return false;
    }

    public e(Object obj) {
        this.f4670a = obj;
    }
}
