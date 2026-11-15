package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: AppCompatPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
class q extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f736b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f737a;

    static {
        f736b = Build.VERSION.SDK_INT < 21;
    }

    public q(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        a(context, attributeSet, i3, i4);
    }

    private void a(Context context, AttributeSet attributeSet, int i3, int i4) {
        w0 w0VarV = w0.v(context, attributeSet, a.j.PopupWindow, i3, i4);
        int i5 = a.j.PopupWindow_overlapAnchor;
        if (w0VarV.s(i5)) {
            b(w0VarV.a(i5, false));
        }
        setBackgroundDrawable(w0VarV.g(a.j.PopupWindow_android_popupBackground));
        w0VarV.w();
    }

    private void b(boolean z2) {
        if (f736b) {
            this.f737a = z2;
        } else {
            androidx.core.widget.h.a(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4) {
        if (f736b && this.f737a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i3, int i4, int i5, int i6) {
        if (f736b && this.f737a) {
            i4 -= view.getHeight();
        }
        super.update(view, i3, i4, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4, int i5) {
        if (f736b && this.f737a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4, i5);
    }
}
