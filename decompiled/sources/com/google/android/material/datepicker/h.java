package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.vivo.seckeysdk.SecurityKeyCipher;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public final class h<S> extends p<S> {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    static final Object f2858j0 = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    static final Object f2859k0 = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    static final Object f2860l0 = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    static final Object f2861m0 = "SELECTOR_TOGGLE_TAG";
    private int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private com.google.android.material.datepicker.d<S> f2862a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private com.google.android.material.datepicker.a f2863b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private com.google.android.material.datepicker.l f2864c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private k f2865d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private com.google.android.material.datepicker.c f2866e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private RecyclerView f2867f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private RecyclerView f2868g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private View f2869h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private View f2870i0;

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f2871b;

        a(int i3) {
            this.f2871b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f2868g0.q1(this.f2871b);
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class b extends e0.a {
        b() {
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            super.g(view, dVar);
            dVar.Z(null);
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class c extends q {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i3, boolean z2, int i4) {
            super(context, i3, z2);
            this.I = i4;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = h.this.f2868g0.getWidth();
                iArr[1] = h.this.f2868g0.getWidth();
            } else {
                iArr[0] = h.this.f2868g0.getHeight();
                iArr[1] = h.this.f2868g0.getHeight();
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class d implements l {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.h.l
        public void a(long j3) {
            if (h.this.f2863b0.o().e(j3)) {
                h.this.f2862a0.g(j3);
                Iterator<o<S>> it = h.this.Y.iterator();
                while (it.hasNext()) {
                    it.next().a(h.this.f2862a0.a());
                }
                h.this.f2868g0.getAdapter().j();
                if (h.this.f2867f0 != null) {
                    h.this.f2867f0.getAdapter().j();
                }
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class e extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Calendar f2875a = s.k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Calendar f2876b = s.k();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if ((recyclerView.getAdapter() instanceof t) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                t tVar = (t) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (d0.e<Long, Long> eVar : h.this.f2862a0.d()) {
                    Long l3 = eVar.f4502a;
                    if (l3 != null && eVar.f4503b != null) {
                        this.f2875a.setTimeInMillis(l3.longValue());
                        this.f2876b.setTimeInMillis(eVar.f4503b.longValue());
                        int iZ = tVar.z(this.f2875a.get(1));
                        int iZ2 = tVar.z(this.f2876b.get(1));
                        View viewC = gridLayoutManager.C(iZ);
                        View viewC2 = gridLayoutManager.C(iZ2);
                        int iX2 = iZ / gridLayoutManager.X2();
                        int iX3 = iZ2 / gridLayoutManager.X2();
                        int i3 = iX2;
                        while (i3 <= iX3) {
                            View viewC3 = gridLayoutManager.C(gridLayoutManager.X2() * i3);
                            if (viewC3 != null) {
                                canvas.drawRect(i3 == iX2 ? viewC.getLeft() + (viewC.getWidth() / 2) : 0, viewC3.getTop() + h.this.f2866e0.f2848d.c(), i3 == iX3 ? viewC2.getLeft() + (viewC2.getWidth() / 2) : recyclerView.getWidth(), viewC3.getBottom() - h.this.f2866e0.f2848d.b(), h.this.f2866e0.f2852h);
                            }
                            i3++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class f extends e0.a {
        f() {
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            super.g(view, dVar);
            dVar.h0(h.this.f2870i0.getVisibility() == 0 ? h.this.N(t0.i.mtrl_picker_toggle_to_year_selection) : h.this.N(t0.i.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class g extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f2879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f2880b;

        g(n nVar, MaterialButton materialButton) {
            this.f2879a = nVar;
            this.f2880b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                CharSequence text = this.f2880b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(SecurityKeyCipher.SECURITY_DATA_SIZE_MAX);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i3, int i4) {
            int iZ1 = i3 < 0 ? h.this.L1().Z1() : h.this.L1().c2();
            h.this.f2864c0 = this.f2879a.y(iZ1);
            this.f2880b.setText(this.f2879a.z(iZ1));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialCalendar.java */
    class ViewOnClickListenerC0038h implements View.OnClickListener {
        ViewOnClickListenerC0038h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.Q1();
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class i implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f2883b;

        i(n nVar) {
            this.f2883b = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iZ1 = h.this.L1().Z1() + 1;
            if (iZ1 < h.this.f2868g0.getAdapter().e()) {
                h.this.O1(this.f2883b.y(iZ1));
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f2885b;

        j(n nVar) {
            this.f2885b = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iC2 = h.this.L1().c2() - 1;
            if (iC2 >= 0) {
                h.this.O1(this.f2885b.y(iC2));
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    enum k {
        DAY,
        YEAR
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    interface l {
        void a(long j3);
    }

    private void D1(View view, n nVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(t0.f.month_navigation_fragment_toggle);
        materialButton.setTag(f2861m0);
        e0.t.m0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(t0.f.month_navigation_previous);
        materialButton2.setTag(f2859k0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(t0.f.month_navigation_next);
        materialButton3.setTag(f2860l0);
        this.f2869h0 = view.findViewById(t0.f.mtrl_calendar_year_selector_frame);
        this.f2870i0 = view.findViewById(t0.f.mtrl_calendar_day_selector_frame);
        P1(k.DAY);
        materialButton.setText(this.f2864c0.q());
        this.f2868g0.k(new g(nVar, materialButton));
        materialButton.setOnClickListener(new ViewOnClickListenerC0038h());
        materialButton3.setOnClickListener(new i(nVar));
        materialButton2.setOnClickListener(new j(nVar));
    }

    private RecyclerView.n E1() {
        return new e();
    }

    static int J1(Context context) {
        return context.getResources().getDimensionPixelSize(t0.d.mtrl_calendar_day_height);
    }

    private static int K1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(t0.d.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(t0.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(t0.d.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(t0.d.mtrl_calendar_days_of_week_height);
        int i3 = m.f2922g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(t0.d.mtrl_calendar_day_height) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(t0.d.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(t0.d.mtrl_calendar_bottom_padding);
    }

    public static <T> h<T> M1(com.google.android.material.datepicker.d<T> dVar, int i3, com.google.android.material.datepicker.a aVar) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.r());
        hVar.m1(bundle);
        return hVar;
    }

    private void N1(int i3) {
        this.f2868g0.post(new a(i3));
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Z);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f2862a0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2863b0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f2864c0);
    }

    com.google.android.material.datepicker.a F1() {
        return this.f2863b0;
    }

    com.google.android.material.datepicker.c G1() {
        return this.f2866e0;
    }

    com.google.android.material.datepicker.l H1() {
        return this.f2864c0;
    }

    public com.google.android.material.datepicker.d<S> I1() {
        return this.f2862a0;
    }

    LinearLayoutManager L1() {
        return (LinearLayoutManager) this.f2868g0.getLayoutManager();
    }

    void O1(com.google.android.material.datepicker.l lVar) {
        n nVar = (n) this.f2868g0.getAdapter();
        int iA = nVar.A(lVar);
        int iA2 = iA - nVar.A(this.f2864c0);
        boolean z2 = Math.abs(iA2) > 3;
        boolean z3 = iA2 > 0;
        this.f2864c0 = lVar;
        if (z2 && z3) {
            this.f2868g0.i1(iA - 3);
            N1(iA);
        } else if (!z2) {
            N1(iA);
        } else {
            this.f2868g0.i1(iA + 3);
            N1(iA);
        }
    }

    void P1(k kVar) {
        this.f2865d0 = kVar;
        if (kVar == k.YEAR) {
            this.f2867f0.getLayoutManager().x1(((t) this.f2867f0.getAdapter()).z(this.f2864c0.f2917d));
            this.f2869h0.setVisibility(0);
            this.f2870i0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.f2869h0.setVisibility(8);
            this.f2870i0.setVisibility(0);
            O1(this.f2864c0);
        }
    }

    void Q1() {
        k kVar = this.f2865d0;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            P1(k.DAY);
        } else if (kVar == k.DAY) {
            P1(kVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        if (bundle == null) {
            bundle = s();
        }
        this.Z = bundle.getInt("THEME_RES_ID_KEY");
        this.f2862a0 = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f2863b0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f2864c0 = (com.google.android.material.datepicker.l) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View l0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i4;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(u(), this.Z);
        this.f2866e0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.l lVarS = this.f2863b0.s();
        if (com.google.android.material.datepicker.i.U1(contextThemeWrapper)) {
            i3 = t0.h.mtrl_calendar_vertical;
            i4 = 1;
        } else {
            i3 = t0.h.mtrl_calendar_horizontal;
            i4 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i3, viewGroup, false);
        viewInflate.setMinimumHeight(K1(g1()));
        GridView gridView = (GridView) viewInflate.findViewById(t0.f.mtrl_calendar_days_of_week);
        e0.t.m0(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.g());
        gridView.setNumColumns(lVarS.f2918e);
        gridView.setEnabled(false);
        this.f2868g0 = (RecyclerView) viewInflate.findViewById(t0.f.mtrl_calendar_months);
        this.f2868g0.setLayoutManager(new c(u(), i4, false, i4));
        this.f2868g0.setTag(f2858j0);
        n nVar = new n(contextThemeWrapper, this.f2862a0, this.f2863b0, new d());
        this.f2868g0.setAdapter(nVar);
        int integer = contextThemeWrapper.getResources().getInteger(t0.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(t0.f.mtrl_calendar_year_selector_frame);
        this.f2867f0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f2867f0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f2867f0.setAdapter(new t(this));
            this.f2867f0.h(E1());
        }
        if (viewInflate.findViewById(t0.f.month_navigation_fragment_toggle) != null) {
            D1(viewInflate, nVar);
        }
        if (!com.google.android.material.datepicker.i.U1(contextThemeWrapper)) {
            new androidx.recyclerview.widget.j().b(this.f2868g0);
        }
        this.f2868g0.i1(nVar.A(this.f2864c0));
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.p
    public boolean u1(o<S> oVar) {
        return super.u1(oVar);
    }
}
