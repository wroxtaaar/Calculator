package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LifecycleRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<g> f1560d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j.a<f, b> f1558b = new j.a<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1561e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1562f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1563g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<d.b> f1564h = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b f1559c = d.b.INITIALIZED;

    /* JADX INFO: compiled from: LifecycleRegistry.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1566b;

        static {
            int[] iArr = new int[d.b.values().length];
            f1566b = iArr;
            try {
                iArr[d.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1566b[d.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1566b[d.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1566b[d.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1566b[d.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[d.a.values().length];
            f1565a = iArr2;
            try {
                iArr2[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1565a[d.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1565a[d.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1565a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1565a[d.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1565a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1565a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: LifecycleRegistry.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d.b f1567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e f1568b;

        b(f fVar, d.b bVar) {
            this.f1568b = j.f(fVar);
            this.f1567a = bVar;
        }

        void a(g gVar, d.a aVar) {
            d.b bVarH = h.h(aVar);
            this.f1567a = h.l(this.f1567a, bVarH);
            this.f1568b.d(gVar, aVar);
            this.f1567a = bVarH;
        }
    }

    public h(g gVar) {
        this.f1560d = new WeakReference<>(gVar);
    }

    private void d(g gVar) {
        Iterator<Map.Entry<f, b>> itA = this.f1558b.a();
        while (itA.hasNext() && !this.f1563g) {
            Map.Entry<f, b> next = itA.next();
            b value = next.getValue();
            while (value.f1567a.compareTo(this.f1559c) > 0 && !this.f1563g && this.f1558b.contains(next.getKey())) {
                d.a aVarF = f(value.f1567a);
                o(h(aVarF));
                value.a(gVar, aVarF);
                n();
            }
        }
    }

    private d.b e(f fVar) {
        Map.Entry<f, b> entryI = this.f1558b.i(fVar);
        d.b bVar = null;
        d.b bVar2 = entryI != null ? entryI.getValue().f1567a : null;
        if (!this.f1564h.isEmpty()) {
            ArrayList<d.b> arrayList = this.f1564h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return l(l(this.f1559c, bVar2), bVar);
    }

    private static d.a f(d.b bVar) {
        int i3 = a.f1566b[bVar.ordinal()];
        if (i3 == 1) {
            throw new IllegalArgumentException();
        }
        if (i3 == 2) {
            return d.a.ON_DESTROY;
        }
        if (i3 == 3) {
            return d.a.ON_STOP;
        }
        if (i3 == 4) {
            return d.a.ON_PAUSE;
        }
        if (i3 == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    private void g(g gVar) {
        j.b<f, b>.d dVarD = this.f1558b.d();
        while (dVarD.hasNext() && !this.f1563g) {
            Map.Entry next = dVarD.next();
            b bVar = (b) next.getValue();
            while (bVar.f1567a.compareTo(this.f1559c) < 0 && !this.f1563g && this.f1558b.contains((f) next.getKey())) {
                o(bVar.f1567a);
                bVar.a(gVar, r(bVar.f1567a));
                n();
            }
        }
    }

    static d.b h(d.a aVar) {
        switch (a.f1565a[aVar.ordinal()]) {
            case 1:
            case 2:
                return d.b.CREATED;
            case 3:
            case 4:
                return d.b.STARTED;
            case 5:
                return d.b.RESUMED;
            case 6:
                return d.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.f1558b.size() == 0) {
            return true;
        }
        d.b bVar = this.f1558b.b().getValue().f1567a;
        d.b bVar2 = this.f1558b.e().getValue().f1567a;
        return bVar == bVar2 && this.f1559c == bVar2;
    }

    static d.b l(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(d.b bVar) {
        if (this.f1559c == bVar) {
            return;
        }
        this.f1559c = bVar;
        if (this.f1562f || this.f1561e != 0) {
            this.f1563g = true;
            return;
        }
        this.f1562f = true;
        q();
        this.f1562f = false;
    }

    private void n() {
        ArrayList<d.b> arrayList = this.f1564h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void o(d.b bVar) {
        this.f1564h.add(bVar);
    }

    private void q() {
        g gVar = this.f1560d.get();
        if (gVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.f1563g = false;
            if (this.f1559c.compareTo(this.f1558b.b().getValue().f1567a) < 0) {
                d(gVar);
            }
            Map.Entry<f, b> entryE = this.f1558b.e();
            if (!this.f1563g && entryE != null && this.f1559c.compareTo(entryE.getValue().f1567a) > 0) {
                g(gVar);
            }
        }
        this.f1563g = false;
    }

    private static d.a r(d.b bVar) {
        int i3 = a.f1566b[bVar.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return d.a.ON_START;
            }
            if (i3 == 3) {
                return d.a.ON_RESUME;
            }
            if (i3 == 4) {
                throw new IllegalArgumentException();
            }
            if (i3 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return d.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar) {
        g gVar;
        d.b bVar = this.f1559c;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        b bVar3 = new b(fVar, bVar2);
        if (this.f1558b.g(fVar, bVar3) == null && (gVar = this.f1560d.get()) != null) {
            boolean z2 = this.f1561e != 0 || this.f1562f;
            d.b bVarE = e(fVar);
            this.f1561e++;
            while (bVar3.f1567a.compareTo(bVarE) < 0 && this.f1558b.contains(fVar)) {
                o(bVar3.f1567a);
                bVar3.a(gVar, r(bVar3.f1567a));
                n();
                bVarE = e(fVar);
            }
            if (!z2) {
                q();
            }
            this.f1561e--;
        }
    }

    @Override // androidx.lifecycle.d
    public d.b b() {
        return this.f1559c;
    }

    @Override // androidx.lifecycle.d
    public void c(f fVar) {
        this.f1558b.h(fVar);
    }

    public void i(d.a aVar) {
        m(h(aVar));
    }

    @Deprecated
    public void k(d.b bVar) {
        p(bVar);
    }

    public void p(d.b bVar) {
        m(bVar);
    }
}
