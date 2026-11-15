package n0;

import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends androidx.recyclerview.widget.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final RecyclerView f5311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final e0.a f5312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final e0.a f5313h;

    /* JADX INFO: compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
    class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            Preference preferenceA;
            e.this.f5312g.g(view, dVar);
            int iD0 = e.this.f5311f.d0(view);
            RecyclerView.g adapter = e.this.f5311f.getAdapter();
            if ((adapter instanceof androidx.preference.d) && (preferenceA = ((androidx.preference.d) adapter).A(iD0)) != null) {
                preferenceA.S(dVar);
            }
        }

        @Override // e0.a
        public boolean j(View view, int i3, Bundle bundle) {
            return e.this.f5312g.j(view, i3, bundle);
        }
    }

    public e(RecyclerView recyclerView) {
        super(recyclerView);
        this.f5312g = super.n();
        this.f5313h = new a();
        this.f5311f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.k
    public e0.a n() {
        return this.f5313h;
    }
}
