package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import n0.h;
import n0.i;
import n0.k;
import n0.l;

/* JADX INFO: compiled from: PreferenceFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends Fragment implements androidx.preference.f.c, androidx.preference.f.a, androidx.preference.f.b, DialogPreference.a {
    private androidx.preference.f Y;
    RecyclerView Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f1644a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f1645b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Context f1646c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f1647d0 = i.preference_list_fragment;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final C0016c f1648e0 = new C0016c();

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Handler f1649f0 = new a();

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final Runnable f1650g0 = new b();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Runnable f1651h0;

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            c.this.v1();
        }
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    class b implements Runnable {
        b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = c.this.Z;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* JADX INFO: renamed from: androidx.preference.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    private class C0016c extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f1654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1656c = true;

        C0016c() {
        }

        private boolean m(View view, RecyclerView recyclerView) {
            RecyclerView.d0 d0VarF0 = recyclerView.f0(view);
            boolean z2 = false;
            if (!((d0VarF0 instanceof g) && ((g) d0VarF0).O())) {
                return false;
            }
            boolean z3 = this.f1656c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z3;
            }
            RecyclerView.d0 d0VarF1 = recyclerView.f0(recyclerView.getChildAt(iIndexOfChild + 1));
            if ((d0VarF1 instanceof g) && ((g) d0VarF1).N()) {
                z2 = true;
            }
            return z2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if (m(view, recyclerView)) {
                rect.bottom = this.f1655b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if (this.f1654a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (m(childAt, recyclerView)) {
                    int y3 = ((int) childAt.getY()) + childAt.getHeight();
                    this.f1654a.setBounds(0, y3, width, this.f1655b + y3);
                    this.f1654a.draw(canvas);
                }
            }
        }

        public void j(boolean z2) {
            this.f1656c = z2;
        }

        public void k(Drawable drawable) {
            if (drawable != null) {
                this.f1655b = drawable.getIntrinsicHeight();
            } else {
                this.f1655b = 0;
            }
            this.f1654a = drawable;
            c.this.Z.t0();
        }

        public void l(int i3) {
            this.f1655b = i3;
            c.this.Z.t0();
        }
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    public interface d {
        boolean a(c cVar, Preference preference);
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    public interface e {
        boolean a(c cVar, Preference preference);
    }

    /* JADX INFO: compiled from: PreferenceFragmentCompat.java */
    public interface f {
        boolean a(c cVar, PreferenceScreen preferenceScreen);
    }

    private void F1() {
        if (this.f1649f0.hasMessages(1)) {
            return;
        }
        this.f1649f0.obtainMessage(1).sendToTarget();
    }

    private void G1() {
        if (this.Y == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void K1() {
        PreferenceScreen preferenceScreenY1 = y1();
        if (preferenceScreenY1 != null) {
            preferenceScreenY1.Q();
        }
        E1();
    }

    protected RecyclerView.g A1(PreferenceScreen preferenceScreen) {
        return new androidx.preference.d(preferenceScreen);
    }

    public RecyclerView.o B1() {
        return new LinearLayoutManager(n());
    }

    public abstract void C1(Bundle bundle, String str);

    @Override // androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        PreferenceScreen preferenceScreenY1 = y1();
        if (preferenceScreenY1 != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenY1.h0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public RecyclerView D1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.f1646c0.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(h.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(i.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(B1());
        recyclerView2.setAccessibilityDelegateCompat(new n0.e(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    public void E0() {
        super.E0();
        this.Y.q(this);
        this.Y.o(this);
    }

    protected void E1() {
    }

    @Override // androidx.fragment.app.Fragment
    public void F0() {
        super.F0();
        this.Y.q(null);
        this.Y.o(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void G0(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenY1;
        super.G0(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenY1 = y1()) != null) {
            preferenceScreenY1.g0(bundle2);
        }
        if (this.f1644a0) {
            v1();
            Runnable runnable = this.f1651h0;
            if (runnable != null) {
                runnable.run();
                this.f1651h0 = null;
            }
        }
        this.f1645b0 = true;
    }

    public void H1(Drawable drawable) {
        this.f1648e0.k(drawable);
    }

    public void I1(int i3) {
        this.f1648e0.l(i3);
    }

    public void J1(PreferenceScreen preferenceScreen) {
        if (!this.Y.r(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        E1();
        this.f1644a0 = true;
        if (this.f1645b0) {
            F1();
        }
    }

    @Override // androidx.preference.f.a
    public void e(Preference preference) {
        androidx.fragment.app.c cVarM1;
        boolean zA = w1() instanceof d ? ((d) w1()).a(this, preference) : false;
        if (!zA && (n() instanceof d)) {
            zA = ((d) n()).a(this, preference);
        }
        if (!zA && z().X("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                cVarM1 = n0.a.M1(preference.o());
            } else if (preference instanceof ListPreference) {
                cVarM1 = n0.b.M1(preference.o());
            } else {
                if (!(preference instanceof AbstractMultiSelectListPreference)) {
                    throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
                }
                cVarM1 = n0.c.M1(preference.o());
            }
            cVarM1.s1(this, 0);
            cVarM1.D1(z(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // androidx.preference.f.b
    public void f(PreferenceScreen preferenceScreen) {
        if ((w1() instanceof f ? ((f) w1()).a(this, preferenceScreen) : false) || !(n() instanceof f)) {
            return;
        }
        ((f) n()).a(this, preferenceScreen);
    }

    @Override // androidx.preference.f.c
    public boolean g(Preference preference) {
        if (preference.l() == null) {
            return false;
        }
        boolean zA = w1() instanceof e ? ((e) w1()).a(this, preference) : false;
        return (zA || !(n() instanceof e)) ? zA : ((e) n()).a(this, preference);
    }

    @Override // androidx.preference.DialogPreference.a
    public Preference h(CharSequence charSequence) {
        androidx.preference.f fVar = this.Y;
        if (fVar == null) {
            return null;
        }
        return fVar.a(charSequence);
    }

    @Override // androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        TypedValue typedValue = new TypedValue();
        n().getTheme().resolveAttribute(n0.f.preferenceTheme, typedValue, true);
        int i3 = typedValue.resourceId;
        if (i3 == 0) {
            i3 = k.PreferenceThemeOverlay;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(n(), i3);
        this.f1646c0 = contextThemeWrapper;
        androidx.preference.f fVar = new androidx.preference.f(contextThemeWrapper);
        this.Y = fVar;
        fVar.p(this);
        C1(bundle, s() != null ? s().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public View l0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = this.f1646c0.obtainStyledAttributes(null, l.PreferenceFragmentCompat, n0.f.preferenceFragmentCompatStyle, 0);
        this.f1647d0 = typedArrayObtainStyledAttributes.getResourceId(l.PreferenceFragmentCompat_android_layout, this.f1647d0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(l.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(l.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(this.f1646c0);
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f1647d0, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewD1 = D1(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewD1 == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.Z = recyclerViewD1;
        recyclerViewD1.h(this.f1648e0);
        H1(drawable);
        if (dimensionPixelSize != -1) {
            I1(dimensionPixelSize);
        }
        this.f1648e0.j(z2);
        if (this.Z.getParent() == null) {
            viewGroup2.addView(this.Z);
        }
        this.f1649f0.post(this.f1650g0);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void o0() {
        this.f1649f0.removeCallbacks(this.f1650g0);
        this.f1649f0.removeMessages(1);
        if (this.f1644a0) {
            K1();
        }
        this.Z = null;
        super.o0();
    }

    public void u1(int i3) {
        G1();
        J1(this.Y.m(this.f1646c0, i3, y1()));
    }

    void v1() {
        PreferenceScreen preferenceScreenY1 = y1();
        if (preferenceScreenY1 != null) {
            x1().setAdapter(A1(preferenceScreenY1));
            preferenceScreenY1.K();
        }
        z1();
    }

    public Fragment w1() {
        return null;
    }

    public final RecyclerView x1() {
        return this.Z;
    }

    public PreferenceScreen y1() {
        return this.Y.k();
    }

    protected void z1() {
    }
}
