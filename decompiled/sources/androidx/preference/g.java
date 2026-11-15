package androidx.preference;

import android.R;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import n0.h;

/* JADX INFO: compiled from: PreferenceViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends RecyclerView.d0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final SparseArray<View> f1690t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1691u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1692v;

    g(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.f1690t = sparseArray;
        sparseArray.put(R.id.title, view.findViewById(R.id.title));
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i3 = h.icon_frame;
        sparseArray.put(i3, view.findViewById(i3));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
    }

    public View M(int i3) {
        View view = this.f1690t.get(i3);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.f1813a.findViewById(i3);
        if (viewFindViewById != null) {
            this.f1690t.put(i3, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean N() {
        return this.f1691u;
    }

    public boolean O() {
        return this.f1692v;
    }

    public void P(boolean z2) {
        this.f1691u = z2;
    }

    public void Q(boolean z2) {
        this.f1692v = z2;
    }
}
