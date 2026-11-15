package p0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TransitionValues.java */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f5726b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f5725a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<m> f5727c = new ArrayList<>();

    @Deprecated
    public s() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f5726b == sVar.f5726b && this.f5725a.equals(sVar.f5725a);
    }

    public int hashCode() {
        return (this.f5726b.hashCode() * 31) + this.f5725a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f5726b + "\n") + "    values:";
        for (String str2 : this.f5725a.keySet()) {
            str = str + "    " + str2 + ": " + this.f5725a.get(str2) + "\n";
        }
        return str;
    }

    public s(View view) {
        this.f5726b = view;
    }
}
