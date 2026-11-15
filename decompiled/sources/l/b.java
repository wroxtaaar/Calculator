package l;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ArraySet.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f5210f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object[] f5211g = new Object[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Object[] f5212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f5213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object[] f5214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f5215k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f5216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f5217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f<E, E> f5219e;

    /* JADX INFO: compiled from: ArraySet.java */
    class a extends f<E, E> {
        a() {
        }

        @Override // l.f
        protected void a() {
            b.this.clear();
        }

        @Override // l.f
        protected Object b(int i3, int i4) {
            return b.this.f5217c[i3];
        }

        @Override // l.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // l.f
        protected int d() {
            return b.this.f5218d;
        }

        @Override // l.f
        protected int e(Object obj) {
            return b.this.e(obj);
        }

        @Override // l.f
        protected int f(Object obj) {
            return b.this.e(obj);
        }

        @Override // l.f
        protected void g(E e3, E e4) {
            b.this.add(e3);
        }

        @Override // l.f
        protected void h(int i3) {
            b.this.h(i3);
        }

        @Override // l.f
        protected E i(int i3, E e3) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (b.class) {
                Object[] objArr = f5214j;
                if (objArr != null) {
                    this.f5217c = objArr;
                    f5214j = (Object[]) objArr[0];
                    this.f5216b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f5215k--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f5212h;
                if (objArr2 != null) {
                    this.f5217c = objArr2;
                    f5212h = (Object[]) objArr2[0];
                    this.f5216b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f5213i--;
                    return;
                }
            }
        }
        this.f5216b = new int[i3];
        this.f5217c = new Object[i3];
    }

    private static void c(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f5215k < 10) {
                    objArr[0] = f5214j;
                    objArr[1] = iArr;
                    for (int i4 = i3 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f5214j = objArr;
                    f5215k++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f5213i < 10) {
                    objArr[0] = f5212h;
                    objArr[1] = iArr;
                    for (int i5 = i3 - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f5212h = objArr;
                    f5213i++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.f5219e == null) {
            this.f5219e = new a();
        }
        return this.f5219e;
    }

    private int f(Object obj, int i3) {
        int i4 = this.f5218d;
        if (i4 == 0) {
            return -1;
        }
        int iA = c.a(this.f5216b, i4, i3);
        if (iA < 0 || obj.equals(this.f5217c[iA])) {
            return iA;
        }
        int i5 = iA + 1;
        while (i5 < i4 && this.f5216b[i5] == i3) {
            if (obj.equals(this.f5217c[i5])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iA - 1; i6 >= 0 && this.f5216b[i6] == i3; i6--) {
            if (obj.equals(this.f5217c[i6])) {
                return i6;
            }
        }
        return ~i5;
    }

    private int g() {
        int i3 = this.f5218d;
        if (i3 == 0) {
            return -1;
        }
        int iA = c.a(this.f5216b, i3, 0);
        if (iA < 0 || this.f5217c[iA] == null) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f5216b[i4] == 0) {
            if (this.f5217c[i4] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f5216b[i5] == 0; i5--) {
            if (this.f5217c[i5] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e3) {
        int i3;
        int iF;
        if (e3 == null) {
            iF = g();
            i3 = 0;
        } else {
            int iHashCode = e3.hashCode();
            i3 = iHashCode;
            iF = f(e3, iHashCode);
        }
        if (iF >= 0) {
            return false;
        }
        int i4 = ~iF;
        int i5 = this.f5218d;
        int[] iArr = this.f5216b;
        if (i5 >= iArr.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.f5217c;
            a(i6);
            int[] iArr2 = this.f5216b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f5217c, 0, objArr.length);
            }
            c(iArr, objArr, this.f5218d);
        }
        int i7 = this.f5218d;
        if (i4 < i7) {
            int[] iArr3 = this.f5216b;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f5217c;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f5218d - i4);
        }
        this.f5216b[i4] = i3;
        this.f5217c[i4] = e3;
        this.f5218d++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f5218d + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public void b(int i3) {
        int[] iArr = this.f5216b;
        if (iArr.length < i3) {
            Object[] objArr = this.f5217c;
            a(i3);
            int i4 = this.f5218d;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f5216b, 0, i4);
                System.arraycopy(objArr, 0, this.f5217c, 0, this.f5218d);
            }
            c(iArr, objArr, this.f5218d);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i3 = this.f5218d;
        if (i3 != 0) {
            c(this.f5216b, this.f5217c, i3);
            this.f5216b = f5210f;
            this.f5217c = f5211g;
            this.f5218d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return e(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int e(Object obj) {
        return obj == null ? g() : f(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f5218d; i3++) {
                try {
                    if (!set.contains(i(i3))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E h(int i3) {
        Object[] objArr = this.f5217c;
        E e3 = (E) objArr[i3];
        int i4 = this.f5218d;
        if (i4 <= 1) {
            c(this.f5216b, objArr, i4);
            this.f5216b = f5210f;
            this.f5217c = f5211g;
            this.f5218d = 0;
        } else {
            int[] iArr = this.f5216b;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                int i5 = i4 - 1;
                this.f5218d = i5;
                if (i3 < i5) {
                    int i6 = i3 + 1;
                    System.arraycopy(iArr, i6, iArr, i3, i5 - i3);
                    Object[] objArr2 = this.f5217c;
                    System.arraycopy(objArr2, i6, objArr2, i3, this.f5218d - i3);
                }
                this.f5217c[this.f5218d] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                this.f5218d--;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f5216b, 0, i3);
                    System.arraycopy(objArr, 0, this.f5217c, 0, i3);
                }
                int i7 = this.f5218d;
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    System.arraycopy(iArr, i8, this.f5216b, i3, i7 - i3);
                    System.arraycopy(objArr, i8, this.f5217c, i3, this.f5218d - i3);
                }
            }
        }
        return e3;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f5216b;
        int i3 = this.f5218d;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 += iArr[i5];
        }
        return i4;
    }

    public E i(int i3) {
        return (E) this.f5217c[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f5218d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        h(iE);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z2 = false;
        for (int i3 = this.f5218d - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.f5217c[i3])) {
                h(i3);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f5218d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i3 = this.f5218d;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f5217c, 0, objArr, 0, i3);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5218d * 14);
        sb.append('{');
        for (int i3 = 0; i3 < this.f5218d; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            E eI = i(i3);
            if (eI != this) {
                sb.append(eI);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i3) {
        if (i3 == 0) {
            this.f5216b = f5210f;
            this.f5217c = f5211g;
        } else {
            a(i3);
        }
        this.f5218d = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f5218d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f5218d));
        }
        System.arraycopy(this.f5217c, 0, tArr, 0, this.f5218d);
        int length = tArr.length;
        int i3 = this.f5218d;
        if (length > i3) {
            tArr[i3] = null;
        }
        return tArr;
    }
}
