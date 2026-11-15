package l;

/* JADX INFO: compiled from: LongSparseArray.java */
/* JADX INFO: loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f5224f = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f5226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f5227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5228e;

    public d() {
        this(10);
    }

    private void d() {
        int i3 = this.f5228e;
        long[] jArr = this.f5226c;
        Object[] objArr = this.f5227d;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f5224f) {
                if (i5 != i4) {
                    jArr[i4] = jArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f5225b = false;
        this.f5228e = i4;
    }

    public void a(long j3, E e3) {
        int i3 = this.f5228e;
        if (i3 != 0 && j3 <= this.f5226c[i3 - 1]) {
            i(j3, e3);
            return;
        }
        if (this.f5225b && i3 >= this.f5226c.length) {
            d();
        }
        int i4 = this.f5228e;
        if (i4 >= this.f5226c.length) {
            int iF = c.f(i4 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f5226c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f5227d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f5226c = jArr;
            this.f5227d = objArr;
        }
        this.f5226c[i4] = j3;
        this.f5227d[i4] = e3;
        this.f5228e = i4 + 1;
    }

    public void b() {
        int i3 = this.f5228e;
        Object[] objArr = this.f5227d;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f5228e = 0;
        this.f5225b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f5226c = (long[]) this.f5226c.clone();
            dVar.f5227d = (Object[]) this.f5227d.clone();
            return dVar;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public E e(long j3) {
        return f(j3, null);
    }

    public E f(long j3, E e3) {
        int iB = c.b(this.f5226c, this.f5228e, j3);
        if (iB >= 0) {
            Object[] objArr = this.f5227d;
            if (objArr[iB] != f5224f) {
                return (E) objArr[iB];
            }
        }
        return e3;
    }

    public int g(long j3) {
        if (this.f5225b) {
            d();
        }
        return c.b(this.f5226c, this.f5228e, j3);
    }

    public long h(int i3) {
        if (this.f5225b) {
            d();
        }
        return this.f5226c[i3];
    }

    public void i(long j3, E e3) {
        int iB = c.b(this.f5226c, this.f5228e, j3);
        if (iB >= 0) {
            this.f5227d[iB] = e3;
            return;
        }
        int i3 = ~iB;
        int i4 = this.f5228e;
        if (i3 < i4) {
            Object[] objArr = this.f5227d;
            if (objArr[i3] == f5224f) {
                this.f5226c[i3] = j3;
                objArr[i3] = e3;
                return;
            }
        }
        if (this.f5225b && i4 >= this.f5226c.length) {
            d();
            i3 = ~c.b(this.f5226c, this.f5228e, j3);
        }
        int i5 = this.f5228e;
        if (i5 >= this.f5226c.length) {
            int iF = c.f(i5 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f5226c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f5227d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5226c = jArr;
            this.f5227d = objArr2;
        }
        int i6 = this.f5228e;
        if (i6 - i3 != 0) {
            long[] jArr3 = this.f5226c;
            int i7 = i3 + 1;
            System.arraycopy(jArr3, i3, jArr3, i7, i6 - i3);
            Object[] objArr4 = this.f5227d;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f5228e - i3);
        }
        this.f5226c[i3] = j3;
        this.f5227d[i3] = e3;
        this.f5228e++;
    }

    public void j(long j3) {
        int iB = c.b(this.f5226c, this.f5228e, j3);
        if (iB >= 0) {
            Object[] objArr = this.f5227d;
            Object obj = objArr[iB];
            Object obj2 = f5224f;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f5225b = true;
            }
        }
    }

    public void k(int i3) {
        Object[] objArr = this.f5227d;
        Object obj = objArr[i3];
        Object obj2 = f5224f;
        if (obj != obj2) {
            objArr[i3] = obj2;
            this.f5225b = true;
        }
    }

    public int l() {
        if (this.f5225b) {
            d();
        }
        return this.f5228e;
    }

    public E m(int i3) {
        if (this.f5225b) {
            d();
        }
        return (E) this.f5227d[i3];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5228e * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f5228e; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(h(i3));
            sb.append('=');
            E eM = m(i3);
            if (eM != this) {
                sb.append(eM);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i3) {
        this.f5225b = false;
        if (i3 == 0) {
            this.f5226c = c.f5222b;
            this.f5227d = c.f5223c;
        } else {
            int iF = c.f(i3);
            this.f5226c = new long[iF];
            this.f5227d = new Object[iF];
        }
    }
}
