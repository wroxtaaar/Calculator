package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: PickerFragment.java */
/* JADX INFO: loaded from: classes.dex */
abstract class p<S> extends Fragment {
    protected final LinkedHashSet<o<S>> Y = new LinkedHashSet<>();

    p() {
    }

    boolean u1(o<S> oVar) {
        return this.Y.add(oVar);
    }

    void v1() {
        this.Y.clear();
    }
}
