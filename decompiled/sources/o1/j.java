package o1;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: JsonElement.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public g a() {
        if (d()) {
            return (g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m b() {
        if (f()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public o c() {
        if (g()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean d() {
        return this instanceof g;
    }

    public boolean e() {
        return this instanceof l;
    }

    public boolean f() {
        return this instanceof m;
    }

    public boolean g() {
        return this instanceof o;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            w1.c cVar = new w1.c(stringWriter);
            cVar.q(true);
            q1.l.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
