package o1;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JsonObject.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q1.h<String, j> f5449a = new q1.h<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).f5449a.equals(this.f5449a));
    }

    public void h(String str, j jVar) {
        q1.h<String, j> hVar = this.f5449a;
        if (jVar == null) {
            jVar = l.f5448a;
        }
        hVar.put(str, jVar);
    }

    public int hashCode() {
        return this.f5449a.hashCode();
    }

    public Set<Map.Entry<String, j>> i() {
        return this.f5449a.entrySet();
    }
}
