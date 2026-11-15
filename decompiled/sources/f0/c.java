package f0;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: compiled from: AccessibilityManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: compiled from: AccessibilityManagerCompat.java */
    public interface a {
        void onTouchExplorationStateChanged(boolean z2);
    }

    /* JADX INFO: compiled from: AccessibilityManagerCompat.java */
    private static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f4637a;

        b(a aVar) {
            this.f4637a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f4637a.equals(((b) obj).f4637a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4637a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z2) {
            this.f4637a.onTouchExplorationStateChanged(z2);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
