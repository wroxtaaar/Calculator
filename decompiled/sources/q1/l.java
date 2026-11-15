package q1;

import java.io.EOFException;
import java.io.IOException;
import o1.n;
import o1.r;

/* JADX INFO: compiled from: Streams.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static o1.j a(w1.a aVar) throws n {
        boolean z2;
        try {
            try {
                aVar.x();
                z2 = false;
                try {
                    return r1.n.U.b(aVar);
                } catch (EOFException e3) {
                    e = e3;
                    if (z2) {
                        return o1.l.f5448a;
                    }
                    throw new r(e);
                }
            } catch (w1.d e4) {
                throw new r(e4);
            } catch (IOException e5) {
                throw new o1.k(e5);
            } catch (NumberFormatException e6) {
                throw new r(e6);
            }
        } catch (EOFException e7) {
            e = e7;
            z2 = true;
        }
    }

    public static void b(o1.j jVar, w1.c cVar) throws IOException {
        r1.n.U.d(cVar, jVar);
    }
}
