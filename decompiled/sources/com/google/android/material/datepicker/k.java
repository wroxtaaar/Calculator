package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialTextInputPicker.java */
/* JADX INFO: loaded from: classes.dex */
public final class k<S> extends p<S> {
    private int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private d<S> f2912a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private com.google.android.material.datepicker.a f2913b0;

    /* JADX INFO: compiled from: MaterialTextInputPicker.java */
    class a extends o<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a(S s3) {
            Iterator<o<S>> it = k.this.Y.iterator();
            while (it.hasNext()) {
                it.next().a(s3);
            }
        }
    }

    static <T> k<T> w1(d<T> dVar, int i3, com.google.android.material.datepicker.a aVar) {
        k<T> kVar = new k<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        kVar.m1(bundle);
        return kVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(Bundle bundle) {
        super.D0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Z);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f2912a0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2913b0);
    }

    @Override // androidx.fragment.app.Fragment
    public void h0(Bundle bundle) {
        super.h0(bundle);
        if (bundle == null) {
            bundle = s();
        }
        this.Z = bundle.getInt("THEME_RES_ID_KEY");
        this.f2912a0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f2913b0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View l0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f2912a0.h(layoutInflater.cloneInContext(new ContextThemeWrapper(u(), this.Z)), viewGroup, bundle, this.f2913b0, new a());
    }
}
