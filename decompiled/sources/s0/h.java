package s0;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<r0.g> f6202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InputStream f6204d;

    public h(int i3, List<r0.g> list) {
        this(i3, list, -1, null);
    }

    public final InputStream a() {
        return this.f6204d;
    }

    public final int b() {
        return this.f6203c;
    }

    public final List<r0.g> c() {
        return Collections.unmodifiableList(this.f6202b);
    }

    public final int d() {
        return this.f6201a;
    }

    public h(int i3, List<r0.g> list, int i4, InputStream inputStream) {
        this.f6201a = i3;
        this.f6202b = list;
        this.f6203c = i4;
        this.f6204d = inputStream;
    }
}
