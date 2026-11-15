package r0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: NetworkResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f6008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f6009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<g> f6010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f6012f;

    @Deprecated
    public k(int i3, byte[] bArr, Map<String, String> map, boolean z2, long j3) {
        this(i3, bArr, map, a(map), z2, j3);
    }

    private static List<g> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new g(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> b(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }

    public k(int i3, byte[] bArr, boolean z2, long j3, List<g> list) {
        this(i3, bArr, b(list), list, z2, j3);
    }

    @Deprecated
    public k(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private k(int i3, byte[] bArr, Map<String, String> map, List<g> list, boolean z2, long j3) {
        this.f6007a = i3;
        this.f6008b = bArr;
        this.f6009c = map;
        if (list == null) {
            this.f6010d = null;
        } else {
            this.f6010d = Collections.unmodifiableList(list);
        }
        this.f6011e = z2;
        this.f6012f = j3;
    }
}
