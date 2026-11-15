package com.google.android.material.internal;

import android.widget.Checkable;
import com.google.android.material.internal.h;

/* JADX INFO: compiled from: MaterialCheckable.java */
/* JADX INFO: loaded from: classes.dex */
public interface h<T extends h<T>> extends Checkable {

    /* JADX INFO: compiled from: MaterialCheckable.java */
    public interface a<C> {
        void a(C c3, boolean z2);
    }

    int getId();

    void setInternalOnCheckedChangeListener(a<T> aVar);
}
