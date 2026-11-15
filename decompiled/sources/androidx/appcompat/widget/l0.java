package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MenuPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class l0 extends j0 implements k0 {
    private static Method L;
    private k0 K;

    /* JADX INFO: compiled from: MenuPopupWindow.java */
    public static class a extends f0 {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final int f682p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final int f683q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private k0 f684r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private MenuItem f685s;

        public a(Context context, boolean z2) {
            super(context, z2);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f682p = 22;
                this.f683q = 21;
            } else {
                this.f682p = 21;
                this.f683q = 22;
            }
        }

        @Override // androidx.appcompat.widget.f0
        public /* bridge */ /* synthetic */ int d(int i3, int i4, int i5, int i6, int i7) {
            return super.d(i3, i4, i5, i6, i7);
        }

        @Override // androidx.appcompat.widget.f0
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i3) {
            return super.e(motionEvent, i3);
        }

        @Override // androidx.appcompat.widget.f0, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            androidx.appcompat.view.menu.d dVar;
            int iPointToPosition;
            int i3;
            if (this.f684r != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                }
                androidx.appcompat.view.menu.g item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = iPointToPosition - headersCount) >= 0 && i3 < dVar.getCount()) {
                    item = dVar.getItem(i3);
                }
                MenuItem menuItem = this.f685s;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e eVarB = dVar.b();
                    if (menuItem != null) {
                        this.f684r.i(eVarB, menuItem);
                    }
                    this.f685s = item;
                    if (item != null) {
                        this.f684r.b(eVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i3, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i3 == this.f682p) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i3 != this.f683q) {
                return super.onKeyDown(i3, keyEvent);
            }
            setSelection(-1);
            ((androidx.appcompat.view.menu.d) getAdapter()).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.f0, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(k0 k0Var) {
            this.f684r = k0Var;
        }

        @Override // androidx.appcompat.widget.f0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public l0(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    public void R(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.G.setEnterTransition((Transition) obj);
        }
    }

    public void S(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.G.setExitTransition((Transition) obj);
        }
    }

    public void T(k0 k0Var) {
        this.K = k0Var;
    }

    public void U(boolean z2) {
        if (Build.VERSION.SDK_INT > 28) {
            this.G.setTouchModal(z2);
            return;
        }
        Method method = L;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z2));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.k0
    public void b(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        k0 k0Var = this.K;
        if (k0Var != null) {
            k0Var.b(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.k0
    public void i(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        k0 k0Var = this.K;
        if (k0Var != null) {
            k0Var.i(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.j0
    f0 s(Context context, boolean z2) {
        a aVar = new a(context, z2);
        aVar.setHoverListener(this);
        return aVar;
    }
}
