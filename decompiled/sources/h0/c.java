package h0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ResourceCursorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private LayoutInflater f4843l;

    @Deprecated
    public c(Context context, int i3, Cursor cursor, boolean z2) {
        super(context, cursor, z2);
        this.f4842k = i3;
        this.f4841j = i3;
        this.f4843l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // h0.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f4843l.inflate(this.f4842k, viewGroup, false);
    }

    @Override // h0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f4843l.inflate(this.f4841j, viewGroup, false);
    }
}
