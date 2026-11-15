package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: compiled from: FragmentContainer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    @Deprecated
    public Fragment a(Context context, String str, Bundle bundle) {
        return Fragment.S(context, str, bundle);
    }

    public abstract View e(int i3);

    public abstract boolean f();
}
