package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: compiled from: OpReorderer.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f2076a;

    /* JADX INFO: compiled from: OpReorderer.java */
    interface a {
        void a(androidx.recyclerview.widget.a.b bVar);

        androidx.recyclerview.widget.a.b b(int i3, int i4, int i5, Object obj);
    }

    h(a aVar) {
        this.f2076a = aVar;
    }

    private int a(List<androidx.recyclerview.widget.a.b> list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1953a != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<androidx.recyclerview.widget.a.b> list, int i3, androidx.recyclerview.widget.a.b bVar, int i4, androidx.recyclerview.widget.a.b bVar2) {
        int i5 = bVar.f1956d;
        int i6 = bVar2.f1954b;
        int i7 = i5 < i6 ? -1 : 0;
        int i8 = bVar.f1954b;
        if (i8 < i6) {
            i7++;
        }
        if (i6 <= i8) {
            bVar.f1954b = i8 + bVar2.f1956d;
        }
        int i9 = bVar2.f1954b;
        if (i9 <= i5) {
            bVar.f1956d = i5 + bVar2.f1956d;
        }
        bVar2.f1954b = i9 + i7;
        list.set(i3, bVar2);
        list.set(i4, bVar);
    }

    private void d(List<androidx.recyclerview.widget.a.b> list, int i3, int i4) {
        androidx.recyclerview.widget.a.b bVar = list.get(i3);
        androidx.recyclerview.widget.a.b bVar2 = list.get(i4);
        int i5 = bVar2.f1953a;
        if (i5 == 1) {
            c(list, i3, bVar, i4, bVar2);
        } else if (i5 == 2) {
            e(list, i3, bVar, i4, bVar2);
        } else {
            if (i5 != 4) {
                return;
            }
            f(list, i3, bVar, i4, bVar2);
        }
    }

    void b(List<androidx.recyclerview.widget.a.b> list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    void e(List<androidx.recyclerview.widget.a.b> list, int i3, androidx.recyclerview.widget.a.b bVar, int i4, androidx.recyclerview.widget.a.b bVar2) {
        boolean z2;
        int i5 = bVar.f1954b;
        int i6 = bVar.f1956d;
        boolean z3 = false;
        if (i5 < i6) {
            if (bVar2.f1954b == i5 && bVar2.f1956d == i6 - i5) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
            }
        } else if (bVar2.f1954b == i6 + 1 && bVar2.f1956d == i5 - i6) {
            z2 = true;
            z3 = true;
        } else {
            z2 = true;
        }
        int i7 = bVar2.f1954b;
        if (i6 < i7) {
            bVar2.f1954b = i7 - 1;
        } else {
            int i8 = bVar2.f1956d;
            if (i6 < i7 + i8) {
                bVar2.f1956d = i8 - 1;
                bVar.f1953a = 2;
                bVar.f1956d = 1;
                if (bVar2.f1956d == 0) {
                    list.remove(i4);
                    this.f2076a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i9 = bVar.f1954b;
        int i10 = bVar2.f1954b;
        androidx.recyclerview.widget.a.b bVarB = null;
        if (i9 <= i10) {
            bVar2.f1954b = i10 + 1;
        } else {
            int i11 = bVar2.f1956d;
            if (i9 < i10 + i11) {
                bVarB = this.f2076a.b(2, i9 + 1, (i10 + i11) - i9, null);
                bVar2.f1956d = bVar.f1954b - bVar2.f1954b;
            }
        }
        if (z3) {
            list.set(i3, bVar2);
            list.remove(i4);
            this.f2076a.a(bVar);
            return;
        }
        if (z2) {
            if (bVarB != null) {
                int i12 = bVar.f1954b;
                if (i12 > bVarB.f1954b) {
                    bVar.f1954b = i12 - bVarB.f1956d;
                }
                int i13 = bVar.f1956d;
                if (i13 > bVarB.f1954b) {
                    bVar.f1956d = i13 - bVarB.f1956d;
                }
            }
            int i14 = bVar.f1954b;
            if (i14 > bVar2.f1954b) {
                bVar.f1954b = i14 - bVar2.f1956d;
            }
            int i15 = bVar.f1956d;
            if (i15 > bVar2.f1954b) {
                bVar.f1956d = i15 - bVar2.f1956d;
            }
        } else {
            if (bVarB != null) {
                int i16 = bVar.f1954b;
                if (i16 >= bVarB.f1954b) {
                    bVar.f1954b = i16 - bVarB.f1956d;
                }
                int i17 = bVar.f1956d;
                if (i17 >= bVarB.f1954b) {
                    bVar.f1956d = i17 - bVarB.f1956d;
                }
            }
            int i18 = bVar.f1954b;
            if (i18 >= bVar2.f1954b) {
                bVar.f1954b = i18 - bVar2.f1956d;
            }
            int i19 = bVar.f1956d;
            if (i19 >= bVar2.f1954b) {
                bVar.f1956d = i19 - bVar2.f1956d;
            }
        }
        list.set(i3, bVar2);
        if (bVar.f1954b != bVar.f1956d) {
            list.set(i4, bVar);
        } else {
            list.remove(i4);
        }
        if (bVarB != null) {
            list.add(i3, bVarB);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    void f(List<androidx.recyclerview.widget.a.b> list, int i3, androidx.recyclerview.widget.a.b bVar, int i4, androidx.recyclerview.widget.a.b bVar2) {
        androidx.recyclerview.widget.a.b bVarB;
        int i5;
        int i6;
        int i7;
        int i8 = bVar.f1956d;
        int i9 = bVar2.f1954b;
        androidx.recyclerview.widget.a.b bVarB2 = null;
        if (i8 >= i9) {
            int i10 = bVar2.f1956d;
            if (i8 < i9 + i10) {
                bVar2.f1956d = i10 - 1;
                bVarB = this.f2076a.b(4, bVar.f1954b, 1, bVar2.f1955c);
            }
            i5 = bVar.f1954b;
            i6 = bVar2.f1954b;
            if (i5 <= i6) {
                bVar2.f1954b = i6 + 1;
            } else {
                i7 = bVar2.f1956d;
                if (i5 < i6 + i7) {
                    int i11 = (i6 + i7) - i5;
                    bVarB2 = this.f2076a.b(4, i5 + 1, i11, bVar2.f1955c);
                    bVar2.f1956d -= i11;
                }
            }
            list.set(i4, bVar);
            if (bVar2.f1956d > 0) {
                list.set(i3, bVar2);
            } else {
                list.remove(i3);
                this.f2076a.a(bVar2);
            }
            if (bVarB != null) {
                list.add(i3, bVarB);
            }
            if (bVarB2 != null) {
                list.add(i3, bVarB2);
            }
        }
        bVar2.f1954b = i9 - 1;
        bVarB = null;
        i5 = bVar.f1954b;
        i6 = bVar2.f1954b;
        if (i5 <= i6) {
            bVar2.f1954b = i6 + 1;
        } else {
            i7 = bVar2.f1956d;
            if (i5 < i6 + i7) {
                int i12 = (i6 + i7) - i5;
                bVarB2 = this.f2076a.b(4, i5 + 1, i12, bVar2.f1955c);
                bVar2.f1956d -= i12;
            }
        }
        list.set(i4, bVar);
        if (bVar2.f1956d > 0) {
            list.set(i3, bVar2);
        } else {
            list.remove(i3);
            this.f2076a.a(bVar2);
        }
        if (bVarB != null) {
            list.add(i3, bVarB);
        }
        if (bVarB2 != null) {
            list.add(i3, bVarB2);
        }
    }
}
