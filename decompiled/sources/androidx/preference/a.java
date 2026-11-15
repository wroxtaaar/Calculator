package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import n0.i;
import n0.j;

/* JADX INFO: compiled from: CollapsiblePreferenceGroupController.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d f1631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1633c = false;

    /* JADX INFO: renamed from: androidx.preference.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CollapsiblePreferenceGroupController.java */
    class C0015a implements Preference.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreferenceGroup f1634a;

        C0015a(PreferenceGroup preferenceGroup) {
            this.f1634a = preferenceGroup;
        }

        @Override // androidx.preference.Preference.e
        public boolean a(Preference preference) {
            this.f1634a.I0(Integer.MAX_VALUE);
            a.this.f1631a.a(preference);
            PreferenceGroup.b bVarD0 = this.f1634a.D0();
            if (bVarD0 == null) {
                return true;
            }
            bVarD0.a();
            return true;
        }
    }

    /* JADX INFO: compiled from: CollapsiblePreferenceGroupController.java */
    static class b extends Preference {
        private long N;

        b(Context context, List<Preference> list, long j3) {
            super(context);
            z0();
            A0(list);
            this.N = j3 + 1000000;
        }

        private void A0(List<Preference> list) {
            ArrayList arrayList = new ArrayList();
            CharSequence string = null;
            for (Preference preference : list) {
                CharSequence charSequenceA = preference.A();
                boolean z2 = preference instanceof PreferenceGroup;
                if (z2 && !TextUtils.isEmpty(charSequenceA)) {
                    arrayList.add((PreferenceGroup) preference);
                }
                if (arrayList.contains(preference.r())) {
                    if (z2) {
                        arrayList.add((PreferenceGroup) preference);
                    }
                } else if (!TextUtils.isEmpty(charSequenceA)) {
                    string = string == null ? charSequenceA : i().getString(j.summary_collapsed_preference_list, string, charSequenceA);
                }
            }
            r0(string);
        }

        private void z0() {
            m0(i.expand_button);
            j0(n0.g.ic_arrow_down_24dp);
            s0(j.expand_button_title);
            q0(999);
        }

        @Override // androidx.preference.Preference
        public void N(g gVar) {
            super.N(gVar);
            gVar.P(false);
        }

        @Override // androidx.preference.Preference
        public long m() {
            return this.N;
        }
    }

    a(PreferenceGroup preferenceGroup, d dVar) {
        this.f1631a = dVar;
        this.f1632b = preferenceGroup.i();
    }

    private b a(PreferenceGroup preferenceGroup, List<Preference> list) {
        b bVar = new b(this.f1632b, list, preferenceGroup.m());
        bVar.p0(new C0015a(preferenceGroup));
        return bVar;
    }

    private List<Preference> b(PreferenceGroup preferenceGroup) {
        this.f1633c = false;
        boolean z2 = preferenceGroup.C0() != Integer.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iF0 = preferenceGroup.F0();
        int i3 = 0;
        for (int i4 = 0; i4 < iF0; i4++) {
            Preference preferenceE0 = preferenceGroup.E0(i4);
            if (preferenceE0.G()) {
                if (!z2 || i3 < preferenceGroup.C0()) {
                    arrayList.add(preferenceE0);
                } else {
                    arrayList2.add(preferenceE0);
                }
                if (preferenceE0 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceE0;
                    if (preferenceGroup2.G0()) {
                        List<Preference> listB = b(preferenceGroup2);
                        if (z2 && this.f1633c) {
                            throw new IllegalArgumentException("Nested expand buttons are not supported!");
                        }
                        for (Preference preference : listB) {
                            if (!z2 || i3 < preferenceGroup.C0()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i3++;
                        }
                    } else {
                        continue;
                    }
                } else {
                    i3++;
                }
            }
        }
        if (z2 && i3 > preferenceGroup.C0()) {
            arrayList.add(a(preferenceGroup, arrayList2));
        }
        this.f1633c |= z2;
        return arrayList;
    }

    public List<Preference> c(PreferenceGroup preferenceGroup) {
        return b(preferenceGroup);
    }
}
