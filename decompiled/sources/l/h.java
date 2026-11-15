package l;

/* JADX INFO: compiled from: SparseArrayCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f5259f = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f5261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f5262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5263e;

    public h() {
        this(10);
    }

    private void d() {
        int i3 = this.f5263e;
        int[] iArr = this.f5261c;
        Object[] objArr = this.f5262d;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f5259f) {
                if (i5 != i4) {
                    iArr[i4] = iArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f5260b = false;
        this.f5263e = i4;
    }

    public void a(int i3, E e3) {
        int i4 = this.f5263e;
        if (i4 != 0 && i3 <= this.f5261c[i4 - 1]) {
            i(i3, e3);
            return;
        }
        if (this.f5260b && i4 >= this.f5261c.length) {
            d();
        }
        int i5 = this.f5263e;
        if (i5 >= this.f5261c.length) {
            int iE = c.e(i5 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f5261c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f5262d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f5261c = iArr;
            this.f5262d = objArr;
        }
        this.f5261c[i5] = i3;
        this.f5262d[i5] = e3;
        this.f5263e = i5 + 1;
    }

    public void b() {
        int i3 = this.f5263e;
        Object[] objArr = this.f5262d;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f5263e = 0;
        this.f5260b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f5261c = (int[]) this.f5261c.clone();
            hVar.f5262d = (Object[]) this.f5262d.clone();
            return hVar;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public E e(int i3) {
        return f(i3, null);
    }

    public E f(int i3, E e3) {
        int iA = c.a(this.f5261c, this.f5263e, i3);
        if (iA >= 0) {
            Object[] objArr = this.f5262d;
            if (objArr[iA] != f5259f) {
                return (E) objArr[iA];
            }
        }
        return e3;
    }

    public int g(E e3) {
        if (this.f5260b) {
            d();
        }
        for (int i3 = 0; i3 < this.f5263e; i3++) {
            if (this.f5262d[i3] == e3) {
                return i3;
            }
        }
        return -1;
    }

    public int h(int i3) {
        if (this.f5260b) {
            d();
        }
        return this.f5261c[i3];
    }

    public void i(int i3, E e3) {
        int iA = c.a(this.f5261c, this.f5263e, i3);
        if (iA >= 0) {
            this.f5262d[iA] = e3;
            return;
        }
        int i4 = ~iA;
        int i5 = this.f5263e;
        if (i4 < i5) {
            Object[] objArr = this.f5262d;
            if (objArr[i4] == f5259f) {
                this.f5261c[i4] = i3;
                objArr[i4] = e3;
                return;
            }
        }
        if (this.f5260b && i5 >= this.f5261c.length) {
            d();
            i4 = ~c.a(this.f5261c, this.f5263e, i3);
        }
        int i6 = this.f5263e;
        if (i6 >= this.f5261c.length) {
            int iE = c.e(i6 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f5261c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f5262d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f5261c = iArr;
            this.f5262d = objArr2;
        }
        int i7 = this.f5263e;
        if (i7 - i4 != 0) {
            int[] iArr3 = this.f5261c;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr4 = this.f5262d;
            System.arraycopy(objArr4, i4, objArr4, i8, this.f5263e - i4);
        }
        this.f5261c[i4] = i3;
        this.f5262d[i4] = e3;
        this.f5263e++;
    }

    public void j(int i3) {
        int iA = c.a(this.f5261c, this.f5263e, i3);
        if (iA >= 0) {
            Object[] objArr = this.f5262d;
            Object obj = objArr[iA];
            Object obj2 = f5259f;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.f5260b = true;
            }
        }
    }

    public int k() {
        if (this.f5260b) {
            d();
        }
        return this.f5263e;
    }

    public E l(int i3) {
        if (this.f5260b) {
            d();
        }
        return (E) this.f5262d[i3];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5263e * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f5263e; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(h(i3));
            sb.append('=');
            E eL = l(i3);
            if (eL != this) {
                sb.append(eL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i3) {
        this.f5260b = false;
        if (i3 == 0) {
            this.f5261c = c.f5221a;
            this.f5262d = c.f5223c;
        } else {
            int iE = c.e(i3);
            this.f5261c = new int[iE];
            this.f5262d = new Object[iE];
        }
    }
}
