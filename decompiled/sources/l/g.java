package l;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: SimpleArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static Object[] f5252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static int f5253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Object[] f5254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static int f5255h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f5256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f5257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5258d;

    public g() {
        this.f5256b = c.f5221a;
        this.f5257c = c.f5223c;
        this.f5258d = 0;
    }

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (g.class) {
                Object[] objArr = f5254g;
                if (objArr != null) {
                    this.f5257c = objArr;
                    f5254g = (Object[]) objArr[0];
                    this.f5256b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f5255h--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f5252e;
                if (objArr2 != null) {
                    this.f5257c = objArr2;
                    f5252e = (Object[]) objArr2[0];
                    this.f5256b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f5253f--;
                    return;
                }
            }
        }
        this.f5256b = new int[i3];
        this.f5257c = new Object[i3 << 1];
    }

    private static int b(int[] iArr, int i3, int i4) {
        try {
            return c.a(iArr, i3, i4);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f5255h < 10) {
                    objArr[0] = f5254g;
                    objArr[1] = iArr;
                    for (int i4 = (i3 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f5254g = objArr;
                    f5255h++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (f5253f < 10) {
                    objArr[0] = f5252e;
                    objArr[1] = iArr;
                    for (int i5 = (i3 << 1) - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f5252e = objArr;
                    f5253f++;
                }
            }
        }
    }

    public void c(int i3) {
        int i4 = this.f5258d;
        int[] iArr = this.f5256b;
        if (iArr.length < i3) {
            Object[] objArr = this.f5257c;
            a(i3);
            if (this.f5258d > 0) {
                System.arraycopy(iArr, 0, this.f5256b, 0, i4);
                System.arraycopy(objArr, 0, this.f5257c, 0, i4 << 1);
            }
            d(iArr, objArr, i4);
        }
        if (this.f5258d != i4) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i3 = this.f5258d;
        if (i3 > 0) {
            int[] iArr = this.f5256b;
            Object[] objArr = this.f5257c;
            this.f5256b = c.f5221a;
            this.f5257c = c.f5223c;
            this.f5258d = 0;
            d(iArr, objArr, i3);
        }
        if (this.f5258d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i3) {
        int i4 = this.f5258d;
        if (i4 == 0) {
            return -1;
        }
        int iB = b(this.f5256b, i4, i3);
        if (iB < 0 || obj.equals(this.f5257c[iB << 1])) {
            return iB;
        }
        int i5 = iB + 1;
        while (i5 < i4 && this.f5256b[i5] == i3) {
            if (obj.equals(this.f5257c[i5 << 1])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iB - 1; i6 >= 0 && this.f5256b[i6] == i3; i6--) {
            if (obj.equals(this.f5257c[i6 << 1])) {
                return i6;
            }
        }
        return ~i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f5258d; i3++) {
                try {
                    K kI = i(i3);
                    V vM = m(i3);
                    Object obj2 = gVar.get(kI);
                    if (vM == null) {
                        if (obj2 != null || !gVar.containsKey(kI)) {
                            return false;
                        }
                    } else if (!vM.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f5258d; i4++) {
                try {
                    K kI2 = i(i4);
                    V vM2 = m(i4);
                    Object obj3 = map.get(kI2);
                    if (vM2 == null) {
                        if (obj3 != null || !map.containsKey(kI2)) {
                            return false;
                        }
                    } else if (!vM2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i3 = this.f5258d;
        if (i3 == 0) {
            return -1;
        }
        int iB = b(this.f5256b, i3, 0);
        if (iB < 0 || this.f5257c[iB << 1] == null) {
            return iB;
        }
        int i4 = iB + 1;
        while (i4 < i3 && this.f5256b[i4] == 0) {
            if (this.f5257c[i4 << 1] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iB - 1; i5 >= 0 && this.f5256b[i5] == 0; i5--) {
            if (this.f5257c[i5 << 1] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v3) {
        int iF = f(obj);
        return iF >= 0 ? (V) this.f5257c[(iF << 1) + 1] : v3;
    }

    int h(Object obj) {
        int i3 = this.f5258d * 2;
        Object[] objArr = this.f5257c;
        if (obj == null) {
            for (int i4 = 1; i4 < i3; i4 += 2) {
                if (objArr[i4] == null) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i3; i5 += 2) {
            if (obj.equals(objArr[i5])) {
                return i5 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f5256b;
        Object[] objArr = this.f5257c;
        int i3 = this.f5258d;
        int i4 = 1;
        int i5 = 0;
        int iHashCode = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i5];
            i5++;
            i4 += 2;
        }
        return iHashCode;
    }

    public K i(int i3) {
        return (K) this.f5257c[i3 << 1];
    }

    public boolean isEmpty() {
        return this.f5258d <= 0;
    }

    public void j(g<? extends K, ? extends V> gVar) {
        int i3 = gVar.f5258d;
        c(this.f5258d + i3);
        if (this.f5258d != 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                put(gVar.i(i4), gVar.m(i4));
            }
        } else if (i3 > 0) {
            System.arraycopy(gVar.f5256b, 0, this.f5256b, 0, i3);
            System.arraycopy(gVar.f5257c, 0, this.f5257c, 0, i3 << 1);
            this.f5258d = i3;
        }
    }

    public V k(int i3) {
        Object[] objArr = this.f5257c;
        int i4 = i3 << 1;
        V v3 = (V) objArr[i4 + 1];
        int i5 = this.f5258d;
        int i6 = 0;
        if (i5 <= 1) {
            d(this.f5256b, objArr, i5);
            this.f5256b = c.f5221a;
            this.f5257c = c.f5223c;
        } else {
            int i7 = i5 - 1;
            int[] iArr = this.f5256b;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    int i9 = i7 - i3;
                    System.arraycopy(iArr, i8, iArr, i3, i9);
                    Object[] objArr2 = this.f5257c;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i4, i9 << 1);
                }
                Object[] objArr3 = this.f5257c;
                int i10 = i7 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                a(i5 > 8 ? i5 + (i5 >> 1) : 8);
                if (i5 != this.f5258d) {
                    throw new ConcurrentModificationException();
                }
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f5256b, 0, i3);
                    System.arraycopy(objArr, 0, this.f5257c, 0, i4);
                }
                if (i3 < i7) {
                    int i11 = i3 + 1;
                    int i12 = i7 - i3;
                    System.arraycopy(iArr, i11, this.f5256b, i3, i12);
                    System.arraycopy(objArr, i11 << 1, this.f5257c, i4, i12 << 1);
                }
            }
            i6 = i7;
        }
        if (i5 != this.f5258d) {
            throw new ConcurrentModificationException();
        }
        this.f5258d = i6;
        return v3;
    }

    public V l(int i3, V v3) {
        int i4 = (i3 << 1) + 1;
        Object[] objArr = this.f5257c;
        V v4 = (V) objArr[i4];
        objArr[i4] = v3;
        return v4;
    }

    public V m(int i3) {
        return (V) this.f5257c[(i3 << 1) + 1];
    }

    public V put(K k3, V v3) {
        int i3;
        int iE;
        int i4 = this.f5258d;
        if (k3 == null) {
            iE = g();
            i3 = 0;
        } else {
            int iHashCode = k3.hashCode();
            i3 = iHashCode;
            iE = e(k3, iHashCode);
        }
        if (iE >= 0) {
            int i5 = (iE << 1) + 1;
            Object[] objArr = this.f5257c;
            V v4 = (V) objArr[i5];
            objArr[i5] = v3;
            return v4;
        }
        int i6 = ~iE;
        int[] iArr = this.f5256b;
        if (i4 >= iArr.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            Object[] objArr2 = this.f5257c;
            a(i7);
            if (i4 != this.f5258d) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f5256b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f5257c, 0, objArr2.length);
            }
            d(iArr, objArr2, i4);
        }
        if (i6 < i4) {
            int[] iArr3 = this.f5256b;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.f5257c;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f5258d - i6) << 1);
        }
        int i9 = this.f5258d;
        if (i4 == i9) {
            int[] iArr4 = this.f5256b;
            if (i6 < iArr4.length) {
                iArr4[i6] = i3;
                Object[] objArr4 = this.f5257c;
                int i10 = i6 << 1;
                objArr4[i10] = k3;
                objArr4[i10 + 1] = v3;
                this.f5258d = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k3, V v3) {
        V v4 = get(k3);
        return v4 == null ? put(k3, v3) : v4;
    }

    public V remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return k(iF);
        }
        return null;
    }

    public V replace(K k3, V v3) {
        int iF = f(k3);
        if (iF >= 0) {
            return l(iF, v3);
        }
        return null;
    }

    public int size() {
        return this.f5258d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5258d * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f5258d; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            K kI = i(i3);
            if (kI != this) {
                sb.append(kI);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vM = m(i3);
            if (vM != this) {
                sb.append(vM);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        V vM = m(iF);
        if (obj2 != vM && (obj2 == null || !obj2.equals(vM))) {
            return false;
        }
        k(iF);
        return true;
    }

    public boolean replace(K k3, V v3, V v4) {
        int iF = f(k3);
        if (iF < 0) {
            return false;
        }
        V vM = m(iF);
        if (vM != v3 && (v3 == null || !v3.equals(vM))) {
            return false;
        }
        l(iF, v4);
        return true;
    }

    public g(int i3) {
        if (i3 == 0) {
            this.f5256b = c.f5221a;
            this.f5257c = c.f5223c;
        } else {
            a(i3);
        }
        this.f5258d = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            j(gVar);
        }
    }
}
