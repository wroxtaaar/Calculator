package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.l0;
import e0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CascadingMenuPopup.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends h implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = a.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Handler f168h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f176p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    View f177q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f179s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f180t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f181u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f182v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f184x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private j.a f185y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    ViewTreeObserver f186z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<e> f169i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final List<d> f170j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f171k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f172l = new ViewOnAttachStateChangeListenerC0001b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final k0 f173m = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f174n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f175o = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f183w = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f178r = D();

    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.c() || b.this.f170j.size() <= 0 || b.this.f170j.get(0).f194a.B()) {
                return;
            }
            View view = b.this.f177q;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator<d> it = b.this.f170j.iterator();
            while (it.hasNext()) {
                it.next().f194a.a();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    class ViewOnAttachStateChangeListenerC0001b implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0001b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f186z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f186z = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f186z.removeGlobalOnLayoutListener(bVar.f171k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    class c implements k0 {

        /* JADX INFO: compiled from: CascadingMenuPopup.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f190b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ MenuItem f191c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f192d;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f190b = dVar;
                this.f191c = menuItem;
                this.f192d = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f190b;
                if (dVar != null) {
                    b.this.B = true;
                    dVar.f195b.e(false);
                    b.this.B = false;
                }
                if (this.f191c.isEnabled() && this.f191c.hasSubMenu()) {
                    this.f192d.L(this.f191c, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.k0
        public void b(e eVar, MenuItem menuItem) {
            b.this.f168h.removeCallbacksAndMessages(null);
            int size = b.this.f170j.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (eVar == b.this.f170j.get(i3).f195b) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return;
            }
            int i4 = i3 + 1;
            b.this.f168h.postAtTime(new a(i4 < b.this.f170j.size() ? b.this.f170j.get(i4) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.k0
        public void i(e eVar, MenuItem menuItem) {
            b.this.f168h.removeCallbacksAndMessages(eVar);
        }
    }

    /* JADX INFO: compiled from: CascadingMenuPopup.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f196c;

        public d(l0 l0Var, e eVar, int i3) {
            this.f194a = l0Var;
            this.f195b = eVar;
            this.f196c = i3;
        }

        public ListView a() {
            return this.f194a.l();
        }
    }

    public b(Context context, View view, int i3, int i4, boolean z2) {
        this.f163c = context;
        this.f176p = view;
        this.f165e = i3;
        this.f166f = i4;
        this.f167g = z2;
        Resources resources = context.getResources();
        this.f164d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.f168h = new Handler();
    }

    private int A(e eVar) {
        int size = this.f170j.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (eVar == this.f170j.get(i3).f195b) {
                return i3;
            }
        }
        return -1;
    }

    private MenuItem B(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = eVar.getItem(i3);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(dVar.f195b, eVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            headersCount = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            }
            if (menuItemB == dVar2.getItem(i3)) {
                break;
            }
            i3++;
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return t.B(this.f176p) == 1 ? 0 : 1;
    }

    private int E(int i3) {
        List<d> list = this.f170j;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f177q.getWindowVisibleDisplayFrame(rect);
        if (this.f178r == 1) {
            return (iArr[0] + listViewA.getWidth()) + i3 > rect.right ? 0 : 1;
        }
        return iArr[0] - i3 < 0 ? 1 : 0;
    }

    private void F(e eVar) {
        d dVar;
        View viewC;
        int i3;
        int i4;
        int i5;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f163c);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.f167g, C);
        if (!c() && this.f183w) {
            dVar2.d(true);
        } else if (c()) {
            dVar2.d(h.x(eVar));
        }
        int iO = h.o(dVar2, null, this.f163c, this.f164d);
        l0 l0VarZ = z();
        l0VarZ.o(dVar2);
        l0VarZ.F(iO);
        l0VarZ.G(this.f175o);
        if (this.f170j.size() > 0) {
            List<d> list = this.f170j;
            dVar = list.get(list.size() - 1);
            viewC = C(dVar, eVar);
        } else {
            dVar = null;
            viewC = null;
        }
        if (viewC != null) {
            l0VarZ.U(false);
            l0VarZ.R(null);
            int iE = E(iO);
            boolean z2 = iE == 1;
            this.f178r = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                l0VarZ.D(viewC);
                i4 = 0;
                i3 = 0;
            } else {
                int[] iArr = new int[2];
                this.f176p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.f175o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f176p.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i3 = iArr2[0] - iArr[0];
                i4 = iArr2[1] - iArr[1];
            }
            if ((this.f175o & 5) == 5) {
                if (z2) {
                    i5 = i3 + iO;
                } else {
                    iO = viewC.getWidth();
                    i5 = i3 - iO;
                }
            } else if (z2) {
                iO = viewC.getWidth();
                i5 = i3 + iO;
            } else {
                i5 = i3 - iO;
            }
            l0VarZ.e(i5);
            l0VarZ.M(true);
            l0VarZ.n(i4);
        } else {
            if (this.f179s) {
                l0VarZ.e(this.f181u);
            }
            if (this.f180t) {
                l0VarZ.n(this.f182v);
            }
            l0VarZ.H(n());
        }
        this.f170j.add(new d(l0VarZ, eVar, this.f178r));
        l0VarZ.a();
        ListView listViewL = l0VarZ.l();
        listViewL.setOnKeyListener(this);
        if (dVar == null && this.f184x && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewL, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.x());
            listViewL.addHeaderView(frameLayout, null, false);
            l0VarZ.a();
        }
    }

    private l0 z() {
        l0 l0Var = new l0(this.f163c, null, this.f165e, this.f166f);
        l0Var.T(this.f173m);
        l0Var.L(this);
        l0Var.K(this);
        l0Var.D(this.f176p);
        l0Var.G(this.f175o);
        l0Var.J(true);
        l0Var.I(2);
        return l0Var;
    }

    @Override // h.e
    public void a() {
        if (c()) {
            return;
        }
        Iterator<e> it = this.f169i.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.f169i.clear();
        View view = this.f176p;
        this.f177q = view;
        if (view != null) {
            boolean z2 = this.f186z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f186z = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f171k);
            }
            this.f177q.addOnAttachStateChangeListener(this.f172l);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z2) {
        int iA = A(eVar);
        if (iA < 0) {
            return;
        }
        int i3 = iA + 1;
        if (i3 < this.f170j.size()) {
            this.f170j.get(i3).f195b.e(false);
        }
        d dVarRemove = this.f170j.remove(iA);
        dVarRemove.f195b.O(this);
        if (this.B) {
            dVarRemove.f194a.S(null);
            dVarRemove.f194a.E(0);
        }
        dVarRemove.f194a.dismiss();
        int size = this.f170j.size();
        if (size > 0) {
            this.f178r = this.f170j.get(size - 1).f196c;
        } else {
            this.f178r = D();
        }
        if (size != 0) {
            if (z2) {
                this.f170j.get(0).f195b.e(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f185y;
        if (aVar != null) {
            aVar.b(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f186z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f186z.removeGlobalOnLayoutListener(this.f171k);
            }
            this.f186z = null;
        }
        this.f177q.removeOnAttachStateChangeListener(this.f172l);
        this.A.onDismiss();
    }

    @Override // h.e
    public boolean c() {
        return this.f170j.size() > 0 && this.f170j.get(0).f194a.c();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean d() {
        return false;
    }

    @Override // h.e
    public void dismiss() {
        int size = this.f170j.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f170j.toArray(new d[size]);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                d dVar = dVarArr[i3];
                if (dVar.f194a.c()) {
                    dVar.f194a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f185y = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        for (d dVar : this.f170j) {
            if (mVar == dVar.f195b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        k(mVar);
        j.a aVar = this.f185y;
        if (aVar != null) {
            aVar.c(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        Iterator<d> it = this.f170j.iterator();
        while (it.hasNext()) {
            h.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void k(e eVar) {
        eVar.c(this, this.f163c);
        if (c()) {
            F(eVar);
        } else {
            this.f169i.add(eVar);
        }
    }

    @Override // h.e
    public ListView l() {
        if (this.f170j.isEmpty()) {
            return null;
        }
        List<d> list = this.f170j;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f170j.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f170j.get(i3);
            if (!dVar.f194a.c()) {
                break;
            } else {
                i3++;
            }
        }
        if (dVar != null) {
            dVar.f195b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i3 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void p(View view) {
        if (this.f176p != view) {
            this.f176p = view;
            this.f175o = e0.d.b(this.f174n, t.B(view));
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z2) {
        this.f183w = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i3) {
        if (this.f174n != i3) {
            this.f174n = i3;
            this.f175o = e0.d.b(i3, t.B(this.f176p));
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i3) {
        this.f179s = true;
        this.f181u = i3;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z2) {
        this.f184x = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i3) {
        this.f180t = true;
        this.f182v = i3;
    }
}
