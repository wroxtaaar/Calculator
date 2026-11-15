package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: ActionMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
class c extends androidx.appcompat.view.menu.a implements e0.b.a {
    a A;
    RunnableC0003c B;
    private b C;
    final f D;
    int E;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    d f543l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f547p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f548q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f549r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f550s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f551t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f552u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f553v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final SparseBooleanArray f556y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    e f557z;

    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, a.a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = c.this.f543l;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) c.this).f161j : view2);
            }
            j(c.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            c cVar = c.this;
            cVar.A = null;
            cVar.E = 0;
            super.e();
        }
    }

    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public h.e a() {
            a aVar = c.this.A;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class RunnableC0003c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f560b;

        public RunnableC0003c(e eVar) {
            this.f560b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) c.this).f155d != null) {
                ((androidx.appcompat.view.menu.a) c.this).f155d.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) c.this).f161j;
            if (view != null && view.getWindowToken() != null && this.f560b.m()) {
                c.this.f557z = this.f560b;
            }
            c.this.B = null;
        }
    }

    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class d extends o implements ActionMenuView.a {

        /* JADX INFO: compiled from: ActionMenuPresenter.java */
        class a extends h0 {

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ c f563k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, c cVar) {
                super(view);
                this.f563k = cVar;
            }

            @Override // androidx.appcompat.widget.h0
            public h.e b() {
                e eVar = c.this.f557z;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.h0
            public boolean c() {
                c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.h0
            public boolean d() {
                c cVar = c.this;
                if (cVar.B != null) {
                    return false;
                }
                cVar.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            y0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i3, int i4, int i5, int i6) {
            boolean frame = super.setFrame(i3, i4, i5, i6);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                x.a.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z2) {
            super(context, eVar, view, z2, a.a.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) c.this).f155d != null) {
                ((androidx.appcompat.view.menu.a) c.this).f155d.close();
            }
            c.this.f557z = null;
            super.e();
        }
    }

    /* JADX INFO: compiled from: ActionMenuPresenter.java */
    private class f implements androidx.appcompat.view.menu.j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z2) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.D().e(false);
            }
            androidx.appcompat.view.menu.j.a aVarM = c.this.m();
            if (aVarM != null) {
                aVarM.b(eVar, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) c.this).f155d) {
                return false;
            }
            c.this.E = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            androidx.appcompat.view.menu.j.a aVarM = c.this.m();
            if (aVarM != null) {
                return aVarM.c(eVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.f556y = new SparseBooleanArray();
        this.D = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f161j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof androidx.appcompat.view.menu.k.a) && ((androidx.appcompat.view.menu.k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f543l;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f545n) {
            return this.f544m;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        RunnableC0003c runnableC0003c = this.B;
        if (runnableC0003c != null && (obj = this.f161j) != null) {
            ((View) obj).removeCallbacks(runnableC0003c);
            this.B = null;
            return true;
        }
        e eVar = this.f557z;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.A;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.B != null || E();
    }

    public boolean E() {
        e eVar = this.f557z;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f551t) {
            this.f550s = g.a.b(this.f154c).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f155d;
        if (eVar != null) {
            eVar.K(true);
        }
    }

    public void G(boolean z2) {
        this.f554w = z2;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f161j = actionMenuView;
        actionMenuView.b(this.f155d);
    }

    public void I(Drawable drawable) {
        d dVar = this.f543l;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f545n = true;
            this.f544m = drawable;
        }
    }

    public void J(boolean z2) {
        this.f546o = z2;
        this.f547p = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f546o || E() || (eVar = this.f155d) == null || this.f161j == null || this.B != null || eVar.z().isEmpty()) {
            return false;
        }
        RunnableC0003c runnableC0003c = new RunnableC0003c(new e(this.f154c, this.f155d, this.f543l, true));
        this.B = runnableC0003c;
        ((View) this.f161j).post(runnableC0003c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void b(androidx.appcompat.view.menu.e eVar, boolean z2) {
        y();
        super.b(eVar, z2);
    }

    @Override // androidx.appcompat.view.menu.a
    public void c(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.k.a aVar) {
        aVar.e(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f161j);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.c] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.g] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.j
    public boolean d() {
        ArrayList<androidx.appcompat.view.menu.g> arrayListE;
        int size;
        int i3;
        int iL;
        ?? r3;
        c cVar = this;
        androidx.appcompat.view.menu.e eVar = cVar.f155d;
        View view = null;
        ?? r4 = 0;
        if (eVar != null) {
            arrayListE = eVar.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i4 = cVar.f550s;
        int i5 = cVar.f549r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f161j;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            androidx.appcompat.view.menu.g gVar = arrayListE.get(i8);
            if (gVar.o()) {
                i6++;
            } else if (gVar.n()) {
                i7++;
            } else {
                z2 = true;
            }
            if (cVar.f554w && gVar.isActionViewExpanded()) {
                i4 = 0;
            }
        }
        if (cVar.f546o && (z2 || i7 + i6 > i4)) {
            i4--;
        }
        int i9 = i4 - i6;
        SparseBooleanArray sparseBooleanArray = cVar.f556y;
        sparseBooleanArray.clear();
        if (cVar.f552u) {
            int i10 = cVar.f555x;
            iL = i5 / i10;
            i3 = i10 + ((i5 % i10) / iL);
        } else {
            i3 = 0;
            iL = 0;
        }
        int i11 = 0;
        int i12 = 0;
        ?? r5 = cVar;
        while (i11 < size) {
            androidx.appcompat.view.menu.g gVar2 = arrayListE.get(i11);
            if (gVar2.o()) {
                View viewN = r5.n(gVar2, view, viewGroup);
                if (r5.f552u) {
                    iL -= ActionMenuView.L(viewN, i3, iL, iMakeMeasureSpec, r4);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                r3 = r4;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i9 > 0 || z3) && i5 > 0 && (!r5.f552u || iL > 0);
                boolean z5 = z4;
                if (z4) {
                    View viewN2 = r5.n(gVar2, null, viewGroup);
                    if (r5.f552u) {
                        int iL2 = ActionMenuView.L(viewN2, i3, iL, iMakeMeasureSpec, 0);
                        iL -= iL2;
                        if (iL2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i12 == 0) {
                        i12 = measuredWidth2;
                    }
                    z4 = z6 & (!r5.f552u ? i5 + i12 <= 0 : i5 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i13 = 0; i13 < i11; i13++) {
                        androidx.appcompat.view.menu.g gVar3 = arrayListE.get(i13);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i9++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i9--;
                }
                gVar2.u(z4);
                r3 = 0;
            } else {
                r3 = r4;
                gVar2.u(r3);
            }
            i11++;
            r4 = r3;
            size = size;
            view = null;
            r5 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void e(Context context, androidx.appcompat.view.menu.e eVar) {
        super.e(context, eVar);
        Resources resources = context.getResources();
        g.a aVarB = g.a.b(context);
        if (!this.f547p) {
            this.f546o = aVarB.h();
        }
        if (!this.f553v) {
            this.f548q = aVarB.c();
        }
        if (!this.f551t) {
            this.f550s = aVarB.d();
        }
        int measuredWidth = this.f548q;
        if (this.f546o) {
            if (this.f543l == null) {
                d dVar = new d(this.f153b);
                this.f543l = dVar;
                if (this.f545n) {
                    dVar.setImageDrawable(this.f544m);
                    this.f544m = null;
                    this.f545n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f543l.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f543l.getMeasuredWidth();
        } else {
            this.f543l = null;
        }
        this.f549r = measuredWidth;
        this.f555x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean i(androidx.appcompat.view.menu.m mVar) {
        boolean z2 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.e0() != this.f155d) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.e0();
        }
        View viewZ = z(mVar2.getItem());
        if (viewZ == null) {
            return false;
        }
        this.E = mVar.getItem().getItemId();
        int size = mVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = mVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
        }
        a aVar = new a(this.f154c, mVar, viewZ);
        this.A = aVar;
        aVar.g(z2);
        this.A.k();
        super.i(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        super.j(z2);
        ((View) this.f161j).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f155d;
        boolean z3 = false;
        if (eVar != null) {
            ArrayList<androidx.appcompat.view.menu.g> arrayListS = eVar.s();
            int size = arrayListS.size();
            for (int i3 = 0; i3 < size; i3++) {
                e0.b bVarB = arrayListS.get(i3).b();
                if (bVarB != null) {
                    bVarB.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f155d;
        ArrayList<androidx.appcompat.view.menu.g> arrayListZ = eVar2 != null ? eVar2.z() : null;
        if (this.f546o && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z3 = !arrayListZ.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f543l == null) {
                this.f543l = new d(this.f153b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f543l.getParent();
            if (viewGroup != this.f161j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f543l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f161j;
                actionMenuView.addView(this.f543l, actionMenuView.F());
            }
        } else {
            d dVar = this.f543l;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f161j;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f543l);
                }
            }
        }
        ((ActionMenuView) this.f161j).setOverflowReserved(this.f546o);
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i3) {
        if (viewGroup.getChildAt(i3) == this.f543l) {
            return false;
        }
        return super.l(viewGroup, i3);
    }

    @Override // androidx.appcompat.view.menu.a
    public View n(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.f161j;
        androidx.appcompat.view.menu.k kVarO = super.o(viewGroup);
        if (kVar != kVarO) {
            ((ActionMenuView) kVarO).setPresenter(this);
        }
        return kVarO;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean q(int i3, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return C() | B();
    }
}
