package z1;

import android.view.View;
import vivo.util.VLog;

/* JADX INFO: compiled from: FastClickProofListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6640b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f6641c;

    public boolean a(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        View view2 = this.f6641c;
        if (view2 != null && view2 == view && Math.abs(jCurrentTimeMillis - this.f6640b) < 500) {
            VLog.d("FastClickProofListener", "isFastClick");
            return true;
        }
        this.f6641c = view;
        this.f6640b = jCurrentTimeMillis;
        return false;
    }

    public abstract void b(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (a(view)) {
            VLog.d("FastClickProofListener", "isFastClick： true");
        } else {
            b(view);
        }
    }
}
