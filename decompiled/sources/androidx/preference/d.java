package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import e0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n0.l;

/* JADX INFO: compiled from: PreferenceGroupAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.g<g> implements Preference.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PreferenceGroup f1658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Preference> f1659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Preference> f1660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<b> f1661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f1662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f1663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private androidx.preference.a f1664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f1665j;

    /* JADX INFO: compiled from: PreferenceGroupAdapter.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.D();
        }
    }

    /* JADX INFO: compiled from: PreferenceGroupAdapter.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f1669c;

        b() {
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1667a == bVar.f1667a && this.f1668b == bVar.f1668b && TextUtils.equals(this.f1669c, bVar.f1669c);
        }

        public int hashCode() {
            return ((((527 + this.f1667a) * 31) + this.f1668b) * 31) + this.f1669c.hashCode();
        }

        b(b bVar) {
            this.f1667a = bVar.f1667a;
            this.f1668b = bVar.f1668b;
            this.f1669c = bVar.f1669c;
        }
    }

    public d(PreferenceGroup preferenceGroup) {
        this(preferenceGroup, new Handler());
    }

    private void x(Preference preference) {
        b bVarY = y(preference, null);
        if (this.f1661f.contains(bVarY)) {
            return;
        }
        this.f1661f.add(bVarY);
    }

    private b y(Preference preference, b bVar) {
        if (bVar == null) {
            bVar = new b();
        }
        bVar.f1669c = preference.getClass().getName();
        bVar.f1667a = preference.p();
        bVar.f1668b = preference.B();
        return bVar;
    }

    private void z(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.K0();
        int iF0 = preferenceGroup.F0();
        for (int i3 = 0; i3 < iF0; i3++) {
            Preference preferenceE0 = preferenceGroup.E0(i3);
            list.add(preferenceE0);
            x(preferenceE0);
            if (preferenceE0 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceE0;
                if (preferenceGroup2.G0()) {
                    z(list, preferenceGroup2);
                }
            }
            preferenceE0.n0(this);
        }
    }

    public Preference A(int i3) {
        if (i3 < 0 || i3 >= e()) {
            return null;
        }
        return this.f1659d.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void m(g gVar, int i3) {
        A(i3).N(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public g o(ViewGroup viewGroup, int i3) {
        b bVar = this.f1661f.get(i3);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, l.BackgroundStyle);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(l.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = u.a.d(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(bVar.f1667a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            t.p0(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i4 = bVar.f1668b;
            if (i4 != 0) {
                layoutInflaterFrom.inflate(i4, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new g(viewInflate);
    }

    void D() {
        Iterator<Preference> it = this.f1660e.iterator();
        while (it.hasNext()) {
            it.next().n0(null);
        }
        ArrayList arrayList = new ArrayList(this.f1660e.size());
        z(arrayList, this.f1658c);
        this.f1659d = this.f1664i.c(this.f1658c);
        this.f1660e = arrayList;
        f fVarX = this.f1658c.x();
        if (fVarX != null) {
            fVarX.i();
        }
        j();
        Iterator<Preference> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().c();
        }
    }

    @Override // androidx.preference.Preference.c
    public void a(Preference preference) {
        this.f1663h.removeCallbacks(this.f1665j);
        this.f1663h.post(this.f1665j);
    }

    @Override // androidx.preference.Preference.c
    public void b(Preference preference) {
        int iIndexOf = this.f1659d.indexOf(preference);
        if (iIndexOf != -1) {
            k(iIndexOf, preference);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f1659d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i3) {
        if (i()) {
            return A(i3).m();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int g(int i3) {
        b bVarY = y(A(i3), this.f1662g);
        this.f1662g = bVarY;
        int iIndexOf = this.f1661f.indexOf(bVarY);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.f1661f.size();
        this.f1661f.add(new b(this.f1662g));
        return size;
    }

    private d(PreferenceGroup preferenceGroup, Handler handler) {
        this.f1662g = new b();
        this.f1665j = new a();
        this.f1658c = preferenceGroup;
        this.f1663h = handler;
        this.f1664i = new androidx.preference.a(preferenceGroup, this);
        this.f1658c.n0(this);
        this.f1659d = new ArrayList();
        this.f1660e = new ArrayList();
        this.f1661f = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f1658c;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            v(((PreferenceScreen) preferenceGroup2).L0());
        } else {
            v(true);
        }
        D();
    }
}
