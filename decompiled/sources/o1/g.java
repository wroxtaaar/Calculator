package o1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: JsonArray.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends j implements Iterable<j> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<j> f5447b = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof g) && ((g) obj).f5447b.equals(this.f5447b));
    }

    public void h(j jVar) {
        if (jVar == null) {
            jVar = l.f5448a;
        }
        this.f5447b.add(jVar);
    }

    public int hashCode() {
        return this.f5447b.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.f5447b.iterator();
    }
}
