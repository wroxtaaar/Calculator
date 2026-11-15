package o1;

import java.io.IOException;

/* JADX INFO: compiled from: TypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class v<T> {

    /* JADX INFO: compiled from: TypeAdapter.java */
    class a extends v<T> {
        a() {
        }

        @Override // o1.v
        public T b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return (T) v.this.b(aVar);
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        public void d(w1.c cVar, T t3) throws IOException {
            if (t3 == null) {
                cVar.l();
            } else {
                v.this.d(cVar, t3);
            }
        }
    }

    public final v<T> a() {
        return new a();
    }

    public abstract T b(w1.a aVar) throws IOException;

    public final j c(T t3) {
        try {
            r1.g gVar = new r1.g();
            d(gVar, t3);
            return gVar.y();
        } catch (IOException e3) {
            throw new k(e3);
        }
    }

    public abstract void d(w1.c cVar, T t3) throws IOException;
}
