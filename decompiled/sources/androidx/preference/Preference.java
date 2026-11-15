package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import n0.h;
import n0.i;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private c H;
    private List<Preference> I;
    private PreferenceGroup J;
    private boolean K;
    private boolean L;
    private final View.OnClickListener M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f1596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d f1599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f1600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f1603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f1604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f1606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f1607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Intent f1608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f1609p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Bundle f1610q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1611r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1612s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1613t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f1614u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Object f1615v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1616w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1617x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1618y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1619z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.Z(view);
        }
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        static class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface c {
        void a(Preference preference);

        void b(Preference preference);
    }

    public interface d {
        boolean a(Preference preference, Object obj);
    }

    public interface e {
        boolean a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f1601h = Integer.MAX_VALUE;
        this.f1602i = 0;
        this.f1611r = true;
        this.f1612s = true;
        this.f1613t = true;
        this.f1616w = true;
        this.f1617x = true;
        this.f1618y = true;
        this.f1619z = true;
        this.A = true;
        this.C = true;
        this.E = true;
        int i5 = i.preference;
        this.F = i5;
        this.M = new a();
        this.f1595b = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.Preference, i3, i4);
        this.f1605l = v.g.n(typedArrayObtainStyledAttributes, l.Preference_icon, l.Preference_android_icon, 0);
        this.f1607n = v.g.o(typedArrayObtainStyledAttributes, l.Preference_key, l.Preference_android_key);
        this.f1603j = v.g.p(typedArrayObtainStyledAttributes, l.Preference_title, l.Preference_android_title);
        this.f1604k = v.g.p(typedArrayObtainStyledAttributes, l.Preference_summary, l.Preference_android_summary);
        this.f1601h = v.g.d(typedArrayObtainStyledAttributes, l.Preference_order, l.Preference_android_order, Integer.MAX_VALUE);
        this.f1609p = v.g.o(typedArrayObtainStyledAttributes, l.Preference_fragment, l.Preference_android_fragment);
        this.F = v.g.n(typedArrayObtainStyledAttributes, l.Preference_layout, l.Preference_android_layout, i5);
        this.G = v.g.n(typedArrayObtainStyledAttributes, l.Preference_widgetLayout, l.Preference_android_widgetLayout, 0);
        this.f1611r = v.g.b(typedArrayObtainStyledAttributes, l.Preference_enabled, l.Preference_android_enabled, true);
        this.f1612s = v.g.b(typedArrayObtainStyledAttributes, l.Preference_selectable, l.Preference_android_selectable, true);
        this.f1613t = v.g.b(typedArrayObtainStyledAttributes, l.Preference_persistent, l.Preference_android_persistent, true);
        this.f1614u = v.g.o(typedArrayObtainStyledAttributes, l.Preference_dependency, l.Preference_android_dependency);
        int i6 = l.Preference_allowDividerAbove;
        this.f1619z = v.g.b(typedArrayObtainStyledAttributes, i6, i6, this.f1612s);
        int i7 = l.Preference_allowDividerBelow;
        this.A = v.g.b(typedArrayObtainStyledAttributes, i7, i7, this.f1612s);
        int i8 = l.Preference_defaultValue;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.f1615v = R(typedArrayObtainStyledAttributes, i8);
        } else {
            int i9 = l.Preference_android_defaultValue;
            if (typedArrayObtainStyledAttributes.hasValue(i9)) {
                this.f1615v = R(typedArrayObtainStyledAttributes, i9);
            }
        }
        this.E = v.g.b(typedArrayObtainStyledAttributes, l.Preference_shouldDisableView, l.Preference_android_shouldDisableView, true);
        int i10 = l.Preference_singleLineTitle;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i10);
        this.B = zHasValue;
        if (zHasValue) {
            this.C = v.g.b(typedArrayObtainStyledAttributes, i10, l.Preference_android_singleLineTitle, true);
        }
        this.D = v.g.b(typedArrayObtainStyledAttributes, l.Preference_iconSpaceReserved, l.Preference_android_iconSpaceReserved, false);
        int i11 = l.Preference_isPreferenceVisible;
        this.f1618y = v.g.b(typedArrayObtainStyledAttributes, i11, i11, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void e0() {
        if (TextUtils.isEmpty(this.f1614u)) {
            return;
        }
        Preference preferenceH = h(this.f1614u);
        if (preferenceH != null) {
            preferenceH.f0(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.f1614u + "\" not found for preference \"" + this.f1607n + "\" (title: \"" + ((Object) this.f1603j) + "\"");
    }

    private void f0(Preference preference) {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.add(preference);
        preference.P(this, u0());
    }

    private void g() {
        w();
        if (v0() && y().contains(this.f1607n)) {
            X(true, null);
            return;
        }
        Object obj = this.f1615v;
        if (obj != null) {
            X(false, obj);
        }
    }

    private void i0(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                i0(viewGroup.getChildAt(childCount), z2);
            }
        }
    }

    private void w0(SharedPreferences.Editor editor) {
        if (this.f1596c.t()) {
            editor.apply();
        }
    }

    private void x0() {
        Preference preferenceH;
        String str = this.f1614u;
        if (str == null || (preferenceH = h(str)) == null) {
            return;
        }
        preferenceH.y0(this);
    }

    private void y0(Preference preference) {
        List<Preference> list = this.I;
        if (list != null) {
            list.remove(preference);
        }
    }

    public CharSequence A() {
        return this.f1603j;
    }

    public final int B() {
        return this.G;
    }

    public boolean C() {
        return !TextUtils.isEmpty(this.f1607n);
    }

    public boolean D() {
        return this.f1611r && this.f1616w && this.f1617x;
    }

    public boolean E() {
        return this.f1613t;
    }

    public boolean F() {
        return this.f1612s;
    }

    public final boolean G() {
        return this.f1618y;
    }

    protected void H() {
        c cVar = this.H;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public void I(boolean z2) {
        List<Preference> list = this.I;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            list.get(i3).P(this, z2);
        }
    }

    protected void J() {
        c cVar = this.H;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public void K() {
        e0();
    }

    protected void L(f fVar) {
        this.f1596c = fVar;
        if (!this.f1598e) {
            this.f1597d = fVar.f();
        }
        g();
    }

    protected void M(f fVar, long j3) {
        this.f1597d = j3;
        this.f1598e = true;
        try {
            L(fVar);
        } finally {
            this.f1598e = false;
        }
    }

    public void N(g gVar) {
        gVar.f1813a.setOnClickListener(this.M);
        gVar.f1813a.setId(this.f1602i);
        TextView textView = (TextView) gVar.M(R.id.title);
        if (textView != null) {
            CharSequence charSequenceA = A();
            if (TextUtils.isEmpty(charSequenceA)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequenceA);
                textView.setVisibility(0);
                if (this.B) {
                    textView.setSingleLine(this.C);
                }
            }
        }
        TextView textView2 = (TextView) gVar.M(R.id.summary);
        if (textView2 != null) {
            CharSequence charSequenceZ = z();
            if (TextUtils.isEmpty(charSequenceZ)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequenceZ);
                textView2.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) gVar.M(R.id.icon);
        if (imageView != null) {
            if (this.f1605l != 0 || this.f1606m != null) {
                if (this.f1606m == null) {
                    this.f1606m = u.a.d(i(), this.f1605l);
                }
                Drawable drawable = this.f1606m;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f1606m != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.D ? 4 : 8);
            }
        }
        View viewM = gVar.M(h.icon_frame);
        if (viewM == null) {
            viewM = gVar.M(R.id.icon_frame);
        }
        if (viewM != null) {
            if (this.f1606m != null) {
                viewM.setVisibility(0);
            } else {
                viewM.setVisibility(this.D ? 4 : 8);
            }
        }
        if (this.E) {
            i0(gVar.f1813a, D());
        } else {
            i0(gVar.f1813a, true);
        }
        boolean zF = F();
        gVar.f1813a.setFocusable(zF);
        gVar.f1813a.setClickable(zF);
        gVar.P(this.f1619z);
        gVar.Q(this.A);
    }

    protected void O() {
    }

    public void P(Preference preference, boolean z2) {
        if (this.f1616w == z2) {
            this.f1616w = !z2;
            I(u0());
            H();
        }
    }

    public void Q() {
        x0();
        this.K = true;
    }

    protected Object R(TypedArray typedArray, int i3) {
        return null;
    }

    public void S(f0.d dVar) {
    }

    public void T(Preference preference, boolean z2) {
        if (this.f1617x == z2) {
            this.f1617x = !z2;
            I(u0());
            H();
        }
    }

    protected void U(Parcelable parcelable) {
        this.L = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable V() {
        this.L = true;
        return AbsSavedState.EMPTY_STATE;
    }

    protected void W(Object obj) {
    }

    @Deprecated
    protected void X(boolean z2, Object obj) {
        W(obj);
    }

    public void Y() {
        f.c cVarH;
        if (D()) {
            O();
            e eVar = this.f1600g;
            if (eVar == null || !eVar.a(this)) {
                f fVarX = x();
                if ((fVarX == null || (cVarH = fVarX.h()) == null || !cVarH.g(this)) && this.f1608o != null) {
                    i().startActivity(this.f1608o);
                }
            }
        }
    }

    protected void Z(View view) {
        Y();
    }

    void a(PreferenceGroup preferenceGroup) {
        this.J = preferenceGroup;
    }

    protected boolean a0(boolean z2) {
        if (!v0()) {
            return false;
        }
        if (z2 == s(!z2)) {
            return true;
        }
        w();
        SharedPreferences.Editor editorE = this.f1596c.e();
        editorE.putBoolean(this.f1607n, z2);
        w0(editorE);
        return true;
    }

    public boolean b(Object obj) {
        d dVar = this.f1599f;
        return dVar == null || dVar.a(this, obj);
    }

    protected boolean b0(int i3) {
        if (!v0()) {
            return false;
        }
        if (i3 == t(~i3)) {
            return true;
        }
        w();
        SharedPreferences.Editor editorE = this.f1596c.e();
        editorE.putInt(this.f1607n, i3);
        w0(editorE);
        return true;
    }

    public final void c() {
        this.K = false;
    }

    protected boolean c0(String str) {
        if (!v0()) {
            return false;
        }
        if (TextUtils.equals(str, u(null))) {
            return true;
        }
        w();
        SharedPreferences.Editor editorE = this.f1596c.e();
        editorE.putString(this.f1607n, str);
        w0(editorE);
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i3 = this.f1601h;
        int i4 = preference.f1601h;
        if (i3 != i4) {
            return i3 - i4;
        }
        CharSequence charSequence = this.f1603j;
        CharSequence charSequence2 = preference.f1603j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f1603j.toString());
    }

    public boolean d0(Set<String> set) {
        if (!v0()) {
            return false;
        }
        if (set.equals(v(null))) {
            return true;
        }
        w();
        SharedPreferences.Editor editorE = this.f1596c.e();
        editorE.putStringSet(this.f1607n, set);
        w0(editorE);
        return true;
    }

    void e(Bundle bundle) {
        Parcelable parcelable;
        if (!C() || (parcelable = bundle.getParcelable(this.f1607n)) == null) {
            return;
        }
        this.L = false;
        U(parcelable);
        if (!this.L) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    void f(Bundle bundle) {
        if (C()) {
            this.L = false;
            Parcelable parcelableV = V();
            if (!this.L) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableV != null) {
                bundle.putParcelable(this.f1607n, parcelableV);
            }
        }
    }

    public void g0(Bundle bundle) {
        e(bundle);
    }

    protected Preference h(String str) {
        f fVar;
        if (TextUtils.isEmpty(str) || (fVar = this.f1596c) == null) {
            return null;
        }
        return fVar.a(str);
    }

    public void h0(Bundle bundle) {
        f(bundle);
    }

    public Context i() {
        return this.f1595b;
    }

    public Bundle j() {
        if (this.f1610q == null) {
            this.f1610q = new Bundle();
        }
        return this.f1610q;
    }

    public void j0(int i3) {
        k0(u.a.d(this.f1595b, i3));
        this.f1605l = i3;
    }

    StringBuilder k() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceA = A();
        if (!TextUtils.isEmpty(charSequenceA)) {
            sb.append(charSequenceA);
            sb.append(' ');
        }
        CharSequence charSequenceZ = z();
        if (!TextUtils.isEmpty(charSequenceZ)) {
            sb.append(charSequenceZ);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void k0(Drawable drawable) {
        if ((drawable != null || this.f1606m == null) && (drawable == null || this.f1606m == drawable)) {
            return;
        }
        this.f1606m = drawable;
        this.f1605l = 0;
        H();
    }

    public String l() {
        return this.f1609p;
    }

    public void l0(Intent intent) {
        this.f1608o = intent;
    }

    long m() {
        return this.f1597d;
    }

    public void m0(int i3) {
        this.F = i3;
    }

    public Intent n() {
        return this.f1608o;
    }

    final void n0(c cVar) {
        this.H = cVar;
    }

    public String o() {
        return this.f1607n;
    }

    public void o0(d dVar) {
        this.f1599f = dVar;
    }

    public final int p() {
        return this.F;
    }

    public void p0(e eVar) {
        this.f1600g = eVar;
    }

    public int q() {
        return this.f1601h;
    }

    public void q0(int i3) {
        if (i3 != this.f1601h) {
            this.f1601h = i3;
            J();
        }
    }

    public PreferenceGroup r() {
        return this.J;
    }

    public void r0(CharSequence charSequence) {
        if ((charSequence != null || this.f1604k == null) && (charSequence == null || charSequence.equals(this.f1604k))) {
            return;
        }
        this.f1604k = charSequence;
        H();
    }

    protected boolean s(boolean z2) {
        if (!v0()) {
            return z2;
        }
        w();
        return this.f1596c.l().getBoolean(this.f1607n, z2);
    }

    public void s0(int i3) {
        t0(this.f1595b.getString(i3));
    }

    protected int t(int i3) {
        if (!v0()) {
            return i3;
        }
        w();
        return this.f1596c.l().getInt(this.f1607n, i3);
    }

    public void t0(CharSequence charSequence) {
        if ((charSequence != null || this.f1603j == null) && (charSequence == null || charSequence.equals(this.f1603j))) {
            return;
        }
        this.f1603j = charSequence;
        H();
    }

    public String toString() {
        return k().toString();
    }

    protected String u(String str) {
        if (!v0()) {
            return str;
        }
        w();
        return this.f1596c.l().getString(this.f1607n, str);
    }

    public boolean u0() {
        return !D();
    }

    public Set<String> v(Set<String> set) {
        if (!v0()) {
            return set;
        }
        w();
        return this.f1596c.l().getStringSet(this.f1607n, set);
    }

    protected boolean v0() {
        return this.f1596c != null && E() && C();
    }

    public n0.d w() {
        f fVar = this.f1596c;
        if (fVar != null) {
            return fVar.j();
        }
        return null;
    }

    public f x() {
        return this.f1596c;
    }

    public SharedPreferences y() {
        if (this.f1596c == null) {
            return null;
        }
        w();
        return this.f1596c.l();
    }

    public CharSequence z() {
        return this.f1604k;
    }

    public Preference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.preferenceStyle, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
